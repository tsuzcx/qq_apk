package com.tencent.mm.plugin.recordvideo.background;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.os.HandlerThread;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.e;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.a.a;
import d.g.a.m;
import d.g.a.r;
import d.g.b.k;
import d.y;
import java.io.IOException;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer;", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IVideoRemuxer;", "captureInfo", "Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;", "editorItems", "", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "drawingRect", "", "mixVideoPath", "", "mixThumbPath", "retryTime", "", "useSoftEncode", "", "enableHevc", "thumbShortSide", "blurBgPath", "(Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;Ljava/util/List;[FLjava/lang/String;Ljava/lang/String;IZZILjava/lang/String;)V", "ABAPrams", "Lcom/tencent/mm/plugin/sight/base/AdaptiveAdjustBitrate;", "getABAPrams", "()Lcom/tencent/mm/plugin/sight/base/AdaptiveAdjustBitrate;", "setABAPrams", "(Lcom/tencent/mm/plugin/sight/base/AdaptiveAdjustBitrate;)V", "SCENE_C2C", "SCENE_FINDER", "SCENE_SNS", "SCENE_STORY", "abaParams", "", "audioBitrate", "audioChannelCount", "audioSampleRate", "blendBitmapProvider", "Lkotlin/Function1;", "", "Landroid/graphics/Bitmap;", "getBlurBgPath", "()Ljava/lang/String;", "setBlurBgPath", "(Ljava/lang/String;)V", "blurBgProvider", "getCaptureInfo", "()Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;", "getDrawingRect", "()[F", "getEditorItems", "()Ljava/util/List;", "getEnableHevc", "()Z", "forceResolution", "framePassDuration", "frameRetriever", "Lcom/tencent/mm/plugin/recordvideo/background/StoryFrameRetriever;", "lastFrameInfo", "Lcom/tencent/mm/media/mix/FrameInfo;", "mixThread", "Landroid/os/HandlerThread;", "getMixThumbPath", "setMixThumbPath", "getMixVideoPath", "setMixVideoPath", "onFinish", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "mixVideo", "mixThumb", "ret", "errorCode", "", "getRetryTime", "()I", "setRetryTime", "(I)V", "getThumbShortSide", "setThumbShortSide", "getUseSoftEncode", "videoBitrate", "videoFrameRate", "videoHeight", "videoMaxQP", "videoMinQP", "videoRotate", "videoWidth", "blendBitmap", "graffiti", "thumb", "left", "", "top", "calcMixEmojiSize", "Landroid/graphics/Point;", "centerCrop", "canvas", "Landroid/graphics/Canvas;", "thumbnail", "size", "centerInside", "checkAudioCache", "callback", "Lkotlin/Function0;", "checkThumbSize", "bitmap", "shortSide", "createGraffitiThumb", "config", "Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig$EncodeConfig;", "createThumb", "getMixConfig", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer$MixConfig;", "mix", "readPictureDegree", "path", "videoParam", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "reMuxEndTimeMsPrams", "reMuxStartTimeMsPrams", "setForceResolution", "setMixConfig", "width", "height", "start", "onFinishCallback", "Companion", "MixConfig", "plugin-recordvideo_release"})
public final class VideoMixer
  implements com.tencent.mm.plugin.recordvideo.background.b.c
{
  public static final VideoMixer.a wnf;
  private int audioBitrate;
  private int audioSampleRate;
  private int gLW;
  private int gOt;
  public final d.g.a.b<Long, Bitmap> gSX;
  public final List<com.tencent.mm.media.editor.a.b> gSw;
  public int gTI;
  public final d.g.a.b<Long, Bitmap> gTW;
  public final boolean gUr;
  private final boolean gUs;
  private int gUt;
  private int gUu;
  private final int qYg;
  private int[] rMF;
  private int videoBitrate;
  private int videoFrameRate;
  private int videoHeight;
  private int videoWidth;
  private r<? super String, ? super String, ? super Boolean, ? super Integer, y> wmQ;
  private long wmR;
  private com.tencent.mm.media.g.c wmS;
  public d wmT;
  public AdaptiveAdjustBitrate wmU;
  public boolean wmV;
  private final int wmW;
  private final int wmX;
  private final int wmY;
  private HandlerThread wmZ;
  public String wmm;
  public final com.tencent.mm.plugin.recordvideo.b.c wna;
  public final float[] wnb;
  String wnc;
  String wnd;
  private int wne;
  
  static
  {
    AppMethodBeat.i(75262);
    wnf = new VideoMixer.a((byte)0);
    AppMethodBeat.o(75262);
  }
  
  private VideoMixer(com.tencent.mm.plugin.recordvideo.b.c paramc, List<com.tencent.mm.media.editor.a.b> paramList, float[] paramArrayOfFloat, String paramString1, String paramString2, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(75260);
    this.wna = paramc;
    this.gSw = paramList;
    this.wnb = paramArrayOfFloat;
    this.wnc = paramString1;
    this.wnd = paramString2;
    this.gLW = paramInt1;
    this.gUr = paramBoolean1;
    this.gUs = paramBoolean2;
    this.wne = paramInt2;
    this.wmm = paramString3;
    this.wmR = -1L;
    this.rMF = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    this.wmW = 1;
    this.wmX = 2;
    this.wmY = 3;
    this.qYg = 4;
    ac.i("MicroMsg.Media.VideoMixer", "create VideoMixer, videoPath:" + this.wna.woZ + ", outputFilePath:" + this.wnc + ", isCaptureVideo:" + this.wna.hbH + ", retryTime:" + this.gLW);
    com.tencent.mm.vfs.i.eA(this.wna.woZ);
    this.gSX = ((d.g.a.b)new b(this));
    this.gTW = ((d.g.a.b)new c(this));
    AppMethodBeat.o(75260);
  }
  
  /* Error */
  public static int aqF(String paramString)
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
    //   35: new 371	android/support/e/a
    //   38: dup
    //   39: aload 5
    //   41: checkcast 373	java/io/InputStream
    //   44: invokespecial 376	android/support/e/a:<init>	(Ljava/io/InputStream;)V
    //   47: astore_0
    //   48: getstatic 382	d/y:KTp	Ld/y;
    //   51: astore 6
    //   53: aload 5
    //   55: aconst_null
    //   56: invokestatic 387	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   59: aload_0
    //   60: ifnull +16 -> 76
    //   63: aload_0
    //   64: ldc_w 389
    //   67: invokevirtual 392	android/support/e/a:m	(Ljava/lang/String;)I
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
  
  private final String duD()
  {
    boolean bool = true;
    AppMethodBeat.i(75250);
    Bitmap localBitmap = com.tencent.mm.plugin.mmsight.d.aX(this.wnc, 200000L);
    if (localBitmap != null)
    {
      try
      {
        ac.i("MicroMsg.Media.VideoMixer", "createThumb getParentAbsolutePath: " + com.tencent.mm.vfs.i.aSs(this.wnd) + "  thumb size:" + this.wne);
        com.tencent.mm.vfs.i.deleteDir(this.wnd);
        i = this.wne;
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
        com.tencent.mm.sdk.platformtools.f.a((Bitmap)localObject1, 60, Bitmap.CompressFormat.JPEG, this.wnd, true);
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          int i;
          int j;
          Object localObject1;
          label174:
          localObject2 = com.tencent.mm.plugin.recordvideo.d.f.wys;
          com.tencent.mm.plugin.recordvideo.d.f.dwx();
        }
      }
      localObject1 = new StringBuilder(" mixVideoPath : ").append(this.wnc).append(" mixThumbPath:").append(this.wnd).append("   thumb-bitmap is null:");
      if (localBitmap != null) {
        break label303;
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.Media.VideoMixer", bool);
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
      localObject2 = com.tencent.mm.plugin.recordvideo.d.f.wys;
      com.tencent.mm.plugin.recordvideo.d.f.dwx();
      break label174;
      label303:
      bool = false;
    }
    label309:
    Object localObject2 = this.wnd;
    AppMethodBeat.o(75250);
    return localObject2;
  }
  
  public static Point gP(int paramInt1, int paramInt2)
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
    this.gOt = paramInt6;
    this.videoFrameRate = paramInt7;
    this.gTI = paramInt8;
    this.gUt = paramInt9;
    this.gUu = paramInt10;
    if (this.wmU == null) {
      this.wmU = new AdaptiveAdjustBitrate();
    }
    AdaptiveAdjustBitrate localAdaptiveAdjustBitrate = this.wmU;
    if (localAdaptiveAdjustBitrate != null)
    {
      localAdaptiveAdjustBitrate.dEr();
      AppMethodBeat.o(75255);
      return;
    }
    AppMethodBeat.o(75255);
  }
  
  public final void a(VideoTransPara paramVideoTransPara, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(75253);
    k.h(paramVideoTransPara, "videoParam");
    if (this.wmU == null) {
      this.wmU = new AdaptiveAdjustBitrate();
    }
    ac.i("MicroMsg.Media.VideoMixer", "Scene: [%d], ABASwitch: [%d] ceilingVideoBR:[%d]", new Object[] { Integer.valueOf(paramVideoTransPara.hCV), Integer.valueOf(paramVideoTransPara.hCL), Integer.valueOf(paramVideoTransPara.hCP) });
    AdaptiveAdjustBitrate localAdaptiveAdjustBitrate = this.wmU;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.gNV = this.videoHeight;
    }
    localAdaptiveAdjustBitrate = this.wmU;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.gNU = this.videoWidth;
    }
    localAdaptiveAdjustBitrate = this.wmU;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.xCn = this.videoBitrate;
    }
    localAdaptiveAdjustBitrate = this.wmU;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.wpw = paramInt2;
    }
    localAdaptiveAdjustBitrate = this.wmU;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.wpx = paramInt1;
    }
    localAdaptiveAdjustBitrate = this.wmU;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.hCV = paramVideoTransPara.hCV;
    }
    localAdaptiveAdjustBitrate = this.wmU;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.hCL = paramVideoTransPara.hCL;
    }
    localAdaptiveAdjustBitrate = this.wmU;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.hCM = paramVideoTransPara.hCM;
    }
    localAdaptiveAdjustBitrate = this.wmU;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.hCN = paramVideoTransPara.hCN;
    }
    localAdaptiveAdjustBitrate = this.wmU;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.hCO = paramVideoTransPara.hCO;
    }
    localAdaptiveAdjustBitrate = this.wmU;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.hCP = paramVideoTransPara.hCP;
    }
    localAdaptiveAdjustBitrate = this.wmU;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.hCQ = paramVideoTransPara.hCQ;
    }
    localAdaptiveAdjustBitrate = this.wmU;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.xCo = paramVideoTransPara.hCR;
    }
    localAdaptiveAdjustBitrate = this.wmU;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.hCT = paramVideoTransPara.hCT;
    }
    localAdaptiveAdjustBitrate = this.wmU;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.gOb = paramVideoTransPara.gOb;
    }
    localAdaptiveAdjustBitrate = this.wmU;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.gOc = paramVideoTransPara.gOc;
    }
    localAdaptiveAdjustBitrate = this.wmU;
    if (localAdaptiveAdjustBitrate != null)
    {
      localAdaptiveAdjustBitrate.hCU = paramVideoTransPara.hCU;
      AppMethodBeat.o(75253);
      return;
    }
    AppMethodBeat.o(75253);
  }
  
  public final void aqG(String paramString)
  {
    AppMethodBeat.i(75259);
    k.h(paramString, "<set-?>");
    this.wnc = paramString;
    AppMethodBeat.o(75259);
  }
  
  public final void c(final r<? super String, ? super String, ? super Boolean, ? super Integer, y> paramr)
  {
    AppMethodBeat.i(75249);
    ac.i("MicroMsg.Media.VideoMixer", "Start mixer " + bs.eWi());
    this.wmQ = ((r)new g(this, paramr));
    paramr = (a)new h(this);
    if (this.wna.wpf != null)
    {
      Object localObject = this.wna.wpf;
      if (localObject == null) {
        k.fOy();
      }
      if (!((AudioCacheInfo)localObject).aMR)
      {
        localObject = com.tencent.mm.plugin.recordvideo.model.audio.i.wrV;
        localObject = com.tencent.mm.plugin.recordvideo.model.audio.i.dvK();
        AudioCacheInfo localAudioCacheInfo = this.wna.wpf;
        if (localAudioCacheInfo == null) {
          k.fOy();
        }
        ((com.tencent.mm.plugin.recordvideo.model.audio.i)localObject).a(localAudioCacheInfo, (m)new VideoMixer.d(paramr));
        AppMethodBeat.o(75249);
        return;
      }
    }
    paramr.invoke();
    AppMethodBeat.o(75249);
  }
  
  public final int duE()
  {
    AppMethodBeat.i(75254);
    ac.i("MicroMsg.Media.VideoMixer", "ABA: Input encoding prams :Br: [%d]  height: [%d]  width: [%d] forceResolution:" + this.wmV, new Object[] { Integer.valueOf(this.videoBitrate), Integer.valueOf(this.videoHeight), Integer.valueOf(this.videoWidth) });
    Object localObject1 = this.wmU;
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
    label654:
    int i6;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).hCV);
      localObject2 = this.wmU;
      if (localObject2 == null) {
        break label912;
      }
      localObject2 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject2).hCL);
      localObject3 = this.wmU;
      if (localObject3 == null) {
        break label918;
      }
      localObject3 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject3).hCM);
      ac.i("MicroMsg.Media.VideoMixer", "Scene: [%d], ABASwitch: [%d], QPSwitch: [%d]", new Object[] { localObject1, localObject2, localObject3 });
      localObject1 = this.wmU;
      if ((localObject1 == null) || (((AdaptiveAdjustBitrate)localObject1).hCL != 1))
      {
        localObject1 = this.wmU;
        if ((localObject1 == null) || (((AdaptiveAdjustBitrate)localObject1).hCL != 2)) {
          break label990;
        }
      }
      localObject1 = this.wmU;
      if ((localObject1 == null) || (((AdaptiveAdjustBitrate)localObject1).hCV != this.wmX))
      {
        localObject1 = this.wmU;
        if ((localObject1 == null) || (((AdaptiveAdjustBitrate)localObject1).hCV != this.wmW))
        {
          localObject1 = this.wmU;
          if ((localObject1 == null) || (((AdaptiveAdjustBitrate)localObject1).hCV != this.qYg)) {
            break label990;
          }
        }
      }
      localObject2 = this.wna.woZ;
      i = this.videoHeight;
      j = this.videoWidth;
      k = this.videoFrameRate;
      m = this.videoBitrate;
      localObject1 = this.wmU;
      if (localObject1 == null) {
        break label924;
      }
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).wpx);
      if (localObject1 == null) {
        k.fOy();
      }
      n = ((Integer)localObject1).intValue();
      localObject1 = this.wmU;
      if (localObject1 == null) {
        break label930;
      }
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).wpw);
      if (localObject1 == null) {
        k.fOy();
      }
      f1 = (n - ((Integer)localObject1).intValue()) / 1000;
      localObject1 = this.wmU;
      if (localObject1 == null) {
        break label936;
      }
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).wpw);
      if (localObject1 == null) {
        k.fOy();
      }
      f2 = ((Integer)localObject1).intValue() / 1000;
      localObject1 = this.wmU;
      if (localObject1 == null) {
        break label942;
      }
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).hCV);
      if (localObject1 == null) {
        k.fOy();
      }
      n = ((Integer)localObject1).intValue();
      localObject1 = this.wmU;
      if (localObject1 == null) {
        break label948;
      }
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).hCN);
      if (localObject1 == null) {
        k.fOy();
      }
      i1 = ((Integer)localObject1).intValue();
      localObject1 = this.wmU;
      if (localObject1 == null) {
        break label954;
      }
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).hCO);
      if (localObject1 == null) {
        k.fOy();
      }
      i2 = ((Integer)localObject1).intValue();
      localObject1 = this.wmU;
      if (localObject1 == null) {
        break label960;
      }
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).hCP);
      if (localObject1 == null) {
        k.fOy();
      }
      i3 = ((Integer)localObject1).intValue();
      localObject1 = this.wmU;
      if (localObject1 == null) {
        break label966;
      }
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).hCQ);
      if (localObject1 == null) {
        k.fOy();
      }
      i4 = ((Integer)localObject1).intValue();
      localObject1 = this.wmU;
      if (localObject1 == null) {
        break label972;
      }
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).xCo);
      if (localObject1 == null) {
        k.fOy();
      }
      i5 = ((Integer)localObject1).intValue();
      localObject1 = this.wmU;
      if (localObject1 == null) {
        break label978;
      }
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).hCS);
      if (localObject1 == null) {
        k.fOy();
      }
      i6 = ((Integer)localObject1).intValue();
      localObject1 = this.wmU;
      if (localObject1 == null) {
        break label984;
      }
    }
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
    label984:
    for (localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).hCT);; localObject1 = null)
    {
      if (localObject1 == null) {
        k.fOy();
      }
      localObject1 = AdaptiveAdjustBitrate.a((String)localObject2, i, j, k, m, f1, f2, n, i1, i2, i3, i4, i5, i6, ((Integer)localObject1).intValue());
      k.g(localObject1, "AdaptiveAdjustBitrate.Ge…ABAPrams?.maxVideoSize!!)");
      this.rMF = ((int[])localObject1);
      if ((this.rMF[3] > 0) || (this.rMF[4] > 0)) {
        this.videoBitrate = (this.rMF[0] * 1000);
      }
      if ((this.rMF[5] > 0) && (!this.wmV))
      {
        this.videoWidth = this.rMF[1];
        this.videoHeight = this.rMF[2];
      }
      ac.i("MicroMsg.Media.VideoMixer", "ABA: Adaptive Bitrate Methods:videoBitrate [%d]  targetWidth [%d]  targetHeight [%d]", new Object[] { Integer.valueOf(this.videoBitrate), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight) });
      o.aJz();
      e.q(this.rMF);
      if ((this.rMF[3] <= 0) && (this.rMF[4] <= 0) && (this.rMF[5] <= 0)) {
        break label1041;
      }
      i = 1;
      AppMethodBeat.o(75254);
      return i;
      localObject1 = null;
      break;
      localObject2 = null;
      break label108;
      localObject3 = null;
      break label129;
      localObject1 = null;
      break label319;
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
      localObject1 = null;
      break label654;
    }
    label990:
    int i = this.videoBitrate;
    localObject1 = this.wmU;
    if (localObject1 != null) {}
    for (localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).hCU);; localObject1 = null)
    {
      ac.i("MicroMsg.Media.VideoMixer", "ABA: No use ABA algorithm: final bitrate: [%d], takePhotosVideoBR: [%d]", new Object[] { Integer.valueOf(i), localObject1 });
      label1041:
      i = 0;
      break;
    }
  }
  
  public final MixConfig duF()
  {
    AppMethodBeat.i(75257);
    MixConfig localMixConfig = new MixConfig();
    localMixConfig.videoWidth = this.videoWidth;
    localMixConfig.videoHeight = this.videoHeight;
    localMixConfig.videoBitrate = this.videoBitrate;
    localMixConfig.audioBitrate = this.audioBitrate;
    localMixConfig.audioSampleRate = this.audioSampleRate;
    localMixConfig.gOt = this.gOt;
    localMixConfig.videoFrameRate = this.videoFrameRate;
    localMixConfig.gTI = this.gTI;
    AppMethodBeat.o(75257);
    return localMixConfig;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer$MixConfig;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "audioBitrate", "", "getAudioBitrate", "()I", "setAudioBitrate", "(I)V", "audioChannelCount", "getAudioChannelCount", "setAudioChannelCount", "audioSampleRate", "getAudioSampleRate", "setAudioSampleRate", "videoBitrate", "getVideoBitrate", "setVideoBitrate", "videoFrameRate", "getVideoFrameRate", "setVideoFrameRate", "videoHeight", "getVideoHeight", "setVideoHeight", "videoRotate", "getVideoRotate", "setVideoRotate", "videoWidth", "getVideoWidth", "setVideoWidth", "describeContents", "toString", "", "writeToParcel", "", "flags", "CREATOR", "plugin-recordvideo_release"})
  public static final class MixConfig
    implements Parcelable
  {
    public static final a CREATOR;
    public int audioBitrate;
    public int audioSampleRate;
    public int gOt;
    public int gTI;
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
      this.gOt = paramParcel.readInt();
      this.videoFrameRate = paramParcel.readInt();
      this.gTI = paramParcel.readInt();
      AppMethodBeat.o(75240);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(75238);
      String str = "[MixConfig]videoWidth=" + this.videoWidth + ", videoHeight=" + this.videoHeight + ", videoBitrate=" + this.videoBitrate + ", audioBitrate=" + this.audioBitrate + ", audioSampleRate=" + this.audioSampleRate + ", audioChannelCount=" + this.gOt + ", videoFrameRate=" + this.videoFrameRate + ", videoRotate=" + this.gTI;
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
      paramParcel.writeInt(this.gOt);
      paramParcel.writeInt(this.videoFrameRate);
      paramParcel.writeInt(this.gTI);
      AppMethodBeat.o(75239);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer$MixConfig$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer$MixConfig;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer$MixConfig;", "plugin-recordvideo_release"})
    public static final class a
      implements Parcelable.Creator<VideoMixer.MixConfig>
    {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/graphics/Bitmap;", "pts", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.b<Long, Bitmap>
  {
    b(VideoMixer paramVideoMixer)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/graphics/Bitmap;", "pts", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.b<Long, Bitmap>
  {
    c(VideoMixer paramVideoMixer)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.b<String, y>
  {
    e(VideoMixer paramVideoMixer, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.b<String, y>
  {
    f(VideoMixer paramVideoMixer)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "mixVideo", "", "mixThumb", "ret", "", "errorCode", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements r<String, String, Boolean, Integer, y>
  {
    g(VideoMixer paramVideoMixer, r paramr)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.VideoMixer
 * JD-Core Version:    0.7.0.1
 */