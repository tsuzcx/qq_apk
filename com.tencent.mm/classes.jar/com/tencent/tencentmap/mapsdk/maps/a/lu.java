package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.f;
import com.tencent.map.lib.gl.JNICallback.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.be;
import com.tencent.tencentmap.mapsdk.a.cq;
import com.tencent.tencentmap.mapsdk.a.cr;
import com.tencent.tencentmap.mapsdk.a.cs;
import com.tencent.tencentmap.mapsdk.a.cs.a;
import com.tencent.tencentmap.mapsdk.a.cs.b;
import com.tencent.tencentmap.mapsdk.a.cs.c;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.microedition.khronos.opengles.GL10;

public class lu
  extends jx
  implements JNICallback.d, ho, hp, hr
{
  public static int a = 1;
  private static final TimeUnit d = TimeUnit.SECONDS;
  ArrayList<lx> b;
  ArrayList<lx> c;
  private int e;
  private final int f;
  private float[] g;
  private cs.a h;
  private kx i;
  private lv j;
  private cs.c k;
  private cs.b l;
  private my m;
  private final BlockingQueue<Runnable> n;
  private ThreadPoolExecutor o;
  private final BlockingQueue<Runnable> p;
  private ThreadPoolExecutor q;
  private int r;
  private be s;
  
  public lu(kx paramkx, cs paramcs)
  {
    AppMethodBeat.i(149234);
    this.f = 80;
    this.b = new ArrayList();
    this.c = new ArrayList();
    this.n = new LinkedBlockingQueue();
    this.p = new LinkedBlockingQueue();
    this.r = -1;
    this.h = paramcs.e();
    this.k = paramcs.b();
    this.e = paramcs.c();
    this.l = paramcs.d();
    if (this.l == null) {
      this.l = new lz();
    }
    a(paramkx);
    a(paramcs.a());
    this.s = new be();
    this.i.b().a(this);
    this.r = this.i.b().z();
    AppMethodBeat.o(149234);
  }
  
  private Bitmap a(lx paramlx)
  {
    AppMethodBeat.i(149242);
    int i1 = 256 / a;
    int i2 = 256 / a;
    Object localObject1 = paramlx.c();
    Object localObject3 = paramlx.d();
    double d1 = 1.0D / Math.pow(2.0D, 20 - paramlx.b());
    Object localObject2 = new DoublePoint(((DoublePoint)localObject1).x - this.e / d1, ((DoublePoint)localObject1).y - this.e / d1);
    localObject3 = new DoublePoint(((DoublePoint)localObject3).x + this.e / d1, ((DoublePoint)localObject3).y + this.e / d1);
    localObject2 = this.m.a((DoublePoint)localObject2, (DoublePoint)localObject3, d1);
    localObject3 = new ArrayList();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      ly locally = (ly)((Iterator)localObject2).next();
      DoublePoint localDoublePoint = locally.a();
      d1 = locally.b();
      double d2 = localDoublePoint.x;
      double d3 = ((DoublePoint)localObject1).x;
      double d4 = localDoublePoint.y;
      double d5 = ((DoublePoint)localObject1).y;
      double d6 = this.j.a(paramlx.b());
      ((List)localObject3).add(new cr((d2 - d3) * d6, d6 * (d4 - d5), d1));
    }
    if (this.h != null)
    {
      localObject2 = this.h.a((List)localObject3, this.g, this.e, 256, this.l);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (localObject2.length == 65536) {
          break label343;
        }
      }
    }
    for (localObject1 = a((List)localObject3, this.g, this.e, 256, this.l);; localObject1 = a((List)localObject3, this.g, this.e, 256, this.l)) {
      try
      {
        label343:
        localObject1 = Bitmap.createBitmap((int[])localObject1, i2, i1, Bitmap.Config.ARGB_8888);
        paramlx.a((Bitmap)localObject1);
        AppMethodBeat.o(149242);
        return localObject1;
      }
      catch (OutOfMemoryError paramlx)
      {
        AppMethodBeat.o(149242);
        return null;
      }
      catch (Exception paramlx)
      {
        break;
      }
    }
  }
  
  private void a(kx paramkx)
  {
    AppMethodBeat.i(149235);
    this.i = paramkx;
    this.j = new lv(this.i);
    this.m = new mz(this);
    this.o = new ThreadPoolExecutor(1, 1, 30L, d, this.n, new lu.1(this));
    this.q = new ThreadPoolExecutor(1, 1, 30L, d, this.p);
    if (this.h != null)
    {
      this.g = this.h.a(this.e);
      if ((this.g == null) || (this.g.length < this.e * 4 * this.e)) {
        System.err.println("Invalid fade out matrix, fail to default.");
      }
    }
    else
    {
      this.g = f();
    }
    this.i.b().a(this);
    this.i.b().a(this);
    this.i.b().a(this);
    AppMethodBeat.o(149235);
  }
  
  private void a(ArrayList<lx> paramArrayList)
  {
    AppMethodBeat.i(149239);
    if (paramArrayList == null)
    {
      AppMethodBeat.o(149239);
      return;
    }
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext()) {
      ((lx)localIterator.next()).a();
    }
    paramArrayList.clear();
    AppMethodBeat.o(149239);
  }
  
  private int[] a(List<cr> paramList, float[] paramArrayOfFloat, float paramFloat, int paramInt, cs.b paramb)
  {
    AppMethodBeat.i(149243);
    float[] arrayOfFloat = new float[paramInt * paramInt];
    int[] arrayOfInt = new int[paramInt * paramInt];
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        cr localcr = (cr)paramList.next();
        double d1 = localcr.c();
        double d2 = localcr.a();
        double d3 = localcr.b();
        if (d1 > 0.0D)
        {
          i1 = 0;
          while (i1 < 2.0F * paramFloat)
          {
            int i2 = 0;
            while (i2 < 2.0F * paramFloat)
            {
              int i3 = (int)(d2 - paramFloat + i1);
              int i4 = (int)(d3 - paramFloat + i2);
              if ((i4 >= 0) && (i3 >= 0) && (i4 < paramInt) && (i3 < paramInt))
              {
                i3 += i4 * paramInt;
                arrayOfFloat[i3] = ((float)(arrayOfFloat[i3] + paramArrayOfFloat[(i2 * 2 * this.e + i1)] * d1));
              }
              i2 += 1;
            }
            i1 += 1;
          }
        }
      }
      int i1 = 0;
      while (i1 < paramInt * paramInt)
      {
        if (arrayOfFloat[i1] > 0.0F) {
          arrayOfInt[i1] = paramb.colorForValue(arrayOfFloat[i1]);
        }
        i1 += 1;
      }
    }
    AppMethodBeat.o(149243);
    return arrayOfInt;
  }
  
  private float[] f()
  {
    AppMethodBeat.i(149237);
    float[] arrayOfFloat = new float[this.e * 2 * 2 * this.e];
    int i1 = 0;
    while (i1 < this.e * 2)
    {
      int i2 = 0;
      if (i2 < this.e * 2)
      {
        float f1 = (float)Math.sqrt((i1 - this.e) * (i1 - this.e) + (i2 - this.e) * (i2 - this.e));
        if (1.0F - f1 / this.e < 0.0F) {}
        for (f1 = 0.0F;; f1 = (float)((Math.exp(-f1 / 10.0D) - Math.exp(-this.e / 10.0D)) / Math.exp(0.0D)))
        {
          arrayOfFloat[(i2 * 2 * this.e + i1)] = f1;
          i2 += 1;
          break;
        }
      }
      i1 += 1;
    }
    AppMethodBeat.o(149237);
    return arrayOfFloat;
  }
  
  public Bitmap a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(149241);
    if (this.r == -1)
    {
      AppMethodBeat.o(149241);
      return null;
    }
    this.s.a(paramArrayOfByte);
    this.j.a().e();
    paramArrayOfByte = new lx(this.s.a(), this.s.b(), this.s.c());
    DoublePoint localDoublePoint1 = new DoublePoint(this.s.a() * 256 << 20 - this.s.c(), this.s.b() * 256 << 20 - this.s.c());
    DoublePoint localDoublePoint2 = new DoublePoint((this.s.a() + 1) * 256 << 20 - this.s.c(), (this.s.b() + 1) * 256 << 20 - this.s.c());
    paramArrayOfByte.a(localDoublePoint1);
    paramArrayOfByte.b(localDoublePoint2);
    paramArrayOfByte = a(paramArrayOfByte);
    AppMethodBeat.o(149241);
    return paramArrayOfByte;
  }
  
  public void a(double paramDouble)
  {
    AppMethodBeat.i(149246);
    if ((paramDouble > 1.0D) || (paramDouble < -1.0D)) {
      c();
    }
    AppMethodBeat.o(149246);
  }
  
  public void a(iq.c paramc)
  {
    AppMethodBeat.i(149245);
    if (paramc != iq.c.a) {
      c();
    }
    AppMethodBeat.o(149245);
  }
  
  public void a(List<cq> paramList)
  {
    AppMethodBeat.i(149236);
    try
    {
      this.q.execute(new lu.a(this, paramList));
      AppMethodBeat.o(149236);
      return;
    }
    catch (Exception paramList)
    {
      AppMethodBeat.o(149236);
    }
  }
  
  public void a(GL10 paramGL10) {}
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void b()
  {
    AppMethodBeat.i(149238);
    this.i.b().b(this);
    this.i.b().b(this);
    if (this.n != null) {
      this.n.clear();
    }
    if (this.o != null) {
      this.o.shutdownNow();
    }
    if (this.p != null) {
      this.p.clear();
    }
    if (this.q != null) {
      this.q.shutdownNow();
    }
    a(this.b);
    a(this.c);
    System.gc();
    AppMethodBeat.o(149238);
  }
  
  public void c() {}
  
  public void c_()
  {
    AppMethodBeat.i(149244);
    c();
    AppMethodBeat.o(149244);
  }
  
  public void d()
  {
    AppMethodBeat.i(149240);
    this.i.b().a(null);
    this.i.b().i(this.r);
    this.r = -1;
    this.s = null;
    b();
    AppMethodBeat.o(149240);
  }
  
  public lv e()
  {
    return this.j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.lu
 * JD-Core Version:    0.7.0.1
 */