package com.tencent.mm.plugin.scanner.model;

import android.graphics.Bitmap;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.a.m;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z.a;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager;", "", "()V", "SCAN_RESOURCE_LOOP_TAG", "", "SCAN_RESOURCE_RELEASE_DELAY_MS", "", "TAG", "bitmapCache", "Ljava/util/concurrent/ConcurrentHashMap;", "Landroid/graphics/Bitmap;", "cachedRequest", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/scanner/api/ScanGoodsRequest;", "Lkotlin/collections/HashMap;", "callbackMap", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceLoadCallback;", "pendingReleaseRequestSet", "", "batchDecodeImage", "", "batchImageDecodeInfo", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$BatchImageDecodeInfo;", "getBatchImageDecodeInfo", "requestId", "request", "getRequestKey", "getResource", "imagePath", "loadResource", "callback", "onCallback", "errCode", "", "errMsg", "releaseBitmap", "key", "releaseRequest", "requestKey", "releaseResource", "BatchImageDecodeInfo", "DecodeTask", "ErrCode", "ImageDecodeInfo", "Status", "plugin-scan_release"})
public final class ab
{
  public static final HashMap<Long, ScanGoodsRequest> CGr;
  private static final ConcurrentHashMap<String, Bitmap> CGs;
  public static final ConcurrentHashMap<String, Boolean> CGt;
  public static final ab CGu;
  public static final HashMap<Long, aa> hdu;
  
  static
  {
    AppMethodBeat.i(240442);
    CGu = new ab();
    hdu = new HashMap();
    CGr = new HashMap();
    CGs = new ConcurrentHashMap();
    CGt = new ConcurrentHashMap();
    AppMethodBeat.o(240442);
  }
  
  public static long a(ScanGoodsRequest paramScanGoodsRequest, aa paramaa)
  {
    AppMethodBeat.i(240437);
    if (paramScanGoodsRequest == null)
    {
      AppMethodBeat.o(240437);
      return -1L;
    }
    if (!paramScanGoodsRequest.isValid())
    {
      Log.e("MicroMsg.ScanGoodsResourceManager", "alvinluo prepare request not valid");
      AppMethodBeat.o(240437);
      return -1L;
    }
    final long l = System.currentTimeMillis();
    Log.i("MicroMsg.ScanGoodsResourceManager", "alvinluo loadResource requestId: %d", new Object[] { Long.valueOf(l) });
    ((Map)hdu).put(Long.valueOf(l), paramaa);
    ((Map)CGr).put(Long.valueOf(l), paramScanGoodsRequest);
    h.RTc.e((Runnable)new e(paramScanGoodsRequest, l), "ScanResourceTag");
    AppMethodBeat.o(240437);
    return l;
  }
  
  public static Bitmap aMy(String paramString)
  {
    AppMethodBeat.i(240438);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(240438);
      return null;
    }
    paramString = (Bitmap)CGs.get(paramString);
    AppMethodBeat.o(240438);
    return paramString;
  }
  
  private static void aMz(String paramString)
  {
    AppMethodBeat.i(240440);
    Bitmap localBitmap = (Bitmap)CGs.get(paramString);
    if (localBitmap != null) {
      localBitmap.recycle();
    }
    CGs.remove(paramString);
    AppMethodBeat.o(240440);
  }
  
  public static String c(ScanGoodsRequest paramScanGoodsRequest)
  {
    AppMethodBeat.i(240441);
    ae localae = ae.SYK;
    paramScanGoodsRequest = String.format("deco:%s,succ:%s,tips:%s", Arrays.copyOf(new Object[] { paramScanGoodsRequest.CAN, paramScanGoodsRequest.CAO, paramScanGoodsRequest.CAP }, 3));
    p.g(paramScanGoodsRequest, "java.lang.String.format(format, *args)");
    AppMethodBeat.o(240441);
    return paramScanGoodsRequest;
  }
  
  private static void g(long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(240439);
    aa localaa = (aa)hdu.get(Long.valueOf(paramLong));
    if (localaa != null) {
      localaa.cn(paramInt, paramString);
    }
    hdu.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(240439);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$BatchImageDecodeInfo;", "", "requestId", "", "imageList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$ImageDecodeInfo;", "Lkotlin/collections/ArrayList;", "(JLjava/util/ArrayList;)V", "errMsg", "", "getErrMsg", "()Ljava/lang/String;", "setErrMsg", "(Ljava/lang/String;)V", "getImageList", "()Ljava/util/ArrayList;", "getRequestId", "()J", "result", "", "getResult", "()I", "setResult", "(I)V", "status", "getStatus", "setStatus", "checkFinish", "", "checkResult", "fillErrMsg", "", "plugin-scan_release"})
  static final class a
  {
    final ArrayList<ab.c> BLy;
    String errMsg;
    int result;
    int status;
    final long ulj;
    
    public a(long paramLong, ArrayList<ab.c> paramArrayList)
    {
      AppMethodBeat.i(240427);
      this.ulj = paramLong;
      this.BLy = paramArrayList;
      this.result = -1;
      this.errMsg = "";
      AppMethodBeat.o(240427);
    }
    
    public final void eQf()
    {
      String str;
      if (this.result == 0) {
        str = "ok";
      }
      for (;;)
      {
        this.errMsg = str;
        return;
        if (this.result == 2) {
          str = "image not exist";
        } else if (this.result == 3) {
          str = "decode fail";
        } else {
          str = "unknown error";
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$DecodeTask;", "Ljava/lang/Runnable;", "info", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$ImageDecodeInfo;", "callback", "Lkotlin/Function2;", "Landroid/graphics/Bitmap;", "", "(Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$ImageDecodeInfo;Lkotlin/jvm/functions/Function2;)V", "getCallback", "()Lkotlin/jvm/functions/Function2;", "getInfo", "()Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$ImageDecodeInfo;", "doDecodeImage", "finishDecode", "bitmap", "run", "startDecode", "plugin-scan_release"})
  static final class b
    implements Runnable
  {
    private final ab.c CGv;
    private final m<ab.c, Bitmap, x> gWp;
    
    public b(ab.c paramc, m<? super ab.c, ? super Bitmap, x> paramm)
    {
      AppMethodBeat.i(240431);
      this.CGv = paramc;
      this.gWp = paramm;
      AppMethodBeat.o(240431);
    }
    
    private static Bitmap a(ab.c paramc)
    {
      Integer localInteger = null;
      AppMethodBeat.i(240430);
      if (!s.YS(paramc.imagePath))
      {
        paramc.result = 2;
        a(paramc, null);
        AppMethodBeat.o(240430);
        return null;
      }
      for (;;)
      {
        try
        {
          localBitmap = BitmapUtil.decodeFile(paramc.imagePath);
          if (localBitmap != null) {}
          try
          {
            if (!localBitmap.isRecycled())
            {
              paramc.result = 0;
              String str = paramc.imagePath;
              int i = paramc.result;
              if (localBitmap != null) {
                localInteger = Integer.valueOf(localBitmap.getAllocationByteCount());
              }
              Log.d("MicroMsg.ScanGoodsResourceManager", "alvinluo decodeImage filePath: %s, decode result: %d, bitmap: %s", new Object[] { str, Integer.valueOf(i), localInteger });
              a(paramc, localBitmap);
              AppMethodBeat.o(240430);
              return localBitmap;
            }
            paramc.result = 3;
            continue;
            Log.printErrStackTrace("MicroMsg.ScanGoodsResourceManager", (Throwable)localException1, "alvinluo decodeImage exception", new Object[0]);
          }
          catch (Exception localException1) {}
        }
        catch (Exception localException2)
        {
          Bitmap localBitmap = null;
          continue;
        }
        paramc.result = 3;
      }
    }
    
    private static void a(ab.c paramc, Bitmap paramBitmap)
    {
      AppMethodBeat.i(240429);
      paramc.status = 2;
      if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
      {
        ab localab = ab.CGu;
        ((Map)ab.eQd()).put(paramc.imagePath, paramBitmap);
      }
      Log.d("MicroMsg.ScanGoodsResourceManager", "alvinluo finishDecode image: %s, status: %d, result: %d", new Object[] { paramc.imagePath, Integer.valueOf(paramc.status), Integer.valueOf(paramc.result) });
      AppMethodBeat.o(240429);
    }
    
    public final void run()
    {
      AppMethodBeat.i(240428);
      Log.d("MicroMsg.ScanGoodsResourceManager", "alvinluo startDecode image: %s", new Object[] { this.CGv.imagePath });
      this.CGv.status = 1;
      this.gWp.invoke(this.CGv, a(this.CGv));
      AppMethodBeat.o(240428);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$ImageDecodeInfo;", "", "imagePath", "", "(Ljava/lang/String;)V", "getImagePath", "()Ljava/lang/String;", "result", "", "getResult", "()I", "setResult", "(I)V", "status", "getStatus", "setStatus", "plugin-scan_release"})
  static final class c
  {
    final String imagePath;
    int result;
    int status;
    
    public c(String paramString)
    {
      AppMethodBeat.i(240432);
      this.imagePath = paramString;
      this.result = -1;
      AppMethodBeat.o(240432);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "decodeInfo", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$ImageDecodeInfo;", "bitmap", "Landroid/graphics/Bitmap;", "invoke", "com/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$batchDecodeImage$1$1"})
  static final class d
    extends q
    implements m<ab.c, Bitmap, x>
  {
    d(z.a parama, ab.a parama1)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(ScanGoodsRequest paramScanGoodsRequest, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(240435);
      Object localObject = ab.CGu;
      localObject = ab.d(this.CGz);
      ab localab = ab.CGu;
      if (ab.eQe().containsKey(localObject))
      {
        Log.i("MicroMsg.ScanGoodsResourceManager", "alvinluo loadResource set can not release");
        localab = ab.CGu;
        ((Map)ab.eQe()).put(localObject, Boolean.FALSE);
      }
      localObject = ab.CGu;
      localObject = ab.a(l, this.CGz);
      localab = ab.CGu;
      ab.a((ab.a)localObject);
      AppMethodBeat.o(240435);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  public static final class f
    implements Runnable
  {
    public f(String paramString, ScanGoodsRequest paramScanGoodsRequest) {}
    
    public final void run()
    {
      AppMethodBeat.i(240436);
      ab localab = ab.CGu;
      if (p.j((Boolean)ab.eQe().get(this.$key), Boolean.TRUE))
      {
        localab = ab.CGu;
        ab.a(this.$key, this.CGz);
        AppMethodBeat.o(240436);
        return;
      }
      Log.d("MicroMsg.ScanGoodsResourceManager", "alvinluo releaseResource not need to release requestKey: %s", new Object[] { this.$key });
      AppMethodBeat.o(240436);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.ab
 * JD-Core Version:    0.7.0.1
 */