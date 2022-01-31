package com.tencent.rtmp.sharp.jni;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@TargetApi(16)
public class AudioDeviceInterface
{
  private static boolean _dumpEnable = false;
  private static boolean _logEnable = true;
  private TraeAudioSession _as = null;
  private AudioManager _audioManager = null;
  private AudioRecord _audioRecord = null;
  private boolean _audioRouteChanged = false;
  private int _audioSource = 0;
  private int _audioSourcePolicy = -1;
  private int _audioStreamTypePolicy = -1;
  private AudioTrack _audioTrack = null;
  private int _bufferedPlaySamples = 0;
  private int _bufferedRecSamples = 0;
  private int _channelOutType = 4;
  private String _connectedDev = "DEVICE_NONE";
  private Context _context = null;
  private boolean _doPlayInit = true;
  private boolean _doRecInit = true;
  private TraeAudioSession _init_as = null;
  private boolean _isPlaying = false;
  private boolean _isRecording = false;
  private int _modePolicy = -1;
  private ByteBuffer _playBuffer;
  private final ReentrantLock _playLock = new ReentrantLock();
  private int _playPosition = 0;
  private int _playSamplerate = 8000;
  private File _play_dump = null;
  private FileOutputStream _play_out = null;
  private boolean _preDone = false;
  private Condition _precon = this._prelock.newCondition();
  private ReentrantLock _prelock = new ReentrantLock();
  private ByteBuffer _recBuffer;
  private final ReentrantLock _recLock = new ReentrantLock();
  private File _rec_dump = null;
  private FileOutputStream _rec_out = null;
  private int _sceneModeKey = 0;
  private int _sessionId = 0;
  private int _streamType = 0;
  private byte[] _tempBufPlay;
  private byte[] _tempBufRec;
  private int switchState = 0;
  private boolean usingJava = true;
  
  public AudioDeviceInterface()
  {
    try
    {
      this._playBuffer = ByteBuffer.allocateDirect(1920);
      this._recBuffer = ByteBuffer.allocateDirect(1920);
      this._tempBufPlay = new byte[1920];
      this._tempBufRec = new byte[1920];
      int i = Build.VERSION.SDK_INT;
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "AudioDeviceInterface apiLevel:" + i);
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
  
  private int GetPlayoutVolume()
  {
    if ((this._audioManager == null) && (this._context != null)) {
      this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
    }
    int i = -1;
    if (this._audioManager != null) {
      i = this._audioManager.getStreamVolume(0);
    }
    return i;
  }
  
  /* Error */
  private int InitPlayback(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   3: ifeq +25 -> 28
    //   6: ldc 182
    //   8: iconst_2
    //   9: new 184	java/lang/StringBuilder
    //   12: dup
    //   13: ldc 241
    //   15: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   18: iload_1
    //   19: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   22: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokestatic 201	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   28: aload_0
    //   29: getfield 117	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   32: ifne +15 -> 47
    //   35: aload_0
    //   36: getfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   39: ifnonnull +8 -> 47
    //   42: iload_2
    //   43: iconst_2
    //   44: if_icmple +36 -> 80
    //   47: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   50: ifeq +28 -> 78
    //   53: ldc 182
    //   55: iconst_2
    //   56: new 184	java/lang/StringBuilder
    //   59: dup
    //   60: ldc 243
    //   62: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   65: aload_0
    //   66: getfield 117	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   69: invokevirtual 246	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   72: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 249	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   78: iconst_m1
    //   79: ireturn
    //   80: aload_0
    //   81: getfield 102	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   84: ifnonnull +19 -> 103
    //   87: aload_0
    //   88: aload_0
    //   89: getfield 94	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_context	Landroid/content/Context;
    //   92: ldc 225
    //   94: invokevirtual 231	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   97: checkcast 233	android/media/AudioManager
    //   100: putfield 102	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   103: iload_2
    //   104: iconst_2
    //   105: if_icmpne +497 -> 602
    //   108: aload_0
    //   109: bipush 12
    //   111: putfield 86	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_channelOutType	I
    //   114: aload_0
    //   115: iload_1
    //   116: putfield 84	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playSamplerate	I
    //   119: iload_1
    //   120: aload_0
    //   121: getfield 86	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_channelOutType	I
    //   124: iconst_2
    //   125: invokestatic 255	android/media/AudioTrack:getMinBufferSize	(III)I
    //   128: istore 6
    //   130: aload_0
    //   131: getfield 86	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_channelOutType	I
    //   134: bipush 12
    //   136: if_icmpne +18 -> 154
    //   139: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   142: ifeq +468 -> 610
    //   145: ldc 182
    //   147: iconst_2
    //   148: ldc_w 257
    //   151: invokestatic 201	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: iload_1
    //   155: bipush 20
    //   157: imul
    //   158: iconst_1
    //   159: imul
    //   160: iconst_2
    //   161: imul
    //   162: sipush 1000
    //   165: idiv
    //   166: istore_2
    //   167: aload_0
    //   168: getfield 86	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_channelOutType	I
    //   171: bipush 12
    //   173: if_icmpne +722 -> 895
    //   176: iload_2
    //   177: iconst_2
    //   178: imul
    //   179: istore_2
    //   180: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   183: ifeq +37 -> 220
    //   186: ldc 182
    //   188: iconst_2
    //   189: new 184	java/lang/StringBuilder
    //   192: dup
    //   193: ldc_w 259
    //   196: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   199: iload 6
    //   201: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   204: ldc_w 261
    //   207: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: iload_2
    //   211: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   214: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 201	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   220: aload_0
    //   221: iconst_0
    //   222: putfield 121	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_bufferedPlaySamples	I
    //   225: aload_0
    //   226: getfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   229: ifnull +15 -> 244
    //   232: aload_0
    //   233: getfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   236: invokevirtual 264	android/media/AudioTrack:release	()V
    //   239: aload_0
    //   240: aconst_null
    //   241: putfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   244: iconst_4
    //   245: newarray int
    //   247: astore 7
    //   249: aload 7
    //   251: dup
    //   252: iconst_0
    //   253: iconst_0
    //   254: iastore
    //   255: dup
    //   256: iconst_1
    //   257: iconst_0
    //   258: iastore
    //   259: dup
    //   260: iconst_2
    //   261: iconst_3
    //   262: iastore
    //   263: dup
    //   264: iconst_3
    //   265: iconst_1
    //   266: iastore
    //   267: pop
    //   268: aload_0
    //   269: aload_0
    //   270: getfield 100	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioStreamTypePolicy	I
    //   273: invokestatic 269	com/tencent/rtmp/sharp/jni/TraeAudioManager:getAudioStreamType	(I)I
    //   276: putfield 82	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   279: aload_0
    //   280: getfield 139	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioRouteChanged	Z
    //   283: ifeq +81 -> 364
    //   286: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   289: ifeq +42 -> 331
    //   292: ldc 182
    //   294: iconst_2
    //   295: new 184	java/lang/StringBuilder
    //   298: dup
    //   299: ldc_w 271
    //   302: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   305: aload_0
    //   306: getfield 139	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioRouteChanged	Z
    //   309: invokevirtual 246	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   312: ldc_w 273
    //   315: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: aload_0
    //   319: getfield 82	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   322: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   325: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokestatic 201	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   331: aload_0
    //   332: getfield 102	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   335: invokevirtual 276	android/media/AudioManager:getMode	()I
    //   338: ifne +298 -> 636
    //   341: aload_0
    //   342: getfield 137	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_connectedDev	Ljava/lang/String;
    //   345: ldc_w 278
    //   348: invokevirtual 284	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   351: ifeq +285 -> 636
    //   354: aload_0
    //   355: iconst_3
    //   356: putfield 82	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   359: aload_0
    //   360: iconst_0
    //   361: putfield 139	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioRouteChanged	Z
    //   364: aload 7
    //   366: iconst_0
    //   367: aload_0
    //   368: getfield 82	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   371: iastore
    //   372: iconst_0
    //   373: istore_3
    //   374: iload 6
    //   376: istore_1
    //   377: iload_3
    //   378: iconst_4
    //   379: if_icmpge +339 -> 718
    //   382: aload_0
    //   383: getfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   386: ifnonnull +332 -> 718
    //   389: aload_0
    //   390: aload 7
    //   392: iload_3
    //   393: iaload
    //   394: putfield 82	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   397: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   400: ifeq +43 -> 443
    //   403: ldc 182
    //   405: iconst_2
    //   406: new 184	java/lang/StringBuilder
    //   409: dup
    //   410: ldc_w 286
    //   413: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   416: iload 6
    //   418: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   421: ldc_w 288
    //   424: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: aload_0
    //   428: getfield 82	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   431: invokestatic 291	android/media/AudioTrack:getNativeOutputSampleRate	(I)I
    //   434: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   437: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   440: invokestatic 201	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   443: iconst_1
    //   444: istore 4
    //   446: iload 4
    //   448: iconst_2
    //   449: if_icmpgt +262 -> 711
    //   452: iload 6
    //   454: iload 4
    //   456: imul
    //   457: istore 5
    //   459: iload 5
    //   461: iload_2
    //   462: iconst_4
    //   463: imul
    //   464: if_icmpge +9 -> 473
    //   467: iload 4
    //   469: iconst_2
    //   470: if_icmplt +99 -> 569
    //   473: aload_0
    //   474: new 251	android/media/AudioTrack
    //   477: dup
    //   478: aload_0
    //   479: getfield 82	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   482: aload_0
    //   483: getfield 84	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playSamplerate	I
    //   486: aload_0
    //   487: getfield 86	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_channelOutType	I
    //   490: iconst_2
    //   491: iload 5
    //   493: iconst_1
    //   494: invokespecial 294	android/media/AudioTrack:<init>	(IIIIII)V
    //   497: putfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   500: iload 5
    //   502: istore_1
    //   503: aload_0
    //   504: getfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   507: invokevirtual 297	android/media/AudioTrack:getState	()I
    //   510: iconst_1
    //   511: if_icmpeq +200 -> 711
    //   514: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   517: ifeq +40 -> 557
    //   520: ldc 182
    //   522: iconst_2
    //   523: new 184	java/lang/StringBuilder
    //   526: dup
    //   527: ldc_w 299
    //   530: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   533: iload 5
    //   535: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   538: ldc_w 301
    //   541: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: aload_0
    //   545: getfield 84	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playSamplerate	I
    //   548: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   551: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   554: invokestatic 201	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   557: aload_0
    //   558: getfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   561: invokevirtual 264	android/media/AudioTrack:release	()V
    //   564: aload_0
    //   565: aconst_null
    //   566: putfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   569: iload 4
    //   571: iconst_1
    //   572: iadd
    //   573: istore 4
    //   575: iload 5
    //   577: istore_1
    //   578: goto -132 -> 446
    //   581: astore 7
    //   583: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   586: ifeq +14 -> 600
    //   589: ldc 182
    //   591: iconst_2
    //   592: aload 7
    //   594: invokevirtual 221	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   597: invokestatic 201	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   600: iconst_m1
    //   601: ireturn
    //   602: aload_0
    //   603: iconst_4
    //   604: putfield 86	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_channelOutType	I
    //   607: goto -493 -> 114
    //   610: aload_0
    //   611: getfield 86	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_channelOutType	I
    //   614: iconst_4
    //   615: if_icmpne -461 -> 154
    //   618: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   621: ifeq -467 -> 154
    //   624: ldc 182
    //   626: iconst_2
    //   627: ldc_w 303
    //   630: invokestatic 201	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   633: goto -479 -> 154
    //   636: aload_0
    //   637: iconst_0
    //   638: putfield 82	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   641: goto -282 -> 359
    //   644: astore 8
    //   646: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   649: ifeq +40 -> 689
    //   652: ldc 182
    //   654: iconst_2
    //   655: new 184	java/lang/StringBuilder
    //   658: dup
    //   659: invokespecial 304	java/lang/StringBuilder:<init>	()V
    //   662: aload 8
    //   664: invokevirtual 221	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   667: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: ldc_w 306
    //   673: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: aload_0
    //   677: getfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   680: invokevirtual 309	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   683: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   686: invokestatic 201	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   689: aload_0
    //   690: getfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   693: ifnull +10 -> 703
    //   696: aload_0
    //   697: getfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   700: invokevirtual 264	android/media/AudioTrack:release	()V
    //   703: aload_0
    //   704: aconst_null
    //   705: putfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   708: goto -139 -> 569
    //   711: iload_3
    //   712: iconst_1
    //   713: iadd
    //   714: istore_3
    //   715: goto -338 -> 377
    //   718: aload_0
    //   719: getfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   722: ifnonnull +20 -> 742
    //   725: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   728: ifeq +12 -> 740
    //   731: ldc 182
    //   733: iconst_2
    //   734: ldc_w 311
    //   737: invokestatic 201	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   740: iconst_m1
    //   741: ireturn
    //   742: aload_0
    //   743: getfield 133	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_as	Lcom/tencent/rtmp/sharp/jni/TraeAudioSession;
    //   746: ifnull +29 -> 775
    //   749: aload_0
    //   750: getfield 102	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   753: ifnull +22 -> 775
    //   756: aload_0
    //   757: getfield 133	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_as	Lcom/tencent/rtmp/sharp/jni/TraeAudioSession;
    //   760: aload_0
    //   761: getfield 102	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   764: invokevirtual 276	android/media/AudioManager:getMode	()I
    //   767: aload_0
    //   768: getfield 82	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   771: invokevirtual 316	com/tencent/rtmp/sharp/jni/TraeAudioSession:voiceCallAudioParamChanged	(II)I
    //   774: pop
    //   775: aload_0
    //   776: aload_0
    //   777: getfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   780: invokevirtual 319	android/media/AudioTrack:getPlaybackHeadPosition	()I
    //   783: putfield 123	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playPosition	I
    //   786: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   789: ifeq +65 -> 854
    //   792: ldc 182
    //   794: iconst_2
    //   795: new 184	java/lang/StringBuilder
    //   798: dup
    //   799: ldc_w 321
    //   802: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   805: aload_0
    //   806: getfield 82	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   809: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   812: ldc_w 323
    //   815: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   818: aload_0
    //   819: getfield 84	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playSamplerate	I
    //   822: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   825: ldc_w 325
    //   828: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   831: aload_0
    //   832: getfield 123	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playPosition	I
    //   835: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   838: ldc_w 327
    //   841: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   844: iload_1
    //   845: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   848: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   851: invokestatic 201	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   854: aload_0
    //   855: getfield 102	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   858: astore 7
    //   860: aload_0
    //   861: getfield 137	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_connectedDev	Ljava/lang/String;
    //   864: ldc_w 329
    //   867: invokevirtual 284	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   870: ifeq +14 -> 884
    //   873: bipush 6
    //   875: istore_1
    //   876: aload 7
    //   878: iload_1
    //   879: invokestatic 333	com/tencent/rtmp/sharp/jni/TraeAudioManager:forceVolumeControlStream	(Landroid/media/AudioManager;I)V
    //   882: iconst_0
    //   883: ireturn
    //   884: aload_0
    //   885: getfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   888: invokevirtual 336	android/media/AudioTrack:getStreamType	()I
    //   891: istore_1
    //   892: goto -16 -> 876
    //   895: goto -715 -> 180
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	898	0	this	AudioDeviceInterface
    //   0	898	1	paramInt1	int
    //   0	898	2	paramInt2	int
    //   373	342	3	i	int
    //   444	130	4	j	int
    //   457	119	5	k	int
    //   128	329	6	m	int
    //   247	144	7	arrayOfInt	int[]
    //   581	12	7	localException1	Exception
    //   858	19	7	localAudioManager	AudioManager
    //   644	19	8	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   87	103	581	java/lang/Exception
    //   473	500	644	java/lang/Exception
  }
  
  private int InitRecording(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "InitRecording entry:" + paramInt1);
    }
    if ((this._isRecording) || (this._audioRecord != null) || (paramInt2 > 2))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "InitRecording _isRecording:" + this._isRecording);
      }
      return -1;
    }
    int i = 16;
    if (paramInt2 == 2) {
      i = 12;
    }
    int n = AudioRecord.getMinBufferSize(paramInt1, i, 2);
    int i1 = paramInt1 * 20 * paramInt2 * 2 / 1000;
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "InitRecording: min rec buf size is " + n + " sr:" + getLowlatencySamplerate() + " fp" + getLowlatencyFramesPerBuffer() + " 20msFZ:" + i1);
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
    int j = 0;
    paramInt2 = n;
    while ((j < 4) && (this._audioRecord == null))
    {
      this._audioSource = arrayOfInt[j];
      int k = 1;
      for (;;)
      {
        if (k > 2) {
          break label516;
        }
        int m = n * k;
        if ((m >= i1 * 4) || (k >= 2)) {}
        try
        {
          this._audioRecord = new AudioRecord(this._audioSource, paramInt1, i, 2, m);
          paramInt2 = m;
          if (this._audioRecord.getState() == 1) {
            break label516;
          }
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "InitRecording:  rec not initialized,try agine,  minbufsize:" + m + " sr:" + paramInt1 + " as:" + this._audioSource);
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
        k += 1;
        paramInt2 = m;
      }
      label516:
      j += 1;
    }
    if (this._audioRecord == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "InitRecording fail!!!");
      }
      return -1;
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, " [Config] InitRecording: audioSession:" + this._sessionId + " audioSource:" + this._audioSource + " rec sample rate set to " + paramInt1 + " recBufSize:" + paramInt2);
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "InitRecording exit");
    }
    return this._bufferedRecSamples;
  }
  
  private int InitSetting(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this._audioSourcePolicy = paramInt1;
    this._audioStreamTypePolicy = paramInt2;
    this._modePolicy = paramInt3;
    this._sceneModeKey = paramInt4;
    if ((this._sceneModeKey == 1) || (this._sceneModeKey == 2) || (this._sceneModeKey == 3)) {}
    for (TraeAudioManager.IsMusicScene = true;; TraeAudioManager.IsMusicScene = false)
    {
      TraeAudioManager.IsUpdateSceneFlag = true;
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "InitSetting: _audioSourcePolicy:" + this._audioSourcePolicy + " _audioStreamTypePolicy:" + this._audioStreamTypePolicy + " _modePolicy:" + this._modePolicy + " sceneModeKey:" + paramInt4);
      }
      return 0;
    }
  }
  
  public static final void LogTraceEntry(String paramString)
  {
    if (!_logEnable) {}
    do
    {
      return;
      paramString = getTraceInfo() + " entry:" + paramString;
    } while (!QLog.isColorLevel());
    QLog.w("TRAE", 2, paramString);
  }
  
  public static final void LogTraceExit()
  {
    if (!_logEnable) {}
    String str;
    do
    {
      return;
      str = getTraceInfo() + " exit";
    } while (!QLog.isColorLevel());
    QLog.w("TRAE", 2, str);
  }
  
  private int OpenslesNeedResetAudioTrack(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (!TraeAudioManager.isCloseSystemAPM(this._modePolicy)) {
          return -1;
        }
        if ((this._audioRouteChanged) || (paramBoolean))
        {
          if ((this._audioManager == null) && (this._context != null)) {
            this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
          }
          if (this._audioManager == null) {
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
        localException = localException;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("TRAE", 2, "PlayAudio Exception: " + localException.getMessage());
        continue;
      }
      finally {}
      return this._audioStreamTypePolicy;
      this._audioStreamTypePolicy = 0;
    }
  }
  
  /* Error */
  private int PlayAudio(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 117	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   4: ifne +67 -> 71
    //   7: iconst_1
    //   8: istore_2
    //   9: aload_0
    //   10: getfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   13: ifnonnull +63 -> 76
    //   16: iconst_1
    //   17: istore_3
    //   18: iload_2
    //   19: iload_3
    //   20: ior
    //   21: ifeq +60 -> 81
    //   24: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   27: ifeq +42 -> 69
    //   30: ldc 182
    //   32: iconst_2
    //   33: new 184	java/lang/StringBuilder
    //   36: dup
    //   37: ldc_w 424
    //   40: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   43: aload_0
    //   44: getfield 117	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   47: invokevirtual 246	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   50: ldc_w 426
    //   53: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_0
    //   57: getfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   60: invokevirtual 309	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 249	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   69: iconst_m1
    //   70: ireturn
    //   71: iconst_0
    //   72: istore_2
    //   73: goto -64 -> 9
    //   76: iconst_0
    //   77: istore_3
    //   78: goto -60 -> 18
    //   81: aload_0
    //   82: getfield 107	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   85: invokevirtual 429	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   88: aload_0
    //   89: getfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   92: astore 10
    //   94: aload 10
    //   96: ifnonnull +13 -> 109
    //   99: aload_0
    //   100: getfield 107	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   103: invokevirtual 432	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   106: bipush 254
    //   108: ireturn
    //   109: aload_0
    //   110: getfield 111	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_doPlayInit	Z
    //   113: istore 7
    //   115: iload 7
    //   117: iconst_1
    //   118: if_icmpne +13 -> 131
    //   121: bipush 237
    //   123: invokestatic 438	android/os/Process:setThreadPriority	(I)V
    //   126: aload_0
    //   127: iconst_0
    //   128: putfield 111	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_doPlayInit	Z
    //   131: getstatic 68	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_dumpEnable	Z
    //   134: ifeq +27 -> 161
    //   137: aload_0
    //   138: getfield 131	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_play_out	Ljava/io/FileOutputStream;
    //   141: astore 10
    //   143: aload 10
    //   145: ifnull +16 -> 161
    //   148: aload_0
    //   149: getfield 131	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_play_out	Ljava/io/FileOutputStream;
    //   152: aload_0
    //   153: getfield 167	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_tempBufPlay	[B
    //   156: iconst_0
    //   157: iconst_0
    //   158: invokevirtual 444	java/io/FileOutputStream:write	([BII)V
    //   161: aload_0
    //   162: getfield 139	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioRouteChanged	Z
    //   165: ifne +598 -> 763
    //   168: iconst_0
    //   169: istore_2
    //   170: aload_0
    //   171: getfield 163	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playBuffer	Ljava/nio/ByteBuffer;
    //   174: aload_0
    //   175: getfield 167	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_tempBufPlay	[B
    //   178: invokevirtual 448	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   181: pop
    //   182: iload_2
    //   183: ifeq +903 -> 1086
    //   186: aload_0
    //   187: getfield 163	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playBuffer	Ljava/nio/ByteBuffer;
    //   190: invokevirtual 452	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   193: pop
    //   194: invokestatic 458	android/os/SystemClock:elapsedRealtime	()J
    //   197: lstore 8
    //   199: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   202: ifeq +45 -> 247
    //   205: ldc 182
    //   207: iconst_2
    //   208: new 184	java/lang/StringBuilder
    //   211: dup
    //   212: ldc_w 460
    //   215: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   218: aload_0
    //   219: getfield 82	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   222: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   225: ldc_w 462
    //   228: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: aload_0
    //   232: getfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   235: invokevirtual 336	android/media/AudioTrack:getStreamType	()I
    //   238: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   241: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokestatic 201	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   247: aload_0
    //   248: getfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   251: invokevirtual 465	android/media/AudioTrack:getPlayState	()I
    //   254: istore_2
    //   255: iload_2
    //   256: iconst_3
    //   257: if_icmpne +114 -> 371
    //   260: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   263: ifeq +12 -> 275
    //   266: ldc 182
    //   268: iconst_2
    //   269: ldc_w 467
    //   272: invokestatic 201	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   275: aload_0
    //   276: getfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   279: invokevirtual 470	android/media/AudioTrack:stop	()V
    //   282: aload_0
    //   283: getfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   286: invokevirtual 473	android/media/AudioTrack:flush	()V
    //   289: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   292: ifeq +32 -> 324
    //   295: ldc 182
    //   297: iconst_2
    //   298: new 184	java/lang/StringBuilder
    //   301: dup
    //   302: ldc_w 475
    //   305: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   308: aload_0
    //   309: getfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   312: invokevirtual 465	android/media/AudioTrack:getPlayState	()I
    //   315: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   318: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: invokestatic 201	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   324: aload_0
    //   325: getfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   328: invokevirtual 264	android/media/AudioTrack:release	()V
    //   331: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   334: ifeq +32 -> 366
    //   337: ldc 182
    //   339: iconst_2
    //   340: new 184	java/lang/StringBuilder
    //   343: dup
    //   344: ldc_w 477
    //   347: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   350: aload_0
    //   351: getfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   354: invokevirtual 465	android/media/AudioTrack:getPlayState	()I
    //   357: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   360: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: invokestatic 201	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   366: aload_0
    //   367: aconst_null
    //   368: putfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   371: aload_0
    //   372: getfield 84	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playSamplerate	I
    //   375: aload_0
    //   376: getfield 86	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_channelOutType	I
    //   379: iconst_2
    //   380: invokestatic 255	android/media/AudioTrack:getMinBufferSize	(III)I
    //   383: istore 5
    //   385: iconst_4
    //   386: newarray int
    //   388: astore 10
    //   390: aload 10
    //   392: dup
    //   393: iconst_0
    //   394: iconst_0
    //   395: iastore
    //   396: dup
    //   397: iconst_1
    //   398: iconst_0
    //   399: iastore
    //   400: dup
    //   401: iconst_2
    //   402: iconst_3
    //   403: iastore
    //   404: dup
    //   405: iconst_3
    //   406: iconst_1
    //   407: iastore
    //   408: pop
    //   409: aload 10
    //   411: iconst_0
    //   412: aload_0
    //   413: getfield 82	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   416: iastore
    //   417: aload_0
    //   418: getfield 84	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playSamplerate	I
    //   421: bipush 20
    //   423: imul
    //   424: iconst_1
    //   425: imul
    //   426: iconst_2
    //   427: imul
    //   428: sipush 1000
    //   431: idiv
    //   432: istore_2
    //   433: aload_0
    //   434: getfield 86	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_channelOutType	I
    //   437: bipush 12
    //   439: if_icmpne +850 -> 1289
    //   442: iload_2
    //   443: iconst_2
    //   444: imul
    //   445: istore_2
    //   446: goto +843 -> 1289
    //   449: iload_3
    //   450: iconst_4
    //   451: if_icmpge +506 -> 957
    //   454: aload_0
    //   455: getfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   458: ifnonnull +499 -> 957
    //   461: aload_0
    //   462: aload 10
    //   464: iload_3
    //   465: iaload
    //   466: putfield 82	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   469: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   472: ifeq +43 -> 515
    //   475: ldc 182
    //   477: iconst_2
    //   478: new 184	java/lang/StringBuilder
    //   481: dup
    //   482: ldc_w 286
    //   485: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   488: iload 5
    //   490: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   493: ldc_w 288
    //   496: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: aload_0
    //   500: getfield 82	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   503: invokestatic 291	android/media/AudioTrack:getNativeOutputSampleRate	(I)I
    //   506: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   509: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   512: invokestatic 201	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   515: iconst_1
    //   516: istore 4
    //   518: iload 4
    //   520: iconst_2
    //   521: if_icmpgt +778 -> 1299
    //   524: iload 5
    //   526: iload 4
    //   528: imul
    //   529: istore 6
    //   531: iload 6
    //   533: iload_2
    //   534: iconst_4
    //   535: imul
    //   536: if_icmpge +9 -> 545
    //   539: iload 4
    //   541: iconst_2
    //   542: if_icmplt +128 -> 670
    //   545: aload_0
    //   546: new 251	android/media/AudioTrack
    //   549: dup
    //   550: aload_0
    //   551: getfield 82	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   554: aload_0
    //   555: getfield 84	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playSamplerate	I
    //   558: aload_0
    //   559: getfield 86	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_channelOutType	I
    //   562: iconst_2
    //   563: iload 6
    //   565: iconst_1
    //   566: invokespecial 294	android/media/AudioTrack:<init>	(IIIIII)V
    //   569: putfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   572: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   575: ifeq +29 -> 604
    //   578: ldc 182
    //   580: iconst_2
    //   581: new 184	java/lang/StringBuilder
    //   584: dup
    //   585: ldc_w 306
    //   588: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   591: aload_0
    //   592: getfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   595: invokevirtual 309	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   598: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   601: invokestatic 201	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   604: aload_0
    //   605: getfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   608: invokevirtual 297	android/media/AudioTrack:getState	()I
    //   611: iconst_1
    //   612: if_icmpeq +687 -> 1299
    //   615: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   618: ifeq +40 -> 658
    //   621: ldc 182
    //   623: iconst_2
    //   624: new 184	java/lang/StringBuilder
    //   627: dup
    //   628: ldc_w 299
    //   631: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   634: iload 6
    //   636: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   639: ldc_w 301
    //   642: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: aload_0
    //   646: getfield 84	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playSamplerate	I
    //   649: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   652: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   655: invokestatic 201	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   658: aload_0
    //   659: getfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   662: invokevirtual 264	android/media/AudioTrack:release	()V
    //   665: aload_0
    //   666: aconst_null
    //   667: putfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   670: iload 4
    //   672: iconst_1
    //   673: iadd
    //   674: istore 4
    //   676: goto -158 -> 518
    //   679: astore 10
    //   681: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   684: ifeq -558 -> 126
    //   687: ldc 182
    //   689: iconst_2
    //   690: new 184	java/lang/StringBuilder
    //   693: dup
    //   694: ldc_w 479
    //   697: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   700: aload 10
    //   702: invokevirtual 221	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   705: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   708: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   711: invokestatic 201	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   714: goto -588 -> 126
    //   717: astore 10
    //   719: iconst_0
    //   720: istore_1
    //   721: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   724: ifeq +30 -> 754
    //   727: ldc 182
    //   729: iconst_2
    //   730: new 184	java/lang/StringBuilder
    //   733: dup
    //   734: ldc_w 417
    //   737: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   740: aload 10
    //   742: invokevirtual 221	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   745: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   751: invokestatic 249	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   754: aload_0
    //   755: getfield 107	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   758: invokevirtual 432	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   761: iload_1
    //   762: ireturn
    //   763: aload_0
    //   764: getfield 102	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   767: ifnonnull +26 -> 793
    //   770: aload_0
    //   771: getfield 94	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_context	Landroid/content/Context;
    //   774: ifnull +19 -> 793
    //   777: aload_0
    //   778: aload_0
    //   779: getfield 94	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_context	Landroid/content/Context;
    //   782: ldc 225
    //   784: invokevirtual 231	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   787: checkcast 233	android/media/AudioManager
    //   790: putfield 102	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   793: aload_0
    //   794: getfield 102	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   797: invokevirtual 276	android/media/AudioManager:getMode	()I
    //   800: ifne +57 -> 857
    //   803: aload_0
    //   804: getfield 137	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_connectedDev	Ljava/lang/String;
    //   807: ldc_w 278
    //   810: invokevirtual 284	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   813: ifeq +44 -> 857
    //   816: aload_0
    //   817: iconst_3
    //   818: putfield 82	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   821: aload_0
    //   822: getfield 82	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   825: aload_0
    //   826: getfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   829: invokevirtual 336	android/media/AudioTrack:getStreamType	()I
    //   832: if_icmpne +33 -> 865
    //   835: iconst_0
    //   836: istore_2
    //   837: aload_0
    //   838: iconst_0
    //   839: putfield 139	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioRouteChanged	Z
    //   842: goto -672 -> 170
    //   845: astore 10
    //   847: aload_0
    //   848: getfield 107	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   851: invokevirtual 432	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   854: aload 10
    //   856: athrow
    //   857: aload_0
    //   858: iconst_0
    //   859: putfield 82	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   862: goto -41 -> 821
    //   865: iconst_1
    //   866: istore_2
    //   867: goto -30 -> 837
    //   870: astore 10
    //   872: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   875: ifeq -504 -> 371
    //   878: ldc 182
    //   880: iconst_2
    //   881: ldc_w 481
    //   884: invokestatic 249	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   887: goto -516 -> 371
    //   890: astore 11
    //   892: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   895: ifeq +40 -> 935
    //   898: ldc 182
    //   900: iconst_2
    //   901: new 184	java/lang/StringBuilder
    //   904: dup
    //   905: invokespecial 304	java/lang/StringBuilder:<init>	()V
    //   908: aload 11
    //   910: invokevirtual 221	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   913: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   916: ldc_w 306
    //   919: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   922: aload_0
    //   923: getfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   926: invokevirtual 309	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   929: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   932: invokestatic 201	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   935: aload_0
    //   936: getfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   939: ifnull +10 -> 949
    //   942: aload_0
    //   943: getfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   946: invokevirtual 264	android/media/AudioTrack:release	()V
    //   949: aload_0
    //   950: aconst_null
    //   951: putfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   954: goto -284 -> 670
    //   957: aload_0
    //   958: getfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   961: astore 10
    //   963: aload 10
    //   965: ifnull +57 -> 1022
    //   968: aload_0
    //   969: getfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   972: invokevirtual 484	android/media/AudioTrack:play	()V
    //   975: aload_0
    //   976: getfield 133	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_as	Lcom/tencent/rtmp/sharp/jni/TraeAudioSession;
    //   979: aload_0
    //   980: getfield 102	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   983: invokevirtual 276	android/media/AudioManager:getMode	()I
    //   986: aload_0
    //   987: getfield 82	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_streamType	I
    //   990: invokevirtual 316	com/tencent/rtmp/sharp/jni/TraeAudioSession:voiceCallAudioParamChanged	(II)I
    //   993: pop
    //   994: aload_0
    //   995: getfield 102	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   998: astore 10
    //   1000: aload_0
    //   1001: getfield 137	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_connectedDev	Ljava/lang/String;
    //   1004: ldc_w 329
    //   1007: invokevirtual 284	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1010: ifeq +65 -> 1075
    //   1013: bipush 6
    //   1015: istore_2
    //   1016: aload 10
    //   1018: iload_2
    //   1019: invokestatic 333	com/tencent/rtmp/sharp/jni/TraeAudioManager:forceVolumeControlStream	(Landroid/media/AudioManager;I)V
    //   1022: iload_1
    //   1023: istore_2
    //   1024: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   1027: ifeq +39 -> 1066
    //   1030: ldc 182
    //   1032: iconst_2
    //   1033: new 184	java/lang/StringBuilder
    //   1036: dup
    //   1037: ldc_w 486
    //   1040: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1043: invokestatic 458	android/os/SystemClock:elapsedRealtime	()J
    //   1046: lload 8
    //   1048: lsub
    //   1049: invokevirtual 489	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1052: ldc_w 491
    //   1055: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1058: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1061: invokestatic 249	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1064: iload_1
    //   1065: istore_2
    //   1066: aload_0
    //   1067: getfield 107	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1070: invokevirtual 432	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1073: iload_2
    //   1074: ireturn
    //   1075: aload_0
    //   1076: getfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1079: invokevirtual 336	android/media/AudioTrack:getStreamType	()I
    //   1082: istore_2
    //   1083: goto -67 -> 1016
    //   1086: aload_0
    //   1087: getfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1090: aload_0
    //   1091: getfield 167	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_tempBufPlay	[B
    //   1094: iconst_0
    //   1095: iload_1
    //   1096: invokevirtual 494	android/media/AudioTrack:write	([BII)I
    //   1099: istore_2
    //   1100: aload_0
    //   1101: getfield 163	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playBuffer	Ljava/nio/ByteBuffer;
    //   1104: invokevirtual 452	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   1107: pop
    //   1108: iload_2
    //   1109: ifge +57 -> 1166
    //   1112: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   1115: ifeq +42 -> 1157
    //   1118: ldc 182
    //   1120: iconst_2
    //   1121: new 184	java/lang/StringBuilder
    //   1124: dup
    //   1125: ldc_w 496
    //   1128: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1131: iload_2
    //   1132: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1135: ldc_w 498
    //   1138: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1141: iload_1
    //   1142: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1145: ldc_w 500
    //   1148: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1151: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1154: invokestatic 249	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1157: aload_0
    //   1158: getfield 107	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1161: invokevirtual 432	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1164: iconst_m1
    //   1165: ireturn
    //   1166: iload_2
    //   1167: iload_1
    //   1168: if_icmpeq +48 -> 1216
    //   1171: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   1174: ifeq +42 -> 1216
    //   1177: ldc 182
    //   1179: iconst_2
    //   1180: new 184	java/lang/StringBuilder
    //   1183: dup
    //   1184: ldc_w 502
    //   1187: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1190: iload_2
    //   1191: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1194: ldc_w 498
    //   1197: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1200: iload_1
    //   1201: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1204: ldc_w 500
    //   1207: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1210: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1213: invokestatic 249	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1216: aload_0
    //   1217: aload_0
    //   1218: getfield 121	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1221: iload_2
    //   1222: iconst_1
    //   1223: ishr
    //   1224: iadd
    //   1225: putfield 121	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1228: aload_0
    //   1229: getfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1232: invokevirtual 319	android/media/AudioTrack:getPlaybackHeadPosition	()I
    //   1235: istore_1
    //   1236: iload_1
    //   1237: aload_0
    //   1238: getfield 123	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playPosition	I
    //   1241: if_icmpge +8 -> 1249
    //   1244: aload_0
    //   1245: iconst_0
    //   1246: putfield 123	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playPosition	I
    //   1249: aload_0
    //   1250: aload_0
    //   1251: getfield 121	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1254: iload_1
    //   1255: aload_0
    //   1256: getfield 123	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playPosition	I
    //   1259: isub
    //   1260: isub
    //   1261: putfield 121	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1264: aload_0
    //   1265: iload_1
    //   1266: putfield 123	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playPosition	I
    //   1269: goto -203 -> 1066
    //   1272: astore 10
    //   1274: iload_2
    //   1275: istore_1
    //   1276: goto -555 -> 721
    //   1279: astore 10
    //   1281: goto -259 -> 1022
    //   1284: astore 10
    //   1286: goto -1125 -> 161
    //   1289: iconst_0
    //   1290: istore_3
    //   1291: goto -842 -> 449
    //   1294: astore 10
    //   1296: goto -575 -> 721
    //   1299: iload_3
    //   1300: iconst_1
    //   1301: iadd
    //   1302: istore_3
    //   1303: goto -854 -> 449
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1306	0	this	AudioDeviceInterface
    //   0	1306	1	paramInt	int
    //   8	1267	2	i	int
    //   17	1286	3	j	int
    //   516	159	4	k	int
    //   383	146	5	m	int
    //   529	106	6	n	int
    //   113	6	7	bool	boolean
    //   197	850	8	l	long
    //   92	371	10	localObject1	Object
    //   679	22	10	localException1	Exception
    //   717	24	10	localException2	Exception
    //   845	10	10	localObject2	Object
    //   870	1	10	localIllegalStateException	java.lang.IllegalStateException
    //   961	56	10	localObject3	Object
    //   1272	1	10	localException3	Exception
    //   1279	1	10	localException4	Exception
    //   1284	1	10	localIOException	java.io.IOException
    //   1294	1	10	localException5	Exception
    //   890	19	11	localException6	Exception
    // Exception table:
    //   from	to	target	type
    //   121	126	679	java/lang/Exception
    //   88	94	717	java/lang/Exception
    //   109	115	717	java/lang/Exception
    //   126	131	717	java/lang/Exception
    //   131	143	717	java/lang/Exception
    //   148	161	717	java/lang/Exception
    //   161	168	717	java/lang/Exception
    //   170	182	717	java/lang/Exception
    //   681	714	717	java/lang/Exception
    //   763	793	717	java/lang/Exception
    //   793	821	717	java/lang/Exception
    //   821	835	717	java/lang/Exception
    //   837	842	717	java/lang/Exception
    //   857	862	717	java/lang/Exception
    //   1086	1100	717	java/lang/Exception
    //   88	94	845	finally
    //   109	115	845	finally
    //   121	126	845	finally
    //   126	131	845	finally
    //   131	143	845	finally
    //   148	161	845	finally
    //   161	168	845	finally
    //   170	182	845	finally
    //   186	247	845	finally
    //   247	255	845	finally
    //   260	275	845	finally
    //   275	324	845	finally
    //   324	366	845	finally
    //   366	371	845	finally
    //   371	442	845	finally
    //   454	515	845	finally
    //   545	572	845	finally
    //   572	604	845	finally
    //   604	658	845	finally
    //   658	670	845	finally
    //   681	714	845	finally
    //   721	754	845	finally
    //   763	793	845	finally
    //   793	821	845	finally
    //   821	835	845	finally
    //   837	842	845	finally
    //   857	862	845	finally
    //   872	887	845	finally
    //   892	935	845	finally
    //   935	949	845	finally
    //   949	954	845	finally
    //   957	963	845	finally
    //   968	1013	845	finally
    //   1016	1022	845	finally
    //   1024	1064	845	finally
    //   1075	1083	845	finally
    //   1086	1100	845	finally
    //   1100	1108	845	finally
    //   1112	1157	845	finally
    //   1171	1216	845	finally
    //   1216	1249	845	finally
    //   1249	1269	845	finally
    //   260	275	870	java/lang/IllegalStateException
    //   275	324	870	java/lang/IllegalStateException
    //   324	366	870	java/lang/IllegalStateException
    //   366	371	870	java/lang/IllegalStateException
    //   545	572	890	java/lang/Exception
    //   1100	1108	1272	java/lang/Exception
    //   1112	1157	1272	java/lang/Exception
    //   1171	1216	1272	java/lang/Exception
    //   1216	1249	1272	java/lang/Exception
    //   1249	1269	1272	java/lang/Exception
    //   968	1013	1279	java/lang/Exception
    //   1016	1022	1279	java/lang/Exception
    //   1075	1083	1279	java/lang/Exception
    //   148	161	1284	java/io/IOException
    //   186	247	1294	java/lang/Exception
    //   247	255	1294	java/lang/Exception
    //   260	275	1294	java/lang/Exception
    //   275	324	1294	java/lang/Exception
    //   324	366	1294	java/lang/Exception
    //   366	371	1294	java/lang/Exception
    //   371	442	1294	java/lang/Exception
    //   454	515	1294	java/lang/Exception
    //   572	604	1294	java/lang/Exception
    //   604	658	1294	java/lang/Exception
    //   658	670	1294	java/lang/Exception
    //   872	887	1294	java/lang/Exception
    //   892	935	1294	java/lang/Exception
    //   935	949	1294	java/lang/Exception
    //   949	954	1294	java/lang/Exception
    //   957	963	1294	java/lang/Exception
    //   1024	1064	1294	java/lang/Exception
  }
  
  /* Error */
  private int RecordAudio(int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: getfield 115	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   6: ifne +37 -> 43
    //   9: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   12: ifeq +29 -> 41
    //   15: ldc 182
    //   17: iconst_2
    //   18: new 184	java/lang/StringBuilder
    //   21: dup
    //   22: ldc_w 505
    //   25: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   28: aload_0
    //   29: getfield 115	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   32: invokevirtual 246	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   35: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 249	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   41: iconst_m1
    //   42: ireturn
    //   43: aload_0
    //   44: getfield 109	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   47: invokevirtual 429	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   50: iload_3
    //   51: istore_2
    //   52: aload_0
    //   53: getfield 80	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   56: astore 5
    //   58: aload 5
    //   60: ifnonnull +13 -> 73
    //   63: aload_0
    //   64: getfield 109	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   67: invokevirtual 432	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   70: bipush 254
    //   72: ireturn
    //   73: iload_3
    //   74: istore_2
    //   75: aload_0
    //   76: getfield 113	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_doRecInit	Z
    //   79: istore 4
    //   81: iload 4
    //   83: iconst_1
    //   84: if_icmpne +15 -> 99
    //   87: bipush 237
    //   89: invokestatic 438	android/os/Process:setThreadPriority	(I)V
    //   92: iload_3
    //   93: istore_2
    //   94: aload_0
    //   95: iconst_0
    //   96: putfield 113	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_doRecInit	Z
    //   99: iload_3
    //   100: istore_2
    //   101: aload_0
    //   102: getfield 165	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_recBuffer	Ljava/nio/ByteBuffer;
    //   105: invokevirtual 452	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   108: pop
    //   109: iload_3
    //   110: istore_2
    //   111: aload_0
    //   112: getfield 80	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   115: aload_0
    //   116: getfield 169	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_tempBufRec	[B
    //   119: iconst_0
    //   120: iload_1
    //   121: invokevirtual 508	android/media/AudioRecord:read	([BII)I
    //   124: istore_3
    //   125: iload_3
    //   126: ifge +147 -> 273
    //   129: iload_3
    //   130: istore_2
    //   131: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   134: ifeq +44 -> 178
    //   137: iload_3
    //   138: istore_2
    //   139: ldc 182
    //   141: iconst_2
    //   142: new 184	java/lang/StringBuilder
    //   145: dup
    //   146: ldc_w 510
    //   149: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   152: iload_3
    //   153: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   156: ldc_w 498
    //   159: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: iload_1
    //   163: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   166: ldc_w 500
    //   169: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokestatic 249	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   178: aload_0
    //   179: getfield 109	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   182: invokevirtual 432	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   185: iconst_m1
    //   186: ireturn
    //   187: astore 5
    //   189: iload_3
    //   190: istore_2
    //   191: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   194: ifeq -102 -> 92
    //   197: iload_3
    //   198: istore_2
    //   199: ldc 182
    //   201: iconst_2
    //   202: new 184	java/lang/StringBuilder
    //   205: dup
    //   206: ldc_w 512
    //   209: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   212: aload 5
    //   214: invokevirtual 221	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   217: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 201	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   226: goto -134 -> 92
    //   229: astore 5
    //   231: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   234: ifeq +30 -> 264
    //   237: ldc 182
    //   239: iconst_2
    //   240: new 184	java/lang/StringBuilder
    //   243: dup
    //   244: ldc_w 514
    //   247: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   250: aload 5
    //   252: invokevirtual 221	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   255: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokestatic 249	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   264: aload_0
    //   265: getfield 109	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   268: invokevirtual 432	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   271: iload_2
    //   272: ireturn
    //   273: iload_3
    //   274: istore_2
    //   275: aload_0
    //   276: getfield 165	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_recBuffer	Ljava/nio/ByteBuffer;
    //   279: aload_0
    //   280: getfield 169	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_tempBufRec	[B
    //   283: iconst_0
    //   284: iload_3
    //   285: invokevirtual 518	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   288: pop
    //   289: iload_3
    //   290: istore_2
    //   291: getstatic 68	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_dumpEnable	Z
    //   294: ifeq +31 -> 325
    //   297: iload_3
    //   298: istore_2
    //   299: aload_0
    //   300: getfield 129	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_rec_out	Ljava/io/FileOutputStream;
    //   303: astore 5
    //   305: aload 5
    //   307: ifnull +18 -> 325
    //   310: iload_3
    //   311: istore_2
    //   312: aload_0
    //   313: getfield 129	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_rec_out	Ljava/io/FileOutputStream;
    //   316: aload_0
    //   317: getfield 169	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_tempBufRec	[B
    //   320: iconst_0
    //   321: iload_3
    //   322: invokevirtual 444	java/io/FileOutputStream:write	([BII)V
    //   325: iload_3
    //   326: iload_1
    //   327: if_icmpeq +61 -> 388
    //   330: iload_3
    //   331: istore_2
    //   332: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   335: ifeq +44 -> 379
    //   338: iload_3
    //   339: istore_2
    //   340: ldc 182
    //   342: iconst_2
    //   343: new 184	java/lang/StringBuilder
    //   346: dup
    //   347: ldc_w 520
    //   350: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   353: iload_3
    //   354: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   357: ldc_w 498
    //   360: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: iload_1
    //   364: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   367: ldc_w 500
    //   370: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   376: invokestatic 249	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   379: aload_0
    //   380: getfield 109	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   383: invokevirtual 432	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   386: iconst_m1
    //   387: ireturn
    //   388: aload_0
    //   389: getfield 109	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   392: invokevirtual 432	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   395: iload_3
    //   396: ireturn
    //   397: astore 5
    //   399: aload_0
    //   400: getfield 109	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   403: invokevirtual 432	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   406: aload 5
    //   408: athrow
    //   409: astore 5
    //   411: goto -86 -> 325
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	414	0	this	AudioDeviceInterface
    //   0	414	1	paramInt	int
    //   51	289	2	i	int
    //   1	395	3	j	int
    //   79	6	4	bool	boolean
    //   56	3	5	localAudioRecord	AudioRecord
    //   187	26	5	localException1	Exception
    //   229	22	5	localException2	Exception
    //   303	3	5	localFileOutputStream	FileOutputStream
    //   397	10	5	localObject	Object
    //   409	1	5	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   87	92	187	java/lang/Exception
    //   52	58	229	java/lang/Exception
    //   75	81	229	java/lang/Exception
    //   94	99	229	java/lang/Exception
    //   101	109	229	java/lang/Exception
    //   111	125	229	java/lang/Exception
    //   131	137	229	java/lang/Exception
    //   139	178	229	java/lang/Exception
    //   191	197	229	java/lang/Exception
    //   199	226	229	java/lang/Exception
    //   275	289	229	java/lang/Exception
    //   291	297	229	java/lang/Exception
    //   299	305	229	java/lang/Exception
    //   312	325	229	java/lang/Exception
    //   332	338	229	java/lang/Exception
    //   340	379	229	java/lang/Exception
    //   52	58	397	finally
    //   75	81	397	finally
    //   87	92	397	finally
    //   94	99	397	finally
    //   101	109	397	finally
    //   111	125	397	finally
    //   131	137	397	finally
    //   139	178	397	finally
    //   191	197	397	finally
    //   199	226	397	finally
    //   231	264	397	finally
    //   275	289	397	finally
    //   291	297	397	finally
    //   299	305	397	finally
    //   312	325	397	finally
    //   332	338	397	finally
    //   340	379	397	finally
    //   312	325	409	java/io/IOException
  }
  
  private int SetPlayoutVolume(int paramInt)
  {
    if ((this._audioManager == null) && (this._context != null)) {
      this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
    }
    int i = -1;
    if (this._audioManager != null)
    {
      this._audioManager.setStreamVolume(0, paramInt, 0);
      i = 0;
    }
    return i;
  }
  
  /* Error */
  private int StartPlayback()
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_1
    //   2: aload_0
    //   3: getfield 117	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   6: ifeq +20 -> 26
    //   9: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   12: ifeq +12 -> 24
    //   15: ldc 182
    //   17: iconst_2
    //   18: ldc_w 530
    //   21: invokestatic 249	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   24: iconst_m1
    //   25: ireturn
    //   26: aload_0
    //   27: getfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   30: ifnonnull +37 -> 67
    //   33: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   36: ifeq -12 -> 24
    //   39: ldc 182
    //   41: iconst_2
    //   42: new 184	java/lang/StringBuilder
    //   45: dup
    //   46: ldc_w 532
    //   49: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   52: aload_0
    //   53: getfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   56: invokevirtual 309	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokestatic 249	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   65: iconst_m1
    //   66: ireturn
    //   67: aload_0
    //   68: getfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   71: invokevirtual 484	android/media/AudioTrack:play	()V
    //   74: getstatic 68	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_dumpEnable	Z
    //   77: ifeq +52 -> 129
    //   80: aload_0
    //   81: getfield 102	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   84: ifnull +11 -> 95
    //   87: aload_0
    //   88: getfield 102	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   91: invokevirtual 276	android/media/AudioManager:getMode	()I
    //   94: istore_1
    //   95: aload_0
    //   96: new 534	java/io/File
    //   99: dup
    //   100: aload_0
    //   101: ldc_w 536
    //   104: iload_1
    //   105: invokespecial 540	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:getDumpFilePath	(Ljava/lang/String;I)Ljava/lang/String;
    //   108: invokespecial 541	java/io/File:<init>	(Ljava/lang/String;)V
    //   111: putfield 127	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_play_dump	Ljava/io/File;
    //   114: aload_0
    //   115: new 440	java/io/FileOutputStream
    //   118: dup
    //   119: aload_0
    //   120: getfield 127	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_play_dump	Ljava/io/File;
    //   123: invokespecial 544	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   126: putfield 131	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_play_out	Ljava/io/FileOutputStream;
    //   129: aload_0
    //   130: iconst_1
    //   131: putfield 117	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   134: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   137: ifeq +12 -> 149
    //   140: ldc 182
    //   142: iconst_2
    //   143: ldc_w 546
    //   146: invokestatic 201	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   149: iconst_0
    //   150: ireturn
    //   151: astore_2
    //   152: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   155: ifeq -131 -> 24
    //   158: ldc 182
    //   160: iconst_2
    //   161: ldc_w 548
    //   164: invokestatic 249	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   167: iconst_m1
    //   168: ireturn
    //   169: astore_2
    //   170: goto -41 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	this	AudioDeviceInterface
    //   1	104	1	i	int
    //   151	1	2	localIllegalStateException	java.lang.IllegalStateException
    //   169	1	2	localFileNotFoundException	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   67	74	151	java/lang/IllegalStateException
    //   114	129	169	java/io/FileNotFoundException
  }
  
  /* Error */
  private int StartRecording()
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_1
    //   2: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   5: ifeq +12 -> 17
    //   8: ldc 182
    //   10: iconst_2
    //   11: ldc_w 551
    //   14: invokestatic 201	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: aload_0
    //   18: getfield 115	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   21: ifeq +37 -> 58
    //   24: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   27: ifeq +29 -> 56
    //   30: ldc 182
    //   32: iconst_2
    //   33: new 184	java/lang/StringBuilder
    //   36: dup
    //   37: ldc_w 553
    //   40: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   43: aload_0
    //   44: getfield 115	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   47: invokevirtual 246	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   50: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 249	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: iconst_m1
    //   57: ireturn
    //   58: aload_0
    //   59: getfield 80	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   62: ifnonnull +37 -> 99
    //   65: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   68: ifeq -12 -> 56
    //   71: ldc 182
    //   73: iconst_2
    //   74: new 184	java/lang/StringBuilder
    //   77: dup
    //   78: ldc_w 555
    //   81: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   84: aload_0
    //   85: getfield 80	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   88: invokevirtual 309	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokestatic 249	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   97: iconst_m1
    //   98: ireturn
    //   99: aload_0
    //   100: getfield 80	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   103: invokevirtual 558	android/media/AudioRecord:startRecording	()V
    //   106: getstatic 68	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_dumpEnable	Z
    //   109: ifeq +52 -> 161
    //   112: aload_0
    //   113: getfield 102	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   116: ifnull +11 -> 127
    //   119: aload_0
    //   120: getfield 102	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   123: invokevirtual 276	android/media/AudioManager:getMode	()I
    //   126: istore_1
    //   127: aload_0
    //   128: new 534	java/io/File
    //   131: dup
    //   132: aload_0
    //   133: ldc_w 560
    //   136: iload_1
    //   137: invokespecial 540	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:getDumpFilePath	(Ljava/lang/String;I)Ljava/lang/String;
    //   140: invokespecial 541	java/io/File:<init>	(Ljava/lang/String;)V
    //   143: putfield 125	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_rec_dump	Ljava/io/File;
    //   146: aload_0
    //   147: new 440	java/io/FileOutputStream
    //   150: dup
    //   151: aload_0
    //   152: getfield 125	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_rec_dump	Ljava/io/File;
    //   155: invokespecial 544	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   158: putfield 129	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_rec_out	Ljava/io/FileOutputStream;
    //   161: aload_0
    //   162: iconst_1
    //   163: putfield 115	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   166: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   169: ifeq +12 -> 181
    //   172: ldc 182
    //   174: iconst_2
    //   175: ldc_w 562
    //   178: invokestatic 201	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   181: iconst_0
    //   182: ireturn
    //   183: astore_2
    //   184: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   187: ifeq -131 -> 56
    //   190: ldc 182
    //   192: iconst_2
    //   193: ldc_w 564
    //   196: invokestatic 249	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   199: iconst_m1
    //   200: ireturn
    //   201: astore_2
    //   202: goto -41 -> 161
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	this	AudioDeviceInterface
    //   1	136	1	i	int
    //   183	1	2	localIllegalStateException	java.lang.IllegalStateException
    //   201	1	2	localFileNotFoundException	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   99	106	183	java/lang/IllegalStateException
    //   146	161	201	java/io/FileNotFoundException
  }
  
  /* Error */
  private int StopPlayback()
  {
    // Byte code:
    //   0: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   3: ifeq +29 -> 32
    //   6: ldc 182
    //   8: iconst_2
    //   9: new 184	java/lang/StringBuilder
    //   12: dup
    //   13: ldc_w 567
    //   16: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   19: aload_0
    //   20: getfield 117	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   23: invokevirtual 246	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   26: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 201	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: aload_0
    //   33: getfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   36: ifnonnull +50 -> 86
    //   39: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   42: ifeq +42 -> 84
    //   45: ldc 182
    //   47: iconst_2
    //   48: new 184	java/lang/StringBuilder
    //   51: dup
    //   52: ldc_w 569
    //   55: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   58: aload_0
    //   59: getfield 117	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   62: invokevirtual 246	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   65: ldc_w 426
    //   68: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: aload_0
    //   72: getfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   75: invokevirtual 309	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 249	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   84: iconst_m1
    //   85: ireturn
    //   86: aload_0
    //   87: getfield 107	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   90: invokevirtual 429	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   93: aload_0
    //   94: getfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   97: invokevirtual 465	android/media/AudioTrack:getPlayState	()I
    //   100: istore_1
    //   101: iload_1
    //   102: iconst_3
    //   103: if_icmpne +67 -> 170
    //   106: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   109: ifeq +12 -> 121
    //   112: ldc 182
    //   114: iconst_2
    //   115: ldc_w 467
    //   118: invokestatic 201	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   121: aload_0
    //   122: getfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   125: invokevirtual 470	android/media/AudioTrack:stop	()V
    //   128: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   131: ifeq +32 -> 163
    //   134: ldc 182
    //   136: iconst_2
    //   137: new 184	java/lang/StringBuilder
    //   140: dup
    //   141: ldc_w 475
    //   144: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   147: aload_0
    //   148: getfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   151: invokevirtual 465	android/media/AudioTrack:getPlayState	()I
    //   154: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   157: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokestatic 201	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   163: aload_0
    //   164: getfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   167: invokevirtual 473	android/media/AudioTrack:flush	()V
    //   170: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   173: ifeq +32 -> 205
    //   176: ldc 182
    //   178: iconst_2
    //   179: new 184	java/lang/StringBuilder
    //   182: dup
    //   183: ldc_w 477
    //   186: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   189: aload_0
    //   190: getfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   193: invokevirtual 465	android/media/AudioTrack:getPlayState	()I
    //   196: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   199: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: invokestatic 201	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   205: aload_0
    //   206: getfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   209: invokevirtual 264	android/media/AudioTrack:release	()V
    //   212: aload_0
    //   213: aconst_null
    //   214: putfield 78	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   217: aload_0
    //   218: iconst_0
    //   219: putfield 117	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   222: aload_0
    //   223: getfield 107	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   226: invokevirtual 432	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   229: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   232: ifeq +12 -> 244
    //   235: ldc 182
    //   237: iconst_2
    //   238: ldc_w 571
    //   241: invokestatic 201	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   244: iconst_0
    //   245: ireturn
    //   246: astore_2
    //   247: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   250: ifeq +12 -> 262
    //   253: ldc 182
    //   255: iconst_2
    //   256: ldc_w 481
    //   259: invokestatic 249	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   262: aload_0
    //   263: getfield 107	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   266: invokevirtual 432	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   269: iconst_m1
    //   270: ireturn
    //   271: astore_2
    //   272: aload_0
    //   273: getfield 107	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   276: invokevirtual 432	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   279: aload_2
    //   280: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	281	0	this	AudioDeviceInterface
    //   100	4	1	i	int
    //   246	1	2	localIllegalStateException	java.lang.IllegalStateException
    //   271	9	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   106	121	246	java/lang/IllegalStateException
    //   121	128	246	java/lang/IllegalStateException
    //   93	101	271	finally
    //   106	121	271	finally
    //   121	128	271	finally
    //   128	163	271	finally
    //   163	170	271	finally
    //   170	205	271	finally
    //   205	222	271	finally
    //   247	262	271	finally
  }
  
  /* Error */
  private int StopRecording()
  {
    // Byte code:
    //   0: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 182
    //   8: iconst_2
    //   9: ldc_w 574
    //   12: invokestatic 201	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_0
    //   16: getfield 80	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   19: ifnonnull +37 -> 56
    //   22: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   25: ifeq +29 -> 54
    //   28: ldc 182
    //   30: iconst_2
    //   31: new 184	java/lang/StringBuilder
    //   34: dup
    //   35: ldc_w 576
    //   38: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   41: aload_0
    //   42: getfield 80	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   45: invokevirtual 309	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 249	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   54: iconst_m1
    //   55: ireturn
    //   56: aload_0
    //   57: getfield 109	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   60: invokevirtual 429	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   63: aload_0
    //   64: getfield 80	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   67: invokevirtual 579	android/media/AudioRecord:getRecordingState	()I
    //   70: istore_1
    //   71: iload_1
    //   72: iconst_3
    //   73: if_icmpne +45 -> 118
    //   76: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   79: ifeq +32 -> 111
    //   82: ldc 182
    //   84: iconst_2
    //   85: new 184	java/lang/StringBuilder
    //   88: dup
    //   89: ldc_w 581
    //   92: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   95: aload_0
    //   96: getfield 80	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   99: invokevirtual 579	android/media/AudioRecord:getRecordingState	()I
    //   102: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   105: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokestatic 201	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   111: aload_0
    //   112: getfield 80	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   115: invokevirtual 582	android/media/AudioRecord:stop	()V
    //   118: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   121: ifeq +32 -> 153
    //   124: ldc 182
    //   126: iconst_2
    //   127: new 184	java/lang/StringBuilder
    //   130: dup
    //   131: ldc_w 584
    //   134: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   137: aload_0
    //   138: getfield 80	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   141: invokevirtual 579	android/media/AudioRecord:getRecordingState	()I
    //   144: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   147: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokestatic 201	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   153: aload_0
    //   154: getfield 80	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   157: invokevirtual 359	android/media/AudioRecord:release	()V
    //   160: aload_0
    //   161: aconst_null
    //   162: putfield 80	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   165: aload_0
    //   166: iconst_0
    //   167: putfield 115	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   170: aload_0
    //   171: getfield 109	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   174: invokevirtual 432	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   177: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   180: ifeq +12 -> 192
    //   183: ldc 182
    //   185: iconst_2
    //   186: ldc_w 586
    //   189: invokestatic 201	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   192: iconst_0
    //   193: ireturn
    //   194: astore_2
    //   195: invokestatic 180	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   198: ifeq +12 -> 210
    //   201: ldc 182
    //   203: iconst_2
    //   204: ldc_w 588
    //   207: invokestatic 249	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   210: aload_0
    //   211: getfield 109	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   214: invokevirtual 432	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   217: iconst_m1
    //   218: ireturn
    //   219: astore_2
    //   220: aload_0
    //   221: getfield 109	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   224: invokevirtual 432	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   227: aload_2
    //   228: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	this	AudioDeviceInterface
    //   70	4	1	i	int
    //   194	1	2	localIllegalStateException	java.lang.IllegalStateException
    //   219	9	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   76	111	194	java/lang/IllegalStateException
    //   111	118	194	java/lang/IllegalStateException
    //   63	71	219	finally
    //   76	111	219	finally
    //   111	118	219	finally
    //   118	153	219	finally
    //   153	170	219	finally
    //   195	210	219	finally
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
  
  private String getDumpFilePath(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "manufacture:" + Build.MANUFACTURER);
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "MODEL:" + Build.MODEL);
    }
    paramString = Environment.getExternalStorageDirectory().getPath() + "/MF-" + Build.MANUFACTURER + "-M-" + Build.MODEL + "-as-" + TraeAudioManager.getAudioSource(this._audioSourcePolicy) + "-st-" + this._streamType + "-m-" + paramInt + "-" + paramString;
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "dump:" + paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "dump replace:" + paramString.replace(" ", "_"));
    }
    return paramString.replace(" ", "_");
  }
  
  private int getLowlatencyFramesPerBuffer()
  {
    if ((this._context == null) || (Build.VERSION.SDK_INT < 9))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "getLowlatencySamplerate err, _context:" + this._context + " api:" + Build.VERSION.SDK_INT);
      }
      return 0;
    }
    boolean bool = this._context.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder("LOW_LATENCY:");
      if (bool != true) {
        break label140;
      }
    }
    label140:
    for (String str = "Y";; str = "N")
    {
      QLog.w("TRAE", 2, str);
      if ((Build.VERSION.SDK_INT >= 17) || (!QLog.isColorLevel())) {
        break;
      }
      QLog.e("TRAE", 2, "API Level too low not support PROPERTY_OUTPUT_SAMPLE_RATE");
      return 0;
    }
  }
  
  private int getLowlatencySamplerate()
  {
    if ((this._context == null) || (Build.VERSION.SDK_INT < 9)) {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "getLowlatencySamplerate err, _context:" + this._context + " api:" + Build.VERSION.SDK_INT);
      }
    }
    label140:
    label147:
    do
    {
      return 0;
      boolean bool = this._context.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder("LOW_LATENCY:");
        if (bool != true) {
          break label140;
        }
      }
      for (String str = "Y";; str = "N")
      {
        QLog.w("TRAE", 2, str);
        if (Build.VERSION.SDK_INT >= 17) {
          break label147;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("TRAE", 2, "API Level too low not support PROPERTY_OUTPUT_SAMPLE_RATE");
        return 0;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TRAE", 2, "getLowlatencySamplerate not support right now!");
    return 0;
  }
  
  public static String getTraceInfo()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    localStringBuffer.append(arrayOfStackTraceElement[2].getClassName()).append(".").append(arrayOfStackTraceElement[2].getMethodName()).append(": ").append(arrayOfStackTraceElement[2].getLineNumber());
    return localStringBuffer.toString();
  }
  
  private void initTRAEAudioManager()
  {
    if (this._context != null)
    {
      TraeAudioManager.init(this._context);
      if (this._init_as == null)
      {
        QLog.e("TRAE", 2, "TraeAudioSession-LeakCheck init: initTRAEAudioManager");
        this._init_as = new TraeAudioSession(this._context, null);
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "initTRAEAudioManager , TraeAudioSession startService");
      }
      this._init_as.startService("DEVICE_SPEAKERPHONE;DEVICE_WIREDHEADSET;DEVICE_BLUETOOTHHEADSET;");
    }
  }
  
  private void onOutputChanage(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, " onOutputChanage:" + paramString);
    }
    setAudioRouteSwitchState(paramString);
    if (!TraeAudioManager.isCloseSystemAPM(this._modePolicy)) {}
    while ((this._sceneModeKey == 1) || (this._sceneModeKey == 2) || (this._sceneModeKey == 3)) {
      return;
    }
    this._connectedDev = paramString;
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder(" onOutputChanage:").append(paramString);
      if (this._audioManager != null) {
        break label253;
      }
      localObject = " am==null";
      localStringBuilder = localStringBuilder.append((String)localObject).append(" st:").append(this._streamType);
      if (this._audioTrack != null) {
        break label280;
      }
      localObject = "_audioTrack==null";
      label136:
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
        label253:
        if (!QLog.isColorLevel()) {
          continue;
        }
        label280:
        QLog.w("TRAE", 2, paramString.getMessage());
        continue;
      }
      this._audioRouteChanged = true;
      return;
      localObject = " mode:" + this._audioManager.getMode();
      break;
      localObject = " at.st:" + this._audioTrack.getStreamType();
      break label136;
      paramString = " mode:" + this._audioManager.getMode();
    }
  }
  
  private void setAudioRouteSwitchState(String paramString)
  {
    if (paramString.equals("DEVICE_EARPHONE"))
    {
      this.switchState = 1;
      return;
    }
    if (paramString.equals("DEVICE_SPEAKERPHONE"))
    {
      this.switchState = 2;
      return;
    }
    if (paramString.equals("DEVICE_WIREDHEADSET"))
    {
      this.switchState = 3;
      return;
    }
    if (paramString.equals("DEVICE_BLUETOOTHHEADSET"))
    {
      this.switchState = 4;
      return;
    }
    this.switchState = 0;
  }
  
  private void uninitTRAEAudioManager()
  {
    if (this._context != null)
    {
      if (this._init_as != null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "uninitTRAEAudioManager , stopService");
        }
        this._init_as.stopService();
        this._init_as.release();
        this._init_as = null;
        QLog.e("TRAE", 2, "TraeAudioSession-LeakCheck release: uninitTRAEAudioManager");
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "uninitTRAEAudioManager , stopService");
      }
      TraeAudioManager.uninit();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.w("TRAE", 2, "uninitTRAEAudioManager , context null");
  }
  
  public int call_postprocess()
  {
    LogTraceEntry("");
    this.switchState = 0;
    if (this._as != null)
    {
      this._as.voiceCallPostprocess();
      this._as.release();
      this._as = null;
      QLog.e("TRAE", 2, "TraeAudioSession-LeakCheck release: call_postprocess");
    }
    TraeAudioManager.IsUpdateSceneFlag = false;
    LogTraceExit();
    return 0;
  }
  
  public int call_postprocess_media()
  {
    LogTraceEntry("");
    this.switchState = 0;
    if (this._as != null)
    {
      this._as.release();
      this._as = null;
      QLog.e("TRAE", 2, "TraeAudioSession-LeakCheck release: call_postprocess_media");
    }
    TraeAudioManager.IsUpdateSceneFlag = false;
    LogTraceExit();
    return 0;
  }
  
  public int call_preprocess()
  {
    LogTraceEntry("");
    this.switchState = 0;
    this._streamType = TraeAudioManager.getAudioStreamType(this._audioStreamTypePolicy);
    if (this._as == null) {
      QLog.e("TRAE", 2, "TraeAudioSession-LeakCheck init: call_preprocess");
    }
    this._as = new TraeAudioSession(this._context, new AudioDeviceInterface.1(this));
    this._preDone = false;
    if (this._as != null) {
      this._prelock.lock();
    }
    int i;
    int j;
    label222:
    for (;;)
    {
      try
      {
        this._as.voiceCallPreprocess(this._modePolicy, this._streamType);
        this._as.connectHighestPriorityDevice();
        i = 7;
        j = i - 1;
        if (i <= 0) {}
      }
      finally
      {
        this._prelock.unlock();
      }
      try
      {
        if (!this._preDone)
        {
          this._precon.await(1L, TimeUnit.SECONDS);
          if (!QLog.isColorLevel()) {
            break label222;
          }
          QLog.e("TRAE", 2, "call_preprocess waiting...  as:" + this._as);
          i = j;
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 2, "call_preprocess done!");
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        continue;
        i = j;
      }
      this._as.getConnectedDevice();
      this._prelock.unlock();
      LogTraceExit();
      return 0;
    }
  }
  
  public int call_preprocess_media()
  {
    LogTraceEntry("");
    this.switchState = 0;
    if (this._as == null) {
      QLog.e("TRAE", 2, "TraeAudioSession-LeakCheck init: call_preprocess_media");
    }
    this._as = new TraeAudioSession(this._context, new TraeAudioSession.a()
    {
      public void a(int paramAnonymousInt) {}
      
      public void a(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public void a(int paramAnonymousInt, String paramAnonymousString)
      {
        if (paramAnonymousInt == 0) {
          AudioDeviceInterface.this.onOutputChanage(paramAnonymousString);
        }
      }
      
      public void a(int paramAnonymousInt, String paramAnonymousString, boolean paramAnonymousBoolean) {}
      
      public void a(int paramAnonymousInt, boolean paramAnonymousBoolean) {}
      
      public void a(int paramAnonymousInt, String[] paramAnonymousArrayOfString, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3) {}
      
      public void a(String paramAnonymousString, long paramAnonymousLong) {}
      
      public void a(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public void a(boolean paramAnonymousBoolean) {}
      
      public void a(String[] paramAnonymousArrayOfString, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
      {
        if (AudioDeviceInterface.this.usingJava) {
          AudioDeviceInterface.this.onOutputChanage(paramAnonymousString1);
        }
      }
      
      public void b(int paramAnonymousInt) {}
      
      public void b(int paramAnonymousInt, String paramAnonymousString) {}
      
      public void b(boolean paramAnonymousBoolean) {}
      
      public void c(int paramAnonymousInt, String paramAnonymousString) {}
    });
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
              QLog.e("TRAE", 2, "media call_preprocess waiting...  mode:" + this._audioManager.getMode());
            }
            Thread.sleep(500L);
            i -= 1;
          }
        }
        if (this._audioManager.getMode() != 0) {
          this._audioManager.setMode(0);
        }
      }
      this._as.connectHighestPriorityDevice();
      this._as.getConnectedDevice();
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "call_preprocess done!");
      }
      label212:
      LogTraceExit();
    }
    catch (InterruptedException localInterruptedException)
    {
      break label212;
    }
    return 0;
  }
  
  public int getAudioRouteSwitchState()
  {
    return this.switchState;
  }
  
  public void setContext(Context paramContext)
  {
    this._context = paramContext;
  }
  
  public void setJavaInterface(int paramInt)
  {
    if (paramInt == 0) {}
    for (this.usingJava = false;; this.usingJava = true)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "setJavaInterface flg:" + paramInt);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.AudioDeviceInterface
 * JD-Core Version:    0.7.0.1
 */