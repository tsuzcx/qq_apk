package com.tencent.mm.plugin.recordvideo.background;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.os.HandlerThread;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aq.e;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.recordvideo.d.f;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.k;
import com.tencent.mm.plugin.recordvideo.ui.editor.b.g;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer;", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IVideoRemuxer;", "videoMixData", "Lcom/tencent/mm/plugin/recordvideo/background/data/VideoMixData;", "(Lcom/tencent/mm/plugin/recordvideo/background/data/VideoMixData;)V", "ABAPrams", "Lcom/tencent/mm/plugin/sight/base/AdaptiveAdjustBitrate;", "getABAPrams", "()Lcom/tencent/mm/plugin/sight/base/AdaptiveAdjustBitrate;", "setABAPrams", "(Lcom/tencent/mm/plugin/sight/base/AdaptiveAdjustBitrate;)V", "SCENE_C2C", "", "SCENE_FINDER", "SCENE_SNS", "SCENE_STORY", "abaFlag", "abaParams", "", "audioBitrate", "audioChannelCount", "audioSampleRate", "blendBitmapProvider", "Lkotlin/Function1;", "", "Landroid/graphics/Bitmap;", "blurBgProvider", "captureInfo", "Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;", "forceResolution", "", "framePassDuration", "frameRetriever", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/StoryFrameRetriever;", "lastFrameInfo", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameInfo;", "mixThread", "Landroid/os/HandlerThread;", "onFinish", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "mixVideo", "mixThumb", "ret", "errorCode", "", "videoBitrate", "videoFrameRate", "videoHeight", "videoMaxQP", "videoMinQP", "getVideoMixData", "()Lcom/tencent/mm/plugin/recordvideo/background/data/VideoMixData;", "videoRotate", "videoWidth", "blendBitmap", "graffiti", "thumb", "left", "", "top", "calcMixEmojiSize", "Landroid/graphics/Point;", "centerCrop", "canvas", "Landroid/graphics/Canvas;", "thumbnail", "size", "centerInside", "checkAudioCache", "callback", "Lkotlin/Function0;", "checkThumbSize", "bitmap", "shortSide", "createGraffitiThumb", "config", "Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig$EncodeConfig;", "createThumb", "getAbaFlag", "getMixConfig", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer$MixConfig;", "mix", "readPictureDegree", "path", "videoParam", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "reMuxEndTimeMsPrams", "reMuxStartTimeMsPrams", "setForceResolution", "setMixConfig", "width", "height", "start", "onFinishCallback", "Companion", "MixConfig", "plugin-recordvideo_release"})
public final class VideoMixer
  implements com.tencent.mm.plugin.recordvideo.background.c.c
{
  public static final a HHb;
  private int[] Azu;
  private r<? super String, ? super String, ? super Boolean, ? super Integer, x> HGO;
  private long HGP;
  private com.tencent.mm.plugin.recordvideo.ui.editor.b.a HGQ;
  public g HGR;
  private com.tencent.mm.plugin.recordvideo.b.c HGS;
  public AdaptiveAdjustBitrate HGT;
  public int HGU;
  public boolean HGV;
  private final int HGW;
  private final int HGX;
  private final int HGY;
  private HandlerThread HGZ;
  public final com.tencent.mm.plugin.recordvideo.background.a.a HHa;
  private int audioBitrate;
  private int audioChannelCount;
  private int audioSampleRate;
  public final b<Long, Bitmap> kVT;
  public int kWG;
  public final b<Long, Bitmap> kWT;
  private int kXq;
  private int kXr;
  private int videoBitrate;
  private int videoFrameRate;
  private int videoHeight;
  private int videoWidth;
  private final int xde;
  
  static
  {
    AppMethodBeat.i(75262);
    HHb = new a((byte)0);
    AppMethodBeat.o(75262);
  }
  
  public VideoMixer(com.tencent.mm.plugin.recordvideo.background.a.a parama)
  {
    AppMethodBeat.i(223530);
    this.HHa = parama;
    this.HGP = -1L;
    this.HGS = this.HHa.HGS;
    parama = new int[34];
    int i = 0;
    while (i < 34)
    {
      parama[i] = 0;
      i += 1;
    }
    this.Azu = parama;
    this.HGW = 1;
    this.HGX = 2;
    this.HGY = 3;
    this.xde = 4;
    Log.i("MicroMsg.Media.VideoMixer", "create VideoMixer, " + this.HHa);
    this.kVT = ((b)new b(this));
    this.kWT = ((b)new c(this));
    AppMethodBeat.o(223530);
  }
  
  /* Error */
  public static int aVO(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: ldc_w 276
    //   7: invokestatic 171	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: ldc_w 277
    //   14: invokestatic 189	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   17: aload_0
    //   18: invokestatic 283	com/tencent/mm/vfs/u:Tf	(Ljava/lang/String;)Ljava/io/InputStream;
    //   21: astore_0
    //   22: aload_0
    //   23: ifnull +162 -> 185
    //   26: aload_0
    //   27: checkcast 285	java/io/Closeable
    //   30: astore 4
    //   32: new 287	androidx/e/a/a
    //   35: dup
    //   36: aload 4
    //   38: checkcast 289	java/io/InputStream
    //   41: invokespecial 292	androidx/e/a/a:<init>	(Ljava/io/InputStream;)V
    //   44: astore_0
    //   45: getstatic 298	kotlin/x:aazN	Lkotlin/x;
    //   48: astore 5
    //   50: aload 4
    //   52: aconst_null
    //   53: invokestatic 303	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   56: aload_0
    //   57: ifnull +17 -> 74
    //   60: aload_0
    //   61: ldc_w 305
    //   64: iconst_1
    //   65: invokevirtual 308	androidx/e/a/a:i	(Ljava/lang/String;I)I
    //   68: istore_1
    //   69: iload_1
    //   70: invokestatic 314	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   73: astore_2
    //   74: aload_2
    //   75: ifnonnull +45 -> 120
    //   78: aload_2
    //   79: ifnonnull +56 -> 135
    //   82: aload_2
    //   83: ifnonnull +67 -> 150
    //   86: iconst_0
    //   87: istore_1
    //   88: ldc_w 276
    //   91: invokestatic 180	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: iload_1
    //   95: ireturn
    //   96: astore_2
    //   97: ldc_w 276
    //   100: invokestatic 180	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: aload_2
    //   104: athrow
    //   105: astore_0
    //   106: aload 4
    //   108: aload_2
    //   109: invokestatic 303	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   112: ldc_w 276
    //   115: invokestatic 180	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: aload_0
    //   119: athrow
    //   120: aload_2
    //   121: invokevirtual 318	java/lang/Integer:intValue	()I
    //   124: bipush 6
    //   126: if_icmpne -48 -> 78
    //   129: bipush 90
    //   131: istore_1
    //   132: goto -44 -> 88
    //   135: aload_2
    //   136: invokevirtual 318	java/lang/Integer:intValue	()I
    //   139: iconst_3
    //   140: if_icmpne -58 -> 82
    //   143: sipush 180
    //   146: istore_1
    //   147: goto -59 -> 88
    //   150: aload_2
    //   151: invokevirtual 318	java/lang/Integer:intValue	()I
    //   154: istore_1
    //   155: iload_1
    //   156: bipush 8
    //   158: if_icmpne +10 -> 168
    //   161: sipush 270
    //   164: istore_1
    //   165: goto -77 -> 88
    //   168: iconst_0
    //   169: istore_1
    //   170: goto -82 -> 88
    //   173: astore_0
    //   174: aload_3
    //   175: astore_2
    //   176: goto -70 -> 106
    //   179: astore_0
    //   180: iconst_0
    //   181: istore_1
    //   182: goto -94 -> 88
    //   185: aconst_null
    //   186: astore_0
    //   187: goto -131 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	paramString	String
    //   68	114	1	i	int
    //   3	80	2	localInteger	Integer
    //   96	55	2	localThrowable	Throwable
    //   175	1	2	localObject1	Object
    //   1	174	3	localObject2	Object
    //   30	77	4	localCloseable	java.io.Closeable
    //   48	1	5	localx	x
    // Exception table:
    //   from	to	target	type
    //   32	50	96	java/lang/Throwable
    //   97	105	105	finally
    //   32	50	173	finally
    //   17	22	179	java/io/IOException
    //   26	32	179	java/io/IOException
    //   50	56	179	java/io/IOException
    //   60	69	179	java/io/IOException
    //   106	120	179	java/io/IOException
    //   120	129	179	java/io/IOException
    //   135	143	179	java/io/IOException
    //   150	155	179	java/io/IOException
  }
  
  private final String fvh()
  {
    boolean bool = true;
    AppMethodBeat.i(75250);
    Bitmap localBitmap = d.bb(this.HHa.HHi, 200000L);
    if (localBitmap != null)
    {
      try
      {
        Log.i("MicroMsg.Media.VideoMixer", "createThumb getParentAbsolutePath: " + u.bBT(this.HHa.HHj) + "  thumb size:" + this.HHa.HHk);
        u.deleteDir(this.HHa.HHj);
        i = this.HHa.HHk;
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
        p.j(localObject1, "Bitmap.createScaledBitma…idth, outputHeight, true)");
        label172:
        BitmapUtil.saveBitmapToImage((Bitmap)localObject1, 60, Bitmap.CompressFormat.JPEG, this.HHa.HHj, true);
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          int i;
          int j;
          Object localObject1;
          label191:
          localObject2 = f.HUI;
          f.fxx();
        }
      }
      localObject1 = new StringBuilder(" mixVideoPath : ").append(this.HHa.HHi).append(" mixThumbPath:").append(this.HHa.HHj).append("   thumb-bitmap is null:");
      if (localBitmap != null) {
        break label325;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.Media.VideoMixer", bool);
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
      localObject2 = f.HUI;
      f.fxx();
      break label191;
      label325:
      bool = false;
    }
    label331:
    Object localObject2 = this.HHa.HHj;
    AppMethodBeat.o(75250);
    return localObject2;
  }
  
  public static Point iX(int paramInt1, int paramInt2)
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
    this.kWG = paramInt8;
    this.kXq = paramInt9;
    this.kXr = paramInt10;
    if (this.HGT == null) {
      this.HGT = new AdaptiveAdjustBitrate();
    }
    AdaptiveAdjustBitrate localAdaptiveAdjustBitrate = this.HGT;
    if (localAdaptiveAdjustBitrate != null)
    {
      localAdaptiveAdjustBitrate.fIs();
      AppMethodBeat.o(75255);
      return;
    }
    AppMethodBeat.o(75255);
  }
  
  public final void a(VideoTransPara paramVideoTransPara, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(75253);
    p.k(paramVideoTransPara, "videoParam");
    if (this.HGT == null) {
      this.HGT = new AdaptiveAdjustBitrate();
    }
    Log.i("MicroMsg.Media.VideoMixer", "Scene: [%d], ABASwitch: [%d] ceilingVideoBR:[%d]", new Object[] { Integer.valueOf(paramVideoTransPara.lJJ), Integer.valueOf(paramVideoTransPara.lJz), Integer.valueOf(paramVideoTransPara.lJD) });
    AdaptiveAdjustBitrate localAdaptiveAdjustBitrate = this.HGT;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.targetHeight = this.videoHeight;
    }
    localAdaptiveAdjustBitrate = this.HGT;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.targetWidth = this.videoWidth;
    }
    localAdaptiveAdjustBitrate = this.HGT;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.JrA = this.videoBitrate;
    }
    localAdaptiveAdjustBitrate = this.HGT;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.HJX = paramInt2;
    }
    localAdaptiveAdjustBitrate = this.HGT;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.HJY = paramInt1;
    }
    localAdaptiveAdjustBitrate = this.HGT;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.lJJ = paramVideoTransPara.lJJ;
    }
    localAdaptiveAdjustBitrate = this.HGT;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.lJz = paramVideoTransPara.lJz;
    }
    localAdaptiveAdjustBitrate = this.HGT;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.lJA = paramVideoTransPara.lJA;
    }
    localAdaptiveAdjustBitrate = this.HGT;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.lJB = paramVideoTransPara.lJB;
    }
    localAdaptiveAdjustBitrate = this.HGT;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.lJC = paramVideoTransPara.lJC;
    }
    localAdaptiveAdjustBitrate = this.HGT;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.lJD = paramVideoTransPara.lJD;
    }
    localAdaptiveAdjustBitrate = this.HGT;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.lJE = paramVideoTransPara.lJE;
    }
    localAdaptiveAdjustBitrate = this.HGT;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.lJG = paramVideoTransPara.lJG;
    }
    localAdaptiveAdjustBitrate = this.HGT;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.JrB = paramVideoTransPara.lJF;
    }
    localAdaptiveAdjustBitrate = this.HGT;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.lJH = paramVideoTransPara.lJH;
    }
    localAdaptiveAdjustBitrate = this.HGT;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.kSl = paramVideoTransPara.kSl;
    }
    localAdaptiveAdjustBitrate = this.HGT;
    if (localAdaptiveAdjustBitrate != null) {
      localAdaptiveAdjustBitrate.kSm = paramVideoTransPara.kSm;
    }
    localAdaptiveAdjustBitrate = this.HGT;
    if (localAdaptiveAdjustBitrate != null)
    {
      localAdaptiveAdjustBitrate.lJI = paramVideoTransPara.lJI;
      AppMethodBeat.o(75253);
      return;
    }
    AppMethodBeat.o(75253);
  }
  
  public final void e(final r<? super String, ? super String, ? super Boolean, ? super Integer, x> paramr)
  {
    AppMethodBeat.i(75249);
    Log.i("MicroMsg.Media.VideoMixer", "Start mixer " + Util.getStack());
    this.HGO = ((r)new g(this, paramr));
    paramr = (kotlin.g.a.a)new h(this);
    if (this.HHa.HGS.zBD != null)
    {
      Object localObject = this.HHa.HGS.zBD;
      if (localObject == null) {
        p.iCn();
      }
      if (!((AudioCacheInfo)localObject).aGs)
      {
        localObject = k.HMx;
        localObject = k.fwB();
        AudioCacheInfo localAudioCacheInfo = this.HHa.HGS.zBD;
        if (localAudioCacheInfo == null) {
          p.iCn();
        }
        ((k)localObject).a(localAudioCacheInfo, (m)new VideoMixer.d(paramr));
        AppMethodBeat.o(75249);
        return;
      }
    }
    paramr.invoke();
    AppMethodBeat.o(75249);
  }
  
  public final int fvi()
  {
    AppMethodBeat.i(75254);
    Log.i("MicroMsg.Media.VideoMixer", "ABA: Input encoding prams :Br: [%d]  height: [%d]  width: [%d] forceResolution:" + this.HGV, new Object[] { Integer.valueOf(this.videoBitrate), Integer.valueOf(this.videoHeight), Integer.valueOf(this.videoWidth) });
    Object localObject1 = this.HGT;
    Object localObject2;
    label107:
    Object localObject3;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).lJJ);
      localObject2 = this.HGT;
      if (localObject2 == null) {
        break label988;
      }
      localObject2 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject2).lJz);
      localObject3 = this.HGT;
      if (localObject3 == null) {
        break label994;
      }
      localObject3 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject3).lJA);
      label128:
      Log.i("MicroMsg.Media.VideoMixer", "Scene: [%d], ABASwitch: [%d], QPSwitch: [%d]", new Object[] { localObject1, localObject2, localObject3 });
      localObject1 = this.HGT;
      if ((localObject1 == null) || (((AdaptiveAdjustBitrate)localObject1).lJz != 1))
      {
        localObject1 = this.HGT;
        if ((localObject1 == null) || (((AdaptiveAdjustBitrate)localObject1).lJz != 2)) {
          break label1096;
        }
      }
      localObject1 = this.HGT;
      if ((localObject1 == null) || (((AdaptiveAdjustBitrate)localObject1).lJJ != this.HGX))
      {
        localObject1 = this.HGT;
        if ((localObject1 == null) || (((AdaptiveAdjustBitrate)localObject1).lJJ != this.HGW))
        {
          localObject1 = this.HGT;
          if ((localObject1 == null) || (((AdaptiveAdjustBitrate)localObject1).lJJ != this.xde)) {
            break label1096;
          }
        }
      }
      if (this.HHa.kSJ)
      {
        Log.i("MicroMsg.Media.VideoMixer", "getABAPrams enableHevc, softEncode:" + this.HHa.kXp);
        if (!this.HHa.kXp) {
          break label1000;
        }
        localObject1 = this.HGT;
        if (localObject1 != null) {
          ((AdaptiveAdjustBitrate)localObject1).JrB = 1;
        }
      }
      label329:
      localObject2 = this.HGS.HJy;
      i = this.videoHeight;
      int j = this.videoWidth;
      int k = this.videoFrameRate;
      int m = this.videoBitrate;
      localObject1 = this.HGT;
      if (localObject1 == null) {
        break label1020;
      }
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).HJY);
      label382:
      if (localObject1 == null) {
        p.iCn();
      }
      int n = ((Integer)localObject1).intValue();
      localObject1 = this.HGT;
      if (localObject1 == null) {
        break label1026;
      }
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).HJX);
      label418:
      if (localObject1 == null) {
        p.iCn();
      }
      float f1 = (n - ((Integer)localObject1).intValue()) / 1000;
      localObject1 = this.HGT;
      if (localObject1 == null) {
        break label1032;
      }
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).HJX);
      label461:
      if (localObject1 == null) {
        p.iCn();
      }
      float f2 = ((Integer)localObject1).intValue() / 1000;
      localObject1 = this.HGT;
      if (localObject1 == null) {
        break label1038;
      }
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).lJJ);
      label501:
      if (localObject1 == null) {
        p.iCn();
      }
      n = ((Integer)localObject1).intValue();
      localObject1 = this.HGT;
      if (localObject1 == null) {
        break label1044;
      }
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).lJB);
      label537:
      if (localObject1 == null) {
        p.iCn();
      }
      int i1 = ((Integer)localObject1).intValue();
      localObject1 = this.HGT;
      if (localObject1 == null) {
        break label1050;
      }
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).lJC);
      label573:
      if (localObject1 == null) {
        p.iCn();
      }
      int i2 = ((Integer)localObject1).intValue();
      localObject1 = this.HGT;
      if (localObject1 == null) {
        break label1056;
      }
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).lJD);
      label609:
      if (localObject1 == null) {
        p.iCn();
      }
      int i3 = ((Integer)localObject1).intValue();
      localObject1 = this.HGT;
      if (localObject1 == null) {
        break label1062;
      }
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).lJE);
      label645:
      if (localObject1 == null) {
        p.iCn();
      }
      int i4 = ((Integer)localObject1).intValue();
      localObject1 = this.HGT;
      if (localObject1 == null) {
        break label1068;
      }
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).JrB);
      label681:
      if (localObject1 == null) {
        p.iCn();
      }
      int i5 = ((Integer)localObject1).intValue();
      localObject1 = this.HGT;
      if (localObject1 == null) {
        break label1074;
      }
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).lJG);
      label717:
      if (localObject1 == null) {
        p.iCn();
      }
      int i6 = ((Integer)localObject1).intValue();
      localObject1 = this.HGT;
      if (localObject1 == null) {
        break label1080;
      }
      localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).lJH);
      label753:
      if (localObject1 == null) {
        p.iCn();
      }
      localObject1 = AdaptiveAdjustBitrate.a((String)localObject2, i, j, k, m, f1, f2, n, i1, i2, i3, i4, i5, i6, ((Integer)localObject1).intValue(), false);
      p.j(localObject1, "AdaptiveAdjustBitrate.Ge…s?.maxVideoSize!!, false)");
      this.Azu = ((int[])localObject1);
      if (this.Azu != null) {
        this.videoBitrate = (this.Azu[0] * 1000);
      }
      if ((this.Azu != null) && (this.Azu[5] > 0) && (!this.HGV))
      {
        this.videoWidth = this.Azu[1];
        this.videoHeight = this.Azu[2];
      }
      Log.i("MicroMsg.Media.VideoMixer", "ABA: Adaptive Bitrate Methods:videoBitrate [%d]  targetWidth [%d]  targetHeight [%d]", new Object[] { Integer.valueOf(this.videoBitrate), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight) });
      s.bqC();
      e.s(this.Azu);
      if (((this.Azu == null) || (this.Azu[3] <= 0)) && (this.Azu[4] <= 0) && (this.Azu[5] <= 0)) {
        break label1086;
      }
      this.HGU = this.Azu[3];
    }
    for (int i = 0;; i = 1)
    {
      AppMethodBeat.o(75254);
      return i;
      localObject1 = null;
      break;
      label988:
      localObject2 = null;
      break label107;
      label994:
      localObject3 = null;
      break label128;
      label1000:
      localObject1 = this.HGT;
      if (localObject1 == null) {
        break label329;
      }
      ((AdaptiveAdjustBitrate)localObject1).JrB = 2;
      break label329;
      label1020:
      localObject1 = null;
      break label382;
      label1026:
      localObject1 = null;
      break label418;
      label1032:
      localObject1 = null;
      break label461;
      label1038:
      localObject1 = null;
      break label501;
      label1044:
      localObject1 = null;
      break label537;
      label1050:
      localObject1 = null;
      break label573;
      label1056:
      localObject1 = null;
      break label609;
      label1062:
      localObject1 = null;
      break label645;
      label1068:
      localObject1 = null;
      break label681;
      label1074:
      localObject1 = null;
      break label717;
      label1080:
      localObject1 = null;
      break label753;
      label1086:
      this.HGU = 0;
    }
    label1096:
    i = this.videoBitrate;
    localObject1 = this.HGT;
    if (localObject1 != null) {}
    for (localObject1 = Integer.valueOf(((AdaptiveAdjustBitrate)localObject1).lJI);; localObject1 = null)
    {
      Log.i("MicroMsg.Media.VideoMixer", "ABA: No use ABA algorithm: final bitrate: [%d], takePhotosVideoBR: [%d]", new Object[] { Integer.valueOf(i), localObject1 });
      i = 1;
      break;
    }
  }
  
  public final MixConfig fvj()
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
    localMixConfig.kWG = this.kWG;
    AppMethodBeat.o(75257);
    return localMixConfig;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer$MixConfig;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "audioBitrate", "", "getAudioBitrate", "()I", "setAudioBitrate", "(I)V", "audioChannelCount", "getAudioChannelCount", "setAudioChannelCount", "audioSampleRate", "getAudioSampleRate", "setAudioSampleRate", "videoBitrate", "getVideoBitrate", "setVideoBitrate", "videoFrameRate", "getVideoFrameRate", "setVideoFrameRate", "videoHeight", "getVideoHeight", "setVideoHeight", "videoRotate", "getVideoRotate", "setVideoRotate", "videoWidth", "getVideoWidth", "setVideoWidth", "describeContents", "toString", "", "writeToParcel", "", "flags", "CREATOR", "plugin-recordvideo_release"})
  public static final class MixConfig
    implements Parcelable
  {
    public static final a CREATOR;
    public int audioBitrate;
    public int audioChannelCount;
    public int audioSampleRate;
    public int kWG;
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
      this.audioChannelCount = paramParcel.readInt();
      this.videoFrameRate = paramParcel.readInt();
      this.kWG = paramParcel.readInt();
      AppMethodBeat.o(75240);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(75238);
      String str = "[MixConfig]videoWidth=" + this.videoWidth + ", videoHeight=" + this.videoHeight + ", videoBitrate=" + this.videoBitrate + ", audioBitrate=" + this.audioBitrate + ", audioSampleRate=" + this.audioSampleRate + ", audioChannelCount=" + this.audioChannelCount + ", videoFrameRate=" + this.videoFrameRate + ", videoRotate=" + this.kWG;
      AppMethodBeat.o(75238);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(75239);
      p.k(paramParcel, "parcel");
      paramParcel.writeInt(this.videoWidth);
      paramParcel.writeInt(this.videoHeight);
      paramParcel.writeInt(this.videoBitrate);
      paramParcel.writeInt(this.audioBitrate);
      paramParcel.writeInt(this.audioSampleRate);
      paramParcel.writeInt(this.audioChannelCount);
      paramParcel.writeInt(this.videoFrameRate);
      paramParcel.writeInt(this.kWG);
      AppMethodBeat.o(75239);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer$MixConfig$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer$MixConfig;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer$MixConfig;", "plugin-recordvideo_release"})
    public static final class a
      implements Parcelable.Creator<VideoMixer.MixConfig>
    {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/background/VideoMixer$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/graphics/Bitmap;", "pts", "", "invoke"})
  static final class b
    extends q
    implements b<Long, Bitmap>
  {
    b(VideoMixer paramVideoMixer)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/graphics/Bitmap;", "pts", "", "invoke"})
  static final class c
    extends q
    implements b<Long, Bitmap>
  {
    c(VideoMixer paramVideoMixer)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class e
    extends q
    implements b<String, x>
  {
    e(VideoMixer paramVideoMixer, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class f
    extends q
    implements b<String, x>
  {
    f(VideoMixer paramVideoMixer)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "mixVideo", "", "mixThumb", "ret", "", "errorCode", "", "invoke"})
  static final class g
    extends q
    implements r<String, String, Boolean, Integer, x>
  {
    g(VideoMixer paramVideoMixer, r paramr)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<x>
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