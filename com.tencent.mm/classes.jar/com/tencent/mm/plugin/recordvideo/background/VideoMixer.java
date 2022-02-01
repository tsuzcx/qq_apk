package com.tencent.mm.plugin.recordvideo.background;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.os.HandlerThread;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import d.g.a.a;
import d.g.a.m;
import d.g.a.r;
import d.g.b.k;
import d.y;
import java.io.IOException;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer;", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IVideoRemuxer;", "captureInfo", "Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;", "editorItems", "", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "drawingRect", "", "mixVideoPath", "", "mixThumbPath", "retryTime", "", "useSoftEncode", "", "enableHevc", "thumbShortSide", "blurBgPath", "(Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;Ljava/util/List;[FLjava/lang/String;Ljava/lang/String;IZZILjava/lang/String;)V", "ABAPrams", "Lcom/tencent/mm/plugin/sight/base/AdaptiveAdjustBitrate;", "getABAPrams", "()Lcom/tencent/mm/plugin/sight/base/AdaptiveAdjustBitrate;", "setABAPrams", "(Lcom/tencent/mm/plugin/sight/base/AdaptiveAdjustBitrate;)V", "SCENE_C2C", "SCENE_FINDER", "SCENE_SNS", "SCENE_STORY", "abaParams", "", "audioBitrate", "audioChannelCount", "audioSampleRate", "blendBitmapProvider", "Lkotlin/Function1;", "", "Landroid/graphics/Bitmap;", "getBlurBgPath", "()Ljava/lang/String;", "setBlurBgPath", "(Ljava/lang/String;)V", "blurBgProvider", "getCaptureInfo", "()Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;", "getDrawingRect", "()[F", "getEditorItems", "()Ljava/util/List;", "getEnableHevc", "()Z", "forceResolution", "framePassDuration", "frameRetriever", "Lcom/tencent/mm/plugin/recordvideo/background/StoryFrameRetriever;", "lastFrameInfo", "Lcom/tencent/mm/media/mix/FrameInfo;", "mixThread", "Landroid/os/HandlerThread;", "getMixThumbPath", "setMixThumbPath", "getMixVideoPath", "setMixVideoPath", "onFinish", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "mixVideo", "mixThumb", "ret", "errorCode", "", "getRetryTime", "()I", "setRetryTime", "(I)V", "getThumbShortSide", "setThumbShortSide", "getUseSoftEncode", "videoBitrate", "videoFrameRate", "videoHeight", "videoMaxQP", "videoMinQP", "videoRotate", "videoWidth", "blendBitmap", "graffiti", "thumb", "left", "", "top", "calcMixEmojiSize", "Landroid/graphics/Point;", "centerCrop", "canvas", "Landroid/graphics/Canvas;", "thumbnail", "size", "centerInside", "checkAudioCache", "callback", "Lkotlin/Function0;", "checkThumbSize", "bitmap", "shortSide", "createGraffitiThumb", "config", "Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig$EncodeConfig;", "createThumb", "getMixConfig", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer$MixConfig;", "mix", "readPictureDegree", "path", "videoParam", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "reMuxEndTimeMsPrams", "reMuxStartTimeMsPrams", "setForceResolution", "setMixConfig", "width", "height", "start", "onFinishCallback", "Companion", "MixConfig", "plugin-recordvideo_release"})
public final class VideoMixer
  implements com.tencent.mm.plugin.recordvideo.background.b.c
{
  public static final a veq;
  private int audioBitrate;
  private int audioSampleRate;
  private int glj;
  private int gnH;
  public final List<com.tencent.mm.media.editor.a.b> grO;
  public final d.g.a.b<Long, Bitmap> gsq;
  public final boolean gtM;
  private final boolean gtN;
  private int gtO;
  private int gtP;
  public int gta;
  public final d.g.a.b<Long, Bitmap> gto;
  private int[] qQH;
  private final int qpk;
  public String vdw;
  private r<? super String, ? super String, ? super Boolean, ? super Integer, y> veb;
  private long vec;
  private com.tencent.mm.media.g.c ved;
  public c vee;
  public AdaptiveAdjustBitrate vef;
  public boolean veg;
  private final int veh;
  private final int vei;
  private final int vej;
  private HandlerThread vek;
  public final com.tencent.mm.plugin.recordvideo.b.c vel;
  public final float[] vem;
  String ven;
  String veo;
  private int vep;
  private int videoBitrate;
  private int videoFrameRate;
  private int videoHeight;
  private int videoWidth;
  
  static
  {
    AppMethodBeat.i(75262);
    veq = new a((byte)0);
    AppMethodBeat.o(75262);
  }
  
  private VideoMixer(com.tencent.mm.plugin.recordvideo.b.c paramc, List<com.tencent.mm.media.editor.a.b> paramList, float[] paramArrayOfFloat, String paramString1, String paramString2, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(75260);
    this.vel = paramc;
    this.grO = paramList;
    this.vem = paramArrayOfFloat;
    this.ven = paramString1;
    this.veo = paramString2;
    this.glj = paramInt1;
    this.gtM = paramBoolean1;
    this.gtN = paramBoolean2;
    this.vep = paramInt2;
    this.vdw = paramString3;
    this.vec = -1L;
    this.qQH = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    this.veh = 1;
    this.vei = 2;
    this.vej = 3;
    this.qpk = 4;
    ad.i("MicroMsg.Media.VideoMixer", "create VideoMixer, videoPath:" + this.vel.vgn + ", outputFilePath:" + this.ven + ", isCaptureVideo:" + this.vel.gBl + ", retryTime:" + this.glj);
    com.tencent.mm.vfs.i.eK(this.vel.vgn);
    this.gsq = ((d.g.a.b)new b(this));
    this.gto = ((d.g.a.b)new c(this));
    AppMethodBeat.o(75260);
  }
  
  /* Error */
  public static int alG(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: ldc_w 362
    //   8: invokestatic 208	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_0
    //   12: ldc_w 363
    //   15: invokestatic 226	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   18: iconst_0
    //   19: istore_1
    //   20: aload_0
    //   21: invokestatic 367	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   24: astore_0
    //   25: aload_0
    //   26: ifnull +158 -> 184
    //   29: aload_0
    //   30: checkcast 369	java/io/Closeable
    //   33: astore 5
    //   35: new 371	android/support/d/a
    //   38: dup
    //   39: aload 5
    //   41: checkcast 373	java/io/InputStream
    //   44: invokespecial 376	android/support/d/a:<init>	(Ljava/io/InputStream;)V
    //   47: astore_0
    //   48: getstatic 382	d/y:JfV	Ld/y;
    //   51: astore 6
    //   53: aload 5
    //   55: aconst_null
    //   56: invokestatic 387	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   59: aload_0
    //   60: ifnull +16 -> 76
    //   63: aload_0
    //   64: ldc_w 389
    //   67: invokevirtual 392	android/support/d/a:l	(Ljava/lang/String;)I
    //   70: istore_2
    //   71: iload_2
    //   72: invokestatic 398	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   75: astore_3
    //   76: aload_3
    //   77: ifnonnull +43 -> 120
    //   80: aload_3
    //   81: ifnonnull +54 -> 135
    //   84: aload_3
    //   85: ifnonnull +65 -> 150
    //   88: ldc_w 362
    //   91: invokestatic 217	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: iload_1
    //   95: ireturn
    //   96: astore_3
    //   97: ldc_w 362
    //   100: invokestatic 217	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: aload_3
    //   104: athrow
    //   105: astore_0
    //   106: aload 5
    //   108: aload_3
    //   109: invokestatic 387	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   112: ldc_w 362
    //   115: invokestatic 217	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: aload_0
    //   119: athrow
    //   120: aload_3
    //   121: invokevirtual 401	java/lang/Integer:intValue	()I
    //   124: bipush 6
    //   126: if_icmpne -46 -> 80
    //   129: bipush 90
    //   131: istore_1
    //   132: goto -44 -> 88
    //   135: aload_3
    //   136: invokevirtual 401	java/lang/Integer:intValue	()I
    //   139: iconst_3
    //   140: if_icmpne -56 -> 84
    //   143: sipush 180
    //   146: istore_1
    //   147: goto -59 -> 88
    //   150: aload_3
    //   151: invokevirtual 401	java/lang/Integer:intValue	()I
    //   154: istore_2
    //   155: iload_2
    //   156: bipush 8
    //   158: if_icmpne +17 -> 175
    //   161: sipush 270
    //   164: istore_1
    //   165: goto -77 -> 88
    //   168: astore_0
    //   169: aload 4
    //   171: astore_3
    //   172: goto -66 -> 106
    //   175: iconst_0
    //   176: istore_1
    //   177: goto -12 -> 165
    //   180: astore_0
    //   181: goto -93 -> 88
    //   184: aconst_null
    //   185: astore_0
    //   186: goto -127 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	paramString	String
    //   19	158	1	i	int
    //   70	89	2	j	int
    //   4	81	3	localInteger	Integer
    //   96	55	3	localThrowable	Throwable
    //   171	1	3	localObject1	Object
    //   1	169	4	localObject2	Object
    //   33	74	5	localCloseable	java.io.Closeable
    //   51	1	6	localy	y
    // Exception table:
    //   from	to	target	type
    //   35	53	96	java/lang/Throwable
    //   97	105	105	finally
    //   35	53	168	finally
    //   20	25	180	java/io/IOException
    //   29	35	180	java/io/IOException
    //   53	59	180	java/io/IOException
    //   63	71	180	java/io/IOException
    //   106	120	180	java/io/IOException
    //   120	129	180	java/io/IOException
    //   135	143	180	java/io/IOException
    //   150	155	180	java/io/IOException
  }
  
  private final String dgV()
  {
    boolean bool = true;
    AppMethodBeat.i(75250);
    Bitmap localBitmap = d.aV(this.ven, 200000L);
    if (localBitmap != null)
    {
      try
      {
        ad.i("MicroMsg.Media.VideoMixer", "createThumb getParentAbsolutePath: " + com.tencent.mm.vfs.i.aMQ(this.veo) + "  thumb size:" + this.vep);
        com.tencent.mm.vfs.i.deleteDir(this.veo);
        i = this.vep;
        if ((i <= 0) || (Math.min(localBitmap.getWidth(), localBitmap.getHeight()) <= i)) {
          break label272;
        }
        if (localBitmap.getWidth() >= localBitmap.getHeight()) {
          break label246;
        }
        int k = (int)(localBitmap.getHeight() * i * 1.0F / localBitmap.getWidth());
        j = i;
        i = k;
        localObject1 = Bitmap.createScaledBitmap(localBitmap, j, i, true);
        k.g(localObject1, "Bitmap.createScaledBitma…idth, outputHeight, true)");
        label158:
        f.a((Bitmap)localObject1, 60, Bitmap.CompressFormat.JPEG, this.veo, true);
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          int i;
          int j;
          Object localObject1;
          label174:
          localObject2 = com.tencent.mm.plugin.recordvideo.d.e.vpB;
          com.tencent.mm.plugin.recordvideo.d.e.diE();
        }
      }
      localObject1 = new StringBuilder(" mixVideoPath : ").append(this.ven).append(" mixThumbPath:").append(this.veo).append("   thumb-bitmap is null:");
      if (localBitmap != null) {
        break label303;
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.Media.VideoMixer", bool);
      if (localBitmap != null) {
        break label309;
      }
      AppMethodBeat.o(75250);
      return null;
      label246:
      float f = localBitmap.getWidth() * i;
      j = localBitmap.getHeight();
      j = (int)(f * 1.0F / j);
      break;
      label272:
      localObject1 = localBitmap;
      break label158;
      localObject2 = com.tencent.mm.plugin.recordvideo.d.e.vpB;
      com.tencent.mm.plugin.recordvideo.d.e.diE();
      break label174;
      label303:
      bool = false;
    }
    label309:
    Object localObject2 = this.veo;
    AppMethodBeat.o(75250);
    return localObject2;
  }
  
  public static Point gI(int paramInt1, int paramInt2)
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
    this.gnH = paramInt6;
    this.videoFrameRate = paramInt7;
    this.gta = paramInt8;
    this.gtO = paramInt9;
    this.gtP = paramInt10;
    if (this.vef == null) {
      this.vef = new AdaptiveAdjustBitrate();
    }
    AdaptiveAdjustBitrate localAdaptiveAdjustBitrate = this.vef;
    if (localAdaptiveAdjustBitrate != null)
    {
      localAdaptiveAdjustBitrate.dqh();
      AppMethodBeat.o(75255);
      return;
    }
    AppMethodBeat.o(75255);
  }
  
  public final void a(VideoTransPara paramVideoTransPara, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(75253);
    k.h(paramVideoTransPara, "videoParam");
    if (this.vef == null) {
      this.vef = new AdaptiveAdjustBitrate();
    }
    ad.i("MicroMsg.Media.VideoMixer", "Scene: [%d], ABASwitch: [%d] abaIncreasesize:[%d]", new Object[] { Integer.valueOf(paramVideoTransPara.hcs), Integer.valueOf(paramVideoTransPara.hcj), Integer.valueOf(paramVideoTransPara.hcn) });
    AdaptiveAdjustBitrate localAdaptiveAdjustBitrate = this.vef;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.gni = this.videoHeight;
    }
    localAdaptiveAdjustBitrate = this.vef;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.gnh = this.videoWidth;
    }
    localAdaptiveAdjustBitrate = this.vef;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.wqW = this.videoBitrate;
    }
    localAdaptiveAdjustBitrate = this.vef;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.vgK = paramInt2;
    }
    localAdaptiveAdjustBitrate = this.vef;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.vgL = paramInt1;
    }
    localAdaptiveAdjustBitrate = this.vef;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.hcs = paramVideoTransPara.hcs;
    }
    localAdaptiveAdjustBitrate = this.vef;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.hcj = paramVideoTransPara.hcj;
    }
    localAdaptiveAdjustBitrate = this.vef;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.hck = paramVideoTransPara.hck;
    }
    localAdaptiveAdjustBitrate = this.vef;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.hcl = paramVideoTransPara.hcl;
    }
    localAdaptiveAdjustBitrate = this.vef;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.hcm = paramVideoTransPara.hcm;
    }
    localAdaptiveAdjustBitrate = this.vef;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.hcn = paramVideoTransPara.hcn;
    }
    localAdaptiveAdjustBitrate = this.vef;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.hco = paramVideoTransPara.hco;
    }
    localAdaptiveAdjustBitrate = this.vef;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.wqX = paramVideoTransPara.hcp;
    }
    localAdaptiveAdjustBitrate = this.vef;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.hcq = paramVideoTransPara.hcq;
    }
    localAdaptiveAdjustBitrate = this.vef;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.gnp = paramVideoTransPara.gnp;
    }
    localAdaptiveAdjustBitrate = this.vef;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.gnq = paramVideoTransPara.gnq;
    }
    localAdaptiveAdjustBitrate = this.vef;
    if (localAdaptiveAdjustBitrate != null)
    {
      localAdaptiveAdjustBitrate.hcr = paramVideoTransPara.hcr;
      AppMethodBeat.o(75253);
      return;
    }
    AppMethodBeat.o(75253);
  }
  
  public final void alH(String paramString)
  {
    AppMethodBeat.i(75259);
    k.h(paramString, "<set-?>");
    this.ven = paramString;
    AppMethodBeat.o(75259);
  }
  
  public final void b(final r<? super String, ? super String, ? super Boolean, ? super Integer, y> paramr)
  {
    AppMethodBeat.i(75249);
    ad.i("MicroMsg.Media.VideoMixer", "Start mixer " + bt.eGN());
    this.veb = ((r)new g(this, paramr));
    paramr = (a)new h(this);
    if (this.vel.vgt != null)
    {
      Object localObject = this.vel.vgt;
      if (localObject == null) {
        k.fvU();
      }
      if (!((AudioCacheInfo)localObject).aMb)
      {
        localObject = com.tencent.mm.plugin.recordvideo.model.audio.i.vjj;
        localObject = com.tencent.mm.plugin.recordvideo.model.audio.i.dhZ();
        AudioCacheInfo localAudioCacheInfo = this.vel.vgt;
        if (localAudioCacheInfo == null) {
          k.fvU();
        }
        ((com.tencent.mm.plugin.recordvideo.model.audio.i)localObject).a(localAudioCacheInfo, (m)new VideoMixer.d(paramr));
        AppMethodBeat.o(75249);
        return;
      }
    }
    paramr.invoke();
    AppMethodBeat.o(75249);
  }
  
  public final int dgW()
  {
    AppMethodBeat.i(75254);
    ad.i("MicroMsg.Media.VideoMixer", "ABA: Input encoding prams :Br: [%d]  height: [%d]  width: [%d] forceResolution:" + this.veg, new Object[] { Integer.valueOf(this.videoBitrate), Integer.valueOf(this.videoHeight), Integer.valueOf(this.videoWidth) });
    Object localObject1 = this.vef;
    Object localObject2;
    label108:
    Object localObject3;
    label129:
    int j;
    int k;
    int m;
    label319:
    int n;
    label355:
    float f1;
    label398:
    float f2;
    label438:
    label474:
    int i1;
    label510:
    int i2;
    label546:
    int i3;
    label582:
    int i4;
    label618:
    int i5;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).hcs);
      localObject2 = this.vef;
      if (localObject2 == null) {
        break label874;
      }
      localObject2 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject2).hcj);
      localObject3 = this.vef;
      if (localObject3 == null) {
        break label880;
      }
      localObject3 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject3).hck);
      ad.i("MicroMsg.Media.VideoMixer", "Scene: [%d], ABASwitch: [%d], QPSwitch: [%d]", new Object[] { localObject1, localObject2, localObject3 });
      localObject1 = this.vef;
      if ((localObject1 == null) || (((AdaptiveAdjustBitrate)localObject1).hcj != 1))
      {
        localObject1 = this.vef;
        if ((localObject1 == null) || (((AdaptiveAdjustBitrate)localObject1).hcj != 2)) {
          break label946;
        }
      }
      localObject1 = this.vef;
      if ((localObject1 == null) || (((AdaptiveAdjustBitrate)localObject1).hcs != this.vei))
      {
        localObject1 = this.vef;
        if ((localObject1 == null) || (((AdaptiveAdjustBitrate)localObject1).hcs != this.veh))
        {
          localObject1 = this.vef;
          if ((localObject1 == null) || (((AdaptiveAdjustBitrate)localObject1).hcs != this.qpk)) {
            break label946;
          }
        }
      }
      localObject2 = this.vel.vgn;
      i = this.videoHeight;
      j = this.videoWidth;
      k = this.videoFrameRate;
      m = this.videoBitrate;
      localObject1 = this.vef;
      if (localObject1 == null) {
        break label886;
      }
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).vgL);
      if (localObject1 == null) {
        k.fvU();
      }
      n = ((Integer)localObject1).intValue();
      localObject1 = this.vef;
      if (localObject1 == null) {
        break label892;
      }
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).vgK);
      if (localObject1 == null) {
        k.fvU();
      }
      f1 = (n - ((Integer)localObject1).intValue()) / 1000;
      localObject1 = this.vef;
      if (localObject1 == null) {
        break label898;
      }
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).vgK);
      if (localObject1 == null) {
        k.fvU();
      }
      f2 = ((Integer)localObject1).intValue() / 1000;
      localObject1 = this.vef;
      if (localObject1 == null) {
        break label904;
      }
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).hcs);
      if (localObject1 == null) {
        k.fvU();
      }
      n = ((Integer)localObject1).intValue();
      localObject1 = this.vef;
      if (localObject1 == null) {
        break label910;
      }
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).hcl);
      if (localObject1 == null) {
        k.fvU();
      }
      i1 = ((Integer)localObject1).intValue();
      localObject1 = this.vef;
      if (localObject1 == null) {
        break label916;
      }
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).hcm);
      if (localObject1 == null) {
        k.fvU();
      }
      i2 = ((Integer)localObject1).intValue();
      localObject1 = this.vef;
      if (localObject1 == null) {
        break label922;
      }
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).hcn);
      if (localObject1 == null) {
        k.fvU();
      }
      i3 = ((Integer)localObject1).intValue();
      localObject1 = this.vef;
      if (localObject1 == null) {
        break label928;
      }
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).hco);
      if (localObject1 == null) {
        k.fvU();
      }
      i4 = ((Integer)localObject1).intValue();
      localObject1 = this.vef;
      if (localObject1 == null) {
        break label934;
      }
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).wqX);
      if (localObject1 == null) {
        k.fvU();
      }
      i5 = ((Integer)localObject1).intValue();
      localObject1 = this.vef;
      if (localObject1 == null) {
        break label940;
      }
    }
    label898:
    label904:
    label910:
    label916:
    label922:
    label928:
    label934:
    label940:
    for (localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).hcq);; localObject1 = null)
    {
      if (localObject1 == null) {
        k.fvU();
      }
      localObject1 = AdaptiveAdjustBitrate.a((String)localObject2, i, j, k, m, f1, f2, n, i1, i2, i3, i4, i5, ((Integer)localObject1).intValue());
      k.g(localObject1, "AdaptiveAdjustBitrate.Ge…ABAPrams?.isEnable720p!!)");
      this.qQH = ((int[])localObject1);
      if ((this.qQH[3] > 0) || (this.qQH[4] > 0)) {
        this.videoBitrate = (this.qQH[0] * 1000);
      }
      if ((this.qQH[5] > 0) && (!this.veg))
      {
        this.videoWidth = this.qQH[1];
        this.videoHeight = this.qQH[2];
      }
      ad.i("MicroMsg.Media.VideoMixer", "ABA: Adaptive Bitrate Methods:videoBitrate [%d]  targetWidth [%d]  targetHeight [%d]", new Object[] { Integer.valueOf(this.videoBitrate), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight) });
      o.aCJ();
      com.tencent.mm.ao.e.p(this.qQH);
      if ((this.qQH[3] <= 0) && (this.qQH[4] <= 0) && (this.qQH[5] <= 0)) {
        break label997;
      }
      i = 1;
      AppMethodBeat.o(75254);
      return i;
      localObject1 = null;
      break;
      label874:
      localObject2 = null;
      break label108;
      label880:
      localObject3 = null;
      break label129;
      label886:
      localObject1 = null;
      break label319;
      label892:
      localObject1 = null;
      break label355;
      localObject1 = null;
      break label398;
      localObject1 = null;
      break label438;
      localObject1 = null;
      break label474;
      localObject1 = null;
      break label510;
      localObject1 = null;
      break label546;
      localObject1 = null;
      break label582;
      localObject1 = null;
      break label618;
    }
    label946:
    int i = this.videoBitrate;
    localObject1 = this.vef;
    if (localObject1 != null) {}
    for (localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).hcr);; localObject1 = null)
    {
      ad.i("MicroMsg.Media.VideoMixer", "ABA: No use ABA algorithm: final bitrate: [%d], takePhotosVideoBR: [%d]", new Object[] { Integer.valueOf(i), localObject1 });
      label997:
      i = 0;
      break;
    }
  }
  
  public final MixConfig dgX()
  {
    AppMethodBeat.i(75257);
    MixConfig localMixConfig = new MixConfig();
    localMixConfig.videoWidth = this.videoWidth;
    localMixConfig.videoHeight = this.videoHeight;
    localMixConfig.videoBitrate = this.videoBitrate;
    localMixConfig.audioBitrate = this.audioBitrate;
    localMixConfig.audioSampleRate = this.audioSampleRate;
    localMixConfig.gnH = this.gnH;
    localMixConfig.videoFrameRate = this.videoFrameRate;
    localMixConfig.gta = this.gta;
    AppMethodBeat.o(75257);
    return localMixConfig;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer$MixConfig;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "audioBitrate", "", "getAudioBitrate", "()I", "setAudioBitrate", "(I)V", "audioChannelCount", "getAudioChannelCount", "setAudioChannelCount", "audioSampleRate", "getAudioSampleRate", "setAudioSampleRate", "videoBitrate", "getVideoBitrate", "setVideoBitrate", "videoFrameRate", "getVideoFrameRate", "setVideoFrameRate", "videoHeight", "getVideoHeight", "setVideoHeight", "videoRotate", "getVideoRotate", "setVideoRotate", "videoWidth", "getVideoWidth", "setVideoWidth", "describeContents", "toString", "", "writeToParcel", "", "flags", "CREATOR", "plugin-recordvideo_release"})
  public static final class MixConfig
    implements Parcelable
  {
    public static final a CREATOR;
    public int audioBitrate;
    public int audioSampleRate;
    public int gnH;
    public int gta;
    public int videoBitrate;
    public int videoFrameRate;
    public int videoHeight;
    public int videoWidth;
    
    static
    {
      AppMethodBeat.i(75241);
      CREATOR = new a((byte)0);
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
      this.gnH = paramParcel.readInt();
      this.videoFrameRate = paramParcel.readInt();
      this.gta = paramParcel.readInt();
      AppMethodBeat.o(75240);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(75238);
      String str = "[MixConfig]videoWidth=" + this.videoWidth + ", videoHeight=" + this.videoHeight + ", videoBitrate=" + this.videoBitrate + ", audioBitrate=" + this.audioBitrate + ", audioSampleRate=" + this.audioSampleRate + ", audioChannelCount=" + this.gnH + ", videoFrameRate=" + this.videoFrameRate + ", videoRotate=" + this.gta;
      AppMethodBeat.o(75238);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(75239);
      k.h(paramParcel, "parcel");
      paramParcel.writeInt(this.videoWidth);
      paramParcel.writeInt(this.videoHeight);
      paramParcel.writeInt(this.videoBitrate);
      paramParcel.writeInt(this.audioBitrate);
      paramParcel.writeInt(this.audioSampleRate);
      paramParcel.writeInt(this.gnH);
      paramParcel.writeInt(this.videoFrameRate);
      paramParcel.writeInt(this.gta);
      AppMethodBeat.o(75239);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer$MixConfig$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer$MixConfig;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer$MixConfig;", "plugin-recordvideo_release"})
    public static final class a
      implements Parcelable.Creator<VideoMixer.MixConfig>
    {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/graphics/Bitmap;", "pts", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.b<Long, Bitmap>
  {
    b(VideoMixer paramVideoMixer)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/graphics/Bitmap;", "pts", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.b<Long, Bitmap>
  {
    c(VideoMixer paramVideoMixer)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.b<String, y>
  {
    e(VideoMixer paramVideoMixer, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.b<String, y>
  {
    f(VideoMixer paramVideoMixer)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "mixVideo", "", "mixThumb", "ret", "", "errorCode", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements r<String, String, Boolean, Integer, y>
  {
    g(VideoMixer paramVideoMixer, r paramr)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class h
    extends d.g.b.l
    implements a<y>
  {
    h(VideoMixer paramVideoMixer)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.VideoMixer
 * JD-Core Version:    0.7.0.1
 */