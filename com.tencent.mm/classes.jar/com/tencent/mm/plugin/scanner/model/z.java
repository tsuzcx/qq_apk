package com.tencent.mm.plugin.scanner.model;

import android.graphics.Bitmap;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.o;
import d.g.a.m;
import d.g.b.ad;
import d.g.b.p;
import d.g.b.q;
import d.g.b.y.a;
import d.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager;", "", "()V", "SCAN_RESOURCE_LOOP_TAG", "", "SCAN_RESOURCE_RELEASE_DELAY_MS", "", "TAG", "bitmapCache", "Ljava/util/concurrent/ConcurrentHashMap;", "Landroid/graphics/Bitmap;", "cachedRequest", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/scanner/api/ScanGoodsRequest;", "Lkotlin/collections/HashMap;", "callbackMap", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceLoadCallback;", "pendingReleaseRequestSet", "", "batchDecodeImage", "", "batchImageDecodeInfo", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$BatchImageDecodeInfo;", "getBatchImageDecodeInfo", "requestId", "request", "getRequestKey", "getResource", "imagePath", "loadResource", "callback", "onCallback", "errCode", "", "errMsg", "releaseBitmap", "key", "releaseRequest", "requestKey", "releaseResource", "BatchImageDecodeInfo", "DecodeTask", "ErrCode", "ImageDecodeInfo", "Status", "plugin-scan_release"})
public final class z
{
  public static final HashMap<Long, y> gsk;
  public static final HashMap<Long, ScanGoodsRequest> yDC;
  private static final ConcurrentHashMap<String, Bitmap> yDD;
  public static final ConcurrentHashMap<String, Boolean> yDE;
  public static final z yDF;
  
  static
  {
    AppMethodBeat.i(189599);
    yDF = new z();
    gsk = new HashMap();
    yDC = new HashMap();
    yDD = new ConcurrentHashMap();
    yDE = new ConcurrentHashMap();
    AppMethodBeat.o(189599);
  }
  
  public static long a(ScanGoodsRequest paramScanGoodsRequest, y paramy)
  {
    AppMethodBeat.i(189594);
    if (paramScanGoodsRequest == null)
    {
      AppMethodBeat.o(189594);
      return -1L;
    }
    if (!paramScanGoodsRequest.isValid())
    {
      ae.e("MicroMsg.ScanGoodsResourceManager", "alvinluo prepare request not valid");
      AppMethodBeat.o(189594);
      return -1L;
    }
    final long l = System.currentTimeMillis();
    ae.i("MicroMsg.ScanGoodsResourceManager", "alvinluo loadResource requestId: %d", new Object[] { Long.valueOf(l) });
    ((Map)gsk).put(Long.valueOf(l), paramy);
    ((Map)yDC).put(Long.valueOf(l), paramScanGoodsRequest);
    com.tencent.e.h.MqF.i((Runnable)new e(paramScanGoodsRequest, l), "ScanResourceTag");
    AppMethodBeat.o(189594);
    return l;
  }
  
  public static Bitmap axU(String paramString)
  {
    AppMethodBeat.i(189595);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(189595);
      return null;
    }
    paramString = (Bitmap)yDD.get(paramString);
    AppMethodBeat.o(189595);
    return paramString;
  }
  
  private static void axV(String paramString)
  {
    AppMethodBeat.i(189597);
    Bitmap localBitmap = (Bitmap)yDD.get(paramString);
    if (localBitmap != null) {
      localBitmap.recycle();
    }
    yDD.remove(paramString);
    AppMethodBeat.o(189597);
  }
  
  public static String c(ScanGoodsRequest paramScanGoodsRequest)
  {
    AppMethodBeat.i(189598);
    ad localad = ad.Njc;
    paramScanGoodsRequest = String.format("deco:%s,succ:%s,tips:%s", Arrays.copyOf(new Object[] { paramScanGoodsRequest.yzH, paramScanGoodsRequest.yzI, paramScanGoodsRequest.yzJ }, 3));
    p.g(paramScanGoodsRequest, "java.lang.String.format(format, *args)");
    AppMethodBeat.o(189598);
    return paramScanGoodsRequest;
  }
  
  private static void f(long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(189596);
    y localy = (y)gsk.get(Long.valueOf(paramLong));
    if (localy != null) {
      localy.bX(paramInt, paramString);
    }
    gsk.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(189596);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$BatchImageDecodeInfo;", "", "requestId", "", "imageList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$ImageDecodeInfo;", "Lkotlin/collections/ArrayList;", "(JLjava/util/ArrayList;)V", "errMsg", "", "getErrMsg", "()Ljava/lang/String;", "setErrMsg", "(Ljava/lang/String;)V", "getImageList", "()Ljava/util/ArrayList;", "getRequestId", "()J", "result", "", "getResult", "()I", "setResult", "(I)V", "status", "getStatus", "setStatus", "checkFinish", "", "checkResult", "fillErrMsg", "", "plugin-scan_release"})
  static final class a
  {
    String errMsg;
    int result;
    int status;
    final ArrayList<z.c> xLu;
    final long xsF;
    
    public a(long paramLong, ArrayList<z.c> paramArrayList)
    {
      AppMethodBeat.i(189584);
      this.xsF = paramLong;
      this.xLu = paramArrayList;
      this.result = -1;
      this.errMsg = "";
      AppMethodBeat.o(189584);
    }
    
    public final void dOz()
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$DecodeTask;", "Ljava/lang/Runnable;", "info", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$ImageDecodeInfo;", "callback", "Lkotlin/Function2;", "Landroid/graphics/Bitmap;", "", "(Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$ImageDecodeInfo;Lkotlin/jvm/functions/Function2;)V", "getCallback", "()Lkotlin/jvm/functions/Function2;", "getInfo", "()Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$ImageDecodeInfo;", "doDecodeImage", "finishDecode", "bitmap", "run", "startDecode", "plugin-scan_release"})
  static final class b
    implements Runnable
  {
    private final m<z.c, Bitmap, d.z> glx;
    private final z.c yDG;
    
    public b(z.c paramc, m<? super z.c, ? super Bitmap, d.z> paramm)
    {
      AppMethodBeat.i(189588);
      this.yDG = paramc;
      this.glx = paramm;
      AppMethodBeat.o(189588);
    }
    
    private static Bitmap a(z.c paramc)
    {
      Integer localInteger = null;
      AppMethodBeat.i(189587);
      if (!o.fB(paramc.imagePath))
      {
        paramc.result = 2;
        a(paramc, null);
        AppMethodBeat.o(189587);
        return null;
      }
      for (;;)
      {
        try
        {
          localBitmap = com.tencent.mm.sdk.platformtools.h.decodeFile(paramc.imagePath);
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
              ae.d("MicroMsg.ScanGoodsResourceManager", "alvinluo decodeImage filePath: %s, decode result: %d, bitmap: %s", new Object[] { str, Integer.valueOf(i), localInteger });
              a(paramc, localBitmap);
              AppMethodBeat.o(189587);
              return localBitmap;
            }
            paramc.result = 3;
            continue;
            ae.printErrStackTrace("MicroMsg.ScanGoodsResourceManager", (Throwable)localException1, "alvinluo decodeImage exception", new Object[0]);
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
    
    private static void a(z.c paramc, Bitmap paramBitmap)
    {
      AppMethodBeat.i(189586);
      paramc.status = 2;
      if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
      {
        z localz = z.yDF;
        ((Map)z.dOx()).put(paramc.imagePath, paramBitmap);
      }
      ae.d("MicroMsg.ScanGoodsResourceManager", "alvinluo finishDecode image: %s, status: %d, result: %d", new Object[] { paramc.imagePath, Integer.valueOf(paramc.status), Integer.valueOf(paramc.result) });
      AppMethodBeat.o(189586);
    }
    
    public final void run()
    {
      AppMethodBeat.i(189585);
      ae.d("MicroMsg.ScanGoodsResourceManager", "alvinluo startDecode image: %s", new Object[] { this.yDG.imagePath });
      this.yDG.status = 1;
      this.glx.p(this.yDG, a(this.yDG));
      AppMethodBeat.o(189585);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$ImageDecodeInfo;", "", "imagePath", "", "(Ljava/lang/String;)V", "getImagePath", "()Ljava/lang/String;", "result", "", "getResult", "()I", "setResult", "(I)V", "status", "getStatus", "setStatus", "plugin-scan_release"})
  static final class c
  {
    final String imagePath;
    int result;
    int status;
    
    public c(String paramString)
    {
      AppMethodBeat.i(189589);
      this.imagePath = paramString;
      this.result = -1;
      AppMethodBeat.o(189589);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "decodeInfo", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$ImageDecodeInfo;", "bitmap", "Landroid/graphics/Bitmap;", "invoke", "com/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$batchDecodeImage$1$1"})
  static final class d
    extends q
    implements m<z.c, Bitmap, d.z>
  {
    d(y.a parama, z.a parama1)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(ScanGoodsRequest paramScanGoodsRequest, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(189592);
      Object localObject = z.yDF;
      localObject = z.d(this.yDK);
      z localz = z.yDF;
      if (z.dOy().containsKey(localObject))
      {
        ae.i("MicroMsg.ScanGoodsResourceManager", "alvinluo loadResource set can not release");
        localz = z.yDF;
        ((Map)z.dOy()).put(localObject, Boolean.FALSE);
      }
      localObject = z.yDF;
      localObject = z.a(l, this.yDK);
      localz = z.yDF;
      z.a((z.a)localObject);
      AppMethodBeat.o(189592);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  public static final class f
    implements Runnable
  {
    public f(String paramString, ScanGoodsRequest paramScanGoodsRequest) {}
    
    public final void run()
    {
      AppMethodBeat.i(189593);
      z localz = z.yDF;
      if (p.i((Boolean)z.dOy().get(this.kAY), Boolean.TRUE))
      {
        localz = z.yDF;
        z.a(this.kAY, this.yDK);
        AppMethodBeat.o(189593);
        return;
      }
      ae.d("MicroMsg.ScanGoodsResourceManager", "alvinluo releaseResource not need to release requestKey: %s", new Object[] { this.kAY });
      AppMethodBeat.o(189593);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.z
 * JD-Core Version:    0.7.0.1
 */