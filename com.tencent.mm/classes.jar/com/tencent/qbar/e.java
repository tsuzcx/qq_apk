package com.tencent.qbar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.scanner.util.a.d;
import com.tencent.mm.plugin.scanner.util.a.i;
import com.tencent.mm.sdk.platformtools.FilesCopy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import com.tencent.scanlib.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class e
{
  private static e ahrg;
  private static i ahrk;
  private static int pvg;
  private static int sJv;
  private Object GXz;
  private ExecutorService OOq;
  private Map<Long, String> ahrh;
  private Map<Long, e.b> ahri;
  private Map<String, List<Long>> ahrj;
  private g rQG;
  
  static
  {
    AppMethodBeat.i(91156);
    ahrg = new e();
    sJv = 0;
    pvg = 0;
    ahrk = null;
    AppMethodBeat.o(91156);
  }
  
  private e()
  {
    AppMethodBeat.i(91154);
    this.ahrh = new HashMap();
    this.ahri = new HashMap();
    this.ahrj = new HashMap();
    this.GXz = new Object();
    this.rQG = new g("WxFileDecodeQueue");
    this.OOq = Executors.newSingleThreadExecutor();
    this.rQG.Oq(((com.tencent.mm.plugin.scanner.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.scanner.api.c.class)).gPB());
    AppMethodBeat.o(91154);
  }
  
  private static void bFr(String paramString)
  {
    AppMethodBeat.i(226824);
    u localu;
    try
    {
      if (Util.isNullOrNil(paramString))
      {
        Log.e("WxFileDecodeQueue", "ensureParentDirExists  destFilePath is empty");
        AppMethodBeat.o(226824);
        return;
      }
      localu = new u(paramString).jKP();
      if (localu == null)
      {
        Log.e("WxFileDecodeQueue", "ensureParentDirExists  parentFile == null, destFilePath: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(226824);
        return;
      }
      if ((!localu.jKS()) || (!localu.isDirectory()))
      {
        boolean bool = localu.jKY();
        Log.w("WxFileDecodeQueue", "ensureParentDirExists  do make dir , parentFile: %s, exists : %b, result: %bisDirectory: %b", new Object[] { ah.v(localu.jKT()), Boolean.valueOf(localu.jKS()), Boolean.valueOf(localu.isDirectory()), Boolean.valueOf(bool) });
        AppMethodBeat.o(226824);
        return;
      }
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("WxFileDecodeQueue", paramString, "ensureParentDirExists", new Object[0]);
      AppMethodBeat.o(226824);
      return;
    }
    Log.i("WxFileDecodeQueue", "ensureParentDirExists parentFile is exists: ".concat(String.valueOf(localu)));
    AppMethodBeat.o(226824);
  }
  
  public static e jWN()
  {
    return ahrg;
  }
  
  private static boolean l(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(226821);
    try
    {
      if (!y.ZC(paramString2))
      {
        bFr(paramString2);
        FilesCopy.copyAssets(paramContext, paramString1, paramString2);
        paramContext = y.bub(paramString2);
        Log.w("WxFileDecodeQueue", "ensureFileComplete file not exists, srcAssetFilePath: %s, destFilePath: %s, targetMD5: %s, fileMD5: %s", new Object[] { paramString1, paramString2, paramString3, paramContext });
        boolean bool = paramString3.equalsIgnoreCase(paramContext);
        AppMethodBeat.o(226821);
        return bool;
      }
      String str = y.bub(paramString2);
      if (paramString3.equalsIgnoreCase(str))
      {
        Log.i("WxFileDecodeQueue", "ensureFileComplete file is complete, srcAssetFilePath: %s, destFilePath: %s, targetMD5: %s, fileMD5: %s", new Object[] { paramString1, paramString2, paramString3, str });
        AppMethodBeat.o(226821);
        return true;
      }
      y.deleteFile(paramString2);
      bFr(paramString2);
      FilesCopy.copyAssets(paramContext, paramString1, paramString2);
      paramContext = y.bub(paramString2);
      if (paramString3.equalsIgnoreCase(paramContext))
      {
        Log.w("WxFileDecodeQueue", "ensureFileComplete copy file is complete, srcAssetFilePath: %s, destFilePath: %s, targetMD5: %s, copyFileMD5: %s", new Object[] { paramString1, paramString2, paramString3, paramContext });
        AppMethodBeat.o(226821);
        return true;
      }
      Log.e("WxFileDecodeQueue", "ensureFileComplete copy file fail, srcAssetFilePath: %s, destFilePath: %s, targetMD5: %s, copyFileMD5: %s", new Object[] { paramString1, paramString2, paramString3, paramContext });
      AppMethodBeat.o(226821);
      return false;
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("WxFileDecodeQueue", paramContext, "ensureFileComplete", new Object[0]);
      AppMethodBeat.o(226821);
    }
    return false;
  }
  
  private static void nX(Context paramContext)
  {
    AppMethodBeat.i(226818);
    if (!com.tencent.mm.plugin.scanner.util.e.gTY())
    {
      AppMethodBeat.o(226818);
      return;
    }
    String str1 = b.og(paramContext);
    String str2 = b.oh(paramContext);
    String str3 = b.oi(paramContext);
    String str4 = b.oj(paramContext);
    String str5 = b.ok(paramContext);
    String str6 = b.ol(paramContext);
    for (;;)
    {
      try
      {
        Log.i("WxFileDecodeQueue", "checkAndCopyAIModelFileIfNeed detectModelBinPath: %s, detectModelParamPath: %s, superResolutionBinPathForNCNN: %s, superResolutionParamPathForNCNN: %s, superResolutionBinPathForXNet: %s, superResolutionParamPathForXNet: %s", new Object[] { str1, str2, str3, str4, str5, str6 });
        if (!Util.isNullOrNil(str1))
        {
          l(paramContext, "qbar/detect_model.bin", str1, "3e7d672cff2fc5b6fa6e02be6f8337c5");
          if (Util.isNullOrNil(str2)) {
            break label247;
          }
          l(paramContext, "qbar/detect_model.param", str2, "754df8e400bd1da9d11a14c375f36089");
          if (Util.isNullOrNil(str3)) {
            break label258;
          }
          l(paramContext, "qbar/srnet.bin", str3, "c8feca3c0512706ab3c62c11055f2819");
          if (Util.isNullOrNil(str4)) {
            break label269;
          }
          l(paramContext, "qbar/srnet.param", str4, "c1ca8996b77cbd3d69d90d04e6ffe147");
          if (Util.isNullOrNil(str5)) {
            break label280;
          }
          l(paramContext, "qbar/detect_model_fp16.xnet", str5, "90aaacd53fa06e2b64a0f70a86e84c21");
          if (Util.isNullOrNil(str6)) {
            break;
          }
          l(paramContext, "qbar/sr_fp16.xnet", str6, "913cfdbdab7d9496b97ec7fba5f8b84a");
          AppMethodBeat.o(226818);
          return;
        }
      }
      catch (Exception paramContext)
      {
        Log.printErrStackTrace("WxFileDecodeQueue", paramContext, "", new Object[0]);
        AppMethodBeat.o(226818);
        return;
      }
      Log.e("WxFileDecodeQueue", "checkAndCopyAIModelFileIfNeed detectModelBinPath is empty");
      continue;
      label247:
      Log.e("WxFileDecodeQueue", "checkAndCopyAIModelFileIfNeed detectModelParamPath is empty");
      continue;
      label258:
      Log.e("WxFileDecodeQueue", "checkAndCopyAIModelFileIfNeed superResolutionBinPathForNCNN is empty");
      continue;
      label269:
      Log.e("WxFileDecodeQueue", "checkAndCopyAIModelFileIfNeed superResolutionParamPathForNCNN is empty");
      continue;
      label280:
      Log.e("WxFileDecodeQueue", "checkAndCopyAIModelFileIfNeed superResolutionBinPathForXNet is empty");
    }
    Log.e("WxFileDecodeQueue", "checkAndCopyAIModelFileIfNeed superResolutionParamPathForXNet is empty");
    AppMethodBeat.o(226818);
  }
  
  public final void a(Context paramContext, long paramLong, String paramString, Bitmap paramBitmap, e.b paramb, int[] paramArrayOfInt, e.c paramc)
  {
    AppMethodBeat.i(226835);
    synchronized (this.GXz)
    {
      com.tencent.mm.plugin.scanner.util.e.jB(paramContext);
      int i = this.ahrh.size();
      if (i < 9)
      {
        Log.i("WxFileDecodeQueue", "addDecodeTask submit decode task %d, fileMap: %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(i) });
        this.ahrh.put(Long.valueOf(paramLong), paramString);
        if (paramb != null) {
          this.ahri.put(Long.valueOf(paramLong), paramb);
        }
        if (!this.ahrj.containsKey(paramString))
        {
          this.ahrj.put(paramString, new ArrayList());
          paramb = b.oe(paramContext);
          nX(paramContext);
          this.OOq.execute(new a(paramString, paramBitmap, paramb, paramArrayOfInt, paramc));
        }
        ((List)this.ahrj.get(paramString)).add(Long.valueOf(paramLong));
        AppMethodBeat.o(226835);
        return;
      }
      Log.w("WxFileDecodeQueue", "too many files are waiting and ignore: %d", new Object[] { Long.valueOf(paramLong) });
      paramb.a(paramLong, null);
    }
  }
  
  public final void a(Context paramContext, long paramLong, String paramString, e.b paramb)
  {
    AppMethodBeat.i(226837);
    a(paramContext, paramLong, paramString, paramb, new int[] { 0 });
    AppMethodBeat.o(226837);
  }
  
  public final void a(Context paramContext, long paramLong, String paramString, e.b paramb, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(226836);
    a(paramContext, paramLong, paramString, null, paramb, paramArrayOfInt, null);
    AppMethodBeat.o(226836);
  }
  
  final class a
    implements Runnable
  {
    private QbarNative.QbarAiModelParam ahrl;
    private int[] ahrm;
    private e.c ahrn;
    private Bitmap bitmap;
    private String filePath;
    
    public a(String paramString, Bitmap paramBitmap, QbarNative.QbarAiModelParam paramQbarAiModelParam, int[] paramArrayOfInt, e.c paramc)
    {
      AppMethodBeat.i(226777);
      this.ahrm = new int[] { 0 };
      this.filePath = paramString;
      this.bitmap = paramBitmap;
      this.ahrl = paramQbarAiModelParam;
      if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0)) {
        this.ahrm = paramArrayOfInt;
      }
      this.ahrn = paramc;
      AppMethodBeat.o(226777);
    }
    
    private boolean jWP()
    {
      boolean bool2 = false;
      int i = 0;
      for (;;)
      {
        boolean bool1 = bool2;
        if (i < this.ahrm.length)
        {
          if ((this.ahrm[i] == 3) || (this.ahrm[i] == 0)) {
            bool1 = true;
          }
        }
        else {
          return bool1;
        }
        i += 1;
      }
    }
    
    private Bitmap jWQ()
    {
      AppMethodBeat.i(226778);
      Bitmap localBitmap = null;
      if ((this.bitmap != null) && (!this.bitmap.isRecycled()))
      {
        Log.i("WxFileDecodeQueue", "decodeFile use bitmap");
        localBitmap = this.bitmap;
      }
      for (;;)
      {
        AppMethodBeat.o(226778);
        return localBitmap;
        try
        {
          if (e.jWO() == null) {
            e.a(new d());
          }
          Object localObject = new com.tencent.mm.plugin.scanner.util.a.c(this.filePath);
          if ((this.ahrn != null) && (this.ahrn.hXf)) {}
          for (boolean bool = true;; bool = false)
          {
            ((com.tencent.mm.plugin.scanner.util.a.c)localObject).hXf = bool;
            localObject = com.tencent.mm.plugin.scanner.util.a.e.a((com.tencent.mm.plugin.scanner.util.a.g)localObject, e.jWO()).bitmap;
            AppMethodBeat.o(226778);
            return localObject;
          }
        }
        catch (Exception localException)
        {
          Log.e("WxFileDecodeQueue", "decode file to bitmap error! " + localException.getMessage());
        }
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(91153);
      Object localObject5 = jWQ();
      for (;;)
      {
        long l;
        e.d locald;
        synchronized (e.a(e.this))
        {
          l = System.currentTimeMillis();
          if (!e.a(e.this).hasInited()) {
            e.a(e.this).a(MMApplicationContext.getContext(), 1, this.ahrl);
          }
          if (e.a(e.this).hasInited()) {
            e.a(e.this).U(this.ahrm);
          }
          locald = new e.d();
          if (localObject5 == null) {
            break label820;
          }
          Log.i("WxFileDecodeQueue", "decodeFile image size: %d, %d", new Object[] { Integer.valueOf(((Bitmap)localObject5).getWidth()), Integer.valueOf(((Bitmap)localObject5).getHeight()) });
          localObject6 = new int[((Bitmap)localObject5).getWidth() * ((Bitmap)localObject5).getHeight()];
          ((Bitmap)localObject5).getPixels((int[])localObject6, 0, ((Bitmap)localObject5).getWidth(), 0, 0, ((Bitmap)localObject5).getWidth(), ((Bitmap)localObject5).getHeight());
          localObject7 = ad.bCb().Jn("basescanui@datacenter");
          Object localObject1 = null;
          if (localObject7 == null) {
            break label1085;
          }
          if (((ad.b)localObject7).getBoolean("key_basescanui_screen_position", false))
          {
            localObject1 = new PointF(((Float)((ad.b)localObject7).get("key_basescanui_screen_x", Float.valueOf(0.0F))).floatValue(), ((Float)((ad.b)localObject7).get("key_basescanui_screen_y", Float.valueOf(0.0F))).floatValue());
            bool1 = false;
            locald.QHP = new ArrayList();
            locald.ahrp = new ArrayList();
            locald.ahrq = new Point(((Bitmap)localObject5).getWidth(), ((Bitmap)localObject5).getHeight());
            localObject7 = e.a(e.this);
            localObject8 = locald.ahrq;
            List localList1 = locald.QHP;
            List localList2 = locald.ahrp;
            if ((this.ahrn == null) || (!this.ahrn.hXf)) {
              break label1091;
            }
            bool2 = true;
            locald.OTq = ((g)localObject7).a((int[])localObject6, (Point)localObject8, (PointF)localObject1, localList1, localList2, bool2);
            if (this.ahrn == null) {
              break label1097;
            }
            i = this.ahrn.hXg;
            locald.hXg = i;
            if (locald.OTq != null) {
              break label637;
            }
            i = 0;
            Log.i("WxFileDecodeQueue", "alvinluo decodeFile get %d decode results, isFingerPositionNormalize: %b, finger: %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), localObject1 });
            i = (int)(System.currentTimeMillis() - l);
            c.ahqI.jWL();
            c.ahqI.AW(i);
            c.ahqI.pF(((Bitmap)localObject5).getWidth(), ((Bitmap)localObject5).getHeight());
            c.ahqI.ahqZ = jWP();
            if ((locald.OTq == null) || (locald.OTq.isEmpty())) {
              break label771;
            }
            localObject1 = locald.OTq.iterator();
            if (!((Iterator)localObject1).hasNext()) {
              break label651;
            }
            localObject5 = (a.a)((Iterator)localObject1).next();
            Log.i("WxFileDecodeQueue", "decodeFile result " + ((a.a)localObject5).typeName + "," + ((a.a)localObject5).data);
          }
        }
        ??? = new PointF(((Float)((ad.b)localObject7).get("key_basescanui_touch_normalize_x", Float.valueOf(0.0F))).floatValue(), ((Float)((ad.b)localObject7).get("key_basescanui_touch_normalize_y", Float.valueOf(0.0F))).floatValue());
        boolean bool1 = true;
        continue;
        label637:
        int i = locald.OTq.size();
        continue;
        label651:
        c.ahqI.jWK();
        c.ahqI.AX(i);
        localObject5 = c.ahqI;
        Object localObject6 = ((a.a)locald.OTq.get(0)).typeName;
        Object localObject7 = ((a.a)locald.OTq.get(0)).data;
        Object localObject8 = ((a.a)locald.OTq.get(0)).charset;
        if (locald.ahrp.isEmpty())
        {
          ??? = null;
          ((c)localObject5).a((String)localObject6, (String)localObject7, (String)localObject8, (WxQbarNative.QBarReportMsg)???, locald.OTq.size(), locald.ahrp);
          label771:
          c.ahqI.cIX();
          this.bitmap = null;
          if (com.tencent.mm.plugin.scanner.util.e.gTX() != 1) {
            break label1016;
          }
        }
        label820:
        label1016:
        for (i = 1722;; i = 1229)
        {
          Log.i("WxFileDecodeQueue", "QBar init report, WxFileDecodeQueue idKey:".concat(String.valueOf(i)));
          com.tencent.mm.plugin.report.service.h.OAn.p(i, 20L, 1L);
          synchronized (e.b(e.this))
          {
            if (!e.c(e.this).containsKey(this.filePath)) {
              break label1040;
            }
            localObject5 = ((List)e.c(e.this).get(this.filePath)).iterator();
            if (!((Iterator)localObject5).hasNext()) {
              break label1023;
            }
            l = ((Long)((Iterator)localObject5).next()).longValue();
            if (e.d(e.this).containsKey(Long.valueOf(l)))
            {
              ((e.b)e.d(e.this).get(Long.valueOf(l))).a(l, locald);
              e.d(e.this).remove(Long.valueOf(l));
            }
            e.e(e.this).remove(Long.valueOf(l));
          }
          ??? = (WxQbarNative.QBarReportMsg)localObject4.ahrp.get(0);
          break;
        }
        label1023:
        e.c(e.this).remove(this.filePath);
        label1040:
        if (e.c(e.this).isEmpty())
        {
          Log.i("WxFileDecodeQueue", "release QBar");
          e.a(e.this).release();
        }
        AppMethodBeat.o(91153);
        return;
        label1085:
        bool1 = false;
        continue;
        label1091:
        boolean bool2 = false;
        continue;
        label1097:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.qbar.e
 * JD-Core Version:    0.7.0.1
 */