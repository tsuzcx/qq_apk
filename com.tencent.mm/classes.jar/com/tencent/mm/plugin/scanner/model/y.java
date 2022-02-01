package com.tencent.mm.plugin.scanner.model;

import android.graphics.Bitmap;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.sdk.platformtools.g;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager;", "", "()V", "SCAN_RESOURCE_LOOP_TAG", "", "SCAN_RESOURCE_RELEASE_DELAY_MS", "", "TAG", "bitmapCache", "Ljava/util/concurrent/ConcurrentHashMap;", "Landroid/graphics/Bitmap;", "cachedRequest", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/scanner/api/ScanGoodsRequest;", "Lkotlin/collections/HashMap;", "callbackMap", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceLoadCallback;", "pendingReleaseRequestSet", "", "batchDecodeImage", "", "batchImageDecodeInfo", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$BatchImageDecodeInfo;", "getBatchImageDecodeInfo", "requestId", "request", "getRequestKey", "getResource", "imagePath", "loadResource", "callback", "onCallback", "errCode", "", "errMsg", "releaseBitmap", "key", "releaseRequest", "requestKey", "releaseResource", "BatchImageDecodeInfo", "DecodeTask", "ErrCode", "ImageDecodeInfo", "Status", "plugin-scan_release"})
public final class y
{
  public static final HashMap<Long, x> gpP;
  public static final HashMap<Long, ScanGoodsRequest> ynD;
  private static final ConcurrentHashMap<String, Bitmap> ynE;
  public static final ConcurrentHashMap<String, Boolean> ynF;
  public static final y ynG;
  
  static
  {
    AppMethodBeat.i(186307);
    ynG = new y();
    gpP = new HashMap();
    ynD = new HashMap();
    ynE = new ConcurrentHashMap();
    ynF = new ConcurrentHashMap();
    AppMethodBeat.o(186307);
  }
  
  public static long a(ScanGoodsRequest paramScanGoodsRequest, x paramx)
  {
    AppMethodBeat.i(186302);
    if (paramScanGoodsRequest == null)
    {
      AppMethodBeat.o(186302);
      return -1L;
    }
    if (!paramScanGoodsRequest.isValid())
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ScanGoodsResourceManager", "alvinluo prepare request not valid");
      AppMethodBeat.o(186302);
      return -1L;
    }
    final long l = System.currentTimeMillis();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanGoodsResourceManager", "alvinluo loadResource requestId: %d", new Object[] { Long.valueOf(l) });
    ((Map)gpP).put(Long.valueOf(l), paramx);
    ((Map)ynD).put(Long.valueOf(l), paramScanGoodsRequest);
    h.LTJ.h((Runnable)new e(paramScanGoodsRequest, l), "ScanResourceTag");
    AppMethodBeat.o(186302);
    return l;
  }
  
  public static Bitmap awF(String paramString)
  {
    AppMethodBeat.i(186303);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(186303);
      return null;
    }
    paramString = (Bitmap)ynE.get(paramString);
    AppMethodBeat.o(186303);
    return paramString;
  }
  
  private static void awG(String paramString)
  {
    AppMethodBeat.i(186305);
    Bitmap localBitmap = (Bitmap)ynE.get(paramString);
    if (localBitmap != null) {
      localBitmap.recycle();
    }
    ynE.remove(paramString);
    AppMethodBeat.o(186305);
  }
  
  public static String c(ScanGoodsRequest paramScanGoodsRequest)
  {
    AppMethodBeat.i(186306);
    d.g.b.ad localad = d.g.b.ad.MLZ;
    paramScanGoodsRequest = String.format("deco:%s,succ:%s,tips:%s", Arrays.copyOf(new Object[] { paramScanGoodsRequest.yjL, paramScanGoodsRequest.yjM, paramScanGoodsRequest.yjN }, 3));
    p.g(paramScanGoodsRequest, "java.lang.String.format(format, *args)");
    AppMethodBeat.o(186306);
    return paramScanGoodsRequest;
  }
  
  private static void g(long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(186304);
    x localx = (x)gpP.get(Long.valueOf(paramLong));
    if (localx != null) {
      localx.bX(paramInt, paramString);
    }
    gpP.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(186304);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$BatchImageDecodeInfo;", "", "requestId", "", "imageList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$ImageDecodeInfo;", "Lkotlin/collections/ArrayList;", "(JLjava/util/ArrayList;)V", "errMsg", "", "getErrMsg", "()Ljava/lang/String;", "setErrMsg", "(Ljava/lang/String;)V", "getImageList", "()Ljava/util/ArrayList;", "getRequestId", "()J", "result", "", "getResult", "()I", "setResult", "(I)V", "status", "getStatus", "setStatus", "checkFinish", "", "checkResult", "fillErrMsg", "", "plugin-scan_release"})
  static final class a
  {
    String errMsg;
    int result;
    int status;
    final long xcO;
    final ArrayList<y.c> xvx;
    
    public a(long paramLong, ArrayList<y.c> paramArrayList)
    {
      AppMethodBeat.i(186292);
      this.xcO = paramLong;
      this.xvx = paramArrayList;
      this.result = -1;
      this.errMsg = "";
      AppMethodBeat.o(186292);
    }
    
    public final void dLg()
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$DecodeTask;", "Ljava/lang/Runnable;", "info", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$ImageDecodeInfo;", "callback", "Lkotlin/Function2;", "Landroid/graphics/Bitmap;", "", "(Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$ImageDecodeInfo;Lkotlin/jvm/functions/Function2;)V", "getCallback", "()Lkotlin/jvm/functions/Function2;", "getInfo", "()Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$ImageDecodeInfo;", "doDecodeImage", "finishDecode", "bitmap", "run", "startDecode", "plugin-scan_release"})
  static final class b
    implements Runnable
  {
    private final m<y.c, Bitmap, z> gjf;
    private final y.c ynH;
    
    public b(y.c paramc, m<? super y.c, ? super Bitmap, z> paramm)
    {
      AppMethodBeat.i(186296);
      this.ynH = paramc;
      this.gjf = paramm;
      AppMethodBeat.o(186296);
    }
    
    private static Bitmap a(y.c paramc)
    {
      Integer localInteger = null;
      AppMethodBeat.i(186295);
      if (!com.tencent.mm.vfs.i.fv(paramc.imagePath))
      {
        paramc.result = 2;
        a(paramc, null);
        AppMethodBeat.o(186295);
        return null;
      }
      for (;;)
      {
        try
        {
          localBitmap = g.decodeFile(paramc.imagePath);
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
              com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ScanGoodsResourceManager", "alvinluo decodeImage filePath: %s, decode result: %d, bitmap: %s", new Object[] { str, Integer.valueOf(i), localInteger });
              a(paramc, localBitmap);
              AppMethodBeat.o(186295);
              return localBitmap;
            }
            paramc.result = 3;
            continue;
            com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.ScanGoodsResourceManager", (Throwable)localException1, "alvinluo decodeImage exception", new Object[0]);
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
    
    private static void a(y.c paramc, Bitmap paramBitmap)
    {
      AppMethodBeat.i(186294);
      paramc.status = 2;
      if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
      {
        y localy = y.ynG;
        ((Map)y.dLe()).put(paramc.imagePath, paramBitmap);
      }
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ScanGoodsResourceManager", "alvinluo finishDecode image: %s, status: %d, result: %d", new Object[] { paramc.imagePath, Integer.valueOf(paramc.status), Integer.valueOf(paramc.result) });
      AppMethodBeat.o(186294);
    }
    
    public final void run()
    {
      AppMethodBeat.i(186293);
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ScanGoodsResourceManager", "alvinluo startDecode image: %s", new Object[] { this.ynH.imagePath });
      this.ynH.status = 1;
      this.gjf.p(this.ynH, a(this.ynH));
      AppMethodBeat.o(186293);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$ImageDecodeInfo;", "", "imagePath", "", "(Ljava/lang/String;)V", "getImagePath", "()Ljava/lang/String;", "result", "", "getResult", "()I", "setResult", "(I)V", "status", "getStatus", "setStatus", "plugin-scan_release"})
  static final class c
  {
    final String imagePath;
    int result;
    int status;
    
    public c(String paramString)
    {
      AppMethodBeat.i(186297);
      this.imagePath = paramString;
      this.result = -1;
      AppMethodBeat.o(186297);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "decodeInfo", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$ImageDecodeInfo;", "bitmap", "Landroid/graphics/Bitmap;", "invoke", "com/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$batchDecodeImage$1$1"})
  static final class d
    extends q
    implements m<y.c, Bitmap, z>
  {
    d(d.g.b.y.a parama, y.a parama1)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(ScanGoodsRequest paramScanGoodsRequest, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(186300);
      Object localObject = y.ynG;
      localObject = y.d(this.ynL);
      y localy = y.ynG;
      if (y.dLf().containsKey(localObject))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanGoodsResourceManager", "alvinluo loadResource set can not release");
        localy = y.ynG;
        ((Map)y.dLf()).put(localObject, Boolean.FALSE);
      }
      localObject = y.ynG;
      localObject = y.a(l, this.ynL);
      localy = y.ynG;
      y.a((y.a)localObject);
      AppMethodBeat.o(186300);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  public static final class f
    implements Runnable
  {
    public f(String paramString, ScanGoodsRequest paramScanGoodsRequest) {}
    
    public final void run()
    {
      AppMethodBeat.i(186301);
      y localy = y.ynG;
      if (p.i((Boolean)y.dLf().get(this.kxJ), Boolean.TRUE))
      {
        localy = y.ynG;
        y.a(this.kxJ, this.ynL);
        AppMethodBeat.o(186301);
        return;
      }
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ScanGoodsResourceManager", "alvinluo releaseResource not need to release requestKey: %s", new Object[] { this.kxJ });
      AppMethodBeat.o(186301);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.y
 * JD-Core Version:    0.7.0.1
 */