package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.f;
import com.tencent.map.lib.util.SystemUtil;
import com.tencent.map.lib.util.b;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.map.lib.basemap.data.GeoPoint;>;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import javax.microedition.khronos.opengles.GL10;

public class lp
  extends ln
{
  private static final int[] v = { 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 3500, 2000, 1500, 1000, 720, 500, 320, 160, 80 };
  private boolean A = false;
  private String B;
  private int C = -1;
  private List<Integer> D;
  private int E = 0;
  private final String F = u() + "_arrow_texture_";
  private final float G;
  private lt.b H = new lp.1(this);
  protected byte[] a = new byte[0];
  private kd b = null;
  private qk c = null;
  private ArrayList<a> d = null;
  private ArrayList<GeoPoint> e = null;
  private float f;
  private ma g = null;
  private boolean h = false;
  private int[] i = null;
  private int[] j = null;
  private int[] k = null;
  private ql.a l;
  private pr m = null;
  private int n = 12;
  private lt o;
  private float p;
  private a q = null;
  private float r = 1.0F;
  private int s = 0;
  private boolean t = false;
  private boolean u = true;
  private float w = 0.0F;
  private int x = 0;
  private ArrayList<GeoPoint> y;
  private boolean z = false;
  
  public lp(ma paramma)
  {
    this.g = paramma;
    this.d = new ArrayList();
    this.G = paramma.getResources().getDisplayMetrics().density;
  }
  
  private float a(a parama1, a parama2, GeoPoint paramGeoPoint, a parama3)
  {
    int i1 = parama1.getLongitudeE6();
    int i2 = parama1.getLatitudeE6();
    int i3 = parama2.getLongitudeE6();
    int i4 = parama2.getLatitudeE6();
    int i5 = paramGeoPoint.getLongitudeE6();
    int i6 = paramGeoPoint.getLatitudeE6();
    float f1 = (i3 - i1) * (i5 - i1) + (i4 - i2) * (i6 - i2);
    if (f1 <= 0.0F)
    {
      parama3.setLatitudeE6(parama1.getLatitudeE6());
      parama3.setLongitudeE6(parama1.getLongitudeE6());
      parama3.a = parama1.a;
      return (float)Math.hypot(i5 - i1, i6 - i2);
    }
    double d1 = (i3 - i1) * (i3 - i1) + (i4 - i2) * (i4 - i2);
    if (f1 >= d1)
    {
      parama3.setLatitudeE6(parama2.getLatitudeE6());
      parama3.setLongitudeE6(parama2.getLongitudeE6());
      parama3.a = parama2.a;
      return (float)Math.hypot(i5 - i3, i6 - i4);
    }
    f1 = (float)(f1 / d1);
    float f2 = i1;
    f2 = (i3 - i1) * f1 + f2;
    float f3 = i2;
    f3 = (i4 - i2) * f1 + f3;
    parama3.setLongitudeE6(Math.round(f2));
    parama3.setLatitudeE6(Math.round(f3));
    parama1.a += (parama2.a - parama1.a) * f1;
    return (float)Math.hypot(i5 - f2, i6 - f3);
  }
  
  private int a(Context paramContext, pr parampr)
  {
    if ((paramContext == null) || (parampr == null)) {}
    int i1;
    do
    {
      do
      {
        return 0;
        parampr = parampr.a(paramContext);
      } while (parampr == null);
      i1 = parampr.getHeight();
    } while (i1 <= 0);
    float f1 = SystemUtil.getDensity(paramContext);
    return (int)(Math.pow(2.0D, 25.0D) / Math.pow(i1, 2.0D) / f1);
  }
  
  private a a(GeoPoint paramGeoPoint)
  {
    float f1 = 3.4028235E+38F;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = new a();
    Object localObject4 = localObject3;
    int i1;
    if (this.d != null)
    {
      localObject4 = localObject3;
      if (this.d.size() >= 2)
      {
        localObject4 = localObject3;
        if (paramGeoPoint != null)
        {
          localObject3 = (a)this.d.get(0);
          i1 = 1;
          localObject4 = localObject2;
          if (i1 < this.d.size())
          {
            localObject4 = (a)this.d.get(i1);
            float f2 = a((a)localObject3, (a)localObject4, paramGeoPoint, (a)localObject1);
            if (f2 >= f1) {
              break label151;
            }
            localObject3 = new a();
            f1 = f2;
            localObject2 = localObject1;
            localObject1 = localObject3;
          }
        }
      }
    }
    label151:
    for (;;)
    {
      i1 += 1;
      localObject3 = localObject4;
      break;
      return localObject4;
    }
  }
  
  private a a(a parama1, a parama2, float paramFloat)
  {
    a locala = new a();
    int i1 = parama2.getLongitudeE6();
    int i2 = parama1.getLongitudeE6();
    int i3 = parama2.getLatitudeE6();
    int i4 = parama1.getLatitudeE6();
    int i5 = parama1.getLatitudeE6();
    locala.setLatitudeE6(Math.round((i3 - i4) * paramFloat) + i5);
    i3 = parama1.getLongitudeE6();
    locala.setLongitudeE6(Math.round((i1 - i2) * paramFloat) + i3);
    parama1.a += (parama2.a - parama1.a) * paramFloat;
    return locala;
  }
  
  private ql.a a(ql.a parama)
  {
    if (parama != ql.a.a) {
      return parama;
    }
    if ((this.i != null) && (this.i.length > 0))
    {
      int i1 = 0;
      int i2 = this.i.length;
      while (i1 < i2)
      {
        if ((this.i[i1] < 0) || (this.i[i1] >= this.n)) {
          return ql.a.c;
        }
        i1 += 1;
      }
      return ql.a.b;
    }
    if ((this.M < 0) || (this.M >= this.n)) {
      return ql.a.c;
    }
    return ql.a.b;
  }
  
  private void a(ls paramls)
  {
    this.o = paramls;
    this.o.a(this.H);
    this.o.a(null, null);
    if ((this.g != null) && (this.g.getMap() != null)) {
      this.g.getMap().a();
    }
  }
  
  private void a(lv paramlv)
  {
    if ((this.g == null) || (this.g.getMap() == null)) {
      return;
    }
    this.o = paramlv;
    this.q = a(lq.a(paramlv.f()));
    if (this.q == null) {
      throw new RuntimeException("Error, start point not found.");
    }
    paramlv.a(this.H);
    paramlv.a(null, null);
    this.g.getMap().a();
  }
  
  private ArrayList<GeoPoint> c(List<a> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.size() < 2)) {
      return localArrayList;
    }
    float f2 = this.q.a;
    float f3 = this.w;
    float f4 = this.q.a;
    float f1 = this.r;
    float f5 = this.r;
    f1 = f2 - f1 * f2;
    f2 += (f3 - f4) * f5;
    Object localObject = null;
    int i1 = 0;
    a locala1;
    if (i1 < paramList.size())
    {
      locala1 = (a)paramList.get(i1);
      if ((locala1.a > f1) && (locala1.a < f2))
      {
        if ((localObject != null) && (((a)localObject).a < f1))
        {
          f3 = locala1.a;
          f4 = ((a)localObject).a;
          a locala2 = a((a)localObject, locala1, (f1 - ((a)localObject).a) / (f3 - f4));
          locala2.b = ((a)localObject).b;
          localArrayList.add(locala2);
        }
        localArrayList.add(locala1);
      }
    }
    for (;;)
    {
      i1 += 1;
      localObject = locala1;
      break;
      if (locala1.a > f2)
      {
        if ((localObject != null) && (((a)localObject).a < f2))
        {
          f1 = locala1.a;
          f3 = ((a)localObject).a;
          paramList = a((a)localObject, locala1, (f2 - ((a)localObject).a) / (f1 - f3));
          paramList.b = locala1.b;
          localArrayList.add(paramList);
        }
        return localArrayList;
      }
      if ((Float.compare(locala1.a, f1) == 0) || (Float.compare(locala1.a, f2) == 0)) {
        localArrayList.add(locala1);
      }
    }
  }
  
  private int d(int paramInt)
  {
    if (paramInt >= this.n) {
      paramInt = this.n - 1;
    }
    for (;;)
    {
      int i1 = paramInt;
      if (paramInt < 0) {
        i1 = 0;
      }
      return i1;
    }
  }
  
  private int[][] d(List<GeoPoint> paramList)
  {
    int i1;
    if ((this.i == null) || (this.j == null) || (paramList == null) || (this.i.length == 0) || (this.j.length == 0) || (paramList.isEmpty()))
    {
      i1 = this.M;
      if (this.l != ql.a.b) {
        break label544;
      }
      i1 = d(i1);
    }
    label544:
    for (;;)
    {
      paramList = (int[][])Array.newInstance(Integer.TYPE, new int[] { 2, 1 });
      paramList[0][0] = i1;
      paramList[1][0] = 0;
      return paramList;
      if ((this.i != null) && (this.j != null)) {}
      for (int i2 = Math.min(this.i.length, this.j.length);; i2 = 0)
      {
        int[] arrayOfInt = new int[i2];
        i1 = 0;
        while (i1 < i2)
        {
          arrayOfInt[i1] = this.i[i1];
          if (this.l == ql.a.b) {
            arrayOfInt[i1] = d(arrayOfInt[i1]);
          }
          i1 += 1;
        }
        TreeMap localTreeMap = new TreeMap();
        Object localObject1 = (a)paramList.get(0);
        i1 = 1;
        if (i1 < i2) {
          if (((a)localObject1).b <= this.j[i1]) {
            localTreeMap.put(Integer.valueOf(0), Integer.valueOf(arrayOfInt[(i1 - 1)]));
          }
        }
        for (int i4 = i1;; i4 = 0)
        {
          int i3 = i4;
          if (i1 == i2)
          {
            i3 = i4;
            if (localTreeMap.size() == 0)
            {
              localTreeMap.put(Integer.valueOf(0), Integer.valueOf(arrayOfInt[(i2 - 1)]));
              i3 = i2;
            }
          }
          i4 = 1;
          i1 = i3;
          i3 = i4;
          for (;;)
          {
            if (i3 >= paramList.size()) {
              break label420;
            }
            localObject2 = (a)paramList.get(i3);
            i4 = i1;
            for (;;)
            {
              if ((i4 < i2) && (((a)localObject2).b > this.j[i4]) && (((a)localObject1).b <= this.j[i4]))
              {
                localTreeMap.put(Integer.valueOf(i3 - 1), Integer.valueOf(arrayOfInt[i4]));
                i1 += 1;
                i4 += 1;
                continue;
                i1 += 1;
                break;
              }
            }
            localObject1 = localObject2;
            i3 += 1;
          }
          label420:
          i1 = localTreeMap.size();
          localObject1 = (int[][])Array.newInstance(Integer.TYPE, new int[] { 2, i1 });
          Object localObject2 = localTreeMap.entrySet().iterator();
          i1 = 0;
          for (;;)
          {
            paramList = (List<GeoPoint>)localObject1;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            paramList = (Map.Entry)((Iterator)localObject2).next();
            localObject1[0][i1] = ((Integer)paramList.getValue()).intValue();
            localObject1[1][i1] = ((Integer)paramList.getKey()).intValue();
            i1 += 1;
          }
        }
      }
    }
  }
  
  private void h()
  {
    if ((this.g == null) || (this.g.getMap() == null)) {}
    do
    {
      do
      {
        return;
        if (a()) {
          break;
        }
      } while (this.b == null);
      this.g.getMap().b(this.b);
      this.b.z();
      this.b = null;
      return;
    } while ((this.e == null) || (this.e.size() < 2));
    if (this.b == null)
    {
      this.g.getMap();
      this.b = new kd(j());
      this.g.getMap().a(this.b);
    }
    for (;;)
    {
      this.g.getMap().a();
      return;
      this.b.a(j());
    }
  }
  
  private void i()
  {
    if ((this.g != null) && (this.g.getMap() != null) && (this.b != null))
    {
      this.g.getMap().b(this.b);
      this.b = null;
    }
  }
  
  private ke j()
  {
    if ((this.g == null) || (this.g.getMap() == null)) {
      return null;
    }
    ke localke = new ke();
    if ((this.m != null) && (this.m.a() != null)) {
      localke.a(this.m.a().a());
    }
    int[][] arrayOfInt = d(this.e);
    localke.c(this.h);
    localke.d(this.C);
    localke.a(this.e);
    int i1;
    float f1;
    label149:
    int[] arrayOfInt1;
    if (this.s == 0)
    {
      i1 = a(this.g.getContext(), this.m);
      if (i1 > 0) {
        if (this.K > i1)
        {
          f1 = i1;
          localke.b(f1);
          if (this.l == ql.a.c)
          {
            localke.b(true);
            if (this.f * 2.0F > this.K) {
              this.f = (this.K / 3.0F);
            }
            localke.c(this.f);
          }
          arrayOfInt1 = e();
          if (!this.u) {
            break label425;
          }
          localke.a(arrayOfInt[1]);
          if ((this.f <= 0.0F) || (arrayOfInt1 == null) || (arrayOfInt1.length <= 0)) {
            break label412;
          }
          localke.a(arrayOfInt[0], arrayOfInt1);
        }
      }
    }
    for (;;)
    {
      localke.a(this.p);
      localke.a(this.s);
      localke.b((int)this.N);
      localke.e(this.t);
      if ((this.x > 0) && (this.x <= 3)) {
        localke.a(this.x, this.y);
      }
      localke.f(this.z);
      localke.a(this.A);
      localke.d(this.u);
      localke.b(this.B);
      localke.b(this.D);
      return localke;
      f1 = this.K;
      break;
      localke.b(this.K);
      break label149;
      localke.b(this.K);
      break label149;
      label412:
      localke.b(arrayOfInt[0]);
      continue;
      label425:
      localke.a(new int[] { 0 });
      if ((this.f > 0.0F) && (arrayOfInt1 != null) && (arrayOfInt1.length > 0))
      {
        i1 = this.M;
        int i2 = arrayOfInt1[0];
        localke.a(new int[] { i1 }, new int[] { i2 });
      }
      else
      {
        localke.b(new int[] { this.M });
      }
    }
  }
  
  public float a(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2)
  {
    float f2 = 0.0F;
    float f1 = f2;
    if (paramGeoPoint1 != null)
    {
      f1 = f2;
      if (paramGeoPoint2 != null)
      {
        f1 = f2;
        if (paramGeoPoint1 != null)
        {
          int i1 = paramGeoPoint1.getLatitudeE6();
          int i2 = paramGeoPoint2.getLatitudeE6();
          int i3 = paramGeoPoint1.getLongitudeE6();
          int i4 = paramGeoPoint2.getLongitudeE6();
          f1 = (float)(Math.hypot(i1 - i2, i3 - i4) + 0.0D);
        }
      }
    }
    return f1;
  }
  
  public void a(float paramFloat)
  {
    this.p = paramFloat;
  }
  
  public void a(int paramInt)
  {
    this.C = paramInt;
  }
  
  public void a(int paramInt, List<qc> paramList)
  {
    this.x = paramInt;
    if (paramList == null) {}
    for (;;)
    {
      return;
      int i1 = paramList.size();
      if (i1 > 0)
      {
        this.y = new ArrayList();
        paramInt = 0;
        while (paramInt < i1)
        {
          Object localObject = (qc)paramList.get(paramInt);
          if (localObject != null)
          {
            localObject = lq.a((qc)localObject);
            if (localObject != null) {
              this.y.add(localObject);
            }
          }
          paramInt += 1;
        }
      }
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    b.b(this.F + this.E);
    Object localObject = new StringBuilder().append(this.F);
    int i1 = this.E + 1;
    this.E = i1;
    localObject = i1;
    b.a((String)localObject, paramBitmap);
    this.B = ((String)localObject);
  }
  
  public void a(lt paramlt)
  {
    if (this.o != null)
    {
      this.o.a();
      this.o.a(null);
    }
    if ((paramlt instanceof lv))
    {
      a((lv)paramlt);
      return;
    }
    if ((paramlt instanceof ls))
    {
      a((ls)paramlt);
      return;
    }
    this.o = null;
  }
  
  public void a(pr parampr)
  {
    if ((this.g == null) || (this.g.getMap() == null) || (parampr == null) || (parampr.a() == null)) {
      return;
    }
    this.m = parampr;
    parampr = this.m.a(this.g.getContext().getApplicationContext());
    b.a(this.m.a().a(), parampr);
    this.l = ql.a.b;
  }
  
  public void a(qk paramqk)
  {
    this.c = paramqk;
  }
  
  public void a(ql paramql)
  {
    if ((this.g == null) || (this.g.getMap() == null) || (paramql == null)) {
      return;
    }
    if (paramql.e() == -1.0F)
    {
      d(this.G * 9.0F);
      b(paramql.f());
      if ((!paramql.l()) || (paramql.h() > 0)) {
        break label305;
      }
      c(1.0F);
    }
    for (;;)
    {
      a_(paramql.j());
      a(paramql.m());
      b(paramql.k());
      a(paramql.q());
      c(paramql.n());
      b(paramql.v());
      b(paramql.w());
      this.k = paramql.x();
      this.J = paramql.i();
      this.s = paramql.p();
      a(paramql.d());
      a(paramql.a(), paramql.b());
      if (paramql.s() != null) {
        a(paramql.s().a(this.g.getContext().getApplicationContext()));
      }
      a(paramql.t());
      this.u = paramql.r();
      pp localpp = paramql.o();
      if (localpp != null) {
        a(localpp.a);
      }
      Object localObject = paramql.g();
      if ((localObject != null) && (localObject.length == 2))
      {
        localpp = localObject[0];
        localObject = localObject[1];
        if ((localpp != null) && (localObject != null) && (localpp.length == localObject.length)) {
          a(localpp, (int[])localObject);
        }
      }
      this.l = a(paramql.c());
      h();
      return;
      d(paramql.e());
      break;
      label305:
      c(paramql.h());
    }
  }
  
  public void a(List<qc> paramList)
  {
    this.w = 0.0F;
    this.d.clear();
    if (paramList == null) {}
    int i2;
    do
    {
      return;
      i2 = paramList.size();
    } while (i2 <= 0);
    Object localObject1 = null;
    this.e = new ArrayList();
    int i1 = 0;
    label44:
    if (i1 < i2)
    {
      Object localObject2 = (qc)paramList.get(i1);
      if (localObject2 == null) {
        break label163;
      }
      localObject2 = lq.a((qc)localObject2);
      if (localObject2 == null) {
        break label163;
      }
      localObject2 = new a((GeoPoint)localObject2);
      this.e.add(localObject2);
      if (localObject1 != null)
      {
        this.w += a((GeoPoint)localObject2, (GeoPoint)localObject1);
        ((a)localObject2).a = this.w;
        ((a)localObject1).b += 1;
      }
      this.d.add(localObject2);
      localObject1 = localObject2;
    }
    label163:
    for (;;)
    {
      i1 += 1;
      break label44;
      break;
    }
  }
  
  public void a(GL10 paramGL10)
  {
    if (!a())
    {
      if (this.b != null) {
        this.b.z();
      }
      return;
    }
    h();
    b(paramGL10);
  }
  
  public void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    this.i = paramArrayOfInt1;
    this.j = paramArrayOfInt2;
    this.l = a(ql.a.a);
  }
  
  public boolean a()
  {
    if (v() != null) {
      return (this.O) && (this.I);
    }
    return this.O;
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    if ((this.g == null) || (this.g.getMap() == null) || (!a())) {}
    while (this.b == null) {
      return false;
    }
    return this.b.a(this.g.getMap().t(), paramFloat1, paramFloat2);
  }
  
  public void b() {}
  
  public void b(float paramFloat)
  {
    this.f = paramFloat;
  }
  
  public void b(int paramInt)
  {
    super.b(paramInt);
  }
  
  public void b(List<Integer> paramList)
  {
    this.D = paramList;
  }
  
  public void b(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  protected boolean b(GL10 paramGL10)
  {
    if ((this.g == null) || (this.g.getMap() == null)) {}
    while ((this.o == null) || (!this.o.d())) {
      return false;
    }
    this.o.c();
    if ((this.o instanceof lv))
    {
      this.e = c(this.d);
      if (this.e.size() >= 2) {
        h();
      }
    }
    for (;;)
    {
      this.g.getMap().a();
      if (this.o.e())
      {
        this.o.a(null);
        this.o = null;
      }
      return true;
      if ((this.o instanceof ls)) {
        h();
      }
    }
  }
  
  public void c()
  {
    h();
  }
  
  public void c(boolean paramBoolean)
  {
    this.A = paramBoolean;
  }
  
  public void d()
  {
    i();
    if (this.d != null)
    {
      this.d.clear();
      this.d = null;
    }
    if (this.e != null)
    {
      this.e.clear();
      this.e = null;
    }
    b.b(this.B);
    if ((this.m != null) && (this.m.a() != null)) {
      b.b(this.m.a().a());
    }
    this.g = null;
  }
  
  public int[] e()
  {
    return this.k;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof lp)) {
      return false;
    }
    paramObject = (lp)paramObject;
    return TextUtils.equals(u(), paramObject.u());
  }
  
  public qk f()
  {
    return this.c;
  }
  
  public kd g()
  {
    return this.b;
  }
  
  public int hashCode()
  {
    return u().hashCode();
  }
  
  public boolean n()
  {
    return true;
  }
  
  private static class a
    extends GeoPoint
  {
    float a = 0.0F;
    int b = 0;
    
    public a() {}
    
    public a(GeoPoint paramGeoPoint)
    {
      super();
    }
    
    public String toString()
    {
      return super.toString() + "," + this.a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.lp
 * JD-Core Version:    0.7.0.1
 */