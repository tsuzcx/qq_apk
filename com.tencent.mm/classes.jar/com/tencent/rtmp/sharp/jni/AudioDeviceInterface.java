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
  private static final String TAG = "AudioDeviceInterface";
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
        QLog.w("AudioDeviceInterface", 2, "AudioDeviceInterface apiLevel:".concat(String.valueOf(i)));
      }
      if (QLog.isColorLevel()) {
        QLog.w("AudioDeviceInterface", 2, " SDK_INT:" + Build.VERSION.SDK_INT);
      }
      if (QLog.isColorLevel()) {
        QLog.w("AudioDeviceInterface", 2, "manufacture:" + Build.MANUFACTURER);
      }
      if (QLog.isColorLevel()) {
        QLog.w("AudioDeviceInterface", 2, "MODEL:" + Build.MODEL);
      }
      AppMethodBeat.o(13814);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("AudioDeviceInterface", 2, localException.getMessage());
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
      QLog.w("AudioDeviceInterface", 2, "EnableVivoKTVLoopback: " + paramInt + " isSupportVivoKTVHelper:" + isSupportVivoKTVHelper + " mVivoKTVHelper:" + mVivoKTVHelper);
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
      QLog.w("AudioDeviceInterface", 2, "InitPlayback entry: sampleRate ".concat(String.valueOf(paramInt1)));
    }
    if ((this._isPlaying) || (this._audioTrack != null) || (paramInt2 > 2))
    {
      if (QLog.isColorLevel()) {
        QLog.e("AudioDeviceInterface", 2, "InitPlayback _isPlaying:" + this._isPlaying);
      }
      AppMethodBeat.o(13819);
      return -1;
    }
    if (this._audioManager == null) {}
    label646:
    label672:
    label958:
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
              break label646;
            }
            QLog.w("AudioDeviceInterface", 2, "InitPlayback, _channelOutType stero");
          }
          int j = paramInt1 * 20 * 1 * 2 / 1000;
          if (this._channelOutType != 12) {
            break label958;
          }
          j *= 2;
          if (QLog.isColorLevel()) {
            QLog.w("AudioDeviceInterface", 2, "InitPlayback: minPlayBufSize:" + i1 + " 20msFz:" + j);
          }
          this._bufferedPlaySamples = 0;
          if (this._audioTrack != null)
          {
            this._audioTrack.release();
            this._audioTrack = null;
          }
          int[] arrayOfInt = new int[4];
          tmp263_261 = arrayOfInt;
          tmp263_261[0] = 0;
          tmp267_263 = tmp263_261;
          tmp267_263[1] = 0;
          tmp271_267 = tmp267_263;
          tmp271_267[2] = 3;
          tmp275_271 = tmp271_267;
          tmp275_271[3] = 1;
          tmp275_271;
          this._streamType = TraeAudioManager.getAudioStreamType(this._audioStreamTypePolicy);
          if (this._audioRouteChanged)
          {
            if (QLog.isColorLevel()) {
              QLog.w("AudioDeviceInterface", 2, "_audioRouteChanged:" + this._audioRouteChanged + " _streamType:" + this._streamType);
            }
            if ((this._audioManager.getMode() != 0) || (!this._connectedDev.equals("DEVICE_SPEAKERPHONE"))) {
              break label672;
            }
            this._streamType = 3;
            this._audioRouteChanged = false;
          }
          arrayOfInt[0] = this._streamType;
          k = 0;
          i = i1;
          if ((k >= 4) || (this._audioTrack != null)) {
            break label756;
          }
          this._streamType = arrayOfInt[k];
          if (QLog.isColorLevel()) {
            QLog.w("AudioDeviceInterface", 2, "InitPlayback: min play buf size is " + i1 + " hw_sr:" + AudioTrack.getNativeOutputSampleRate(this._streamType));
          }
          m = 1;
          if (m > 2) {
            break label747;
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
          QLog.w("AudioDeviceInterface", 2, localException1.getMessage());
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
          break label747;
        }
        if (QLog.isColorLevel()) {
          QLog.w("AudioDeviceInterface", 2, "InitPlayback: play not initialized playBufSize:" + n + " sr:" + this._playSamplerate);
        }
        this._audioTrack.release();
        this._audioTrack = null;
      }
      catch (Exception localException2)
      {
        if (!QLog.isColorLevel()) {
          break label725;
        }
        QLog.w("AudioDeviceInterface", 2, localException2.getMessage() + " _audioTrack:" + this._audioTrack);
        if (this._audioTrack == null) {
          break label739;
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
        QLog.w("AudioDeviceInterface", 2, "InitPlayback, _channelOutType Mono");
        continue;
        this._streamType = 0;
        continue;
        label725:
        label739:
        label747:
        k += 1;
        continue;
        label756:
        if (this._audioTrack == null)
        {
          if (QLog.isColorLevel()) {
            QLog.w("AudioDeviceInterface", 2, "InitPlayback fail!!!");
          }
          AppMethodBeat.o(13819);
          return -1;
        }
        if ((this._as != null) && (this._audioManager != null)) {
          this._as.voiceCallAudioParamChanged(this._audioManager.getMode(), this._streamType);
        }
        this._playPosition = this._audioTrack.getPlaybackHeadPosition();
        if (QLog.isColorLevel()) {
          QLog.w("AudioDeviceInterface", 2, "InitPlayback exit: streamType:" + this._streamType + " samplerate:" + this._playSamplerate + " _playPosition:" + this._playPosition + " playBufSize:" + i + " nPlayLengthMs:" + this.nPlayLengthMs);
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
      QLog.w("AudioDeviceInterface", 2, "InitRecording entry:".concat(String.valueOf(paramInt1)));
    }
    if ((this._isRecording) || (this._audioRecord != null) || (paramInt2 > 2))
    {
      if (QLog.isColorLevel()) {
        QLog.e("AudioDeviceInterface", 2, "InitRecording _isRecording:" + this._isRecording);
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
      QLog.w("AudioDeviceInterface", 2, "InitRecording: min rec buf size is " + i1 + " sr:" + getLowlatencySamplerate() + " fp" + getLowlatencyFramesPerBuffer() + " 20msFZ:" + i2);
    }
    this._bufferedRecSamples = (paramInt1 * 5 / 200);
    if (QLog.isColorLevel()) {
      QLog.w("AudioDeviceInterface", 2, "  rough rec delay set to " + this._bufferedRecSamples);
    }
    if (this._audioRecord != null)
    {
      this._audioRecord.release();
      this._audioRecord = null;
    }
    int[] arrayOfInt = new int[4];
    int[] tmp259_257 = arrayOfInt;
    tmp259_257[0] = 0;
    int[] tmp263_259 = tmp259_257;
    tmp263_259[1] = 1;
    int[] tmp267_263 = tmp263_259;
    tmp267_263[2] = 5;
    int[] tmp271_267 = tmp267_263;
    tmp271_267[3] = 0;
    tmp271_267;
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
          break label539;
        }
        int n = i1 * m;
        if ((n >= i2 * 4) || (m >= 2)) {}
        try
        {
          this.nRecordLengthMs = (n * 500 / (paramInt1 * paramInt2));
          this._audioRecord = new AudioRecord(this._audioSource, paramInt1, j, 2, n);
          i = n;
          if (this._audioRecord.getState() == 1) {
            break label539;
          }
          if (QLog.isColorLevel()) {
            QLog.w("AudioDeviceInterface", 2, "InitRecording:  rec not initialized,try agine,  minbufsize:" + n + " sr:" + paramInt1 + " as:" + this._audioSource);
          }
          this._audioRecord.release();
          this._audioRecord = null;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("AudioDeviceInterface", 2, localException.getMessage() + " _audioRecord:" + this._audioRecord);
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
      label539:
      k += 1;
    }
    if (this._audioRecord == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("AudioDeviceInterface", 2, "InitRecording fail!!!");
      }
      AppMethodBeat.o(13818);
      return -1;
    }
    if (QLog.isColorLevel()) {
      QLog.w("AudioDeviceInterface", 2, " [Config] InitRecording: audioSession:" + this._sessionId + " audioSource:" + this._audioSource + " rec sample rate set to " + paramInt1 + " recBufSize:" + i + " nRecordLengthMs:" + this.nRecordLengthMs);
    }
    if (QLog.isColorLevel()) {
      QLog.w("AudioDeviceInterface", 2, "InitRecording exit");
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
        break label188;
      }
    }
    label188:
    for (TraeAudioManager.IsEarPhoneSupported = true;; TraeAudioManager.IsEarPhoneSupported = false)
    {
      TraeAudioManager.IsUpdateSceneFlag = true;
      if (QLog.isColorLevel()) {
        QLog.w("AudioDeviceInterface", 2, "InitSetting: _audioSourcePolicy:" + this._audioSourcePolicy + " _audioStreamTypePolicy:" + this._audioStreamTypePolicy + " _modePolicy:" + this._modePolicy + " DeviceStat:" + paramInt4 + " isSupportVivoKTVHelper:" + isSupportVivoKTVHelper);
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
      QLog.w("AudioDeviceInterface", 2, paramString);
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
      QLog.w("AudioDeviceInterface", 2, str);
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
          QLog.w("AudioDeviceInterface", 2, "openFile mp3 Failed!!!");
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
        QLog.e("AudioDeviceInterface", 2, "PlayAudio Exception: " + localException.getMessage());
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
    //   3: invokestatic 106	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 164	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   10: ifne +73 -> 83
    //   13: iconst_1
    //   14: istore_2
    //   15: aload_0
    //   16: getfield 130	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   19: ifnonnull +69 -> 88
    //   22: iconst_1
    //   23: istore_3
    //   24: iload_2
    //   25: iload_3
    //   26: ior
    //   27: ifeq +66 -> 93
    //   30: invokestatic 261	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   33: ifeq +42 -> 75
    //   36: ldc 26
    //   38: iconst_2
    //   39: new 279	java/lang/StringBuilder
    //   42: dup
    //   43: ldc_w 560
    //   46: invokespecial 284	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   49: aload_0
    //   50: getfield 164	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   53: invokevirtual 339	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   56: ldc_w 562
    //   59: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload_0
    //   63: getfield 130	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   66: invokevirtual 344	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   69: invokevirtual 292	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokestatic 358	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   75: sipush 13825
    //   78: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: iconst_m1
    //   82: ireturn
    //   83: iconst_0
    //   84: istore_2
    //   85: goto -70 -> 15
    //   88: iconst_0
    //   89: istore_3
    //   90: goto -66 -> 24
    //   93: aload_0
    //   94: getfield 130	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   97: astore 10
    //   99: aload 10
    //   101: ifnonnull +12 -> 113
    //   104: sipush 13825
    //   107: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: bipush 254
    //   112: ireturn
    //   113: aload_0
    //   114: getfield 158	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_doPlayInit	Z
    //   117: istore 7
    //   119: iload 7
    //   121: iconst_1
    //   122: if_icmpne +22 -> 144
    //   125: bipush 237
    //   127: invokestatic 567	android/os/Process:setThreadPriority	(I)V
    //   130: invokestatic 573	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   133: ldc_w 575
    //   136: invokevirtual 578	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   139: aload_0
    //   140: iconst_0
    //   141: putfield 158	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_doPlayInit	Z
    //   144: getstatic 108	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_dumpEnable	Z
    //   147: ifeq +27 -> 174
    //   150: aload_0
    //   151: getfield 178	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_play_out	Ljava/io/FileOutputStream;
    //   154: astore 10
    //   156: aload 10
    //   158: ifnull +16 -> 174
    //   161: aload_0
    //   162: getfield 178	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_play_out	Ljava/io/FileOutputStream;
    //   165: aload_0
    //   166: getfield 245	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_tempBufPlay	[B
    //   169: iconst_0
    //   170: iconst_0
    //   171: invokevirtual 584	java/io/FileOutputStream:write	([BII)V
    //   174: aload_0
    //   175: getfield 192	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioRouteChanged	Z
    //   178: ifne +632 -> 810
    //   181: iconst_0
    //   182: istore_2
    //   183: aload_0
    //   184: getfield 219	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playBuffer	Ljava/nio/ByteBuffer;
    //   187: aload_0
    //   188: getfield 245	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_tempBufPlay	[B
    //   191: invokevirtual 588	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   194: pop
    //   195: iload_2
    //   196: ifeq +947 -> 1143
    //   199: aload_0
    //   200: getfield 219	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playBuffer	Ljava/nio/ByteBuffer;
    //   203: invokevirtual 592	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   206: pop
    //   207: invokestatic 598	android/os/SystemClock:elapsedRealtime	()J
    //   210: lstore 8
    //   212: invokestatic 261	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   215: ifeq +45 -> 260
    //   218: ldc 26
    //   220: iconst_2
    //   221: new 279	java/lang/StringBuilder
    //   224: dup
    //   225: ldc_w 600
    //   228: invokespecial 284	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   231: aload_0
    //   232: getfield 134	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   235: invokevirtual 288	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   238: ldc_w 602
    //   241: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: aload_0
    //   245: getfield 130	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   248: invokevirtual 451	android/media/AudioTrack:getStreamType	()I
    //   251: invokevirtual 288	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   254: invokevirtual 292	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: invokestatic 277	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   260: aload_0
    //   261: getfield 130	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   264: invokevirtual 605	android/media/AudioTrack:getPlayState	()I
    //   267: istore_2
    //   268: iload_2
    //   269: iconst_3
    //   270: if_icmpne +114 -> 384
    //   273: invokestatic 261	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   276: ifeq +12 -> 288
    //   279: ldc 26
    //   281: iconst_2
    //   282: ldc_w 607
    //   285: invokestatic 277	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   288: aload_0
    //   289: getfield 130	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   292: invokevirtual 610	android/media/AudioTrack:stop	()V
    //   295: aload_0
    //   296: getfield 130	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   299: invokevirtual 613	android/media/AudioTrack:flush	()V
    //   302: invokestatic 261	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   305: ifeq +32 -> 337
    //   308: ldc 26
    //   310: iconst_2
    //   311: new 279	java/lang/StringBuilder
    //   314: dup
    //   315: ldc_w 615
    //   318: invokespecial 284	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   321: aload_0
    //   322: getfield 130	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   325: invokevirtual 605	android/media/AudioTrack:getPlayState	()I
    //   328: invokevirtual 288	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   331: invokevirtual 292	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: invokestatic 277	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   337: aload_0
    //   338: getfield 130	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   341: invokevirtual 381	android/media/AudioTrack:release	()V
    //   344: invokestatic 261	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   347: ifeq +32 -> 379
    //   350: ldc 26
    //   352: iconst_2
    //   353: new 279	java/lang/StringBuilder
    //   356: dup
    //   357: ldc_w 617
    //   360: invokespecial 284	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   363: aload_0
    //   364: getfield 130	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   367: invokevirtual 605	android/media/AudioTrack:getPlayState	()I
    //   370: invokevirtual 288	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   373: invokevirtual 292	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   376: invokestatic 277	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   379: aload_0
    //   380: aconst_null
    //   381: putfield 130	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   384: aload_0
    //   385: getfield 136	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playSamplerate	I
    //   388: aload_0
    //   389: getfield 138	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_channelOutType	I
    //   392: iconst_2
    //   393: invokestatic 374	android/media/AudioTrack:getMinBufferSize	(III)I
    //   396: istore 5
    //   398: iconst_4
    //   399: newarray int
    //   401: astore 10
    //   403: aload 10
    //   405: dup
    //   406: iconst_0
    //   407: iconst_0
    //   408: iastore
    //   409: dup
    //   410: iconst_1
    //   411: iconst_0
    //   412: iastore
    //   413: dup
    //   414: iconst_2
    //   415: iconst_3
    //   416: iastore
    //   417: dup
    //   418: iconst_3
    //   419: iconst_1
    //   420: iastore
    //   421: pop
    //   422: aload 10
    //   424: iconst_0
    //   425: aload_0
    //   426: getfield 134	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   429: iastore
    //   430: aload_0
    //   431: getfield 136	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playSamplerate	I
    //   434: bipush 20
    //   436: imul
    //   437: iconst_1
    //   438: imul
    //   439: iconst_2
    //   440: imul
    //   441: sipush 1000
    //   444: idiv
    //   445: istore_2
    //   446: aload_0
    //   447: getfield 138	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_channelOutType	I
    //   450: bipush 12
    //   452: if_icmpne +883 -> 1335
    //   455: iload_2
    //   456: iconst_2
    //   457: imul
    //   458: istore_2
    //   459: goto +876 -> 1335
    //   462: iload_3
    //   463: iconst_4
    //   464: if_icmpge +536 -> 1000
    //   467: aload_0
    //   468: getfield 130	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   471: ifnonnull +529 -> 1000
    //   474: aload_0
    //   475: aload 10
    //   477: iload_3
    //   478: iaload
    //   479: putfield 134	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   482: invokestatic 261	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   485: ifeq +43 -> 528
    //   488: ldc 26
    //   490: iconst_2
    //   491: new 279	java/lang/StringBuilder
    //   494: dup
    //   495: ldc_w 402
    //   498: invokespecial 284	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   501: iload 5
    //   503: invokevirtual 288	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   506: ldc_w 404
    //   509: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: aload_0
    //   513: getfield 134	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   516: invokestatic 407	android/media/AudioTrack:getNativeOutputSampleRate	(I)I
    //   519: invokevirtual 288	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   522: invokevirtual 292	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   525: invokestatic 277	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   528: iconst_1
    //   529: istore 4
    //   531: iload 4
    //   533: iconst_2
    //   534: if_icmpgt +811 -> 1345
    //   537: iload 5
    //   539: iload 4
    //   541: imul
    //   542: istore 6
    //   544: iload 6
    //   546: iload_2
    //   547: iconst_4
    //   548: imul
    //   549: if_icmpge +9 -> 558
    //   552: iload 4
    //   554: iconst_2
    //   555: if_icmplt +128 -> 683
    //   558: aload_0
    //   559: new 370	android/media/AudioTrack
    //   562: dup
    //   563: aload_0
    //   564: getfield 134	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   567: aload_0
    //   568: getfield 136	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playSamplerate	I
    //   571: aload_0
    //   572: getfield 138	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_channelOutType	I
    //   575: iconst_2
    //   576: iload 6
    //   578: iconst_1
    //   579: invokespecial 410	android/media/AudioTrack:<init>	(IIIIII)V
    //   582: putfield 130	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   585: invokestatic 261	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   588: ifeq +29 -> 617
    //   591: ldc 26
    //   593: iconst_2
    //   594: new 279	java/lang/StringBuilder
    //   597: dup
    //   598: ldc_w 422
    //   601: invokespecial 284	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   604: aload_0
    //   605: getfield 130	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   608: invokevirtual 344	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   611: invokevirtual 292	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   614: invokestatic 277	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   617: aload_0
    //   618: getfield 130	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   621: invokevirtual 413	android/media/AudioTrack:getState	()I
    //   624: iconst_1
    //   625: if_icmpeq +720 -> 1345
    //   628: invokestatic 261	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   631: ifeq +40 -> 671
    //   634: ldc 26
    //   636: iconst_2
    //   637: new 279	java/lang/StringBuilder
    //   640: dup
    //   641: ldc_w 415
    //   644: invokespecial 284	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   647: iload 6
    //   649: invokevirtual 288	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   652: ldc_w 417
    //   655: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   658: aload_0
    //   659: getfield 136	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playSamplerate	I
    //   662: invokevirtual 288	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   665: invokevirtual 292	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   668: invokestatic 277	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   671: aload_0
    //   672: getfield 130	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   675: invokevirtual 381	android/media/AudioTrack:release	()V
    //   678: aload_0
    //   679: aconst_null
    //   680: putfield 130	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   683: iload 4
    //   685: iconst_1
    //   686: iadd
    //   687: istore 4
    //   689: goto -158 -> 531
    //   692: astore 10
    //   694: invokestatic 261	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   697: ifeq -558 -> 139
    //   700: ldc 26
    //   702: iconst_2
    //   703: new 279	java/lang/StringBuilder
    //   706: dup
    //   707: ldc_w 619
    //   710: invokespecial 284	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   713: aload 10
    //   715: invokevirtual 310	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   718: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   721: invokevirtual 292	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   724: invokestatic 277	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   727: goto -588 -> 139
    //   730: astore 10
    //   732: iconst_0
    //   733: istore_1
    //   734: iload_1
    //   735: istore_2
    //   736: invokestatic 261	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   739: ifeq +32 -> 771
    //   742: ldc 26
    //   744: iconst_2
    //   745: new 279	java/lang/StringBuilder
    //   748: dup
    //   749: ldc_w 553
    //   752: invokespecial 284	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   755: aload 10
    //   757: invokevirtual 310	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   760: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   763: invokevirtual 292	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   766: invokestatic 358	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   769: iload_1
    //   770: istore_2
    //   771: sipush 13825
    //   774: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   777: iload_2
    //   778: ireturn
    //   779: astore 10
    //   781: invokestatic 261	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   784: ifeq -610 -> 174
    //   787: ldc 26
    //   789: iconst_2
    //   790: ldc_w 621
    //   793: invokestatic 358	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   796: goto -622 -> 174
    //   799: astore 10
    //   801: sipush 13825
    //   804: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   807: aload 10
    //   809: athrow
    //   810: aload_0
    //   811: getfield 156	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   814: ifnonnull +27 -> 841
    //   817: aload_0
    //   818: getfield 148	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_context	Landroid/content/Context;
    //   821: ifnull +20 -> 841
    //   824: aload_0
    //   825: aload_0
    //   826: getfield 148	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_context	Landroid/content/Context;
    //   829: ldc_w 360
    //   832: invokevirtual 366	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   835: checkcast 368	android/media/AudioManager
    //   838: putfield 156	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   841: aload_0
    //   842: getfield 156	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   845: ifnull +55 -> 900
    //   848: aload_0
    //   849: getfield 156	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   852: invokevirtual 394	android/media/AudioManager:getMode	()I
    //   855: ifne +45 -> 900
    //   858: aload_0
    //   859: getfield 190	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_connectedDev	Ljava/lang/String;
    //   862: ldc_w 396
    //   865: invokevirtual 400	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   868: ifeq +32 -> 900
    //   871: aload_0
    //   872: iconst_3
    //   873: putfield 134	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   876: aload_0
    //   877: getfield 134	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   880: aload_0
    //   881: getfield 130	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   884: invokevirtual 451	android/media/AudioTrack:getStreamType	()I
    //   887: if_icmpne +21 -> 908
    //   890: iconst_0
    //   891: istore_2
    //   892: aload_0
    //   893: iconst_0
    //   894: putfield 192	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioRouteChanged	Z
    //   897: goto -714 -> 183
    //   900: aload_0
    //   901: iconst_0
    //   902: putfield 134	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   905: goto -29 -> 876
    //   908: iconst_1
    //   909: istore_2
    //   910: goto -18 -> 892
    //   913: astore 10
    //   915: invokestatic 261	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   918: ifeq -534 -> 384
    //   921: ldc 26
    //   923: iconst_2
    //   924: ldc_w 623
    //   927: invokestatic 358	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   930: goto -546 -> 384
    //   933: astore 11
    //   935: invokestatic 261	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   938: ifeq +40 -> 978
    //   941: ldc 26
    //   943: iconst_2
    //   944: new 279	java/lang/StringBuilder
    //   947: dup
    //   948: invokespecial 420	java/lang/StringBuilder:<init>	()V
    //   951: aload 11
    //   953: invokevirtual 310	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   956: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   959: ldc_w 422
    //   962: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   965: aload_0
    //   966: getfield 130	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   969: invokevirtual 344	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   972: invokevirtual 292	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   975: invokestatic 277	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   978: aload_0
    //   979: getfield 130	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   982: ifnull +10 -> 992
    //   985: aload_0
    //   986: getfield 130	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   989: invokevirtual 381	android/media/AudioTrack:release	()V
    //   992: aload_0
    //   993: aconst_null
    //   994: putfield 130	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   997: goto -314 -> 683
    //   1000: aload_0
    //   1001: getfield 130	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1004: astore 10
    //   1006: aload 10
    //   1008: ifnull +57 -> 1065
    //   1011: aload_0
    //   1012: getfield 130	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1015: invokevirtual 626	android/media/AudioTrack:play	()V
    //   1018: aload_0
    //   1019: getfield 186	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_as	Lcom/tencent/rtmp/sharp/jni/TraeAudioSession;
    //   1022: aload_0
    //   1023: getfield 156	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   1026: invokevirtual 394	android/media/AudioManager:getMode	()I
    //   1029: aload_0
    //   1030: getfield 134	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   1033: invokevirtual 429	com/tencent/rtmp/sharp/jni/TraeAudioSession:voiceCallAudioParamChanged	(II)I
    //   1036: pop
    //   1037: aload_0
    //   1038: getfield 156	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   1041: astore 10
    //   1043: aload_0
    //   1044: getfield 190	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_connectedDev	Ljava/lang/String;
    //   1047: ldc_w 444
    //   1050: invokevirtual 400	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1053: ifeq +59 -> 1112
    //   1056: bipush 6
    //   1058: istore_2
    //   1059: aload 10
    //   1061: iload_2
    //   1062: invokestatic 448	com/tencent/rtmp/sharp/jni/TraeAudioManager:forceVolumeControlStream	(Landroid/media/AudioManager;I)V
    //   1065: iload_1
    //   1066: istore_2
    //   1067: invokestatic 261	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   1070: ifeq -299 -> 771
    //   1073: ldc 26
    //   1075: iconst_2
    //   1076: new 279	java/lang/StringBuilder
    //   1079: dup
    //   1080: ldc_w 628
    //   1083: invokespecial 284	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1086: invokestatic 598	android/os/SystemClock:elapsedRealtime	()J
    //   1089: lload 8
    //   1091: lsub
    //   1092: invokevirtual 631	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1095: ldc_w 633
    //   1098: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1101: invokevirtual 292	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1104: invokestatic 358	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1107: iload_1
    //   1108: istore_2
    //   1109: goto -338 -> 771
    //   1112: aload_0
    //   1113: getfield 130	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1116: invokevirtual 451	android/media/AudioTrack:getStreamType	()I
    //   1119: istore_2
    //   1120: goto -61 -> 1059
    //   1123: astore 10
    //   1125: invokestatic 261	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   1128: ifeq -63 -> 1065
    //   1131: ldc 26
    //   1133: iconst_2
    //   1134: ldc_w 635
    //   1137: invokestatic 358	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1140: goto -75 -> 1065
    //   1143: aload_0
    //   1144: getfield 130	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1147: aload_0
    //   1148: getfield 245	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_tempBufPlay	[B
    //   1151: iconst_0
    //   1152: iload_1
    //   1153: invokevirtual 638	android/media/AudioTrack:write	([BII)I
    //   1156: istore_2
    //   1157: aload_0
    //   1158: getfield 219	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playBuffer	Ljava/nio/ByteBuffer;
    //   1161: invokevirtual 592	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   1164: pop
    //   1165: iload_2
    //   1166: ifge +56 -> 1222
    //   1169: invokestatic 261	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   1172: ifeq +42 -> 1214
    //   1175: ldc 26
    //   1177: iconst_2
    //   1178: new 279	java/lang/StringBuilder
    //   1181: dup
    //   1182: ldc_w 640
    //   1185: invokespecial 284	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1188: iload_2
    //   1189: invokevirtual 288	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1192: ldc_w 642
    //   1195: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1198: iload_1
    //   1199: invokevirtual 288	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1202: ldc_w 644
    //   1205: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1208: invokevirtual 292	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1211: invokestatic 358	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1214: sipush 13825
    //   1217: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1220: iconst_m1
    //   1221: ireturn
    //   1222: iload_2
    //   1223: iload_1
    //   1224: if_icmpeq +48 -> 1272
    //   1227: invokestatic 261	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   1230: ifeq +42 -> 1272
    //   1233: ldc 26
    //   1235: iconst_2
    //   1236: new 279	java/lang/StringBuilder
    //   1239: dup
    //   1240: ldc_w 646
    //   1243: invokespecial 284	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1246: iload_2
    //   1247: invokevirtual 288	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1250: ldc_w 642
    //   1253: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1256: iload_1
    //   1257: invokevirtual 288	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1260: ldc_w 644
    //   1263: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1266: invokevirtual 292	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1269: invokestatic 358	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1272: aload_0
    //   1273: aload_0
    //   1274: getfield 168	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1277: iload_2
    //   1278: iconst_1
    //   1279: ishr
    //   1280: iadd
    //   1281: putfield 168	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1284: aload_0
    //   1285: getfield 130	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1288: invokevirtual 432	android/media/AudioTrack:getPlaybackHeadPosition	()I
    //   1291: istore_1
    //   1292: iload_1
    //   1293: aload_0
    //   1294: getfield 170	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playPosition	I
    //   1297: if_icmpge +8 -> 1305
    //   1300: aload_0
    //   1301: iconst_0
    //   1302: putfield 170	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playPosition	I
    //   1305: aload_0
    //   1306: aload_0
    //   1307: getfield 168	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1310: iload_1
    //   1311: aload_0
    //   1312: getfield 170	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playPosition	I
    //   1315: isub
    //   1316: isub
    //   1317: putfield 168	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1320: aload_0
    //   1321: iload_1
    //   1322: putfield 170	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playPosition	I
    //   1325: goto -554 -> 771
    //   1328: astore 10
    //   1330: iload_2
    //   1331: istore_1
    //   1332: goto -598 -> 734
    //   1335: iconst_0
    //   1336: istore_3
    //   1337: goto -875 -> 462
    //   1340: astore 10
    //   1342: goto -608 -> 734
    //   1345: iload_3
    //   1346: iconst_1
    //   1347: iadd
    //   1348: istore_3
    //   1349: goto -887 -> 462
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1352	0	this	AudioDeviceInterface
    //   0	1352	1	paramInt	int
    //   14	1317	2	i	int
    //   23	1326	3	j	int
    //   529	159	4	k	int
    //   396	146	5	m	int
    //   542	106	6	n	int
    //   117	6	7	bool	boolean
    //   210	880	8	l	long
    //   97	379	10	localObject1	Object
    //   692	22	10	localException1	Exception
    //   730	26	10	localException2	Exception
    //   779	1	10	localIOException	java.io.IOException
    //   799	9	10	localObject2	Object
    //   913	1	10	localIllegalStateException	IllegalStateException
    //   1004	56	10	localObject3	Object
    //   1123	1	10	localException3	Exception
    //   1328	1	10	localException4	Exception
    //   1340	1	10	localException5	Exception
    //   933	19	11	localException6	Exception
    // Exception table:
    //   from	to	target	type
    //   125	139	692	java/lang/Exception
    //   93	99	730	java/lang/Exception
    //   113	119	730	java/lang/Exception
    //   139	144	730	java/lang/Exception
    //   144	156	730	java/lang/Exception
    //   161	174	730	java/lang/Exception
    //   174	181	730	java/lang/Exception
    //   183	195	730	java/lang/Exception
    //   694	727	730	java/lang/Exception
    //   781	796	730	java/lang/Exception
    //   810	841	730	java/lang/Exception
    //   841	876	730	java/lang/Exception
    //   876	890	730	java/lang/Exception
    //   892	897	730	java/lang/Exception
    //   900	905	730	java/lang/Exception
    //   1143	1157	730	java/lang/Exception
    //   161	174	779	java/io/IOException
    //   93	99	799	finally
    //   113	119	799	finally
    //   125	139	799	finally
    //   139	144	799	finally
    //   144	156	799	finally
    //   161	174	799	finally
    //   174	181	799	finally
    //   183	195	799	finally
    //   199	260	799	finally
    //   260	268	799	finally
    //   273	288	799	finally
    //   288	337	799	finally
    //   337	379	799	finally
    //   379	384	799	finally
    //   384	455	799	finally
    //   467	528	799	finally
    //   558	585	799	finally
    //   585	617	799	finally
    //   617	671	799	finally
    //   671	683	799	finally
    //   694	727	799	finally
    //   736	769	799	finally
    //   781	796	799	finally
    //   810	841	799	finally
    //   841	876	799	finally
    //   876	890	799	finally
    //   892	897	799	finally
    //   900	905	799	finally
    //   915	930	799	finally
    //   935	978	799	finally
    //   978	992	799	finally
    //   992	997	799	finally
    //   1000	1006	799	finally
    //   1011	1056	799	finally
    //   1059	1065	799	finally
    //   1067	1107	799	finally
    //   1112	1120	799	finally
    //   1125	1140	799	finally
    //   1143	1157	799	finally
    //   1157	1165	799	finally
    //   1169	1214	799	finally
    //   1227	1272	799	finally
    //   1272	1305	799	finally
    //   1305	1325	799	finally
    //   273	288	913	java/lang/IllegalStateException
    //   288	337	913	java/lang/IllegalStateException
    //   337	379	913	java/lang/IllegalStateException
    //   379	384	913	java/lang/IllegalStateException
    //   558	585	933	java/lang/Exception
    //   1011	1056	1123	java/lang/Exception
    //   1059	1065	1123	java/lang/Exception
    //   1112	1120	1123	java/lang/Exception
    //   1157	1165	1328	java/lang/Exception
    //   1169	1214	1328	java/lang/Exception
    //   1227	1272	1328	java/lang/Exception
    //   1272	1305	1328	java/lang/Exception
    //   1305	1325	1328	java/lang/Exception
    //   199	260	1340	java/lang/Exception
    //   260	268	1340	java/lang/Exception
    //   273	288	1340	java/lang/Exception
    //   288	337	1340	java/lang/Exception
    //   337	379	1340	java/lang/Exception
    //   379	384	1340	java/lang/Exception
    //   384	455	1340	java/lang/Exception
    //   467	528	1340	java/lang/Exception
    //   585	617	1340	java/lang/Exception
    //   617	671	1340	java/lang/Exception
    //   671	683	1340	java/lang/Exception
    //   915	930	1340	java/lang/Exception
    //   935	978	1340	java/lang/Exception
    //   978	992	1340	java/lang/Exception
    //   992	997	1340	java/lang/Exception
    //   1000	1006	1340	java/lang/Exception
    //   1067	1107	1340	java/lang/Exception
    //   1125	1140	1340	java/lang/Exception
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
    //   3: invokestatic 106	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 162	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   10: ifne +43 -> 53
    //   13: invokestatic 261	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   16: ifeq +29 -> 45
    //   19: ldc 26
    //   21: iconst_2
    //   22: new 279	java/lang/StringBuilder
    //   25: dup
    //   26: ldc_w 667
    //   29: invokespecial 284	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   32: aload_0
    //   33: getfield 162	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   36: invokevirtual 339	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   39: invokevirtual 292	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 358	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: sipush 13827
    //   48: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: iconst_m1
    //   52: ireturn
    //   53: aload_0
    //   54: getfield 132	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   57: astore 5
    //   59: aload 5
    //   61: ifnonnull +12 -> 73
    //   64: sipush 13827
    //   67: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: bipush 254
    //   72: ireturn
    //   73: aload_0
    //   74: getfield 160	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_doRecInit	Z
    //   77: istore 4
    //   79: iload 4
    //   81: iconst_1
    //   82: if_icmpne +22 -> 104
    //   85: bipush 237
    //   87: invokestatic 567	android/os/Process:setThreadPriority	(I)V
    //   90: invokestatic 573	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   93: ldc_w 669
    //   96: invokevirtual 578	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   99: aload_0
    //   100: iconst_0
    //   101: putfield 160	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_doRecInit	Z
    //   104: aload_0
    //   105: getfield 221	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_recBuffer	Ljava/nio/ByteBuffer;
    //   108: invokevirtual 592	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   111: pop
    //   112: aload_0
    //   113: getfield 132	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   116: aload_0
    //   117: getfield 247	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_tempBufRec	[B
    //   120: iconst_0
    //   121: iload_1
    //   122: invokevirtual 672	android/media/AudioRecord:read	([BII)I
    //   125: istore_2
    //   126: iload_2
    //   127: ifge +143 -> 270
    //   130: invokestatic 261	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   133: ifeq +42 -> 175
    //   136: ldc 26
    //   138: iconst_2
    //   139: new 279	java/lang/StringBuilder
    //   142: dup
    //   143: ldc_w 674
    //   146: invokespecial 284	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   149: iload_2
    //   150: invokevirtual 288	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   153: ldc_w 642
    //   156: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: iload_1
    //   160: invokevirtual 288	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   163: ldc_w 644
    //   166: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: invokevirtual 292	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokestatic 358	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   175: sipush 13827
    //   178: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   181: iconst_m1
    //   182: ireturn
    //   183: astore 5
    //   185: invokestatic 261	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   188: ifeq -89 -> 99
    //   191: ldc 26
    //   193: iconst_2
    //   194: new 279	java/lang/StringBuilder
    //   197: dup
    //   198: ldc_w 676
    //   201: invokespecial 284	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   204: aload 5
    //   206: invokevirtual 310	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   209: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 292	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokestatic 277	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   218: goto -119 -> 99
    //   221: astore 5
    //   223: iconst_0
    //   224: istore_2
    //   225: iload_2
    //   226: istore_3
    //   227: invokestatic 261	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   230: ifeq +32 -> 262
    //   233: ldc 26
    //   235: iconst_2
    //   236: new 279	java/lang/StringBuilder
    //   239: dup
    //   240: ldc_w 678
    //   243: invokespecial 284	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   246: aload 5
    //   248: invokevirtual 310	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   251: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: invokevirtual 292	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: invokestatic 358	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   260: iload_2
    //   261: istore_3
    //   262: sipush 13827
    //   265: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   268: iload_3
    //   269: ireturn
    //   270: aload_0
    //   271: getfield 221	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_recBuffer	Ljava/nio/ByteBuffer;
    //   274: aload_0
    //   275: getfield 247	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_tempBufRec	[B
    //   278: iconst_0
    //   279: iload_2
    //   280: invokevirtual 664	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   283: pop
    //   284: getstatic 108	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_dumpEnable	Z
    //   287: ifeq +27 -> 314
    //   290: aload_0
    //   291: getfield 176	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_rec_out	Ljava/io/FileOutputStream;
    //   294: astore 5
    //   296: aload 5
    //   298: ifnull +16 -> 314
    //   301: aload_0
    //   302: getfield 176	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_rec_out	Ljava/io/FileOutputStream;
    //   305: aload_0
    //   306: getfield 247	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_tempBufRec	[B
    //   309: iconst_0
    //   310: iload_2
    //   311: invokevirtual 584	java/io/FileOutputStream:write	([BII)V
    //   314: iload_2
    //   315: istore_3
    //   316: iload_2
    //   317: iload_1
    //   318: if_icmpeq -56 -> 262
    //   321: invokestatic 261	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   324: ifeq +42 -> 366
    //   327: ldc 26
    //   329: iconst_2
    //   330: new 279	java/lang/StringBuilder
    //   333: dup
    //   334: ldc_w 680
    //   337: invokespecial 284	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   340: iload_2
    //   341: invokevirtual 288	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   344: ldc_w 642
    //   347: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: iload_1
    //   351: invokevirtual 288	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   354: ldc_w 644
    //   357: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: invokevirtual 292	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: invokestatic 358	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   366: sipush 13827
    //   369: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   372: iconst_m1
    //   373: ireturn
    //   374: astore 5
    //   376: invokestatic 261	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   379: ifeq -65 -> 314
    //   382: ldc 26
    //   384: iconst_2
    //   385: ldc_w 682
    //   388: invokestatic 358	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   391: goto -77 -> 314
    //   394: astore 5
    //   396: goto -171 -> 225
    //   399: astore 5
    //   401: sipush 13827
    //   404: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   407: aload 5
    //   409: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	410	0	this	AudioDeviceInterface
    //   0	410	1	paramInt	int
    //   125	216	2	i	int
    //   226	90	3	j	int
    //   77	6	4	bool	boolean
    //   57	3	5	localAudioRecord	AudioRecord
    //   183	22	5	localException1	Exception
    //   221	26	5	localException2	Exception
    //   294	3	5	localFileOutputStream	FileOutputStream
    //   374	1	5	localIOException	java.io.IOException
    //   394	1	5	localException3	Exception
    //   399	9	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   85	99	183	java/lang/Exception
    //   53	59	221	java/lang/Exception
    //   73	79	221	java/lang/Exception
    //   99	104	221	java/lang/Exception
    //   104	126	221	java/lang/Exception
    //   185	218	221	java/lang/Exception
    //   301	314	374	java/io/IOException
    //   130	175	394	java/lang/Exception
    //   270	296	394	java/lang/Exception
    //   301	314	394	java/lang/Exception
    //   321	366	394	java/lang/Exception
    //   376	391	394	java/lang/Exception
    //   53	59	399	finally
    //   73	79	399	finally
    //   85	99	399	finally
    //   99	104	399	finally
    //   104	126	399	finally
    //   130	175	399	finally
    //   185	218	399	finally
    //   227	260	399	finally
    //   270	296	399	finally
    //   301	314	399	finally
    //   321	366	399	finally
    //   376	391	399	finally
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
      QLog.w("AudioDeviceInterface", 2, "TraeAudioSession SetAudioOutputMode: ".concat(String.valueOf(paramInt)));
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
      label57:
      paramInt = i;
      if (j < mDeviceList.length)
      {
        paramInt = i;
        if (i == 0)
        {
          if (!"DEVICE_WIREDHEADSET".equals(mDeviceList[j])) {
            break label204;
          }
          this._asAudioManager.connectDevice("DEVICE_WIREDHEADSET");
          paramInt = 1;
        }
      }
      j = 0;
      label102:
      i = paramInt;
      if (j < mDeviceList.length)
      {
        i = paramInt;
        if (paramInt == 0)
        {
          if (!"DEVICE_BLUETOOTHHEADSET".equals(mDeviceList[j])) {
            break label211;
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
              break label218;
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
        label204:
        j += 1;
        break label57;
        label211:
        j += 1;
        break label102;
        label218:
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
    //   5: invokestatic 106	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 164	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   12: ifeq +26 -> 38
    //   15: invokestatic 261	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   18: ifeq +12 -> 30
    //   21: ldc 26
    //   23: iconst_2
    //   24: ldc_w 707
    //   27: invokestatic 358	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   30: sipush 13822
    //   33: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: iconst_m1
    //   37: ireturn
    //   38: aload_0
    //   39: getfield 130	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   42: ifnonnull +43 -> 85
    //   45: invokestatic 261	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   48: ifeq +29 -> 77
    //   51: ldc 26
    //   53: iconst_2
    //   54: new 279	java/lang/StringBuilder
    //   57: dup
    //   58: ldc_w 709
    //   61: invokespecial 284	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   64: aload_0
    //   65: getfield 130	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   68: invokevirtual 344	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 292	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 358	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: sipush 13822
    //   80: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: iconst_m1
    //   84: ireturn
    //   85: aload_0
    //   86: getfield 130	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   89: invokevirtual 626	android/media/AudioTrack:play	()V
    //   92: getstatic 108	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_dumpEnable	Z
    //   95: ifeq +52 -> 147
    //   98: aload_0
    //   99: getfield 156	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   102: ifnull +11 -> 113
    //   105: aload_0
    //   106: getfield 156	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   109: invokevirtual 394	android/media/AudioManager:getMode	()I
    //   112: istore_1
    //   113: aload_0
    //   114: new 711	java/io/File
    //   117: dup
    //   118: aload_0
    //   119: ldc_w 713
    //   122: iload_1
    //   123: invokespecial 717	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:getDumpFilePath	(Ljava/lang/String;I)Ljava/lang/String;
    //   126: invokespecial 718	java/io/File:<init>	(Ljava/lang/String;)V
    //   129: putfield 174	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_play_dump	Ljava/io/File;
    //   132: aload_0
    //   133: new 580	java/io/FileOutputStream
    //   136: dup
    //   137: aload_0
    //   138: getfield 174	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_play_dump	Ljava/io/File;
    //   141: invokespecial 721	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   144: putfield 178	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_play_out	Ljava/io/FileOutputStream;
    //   147: aload_0
    //   148: iconst_1
    //   149: putfield 164	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   152: invokestatic 261	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   155: ifeq +12 -> 167
    //   158: ldc 26
    //   160: iconst_2
    //   161: ldc_w 723
    //   164: invokestatic 277	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   167: sipush 13822
    //   170: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   173: iconst_0
    //   174: ireturn
    //   175: astore_2
    //   176: invokestatic 261	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   179: ifeq +12 -> 191
    //   182: ldc 26
    //   184: iconst_2
    //   185: ldc_w 725
    //   188: invokestatic 358	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   191: sipush 13822
    //   194: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   197: iconst_m1
    //   198: ireturn
    //   199: astore_2
    //   200: invokestatic 261	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   203: ifeq -56 -> 147
    //   206: ldc 26
    //   208: iconst_2
    //   209: ldc_w 727
    //   212: invokestatic 358	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   215: goto -68 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	this	AudioDeviceInterface
    //   1	122	1	i	int
    //   175	1	2	localIllegalStateException	IllegalStateException
    //   199	1	2	localFileNotFoundException	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   85	92	175	java/lang/IllegalStateException
    //   132	147	199	java/io/FileNotFoundException
  }
  
  /* Error */
  private int StartRecording()
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_1
    //   2: sipush 13821
    //   5: invokestatic 106	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 261	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   11: ifeq +12 -> 23
    //   14: ldc 26
    //   16: iconst_2
    //   17: ldc_w 730
    //   20: invokestatic 277	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   23: aload_0
    //   24: getfield 162	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   27: ifeq +43 -> 70
    //   30: invokestatic 261	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   33: ifeq +29 -> 62
    //   36: ldc 26
    //   38: iconst_2
    //   39: new 279	java/lang/StringBuilder
    //   42: dup
    //   43: ldc_w 732
    //   46: invokespecial 284	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   49: aload_0
    //   50: getfield 162	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   53: invokevirtual 339	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   56: invokevirtual 292	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokestatic 358	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   62: sipush 13821
    //   65: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: iconst_m1
    //   69: ireturn
    //   70: aload_0
    //   71: getfield 132	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   74: ifnonnull +43 -> 117
    //   77: invokestatic 261	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   80: ifeq +29 -> 109
    //   83: ldc 26
    //   85: iconst_2
    //   86: new 279	java/lang/StringBuilder
    //   89: dup
    //   90: ldc_w 734
    //   93: invokespecial 284	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   96: aload_0
    //   97: getfield 132	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   100: invokevirtual 344	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 292	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokestatic 358	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   109: sipush 13821
    //   112: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: iconst_m1
    //   116: ireturn
    //   117: aload_0
    //   118: getfield 132	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   121: invokevirtual 737	android/media/AudioRecord:startRecording	()V
    //   124: getstatic 108	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_dumpEnable	Z
    //   127: ifeq +52 -> 179
    //   130: aload_0
    //   131: getfield 156	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   134: ifnull +11 -> 145
    //   137: aload_0
    //   138: getfield 156	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   141: invokevirtual 394	android/media/AudioManager:getMode	()I
    //   144: istore_1
    //   145: aload_0
    //   146: new 711	java/io/File
    //   149: dup
    //   150: aload_0
    //   151: ldc_w 739
    //   154: iload_1
    //   155: invokespecial 717	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:getDumpFilePath	(Ljava/lang/String;I)Ljava/lang/String;
    //   158: invokespecial 718	java/io/File:<init>	(Ljava/lang/String;)V
    //   161: putfield 172	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_rec_dump	Ljava/io/File;
    //   164: aload_0
    //   165: new 580	java/io/FileOutputStream
    //   168: dup
    //   169: aload_0
    //   170: getfield 172	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_rec_dump	Ljava/io/File;
    //   173: invokespecial 721	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   176: putfield 176	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_rec_out	Ljava/io/FileOutputStream;
    //   179: aload_0
    //   180: iconst_1
    //   181: putfield 162	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   184: invokestatic 261	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   187: ifeq +12 -> 199
    //   190: ldc 26
    //   192: iconst_2
    //   193: ldc_w 741
    //   196: invokestatic 277	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   199: sipush 13821
    //   202: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   205: iconst_0
    //   206: ireturn
    //   207: astore_2
    //   208: invokestatic 261	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   211: ifeq +12 -> 223
    //   214: ldc 26
    //   216: iconst_2
    //   217: ldc_w 743
    //   220: invokestatic 358	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   223: sipush 13821
    //   226: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   229: iconst_m1
    //   230: ireturn
    //   231: astore_2
    //   232: invokestatic 261	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   235: ifeq -56 -> 179
    //   238: ldc 26
    //   240: iconst_2
    //   241: ldc_w 745
    //   244: invokestatic 358	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   247: goto -68 -> 179
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	250	0	this	AudioDeviceInterface
    //   1	154	1	i	int
    //   207	1	2	localIllegalStateException	IllegalStateException
    //   231	1	2	localFileNotFoundException	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   117	124	207	java/lang/IllegalStateException
    //   164	179	231	java/io/FileNotFoundException
  }
  
  private int StopPlayback()
  {
    AppMethodBeat.i(13824);
    if (QLog.isColorLevel()) {
      QLog.w("AudioDeviceInterface", 2, "StopPlayback entry _isPlaying:" + this._isPlaying);
    }
    if (this._audioTrack == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AudioDeviceInterface", 2, "StopPlayback _isPlaying:" + this._isPlaying + " " + this._audioTrack);
      }
      AppMethodBeat.o(13824);
      return -1;
    }
    if (this._audioTrack.getPlayState() == 3) {}
    try
    {
      if (QLog.isColorLevel()) {
        QLog.w("AudioDeviceInterface", 2, "StopPlayback stoping...");
      }
      this._audioTrack.stop();
      if (QLog.isColorLevel()) {
        QLog.w("AudioDeviceInterface", 2, "StopPlayback flushing... state:" + this._audioTrack.getPlayState());
      }
      this._audioTrack.flush();
      if (QLog.isColorLevel()) {
        QLog.w("AudioDeviceInterface", 2, "StopPlayback releaseing... state:" + this._audioTrack.getPlayState());
      }
      this._audioTrack.release();
      this._audioTrack = null;
      this._isPlaying = false;
      if (QLog.isColorLevel()) {
        QLog.w("AudioDeviceInterface", 2, "StopPlayback exit ok");
      }
      AppMethodBeat.o(13824);
      return 0;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AudioDeviceInterface", 2, "StopPlayback err");
      }
      AppMethodBeat.o(13824);
    }
    return -1;
  }
  
  private int StopRecording()
  {
    AppMethodBeat.i(13823);
    if (QLog.isColorLevel()) {
      QLog.w("AudioDeviceInterface", 2, "StopRecording entry");
    }
    if (this._audioRecord == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AudioDeviceInterface", 2, "UnintRecord:" + this._audioRecord);
      }
      AppMethodBeat.o(13823);
      return -1;
    }
    if (this._audioRecord.getRecordingState() == 3) {}
    try
    {
      if (QLog.isColorLevel()) {
        QLog.w("AudioDeviceInterface", 2, "StopRecording stop... state:" + this._audioRecord.getRecordingState());
      }
      this._audioRecord.stop();
      if (QLog.isColorLevel()) {
        QLog.w("AudioDeviceInterface", 2, "StopRecording releaseing... state:" + this._audioRecord.getRecordingState());
      }
      this._audioRecord.release();
      this._audioRecord = null;
      this._isRecording = false;
      if (QLog.isColorLevel()) {
        QLog.w("AudioDeviceInterface", 2, "StopRecording exit ok");
      }
      AppMethodBeat.o(13823);
      return 0;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AudioDeviceInterface", 2, "StopRecording  err");
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
      QLog.w("AudioDeviceInterface", 2, "getDecBuffer failed!! index:".concat(String.valueOf(paramInt)));
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
      QLog.w("AudioDeviceInterface", 2, "manufacture:" + Build.MANUFACTURER);
    }
    if (QLog.isColorLevel()) {
      QLog.w("AudioDeviceInterface", 2, "MODEL:" + Build.MODEL);
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
      QLog.w("AudioDeviceInterface", 2, "dump:".concat(String.valueOf(paramString)));
    }
    if (QLog.isColorLevel()) {
      QLog.w("AudioDeviceInterface", 2, "dump replace:" + paramString.replace(" ", "_"));
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
        QLog.e("AudioDeviceInterface", 2, "getLowlatencySamplerate err, _context:" + this._context + " api:" + Build.VERSION.SDK_INT);
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
        break label158;
      }
    }
    label158:
    for (String str = "Y";; str = "N")
    {
      QLog.w("AudioDeviceInterface", 2, str);
      if (Build.VERSION.SDK_INT >= 17) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.e("AudioDeviceInterface", 2, "API Level too low not support PROPERTY_OUTPUT_SAMPLE_RATE");
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
        QLog.e("AudioDeviceInterface", 2, "getLowlatencySamplerate err, _context:" + this._context + " api:" + Build.VERSION.SDK_INT);
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
        break label158;
      }
    }
    label158:
    for (String str = "Y";; str = "N")
    {
      QLog.w("AudioDeviceInterface", 2, str);
      if (Build.VERSION.SDK_INT >= 17) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.e("AudioDeviceInterface", 2, "API Level too low not support PROPERTY_OUTPUT_SAMPLE_RATE");
      }
      AppMethodBeat.o(13815);
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.e("AudioDeviceInterface", 2, "getLowlatencySamplerate not support right now!");
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
        QLog.w("AudioDeviceInterface", 2, "initTRAEAudioManager , TraeAudioSession create");
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
        QLog.w("AudioDeviceInterface", 2, "hardcode FEATURE_AUDIO_LOW_LATENCY: " + Build.MANUFACTURER + "_" + Build.MODEL);
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
      QLog.w("AudioDeviceInterface", 2, " onOutputChanage:".concat(String.valueOf(paramString)));
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
        break label280;
      }
      localObject = " am==null";
      localStringBuilder = localStringBuilder.append((String)localObject).append(" st:").append(this._streamType);
      if (this._audioTrack != null) {
        break label307;
      }
      localObject = "_audioTrack==null";
      label156:
      QLog.w("AudioDeviceInterface", 2, (String)localObject);
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
          QLog.w("AudioDeviceInterface", 2, paramString);
        }
        if ((this._audioManager != null) && (this._connectedDev.equals("DEVICE_SPEAKERPHONE"))) {
          this._audioManager.setMode(0);
        }
      }
      catch (Exception paramString)
      {
        label280:
        label307:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("AudioDeviceInterface", 2, paramString.getMessage());
        continue;
      }
      this._audioRouteChanged = true;
      AppMethodBeat.o(13833);
      return;
      localObject = " mode:" + this._audioManager.getMode();
      break;
      localObject = " at.st:" + this._audioTrack.getStreamType();
      break label156;
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
      QLog.w("AudioDeviceInterface", 2, "initTRAEAudioManager , TraeAudioSession startService: " + this._asAudioManager + " deviceConfig:" + paramString);
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
      QLog.w("AudioDeviceInterface", 2, "initTRAEAudioManager , TraeAudioSession stopService: " + this._asAudioManager);
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
        QLog.w("AudioDeviceInterface", 2, "uninitTRAEAudioManager , stopService");
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
      QLog.w("AudioDeviceInterface", 2, "uninitTRAEAudioManager , context null");
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
                QLog.e("AudioDeviceInterface", 2, "onServiceStateUpdate signalAll");
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
              QLog.e("AudioDeviceInterface", 2, "onVoicecallPreprocessRes signalAll");
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
    label382:
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
                QLog.e("AudioDeviceInterface", 2, "call_preprocess waiting...  mode:" + this._audioManager.getMode());
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
              QLog.e("AudioDeviceInterface", 2, "media call_preprocess setMicrophoneMute false");
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
            break label382;
          }
          QLog.e("AudioDeviceInterface", 2, "call_preprocess waiting...  as:" + this._as);
          i = j;
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.e("AudioDeviceInterface", 2, "call_preprocess done!");
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
              QLog.e("AudioDeviceInterface", 2, "media call_preprocess_media waiting...  mode:" + this._audioManager.getMode());
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
            QLog.e("AudioDeviceInterface", 2, "media call_preprocess_media setMicrophoneMute false");
          }
        }
      }
      this._as.connectHighestPriorityDevice();
      this._as.getConnectedDevice();
      if (QLog.isColorLevel()) {
        QLog.e("AudioDeviceInterface", 2, "call_preprocess_media done!");
      }
      label282:
      LogTraceExit();
    }
    catch (InterruptedException localInterruptedException)
    {
      break label282;
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
                  QLog.w("AudioDeviceInterface", 2, "checkAACSupported support!, " + arrayOfString1.getName());
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
                QLog.w("AudioDeviceInterface", 2, "checkAACSupported support!, " + ((MediaCodecInfo)localObject).getName());
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
        QLog.e("AudioDeviceInterface", 2, "check if support aac codec failed.");
      }
      if (QLog.isColorLevel()) {
        QLog.e("AudioDeviceInterface", 2, "Error when checking aac codec availability");
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
      QLog.w("AudioDeviceInterface", 2, "checkAACSupported isSupportEncoder: " + i + ", isSupportDecoder:" + j);
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
    AppMethodBeat.i(217799);
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
    AppMethodBeat.o(217799);
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
          QLog.w("AudioDeviceInterface", 2, "not hasLightSensorManager null == sensor8");
        }
        AppMethodBeat.o(13844);
        return 0;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("AudioDeviceInterface", 2, localException.getMessage());
      }
      AppMethodBeat.o(13844);
      return 1;
    }
    if (QLog.isColorLevel()) {
      QLog.w("AudioDeviceInterface", 2, "hasLightSensorManager");
    }
    AppMethodBeat.o(13844);
    return 1;
  }
  
  public int isBackground()
  {
    AppMethodBeat.i(217801);
    if (this._context == null)
    {
      AppMethodBeat.o(217801);
      return 0;
    }
    try
    {
      Object localObject = (ActivityManager)this._context.getSystemService("activity");
      if (((ActivityManager)localObject).getRunningTasks(1) == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AudioDeviceInterface", 2, "running task is null, ams is abnormal!!!");
        }
        AppMethodBeat.o(217801);
        return 0;
      }
      localObject = (ActivityManager.RunningTaskInfo)((ActivityManager)localObject).getRunningTasks(1).get(0);
      if ((localObject == null) || (((ActivityManager.RunningTaskInfo)localObject).topActivity == null))
      {
        if (QLog.isColorLevel()) {
          QLog.e("AudioDeviceInterface", 2, "failed to get RunningTaskInfo");
        }
        AppMethodBeat.o(217801);
        return 0;
      }
      boolean bool = ((ActivityManager.RunningTaskInfo)localObject).topActivity.getPackageName().equals(this._context.getPackageName());
      if (!bool) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(217801);
        return 1;
      }
      AppMethodBeat.o(217801);
      return 0;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE isBackground", 2, localException.getMessage());
      }
      AppMethodBeat.o(217801);
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
        QLog.w("AudioDeviceInterface", 2, "setJavaInterface flg:".concat(String.valueOf(paramInt)));
      }
      AppMethodBeat.o(13838);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.AudioDeviceInterface
 * JD-Core Version:    0.7.0.1
 */