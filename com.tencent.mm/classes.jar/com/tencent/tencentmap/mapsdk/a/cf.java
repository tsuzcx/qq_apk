package com.tencent.tencentmap.mapsdk.a;

import android.os.Handler;
import android.util.Log;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.d;
import com.tencent.map.lib.element.c;
import com.tencent.map.lib.f;
import com.tencent.map.lib.gl.JNICallback.e;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.hr;
import com.tencent.tencentmap.mapsdk.maps.a.iq.c;
import com.tencent.tencentmap.mapsdk.maps.a.ks;
import com.tencent.tencentmap.mapsdk.maps.a.kx;
import com.tencent.tencentmap.mapsdk.maps.a.nc;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

public class cf
  implements JNICallback.e, hr
{
  private q a;
  private m b;
  private boolean c;
  private kx d;
  private ah.f e;
  private Handler f;
  private f g;
  private boolean h;
  private cu i;
  private cz j;
  
  public cf(kx paramkx, String paramString)
  {
    AppMethodBeat.i(149964);
    this.e = null;
    this.f = new Handler();
    this.g = null;
    this.h = false;
    this.i = null;
    this.d = paramkx;
    if (this.d != null) {
      if (paramString != null) {
        break label142;
      }
    }
    label142:
    for (this.a = u.a(this.d.i());; this.a = s.a(this.d.i(), paramString))
    {
      g();
      this.c = false;
      a(this.c);
      this.g = this.d.b();
      if (this.g != null)
      {
        this.g.a(this);
        this.g.a(this);
        this.e = new ks(this.d);
      }
      AppMethodBeat.o(149964);
      return;
    }
  }
  
  private void a(String paramString1, String paramString2, String[] paramArrayOfString, int paramInt)
  {
    int k = 0;
    AppMethodBeat.i(149972);
    if ((this.d == null) || (this.d.b() == null))
    {
      AppMethodBeat.o(149972);
      return;
    }
    Object localObject = this.d.b();
    int m = ((f)localObject).c();
    if ((paramString1 != null) && (paramArrayOfString != null) && (paramArrayOfString.length > 0) && (paramInt >= 0) && (m >= 16))
    {
      if ((this.e != null) && (!this.h))
      {
        this.h = true;
        if ((this.d != null) && (this.d.j != null)) {
          this.d.j.b(true);
        }
        this.e.onIndoorBuildingFocused();
      }
      ((f)localObject).g(Math.min(this.d.i, 22));
      if (this.e != null)
      {
        localObject = new ArrayList();
        m = paramArrayOfString.length;
        while (k < m)
        {
          ((List)localObject).add(new cw(paramArrayOfString[k]));
          k += 1;
        }
        try
        {
          if ((this.i != null) && (this.i.a().equals(paramString1)))
          {
            k = this.i.d();
            if (k == paramInt)
            {
              AppMethodBeat.o(149972);
              return;
            }
          }
        }
        catch (Exception paramArrayOfString)
        {
          this.i = new cu(paramString1, paramString2, (List)localObject, paramInt);
          if ((this.d != null) && (this.d.j != null) && (this.d.j.b()) && (this.d.b().h() >= 16)) {
            this.d.j.a(this.i);
          }
          this.e.onIndoorLevelActivated(this.i);
        }
      }
      AppMethodBeat.o(149972);
      return;
    }
    i();
    if (this.h)
    {
      this.h = false;
      this.i = null;
      if ((this.d != null) && (this.d.j != null)) {
        this.d.j.b(false);
      }
      if (this.e != null) {
        this.e.onIndoorBuildingDeactivated();
      }
    }
    AppMethodBeat.o(149972);
  }
  
  private void g()
  {
    AppMethodBeat.i(149965);
    int k = this.a.b("AIEnabled");
    int m = this.a.b("AIType");
    try
    {
      JSONArray localJSONArray = new JSONArray(this.a.a("AIBuildingList"));
      if ((k != -1) && (m != -1) && (localJSONArray != null)) {
        this.b = new m(k, m, localJSONArray);
      }
      if ((this.g != null) && (m == 1)) {
        this.g.a(b());
      }
      AppMethodBeat.o(149965);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        d.b(Log.getStackTraceString(localException));
        Object localObject = null;
      }
    }
  }
  
  private boolean h()
  {
    AppMethodBeat.i(149968);
    if ((this.b != null) && (this.b.a() == 1))
    {
      AppMethodBeat.o(149968);
      return true;
    }
    AppMethodBeat.o(149968);
    return false;
  }
  
  private void i()
  {
    AppMethodBeat.i(149974);
    if ((this.d == null) || (this.d.b() == null) || (this.h))
    {
      AppMethodBeat.o(149974);
      return;
    }
    f localf = this.d.b();
    int k = Math.min(20, this.d.i);
    if (localf.j() < k) {
      localf.g(k);
    }
    AppMethodBeat.o(149974);
  }
  
  public int a()
  {
    AppMethodBeat.i(149969);
    if ((this.b != null) && (this.b.a() == 1))
    {
      AppMethodBeat.o(149969);
      return 1;
    }
    AppMethodBeat.o(149969);
    return 0;
  }
  
  public String a(cz paramcz)
  {
    AppMethodBeat.i(149979);
    if (this.i == null)
    {
      AppMethodBeat.o(149979);
      return null;
    }
    new cz(this.j.a, this.j.b);
    paramcz = this.i.b();
    AppMethodBeat.o(149979);
    return paramcz;
  }
  
  public void a(int paramInt)
  {
    AppMethodBeat.i(149976);
    if (this.g == null)
    {
      AppMethodBeat.o(149976);
      return;
    }
    this.g.f(paramInt);
    AppMethodBeat.o(149976);
  }
  
  public void a(m paramm)
  {
    AppMethodBeat.i(149966);
    this.b = paramm;
    if (this.b == null) {
      this.a.a(new String[] { "AIEnabled", "AIType", "AIBuildingList" });
    }
    for (;;)
    {
      this.f.post(new cf.1(this));
      AppMethodBeat.o(149966);
      return;
      this.a.a("AIEnabled", this.b.a());
      this.a.a("AIType", this.b.b());
      if (this.b.c() != null) {
        this.a.a("AIBuildingList", this.b.c().toString());
      }
      if ((this.g != null) && (a() == 1)) {
        this.g.a(b());
      }
    }
  }
  
  public void a(iq.c paramc)
  {
    AppMethodBeat.i(149973);
    if ((!this.c) || (this.d == null) || (this.d.b() == null) || (this.d.G() == null))
    {
      AppMethodBeat.o(149973);
      return;
    }
    if (this.h)
    {
      this.d.G().b(true);
      AppMethodBeat.o(149973);
      return;
    }
    this.d.G().b(false);
    i();
    AppMethodBeat.o(149973);
  }
  
  public void a(boolean paramBoolean)
  {
    AppMethodBeat.i(149967);
    this.c = paramBoolean;
    if (this.g == null)
    {
      AppMethodBeat.o(149967);
      return;
    }
    if (!h())
    {
      this.g.d(false);
      AppMethodBeat.o(149967);
      return;
    }
    if ((this.d != null) && (this.d.j != null)) {
      this.d.j.b(paramBoolean);
    }
    this.g.d(paramBoolean);
    if ((!paramBoolean) && (this.h))
    {
      this.h = false;
      this.i = null;
      if (this.e != null) {
        this.e.onIndoorBuildingDeactivated();
      }
    }
    AppMethodBeat.o(149967);
  }
  
  public cu b(cz paramcz)
  {
    AppMethodBeat.i(149980);
    new cz(this.j.a, this.j.b);
    paramcz = this.i;
    AppMethodBeat.o(149980);
    return paramcz;
  }
  
  public String[] b()
  {
    AppMethodBeat.i(149970);
    if (this.b != null)
    {
      String[] arrayOfString = this.b.d();
      AppMethodBeat.o(149970);
      return arrayOfString;
    }
    AppMethodBeat.o(149970);
    return null;
  }
  
  public boolean c()
  {
    return this.h;
  }
  
  public void d()
  {
    AppMethodBeat.i(149975);
    if (this.i != null)
    {
      String str = this.i.a();
      int k = this.i.d();
      Object localObject = this.i.c();
      if ((localObject == null) || (k >= ((List)localObject).size()))
      {
        AppMethodBeat.o(149975);
        return;
      }
      localObject = ((cw)((List)localObject).get(k)).a();
      if ((!StringUtil.isEmpty(str)) && (!StringUtil.isEmpty((String)localObject))) {
        this.d.b().a(str, (String)localObject);
      }
    }
    AppMethodBeat.o(149975);
  }
  
  public int e()
  {
    AppMethodBeat.i(149977);
    if (this.i == null)
    {
      AppMethodBeat.o(149977);
      return -1;
    }
    int k = this.i.d();
    AppMethodBeat.o(149977);
    return k;
  }
  
  public String[] f()
  {
    AppMethodBeat.i(149978);
    if ((this.i == null) || (this.i.c() == null) || (this.i.c().isEmpty()))
    {
      AppMethodBeat.o(149978);
      return null;
    }
    List localList = this.i.c();
    String[] arrayOfString = new String[localList.size()];
    int k = 0;
    while (k < localList.size())
    {
      arrayOfString[k] = ((cw)localList.get(k)).a();
      k += 1;
    }
    AppMethodBeat.o(149978);
    return arrayOfString;
  }
  
  public void y()
  {
    AppMethodBeat.i(149971);
    if ((!this.c) || (this.d == null) || (this.d.b() == null))
    {
      AppMethodBeat.o(149971);
      return;
    }
    Object localObject1 = this.d.b();
    Object localObject2 = new GeoPoint();
    localObject1 = ((f)localObject1).c((GeoPoint)localObject2);
    if (localObject1 == null)
    {
      AppMethodBeat.o(149971);
      return;
    }
    this.j = new cz(((GeoPoint)localObject2).getLatitudeE6() * 1.0D / 1000000.0D, ((GeoPoint)localObject2).getLongitudeE6() * 1.0D / 1000000.0D);
    localObject2 = ((c)localObject1).a;
    String str = ((c)localObject1).b;
    String[] arrayOfString = ((c)localObject1).d;
    int k = ((c)localObject1).c;
    this.f.post(new cf.2(this, (String)localObject2, str, arrayOfString, k));
    AppMethodBeat.o(149971);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.cf
 * JD-Core Version:    0.7.0.1
 */