package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.element.j;
import com.tencent.map.lib.element.l;
import com.tencent.map.lib.f;
import com.tencent.map.lib.mapstructure.Polygon2D;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.cz;
import com.tencent.tencentmap.mapsdk.a.di;
import java.util.ArrayList;
import java.util.List;
import javax.microedition.khronos.opengles.GL10;

public class jy
  extends jx
  implements j, hr
{
  Polygon2D a;
  private List<GeoPoint> b;
  private Rect c;
  private l d;
  private byte[] e;
  private jy.a f;
  private String g;
  private GeoPoint h;
  private Rect i;
  private f j;
  private boolean k;
  private boolean l;
  private di m;
  
  public jy(kx paramkx, di paramdi)
  {
    AppMethodBeat.i(148855);
    this.b = new ArrayList();
    this.e = new byte[0];
    this.f = new jy.a(null);
    this.h = new GeoPoint();
    this.i = new Rect();
    this.k = false;
    this.l = false;
    if ((paramkx == null) || (paramkx.b() == null))
    {
      AppMethodBeat.o(148855);
      return;
    }
    this.a = new Polygon2D();
    this.a.polygonId = -1;
    this.m = paramdi;
    this.j = paramkx.b();
    if ((paramdi != null) && (!StringUtil.isEmpty(paramdi.g()))) {
      this.j.a(this);
    }
    AppMethodBeat.o(148855);
  }
  
  private int a(Rect paramRect, String paramString)
  {
    return 1;
  }
  
  private int a(String paramString, hu paramhu)
  {
    AppMethodBeat.i(148873);
    GeoPoint localGeoPoint1 = new GeoPoint(this.i.top, this.i.left);
    GeoPoint localGeoPoint2 = new GeoPoint(this.i.top, this.i.right);
    GeoPoint localGeoPoint3 = new GeoPoint(this.i.bottom, this.i.right);
    GeoPoint localGeoPoint4 = new GeoPoint(this.i.bottom, this.i.left);
    paramhu = a(new DoublePoint[] { paramhu.b(localGeoPoint1), paramhu.b(localGeoPoint2), paramhu.b(localGeoPoint3), paramhu.b(localGeoPoint4) });
    int n = a(new Rect((int)paramhu[0].x, (int)paramhu[0].y, (int)paramhu[1].x, (int)paramhu[1].y), paramString);
    AppMethodBeat.o(148873);
    return n;
  }
  
  private DoublePoint[] a(DoublePoint[] paramArrayOfDoublePoint)
  {
    AppMethodBeat.i(148872);
    int i1 = paramArrayOfDoublePoint.length;
    double d6 = paramArrayOfDoublePoint[0].x;
    double d4 = paramArrayOfDoublePoint[0].y;
    double d2 = paramArrayOfDoublePoint[0].x;
    double d1 = paramArrayOfDoublePoint[0].y;
    int n = 1;
    double d5;
    double d3;
    if (n < i1)
    {
      double d7 = paramArrayOfDoublePoint[n].x;
      d5 = paramArrayOfDoublePoint[n].y;
      d3 = d6;
      if (d7 < d6) {
        d3 = d7;
      }
      if (d7 <= d2) {
        break label185;
      }
      d2 = d7;
    }
    label185:
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
        n += 1;
        d4 = d6;
        d6 = d3;
        break;
        paramArrayOfDoublePoint = new DoublePoint(d6, d4);
        DoublePoint localDoublePoint = new DoublePoint(d2, d1);
        AppMethodBeat.o(148872);
        return new DoublePoint[] { paramArrayOfDoublePoint, localDoublePoint };
      }
    }
  }
  
  private void b(List<cz> paramList)
  {
    AppMethodBeat.i(148858);
    if (paramList == null)
    {
      AppMethodBeat.o(148858);
      return;
    }
    int i1 = paramList.size();
    if (i1 <= 0)
    {
      AppMethodBeat.o(148858);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int n = 0;
    while (n < i1)
    {
      Object localObject = (cz)paramList.get(n);
      if (localObject != null)
      {
        localObject = ka.a((cz)localObject);
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
      n += 1;
    }
    a(localArrayList);
    AppMethodBeat.o(148858);
  }
  
  private boolean b(hu paramhu)
  {
    AppMethodBeat.i(148870);
    if (this.a == null)
    {
      AppMethodBeat.o(148870);
      return false;
    }
    Object localObject2 = f();
    Object localObject4 = new GeoPoint(((Rect)localObject2).top, ((Rect)localObject2).left);
    Object localObject3 = new GeoPoint(((Rect)localObject2).bottom, ((Rect)localObject2).right);
    Object localObject1 = new GeoPoint(((Rect)localObject2).bottom, ((Rect)localObject2).left);
    localObject2 = new GeoPoint(((Rect)localObject2).top, ((Rect)localObject2).right);
    localObject4 = paramhu.b((GeoPoint)localObject4);
    localObject3 = paramhu.b((GeoPoint)localObject3);
    localObject1 = paramhu.b((GeoPoint)localObject1);
    paramhu = a(new DoublePoint[] { localObject4, paramhu.b((GeoPoint)localObject2), localObject3, localObject1 });
    paramhu = new Rect((int)paramhu[0].x, (int)paramhu[0].y, (int)paramhu[1].x, (int)paramhu[1].y);
    if ((Math.abs(paramhu.width()) > 5) && (Math.abs(paramhu.height()) > 5))
    {
      AppMethodBeat.o(148870);
      return true;
    }
    AppMethodBeat.o(148870);
    return false;
  }
  
  private int[] b(int paramInt)
  {
    AppMethodBeat.i(148862);
    int n = Color.red(paramInt);
    int i1 = Color.green(paramInt);
    int i2 = Color.blue(paramInt);
    paramInt = Color.alpha(paramInt);
    AppMethodBeat.o(148862);
    return new int[] { n, i1, i2, paramInt };
  }
  
  private void c(hu paramhu)
  {
    AppMethodBeat.i(148871);
    if (this.j == null)
    {
      AppMethodBeat.o(148871);
      return;
    }
    String str = this.m.g();
    if (StringUtil.isEmpty(str))
    {
      AppMethodBeat.o(148871);
      return;
    }
    synchronized (this.e)
    {
      if (this.f == null) {
        this.f = new jy.a(null);
      }
      a(str, paramhu);
      AppMethodBeat.o(148871);
      return;
    }
  }
  
  private void g()
  {
    AppMethodBeat.i(148863);
    if (this.j == null)
    {
      AppMethodBeat.o(148863);
      return;
    }
    if ((this.a.polygonId >= 0) && (!this.P))
    {
      AppMethodBeat.o(148863);
      return;
    }
    if ((this.b == null) || (this.b.size() <= 2))
    {
      AppMethodBeat.o(148863);
      return;
    }
    this.a.color = b(this.L);
    this.a.borderColor = b(this.M);
    this.a.borderWidth = this.K;
    this.a.polygonMode = 1;
    this.a.zIndex = D();
    this.a.level = E();
    int i1 = this.b.size();
    this.a.points = new Point[i1];
    int n = 0;
    while (n < i1)
    {
      GeoPoint localGeoPoint = (GeoPoint)this.b.get(n);
      this.a.points[n] = new Point(localGeoPoint.getLongitudeE6(), localGeoPoint.getLatitudeE6());
      n += 1;
    }
    if (-1 == this.a.polygonId) {
      this.a.polygonId = this.j.a(this.a);
    }
    for (;;)
    {
      this.j.a();
      this.P = false;
      AppMethodBeat.o(148863);
      return;
      if (this.P) {
        this.j.b(this.a);
      }
    }
  }
  
  public Rect a(hu paramhu)
  {
    AppMethodBeat.i(148868);
    Rect localRect = new Rect();
    new Rect();
    if (this.a != null) {
      localRect = f();
    }
    if (this.d != null)
    {
      paramhu = this.d.a(paramhu);
      localRect.left = Math.min(localRect.left, paramhu.left);
      localRect.top = Math.min(localRect.top, paramhu.top);
      localRect.right = Math.max(localRect.right, paramhu.right);
      localRect.bottom = Math.max(localRect.bottom, paramhu.bottom);
    }
    AppMethodBeat.o(148868);
    return localRect;
  }
  
  public void a(di paramdi)
  {
    AppMethodBeat.i(148857);
    if (paramdi == null)
    {
      AppMethodBeat.o(148857);
      return;
    }
    d(paramdi.d());
    c(paramdi.c());
    d(paramdi.b());
    c(paramdi.e());
    a(paramdi.f());
    a_(paramdi.h());
    b(paramdi.a());
    this.P = true;
    AppMethodBeat.o(148857);
  }
  
  public void a(ih paramih, hu paramhu, GL10 paramGL10)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(148867);
        if (this.j == null)
        {
          AppMethodBeat.o(148867);
          return;
        }
        if (!a())
        {
          this.j.c(this.a.polygonId);
          this.a.polygonId = -1;
          AppMethodBeat.o(148867);
          continue;
        }
        if (!StringUtil.isEmpty(this.m.g())) {
          break label93;
        }
      }
      finally {}
      c();
      AppMethodBeat.o(148867);
      continue;
      label93:
      if (!b(paramhu))
      {
        AppMethodBeat.o(148867);
      }
      else
      {
        a(paramGL10);
        if (this.d != null)
        {
          this.d.b(paramih, paramhu);
          this.g = this.d.f();
          if (!this.l)
          {
            this.j.d(this.d.f(), e());
            this.l = true;
          }
        }
        AppMethodBeat.o(148867);
      }
    }
  }
  
  public void a(iq.c paramc)
  {
    AppMethodBeat.i(148869);
    if (paramc == iq.c.a)
    {
      AppMethodBeat.o(148869);
      return;
    }
    if (this.j != null) {
      c(this.j.t());
    }
    AppMethodBeat.o(148869);
  }
  
  public void a(List<GeoPoint> paramList)
  {
    AppMethodBeat.i(148856);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(148856);
      return;
    }
    int n;
    label54:
    GeoPoint localGeoPoint;
    if (this.b == null)
    {
      this.b = new ArrayList();
      int i2 = paramList.size();
      n = 0;
      if (n >= i2) {
        break label151;
      }
      localGeoPoint = (GeoPoint)paramList.get(n);
      if (localGeoPoint != null)
      {
        i1 = 0;
        label79:
        if (i1 >= n) {
          break label158;
        }
        if (!localGeoPoint.equals((GeoPoint)paramList.get(i1))) {
          break label144;
        }
      }
    }
    label144:
    label151:
    label158:
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 == 0)
      {
        this.P = true;
        this.b.add(localGeoPoint);
      }
      n += 1;
      break label54;
      this.b.clear();
      break;
      i1 += 1;
      break label79;
      AppMethodBeat.o(148856);
      return;
    }
  }
  
  public void a(GL10 paramGL10)
  {
    AppMethodBeat.i(148859);
    if (this.j == null)
    {
      AppMethodBeat.o(148859);
      return;
    }
    if (!a())
    {
      this.j.c(this.a.polygonId);
      this.a.polygonId = -1;
      AppMethodBeat.o(148859);
      return;
    }
    c();
    AppMethodBeat.o(148859);
  }
  
  public void a(boolean paramBoolean)
  {
    AppMethodBeat.i(148860);
    if (this.j == null)
    {
      AppMethodBeat.o(148860);
      return;
    }
    this.O = paramBoolean;
    this.j.a();
    AppMethodBeat.o(148860);
  }
  
  public boolean a()
  {
    return this.O;
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public boolean a(hu paramhu, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void b() {}
  
  public void b(ih paramih, hu paramhu) {}
  
  public void c()
  {
    AppMethodBeat.i(148861);
    g();
    AppMethodBeat.o(148861);
  }
  
  public void d()
  {
    AppMethodBeat.i(148865);
    if (this.j == null)
    {
      AppMethodBeat.o(148865);
      return;
    }
    this.j.b(this);
    if (this.a != null) {
      this.j.c(this.a.polygonId);
    }
    if (this.b != null)
    {
      this.b.clear();
      this.b = null;
    }
    synchronized (this.e)
    {
      if (this.f != null)
      {
        this.f.a();
        this.f = null;
      }
      if (this.d != null)
      {
        this.j.b(this.d);
        this.d = null;
      }
      this.k = false;
      AppMethodBeat.o(148865);
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
    AppMethodBeat.i(148866);
    if (this.c != null)
    {
      localObject = this.c;
      AppMethodBeat.o(148866);
      return localObject;
    }
    if ((this.b == null) || (this.b.isEmpty()))
    {
      AppMethodBeat.o(148866);
      return null;
    }
    Object localObject = (GeoPoint)this.b.get(0);
    int i2 = ((GeoPoint)localObject).getLatitudeE6();
    int n = ((GeoPoint)localObject).getLongitudeE6();
    int i6 = this.b.size();
    int i5 = 1;
    int i1 = i2;
    int i3 = n;
    int i4 = n;
    n = i5;
    while (n < i6)
    {
      localObject = (GeoPoint)this.b.get(n);
      i5 = ((GeoPoint)localObject).getLatitudeE6();
      int i7 = ((GeoPoint)localObject).getLongitudeE6();
      i4 = Math.min(i4, i7);
      i3 = Math.max(i3, i7);
      i2 = Math.max(i2, i5);
      i1 = Math.min(i1, i5);
      n += 1;
    }
    this.c = new Rect(i4, i2, i3, i1);
    localObject = this.c;
    AppMethodBeat.o(148866);
    return localObject;
  }
  
  public void z()
  {
    AppMethodBeat.i(148864);
    super.z();
    AppMethodBeat.o(148864);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.jy
 * JD-Core Version:    0.7.0.1
 */