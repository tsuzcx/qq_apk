package com.tencent.rtmp.sharp.jni;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
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
import android.os.Environment;
import com.tencent.d.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
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
    AppMethodBeat.i(146978);
    _dumpEnable = false;
    _logEnable = true;
    mDeviceList = null;
    mVivoKTVHelper = null;
    isSupportVivoKTVHelper = false;
    CPU_FILTER = new AudioDeviceInterface.4();
    AppMethodBeat.o(146978);
  }
  
  public AudioDeviceInterface()
  {
    AppMethodBeat.i(65760);
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
      a.dUd();
      a.iP("TRAE", "AudioDeviceInterface apiLevel:".concat(String.valueOf(i)));
      a.dUd();
      a.iP("TRAE", " SDK_INT:" + Build.VERSION.SDK_INT);
      a.dUd();
      a.iP("TRAE", "manufacture:" + Build.MANUFACTURER);
      a.dUd();
      a.iP("TRAE", "MODEL:" + Build.MODEL);
      AppMethodBeat.o(65760);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        a.dUd();
        a.iP("TRAE", localException.getMessage());
      }
    }
  }
  
  private int CloseMp3File(int paramInt)
  {
    AppMethodBeat.i(146970);
    TraeAudioCodecList.a locala = this._traeAudioCodecList.find(paramInt);
    if (locala != null)
    {
      locala.b.release();
      locala.b = null;
      this._traeAudioCodecList.remove(paramInt);
      AppMethodBeat.o(146970);
      return 0;
    }
    AppMethodBeat.o(146970);
    return -1;
  }
  
  private int EnableVivoKTVLoopback(int paramInt)
  {
    AppMethodBeat.i(146965);
    a.dUd();
    a.iP("TRAE", "EnableVivoKTVLoopback: " + paramInt + " isSupportVivoKTVHelper:" + isSupportVivoKTVHelper + " mVivoKTVHelper:" + mVivoKTVHelper);
    if ((mVivoKTVHelper != null) && (isSupportVivoKTVHelper))
    {
      mVivoKTVHelper.setPlayFeedbackParam(paramInt);
      AppMethodBeat.o(146965);
      return 0;
    }
    AppMethodBeat.o(146965);
    return -1;
  }
  
  private int GetPlayoutVolume()
  {
    AppMethodBeat.i(65775);
    if ((this._audioManager == null) && (this._context != null)) {
      this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
    }
    int i = -1;
    if (this._audioManager != null) {
      i = this._audioManager.getStreamVolume(0);
    }
    AppMethodBeat.o(65775);
    return i;
  }
  
  private int InitPlayback(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(65765);
    a.dUd();
    a.iP("TRAE", "InitPlayback entry: sampleRate ".concat(String.valueOf(paramInt1)));
    if ((this._isPlaying) || (this._audioTrack != null) || (paramInt2 > 2))
    {
      a.dUd();
      a.iO("TRAE", "InitPlayback _isPlaying:" + this._isPlaying);
      AppMethodBeat.o(65765);
      return -1;
    }
    if (this._audioManager == null) {}
    label910:
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
            a.dUd();
            a.iP("TRAE", "InitPlayback, _channelOutType stero");
          }
          int j = paramInt1 * 20 * 1 * 2 / 1000;
          if (this._channelOutType != 12) {
            break label910;
          }
          j *= 2;
          a.dUd();
          a.iP("TRAE", "InitPlayback: minPlayBufSize:" + i1 + " 20msFz:" + j);
          this._bufferedPlaySamples = 0;
          if (this._audioTrack != null)
          {
            this._audioTrack.release();
            this._audioTrack = null;
          }
          int[] arrayOfInt = new int[4];
          tmp255_253 = arrayOfInt;
          tmp255_253[0] = 0;
          tmp259_255 = tmp255_253;
          tmp259_255[1] = 0;
          tmp263_259 = tmp259_255;
          tmp263_259[2] = 3;
          tmp267_263 = tmp263_259;
          tmp267_263[3] = 1;
          tmp267_263;
          this._streamType = TraeAudioManager.getAudioStreamType(this._audioStreamTypePolicy);
          if (this._audioRouteChanged)
          {
            a.dUd();
            a.iP("TRAE", "_audioRouteChanged:" + this._audioRouteChanged + " _streamType:" + this._streamType);
            if ((this._audioManager.getMode() != 0) || (!this._connectedDev.equals("DEVICE_SPEAKERPHONE"))) {
              break label630;
            }
            this._streamType = 3;
            this._audioRouteChanged = false;
          }
          arrayOfInt[0] = this._streamType;
          k = 0;
          i = i1;
          if ((k >= 4) || (this._audioTrack != null)) {
            break label712;
          }
          this._streamType = arrayOfInt[k];
          a.dUd();
          a.iP("TRAE", "InitPlayback: min play buf size is " + i1 + " hw_sr:" + AudioTrack.getNativeOutputSampleRate(this._streamType));
          m = 1;
          if (m > 2) {
            break label703;
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
        a.dUd();
        a.iP("TRAE", localException1.getMessage());
        AppMethodBeat.o(65765);
        return -1;
      }
      try
      {
        this.nPlayLengthMs = (n * 500 / (paramInt1 * paramInt2));
        this._audioTrack = new AudioTrack(this._streamType, this._playSamplerate, this._channelOutType, 2, n, 1);
        i = n;
        if (this._audioTrack.getState() == 1) {
          break label703;
        }
        a.dUd();
        a.iP("TRAE", "InitPlayback: play not initialized playBufSize:" + n + " sr:" + this._playSamplerate);
        this._audioTrack.release();
        this._audioTrack = null;
      }
      catch (Exception localException2)
      {
        a.dUd();
        a.iP("TRAE", localException2.getMessage() + " _audioTrack:" + this._audioTrack);
        if (this._audioTrack == null) {
          break label695;
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
      label630:
      this._streamType = 0;
      continue;
      label695:
      label703:
      k += 1;
      continue;
      label712:
      if (this._audioTrack == null)
      {
        a.dUd();
        a.iP("TRAE", "InitPlayback fail!!!");
        AppMethodBeat.o(65765);
        return -1;
      }
      if ((this._as != null) && (this._audioManager != null)) {
        this._as.voiceCallAudioParamChanged(this._audioManager.getMode(), this._streamType);
      }
      this._playPosition = this._audioTrack.getPlaybackHeadPosition();
      a.dUd();
      a.iP("TRAE", "InitPlayback exit: streamType:" + this._streamType + " samplerate:" + this._playSamplerate + " _playPosition:" + this._playPosition + " playBufSize:" + i + " nPlayLengthMs:" + this.nPlayLengthMs);
      AudioManager localAudioManager = this._audioManager;
      if (this._connectedDev.equals("DEVICE_BLUETOOTHHEADSET")) {}
      for (paramInt1 = 6;; paramInt1 = this._audioTrack.getStreamType())
      {
        TraeAudioManager.forceVolumeControlStream(localAudioManager, paramInt1);
        AppMethodBeat.o(65765);
        return 0;
      }
    }
  }
  
  private int InitRecording(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(65764);
    a.dUd();
    a.iP("TRAE", "InitRecording entry:".concat(String.valueOf(paramInt1)));
    if ((this._isRecording) || (this._audioRecord != null) || (paramInt2 > 2))
    {
      a.dUd();
      a.iO("TRAE", "InitRecording _isRecording:" + this._isRecording);
      AppMethodBeat.o(65764);
      return -1;
    }
    int j = 16;
    if (paramInt2 == 2) {
      j = 12;
    }
    int i1 = AudioRecord.getMinBufferSize(paramInt1, j, 2);
    int i2 = paramInt1 * 20 * paramInt2 * 2 / 1000;
    a.dUd();
    a.iP("TRAE", "InitRecording: min rec buf size is " + i1 + " sr:" + getLowlatencySamplerate() + " fp" + getLowlatencyFramesPerBuffer() + " 20msFZ:" + i2);
    this._bufferedRecSamples = (paramInt1 * 5 / 200);
    a.dUd();
    a.iP("TRAE", "  rough rec delay set to " + this._bufferedRecSamples);
    if (this._audioRecord != null)
    {
      this._audioRecord.release();
      this._audioRecord = null;
    }
    int[] arrayOfInt = new int[4];
    int[] tmp251_249 = arrayOfInt;
    tmp251_249[0] = 0;
    int[] tmp255_251 = tmp251_249;
    tmp255_251[1] = 1;
    int[] tmp259_255 = tmp255_251;
    tmp259_255[2] = 5;
    int[] tmp263_259 = tmp259_255;
    tmp263_259[3] = 0;
    tmp263_259;
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
          break label527;
        }
        int n = i1 * m;
        if ((n >= i2 * 4) || (m >= 2)) {}
        try
        {
          this.nRecordLengthMs = (n * 500 / (paramInt1 * paramInt2));
          this._audioRecord = new AudioRecord(this._audioSource, paramInt1, j, 2, n);
          i = n;
          if (this._audioRecord.getState() == 1) {
            break label527;
          }
          a.dUd();
          a.iP("TRAE", "InitRecording:  rec not initialized,try agine,  minbufsize:" + n + " sr:" + paramInt1 + " as:" + this._audioSource);
          this._audioRecord.release();
          this._audioRecord = null;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            a.dUd();
            a.iP("TRAE", localException.getMessage() + " _audioRecord:" + this._audioRecord);
            if (this._audioRecord != null) {
              this._audioRecord.release();
            }
            this._audioRecord = null;
          }
        }
        m += 1;
        i = n;
      }
      label527:
      k += 1;
    }
    if (this._audioRecord == null)
    {
      a.dUd();
      a.iP("TRAE", "InitRecording fail!!!");
      AppMethodBeat.o(65764);
      return -1;
    }
    a.dUd();
    a.iP("TRAE", " [Config] InitRecording: audioSession:" + this._sessionId + " audioSource:" + this._audioSource + " rec sample rate set to " + paramInt1 + " recBufSize:" + i + " nRecordLengthMs:" + this.nRecordLengthMs);
    a.dUd();
    a.iP("TRAE", "InitRecording exit");
    paramInt1 = this._bufferedRecSamples;
    AppMethodBeat.o(65764);
    return paramInt1;
  }
  
  private int InitSetting(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(146956);
    this._audioSourcePolicy = paramInt1;
    this._audioStreamTypePolicy = paramInt2;
    this._modePolicy = paramInt3;
    this._deviceStat = paramInt4;
    this._sceneMode = paramInt5;
    if ((this._deviceStat == 1) || (this._deviceStat == 5) || (this._deviceStat == 2) || (this._deviceStat == 3))
    {
      TraeAudioManager.IsMusicScene = true;
      if ((this._sceneMode != 0) && (this._sceneMode != 4)) {
        break label186;
      }
    }
    label186:
    for (TraeAudioManager.IsEarPhoneSupported = true;; TraeAudioManager.IsEarPhoneSupported = false)
    {
      TraeAudioManager.IsUpdateSceneFlag = true;
      a.dUd();
      a.iP("TRAE", "InitSetting: _audioSourcePolicy:" + this._audioSourcePolicy + " _audioStreamTypePolicy:" + this._audioStreamTypePolicy + " _modePolicy:" + this._modePolicy + " DeviceStat:" + paramInt4 + " isSupportVivoKTVHelper:" + isSupportVivoKTVHelper);
      AppMethodBeat.o(146956);
      return 0;
      TraeAudioManager.IsMusicScene = false;
      break;
    }
  }
  
  public static final void LogTraceEntry(String paramString)
  {
    AppMethodBeat.i(65777);
    if (!_logEnable)
    {
      AppMethodBeat.o(65777);
      return;
    }
    paramString = getTraceInfo() + " entry:" + paramString;
    a.dUd();
    a.iP("TRAE", paramString);
    AppMethodBeat.o(65777);
  }
  
  public static final void LogTraceExit()
  {
    AppMethodBeat.i(65778);
    if (!_logEnable)
    {
      AppMethodBeat.o(65778);
      return;
    }
    String str = getTraceInfo() + " exit";
    a.dUd();
    a.iP("TRAE", str);
    AppMethodBeat.o(65778);
  }
  
  private int OpenMp3File(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(146967);
    if (this._traeAudioCodecList.find(paramInt1) == null)
    {
      TraeAudioCodecList.a locala = this._traeAudioCodecList.add(paramInt1);
      locala.b.setIOPath(paramString);
      locala.b.setIndex(paramInt1);
      paramInt2 = locala.b.prepare(paramInt2);
      if (paramInt2 != 0)
      {
        a.dUd();
        a.iP("TRAE", "openFile mp3 Failed!!!");
        locala.b.release();
        locala.b = null;
        this._traeAudioCodecList.remove(paramInt1);
        AppMethodBeat.o(146967);
        return paramInt2;
      }
      AppMethodBeat.o(146967);
      return 0;
    }
    AppMethodBeat.o(146967);
    return -1;
  }
  
  private int OpenslesNeedResetAudioTrack(boolean paramBoolean)
  {
    AppMethodBeat.i(65772);
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
        a.dUd();
        a.iO("TRAE", "PlayAudio Exception: " + localException.getMessage());
        continue;
      }
      finally
      {
        AppMethodBeat.o(65772);
      }
      i = this._audioStreamTypePolicy;
      AppMethodBeat.o(65772);
      return i;
      this._audioStreamTypePolicy = 0;
    }
  }
  
  /* Error */
  private int PlayAudio(int paramInt)
  {
    // Byte code:
    //   0: ldc_w 566
    //   3: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 157	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   10: ifne +71 -> 81
    //   13: iconst_1
    //   14: istore_2
    //   15: aload_0
    //   16: getfield 123	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   19: ifnonnull +67 -> 86
    //   22: iconst_1
    //   23: istore_3
    //   24: iload_2
    //   25: iload_3
    //   26: ior
    //   27: ifeq +64 -> 91
    //   30: invokestatic 254	com/tencent/d/a/a/a:dUd	()Z
    //   33: pop
    //   34: ldc_w 256
    //   37: new 274	java/lang/StringBuilder
    //   40: dup
    //   41: ldc_w 568
    //   44: invokespecial 279	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   47: aload_0
    //   48: getfield 157	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   51: invokevirtual 336	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   54: ldc_w 570
    //   57: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: aload_0
    //   61: getfield 123	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   64: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 287	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokestatic 372	com/tencent/d/a/a/a:iO	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: ldc_w 566
    //   76: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   79: iconst_m1
    //   80: ireturn
    //   81: iconst_0
    //   82: istore_2
    //   83: goto -68 -> 15
    //   86: iconst_0
    //   87: istore_3
    //   88: goto -64 -> 24
    //   91: aload_0
    //   92: getfield 123	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   95: astore 10
    //   97: aload 10
    //   99: ifnonnull +12 -> 111
    //   102: ldc_w 566
    //   105: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   108: bipush 254
    //   110: ireturn
    //   111: aload_0
    //   112: getfield 151	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_doPlayInit	Z
    //   115: istore 7
    //   117: iload 7
    //   119: iconst_1
    //   120: if_icmpne +22 -> 142
    //   123: bipush 237
    //   125: invokestatic 575	android/os/Process:setThreadPriority	(I)V
    //   128: invokestatic 581	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   131: ldc_w 583
    //   134: invokevirtual 586	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   137: aload_0
    //   138: iconst_0
    //   139: putfield 151	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_doPlayInit	Z
    //   142: getstatic 98	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_dumpEnable	Z
    //   145: ifeq +27 -> 172
    //   148: aload_0
    //   149: getfield 171	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_play_out	Ljava/io/FileOutputStream;
    //   152: astore 10
    //   154: aload 10
    //   156: ifnull +16 -> 172
    //   159: aload_0
    //   160: getfield 171	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_play_out	Ljava/io/FileOutputStream;
    //   163: aload_0
    //   164: getfield 238	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_tempBufPlay	[B
    //   167: iconst_0
    //   168: iconst_0
    //   169: invokevirtual 592	java/io/FileOutputStream:write	([BII)V
    //   172: aload_0
    //   173: getfield 185	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioRouteChanged	Z
    //   176: ifne +579 -> 755
    //   179: iconst_0
    //   180: istore_2
    //   181: aload_0
    //   182: getfield 212	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playBuffer	Ljava/nio/ByteBuffer;
    //   185: aload_0
    //   186: getfield 238	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_tempBufPlay	[B
    //   189: invokevirtual 596	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   192: pop
    //   193: iload_2
    //   194: ifeq +875 -> 1069
    //   197: aload_0
    //   198: getfield 212	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playBuffer	Ljava/nio/ByteBuffer;
    //   201: invokevirtual 600	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   204: pop
    //   205: invokestatic 606	android/os/SystemClock:elapsedRealtime	()J
    //   208: lstore 8
    //   210: invokestatic 254	com/tencent/d/a/a/a:dUd	()Z
    //   213: pop
    //   214: ldc_w 256
    //   217: new 274	java/lang/StringBuilder
    //   220: dup
    //   221: ldc_w 608
    //   224: invokespecial 279	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   227: aload_0
    //   228: getfield 127	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   231: invokevirtual 283	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   234: ldc_w 610
    //   237: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: aload_0
    //   241: getfield 123	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   244: invokevirtual 452	android/media/AudioTrack:getStreamType	()I
    //   247: invokevirtual 283	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   250: invokevirtual 287	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: invokestatic 272	com/tencent/d/a/a/a:iP	(Ljava/lang/String;Ljava/lang/String;)V
    //   256: aload_0
    //   257: getfield 123	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   260: invokevirtual 613	android/media/AudioTrack:getPlayState	()I
    //   263: istore_2
    //   264: iload_2
    //   265: iconst_3
    //   266: if_icmpne +108 -> 374
    //   269: invokestatic 254	com/tencent/d/a/a/a:dUd	()Z
    //   272: pop
    //   273: ldc_w 256
    //   276: ldc_w 615
    //   279: invokestatic 272	com/tencent/d/a/a/a:iP	(Ljava/lang/String;Ljava/lang/String;)V
    //   282: aload_0
    //   283: getfield 123	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   286: invokevirtual 618	android/media/AudioTrack:stop	()V
    //   289: aload_0
    //   290: getfield 123	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   293: invokevirtual 621	android/media/AudioTrack:flush	()V
    //   296: invokestatic 254	com/tencent/d/a/a/a:dUd	()Z
    //   299: pop
    //   300: ldc_w 256
    //   303: new 274	java/lang/StringBuilder
    //   306: dup
    //   307: ldc_w 623
    //   310: invokespecial 279	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   313: aload_0
    //   314: getfield 123	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   317: invokevirtual 613	android/media/AudioTrack:getPlayState	()I
    //   320: invokevirtual 283	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   323: invokevirtual 287	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   326: invokestatic 272	com/tencent/d/a/a/a:iP	(Ljava/lang/String;Ljava/lang/String;)V
    //   329: aload_0
    //   330: getfield 123	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   333: invokevirtual 385	android/media/AudioTrack:release	()V
    //   336: invokestatic 254	com/tencent/d/a/a/a:dUd	()Z
    //   339: pop
    //   340: ldc_w 256
    //   343: new 274	java/lang/StringBuilder
    //   346: dup
    //   347: ldc_w 625
    //   350: invokespecial 279	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   353: aload_0
    //   354: getfield 123	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   357: invokevirtual 613	android/media/AudioTrack:getPlayState	()I
    //   360: invokevirtual 283	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   363: invokevirtual 287	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   366: invokestatic 272	com/tencent/d/a/a/a:iP	(Ljava/lang/String;Ljava/lang/String;)V
    //   369: aload_0
    //   370: aconst_null
    //   371: putfield 123	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   374: aload_0
    //   375: getfield 129	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playSamplerate	I
    //   378: aload_0
    //   379: getfield 131	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_channelOutType	I
    //   382: iconst_2
    //   383: invokestatic 378	android/media/AudioTrack:getMinBufferSize	(III)I
    //   386: istore 5
    //   388: iconst_4
    //   389: newarray int
    //   391: astore 10
    //   393: aload 10
    //   395: dup
    //   396: iconst_0
    //   397: iconst_0
    //   398: iastore
    //   399: dup
    //   400: iconst_1
    //   401: iconst_0
    //   402: iastore
    //   403: dup
    //   404: iconst_2
    //   405: iconst_3
    //   406: iastore
    //   407: dup
    //   408: iconst_3
    //   409: iconst_1
    //   410: iastore
    //   411: pop
    //   412: aload 10
    //   414: iconst_0
    //   415: aload_0
    //   416: getfield 127	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   419: iastore
    //   420: aload_0
    //   421: getfield 129	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playSamplerate	I
    //   424: bipush 20
    //   426: imul
    //   427: iconst_1
    //   428: imul
    //   429: iconst_2
    //   430: imul
    //   431: sipush 1000
    //   434: idiv
    //   435: istore_2
    //   436: aload_0
    //   437: getfield 131	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_channelOutType	I
    //   440: bipush 12
    //   442: if_icmpne +827 -> 1269
    //   445: iload_2
    //   446: iconst_2
    //   447: imul
    //   448: istore_2
    //   449: goto +820 -> 1269
    //   452: iload_3
    //   453: iconst_4
    //   454: if_icmpge +498 -> 952
    //   457: aload_0
    //   458: getfield 123	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   461: ifnonnull +491 -> 952
    //   464: aload_0
    //   465: aload 10
    //   467: iload_3
    //   468: iaload
    //   469: putfield 127	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   472: invokestatic 254	com/tencent/d/a/a/a:dUd	()Z
    //   475: pop
    //   476: ldc_w 256
    //   479: new 274	java/lang/StringBuilder
    //   482: dup
    //   483: ldc_w 405
    //   486: invokespecial 279	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   489: iload 5
    //   491: invokevirtual 283	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   494: ldc_w 407
    //   497: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: aload_0
    //   501: getfield 127	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   504: invokestatic 410	android/media/AudioTrack:getNativeOutputSampleRate	(I)I
    //   507: invokevirtual 283	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   510: invokevirtual 287	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   513: invokestatic 272	com/tencent/d/a/a/a:iP	(Ljava/lang/String;Ljava/lang/String;)V
    //   516: iconst_1
    //   517: istore 4
    //   519: iload 4
    //   521: iconst_2
    //   522: if_icmpgt +757 -> 1279
    //   525: iload 5
    //   527: iload 4
    //   529: imul
    //   530: istore 6
    //   532: iload 6
    //   534: iload_2
    //   535: iconst_4
    //   536: imul
    //   537: if_icmpge +9 -> 546
    //   540: iload 4
    //   542: iconst_2
    //   543: if_icmplt +124 -> 667
    //   546: aload_0
    //   547: new 374	android/media/AudioTrack
    //   550: dup
    //   551: aload_0
    //   552: getfield 127	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   555: aload_0
    //   556: getfield 129	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playSamplerate	I
    //   559: aload_0
    //   560: getfield 131	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_channelOutType	I
    //   563: iconst_2
    //   564: iload 6
    //   566: iconst_1
    //   567: invokespecial 413	android/media/AudioTrack:<init>	(IIIIII)V
    //   570: putfield 123	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   573: invokestatic 254	com/tencent/d/a/a/a:dUd	()Z
    //   576: pop
    //   577: ldc_w 256
    //   580: new 274	java/lang/StringBuilder
    //   583: dup
    //   584: ldc_w 423
    //   587: invokespecial 279	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   590: aload_0
    //   591: getfield 123	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   594: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   597: invokevirtual 287	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   600: invokestatic 272	com/tencent/d/a/a/a:iP	(Ljava/lang/String;Ljava/lang/String;)V
    //   603: aload_0
    //   604: getfield 123	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   607: invokevirtual 416	android/media/AudioTrack:getState	()I
    //   610: iconst_1
    //   611: if_icmpeq +668 -> 1279
    //   614: invokestatic 254	com/tencent/d/a/a/a:dUd	()Z
    //   617: pop
    //   618: ldc_w 256
    //   621: new 274	java/lang/StringBuilder
    //   624: dup
    //   625: ldc_w 418
    //   628: invokespecial 279	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   631: iload 6
    //   633: invokevirtual 283	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   636: ldc_w 420
    //   639: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   642: aload_0
    //   643: getfield 129	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playSamplerate	I
    //   646: invokevirtual 283	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   649: invokevirtual 287	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   652: invokestatic 272	com/tencent/d/a/a/a:iP	(Ljava/lang/String;Ljava/lang/String;)V
    //   655: aload_0
    //   656: getfield 123	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   659: invokevirtual 385	android/media/AudioTrack:release	()V
    //   662: aload_0
    //   663: aconst_null
    //   664: putfield 123	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   667: iload 4
    //   669: iconst_1
    //   670: iadd
    //   671: istore 4
    //   673: goto -154 -> 519
    //   676: astore 10
    //   678: invokestatic 254	com/tencent/d/a/a/a:dUd	()Z
    //   681: pop
    //   682: ldc_w 256
    //   685: new 274	java/lang/StringBuilder
    //   688: dup
    //   689: ldc_w 627
    //   692: invokespecial 279	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   695: aload 10
    //   697: invokevirtual 305	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   700: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   703: invokevirtual 287	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   706: invokestatic 272	com/tencent/d/a/a/a:iP	(Ljava/lang/String;Ljava/lang/String;)V
    //   709: goto -572 -> 137
    //   712: astore 10
    //   714: iconst_0
    //   715: istore_1
    //   716: invokestatic 254	com/tencent/d/a/a/a:dUd	()Z
    //   719: pop
    //   720: ldc_w 256
    //   723: new 274	java/lang/StringBuilder
    //   726: dup
    //   727: ldc_w 560
    //   730: invokespecial 279	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   733: aload 10
    //   735: invokevirtual 305	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   738: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   741: invokevirtual 287	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   744: invokestatic 372	com/tencent/d/a/a/a:iO	(Ljava/lang/String;Ljava/lang/String;)V
    //   747: ldc_w 566
    //   750: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   753: iload_1
    //   754: ireturn
    //   755: aload_0
    //   756: getfield 149	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   759: ifnonnull +27 -> 786
    //   762: aload_0
    //   763: getfield 141	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_context	Landroid/content/Context;
    //   766: ifnull +20 -> 786
    //   769: aload_0
    //   770: aload_0
    //   771: getfield 141	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_context	Landroid/content/Context;
    //   774: ldc_w 351
    //   777: invokevirtual 357	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   780: checkcast 359	android/media/AudioManager
    //   783: putfield 149	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   786: aload_0
    //   787: getfield 149	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   790: ifnull +66 -> 856
    //   793: aload_0
    //   794: getfield 149	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   797: invokevirtual 397	android/media/AudioManager:getMode	()I
    //   800: ifne +56 -> 856
    //   803: aload_0
    //   804: getfield 183	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_connectedDev	Ljava/lang/String;
    //   807: ldc_w 399
    //   810: invokevirtual 403	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   813: ifeq +43 -> 856
    //   816: aload_0
    //   817: iconst_3
    //   818: putfield 127	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   821: aload_0
    //   822: getfield 127	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   825: aload_0
    //   826: getfield 123	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   829: invokevirtual 452	android/media/AudioTrack:getStreamType	()I
    //   832: if_icmpne +32 -> 864
    //   835: iconst_0
    //   836: istore_2
    //   837: aload_0
    //   838: iconst_0
    //   839: putfield 185	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioRouteChanged	Z
    //   842: goto -661 -> 181
    //   845: astore 10
    //   847: ldc_w 566
    //   850: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   853: aload 10
    //   855: athrow
    //   856: aload_0
    //   857: iconst_0
    //   858: putfield 127	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   861: goto -40 -> 821
    //   864: iconst_1
    //   865: istore_2
    //   866: goto -29 -> 837
    //   869: astore 10
    //   871: invokestatic 254	com/tencent/d/a/a/a:dUd	()Z
    //   874: pop
    //   875: ldc_w 256
    //   878: ldc_w 629
    //   881: invokestatic 372	com/tencent/d/a/a/a:iO	(Ljava/lang/String;Ljava/lang/String;)V
    //   884: goto -510 -> 374
    //   887: astore 11
    //   889: invokestatic 254	com/tencent/d/a/a/a:dUd	()Z
    //   892: pop
    //   893: ldc_w 256
    //   896: new 274	java/lang/StringBuilder
    //   899: dup
    //   900: invokespecial 421	java/lang/StringBuilder:<init>	()V
    //   903: aload 11
    //   905: invokevirtual 305	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   908: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   911: ldc_w 423
    //   914: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   917: aload_0
    //   918: getfield 123	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   921: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   924: invokevirtual 287	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   927: invokestatic 272	com/tencent/d/a/a/a:iP	(Ljava/lang/String;Ljava/lang/String;)V
    //   930: aload_0
    //   931: getfield 123	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   934: ifnull +10 -> 944
    //   937: aload_0
    //   938: getfield 123	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   941: invokevirtual 385	android/media/AudioTrack:release	()V
    //   944: aload_0
    //   945: aconst_null
    //   946: putfield 123	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   949: goto -282 -> 667
    //   952: aload_0
    //   953: getfield 123	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   956: astore 10
    //   958: aload 10
    //   960: ifnull +57 -> 1017
    //   963: aload_0
    //   964: getfield 123	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   967: invokevirtual 632	android/media/AudioTrack:play	()V
    //   970: aload_0
    //   971: getfield 179	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_as	Lcom/tencent/rtmp/sharp/jni/TraeAudioSession;
    //   974: aload_0
    //   975: getfield 149	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   978: invokevirtual 397	android/media/AudioManager:getMode	()I
    //   981: aload_0
    //   982: getfield 127	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   985: invokevirtual 430	com/tencent/rtmp/sharp/jni/TraeAudioSession:voiceCallAudioParamChanged	(II)I
    //   988: pop
    //   989: aload_0
    //   990: getfield 149	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   993: astore 10
    //   995: aload_0
    //   996: getfield 183	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_connectedDev	Ljava/lang/String;
    //   999: ldc_w 445
    //   1002: invokevirtual 403	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1005: ifeq +53 -> 1058
    //   1008: bipush 6
    //   1010: istore_2
    //   1011: aload 10
    //   1013: iload_2
    //   1014: invokestatic 449	com/tencent/rtmp/sharp/jni/TraeAudioManager:forceVolumeControlStream	(Landroid/media/AudioManager;I)V
    //   1017: invokestatic 254	com/tencent/d/a/a/a:dUd	()Z
    //   1020: pop
    //   1021: ldc_w 256
    //   1024: new 274	java/lang/StringBuilder
    //   1027: dup
    //   1028: ldc_w 634
    //   1031: invokespecial 279	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1034: invokestatic 606	android/os/SystemClock:elapsedRealtime	()J
    //   1037: lload 8
    //   1039: lsub
    //   1040: invokevirtual 637	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1043: ldc_w 639
    //   1046: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1049: invokevirtual 287	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1052: invokestatic 372	com/tencent/d/a/a/a:iO	(Ljava/lang/String;Ljava/lang/String;)V
    //   1055: goto -308 -> 747
    //   1058: aload_0
    //   1059: getfield 123	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1062: invokevirtual 452	android/media/AudioTrack:getStreamType	()I
    //   1065: istore_2
    //   1066: goto -55 -> 1011
    //   1069: aload_0
    //   1070: getfield 123	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1073: aload_0
    //   1074: getfield 238	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_tempBufPlay	[B
    //   1077: iconst_0
    //   1078: iload_1
    //   1079: invokevirtual 642	android/media/AudioTrack:write	([BII)I
    //   1082: istore_2
    //   1083: aload_0
    //   1084: getfield 212	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playBuffer	Ljava/nio/ByteBuffer;
    //   1087: invokevirtual 600	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   1090: pop
    //   1091: iload_2
    //   1092: ifge +54 -> 1146
    //   1095: invokestatic 254	com/tencent/d/a/a/a:dUd	()Z
    //   1098: pop
    //   1099: ldc_w 256
    //   1102: new 274	java/lang/StringBuilder
    //   1105: dup
    //   1106: ldc_w 644
    //   1109: invokespecial 279	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1112: iload_2
    //   1113: invokevirtual 283	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1116: ldc_w 646
    //   1119: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1122: iload_1
    //   1123: invokevirtual 283	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1126: ldc_w 648
    //   1129: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1132: invokevirtual 287	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1135: invokestatic 372	com/tencent/d/a/a/a:iO	(Ljava/lang/String;Ljava/lang/String;)V
    //   1138: ldc_w 566
    //   1141: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1144: iconst_m1
    //   1145: ireturn
    //   1146: iload_2
    //   1147: iload_1
    //   1148: if_icmpeq +46 -> 1194
    //   1151: invokestatic 254	com/tencent/d/a/a/a:dUd	()Z
    //   1154: pop
    //   1155: ldc_w 256
    //   1158: new 274	java/lang/StringBuilder
    //   1161: dup
    //   1162: ldc_w 650
    //   1165: invokespecial 279	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1168: iload_2
    //   1169: invokevirtual 283	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1172: ldc_w 646
    //   1175: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1178: iload_1
    //   1179: invokevirtual 283	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1182: ldc_w 648
    //   1185: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1188: invokevirtual 287	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1191: invokestatic 372	com/tencent/d/a/a/a:iO	(Ljava/lang/String;Ljava/lang/String;)V
    //   1194: aload_0
    //   1195: aload_0
    //   1196: getfield 161	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1199: iload_2
    //   1200: iconst_1
    //   1201: ishr
    //   1202: iadd
    //   1203: putfield 161	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1206: aload_0
    //   1207: getfield 123	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1210: invokevirtual 433	android/media/AudioTrack:getPlaybackHeadPosition	()I
    //   1213: istore_1
    //   1214: iload_1
    //   1215: aload_0
    //   1216: getfield 163	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playPosition	I
    //   1219: if_icmpge +8 -> 1227
    //   1222: aload_0
    //   1223: iconst_0
    //   1224: putfield 163	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playPosition	I
    //   1227: aload_0
    //   1228: aload_0
    //   1229: getfield 161	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1232: iload_1
    //   1233: aload_0
    //   1234: getfield 163	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playPosition	I
    //   1237: isub
    //   1238: isub
    //   1239: putfield 161	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1242: aload_0
    //   1243: iload_1
    //   1244: putfield 163	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playPosition	I
    //   1247: iload_2
    //   1248: istore_1
    //   1249: goto -502 -> 747
    //   1252: astore 10
    //   1254: iload_2
    //   1255: istore_1
    //   1256: goto -540 -> 716
    //   1259: astore 10
    //   1261: goto -244 -> 1017
    //   1264: astore 10
    //   1266: goto -1094 -> 172
    //   1269: iconst_0
    //   1270: istore_3
    //   1271: goto -819 -> 452
    //   1274: astore 10
    //   1276: goto -560 -> 716
    //   1279: iload_3
    //   1280: iconst_1
    //   1281: iadd
    //   1282: istore_3
    //   1283: goto -831 -> 452
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1286	0	this	AudioDeviceInterface
    //   0	1286	1	paramInt	int
    //   14	1241	2	i	int
    //   23	1260	3	j	int
    //   517	155	4	k	int
    //   386	144	5	m	int
    //   530	102	6	n	int
    //   115	6	7	bool	boolean
    //   208	830	8	l	long
    //   95	371	10	localObject1	Object
    //   676	20	10	localException1	Exception
    //   712	22	10	localException2	Exception
    //   845	9	10	localObject2	Object
    //   869	1	10	localIllegalStateException	IllegalStateException
    //   956	56	10	localObject3	Object
    //   1252	1	10	localException3	Exception
    //   1259	1	10	localException4	Exception
    //   1264	1	10	localIOException	java.io.IOException
    //   1274	1	10	localException5	Exception
    //   887	17	11	localException6	Exception
    // Exception table:
    //   from	to	target	type
    //   123	137	676	java/lang/Exception
    //   91	97	712	java/lang/Exception
    //   111	117	712	java/lang/Exception
    //   137	142	712	java/lang/Exception
    //   142	154	712	java/lang/Exception
    //   159	172	712	java/lang/Exception
    //   172	179	712	java/lang/Exception
    //   181	193	712	java/lang/Exception
    //   678	709	712	java/lang/Exception
    //   755	786	712	java/lang/Exception
    //   786	821	712	java/lang/Exception
    //   821	835	712	java/lang/Exception
    //   837	842	712	java/lang/Exception
    //   856	861	712	java/lang/Exception
    //   1069	1083	712	java/lang/Exception
    //   91	97	845	finally
    //   111	117	845	finally
    //   123	137	845	finally
    //   137	142	845	finally
    //   142	154	845	finally
    //   159	172	845	finally
    //   172	179	845	finally
    //   181	193	845	finally
    //   197	264	845	finally
    //   269	374	845	finally
    //   374	445	845	finally
    //   457	516	845	finally
    //   546	573	845	finally
    //   573	667	845	finally
    //   678	709	845	finally
    //   716	747	845	finally
    //   755	786	845	finally
    //   786	821	845	finally
    //   821	835	845	finally
    //   837	842	845	finally
    //   856	861	845	finally
    //   871	884	845	finally
    //   889	944	845	finally
    //   944	949	845	finally
    //   952	958	845	finally
    //   963	1008	845	finally
    //   1011	1017	845	finally
    //   1017	1055	845	finally
    //   1058	1066	845	finally
    //   1069	1083	845	finally
    //   1083	1091	845	finally
    //   1095	1138	845	finally
    //   1151	1194	845	finally
    //   1194	1227	845	finally
    //   1227	1247	845	finally
    //   269	374	869	java/lang/IllegalStateException
    //   546	573	887	java/lang/Exception
    //   1083	1091	1252	java/lang/Exception
    //   1095	1138	1252	java/lang/Exception
    //   1151	1194	1252	java/lang/Exception
    //   1194	1227	1252	java/lang/Exception
    //   1227	1247	1252	java/lang/Exception
    //   963	1008	1259	java/lang/Exception
    //   1011	1017	1259	java/lang/Exception
    //   1058	1066	1259	java/lang/Exception
    //   159	172	1264	java/io/IOException
    //   197	264	1274	java/lang/Exception
    //   269	374	1274	java/lang/Exception
    //   374	445	1274	java/lang/Exception
    //   457	516	1274	java/lang/Exception
    //   573	667	1274	java/lang/Exception
    //   871	884	1274	java/lang/Exception
    //   889	944	1274	java/lang/Exception
    //   944	949	1274	java/lang/Exception
    //   952	958	1274	java/lang/Exception
    //   1017	1055	1274	java/lang/Exception
  }
  
  private int ReadMp3File(int paramInt)
  {
    AppMethodBeat.i(146969);
    TraeAudioCodecList.a locala = this._traeAudioCodecList.find(paramInt);
    if (locala != null)
    {
      ByteBuffer localByteBuffer = getDecBuffer(paramInt);
      if (localByteBuffer == null)
      {
        AppMethodBeat.o(146969);
        return -1;
      }
      localByteBuffer.rewind();
      paramInt = locala.b.getFrameSize();
      int i = locala.b.ReadOneFrame(locala.c, paramInt);
      localByteBuffer.put(locala.c, 0, paramInt);
      AppMethodBeat.o(146969);
      return i;
    }
    AppMethodBeat.o(146969);
    return -1;
  }
  
  /* Error */
  private int RecordAudio(int paramInt)
  {
    // Byte code:
    //   0: ldc_w 671
    //   3: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 155	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   10: ifne +41 -> 51
    //   13: invokestatic 254	com/tencent/d/a/a/a:dUd	()Z
    //   16: pop
    //   17: ldc_w 256
    //   20: new 274	java/lang/StringBuilder
    //   23: dup
    //   24: ldc_w 673
    //   27: invokespecial 279	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   30: aload_0
    //   31: getfield 155	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   34: invokevirtual 336	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   37: invokevirtual 287	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 372	com/tencent/d/a/a/a:iO	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: ldc_w 671
    //   46: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: iconst_m1
    //   50: ireturn
    //   51: aload_0
    //   52: getfield 125	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   55: astore 5
    //   57: aload 5
    //   59: ifnonnull +12 -> 71
    //   62: ldc_w 671
    //   65: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: bipush 254
    //   70: ireturn
    //   71: aload_0
    //   72: getfield 153	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_doRecInit	Z
    //   75: istore 4
    //   77: iload 4
    //   79: iconst_1
    //   80: if_icmpne +22 -> 102
    //   83: bipush 237
    //   85: invokestatic 575	android/os/Process:setThreadPriority	(I)V
    //   88: invokestatic 581	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   91: ldc_w 675
    //   94: invokevirtual 586	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   97: aload_0
    //   98: iconst_0
    //   99: putfield 153	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_doRecInit	Z
    //   102: aload_0
    //   103: getfield 214	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_recBuffer	Ljava/nio/ByteBuffer;
    //   106: invokevirtual 600	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   109: pop
    //   110: aload_0
    //   111: getfield 125	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   114: aload_0
    //   115: getfield 240	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_tempBufRec	[B
    //   118: iconst_0
    //   119: iload_1
    //   120: invokevirtual 678	android/media/AudioRecord:read	([BII)I
    //   123: istore_2
    //   124: iload_2
    //   125: ifge +135 -> 260
    //   128: invokestatic 254	com/tencent/d/a/a/a:dUd	()Z
    //   131: pop
    //   132: ldc_w 256
    //   135: new 274	java/lang/StringBuilder
    //   138: dup
    //   139: ldc_w 680
    //   142: invokespecial 279	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   145: iload_2
    //   146: invokevirtual 283	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   149: ldc_w 646
    //   152: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: iload_1
    //   156: invokevirtual 283	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   159: ldc_w 648
    //   162: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: invokevirtual 287	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokestatic 372	com/tencent/d/a/a/a:iO	(Ljava/lang/String;Ljava/lang/String;)V
    //   171: ldc_w 671
    //   174: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   177: iconst_m1
    //   178: ireturn
    //   179: astore 5
    //   181: invokestatic 254	com/tencent/d/a/a/a:dUd	()Z
    //   184: pop
    //   185: ldc_w 256
    //   188: new 274	java/lang/StringBuilder
    //   191: dup
    //   192: ldc_w 682
    //   195: invokespecial 279	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   198: aload 5
    //   200: invokevirtual 305	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   203: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: invokevirtual 287	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokestatic 272	com/tencent/d/a/a/a:iP	(Ljava/lang/String;Ljava/lang/String;)V
    //   212: goto -115 -> 97
    //   215: astore 5
    //   217: iconst_0
    //   218: istore_2
    //   219: invokestatic 254	com/tencent/d/a/a/a:dUd	()Z
    //   222: pop
    //   223: ldc_w 256
    //   226: new 274	java/lang/StringBuilder
    //   229: dup
    //   230: ldc_w 684
    //   233: invokespecial 279	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   236: aload 5
    //   238: invokevirtual 305	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   241: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: invokevirtual 287	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokestatic 372	com/tencent/d/a/a/a:iO	(Ljava/lang/String;Ljava/lang/String;)V
    //   250: iload_2
    //   251: istore_3
    //   252: ldc_w 671
    //   255: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   258: iload_3
    //   259: ireturn
    //   260: aload_0
    //   261: getfield 214	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_recBuffer	Ljava/nio/ByteBuffer;
    //   264: aload_0
    //   265: getfield 240	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_tempBufRec	[B
    //   268: iconst_0
    //   269: iload_2
    //   270: invokevirtual 669	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   273: pop
    //   274: getstatic 98	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_dumpEnable	Z
    //   277: ifeq +27 -> 304
    //   280: aload_0
    //   281: getfield 169	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_rec_out	Ljava/io/FileOutputStream;
    //   284: astore 5
    //   286: aload 5
    //   288: ifnull +16 -> 304
    //   291: aload_0
    //   292: getfield 169	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_rec_out	Ljava/io/FileOutputStream;
    //   295: aload_0
    //   296: getfield 240	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_tempBufRec	[B
    //   299: iconst_0
    //   300: iload_2
    //   301: invokevirtual 592	java/io/FileOutputStream:write	([BII)V
    //   304: iload_2
    //   305: istore_3
    //   306: iload_2
    //   307: iload_1
    //   308: if_icmpeq -56 -> 252
    //   311: invokestatic 254	com/tencent/d/a/a/a:dUd	()Z
    //   314: pop
    //   315: ldc_w 256
    //   318: new 274	java/lang/StringBuilder
    //   321: dup
    //   322: ldc_w 686
    //   325: invokespecial 279	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   328: iload_2
    //   329: invokevirtual 283	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   332: ldc_w 646
    //   335: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: iload_1
    //   339: invokevirtual 283	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   342: ldc_w 648
    //   345: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: invokevirtual 287	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: invokestatic 372	com/tencent/d/a/a/a:iO	(Ljava/lang/String;Ljava/lang/String;)V
    //   354: ldc_w 671
    //   357: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   360: iconst_m1
    //   361: ireturn
    //   362: astore 5
    //   364: ldc_w 671
    //   367: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   370: aload 5
    //   372: athrow
    //   373: astore 5
    //   375: goto -156 -> 219
    //   378: astore 5
    //   380: goto -76 -> 304
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	383	0	this	AudioDeviceInterface
    //   0	383	1	paramInt	int
    //   123	206	2	i	int
    //   251	55	3	j	int
    //   75	6	4	bool	boolean
    //   55	3	5	localAudioRecord	AudioRecord
    //   179	20	5	localException1	Exception
    //   215	22	5	localException2	Exception
    //   284	3	5	localFileOutputStream	FileOutputStream
    //   362	9	5	localObject	Object
    //   373	1	5	localException3	Exception
    //   378	1	5	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   83	97	179	java/lang/Exception
    //   51	57	215	java/lang/Exception
    //   71	77	215	java/lang/Exception
    //   97	102	215	java/lang/Exception
    //   102	124	215	java/lang/Exception
    //   181	212	215	java/lang/Exception
    //   51	57	362	finally
    //   71	77	362	finally
    //   83	97	362	finally
    //   97	102	362	finally
    //   102	124	362	finally
    //   128	171	362	finally
    //   181	212	362	finally
    //   219	250	362	finally
    //   260	286	362	finally
    //   291	304	362	finally
    //   311	354	362	finally
    //   128	171	373	java/lang/Exception
    //   260	286	373	java/lang/Exception
    //   291	304	373	java/lang/Exception
    //   311	354	373	java/lang/Exception
    //   291	304	378	java/io/IOException
  }
  
  private int SeekMp3To(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(146971);
    TraeAudioCodecList.a locala = this._traeAudioCodecList.find(paramInt1);
    if (locala != null)
    {
      paramInt1 = locala.b.SeekTo(paramInt2);
      AppMethodBeat.o(146971);
      return paramInt1;
    }
    AppMethodBeat.o(146971);
    return 0;
  }
  
  private int SetAudioOutputMode(int paramInt)
  {
    AppMethodBeat.i(146959);
    a.dUd();
    a.iP("TRAE", "TraeAudioSession SetAudioOutputMode: ".concat(String.valueOf(paramInt)));
    if (paramInt == 0)
    {
      if ((mDeviceList == null) || (this._asAudioManager == null))
      {
        AppMethodBeat.o(146959);
        return -1;
      }
      int i = 0;
      int j = 0;
      label55:
      paramInt = i;
      if (j < mDeviceList.length)
      {
        paramInt = i;
        if (i == 0)
        {
          if (!"DEVICE_WIREDHEADSET".equals(mDeviceList[j])) {
            break label202;
          }
          this._asAudioManager.connectDevice("DEVICE_WIREDHEADSET");
          paramInt = 1;
        }
      }
      j = 0;
      label100:
      i = paramInt;
      if (j < mDeviceList.length)
      {
        i = paramInt;
        if (paramInt == 0)
        {
          if (!"DEVICE_BLUETOOTHHEADSET".equals(mDeviceList[j])) {
            break label209;
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
              break label216;
            }
            this._asAudioManager.connectDevice("DEVICE_EARPHONE");
            paramInt = 1;
          }
        }
        i = paramInt;
        if (paramInt == 0) {
          break;
        }
        AppMethodBeat.o(146959);
        return 0;
        label202:
        j += 1;
        break label55;
        label209:
        j += 1;
        break label100;
        label216:
        j += 1;
      }
    }
    if (1 == paramInt)
    {
      if (this._asAudioManager == null)
      {
        AppMethodBeat.o(146959);
        return -1;
      }
      this._asAudioManager.connectDevice("DEVICE_SPEAKERPHONE");
      AppMethodBeat.o(146959);
      return 0;
    }
    AppMethodBeat.o(146959);
    return -1;
  }
  
  private int SetPlayoutVolume(int paramInt)
  {
    AppMethodBeat.i(65774);
    if ((this._audioManager == null) && (this._context != null)) {
      this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
    }
    int i = -1;
    if (this._audioManager != null)
    {
      this._audioManager.setStreamVolume(0, paramInt, 0);
      i = 0;
    }
    AppMethodBeat.o(65774);
    return i;
  }
  
  /* Error */
  private int StartPlayback()
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_1
    //   2: ldc_w 713
    //   5: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 157	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   12: ifeq +24 -> 36
    //   15: invokestatic 254	com/tencent/d/a/a/a:dUd	()Z
    //   18: pop
    //   19: ldc_w 256
    //   22: ldc_w 715
    //   25: invokestatic 372	com/tencent/d/a/a/a:iO	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: ldc_w 713
    //   31: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: iconst_m1
    //   35: ireturn
    //   36: aload_0
    //   37: getfield 123	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   40: ifnonnull +41 -> 81
    //   43: invokestatic 254	com/tencent/d/a/a/a:dUd	()Z
    //   46: pop
    //   47: ldc_w 256
    //   50: new 274	java/lang/StringBuilder
    //   53: dup
    //   54: ldc_w 717
    //   57: invokespecial 279	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   60: aload_0
    //   61: getfield 123	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   64: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 287	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokestatic 372	com/tencent/d/a/a/a:iO	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: ldc_w 713
    //   76: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   79: iconst_m1
    //   80: ireturn
    //   81: aload_0
    //   82: getfield 123	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   85: invokevirtual 632	android/media/AudioTrack:play	()V
    //   88: getstatic 98	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_dumpEnable	Z
    //   91: ifeq +52 -> 143
    //   94: aload_0
    //   95: getfield 149	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   98: ifnull +11 -> 109
    //   101: aload_0
    //   102: getfield 149	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   105: invokevirtual 397	android/media/AudioManager:getMode	()I
    //   108: istore_1
    //   109: aload_0
    //   110: new 719	java/io/File
    //   113: dup
    //   114: aload_0
    //   115: ldc_w 721
    //   118: iload_1
    //   119: invokespecial 725	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:getDumpFilePath	(Ljava/lang/String;I)Ljava/lang/String;
    //   122: invokespecial 726	java/io/File:<init>	(Ljava/lang/String;)V
    //   125: putfield 167	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_play_dump	Ljava/io/File;
    //   128: aload_0
    //   129: new 588	java/io/FileOutputStream
    //   132: dup
    //   133: aload_0
    //   134: getfield 167	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_play_dump	Ljava/io/File;
    //   137: invokespecial 729	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   140: putfield 171	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_play_out	Ljava/io/FileOutputStream;
    //   143: aload_0
    //   144: iconst_1
    //   145: putfield 157	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   148: invokestatic 254	com/tencent/d/a/a/a:dUd	()Z
    //   151: pop
    //   152: ldc_w 256
    //   155: ldc_w 731
    //   158: invokestatic 272	com/tencent/d/a/a/a:iP	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: ldc_w 713
    //   164: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   167: iconst_0
    //   168: ireturn
    //   169: astore_2
    //   170: invokestatic 254	com/tencent/d/a/a/a:dUd	()Z
    //   173: pop
    //   174: ldc_w 256
    //   177: ldc_w 733
    //   180: invokestatic 372	com/tencent/d/a/a/a:iO	(Ljava/lang/String;Ljava/lang/String;)V
    //   183: ldc_w 713
    //   186: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   189: iconst_m1
    //   190: ireturn
    //   191: astore_2
    //   192: goto -49 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	this	AudioDeviceInterface
    //   1	118	1	i	int
    //   169	1	2	localIllegalStateException	IllegalStateException
    //   191	1	2	localFileNotFoundException	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   81	88	169	java/lang/IllegalStateException
    //   128	143	191	java/io/FileNotFoundException
  }
  
  /* Error */
  private int StartRecording()
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_1
    //   2: ldc_w 735
    //   5: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 254	com/tencent/d/a/a/a:dUd	()Z
    //   11: pop
    //   12: ldc_w 256
    //   15: ldc_w 737
    //   18: invokestatic 272	com/tencent/d/a/a/a:iP	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: aload_0
    //   22: getfield 155	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   25: ifeq +41 -> 66
    //   28: invokestatic 254	com/tencent/d/a/a/a:dUd	()Z
    //   31: pop
    //   32: ldc_w 256
    //   35: new 274	java/lang/StringBuilder
    //   38: dup
    //   39: ldc_w 739
    //   42: invokespecial 279	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   45: aload_0
    //   46: getfield 155	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   49: invokevirtual 336	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   52: invokevirtual 287	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 372	com/tencent/d/a/a/a:iO	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: ldc_w 735
    //   61: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: iconst_m1
    //   65: ireturn
    //   66: aload_0
    //   67: getfield 125	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   70: ifnonnull +41 -> 111
    //   73: invokestatic 254	com/tencent/d/a/a/a:dUd	()Z
    //   76: pop
    //   77: ldc_w 256
    //   80: new 274	java/lang/StringBuilder
    //   83: dup
    //   84: ldc_w 741
    //   87: invokespecial 279	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   90: aload_0
    //   91: getfield 125	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   94: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 287	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 372	com/tencent/d/a/a/a:iO	(Ljava/lang/String;Ljava/lang/String;)V
    //   103: ldc_w 735
    //   106: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: iconst_m1
    //   110: ireturn
    //   111: aload_0
    //   112: getfield 125	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   115: invokevirtual 744	android/media/AudioRecord:startRecording	()V
    //   118: getstatic 98	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_dumpEnable	Z
    //   121: ifeq +52 -> 173
    //   124: aload_0
    //   125: getfield 149	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   128: ifnull +11 -> 139
    //   131: aload_0
    //   132: getfield 149	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   135: invokevirtual 397	android/media/AudioManager:getMode	()I
    //   138: istore_1
    //   139: aload_0
    //   140: new 719	java/io/File
    //   143: dup
    //   144: aload_0
    //   145: ldc_w 746
    //   148: iload_1
    //   149: invokespecial 725	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:getDumpFilePath	(Ljava/lang/String;I)Ljava/lang/String;
    //   152: invokespecial 726	java/io/File:<init>	(Ljava/lang/String;)V
    //   155: putfield 165	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_rec_dump	Ljava/io/File;
    //   158: aload_0
    //   159: new 588	java/io/FileOutputStream
    //   162: dup
    //   163: aload_0
    //   164: getfield 165	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_rec_dump	Ljava/io/File;
    //   167: invokespecial 729	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   170: putfield 169	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_rec_out	Ljava/io/FileOutputStream;
    //   173: aload_0
    //   174: iconst_1
    //   175: putfield 155	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   178: invokestatic 254	com/tencent/d/a/a/a:dUd	()Z
    //   181: pop
    //   182: ldc_w 256
    //   185: ldc_w 748
    //   188: invokestatic 272	com/tencent/d/a/a/a:iP	(Ljava/lang/String;Ljava/lang/String;)V
    //   191: ldc_w 735
    //   194: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   197: iconst_0
    //   198: ireturn
    //   199: astore_2
    //   200: invokestatic 254	com/tencent/d/a/a/a:dUd	()Z
    //   203: pop
    //   204: ldc_w 256
    //   207: ldc_w 750
    //   210: invokestatic 372	com/tencent/d/a/a/a:iO	(Ljava/lang/String;Ljava/lang/String;)V
    //   213: ldc_w 735
    //   216: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   219: iconst_m1
    //   220: ireturn
    //   221: astore_2
    //   222: goto -49 -> 173
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	225	0	this	AudioDeviceInterface
    //   1	148	1	i	int
    //   199	1	2	localIllegalStateException	IllegalStateException
    //   221	1	2	localFileNotFoundException	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   111	118	199	java/lang/IllegalStateException
    //   158	173	221	java/io/FileNotFoundException
  }
  
  private int StopPlayback()
  {
    AppMethodBeat.i(65770);
    a.dUd();
    a.iP("TRAE", "StopPlayback entry _isPlaying:" + this._isPlaying);
    if (this._audioTrack == null)
    {
      a.dUd();
      a.iO("TRAE", "StopPlayback _isPlaying:" + this._isPlaying + " " + this._audioTrack);
      AppMethodBeat.o(65770);
      return -1;
    }
    if (this._audioTrack.getPlayState() == 3) {}
    try
    {
      a.dUd();
      a.iP("TRAE", "StopPlayback stoping...");
      this._audioTrack.stop();
      a.dUd();
      a.iP("TRAE", "StopPlayback flushing... state:" + this._audioTrack.getPlayState());
      this._audioTrack.flush();
      a.dUd();
      a.iP("TRAE", "StopPlayback releaseing... state:" + this._audioTrack.getPlayState());
      this._audioTrack.release();
      this._audioTrack = null;
      this._isPlaying = false;
      a.dUd();
      a.iP("TRAE", "StopPlayback exit ok");
      AppMethodBeat.o(65770);
      return 0;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      a.dUd();
      a.iO("TRAE", "StopPlayback err");
      AppMethodBeat.o(65770);
    }
    return -1;
  }
  
  private int StopRecording()
  {
    AppMethodBeat.i(65769);
    a.dUd();
    a.iP("TRAE", "StopRecording entry");
    if (this._audioRecord == null)
    {
      a.dUd();
      a.iO("TRAE", "UnintRecord:" + this._audioRecord);
      AppMethodBeat.o(65769);
      return -1;
    }
    if (this._audioRecord.getRecordingState() == 3) {}
    try
    {
      a.dUd();
      a.iP("TRAE", "StopRecording stop... state:" + this._audioRecord.getRecordingState());
      this._audioRecord.stop();
      a.dUd();
      a.iP("TRAE", "StopRecording releaseing... state:" + this._audioRecord.getRecordingState());
      this._audioRecord.release();
      this._audioRecord = null;
      this._isRecording = false;
      a.dUd();
      a.iP("TRAE", "StopRecording exit ok");
      AppMethodBeat.o(65769);
      return 0;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      a.dUd();
      a.iO("TRAE", "StopRecording  err");
      AppMethodBeat.o(65769);
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
    AppMethodBeat.i(146968);
    switch (paramInt)
    {
    default: 
      a.iP("TRAE", "getDecBuffer failed!! index:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(146968);
      return null;
    case 0: 
      localByteBuffer = this._decBuffer0;
      AppMethodBeat.o(146968);
      return localByteBuffer;
    case 1: 
      localByteBuffer = this._decBuffer1;
      AppMethodBeat.o(146968);
      return localByteBuffer;
    case 2: 
      localByteBuffer = this._decBuffer2;
      AppMethodBeat.o(146968);
      return localByteBuffer;
    case 3: 
      localByteBuffer = this._decBuffer3;
      AppMethodBeat.o(146968);
      return localByteBuffer;
    case 4: 
      localByteBuffer = this._decBuffer4;
      AppMethodBeat.o(146968);
      return localByteBuffer;
    case 5: 
      localByteBuffer = this._decBuffer5;
      AppMethodBeat.o(146968);
      return localByteBuffer;
    case 6: 
      localByteBuffer = this._decBuffer6;
      AppMethodBeat.o(146968);
      return localByteBuffer;
    case 7: 
      localByteBuffer = this._decBuffer7;
      AppMethodBeat.o(146968);
      return localByteBuffer;
    case 8: 
      localByteBuffer = this._decBuffer8;
      AppMethodBeat.o(146968);
      return localByteBuffer;
    case 9: 
      localByteBuffer = this._decBuffer9;
      AppMethodBeat.o(146968);
      return localByteBuffer;
    }
    ByteBuffer localByteBuffer = this._decBuffer10;
    AppMethodBeat.o(146968);
    return localByteBuffer;
  }
  
  private String getDumpFilePath(String paramString, int paramInt)
  {
    AppMethodBeat.i(65766);
    a.dUd();
    a.iP("TRAE", "manufacture:" + Build.MANUFACTURER);
    a.dUd();
    a.iP("TRAE", "MODEL:" + Build.MODEL);
    paramString = Environment.getExternalStorageDirectory().getPath() + "/MF-" + Build.MANUFACTURER + "-M-" + Build.MODEL + "-as-" + TraeAudioManager.getAudioSource(this._audioSourcePolicy) + "-st-" + this._streamType + "-m-" + paramInt + "-" + paramString;
    a.dUd();
    a.iP("TRAE", "dump:".concat(String.valueOf(paramString)));
    a.dUd();
    a.iP("TRAE", "dump replace:" + paramString.replace(" ", "_"));
    paramString = paramString.replace(" ", "_");
    AppMethodBeat.o(65766);
    return paramString;
  }
  
  private int getLowlatencyFramesPerBuffer()
  {
    AppMethodBeat.i(65762);
    if ((this._context == null) || (Build.VERSION.SDK_INT < 9))
    {
      a.dUd();
      a.iO("TRAE", "getLowlatencySamplerate err, _context:" + this._context + " api:" + Build.VERSION.SDK_INT);
      AppMethodBeat.o(65762);
      return 0;
    }
    boolean bool = this._context.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
    a.dUd();
    StringBuilder localStringBuilder = new StringBuilder("LOW_LATENCY:");
    if (bool == true) {}
    for (String str = "Y";; str = "N")
    {
      a.iP("TRAE", str);
      if (Build.VERSION.SDK_INT >= 17) {
        break;
      }
      a.dUd();
      a.iO("TRAE", "API Level too low not support PROPERTY_OUTPUT_SAMPLE_RATE");
      AppMethodBeat.o(65762);
      return 0;
    }
    AppMethodBeat.o(65762);
    return 0;
  }
  
  private int getLowlatencySamplerate()
  {
    AppMethodBeat.i(65761);
    if ((this._context == null) || (Build.VERSION.SDK_INT < 9))
    {
      a.dUd();
      a.iO("TRAE", "getLowlatencySamplerate err, _context:" + this._context + " api:" + Build.VERSION.SDK_INT);
      AppMethodBeat.o(65761);
      return 0;
    }
    boolean bool = this._context.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
    a.dUd();
    StringBuilder localStringBuilder = new StringBuilder("LOW_LATENCY:");
    if (bool == true) {}
    for (String str = "Y";; str = "N")
    {
      a.iP("TRAE", str);
      if (Build.VERSION.SDK_INT >= 17) {
        break;
      }
      a.dUd();
      a.iO("TRAE", "API Level too low not support PROPERTY_OUTPUT_SAMPLE_RATE");
      AppMethodBeat.o(65761);
      return 0;
    }
    a.dUd();
    a.iO("TRAE", "getLowlatencySamplerate not support right now!");
    AppMethodBeat.o(65761);
    return 0;
  }
  
  private int getMp3Channels(int paramInt)
  {
    AppMethodBeat.i(146973);
    TraeAudioCodecList.a locala = this._traeAudioCodecList.find(paramInt);
    if (locala != null)
    {
      paramInt = locala.b.getChannels();
      AppMethodBeat.o(146973);
      return paramInt;
    }
    AppMethodBeat.o(146973);
    return -1;
  }
  
  private long getMp3FileTotalMs(int paramInt)
  {
    AppMethodBeat.i(146974);
    TraeAudioCodecList.a locala = this._traeAudioCodecList.find(paramInt);
    if (locala != null)
    {
      long l = locala.b.getFileTotalMs();
      AppMethodBeat.o(146974);
      return l;
    }
    AppMethodBeat.o(146974);
    return -1L;
  }
  
  private int getMp3SampleRate(int paramInt)
  {
    AppMethodBeat.i(146972);
    TraeAudioCodecList.a locala = this._traeAudioCodecList.find(paramInt);
    if (locala != null)
    {
      paramInt = locala.b.getSampleRate();
      AppMethodBeat.o(146972);
      return paramInt;
    }
    AppMethodBeat.o(146972);
    return -1;
  }
  
  private int getPlayRecordSysBufferMs()
  {
    return (this.nRecordLengthMs + this.nPlayLengthMs) * 2;
  }
  
  public static String getTraceInfo()
  {
    AppMethodBeat.i(65776);
    Object localObject = new StringBuffer();
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    ((StringBuffer)localObject).append(arrayOfStackTraceElement[2].getClassName()).append(".").append(arrayOfStackTraceElement[2].getMethodName()).append(": ").append(arrayOfStackTraceElement[2].getLineNumber());
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(65776);
    return localObject;
  }
  
  private void initTRAEAudioManager()
  {
    AppMethodBeat.i(65786);
    if (this._context != null)
    {
      TraeAudioManager.init(this._context);
      a.dUd();
      a.iP("TRAE", "initTRAEAudioManager , TraeAudioSession create");
      if (this._asAudioManager == null) {
        this._asAudioManager = new TraeAudioSession(this._context, new AudioDeviceInterface.3(this));
      }
      this._asAudioManager.startService("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
    }
    AppMethodBeat.o(65786);
  }
  
  static boolean isHardcodeOpenSles()
  {
    AppMethodBeat.i(146961);
    if (Build.MANUFACTURER.equals("Xiaomi"))
    {
      if (Build.MODEL.equals("MI 5"))
      {
        AppMethodBeat.o(146961);
        return true;
      }
      if (Build.MODEL.equals("MI 5s"))
      {
        AppMethodBeat.o(146961);
        return true;
      }
      if (Build.MODEL.equals("MI 5s Plus"))
      {
        AppMethodBeat.o(146961);
        return true;
      }
    }
    else if ((Build.MANUFACTURER.equals("samsung")) && (Build.MODEL.equals("SM-G9350")))
    {
      AppMethodBeat.o(146961);
      return true;
    }
    AppMethodBeat.o(146961);
    return false;
  }
  
  private int isSupportLowLatency()
  {
    AppMethodBeat.i(146963);
    if (isHardcodeOpenSles())
    {
      a.dUd();
      a.iP("TRAE", "hardcode FEATURE_AUDIO_LOW_LATENCY: " + Build.MANUFACTURER + "_" + Build.MODEL);
      AppMethodBeat.o(146963);
      return 1;
    }
    AppMethodBeat.o(146963);
    return 0;
  }
  
  private int isSupportVivoKTVHelper()
  {
    AppMethodBeat.i(146964);
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
      AppMethodBeat.o(146964);
      return 1;
    }
    AppMethodBeat.o(146964);
    return 0;
  }
  
  private int isVivoKTVLoopback()
  {
    AppMethodBeat.i(146966);
    if ((mVivoKTVHelper != null) && (isSupportVivoKTVHelper))
    {
      int i = mVivoKTVHelper.getPlayFeedbackParam();
      AppMethodBeat.o(146966);
      return i;
    }
    AppMethodBeat.o(146966);
    return 0;
  }
  
  private void onOutputChanage(String paramString)
  {
    AppMethodBeat.i(65779);
    a.dUd();
    a.iP("TRAE", " onOutputChanage:".concat(String.valueOf(paramString)));
    setAudioRouteSwitchState(paramString);
    if (!TraeAudioManager.isCloseSystemAPM(this._modePolicy))
    {
      AppMethodBeat.o(65779);
      return;
    }
    if ((this._deviceStat == 1) || (this._deviceStat == 5) || (this._deviceStat == 2) || (this._deviceStat == 3))
    {
      AppMethodBeat.o(65779);
      return;
    }
    this._connectedDev = paramString;
    a.dUd();
    StringBuilder localStringBuilder = new StringBuilder(" onOutputChanage:").append(paramString);
    Object localObject;
    if (this._audioManager == null)
    {
      localObject = " am==null";
      localStringBuilder = localStringBuilder.append((String)localObject).append(" st:").append(this._streamType);
      if (this._audioTrack != null) {
        break label301;
      }
      localObject = "_audioTrack==null";
      label152:
      a.iP("TRAE", (String)localObject);
    }
    for (;;)
    {
      try
      {
        if (this._audioManager == null) {
          this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
        }
        a.dUd();
        localObject = new StringBuilder(" curr mode:").append(paramString);
        if (this._audioManager != null) {
          continue;
        }
        paramString = "am==null";
        a.iP("TRAE", paramString);
        if ((this._audioManager != null) && (this._connectedDev.equals("DEVICE_SPEAKERPHONE"))) {
          this._audioManager.setMode(0);
        }
      }
      catch (Exception paramString)
      {
        label301:
        a.dUd();
        a.iP("TRAE", paramString.getMessage());
        continue;
      }
      this._audioRouteChanged = true;
      AppMethodBeat.o(65779);
      return;
      localObject = " mode:" + this._audioManager.getMode();
      break;
      localObject = " at.st:" + this._audioTrack.getStreamType();
      break label152;
      paramString = " mode:" + this._audioManager.getMode();
    }
  }
  
  private void setAudioRouteSwitchState(String paramString)
  {
    AppMethodBeat.i(65785);
    if (paramString.equals("DEVICE_EARPHONE"))
    {
      this.switchState = 1;
      AppMethodBeat.o(65785);
      return;
    }
    if (paramString.equals("DEVICE_SPEAKERPHONE"))
    {
      this.switchState = 2;
      AppMethodBeat.o(65785);
      return;
    }
    if (paramString.equals("DEVICE_WIREDHEADSET"))
    {
      this.switchState = 3;
      AppMethodBeat.o(65785);
      return;
    }
    if (paramString.equals("DEVICE_BLUETOOTHHEADSET"))
    {
      this.switchState = 4;
      AppMethodBeat.o(65785);
      return;
    }
    this.switchState = 0;
    AppMethodBeat.o(65785);
  }
  
  private int startService(String paramString)
  {
    AppMethodBeat.i(146957);
    a.dUd();
    a.iP("TRAE", "initTRAEAudioManager , TraeAudioSession startService: " + this._asAudioManager + " deviceConfig:" + paramString);
    if (this._asAudioManager != null)
    {
      int i = this._asAudioManager.startService(paramString);
      AppMethodBeat.o(146957);
      return i;
    }
    AppMethodBeat.o(146957);
    return -1;
  }
  
  private int stopService()
  {
    AppMethodBeat.i(146958);
    a.dUd();
    a.iP("TRAE", "initTRAEAudioManager , TraeAudioSession stopService: " + this._asAudioManager);
    if (this._asAudioManager != null)
    {
      int i = this._asAudioManager.stopService();
      AppMethodBeat.o(146958);
      return i;
    }
    AppMethodBeat.o(146958);
    return -1;
  }
  
  private void uninitTRAEAudioManager()
  {
    AppMethodBeat.i(65787);
    if (this._context != null)
    {
      a.dUd();
      a.iP("TRAE", "uninitTRAEAudioManager , stopService");
      if (this._asAudioManager != null)
      {
        this._asAudioManager.stopService();
        this._asAudioManager.release();
        this._asAudioManager = null;
        AppMethodBeat.o(65787);
      }
    }
    else
    {
      a.dUd();
      a.iP("TRAE", "uninitTRAEAudioManager , context null");
    }
    AppMethodBeat.o(65787);
  }
  
  public int call_postprocess()
  {
    AppMethodBeat.i(65781);
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
    AppMethodBeat.o(65781);
    return 0;
  }
  
  public int call_postprocess_media()
  {
    AppMethodBeat.i(65783);
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
    AppMethodBeat.o(65783);
    return 0;
  }
  
  public int call_preprocess()
  {
    AppMethodBeat.i(65780);
    LogTraceEntry("");
    this.switchState = 0;
    this._streamType = TraeAudioManager.getAudioStreamType(this._audioStreamTypePolicy);
    if (this._as == null) {
      this._as = new TraeAudioSession(this._context, new AudioDeviceInterface.1(this));
    }
    this._preDone = false;
    if (this._as != null) {
      this._prelock.lock();
    }
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
              a.dUd();
              a.iO("TRAE", "call_preprocess waiting...  mode:" + this._audioManager.getMode());
              Thread.sleep(500L);
              i -= 1;
              continue;
            }
          }
          if (this._audioManager.isMicrophoneMute())
          {
            this._audioManager.setMicrophoneMute(false);
            a.dUd();
            a.iO("TRAE", "media call_preprocess setMicrophoneMute false");
          }
        }
        this._as.voiceCallPreprocess(this._modePolicy, this._streamType);
        this._as.connectHighestPriorityDevice();
        i = 7;
        if (i <= 0) {}
      }
      catch (InterruptedException localInterruptedException1)
      {
        int i;
        this._prelock.unlock();
        continue;
      }
      finally
      {
        this._prelock.unlock();
        AppMethodBeat.o(65780);
      }
      try
      {
        if (!this._preDone)
        {
          this._precon.await(1L, TimeUnit.SECONDS);
          a.dUd();
          a.iO("TRAE", "call_preprocess waiting...  as:" + this._as);
          i -= 1;
        }
        else
        {
          a.dUd();
          a.iO("TRAE", "call_preprocess done!");
        }
      }
      catch (InterruptedException localInterruptedException2) {}
    }
    this._as.getConnectedDevice();
    this._prelock.unlock();
    LogTraceExit();
    AppMethodBeat.o(65780);
    return 0;
  }
  
  public int call_preprocess_media()
  {
    AppMethodBeat.i(65782);
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
      this._as = new TraeAudioSession(this._context, new AudioDeviceInterface.2(this));
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
            a.dUd();
            a.iO("TRAE", "media call_preprocess_media waiting...  mode:" + this._audioManager.getMode());
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
          a.dUd();
          a.iO("TRAE", "media call_preprocess_media setMicrophoneMute false");
        }
      }
      this._as.connectHighestPriorityDevice();
      this._as.getConnectedDevice();
      a.dUd();
      a.iO("TRAE", "call_preprocess_media done!");
      label276:
      LogTraceExit();
    }
    catch (InterruptedException localInterruptedException)
    {
      break label276;
    }
    AppMethodBeat.o(65782);
    return 0;
  }
  
  @SuppressLint({"NewApi"})
  public int checkAACMediaCodecSupported(boolean paramBoolean)
  {
    AppMethodBeat.i(146976);
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
              AppMethodBeat.o(146976);
              return 0;
            }
            String[] arrayOfString2 = arrayOfString1.getSupportedTypes();
            j = 0;
            while (j < arrayOfString2.length)
            {
              if (arrayOfString2[j].equalsIgnoreCase("audio/mp4a-latm"))
              {
                a.dUd();
                a.iP("TRAE", "checkAACSupported support!, " + arrayOfString1.getName());
                AppMethodBeat.o(146976);
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
            AppMethodBeat.o(146976);
            return 0;
          }
          arrayOfString1 = ((MediaCodecInfo)localObject).getSupportedTypes();
          j = 0;
          while (j < arrayOfString1.length)
          {
            if (arrayOfString1[j].equalsIgnoreCase("audio/mp4a-latm"))
            {
              a.dUd();
              a.iP("TRAE", "checkAACSupported support!, " + ((MediaCodecInfo)localObject).getName());
              AppMethodBeat.o(146976);
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
      a.dUd();
      a.iO("TRAE", "Error when checking aac codec availability");
      AppMethodBeat.o(146976);
    }
  }
  
  public int checkAACSupported()
  {
    AppMethodBeat.i(146975);
    int i = checkAACMediaCodecSupported(false);
    int j = checkAACMediaCodecSupported(true);
    a.dUd();
    a.iP("TRAE", "checkAACSupported isSupportEncoder: " + i + ", isSupportDecoder:" + j);
    if ((i == 1) && (j == 1))
    {
      AppMethodBeat.o(146975);
      return 1;
    }
    AppMethodBeat.o(146975);
    return 0;
  }
  
  public int getAudioRouteSwitchState()
  {
    return this.switchState;
  }
  
  public int getNumberOfCPUCores()
  {
    int i = -1;
    AppMethodBeat.i(146962);
    if (Build.VERSION.SDK_INT <= 10)
    {
      AppMethodBeat.o(146962);
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
    AppMethodBeat.o(146962);
    return i;
  }
  
  public int hasLightSensorManager()
  {
    AppMethodBeat.i(146960);
    if (this._context == null)
    {
      AppMethodBeat.o(146960);
      return 1;
    }
    try
    {
      Sensor localSensor = ((SensorManager)this._context.getSystemService("sensor")).getDefaultSensor(5);
      if (localSensor == null)
      {
        a.dUd();
        a.iP("TRAE", "not hasLightSensorManager null == sensor8");
        AppMethodBeat.o(146960);
        return 0;
      }
    }
    catch (Exception localException)
    {
      a.dUd();
      a.iP("TRAE", localException.getMessage());
      AppMethodBeat.o(146960);
      return 1;
    }
    a.dUd();
    a.iP("TRAE", "hasLightSensorManager");
    AppMethodBeat.o(146960);
    return 1;
  }
  
  public void setContext(Context paramContext)
  {
    this._context = paramContext;
  }
  
  public void setJavaInterface(int paramInt)
  {
    AppMethodBeat.i(65784);
    if (paramInt == 0) {}
    for (this.usingJava = false;; this.usingJava = true)
    {
      a.dUd();
      a.iP("TRAE", "setJavaInterface flg:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(65784);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.AudioDeviceInterface
 * JD-Core Version:    0.7.0.1
 */