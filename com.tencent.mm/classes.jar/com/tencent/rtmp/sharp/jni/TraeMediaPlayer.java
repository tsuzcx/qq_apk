package com.tencent.rtmp.sharp.jni;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
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
  private TraeMediaPlayer.a mCallback;
  private MediaPlayer mMediaPlay = null;
  
  public TraeMediaPlayer(Context paramContext, TraeMediaPlayer.a parama)
  {
    this._context = paramContext;
    this.mCallback = parama;
  }
  
  private void volumeDo()
  {
    if ((this.mMediaPlay == null) || (!this._ringMode) || (this._streamType == 2)) {
      return;
    }
    for (;;)
    {
      int i;
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
          break label183;
        }
        QLog.e("TRAE", 2, "TraeMediaPlay volumeDo currV:" + j + " maxV:" + i + " currRV:" + k + " maxRV:" + m + " setV:" + n);
      }
      catch (Exception localException)
      {
        AudioManager localAudioManager;
        int j;
        return;
      }
      localAudioManager.setStreamVolume(this._streamType, i, 0);
      this._prevVolume = j;
      return;
      label183:
      while (n + 1 < i)
      {
        i = n + 1;
        break;
      }
    }
  }
  
  private void volumeUndo()
  {
    if ((this.mMediaPlay == null) || (!this._ringMode) || (this._streamType == 2) || (this._prevVolume == -1)) {
      return;
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "TraeMediaPlay volumeUndo _prevVolume:" + this._prevVolume);
      }
      ((AudioManager)this._context.getSystemService("audio")).setStreamVolume(this._streamType, this._prevVolume, 0);
      return;
    }
    catch (Exception localException) {}
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
    AudioDeviceInterface.LogTraceEntry(" cb:" + this.mCallback + " loopCount:" + this._loopCount + " _loop:" + this._loop);
    if (this._loop)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TRAE", 2, "loop play,continue...");
      }
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
          this.mCallback.a();
        }
        AudioDeviceInterface.LogTraceExit();
      }
      catch (Exception paramMediaPlayer)
      {
        continue;
      }
      return;
      this.mMediaPlay.start();
      this._loopCount -= 1;
    }
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    AudioDeviceInterface.LogTraceEntry(" cb:" + this.mCallback + " arg1:" + paramInt1 + " arg2:" + paramInt2);
    try
    {
      this.mMediaPlay.release();
      label47:
      this.mMediaPlay = null;
      if (this.mCallback != null) {
        this.mCallback.a();
      }
      AudioDeviceInterface.LogTraceExit();
      return false;
    }
    catch (Exception paramMediaPlayer)
    {
      break label47;
    }
  }
  
  /* Error */
  public boolean playRing(int paramInt1, int paramInt2, android.net.Uri paramUri, java.lang.String paramString, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, boolean paramBoolean3, int paramInt4)
  {
    // Byte code:
    //   0: invokestatic 99	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   3: ifeq +129 -> 132
    //   6: new 103	java/lang/StringBuilder
    //   9: dup
    //   10: ldc 209
    //   12: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   15: iload_1
    //   16: invokevirtual 112	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   19: ldc 211
    //   21: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: iload_2
    //   25: invokevirtual 112	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   28: ldc 213
    //   30: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_3
    //   34: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   37: ldc 215
    //   39: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload 4
    //   44: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc 217
    //   49: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: astore 12
    //   54: iload 5
    //   56: ifeq +147 -> 203
    //   59: ldc 219
    //   61: astore 11
    //   63: aload 12
    //   65: aload 11
    //   67: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: ldc 221
    //   72: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: iload 6
    //   77: invokevirtual 112	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   80: ldc 223
    //   82: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: astore 12
    //   87: iload 7
    //   89: ifeq +121 -> 210
    //   92: ldc 219
    //   94: astore 11
    //   96: ldc 101
    //   98: iconst_2
    //   99: aload 12
    //   101: aload 11
    //   103: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: ldc 225
    //   108: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: iload 8
    //   113: invokevirtual 156	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   116: ldc 227
    //   118: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: iload 9
    //   123: invokevirtual 112	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   126: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokestatic 131	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   132: iload 5
    //   134: ifne +89 -> 223
    //   137: iload 6
    //   139: ifgt +84 -> 223
    //   142: invokestatic 99	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   145: ifeq +56 -> 201
    //   148: new 103	java/lang/StringBuilder
    //   151: dup
    //   152: ldc 229
    //   154: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   157: iload_1
    //   158: invokevirtual 112	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   161: ldc 217
    //   163: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: astore 4
    //   168: iload 5
    //   170: ifeq +47 -> 217
    //   173: ldc 219
    //   175: astore_3
    //   176: ldc 101
    //   178: iconst_2
    //   179: aload 4
    //   181: aload_3
    //   182: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: ldc 221
    //   187: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: iload 6
    //   192: invokevirtual 112	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   195: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: invokestatic 131	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   201: iconst_0
    //   202: ireturn
    //   203: ldc 231
    //   205: astore 11
    //   207: goto -144 -> 63
    //   210: ldc 231
    //   212: astore 11
    //   214: goto -118 -> 96
    //   217: ldc 231
    //   219: astore_3
    //   220: goto -44 -> 176
    //   223: aload_0
    //   224: getfield 46	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   227: ifnull +31 -> 258
    //   230: aload_0
    //   231: getfield 46	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   234: invokevirtual 173	android/media/MediaPlayer:isPlaying	()Z
    //   237: istore 10
    //   239: iload 10
    //   241: ifeq +5 -> 246
    //   244: iconst_0
    //   245: ireturn
    //   246: aload_0
    //   247: getfield 46	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   250: invokevirtual 182	android/media/MediaPlayer:release	()V
    //   253: aload_0
    //   254: aconst_null
    //   255: putfield 46	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   258: aload_0
    //   259: getfield 60	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_watchTimer	Ljava/util/Timer;
    //   262: ifnull +20 -> 282
    //   265: aload_0
    //   266: getfield 60	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_watchTimer	Ljava/util/Timer;
    //   269: invokevirtual 236	java/util/Timer:cancel	()V
    //   272: aload_0
    //   273: aconst_null
    //   274: putfield 60	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_watchTimer	Ljava/util/Timer;
    //   277: aload_0
    //   278: aconst_null
    //   279: putfield 62	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_watchTimertask	Ljava/util/TimerTask;
    //   282: aload_0
    //   283: getfield 66	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_context	Landroid/content/Context;
    //   286: ldc 78
    //   288: invokevirtual 84	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   291: checkcast 86	android/media/AudioManager
    //   294: astore 11
    //   296: aload_0
    //   297: new 170	android/media/MediaPlayer
    //   300: dup
    //   301: invokespecial 237	android/media/MediaPlayer:<init>	()V
    //   304: putfield 46	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   307: aload_0
    //   308: getfield 46	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   311: ifnonnull +187 -> 498
    //   314: aload_0
    //   315: getfield 46	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   318: invokevirtual 182	android/media/MediaPlayer:release	()V
    //   321: aload_0
    //   322: aconst_null
    //   323: putfield 46	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   326: iconst_0
    //   327: ireturn
    //   328: astore 11
    //   330: aload_0
    //   331: aconst_null
    //   332: putfield 46	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   335: goto -77 -> 258
    //   338: astore_3
    //   339: invokestatic 99	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   342: ifeq +40 -> 382
    //   345: ldc 101
    //   347: iconst_2
    //   348: new 103	java/lang/StringBuilder
    //   351: dup
    //   352: ldc 239
    //   354: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   357: aload_3
    //   358: invokevirtual 242	java/lang/IllegalStateException:getLocalizedMessage	()Ljava/lang/String;
    //   361: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: ldc 244
    //   366: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: aload_3
    //   370: invokevirtual 247	java/lang/IllegalStateException:getMessage	()Ljava/lang/String;
    //   373: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   379: invokestatic 166	com/tencent/rtmp/sharp/jni/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   382: aload_0
    //   383: getfield 46	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   386: invokevirtual 182	android/media/MediaPlayer:release	()V
    //   389: aload_0
    //   390: aconst_null
    //   391: putfield 46	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   394: iconst_0
    //   395: ireturn
    //   396: astore_3
    //   397: aload_0
    //   398: aconst_null
    //   399: putfield 46	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   402: aload_3
    //   403: athrow
    //   404: astore_3
    //   405: invokestatic 99	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   408: ifeq -26 -> 382
    //   411: ldc 101
    //   413: iconst_2
    //   414: new 103	java/lang/StringBuilder
    //   417: dup
    //   418: ldc 249
    //   420: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   423: aload_3
    //   424: invokevirtual 250	java/io/IOException:getLocalizedMessage	()Ljava/lang/String;
    //   427: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: ldc 244
    //   432: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: aload_3
    //   436: invokevirtual 251	java/io/IOException:getMessage	()Ljava/lang/String;
    //   439: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   445: invokestatic 166	com/tencent/rtmp/sharp/jni/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   448: goto -66 -> 382
    //   451: astore_3
    //   452: invokestatic 99	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   455: ifeq -73 -> 382
    //   458: ldc 101
    //   460: iconst_2
    //   461: new 103	java/lang/StringBuilder
    //   464: dup
    //   465: ldc 253
    //   467: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   470: aload_3
    //   471: invokevirtual 254	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   474: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: ldc 244
    //   479: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: aload_3
    //   483: invokevirtual 255	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   486: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   492: invokestatic 166	com/tencent/rtmp/sharp/jni/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   495: goto -113 -> 382
    //   498: aload_0
    //   499: getfield 46	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   502: aload_0
    //   503: invokevirtual 259	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   506: aload_0
    //   507: getfield 46	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   510: aload_0
    //   511: invokevirtual 263	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   514: iload_1
    //   515: tableswitch	default:+638 -> 1153, 0:+75->590, 1:+237->752, 2:+329->844
    //   541: nop
    //   542: dadd
    //   543: ifeq +26 -> 569
    //   546: ldc 101
    //   548: iconst_2
    //   549: new 103	java/lang/StringBuilder
    //   552: dup
    //   553: ldc_w 265
    //   556: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   559: iload_1
    //   560: invokevirtual 112	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   563: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   566: invokestatic 131	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   569: aload_0
    //   570: getfield 46	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   573: invokevirtual 182	android/media/MediaPlayer:release	()V
    //   576: aload_0
    //   577: aconst_null
    //   578: putfield 46	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   581: aload_0
    //   582: getfield 46	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   585: ifnonnull +301 -> 886
    //   588: iconst_0
    //   589: ireturn
    //   590: invokestatic 99	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   593: ifeq +26 -> 619
    //   596: ldc 101
    //   598: iconst_2
    //   599: new 103	java/lang/StringBuilder
    //   602: dup
    //   603: ldc_w 267
    //   606: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   609: iload_2
    //   610: invokevirtual 112	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   613: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   616: invokestatic 131	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   619: aload_0
    //   620: getfield 66	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_context	Landroid/content/Context;
    //   623: invokevirtual 271	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   626: iload_2
    //   627: invokevirtual 277	android/content/res/Resources:openRawResourceFd	(I)Landroid/content/res/AssetFileDescriptor;
    //   630: astore_3
    //   631: aload_3
    //   632: ifnonnull +46 -> 678
    //   635: invokestatic 99	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   638: ifeq +26 -> 664
    //   641: ldc 101
    //   643: iconst_2
    //   644: new 103	java/lang/StringBuilder
    //   647: dup
    //   648: ldc_w 279
    //   651: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   654: iload_2
    //   655: invokevirtual 112	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   658: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   661: invokestatic 131	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   664: aload_0
    //   665: getfield 46	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   668: invokevirtual 182	android/media/MediaPlayer:release	()V
    //   671: aload_0
    //   672: aconst_null
    //   673: putfield 46	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   676: iconst_0
    //   677: ireturn
    //   678: aload_0
    //   679: getfield 46	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   682: aload_3
    //   683: invokevirtual 285	android/content/res/AssetFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   686: aload_3
    //   687: invokevirtual 289	android/content/res/AssetFileDescriptor:getStartOffset	()J
    //   690: aload_3
    //   691: invokevirtual 292	android/content/res/AssetFileDescriptor:getLength	()J
    //   694: invokevirtual 296	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   697: aload_3
    //   698: invokevirtual 299	android/content/res/AssetFileDescriptor:close	()V
    //   701: goto -120 -> 581
    //   704: astore_3
    //   705: invokestatic 99	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   708: ifeq -326 -> 382
    //   711: ldc 101
    //   713: iconst_2
    //   714: new 103	java/lang/StringBuilder
    //   717: dup
    //   718: ldc_w 301
    //   721: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   724: aload_3
    //   725: invokevirtual 302	java/lang/IllegalArgumentException:getLocalizedMessage	()Ljava/lang/String;
    //   728: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   731: ldc 244
    //   733: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   736: aload_3
    //   737: invokevirtual 303	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   740: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   746: invokestatic 166	com/tencent/rtmp/sharp/jni/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   749: goto -367 -> 382
    //   752: invokestatic 99	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   755: ifeq +26 -> 781
    //   758: ldc 101
    //   760: iconst_2
    //   761: new 103	java/lang/StringBuilder
    //   764: dup
    //   765: ldc_w 305
    //   768: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   771: aload_3
    //   772: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   775: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   778: invokestatic 131	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   781: aload_0
    //   782: getfield 46	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   785: aload_0
    //   786: getfield 66	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_context	Landroid/content/Context;
    //   789: aload_3
    //   790: invokevirtual 308	android/media/MediaPlayer:setDataSource	(Landroid/content/Context;Landroid/net/Uri;)V
    //   793: goto -212 -> 581
    //   796: astore_3
    //   797: invokestatic 99	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   800: ifeq -418 -> 382
    //   803: ldc 101
    //   805: iconst_2
    //   806: new 103	java/lang/StringBuilder
    //   809: dup
    //   810: ldc_w 310
    //   813: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   816: aload_3
    //   817: invokevirtual 311	java/lang/SecurityException:getLocalizedMessage	()Ljava/lang/String;
    //   820: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   823: ldc 244
    //   825: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   828: aload_3
    //   829: invokevirtual 312	java/lang/SecurityException:getMessage	()Ljava/lang/String;
    //   832: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   835: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   838: invokestatic 166	com/tencent/rtmp/sharp/jni/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   841: goto -459 -> 382
    //   844: invokestatic 99	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   847: ifeq +27 -> 874
    //   850: ldc 101
    //   852: iconst_2
    //   853: new 103	java/lang/StringBuilder
    //   856: dup
    //   857: ldc_w 314
    //   860: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   863: aload 4
    //   865: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   868: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   871: invokestatic 131	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   874: aload_0
    //   875: getfield 46	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   878: aload 4
    //   880: invokevirtual 316	android/media/MediaPlayer:setDataSource	(Ljava/lang/String;)V
    //   883: goto -302 -> 581
    //   886: aload_0
    //   887: iload 7
    //   889: putfield 58	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_ringMode	Z
    //   892: iconst_0
    //   893: istore_1
    //   894: aload_0
    //   895: getfield 58	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_ringMode	Z
    //   898: ifeq +208 -> 1106
    //   901: aload_0
    //   902: iconst_2
    //   903: putfield 48	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_streamType	I
    //   906: iconst_1
    //   907: istore_1
    //   908: aload_0
    //   909: iload 8
    //   911: putfield 50	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_hasCall	Z
    //   914: aload_0
    //   915: getfield 50	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_hasCall	Z
    //   918: ifeq +9 -> 927
    //   921: aload_0
    //   922: iload 9
    //   924: putfield 48	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_streamType	I
    //   927: aload_0
    //   928: getfield 46	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   931: aload_0
    //   932: getfield 48	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_streamType	I
    //   935: invokevirtual 320	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   938: aload_0
    //   939: getfield 46	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   942: invokevirtual 323	android/media/MediaPlayer:prepare	()V
    //   945: aload_0
    //   946: getfield 46	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   949: iload 5
    //   951: invokevirtual 327	android/media/MediaPlayer:setLooping	(Z)V
    //   954: aload_0
    //   955: getfield 46	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   958: invokevirtual 191	android/media/MediaPlayer:start	()V
    //   961: aload_0
    //   962: iload 5
    //   964: putfield 52	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_loop	Z
    //   967: aload_0
    //   968: getfield 52	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_loop	Z
    //   971: iconst_1
    //   972: if_icmpne +152 -> 1124
    //   975: aload_0
    //   976: iconst_1
    //   977: putfield 56	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_loopCount	I
    //   980: aload_0
    //   981: iconst_m1
    //   982: putfield 54	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_durationMS	I
    //   985: aload_0
    //   986: aload_0
    //   987: getfield 56	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_loopCount	I
    //   990: iconst_1
    //   991: isub
    //   992: putfield 56	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_loopCount	I
    //   995: aload_0
    //   996: getfield 50	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_hasCall	Z
    //   999: ifne +9 -> 1008
    //   1002: aload 11
    //   1004: iload_1
    //   1005: invokevirtual 330	android/media/AudioManager:setMode	(I)V
    //   1008: aload_0
    //   1009: getfield 54	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_durationMS	I
    //   1012: ifle +46 -> 1058
    //   1015: aload_0
    //   1016: new 233	java/util/Timer
    //   1019: dup
    //   1020: invokespecial 331	java/util/Timer:<init>	()V
    //   1023: putfield 60	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_watchTimer	Ljava/util/Timer;
    //   1026: aload_0
    //   1027: new 10	com/tencent/rtmp/sharp/jni/TraeMediaPlayer$1
    //   1030: dup
    //   1031: aload_0
    //   1032: invokespecial 334	com/tencent/rtmp/sharp/jni/TraeMediaPlayer$1:<init>	(Lcom/tencent/rtmp/sharp/jni/TraeMediaPlayer;)V
    //   1035: putfield 62	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_watchTimertask	Ljava/util/TimerTask;
    //   1038: aload_0
    //   1039: getfield 60	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_watchTimer	Ljava/util/Timer;
    //   1042: aload_0
    //   1043: getfield 62	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_watchTimertask	Ljava/util/TimerTask;
    //   1046: aload_0
    //   1047: getfield 54	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_durationMS	I
    //   1050: sipush 1000
    //   1053: iadd
    //   1054: i2l
    //   1055: invokevirtual 338	java/util/Timer:schedule	(Ljava/util/TimerTask;J)V
    //   1058: invokestatic 99	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   1061: ifeq +95 -> 1156
    //   1064: ldc 101
    //   1066: iconst_2
    //   1067: new 103	java/lang/StringBuilder
    //   1070: dup
    //   1071: ldc_w 340
    //   1074: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1077: aload_0
    //   1078: getfield 46	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   1081: invokevirtual 342	android/media/MediaPlayer:getDuration	()I
    //   1084: invokevirtual 112	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1087: ldc 217
    //   1089: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1092: iload 5
    //   1094: invokevirtual 156	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1097: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1100: invokestatic 131	com/tencent/rtmp/sharp/jni/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1103: goto +53 -> 1156
    //   1106: aload_0
    //   1107: iconst_0
    //   1108: putfield 48	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_streamType	I
    //   1111: getstatic 347	android/os/Build$VERSION:SDK_INT	I
    //   1114: bipush 11
    //   1116: if_icmplt -208 -> 908
    //   1119: iconst_3
    //   1120: istore_1
    //   1121: goto -213 -> 908
    //   1124: aload_0
    //   1125: iload 6
    //   1127: putfield 56	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_loopCount	I
    //   1130: aload_0
    //   1131: aload_0
    //   1132: getfield 56	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_loopCount	I
    //   1135: aload_0
    //   1136: getfield 46	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   1139: invokevirtual 342	android/media/MediaPlayer:getDuration	()I
    //   1142: imul
    //   1143: putfield 54	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_durationMS	I
    //   1146: goto -161 -> 985
    //   1149: astore_3
    //   1150: goto -761 -> 389
    //   1153: goto -613 -> 540
    //   1156: iconst_1
    //   1157: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1158	0	this	TraeMediaPlayer
    //   0	1158	1	paramInt1	int
    //   0	1158	2	paramInt2	int
    //   0	1158	3	paramUri	android.net.Uri
    //   0	1158	4	paramString	java.lang.String
    //   0	1158	5	paramBoolean1	boolean
    //   0	1158	6	paramInt3	int
    //   0	1158	7	paramBoolean2	boolean
    //   0	1158	8	paramBoolean3	boolean
    //   0	1158	9	paramInt4	int
    //   237	3	10	bool	boolean
    //   61	234	11	localObject	Object
    //   328	675	11	localException	Exception
    //   52	48	12	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   246	253	328	java/lang/Exception
    //   223	239	338	java/lang/IllegalStateException
    //   253	258	338	java/lang/IllegalStateException
    //   258	282	338	java/lang/IllegalStateException
    //   282	326	338	java/lang/IllegalStateException
    //   330	335	338	java/lang/IllegalStateException
    //   397	404	338	java/lang/IllegalStateException
    //   498	514	338	java/lang/IllegalStateException
    //   540	569	338	java/lang/IllegalStateException
    //   569	581	338	java/lang/IllegalStateException
    //   581	588	338	java/lang/IllegalStateException
    //   590	619	338	java/lang/IllegalStateException
    //   619	631	338	java/lang/IllegalStateException
    //   635	664	338	java/lang/IllegalStateException
    //   664	676	338	java/lang/IllegalStateException
    //   678	701	338	java/lang/IllegalStateException
    //   752	781	338	java/lang/IllegalStateException
    //   781	793	338	java/lang/IllegalStateException
    //   844	874	338	java/lang/IllegalStateException
    //   874	883	338	java/lang/IllegalStateException
    //   886	892	338	java/lang/IllegalStateException
    //   894	906	338	java/lang/IllegalStateException
    //   908	927	338	java/lang/IllegalStateException
    //   927	985	338	java/lang/IllegalStateException
    //   985	1008	338	java/lang/IllegalStateException
    //   1008	1058	338	java/lang/IllegalStateException
    //   1058	1103	338	java/lang/IllegalStateException
    //   1106	1111	338	java/lang/IllegalStateException
    //   1111	1119	338	java/lang/IllegalStateException
    //   1124	1146	338	java/lang/IllegalStateException
    //   246	253	396	finally
    //   223	239	404	java/io/IOException
    //   253	258	404	java/io/IOException
    //   258	282	404	java/io/IOException
    //   282	326	404	java/io/IOException
    //   330	335	404	java/io/IOException
    //   397	404	404	java/io/IOException
    //   498	514	404	java/io/IOException
    //   540	569	404	java/io/IOException
    //   569	581	404	java/io/IOException
    //   581	588	404	java/io/IOException
    //   590	619	404	java/io/IOException
    //   619	631	404	java/io/IOException
    //   635	664	404	java/io/IOException
    //   664	676	404	java/io/IOException
    //   678	701	404	java/io/IOException
    //   752	781	404	java/io/IOException
    //   781	793	404	java/io/IOException
    //   844	874	404	java/io/IOException
    //   874	883	404	java/io/IOException
    //   886	892	404	java/io/IOException
    //   894	906	404	java/io/IOException
    //   908	927	404	java/io/IOException
    //   927	985	404	java/io/IOException
    //   985	1008	404	java/io/IOException
    //   1008	1058	404	java/io/IOException
    //   1058	1103	404	java/io/IOException
    //   1106	1111	404	java/io/IOException
    //   1111	1119	404	java/io/IOException
    //   1124	1146	404	java/io/IOException
    //   223	239	451	java/lang/Exception
    //   253	258	451	java/lang/Exception
    //   258	282	451	java/lang/Exception
    //   282	326	451	java/lang/Exception
    //   330	335	451	java/lang/Exception
    //   339	382	451	java/lang/Exception
    //   397	404	451	java/lang/Exception
    //   405	448	451	java/lang/Exception
    //   498	514	451	java/lang/Exception
    //   540	569	451	java/lang/Exception
    //   569	581	451	java/lang/Exception
    //   581	588	451	java/lang/Exception
    //   590	619	451	java/lang/Exception
    //   619	631	451	java/lang/Exception
    //   635	664	451	java/lang/Exception
    //   664	676	451	java/lang/Exception
    //   678	701	451	java/lang/Exception
    //   705	749	451	java/lang/Exception
    //   752	781	451	java/lang/Exception
    //   781	793	451	java/lang/Exception
    //   797	841	451	java/lang/Exception
    //   844	874	451	java/lang/Exception
    //   874	883	451	java/lang/Exception
    //   886	892	451	java/lang/Exception
    //   894	906	451	java/lang/Exception
    //   908	927	451	java/lang/Exception
    //   927	985	451	java/lang/Exception
    //   985	1008	451	java/lang/Exception
    //   1008	1058	451	java/lang/Exception
    //   1058	1103	451	java/lang/Exception
    //   1106	1111	451	java/lang/Exception
    //   1111	1119	451	java/lang/Exception
    //   1124	1146	451	java/lang/Exception
    //   223	239	704	java/lang/IllegalArgumentException
    //   253	258	704	java/lang/IllegalArgumentException
    //   258	282	704	java/lang/IllegalArgumentException
    //   282	326	704	java/lang/IllegalArgumentException
    //   330	335	704	java/lang/IllegalArgumentException
    //   397	404	704	java/lang/IllegalArgumentException
    //   498	514	704	java/lang/IllegalArgumentException
    //   540	569	704	java/lang/IllegalArgumentException
    //   569	581	704	java/lang/IllegalArgumentException
    //   581	588	704	java/lang/IllegalArgumentException
    //   590	619	704	java/lang/IllegalArgumentException
    //   619	631	704	java/lang/IllegalArgumentException
    //   635	664	704	java/lang/IllegalArgumentException
    //   664	676	704	java/lang/IllegalArgumentException
    //   678	701	704	java/lang/IllegalArgumentException
    //   752	781	704	java/lang/IllegalArgumentException
    //   781	793	704	java/lang/IllegalArgumentException
    //   844	874	704	java/lang/IllegalArgumentException
    //   874	883	704	java/lang/IllegalArgumentException
    //   886	892	704	java/lang/IllegalArgumentException
    //   894	906	704	java/lang/IllegalArgumentException
    //   908	927	704	java/lang/IllegalArgumentException
    //   927	985	704	java/lang/IllegalArgumentException
    //   985	1008	704	java/lang/IllegalArgumentException
    //   1008	1058	704	java/lang/IllegalArgumentException
    //   1058	1103	704	java/lang/IllegalArgumentException
    //   1106	1111	704	java/lang/IllegalArgumentException
    //   1111	1119	704	java/lang/IllegalArgumentException
    //   1124	1146	704	java/lang/IllegalArgumentException
    //   223	239	796	java/lang/SecurityException
    //   253	258	796	java/lang/SecurityException
    //   258	282	796	java/lang/SecurityException
    //   282	326	796	java/lang/SecurityException
    //   330	335	796	java/lang/SecurityException
    //   397	404	796	java/lang/SecurityException
    //   498	514	796	java/lang/SecurityException
    //   540	569	796	java/lang/SecurityException
    //   569	581	796	java/lang/SecurityException
    //   581	588	796	java/lang/SecurityException
    //   590	619	796	java/lang/SecurityException
    //   619	631	796	java/lang/SecurityException
    //   635	664	796	java/lang/SecurityException
    //   664	676	796	java/lang/SecurityException
    //   678	701	796	java/lang/SecurityException
    //   752	781	796	java/lang/SecurityException
    //   781	793	796	java/lang/SecurityException
    //   844	874	796	java/lang/SecurityException
    //   874	883	796	java/lang/SecurityException
    //   886	892	796	java/lang/SecurityException
    //   894	906	796	java/lang/SecurityException
    //   908	927	796	java/lang/SecurityException
    //   927	985	796	java/lang/SecurityException
    //   985	1008	796	java/lang/SecurityException
    //   1008	1058	796	java/lang/SecurityException
    //   1058	1103	796	java/lang/SecurityException
    //   1106	1111	796	java/lang/SecurityException
    //   1111	1119	796	java/lang/SecurityException
    //   1124	1146	796	java/lang/SecurityException
    //   382	389	1149	java/lang/Exception
  }
  
  public void stopRing()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TRAE", 2, "TraeMediaPlay stopRing ");
    }
    if (this.mMediaPlay == null) {
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
      label78:
      break label78;
    }
    this.mMediaPlay = null;
    this._durationMS = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeMediaPlayer
 * JD-Core Version:    0.7.0.1
 */