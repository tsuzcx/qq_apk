package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.element.d;
import com.tencent.map.lib.element.e;
import com.tencent.map.lib.f;
import com.tencent.map.lib.util.SystemUtil;
import com.tencent.map.lib.util.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.bj;
import com.tencent.tencentmap.mapsdk.a.ci;
import com.tencent.tencentmap.mapsdk.a.ck;
import com.tencent.tencentmap.mapsdk.a.cz;
import com.tencent.tencentmap.mapsdk.a.dg;
import com.tencent.tencentmap.mapsdk.a.dj;
import com.tencent.tencentmap.mapsdk.a.dk;
import com.tencent.tencentmap.mapsdk.a.dk.a;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import javax.microedition.khronos.opengles.GL10;

public class jz
  extends jx
{
  private static final int[] w = { 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 3500, 2000, 1500, 1000, 720, 500, 320, 160, 80 };
  private boolean A;
  private boolean B;
  private int C;
  private GeoPoint D;
  private String E;
  private int F;
  private List<Integer> G;
  private int H;
  private final String R;
  private final float S;
  private kd.b T;
  protected byte[] a;
  private d b;
  private dj c;
  private ArrayList<jz.a> d;
  private ArrayList<GeoPoint> e;
  private float f;
  private kx g;
  private boolean h;
  private int[] i;
  private int[] j;
  private int[] k;
  private int l;
  private dk.a m;
  private ck n;
  private int o;
  private kd p;
  private float q;
  private jz.a r;
  private float s;
  private int t;
  private boolean u;
  private boolean v;
  private float x;
  private int y;
  private ArrayList<GeoPoint> z;
  
  public jz(kx paramkx)
  {
    AppMethodBeat.i(148877);
    this.b = null;
    this.c = null;
    this.a = new byte[0];
    this.d = null;
    this.e = null;
    this.g = null;
    this.h = false;
    this.i = null;
    this.j = null;
    this.k = null;
    this.l = -7829368;
    this.n = null;
    this.o = 12;
    this.r = null;
    this.s = 1.0F;
    this.t = 0;
    this.u = false;
    this.v = true;
    this.x = 0.0F;
    this.y = 0;
    this.A = false;
    this.B = false;
    this.C = -1;
    this.D = null;
    this.F = -1;
    this.H = 0;
    this.R = (A() + "_arrow_texture_");
    this.T = new jz.1(this);
    this.g = paramkx;
    this.d = new ArrayList();
    this.S = this.g.i().getResources().getDisplayMetrics().density;
    AppMethodBeat.o(148877);
  }
  
  private float a(jz.a parama1, jz.a parama2, GeoPoint paramGeoPoint, jz.a parama3)
  {
    AppMethodBeat.i(148894);
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
      f1 = (float)Math.hypot(i5 - i1, i6 - i2);
      AppMethodBeat.o(148894);
      return f1;
    }
    double d1 = (i3 - i1) * (i3 - i1) + (i4 - i2) * (i4 - i2);
    if (f1 >= d1)
    {
      parama3.setLatitudeE6(parama2.getLatitudeE6());
      parama3.setLongitudeE6(parama2.getLongitudeE6());
      parama3.a = parama2.a;
      f1 = (float)Math.hypot(i5 - i3, i6 - i4);
      AppMethodBeat.o(148894);
      return f1;
    }
    f1 = (float)(f1 / d1);
    float f2 = i1;
    f2 = (i3 - i1) * f1 + f2;
    float f3 = i2;
    f3 = (i4 - i2) * f1 + f3;
    parama3.setLongitudeE6(Math.round(f2));
    parama3.setLatitudeE6(Math.round(f3));
    parama1.a += (parama2.a - parama1.a) * f1;
    f1 = (float)Math.hypot(i5 - f2, i6 - f3);
    AppMethodBeat.o(148894);
    return f1;
  }
  
  private int a(Context paramContext, ck paramck)
  {
    AppMethodBeat.i(148908);
    if ((paramContext == null) || (paramck == null))
    {
      AppMethodBeat.o(148908);
      return 0;
    }
    paramck = paramck.a(paramContext);
    if (paramck == null)
    {
      AppMethodBeat.o(148908);
      return 0;
    }
    int i1 = paramck.getHeight();
    if (i1 <= 0)
    {
      AppMethodBeat.o(148908);
      return 0;
    }
    float f1 = SystemUtil.getDensity(paramContext);
    i1 = (int)(Math.pow(2.0D, 25.0D) / Math.pow(i1, 2.0D) / f1);
    AppMethodBeat.o(148908);
    return i1;
  }
  
  private dk.a a(dk.a parama)
  {
    if (parama != dk.a.a) {
      return parama;
    }
    if ((this.i != null) && (this.i.length > 0))
    {
      int i1 = 0;
      int i2 = this.i.length;
      while (i1 < i2)
      {
        if ((this.i[i1] < 0) || (this.i[i1] >= this.o)) {
          return dk.a.c;
        }
        i1 += 1;
      }
      return dk.a.b;
    }
    if ((this.M < 0) || (this.M >= this.o)) {
      return dk.a.c;
    }
    return dk.a.b;
  }
  
  private jz.a a(GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(148907);
    float f1 = 3.4028235E+38F;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = new jz.a();
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
          localObject3 = (jz.a)this.d.get(0);
          i1 = 1;
          localObject4 = localObject2;
          if (i1 < this.d.size())
          {
            localObject4 = (jz.a)this.d.get(i1);
            float f2 = a((jz.a)localObject3, (jz.a)localObject4, paramGeoPoint, (jz.a)localObject1);
            if (f2 >= f1) {
              break label164;
            }
            localObject3 = new jz.a();
            f1 = f2;
            localObject2 = localObject1;
            localObject1 = localObject3;
          }
        }
      }
    }
    label164:
    for (;;)
    {
      i1 += 1;
      localObject3 = localObject4;
      break;
      AppMethodBeat.o(148907);
      return localObject4;
    }
  }
  
  private jz.a a(jz.a parama1, jz.a parama2, float paramFloat)
  {
    AppMethodBeat.i(148892);
    jz.a locala = new jz.a();
    int i1 = parama2.getLongitudeE6();
    int i2 = parama1.getLongitudeE6();
    int i3 = parama2.getLatitudeE6();
    int i4 = parama1.getLatitudeE6();
    int i5 = parama1.getLatitudeE6();
    locala.setLatitudeE6(Math.round((i3 - i4) * paramFloat) + i5);
    i3 = parama1.getLongitudeE6();
    locala.setLongitudeE6(Math.round((i1 - i2) * paramFloat) + i3);
    parama1.a += (parama2.a - parama1.a) * paramFloat;
    AppMethodBeat.o(148892);
    return locala;
  }
  
  private void a(kc paramkc)
  {
    AppMethodBeat.i(148906);
    this.p = paramkc;
    this.p.a(this.T);
    this.p.a(null, null);
    if ((this.g != null) && (this.g.b() != null)) {
      this.g.b().a();
    }
    AppMethodBeat.o(148906);
  }
  
  private void a(kf paramkf)
  {
    AppMethodBeat.i(148905);
    if ((this.g == null) || (this.g.b() == null))
    {
      AppMethodBeat.o(148905);
      return;
    }
    this.p = paramkf;
    this.r = a(ka.a(paramkf.g()));
    if (this.r == null)
    {
      paramkf = new RuntimeException("Error, start point not found.");
      AppMethodBeat.o(148905);
      throw paramkf;
    }
    paramkf.a(this.T);
    paramkf.a(null, null);
    this.g.b().a();
    AppMethodBeat.o(148905);
  }
  
  private ArrayList<GeoPoint> c(List<jz.a> paramList)
  {
    AppMethodBeat.i(148891);
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.size() < 2))
    {
      AppMethodBeat.o(148891);
      return localArrayList;
    }
    float f2 = this.r.a;
    float f3 = this.x;
    float f4 = this.r.a;
    float f1 = this.s;
    float f5 = this.s;
    f1 = f2 - f1 * f2;
    f2 += (f3 - f4) * f5;
    Object localObject = null;
    int i1 = 0;
    jz.a locala1;
    if (i1 < paramList.size())
    {
      locala1 = (jz.a)paramList.get(i1);
      if ((locala1.a > f1) && (locala1.a < f2))
      {
        if ((localObject != null) && (((jz.a)localObject).a < f1))
        {
          f3 = locala1.a;
          f4 = ((jz.a)localObject).a;
          jz.a locala2 = a((jz.a)localObject, locala1, (f1 - ((jz.a)localObject).a) / (f3 - f4));
          locala2.b = ((jz.a)localObject).b;
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
        if ((localObject != null) && (((jz.a)localObject).a < f2))
        {
          f1 = locala1.a;
          f3 = ((jz.a)localObject).a;
          paramList = a((jz.a)localObject, locala1, (f2 - ((jz.a)localObject).a) / (f1 - f3));
          paramList.b = locala1.b;
          localArrayList.add(paramList);
        }
        AppMethodBeat.o(148891);
        return localArrayList;
      }
      if ((Float.compare(locala1.a, f1) == 0) || (Float.compare(locala1.a, f2) == 0)) {
        localArrayList.add(locala1);
      }
    }
  }
  
  private int[][] d(List<GeoPoint> paramList)
  {
    AppMethodBeat.i(148893);
    int i1;
    if ((this.i == null) || (this.j == null) || (paramList == null) || (this.i.length == 0) || (this.j.length == 0) || (paramList.isEmpty()))
    {
      i1 = this.M;
      if (this.m != dk.a.b) {
        break label561;
      }
      i1 = e(i1);
    }
    label432:
    label561:
    for (;;)
    {
      paramList = (int[][])Array.newInstance(Integer.TYPE, new int[] { 2, 1 });
      paramList[0][0] = i1;
      paramList[1][0] = 0;
      AppMethodBeat.o(148893);
      return paramList;
      if ((this.i != null) && (this.j != null)) {}
      for (int i2 = Math.min(this.i.length, this.j.length);; i2 = 0)
      {
        int[] arrayOfInt = new int[i2];
        i1 = 0;
        while (i1 < i2)
        {
          arrayOfInt[i1] = this.i[i1];
          if (this.m == dk.a.b) {
            arrayOfInt[i1] = e(arrayOfInt[i1]);
          }
          i1 += 1;
        }
        TreeMap localTreeMap = new TreeMap();
        Object localObject1 = (jz.a)paramList.get(0);
        i1 = 1;
        if (i1 < i2) {
          if (((jz.a)localObject1).b <= this.j[i1]) {
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
          Object localObject2;
          for (;;)
          {
            if (i3 >= paramList.size()) {
              break label432;
            }
            localObject2 = (jz.a)paramList.get(i3);
            i4 = i1;
            for (;;)
            {
              if ((i4 < i2) && (((jz.a)localObject2).b > this.j[i4]) && (((jz.a)localObject1).b <= this.j[i4]))
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
          i1 = localTreeMap.size();
          paramList = (int[][])Array.newInstance(Integer.TYPE, new int[] { 2, i1 });
          localObject1 = localTreeMap.entrySet().iterator();
          i1 = 0;
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (Map.Entry)((Iterator)localObject1).next();
            paramList[0][i1] = ((Integer)((Map.Entry)localObject2).getValue()).intValue();
            paramList[1][i1] = ((Integer)((Map.Entry)localObject2).getKey()).intValue();
            i1 += 1;
          }
          AppMethodBeat.o(148893);
          return paramList;
        }
      }
    }
  }
  
  private int e(int paramInt)
  {
    if (paramInt >= this.o) {
      paramInt = this.o - 1;
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
  
  private void k()
  {
    AppMethodBeat.i(148883);
    if ((this.g == null) || (this.g.b() == null))
    {
      AppMethodBeat.o(148883);
      return;
    }
    if (!a())
    {
      if (this.b != null)
      {
        this.g.b().b(this.b);
        this.b.B();
        this.b = null;
      }
      AppMethodBeat.o(148883);
      return;
    }
    if ((this.e == null) || (this.e.size() < 2))
    {
      AppMethodBeat.o(148883);
      return;
    }
    if (this.b == null)
    {
      this.g.b();
      this.b = new d(m());
      this.g.b().a(this.b);
    }
    for (;;)
    {
      this.b.a(this.C, this.D);
      this.g.b().a();
      AppMethodBeat.o(148883);
      return;
      this.b.a(m());
    }
  }
  
  private void l()
  {
    AppMethodBeat.i(148885);
    if ((this.g != null) && (this.g.b() != null) && (this.b != null))
    {
      this.g.b().b(this.b);
      this.b = null;
    }
    AppMethodBeat.o(148885);
  }
  
  private e m()
  {
    AppMethodBeat.i(148886);
    if ((this.g == null) || (this.g.b() == null))
    {
      AppMethodBeat.o(148886);
      return null;
    }
    e locale = new e();
    if ((this.n != null) && (this.n.a() != null)) {
      locale.a(this.n.a().a());
    }
    int[][] arrayOfInt = d(this.e);
    locale.c(this.h);
    locale.d(this.F);
    locale.a(this.e);
    locale.a(this.l);
    int i1;
    float f1;
    label171:
    int[] arrayOfInt1;
    if (this.t == 0)
    {
      i1 = a(this.g.i(), this.n);
      if (i1 > 0) {
        if (this.K > i1)
        {
          f1 = i1;
          locale.b(f1);
          if (this.m == dk.a.c)
          {
            locale.b(true);
            if (this.f * 2.0F > this.K) {
              this.f = (this.K / 3.0F);
            }
            locale.c(this.f);
          }
          arrayOfInt1 = f();
          if (!this.v) {
            break label462;
          }
          locale.a(arrayOfInt[1]);
          if ((this.f <= 0.0F) || (arrayOfInt1 == null) || (arrayOfInt1.length <= 0)) {
            break label449;
          }
          locale.a(arrayOfInt[0], arrayOfInt1);
        }
      }
    }
    for (;;)
    {
      locale.a(this.q);
      locale.b(this.t);
      locale.c((int)this.N);
      locale.e(this.u);
      if ((this.y > 0) && (this.y <= 3)) {
        locale.a(this.y, this.z);
      }
      locale.f(this.A);
      locale.a(this.B);
      locale.d(this.v);
      locale.b(this.E);
      locale.b(this.G);
      locale.d(this.Q);
      AppMethodBeat.o(148886);
      return locale;
      f1 = this.K;
      break;
      locale.b(this.K);
      break label171;
      locale.b(this.K);
      break label171;
      label449:
      locale.b(arrayOfInt[0]);
      continue;
      label462:
      locale.a(new int[] { 0 });
      if ((this.f > 0.0F) && (arrayOfInt1 != null) && (arrayOfInt1.length > 0))
      {
        i1 = this.M;
        int i2 = arrayOfInt1[0];
        locale.a(new int[] { i1 }, new int[] { i2 });
      }
      else
      {
        locale.b(new int[] { this.M });
      }
    }
  }
  
  public float a(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2)
  {
    AppMethodBeat.i(148890);
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
    AppMethodBeat.o(148890);
    return f1;
  }
  
  public void a(float paramFloat)
  {
    this.q = paramFloat;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148900);
    if (this.b == null)
    {
      AppMethodBeat.o(148900);
      return;
    }
    this.b.p();
    this.b.a(paramInt1, paramInt2);
    k();
    AppMethodBeat.o(148900);
  }
  
  public void a(int paramInt, cz paramcz)
  {
    AppMethodBeat.i(148901);
    paramcz = ka.a(paramcz);
    if ((paramInt == -1) || (paramcz == null))
    {
      AppMethodBeat.o(148901);
      return;
    }
    this.C = paramInt;
    this.D = paramcz;
    c();
    AppMethodBeat.o(148901);
  }
  
  public void a(int paramInt, List<cz> paramList)
  {
    AppMethodBeat.i(148878);
    this.y = paramInt;
    if (paramList == null)
    {
      AppMethodBeat.o(148878);
      return;
    }
    int i1 = paramList.size();
    if (i1 <= 0)
    {
      AppMethodBeat.o(148878);
      return;
    }
    this.z = new ArrayList();
    paramInt = 0;
    while (paramInt < i1)
    {
      Object localObject = (cz)paramList.get(paramInt);
      if (localObject != null)
      {
        localObject = ka.a((cz)localObject);
        if (localObject != null) {
          this.z.add(localObject);
        }
      }
      paramInt += 1;
    }
    AppMethodBeat.o(148878);
  }
  
  public void a(Bitmap paramBitmap)
  {
    AppMethodBeat.i(148879);
    b.b(this.R + this.H);
    Object localObject = new StringBuilder().append(this.R);
    int i1 = this.H + 1;
    this.H = i1;
    localObject = i1;
    b.a((String)localObject, paramBitmap);
    this.E = ((String)localObject);
    AppMethodBeat.o(148879);
  }
  
  public void a(ck paramck)
  {
    AppMethodBeat.i(148884);
    if ((this.g == null) || (this.g.b() == null) || (paramck == null) || (paramck.a() == null))
    {
      AppMethodBeat.o(148884);
      return;
    }
    this.n = paramck;
    paramck = this.n.a(this.g.i());
    b.a(this.n.a().a(), paramck);
    this.m = dk.a.b;
    AppMethodBeat.o(148884);
  }
  
  public void a(dj paramdj)
  {
    this.c = paramdj;
  }
  
  public void a(dk paramdk)
  {
    AppMethodBeat.i(148881);
    if ((this.g == null) || (this.g.b() == null) || (paramdk == null))
    {
      AppMethodBeat.o(148881);
      return;
    }
    if (paramdk.f() == -1.0F) {
      d(9.0F);
    }
    for (;;)
    {
      c(paramdk.g());
      c(paramdk.i());
      a(paramdk.k());
      a(paramdk.n());
      c(paramdk.l());
      a(paramdk.r());
      e(paramdk.o());
      b(paramdk.x());
      b(paramdk.y());
      this.k = paramdk.z();
      this.J = paramdk.j();
      this.t = paramdk.q();
      this.Q = paramdk.t();
      this.l = paramdk.d();
      if ((paramdk.m()) && (this.Q == dg.a)) {
        this.Q = dg.c;
      }
      a(paramdk.e());
      a(paramdk.a(), paramdk.b());
      if (paramdk.u() != null) {
        a(paramdk.u().a(this.g.i()));
      }
      b(paramdk.v());
      this.v = paramdk.s();
      ci localci = paramdk.p();
      if (localci != null) {
        a(localci.a);
      }
      Object localObject = paramdk.h();
      if ((localObject != null) && (localObject.length == 2))
      {
        localci = localObject[0];
        localObject = localObject[1];
        if ((localci != null) && (localObject != null) && (localci.length == localObject.length)) {
          a(localci, (int[])localObject);
        }
      }
      this.m = a(paramdk.c());
      k();
      AppMethodBeat.o(148881);
      return;
      d(paramdk.f());
    }
  }
  
  public void a(kd paramkd)
  {
    AppMethodBeat.i(148904);
    if (this.p != null)
    {
      this.p.b();
      this.p.a(null);
    }
    if ((paramkd instanceof kf))
    {
      a((kf)paramkd);
      AppMethodBeat.o(148904);
      return;
    }
    if ((paramkd instanceof kc))
    {
      a((kc)paramkd);
      AppMethodBeat.o(148904);
      return;
    }
    this.p = null;
    AppMethodBeat.o(148904);
  }
  
  public void a(List<cz> paramList)
  {
    AppMethodBeat.i(148880);
    this.x = 0.0F;
    this.d.clear();
    if (paramList == null)
    {
      AppMethodBeat.o(148880);
      return;
    }
    int i2 = paramList.size();
    if (i2 <= 0)
    {
      AppMethodBeat.o(148880);
      return;
    }
    Object localObject1 = null;
    this.e = new ArrayList();
    int i1 = 0;
    if (i1 < i2)
    {
      Object localObject2 = (cz)paramList.get(i1);
      if (localObject2 == null) {
        break label189;
      }
      localObject2 = ka.a((cz)localObject2);
      if (localObject2 == null) {
        break label189;
      }
      localObject2 = new jz.a((GeoPoint)localObject2);
      this.e.add(localObject2);
      if (localObject1 != null)
      {
        this.x += a((GeoPoint)localObject2, (GeoPoint)localObject1);
        ((jz.a)localObject2).a = this.x;
        ((jz.a)localObject1).b += 1;
      }
      this.d.add(localObject2);
      localObject1 = localObject2;
    }
    label189:
    for (;;)
    {
      i1 += 1;
      break;
      AppMethodBeat.o(148880);
      return;
    }
  }
  
  public void a(GL10 paramGL10)
  {
    AppMethodBeat.i(148887);
    if (!a())
    {
      AppMethodBeat.o(148887);
      return;
    }
    b(paramGL10);
    AppMethodBeat.o(148887);
  }
  
  public void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(148898);
    this.i = paramArrayOfInt1;
    this.j = paramArrayOfInt2;
    this.m = a(dk.a.a);
    AppMethodBeat.o(148898);
  }
  
  public boolean a()
  {
    AppMethodBeat.i(148895);
    if (B() != null)
    {
      if ((this.O) && (this.I))
      {
        AppMethodBeat.o(148895);
        return true;
      }
      AppMethodBeat.o(148895);
      return false;
    }
    boolean bool = this.O;
    AppMethodBeat.o(148895);
    return bool;
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(148889);
    if ((this.g == null) || (this.g.b() == null) || (!a()))
    {
      AppMethodBeat.o(148889);
      return false;
    }
    if (this.b != null)
    {
      boolean bool = this.b.a(this.g.b().t(), paramFloat1, paramFloat2);
      AppMethodBeat.o(148889);
      return bool;
    }
    AppMethodBeat.o(148889);
    return false;
  }
  
  public void b() {}
  
  public void b(float paramFloat)
  {
    this.f = paramFloat;
  }
  
  public void b(int paramInt)
  {
    this.F = paramInt;
  }
  
  public void b(List<Integer> paramList)
  {
    this.G = paramList;
  }
  
  public void b(boolean paramBoolean)
  {
    this.u = paramBoolean;
  }
  
  protected boolean b(GL10 paramGL10)
  {
    AppMethodBeat.i(148888);
    if ((this.g == null) || (this.g.b() == null))
    {
      AppMethodBeat.o(148888);
      return false;
    }
    if ((this.p != null) && (this.p.e()))
    {
      this.p.d();
      if ((this.p instanceof kf))
      {
        this.e = c(this.d);
        if (this.e.size() >= 2) {
          k();
        }
      }
      for (;;)
      {
        this.g.b().a();
        if (this.p.f())
        {
          this.p.a(null);
          this.p = null;
        }
        AppMethodBeat.o(148888);
        return true;
        if ((this.p instanceof kc)) {
          k();
        }
      }
    }
    AppMethodBeat.o(148888);
    return false;
  }
  
  public void c()
  {
    AppMethodBeat.i(148896);
    k();
    AppMethodBeat.o(148896);
  }
  
  public void c(int paramInt)
  {
    AppMethodBeat.i(148882);
    super.c(paramInt);
    AppMethodBeat.o(148882);
  }
  
  public void c(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void d()
  {
    AppMethodBeat.i(148897);
    l();
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
    b.b(this.E);
    if ((this.n != null) && (this.n.a() != null)) {
      b.b(this.n.a().a());
    }
    AppMethodBeat.o(148897);
  }
  
  public void d(boolean paramBoolean)
  {
    AppMethodBeat.i(148902);
    this.A = paramBoolean;
    if (this.b != null) {
      this.b.a(paramBoolean);
    }
    AppMethodBeat.o(148902);
  }
  
  public void e(boolean paramBoolean)
  {
    this.B = paramBoolean;
  }
  
  public int[][] e()
  {
    if ((this.i == null) || (this.j == null)) {}
    while (this.i.length != this.j.length) {
      return null;
    }
    int i1 = this.i.length;
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { 2, i1 });
    arrayOfInt[0] = this.i;
    arrayOfInt[1] = this.j;
    return arrayOfInt;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(100154);
    if (paramObject == null)
    {
      AppMethodBeat.o(100154);
      return false;
    }
    if (!(paramObject instanceof jz))
    {
      AppMethodBeat.o(100154);
      return false;
    }
    paramObject = (jz)paramObject;
    boolean bool = TextUtils.equals(A(), paramObject.A());
    AppMethodBeat.o(100154);
    return bool;
  }
  
  public int[] f()
  {
    return this.k;
  }
  
  public void g()
  {
    AppMethodBeat.i(148899);
    if (this.b == null)
    {
      AppMethodBeat.o(148899);
      return;
    }
    this.b.p();
    AppMethodBeat.o(148899);
  }
  
  public dj h()
  {
    return this.c;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(100155);
    int i1 = A().hashCode();
    AppMethodBeat.o(100155);
    return i1;
  }
  
  public Rect i()
  {
    AppMethodBeat.i(148903);
    Rect localRect = this.b.u();
    AppMethodBeat.o(148903);
    return localRect;
  }
  
  public d j()
  {
    return this.b;
  }
  
  public boolean r()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.jz
 * JD-Core Version:    0.7.0.1
 */