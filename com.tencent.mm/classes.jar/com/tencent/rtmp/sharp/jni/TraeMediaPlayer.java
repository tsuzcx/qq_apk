package com.tencent.rtmp.sharp.jni;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Timer;
import java.util.TimerTask;

public class TraeMediaPlayer
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener
{
  public static final int TRAE_MEDIAPLAER_DATASOURCE_FILEPATH = 2;
  public static final int TRAE_MEDIAPLAER_DATASOURCE_RSID = 0;
  public static final int TRAE_MEDIAPLAER_DATASOURCE_URI = 1;
  public static final int TRAE_MEDIAPLAER_STOP = 100;
  private Context _context;
  private int _durationMS = -1;
  private boolean _hasCall = false;
  private boolean _loop = false;
  int _loopCount = 0;
  private int _prevVolume = -1;
  boolean _ringMode = false;
  private int _streamType = 0;
  private Timer _watchTimer = null;
  private TimerTask _watchTimertask = null;
  private OnCompletionListener mCallback;
  private MediaPlayer mMediaPlay = null;
  
  public TraeMediaPlayer(Context paramContext, OnCompletionListener paramOnCompletionListener)
  {
    this._context = paramContext;
    this.mCallback = paramOnCompletionListener;
  }
  
  private void volumeDo()
  {
    AppMethodBeat.i(13642);
    if ((this.mMediaPlay == null) || (!this._ringMode) || (this._streamType == 2))
    {
      AppMethodBeat.o(13642);
      return;
    }
    for (;;)
    {
      int n;
      try
      {
        localAudioManager = (AudioManager)this._context.getSystemService("audio");
        j = localAudioManager.getStreamVolume(this._streamType);
        i = localAudioManager.getStreamMaxVolume(this._streamType);
        int k = localAudioManager.getStreamVolume(2);
        int m = localAudioManager.getStreamMaxVolume(2);
        n = (int)(k * 1.0D / m * i);
        if (!QLog.isColorLevel()) {
          break label207;
        }
        QLog.e("TRAE", 2, "TraeMediaPlay volumeDo currV:" + j + " maxV:" + i + " currRV:" + k + " maxRV:" + m + " setV:" + n);
      }
      catch (Exception localException)
      {
        AudioManager localAudioManager;
        int j;
        AppMethodBeat.o(13642);
        return;
      }
      localAudioManager.setStreamVolume(this._streamType, i, 0);
      this._prevVolume = j;
      AppMethodBeat.o(13642);
      return;
      int i = n + 1;
      continue;
      label207:
      if (n + 1 < i) {}
    }
  }
  
  private void volumeUndo()
  {
    AppMethodBeat.i(13643);
    if ((this.mMediaPlay == null) || (!this._ringMode) || (this._streamType == 2) || (this._prevVolume == -1))
    {
      AppMethodBeat.o(13643);
      return;
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "TraeMediaPlay volumeUndo _prevVolume:" + this._prevVolume);
      }
      ((AudioManager)this._context.getSystemService("audio")).setStreamVolume(this._streamType, this._prevVolume, 0);
      AppMethodBeat.o(13643);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(13643);
    }
  }
  
  public int getDuration()
  {
    return this._durationMS;
  }
  
  public int getStreamType()
  {
    return this._streamType;
  }
  
  public boolean hasCall()
  {
    return this._hasCall;
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    AppMethodBeat.i(13640);
    AudioDeviceInterface.LogTraceEntry(" cb:" + this.mCallback + " loopCount:" + this._loopCount + " _loop:" + this._loop);
    if (this._loop)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TRAE", 2, "loop play,continue...");
      }
      AppMethodBeat.o(13640);
      return;
    }
    for (;;)
    {
      try
      {
        if (this._loopCount > 0) {
          continue;
        }
        volumeUndo();
        if (this.mMediaPlay.isPlaying()) {
          this.mMediaPlay.stop();
        }
        this.mMediaPlay.reset();
        this.mMediaPlay.release();
        this.mMediaPlay = null;
        if (this.mCallback != null) {
          this.mCallback.onCompletion();
        }
        AudioDeviceInterface.LogTraceExit();
      }
      catch (Exception paramMediaPlayer)
      {
        continue;
      }
      AppMethodBeat.o(13640);
      return;
      this.mMediaPlay.start();
      this._loopCount -= 1;
    }
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(13641);
    AudioDeviceInterface.LogTraceEntry(" cb:" + this.mCallback + " arg1:" + paramInt1 + " arg2:" + paramInt2);
    try
    {
      this.mMediaPlay.release();
      label53:
      this.mMediaPlay = null;
      if (this.mCallback != null) {
        this.mCallback.onCompletion();
      }
      AudioDeviceInterface.LogTraceExit();
      AppMethodBeat.o(13641);
      return false;
    }
    catch (Exception paramMediaPlayer)
    {
      break label53;
    }
  }
  
  /* Error */
  public boolean playRing(int paramInt1, int paramInt2, android.net.Uri paramUri, java.lang.String paramString, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, boolean paramBoolean3, int paramInt4)
  {
    // Byte code:
    //   0: sipush 13638
    //   3: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 109	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   9: ifeq +129 -> 138
    //   12: new 113	java/lang/StringBuilder
    //   15: dup
    //   16: ldc 218
    //   18: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   21: iload_1
    //   22: invokevirtual 122	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   25: ldc 220
    //   27: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: iload_2
    //   31: invokevirtual 122	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   34: ldc 222
    //   36: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_3
    //   40: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   43: ldc 224
    //   45: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload 4
    //   50: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: ldc 226
    //   55: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: astore 12
    //   60: iload 5
    //   62: ifeq +153 -> 215
    //   65: ldc 228
    //   67: astore 11
    //   69: aload 12
    //   71: aload 11
    //   73: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: ldc 230
    //   78: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: iload 6
    //   83: invokevirtual 122	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   86: ldc 232
    //   88: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: astore 12
    //   93: iload 7
    //   95: ifeq +127 -> 222
    //   98: ldc 228
    //   100: astore 11
    //   102: ldc 111
    //   104: iconst_2
    //   105: aload 12
    //   107: aload 11
    //   109: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: ldc 234
    //   114: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: iload 8
    //   119: invokevirtual 166	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   122: ldc 236
    //   124: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: iload 9
    //   129: invokevirtual 122	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   132: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 141	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   138: iload 5
    //   140: ifne +95 -> 235
    //   143: iload 6
    //   145: ifgt +90 -> 235
    //   148: invokestatic 109	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   151: ifeq +56 -> 207
    //   154: new 113	java/lang/StringBuilder
    //   157: dup
    //   158: ldc 238
    //   160: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   163: iload_1
    //   164: invokevirtual 122	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   167: ldc 226
    //   169: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: astore 4
    //   174: iload 5
    //   176: ifeq +53 -> 229
    //   179: ldc 228
    //   181: astore_3
    //   182: ldc 111
    //   184: iconst_2
    //   185: aload 4
    //   187: aload_3
    //   188: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: ldc 230
    //   193: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: iload 6
    //   198: invokevirtual 122	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   201: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 141	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   207: sipush 13638
    //   210: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   213: iconst_0
    //   214: ireturn
    //   215: ldc 240
    //   217: astore 11
    //   219: goto -150 -> 69
    //   222: ldc 240
    //   224: astore 11
    //   226: goto -124 -> 102
    //   229: ldc 240
    //   231: astore_3
    //   232: goto -50 -> 182
    //   235: aload_0
    //   236: getfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   239: ifnull +37 -> 276
    //   242: aload_0
    //   243: getfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   246: invokevirtual 183	android/media/MediaPlayer:isPlaying	()Z
    //   249: istore 10
    //   251: iload 10
    //   253: ifeq +11 -> 264
    //   256: sipush 13638
    //   259: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   262: iconst_0
    //   263: ireturn
    //   264: aload_0
    //   265: getfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   268: invokevirtual 192	android/media/MediaPlayer:release	()V
    //   271: aload_0
    //   272: aconst_null
    //   273: putfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   276: aload_0
    //   277: getfield 61	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_watchTimer	Ljava/util/Timer;
    //   280: ifnull +20 -> 300
    //   283: aload_0
    //   284: getfield 61	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_watchTimer	Ljava/util/Timer;
    //   287: invokevirtual 245	java/util/Timer:cancel	()V
    //   290: aload_0
    //   291: aconst_null
    //   292: putfield 61	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_watchTimer	Ljava/util/Timer;
    //   295: aload_0
    //   296: aconst_null
    //   297: putfield 63	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_watchTimertask	Ljava/util/TimerTask;
    //   300: aload_0
    //   301: getfield 67	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_context	Landroid/content/Context;
    //   304: ldc 88
    //   306: invokevirtual 94	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   309: checkcast 96	android/media/AudioManager
    //   312: astore 11
    //   314: aload_0
    //   315: new 180	android/media/MediaPlayer
    //   318: dup
    //   319: invokespecial 246	android/media/MediaPlayer:<init>	()V
    //   322: putfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   325: aload_0
    //   326: getfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   329: ifnonnull +207 -> 536
    //   332: aload_0
    //   333: getfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   336: invokevirtual 192	android/media/MediaPlayer:release	()V
    //   339: aload_0
    //   340: aconst_null
    //   341: putfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   344: sipush 13638
    //   347: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   350: iconst_0
    //   351: ireturn
    //   352: astore 11
    //   354: aload_0
    //   355: aconst_null
    //   356: putfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   359: goto -83 -> 276
    //   362: astore_3
    //   363: invokestatic 109	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   366: ifeq +40 -> 406
    //   369: ldc 111
    //   371: iconst_2
    //   372: new 113	java/lang/StringBuilder
    //   375: dup
    //   376: ldc 248
    //   378: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   381: aload_3
    //   382: invokevirtual 251	java/lang/IllegalStateException:getLocalizedMessage	()Ljava/lang/String;
    //   385: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: ldc 253
    //   390: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: aload_3
    //   394: invokevirtual 256	java/lang/IllegalStateException:getMessage	()Ljava/lang/String;
    //   397: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   403: invokestatic 176	com/tencent/rtmp/sharp/jni/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   406: aload_0
    //   407: getfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   410: invokevirtual 192	android/media/MediaPlayer:release	()V
    //   413: aload_0
    //   414: aconst_null
    //   415: putfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   418: sipush 13638
    //   421: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   424: iconst_0
    //   425: ireturn
    //   426: astore_3
    //   427: aload_0
    //   428: aconst_null
    //   429: putfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   432: sipush 13638
    //   435: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   438: aload_3
    //   439: athrow
    //   440: astore_3
    //   441: invokestatic 109	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   444: ifeq -38 -> 406
    //   447: ldc 111
    //   449: iconst_2
    //   450: new 113	java/lang/StringBuilder
    //   453: dup
    //   454: ldc_w 258
    //   457: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   460: aload_3
    //   461: invokevirtual 259	java/io/IOException:getLocalizedMessage	()Ljava/lang/String;
    //   464: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: ldc 253
    //   469: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: aload_3
    //   473: invokevirtual 260	java/io/IOException:getMessage	()Ljava/lang/String;
    //   476: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   482: invokestatic 176	com/tencent/rtmp/sharp/jni/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   485: goto -79 -> 406
    //   488: astore_3
    //   489: invokestatic 109	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   492: ifeq -86 -> 406
    //   495: ldc 111
    //   497: iconst_2
    //   498: new 113	java/lang/StringBuilder
    //   501: dup
    //   502: ldc_w 262
    //   505: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   508: aload_3
    //   509: invokevirtual 263	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   512: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: ldc 253
    //   517: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: aload_3
    //   521: invokevirtual 264	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   524: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   530: invokestatic 176	com/tencent/rtmp/sharp/jni/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   533: goto -127 -> 406
    //   536: aload_0
    //   537: getfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   540: aload_0
    //   541: invokevirtual 268	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   544: aload_0
    //   545: getfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   548: aload_0
    //   549: invokevirtual 272	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   552: iload_1
    //   553: tableswitch	default:+624 -> 1177, 0:+78->631, 1:+232->785, 2:+317->870
    //   581: nop
    //   582: ldiv
    //   583: ifeq +19 -> 602
    //   586: ldc 111
    //   588: iconst_2
    //   589: ldc_w 274
    //   592: iload_1
    //   593: invokestatic 280	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   596: invokevirtual 284	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   599: invokestatic 141	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   602: aload_0
    //   603: getfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   606: invokevirtual 192	android/media/MediaPlayer:release	()V
    //   609: aload_0
    //   610: aconst_null
    //   611: putfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   614: aload_0
    //   615: getfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   618: astore_3
    //   619: aload_3
    //   620: ifnonnull +285 -> 905
    //   623: sipush 13638
    //   626: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   629: iconst_0
    //   630: ireturn
    //   631: invokestatic 109	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   634: ifeq +19 -> 653
    //   637: ldc 111
    //   639: iconst_2
    //   640: ldc_w 286
    //   643: iload_2
    //   644: invokestatic 280	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   647: invokevirtual 284	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   650: invokestatic 141	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   653: aload_0
    //   654: getfield 67	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_context	Landroid/content/Context;
    //   657: invokevirtual 290	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   660: iload_2
    //   661: invokevirtual 296	android/content/res/Resources:openRawResourceFd	(I)Landroid/content/res/AssetFileDescriptor;
    //   664: astore_3
    //   665: aload_3
    //   666: ifnonnull +45 -> 711
    //   669: invokestatic 109	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   672: ifeq +19 -> 691
    //   675: ldc 111
    //   677: iconst_2
    //   678: ldc_w 298
    //   681: iload_2
    //   682: invokestatic 280	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   685: invokevirtual 284	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   688: invokestatic 141	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   691: aload_0
    //   692: getfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   695: invokevirtual 192	android/media/MediaPlayer:release	()V
    //   698: aload_0
    //   699: aconst_null
    //   700: putfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   703: sipush 13638
    //   706: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   709: iconst_0
    //   710: ireturn
    //   711: aload_0
    //   712: getfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   715: aload_3
    //   716: invokevirtual 304	android/content/res/AssetFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   719: aload_3
    //   720: invokevirtual 308	android/content/res/AssetFileDescriptor:getStartOffset	()J
    //   723: aload_3
    //   724: invokevirtual 311	android/content/res/AssetFileDescriptor:getLength	()J
    //   727: invokevirtual 315	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   730: aload_3
    //   731: invokevirtual 318	android/content/res/AssetFileDescriptor:close	()V
    //   734: goto -120 -> 614
    //   737: astore_3
    //   738: invokestatic 109	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   741: ifeq -335 -> 406
    //   744: ldc 111
    //   746: iconst_2
    //   747: new 113	java/lang/StringBuilder
    //   750: dup
    //   751: ldc_w 320
    //   754: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   757: aload_3
    //   758: invokevirtual 321	java/lang/IllegalArgumentException:getLocalizedMessage	()Ljava/lang/String;
    //   761: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   764: ldc 253
    //   766: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   769: aload_3
    //   770: invokevirtual 322	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   773: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   776: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   779: invokestatic 176	com/tencent/rtmp/sharp/jni/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   782: goto -376 -> 406
    //   785: invokestatic 109	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   788: ifeq +19 -> 807
    //   791: ldc 111
    //   793: iconst_2
    //   794: ldc_w 324
    //   797: aload_3
    //   798: invokestatic 327	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   801: invokevirtual 284	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   804: invokestatic 141	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   807: aload_0
    //   808: getfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   811: aload_0
    //   812: getfield 67	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_context	Landroid/content/Context;
    //   815: aload_3
    //   816: invokevirtual 330	android/media/MediaPlayer:setDataSource	(Landroid/content/Context;Landroid/net/Uri;)V
    //   819: goto -205 -> 614
    //   822: astore_3
    //   823: invokestatic 109	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   826: ifeq -420 -> 406
    //   829: ldc 111
    //   831: iconst_2
    //   832: new 113	java/lang/StringBuilder
    //   835: dup
    //   836: ldc_w 332
    //   839: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   842: aload_3
    //   843: invokevirtual 333	java/lang/SecurityException:getLocalizedMessage	()Ljava/lang/String;
    //   846: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   849: ldc 253
    //   851: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   854: aload_3
    //   855: invokevirtual 334	java/lang/SecurityException:getMessage	()Ljava/lang/String;
    //   858: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   861: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   864: invokestatic 176	com/tencent/rtmp/sharp/jni/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   867: goto -461 -> 406
    //   870: invokestatic 109	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   873: ifeq +20 -> 893
    //   876: ldc 111
    //   878: iconst_2
    //   879: ldc_w 336
    //   882: aload 4
    //   884: invokestatic 327	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   887: invokevirtual 284	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   890: invokestatic 141	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   893: aload_0
    //   894: getfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   897: aload 4
    //   899: invokevirtual 338	android/media/MediaPlayer:setDataSource	(Ljava/lang/String;)V
    //   902: goto -288 -> 614
    //   905: aload_0
    //   906: iload 7
    //   908: putfield 59	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_ringMode	Z
    //   911: iconst_0
    //   912: istore_1
    //   913: aload_0
    //   914: getfield 59	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_ringMode	Z
    //   917: ifeq +213 -> 1130
    //   920: aload_0
    //   921: iconst_2
    //   922: putfield 49	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_streamType	I
    //   925: iconst_1
    //   926: istore_1
    //   927: aload_0
    //   928: iload 8
    //   930: putfield 51	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_hasCall	Z
    //   933: aload_0
    //   934: getfield 51	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_hasCall	Z
    //   937: ifeq +9 -> 946
    //   940: aload_0
    //   941: iload 9
    //   943: putfield 49	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_streamType	I
    //   946: aload_0
    //   947: getfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   950: aload_0
    //   951: getfield 49	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_streamType	I
    //   954: invokevirtual 341	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   957: aload_0
    //   958: getfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   961: invokevirtual 344	android/media/MediaPlayer:prepare	()V
    //   964: aload_0
    //   965: getfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   968: iload 5
    //   970: invokevirtual 348	android/media/MediaPlayer:setLooping	(Z)V
    //   973: aload_0
    //   974: getfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   977: invokevirtual 200	android/media/MediaPlayer:start	()V
    //   980: aload_0
    //   981: iload 5
    //   983: putfield 53	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_loop	Z
    //   986: aload_0
    //   987: getfield 53	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_loop	Z
    //   990: iconst_1
    //   991: if_icmpne +157 -> 1148
    //   994: aload_0
    //   995: iconst_1
    //   996: putfield 57	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_loopCount	I
    //   999: aload_0
    //   1000: iconst_m1
    //   1001: putfield 55	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_durationMS	I
    //   1004: aload_0
    //   1005: aload_0
    //   1006: getfield 57	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_loopCount	I
    //   1009: iconst_1
    //   1010: isub
    //   1011: putfield 57	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_loopCount	I
    //   1014: aload_0
    //   1015: getfield 51	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_hasCall	Z
    //   1018: ifne +9 -> 1027
    //   1021: aload 11
    //   1023: iload_1
    //   1024: invokevirtual 351	android/media/AudioManager:setMode	(I)V
    //   1027: aload_0
    //   1028: getfield 55	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_durationMS	I
    //   1031: ifle +46 -> 1077
    //   1034: aload_0
    //   1035: new 242	java/util/Timer
    //   1038: dup
    //   1039: invokespecial 352	java/util/Timer:<init>	()V
    //   1042: putfield 61	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_watchTimer	Ljava/util/Timer;
    //   1045: aload_0
    //   1046: new 10	com/tencent/rtmp/sharp/jni/TraeMediaPlayer$1
    //   1049: dup
    //   1050: aload_0
    //   1051: invokespecial 355	com/tencent/rtmp/sharp/jni/TraeMediaPlayer$1:<init>	(Lcom/tencent/rtmp/sharp/jni/TraeMediaPlayer;)V
    //   1054: putfield 63	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_watchTimertask	Ljava/util/TimerTask;
    //   1057: aload_0
    //   1058: getfield 61	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_watchTimer	Ljava/util/Timer;
    //   1061: aload_0
    //   1062: getfield 63	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_watchTimertask	Ljava/util/TimerTask;
    //   1065: aload_0
    //   1066: getfield 55	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_durationMS	I
    //   1069: sipush 1000
    //   1072: iadd
    //   1073: i2l
    //   1074: invokevirtual 359	java/util/Timer:schedule	(Ljava/util/TimerTask;J)V
    //   1077: invokestatic 109	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   1080: ifeq +42 -> 1122
    //   1083: ldc 111
    //   1085: iconst_2
    //   1086: new 113	java/lang/StringBuilder
    //   1089: dup
    //   1090: ldc_w 361
    //   1093: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1096: aload_0
    //   1097: getfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   1100: invokevirtual 363	android/media/MediaPlayer:getDuration	()I
    //   1103: invokevirtual 122	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1106: ldc 226
    //   1108: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1111: iload 5
    //   1113: invokevirtual 166	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1116: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1119: invokestatic 141	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1122: sipush 13638
    //   1125: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1128: iconst_1
    //   1129: ireturn
    //   1130: aload_0
    //   1131: iconst_0
    //   1132: putfield 49	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_streamType	I
    //   1135: getstatic 368	android/os/Build$VERSION:SDK_INT	I
    //   1138: bipush 11
    //   1140: if_icmplt -213 -> 927
    //   1143: iconst_3
    //   1144: istore_1
    //   1145: goto -218 -> 927
    //   1148: aload_0
    //   1149: iload 6
    //   1151: putfield 57	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_loopCount	I
    //   1154: aload_0
    //   1155: aload_0
    //   1156: getfield 57	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_loopCount	I
    //   1159: aload_0
    //   1160: getfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   1163: invokevirtual 363	android/media/MediaPlayer:getDuration	()I
    //   1166: imul
    //   1167: putfield 55	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_durationMS	I
    //   1170: goto -166 -> 1004
    //   1173: astore_3
    //   1174: goto -761 -> 413
    //   1177: goto -597 -> 580
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1180	0	this	TraeMediaPlayer
    //   0	1180	1	paramInt1	int
    //   0	1180	2	paramInt2	int
    //   0	1180	3	paramUri	android.net.Uri
    //   0	1180	4	paramString	java.lang.String
    //   0	1180	5	paramBoolean1	boolean
    //   0	1180	6	paramInt3	int
    //   0	1180	7	paramBoolean2	boolean
    //   0	1180	8	paramBoolean3	boolean
    //   0	1180	9	paramInt4	int
    //   249	3	10	bool	boolean
    //   67	246	11	localObject	Object
    //   352	670	11	localException	Exception
    //   58	48	12	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   264	271	352	java/lang/Exception
    //   235	251	362	java/lang/IllegalStateException
    //   271	276	362	java/lang/IllegalStateException
    //   276	300	362	java/lang/IllegalStateException
    //   300	344	362	java/lang/IllegalStateException
    //   354	359	362	java/lang/IllegalStateException
    //   427	440	362	java/lang/IllegalStateException
    //   536	552	362	java/lang/IllegalStateException
    //   580	602	362	java/lang/IllegalStateException
    //   602	614	362	java/lang/IllegalStateException
    //   614	619	362	java/lang/IllegalStateException
    //   631	653	362	java/lang/IllegalStateException
    //   653	665	362	java/lang/IllegalStateException
    //   669	691	362	java/lang/IllegalStateException
    //   691	703	362	java/lang/IllegalStateException
    //   711	734	362	java/lang/IllegalStateException
    //   785	807	362	java/lang/IllegalStateException
    //   807	819	362	java/lang/IllegalStateException
    //   870	893	362	java/lang/IllegalStateException
    //   893	902	362	java/lang/IllegalStateException
    //   905	911	362	java/lang/IllegalStateException
    //   913	925	362	java/lang/IllegalStateException
    //   927	946	362	java/lang/IllegalStateException
    //   946	1004	362	java/lang/IllegalStateException
    //   1004	1027	362	java/lang/IllegalStateException
    //   1027	1077	362	java/lang/IllegalStateException
    //   1077	1122	362	java/lang/IllegalStateException
    //   1130	1135	362	java/lang/IllegalStateException
    //   1135	1143	362	java/lang/IllegalStateException
    //   1148	1170	362	java/lang/IllegalStateException
    //   264	271	426	finally
    //   235	251	440	java/io/IOException
    //   271	276	440	java/io/IOException
    //   276	300	440	java/io/IOException
    //   300	344	440	java/io/IOException
    //   354	359	440	java/io/IOException
    //   427	440	440	java/io/IOException
    //   536	552	440	java/io/IOException
    //   580	602	440	java/io/IOException
    //   602	614	440	java/io/IOException
    //   614	619	440	java/io/IOException
    //   631	653	440	java/io/IOException
    //   653	665	440	java/io/IOException
    //   669	691	440	java/io/IOException
    //   691	703	440	java/io/IOException
    //   711	734	440	java/io/IOException
    //   785	807	440	java/io/IOException
    //   807	819	440	java/io/IOException
    //   870	893	440	java/io/IOException
    //   893	902	440	java/io/IOException
    //   905	911	440	java/io/IOException
    //   913	925	440	java/io/IOException
    //   927	946	440	java/io/IOException
    //   946	1004	440	java/io/IOException
    //   1004	1027	440	java/io/IOException
    //   1027	1077	440	java/io/IOException
    //   1077	1122	440	java/io/IOException
    //   1130	1135	440	java/io/IOException
    //   1135	1143	440	java/io/IOException
    //   1148	1170	440	java/io/IOException
    //   235	251	488	java/lang/Exception
    //   271	276	488	java/lang/Exception
    //   276	300	488	java/lang/Exception
    //   300	344	488	java/lang/Exception
    //   354	359	488	java/lang/Exception
    //   363	406	488	java/lang/Exception
    //   427	440	488	java/lang/Exception
    //   441	485	488	java/lang/Exception
    //   536	552	488	java/lang/Exception
    //   580	602	488	java/lang/Exception
    //   602	614	488	java/lang/Exception
    //   614	619	488	java/lang/Exception
    //   631	653	488	java/lang/Exception
    //   653	665	488	java/lang/Exception
    //   669	691	488	java/lang/Exception
    //   691	703	488	java/lang/Exception
    //   711	734	488	java/lang/Exception
    //   738	782	488	java/lang/Exception
    //   785	807	488	java/lang/Exception
    //   807	819	488	java/lang/Exception
    //   823	867	488	java/lang/Exception
    //   870	893	488	java/lang/Exception
    //   893	902	488	java/lang/Exception
    //   905	911	488	java/lang/Exception
    //   913	925	488	java/lang/Exception
    //   927	946	488	java/lang/Exception
    //   946	1004	488	java/lang/Exception
    //   1004	1027	488	java/lang/Exception
    //   1027	1077	488	java/lang/Exception
    //   1077	1122	488	java/lang/Exception
    //   1130	1135	488	java/lang/Exception
    //   1135	1143	488	java/lang/Exception
    //   1148	1170	488	java/lang/Exception
    //   235	251	737	java/lang/IllegalArgumentException
    //   271	276	737	java/lang/IllegalArgumentException
    //   276	300	737	java/lang/IllegalArgumentException
    //   300	344	737	java/lang/IllegalArgumentException
    //   354	359	737	java/lang/IllegalArgumentException
    //   427	440	737	java/lang/IllegalArgumentException
    //   536	552	737	java/lang/IllegalArgumentException
    //   580	602	737	java/lang/IllegalArgumentException
    //   602	614	737	java/lang/IllegalArgumentException
    //   614	619	737	java/lang/IllegalArgumentException
    //   631	653	737	java/lang/IllegalArgumentException
    //   653	665	737	java/lang/IllegalArgumentException
    //   669	691	737	java/lang/IllegalArgumentException
    //   691	703	737	java/lang/IllegalArgumentException
    //   711	734	737	java/lang/IllegalArgumentException
    //   785	807	737	java/lang/IllegalArgumentException
    //   807	819	737	java/lang/IllegalArgumentException
    //   870	893	737	java/lang/IllegalArgumentException
    //   893	902	737	java/lang/IllegalArgumentException
    //   905	911	737	java/lang/IllegalArgumentException
    //   913	925	737	java/lang/IllegalArgumentException
    //   927	946	737	java/lang/IllegalArgumentException
    //   946	1004	737	java/lang/IllegalArgumentException
    //   1004	1027	737	java/lang/IllegalArgumentException
    //   1027	1077	737	java/lang/IllegalArgumentException
    //   1077	1122	737	java/lang/IllegalArgumentException
    //   1130	1135	737	java/lang/IllegalArgumentException
    //   1135	1143	737	java/lang/IllegalArgumentException
    //   1148	1170	737	java/lang/IllegalArgumentException
    //   235	251	822	java/lang/SecurityException
    //   271	276	822	java/lang/SecurityException
    //   276	300	822	java/lang/SecurityException
    //   300	344	822	java/lang/SecurityException
    //   354	359	822	java/lang/SecurityException
    //   427	440	822	java/lang/SecurityException
    //   536	552	822	java/lang/SecurityException
    //   580	602	822	java/lang/SecurityException
    //   602	614	822	java/lang/SecurityException
    //   614	619	822	java/lang/SecurityException
    //   631	653	822	java/lang/SecurityException
    //   653	665	822	java/lang/SecurityException
    //   669	691	822	java/lang/SecurityException
    //   691	703	822	java/lang/SecurityException
    //   711	734	822	java/lang/SecurityException
    //   785	807	822	java/lang/SecurityException
    //   807	819	822	java/lang/SecurityException
    //   870	893	822	java/lang/SecurityException
    //   893	902	822	java/lang/SecurityException
    //   905	911	822	java/lang/SecurityException
    //   913	925	822	java/lang/SecurityException
    //   927	946	822	java/lang/SecurityException
    //   946	1004	822	java/lang/SecurityException
    //   1004	1027	822	java/lang/SecurityException
    //   1027	1077	822	java/lang/SecurityException
    //   1077	1122	822	java/lang/SecurityException
    //   1130	1135	822	java/lang/SecurityException
    //   1135	1143	822	java/lang/SecurityException
    //   1148	1170	822	java/lang/SecurityException
    //   406	413	1173	java/lang/Exception
  }
  
  public void stopRing()
  {
    AppMethodBeat.i(13639);
    if (QLog.isColorLevel()) {
      QLog.d("TRAE", 2, "TraeMediaPlay stopRing ");
    }
    if (this.mMediaPlay == null)
    {
      AppMethodBeat.o(13639);
      return;
    }
    if (this.mMediaPlay.isPlaying()) {
      this.mMediaPlay.stop();
    }
    this.mMediaPlay.reset();
    try
    {
      if (this._watchTimer != null)
      {
        this._watchTimer.cancel();
        this._watchTimer = null;
        this._watchTimertask = null;
      }
      this.mMediaPlay.release();
    }
    catch (Exception localException)
    {
      label90:
      break label90;
    }
    this.mMediaPlay = null;
    this._durationMS = -1;
    AppMethodBeat.o(13639);
  }
  
  public static abstract interface OnCompletionListener
  {
    public abstract void onCompletion();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeMediaPlayer
 * JD-Core Version:    0.7.0.1
 */