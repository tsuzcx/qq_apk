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
          break label239;
        }
        QLog.e("TRAE", 2, "TraeMediaPlay volumeDo currV:" + j + " maxV:" + i + " currRV:" + k + " maxRV:" + m + " setV:" + n);
      }
      catch (Exception localException)
      {
        AudioManager localAudioManager;
        int j;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("TRAE", 2, "set stream volume failed." + localException.getMessage());
        AppMethodBeat.o(13642);
        return;
      }
      localAudioManager.setStreamVolume(this._streamType, i, 0);
      this._prevVolume = j;
      AppMethodBeat.o(13642);
      return;
      int i = n + 1;
      continue;
      label239:
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
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "set stream volume failed." + localException.getMessage());
      }
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
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("TRAE", 2, "stop play failed." + paramMediaPlayer.getMessage());
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
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 2, "release MediaPlayer failed." + paramMediaPlayer.getMessage());
        }
      }
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
    //   16: ldc 227
    //   18: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   21: iload_1
    //   22: invokevirtual 122	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   25: ldc 229
    //   27: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: iload_2
    //   31: invokevirtual 122	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   34: ldc 231
    //   36: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_3
    //   40: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   43: ldc 233
    //   45: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload 4
    //   50: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: ldc 235
    //   55: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: astore 12
    //   60: iload 5
    //   62: ifeq +153 -> 215
    //   65: ldc 237
    //   67: astore 11
    //   69: aload 12
    //   71: aload 11
    //   73: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: ldc 239
    //   78: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: iload 6
    //   83: invokevirtual 122	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   86: ldc 241
    //   88: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: astore 12
    //   93: iload 7
    //   95: ifeq +127 -> 222
    //   98: ldc 237
    //   100: astore 11
    //   102: ldc 111
    //   104: iconst_2
    //   105: aload 12
    //   107: aload 11
    //   109: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: ldc 243
    //   114: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: iload 8
    //   119: invokevirtual 171	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   122: ldc 245
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
    //   158: ldc 247
    //   160: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   163: iload_1
    //   164: invokevirtual 122	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   167: ldc 235
    //   169: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: astore 4
    //   174: iload 5
    //   176: ifeq +53 -> 229
    //   179: ldc 237
    //   181: astore_3
    //   182: ldc 111
    //   184: iconst_2
    //   185: aload 4
    //   187: aload_3
    //   188: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: ldc 239
    //   193: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: iload 6
    //   198: invokevirtual 122	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   201: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 141	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   207: sipush 13638
    //   210: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   213: iconst_0
    //   214: ireturn
    //   215: ldc 249
    //   217: astore 11
    //   219: goto -150 -> 69
    //   222: ldc 249
    //   224: astore 11
    //   226: goto -124 -> 102
    //   229: ldc 249
    //   231: astore_3
    //   232: goto -50 -> 182
    //   235: aload_0
    //   236: getfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   239: ifnull +37 -> 276
    //   242: aload_0
    //   243: getfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   246: invokevirtual 188	android/media/MediaPlayer:isPlaying	()Z
    //   249: istore 10
    //   251: iload 10
    //   253: ifeq +11 -> 264
    //   256: sipush 13638
    //   259: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   262: iconst_0
    //   263: ireturn
    //   264: aload_0
    //   265: getfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   268: invokevirtual 197	android/media/MediaPlayer:release	()V
    //   271: aload_0
    //   272: aconst_null
    //   273: putfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   276: aload_0
    //   277: getfield 61	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_watchTimer	Ljava/util/Timer;
    //   280: ifnull +20 -> 300
    //   283: aload_0
    //   284: getfield 61	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_watchTimer	Ljava/util/Timer;
    //   287: invokevirtual 254	java/util/Timer:cancel	()V
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
    //   315: new 185	android/media/MediaPlayer
    //   318: dup
    //   319: invokespecial 255	android/media/MediaPlayer:<init>	()V
    //   322: putfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   325: aload_0
    //   326: getfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   329: ifnonnull +243 -> 572
    //   332: aload_0
    //   333: getfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   336: invokevirtual 197	android/media/MediaPlayer:release	()V
    //   339: aload_0
    //   340: aconst_null
    //   341: putfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   344: sipush 13638
    //   347: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   350: iconst_0
    //   351: ireturn
    //   352: astore 11
    //   354: invokestatic 109	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   357: ifeq +29 -> 386
    //   360: ldc 111
    //   362: iconst_2
    //   363: new 113	java/lang/StringBuilder
    //   366: dup
    //   367: ldc 215
    //   369: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   372: aload 11
    //   374: invokevirtual 150	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   377: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   383: invokestatic 141	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   386: aload_0
    //   387: aconst_null
    //   388: putfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   391: goto -115 -> 276
    //   394: astore_3
    //   395: invokestatic 109	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   398: ifeq +42 -> 440
    //   401: ldc 111
    //   403: iconst_2
    //   404: new 113	java/lang/StringBuilder
    //   407: dup
    //   408: ldc_w 257
    //   411: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   414: aload_3
    //   415: invokevirtual 260	java/lang/IllegalStateException:getLocalizedMessage	()Ljava/lang/String;
    //   418: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: ldc_w 262
    //   424: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: aload_3
    //   428: invokevirtual 263	java/lang/IllegalStateException:getMessage	()Ljava/lang/String;
    //   431: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   437: invokestatic 181	com/tencent/rtmp/sharp/jni/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   440: aload_0
    //   441: getfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   444: invokevirtual 197	android/media/MediaPlayer:release	()V
    //   447: aload_0
    //   448: aconst_null
    //   449: putfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   452: sipush 13638
    //   455: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   458: iconst_0
    //   459: ireturn
    //   460: astore_3
    //   461: aload_0
    //   462: aconst_null
    //   463: putfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   466: sipush 13638
    //   469: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   472: aload_3
    //   473: athrow
    //   474: astore_3
    //   475: invokestatic 109	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   478: ifeq -38 -> 440
    //   481: ldc 111
    //   483: iconst_2
    //   484: new 113	java/lang/StringBuilder
    //   487: dup
    //   488: ldc_w 265
    //   491: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   494: aload_3
    //   495: invokevirtual 266	java/io/IOException:getLocalizedMessage	()Ljava/lang/String;
    //   498: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: ldc_w 262
    //   504: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: aload_3
    //   508: invokevirtual 267	java/io/IOException:getMessage	()Ljava/lang/String;
    //   511: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   517: invokestatic 181	com/tencent/rtmp/sharp/jni/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   520: goto -80 -> 440
    //   523: astore_3
    //   524: invokestatic 109	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   527: ifeq -87 -> 440
    //   530: ldc 111
    //   532: iconst_2
    //   533: new 113	java/lang/StringBuilder
    //   536: dup
    //   537: ldc_w 269
    //   540: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   543: aload_3
    //   544: invokevirtual 270	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   547: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: ldc_w 262
    //   553: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: aload_3
    //   557: invokevirtual 150	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   560: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   566: invokestatic 181	com/tencent/rtmp/sharp/jni/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   569: goto -129 -> 440
    //   572: aload_0
    //   573: getfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   576: aload_0
    //   577: invokevirtual 274	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   580: aload_0
    //   581: getfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   584: aload_0
    //   585: invokevirtual 278	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   588: iload_1
    //   589: tableswitch	default:+626 -> 1215, 0:+78->667, 1:+233->822, 2:+319->908
    //   617: nop
    //   618: ldiv
    //   619: ifeq +19 -> 638
    //   622: ldc 111
    //   624: iconst_2
    //   625: ldc_w 280
    //   628: iload_1
    //   629: invokestatic 286	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   632: invokevirtual 290	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   635: invokestatic 141	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   638: aload_0
    //   639: getfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   642: invokevirtual 197	android/media/MediaPlayer:release	()V
    //   645: aload_0
    //   646: aconst_null
    //   647: putfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   650: aload_0
    //   651: getfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   654: astore_3
    //   655: aload_3
    //   656: ifnonnull +287 -> 943
    //   659: sipush 13638
    //   662: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   665: iconst_0
    //   666: ireturn
    //   667: invokestatic 109	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   670: ifeq +19 -> 689
    //   673: ldc 111
    //   675: iconst_2
    //   676: ldc_w 292
    //   679: iload_2
    //   680: invokestatic 286	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   683: invokevirtual 290	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   686: invokestatic 141	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   689: aload_0
    //   690: getfield 67	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_context	Landroid/content/Context;
    //   693: invokevirtual 296	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   696: iload_2
    //   697: invokevirtual 302	android/content/res/Resources:openRawResourceFd	(I)Landroid/content/res/AssetFileDescriptor;
    //   700: astore_3
    //   701: aload_3
    //   702: ifnonnull +45 -> 747
    //   705: invokestatic 109	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   708: ifeq +19 -> 727
    //   711: ldc 111
    //   713: iconst_2
    //   714: ldc_w 304
    //   717: iload_2
    //   718: invokestatic 286	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   721: invokevirtual 290	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   724: invokestatic 141	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   727: aload_0
    //   728: getfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   731: invokevirtual 197	android/media/MediaPlayer:release	()V
    //   734: aload_0
    //   735: aconst_null
    //   736: putfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   739: sipush 13638
    //   742: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   745: iconst_0
    //   746: ireturn
    //   747: aload_0
    //   748: getfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   751: aload_3
    //   752: invokevirtual 310	android/content/res/AssetFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   755: aload_3
    //   756: invokevirtual 314	android/content/res/AssetFileDescriptor:getStartOffset	()J
    //   759: aload_3
    //   760: invokevirtual 317	android/content/res/AssetFileDescriptor:getLength	()J
    //   763: invokevirtual 321	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   766: aload_3
    //   767: invokevirtual 324	android/content/res/AssetFileDescriptor:close	()V
    //   770: goto -120 -> 650
    //   773: astore_3
    //   774: invokestatic 109	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   777: ifeq -337 -> 440
    //   780: ldc 111
    //   782: iconst_2
    //   783: new 113	java/lang/StringBuilder
    //   786: dup
    //   787: ldc_w 326
    //   790: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   793: aload_3
    //   794: invokevirtual 327	java/lang/IllegalArgumentException:getLocalizedMessage	()Ljava/lang/String;
    //   797: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   800: ldc_w 262
    //   803: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   806: aload_3
    //   807: invokevirtual 328	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   810: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   813: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   816: invokestatic 181	com/tencent/rtmp/sharp/jni/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   819: goto -379 -> 440
    //   822: invokestatic 109	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   825: ifeq +19 -> 844
    //   828: ldc 111
    //   830: iconst_2
    //   831: ldc_w 330
    //   834: aload_3
    //   835: invokestatic 333	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   838: invokevirtual 290	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   841: invokestatic 141	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   844: aload_0
    //   845: getfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   848: aload_0
    //   849: getfield 67	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_context	Landroid/content/Context;
    //   852: aload_3
    //   853: invokevirtual 336	android/media/MediaPlayer:setDataSource	(Landroid/content/Context;Landroid/net/Uri;)V
    //   856: goto -206 -> 650
    //   859: astore_3
    //   860: invokestatic 109	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   863: ifeq -423 -> 440
    //   866: ldc 111
    //   868: iconst_2
    //   869: new 113	java/lang/StringBuilder
    //   872: dup
    //   873: ldc_w 338
    //   876: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   879: aload_3
    //   880: invokevirtual 339	java/lang/SecurityException:getLocalizedMessage	()Ljava/lang/String;
    //   883: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   886: ldc_w 262
    //   889: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   892: aload_3
    //   893: invokevirtual 340	java/lang/SecurityException:getMessage	()Ljava/lang/String;
    //   896: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   899: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   902: invokestatic 181	com/tencent/rtmp/sharp/jni/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   905: goto -465 -> 440
    //   908: invokestatic 109	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   911: ifeq +20 -> 931
    //   914: ldc 111
    //   916: iconst_2
    //   917: ldc_w 342
    //   920: aload 4
    //   922: invokestatic 333	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   925: invokevirtual 290	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   928: invokestatic 141	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   931: aload_0
    //   932: getfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   935: aload 4
    //   937: invokevirtual 344	android/media/MediaPlayer:setDataSource	(Ljava/lang/String;)V
    //   940: goto -290 -> 650
    //   943: aload_0
    //   944: iload 7
    //   946: putfield 59	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_ringMode	Z
    //   949: iconst_0
    //   950: istore_1
    //   951: aload_0
    //   952: getfield 59	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_ringMode	Z
    //   955: ifeq +213 -> 1168
    //   958: aload_0
    //   959: iconst_2
    //   960: putfield 49	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_streamType	I
    //   963: iconst_1
    //   964: istore_1
    //   965: aload_0
    //   966: iload 8
    //   968: putfield 51	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_hasCall	Z
    //   971: aload_0
    //   972: getfield 51	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_hasCall	Z
    //   975: ifeq +9 -> 984
    //   978: aload_0
    //   979: iload 9
    //   981: putfield 49	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_streamType	I
    //   984: aload_0
    //   985: getfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   988: aload_0
    //   989: getfield 49	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_streamType	I
    //   992: invokevirtual 347	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   995: aload_0
    //   996: getfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   999: invokevirtual 350	android/media/MediaPlayer:prepare	()V
    //   1002: aload_0
    //   1003: getfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   1006: iload 5
    //   1008: invokevirtual 354	android/media/MediaPlayer:setLooping	(Z)V
    //   1011: aload_0
    //   1012: getfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   1015: invokevirtual 205	android/media/MediaPlayer:start	()V
    //   1018: aload_0
    //   1019: iload 5
    //   1021: putfield 53	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_loop	Z
    //   1024: aload_0
    //   1025: getfield 53	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_loop	Z
    //   1028: iconst_1
    //   1029: if_icmpne +157 -> 1186
    //   1032: aload_0
    //   1033: iconst_1
    //   1034: putfield 57	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_loopCount	I
    //   1037: aload_0
    //   1038: iconst_m1
    //   1039: putfield 55	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_durationMS	I
    //   1042: aload_0
    //   1043: aload_0
    //   1044: getfield 57	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_loopCount	I
    //   1047: iconst_1
    //   1048: isub
    //   1049: putfield 57	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_loopCount	I
    //   1052: aload_0
    //   1053: getfield 51	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_hasCall	Z
    //   1056: ifne +9 -> 1065
    //   1059: aload 11
    //   1061: iload_1
    //   1062: invokevirtual 357	android/media/AudioManager:setMode	(I)V
    //   1065: aload_0
    //   1066: getfield 55	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_durationMS	I
    //   1069: ifle +46 -> 1115
    //   1072: aload_0
    //   1073: new 251	java/util/Timer
    //   1076: dup
    //   1077: invokespecial 358	java/util/Timer:<init>	()V
    //   1080: putfield 61	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_watchTimer	Ljava/util/Timer;
    //   1083: aload_0
    //   1084: new 10	com/tencent/rtmp/sharp/jni/TraeMediaPlayer$1
    //   1087: dup
    //   1088: aload_0
    //   1089: invokespecial 361	com/tencent/rtmp/sharp/jni/TraeMediaPlayer$1:<init>	(Lcom/tencent/rtmp/sharp/jni/TraeMediaPlayer;)V
    //   1092: putfield 63	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_watchTimertask	Ljava/util/TimerTask;
    //   1095: aload_0
    //   1096: getfield 61	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_watchTimer	Ljava/util/Timer;
    //   1099: aload_0
    //   1100: getfield 63	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_watchTimertask	Ljava/util/TimerTask;
    //   1103: aload_0
    //   1104: getfield 55	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_durationMS	I
    //   1107: sipush 1000
    //   1110: iadd
    //   1111: i2l
    //   1112: invokevirtual 365	java/util/Timer:schedule	(Ljava/util/TimerTask;J)V
    //   1115: invokestatic 109	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   1118: ifeq +42 -> 1160
    //   1121: ldc 111
    //   1123: iconst_2
    //   1124: new 113	java/lang/StringBuilder
    //   1127: dup
    //   1128: ldc_w 367
    //   1131: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1134: aload_0
    //   1135: getfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   1138: invokevirtual 369	android/media/MediaPlayer:getDuration	()I
    //   1141: invokevirtual 122	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1144: ldc 235
    //   1146: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1149: iload 5
    //   1151: invokevirtual 171	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1154: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1157: invokestatic 141	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1160: sipush 13638
    //   1163: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1166: iconst_1
    //   1167: ireturn
    //   1168: aload_0
    //   1169: iconst_0
    //   1170: putfield 49	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_streamType	I
    //   1173: getstatic 374	android/os/Build$VERSION:SDK_INT	I
    //   1176: bipush 11
    //   1178: if_icmplt -213 -> 965
    //   1181: iconst_3
    //   1182: istore_1
    //   1183: goto -218 -> 965
    //   1186: aload_0
    //   1187: iload 6
    //   1189: putfield 57	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_loopCount	I
    //   1192: aload_0
    //   1193: aload_0
    //   1194: getfield 57	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_loopCount	I
    //   1197: aload_0
    //   1198: getfield 47	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   1201: invokevirtual 369	android/media/MediaPlayer:getDuration	()I
    //   1204: imul
    //   1205: putfield 55	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_durationMS	I
    //   1208: goto -166 -> 1042
    //   1211: astore_3
    //   1212: goto -765 -> 447
    //   1215: goto -599 -> 616
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1218	0	this	TraeMediaPlayer
    //   0	1218	1	paramInt1	int
    //   0	1218	2	paramInt2	int
    //   0	1218	3	paramUri	android.net.Uri
    //   0	1218	4	paramString	java.lang.String
    //   0	1218	5	paramBoolean1	boolean
    //   0	1218	6	paramInt3	int
    //   0	1218	7	paramBoolean2	boolean
    //   0	1218	8	paramBoolean3	boolean
    //   0	1218	9	paramInt4	int
    //   249	3	10	bool	boolean
    //   67	246	11	localObject	Object
    //   352	708	11	localException	Exception
    //   58	48	12	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   264	271	352	java/lang/Exception
    //   235	251	394	java/lang/IllegalStateException
    //   271	276	394	java/lang/IllegalStateException
    //   276	300	394	java/lang/IllegalStateException
    //   300	344	394	java/lang/IllegalStateException
    //   386	391	394	java/lang/IllegalStateException
    //   461	474	394	java/lang/IllegalStateException
    //   572	588	394	java/lang/IllegalStateException
    //   616	638	394	java/lang/IllegalStateException
    //   638	650	394	java/lang/IllegalStateException
    //   650	655	394	java/lang/IllegalStateException
    //   667	689	394	java/lang/IllegalStateException
    //   689	701	394	java/lang/IllegalStateException
    //   705	727	394	java/lang/IllegalStateException
    //   727	739	394	java/lang/IllegalStateException
    //   747	770	394	java/lang/IllegalStateException
    //   822	844	394	java/lang/IllegalStateException
    //   844	856	394	java/lang/IllegalStateException
    //   908	931	394	java/lang/IllegalStateException
    //   931	940	394	java/lang/IllegalStateException
    //   943	949	394	java/lang/IllegalStateException
    //   951	963	394	java/lang/IllegalStateException
    //   965	984	394	java/lang/IllegalStateException
    //   984	1042	394	java/lang/IllegalStateException
    //   1042	1065	394	java/lang/IllegalStateException
    //   1065	1115	394	java/lang/IllegalStateException
    //   1115	1160	394	java/lang/IllegalStateException
    //   1168	1173	394	java/lang/IllegalStateException
    //   1173	1181	394	java/lang/IllegalStateException
    //   1186	1208	394	java/lang/IllegalStateException
    //   264	271	460	finally
    //   354	386	460	finally
    //   235	251	474	java/io/IOException
    //   271	276	474	java/io/IOException
    //   276	300	474	java/io/IOException
    //   300	344	474	java/io/IOException
    //   386	391	474	java/io/IOException
    //   461	474	474	java/io/IOException
    //   572	588	474	java/io/IOException
    //   616	638	474	java/io/IOException
    //   638	650	474	java/io/IOException
    //   650	655	474	java/io/IOException
    //   667	689	474	java/io/IOException
    //   689	701	474	java/io/IOException
    //   705	727	474	java/io/IOException
    //   727	739	474	java/io/IOException
    //   747	770	474	java/io/IOException
    //   822	844	474	java/io/IOException
    //   844	856	474	java/io/IOException
    //   908	931	474	java/io/IOException
    //   931	940	474	java/io/IOException
    //   943	949	474	java/io/IOException
    //   951	963	474	java/io/IOException
    //   965	984	474	java/io/IOException
    //   984	1042	474	java/io/IOException
    //   1042	1065	474	java/io/IOException
    //   1065	1115	474	java/io/IOException
    //   1115	1160	474	java/io/IOException
    //   1168	1173	474	java/io/IOException
    //   1173	1181	474	java/io/IOException
    //   1186	1208	474	java/io/IOException
    //   235	251	523	java/lang/Exception
    //   271	276	523	java/lang/Exception
    //   276	300	523	java/lang/Exception
    //   300	344	523	java/lang/Exception
    //   386	391	523	java/lang/Exception
    //   395	440	523	java/lang/Exception
    //   461	474	523	java/lang/Exception
    //   475	520	523	java/lang/Exception
    //   572	588	523	java/lang/Exception
    //   616	638	523	java/lang/Exception
    //   638	650	523	java/lang/Exception
    //   650	655	523	java/lang/Exception
    //   667	689	523	java/lang/Exception
    //   689	701	523	java/lang/Exception
    //   705	727	523	java/lang/Exception
    //   727	739	523	java/lang/Exception
    //   747	770	523	java/lang/Exception
    //   774	819	523	java/lang/Exception
    //   822	844	523	java/lang/Exception
    //   844	856	523	java/lang/Exception
    //   860	905	523	java/lang/Exception
    //   908	931	523	java/lang/Exception
    //   931	940	523	java/lang/Exception
    //   943	949	523	java/lang/Exception
    //   951	963	523	java/lang/Exception
    //   965	984	523	java/lang/Exception
    //   984	1042	523	java/lang/Exception
    //   1042	1065	523	java/lang/Exception
    //   1065	1115	523	java/lang/Exception
    //   1115	1160	523	java/lang/Exception
    //   1168	1173	523	java/lang/Exception
    //   1173	1181	523	java/lang/Exception
    //   1186	1208	523	java/lang/Exception
    //   235	251	773	java/lang/IllegalArgumentException
    //   271	276	773	java/lang/IllegalArgumentException
    //   276	300	773	java/lang/IllegalArgumentException
    //   300	344	773	java/lang/IllegalArgumentException
    //   386	391	773	java/lang/IllegalArgumentException
    //   461	474	773	java/lang/IllegalArgumentException
    //   572	588	773	java/lang/IllegalArgumentException
    //   616	638	773	java/lang/IllegalArgumentException
    //   638	650	773	java/lang/IllegalArgumentException
    //   650	655	773	java/lang/IllegalArgumentException
    //   667	689	773	java/lang/IllegalArgumentException
    //   689	701	773	java/lang/IllegalArgumentException
    //   705	727	773	java/lang/IllegalArgumentException
    //   727	739	773	java/lang/IllegalArgumentException
    //   747	770	773	java/lang/IllegalArgumentException
    //   822	844	773	java/lang/IllegalArgumentException
    //   844	856	773	java/lang/IllegalArgumentException
    //   908	931	773	java/lang/IllegalArgumentException
    //   931	940	773	java/lang/IllegalArgumentException
    //   943	949	773	java/lang/IllegalArgumentException
    //   951	963	773	java/lang/IllegalArgumentException
    //   965	984	773	java/lang/IllegalArgumentException
    //   984	1042	773	java/lang/IllegalArgumentException
    //   1042	1065	773	java/lang/IllegalArgumentException
    //   1065	1115	773	java/lang/IllegalArgumentException
    //   1115	1160	773	java/lang/IllegalArgumentException
    //   1168	1173	773	java/lang/IllegalArgumentException
    //   1173	1181	773	java/lang/IllegalArgumentException
    //   1186	1208	773	java/lang/IllegalArgumentException
    //   235	251	859	java/lang/SecurityException
    //   271	276	859	java/lang/SecurityException
    //   276	300	859	java/lang/SecurityException
    //   300	344	859	java/lang/SecurityException
    //   386	391	859	java/lang/SecurityException
    //   461	474	859	java/lang/SecurityException
    //   572	588	859	java/lang/SecurityException
    //   616	638	859	java/lang/SecurityException
    //   638	650	859	java/lang/SecurityException
    //   650	655	859	java/lang/SecurityException
    //   667	689	859	java/lang/SecurityException
    //   689	701	859	java/lang/SecurityException
    //   705	727	859	java/lang/SecurityException
    //   727	739	859	java/lang/SecurityException
    //   747	770	859	java/lang/SecurityException
    //   822	844	859	java/lang/SecurityException
    //   844	856	859	java/lang/SecurityException
    //   908	931	859	java/lang/SecurityException
    //   931	940	859	java/lang/SecurityException
    //   943	949	859	java/lang/SecurityException
    //   951	963	859	java/lang/SecurityException
    //   965	984	859	java/lang/SecurityException
    //   984	1042	859	java/lang/SecurityException
    //   1042	1065	859	java/lang/SecurityException
    //   1065	1115	859	java/lang/SecurityException
    //   1115	1160	859	java/lang/SecurityException
    //   1168	1173	859	java/lang/SecurityException
    //   1173	1181	859	java/lang/SecurityException
    //   1186	1208	859	java/lang/SecurityException
    //   440	447	1211	java/lang/Exception
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
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 2, "release MediaPlayer failed." + localException.getMessage());
        }
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeMediaPlayer
 * JD-Core Version:    0.7.0.1
 */