package com.tencent.mm.videocomposition;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.URLAsset;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.resource.TAVAssetTrackResource;
import com.tencent.tavkit.composition.resource.TAVEmptyResource;
import com.tencent.tavkit.composition.resource.TAVImageResource;
import com.tencent.tavkit.composition.resource.TAVResource;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/videocomposition/TrackCache;", "", "()V", "bitmapCache", "Ljava/util/HashMap;", "", "Landroid/graphics/Bitmap;", "Lkotlin/collections/HashMap;", "bitmapSizeLimit", "", "getBitmapSizeLimit", "()I", "setBitmapSizeLimit", "(I)V", "cache", "Lcom/tencent/tavkit/composition/resource/TAVResource;", "imageDuration", "", "getImageDuration", "()J", "setImageDuration", "(J)V", "videoInfoCache", "Lcom/tencent/mm/videocomposition/VideoClipInfo;", "clear", "", "createRescaleBitmap", "path", "getBitmap", "track", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "getResource", "getVideoInfo", "remove", "resizeBitmap", "bitmap", "video_composition_release"}, k=1, mv={1, 1, 15})
public final class e
{
  private static final HashMap<String, Bitmap> Etw;
  private static final HashMap<String, i> ObC;
  private static int agDH;
  private static long agDI;
  public static final e agDJ;
  private static final HashMap<String, TAVResource> cache;
  
  static
  {
    AppMethodBeat.i(233492);
    agDJ = new e();
    agDH = 1080;
    agDI = 10000L;
    Etw = new HashMap();
    cache = new HashMap();
    ObC = new HashMap();
    AppMethodBeat.o(233492);
  }
  
  public static void aFO(int paramInt)
  {
    agDH = paramInt;
  }
  
  public static int jLS()
  {
    return agDH;
  }
  
  public static void jLT()
  {
    agDI = 4000L;
  }
  
  /* Error */
  public final i bEy(String paramString)
  {
    // Byte code:
    //   0: ldc 101
    //   2: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ldc 102
    //   8: invokestatic 108	kotlin/g/b/s:t	(Ljava/lang/Object;Ljava/lang/String;)V
    //   11: aload_0
    //   12: monitorenter
    //   13: getstatic 86	com/tencent/mm/videocomposition/e:ObC	Ljava/util/HashMap;
    //   16: aload_1
    //   17: invokevirtual 112	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   20: checkcast 114	com/tencent/mm/videocomposition/i
    //   23: astore 7
    //   25: aload 7
    //   27: astore 6
    //   29: aload 7
    //   31: ifnonnull +141 -> 172
    //   34: aconst_null
    //   35: astore 7
    //   37: new 116	android/media/MediaMetadataRetriever
    //   40: dup
    //   41: invokespecial 117	android/media/MediaMetadataRetriever:<init>	()V
    //   44: astore 8
    //   46: aload 8
    //   48: aload_1
    //   49: invokevirtual 121	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   52: aload 8
    //   54: bipush 18
    //   56: invokevirtual 125	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   59: astore 6
    //   61: aload 6
    //   63: ifnull +119 -> 182
    //   66: aload 6
    //   68: invokestatic 131	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   71: istore_2
    //   72: aload 8
    //   74: bipush 19
    //   76: invokevirtual 125	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   79: astore 6
    //   81: aload 6
    //   83: ifnull +104 -> 187
    //   86: aload 6
    //   88: invokestatic 131	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   91: istore_3
    //   92: aload 8
    //   94: bipush 24
    //   96: invokevirtual 125	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   99: astore 6
    //   101: aload 6
    //   103: ifnull +89 -> 192
    //   106: aload 6
    //   108: invokestatic 131	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   111: istore 4
    //   113: goto +142 -> 255
    //   116: aload 8
    //   118: bipush 9
    //   120: invokevirtual 125	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   123: astore 6
    //   125: aload 6
    //   127: ifnull +71 -> 198
    //   130: aload 6
    //   132: invokestatic 131	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   135: istore 5
    //   137: new 114	com/tencent/mm/videocomposition/i
    //   140: dup
    //   141: iload_3
    //   142: iload_2
    //   143: iload 4
    //   145: iload 5
    //   147: invokespecial 134	com/tencent/mm/videocomposition/i:<init>	(IIII)V
    //   150: astore 6
    //   152: getstatic 86	com/tencent/mm/videocomposition/e:ObC	Ljava/util/HashMap;
    //   155: checkcast 136	java/util/Map
    //   158: aload_1
    //   159: aload 6
    //   161: invokeinterface 140 3 0
    //   166: pop
    //   167: aload 8
    //   169: invokevirtual 143	android/media/MediaMetadataRetriever:release	()V
    //   172: aload_0
    //   173: monitorexit
    //   174: ldc 101
    //   176: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   179: aload 6
    //   181: areturn
    //   182: iconst_0
    //   183: istore_2
    //   184: goto -112 -> 72
    //   187: iconst_0
    //   188: istore_3
    //   189: goto -97 -> 92
    //   192: iconst_0
    //   193: istore 4
    //   195: goto +60 -> 255
    //   198: iconst_0
    //   199: istore 5
    //   201: goto -64 -> 137
    //   204: astore_1
    //   205: aload 7
    //   207: astore 6
    //   209: aload 8
    //   211: invokevirtual 143	android/media/MediaMetadataRetriever:release	()V
    //   214: goto -42 -> 172
    //   217: astore_1
    //   218: aload_0
    //   219: monitorexit
    //   220: ldc 101
    //   222: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   225: aload_1
    //   226: athrow
    //   227: astore_1
    //   228: aload 8
    //   230: invokevirtual 143	android/media/MediaMetadataRetriever:release	()V
    //   233: ldc 101
    //   235: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   238: aload_1
    //   239: athrow
    //   240: astore_1
    //   241: goto -32 -> 209
    //   244: iload_2
    //   245: istore 5
    //   247: iload_3
    //   248: istore_2
    //   249: iload 5
    //   251: istore_3
    //   252: goto -136 -> 116
    //   255: iload 4
    //   257: sipush 270
    //   260: if_icmpeq +10 -> 270
    //   263: iload 4
    //   265: bipush 90
    //   267: if_icmpne -23 -> 244
    //   270: goto -154 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	273	0	this	e
    //   0	273	1	paramString	String
    //   71	178	2	i	int
    //   91	161	3	j	int
    //   111	157	4	k	int
    //   135	115	5	m	int
    //   27	181	6	localObject	Object
    //   23	183	7	locali	i
    //   44	185	8	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    // Exception table:
    //   from	to	target	type
    //   46	61	204	java/lang/Exception
    //   66	72	204	java/lang/Exception
    //   72	81	204	java/lang/Exception
    //   86	92	204	java/lang/Exception
    //   92	101	204	java/lang/Exception
    //   106	113	204	java/lang/Exception
    //   116	125	204	java/lang/Exception
    //   130	137	204	java/lang/Exception
    //   137	152	204	java/lang/Exception
    //   13	25	217	finally
    //   37	46	217	finally
    //   167	172	217	finally
    //   209	214	217	finally
    //   228	240	217	finally
    //   46	61	227	finally
    //   66	72	227	finally
    //   72	81	227	finally
    //   86	92	227	finally
    //   92	101	227	finally
    //   106	113	227	finally
    //   116	125	227	finally
    //   130	137	227	finally
    //   137	152	227	finally
    //   152	167	227	finally
    //   152	167	240	java/lang/Exception
  }
  
  public final void clear()
  {
    AppMethodBeat.i(233523);
    try
    {
      cache.clear();
      Etw.clear();
      ObC.clear();
      ah localah = ah.aiuX;
      return;
    }
    finally
    {
      AppMethodBeat.o(233523);
    }
  }
  
  public final TAVResource e(b paramb)
  {
    AppMethodBeat.i(233513);
    s.t(paramb, "track");
    try
    {
      localObject2 = (TAVResource)cache.get(paramb.path);
      localObject1 = localObject2;
      if (localObject2 == null) {}
      switch (paramb.type)
      {
      case 1: 
        localObject1 = (TAVResource)new TAVEmptyResource(CMTime.CMTimeZero);
        label83:
        cache.put(paramb.path, localObject1);
        paramb = ((TAVResource)localObject1).clone();
        s.r(paramb, "resource.clone()");
        return paramb;
      }
    }
    finally
    {
      Object localObject2;
      Object localObject3;
      long l;
      int j;
      int k;
      Canvas localCanvas;
      AppMethodBeat.o(233513);
    }
    localObject3 = paramb.path;
    l = SystemClock.elapsedRealtime();
    com.tencent.mm.videocomposition.d.b.i("CompositionTrack", "createRescaleBitmap:".concat(String.valueOf(localObject3)), new Object[0]);
    Object localObject1 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
    BitmapFactory.decodeFile((String)localObject3, (BitmapFactory.Options)localObject1);
    j = ((BitmapFactory.Options)localObject1).outWidth;
    k = ((BitmapFactory.Options)localObject1).outHeight;
    localObject2 = com.tencent.mm.videocomposition.d.a.agFF;
    int i = agDH;
    ((BitmapFactory.Options)localObject1).inSampleSize = com.tencent.mm.videocomposition.d.a.calculateInSampleSize(j, k, i, i);
    ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
    localObject1 = BitmapFactory.decodeFile((String)localObject3, (BitmapFactory.Options)localObject1);
    if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled())) {
      if (((Bitmap)localObject1).getWidth() % 2 == 1)
      {
        localObject2 = Bitmap.createBitmap(((Bitmap)localObject1).getWidth() + 1, ((Bitmap)localObject1).getHeight(), Bitmap.Config.ARGB_8888);
        if (localObject2 == null) {
          s.klw();
        }
        localCanvas = new Canvas((Bitmap)localObject2);
        localCanvas.drawARGB(0, 0, 0, 0);
        localCanvas.drawBitmap((Bitmap)localObject1, 0.0F, 0.0F, null);
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      if (localObject1 == null) {
        s.klw();
      }
      switch (new androidx.f.a.a((InputStream)new FileInputStream((String)localObject3)).k("Orientation", 1))
      {
      case 6: 
      case 3: 
      case 8: 
        for (;;)
        {
          localObject2 = localObject1;
          if (i > 0)
          {
            localObject2 = com.tencent.mm.videocomposition.d.a.agFF;
            localObject3 = com.tencent.mm.videocomposition.d.a.rotate((Bitmap)localObject1, i);
            localObject2 = localObject1;
            if (localObject3 != null) {
              localObject2 = localObject3;
            }
          }
          com.tencent.mm.videocomposition.d.b.i("CompositionTrack", "final rescale bitmap size:[" + ((Bitmap)localObject2).getWidth() + ", " + ((Bitmap)localObject2).getHeight() + "], origin size:[" + j + ", " + k + "], cost:" + (SystemClock.elapsedRealtime() - l), new Object[0]);
          ((Map)Etw).put(paramb.path, localObject2);
          localObject1 = (TAVResource)new TAVImageResource(new CIImage((Bitmap)localObject2), new CMTime(agDI, 1000), true);
          break;
          com.tencent.mm.videocomposition.d.b.i("CompositionTrack", "image rotate 90", new Object[0]);
          i = 90;
          continue;
          com.tencent.mm.videocomposition.d.b.i("CompositionTrack", "image rotate 180", new Object[0]);
          i = 180;
          continue;
          com.tencent.mm.videocomposition.d.b.i("CompositionTrack", "image rotate 270", new Object[0]);
          i = 270;
        }
        localObject1 = (TAVResource)new TAVAssetTrackResource((Asset)new URLAsset(paramb.path));
        break label83;
        break;
      case 4: 
      case 5: 
      case 7: 
      default: 
        for (;;)
        {
          label380:
          break;
          i = 0;
          break label380;
        }
        localObject1 = null;
      }
    }
  }
  
  public final Bitmap f(b paramb)
  {
    AppMethodBeat.i(233518);
    s.t(paramb, "track");
    try
    {
      paramb = (Bitmap)Etw.get(paramb.path);
      return paramb;
    }
    finally
    {
      AppMethodBeat.o(233518);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.videocomposition.e
 * JD-Core Version:    0.7.0.1
 */