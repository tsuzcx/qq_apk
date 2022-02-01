package com.tencent.mm.plugin.recordvideo.background;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.os.HandlerThread;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.e;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.recordvideo.d.f;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.i;
import com.tencent.mm.plugin.recordvideo.ui.editor.b.g;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import d.g.a.b;
import d.g.a.m;
import d.g.a.r;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.io.IOException;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer;", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IVideoRemuxer;", "videoMixData", "Lcom/tencent/mm/plugin/recordvideo/background/data/VideoMixData;", "(Lcom/tencent/mm/plugin/recordvideo/background/data/VideoMixData;)V", "ABAPrams", "Lcom/tencent/mm/plugin/sight/base/AdaptiveAdjustBitrate;", "getABAPrams", "()Lcom/tencent/mm/plugin/sight/base/AdaptiveAdjustBitrate;", "setABAPrams", "(Lcom/tencent/mm/plugin/sight/base/AdaptiveAdjustBitrate;)V", "SCENE_C2C", "", "SCENE_FINDER", "SCENE_SNS", "SCENE_STORY", "abaParams", "", "audioBitrate", "audioChannelCount", "audioSampleRate", "blendBitmapProvider", "Lkotlin/Function1;", "", "Landroid/graphics/Bitmap;", "blurBgProvider", "captureInfo", "Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;", "forceResolution", "", "framePassDuration", "frameRetriever", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/StoryFrameRetriever;", "lastFrameInfo", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameInfo;", "mixThread", "Landroid/os/HandlerThread;", "onFinish", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "mixVideo", "mixThumb", "ret", "errorCode", "", "videoBitrate", "videoFrameRate", "videoHeight", "videoMaxQP", "videoMinQP", "getVideoMixData", "()Lcom/tencent/mm/plugin/recordvideo/background/data/VideoMixData;", "videoRotate", "videoWidth", "blendBitmap", "graffiti", "thumb", "left", "", "top", "calcMixEmojiSize", "Landroid/graphics/Point;", "centerCrop", "canvas", "Landroid/graphics/Canvas;", "thumbnail", "size", "centerInside", "checkAudioCache", "callback", "Lkotlin/Function0;", "checkThumbSize", "bitmap", "shortSide", "createGraffitiThumb", "config", "Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig$EncodeConfig;", "createThumb", "getMixConfig", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer$MixConfig;", "mix", "readPictureDegree", "path", "videoParam", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "reMuxEndTimeMsPrams", "reMuxStartTimeMsPrams", "setForceResolution", "setMixConfig", "width", "height", "start", "onFinishCallback", "Companion", "MixConfig", "plugin-recordvideo_release"})
public final class VideoMixer
  implements com.tencent.mm.plugin.recordvideo.background.c.c
{
  public static final VideoMixer.a xKM;
  private int audioBitrate;
  private int audioChannelCount;
  private int audioSampleRate;
  public final b<Long, Bitmap> hnM;
  public final b<Long, Bitmap> hoL;
  public int hoy;
  private int hpi;
  private int hpj;
  private final int rRG;
  private int[] sTT;
  private int videoBitrate;
  private int videoFrameRate;
  private int videoHeight;
  private int videoWidth;
  private r<? super String, ? super String, ? super Boolean, ? super Integer, z> xKA;
  private long xKB;
  private com.tencent.mm.plugin.recordvideo.ui.editor.b.a xKC;
  public g xKD;
  private com.tencent.mm.plugin.recordvideo.b.c xKE;
  public AdaptiveAdjustBitrate xKF;
  public boolean xKG;
  private final int xKH;
  private final int xKI;
  private final int xKJ;
  private HandlerThread xKK;
  public final com.tencent.mm.plugin.recordvideo.background.a.a xKL;
  
  static
  {
    AppMethodBeat.i(75262);
    xKM = new VideoMixer.a((byte)0);
    AppMethodBeat.o(75262);
  }
  
  public VideoMixer(com.tencent.mm.plugin.recordvideo.background.a.a parama)
  {
    AppMethodBeat.i(206541);
    this.xKL = parama;
    this.xKB = -1L;
    this.xKE = this.xKL.xKE;
    parama = new int[34];
    int i = 0;
    while (i < 34)
    {
      parama[i] = 0;
      i += 1;
    }
    this.sTT = parama;
    this.xKH = 1;
    this.xKI = 2;
    this.xKJ = 3;
    this.rRG = 4;
    ae.i("MicroMsg.Media.VideoMixer", "create VideoMixer, " + this.xKL);
    this.hnM = ((b)new b(this));
    this.hoL = ((b)new c(this));
    AppMethodBeat.o(206541);
  }
  
  /* Error */
  public static int awU(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: ldc_w 273
    //   7: invokestatic 167	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: ldc_w 274
    //   14: invokestatic 185	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   17: aload_0
    //   18: invokestatic 280	com/tencent/mm/vfs/o:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   21: astore_0
    //   22: aload_0
    //   23: ifnull +161 -> 184
    //   26: aload_0
    //   27: checkcast 282	java/io/Closeable
    //   30: astore 4
    //   32: new 284	android/support/e/a
    //   35: dup
    //   36: aload 4
    //   38: checkcast 286	java/io/InputStream
    //   41: invokespecial 289	android/support/e/a:<init>	(Ljava/io/InputStream;)V
    //   44: astore_0
    //   45: getstatic 295	d/z:Nhr	Ld/z;
    //   48: astore 5
    //   50: aload 4
    //   52: aconst_null
    //   53: invokestatic 300	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   56: aload_0
    //   57: ifnull +16 -> 73
    //   60: aload_0
    //   61: ldc_w 302
    //   64: invokevirtual 305	android/support/e/a:l	(Ljava/lang/String;)I
    //   67: istore_1
    //   68: iload_1
    //   69: invokestatic 311	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   72: astore_2
    //   73: aload_2
    //   74: ifnonnull +45 -> 119
    //   77: aload_2
    //   78: ifnonnull +56 -> 134
    //   81: aload_2
    //   82: ifnonnull +67 -> 149
    //   85: iconst_0
    //   86: istore_1
    //   87: ldc_w 273
    //   90: invokestatic 176	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: iload_1
    //   94: ireturn
    //   95: astore_2
    //   96: ldc_w 273
    //   99: invokestatic 176	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: aload_2
    //   103: athrow
    //   104: astore_0
    //   105: aload 4
    //   107: aload_2
    //   108: invokestatic 300	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   111: ldc_w 273
    //   114: invokestatic 176	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: aload_0
    //   118: athrow
    //   119: aload_2
    //   120: invokevirtual 315	java/lang/Integer:intValue	()I
    //   123: bipush 6
    //   125: if_icmpne -48 -> 77
    //   128: bipush 90
    //   130: istore_1
    //   131: goto -44 -> 87
    //   134: aload_2
    //   135: invokevirtual 315	java/lang/Integer:intValue	()I
    //   138: iconst_3
    //   139: if_icmpne -58 -> 81
    //   142: sipush 180
    //   145: istore_1
    //   146: goto -59 -> 87
    //   149: aload_2
    //   150: invokevirtual 315	java/lang/Integer:intValue	()I
    //   153: istore_1
    //   154: iload_1
    //   155: bipush 8
    //   157: if_icmpne +10 -> 167
    //   160: sipush 270
    //   163: istore_1
    //   164: goto -77 -> 87
    //   167: iconst_0
    //   168: istore_1
    //   169: goto -82 -> 87
    //   172: astore_0
    //   173: aload_3
    //   174: astore_2
    //   175: goto -70 -> 105
    //   178: astore_0
    //   179: iconst_0
    //   180: istore_1
    //   181: goto -94 -> 87
    //   184: aconst_null
    //   185: astore_0
    //   186: goto -130 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	paramString	String
    //   67	114	1	i	int
    //   3	79	2	localInteger	Integer
    //   95	55	2	localThrowable	Throwable
    //   174	1	2	localObject1	Object
    //   1	173	3	localObject2	Object
    //   30	76	4	localCloseable	java.io.Closeable
    //   48	1	5	localz	z
    // Exception table:
    //   from	to	target	type
    //   32	50	95	java/lang/Throwable
    //   96	104	104	finally
    //   32	50	172	finally
    //   17	22	178	java/io/IOException
    //   26	32	178	java/io/IOException
    //   50	56	178	java/io/IOException
    //   60	68	178	java/io/IOException
    //   105	119	178	java/io/IOException
    //   119	128	178	java/io/IOException
    //   134	142	178	java/io/IOException
    //   149	154	178	java/io/IOException
  }
  
  private final String dIq()
  {
    boolean bool = true;
    AppMethodBeat.i(75250);
    Bitmap localBitmap = d.aZ(this.xKL.xKT, 200000L);
    if (localBitmap != null)
    {
      try
      {
        ae.i("MicroMsg.Media.VideoMixer", "createThumb getParentAbsolutePath: " + com.tencent.mm.vfs.o.aZU(this.xKL.xKU) + "  thumb size:" + this.xKL.xKV);
        com.tencent.mm.vfs.o.deleteDir(this.xKL.xKU);
        i = this.xKL.xKV;
        if ((i <= 0) || (Math.min(localBitmap.getWidth(), localBitmap.getHeight()) <= i)) {
          break label294;
        }
        if (localBitmap.getWidth() >= localBitmap.getHeight()) {
          break label268;
        }
        int k = (int)(localBitmap.getHeight() * i * 1.0F / localBitmap.getWidth());
        j = i;
        i = k;
        localObject1 = Bitmap.createScaledBitmap(localBitmap, j, i, true);
        p.g(localObject1, "Bitmap.createScaledBitma…idth, outputHeight, true)");
        label172:
        h.a((Bitmap)localObject1, 60, Bitmap.CompressFormat.JPEG, this.xKL.xKU, true);
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          int i;
          int j;
          Object localObject1;
          label191:
          localObject2 = f.xXh;
          f.dKi();
        }
      }
      localObject1 = new StringBuilder(" mixVideoPath : ").append(this.xKL.xKT).append(" mixThumbPath:").append(this.xKL.xKU).append("   thumb-bitmap is null:");
      if (localBitmap != null) {
        break label325;
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.Media.VideoMixer", bool);
      if (localBitmap != null) {
        break label331;
      }
      AppMethodBeat.o(75250);
      return null;
      label268:
      float f = localBitmap.getWidth() * i;
      j = localBitmap.getHeight();
      j = (int)(f * 1.0F / j);
      break;
      label294:
      localObject1 = localBitmap;
      break label172;
      localObject2 = f.xXh;
      f.dKi();
      break label191;
      label325:
      bool = false;
    }
    label331:
    Object localObject2 = this.xKL.xKU;
    AppMethodBeat.o(75250);
    return localObject2;
  }
  
  public static Point hi(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(75258);
    Point localPoint = new Point(paramInt1 * 1, paramInt2 * 1);
    AppMethodBeat.o(75258);
    return localPoint;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    AppMethodBeat.i(75255);
    this.videoWidth = paramInt1;
    this.videoHeight = paramInt2;
    this.videoBitrate = paramInt3;
    this.audioBitrate = paramInt4;
    this.audioSampleRate = paramInt5;
    this.audioChannelCount = paramInt6;
    this.videoFrameRate = paramInt7;
    this.hoy = paramInt8;
    this.hpi = paramInt9;
    this.hpj = paramInt10;
    if (this.xKF == null) {
      this.xKF = new AdaptiveAdjustBitrate();
    }
    AdaptiveAdjustBitrate localAdaptiveAdjustBitrate = this.xKF;
    if (localAdaptiveAdjustBitrate != null)
    {
      localAdaptiveAdjustBitrate.dTr();
      AppMethodBeat.o(75255);
      return;
    }
    AppMethodBeat.o(75255);
  }
  
  public final void a(VideoTransPara paramVideoTransPara, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(75253);
    p.h(paramVideoTransPara, "videoParam");
    if (this.xKF == null) {
      this.xKF = new AdaptiveAdjustBitrate();
    }
    ae.i("MicroMsg.Media.VideoMixer", "Scene: [%d], ABASwitch: [%d] ceilingVideoBR:[%d]", new Object[] { Integer.valueOf(paramVideoTransPara.hYs), Integer.valueOf(paramVideoTransPara.hYi), Integer.valueOf(paramVideoTransPara.hYm) });
    AdaptiveAdjustBitrate localAdaptiveAdjustBitrate = this.xKF;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.targetHeight = this.videoHeight;
    }
    localAdaptiveAdjustBitrate = this.xKF;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.targetWidth = this.videoWidth;
    }
    localAdaptiveAdjustBitrate = this.xKF;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.zhh = this.videoBitrate;
    }
    localAdaptiveAdjustBitrate = this.xKF;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.xNj = paramInt2;
    }
    localAdaptiveAdjustBitrate = this.xKF;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.xNk = paramInt1;
    }
    localAdaptiveAdjustBitrate = this.xKF;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.hYs = paramVideoTransPara.hYs;
    }
    localAdaptiveAdjustBitrate = this.xKF;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.hYi = paramVideoTransPara.hYi;
    }
    localAdaptiveAdjustBitrate = this.xKF;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.hYj = paramVideoTransPara.hYj;
    }
    localAdaptiveAdjustBitrate = this.xKF;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.hYk = paramVideoTransPara.hYk;
    }
    localAdaptiveAdjustBitrate = this.xKF;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.hYl = paramVideoTransPara.hYl;
    }
    localAdaptiveAdjustBitrate = this.xKF;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.hYm = paramVideoTransPara.hYm;
    }
    localAdaptiveAdjustBitrate = this.xKF;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.hYn = paramVideoTransPara.hYn;
    }
    localAdaptiveAdjustBitrate = this.xKF;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.zhi = paramVideoTransPara.hYo;
    }
    localAdaptiveAdjustBitrate = this.xKF;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.hYq = paramVideoTransPara.hYq;
    }
    localAdaptiveAdjustBitrate = this.xKF;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.hkJ = paramVideoTransPara.hkJ;
    }
    localAdaptiveAdjustBitrate = this.xKF;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.hkK = paramVideoTransPara.hkK;
    }
    localAdaptiveAdjustBitrate = this.xKF;
    if (localAdaptiveAdjustBitrate != null)
    {
      localAdaptiveAdjustBitrate.hYr = paramVideoTransPara.hYr;
      AppMethodBeat.o(75253);
      return;
    }
    AppMethodBeat.o(75253);
  }
  
  public final void c(final r<? super String, ? super String, ? super Boolean, ? super Integer, z> paramr)
  {
    AppMethodBeat.i(75249);
    ae.i("MicroMsg.Media.VideoMixer", "Start mixer " + bu.fpN());
    this.xKA = ((r)new g(this, paramr));
    paramr = (d.g.a.a)new h(this);
    if (this.xKL.xKE.xMS != null)
    {
      Object localObject = this.xKL.xKE.xMS;
      if (localObject == null) {
        p.gkB();
      }
      if (!((AudioCacheInfo)localObject).aXj)
      {
        localObject = i.xPI;
        localObject = i.dJz();
        AudioCacheInfo localAudioCacheInfo = this.xKL.xKE.xMS;
        if (localAudioCacheInfo == null) {
          p.gkB();
        }
        ((i)localObject).a(localAudioCacheInfo, (m)new VideoMixer.d(paramr));
        AppMethodBeat.o(75249);
        return;
      }
    }
    paramr.invoke();
    AppMethodBeat.o(75249);
  }
  
  public final int dIr()
  {
    AppMethodBeat.i(75254);
    ae.i("MicroMsg.Media.VideoMixer", "ABA: Input encoding prams :Br: [%d]  height: [%d]  width: [%d] forceResolution:" + this.xKG, new Object[] { Integer.valueOf(this.videoBitrate), Integer.valueOf(this.videoHeight), Integer.valueOf(this.videoWidth) });
    Object localObject1 = this.xKF;
    Object localObject2;
    label107:
    Object localObject3;
    label128:
    int j;
    int k;
    int m;
    label317:
    int n;
    label353:
    float f1;
    label396:
    float f2;
    label436:
    label472:
    int i1;
    label508:
    int i2;
    label544:
    int i3;
    label580:
    int i4;
    label616:
    int i5;
    label652:
    int i6;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).hYs);
      localObject2 = this.xKF;
      if (localObject2 == null) {
        break label906;
      }
      localObject2 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject2).hYi);
      localObject3 = this.xKF;
      if (localObject3 == null) {
        break label912;
      }
      localObject3 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject3).hYj);
      ae.i("MicroMsg.Media.VideoMixer", "Scene: [%d], ABASwitch: [%d], QPSwitch: [%d]", new Object[] { localObject1, localObject2, localObject3 });
      localObject1 = this.xKF;
      if ((localObject1 == null) || (((AdaptiveAdjustBitrate)localObject1).hYi != 1))
      {
        localObject1 = this.xKF;
        if ((localObject1 == null) || (((AdaptiveAdjustBitrate)localObject1).hYi != 2)) {
          break label984;
        }
      }
      localObject1 = this.xKF;
      if ((localObject1 == null) || (((AdaptiveAdjustBitrate)localObject1).hYs != this.xKI))
      {
        localObject1 = this.xKF;
        if ((localObject1 == null) || (((AdaptiveAdjustBitrate)localObject1).hYs != this.xKH))
        {
          localObject1 = this.xKF;
          if ((localObject1 == null) || (((AdaptiveAdjustBitrate)localObject1).hYs != this.rRG)) {
            break label984;
          }
        }
      }
      localObject2 = this.xKE.xMM;
      i = this.videoHeight;
      j = this.videoWidth;
      k = this.videoFrameRate;
      m = this.videoBitrate;
      localObject1 = this.xKF;
      if (localObject1 == null) {
        break label918;
      }
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).xNk);
      if (localObject1 == null) {
        p.gkB();
      }
      n = ((Integer)localObject1).intValue();
      localObject1 = this.xKF;
      if (localObject1 == null) {
        break label924;
      }
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).xNj);
      if (localObject1 == null) {
        p.gkB();
      }
      f1 = (n - ((Integer)localObject1).intValue()) / 1000;
      localObject1 = this.xKF;
      if (localObject1 == null) {
        break label930;
      }
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).xNj);
      if (localObject1 == null) {
        p.gkB();
      }
      f2 = ((Integer)localObject1).intValue() / 1000;
      localObject1 = this.xKF;
      if (localObject1 == null) {
        break label936;
      }
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).hYs);
      if (localObject1 == null) {
        p.gkB();
      }
      n = ((Integer)localObject1).intValue();
      localObject1 = this.xKF;
      if (localObject1 == null) {
        break label942;
      }
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).hYk);
      if (localObject1 == null) {
        p.gkB();
      }
      i1 = ((Integer)localObject1).intValue();
      localObject1 = this.xKF;
      if (localObject1 == null) {
        break label948;
      }
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).hYl);
      if (localObject1 == null) {
        p.gkB();
      }
      i2 = ((Integer)localObject1).intValue();
      localObject1 = this.xKF;
      if (localObject1 == null) {
        break label954;
      }
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).hYm);
      if (localObject1 == null) {
        p.gkB();
      }
      i3 = ((Integer)localObject1).intValue();
      localObject1 = this.xKF;
      if (localObject1 == null) {
        break label960;
      }
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).hYn);
      if (localObject1 == null) {
        p.gkB();
      }
      i4 = ((Integer)localObject1).intValue();
      localObject1 = this.xKF;
      if (localObject1 == null) {
        break label966;
      }
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).zhi);
      if (localObject1 == null) {
        p.gkB();
      }
      i5 = ((Integer)localObject1).intValue();
      localObject1 = this.xKF;
      if (localObject1 == null) {
        break label972;
      }
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).hYp);
      if (localObject1 == null) {
        p.gkB();
      }
      i6 = ((Integer)localObject1).intValue();
      localObject1 = this.xKF;
      if (localObject1 == null) {
        break label978;
      }
    }
    label906:
    label912:
    label918:
    label924:
    label930:
    label936:
    label942:
    label948:
    label954:
    label960:
    label966:
    label972:
    label978:
    for (localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).hYq);; localObject1 = null)
    {
      if (localObject1 == null) {
        p.gkB();
      }
      localObject1 = AdaptiveAdjustBitrate.a((String)localObject2, i, j, k, m, f1, f2, n, i1, i2, i3, i4, i5, i6, ((Integer)localObject1).intValue(), false);
      p.g(localObject1, "AdaptiveAdjustBitrate.Ge…s?.maxVideoSize!!, false)");
      this.sTT = ((int[])localObject1);
      if (this.sTT != null) {
        this.videoBitrate = (this.sTT[0] * 1000);
      }
      if ((this.sTT != null) && (this.sTT[5] > 0) && (!this.xKG))
      {
        this.videoWidth = this.sTT[1];
        this.videoHeight = this.sTT[2];
      }
      ae.i("MicroMsg.Media.VideoMixer", "ABA: Adaptive Bitrate Methods:videoBitrate [%d]  targetWidth [%d]  targetHeight [%d]", new Object[] { Integer.valueOf(this.videoBitrate), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight) });
      com.tencent.mm.modelvideo.o.aNi();
      e.q(this.sTT);
      if ((this.sTT[3] <= 0) && (this.sTT[4] <= 0) && (this.sTT[5] <= 0)) {
        break label1034;
      }
      i = 1;
      AppMethodBeat.o(75254);
      return i;
      localObject1 = null;
      break;
      localObject2 = null;
      break label107;
      localObject3 = null;
      break label128;
      localObject1 = null;
      break label317;
      localObject1 = null;
      break label353;
      localObject1 = null;
      break label396;
      localObject1 = null;
      break label436;
      localObject1 = null;
      break label472;
      localObject1 = null;
      break label508;
      localObject1 = null;
      break label544;
      localObject1 = null;
      break label580;
      localObject1 = null;
      break label616;
      localObject1 = null;
      break label652;
    }
    label984:
    int i = this.videoBitrate;
    localObject1 = this.xKF;
    if (localObject1 != null) {}
    for (localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).hYr);; localObject1 = null)
    {
      ae.i("MicroMsg.Media.VideoMixer", "ABA: No use ABA algorithm: final bitrate: [%d], takePhotosVideoBR: [%d]", new Object[] { Integer.valueOf(i), localObject1 });
      label1034:
      i = 0;
      break;
    }
  }
  
  public final MixConfig dIs()
  {
    AppMethodBeat.i(75257);
    MixConfig localMixConfig = new MixConfig();
    localMixConfig.videoWidth = this.videoWidth;
    localMixConfig.videoHeight = this.videoHeight;
    localMixConfig.videoBitrate = this.videoBitrate;
    localMixConfig.audioBitrate = this.audioBitrate;
    localMixConfig.audioSampleRate = this.audioSampleRate;
    localMixConfig.audioChannelCount = this.audioChannelCount;
    localMixConfig.videoFrameRate = this.videoFrameRate;
    localMixConfig.hoy = this.hoy;
    AppMethodBeat.o(75257);
    return localMixConfig;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer$MixConfig;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "audioBitrate", "", "getAudioBitrate", "()I", "setAudioBitrate", "(I)V", "audioChannelCount", "getAudioChannelCount", "setAudioChannelCount", "audioSampleRate", "getAudioSampleRate", "setAudioSampleRate", "videoBitrate", "getVideoBitrate", "setVideoBitrate", "videoFrameRate", "getVideoFrameRate", "setVideoFrameRate", "videoHeight", "getVideoHeight", "setVideoHeight", "videoRotate", "getVideoRotate", "setVideoRotate", "videoWidth", "getVideoWidth", "setVideoWidth", "describeContents", "toString", "", "writeToParcel", "", "flags", "CREATOR", "plugin-recordvideo_release"})
  public static final class MixConfig
    implements Parcelable
  {
    public static final VideoMixer.MixConfig.a CREATOR;
    public int audioBitrate;
    public int audioChannelCount;
    public int audioSampleRate;
    public int hoy;
    public int videoBitrate;
    public int videoFrameRate;
    public int videoHeight;
    public int videoWidth;
    
    static
    {
      AppMethodBeat.i(75241);
      CREATOR = new VideoMixer.MixConfig.a((byte)0);
      AppMethodBeat.o(75241);
    }
    
    public MixConfig() {}
    
    public MixConfig(Parcel paramParcel)
    {
      this();
      AppMethodBeat.i(75240);
      this.videoWidth = paramParcel.readInt();
      this.videoHeight = paramParcel.readInt();
      this.videoBitrate = paramParcel.readInt();
      this.audioBitrate = paramParcel.readInt();
      this.audioSampleRate = paramParcel.readInt();
      this.audioChannelCount = paramParcel.readInt();
      this.videoFrameRate = paramParcel.readInt();
      this.hoy = paramParcel.readInt();
      AppMethodBeat.o(75240);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(75238);
      String str = "[MixConfig]videoWidth=" + this.videoWidth + ", videoHeight=" + this.videoHeight + ", videoBitrate=" + this.videoBitrate + ", audioBitrate=" + this.audioBitrate + ", audioSampleRate=" + this.audioSampleRate + ", audioChannelCount=" + this.audioChannelCount + ", videoFrameRate=" + this.videoFrameRate + ", videoRotate=" + this.hoy;
      AppMethodBeat.o(75238);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(75239);
      p.h(paramParcel, "parcel");
      paramParcel.writeInt(this.videoWidth);
      paramParcel.writeInt(this.videoHeight);
      paramParcel.writeInt(this.videoBitrate);
      paramParcel.writeInt(this.audioBitrate);
      paramParcel.writeInt(this.audioSampleRate);
      paramParcel.writeInt(this.audioChannelCount);
      paramParcel.writeInt(this.videoFrameRate);
      paramParcel.writeInt(this.hoy);
      AppMethodBeat.o(75239);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/graphics/Bitmap;", "pts", "", "invoke"})
  static final class b
    extends q
    implements b<Long, Bitmap>
  {
    b(VideoMixer paramVideoMixer)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/graphics/Bitmap;", "pts", "", "invoke"})
  static final class c
    extends q
    implements b<Long, Bitmap>
  {
    c(VideoMixer paramVideoMixer)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "invoke"})
  static final class e
    extends q
    implements b<String, z>
  {
    e(VideoMixer paramVideoMixer, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "invoke"})
  static final class f
    extends q
    implements b<String, z>
  {
    f(VideoMixer paramVideoMixer)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "mixVideo", "", "mixThumb", "ret", "", "errorCode", "", "invoke"})
  static final class g
    extends q
    implements r<String, String, Boolean, Integer, z>
  {
    g(VideoMixer paramVideoMixer, r paramr)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements d.g.a.a<z>
  {
    h(VideoMixer paramVideoMixer)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.VideoMixer
 * JD-Core Version:    0.7.0.1
 */