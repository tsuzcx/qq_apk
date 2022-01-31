package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.f;
import com.tencent.map.lib.mapstructure.Polygon2D;
import com.tencent.map.lib.util.StringUtil;
import java.util.ArrayList;
import java.util.List;
import javax.microedition.khronos.opengles.GL10;

public class lo
  extends ln
  implements iq, kj
{
  Polygon2D a;
  private ma b = null;
  private List<GeoPoint> c = new ArrayList();
  private Rect d;
  private kl e;
  private byte[] f = new byte[0];
  private lo.b g = new lo.b(null);
  private String h;
  private GeoPoint i = new GeoPoint();
  private Rect j = new Rect();
  private f k;
  private boolean l = false;
  private boolean m = false;
  private qj n;
  
  public lo(ma paramma, qj paramqj)
  {
    this.b = paramma;
    if ((this.b == null) || (this.b.getMap() == null)) {}
    do
    {
      return;
      this.a = new Polygon2D();
      this.a.polygonId = -1;
      this.n = paramqj;
      this.k = this.b.getMap();
    } while ((paramqj == null) || (StringUtil.isEmpty(paramqj.g())));
    this.k.a(this);
  }
  
  private double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6)
  {
    return (paramDouble3 - paramDouble1) * (paramDouble6 - paramDouble2) - (paramDouble5 - paramDouble1) * (paramDouble4 - paramDouble2);
  }
  
  private double a(qc paramqc1, lo.a[] paramArrayOfa, qc paramqc2)
  {
    int i6 = paramArrayOfa.length;
    qc localqc1 = new qc(0.0D, 0.0D);
    qc localqc2 = new qc(0.0D, 0.0D);
    Object localObject = paramArrayOfa[0];
    qc localqc3 = localObject.a[0];
    localObject = localObject.a[1];
    double d1 = lr.a(paramqc1, localqc3, (qc)localObject);
    localqc1.a = localqc3.a;
    localqc1.b = localqc3.b;
    localqc2.a = ((qc)localObject).a;
    localqc2.b = ((qc)localObject).b;
    int i1 = 1;
    double d2;
    if (i1 < i6)
    {
      localObject = paramArrayOfa[i1];
      localqc3 = localObject.a[0];
      localObject = localObject.a[1];
      d2 = lr.a(paramqc1, localqc3, (qc)localObject);
      if (d2 >= d1) {
        break label421;
      }
      localqc1.a = localqc3.a;
      localqc1.b = localqc3.b;
      localqc2.a = ((qc)localObject).a;
      localqc2.b = ((qc)localObject).b;
      d1 = d2;
    }
    label264:
    label421:
    for (;;)
    {
      i1 += 1;
      break;
      int i2 = 0;
      localqc1 = lr.b(paramqc1, localqc1, localqc2);
      localqc2 = new qc(0.0D, 0.0D);
      d1 = 0.0D;
      int i3 = 0;
      i1 = 0;
      int i5;
      int i4;
      if (i3 == 0)
      {
        localqc3 = lr.a(paramqc1, localqc1, i2);
        d2 = lr.b(localqc3, localqc1);
        i5 = 0;
        i4 = i3;
        if (i5 < i6)
        {
          localObject = paramArrayOfa[i5];
          if (lr.a(localqc3, d2, localObject.a[0], localObject.a[1])) {
            i4 = 1;
          }
        }
        else
        {
          if (i4 != 0) {
            break label365;
          }
          localqc2.a = localqc3.a;
          localqc2.b = localqc3.b;
          i2 += 5;
          d1 = d2;
        }
      }
      for (;;)
      {
        i1 += 1;
        i3 = i4;
        break;
        i5 += 1;
        break label264;
        label365:
        if (i1 == 0)
        {
          localqc2.a = localqc3.a;
          localqc2.b = localqc3.b;
          d1 = d2;
          continue;
          paramqc2.a = localqc2.a;
          paramqc2.b = localqc2.b;
          return d1;
        }
      }
    }
  }
  
  private double a(lo.a[] paramArrayOfa, qc paramqc)
  {
    List localList = h();
    if ((localList == null) || (localList.isEmpty())) {
      return 0.0D;
    }
    localList = lq.a(localList);
    if ((localList == null) || (localList.isEmpty())) {
      return 0.0D;
    }
    int i3 = localList.size();
    qc[] arrayOfqc = new qc[i3];
    double[] arrayOfDouble = new double[i3];
    int i1 = 0;
    while (i1 < i3)
    {
      arrayOfqc[i1] = new qc(0.0D, 0.0D);
      arrayOfDouble[i1] = a((qc)localList.get(i1), paramArrayOfa, arrayOfqc[i1]);
      if (Double.isNaN(arrayOfDouble[i1])) {
        arrayOfDouble[i1] = 0.0D;
      }
      i1 += 1;
    }
    double d1 = arrayOfDouble[0];
    i1 = 1;
    int i2 = 0;
    while (i1 < i3)
    {
      double d2 = d1;
      if (arrayOfDouble[i1] > d1)
      {
        d2 = arrayOfDouble[i1];
        i2 = i1;
      }
      i1 += 1;
      d1 = d2;
    }
    paramqc.a = arrayOfqc[i2].a;
    paramqc.b = arrayOfqc[i2].b;
    return arrayOfDouble[i2];
  }
  
  private int a(Rect paramRect, String paramString)
  {
    return 1;
  }
  
  private int a(String paramString, GeoPoint paramGeoPoint, iu paramiu)
  {
    this.j = a(j());
    paramGeoPoint.setLatitudeE6(this.j.centerY());
    paramGeoPoint.setLongitudeE6(this.j.centerX());
    paramGeoPoint = new GeoPoint(this.j.top, this.j.left);
    GeoPoint localGeoPoint1 = new GeoPoint(this.j.top, this.j.right);
    GeoPoint localGeoPoint2 = new GeoPoint(this.j.bottom, this.j.right);
    GeoPoint localGeoPoint3 = new GeoPoint(this.j.bottom, this.j.left);
    paramGeoPoint = a(new DoublePoint[] { paramiu.b(paramGeoPoint), paramiu.b(localGeoPoint1), paramiu.b(localGeoPoint2), paramiu.b(localGeoPoint3) });
    return a(new Rect((int)paramGeoPoint[0].x, (int)paramGeoPoint[0].y, (int)paramGeoPoint[1].x, (int)paramGeoPoint[1].y), paramString);
  }
  
  private int a(String paramString, iu paramiu)
  {
    GeoPoint localGeoPoint1 = new GeoPoint(this.j.top, this.j.left);
    GeoPoint localGeoPoint2 = new GeoPoint(this.j.top, this.j.right);
    GeoPoint localGeoPoint3 = new GeoPoint(this.j.bottom, this.j.right);
    GeoPoint localGeoPoint4 = new GeoPoint(this.j.bottom, this.j.left);
    paramiu = a(new DoublePoint[] { paramiu.b(localGeoPoint1), paramiu.b(localGeoPoint2), paramiu.b(localGeoPoint3), paramiu.b(localGeoPoint4) });
    return a(new Rect((int)paramiu[0].x, (int)paramiu[0].y, (int)paramiu[1].x, (int)paramiu[1].y), paramString);
  }
  
  private Rect a(lo.a[] paramArrayOfa)
  {
    qc localqc = new qc(0.0D, 0.0D);
    double d1 = a(paramArrayOfa, localqc);
    double d2 = localqc.b;
    double d3 = localqc.a;
    return new Rect((int)((d2 + d1) * 1000000.0D), (int)((d3 + d1) * 1000000.0D), (int)((d2 - d1) * 1000000.0D), (int)((d3 - d1) * 1000000.0D));
  }
  
  private boolean a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7, double paramDouble8)
  {
    boolean bool2 = false;
    double d1 = (paramDouble3 - paramDouble1) * (paramDouble8 - paramDouble6) - (paramDouble4 - paramDouble2) * (paramDouble7 - paramDouble5);
    boolean bool1 = bool2;
    if (d1 != 0.0D)
    {
      paramDouble7 = ((paramDouble2 - paramDouble6) * (paramDouble7 - paramDouble5) - (paramDouble1 - paramDouble5) * (paramDouble8 - paramDouble6)) / d1;
      paramDouble1 = ((paramDouble2 - paramDouble6) * (paramDouble3 - paramDouble1) - (paramDouble1 - paramDouble5) * (paramDouble4 - paramDouble2)) / d1;
      bool1 = bool2;
      if (paramDouble7 >= 0.0D)
      {
        bool1 = bool2;
        if (paramDouble7 <= 1.0D)
        {
          bool1 = bool2;
          if (paramDouble1 >= 0.0D)
          {
            bool1 = bool2;
            if (paramDouble1 <= 1.0D) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean a(GeoPoint paramGeoPoint)
  {
    if ((this.c == null) || (this.c.size() <= 1)) {
      return false;
    }
    double d1 = paramGeoPoint.getLongitudeE6();
    double d2 = paramGeoPoint.getLatitudeE6();
    int i1 = 0;
    int i3 = this.c.size();
    int i2 = 0;
    GeoPoint localGeoPoint;
    double d3;
    double d4;
    double d5;
    double d6;
    if (i2 < i3 - 1)
    {
      paramGeoPoint = (GeoPoint)this.c.get(i2);
      localGeoPoint = (GeoPoint)this.c.get(i2 + 1);
      d3 = paramGeoPoint.getLongitudeE6();
      d4 = paramGeoPoint.getLatitudeE6();
      d5 = localGeoPoint.getLongitudeE6();
      d6 = localGeoPoint.getLatitudeE6();
      if (b(d1, d2, d3, d4, d5, d6)) {
        return true;
      }
      if (Math.abs(d6 - d4) < 1.E-009D) {
        break label495;
      }
      if (b(d3, d4, d1, d2, 180.0D, d2))
      {
        if (d4 <= d6) {
          break label495;
        }
        i1 += 1;
      }
    }
    label417:
    label495:
    for (;;)
    {
      i2 += 1;
      break;
      if (b(d5, d6, d1, d2, 180.0D, d2))
      {
        if (d6 > d4) {
          i1 += 1;
        }
      }
      else if (a(d3, d4, d5, d6, d1, d2, 180.0D, d2))
      {
        i1 += 1;
        continue;
        paramGeoPoint = (GeoPoint)this.c.get(i3 - 1);
        localGeoPoint = (GeoPoint)this.c.get(0);
        d3 = paramGeoPoint.getLongitudeE6();
        d4 = paramGeoPoint.getLatitudeE6();
        d5 = localGeoPoint.getLongitudeE6();
        d6 = localGeoPoint.getLatitudeE6();
        if (b(d1, d2, d3, d4, d5, d6)) {
          return true;
        }
        i2 = i1;
        if (Math.abs(d6 - d4) >= 1.E-009D)
        {
          if (!b(d3, d4, d1, d2, 180.0D, d2)) {
            break label417;
          }
          i2 = i1;
          if (d4 > d6) {
            i2 = i1 + 1;
          }
        }
        while (i2 % 2 == 1)
        {
          return true;
          if (b(d5, d6, d1, d2, 180.0D, d2))
          {
            i2 = i1;
            if (d6 > d4) {
              i2 = i1 + 1;
            }
          }
          else
          {
            i2 = i1;
            if (a(d3, d4, d5, d6, d1, d2, 180.0D, d2)) {
              i2 = i1 + 1;
            }
          }
        }
        return false;
      }
    }
  }
  
  private int[] a(int paramInt)
  {
    return new int[] { Color.red(paramInt), Color.green(paramInt), Color.blue(paramInt), Color.alpha(paramInt) };
  }
  
  private DoublePoint[] a(DoublePoint[] paramArrayOfDoublePoint)
  {
    int i2 = paramArrayOfDoublePoint.length;
    double d6 = paramArrayOfDoublePoint[0].x;
    double d4 = paramArrayOfDoublePoint[0].y;
    double d2 = paramArrayOfDoublePoint[0].x;
    double d1 = paramArrayOfDoublePoint[0].y;
    int i1 = 1;
    double d5;
    double d3;
    if (i1 < i2)
    {
      double d7 = paramArrayOfDoublePoint[i1].x;
      d5 = paramArrayOfDoublePoint[i1].y;
      d3 = d6;
      if (d7 < d6) {
        d3 = d7;
      }
      if (d7 <= d2) {
        break label169;
      }
      d2 = d7;
    }
    label169:
    for (;;)
    {
      d6 = d4;
      if (d5 < d4) {
        d6 = d5;
      }
      if (d5 > d1) {
        d1 = d5;
      }
      for (;;)
      {
        i1 += 1;
        d4 = d6;
        d6 = d3;
        break;
        return new DoublePoint[] { new DoublePoint(d6, d4), new DoublePoint(d2, d1) };
      }
    }
  }
  
  private void b(List<qc> paramList)
  {
    if (paramList == null) {}
    int i2;
    do
    {
      return;
      i2 = paramList.size();
    } while (i2 <= 0);
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject = (qc)paramList.get(i1);
      if (localObject != null)
      {
        localObject = lq.a((qc)localObject);
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
      i1 += 1;
    }
    a(localArrayList);
  }
  
  private boolean b(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (Math.abs(a(paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramDouble6)) < 1.E-009D)
    {
      bool1 = bool2;
      if ((paramDouble1 - paramDouble3) * (paramDouble1 - paramDouble5) <= 0.0D)
      {
        bool1 = bool2;
        if ((paramDouble2 - paramDouble4) * (paramDouble2 - paramDouble6) <= 0.0D) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private boolean b(iu paramiu)
  {
    if (this.a == null) {}
    do
    {
      return false;
      Object localObject2 = f();
      Object localObject4 = new GeoPoint(((Rect)localObject2).top, ((Rect)localObject2).left);
      Object localObject3 = new GeoPoint(((Rect)localObject2).bottom, ((Rect)localObject2).right);
      Object localObject1 = new GeoPoint(((Rect)localObject2).bottom, ((Rect)localObject2).left);
      localObject2 = new GeoPoint(((Rect)localObject2).top, ((Rect)localObject2).right);
      localObject4 = paramiu.b((GeoPoint)localObject4);
      localObject3 = paramiu.b((GeoPoint)localObject3);
      localObject1 = paramiu.b((GeoPoint)localObject1);
      paramiu = a(new DoublePoint[] { localObject4, paramiu.b((GeoPoint)localObject2), localObject3, localObject1 });
      paramiu = new Rect((int)paramiu[0].x, (int)paramiu[0].y, (int)paramiu[1].x, (int)paramiu[1].y);
    } while ((Math.abs(paramiu.width()) <= 5) || (Math.abs(paramiu.height()) <= 5));
    return true;
  }
  
  private kl c(iu paramiu)
  {
    if (this.k == null) {}
    String str;
    do
    {
      return null;
      str = this.n.g();
    } while (StringUtil.isEmpty(str));
    synchronized (this.f)
    {
      if (this.g == null) {
        this.g = new lo.b(null);
      }
      a(str, this.i, paramiu);
      return null;
    }
  }
  
  private void d(iu paramiu)
  {
    if (this.k == null) {}
    String str;
    do
    {
      return;
      str = this.n.g();
    } while (StringUtil.isEmpty(str));
    synchronized (this.f)
    {
      if (this.g == null) {
        this.g = new lo.b(null);
      }
      a(str, paramiu);
      return;
    }
  }
  
  private void i()
  {
    if ((this.b == null) || (this.b.getMap() == null)) {}
    while (((this.a.polygonId >= 0) && (!this.P)) || (this.c == null) || (this.c.size() <= 2)) {
      return;
    }
    this.a.color = a(this.L);
    this.a.borderColor = a(this.M);
    this.a.borderWidth = this.K;
    this.a.polygonMode = 1;
    this.a.zIndex = x();
    int i2 = this.c.size();
    this.a.points = new Point[i2];
    int i1 = 0;
    while (i1 < i2)
    {
      GeoPoint localGeoPoint = (GeoPoint)this.c.get(i1);
      this.a.points[i1] = new Point(localGeoPoint.getLongitudeE6(), localGeoPoint.getLatitudeE6());
      i1 += 1;
    }
    if (-1 == this.a.polygonId) {
      this.a.polygonId = this.b.getMap().a(this.a);
    }
    for (;;)
    {
      this.b.getMap().a();
      this.P = false;
      return;
      if (this.P) {
        this.b.getMap().b(this.a);
      }
    }
  }
  
  private lo.a[] j()
  {
    Object localObject = g();
    List localList = lq.a((List)localObject);
    int i2 = ((List)localObject).size();
    localObject = new ArrayList();
    int i1 = 0;
    while (i1 < i2 - 1)
    {
      ((List)localObject).add(new lo.a(this, (qc)localList.get(i1), (qc)localList.get(i1 + 1)));
      i1 += 1;
    }
    ((List)localObject).add(new lo.a(this, (qc)localList.get(i2 - 1), (qc)localList.get(0)));
    return (lo.a[])((List)localObject).toArray(new lo.a[((List)localObject).size()]);
  }
  
  public Rect a(iu paramiu)
  {
    Rect localRect = new Rect();
    new Rect();
    if (this.a != null) {
      localRect = f();
    }
    if (this.e != null)
    {
      paramiu = this.e.a(paramiu);
      localRect.left = Math.min(localRect.left, paramiu.left);
      localRect.top = Math.min(localRect.top, paramiu.top);
      localRect.right = Math.max(localRect.right, paramiu.right);
      localRect.bottom = Math.max(localRect.bottom, paramiu.bottom);
    }
    return localRect;
  }
  
  public void a(je paramje, iu paramiu, GL10 paramGL10)
  {
    for (;;)
    {
      try
      {
        if (this.b != null)
        {
          f localf = this.b.getMap();
          if (localf != null) {}
        }
        else
        {
          return;
        }
        if (!a())
        {
          this.b.getMap().c(this.a.polygonId);
          this.a.polygonId = -1;
          continue;
        }
        if (!StringUtil.isEmpty(this.n.g())) {
          break label86;
        }
      }
      finally {}
      c();
      continue;
      label86:
      if (b(paramiu))
      {
        if (!this.l)
        {
          this.e = c(paramiu);
          this.l = true;
        }
        a(paramGL10);
        if (this.e != null)
        {
          this.e.b(paramje, paramiu);
          this.h = this.e.f();
          if (!this.m)
          {
            this.k.d(this.e.f(), e());
            this.m = true;
          }
        }
      }
    }
  }
  
  public void a(jo.c paramc)
  {
    if (paramc == jo.c.a) {}
    while (this.k == null) {
      return;
    }
    d(this.k.t());
  }
  
  public void a(qj paramqj)
  {
    if (paramqj == null) {
      return;
    }
    c(paramqj.d());
    b(paramqj.c());
    d(paramqj.b());
    c(paramqj.e());
    a_(paramqj.f());
    b(paramqj.a());
    this.P = true;
  }
  
  public void a(List<GeoPoint> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    label32:
    int i1;
    label42:
    GeoPoint localGeoPoint;
    if (this.c == null)
    {
      this.c = new ArrayList();
      int i3 = paramList.size();
      i1 = 0;
      if (i1 < i3)
      {
        localGeoPoint = (GeoPoint)paramList.get(i1);
        if (localGeoPoint != null)
        {
          i2 = 0;
          label67:
          if (i2 >= i1) {
            break label139;
          }
          if (!localGeoPoint.equals((GeoPoint)paramList.get(i2))) {
            break label132;
          }
        }
      }
    }
    label132:
    label139:
    for (int i2 = 1;; i2 = 0)
    {
      if (i2 == 0)
      {
        this.P = true;
        this.c.add(localGeoPoint);
      }
      i1 += 1;
      break label42;
      break;
      this.c.clear();
      break label32;
      i2 += 1;
      break label67;
    }
  }
  
  public void a(GL10 paramGL10)
  {
    if ((this.b == null) || (this.b.getMap() == null)) {
      return;
    }
    if (!a())
    {
      this.b.getMap().c(this.a.polygonId);
      this.a.polygonId = -1;
      return;
    }
    c();
  }
  
  public boolean a()
  {
    return this.O;
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public boolean a(iu paramiu, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void a_(boolean paramBoolean)
  {
    if ((this.b == null) || (this.b.getMap() == null)) {
      return;
    }
    this.O = paramBoolean;
    this.b.getMap().a();
  }
  
  public void b() {}
  
  public void b(je paramje, iu paramiu) {}
  
  public void c()
  {
    i();
  }
  
  public void d()
  {
    if ((this.b == null) || (this.k == null)) {
      return;
    }
    this.k.b(this);
    if (this.a != null) {
      this.b.getMap().c(this.a.polygonId);
    }
    if (this.c != null)
    {
      this.c.clear();
      this.c = null;
    }
    this.b = null;
    synchronized (this.f)
    {
      if (this.g != null)
      {
        this.g.a();
        this.g = null;
      }
      if (this.e != null)
      {
        this.k.b(this.e);
        this.e = null;
      }
      this.k = null;
      this.l = false;
      return;
    }
  }
  
  public int e()
  {
    if (this.a == null) {
      return -1;
    }
    return this.a.polygonId;
  }
  
  public Rect f()
  {
    if (this.d != null) {
      return this.d;
    }
    if ((this.c == null) || (this.c.isEmpty())) {
      return null;
    }
    GeoPoint localGeoPoint = (GeoPoint)this.c.get(0);
    int i3 = localGeoPoint.getLatitudeE6();
    int i1 = localGeoPoint.getLongitudeE6();
    int i7 = this.c.size();
    int i6 = 1;
    int i2 = i3;
    int i4 = i1;
    int i5 = i1;
    i1 = i6;
    while (i1 < i7)
    {
      localGeoPoint = (GeoPoint)this.c.get(i1);
      i6 = localGeoPoint.getLatitudeE6();
      int i8 = localGeoPoint.getLongitudeE6();
      i5 = Math.min(i5, i8);
      i4 = Math.max(i4, i8);
      i3 = Math.max(i3, i6);
      i2 = Math.min(i2, i6);
      i1 += 1;
    }
    this.d = new Rect(i5, i3, i4, i2);
    return this.d;
  }
  
  public List<GeoPoint> g()
  {
    return this.c;
  }
  
  public List<GeoPoint> h()
  {
    ArrayList localArrayList = new ArrayList(49);
    Object localObject = f();
    int i1 = ((Rect)localObject).left;
    int i2 = ((Rect)localObject).right;
    i2 = ((Rect)localObject).top;
    int i3 = ((Rect)localObject).bottom;
    i3 = Math.abs(((Rect)localObject).width());
    int i4 = Math.abs(((Rect)localObject).height());
    double d1 = i1 - 0.125D * i3;
    double d2 = i2 - 0.125D * i4;
    double d3 = i1 - 0.25D * i3;
    double d4 = i2 - 0.25D * i4;
    double d5 = i1 - 0.375D * i3;
    double d6 = i2 - 0.375D * i4;
    double d7 = i1 - 0.5D * i3;
    double d8 = i2 - 0.5D * i4;
    double d9 = i1 - 0.625D * i3;
    double d10 = i2 - 0.625D * i4;
    double d11 = i1 - 0.75D * i3;
    double d12 = i2 - 0.75D * i4;
    double d13 = i1 - i3 * 0.825D;
    double d14 = i2 - 0.825D * i4;
    localObject = new GeoPoint(new GeoPoint((int)d2, (int)d1));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d4, (int)d1));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d6, (int)d1));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d8, (int)d1));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d10, (int)d1));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d12, (int)d1));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d14, (int)d1));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d2, (int)d3));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d4, (int)d3));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d6, (int)d3));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d8, (int)d3));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d10, (int)d3));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d12, (int)d3));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d14, (int)d3));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d2, (int)d5));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d4, (int)d5));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d6, (int)d5));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d8, (int)d5));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d10, (int)d5));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d12, (int)d5));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d14, (int)d5));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d2, (int)d7));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d4, (int)d7));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d6, (int)d7));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d8, (int)d7));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d10, (int)d7));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d12, (int)d7));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d14, (int)d7));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d2, (int)d9));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d4, (int)d9));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d6, (int)d9));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d8, (int)d9));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d10, (int)d9));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d12, (int)d9));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d14, (int)d9));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d2, (int)d11));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d4, (int)d11));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d6, (int)d11));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d8, (int)d11));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d10, (int)d11));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d12, (int)d11));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d14, (int)d11));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d2, (int)d13));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d4, (int)d13));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d6, (int)d13));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d8, (int)d13));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d10, (int)d13));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d12, (int)d13));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    localObject = new GeoPoint(new GeoPoint((int)d14, (int)d13));
    if (a((GeoPoint)localObject)) {
      localArrayList.add(localObject);
    }
    return localArrayList;
  }
  
  public void t()
  {
    super.t();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.lo
 * JD-Core Version:    0.7.0.1
 */