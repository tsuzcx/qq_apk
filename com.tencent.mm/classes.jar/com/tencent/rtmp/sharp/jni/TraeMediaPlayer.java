package com.tencent.rtmp.sharp.jni;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.d.a.a.a;
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
  private TraeMediaPlayer.a mCallback;
  private MediaPlayer mMediaPlay = null;
  
  public TraeMediaPlayer(Context paramContext, TraeMediaPlayer.a parama)
  {
    this._context = paramContext;
    this.mCallback = parama;
  }
  
  private void volumeDo()
  {
    AppMethodBeat.i(65623);
    if ((this.mMediaPlay == null) || (!this._ringMode) || (this._streamType == 2))
    {
      AppMethodBeat.o(65623);
      return;
    }
    try
    {
      AudioManager localAudioManager = (AudioManager)this._context.getSystemService("audio");
      int j = localAudioManager.getStreamVolume(this._streamType);
      int i = localAudioManager.getStreamMaxVolume(this._streamType);
      int k = localAudioManager.getStreamVolume(2);
      int m = localAudioManager.getStreamMaxVolume(2);
      int n = (int)(k * 1.0D / m * i);
      a.dUd();
      a.iO("TRAE", "TraeMediaPlay volumeDo currV:" + j + " maxV:" + i + " currRV:" + k + " maxRV:" + m + " setV:" + n);
      if (n + 1 >= i) {}
      for (;;)
      {
        localAudioManager.setStreamVolume(this._streamType, i, 0);
        this._prevVolume = j;
        AppMethodBeat.o(65623);
        return;
        i = n + 1;
      }
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(65623);
    }
  }
  
  private void volumeUndo()
  {
    AppMethodBeat.i(65624);
    if ((this.mMediaPlay == null) || (!this._ringMode) || (this._streamType == 2) || (this._prevVolume == -1))
    {
      AppMethodBeat.o(65624);
      return;
    }
    try
    {
      a.dUd();
      a.iO("TRAE", "TraeMediaPlay volumeUndo _prevVolume:" + this._prevVolume);
      ((AudioManager)this._context.getSystemService("audio")).setStreamVolume(this._streamType, this._prevVolume, 0);
      AppMethodBeat.o(65624);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(65624);
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
    AppMethodBeat.i(65621);
    AudioDeviceInterface.LogTraceEntry(" cb:" + this.mCallback + " loopCount:" + this._loopCount + " _loop:" + this._loop);
    if (this._loop)
    {
      a.dUd();
      a.iQ("TRAE", "loop play,continue...");
      AppMethodBeat.o(65621);
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
      AppMethodBeat.o(65621);
      return;
      this.mMediaPlay.start();
      this._loopCount -= 1;
    }
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(65622);
    AudioDeviceInterface.LogTraceEntry(" cb:" + this.mCallback + " arg1:" + paramInt1 + " arg2:" + paramInt2);
    try
    {
      this.mMediaPlay.release();
      label52:
      this.mMediaPlay = null;
      if (this.mCallback != null) {
        this.mCallback.a();
      }
      AudioDeviceInterface.LogTraceExit();
      AppMethodBeat.o(65622);
      return false;
    }
    catch (Exception paramMediaPlayer)
    {
      break label52;
    }
  }
  
  /* Error */
  public boolean playRing(int paramInt1, int paramInt2, android.net.Uri paramUri, java.lang.String paramString, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, boolean paramBoolean3, int paramInt4)
  {
    // Byte code:
    //   0: ldc 219
    //   2: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 107	com/tencent/d/a/a/a:dUd	()Z
    //   8: pop
    //   9: new 111	java/lang/StringBuilder
    //   12: dup
    //   13: ldc 221
    //   15: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   18: iload_1
    //   19: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   22: ldc 223
    //   24: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: iload_2
    //   28: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   31: ldc 225
    //   33: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_3
    //   37: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   40: ldc 227
    //   42: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload 4
    //   47: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: ldc 229
    //   52: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: astore 12
    //   57: iload 5
    //   59: ifeq +148 -> 207
    //   62: ldc 231
    //   64: astore 11
    //   66: aload 12
    //   68: aload 11
    //   70: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: ldc 233
    //   75: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: iload 6
    //   80: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   83: ldc 235
    //   85: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: astore 12
    //   90: iload 7
    //   92: ifeq +122 -> 214
    //   95: ldc 231
    //   97: astore 11
    //   99: ldc 109
    //   101: aload 12
    //   103: aload 11
    //   105: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: ldc 237
    //   110: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: iload 8
    //   115: invokevirtual 166	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   118: ldc 239
    //   120: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: iload 9
    //   125: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   128: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokestatic 139	com/tencent/d/a/a/a:iO	(Ljava/lang/String;Ljava/lang/String;)V
    //   134: iload 5
    //   136: ifne +91 -> 227
    //   139: iload 6
    //   141: ifgt +86 -> 227
    //   144: invokestatic 107	com/tencent/d/a/a/a:dUd	()Z
    //   147: pop
    //   148: new 111	java/lang/StringBuilder
    //   151: dup
    //   152: ldc 241
    //   154: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   157: iload_1
    //   158: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   161: ldc 229
    //   163: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: astore 4
    //   168: iload 5
    //   170: ifeq +51 -> 221
    //   173: ldc 231
    //   175: astore_3
    //   176: ldc 109
    //   178: aload 4
    //   180: aload_3
    //   181: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: ldc 233
    //   186: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: iload 6
    //   191: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   194: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: invokestatic 139	com/tencent/d/a/a/a:iO	(Ljava/lang/String;Ljava/lang/String;)V
    //   200: ldc 219
    //   202: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   205: iconst_0
    //   206: ireturn
    //   207: ldc 243
    //   209: astore 11
    //   211: goto -145 -> 66
    //   214: ldc 243
    //   216: astore 11
    //   218: goto -119 -> 99
    //   221: ldc 243
    //   223: astore_3
    //   224: goto -48 -> 176
    //   227: aload_0
    //   228: getfield 44	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   231: ifnull +36 -> 267
    //   234: aload_0
    //   235: getfield 44	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   238: invokevirtual 183	android/media/MediaPlayer:isPlaying	()Z
    //   241: istore 10
    //   243: iload 10
    //   245: ifeq +10 -> 255
    //   248: ldc 219
    //   250: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   253: iconst_0
    //   254: ireturn
    //   255: aload_0
    //   256: getfield 44	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   259: invokevirtual 192	android/media/MediaPlayer:release	()V
    //   262: aload_0
    //   263: aconst_null
    //   264: putfield 44	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   267: aload_0
    //   268: getfield 58	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_watchTimer	Ljava/util/Timer;
    //   271: ifnull +20 -> 291
    //   274: aload_0
    //   275: getfield 58	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_watchTimer	Ljava/util/Timer;
    //   278: invokevirtual 248	java/util/Timer:cancel	()V
    //   281: aload_0
    //   282: aconst_null
    //   283: putfield 58	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_watchTimer	Ljava/util/Timer;
    //   286: aload_0
    //   287: aconst_null
    //   288: putfield 60	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_watchTimertask	Ljava/util/TimerTask;
    //   291: aload_0
    //   292: getfield 64	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_context	Landroid/content/Context;
    //   295: ldc 86
    //   297: invokevirtual 92	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   300: checkcast 94	android/media/AudioManager
    //   303: astore 11
    //   305: aload_0
    //   306: new 180	android/media/MediaPlayer
    //   309: dup
    //   310: invokespecial 249	android/media/MediaPlayer:<init>	()V
    //   313: putfield 44	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   316: aload_0
    //   317: getfield 44	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   320: ifnonnull +198 -> 518
    //   323: aload_0
    //   324: getfield 44	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   327: invokevirtual 192	android/media/MediaPlayer:release	()V
    //   330: aload_0
    //   331: aconst_null
    //   332: putfield 44	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   335: ldc 219
    //   337: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   340: iconst_0
    //   341: ireturn
    //   342: astore 11
    //   344: aload_0
    //   345: aconst_null
    //   346: putfield 44	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   349: goto -82 -> 267
    //   352: astore_3
    //   353: invokestatic 107	com/tencent/d/a/a/a:dUd	()Z
    //   356: pop
    //   357: ldc 109
    //   359: new 111	java/lang/StringBuilder
    //   362: dup
    //   363: ldc 251
    //   365: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   368: aload_3
    //   369: invokevirtual 254	java/lang/IllegalStateException:getLocalizedMessage	()Ljava/lang/String;
    //   372: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: ldc_w 256
    //   378: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: aload_3
    //   382: invokevirtual 259	java/lang/IllegalStateException:getMessage	()Ljava/lang/String;
    //   385: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: invokestatic 176	com/tencent/d/a/a/a:iQ	(Ljava/lang/String;Ljava/lang/String;)V
    //   394: aload_0
    //   395: getfield 44	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   398: invokevirtual 192	android/media/MediaPlayer:release	()V
    //   401: aload_0
    //   402: aconst_null
    //   403: putfield 44	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   406: ldc 219
    //   408: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   411: iconst_0
    //   412: ireturn
    //   413: astore_3
    //   414: aload_0
    //   415: aconst_null
    //   416: putfield 44	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   419: ldc 219
    //   421: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   424: aload_3
    //   425: athrow
    //   426: astore_3
    //   427: invokestatic 107	com/tencent/d/a/a/a:dUd	()Z
    //   430: pop
    //   431: ldc 109
    //   433: new 111	java/lang/StringBuilder
    //   436: dup
    //   437: ldc_w 261
    //   440: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   443: aload_3
    //   444: invokevirtual 262	java/io/IOException:getLocalizedMessage	()Ljava/lang/String;
    //   447: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: ldc_w 256
    //   453: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: aload_3
    //   457: invokevirtual 263	java/io/IOException:getMessage	()Ljava/lang/String;
    //   460: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   466: invokestatic 176	com/tencent/d/a/a/a:iQ	(Ljava/lang/String;Ljava/lang/String;)V
    //   469: goto -75 -> 394
    //   472: astore_3
    //   473: invokestatic 107	com/tencent/d/a/a/a:dUd	()Z
    //   476: pop
    //   477: ldc 109
    //   479: new 111	java/lang/StringBuilder
    //   482: dup
    //   483: ldc_w 265
    //   486: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   489: aload_3
    //   490: invokevirtual 266	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   493: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: ldc_w 256
    //   499: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: aload_3
    //   503: invokevirtual 267	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   506: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   512: invokestatic 176	com/tencent/d/a/a/a:iQ	(Ljava/lang/String;Ljava/lang/String;)V
    //   515: goto -121 -> 394
    //   518: aload_0
    //   519: getfield 44	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   522: aload_0
    //   523: invokevirtual 271	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   526: aload_0
    //   527: getfield 44	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   530: aload_0
    //   531: invokevirtual 275	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   534: iload_1
    //   535: tableswitch	default:+597 -> 1132, 0:+72->607, 1:+217->752, 2:+297->832
    //   561: nop
    //   562: dmul
    //   563: pop
    //   564: ldc 109
    //   566: ldc_w 277
    //   569: iload_1
    //   570: invokestatic 283	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   573: invokevirtual 287	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   576: invokestatic 139	com/tencent/d/a/a/a:iO	(Ljava/lang/String;Ljava/lang/String;)V
    //   579: aload_0
    //   580: getfield 44	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   583: invokevirtual 192	android/media/MediaPlayer:release	()V
    //   586: aload_0
    //   587: aconst_null
    //   588: putfield 44	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   591: aload_0
    //   592: getfield 44	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   595: astore_3
    //   596: aload_3
    //   597: ifnonnull +267 -> 864
    //   600: ldc 219
    //   602: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   605: iconst_0
    //   606: ireturn
    //   607: invokestatic 107	com/tencent/d/a/a/a:dUd	()Z
    //   610: pop
    //   611: ldc 109
    //   613: ldc_w 289
    //   616: iload_2
    //   617: invokestatic 283	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   620: invokevirtual 287	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   623: invokestatic 139	com/tencent/d/a/a/a:iO	(Ljava/lang/String;Ljava/lang/String;)V
    //   626: aload_0
    //   627: getfield 64	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_context	Landroid/content/Context;
    //   630: invokevirtual 293	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   633: iload_2
    //   634: invokevirtual 299	android/content/res/Resources:openRawResourceFd	(I)Landroid/content/res/AssetFileDescriptor;
    //   637: astore_3
    //   638: aload_3
    //   639: ifnonnull +41 -> 680
    //   642: invokestatic 107	com/tencent/d/a/a/a:dUd	()Z
    //   645: pop
    //   646: ldc 109
    //   648: ldc_w 301
    //   651: iload_2
    //   652: invokestatic 283	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   655: invokevirtual 287	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   658: invokestatic 139	com/tencent/d/a/a/a:iO	(Ljava/lang/String;Ljava/lang/String;)V
    //   661: aload_0
    //   662: getfield 44	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   665: invokevirtual 192	android/media/MediaPlayer:release	()V
    //   668: aload_0
    //   669: aconst_null
    //   670: putfield 44	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   673: ldc 219
    //   675: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   678: iconst_0
    //   679: ireturn
    //   680: aload_0
    //   681: getfield 44	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   684: aload_3
    //   685: invokevirtual 307	android/content/res/AssetFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   688: aload_3
    //   689: invokevirtual 311	android/content/res/AssetFileDescriptor:getStartOffset	()J
    //   692: aload_3
    //   693: invokevirtual 314	android/content/res/AssetFileDescriptor:getLength	()J
    //   696: invokevirtual 318	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   699: aload_3
    //   700: invokevirtual 321	android/content/res/AssetFileDescriptor:close	()V
    //   703: goto -112 -> 591
    //   706: astore_3
    //   707: invokestatic 107	com/tencent/d/a/a/a:dUd	()Z
    //   710: pop
    //   711: ldc 109
    //   713: new 111	java/lang/StringBuilder
    //   716: dup
    //   717: ldc_w 323
    //   720: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   723: aload_3
    //   724: invokevirtual 324	java/lang/IllegalArgumentException:getLocalizedMessage	()Ljava/lang/String;
    //   727: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   730: ldc_w 256
    //   733: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   736: aload_3
    //   737: invokevirtual 325	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   740: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   746: invokestatic 176	com/tencent/d/a/a/a:iQ	(Ljava/lang/String;Ljava/lang/String;)V
    //   749: goto -355 -> 394
    //   752: invokestatic 107	com/tencent/d/a/a/a:dUd	()Z
    //   755: pop
    //   756: ldc 109
    //   758: ldc_w 327
    //   761: aload_3
    //   762: invokestatic 330	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   765: invokevirtual 287	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   768: invokestatic 139	com/tencent/d/a/a/a:iO	(Ljava/lang/String;Ljava/lang/String;)V
    //   771: aload_0
    //   772: getfield 44	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   775: aload_0
    //   776: getfield 64	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_context	Landroid/content/Context;
    //   779: aload_3
    //   780: invokevirtual 333	android/media/MediaPlayer:setDataSource	(Landroid/content/Context;Landroid/net/Uri;)V
    //   783: goto -192 -> 591
    //   786: astore_3
    //   787: invokestatic 107	com/tencent/d/a/a/a:dUd	()Z
    //   790: pop
    //   791: ldc 109
    //   793: new 111	java/lang/StringBuilder
    //   796: dup
    //   797: ldc_w 335
    //   800: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   803: aload_3
    //   804: invokevirtual 336	java/lang/SecurityException:getLocalizedMessage	()Ljava/lang/String;
    //   807: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   810: ldc_w 256
    //   813: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   816: aload_3
    //   817: invokevirtual 337	java/lang/SecurityException:getMessage	()Ljava/lang/String;
    //   820: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   823: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   826: invokestatic 176	com/tencent/d/a/a/a:iQ	(Ljava/lang/String;Ljava/lang/String;)V
    //   829: goto -435 -> 394
    //   832: invokestatic 107	com/tencent/d/a/a/a:dUd	()Z
    //   835: pop
    //   836: ldc 109
    //   838: ldc_w 339
    //   841: aload 4
    //   843: invokestatic 330	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   846: invokevirtual 287	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   849: invokestatic 139	com/tencent/d/a/a/a:iO	(Ljava/lang/String;Ljava/lang/String;)V
    //   852: aload_0
    //   853: getfield 44	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   856: aload 4
    //   858: invokevirtual 341	android/media/MediaPlayer:setDataSource	(Ljava/lang/String;)V
    //   861: goto -270 -> 591
    //   864: aload_0
    //   865: iload 7
    //   867: putfield 56	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_ringMode	Z
    //   870: iconst_0
    //   871: istore_1
    //   872: aload_0
    //   873: getfield 56	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_ringMode	Z
    //   876: ifeq +209 -> 1085
    //   879: aload_0
    //   880: iconst_2
    //   881: putfield 46	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_streamType	I
    //   884: iconst_1
    //   885: istore_1
    //   886: aload_0
    //   887: iload 8
    //   889: putfield 48	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_hasCall	Z
    //   892: aload_0
    //   893: getfield 48	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_hasCall	Z
    //   896: ifeq +9 -> 905
    //   899: aload_0
    //   900: iload 9
    //   902: putfield 46	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_streamType	I
    //   905: aload_0
    //   906: getfield 44	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   909: aload_0
    //   910: getfield 46	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_streamType	I
    //   913: invokevirtual 344	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   916: aload_0
    //   917: getfield 44	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   920: invokevirtual 347	android/media/MediaPlayer:prepare	()V
    //   923: aload_0
    //   924: getfield 44	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   927: iload 5
    //   929: invokevirtual 351	android/media/MediaPlayer:setLooping	(Z)V
    //   932: aload_0
    //   933: getfield 44	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   936: invokevirtual 201	android/media/MediaPlayer:start	()V
    //   939: aload_0
    //   940: iload 5
    //   942: putfield 50	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_loop	Z
    //   945: aload_0
    //   946: getfield 50	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_loop	Z
    //   949: iconst_1
    //   950: if_icmpne +153 -> 1103
    //   953: aload_0
    //   954: iconst_1
    //   955: putfield 54	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_loopCount	I
    //   958: aload_0
    //   959: iconst_m1
    //   960: putfield 52	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_durationMS	I
    //   963: aload_0
    //   964: aload_0
    //   965: getfield 54	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_loopCount	I
    //   968: iconst_1
    //   969: isub
    //   970: putfield 54	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_loopCount	I
    //   973: aload_0
    //   974: getfield 48	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_hasCall	Z
    //   977: ifne +9 -> 986
    //   980: aload 11
    //   982: iload_1
    //   983: invokevirtual 354	android/media/AudioManager:setMode	(I)V
    //   986: aload_0
    //   987: getfield 52	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_durationMS	I
    //   990: ifle +46 -> 1036
    //   993: aload_0
    //   994: new 245	java/util/Timer
    //   997: dup
    //   998: invokespecial 355	java/util/Timer:<init>	()V
    //   1001: putfield 58	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_watchTimer	Ljava/util/Timer;
    //   1004: aload_0
    //   1005: new 357	com/tencent/rtmp/sharp/jni/TraeMediaPlayer$1
    //   1008: dup
    //   1009: aload_0
    //   1010: invokespecial 360	com/tencent/rtmp/sharp/jni/TraeMediaPlayer$1:<init>	(Lcom/tencent/rtmp/sharp/jni/TraeMediaPlayer;)V
    //   1013: putfield 60	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_watchTimertask	Ljava/util/TimerTask;
    //   1016: aload_0
    //   1017: getfield 58	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_watchTimer	Ljava/util/Timer;
    //   1020: aload_0
    //   1021: getfield 60	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_watchTimertask	Ljava/util/TimerTask;
    //   1024: aload_0
    //   1025: getfield 52	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_durationMS	I
    //   1028: sipush 1000
    //   1031: iadd
    //   1032: i2l
    //   1033: invokevirtual 364	java/util/Timer:schedule	(Ljava/util/TimerTask;J)V
    //   1036: invokestatic 107	com/tencent/d/a/a/a:dUd	()Z
    //   1039: pop
    //   1040: ldc 109
    //   1042: new 111	java/lang/StringBuilder
    //   1045: dup
    //   1046: ldc_w 366
    //   1049: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1052: aload_0
    //   1053: getfield 44	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   1056: invokevirtual 368	android/media/MediaPlayer:getDuration	()I
    //   1059: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1062: ldc 229
    //   1064: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1067: iload 5
    //   1069: invokevirtual 166	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1072: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1075: invokestatic 139	com/tencent/d/a/a/a:iO	(Ljava/lang/String;Ljava/lang/String;)V
    //   1078: ldc 219
    //   1080: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1083: iconst_1
    //   1084: ireturn
    //   1085: aload_0
    //   1086: iconst_0
    //   1087: putfield 46	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_streamType	I
    //   1090: getstatic 373	android/os/Build$VERSION:SDK_INT	I
    //   1093: bipush 11
    //   1095: if_icmplt -209 -> 886
    //   1098: iconst_3
    //   1099: istore_1
    //   1100: goto -214 -> 886
    //   1103: aload_0
    //   1104: iload 6
    //   1106: putfield 54	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_loopCount	I
    //   1109: aload_0
    //   1110: aload_0
    //   1111: getfield 54	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_loopCount	I
    //   1114: aload_0
    //   1115: getfield 44	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:mMediaPlay	Landroid/media/MediaPlayer;
    //   1118: invokevirtual 368	android/media/MediaPlayer:getDuration	()I
    //   1121: imul
    //   1122: putfield 52	com/tencent/rtmp/sharp/jni/TraeMediaPlayer:_durationMS	I
    //   1125: goto -162 -> 963
    //   1128: astore_3
    //   1129: goto -728 -> 401
    //   1132: goto -572 -> 560
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1135	0	this	TraeMediaPlayer
    //   0	1135	1	paramInt1	int
    //   0	1135	2	paramInt2	int
    //   0	1135	3	paramUri	android.net.Uri
    //   0	1135	4	paramString	java.lang.String
    //   0	1135	5	paramBoolean1	boolean
    //   0	1135	6	paramInt3	int
    //   0	1135	7	paramBoolean2	boolean
    //   0	1135	8	paramBoolean3	boolean
    //   0	1135	9	paramInt4	int
    //   241	3	10	bool	boolean
    //   64	240	11	localObject	Object
    //   342	639	11	localException	Exception
    //   55	47	12	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   255	262	342	java/lang/Exception
    //   227	243	352	java/lang/IllegalStateException
    //   262	267	352	java/lang/IllegalStateException
    //   267	291	352	java/lang/IllegalStateException
    //   291	335	352	java/lang/IllegalStateException
    //   344	349	352	java/lang/IllegalStateException
    //   414	426	352	java/lang/IllegalStateException
    //   518	534	352	java/lang/IllegalStateException
    //   560	591	352	java/lang/IllegalStateException
    //   591	596	352	java/lang/IllegalStateException
    //   607	638	352	java/lang/IllegalStateException
    //   642	673	352	java/lang/IllegalStateException
    //   680	703	352	java/lang/IllegalStateException
    //   752	783	352	java/lang/IllegalStateException
    //   832	861	352	java/lang/IllegalStateException
    //   864	870	352	java/lang/IllegalStateException
    //   872	884	352	java/lang/IllegalStateException
    //   886	905	352	java/lang/IllegalStateException
    //   905	963	352	java/lang/IllegalStateException
    //   963	986	352	java/lang/IllegalStateException
    //   986	1036	352	java/lang/IllegalStateException
    //   1036	1078	352	java/lang/IllegalStateException
    //   1085	1090	352	java/lang/IllegalStateException
    //   1090	1098	352	java/lang/IllegalStateException
    //   1103	1125	352	java/lang/IllegalStateException
    //   255	262	413	finally
    //   227	243	426	java/io/IOException
    //   262	267	426	java/io/IOException
    //   267	291	426	java/io/IOException
    //   291	335	426	java/io/IOException
    //   344	349	426	java/io/IOException
    //   414	426	426	java/io/IOException
    //   518	534	426	java/io/IOException
    //   560	591	426	java/io/IOException
    //   591	596	426	java/io/IOException
    //   607	638	426	java/io/IOException
    //   642	673	426	java/io/IOException
    //   680	703	426	java/io/IOException
    //   752	783	426	java/io/IOException
    //   832	861	426	java/io/IOException
    //   864	870	426	java/io/IOException
    //   872	884	426	java/io/IOException
    //   886	905	426	java/io/IOException
    //   905	963	426	java/io/IOException
    //   963	986	426	java/io/IOException
    //   986	1036	426	java/io/IOException
    //   1036	1078	426	java/io/IOException
    //   1085	1090	426	java/io/IOException
    //   1090	1098	426	java/io/IOException
    //   1103	1125	426	java/io/IOException
    //   227	243	472	java/lang/Exception
    //   262	267	472	java/lang/Exception
    //   267	291	472	java/lang/Exception
    //   291	335	472	java/lang/Exception
    //   344	349	472	java/lang/Exception
    //   353	394	472	java/lang/Exception
    //   414	426	472	java/lang/Exception
    //   427	469	472	java/lang/Exception
    //   518	534	472	java/lang/Exception
    //   560	591	472	java/lang/Exception
    //   591	596	472	java/lang/Exception
    //   607	638	472	java/lang/Exception
    //   642	673	472	java/lang/Exception
    //   680	703	472	java/lang/Exception
    //   707	749	472	java/lang/Exception
    //   752	783	472	java/lang/Exception
    //   787	829	472	java/lang/Exception
    //   832	861	472	java/lang/Exception
    //   864	870	472	java/lang/Exception
    //   872	884	472	java/lang/Exception
    //   886	905	472	java/lang/Exception
    //   905	963	472	java/lang/Exception
    //   963	986	472	java/lang/Exception
    //   986	1036	472	java/lang/Exception
    //   1036	1078	472	java/lang/Exception
    //   1085	1090	472	java/lang/Exception
    //   1090	1098	472	java/lang/Exception
    //   1103	1125	472	java/lang/Exception
    //   227	243	706	java/lang/IllegalArgumentException
    //   262	267	706	java/lang/IllegalArgumentException
    //   267	291	706	java/lang/IllegalArgumentException
    //   291	335	706	java/lang/IllegalArgumentException
    //   344	349	706	java/lang/IllegalArgumentException
    //   414	426	706	java/lang/IllegalArgumentException
    //   518	534	706	java/lang/IllegalArgumentException
    //   560	591	706	java/lang/IllegalArgumentException
    //   591	596	706	java/lang/IllegalArgumentException
    //   607	638	706	java/lang/IllegalArgumentException
    //   642	673	706	java/lang/IllegalArgumentException
    //   680	703	706	java/lang/IllegalArgumentException
    //   752	783	706	java/lang/IllegalArgumentException
    //   832	861	706	java/lang/IllegalArgumentException
    //   864	870	706	java/lang/IllegalArgumentException
    //   872	884	706	java/lang/IllegalArgumentException
    //   886	905	706	java/lang/IllegalArgumentException
    //   905	963	706	java/lang/IllegalArgumentException
    //   963	986	706	java/lang/IllegalArgumentException
    //   986	1036	706	java/lang/IllegalArgumentException
    //   1036	1078	706	java/lang/IllegalArgumentException
    //   1085	1090	706	java/lang/IllegalArgumentException
    //   1090	1098	706	java/lang/IllegalArgumentException
    //   1103	1125	706	java/lang/IllegalArgumentException
    //   227	243	786	java/lang/SecurityException
    //   262	267	786	java/lang/SecurityException
    //   267	291	786	java/lang/SecurityException
    //   291	335	786	java/lang/SecurityException
    //   344	349	786	java/lang/SecurityException
    //   414	426	786	java/lang/SecurityException
    //   518	534	786	java/lang/SecurityException
    //   560	591	786	java/lang/SecurityException
    //   591	596	786	java/lang/SecurityException
    //   607	638	786	java/lang/SecurityException
    //   642	673	786	java/lang/SecurityException
    //   680	703	786	java/lang/SecurityException
    //   752	783	786	java/lang/SecurityException
    //   832	861	786	java/lang/SecurityException
    //   864	870	786	java/lang/SecurityException
    //   872	884	786	java/lang/SecurityException
    //   886	905	786	java/lang/SecurityException
    //   905	963	786	java/lang/SecurityException
    //   963	986	786	java/lang/SecurityException
    //   986	1036	786	java/lang/SecurityException
    //   1036	1078	786	java/lang/SecurityException
    //   1085	1090	786	java/lang/SecurityException
    //   1090	1098	786	java/lang/SecurityException
    //   1103	1125	786	java/lang/SecurityException
    //   394	401	1128	java/lang/Exception
  }
  
  public void stopRing()
  {
    AppMethodBeat.i(65620);
    a.dUd();
    a.iQ("TRAE", "TraeMediaPlay stopRing ");
    if (this.mMediaPlay == null)
    {
      AppMethodBeat.o(65620);
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
      label87:
      break label87;
    }
    this.mMediaPlay = null;
    this._durationMS = -1;
    AppMethodBeat.o(65620);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeMediaPlayer
 * JD-Core Version:    0.7.0.1
 */