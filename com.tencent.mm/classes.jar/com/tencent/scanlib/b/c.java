package com.tencent.scanlib.b;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qbar.QbarNative.QBarZoomInfo;
import com.tencent.qbar.a.a;
import com.tencent.stubs.logger.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class c
{
  private static c ROG;
  public Object CCt;
  private Map CDO;
  private ExecutorService CDQ;
  public long CDU;
  private boolean CDW;
  public int CDX;
  public int[] RKg;
  public a ROF;
  public ExecutorService ROH;
  private c ROI;
  
  static
  {
    AppMethodBeat.i(3563);
    ROG = new c();
    AppMethodBeat.o(3563);
  }
  
  private c()
  {
    AppMethodBeat.i(3560);
    this.RKg = new int[] { 2, 1 };
    this.CDO = new HashMap();
    this.CCt = new Object();
    this.ROH = Executors.newSingleThreadExecutor();
    this.CDQ = Executors.newSingleThreadExecutor();
    this.ROF = new a("ScanDecodeQueue");
    AppMethodBeat.o(3560);
  }
  
  public static c hld()
  {
    return ROG;
  }
  
  public final void Iv(long paramLong)
  {
    AppMethodBeat.i(3561);
    synchronized (this.CCt)
    {
      if (this.CDU == paramLong)
      {
        this.CDU = 0L;
        this.ROI = null;
        this.CDX = 0;
        this.CDO.clear();
      }
      AppMethodBeat.o(3561);
      return;
    }
  }
  
  public final void a(long paramLong, c paramc)
  {
    synchronized (this.CCt)
    {
      this.CDU = paramLong;
      this.ROI = paramc;
      this.CDX = 0;
      return;
    }
  }
  
  public final class a
    implements Runnable
  {
    private byte[] CDY;
    private Point CDZ;
    private long dDZ;
    private Rect iiw;
    private int sRI;
    
    public a(long paramLong, byte[] paramArrayOfByte, Point paramPoint, int paramInt, Rect paramRect)
    {
      this.dDZ = paramLong;
      this.CDY = paramArrayOfByte;
      this.CDZ = paramPoint;
      this.sRI = paramInt;
      this.iiw = paramRect;
    }
    
    public final void run()
    {
      AppMethodBeat.i(3558);
      int[] arrayOfInt = new int[2];
      byte[] arrayOfByte;
      synchronized (c.a(c.this))
      {
        arrayOfByte = c.a(c.this).a(this.CDY, this.CDZ, this.sRI, this.iiw, arrayOfInt);
        ??? = c.b(c.this);
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
      AppMethodBeat.i(3559);
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      synchronized (c.b(c.this))
      {
        if (this.dDZ == c.c(c.this))
        {
          c.a(c.this, true);
          if (!c.d(c.this).isEmpty())
          {
            ??? = (byte[])c.d(c.this).get("param_gray_data");
            this.RKB = Arrays.copyOf((byte[])???, ???.length);
            this.RKC = new Point((Point)c.d(c.this).get("param_out_size"));
            c.d(c.this).clear();
          }
          localArrayList1 = new ArrayList();
          localArrayList2 = new ArrayList();
          if ((this.RKB == null) || (this.RKC == null)) {
            break label468;
          }
        }
      }
      QbarNative.QBarZoomInfo localQBarZoomInfo;
      for (;;)
      {
        synchronized (c.a(c.this))
        {
          if (c.a(c.this).hasInited())
          {
            c.i(c.this);
            ??? = c.a(c.this).U(this.RKB, this.RKC.x, this.RKC.y);
            localQBarZoomInfo = c.a(c.this).hlb();
            c.a(c.this).H(localArrayList1, localArrayList2);
            synchronized (c.b(c.this))
            {
              if (this.dDZ != c.c(c.this)) {
                break label734;
              }
              localObject5 = com.tencent.qbar.a.getVersion();
              if (??? != null) {
                break label491;
              }
              i = 0;
              Log.i("ScanDecodeQueue", String.format("qbar version %s, get %d decode results", new Object[] { localObject5, Integer.valueOf(i) }));
              if (??? == null) {
                break;
              }
              localObject5 = ((List)???).iterator();
              if (!((Iterator)localObject5).hasNext()) {
                break;
              }
              a.a locala = (a.a)((Iterator)localObject5).next();
              Log.i("ScanDecodeQueue", "result " + locala.typeName + "," + locala.data);
            }
            c.a(c.this, false);
            c.h(c.this);
            AppMethodBeat.o(3559);
            return;
            localObject4 = finally;
            AppMethodBeat.o(3559);
            throw localObject4;
          }
          c.a(c.this, false);
          c.h(c.this);
          AppMethodBeat.o(3559);
          return;
        }
        label468:
        c.a(c.this, false);
        c.h(c.this);
        AppMethodBeat.o(3559);
        return;
        label491:
        int i = localList.size();
      }
      Object localObject5 = new Bundle();
      if (localQBarZoomInfo != null)
      {
        Log.i("ScanDecodeQueue", String.format("isZoom %b, zoomFactor %f", new Object[] { Boolean.valueOf(localQBarZoomInfo.isZoom), Float.valueOf(localQBarZoomInfo.zoomFactor) }));
        if ((localList == null) || ((localList.isEmpty()) && (localQBarZoomInfo.isZoom))) {
          ((Bundle)localObject5).putFloat("param_zoom_ratio", localQBarZoomInfo.zoomFactor);
        }
      }
      Log.i("ScanDecodeQueue", String.format("detect %d codes", new Object[] { Integer.valueOf(localArrayList1.size()) }));
      if (localArrayList1.size() > 0)
      {
        localArrayList1 = com.tencent.scanlib.a.G(localArrayList1, localArrayList2);
        if (!localArrayList1.isEmpty()) {
          ((Bundle)localObject5).putParcelableArrayList("param_detect_codes", localArrayList1);
        }
      }
      if (!((Bundle)localObject5).isEmpty()) {
        c.g(c.this).b(this.dDZ, (Bundle)localObject5);
      }
      if ((localList != null) && (!localList.isEmpty()))
      {
        c.g(c.this).b(c.c(c.this), localList);
        c.a(c.this, false);
      }
      for (;;)
      {
        AppMethodBeat.o(3559);
        return;
        c.h(c.this);
        break;
        label734:
        c.a(c.this, false);
        c.h(c.this);
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void aj(long paramLong1, long paramLong2);
    
    public abstract void b(long paramLong, Bundle paramBundle);
    
    public abstract void b(long paramLong, List<a.a> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.scanlib.b.c
 * JD-Core Version:    0.7.0.1
 */