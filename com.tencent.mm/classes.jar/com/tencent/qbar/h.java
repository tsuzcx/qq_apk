package com.tencent.qbar;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.scanner.util.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class h
{
  private static h JQZ;
  private int[] JQT;
  public com.tencent.mm.plugin.scanner.d.c JRa;
  private int[] JRb;
  private c JRc;
  private long JRd;
  private Runnable JRe;
  private ScanDecodeFrameData JRf;
  private boolean JRg;
  private int JRh;
  private int JRi;
  private boolean aNN;
  public g knn;
  private Map wXC;
  private Object wXD;
  private long wXJ;
  private boolean wXL;
  public int wXM;
  private long xan;
  public boolean xbW;
  
  static
  {
    AppMethodBeat.i(91183);
    JQZ = new h();
    AppMethodBeat.o(91183);
  }
  
  public h()
  {
    AppMethodBeat.i(91175);
    this.JRa = new com.tencent.mm.plugin.scanner.d.b();
    this.xbW = false;
    this.JRb = new int[] { 0 };
    this.JQT = this.JRb;
    this.wXC = new HashMap();
    this.wXD = new Object();
    this.xan = 0L;
    this.knn = new g("MicroMsg.WxScanDecodeQueue");
    this.aNN = false;
    this.JRd = 1000L;
    this.JRe = null;
    this.JRf = null;
    this.JRg = false;
    this.JRh = 2;
    this.JRi = 0;
    AppMethodBeat.o(91175);
  }
  
  public static h fCn()
  {
    return JQZ;
  }
  
  private void fCo()
  {
    AppMethodBeat.i(204950);
    if (this.JRe != null) {
      ap.aB(this.JRe);
    }
    AppMethodBeat.o(204950);
  }
  
  public final void K(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(91177);
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0)) {
      synchronized (this.knn)
      {
        this.JQT = paramArrayOfInt;
        if (this.knn.hasInited()) {
          this.knn.L(this.JQT);
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
    synchronized (this.wXD)
    {
      c.JQr.reset();
      c.JQr.xan = System.currentTimeMillis();
      c.JQr.adZ(c.JQl);
      c.JQr.aeb(c.JQo);
      this.wXJ = paramLong;
      this.JRc = ???;
      this.wXM = 0;
      this.xan = System.currentTimeMillis();
    }
    synchronized (this.knn)
    {
      if (this.knn.hasInited()) {
        this.knn.reset(false);
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
    synchronized (this.wXD)
    {
      ac.d("MicroMsg.WxScanDecodeQueue", "%d submit crop gray", new Object[] { Long.valueOf(this.wXJ) });
      if (this.wXJ != 0L) {
        com.tencent.mm.sdk.g.b.c(new a(this.wXJ, paramArrayOfByte, paramPoint, paramInt, paramRect), "WxScanDecodeQueue_Crop_Gray");
      }
      if ((this.aNN) && (this.JRg)) {
        this.JRf = new ScanDecodeFrameData(paramArrayOfByte, paramPoint.x, paramPoint.y, paramInt);
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
      synchronized (this.knn)
      {
        if (!this.knn.hasInited())
        {
          this.knn.a(0, com.tencent.scanlib.a.kN(paramContext));
          if (this.knn.hasInited())
          {
            this.knn.fCm();
            this.knn.L(this.JQT);
          }
        }
        int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pWI, 0);
        if ((i != 0) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.DEBUG))
        {
          bool = true;
          this.JRg = bool;
          this.JRd = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pWJ, 1000L);
          this.JRh = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pWM, 2);
          ac.i("MicroMsg.WxScanDecodeQueue", "alvinluo initScanDecodeQueue configValue: %d, needShowSuccessFrameWhenZoom: %b, zoomDuration: %d, ignoreFrameNum: %d", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.JRg), Long.valueOf(this.JRd), Integer.valueOf(this.JRh) });
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
    ac.i("MicroMsg.WxScanDecodeQueue", "release QBar");
    this.JQT = this.JRb;
    wz(this.wXJ);
    synchronized (this.knn)
    {
      this.knn.release();
      c.JQr.JQG = 1.0F;
      fCo();
      AppMethodBeat.o(91181);
      return;
    }
  }
  
  public final void wz(long paramLong)
  {
    AppMethodBeat.i(91180);
    synchronized (this.wXD)
    {
      if (this.wXJ == paramLong)
      {
        this.wXJ = 0L;
        this.wXM = 0;
        this.JRc = null;
        this.wXC.clear();
        this.aNN = false;
        this.xan = 0L;
      }
      fCo();
      AppMethodBeat.o(91180);
      return;
    }
  }
  
  final class a
    implements Runnable
  {
    private long dao;
    private Rect gUl;
    private int qyr;
    private byte[] wXN;
    private Point wXO;
    
    a(long paramLong, byte[] paramArrayOfByte, Point paramPoint, int paramInt, Rect paramRect)
    {
      this.dao = paramLong;
      this.wXN = paramArrayOfByte;
      this.wXO = paramPoint;
      this.qyr = paramInt;
      this.gUl = paramRect;
    }
    
    public final void run()
    {
      AppMethodBeat.i(91173);
      int[] arrayOfInt = new int[2];
      byte[] arrayOfByte;
      synchronized (h.a(h.this))
      {
        arrayOfByte = h.a(h.this).a(this.wXN, this.wXO, this.qyr, this.gUl, arrayOfInt);
        ??? = h.b(h.this);
        if (arrayOfByte == null) {}
      }
    }
  }
  
  final class b
    implements Runnable
  {
    private byte[] JRk;
    private Point JRl;
    private long dao;
    
    b(long paramLong)
    {
      this.dao = paramLong;
    }
    
    public final void run()
    {
      AppMethodBeat.i(91174);
      long l;
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      synchronized (h.b(h.this))
      {
        if (this.dao == h.c(h.this))
        {
          h.a(h.this, true);
          if (!h.d(h.this).isEmpty())
          {
            ??? = (byte[])h.d(h.this).get("param_gray_data");
            this.JRk = Arrays.copyOf((byte[])???, ???.length);
            this.JRl = new Point((Point)h.d(h.this).get("param_out_size"));
            h.d(h.this).clear();
          }
          l = System.currentTimeMillis();
          localArrayList1 = new ArrayList();
          localArrayList2 = new ArrayList();
          if ((this.JRk == null) || (this.JRl == null)) {
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
              ac.i("MicroMsg.WxScanDecodeQueue", "alvinluo decodeGrayData isZooming and reset, currentFrameNumWhenZooming: %d", new Object[] { Integer.valueOf(h.k(h.this)) });
              h.a(h.this).reset(true);
            }
            localObject4 = h.a(h.this).a(this.JRk, this.JRl.x, this.JRl.y, localArrayList2, localArrayList1);
            localObject6 = h.a(h.this).fCZ();
            k = h.a(h.this).fCl();
            if (!d.dBp()) {
              break label1272;
            }
            ??? = h.a(h.this).jt();
            ??? = localObject4;
            if (h.l(h.this) != null)
            {
              ??? = localObject4;
              if (h.m(h.this)) {
                ??? = h.l(h.this).fj((List)localObject4);
              }
            }
            m = (int)(System.currentTimeMillis() - l);
            c.JQr.fCg();
            c.JQr.BO(m);
            c.JQr.kw(this.JRl.x, this.JRl.y);
            c.JQr.JQJ = h.n(h.this);
            synchronized (h.b(h.this))
            {
              if (this.dao != h.c(h.this)) {
                break label1248;
              }
              localObject4 = a.getVersion();
              if (??? != null) {
                break label685;
              }
              i = 0;
              ac.i("MicroMsg.WxScanDecodeQueue", "qbar version %s, get %d decode results", new Object[] { localObject4, Integer.valueOf(i) });
              if (??? == null) {
                break label696;
              }
              localObject4 = ((List)???).iterator();
              if (!((Iterator)localObject4).hasNext()) {
                break label696;
              }
              localObject7 = (a.a)((Iterator)localObject4).next();
              ac.i("MicroMsg.WxScanDecodeQueue", "result " + ((a.a)localObject7).typeName + "," + ((a.a)localObject7).data);
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
          ac.i("MicroMsg.WxScanDecodeQueue", "isZoom %b, zoomFactor %f", new Object[] { Boolean.valueOf(((QbarNative.QBarZoomInfo)localObject6).isZoom), Float.valueOf(((QbarNative.QBarZoomInfo)localObject6).zoomFactor) });
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
            ac.i("MicroMsg.WxScanDecodeQueue", "alvinluo decodeGrayData ignoreResult: %b, isZooming: %b, result size: %d", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(j) });
            if (!((Bundle)localObject4).isEmpty()) {
              h.f(h.this).b(this.dao, (Bundle)localObject4);
            }
            if ((localList == null) || (localList.isEmpty()) || (bool1)) {
              break label1210;
            }
            c.JQr.fCf();
            c.JQr.BP(m);
            localObject6 = c.JQr;
            localObject7 = ((a.a)localList.get(0)).typeName;
            String str3 = ((a.a)localList.get(0)).data;
            String str4 = ((a.a)localList.get(0)).charset;
            if (!localArrayList1.isEmpty()) {
              break label1194;
            }
            localObject4 = null;
            label971:
            ((c)localObject6).a((String)localObject7, str3, str4, (WxQbarNative.QBarReportMsg)localObject4, localList.size(), localArrayList1);
            c.JQr.JQI = k;
            ac.v("MicroMsg.QBarEngineReporter", "alvinluo setWaitingFrameCount: %d", new Object[] { Integer.valueOf(k) });
            c.JQr.btF();
            localObject4 = new Bundle();
            ac.v("MicroMsg.WxScanDecodeQueue", "alvinluo decodeSuccess result size: %d, isZooming: %b", new Object[] { Integer.valueOf(localList.size()), Boolean.valueOf(h.i(h.this)) });
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
    
    public abstract void ad(long paramLong1, long paramLong2);
    
    public abstract void b(long paramLong, Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qbar.h
 * JD-Core Version:    0.7.0.1
 */