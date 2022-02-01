package com.tencent.mm.plugin.scanner.model;

import android.graphics.Bitmap;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.a.m;
import kotlin.g.b.aa.a;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager;", "", "()V", "SCAN_RESOURCE_LOOP_TAG", "", "SCAN_RESOURCE_RELEASE_DELAY_MS", "", "TAG", "bitmapCache", "Ljava/util/concurrent/ConcurrentHashMap;", "Landroid/graphics/Bitmap;", "cachedRequest", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/scanner/api/ScanGoodsRequest;", "Lkotlin/collections/HashMap;", "callbackMap", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceLoadCallback;", "pendingReleaseRequestSet", "", "batchDecodeImage", "", "batchImageDecodeInfo", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$BatchImageDecodeInfo;", "getBatchImageDecodeInfo", "requestId", "request", "getRequestKey", "getResource", "imagePath", "loadResource", "callback", "onCallback", "errCode", "", "errMsg", "releaseBitmap", "key", "releaseRequest", "requestKey", "releaseResource", "BatchImageDecodeInfo", "DecodeTask", "ErrCode", "ImageDecodeInfo", "Status", "plugin-scan_release"})
public final class z
{
  public static final HashMap<Long, ScanGoodsRequest> ILD;
  private static final ConcurrentHashMap<String, Bitmap> ILE;
  public static final ConcurrentHashMap<String, Boolean> ILF;
  public static final z ILG;
  public static final HashMap<Long, y> jPb;
  
  static
  {
    AppMethodBeat.i(223571);
    ILG = new z();
    jPb = new HashMap();
    ILD = new HashMap();
    ILE = new ConcurrentHashMap();
    ILF = new ConcurrentHashMap();
    AppMethodBeat.o(223571);
  }
  
  public static long a(ScanGoodsRequest paramScanGoodsRequest, y paramy)
  {
    AppMethodBeat.i(223550);
    if (paramScanGoodsRequest == null)
    {
      AppMethodBeat.o(223550);
      return -1L;
    }
    if (!paramScanGoodsRequest.isValid())
    {
      Log.e("MicroMsg.ScanGoodsResourceManager", "alvinluo prepare request not valid");
      AppMethodBeat.o(223550);
      return -1L;
    }
    final long l = System.currentTimeMillis();
    Log.i("MicroMsg.ScanGoodsResourceManager", "alvinluo loadResource requestId: %d", new Object[] { Long.valueOf(l) });
    ((Map)jPb).put(Long.valueOf(l), paramy);
    ((Map)ILD).put(Long.valueOf(l), paramScanGoodsRequest);
    h.ZvG.g((Runnable)new e(paramScanGoodsRequest, l), "ScanResourceTag");
    AppMethodBeat.o(223550);
    return l;
  }
  
  public static Bitmap aXf(String paramString)
  {
    AppMethodBeat.i(223553);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(223553);
      return null;
    }
    paramString = (Bitmap)ILE.get(paramString);
    AppMethodBeat.o(223553);
    return paramString;
  }
  
  private static void aXg(String paramString)
  {
    AppMethodBeat.i(223559);
    Bitmap localBitmap = (Bitmap)ILE.get(paramString);
    if (localBitmap != null) {
      localBitmap.recycle();
    }
    ILE.remove(paramString);
    AppMethodBeat.o(223559);
  }
  
  public static String c(ScanGoodsRequest paramScanGoodsRequest)
  {
    AppMethodBeat.i(223565);
    af localaf = af.aaBG;
    paramScanGoodsRequest = String.format("deco:%s,succ:%s,tips:%s", Arrays.copyOf(new Object[] { paramScanGoodsRequest.IGs, paramScanGoodsRequest.IGt, paramScanGoodsRequest.IGu }, 3));
    p.j(paramScanGoodsRequest, "java.lang.String.format(format, *args)");
    AppMethodBeat.o(223565);
    return paramScanGoodsRequest;
  }
  
  private static void f(long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(223557);
    y localy = (y)jPb.get(Long.valueOf(paramLong));
    if (localy != null) {
      localy.cm(paramInt, paramString);
    }
    jPb.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(223557);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$BatchImageDecodeInfo;", "", "requestId", "", "imageList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$ImageDecodeInfo;", "Lkotlin/collections/ArrayList;", "(JLjava/util/ArrayList;)V", "errMsg", "", "getErrMsg", "()Ljava/lang/String;", "setErrMsg", "(Ljava/lang/String;)V", "getImageList", "()Ljava/util/ArrayList;", "getRequestId", "()J", "result", "", "getResult", "()I", "setResult", "(I)V", "status", "getStatus", "setStatus", "checkFinish", "", "checkResult", "fillErrMsg", "", "plugin-scan_release"})
  static final class a
  {
    final ArrayList<z.c> HHJ;
    String errMsg;
    int result;
    int status;
    final long yjR;
    
    public a(long paramLong, ArrayList<z.c> paramArrayList)
    {
      AppMethodBeat.i(219060);
      this.yjR = paramLong;
      this.HHJ = paramArrayList;
      this.result = -1;
      this.errMsg = "";
      AppMethodBeat.o(219060);
    }
    
    public final void fDb()
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$DecodeTask;", "Ljava/lang/Runnable;", "info", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$ImageDecodeInfo;", "callback", "Lkotlin/Function2;", "Landroid/graphics/Bitmap;", "", "(Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$ImageDecodeInfo;Lkotlin/jvm/functions/Function2;)V", "getCallback", "()Lkotlin/jvm/functions/Function2;", "getInfo", "()Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$ImageDecodeInfo;", "doDecodeImage", "finishDecode", "bitmap", "run", "startDecode", "plugin-scan_release"})
  static final class b
    implements Runnable
  {
    private final z.c ILH;
    private final m<z.c, Bitmap, x> jHk;
    
    public b(z.c paramc, m<? super z.c, ? super Bitmap, x> paramm)
    {
      AppMethodBeat.i(221552);
      this.ILH = paramc;
      this.jHk = paramm;
      AppMethodBeat.o(221552);
    }
    
    private static Bitmap a(z.c paramc)
    {
      Integer localInteger = null;
      AppMethodBeat.i(221550);
      if (!u.agG(paramc.imagePath))
      {
        paramc.result = 2;
        a(paramc, null);
        AppMethodBeat.o(221550);
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
              AppMethodBeat.o(221550);
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
    
    private static void a(z.c paramc, Bitmap paramBitmap)
    {
      AppMethodBeat.i(221544);
      paramc.status = 2;
      if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
      {
        z localz = z.ILG;
        ((Map)z.fCZ()).put(paramc.imagePath, paramBitmap);
      }
      Log.d("MicroMsg.ScanGoodsResourceManager", "alvinluo finishDecode image: %s, status: %d, result: %d", new Object[] { paramc.imagePath, Integer.valueOf(paramc.status), Integer.valueOf(paramc.result) });
      AppMethodBeat.o(221544);
    }
    
    public final void run()
    {
      AppMethodBeat.i(221540);
      Log.d("MicroMsg.ScanGoodsResourceManager", "alvinluo startDecode image: %s", new Object[] { this.ILH.imagePath });
      this.ILH.status = 1;
      this.jHk.invoke(this.ILH, a(this.ILH));
      AppMethodBeat.o(221540);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$ImageDecodeInfo;", "", "imagePath", "", "(Ljava/lang/String;)V", "getImagePath", "()Ljava/lang/String;", "result", "", "getResult", "()I", "setResult", "(I)V", "status", "getStatus", "setStatus", "plugin-scan_release"})
  static final class c
  {
    final String imagePath;
    int result;
    int status;
    
    public c(String paramString)
    {
      AppMethodBeat.i(219900);
      this.imagePath = paramString;
      this.result = -1;
      AppMethodBeat.o(219900);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "decodeInfo", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$ImageDecodeInfo;", "bitmap", "Landroid/graphics/Bitmap;", "invoke", "com/tencent/mm/plugin/scanner/model/ScanGoodsResourceManager$batchDecodeImage$1$1"})
  static final class d
    extends q
    implements m<z.c, Bitmap, x>
  {
    d(aa.a parama, z.a parama1)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(ScanGoodsRequest paramScanGoodsRequest, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(219313);
      Object localObject = z.ILG;
      localObject = z.d(this.ILL);
      z localz = z.ILG;
      if (z.fDa().containsKey(localObject))
      {
        Log.i("MicroMsg.ScanGoodsResourceManager", "alvinluo loadResource set can not release");
        localz = z.ILG;
        ((Map)z.fDa()).put(localObject, Boolean.FALSE);
      }
      localObject = z.ILG;
      localObject = z.a(l, this.ILL);
      localz = z.ILG;
      z.a((z.a)localObject);
      AppMethodBeat.o(219313);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  public static final class f
    implements Runnable
  {
    public f(String paramString, ScanGoodsRequest paramScanGoodsRequest) {}
    
    public final void run()
    {
      AppMethodBeat.i(218050);
      z localz = z.ILG;
      if (p.h((Boolean)z.fDa().get(this.$key), Boolean.TRUE))
      {
        localz = z.ILG;
        z.a(this.$key, this.ILL);
        AppMethodBeat.o(218050);
        return;
      }
      Log.d("MicroMsg.ScanGoodsResourceManager", "alvinluo releaseResource not need to release requestKey: %s", new Object[] { this.$key });
      AppMethodBeat.o(218050);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.z
 * JD-Core Version:    0.7.0.1
 */