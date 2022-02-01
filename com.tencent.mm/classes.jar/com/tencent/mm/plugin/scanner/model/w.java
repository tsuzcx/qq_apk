package com.tencent.mm.plugin.scanner.model;

import android.graphics.Bitmap;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.f;
import d.g.a.m;
import d.g.b.k;
import d.g.b.v.a;
import d.g.b.z;
import d.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager;", "", "()V", "SCAN_RESOURCE_LOOP_TAG", "", "SCAN_RESOURCE_RELEASE_DELAY_MS", "", "TAG", "bitmapCache", "Ljava/util/concurrent/ConcurrentHashMap;", "Landroid/graphics/Bitmap;", "cachedRequest", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/scanner/api/ScanGoodsRequest;", "Lkotlin/collections/HashMap;", "callbackMap", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceLoadCallback;", "pendingReleaseRequestSet", "", "batchDecodeImage", "", "batchImageDecodeInfo", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$BatchImageDecodeInfo;", "getBatchImageDecodeInfo", "requestId", "request", "getRequestKey", "getResource", "imagePath", "loadResource", "callback", "onCallback", "errCode", "", "errMsg", "releaseBitmap", "key", "releaseRequest", "requestKey", "releaseResource", "BatchImageDecodeInfo", "DecodeTask", "ErrCode", "ImageDecodeInfo", "Status", "plugin-scan_release"})
public final class w
{
  public static final HashMap<Long, v> fWm;
  public static final HashMap<Long, ScanGoodsRequest> wZF;
  private static final ConcurrentHashMap<String, Bitmap> wZG;
  public static final ConcurrentHashMap<String, Boolean> wZH;
  public static final w wZI;
  
  static
  {
    AppMethodBeat.i(199600);
    wZI = new w();
    fWm = new HashMap();
    wZF = new HashMap();
    wZG = new ConcurrentHashMap();
    wZH = new ConcurrentHashMap();
    AppMethodBeat.o(199600);
  }
  
  public static long a(ScanGoodsRequest paramScanGoodsRequest, v paramv)
  {
    AppMethodBeat.i(199595);
    if (paramScanGoodsRequest == null)
    {
      AppMethodBeat.o(199595);
      return -1L;
    }
    if (!paramScanGoodsRequest.isValid())
    {
      ac.e("MicroMsg.ScanGoodsResourceManager", "alvinluo prepare request not valid");
      AppMethodBeat.o(199595);
      return -1L;
    }
    final long l = System.currentTimeMillis();
    ac.i("MicroMsg.ScanGoodsResourceManager", "alvinluo loadResource requestId: %d", new Object[] { Long.valueOf(l) });
    ((Map)fWm).put(Long.valueOf(l), paramv);
    ((Map)wZF).put(Long.valueOf(l), paramScanGoodsRequest);
    h.JZN.h((Runnable)new e(paramScanGoodsRequest, l), "ScanResourceTag");
    AppMethodBeat.o(199595);
    return l;
  }
  
  public static String a(ScanGoodsRequest paramScanGoodsRequest)
  {
    AppMethodBeat.i(199599);
    z localz = z.KUT;
    paramScanGoodsRequest = String.format("deco:%s,succ:%s,tips:%s", Arrays.copyOf(new Object[] { paramScanGoodsRequest.wWd, paramScanGoodsRequest.wWe, paramScanGoodsRequest.wWf }, 3));
    k.g(paramScanGoodsRequest, "java.lang.String.format(format, *args)");
    AppMethodBeat.o(199599);
    return paramScanGoodsRequest;
  }
  
  public static Bitmap arF(String paramString)
  {
    AppMethodBeat.i(199596);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(199596);
      return null;
    }
    paramString = (Bitmap)wZG.get(paramString);
    AppMethodBeat.o(199596);
    return paramString;
  }
  
  private static void arG(String paramString)
  {
    AppMethodBeat.i(199598);
    Bitmap localBitmap = (Bitmap)wZG.get(paramString);
    if (localBitmap != null) {
      localBitmap.recycle();
    }
    wZG.remove(paramString);
    AppMethodBeat.o(199598);
  }
  
  private static void f(long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(199597);
    v localv = (v)fWm.get(Long.valueOf(paramLong));
    if (localv != null) {
      localv.bQ(paramInt, paramString);
    }
    fWm.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(199597);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$BatchImageDecodeInfo;", "", "requestId", "", "imageList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$ImageDecodeInfo;", "Lkotlin/collections/ArrayList;", "(JLjava/util/ArrayList;)V", "errMsg", "", "getErrMsg", "()Ljava/lang/String;", "setErrMsg", "(Ljava/lang/String;)V", "getImageList", "()Ljava/util/ArrayList;", "getRequestId", "()J", "result", "", "getResult", "()I", "setResult", "(I)V", "status", "getStatus", "setStatus", "checkFinish", "", "checkResult", "fillErrMsg", "", "plugin-scan_release"})
  static final class a
  {
    String errMsg;
    int result;
    int status;
    final long vVK;
    final ArrayList<w.c> wnH;
    
    public a(long paramLong, ArrayList<w.c> paramArrayList)
    {
      AppMethodBeat.i(199585);
      this.vVK = paramLong;
      this.wnH = paramArrayList;
      this.result = -1;
      this.errMsg = "";
      AppMethodBeat.o(199585);
    }
    
    public final void dzG()
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$DecodeTask;", "Ljava/lang/Runnable;", "info", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$ImageDecodeInfo;", "callback", "Lkotlin/Function2;", "Landroid/graphics/Bitmap;", "", "(Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$ImageDecodeInfo;Lkotlin/jvm/functions/Function2;)V", "getCallback", "()Lkotlin/jvm/functions/Function2;", "getInfo", "()Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$ImageDecodeInfo;", "doDecodeImage", "finishDecode", "bitmap", "run", "startDecode", "plugin-scan_release"})
  static final class b
    implements Runnable
  {
    private final m<w.c, Bitmap, y> fPF;
    private final w.c wZJ;
    
    public b(w.c paramc, m<? super w.c, ? super Bitmap, y> paramm)
    {
      AppMethodBeat.i(199589);
      this.wZJ = paramc;
      this.fPF = paramm;
      AppMethodBeat.o(199589);
    }
    
    private static Bitmap a(w.c paramc)
    {
      Integer localInteger = null;
      AppMethodBeat.i(199588);
      if (!com.tencent.mm.vfs.i.eA(paramc.imagePath))
      {
        paramc.result = 2;
        a(paramc, null);
        AppMethodBeat.o(199588);
        return null;
      }
      for (;;)
      {
        try
        {
          localBitmap = f.decodeFile(paramc.imagePath);
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
              ac.d("MicroMsg.ScanGoodsResourceManager", "alvinluo decodeImage filePath: %s, decode result: %d, bitmap: %s", new Object[] { str, Integer.valueOf(i), localInteger });
              a(paramc, localBitmap);
              AppMethodBeat.o(199588);
              return localBitmap;
            }
            paramc.result = 3;
            continue;
            ac.printErrStackTrace("MicroMsg.ScanGoodsResourceManager", (Throwable)localException1, "alvinluo decodeImage exception", new Object[0]);
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
    
    private static void a(w.c paramc, Bitmap paramBitmap)
    {
      AppMethodBeat.i(199587);
      paramc.status = 2;
      if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
      {
        w localw = w.wZI;
        ((Map)w.dzE()).put(paramc.imagePath, paramBitmap);
      }
      ac.d("MicroMsg.ScanGoodsResourceManager", "alvinluo finishDecode image: %s, status: %d, result: %d", new Object[] { paramc.imagePath, Integer.valueOf(paramc.status), Integer.valueOf(paramc.result) });
      AppMethodBeat.o(199587);
    }
    
    public final void run()
    {
      AppMethodBeat.i(199586);
      ac.d("MicroMsg.ScanGoodsResourceManager", "alvinluo startDecode image: %s", new Object[] { this.wZJ.imagePath });
      this.wZJ.status = 1;
      this.fPF.n(this.wZJ, a(this.wZJ));
      AppMethodBeat.o(199586);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$ImageDecodeInfo;", "", "imagePath", "", "(Ljava/lang/String;)V", "getImagePath", "()Ljava/lang/String;", "result", "", "getResult", "()I", "setResult", "(I)V", "status", "getStatus", "setStatus", "plugin-scan_release"})
  static final class c
  {
    final String imagePath;
    int result;
    int status;
    
    public c(String paramString)
    {
      AppMethodBeat.i(199590);
      this.imagePath = paramString;
      this.result = -1;
      AppMethodBeat.o(199590);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "decodeInfo", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$ImageDecodeInfo;", "bitmap", "Landroid/graphics/Bitmap;", "invoke", "com/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$batchDecodeImage$1$1"})
  static final class d
    extends d.g.b.l
    implements m<w.c, Bitmap, y>
  {
    d(v.a parama, w.a parama1)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(ScanGoodsRequest paramScanGoodsRequest, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(199593);
      Object localObject = w.wZI;
      localObject = w.b(this.wZN);
      w localw = w.wZI;
      if (w.dzF().containsKey(localObject))
      {
        ac.i("MicroMsg.ScanGoodsResourceManager", "alvinluo loadResource set can not release");
        localw = w.wZI;
        ((Map)w.dzF()).put(localObject, Boolean.FALSE);
      }
      localObject = w.wZI;
      localObject = w.a(l, this.wZN);
      localw = w.wZI;
      w.a((w.a)localObject);
      AppMethodBeat.o(199593);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  public static final class f
    implements Runnable
  {
    public f(String paramString, ScanGoodsRequest paramScanGoodsRequest) {}
    
    public final void run()
    {
      AppMethodBeat.i(199594);
      w localw = w.wZI;
      if (k.g((Boolean)w.dzF().get(this.kdj), Boolean.TRUE))
      {
        localw = w.wZI;
        w.a(this.kdj, this.wZN);
        AppMethodBeat.o(199594);
        return;
      }
      ac.d("MicroMsg.ScanGoodsResourceManager", "alvinluo releaseResource not need to release requestKey: %s", new Object[] { this.kdj });
      AppMethodBeat.o(199594);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.w
 * JD-Core Version:    0.7.0.1
 */