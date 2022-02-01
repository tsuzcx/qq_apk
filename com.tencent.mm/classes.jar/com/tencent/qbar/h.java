package com.tencent.qbar;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.scanner.util.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class h
{
  private static h ZmY;
  private Object Brg;
  private Map IIq;
  private long IIw;
  private boolean IIy;
  public int IIz;
  private long IMq;
  public boolean IPn;
  private int[] ZmP;
  public com.tencent.mm.plugin.scanner.g.c ZmZ;
  private int[] Zna;
  private c Znb;
  private long Znc;
  private Runnable Znd;
  private ScanDecodeFrameData Zne;
  private boolean Znf;
  private int Zng;
  private int Znh;
  private boolean aHx;
  public g oMJ;
  
  static
  {
    AppMethodBeat.i(91183);
    ZmY = new h();
    AppMethodBeat.o(91183);
  }
  
  public h()
  {
    AppMethodBeat.i(91175);
    this.ZmZ = new com.tencent.mm.plugin.scanner.g.b();
    this.IPn = false;
    this.Zna = new int[] { 0 };
    this.ZmP = this.Zna;
    this.IIq = new HashMap();
    this.Brg = new Object();
    this.IMq = 0L;
    this.oMJ = new g("MicroMsg.WxScanDecodeQueue");
    this.aHx = false;
    this.Znc = 1000L;
    this.Znd = null;
    this.Zne = null;
    this.Znf = false;
    this.Zng = 2;
    this.Znh = 0;
    AppMethodBeat.o(91175);
  }
  
  public static h inM()
  {
    return ZmY;
  }
  
  private void inN()
  {
    AppMethodBeat.i(192632);
    if (this.Znd != null) {
      MMHandlerThread.removeRunnable(this.Znd);
    }
    AppMethodBeat.o(192632);
  }
  
  public final void PP(long paramLong)
  {
    AppMethodBeat.i(91180);
    synchronized (this.Brg)
    {
      if (this.IIw == paramLong)
      {
        this.IIw = 0L;
        this.IIz = 0;
        this.Znb = null;
        this.IIq.clear();
        this.aHx = false;
        this.IMq = 0L;
      }
      inN();
      AppMethodBeat.o(91180);
      return;
    }
  }
  
  public final void R(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(91177);
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0)) {
      synchronized (this.oMJ)
      {
        this.ZmP = paramArrayOfInt;
        if (this.oMJ.hasInited()) {
          this.oMJ.S(this.ZmP);
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
    synchronized (this.Brg)
    {
      c.Zmm.reset();
      c.Zmm.IMq = System.currentTimeMillis();
      c.Zmm.aAj(c.Zmg);
      c.Zmm.setTabType(c.Zmj);
      this.IIw = paramLong;
      this.Znb = ???;
      this.IIz = 0;
      this.IMq = System.currentTimeMillis();
    }
    synchronized (this.oMJ)
    {
      if (this.oMJ.hasInited()) {
        this.oMJ.reset(false);
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
    synchronized (this.Brg)
    {
      Log.d("MicroMsg.WxScanDecodeQueue", "%d submit crop gray", new Object[] { Long.valueOf(this.IIw) });
      if (this.IIw != 0L) {
        ThreadPool.post(new a(this.IIw, paramArrayOfByte, paramPoint, paramInt, paramRect), "WxScanDecodeQueue_Crop_Gray");
      }
      if ((this.aHx) && (this.Znf)) {
        this.Zne = new ScanDecodeFrameData(paramArrayOfByte, paramPoint.x, paramPoint.y, paramInt);
      }
      AppMethodBeat.o(91179);
      return;
    }
  }
  
  public final void init(Context paramContext)
  {
    AppMethodBeat.i(91176);
    synchronized (this.oMJ)
    {
      if (!this.oMJ.hasInited())
      {
        this.oMJ.a(0, com.tencent.scanlib.b.lZ(paramContext));
        if (this.oMJ.hasInited())
        {
          this.oMJ.inL();
          this.oMJ.S(this.ZmP);
        }
      }
      this.Znf = true;
      this.Znc = 1000L;
      this.Zng = 2;
      Log.i("MicroMsg.WxScanDecodeQueue", "alvinluo initScanDecodeQueue needShowSuccessFrameWhenZoom: %b, zoomDuration: %d, ignoreFrameNum: %d", new Object[] { Boolean.valueOf(this.Znf), Long.valueOf(this.Znc), Integer.valueOf(this.Zng) });
      AppMethodBeat.o(91176);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(91181);
    Log.i("MicroMsg.WxScanDecodeQueue", "release QBar");
    this.ZmP = this.Zna;
    PP(this.IIw);
    synchronized (this.oMJ)
    {
      this.oMJ.release();
      c.Zmm.ZmB = 1.0F;
      inN();
      AppMethodBeat.o(91181);
      return;
    }
  }
  
  final class a
    implements Runnable
  {
    private byte[] IIA;
    private Point IIB;
    private long fwK;
    private Rect kXj;
    private int wxE;
    
    a(long paramLong, byte[] paramArrayOfByte, Point paramPoint, int paramInt, Rect paramRect)
    {
      this.fwK = paramLong;
      this.IIA = paramArrayOfByte;
      this.IIB = paramPoint;
      this.wxE = paramInt;
      this.kXj = paramRect;
    }
    
    public final void run()
    {
      AppMethodBeat.i(91173);
      int[] arrayOfInt = new int[2];
      byte[] arrayOfByte;
      synchronized (h.a(h.this))
      {
        arrayOfByte = h.a(h.this).a(this.IIA, this.IIB, this.wxE, this.kXj, arrayOfInt);
        ??? = h.b(h.this);
        if (arrayOfByte == null) {}
      }
    }
  }
  
  final class b
    implements Runnable
  {
    private byte[] IIA;
    private Point IIB;
    private byte[] Znj;
    private Point Znk;
    private long fwK;
    private Rect kXj;
    
    b(long paramLong)
    {
      this.fwK = paramLong;
    }
    
    private byte[] inO()
    {
      AppMethodBeat.i(193743);
      if (this.IIA == null)
      {
        AppMethodBeat.o(193743);
        return null;
      }
      try
      {
        Object localObject = new ByteArrayOutputStream();
        Rect localRect = new Rect(0, 0, this.IIB.x, this.IIB.y);
        new YuvImage(this.IIA, 17, localRect.width(), localRect.height(), null).compressToJpeg(localRect, 30, (OutputStream)localObject);
        localObject = ((ByteArrayOutputStream)localObject).toByteArray();
        AppMethodBeat.o(193743);
        return localObject;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.WxScanDecodeQueue", localException, "", new Object[0]);
        Log.e("MicroMsg.WxScanDecodeQueue", "failed create preview jpeg data");
        AppMethodBeat.o(193743);
      }
      return null;
    }
    
    public final void run()
    {
      AppMethodBeat.i(91174);
      long l;
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      synchronized (h.b(h.this))
      {
        if (this.fwK == h.c(h.this))
        {
          h.a(h.this, true);
          if (!h.d(h.this).isEmpty())
          {
            ??? = (byte[])h.d(h.this).get("param_gray_data");
            this.Znj = Arrays.copyOf((byte[])???, ???.length);
            this.Znk = new Point((Point)h.d(h.this).get("param_out_size"));
            if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vOk, 0) != 0)
            {
              ??? = (byte[])h.d(h.this).get("param_preview_data");
              this.IIA = Arrays.copyOf((byte[])???, ???.length);
            }
            this.kXj = new Rect((Rect)h.d(h.this).get("param_crop_rect"));
            this.IIB = new Point((Point)h.d(h.this).get("param_resolution"));
            h.d(h.this).clear();
          }
          l = System.currentTimeMillis();
          localArrayList1 = new ArrayList();
          localArrayList2 = new ArrayList();
          if ((this.Znj == null) || (this.Znk == null)) {
            break label776;
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
            localObject4 = h.a(h.this).a(this.Znj, this.Znk.x, this.Znk.y, localArrayList2, localArrayList1);
            localObject6 = h.a(h.this).ioA();
            k = h.a(h.this).inK();
            if (!d.fES()) {
              break label1417;
            }
            ??? = h.a(h.this).iN();
            ??? = localObject4;
            if (h.l(h.this) != null)
            {
              ??? = localObject4;
              if (h.m(h.this)) {
                ??? = h.l(h.this).hi((List)localObject4);
              }
            }
            m = (int)(System.currentTimeMillis() - l);
            c.Zmm.inD();
            c.Zmm.WL(m);
            c.Zmm.nI(this.Znk.x, this.Znk.y);
            c.Zmm.ZmE = h.n(h.this);
            synchronized (h.b(h.this))
            {
              if (this.fwK != h.c(h.this)) {
                break label1393;
              }
              localObject4 = a.getVersion();
              if (??? != null) {
                break label798;
              }
              i = 0;
              Log.i("MicroMsg.WxScanDecodeQueue", "qbar version %s, get %d decode results", new Object[] { localObject4, Integer.valueOf(i) });
              if (??? == null) {
                break label809;
              }
              localObject4 = ((List)???).iterator();
              if (!((Iterator)localObject4).hasNext()) {
                break label809;
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
        label776:
        h.a(h.this, false);
        h.g(h.this);
        AppMethodBeat.o(91174);
        return;
        label798:
        int i = localList.size();
        continue;
        label809:
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
              h.f(h.this).b(this.fwK, (Bundle)localObject4);
            }
            if ((localList == null) || (localList.isEmpty()) || (bool1)) {
              break label1355;
            }
            c.Zmm.inC();
            c.Zmm.WM(m);
            localObject6 = c.Zmm;
            localObject7 = ((a.a)localList.get(0)).typeName;
            String str3 = ((a.a)localList.get(0)).data;
            String str4 = ((a.a)localList.get(0)).charset;
            if (!localArrayList1.isEmpty()) {
              break label1339;
            }
            localObject4 = null;
            label1084:
            ((c)localObject6).a((String)localObject7, str3, str4, (WxQbarNative.QBarReportMsg)localObject4, localList.size(), localArrayList1);
            c.Zmm.ZmD = k;
            Log.v("MicroMsg.QBarEngineReporter", "alvinluo setWaitingFrameCount: %d", new Object[] { Integer.valueOf(k) });
            c.Zmm.cig();
            localObject4 = new Bundle();
            Log.v("MicroMsg.WxScanDecodeQueue", "alvinluo decodeSuccess result size: %d, isZooming: %b", new Object[] { Integer.valueOf(localList.size()), Boolean.valueOf(h.i(h.this)) });
            if ((localList.size() > 1) && (h.i(h.this))) {
              ((Bundle)localObject4).putParcelable("decode_success_frame_data", h.o(h.this));
            }
            ((Bundle)localObject4).putString("decode_debug_string", str1);
            ((Bundle)localObject4).putLong("decode_success_cost_time", System.currentTimeMillis() - h.p(h.this));
            if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vOk, 0) != 0) {
              ((Bundle)localObject4).putByteArray("decode_success_jpeg_data", inO());
            }
            h.f(h.this).a(h.c(h.this), localList, localArrayList2, localArrayList1, (Bundle)localObject4);
            label1310:
            h.a(h.this, false);
          }
          for (;;)
          {
            AppMethodBeat.o(91174);
            return;
            j = localList.size();
            break;
            label1339:
            localObject4 = (WxQbarNative.QBarReportMsg)localArrayList1.get(0);
            break label1084;
            label1355:
            if ((i != 0) && (h.q(h.this)))
            {
              h.r(h.this);
              h.s(h.this);
            }
            h.g(h.this);
            break label1310;
            label1393:
            h.a(h.this, false);
            h.g(h.this);
          }
        }
        label1417:
        String str2 = "";
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(long paramLong, List<a.a> paramList, List<QbarNative.QBarPoint> paramList1, List<WxQbarNative.QBarReportMsg> paramList2, Bundle paramBundle);
    
    public abstract void as(long paramLong1, long paramLong2);
    
    public abstract void b(long paramLong, Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qbar.h
 * JD-Core Version:    0.7.0.1
 */