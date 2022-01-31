package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.element.j;
import com.tencent.map.lib.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.ie;
import com.tencent.tencentmap.mapsdk.maps.a.jx;
import com.tencent.tencentmap.mapsdk.maps.a.jz;
import com.tencent.tencentmap.mapsdk.maps.a.ka;
import com.tencent.tencentmap.mapsdk.maps.a.kx;
import java.util.ArrayList;
import java.util.List;

public final class bb
  extends cb
  implements bz
{
  private kx a;
  private ah.o b;
  
  public bb(ie paramie)
  {
    AppMethodBeat.i(149810);
    this.a = null;
    this.b = null;
    this.a = ((kx)paramie.getVectorMapDelegate());
    if ((this.a != null) && (this.a.a(jz.class) == null)) {
      this.a.a(jz.class, this);
    }
    AppMethodBeat.o(149810);
  }
  
  final dj a(dk paramdk, ba paramba)
  {
    AppMethodBeat.i(100740);
    if (this.a == null)
    {
      AppMethodBeat.o(100740);
      return null;
    }
    jz localjz = new jz(this.a);
    localjz.a(paramdk);
    localjz.c();
    if (!this.a.a(localjz))
    {
      AppMethodBeat.o(100740);
      return null;
    }
    this.a.b().a();
    paramdk = new dj(paramdk, paramba, localjz.A());
    localjz.a(paramdk);
    AppMethodBeat.o(100740);
    return paramdk;
  }
  
  public final void a()
  {
    AppMethodBeat.i(100739);
    if (this.a != null)
    {
      this.a.b(jz.class);
      this.a = null;
    }
    AppMethodBeat.o(100739);
  }
  
  final void a(String paramString)
  {
    AppMethodBeat.i(100741);
    if ((this.a == null) || (this.a.b() == null))
    {
      AppMethodBeat.o(100741);
      return;
    }
    this.a.b(paramString, true);
    this.a.b().a();
    AppMethodBeat.o(100741);
  }
  
  final void a(String paramString, float paramFloat)
  {
    AppMethodBeat.i(100745);
    if ((this.a == null) || (this.a.b() == null))
    {
      AppMethodBeat.o(100745);
      return;
    }
    synchronized (this.a.b)
    {
      paramString = this.a.b(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(100745);
        return;
      }
      if (!(paramString instanceof jz))
      {
        AppMethodBeat.o(100745);
        return;
      }
      paramString = (jz)paramString;
      paramString.d(paramFloat);
      paramString.c();
      this.a.b().a();
      AppMethodBeat.o(100745);
      return;
    }
  }
  
  final void a(String paramString, int paramInt)
  {
    AppMethodBeat.i(100742);
    if ((this.a == null) || (this.a.b() == null))
    {
      AppMethodBeat.o(100742);
      return;
    }
    synchronized (this.a.b)
    {
      paramString = this.a.b(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(100742);
        return;
      }
      paramString.c(paramInt);
      paramString.c();
      this.a.b().a();
      AppMethodBeat.o(100742);
      return;
    }
  }
  
  final void a(String paramString, int paramInt, cz paramcz)
  {
    AppMethodBeat.i(149812);
    if ((this.a == null) || (this.a.b() == null))
    {
      AppMethodBeat.o(149812);
      return;
    }
    synchronized (this.a.b)
    {
      paramString = this.a.b(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(149812);
        return;
      }
      if (!(paramString instanceof jz))
      {
        AppMethodBeat.o(149812);
        return;
      }
      ((jz)paramString).a(paramInt, paramcz);
      this.a.b().a();
      AppMethodBeat.o(149812);
      return;
    }
  }
  
  final void a(String paramString, ck paramck)
  {
    AppMethodBeat.i(149811);
    if ((this.a == null) || (this.a.b() == null))
    {
      AppMethodBeat.o(149811);
      return;
    }
    synchronized (this.a.b)
    {
      paramString = this.a.b(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(149811);
        return;
      }
      if (!(paramString instanceof jz))
      {
        AppMethodBeat.o(149811);
        return;
      }
      paramString = (jz)paramString;
      paramString.a(paramck);
      paramString.c();
      this.a.b().a();
      AppMethodBeat.o(149811);
      return;
    }
  }
  
  final void a(String paramString, List<cz> paramList)
  {
    AppMethodBeat.i(100743);
    if ((this.a == null) || (this.a.b() == null))
    {
      AppMethodBeat.o(100743);
      return;
    }
    synchronized (this.a.b)
    {
      paramString = this.a.b(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(100743);
        return;
      }
      if (!(paramString instanceof jz))
      {
        AppMethodBeat.o(100743);
        return;
      }
      paramString = (jz)paramString;
    }
    try
    {
      paramString.a(paramList);
      label84:
      paramString.c();
      this.a.b().a();
      AppMethodBeat.o(100743);
      return;
      paramString = finally;
      AppMethodBeat.o(100743);
      throw paramString;
    }
    catch (IndexOutOfBoundsException paramList)
    {
      break label84;
    }
  }
  
  final void a(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(100746);
    if ((this.a == null) || (this.a.b() == null))
    {
      AppMethodBeat.o(100746);
      return;
    }
    synchronized (this.a.b)
    {
      paramString = this.a.b(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(100746);
        return;
      }
      paramString.a(paramBoolean);
      paramString.c();
      this.a.b().a();
      AppMethodBeat.o(100746);
      return;
    }
  }
  
  public final boolean a(jx paramjx, boolean paramBoolean, GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(149814);
    paramjx = (jz)paramjx;
    paramBoolean = paramjx.h().j();
    if ((this.b != null) && (paramBoolean))
    {
      paramGeoPoint = ka.a(paramGeoPoint);
      this.b.a(paramjx.h(), paramGeoPoint);
      AppMethodBeat.o(149814);
      return true;
    }
    AppMethodBeat.o(149814);
    return false;
  }
  
  final List<j> b(String paramString)
  {
    AppMethodBeat.i(100750);
    if ((this.a == null) || (this.a.b() == null))
    {
      AppMethodBeat.o(100750);
      return null;
    }
    synchronized (this.a.b)
    {
      paramString = this.a.b(paramString);
      if ((paramString == null) || (!(paramString instanceof jz)))
      {
        AppMethodBeat.o(100750);
        return null;
      }
      paramString = (jz)paramString;
      ??? = new ArrayList(1);
      ((List)???).add(paramString.j());
      AppMethodBeat.o(100750);
      return ???;
    }
  }
  
  final void b()
  {
    AppMethodBeat.i(100749);
    if (this.a != null) {
      this.a.c(jz.class);
    }
    AppMethodBeat.o(100749);
  }
  
  final void b(String paramString, float paramFloat)
  {
    AppMethodBeat.i(100747);
    if ((this.a == null) || (this.a.b() == null))
    {
      AppMethodBeat.o(100747);
      return;
    }
    synchronized (this.a.b)
    {
      paramString = this.a.b(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(100747);
        return;
      }
      if (!(paramString instanceof jz))
      {
        AppMethodBeat.o(100747);
        return;
      }
      paramString = (jz)paramString;
      paramString.c(paramFloat);
      paramString.c();
      this.a.b().a();
      AppMethodBeat.o(100747);
      return;
    }
  }
  
  final void b(String paramString, int paramInt)
  {
    AppMethodBeat.i(100744);
    if ((this.a == null) || (this.a.b() == null))
    {
      AppMethodBeat.o(100744);
      return;
    }
    synchronized (this.a.b)
    {
      paramString = this.a.b(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(100744);
        return;
      }
      paramString.a_(paramInt);
      paramString.c();
      this.a.b().a();
      AppMethodBeat.o(100744);
      return;
    }
  }
  
  final void b(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(149813);
    if ((this.a == null) || (this.a.b() == null))
    {
      AppMethodBeat.o(149813);
      return;
    }
    synchronized (this.a.b)
    {
      paramString = this.a.b(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(149813);
        return;
      }
      if (!(paramString instanceof jz))
      {
        AppMethodBeat.o(149813);
        return;
      }
      ((jz)paramString).d(paramBoolean);
      this.a.b().a();
      AppMethodBeat.o(149813);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.bb
 * JD-Core Version:    0.7.0.1
 */