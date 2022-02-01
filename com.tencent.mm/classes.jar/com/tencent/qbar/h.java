package com.tencent.qbar;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.scanner.util.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class h
{
  private static h Ipp;
  private int[] Ipj;
  public com.tencent.mm.plugin.scanner.d.c Ipq;
  private int[] Ipr;
  private c Ips;
  private long Ipt;
  private Runnable Ipu;
  private ScanDecodeFrameData Ipv;
  private boolean Ipw;
  private int Ipx;
  private int Ipy;
  private boolean aMX;
  public g jMM;
  private Map vNh;
  private Object vNi;
  private long vNo;
  private boolean vNq;
  public int vNr;
  private long vPG;
  public boolean vRl;
  
  static
  {
    AppMethodBeat.i(91183);
    Ipp = new h();
    AppMethodBeat.o(91183);
  }
  
  public h()
  {
    AppMethodBeat.i(91175);
    this.Ipq = new com.tencent.mm.plugin.scanner.d.b();
    this.vRl = false;
    this.Ipr = new int[] { 0 };
    this.Ipj = this.Ipr;
    this.vNh = new HashMap();
    this.vNi = new Object();
    this.vPG = 0L;
    this.jMM = new g("MicroMsg.WxScanDecodeQueue");
    this.aMX = false;
    this.Ipt = 1000L;
    this.Ipu = null;
    this.Ipv = null;
    this.Ipw = false;
    this.Ipx = 2;
    this.Ipy = 0;
    AppMethodBeat.o(91175);
  }
  
  public static h flW()
  {
    return Ipp;
  }
  
  private void flX()
  {
    AppMethodBeat.i(190147);
    if (this.Ipu != null) {
      aq.az(this.Ipu);
    }
    AppMethodBeat.o(190147);
  }
  
  public final void K(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(91177);
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0)) {
      synchronized (this.jMM)
      {
        this.Ipj = paramArrayOfInt;
        if (this.jMM.hasInited()) {
          this.jMM.L(this.Ipj);
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
    synchronized (this.vNi)
    {
      c.IoG.reset();
      c.IoG.vPG = System.currentTimeMillis();
      c.IoG.abG(c.IoA);
      c.IoG.abI(c.IoD);
      this.vNo = paramLong;
      this.Ips = ???;
      this.vNr = 0;
      this.vPG = System.currentTimeMillis();
    }
    synchronized (this.jMM)
    {
      if (this.jMM.hasInited()) {
        this.jMM.reset(false);
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
    synchronized (this.vNi)
    {
      ad.d("MicroMsg.WxScanDecodeQueue", "%d submit crop gray", new Object[] { Long.valueOf(this.vNo) });
      if (this.vNo != 0L) {
        com.tencent.mm.sdk.g.b.c(new a(this.vNo, paramArrayOfByte, paramPoint, paramInt, paramRect), "WxScanDecodeQueue_Crop_Gray");
      }
      if ((this.aMX) && (this.Ipw)) {
        this.Ipv = new ScanDecodeFrameData(paramArrayOfByte, paramPoint.x, paramPoint.y, paramInt);
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
      synchronized (this.jMM)
      {
        if (!this.jMM.hasInited())
        {
          this.jMM.a(0, com.tencent.scanlib.a.kB(paramContext));
          if (this.jMM.hasInited())
          {
            this.jMM.flV();
            this.jMM.L(this.Ipj);
          }
        }
        int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.psz, 0);
        if ((i != 0) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.DEBUG))
        {
          bool = true;
          this.Ipw = bool;
          this.Ipt = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.psA, 1000L);
          this.Ipx = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.psD, 2);
          ad.i("MicroMsg.WxScanDecodeQueue", "alvinluo initScanDecodeQueue configValue: %d, needShowSuccessFrameWhenZoom: %b, zoomDuration: %d, ignoreFrameNum: %d", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.Ipw), Long.valueOf(this.Ipt), Integer.valueOf(this.Ipx) });
          AppMethodBeat.o(91176);
          return;
        }
      }
      boolean bool = false;
    }
  }
  
  public final void rW(long paramLong)
  {
    AppMethodBeat.i(91180);
    synchronized (this.vNi)
    {
      if (this.vNo == paramLong)
      {
        this.vNo = 0L;
        this.vNr = 0;
        this.Ips = null;
        this.vNh.clear();
        this.aMX = false;
        this.vPG = 0L;
      }
      flX();
      AppMethodBeat.o(91180);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(91181);
    ad.i("MicroMsg.WxScanDecodeQueue", "release QBar");
    this.Ipj = this.Ipr;
    rW(this.vNo);
    synchronized (this.jMM)
    {
      this.jMM.release();
      c.IoG.IoW = 1.0F;
      flX();
      AppMethodBeat.o(91181);
      return;
    }
  }
  
  final class a
    implements Runnable
  {
    private long dcQ;
    private Rect gtE;
    private int pPJ;
    private byte[] vNs;
    private Point vNt;
    
    a(long paramLong, byte[] paramArrayOfByte, Point paramPoint, int paramInt, Rect paramRect)
    {
      this.dcQ = paramLong;
      this.vNs = paramArrayOfByte;
      this.vNt = paramPoint;
      this.pPJ = paramInt;
      this.gtE = paramRect;
    }
    
    public final void run()
    {
      AppMethodBeat.i(91173);
      int[] arrayOfInt = new int[2];
      byte[] arrayOfByte;
      synchronized (h.a(h.this))
      {
        arrayOfByte = h.a(h.this).a(this.vNs, this.vNt, this.pPJ, this.gtE, arrayOfInt);
        ??? = h.b(h.this);
        if (arrayOfByte == null) {}
      }
    }
  }
  
  final class b
    implements Runnable
  {
    private byte[] IpA;
    private Point IpB;
    private long dcQ;
    
    b(long paramLong)
    {
      this.dcQ = paramLong;
    }
    
    public final void run()
    {
      AppMethodBeat.i(91174);
      long l;
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      synchronized (h.b(h.this))
      {
        if (this.dcQ == h.c(h.this))
        {
          h.a(h.this, true);
          if (!h.d(h.this).isEmpty())
          {
            ??? = (byte[])h.d(h.this).get("param_gray_data");
            this.IpA = Arrays.copyOf((byte[])???, ???.length);
            this.IpB = new Point((Point)h.d(h.this).get("param_out_size"));
            h.d(h.this).clear();
          }
          l = System.currentTimeMillis();
          localArrayList1 = new ArrayList();
          localArrayList2 = new ArrayList();
          if ((this.IpA == null) || (this.IpB == null)) {
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
              ad.i("MicroMsg.WxScanDecodeQueue", "alvinluo decodeGrayData isZooming and reset, currentFrameNumWhenZooming: %d", new Object[] { Integer.valueOf(h.k(h.this)) });
              h.a(h.this).reset(true);
            }
            localObject4 = h.a(h.this).a(this.IpA, this.IpB.x, this.IpB.y, localArrayList2, localArrayList1);
            localObject6 = h.a(h.this).fmJ();
            k = h.a(h.this).flU();
            if (!d.dnh()) {
              break label1272;
            }
            ??? = h.a(h.this).jl();
            ??? = localObject4;
            if (h.l(h.this) != null)
            {
              ??? = localObject4;
              if (h.m(h.this)) {
                ??? = h.l(h.this).fc((List)localObject4);
              }
            }
            m = (int)(System.currentTimeMillis() - l);
            c.IoG.flP();
            c.IoG.xe(m);
            c.IoG.kj(this.IpB.x, this.IpB.y);
            c.IoG.IoZ = h.n(h.this);
            synchronized (h.b(h.this))
            {
              if (this.dcQ != h.c(h.this)) {
                break label1248;
              }
              localObject4 = a.getVersion();
              if (??? != null) {
                break label685;
              }
              i = 0;
              ad.i("MicroMsg.WxScanDecodeQueue", "qbar version %s, get %d decode results", new Object[] { localObject4, Integer.valueOf(i) });
              if (??? == null) {
                break label696;
              }
              localObject4 = ((List)???).iterator();
              if (!((Iterator)localObject4).hasNext()) {
                break label696;
              }
              localObject7 = (a.a)((Iterator)localObject4).next();
              ad.i("MicroMsg.WxScanDecodeQueue", "result " + ((a.a)localObject7).typeName + "," + ((a.a)localObject7).data);
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
          ad.i("MicroMsg.WxScanDecodeQueue", "isZoom %b, zoomFactor %f", new Object[] { Boolean.valueOf(((QbarNative.QBarZoomInfo)localObject6).isZoom), Float.valueOf(((QbarNative.QBarZoomInfo)localObject6).zoomFactor) });
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
            ad.i("MicroMsg.WxScanDecodeQueue", "alvinluo decodeGrayData ignoreResult: %b, isZooming: %b, result size: %d", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(j) });
            if (!((Bundle)localObject4).isEmpty()) {
              h.f(h.this).b(this.dcQ, (Bundle)localObject4);
            }
            if ((localList == null) || (localList.isEmpty()) || (bool1)) {
              break label1210;
            }
            c.IoG.flO();
            c.IoG.xf(m);
            localObject6 = c.IoG;
            localObject7 = ((a.a)localList.get(0)).typeName;
            String str3 = ((a.a)localList.get(0)).data;
            String str4 = ((a.a)localList.get(0)).charset;
            if (!localArrayList1.isEmpty()) {
              break label1194;
            }
            localObject4 = null;
            label971:
            ((c)localObject6).a((String)localObject7, str3, str4, (WxQbarNative.QBarReportMsg)localObject4, localList.size(), localArrayList1);
            c.IoG.IoY = k;
            ad.v("MicroMsg.QBarEngineReporter", "alvinluo setWaitingFrameCount: %d", new Object[] { Integer.valueOf(k) });
            c.IoG.bmJ();
            localObject4 = new Bundle();
            ad.v("MicroMsg.WxScanDecodeQueue", "alvinluo decodeSuccess result size: %d, isZooming: %b", new Object[] { Integer.valueOf(localList.size()), Boolean.valueOf(h.i(h.this)) });
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
    
    public abstract void ag(long paramLong1, long paramLong2);
    
    public abstract void b(long paramLong, Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qbar.h
 * JD-Core Version:    0.7.0.1
 */