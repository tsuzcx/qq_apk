package com.tencent.qbar;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.g.d;
import com.tencent.mm.plugin.scanner.util.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class h
{
  private static h ahrv;
  private Object GXz;
  private Map OOo;
  private long OOu;
  private boolean OOw;
  public int OOx;
  private long OTD;
  public boolean OXQ;
  private long ahrA;
  private Runnable ahrB;
  private ScanDecodeFrameData ahrC;
  private boolean ahrD;
  private int ahrE;
  private int ahrF;
  public ConcurrentHashMap<String, Long> ahrG;
  private int[] ahrm;
  public d ahrw;
  private com.tencent.qbar.b.a ahrx;
  private int[] ahry;
  private c ahrz;
  private boolean isZooming;
  public g rQG;
  
  static
  {
    AppMethodBeat.i(91183);
    ahrv = new h();
    AppMethodBeat.o(91183);
  }
  
  public h()
  {
    AppMethodBeat.i(91175);
    this.ahrw = new com.tencent.mm.plugin.scanner.g.b();
    this.OXQ = false;
    this.ahrx = new com.tencent.qbar.b.a();
    this.ahry = new int[] { 0 };
    this.ahrm = this.ahry;
    this.OOo = new HashMap();
    this.GXz = new Object();
    this.OTD = 0L;
    this.rQG = new g("MicroMsg.WxScanDecodeQueue");
    this.isZooming = false;
    this.ahrA = 1000L;
    this.ahrB = null;
    this.ahrC = null;
    this.ahrD = false;
    this.ahrE = 2;
    this.ahrF = 0;
    this.ahrG = new ConcurrentHashMap();
    AppMethodBeat.o(91175);
  }
  
  private boolean bFu(String paramString)
  {
    AppMethodBeat.i(226832);
    for (;;)
    {
      try
      {
        Long localLong = (Long)this.ahrG.get(paramString);
        if (localLong == null) {
          continue;
        }
        long l1 = System.currentTimeMillis();
        long l2 = localLong.longValue();
        int i = e.gTW();
        if (l1 - l2 >= i) {
          continue;
        }
        bool = true;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.WxScanDecodeQueue", localException, "isCodeNotRecognize", new Object[0]);
        boolean bool = false;
        continue;
      }
      Log.d("MicroMsg.WxScanDecodeQueue", "isCodeNotRecognize  code:%s, result:%s", new Object[] { paramString, Boolean.valueOf(bool) });
      AppMethodBeat.o(226832);
      return bool;
      this.ahrG.remove(paramString);
      bool = false;
    }
  }
  
  public static h jWV()
  {
    return ahrv;
  }
  
  private void jWW()
  {
    AppMethodBeat.i(226830);
    if (this.ahrB != null) {
      MMHandlerThread.removeRunnable(this.ahrB);
    }
    AppMethodBeat.o(226830);
  }
  
  private void jWX()
  {
    AppMethodBeat.i(226834);
    try
    {
      this.ahrG.clear();
      AppMethodBeat.o(226834);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.WxScanDecodeQueue", localException, "resetNoRecognizeCodeStringData", new Object[0]);
      AppMethodBeat.o(226834);
    }
  }
  
  public final void T(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(91177);
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0)) {
      synchronized (this.rQG)
      {
        this.ahrm = paramArrayOfInt;
        if (this.rQG.hasInited()) {
          this.rQG.U(this.ahrm);
        }
        AppMethodBeat.o(91177);
        return;
      }
    }
    AppMethodBeat.o(91177);
  }
  
  public final void a(long paramLong, int paramInt, d arg4, c paramc)
  {
    AppMethodBeat.i(226847);
    synchronized (this.GXz)
    {
      c.ahqH.reset();
      c.ahqH.OTD = System.currentTimeMillis();
      c.ahqH.aGV(c.ahqA);
      c.ahqH.setTabType(paramInt);
      c.ahqH.a(???);
      this.OOu = paramLong;
      this.ahrz = paramc;
      this.OOx = 0;
      this.OTD = System.currentTimeMillis();
    }
    synchronized (this.rQG)
    {
      if (this.rQG.hasInited()) {
        this.rQG.reset(false);
      }
      AppMethodBeat.o(226847);
      return;
      ??? = finally;
      AppMethodBeat.o(226847);
      throw ???;
    }
  }
  
  public final void a(byte[] paramArrayOfByte, Point paramPoint, int paramInt, Rect paramRect)
  {
    AppMethodBeat.i(91179);
    synchronized (this.GXz)
    {
      Log.d("MicroMsg.WxScanDecodeQueue", "%d submit crop gray", new Object[] { Long.valueOf(this.OOu) });
      if (this.OOu != 0L) {
        ThreadPool.post(new a(System.currentTimeMillis(), this.OOu, paramArrayOfByte, paramPoint, paramInt, paramRect), "WxScanDecodeQueue_Crop_Gray");
      }
      if ((this.isZooming) && (this.ahrD)) {
        this.ahrC = new ScanDecodeFrameData(paramArrayOfByte, paramPoint.x, paramPoint.y, paramInt);
      }
      AppMethodBeat.o(91179);
      return;
    }
  }
  
  public final void init(Context paramContext)
  {
    AppMethodBeat.i(91176);
    for (;;)
    {
      synchronized (this.rQG)
      {
        if (!this.rQG.hasInited())
        {
          this.rQG.a(paramContext, 0, com.tencent.scanlib.b.oe(paramContext));
          if (this.rQG.hasInited())
          {
            this.rQG.jWU();
            this.rQG.U(this.ahrm);
          }
          this.ahrx.init();
        }
        this.ahrD = true;
        this.ahrA = 1000L;
        this.ahrE = 2;
        Log.i("MicroMsg.WxScanDecodeQueue", "alvinluo initScanDecodeQueue needShowSuccessFrameWhenZoom: %b, zoomDuration: %d, ignoreFrameNum: %d", new Object[] { Boolean.valueOf(this.ahrD), Long.valueOf(this.ahrA), Integer.valueOf(this.ahrE) });
        if (e.gTX() == 1)
        {
          i = 1722;
          Log.i("MicroMsg.WxScanDecodeQueue", "QBar init report, WxScanDecodeQueue idKey:".concat(String.valueOf(i)));
          com.tencent.mm.plugin.report.service.h.OAn.p(i, 21L, 1L);
          AppMethodBeat.o(91176);
          return;
        }
      }
      int i = 1229;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(91181);
    Log.i("MicroMsg.WxScanDecodeQueue", "release QBar");
    this.ahrm = this.ahry;
    tR(this.OOu);
    synchronized (this.rQG)
    {
      this.rQG.release();
      c.ahqH.ahqW = 1.0F;
      jWW();
      this.ahrx.jWY();
      jWX();
      AppMethodBeat.o(91181);
      return;
    }
  }
  
  public final void tR(long paramLong)
  {
    AppMethodBeat.i(91180);
    synchronized (this.GXz)
    {
      if (this.OOu == paramLong)
      {
        this.OOu = 0L;
        this.OOx = 0;
        this.ahrz = null;
        this.OOo.clear();
        this.isZooming = false;
        this.OTD = 0L;
        this.ahrx.ahrQ = -1L;
      }
      jWW();
      AppMethodBeat.o(91180);
      return;
    }
  }
  
  final class a
    implements Runnable
  {
    private Rect Gl;
    private byte[] OOy;
    private Point OOz;
    private long ahrI;
    private long hBk;
    private int zTK;
    
    a(long paramLong1, long paramLong2, byte[] paramArrayOfByte, Point paramPoint, int paramInt, Rect paramRect)
    {
      this.ahrI = paramLong1;
      this.hBk = paramLong2;
      this.OOy = paramArrayOfByte;
      this.OOz = paramPoint;
      this.zTK = paramInt;
      this.Gl = paramRect;
    }
    
    public final void run()
    {
      AppMethodBeat.i(91173);
      Log.i("MicroMsg.WxScanDecodeQueue", "CropGrayTask");
      int[] arrayOfInt = new int[2];
      byte[] arrayOfByte;
      synchronized (h.a(h.this))
      {
        long l1 = System.currentTimeMillis();
        arrayOfByte = h.a(h.this).a(this.OOy, this.OOz, this.zTK, this.Gl, arrayOfInt);
        long l2 = System.currentTimeMillis();
        h.b(h.this).bM(this.ahrI, l2 - l1);
        ??? = h.c(h.this);
        if (arrayOfByte == null) {}
      }
    }
  }
  
  final class b
    implements Runnable
  {
    private long ahrI;
    private byte[] ahrJ;
    private byte[] ahrK;
    private ScanIdentifyReportInfo ahrL;
    private Point ahrM;
    private long hBk;
    
    b(long paramLong)
    {
      this.hBk = paramLong;
    }
    
    public final void run()
    {
      AppMethodBeat.i(91174);
      long l1;
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      synchronized (h.c(h.this))
      {
        if (this.hBk == h.d(h.this))
        {
          h.a(h.this, true);
          if (!h.e(h.this).isEmpty())
          {
            ??? = (byte[])h.e(h.this).get("param_gray_data");
            this.ahrJ = Arrays.copyOf((byte[])???, ???.length);
            this.ahrM = new Point((Point)h.e(h.this).get("param_out_size"));
            this.ahrK = ((byte[])h.e(h.this).get("param_preview_data"));
            ??? = new Point((Point)h.e(h.this).get("param_resolution"));
            this.ahrL = new ScanIdentifyReportInfo(this.ahrK, (Point)???);
            this.ahrI = ((Long)h.e(h.this).get("param_decode_task_id")).longValue();
            h.e(h.this).clear();
          }
          l1 = System.currentTimeMillis();
          localArrayList1 = new ArrayList();
          localArrayList2 = new ArrayList();
          if ((this.ahrJ == null) || (this.ahrM == null)) {
            break label793;
          }
        }
      }
      for (;;)
      {
        Object localObject6;
        int k;
        int m;
        Object localObject7;
        synchronized (h.a(h.this))
        {
          if (h.a(h.this).hasInited())
          {
            long l2 = System.currentTimeMillis();
            h.i(h.this);
            if (h.j(h.this))
            {
              h.k(h.this);
              Log.i("MicroMsg.WxScanDecodeQueue", "alvinluo decodeGrayData isZooming and reset, currentFrameNumWhenZooming: %d", new Object[] { Integer.valueOf(h.l(h.this)) });
              h.a(h.this).reset(true);
            }
            localObject4 = h.a(h.this).a(this.ahrJ, this.ahrM.x, this.ahrM.y, localArrayList2, localArrayList1);
            localObject6 = h.a(h.this).jXN();
            k = h.a(h.this).jWT();
            if (!e.gTS()) {
              break label1468;
            }
            ??? = h.a(h.this).GR();
            long l3 = System.currentTimeMillis();
            h.b(h.this).bM(this.ahrI, l3 - l2);
            h.b(h.this).AZ(this.ahrI);
            ??? = localObject4;
            if (h.m(h.this) != null)
            {
              ??? = localObject4;
              if (h.n(h.this)) {
                ??? = h.m(h.this).F((List)localObject4);
              }
            }
            m = (int)(System.currentTimeMillis() - l1);
            c.ahqH.jWL();
            c.ahqH.AW(m);
            c.ahqH.pF(this.ahrM.x, this.ahrM.y);
            c.ahqH.ahqZ = h.o(h.this);
            synchronized (h.c(h.this))
            {
              if (this.hBk != h.d(h.this)) {
                break label1444;
              }
              localObject4 = a.getVersion();
              if (??? != null) {
                break label815;
              }
              i = 0;
              Log.i("MicroMsg.WxScanDecodeQueue", "qbar version %s, get %d decode results", new Object[] { localObject4, Integer.valueOf(i) });
              if (??? == null) {
                break label826;
              }
              localObject4 = ((List)???).iterator();
              if (!((Iterator)localObject4).hasNext()) {
                break label826;
              }
              localObject7 = (a.a)((Iterator)localObject4).next();
              Log.i("MicroMsg.WxScanDecodeQueue", "result " + ((a.a)localObject7).typeName + "," + ((a.a)localObject7).data);
            }
            h.a(h.this, false);
            h.h(h.this);
            AppMethodBeat.o(91174);
            return;
            localList = finally;
            AppMethodBeat.o(91174);
            throw localList;
          }
          h.a(h.this, false);
          h.h(h.this);
          AppMethodBeat.o(91174);
          return;
        }
        label793:
        h.a(h.this, false);
        h.h(h.this);
        AppMethodBeat.o(91174);
        return;
        label815:
        int i = localList.size();
        continue;
        label826:
        Object localObject4 = new Bundle();
        if (localObject6 != null)
        {
          Log.i("MicroMsg.WxScanDecodeQueue", "isZoom %b, zoomFactor %f", new Object[] { Boolean.valueOf(((QbarNative.QBarZoomInfo)localObject6).isZoom), Float.valueOf(((QbarNative.QBarZoomInfo)localObject6).zoomFactor) });
          if ((localList == null) || ((localList.isEmpty()) && (((QbarNative.QBarZoomInfo)localObject6).isZoom))) {
            ((Bundle)localObject4).putFloat("param_zoom_ratio", ((QbarNative.QBarZoomInfo)localObject6).zoomFactor);
          }
        }
        for (i = 1;; i = 0)
        {
          boolean bool1 = h.a(h.this, localList);
          boolean bool2 = h.j(h.this);
          int j;
          if (localList == null)
          {
            j = 0;
            Log.i("MicroMsg.WxScanDecodeQueue", "alvinluo decodeGrayData ignoreResult: %b, isZooming: %b, result size: %d", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(j) });
            if (!((Bundle)localObject4).isEmpty()) {
              h.g(h.this).b(this.hBk, (Bundle)localObject4);
            }
            if ((localList == null) || (localList.isEmpty()) || (bool1)) {
              break label1365;
            }
            c.ahqH.jWK();
            c.ahqH.AX(m);
            localObject6 = c.ahqH;
            localObject7 = ((a.a)localList.get(0)).typeName;
            String str3 = ((a.a)localList.get(0)).data;
            String str4 = ((a.a)localList.get(0)).charset;
            if (!localArrayList1.isEmpty()) {
              break label1349;
            }
            localObject4 = null;
            label1101:
            ((c)localObject6).a((String)localObject7, str3, str4, (WxQbarNative.QBarReportMsg)localObject4, localList.size(), localArrayList1);
            c.ahqH.ahqY = k;
            Log.v("MicroMsg.QBarEngineReporter", "alvinluo setWaitingFrameCount: %d", new Object[] { Integer.valueOf(k) });
            c.ahqH.cIX();
            localObject4 = new Bundle();
            Log.v("MicroMsg.WxScanDecodeQueue", "alvinluo decodeSuccess result size: %d, isZooming: %b", new Object[] { Integer.valueOf(localList.size()), Boolean.valueOf(h.j(h.this)) });
            if ((localList.size() > 1) && (h.j(h.this))) {
              ((Bundle)localObject4).putParcelable("decode_success_frame_data", h.p(h.this));
            }
            ((Bundle)localObject4).putString("decode_debug_string", str1);
            ((Bundle)localObject4).putLong("decode_success_cost_time", System.currentTimeMillis() - h.q(h.this));
            ((Bundle)localObject4).putParcelable("ScanIdentifyReportInfo.DecodeKey", this.ahrL);
            h.g(h.this).a(h.d(h.this), localList, localArrayList2, localArrayList1, (Bundle)localObject4);
            label1307:
            h.a(h.this, false);
          }
          for (;;)
          {
            h.b(h.this).AY(System.currentTimeMillis());
            AppMethodBeat.o(91174);
            return;
            j = localList.size();
            break;
            label1349:
            localObject4 = (WxQbarNative.QBarReportMsg)localArrayList1.get(0);
            break label1101;
            label1365:
            if ((i != 0) && (h.r(h.this)))
            {
              h.s(h.this);
              h.t(h.this);
            }
            h.h(h.this);
            if ((i == 0) && (!h.j(h.this)))
            {
              h.g(h.this).cr(this.ahrK);
              break label1307;
            }
            Log.w("MicroMsg.WxScanDecodeQueue", "onDecodeNothing not called");
            break label1307;
            label1444:
            h.a(h.this, false);
            h.h(h.this);
          }
        }
        label1468:
        String str2 = "";
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(long paramLong, List<a.a> paramList, List<QbarNative.QBarPoint> paramList1, List<WxQbarNative.QBarReportMsg> paramList2, Bundle paramBundle);
    
    public abstract void b(long paramLong, Bundle paramBundle);
    
    public abstract void bc(long paramLong1, long paramLong2);
    
    public abstract void cr(byte[] paramArrayOfByte);
  }
  
  public static class d
  {
    public String OTx = "";
    public String OTy = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.qbar.h
 * JD-Core Version:    0.7.0.1
 */