package com.tencent.qbar;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.scanner.util.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class h
{
  private static h RKq;
  private Object CCt;
  private Map CDO;
  private long CDU;
  private boolean CDW;
  public int CDX;
  private long CHf;
  public boolean CJM;
  private int[] RKg;
  public com.tencent.mm.plugin.scanner.f.c RKr;
  private int[] RKs;
  private c RKt;
  private long RKu;
  private Runnable RKv;
  private ScanDecodeFrameData RKw;
  private boolean RKx;
  private int RKy;
  private int RKz;
  private boolean aYc;
  public g lQo;
  
  static
  {
    AppMethodBeat.i(91183);
    RKq = new h();
    AppMethodBeat.o(91183);
  }
  
  public h()
  {
    AppMethodBeat.i(91175);
    this.RKr = new com.tencent.mm.plugin.scanner.f.b();
    this.CJM = false;
    this.RKs = new int[] { 0 };
    this.RKg = this.RKs;
    this.CDO = new HashMap();
    this.CCt = new Object();
    this.CHf = 0L;
    this.lQo = new g("MicroMsg.WxScanDecodeQueue");
    this.aYc = false;
    this.RKu = 1000L;
    this.RKv = null;
    this.RKw = null;
    this.RKx = false;
    this.RKy = 2;
    this.RKz = 0;
    AppMethodBeat.o(91175);
  }
  
  public static h hkp()
  {
    return RKq;
  }
  
  private void hkq()
  {
    AppMethodBeat.i(194835);
    if (this.RKv != null) {
      MMHandlerThread.removeRunnable(this.RKv);
    }
    AppMethodBeat.o(194835);
  }
  
  public final void Iv(long paramLong)
  {
    AppMethodBeat.i(91180);
    synchronized (this.CCt)
    {
      if (this.CDU == paramLong)
      {
        this.CDU = 0L;
        this.CDX = 0;
        this.RKt = null;
        this.CDO.clear();
        this.aYc = false;
        this.CHf = 0L;
      }
      hkq();
      AppMethodBeat.o(91180);
      return;
    }
  }
  
  public final void S(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(91177);
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0)) {
      synchronized (this.lQo)
      {
        this.RKg = paramArrayOfInt;
        if (this.lQo.hasInited()) {
          this.lQo.T(this.RKg);
        }
        AppMethodBeat.o(91177);
        return;
      }
    }
    AppMethodBeat.o(91177);
  }
  
  public final void a(long paramLong, c arg3)
  {
    AppMethodBeat.i(91178);
    synchronized (this.CCt)
    {
      c.RJE.reset();
      c.RJE.CHf = System.currentTimeMillis();
      c.RJE.aqw(c.RJy);
      c.RJE.setTabType(c.RJB);
      this.CDU = paramLong;
      this.RKt = ???;
      this.CDX = 0;
      this.CHf = System.currentTimeMillis();
    }
    synchronized (this.lQo)
    {
      if (this.lQo.hasInited()) {
        this.lQo.reset(false);
      }
      AppMethodBeat.o(91178);
      return;
      ??? = finally;
      AppMethodBeat.o(91178);
      throw ???;
    }
  }
  
  public final void a(byte[] paramArrayOfByte, Point paramPoint, int paramInt, Rect paramRect)
  {
    AppMethodBeat.i(91179);
    synchronized (this.CCt)
    {
      Log.d("MicroMsg.WxScanDecodeQueue", "%d submit crop gray", new Object[] { Long.valueOf(this.CDU) });
      if (this.CDU != 0L) {
        ThreadPool.post(new a(this.CDU, paramArrayOfByte, paramPoint, paramInt, paramRect), "WxScanDecodeQueue_Crop_Gray");
      }
      if ((this.aYc) && (this.RKx)) {
        this.RKw = new ScanDecodeFrameData(paramArrayOfByte, paramPoint.x, paramPoint.y, paramInt);
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
      synchronized (this.lQo)
      {
        if (!this.lQo.hasInited())
        {
          this.lQo.a(0, com.tencent.scanlib.a.lb(paramContext));
          if (this.lQo.hasInited())
          {
            this.lQo.hko();
            this.lQo.T(this.RKg);
          }
        }
        int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sex, 0);
        if ((i != 0) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG))
        {
          bool = true;
          this.RKx = bool;
          this.RKu = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sey, 1000L);
          this.RKy = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.seB, 2);
          Log.i("MicroMsg.WxScanDecodeQueue", "alvinluo initScanDecodeQueue configValue: %d, needShowSuccessFrameWhenZoom: %b, zoomDuration: %d, ignoreFrameNum: %d", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.RKx), Long.valueOf(this.RKu), Integer.valueOf(this.RKy) });
          AppMethodBeat.o(91176);
          return;
        }
      }
      boolean bool = false;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(91181);
    Log.i("MicroMsg.WxScanDecodeQueue", "release QBar");
    this.RKg = this.RKs;
    Iv(this.CDU);
    synchronized (this.lQo)
    {
      this.lQo.release();
      c.RJE.RJT = 1.0F;
      hkq();
      AppMethodBeat.o(91181);
      return;
    }
  }
  
  final class a
    implements Runnable
  {
    private byte[] CDY;
    private Point CDZ;
    private long dDZ;
    private Rect iiw;
    private int sRI;
    
    a(long paramLong, byte[] paramArrayOfByte, Point paramPoint, int paramInt, Rect paramRect)
    {
      this.dDZ = paramLong;
      this.CDY = paramArrayOfByte;
      this.CDZ = paramPoint;
      this.sRI = paramInt;
      this.iiw = paramRect;
    }
    
    public final void run()
    {
      AppMethodBeat.i(91173);
      int[] arrayOfInt = new int[2];
      byte[] arrayOfByte;
      synchronized (h.a(h.this))
      {
        arrayOfByte = h.a(h.this).a(this.CDY, this.CDZ, this.sRI, this.iiw, arrayOfInt);
        ??? = h.b(h.this);
        if (arrayOfByte == null) {}
      }
    }
  }
  
  final class b
    implements Runnable
  {
    private byte[] RKB;
    private Point RKC;
    private long dDZ;
    
    b(long paramLong)
    {
      this.dDZ = paramLong;
    }
    
    public final void run()
    {
      AppMethodBeat.i(91174);
      long l;
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      synchronized (h.b(h.this))
      {
        if (this.dDZ == h.c(h.this))
        {
          h.a(h.this, true);
          if (!h.d(h.this).isEmpty())
          {
            ??? = (byte[])h.d(h.this).get("param_gray_data");
            this.RKB = Arrays.copyOf((byte[])???, ???.length);
            this.RKC = new Point((Point)h.d(h.this).get("param_out_size"));
            h.d(h.this).clear();
          }
          l = System.currentTimeMillis();
          localArrayList1 = new ArrayList();
          localArrayList2 = new ArrayList();
          if ((this.RKB == null) || (this.RKC == null)) {
            break label663;
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
            h.h(h.this);
            if (h.i(h.this))
            {
              h.j(h.this);
              Log.i("MicroMsg.WxScanDecodeQueue", "alvinluo decodeGrayData isZooming and reset, currentFrameNumWhenZooming: %d", new Object[] { Integer.valueOf(h.k(h.this)) });
              h.a(h.this).reset(true);
            }
            localObject4 = h.a(h.this).a(this.RKB, this.RKC.x, this.RKC.y, localArrayList2, localArrayList1);
            localObject6 = h.a(h.this).hlb();
            k = h.a(h.this).hkn();
            if (!d.eRT()) {
              break label1272;
            }
            ??? = h.a(h.this).jS();
            ??? = localObject4;
            if (h.l(h.this) != null)
            {
              ??? = localObject4;
              if (h.m(h.this)) {
                ??? = h.l(h.this).gC((List)localObject4);
              }
            }
            m = (int)(System.currentTimeMillis() - l);
            c.RJE.hkh();
            c.RJE.Ov(m);
            c.RJE.mr(this.RKC.x, this.RKC.y);
            c.RJE.RJW = h.n(h.this);
            synchronized (h.b(h.this))
            {
              if (this.dDZ != h.c(h.this)) {
                break label1248;
              }
              localObject4 = a.getVersion();
              if (??? != null) {
                break label685;
              }
              i = 0;
              Log.i("MicroMsg.WxScanDecodeQueue", "qbar version %s, get %d decode results", new Object[] { localObject4, Integer.valueOf(i) });
              if (??? == null) {
                break label696;
              }
              localObject4 = ((List)???).iterator();
              if (!((Iterator)localObject4).hasNext()) {
                break label696;
              }
              localObject7 = (a.a)((Iterator)localObject4).next();
              Log.i("MicroMsg.WxScanDecodeQueue", "result " + ((a.a)localObject7).typeName + "," + ((a.a)localObject7).data);
            }
            h.a(h.this, false);
            h.g(h.this);
            AppMethodBeat.o(91174);
            return;
            localList = finally;
            AppMethodBeat.o(91174);
            throw localList;
          }
          h.a(h.this, false);
          h.g(h.this);
          AppMethodBeat.o(91174);
          return;
        }
        label663:
        h.a(h.this, false);
        h.g(h.this);
        AppMethodBeat.o(91174);
        return;
        label685:
        int i = localList.size();
        continue;
        label696:
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
          boolean bool2 = h.i(h.this);
          int j;
          if (localList == null)
          {
            j = 0;
            Log.i("MicroMsg.WxScanDecodeQueue", "alvinluo decodeGrayData ignoreResult: %b, isZooming: %b, result size: %d", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(j) });
            if (!((Bundle)localObject4).isEmpty()) {
              h.f(h.this).b(this.dDZ, (Bundle)localObject4);
            }
            if ((localList == null) || (localList.isEmpty()) || (bool1)) {
              break label1210;
            }
            c.RJE.hkg();
            c.RJE.Ow(m);
            localObject6 = c.RJE;
            localObject7 = ((a.a)localList.get(0)).typeName;
            String str3 = ((a.a)localList.get(0)).data;
            String str4 = ((a.a)localList.get(0)).charset;
            if (!localArrayList1.isEmpty()) {
              break label1194;
            }
            localObject4 = null;
            label971:
            ((c)localObject6).a((String)localObject7, str3, str4, (WxQbarNative.QBarReportMsg)localObject4, localList.size(), localArrayList1);
            c.RJE.RJV = k;
            Log.v("MicroMsg.QBarEngineReporter", "alvinluo setWaitingFrameCount: %d", new Object[] { Integer.valueOf(k) });
            c.RJE.bUV();
            localObject4 = new Bundle();
            Log.v("MicroMsg.WxScanDecodeQueue", "alvinluo decodeSuccess result size: %d, isZooming: %b", new Object[] { Integer.valueOf(localList.size()), Boolean.valueOf(h.i(h.this)) });
            if ((localList.size() > 1) && (h.i(h.this))) {
              ((Bundle)localObject4).putParcelable("decode_success_frame_data", h.o(h.this));
            }
            ((Bundle)localObject4).putString("decode_debug_string", str1);
            ((Bundle)localObject4).putLong("decode_success_cost_time", System.currentTimeMillis() - h.p(h.this));
            h.f(h.this).a(h.c(h.this), localList, localArrayList2, localArrayList1, (Bundle)localObject4);
            label1165:
            h.a(h.this, false);
          }
          for (;;)
          {
            AppMethodBeat.o(91174);
            return;
            j = localList.size();
            break;
            label1194:
            localObject4 = (WxQbarNative.QBarReportMsg)localArrayList1.get(0);
            break label971;
            label1210:
            if ((i != 0) && (h.q(h.this)))
            {
              h.r(h.this);
              h.s(h.this);
            }
            h.g(h.this);
            break label1165;
            label1248:
            h.a(h.this, false);
            h.g(h.this);
          }
        }
        label1272:
        String str2 = "";
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(long paramLong, List<a.a> paramList, List<QbarNative.QBarPoint> paramList1, List<WxQbarNative.QBarReportMsg> paramList2, Bundle paramBundle);
    
    public abstract void aj(long paramLong1, long paramLong2);
    
    public abstract void b(long paramLong, Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qbar.h
 * JD-Core Version:    0.7.0.1
 */