package com.tencent.rtmp.sharp.jni;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@TargetApi(16)
public class AudioDeviceInterface
{
  private static final FileFilter CPU_FILTER;
  public static final int OUTPUT_MODE_HEADSET = 0;
  public static final int OUTPUT_MODE_SPEAKER = 1;
  private static boolean _dumpEnable;
  private static boolean _logEnable;
  private static boolean isSupportVivoKTVHelper;
  private static String[] mDeviceList;
  private static VivoKTVHelper mVivoKTVHelper;
  private TraeAudioSession _as;
  private TraeAudioSession _asAudioManager;
  private AudioManager _audioManager;
  private AudioRecord _audioRecord;
  private boolean _audioRouteChanged;
  private int _audioSource;
  private int _audioSourcePolicy;
  private int _audioStreamTypePolicy;
  private AudioTrack _audioTrack;
  private int _bufferedPlaySamples;
  private int _bufferedRecSamples;
  private int _channelOutType;
  private String _connectedDev;
  private Context _context;
  private ByteBuffer _decBuffer0;
  private ByteBuffer _decBuffer1;
  private ByteBuffer _decBuffer10;
  private ByteBuffer _decBuffer2;
  private ByteBuffer _decBuffer3;
  private ByteBuffer _decBuffer4;
  private ByteBuffer _decBuffer5;
  private ByteBuffer _decBuffer6;
  private ByteBuffer _decBuffer7;
  private ByteBuffer _decBuffer8;
  private ByteBuffer _decBuffer9;
  private int _deviceStat;
  private boolean _doPlayInit;
  private boolean _doRecInit;
  private boolean _isPlaying;
  private boolean _isRecording;
  private int _modePolicy;
  private ByteBuffer _playBuffer;
  private int _playPosition;
  private int _playSamplerate;
  private File _play_dump;
  private FileOutputStream _play_out;
  private boolean _preDone;
  private Condition _precon;
  private ReentrantLock _prelock;
  private ByteBuffer _recBuffer;
  private File _rec_dump;
  private FileOutputStream _rec_out;
  private int _sceneMode;
  private int _sessionId;
  private int _streamType;
  private byte[] _tempBufPlay;
  private byte[] _tempBufRec;
  private TraeAudioCodecList _traeAudioCodecList;
  private int nPlayLengthMs;
  private int nRecordLengthMs;
  private int switchState;
  private boolean usingJava;
  
  static
  {
    AppMethodBeat.i(13863);
    _dumpEnable = false;
    _logEnable = true;
    mDeviceList = null;
    mVivoKTVHelper = null;
    isSupportVivoKTVHelper = false;
    CPU_FILTER = new FileFilter()
    {
      public final boolean accept(File paramAnonymousFile)
      {
        AppMethodBeat.i(13910);
        paramAnonymousFile = paramAnonymousFile.getName();
        if (paramAnonymousFile.startsWith("cpu"))
        {
          int i = 3;
          while (i < paramAnonymousFile.length())
          {
            if ((paramAnonymousFile.charAt(i) < '0') || (paramAnonymousFile.charAt(i) > '9'))
            {
              AppMethodBeat.o(13910);
              return false;
            }
            i += 1;
          }
          AppMethodBeat.o(13910);
          return true;
        }
        AppMethodBeat.o(13910);
        return false;
      }
    };
    AppMethodBeat.o(13863);
  }
  
  public AudioDeviceInterface()
  {
    AppMethodBeat.i(13814);
    this._audioTrack = null;
    this._audioRecord = null;
    this._streamType = 0;
    this._playSamplerate = 8000;
    this._channelOutType = 4;
    this._audioSource = 0;
    this._deviceStat = 0;
    this._sceneMode = 0;
    this._sessionId = 0;
    this._context = null;
    this._modePolicy = -1;
    this._audioSourcePolicy = -1;
    this._audioStreamTypePolicy = -1;
    this._audioManager = null;
    this._doPlayInit = true;
    this._doRecInit = true;
    this._isRecording = false;
    this._isPlaying = false;
    this._bufferedRecSamples = 0;
    this._bufferedPlaySamples = 0;
    this._playPosition = 0;
    this._rec_dump = null;
    this._play_dump = null;
    this._rec_out = null;
    this._play_out = null;
    this.nRecordLengthMs = 0;
    this.nPlayLengthMs = 0;
    this._traeAudioCodecList = null;
    this._as = null;
    this._connectedDev = "DEVICE_NONE";
    this._audioRouteChanged = false;
    this._prelock = new ReentrantLock();
    this._precon = this._prelock.newCondition();
    this._preDone = false;
    this.usingJava = true;
    this.switchState = 0;
    this._asAudioManager = null;
    try
    {
      this._playBuffer = ByteBuffer.allocateDirect(1920);
      this._recBuffer = ByteBuffer.allocateDirect(1920);
      this._decBuffer0 = ByteBuffer.allocateDirect(3840);
      this._decBuffer1 = ByteBuffer.allocateDirect(3840);
      this._decBuffer2 = ByteBuffer.allocateDirect(3840);
      this._decBuffer3 = ByteBuffer.allocateDirect(3840);
      this._decBuffer4 = ByteBuffer.allocateDirect(3840);
      this._decBuffer5 = ByteBuffer.allocateDirect(3840);
      this._decBuffer6 = ByteBuffer.allocateDirect(3840);
      this._decBuffer7 = ByteBuffer.allocateDirect(3840);
      this._decBuffer8 = ByteBuffer.allocateDirect(3840);
      this._decBuffer9 = ByteBuffer.allocateDirect(3840);
      this._decBuffer10 = ByteBuffer.allocateDirect(3840);
      this._tempBufPlay = new byte[1920];
      this._tempBufRec = new byte[1920];
      this._traeAudioCodecList = new TraeAudioCodecList();
      int i = Build.VERSION.SDK_INT;
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "AudioDeviceInterface apiLevel:".concat(String.valueOf(i)));
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, " SDK_INT:" + Build.VERSION.SDK_INT);
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "manufacture:" + Build.MANUFACTURER);
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "MODEL:" + Build.MODEL);
      }
      AppMethodBeat.o(13814);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, localException.getMessage());
        }
      }
    }
  }
  
  private int CloseMp3File(int paramInt)
  {
    AppMethodBeat.i(13855);
    TraeAudioCodecList.CodecInfo localCodecInfo = this._traeAudioCodecList.find(paramInt);
    if (localCodecInfo != null)
    {
      localCodecInfo.audioDecoder.release();
      localCodecInfo.audioDecoder = null;
      this._traeAudioCodecList.remove(paramInt);
      AppMethodBeat.o(13855);
      return 0;
    }
    AppMethodBeat.o(13855);
    return -1;
  }
  
  private int EnableVivoKTVLoopback(int paramInt)
  {
    AppMethodBeat.i(13849);
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "EnableVivoKTVLoopback: " + paramInt + " isSupportVivoKTVHelper:" + isSupportVivoKTVHelper + " mVivoKTVHelper:" + mVivoKTVHelper);
    }
    if ((mVivoKTVHelper != null) && (isSupportVivoKTVHelper))
    {
      mVivoKTVHelper.setPlayFeedbackParam(paramInt);
      AppMethodBeat.o(13849);
      return 0;
    }
    AppMethodBeat.o(13849);
    return -1;
  }
  
  private int InitPlayback(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(13819);
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "InitPlayback entry: sampleRate ".concat(String.valueOf(paramInt1)));
    }
    if ((this._isPlaying) || (this._audioTrack != null) || (paramInt2 > 2))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "InitPlayback _isPlaying:" + this._isPlaying);
      }
      AppMethodBeat.o(13819);
      return -1;
    }
    if (this._audioManager == null) {}
    label654:
    label681:
    label970:
    for (;;)
    {
      int k;
      try
      {
        this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
        if (paramInt2 == 2)
        {
          this._channelOutType = 12;
          this._playSamplerate = paramInt1;
          int i1 = AudioTrack.getMinBufferSize(paramInt1, this._channelOutType, 2);
          if (this._channelOutType == 12)
          {
            if (!QLog.isColorLevel()) {
              break label654;
            }
            QLog.w("TRAE", 2, "InitPlayback, _channelOutType stero");
          }
          int j = paramInt1 * 20 * 1 * 2 / 1000;
          if (this._channelOutType != 12) {
            break label970;
          }
          j *= 2;
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "InitPlayback: minPlayBufSize:" + i1 + " 20msFz:" + j);
          }
          this._bufferedPlaySamples = 0;
          if (this._audioTrack != null)
          {
            this._audioTrack.release();
            this._audioTrack = null;
          }
          int[] arrayOfInt = new int[4];
          tmp267_265 = arrayOfInt;
          tmp267_265[0] = 0;
          tmp271_267 = tmp267_265;
          tmp271_267[1] = 0;
          tmp275_271 = tmp271_267;
          tmp275_271[2] = 3;
          tmp279_275 = tmp275_271;
          tmp279_275[3] = 1;
          tmp279_275;
          this._streamType = TraeAudioManager.getAudioStreamType(this._audioStreamTypePolicy);
          if (this._audioRouteChanged)
          {
            if (QLog.isColorLevel()) {
              QLog.w("TRAE", 2, "_audioRouteChanged:" + this._audioRouteChanged + " _streamType:" + this._streamType);
            }
            if ((this._audioManager.getMode() != 0) || (!this._connectedDev.equals("DEVICE_SPEAKERPHONE"))) {
              break label681;
            }
            this._streamType = 3;
            this._audioRouteChanged = false;
          }
          arrayOfInt[0] = this._streamType;
          k = 0;
          i = i1;
          if ((k >= 4) || (this._audioTrack != null)) {
            break label766;
          }
          this._streamType = arrayOfInt[k];
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "InitPlayback: min play buf size is " + i1 + " hw_sr:" + AudioTrack.getNativeOutputSampleRate(this._streamType));
          }
          m = 1;
          if (m > 2) {
            break label757;
          }
          n = i1 * m;
          if (n < j * 4) {
            if (m < 2) {
              continue;
            }
          }
        }
      }
      catch (Exception localException1)
      {
        int m;
        int n;
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, localException1.getMessage());
        }
        AppMethodBeat.o(13819);
        return -1;
      }
      try
      {
        this.nPlayLengthMs = (n * 500 / (paramInt1 * paramInt2));
        this._audioTrack = new AudioTrack(this._streamType, this._playSamplerate, this._channelOutType, 2, n, 1);
        i = n;
        if (this._audioTrack.getState() == 1) {
          break label757;
        }
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "InitPlayback: play not initialized playBufSize:" + n + " sr:" + this._playSamplerate);
        }
        this._audioTrack.release();
        this._audioTrack = null;
      }
      catch (Exception localException2)
      {
        if (!QLog.isColorLevel()) {
          break label735;
        }
        QLog.w("TRAE", 2, localException2.getMessage() + " _audioTrack:" + this._audioTrack);
        if (this._audioTrack == null) {
          break label749;
        }
        this._audioTrack.release();
        this._audioTrack = null;
        continue;
      }
      m += 1;
      int i = n;
      continue;
      this._channelOutType = 4;
      continue;
      if ((this._channelOutType == 4) && (QLog.isColorLevel()))
      {
        QLog.w("TRAE", 2, "InitPlayback, _channelOutType Mono");
        continue;
        this._streamType = 0;
        continue;
        label735:
        label749:
        label757:
        k += 1;
        continue;
        label766:
        if (this._audioTrack == null)
        {
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "InitPlayback fail!!!");
          }
          AppMethodBeat.o(13819);
          return -1;
        }
        if ((this._as != null) && (this._audioManager != null)) {
          this._as.voiceCallAudioParamChanged(this._audioManager.getMode(), this._streamType);
        }
        this._playPosition = this._audioTrack.getPlaybackHeadPosition();
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "InitPlayback exit: streamType:" + this._streamType + " samplerate:" + this._playSamplerate + " _playPosition:" + this._playPosition + " playBufSize:" + i + " nPlayLengthMs:" + this.nPlayLengthMs);
        }
        AudioManager localAudioManager = this._audioManager;
        if (this._connectedDev.equals("DEVICE_BLUETOOTHHEADSET")) {}
        for (paramInt1 = 6;; paramInt1 = this._audioTrack.getStreamType())
        {
          TraeAudioManager.forceVolumeControlStream(localAudioManager, paramInt1);
          AppMethodBeat.o(13819);
          return 0;
        }
      }
    }
  }
  
  private int InitRecording(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(13818);
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "InitRecording entry:".concat(String.valueOf(paramInt1)));
    }
    if ((this._isRecording) || (this._audioRecord != null) || (paramInt2 > 2))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "InitRecording _isRecording:" + this._isRecording);
      }
      AppMethodBeat.o(13818);
      return -1;
    }
    int j = 16;
    if (paramInt2 == 2) {
      j = 12;
    }
    int i1 = AudioRecord.getMinBufferSize(paramInt1, j, 2);
    int i2 = paramInt1 * 20 * paramInt2 * 2 / 1000;
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "InitRecording: min rec buf size is " + i1 + " sr:" + getLowlatencySamplerate() + " fp" + getLowlatencyFramesPerBuffer() + " 20msFZ:" + i2);
    }
    this._bufferedRecSamples = (paramInt1 * 5 / 200);
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "  rough rec delay set to " + this._bufferedRecSamples);
    }
    if (this._audioRecord != null)
    {
      this._audioRecord.release();
      this._audioRecord = null;
    }
    int[] arrayOfInt = new int[4];
    int[] tmp263_261 = arrayOfInt;
    tmp263_261[0] = 0;
    int[] tmp267_263 = tmp263_261;
    tmp267_263[1] = 1;
    int[] tmp271_267 = tmp267_263;
    tmp271_267[2] = 5;
    int[] tmp275_271 = tmp271_267;
    tmp275_271[3] = 0;
    tmp275_271;
    arrayOfInt[0] = TraeAudioManager.getAudioSource(this._audioSourcePolicy);
    int k = 0;
    int i = i1;
    while ((k < 4) && (this._audioRecord == null))
    {
      this._audioSource = arrayOfInt[k];
      int m = 1;
      for (;;)
      {
        if (m > 2) {
          break label545;
        }
        int n = i1 * m;
        if ((n >= i2 * 4) || (m >= 2)) {}
        try
        {
          this.nRecordLengthMs = (n * 500 / (paramInt1 * paramInt2));
          this._audioRecord = new AudioRecord(this._audioSource, paramInt1, j, 2, n);
          i = n;
          if (this._audioRecord.getState() == 1) {
            break label545;
          }
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "InitRecording:  rec not initialized,try agine,  minbufsize:" + n + " sr:" + paramInt1 + " as:" + this._audioSource);
          }
          this._audioRecord.release();
          this._audioRecord = null;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("TRAE", 2, localException.getMessage() + " _audioRecord:" + this._audioRecord);
            }
            if (this._audioRecord != null) {
              this._audioRecord.release();
            }
            this._audioRecord = null;
          }
        }
        m += 1;
        i = n;
      }
      label545:
      k += 1;
    }
    if (this._audioRecord == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "InitRecording fail!!!");
      }
      AppMethodBeat.o(13818);
      return -1;
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, " [Config] InitRecording: audioSession:" + this._sessionId + " audioSource:" + this._audioSource + " rec sample rate set to " + paramInt1 + " recBufSize:" + i + " nRecordLengthMs:" + this.nRecordLengthMs);
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "InitRecording exit");
    }
    paramInt1 = this._bufferedRecSamples;
    AppMethodBeat.o(13818);
    return paramInt1;
  }
  
  private int InitSetting(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(13817);
    this._audioSourcePolicy = paramInt1;
    this._audioStreamTypePolicy = paramInt2;
    this._modePolicy = paramInt3;
    this._deviceStat = paramInt4;
    this._sceneMode = paramInt5;
    if ((this._deviceStat == 1) || (this._deviceStat == 5) || (this._deviceStat == 2) || (this._deviceStat == 3))
    {
      TraeAudioManager.IsMusicScene = true;
      if ((this._sceneMode != 0) && (this._sceneMode != 4)) {
        break label189;
      }
    }
    label189:
    for (TraeAudioManager.IsEarPhoneSupported = true;; TraeAudioManager.IsEarPhoneSupported = false)
    {
      TraeAudioManager.IsUpdateSceneFlag = true;
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "InitSetting: _audioSourcePolicy:" + this._audioSourcePolicy + " _audioStreamTypePolicy:" + this._audioStreamTypePolicy + " _modePolicy:" + this._modePolicy + " DeviceStat:" + paramInt4 + " isSupportVivoKTVHelper:" + isSupportVivoKTVHelper);
      }
      AppMethodBeat.o(13817);
      return 0;
      TraeAudioManager.IsMusicScene = false;
      break;
    }
  }
  
  public static final void LogTraceEntry(String paramString)
  {
    AppMethodBeat.i(13831);
    if (!_logEnable)
    {
      AppMethodBeat.o(13831);
      return;
    }
    paramString = getTraceInfo() + " entry:" + paramString;
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, paramString);
    }
    AppMethodBeat.o(13831);
  }
  
  public static final void LogTraceExit()
  {
    AppMethodBeat.i(13832);
    if (!_logEnable)
    {
      AppMethodBeat.o(13832);
      return;
    }
    String str = getTraceInfo() + " exit";
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, str);
    }
    AppMethodBeat.o(13832);
  }
  
  private int OpenMp3File(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(13852);
    if (this._traeAudioCodecList.find(paramInt1) == null)
    {
      TraeAudioCodecList.CodecInfo localCodecInfo = this._traeAudioCodecList.add(paramInt1);
      localCodecInfo.audioDecoder.setIOPath(paramString);
      localCodecInfo.audioDecoder.setIndex(paramInt1);
      paramInt2 = localCodecInfo.audioDecoder.prepare(paramInt2);
      if (paramInt2 != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "openFile mp3 Failed!!!");
        }
        localCodecInfo.audioDecoder.release();
        localCodecInfo.audioDecoder = null;
        this._traeAudioCodecList.remove(paramInt1);
        AppMethodBeat.o(13852);
        return paramInt2;
      }
      AppMethodBeat.o(13852);
      return 0;
    }
    AppMethodBeat.o(13852);
    return -1;
  }
  
  private int OpenslesNeedResetAudioTrack(boolean paramBoolean)
  {
    AppMethodBeat.i(13826);
    for (;;)
    {
      try
      {
        boolean bool = TraeAudioManager.isCloseSystemAPM(this._modePolicy);
        if (!bool) {
          return -1;
        }
        if ((this._audioRouteChanged) || (paramBoolean))
        {
          if ((this._audioManager == null) && (this._context != null)) {
            this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
          }
          AudioManager localAudioManager = this._audioManager;
          if (localAudioManager == null) {
            return 0;
          }
          if ((this._audioManager.getMode() != 0) || (!this._connectedDev.equals("DEVICE_SPEAKERPHONE"))) {
            continue;
          }
          this._audioStreamTypePolicy = 3;
          this._audioRouteChanged = false;
        }
      }
      catch (Exception localException)
      {
        int i;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("TRAE", 2, "PlayAudio Exception: " + localException.getMessage());
        continue;
      }
      finally
      {
        AppMethodBeat.o(13826);
      }
      i = this._audioStreamTypePolicy;
      AppMethodBeat.o(13826);
      return i;
      this._audioStreamTypePolicy = 0;
    }
  }
  
  /* Error */
  private int PlayAudio(int paramInt)
  {
    // Byte code:
    //   0: sipush 13825
    //   3: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 161	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   10: ifne +74 -> 84
    //   13: iconst_1
    //   14: istore_2
    //   15: aload_0
    //   16: getfield 127	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   19: ifnonnull +70 -> 89
    //   22: iconst_1
    //   23: istore_3
    //   24: iload_2
    //   25: iload_3
    //   26: ior
    //   27: ifeq +67 -> 94
    //   30: invokestatic 258	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   33: ifeq +43 -> 76
    //   36: ldc_w 260
    //   39: iconst_2
    //   40: new 278	java/lang/StringBuilder
    //   43: dup
    //   44: ldc_w 559
    //   47: invokespecial 283	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   50: aload_0
    //   51: getfield 161	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   54: invokevirtual 338	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   57: ldc_w 561
    //   60: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_0
    //   64: getfield 127	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   67: invokevirtual 343	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 357	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: sipush 13825
    //   79: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   82: iconst_m1
    //   83: ireturn
    //   84: iconst_0
    //   85: istore_2
    //   86: goto -71 -> 15
    //   89: iconst_0
    //   90: istore_3
    //   91: goto -67 -> 24
    //   94: aload_0
    //   95: getfield 127	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   98: astore 10
    //   100: aload 10
    //   102: ifnonnull +12 -> 114
    //   105: sipush 13825
    //   108: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: bipush 254
    //   113: ireturn
    //   114: aload_0
    //   115: getfield 155	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_doPlayInit	Z
    //   118: istore 7
    //   120: iload 7
    //   122: iconst_1
    //   123: if_icmpne +22 -> 145
    //   126: bipush 237
    //   128: invokestatic 566	android/os/Process:setThreadPriority	(I)V
    //   131: invokestatic 572	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   134: ldc_w 574
    //   137: invokevirtual 577	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   140: aload_0
    //   141: iconst_0
    //   142: putfield 155	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_doPlayInit	Z
    //   145: getstatic 105	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_dumpEnable	Z
    //   148: ifeq +27 -> 175
    //   151: aload_0
    //   152: getfield 175	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_play_out	Ljava/io/FileOutputStream;
    //   155: astore 10
    //   157: aload 10
    //   159: ifnull +16 -> 175
    //   162: aload_0
    //   163: getfield 175	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_play_out	Ljava/io/FileOutputStream;
    //   166: aload_0
    //   167: getfield 242	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_tempBufPlay	[B
    //   170: iconst_0
    //   171: iconst_0
    //   172: invokevirtual 583	java/io/FileOutputStream:write	([BII)V
    //   175: aload_0
    //   176: getfield 189	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioRouteChanged	Z
    //   179: ifne +642 -> 821
    //   182: iconst_0
    //   183: istore_2
    //   184: aload_0
    //   185: getfield 216	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playBuffer	Ljava/nio/ByteBuffer;
    //   188: aload_0
    //   189: getfield 242	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_tempBufPlay	[B
    //   192: invokevirtual 587	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   195: pop
    //   196: iload_2
    //   197: ifeq +961 -> 1158
    //   200: aload_0
    //   201: getfield 216	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playBuffer	Ljava/nio/ByteBuffer;
    //   204: invokevirtual 591	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   207: pop
    //   208: invokestatic 597	android/os/SystemClock:elapsedRealtime	()J
    //   211: lstore 8
    //   213: invokestatic 258	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   216: ifeq +46 -> 262
    //   219: ldc_w 260
    //   222: iconst_2
    //   223: new 278	java/lang/StringBuilder
    //   226: dup
    //   227: ldc_w 599
    //   230: invokespecial 283	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   233: aload_0
    //   234: getfield 131	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   237: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   240: ldc_w 601
    //   243: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: aload_0
    //   247: getfield 127	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   250: invokevirtual 450	android/media/AudioTrack:getStreamType	()I
    //   253: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   256: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokestatic 276	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   262: aload_0
    //   263: getfield 127	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   266: invokevirtual 604	android/media/AudioTrack:getPlayState	()I
    //   269: istore_2
    //   270: iload_2
    //   271: iconst_3
    //   272: if_icmpne +117 -> 389
    //   275: invokestatic 258	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   278: ifeq +13 -> 291
    //   281: ldc_w 260
    //   284: iconst_2
    //   285: ldc_w 606
    //   288: invokestatic 276	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   291: aload_0
    //   292: getfield 127	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   295: invokevirtual 609	android/media/AudioTrack:stop	()V
    //   298: aload_0
    //   299: getfield 127	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   302: invokevirtual 612	android/media/AudioTrack:flush	()V
    //   305: invokestatic 258	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   308: ifeq +33 -> 341
    //   311: ldc_w 260
    //   314: iconst_2
    //   315: new 278	java/lang/StringBuilder
    //   318: dup
    //   319: ldc_w 614
    //   322: invokespecial 283	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   325: aload_0
    //   326: getfield 127	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   329: invokevirtual 604	android/media/AudioTrack:getPlayState	()I
    //   332: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   335: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: invokestatic 276	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   341: aload_0
    //   342: getfield 127	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   345: invokevirtual 380	android/media/AudioTrack:release	()V
    //   348: invokestatic 258	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   351: ifeq +33 -> 384
    //   354: ldc_w 260
    //   357: iconst_2
    //   358: new 278	java/lang/StringBuilder
    //   361: dup
    //   362: ldc_w 616
    //   365: invokespecial 283	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   368: aload_0
    //   369: getfield 127	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   372: invokevirtual 604	android/media/AudioTrack:getPlayState	()I
    //   375: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   378: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   381: invokestatic 276	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   384: aload_0
    //   385: aconst_null
    //   386: putfield 127	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   389: aload_0
    //   390: getfield 133	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playSamplerate	I
    //   393: aload_0
    //   394: getfield 135	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_channelOutType	I
    //   397: iconst_2
    //   398: invokestatic 373	android/media/AudioTrack:getMinBufferSize	(III)I
    //   401: istore 5
    //   403: iconst_4
    //   404: newarray int
    //   406: astore 10
    //   408: aload 10
    //   410: dup
    //   411: iconst_0
    //   412: iconst_0
    //   413: iastore
    //   414: dup
    //   415: iconst_1
    //   416: iconst_0
    //   417: iastore
    //   418: dup
    //   419: iconst_2
    //   420: iconst_3
    //   421: iastore
    //   422: dup
    //   423: iconst_3
    //   424: iconst_1
    //   425: iastore
    //   426: pop
    //   427: aload 10
    //   429: iconst_0
    //   430: aload_0
    //   431: getfield 131	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   434: iastore
    //   435: aload_0
    //   436: getfield 133	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playSamplerate	I
    //   439: bipush 20
    //   441: imul
    //   442: iconst_1
    //   443: imul
    //   444: iconst_2
    //   445: imul
    //   446: sipush 1000
    //   449: idiv
    //   450: istore_2
    //   451: aload_0
    //   452: getfield 135	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_channelOutType	I
    //   455: bipush 12
    //   457: if_icmpne +895 -> 1352
    //   460: iload_2
    //   461: iconst_2
    //   462: imul
    //   463: istore_2
    //   464: goto +888 -> 1352
    //   467: iload_3
    //   468: iconst_4
    //   469: if_icmpge +544 -> 1013
    //   472: aload_0
    //   473: getfield 127	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   476: ifnonnull +537 -> 1013
    //   479: aload_0
    //   480: aload 10
    //   482: iload_3
    //   483: iaload
    //   484: putfield 131	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   487: invokestatic 258	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   490: ifeq +44 -> 534
    //   493: ldc_w 260
    //   496: iconst_2
    //   497: new 278	java/lang/StringBuilder
    //   500: dup
    //   501: ldc_w 401
    //   504: invokespecial 283	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   507: iload 5
    //   509: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   512: ldc_w 403
    //   515: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: aload_0
    //   519: getfield 131	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   522: invokestatic 406	android/media/AudioTrack:getNativeOutputSampleRate	(I)I
    //   525: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   528: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   531: invokestatic 276	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   534: iconst_1
    //   535: istore 4
    //   537: iload 4
    //   539: iconst_2
    //   540: if_icmpgt +822 -> 1362
    //   543: iload 5
    //   545: iload 4
    //   547: imul
    //   548: istore 6
    //   550: iload 6
    //   552: iload_2
    //   553: iconst_4
    //   554: imul
    //   555: if_icmpge +9 -> 564
    //   558: iload 4
    //   560: iconst_2
    //   561: if_icmplt +130 -> 691
    //   564: aload_0
    //   565: new 369	android/media/AudioTrack
    //   568: dup
    //   569: aload_0
    //   570: getfield 131	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   573: aload_0
    //   574: getfield 133	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playSamplerate	I
    //   577: aload_0
    //   578: getfield 135	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_channelOutType	I
    //   581: iconst_2
    //   582: iload 6
    //   584: iconst_1
    //   585: invokespecial 409	android/media/AudioTrack:<init>	(IIIIII)V
    //   588: putfield 127	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   591: invokestatic 258	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   594: ifeq +30 -> 624
    //   597: ldc_w 260
    //   600: iconst_2
    //   601: new 278	java/lang/StringBuilder
    //   604: dup
    //   605: ldc_w 421
    //   608: invokespecial 283	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   611: aload_0
    //   612: getfield 127	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   615: invokevirtual 343	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   618: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   621: invokestatic 276	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   624: aload_0
    //   625: getfield 127	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   628: invokevirtual 412	android/media/AudioTrack:getState	()I
    //   631: iconst_1
    //   632: if_icmpeq +730 -> 1362
    //   635: invokestatic 258	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   638: ifeq +41 -> 679
    //   641: ldc_w 260
    //   644: iconst_2
    //   645: new 278	java/lang/StringBuilder
    //   648: dup
    //   649: ldc_w 414
    //   652: invokespecial 283	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   655: iload 6
    //   657: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   660: ldc_w 416
    //   663: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: aload_0
    //   667: getfield 133	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playSamplerate	I
    //   670: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   673: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   676: invokestatic 276	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   679: aload_0
    //   680: getfield 127	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   683: invokevirtual 380	android/media/AudioTrack:release	()V
    //   686: aload_0
    //   687: aconst_null
    //   688: putfield 127	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   691: iload 4
    //   693: iconst_1
    //   694: iadd
    //   695: istore 4
    //   697: goto -160 -> 537
    //   700: astore 10
    //   702: invokestatic 258	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   705: ifeq -565 -> 140
    //   708: ldc_w 260
    //   711: iconst_2
    //   712: new 278	java/lang/StringBuilder
    //   715: dup
    //   716: ldc_w 618
    //   719: invokespecial 283	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   722: aload 10
    //   724: invokevirtual 309	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   727: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   730: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   733: invokestatic 276	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   736: goto -596 -> 140
    //   739: astore 10
    //   741: iconst_0
    //   742: istore_1
    //   743: iload_1
    //   744: istore_2
    //   745: invokestatic 258	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   748: ifeq +33 -> 781
    //   751: ldc_w 260
    //   754: iconst_2
    //   755: new 278	java/lang/StringBuilder
    //   758: dup
    //   759: ldc_w 552
    //   762: invokespecial 283	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   765: aload 10
    //   767: invokevirtual 309	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   770: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   773: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   776: invokestatic 357	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   779: iload_1
    //   780: istore_2
    //   781: sipush 13825
    //   784: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   787: iload_2
    //   788: ireturn
    //   789: astore 10
    //   791: invokestatic 258	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   794: ifeq -619 -> 175
    //   797: ldc_w 260
    //   800: iconst_2
    //   801: ldc_w 620
    //   804: invokestatic 357	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   807: goto -632 -> 175
    //   810: astore 10
    //   812: sipush 13825
    //   815: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   818: aload 10
    //   820: athrow
    //   821: aload_0
    //   822: getfield 153	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   825: ifnonnull +27 -> 852
    //   828: aload_0
    //   829: getfield 145	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_context	Landroid/content/Context;
    //   832: ifnull +20 -> 852
    //   835: aload_0
    //   836: aload_0
    //   837: getfield 145	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_context	Landroid/content/Context;
    //   840: ldc_w 359
    //   843: invokevirtual 365	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   846: checkcast 367	android/media/AudioManager
    //   849: putfield 153	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   852: aload_0
    //   853: getfield 153	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   856: ifnull +55 -> 911
    //   859: aload_0
    //   860: getfield 153	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   863: invokevirtual 393	android/media/AudioManager:getMode	()I
    //   866: ifne +45 -> 911
    //   869: aload_0
    //   870: getfield 187	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_connectedDev	Ljava/lang/String;
    //   873: ldc_w 395
    //   876: invokevirtual 399	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   879: ifeq +32 -> 911
    //   882: aload_0
    //   883: iconst_3
    //   884: putfield 131	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   887: aload_0
    //   888: getfield 131	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   891: aload_0
    //   892: getfield 127	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   895: invokevirtual 450	android/media/AudioTrack:getStreamType	()I
    //   898: if_icmpne +21 -> 919
    //   901: iconst_0
    //   902: istore_2
    //   903: aload_0
    //   904: iconst_0
    //   905: putfield 189	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioRouteChanged	Z
    //   908: goto -724 -> 184
    //   911: aload_0
    //   912: iconst_0
    //   913: putfield 131	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   916: goto -29 -> 887
    //   919: iconst_1
    //   920: istore_2
    //   921: goto -18 -> 903
    //   924: astore 10
    //   926: invokestatic 258	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   929: ifeq -540 -> 389
    //   932: ldc_w 260
    //   935: iconst_2
    //   936: ldc_w 622
    //   939: invokestatic 357	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   942: goto -553 -> 389
    //   945: astore 11
    //   947: invokestatic 258	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   950: ifeq +41 -> 991
    //   953: ldc_w 260
    //   956: iconst_2
    //   957: new 278	java/lang/StringBuilder
    //   960: dup
    //   961: invokespecial 419	java/lang/StringBuilder:<init>	()V
    //   964: aload 11
    //   966: invokevirtual 309	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   969: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   972: ldc_w 421
    //   975: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   978: aload_0
    //   979: getfield 127	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   982: invokevirtual 343	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   985: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   988: invokestatic 276	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   991: aload_0
    //   992: getfield 127	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   995: ifnull +10 -> 1005
    //   998: aload_0
    //   999: getfield 127	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1002: invokevirtual 380	android/media/AudioTrack:release	()V
    //   1005: aload_0
    //   1006: aconst_null
    //   1007: putfield 127	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1010: goto -319 -> 691
    //   1013: aload_0
    //   1014: getfield 127	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1017: astore 10
    //   1019: aload 10
    //   1021: ifnull +57 -> 1078
    //   1024: aload_0
    //   1025: getfield 127	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1028: invokevirtual 625	android/media/AudioTrack:play	()V
    //   1031: aload_0
    //   1032: getfield 183	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_as	Lcom/tencent/rtmp/sharp/jni/TraeAudioSession;
    //   1035: aload_0
    //   1036: getfield 153	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   1039: invokevirtual 393	android/media/AudioManager:getMode	()I
    //   1042: aload_0
    //   1043: getfield 131	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   1046: invokevirtual 428	com/tencent/rtmp/sharp/jni/TraeAudioSession:voiceCallAudioParamChanged	(II)I
    //   1049: pop
    //   1050: aload_0
    //   1051: getfield 153	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   1054: astore 10
    //   1056: aload_0
    //   1057: getfield 187	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_connectedDev	Ljava/lang/String;
    //   1060: ldc_w 443
    //   1063: invokevirtual 399	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1066: ifeq +60 -> 1126
    //   1069: bipush 6
    //   1071: istore_2
    //   1072: aload 10
    //   1074: iload_2
    //   1075: invokestatic 447	com/tencent/rtmp/sharp/jni/TraeAudioManager:forceVolumeControlStream	(Landroid/media/AudioManager;I)V
    //   1078: iload_1
    //   1079: istore_2
    //   1080: invokestatic 258	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   1083: ifeq -302 -> 781
    //   1086: ldc_w 260
    //   1089: iconst_2
    //   1090: new 278	java/lang/StringBuilder
    //   1093: dup
    //   1094: ldc_w 627
    //   1097: invokespecial 283	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1100: invokestatic 597	android/os/SystemClock:elapsedRealtime	()J
    //   1103: lload 8
    //   1105: lsub
    //   1106: invokevirtual 630	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1109: ldc_w 632
    //   1112: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1115: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1118: invokestatic 357	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1121: iload_1
    //   1122: istore_2
    //   1123: goto -342 -> 781
    //   1126: aload_0
    //   1127: getfield 127	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1130: invokevirtual 450	android/media/AudioTrack:getStreamType	()I
    //   1133: istore_2
    //   1134: goto -62 -> 1072
    //   1137: astore 10
    //   1139: invokestatic 258	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   1142: ifeq -64 -> 1078
    //   1145: ldc_w 260
    //   1148: iconst_2
    //   1149: ldc_w 634
    //   1152: invokestatic 357	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1155: goto -77 -> 1078
    //   1158: aload_0
    //   1159: getfield 127	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1162: aload_0
    //   1163: getfield 242	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_tempBufPlay	[B
    //   1166: iconst_0
    //   1167: iload_1
    //   1168: invokevirtual 637	android/media/AudioTrack:write	([BII)I
    //   1171: istore_2
    //   1172: aload_0
    //   1173: getfield 216	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playBuffer	Ljava/nio/ByteBuffer;
    //   1176: invokevirtual 591	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   1179: pop
    //   1180: iload_2
    //   1181: ifge +57 -> 1238
    //   1184: invokestatic 258	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   1187: ifeq +43 -> 1230
    //   1190: ldc_w 260
    //   1193: iconst_2
    //   1194: new 278	java/lang/StringBuilder
    //   1197: dup
    //   1198: ldc_w 639
    //   1201: invokespecial 283	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1204: iload_2
    //   1205: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1208: ldc_w 641
    //   1211: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1214: iload_1
    //   1215: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1218: ldc_w 643
    //   1221: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1224: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1227: invokestatic 357	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1230: sipush 13825
    //   1233: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1236: iconst_m1
    //   1237: ireturn
    //   1238: iload_2
    //   1239: iload_1
    //   1240: if_icmpeq +49 -> 1289
    //   1243: invokestatic 258	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   1246: ifeq +43 -> 1289
    //   1249: ldc_w 260
    //   1252: iconst_2
    //   1253: new 278	java/lang/StringBuilder
    //   1256: dup
    //   1257: ldc_w 645
    //   1260: invokespecial 283	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1263: iload_2
    //   1264: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1267: ldc_w 641
    //   1270: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1273: iload_1
    //   1274: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1277: ldc_w 643
    //   1280: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1283: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1286: invokestatic 357	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1289: aload_0
    //   1290: aload_0
    //   1291: getfield 165	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1294: iload_2
    //   1295: iconst_1
    //   1296: ishr
    //   1297: iadd
    //   1298: putfield 165	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1301: aload_0
    //   1302: getfield 127	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1305: invokevirtual 431	android/media/AudioTrack:getPlaybackHeadPosition	()I
    //   1308: istore_1
    //   1309: iload_1
    //   1310: aload_0
    //   1311: getfield 167	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playPosition	I
    //   1314: if_icmpge +8 -> 1322
    //   1317: aload_0
    //   1318: iconst_0
    //   1319: putfield 167	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playPosition	I
    //   1322: aload_0
    //   1323: aload_0
    //   1324: getfield 165	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1327: iload_1
    //   1328: aload_0
    //   1329: getfield 167	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playPosition	I
    //   1332: isub
    //   1333: isub
    //   1334: putfield 165	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1337: aload_0
    //   1338: iload_1
    //   1339: putfield 167	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playPosition	I
    //   1342: goto -561 -> 781
    //   1345: astore 10
    //   1347: iload_2
    //   1348: istore_1
    //   1349: goto -606 -> 743
    //   1352: iconst_0
    //   1353: istore_3
    //   1354: goto -887 -> 467
    //   1357: astore 10
    //   1359: goto -616 -> 743
    //   1362: iload_3
    //   1363: iconst_1
    //   1364: iadd
    //   1365: istore_3
    //   1366: goto -899 -> 467
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1369	0	this	AudioDeviceInterface
    //   0	1369	1	paramInt	int
    //   14	1334	2	i	int
    //   23	1343	3	j	int
    //   535	161	4	k	int
    //   401	147	5	m	int
    //   548	108	6	n	int
    //   118	6	7	bool	boolean
    //   211	893	8	l	long
    //   98	383	10	localObject1	Object
    //   700	23	10	localException1	Exception
    //   739	27	10	localException2	Exception
    //   789	1	10	localIOException	java.io.IOException
    //   810	9	10	localObject2	Object
    //   924	1	10	localIllegalStateException	IllegalStateException
    //   1017	56	10	localObject3	Object
    //   1137	1	10	localException3	Exception
    //   1345	1	10	localException4	Exception
    //   1357	1	10	localException5	Exception
    //   945	20	11	localException6	Exception
    // Exception table:
    //   from	to	target	type
    //   126	140	700	java/lang/Exception
    //   94	100	739	java/lang/Exception
    //   114	120	739	java/lang/Exception
    //   140	145	739	java/lang/Exception
    //   145	157	739	java/lang/Exception
    //   162	175	739	java/lang/Exception
    //   175	182	739	java/lang/Exception
    //   184	196	739	java/lang/Exception
    //   702	736	739	java/lang/Exception
    //   791	807	739	java/lang/Exception
    //   821	852	739	java/lang/Exception
    //   852	887	739	java/lang/Exception
    //   887	901	739	java/lang/Exception
    //   903	908	739	java/lang/Exception
    //   911	916	739	java/lang/Exception
    //   1158	1172	739	java/lang/Exception
    //   162	175	789	java/io/IOException
    //   94	100	810	finally
    //   114	120	810	finally
    //   126	140	810	finally
    //   140	145	810	finally
    //   145	157	810	finally
    //   162	175	810	finally
    //   175	182	810	finally
    //   184	196	810	finally
    //   200	262	810	finally
    //   262	270	810	finally
    //   275	291	810	finally
    //   291	341	810	finally
    //   341	384	810	finally
    //   384	389	810	finally
    //   389	460	810	finally
    //   472	534	810	finally
    //   564	591	810	finally
    //   591	624	810	finally
    //   624	679	810	finally
    //   679	691	810	finally
    //   702	736	810	finally
    //   745	779	810	finally
    //   791	807	810	finally
    //   821	852	810	finally
    //   852	887	810	finally
    //   887	901	810	finally
    //   903	908	810	finally
    //   911	916	810	finally
    //   926	942	810	finally
    //   947	991	810	finally
    //   991	1005	810	finally
    //   1005	1010	810	finally
    //   1013	1019	810	finally
    //   1024	1069	810	finally
    //   1072	1078	810	finally
    //   1080	1121	810	finally
    //   1126	1134	810	finally
    //   1139	1155	810	finally
    //   1158	1172	810	finally
    //   1172	1180	810	finally
    //   1184	1230	810	finally
    //   1243	1289	810	finally
    //   1289	1322	810	finally
    //   1322	1342	810	finally
    //   275	291	924	java/lang/IllegalStateException
    //   291	341	924	java/lang/IllegalStateException
    //   341	384	924	java/lang/IllegalStateException
    //   384	389	924	java/lang/IllegalStateException
    //   564	591	945	java/lang/Exception
    //   1024	1069	1137	java/lang/Exception
    //   1072	1078	1137	java/lang/Exception
    //   1126	1134	1137	java/lang/Exception
    //   1172	1180	1345	java/lang/Exception
    //   1184	1230	1345	java/lang/Exception
    //   1243	1289	1345	java/lang/Exception
    //   1289	1322	1345	java/lang/Exception
    //   1322	1342	1345	java/lang/Exception
    //   200	262	1357	java/lang/Exception
    //   262	270	1357	java/lang/Exception
    //   275	291	1357	java/lang/Exception
    //   291	341	1357	java/lang/Exception
    //   341	384	1357	java/lang/Exception
    //   384	389	1357	java/lang/Exception
    //   389	460	1357	java/lang/Exception
    //   472	534	1357	java/lang/Exception
    //   591	624	1357	java/lang/Exception
    //   624	679	1357	java/lang/Exception
    //   679	691	1357	java/lang/Exception
    //   926	942	1357	java/lang/Exception
    //   947	991	1357	java/lang/Exception
    //   991	1005	1357	java/lang/Exception
    //   1005	1010	1357	java/lang/Exception
    //   1013	1019	1357	java/lang/Exception
    //   1080	1121	1357	java/lang/Exception
    //   1139	1155	1357	java/lang/Exception
  }
  
  private int ReadMp3File(int paramInt)
  {
    AppMethodBeat.i(13854);
    TraeAudioCodecList.CodecInfo localCodecInfo = this._traeAudioCodecList.find(paramInt);
    if (localCodecInfo != null)
    {
      ByteBuffer localByteBuffer = getDecBuffer(paramInt);
      if (localByteBuffer == null)
      {
        AppMethodBeat.o(13854);
        return -1;
      }
      localByteBuffer.rewind();
      paramInt = localCodecInfo.audioDecoder.getFrameSize();
      int i = localCodecInfo.audioDecoder.ReadOneFrame(localCodecInfo._tempBufdec, paramInt);
      localByteBuffer.put(localCodecInfo._tempBufdec, 0, paramInt);
      AppMethodBeat.o(13854);
      return i;
    }
    AppMethodBeat.o(13854);
    return -1;
  }
  
  /* Error */
  private int RecordAudio(int paramInt)
  {
    // Byte code:
    //   0: sipush 13827
    //   3: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 159	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   10: ifne +44 -> 54
    //   13: invokestatic 258	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   16: ifeq +30 -> 46
    //   19: ldc_w 260
    //   22: iconst_2
    //   23: new 278	java/lang/StringBuilder
    //   26: dup
    //   27: ldc_w 666
    //   30: invokespecial 283	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   33: aload_0
    //   34: getfield 159	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   37: invokevirtual 338	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   40: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 357	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   46: sipush 13827
    //   49: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: iconst_m1
    //   53: ireturn
    //   54: aload_0
    //   55: getfield 129	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   58: astore 5
    //   60: aload 5
    //   62: ifnonnull +12 -> 74
    //   65: sipush 13827
    //   68: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: bipush 254
    //   73: ireturn
    //   74: aload_0
    //   75: getfield 157	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_doRecInit	Z
    //   78: istore 4
    //   80: iload 4
    //   82: iconst_1
    //   83: if_icmpne +22 -> 105
    //   86: bipush 237
    //   88: invokestatic 566	android/os/Process:setThreadPriority	(I)V
    //   91: invokestatic 572	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   94: ldc_w 668
    //   97: invokevirtual 577	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   100: aload_0
    //   101: iconst_0
    //   102: putfield 157	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_doRecInit	Z
    //   105: aload_0
    //   106: getfield 218	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_recBuffer	Ljava/nio/ByteBuffer;
    //   109: invokevirtual 591	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   112: pop
    //   113: aload_0
    //   114: getfield 129	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   117: aload_0
    //   118: getfield 244	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_tempBufRec	[B
    //   121: iconst_0
    //   122: iload_1
    //   123: invokevirtual 671	android/media/AudioRecord:read	([BII)I
    //   126: istore_2
    //   127: iload_2
    //   128: ifge +146 -> 274
    //   131: invokestatic 258	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   134: ifeq +43 -> 177
    //   137: ldc_w 260
    //   140: iconst_2
    //   141: new 278	java/lang/StringBuilder
    //   144: dup
    //   145: ldc_w 673
    //   148: invokespecial 283	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   151: iload_2
    //   152: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   155: ldc_w 641
    //   158: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: iload_1
    //   162: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   165: ldc_w 643
    //   168: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 357	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   177: sipush 13827
    //   180: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   183: iconst_m1
    //   184: ireturn
    //   185: astore 5
    //   187: invokestatic 258	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   190: ifeq -90 -> 100
    //   193: ldc_w 260
    //   196: iconst_2
    //   197: new 278	java/lang/StringBuilder
    //   200: dup
    //   201: ldc_w 675
    //   204: invokespecial 283	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   207: aload 5
    //   209: invokevirtual 309	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   212: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokestatic 276	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   221: goto -121 -> 100
    //   224: astore 5
    //   226: iconst_0
    //   227: istore_2
    //   228: iload_2
    //   229: istore_3
    //   230: invokestatic 258	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   233: ifeq +33 -> 266
    //   236: ldc_w 260
    //   239: iconst_2
    //   240: new 278	java/lang/StringBuilder
    //   243: dup
    //   244: ldc_w 677
    //   247: invokespecial 283	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   250: aload 5
    //   252: invokevirtual 309	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   255: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokestatic 357	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   264: iload_2
    //   265: istore_3
    //   266: sipush 13827
    //   269: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   272: iload_3
    //   273: ireturn
    //   274: aload_0
    //   275: getfield 218	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_recBuffer	Ljava/nio/ByteBuffer;
    //   278: aload_0
    //   279: getfield 244	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_tempBufRec	[B
    //   282: iconst_0
    //   283: iload_2
    //   284: invokevirtual 663	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   287: pop
    //   288: getstatic 105	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_dumpEnable	Z
    //   291: ifeq +27 -> 318
    //   294: aload_0
    //   295: getfield 173	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_rec_out	Ljava/io/FileOutputStream;
    //   298: astore 5
    //   300: aload 5
    //   302: ifnull +16 -> 318
    //   305: aload_0
    //   306: getfield 173	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_rec_out	Ljava/io/FileOutputStream;
    //   309: aload_0
    //   310: getfield 244	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_tempBufRec	[B
    //   313: iconst_0
    //   314: iload_2
    //   315: invokevirtual 583	java/io/FileOutputStream:write	([BII)V
    //   318: iload_2
    //   319: istore_3
    //   320: iload_2
    //   321: iload_1
    //   322: if_icmpeq -56 -> 266
    //   325: invokestatic 258	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   328: ifeq +43 -> 371
    //   331: ldc_w 260
    //   334: iconst_2
    //   335: new 278	java/lang/StringBuilder
    //   338: dup
    //   339: ldc_w 679
    //   342: invokespecial 283	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   345: iload_2
    //   346: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   349: ldc_w 641
    //   352: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: iload_1
    //   356: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   359: ldc_w 643
    //   362: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   368: invokestatic 357	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   371: sipush 13827
    //   374: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   377: iconst_m1
    //   378: ireturn
    //   379: astore 5
    //   381: invokestatic 258	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   384: ifeq -66 -> 318
    //   387: ldc_w 260
    //   390: iconst_2
    //   391: ldc_w 681
    //   394: invokestatic 357	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   397: goto -79 -> 318
    //   400: astore 5
    //   402: goto -174 -> 228
    //   405: astore 5
    //   407: sipush 13827
    //   410: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   413: aload 5
    //   415: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	416	0	this	AudioDeviceInterface
    //   0	416	1	paramInt	int
    //   126	220	2	i	int
    //   229	91	3	j	int
    //   78	6	4	bool	boolean
    //   58	3	5	localAudioRecord	AudioRecord
    //   185	23	5	localException1	Exception
    //   224	27	5	localException2	Exception
    //   298	3	5	localFileOutputStream	FileOutputStream
    //   379	1	5	localIOException	java.io.IOException
    //   400	1	5	localException3	Exception
    //   405	9	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   86	100	185	java/lang/Exception
    //   54	60	224	java/lang/Exception
    //   74	80	224	java/lang/Exception
    //   100	105	224	java/lang/Exception
    //   105	127	224	java/lang/Exception
    //   187	221	224	java/lang/Exception
    //   305	318	379	java/io/IOException
    //   131	177	400	java/lang/Exception
    //   274	300	400	java/lang/Exception
    //   305	318	400	java/lang/Exception
    //   325	371	400	java/lang/Exception
    //   381	397	400	java/lang/Exception
    //   54	60	405	finally
    //   74	80	405	finally
    //   86	100	405	finally
    //   100	105	405	finally
    //   105	127	405	finally
    //   131	177	405	finally
    //   187	221	405	finally
    //   230	264	405	finally
    //   274	300	405	finally
    //   305	318	405	finally
    //   325	371	405	finally
    //   381	397	405	finally
  }
  
  private int SeekMp3To(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(13856);
    TraeAudioCodecList.CodecInfo localCodecInfo = this._traeAudioCodecList.find(paramInt1);
    if (localCodecInfo != null)
    {
      paramInt1 = localCodecInfo.audioDecoder.SeekTo(paramInt2);
      AppMethodBeat.o(13856);
      return paramInt1;
    }
    AppMethodBeat.o(13856);
    return 0;
  }
  
  private int SetAudioOutputMode(int paramInt)
  {
    AppMethodBeat.i(13843);
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "TraeAudioSession SetAudioOutputMode: ".concat(String.valueOf(paramInt)));
    }
    if (paramInt == 0)
    {
      if ((mDeviceList == null) || (this._asAudioManager == null))
      {
        AppMethodBeat.o(13843);
        return -1;
      }
      int i = 0;
      int j = 0;
      label58:
      paramInt = i;
      if (j < mDeviceList.length)
      {
        paramInt = i;
        if (i == 0)
        {
          if (!"DEVICE_WIREDHEADSET".equals(mDeviceList[j])) {
            break label205;
          }
          this._asAudioManager.connectDevice("DEVICE_WIREDHEADSET");
          paramInt = 1;
        }
      }
      j = 0;
      label103:
      i = paramInt;
      if (j < mDeviceList.length)
      {
        i = paramInt;
        if (paramInt == 0)
        {
          if (!"DEVICE_BLUETOOTHHEADSET".equals(mDeviceList[j])) {
            break label212;
          }
          this._asAudioManager.connectDevice("DEVICE_BLUETOOTHHEADSET");
          i = 1;
        }
      }
      j = 0;
      for (;;)
      {
        paramInt = i;
        if (j < mDeviceList.length)
        {
          paramInt = i;
          if (i == 0)
          {
            if (!"DEVICE_EARPHONE".equals(mDeviceList[j])) {
              break label219;
            }
            this._asAudioManager.connectDevice("DEVICE_EARPHONE");
            paramInt = 1;
          }
        }
        i = paramInt;
        if (paramInt == 0) {
          break;
        }
        AppMethodBeat.o(13843);
        return 0;
        label205:
        j += 1;
        break label58;
        label212:
        j += 1;
        break label103;
        label219:
        j += 1;
      }
    }
    if (1 == paramInt)
    {
      if (this._asAudioManager == null)
      {
        AppMethodBeat.o(13843);
        return -1;
      }
      this._asAudioManager.connectDevice("DEVICE_SPEAKERPHONE");
      AppMethodBeat.o(13843);
      return 0;
    }
    AppMethodBeat.o(13843);
    return -1;
  }
  
  private int SetPlayoutVolume(int paramInt)
  {
    AppMethodBeat.i(13828);
    if ((this._audioManager == null) && (this._context != null)) {
      this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
    }
    int i = -1;
    if (this._audioManager != null)
    {
      this._audioManager.setStreamVolume(0, paramInt, 0);
      i = 0;
    }
    AppMethodBeat.o(13828);
    return i;
  }
  
  /* Error */
  private int StartPlayback()
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_1
    //   2: sipush 13822
    //   5: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 161	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   12: ifeq +27 -> 39
    //   15: invokestatic 258	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   18: ifeq +13 -> 31
    //   21: ldc_w 260
    //   24: iconst_2
    //   25: ldc_w 706
    //   28: invokestatic 357	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: sipush 13822
    //   34: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: iconst_m1
    //   38: ireturn
    //   39: aload_0
    //   40: getfield 127	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   43: ifnonnull +44 -> 87
    //   46: invokestatic 258	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   49: ifeq +30 -> 79
    //   52: ldc_w 260
    //   55: iconst_2
    //   56: new 278	java/lang/StringBuilder
    //   59: dup
    //   60: ldc_w 708
    //   63: invokespecial 283	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   66: aload_0
    //   67: getfield 127	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   70: invokevirtual 343	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 357	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   79: sipush 13822
    //   82: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: iconst_m1
    //   86: ireturn
    //   87: aload_0
    //   88: getfield 127	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   91: invokevirtual 625	android/media/AudioTrack:play	()V
    //   94: getstatic 105	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_dumpEnable	Z
    //   97: ifeq +52 -> 149
    //   100: aload_0
    //   101: getfield 153	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   104: ifnull +11 -> 115
    //   107: aload_0
    //   108: getfield 153	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   111: invokevirtual 393	android/media/AudioManager:getMode	()I
    //   114: istore_1
    //   115: aload_0
    //   116: new 710	java/io/File
    //   119: dup
    //   120: aload_0
    //   121: ldc_w 712
    //   124: iload_1
    //   125: invokespecial 716	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:getDumpFilePath	(Ljava/lang/String;I)Ljava/lang/String;
    //   128: invokespecial 717	java/io/File:<init>	(Ljava/lang/String;)V
    //   131: putfield 171	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_play_dump	Ljava/io/File;
    //   134: aload_0
    //   135: new 579	java/io/FileOutputStream
    //   138: dup
    //   139: aload_0
    //   140: getfield 171	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_play_dump	Ljava/io/File;
    //   143: invokespecial 720	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   146: putfield 175	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_play_out	Ljava/io/FileOutputStream;
    //   149: aload_0
    //   150: iconst_1
    //   151: putfield 161	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   154: invokestatic 258	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   157: ifeq +13 -> 170
    //   160: ldc_w 260
    //   163: iconst_2
    //   164: ldc_w 722
    //   167: invokestatic 276	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   170: sipush 13822
    //   173: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   176: iconst_0
    //   177: ireturn
    //   178: astore_2
    //   179: invokestatic 258	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   182: ifeq +13 -> 195
    //   185: ldc_w 260
    //   188: iconst_2
    //   189: ldc_w 724
    //   192: invokestatic 357	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   195: sipush 13822
    //   198: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   201: iconst_m1
    //   202: ireturn
    //   203: astore_2
    //   204: invokestatic 258	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   207: ifeq -58 -> 149
    //   210: ldc_w 260
    //   213: iconst_2
    //   214: ldc_w 726
    //   217: invokestatic 357	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   220: goto -71 -> 149
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	this	AudioDeviceInterface
    //   1	124	1	i	int
    //   178	1	2	localIllegalStateException	IllegalStateException
    //   203	1	2	localFileNotFoundException	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   87	94	178	java/lang/IllegalStateException
    //   134	149	203	java/io/FileNotFoundException
  }
  
  /* Error */
  private int StartRecording()
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_1
    //   2: sipush 13821
    //   5: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 258	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   11: ifeq +13 -> 24
    //   14: ldc_w 260
    //   17: iconst_2
    //   18: ldc_w 729
    //   21: invokestatic 276	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   24: aload_0
    //   25: getfield 159	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   28: ifeq +44 -> 72
    //   31: invokestatic 258	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   34: ifeq +30 -> 64
    //   37: ldc_w 260
    //   40: iconst_2
    //   41: new 278	java/lang/StringBuilder
    //   44: dup
    //   45: ldc_w 731
    //   48: invokespecial 283	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   51: aload_0
    //   52: getfield 159	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   55: invokevirtual 338	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   58: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 357	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: sipush 13821
    //   67: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: iconst_m1
    //   71: ireturn
    //   72: aload_0
    //   73: getfield 129	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   76: ifnonnull +44 -> 120
    //   79: invokestatic 258	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   82: ifeq +30 -> 112
    //   85: ldc_w 260
    //   88: iconst_2
    //   89: new 278	java/lang/StringBuilder
    //   92: dup
    //   93: ldc_w 733
    //   96: invokespecial 283	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   99: aload_0
    //   100: getfield 129	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   103: invokevirtual 343	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokestatic 357	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   112: sipush 13821
    //   115: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: iconst_m1
    //   119: ireturn
    //   120: aload_0
    //   121: getfield 129	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   124: invokevirtual 736	android/media/AudioRecord:startRecording	()V
    //   127: getstatic 105	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_dumpEnable	Z
    //   130: ifeq +52 -> 182
    //   133: aload_0
    //   134: getfield 153	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   137: ifnull +11 -> 148
    //   140: aload_0
    //   141: getfield 153	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   144: invokevirtual 393	android/media/AudioManager:getMode	()I
    //   147: istore_1
    //   148: aload_0
    //   149: new 710	java/io/File
    //   152: dup
    //   153: aload_0
    //   154: ldc_w 738
    //   157: iload_1
    //   158: invokespecial 716	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:getDumpFilePath	(Ljava/lang/String;I)Ljava/lang/String;
    //   161: invokespecial 717	java/io/File:<init>	(Ljava/lang/String;)V
    //   164: putfield 169	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_rec_dump	Ljava/io/File;
    //   167: aload_0
    //   168: new 579	java/io/FileOutputStream
    //   171: dup
    //   172: aload_0
    //   173: getfield 169	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_rec_dump	Ljava/io/File;
    //   176: invokespecial 720	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   179: putfield 173	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_rec_out	Ljava/io/FileOutputStream;
    //   182: aload_0
    //   183: iconst_1
    //   184: putfield 159	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   187: invokestatic 258	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   190: ifeq +13 -> 203
    //   193: ldc_w 260
    //   196: iconst_2
    //   197: ldc_w 740
    //   200: invokestatic 276	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   203: sipush 13821
    //   206: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   209: iconst_0
    //   210: ireturn
    //   211: astore_2
    //   212: invokestatic 258	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   215: ifeq +13 -> 228
    //   218: ldc_w 260
    //   221: iconst_2
    //   222: ldc_w 742
    //   225: invokestatic 357	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   228: sipush 13821
    //   231: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   234: iconst_m1
    //   235: ireturn
    //   236: astore_2
    //   237: invokestatic 258	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   240: ifeq -58 -> 182
    //   243: ldc_w 260
    //   246: iconst_2
    //   247: ldc_w 744
    //   250: invokestatic 357	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   253: goto -71 -> 182
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	256	0	this	AudioDeviceInterface
    //   1	157	1	i	int
    //   211	1	2	localIllegalStateException	IllegalStateException
    //   236	1	2	localFileNotFoundException	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   120	127	211	java/lang/IllegalStateException
    //   167	182	236	java/io/FileNotFoundException
  }
  
  private int StopPlayback()
  {
    AppMethodBeat.i(13824);
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "StopPlayback entry _isPlaying:" + this._isPlaying);
    }
    if (this._audioTrack == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "StopPlayback _isPlaying:" + this._isPlaying + " " + this._audioTrack);
      }
      AppMethodBeat.o(13824);
      return -1;
    }
    if (this._audioTrack.getPlayState() == 3) {}
    try
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "StopPlayback stoping...");
      }
      this._audioTrack.stop();
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "StopPlayback flushing... state:" + this._audioTrack.getPlayState());
      }
      this._audioTrack.flush();
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "StopPlayback releaseing... state:" + this._audioTrack.getPlayState());
      }
      this._audioTrack.release();
      this._audioTrack = null;
      this._isPlaying = false;
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "StopPlayback exit ok");
      }
      AppMethodBeat.o(13824);
      return 0;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "StopPlayback err");
      }
      AppMethodBeat.o(13824);
    }
    return -1;
  }
  
  private int StopRecording()
  {
    AppMethodBeat.i(13823);
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "StopRecording entry");
    }
    if (this._audioRecord == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "UnintRecord:" + this._audioRecord);
      }
      AppMethodBeat.o(13823);
      return -1;
    }
    if (this._audioRecord.getRecordingState() == 3) {}
    try
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "StopRecording stop... state:" + this._audioRecord.getRecordingState());
      }
      this._audioRecord.stop();
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "StopRecording releaseing... state:" + this._audioRecord.getRecordingState());
      }
      this._audioRecord.release();
      this._audioRecord = null;
      this._isRecording = false;
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "StopRecording exit ok");
      }
      AppMethodBeat.o(13823);
      return 0;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "StopRecording  err");
      }
      AppMethodBeat.o(13823);
    }
    return -1;
  }
  
  private int getAndroidSdkVersion()
  {
    return Build.VERSION.SDK_INT;
  }
  
  @TargetApi(16)
  private int getAudioSessionId(AudioRecord paramAudioRecord)
  {
    return 0;
  }
  
  private ByteBuffer getDecBuffer(int paramInt)
  {
    AppMethodBeat.i(13853);
    switch (paramInt)
    {
    default: 
      QLog.w("TRAE", 2, "getDecBuffer failed!! index:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(13853);
      return null;
    case 0: 
      localByteBuffer = this._decBuffer0;
      AppMethodBeat.o(13853);
      return localByteBuffer;
    case 1: 
      localByteBuffer = this._decBuffer1;
      AppMethodBeat.o(13853);
      return localByteBuffer;
    case 2: 
      localByteBuffer = this._decBuffer2;
      AppMethodBeat.o(13853);
      return localByteBuffer;
    case 3: 
      localByteBuffer = this._decBuffer3;
      AppMethodBeat.o(13853);
      return localByteBuffer;
    case 4: 
      localByteBuffer = this._decBuffer4;
      AppMethodBeat.o(13853);
      return localByteBuffer;
    case 5: 
      localByteBuffer = this._decBuffer5;
      AppMethodBeat.o(13853);
      return localByteBuffer;
    case 6: 
      localByteBuffer = this._decBuffer6;
      AppMethodBeat.o(13853);
      return localByteBuffer;
    case 7: 
      localByteBuffer = this._decBuffer7;
      AppMethodBeat.o(13853);
      return localByteBuffer;
    case 8: 
      localByteBuffer = this._decBuffer8;
      AppMethodBeat.o(13853);
      return localByteBuffer;
    case 9: 
      localByteBuffer = this._decBuffer9;
      AppMethodBeat.o(13853);
      return localByteBuffer;
    }
    ByteBuffer localByteBuffer = this._decBuffer10;
    AppMethodBeat.o(13853);
    return localByteBuffer;
  }
  
  private String getDumpFilePath(String paramString, int paramInt)
  {
    AppMethodBeat.i(13820);
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "manufacture:" + Build.MANUFACTURER);
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "MODEL:" + Build.MODEL);
    }
    if (this._context == null)
    {
      AppMethodBeat.o(13820);
      return null;
    }
    File localFile = this._context.getExternalFilesDir(null);
    if (localFile == null)
    {
      AppMethodBeat.o(13820);
      return null;
    }
    paramString = localFile.getPath() + "/MF-" + Build.MANUFACTURER + "-M-" + Build.MODEL + "-as-" + TraeAudioManager.getAudioSource(this._audioSourcePolicy) + "-st-" + this._streamType + "-m-" + paramInt + "-" + paramString;
    localFile = new File(paramString);
    if (!localFile.getParentFile().exists()) {
      localFile.getParentFile().mkdirs();
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "dump:".concat(String.valueOf(paramString)));
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "dump replace:" + paramString.replace(" ", "_"));
    }
    paramString = paramString.replace(" ", "_");
    AppMethodBeat.o(13820);
    return paramString;
  }
  
  private int getLowlatencyFramesPerBuffer()
  {
    AppMethodBeat.i(13816);
    if ((this._context == null) || (Build.VERSION.SDK_INT < 9))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "getLowlatencySamplerate err, _context:" + this._context + " api:" + Build.VERSION.SDK_INT);
      }
      AppMethodBeat.o(13816);
      return 0;
    }
    boolean bool = this._context.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder("LOW_LATENCY:");
      if (bool != true) {
        break label161;
      }
    }
    label161:
    for (String str = "Y";; str = "N")
    {
      QLog.w("TRAE", 2, str);
      if (Build.VERSION.SDK_INT >= 17) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "API Level too low not support PROPERTY_OUTPUT_SAMPLE_RATE");
      }
      AppMethodBeat.o(13816);
      return 0;
    }
    AppMethodBeat.o(13816);
    return 0;
  }
  
  private int getLowlatencySamplerate()
  {
    AppMethodBeat.i(13815);
    if ((this._context == null) || (Build.VERSION.SDK_INT < 9))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "getLowlatencySamplerate err, _context:" + this._context + " api:" + Build.VERSION.SDK_INT);
      }
      AppMethodBeat.o(13815);
      return 0;
    }
    boolean bool = this._context.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder("LOW_LATENCY:");
      if (bool != true) {
        break label161;
      }
    }
    label161:
    for (String str = "Y";; str = "N")
    {
      QLog.w("TRAE", 2, str);
      if (Build.VERSION.SDK_INT >= 17) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "API Level too low not support PROPERTY_OUTPUT_SAMPLE_RATE");
      }
      AppMethodBeat.o(13815);
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.e("TRAE", 2, "getLowlatencySamplerate not support right now!");
    }
    AppMethodBeat.o(13815);
    return 0;
  }
  
  private int getMp3Channels(int paramInt)
  {
    AppMethodBeat.i(13858);
    TraeAudioCodecList.CodecInfo localCodecInfo = this._traeAudioCodecList.find(paramInt);
    if (localCodecInfo != null)
    {
      paramInt = localCodecInfo.audioDecoder.getChannels();
      AppMethodBeat.o(13858);
      return paramInt;
    }
    AppMethodBeat.o(13858);
    return -1;
  }
  
  private long getMp3FileTotalMs(int paramInt)
  {
    AppMethodBeat.i(13859);
    TraeAudioCodecList.CodecInfo localCodecInfo = this._traeAudioCodecList.find(paramInt);
    if (localCodecInfo != null)
    {
      long l = localCodecInfo.audioDecoder.getFileTotalMs();
      AppMethodBeat.o(13859);
      return l;
    }
    AppMethodBeat.o(13859);
    return -1L;
  }
  
  private int getMp3SampleRate(int paramInt)
  {
    AppMethodBeat.i(13857);
    TraeAudioCodecList.CodecInfo localCodecInfo = this._traeAudioCodecList.find(paramInt);
    if (localCodecInfo != null)
    {
      paramInt = localCodecInfo.audioDecoder.getSampleRate();
      AppMethodBeat.o(13857);
      return paramInt;
    }
    AppMethodBeat.o(13857);
    return -1;
  }
  
  private int getPlayRecordSysBufferMs()
  {
    return (this.nRecordLengthMs + this.nPlayLengthMs) * 2;
  }
  
  public static String getTraceInfo()
  {
    AppMethodBeat.i(13830);
    Object localObject = new StringBuffer();
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    ((StringBuffer)localObject).append(arrayOfStackTraceElement[2].getClassName()).append(".").append(arrayOfStackTraceElement[2].getMethodName()).append(": ").append(arrayOfStackTraceElement[2].getLineNumber());
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(13830);
    return localObject;
  }
  
  private void initTRAEAudioManager()
  {
    AppMethodBeat.i(13840);
    if (this._context != null)
    {
      TraeAudioManager.init(this._context);
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "initTRAEAudioManager , TraeAudioSession create");
      }
      if (this._asAudioManager == null) {
        this._asAudioManager = new TraeAudioSession(this._context, new TraeAudioSession.ITraeAudioCallback()
        {
          public void onAudioRouteSwitchEnd(String paramAnonymousString, long paramAnonymousLong) {}
          
          public void onAudioRouteSwitchStart(String paramAnonymousString1, String paramAnonymousString2) {}
          
          public void onConnectDeviceRes(int paramAnonymousInt, String paramAnonymousString, boolean paramAnonymousBoolean) {}
          
          public void onDeviceChangabledUpdate(boolean paramAnonymousBoolean) {}
          
          public void onDeviceListUpdate(String[] paramAnonymousArrayOfString, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
          {
            AppMethodBeat.i(13889);
            AudioDeviceInterface.access$302(paramAnonymousArrayOfString);
            if (AudioDeviceInterface.this.usingJava) {
              AudioDeviceInterface.access$500(AudioDeviceInterface.this, paramAnonymousString1);
            }
            AppMethodBeat.o(13889);
          }
          
          public void onGetConnectedDeviceRes(int paramAnonymousInt, String paramAnonymousString)
          {
            AppMethodBeat.i(13891);
            if (paramAnonymousInt == 0) {
              AudioDeviceInterface.access$500(AudioDeviceInterface.this, paramAnonymousString);
            }
            AppMethodBeat.o(13891);
          }
          
          public void onGetConnectingDeviceRes(int paramAnonymousInt, String paramAnonymousString) {}
          
          public void onGetDeviceListRes(int paramAnonymousInt, String[] paramAnonymousArrayOfString, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
          {
            AppMethodBeat.i(13890);
            AudioDeviceInterface.access$302(paramAnonymousArrayOfString);
            AppMethodBeat.o(13890);
          }
          
          public void onGetStreamTypeRes(int paramAnonymousInt1, int paramAnonymousInt2) {}
          
          public void onIsDeviceChangabledRes(int paramAnonymousInt, boolean paramAnonymousBoolean) {}
          
          public void onRingCompletion(int paramAnonymousInt, String paramAnonymousString) {}
          
          public void onServiceStateUpdate(boolean paramAnonymousBoolean) {}
          
          public void onStreamTypeUpdate(int paramAnonymousInt) {}
          
          public void onVoicecallPreprocessRes(int paramAnonymousInt) {}
        });
      }
      this._asAudioManager.startService("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
    }
    AppMethodBeat.o(13840);
  }
  
  static boolean isHardcodeOpenSles()
  {
    AppMethodBeat.i(13845);
    if (Build.MANUFACTURER.equals("Xiaomi"))
    {
      if (Build.MODEL.equals("MI 5"))
      {
        AppMethodBeat.o(13845);
        return true;
      }
      if (Build.MODEL.equals("MI 5s"))
      {
        AppMethodBeat.o(13845);
        return true;
      }
      if (Build.MODEL.equals("MI 5s Plus"))
      {
        AppMethodBeat.o(13845);
        return true;
      }
    }
    else if ((Build.MANUFACTURER.equals("samsung")) && (Build.MODEL.equals("SM-G9350")))
    {
      AppMethodBeat.o(13845);
      return true;
    }
    AppMethodBeat.o(13845);
    return false;
  }
  
  private int isSupportLowLatency()
  {
    AppMethodBeat.i(13847);
    if (isHardcodeOpenSles())
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "hardcode FEATURE_AUDIO_LOW_LATENCY: " + Build.MANUFACTURER + "_" + Build.MODEL);
      }
      AppMethodBeat.o(13847);
      return 1;
    }
    AppMethodBeat.o(13847);
    return 0;
  }
  
  private int isSupportVivoKTVHelper()
  {
    AppMethodBeat.i(13848);
    if (this._context != null)
    {
      VivoKTVHelper localVivoKTVHelper = VivoKTVHelper.getInstance(this._context);
      mVivoKTVHelper = localVivoKTVHelper;
      if (localVivoKTVHelper != null) {
        isSupportVivoKTVHelper = mVivoKTVHelper.isDeviceSupportKaraoke();
      }
    }
    if (isSupportVivoKTVHelper == true)
    {
      AppMethodBeat.o(13848);
      return 1;
    }
    AppMethodBeat.o(13848);
    return 0;
  }
  
  private int isVivoKTVLoopback()
  {
    AppMethodBeat.i(13850);
    if ((mVivoKTVHelper != null) && (isSupportVivoKTVHelper))
    {
      int i = mVivoKTVHelper.getPlayFeedbackParam();
      AppMethodBeat.o(13850);
      return i;
    }
    AppMethodBeat.o(13850);
    return 0;
  }
  
  private void onOutputChanage(String paramString)
  {
    AppMethodBeat.i(13833);
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, " onOutputChanage:".concat(String.valueOf(paramString)));
    }
    setAudioRouteSwitchState(paramString);
    if (!TraeAudioManager.isCloseSystemAPM(this._modePolicy))
    {
      AppMethodBeat.o(13833);
      return;
    }
    if ((this._deviceStat == 1) || (this._deviceStat == 5) || (this._deviceStat == 2) || (this._deviceStat == 3))
    {
      AppMethodBeat.o(13833);
      return;
    }
    this._connectedDev = paramString;
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder(" onOutputChanage:").append(paramString);
      if (this._audioManager != null) {
        break label283;
      }
      localObject = " am==null";
      localStringBuilder = localStringBuilder.append((String)localObject).append(" st:").append(this._streamType);
      if (this._audioTrack != null) {
        break label310;
      }
      localObject = "_audioTrack==null";
      label157:
      QLog.w("TRAE", 2, (String)localObject);
    }
    for (;;)
    {
      try
      {
        if (this._audioManager == null) {
          this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder(" curr mode:").append(paramString);
          if (this._audioManager != null) {
            continue;
          }
          paramString = "am==null";
          QLog.w("TRAE", 2, paramString);
        }
        if ((this._audioManager != null) && (this._connectedDev.equals("DEVICE_SPEAKERPHONE"))) {
          this._audioManager.setMode(0);
        }
      }
      catch (Exception paramString)
      {
        label283:
        label310:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("TRAE", 2, paramString.getMessage());
        continue;
      }
      this._audioRouteChanged = true;
      AppMethodBeat.o(13833);
      return;
      localObject = " mode:" + this._audioManager.getMode();
      break;
      localObject = " at.st:" + this._audioTrack.getStreamType();
      break label157;
      paramString = " mode:" + this._audioManager.getMode();
    }
  }
  
  private void setAudioRouteSwitchState(String paramString)
  {
    AppMethodBeat.i(13839);
    if (paramString.equals("DEVICE_EARPHONE"))
    {
      this.switchState = 1;
      AppMethodBeat.o(13839);
      return;
    }
    if (paramString.equals("DEVICE_SPEAKERPHONE"))
    {
      this.switchState = 2;
      AppMethodBeat.o(13839);
      return;
    }
    if (paramString.equals("DEVICE_WIREDHEADSET"))
    {
      this.switchState = 3;
      AppMethodBeat.o(13839);
      return;
    }
    if (paramString.equals("DEVICE_BLUETOOTHHEADSET"))
    {
      this.switchState = 4;
      AppMethodBeat.o(13839);
      return;
    }
    this.switchState = 0;
    AppMethodBeat.o(13839);
  }
  
  private int startService(String paramString)
  {
    AppMethodBeat.i(13841);
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "initTRAEAudioManager , TraeAudioSession startService: " + this._asAudioManager + " deviceConfig:" + paramString);
    }
    if (this._asAudioManager != null)
    {
      int i = this._asAudioManager.startService(paramString);
      AppMethodBeat.o(13841);
      return i;
    }
    AppMethodBeat.o(13841);
    return -1;
  }
  
  private int stopService()
  {
    AppMethodBeat.i(13842);
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "initTRAEAudioManager , TraeAudioSession stopService: " + this._asAudioManager);
    }
    if (this._asAudioManager != null)
    {
      int i = this._asAudioManager.stopService();
      AppMethodBeat.o(13842);
      return i;
    }
    AppMethodBeat.o(13842);
    return -1;
  }
  
  private void uninitTRAEAudioManager()
  {
    AppMethodBeat.i(13851);
    if (this._context != null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "uninitTRAEAudioManager , stopService");
      }
      if (this._asAudioManager != null)
      {
        this._asAudioManager.stopService();
        this._asAudioManager.release();
        this._asAudioManager = null;
        AppMethodBeat.o(13851);
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.w("TRAE", 2, "uninitTRAEAudioManager , context null");
    }
    AppMethodBeat.o(13851);
  }
  
  public int GetPlayoutVolume()
  {
    AppMethodBeat.i(13829);
    for (;;)
    {
      try
      {
        if ((this._audioManager == null) && (this._context != null)) {
          this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
        }
        if (this._audioManager == null) {
          continue;
        }
        i = this._audioManager.getStreamVolume(this._streamType);
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("TRAE GetPlayoutVolume", 2, localException.getMessage());
        int i = -1;
        continue;
      }
      AppMethodBeat.o(13829);
      return i;
      i = -1;
    }
  }
  
  public int call_postprocess()
  {
    AppMethodBeat.i(13835);
    LogTraceEntry("");
    this.switchState = 0;
    if (this._as != null)
    {
      this._as.voiceCallPostprocess();
      this._as.release();
      this._as = null;
    }
    TraeAudioManager.IsUpdateSceneFlag = false;
    LogTraceExit();
    AppMethodBeat.o(13835);
    return 0;
  }
  
  public int call_postprocess_media()
  {
    AppMethodBeat.i(13837);
    LogTraceEntry("");
    this.switchState = 0;
    if (this._as != null)
    {
      this._as.release();
      this._as = null;
    }
    TraeAudioManager.IsUpdateSceneFlag = false;
    if ((mVivoKTVHelper != null) && (isSupportVivoKTVHelper)) {
      mVivoKTVHelper.closeKTVDevice();
    }
    LogTraceExit();
    AppMethodBeat.o(13837);
    return 0;
  }
  
  public int call_preprocess()
  {
    AppMethodBeat.i(13834);
    LogTraceEntry("");
    this.switchState = 0;
    this._streamType = TraeAudioManager.getAudioStreamType(this._audioStreamTypePolicy);
    if (this._as == null) {
      this._as = new TraeAudioSession(this._context, new TraeAudioSession.ITraeAudioCallback()
      {
        public void onAudioRouteSwitchEnd(String paramAnonymousString, long paramAnonymousLong) {}
        
        public void onAudioRouteSwitchStart(String paramAnonymousString1, String paramAnonymousString2) {}
        
        public void onConnectDeviceRes(int paramAnonymousInt, String paramAnonymousString, boolean paramAnonymousBoolean) {}
        
        public void onDeviceChangabledUpdate(boolean paramAnonymousBoolean) {}
        
        public void onDeviceListUpdate(String[] paramAnonymousArrayOfString, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
        {
          AppMethodBeat.i(13802);
          AudioDeviceInterface.access$302(paramAnonymousArrayOfString);
          if (AudioDeviceInterface.this.usingJava) {
            AudioDeviceInterface.access$500(AudioDeviceInterface.this, paramAnonymousString1);
          }
          AppMethodBeat.o(13802);
        }
        
        public void onGetConnectedDeviceRes(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(13804);
          if (paramAnonymousInt == 0) {
            AudioDeviceInterface.access$500(AudioDeviceInterface.this, paramAnonymousString);
          }
          AppMethodBeat.o(13804);
        }
        
        public void onGetConnectingDeviceRes(int paramAnonymousInt, String paramAnonymousString) {}
        
        public void onGetDeviceListRes(int paramAnonymousInt, String[] paramAnonymousArrayOfString, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
        {
          AppMethodBeat.i(13803);
          AudioDeviceInterface.access$302(paramAnonymousArrayOfString);
          AppMethodBeat.o(13803);
        }
        
        public void onGetStreamTypeRes(int paramAnonymousInt1, int paramAnonymousInt2) {}
        
        public void onIsDeviceChangabledRes(int paramAnonymousInt, boolean paramAnonymousBoolean) {}
        
        public void onRingCompletion(int paramAnonymousInt, String paramAnonymousString) {}
        
        public void onServiceStateUpdate(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(13801);
          if (!paramAnonymousBoolean) {
            try
            {
              AudioDeviceInterface.this._prelock.lock();
              AudioDeviceInterface.access$102(AudioDeviceInterface.this, true);
              if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "onServiceStateUpdate signalAll");
              }
              AudioDeviceInterface.this._precon.signalAll();
              AudioDeviceInterface.this._prelock.unlock();
              AppMethodBeat.o(13801);
              return;
            }
            catch (Exception localException) {}
          }
          AppMethodBeat.o(13801);
        }
        
        public void onStreamTypeUpdate(int paramAnonymousInt) {}
        
        public void onVoicecallPreprocessRes(int paramAnonymousInt)
        {
          AppMethodBeat.i(13805);
          try
          {
            AudioDeviceInterface.this._prelock.lock();
            AudioDeviceInterface.access$102(AudioDeviceInterface.this, true);
            if (QLog.isColorLevel()) {
              QLog.e("TRAE", 2, "onVoicecallPreprocessRes signalAll");
            }
            AudioDeviceInterface.this._precon.signalAll();
            AudioDeviceInterface.this._prelock.unlock();
            AppMethodBeat.o(13805);
            return;
          }
          catch (Exception localException)
          {
            AppMethodBeat.o(13805);
          }
        }
      });
    }
    this._preDone = false;
    if (this._as != null) {
      this._prelock.lock();
    }
    int i;
    int j;
    label386:
    for (;;)
    {
      try
      {
        if (this._audioManager == null) {
          this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
        }
        if (this._audioManager != null)
        {
          if (this._audioManager.getMode() == 2)
          {
            i = 5;
            if ((i > 0) && (this._audioManager.getMode() == 2))
            {
              if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "call_preprocess waiting...  mode:" + this._audioManager.getMode());
              }
              Thread.sleep(500L);
              i -= 1;
              continue;
            }
          }
          if (this._audioManager.isMicrophoneMute())
          {
            this._audioManager.setMicrophoneMute(false);
            if (QLog.isColorLevel()) {
              QLog.e("TRAE", 2, "media call_preprocess setMicrophoneMute false");
            }
          }
        }
        this._as.voiceCallPreprocess(this._modePolicy, this._streamType);
        this._as.connectHighestPriorityDevice();
        i = 7;
        j = i - 1;
        if (i <= 0) {}
      }
      catch (InterruptedException localInterruptedException1)
      {
        this._prelock.unlock();
        continue;
      }
      finally
      {
        this._prelock.unlock();
        AppMethodBeat.o(13834);
      }
      try
      {
        if (!this._preDone)
        {
          this._precon.await(1L, TimeUnit.SECONDS);
          if (!QLog.isColorLevel()) {
            break label386;
          }
          QLog.e("TRAE", 2, "call_preprocess waiting...  as:" + this._as);
          i = j;
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 2, "call_preprocess done!");
        }
      }
      catch (InterruptedException localInterruptedException2)
      {
        continue;
        i = j;
      }
      this._as.getConnectedDevice();
      this._prelock.unlock();
      LogTraceExit();
      AppMethodBeat.o(13834);
      return 0;
    }
  }
  
  public int call_preprocess_media()
  {
    AppMethodBeat.i(13836);
    LogTraceEntry("");
    this.switchState = 0;
    if ((mVivoKTVHelper != null) && (isSupportVivoKTVHelper))
    {
      mVivoKTVHelper.openKTVDevice();
      mVivoKTVHelper.setPreModeParam(1);
      mVivoKTVHelper.setPlayFeedbackParam(1);
      mVivoKTVHelper.setPlayFeedbackParam(0);
    }
    if (this._as == null) {
      this._as = new TraeAudioSession(this._context, new TraeAudioSession.ITraeAudioCallback()
      {
        public void onAudioRouteSwitchEnd(String paramAnonymousString, long paramAnonymousLong) {}
        
        public void onAudioRouteSwitchStart(String paramAnonymousString1, String paramAnonymousString2) {}
        
        public void onConnectDeviceRes(int paramAnonymousInt, String paramAnonymousString, boolean paramAnonymousBoolean) {}
        
        public void onDeviceChangabledUpdate(boolean paramAnonymousBoolean) {}
        
        public void onDeviceListUpdate(String[] paramAnonymousArrayOfString, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
        {
          AppMethodBeat.i(13635);
          AudioDeviceInterface.access$302(paramAnonymousArrayOfString);
          if (AudioDeviceInterface.this.usingJava) {
            AudioDeviceInterface.access$500(AudioDeviceInterface.this, paramAnonymousString1);
          }
          AppMethodBeat.o(13635);
        }
        
        public void onGetConnectedDeviceRes(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(13637);
          if (paramAnonymousInt == 0) {
            AudioDeviceInterface.access$500(AudioDeviceInterface.this, paramAnonymousString);
          }
          AppMethodBeat.o(13637);
        }
        
        public void onGetConnectingDeviceRes(int paramAnonymousInt, String paramAnonymousString) {}
        
        public void onGetDeviceListRes(int paramAnonymousInt, String[] paramAnonymousArrayOfString, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
        {
          AppMethodBeat.i(13636);
          AudioDeviceInterface.access$302(paramAnonymousArrayOfString);
          AppMethodBeat.o(13636);
        }
        
        public void onGetStreamTypeRes(int paramAnonymousInt1, int paramAnonymousInt2) {}
        
        public void onIsDeviceChangabledRes(int paramAnonymousInt, boolean paramAnonymousBoolean) {}
        
        public void onRingCompletion(int paramAnonymousInt, String paramAnonymousString) {}
        
        public void onServiceStateUpdate(boolean paramAnonymousBoolean) {}
        
        public void onStreamTypeUpdate(int paramAnonymousInt) {}
        
        public void onVoicecallPreprocessRes(int paramAnonymousInt) {}
      });
    }
    if (this._as != null) {}
    try
    {
      if (this._audioManager == null) {
        this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
      }
      if (this._audioManager != null)
      {
        if (this._audioManager.getMode() == 2)
        {
          int i = 5;
          while ((i > 0) && (this._audioManager.getMode() == 2))
          {
            if (QLog.isColorLevel()) {
              QLog.e("TRAE", 2, "media call_preprocess_media waiting...  mode:" + this._audioManager.getMode());
            }
            Thread.sleep(500L);
            i -= 1;
          }
        }
        if (this._audioManager.getMode() != 0) {
          this._audioManager.setMode(0);
        }
        if (this._audioManager.isMicrophoneMute())
        {
          this._audioManager.setMicrophoneMute(false);
          if (QLog.isColorLevel()) {
            QLog.e("TRAE", 2, "media call_preprocess_media setMicrophoneMute false");
          }
        }
      }
      this._as.connectHighestPriorityDevice();
      this._as.getConnectedDevice();
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "call_preprocess_media done!");
      }
      label285:
      LogTraceExit();
    }
    catch (InterruptedException localInterruptedException)
    {
      break label285;
    }
    AppMethodBeat.o(13836);
    return 0;
  }
  
  @SuppressLint({"NewApi"})
  public int checkAACMediaCodecSupported(boolean paramBoolean)
  {
    AppMethodBeat.i(13861);
    try
    {
      Object localObject;
      String[] arrayOfString1;
      boolean bool;
      int j;
      if (Build.VERSION.SDK_INT >= 21)
      {
        localObject = new MediaCodecList(1).getCodecInfos();
        k = localObject.length;
        i = 0;
        while (i < k)
        {
          arrayOfString1 = localObject[i];
          if (arrayOfString1.isEncoder() != paramBoolean)
          {
            bool = arrayOfString1.getName().toLowerCase().contains("nvidia");
            if (bool)
            {
              AppMethodBeat.o(13861);
              return 0;
            }
            String[] arrayOfString2 = arrayOfString1.getSupportedTypes();
            j = 0;
            while (j < arrayOfString2.length)
            {
              if (arrayOfString2[j].equalsIgnoreCase("audio/mp4a-latm"))
              {
                if (QLog.isColorLevel()) {
                  QLog.w("TRAE", 2, "checkAACSupported support!, " + arrayOfString1.getName());
                }
                AppMethodBeat.o(13861);
                return 1;
              }
              j += 1;
            }
          }
          i += 1;
        }
      }
      int k = MediaCodecList.getCodecCount();
      int i = 0;
      while (i < k)
      {
        localObject = MediaCodecList.getCodecInfoAt(i);
        if (((MediaCodecInfo)localObject).isEncoder() != paramBoolean)
        {
          bool = ((MediaCodecInfo)localObject).getName().toLowerCase().contains("nvidia");
          if (bool)
          {
            AppMethodBeat.o(13861);
            return 0;
          }
          arrayOfString1 = ((MediaCodecInfo)localObject).getSupportedTypes();
          j = 0;
          while (j < arrayOfString1.length)
          {
            if (arrayOfString1[j].equalsIgnoreCase("audio/mp4a-latm"))
            {
              if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "checkAACSupported support!, " + ((MediaCodecInfo)localObject).getName());
              }
              AppMethodBeat.o(13861);
              return 1;
            }
            j += 1;
          }
        }
        i += 1;
      }
      return 0;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "check if support aac codec failed.");
      }
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "Error when checking aac codec availability");
      }
      AppMethodBeat.o(13861);
    }
  }
  
  public int checkAACSupported()
  {
    AppMethodBeat.i(13860);
    int i = checkAACMediaCodecSupported(false);
    int j = checkAACMediaCodecSupported(true);
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "checkAACSupported isSupportEncoder: " + i + ", isSupportDecoder:" + j);
    }
    if ((i == 1) && (j == 1))
    {
      AppMethodBeat.o(13860);
      return 1;
    }
    AppMethodBeat.o(13860);
    return 0;
  }
  
  public int getAudioRouteSwitchState()
  {
    return this.switchState;
  }
  
  public int getMode()
  {
    AppMethodBeat.i(222660);
    j = -1;
    try
    {
      if ((this._audioManager == null) && (this._context != null)) {
        this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
      }
      if (this._audioManager == null) {
        break label87;
      }
      i = this._audioManager.getMode();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = j;
        if (QLog.isColorLevel())
        {
          QLog.w("TRAE getMode", 2, localException.getMessage());
          i = j;
          continue;
          i = -1;
        }
      }
    }
    AppMethodBeat.o(222660);
    return i;
  }
  
  public int getNumberOfCPUCores()
  {
    int i = -1;
    AppMethodBeat.i(13846);
    if (Build.VERSION.SDK_INT <= 10)
    {
      AppMethodBeat.o(13846);
      return 1;
    }
    try
    {
      int j = new File("/sys/devices/system/cpu/").listFiles(CPU_FILTER).length;
      i = j;
    }
    catch (NullPointerException localNullPointerException)
    {
      break label44;
    }
    catch (SecurityException localSecurityException)
    {
      label44:
      break label44;
    }
    AppMethodBeat.o(13846);
    return i;
  }
  
  public int hasLightSensorManager()
  {
    AppMethodBeat.i(13844);
    if (this._context == null)
    {
      AppMethodBeat.o(13844);
      return 1;
    }
    try
    {
      Sensor localSensor = ((SensorManager)this._context.getSystemService("sensor")).getDefaultSensor(5);
      if (localSensor == null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "not hasLightSensorManager null == sensor8");
        }
        AppMethodBeat.o(13844);
        return 0;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, localException.getMessage());
      }
      AppMethodBeat.o(13844);
      return 1;
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "hasLightSensorManager");
    }
    AppMethodBeat.o(13844);
    return 1;
  }
  
  public int isBackground()
  {
    AppMethodBeat.i(222661);
    if (this._context == null)
    {
      AppMethodBeat.o(222661);
      return 0;
    }
    try
    {
      Object localObject = (ActivityManager)this._context.getSystemService("activity");
      if (((ActivityManager)localObject).getRunningTasks(1) == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 2, "running task is null, ams is abnormal!!!");
        }
        AppMethodBeat.o(222661);
        return 0;
      }
      localObject = (ActivityManager.RunningTaskInfo)((ActivityManager)localObject).getRunningTasks(1).get(0);
      if ((localObject == null) || (((ActivityManager.RunningTaskInfo)localObject).topActivity == null))
      {
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 2, "failed to get RunningTaskInfo");
        }
        AppMethodBeat.o(222661);
        return 0;
      }
      boolean bool = ((ActivityManager.RunningTaskInfo)localObject).topActivity.getPackageName().equals(this._context.getPackageName());
      if (!bool) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(222661);
        return 1;
      }
      AppMethodBeat.o(222661);
      return 0;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE isBackground", 2, localException.getMessage());
      }
      AppMethodBeat.o(222661);
    }
    return 0;
  }
  
  public void setContext(Context paramContext)
  {
    this._context = paramContext;
  }
  
  public void setJavaInterface(int paramInt)
  {
    AppMethodBeat.i(13838);
    if (paramInt == 0) {}
    for (this.usingJava = false;; this.usingJava = true)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "setJavaInterface flg:".concat(String.valueOf(paramInt)));
      }
      AppMethodBeat.o(13838);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.AudioDeviceInterface
 * JD-Core Version:    0.7.0.1
 */