package com.tencent.mm.plugin.scanner.model;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.am;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager;", "", "()V", "SCAN_RESOURCE_LOOP_TAG", "", "SCAN_RESOURCE_RELEASE_DELAY_MS", "", "TAG", "bitmapCache", "Ljava/util/concurrent/ConcurrentHashMap;", "Landroid/graphics/Bitmap;", "cachedRequest", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/scanner/api/ScanGoodsRequest;", "Lkotlin/collections/HashMap;", "callbackMap", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceLoadCallback;", "pendingReleaseRequestSet", "", "batchDecodeImage", "", "batchImageDecodeInfo", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$BatchImageDecodeInfo;", "getBatchImageDecodeInfo", "requestId", "request", "getRequestKey", "getResource", "imagePath", "loadResource", "callback", "onCallback", "errCode", "", "errMsg", "releaseBitmap", "key", "releaseRequest", "requestKey", "releaseResource", "BatchImageDecodeInfo", "DecodeTask", "ErrCode", "ImageDecodeInfo", "Status", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ag
{
  public static final ag OSF;
  private static final HashMap<Long, ScanGoodsRequest> OSG;
  private static final ConcurrentHashMap<String, Bitmap> OSH;
  private static final ConcurrentHashMap<String, Boolean> OSI;
  private static final HashMap<Long, af> mnT;
  
  static
  {
    AppMethodBeat.i(314280);
    OSF = new ag();
    mnT = new HashMap();
    OSG = new HashMap();
    OSH = new ConcurrentHashMap();
    OSI = new ConcurrentHashMap();
    AppMethodBeat.o(314280);
  }
  
  public static long a(ScanGoodsRequest paramScanGoodsRequest, af paramaf)
  {
    AppMethodBeat.i(314229);
    if (paramScanGoodsRequest == null)
    {
      AppMethodBeat.o(314229);
      return -1L;
    }
    if (!paramScanGoodsRequest.isValid())
    {
      Log.e("MicroMsg.ScanGoodsResourceManager", "alvinluo prepare request not valid");
      AppMethodBeat.o(314229);
      return -1L;
    }
    long l = System.currentTimeMillis();
    Log.i("MicroMsg.ScanGoodsResourceManager", "alvinluo loadResource requestId: %d", new Object[] { Long.valueOf(l) });
    ((Map)mnT).put(Long.valueOf(l), paramaf);
    ((Map)OSG).put(Long.valueOf(l), paramScanGoodsRequest);
    h.ahAA.j(new ag..ExternalSyntheticLambda0(paramScanGoodsRequest, l), "ScanResourceTag");
    AppMethodBeat.o(314229);
    return l;
  }
  
  private static final void a(ScanGoodsRequest paramScanGoodsRequest, long paramLong)
  {
    AppMethodBeat.i(314268);
    Object localObject = c(paramScanGoodsRequest);
    if (OSI.containsKey(localObject))
    {
      Log.i("MicroMsg.ScanGoodsResourceManager", "alvinluo loadResource set can not release");
      ((Map)OSI).put(localObject, Boolean.FALSE);
    }
    localObject = new ArrayList();
    String str = paramScanGoodsRequest.OMA;
    s.s(str, "request.decorationImagePath");
    ((ArrayList)localObject).add(new c(str));
    str = paramScanGoodsRequest.OMB;
    s.s(str, "request.successImagePath");
    ((ArrayList)localObject).add(new c(str));
    paramScanGoodsRequest = paramScanGoodsRequest.OMC;
    s.s(paramScanGoodsRequest, "request.scanTipsImagePath");
    ((ArrayList)localObject).add(new c(paramScanGoodsRequest));
    a(new a(paramLong, (ArrayList)localObject));
    AppMethodBeat.o(314268);
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(314249);
    Log.i("MicroMsg.ScanGoodsResourceManager", "batchDecodeImage start");
    Iterator localIterator = ((Iterable)parama.NEX).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      Bitmap localBitmap = (Bitmap)OSH.get(localc.imagePath);
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        Log.v("MicroMsg.ScanGoodsResourceManager", "alvinluo batchDecodeImage imagePath: %s, exist bitmap", new Object[] { localc.imagePath });
        localc.status = 2;
        localc.result = 0;
      }
      else
      {
        h.ahAA.bo((Runnable)new b(localc, (m)new d(parama)));
        i = 1;
      }
    }
    if (i == 0)
    {
      Log.i("MicroMsg.ScanGoodsResourceManager", "alvinluo batchDecodeImage use cache no need to decode");
      g(parama.Bjl, 0, "ok");
    }
    AppMethodBeat.o(314249);
  }
  
  private static final void a(String paramString, ScanGoodsRequest paramScanGoodsRequest)
  {
    AppMethodBeat.i(314273);
    s.u(paramString, "$key");
    if (s.p(OSI.get(paramString), Boolean.TRUE))
    {
      Log.i("MicroMsg.ScanGoodsResourceManager", "alvinluo releaseResource requestKey: %s", new Object[] { paramString });
      OSI.remove(paramString);
      paramString = paramScanGoodsRequest.OMA;
      s.s(paramString, "request.decorationImagePath");
      aUK(paramString);
      paramString = paramScanGoodsRequest.OMB;
      s.s(paramString, "request.successImagePath");
      aUK(paramString);
      paramString = paramScanGoodsRequest.OMC;
      s.s(paramString, "request.scanTipsImagePath");
      aUK(paramString);
      AppMethodBeat.o(314273);
      return;
    }
    Log.d("MicroMsg.ScanGoodsResourceManager", "alvinluo releaseResource not need to release requestKey: %s", new Object[] { paramString });
    AppMethodBeat.o(314273);
  }
  
  public static Bitmap aUJ(String paramString)
  {
    AppMethodBeat.i(314234);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(314234);
      return null;
    }
    paramString = (Bitmap)OSH.get(paramString);
    AppMethodBeat.o(314234);
    return paramString;
  }
  
  private static void aUK(String paramString)
  {
    AppMethodBeat.i(314261);
    Bitmap localBitmap = (Bitmap)OSH.get(paramString);
    if (localBitmap != null) {
      localBitmap.recycle();
    }
    OSH.remove(paramString);
    AppMethodBeat.o(314261);
  }
  
  private static String c(ScanGoodsRequest paramScanGoodsRequest)
  {
    AppMethodBeat.i(314265);
    am localam = am.aixg;
    paramScanGoodsRequest = String.format("deco:%s,succ:%s,tips:%s", Arrays.copyOf(new Object[] { paramScanGoodsRequest.OMA, paramScanGoodsRequest.OMB, paramScanGoodsRequest.OMC }, 3));
    s.s(paramScanGoodsRequest, "java.lang.String.format(format, *args)");
    AppMethodBeat.o(314265);
    return paramScanGoodsRequest;
  }
  
  private static void g(long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(314258);
    af localaf = (af)mnT.get(Long.valueOf(paramLong));
    if (localaf != null) {
      localaf.cX(paramInt, paramString);
    }
    mnT.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(314258);
  }
  
  public static void tW(long paramLong)
  {
    AppMethodBeat.i(314241);
    ScanGoodsRequest localScanGoodsRequest = (ScanGoodsRequest)OSG.get(Long.valueOf(paramLong));
    OSG.remove(Long.valueOf(paramLong));
    mnT.remove(Long.valueOf(paramLong));
    if (localScanGoodsRequest == null)
    {
      AppMethodBeat.o(314241);
      return;
    }
    Log.d("MicroMsg.ScanGoodsResourceManager", "alvinluo releaseResource requestId: %s", new Object[] { Long.valueOf(paramLong) });
    String str = c(localScanGoodsRequest);
    ((Map)OSI).put(str, Boolean.TRUE);
    h.ahAA.b(new ag..ExternalSyntheticLambda1(str, localScanGoodsRequest), 10000L, "ScanResourceTag");
    AppMethodBeat.o(314241);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$BatchImageDecodeInfo;", "", "requestId", "", "imageList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$ImageDecodeInfo;", "Lkotlin/collections/ArrayList;", "(JLjava/util/ArrayList;)V", "errMsg", "", "getErrMsg", "()Ljava/lang/String;", "setErrMsg", "(Ljava/lang/String;)V", "getImageList", "()Ljava/util/ArrayList;", "getRequestId", "()J", "result", "", "getResult", "()I", "setResult", "(I)V", "status", "getStatus", "setStatus", "checkFinish", "", "checkResult", "fillErrMsg", "", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
  {
    final long Bjl;
    final ArrayList<ag.c> NEX;
    String errMsg;
    int result;
    int status;
    
    public a(long paramLong, ArrayList<ag.c> paramArrayList)
    {
      AppMethodBeat.i(314336);
      this.Bjl = paramLong;
      this.NEX = paramArrayList;
      this.result = -1;
      this.errMsg = "";
      AppMethodBeat.o(314336);
    }
    
    public final void gRm()
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
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$DecodeTask;", "Ljava/lang/Runnable;", "info", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$ImageDecodeInfo;", "callback", "Lkotlin/Function2;", "Landroid/graphics/Bitmap;", "", "(Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$ImageDecodeInfo;Lkotlin/jvm/functions/Function2;)V", "getCallback", "()Lkotlin/jvm/functions/Function2;", "getInfo", "()Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$ImageDecodeInfo;", "doDecodeImage", "finishDecode", "bitmap", "run", "startDecode", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class b
    implements Runnable
  {
    private final ag.c OSJ;
    private final m<ag.c, Bitmap, ah> mgM;
    
    public b(ag.c paramc, m<? super ag.c, ? super Bitmap, ah> paramm)
    {
      AppMethodBeat.i(314334);
      this.OSJ = paramc;
      this.mgM = paramm;
      AppMethodBeat.o(314334);
    }
    
    private static Bitmap a(ag.c paramc)
    {
      Object localObject = null;
      AppMethodBeat.i(314344);
      if (!y.ZC(paramc.imagePath))
      {
        paramc.result = 2;
        a(paramc, null);
        AppMethodBeat.o(314344);
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
                continue;
              }
              Log.d("MicroMsg.ScanGoodsResourceManager", "alvinluo decodeImage filePath: %s, decode result: %d, bitmap: %s", new Object[] { str, Integer.valueOf(i), localObject });
              a(paramc, localBitmap);
              AppMethodBeat.o(314344);
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
          int j;
          Integer localInteger;
          Bitmap localBitmap = null;
          continue;
        }
        paramc.result = 3;
        continue;
        j = localBitmap.getAllocationByteCount();
        localInteger = Integer.valueOf(j);
      }
    }
    
    private static void a(ag.c paramc, Bitmap paramBitmap)
    {
      AppMethodBeat.i(314340);
      paramc.status = 2;
      if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
        ((Map)ag.gRl()).put(paramc.imagePath, paramBitmap);
      }
      Log.d("MicroMsg.ScanGoodsResourceManager", "alvinluo finishDecode image: %s, status: %d, result: %d", new Object[] { paramc.imagePath, Integer.valueOf(paramc.status), Integer.valueOf(paramc.result) });
      AppMethodBeat.o(314340);
    }
    
    public final void run()
    {
      AppMethodBeat.i(314348);
      Log.d("MicroMsg.ScanGoodsResourceManager", "alvinluo startDecode image: %s", new Object[] { this.OSJ.imagePath });
      this.OSJ.status = 1;
      this.mgM.invoke(this.OSJ, a(this.OSJ));
      AppMethodBeat.o(314348);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$ImageDecodeInfo;", "", "imagePath", "", "(Ljava/lang/String;)V", "getImagePath", "()Ljava/lang/String;", "result", "", "getResult", "()I", "setResult", "(I)V", "status", "getStatus", "setStatus", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class c
  {
    final String imagePath;
    int result;
    int status;
    
    public c(String paramString)
    {
      AppMethodBeat.i(314349);
      this.imagePath = paramString;
      this.result = -1;
      AppMethodBeat.o(314349);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "decodeInfo", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$ImageDecodeInfo;", "bitmap", "Landroid/graphics/Bitmap;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements m<ag.c, Bitmap, ah>
  {
    d(ag.a parama)
    {
      super();
    }
    
    private static final void b(ag.a parama)
    {
      AppMethodBeat.i(314347);
      s.u(parama, "$batchImageDecodeInfo");
      ag localag = ag.OSF;
      ag.h(parama.Bjl, parama.result, parama.errMsg);
      AppMethodBeat.o(314347);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.ag
 * JD-Core Version:    0.7.0.1
 */