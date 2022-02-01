package com.tencent.qbar;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.scanner.util.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class h
{
  private static h LKQ;
  private int[] LKG;
  public com.tencent.mm.plugin.scanner.d.c LKR;
  private int[] LKS;
  private c LKT;
  private long LKU;
  private Runnable LKV;
  private ScanDecodeFrameData LKW;
  private boolean LKX;
  private int LKY;
  private int LKZ;
  private boolean aYh;
  public g kIn;
  private Map yln;
  private Object ylo;
  private long ylu;
  private boolean ylw;
  public int ylx;
  private long yom;
  public boolean ypY;
  
  static
  {
    AppMethodBeat.i(91183);
    LKQ = new h();
    AppMethodBeat.o(91183);
  }
  
  public h()
  {
    AppMethodBeat.i(91175);
    this.LKR = new com.tencent.mm.plugin.scanner.d.b();
    this.ypY = false;
    this.LKS = new int[] { 0 };
    this.LKG = this.LKS;
    this.yln = new HashMap();
    this.ylo = new Object();
    this.yom = 0L;
    this.kIn = new g("MicroMsg.WxScanDecodeQueue");
    this.aYh = false;
    this.LKU = 1000L;
    this.LKV = null;
    this.LKW = null;
    this.LKX = false;
    this.LKY = 2;
    this.LKZ = 0;
    AppMethodBeat.o(91175);
  }
  
  public static h fTD()
  {
    return LKQ;
  }
  
  private void fTE()
  {
    AppMethodBeat.i(218760);
    if (this.LKV != null) {
      aq.aA(this.LKV);
    }
    AppMethodBeat.o(218760);
  }
  
  public final void K(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(91177);
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0)) {
      synchronized (this.kIn)
      {
        this.LKG = paramArrayOfInt;
        if (this.kIn.hasInited()) {
          this.kIn.L(this.LKG);
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
    synchronized (this.ylo)
    {
      c.LKe.reset();
      c.LKe.yom = System.currentTimeMillis();
      c.LKe.agz(c.LJY);
      c.LKe.agB(c.LKb);
      this.ylu = paramLong;
      this.LKT = ???;
      this.ylx = 0;
      this.yom = System.currentTimeMillis();
    }
    synchronized (this.kIn)
    {
      if (this.kIn.hasInited()) {
        this.kIn.reset(false);
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
    synchronized (this.ylo)
    {
      ad.d("MicroMsg.WxScanDecodeQueue", "%d submit crop gray", new Object[] { Long.valueOf(this.ylu) });
      if (this.ylu != 0L) {
        com.tencent.mm.sdk.g.b.c(new a(this.ylu, paramArrayOfByte, paramPoint, paramInt, paramRect), "WxScanDecodeQueue_Crop_Gray");
      }
      if ((this.aYh) && (this.LKX)) {
        this.LKW = new ScanDecodeFrameData(paramArrayOfByte, paramPoint.x, paramPoint.y, paramInt);
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
      synchronized (this.kIn)
      {
        if (!this.kIn.hasInited())
        {
          this.kIn.a(0, com.tencent.scanlib.a.la(paramContext));
          if (this.kIn.hasInited())
          {
            this.kIn.fTC();
            this.kIn.L(this.LKG);
          }
        }
        int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qBG, 0);
        if ((i != 0) || (i.IS_FLAVOR_RED) || (i.DEBUG))
        {
          bool = true;
          this.LKX = bool;
          this.LKU = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qBH, 1000L);
          this.LKY = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qBK, 2);
          ad.i("MicroMsg.WxScanDecodeQueue", "alvinluo initScanDecodeQueue configValue: %d, needShowSuccessFrameWhenZoom: %b, zoomDuration: %d, ignoreFrameNum: %d", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.LKX), Long.valueOf(this.LKU), Integer.valueOf(this.LKY) });
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
    ad.i("MicroMsg.WxScanDecodeQueue", "release QBar");
    this.LKG = this.LKS;
    yV(this.ylu);
    synchronized (this.kIn)
    {
      this.kIn.release();
      c.LKe.LKt = 1.0F;
      fTE();
      AppMethodBeat.o(91181);
      return;
    }
  }
  
  public final void yV(long paramLong)
  {
    AppMethodBeat.i(91180);
    synchronized (this.ylo)
    {
      if (this.ylu == paramLong)
      {
        this.ylu = 0L;
        this.ylx = 0;
        this.LKT = null;
        this.yln.clear();
        this.aYh = false;
        this.yom = 0L;
      }
      fTE();
      AppMethodBeat.o(91180);
      return;
    }
  }
  
  final class a
    implements Runnable
  {
    private long dlI;
    private Rect hmm;
    private int rih;
    private byte[] yly;
    private Point ylz;
    
    a(long paramLong, byte[] paramArrayOfByte, Point paramPoint, int paramInt, Rect paramRect)
    {
      this.dlI = paramLong;
      this.yly = paramArrayOfByte;
      this.ylz = paramPoint;
      this.rih = paramInt;
      this.hmm = paramRect;
    }
    
    public final void run()
    {
      AppMethodBeat.i(91173);
      int[] arrayOfInt = new int[2];
      byte[] arrayOfByte;
      synchronized (h.a(h.this))
      {
        arrayOfByte = h.a(h.this).a(this.yly, this.ylz, this.rih, this.hmm, arrayOfInt);
        ??? = h.b(h.this);
        if (arrayOfByte == null) {}
      }
    }
  }
  
  final class b
    implements Runnable
  {
    private byte[] LLb;
    private Point LLc;
    private long dlI;
    
    b(long paramLong)
    {
      this.dlI = paramLong;
    }
    
    public final void run()
    {
      AppMethodBeat.i(91174);
      long l;
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      synchronized (h.b(h.this))
      {
        if (this.dlI == h.c(h.this))
        {
          h.a(h.this, true);
          if (!h.d(h.this).isEmpty())
          {
            ??? = (byte[])h.d(h.this).get("param_gray_data");
            this.LLb = Arrays.copyOf((byte[])???, ???.length);
            this.LLc = new Point((Point)h.d(h.this).get("param_out_size"));
            h.d(h.this).clear();
          }
          l = System.currentTimeMillis();
          localArrayList1 = new ArrayList();
          localArrayList2 = new ArrayList();
          if ((this.LLb == null) || (this.LLc == null)) {
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
            localObject4 = h.a(h.this).a(this.LLb, this.LLc.x, this.LLc.y, localArrayList2, localArrayList1);
            localObject6 = h.a(h.this).fUr();
            k = h.a(h.this).fTB();
            if (!d.dMN()) {
              break label1272;
            }
            ??? = h.a(h.this).jJ();
            ??? = localObject4;
            if (h.l(h.this) != null)
            {
              ??? = localObject4;
              if (h.m(h.this)) {
                ??? = h.l(h.this).fw((List)localObject4);
              }
            }
            m = (int)(System.currentTimeMillis() - l);
            c.LKe.fTv();
            c.LKe.EQ(m);
            c.LKe.kL(this.LLc.x, this.LLc.y);
            c.LKe.LKw = h.n(h.this);
            synchronized (h.b(h.this))
            {
              if (this.dlI != h.c(h.this)) {
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
              h.f(h.this).b(this.dlI, (Bundle)localObject4);
            }
            if ((localList == null) || (localList.isEmpty()) || (bool1)) {
              break label1210;
            }
            c.LKe.fTu();
            c.LKe.ER(m);
            localObject6 = c.LKe;
            localObject7 = ((a.a)localList.get(0)).typeName;
            String str3 = ((a.a)localList.get(0)).data;
            String str4 = ((a.a)localList.get(0)).charset;
            if (!localArrayList1.isEmpty()) {
              break label1194;
            }
            localObject4 = null;
            label971:
            ((c)localObject6).a((String)localObject7, str3, str4, (WxQbarNative.QBarReportMsg)localObject4, localList.size(), localArrayList1);
            c.LKe.LKv = k;
            ad.v("MicroMsg.QBarEngineReporter", "alvinluo setWaitingFrameCount: %d", new Object[] { Integer.valueOf(k) });
            c.LKe.bxK();
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