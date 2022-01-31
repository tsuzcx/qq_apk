package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.element.j;
import com.tencent.map.lib.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.ie;
import com.tencent.tencentmap.mapsdk.maps.a.js;
import com.tencent.tencentmap.mapsdk.maps.a.jx;
import com.tencent.tencentmap.mapsdk.maps.a.ka;
import com.tencent.tencentmap.mapsdk.maps.a.kx;
import java.util.ArrayList;
import java.util.List;

public final class bo
  extends bs
  implements bz
{
  private kx a;
  
  public bo(ie paramie)
  {
    AppMethodBeat.i(149903);
    this.a = null;
    this.a = ((kx)paramie.getVectorMapDelegate());
    if (this.a == null)
    {
      AppMethodBeat.o(149903);
      return;
    }
    if (this.a.a(js.class) == null) {
      this.a.a(js.class, this);
    }
    AppMethodBeat.o(149903);
  }
  
  final co a(cp paramcp, bn parambn)
  {
    AppMethodBeat.i(149905);
    if (this.a == null)
    {
      AppMethodBeat.o(149905);
      return null;
    }
    js localjs = new js(this.a);
    localjs.a(paramcp);
    localjs.c();
    if (!this.a.a(localjs))
    {
      AppMethodBeat.o(149905);
      return null;
    }
    this.a.b().a();
    paramcp = new co(paramcp, parambn, localjs.A());
    AppMethodBeat.o(149905);
    return paramcp;
  }
  
  public final void a()
  {
    AppMethodBeat.i(149904);
    if (this.a != null)
    {
      this.a.b(js.class);
      this.a = null;
    }
    AppMethodBeat.o(149904);
  }
  
  final void a(String paramString)
  {
    AppMethodBeat.i(149906);
    if (this.a == null)
    {
      AppMethodBeat.o(149906);
      return;
    }
    synchronized (this.a.b)
    {
      paramString = this.a.b(paramString, false);
      if ((paramString == null) || (!(paramString instanceof js)))
      {
        AppMethodBeat.o(149906);
        return;
      }
      paramString.d();
      this.a.b().a();
      AppMethodBeat.o(149906);
      return;
    }
  }
  
  final void a(String paramString, double paramDouble)
  {
    AppMethodBeat.i(149909);
    if (this.a == null)
    {
      AppMethodBeat.o(149909);
      return;
    }
    synchronized (this.a.b)
    {
      paramString = this.a.b(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(149909);
        return;
      }
      if (!(paramString instanceof js))
      {
        AppMethodBeat.o(149909);
        return;
      }
      ((js)paramString).a(paramDouble);
      this.a.b().a();
      AppMethodBeat.o(149909);
      return;
    }
  }
  
  final void a(String paramString, float paramFloat)
  {
    AppMethodBeat.i(149911);
    if (this.a == null)
    {
      AppMethodBeat.o(149911);
      return;
    }
    synchronized (this.a.b)
    {
      paramString = this.a.b(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(149911);
        return;
      }
      if (!(paramString instanceof js))
      {
        AppMethodBeat.o(149911);
        return;
      }
      ((js)paramString).d(paramFloat);
      this.a.b().a();
      AppMethodBeat.o(149911);
      return;
    }
  }
  
  final void a(String paramString, int paramInt)
  {
    AppMethodBeat.i(149908);
    if (this.a == null)
    {
      AppMethodBeat.o(149908);
      return;
    }
    synchronized (this.a.b)
    {
      paramString = this.a.b(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(149908);
        return;
      }
      if (!(paramString instanceof js))
      {
        AppMethodBeat.o(149908);
        return;
      }
      ((js)paramString).d(paramInt);
      this.a.b().a();
      AppMethodBeat.o(149908);
      return;
    }
  }
  
  final void a(String paramString, cz paramcz)
  {
    AppMethodBeat.i(149907);
    if (this.a == null)
    {
      AppMethodBeat.o(149907);
      return;
    }
    if (paramcz == null)
    {
      AppMethodBeat.o(149907);
      return;
    }
    synchronized (this.a.b)
    {
      paramString = this.a.b(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(149907);
        return;
      }
      if (!(paramString instanceof js))
      {
        AppMethodBeat.o(149907);
        return;
      }
      ((js)paramString).a(ka.a(paramcz));
      this.a.b().a();
      AppMethodBeat.o(149907);
      return;
    }
  }
  
  final void a(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(149912);
    if (this.a == null)
    {
      AppMethodBeat.o(149912);
      return;
    }
    synchronized (this.a.b)
    {
      paramString = this.a.b(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(149912);
        return;
      }
      if (!(paramString instanceof js))
      {
        AppMethodBeat.o(149912);
        return;
      }
      ((js)paramString).a(paramBoolean);
      this.a.b().a();
      AppMethodBeat.o(149912);
      return;
    }
  }
  
  public final boolean a(jx paramjx, boolean paramBoolean, GeoPoint paramGeoPoint)
  {
    return false;
  }
  
  final List<j> b(String paramString)
  {
    AppMethodBeat.i(149916);
    if (this.a == null)
    {
      AppMethodBeat.o(149916);
      return null;
    }
    synchronized (this.a.b)
    {
      paramString = this.a.b(paramString);
      if ((paramString == null) || (!(paramString instanceof js)))
      {
        AppMethodBeat.o(149916);
        return null;
      }
      paramString = (js)paramString;
      ??? = new ArrayList(1);
      ((List)???).add(paramString);
      AppMethodBeat.o(149916);
      return ???;
    }
  }
  
  final void b()
  {
    AppMethodBeat.i(149915);
    if (this.a != null) {
      this.a.c(js.class);
    }
    AppMethodBeat.o(149915);
  }
  
  final void b(String paramString, float paramFloat)
  {
    AppMethodBeat.i(149913);
    if (this.a == null)
    {
      AppMethodBeat.o(149913);
      return;
    }
    jx localjx = this.a.b(paramString);
    if (localjx != null) {
      localjx.c(paramFloat);
    }
    this.a.a(paramString, paramFloat);
    this.a.b().a();
    AppMethodBeat.o(149913);
  }
  
  final void b(String paramString, int paramInt)
  {
    AppMethodBeat.i(149910);
    if (this.a == null)
    {
      AppMethodBeat.o(149910);
      return;
    }
    synchronized (this.a.b)
    {
      paramString = this.a.b(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(149910);
        return;
      }
      if (!(paramString instanceof js))
      {
        AppMethodBeat.o(149910);
        return;
      }
      ((js)paramString).c(paramInt);
      this.a.b().a();
      AppMethodBeat.o(149910);
      return;
    }
  }
  
  final void c(String paramString, int paramInt)
  {
    AppMethodBeat.i(149914);
    if (this.a == null)
    {
      AppMethodBeat.o(149914);
      return;
    }
    synchronized (this.a.b)
    {
      paramString = this.a.b(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(149914);
        return;
      }
      if (!(paramString instanceof js))
      {
        AppMethodBeat.o(149914);
        return;
      }
      if (paramString != null) {
        paramString.a_(paramInt);
      }
      this.a.b().a();
      AppMethodBeat.o(149914);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.bo
 * JD-Core Version:    0.7.0.1
 */