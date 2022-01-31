package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.element.j;
import com.tencent.map.lib.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.ie;
import com.tencent.tencentmap.mapsdk.maps.a.jx;
import com.tencent.tencentmap.mapsdk.maps.a.jy;
import com.tencent.tencentmap.mapsdk.maps.a.ka;
import com.tencent.tencentmap.mapsdk.maps.a.kx;
import java.util.ArrayList;
import java.util.List;

public class az
  extends ca
{
  private kx a;
  
  public az(ie paramie)
  {
    AppMethodBeat.i(149793);
    this.a = null;
    this.a = ((kx)paramie.getVectorMapDelegate());
    AppMethodBeat.o(149793);
  }
  
  private ArrayList<GeoPoint> a(List<cz> paramList)
  {
    AppMethodBeat.i(149803);
    if (paramList == null)
    {
      AppMethodBeat.o(149803);
      return null;
    }
    int j = paramList.size();
    if (j <= 0)
    {
      AppMethodBeat.o(149803);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < j)
    {
      Object localObject = (cz)paramList.get(i);
      if (localObject != null)
      {
        localObject = ka.a((cz)localObject);
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(149803);
    return localArrayList;
  }
  
  dh a(di paramdi, ay paramay)
  {
    AppMethodBeat.i(149795);
    if (this.a == null)
    {
      AppMethodBeat.o(149795);
      return null;
    }
    jy localjy = new jy(this.a, paramdi);
    localjy.a(paramdi);
    localjy.c();
    if (!this.a.a(localjy))
    {
      AppMethodBeat.o(149795);
      return null;
    }
    this.a.b().a();
    paramdi = new dh(paramdi, paramay, localjy.A());
    AppMethodBeat.o(149795);
    return paramdi;
  }
  
  public void a()
  {
    AppMethodBeat.i(149794);
    if (this.a != null)
    {
      this.a.b(jy.class);
      this.a = null;
    }
    AppMethodBeat.o(149794);
  }
  
  void a(String paramString)
  {
    AppMethodBeat.i(149796);
    if (this.a == null)
    {
      AppMethodBeat.o(149796);
      return;
    }
    this.a.b(paramString, true);
    this.a.b().a();
    AppMethodBeat.o(149796);
  }
  
  void a(String paramString, float paramFloat)
  {
    AppMethodBeat.i(149800);
    if ((this.a == null) || (this.a.b() == null))
    {
      AppMethodBeat.o(149800);
      return;
    }
    synchronized (this.a.b)
    {
      paramString = this.a.b(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(149800);
        return;
      }
      paramString.d(paramFloat);
      this.a.b().a();
      AppMethodBeat.o(149800);
      return;
    }
  }
  
  void a(String paramString, int paramInt)
  {
    AppMethodBeat.i(149797);
    if (this.a == null)
    {
      AppMethodBeat.o(149797);
      return;
    }
    synchronized (this.a.b)
    {
      paramString = this.a.b(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(149797);
        return;
      }
      paramString.d(paramInt);
      this.a.b().a();
      AppMethodBeat.o(149797);
      return;
    }
  }
  
  void a(String paramString, List<cz> paramList)
  {
    AppMethodBeat.i(149798);
    if ((this.a == null) || (this.a.b() == null))
    {
      AppMethodBeat.o(149798);
      return;
    }
    synchronized (this.a.b)
    {
      paramString = this.a.b(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(149798);
        return;
      }
      if (!(paramString instanceof jy))
      {
        AppMethodBeat.o(149798);
        return;
      }
      paramString = (jy)paramString;
      paramString.a(a(paramList));
      paramString.c();
      this.a.b().a();
      AppMethodBeat.o(149798);
      return;
    }
  }
  
  void a(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(149801);
    if ((this.a == null) || (this.a.b() == null))
    {
      AppMethodBeat.o(149801);
      return;
    }
    synchronized (this.a.b)
    {
      paramString = this.a.b(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(149801);
        return;
      }
      paramString.a(paramBoolean);
      this.a.b().a();
      AppMethodBeat.o(149801);
      return;
    }
  }
  
  List<j> b(String paramString)
  {
    AppMethodBeat.i(149805);
    if ((this.a == null) || (this.a.b() == null))
    {
      AppMethodBeat.o(149805);
      return null;
    }
    synchronized (this.a.b)
    {
      paramString = this.a.b(paramString);
      if ((paramString == null) || (!(paramString instanceof jy)))
      {
        AppMethodBeat.o(149805);
        return null;
      }
      paramString = (jy)paramString;
      ??? = new ArrayList(1);
      ((List)???).add(paramString);
      AppMethodBeat.o(149805);
      return ???;
    }
  }
  
  void b()
  {
    AppMethodBeat.i(149804);
    if (this.a != null) {
      this.a.c(jy.class);
    }
    AppMethodBeat.o(149804);
  }
  
  void b(String paramString, float paramFloat)
  {
    AppMethodBeat.i(149802);
    if ((this.a == null) || (this.a.b() == null))
    {
      AppMethodBeat.o(149802);
      return;
    }
    synchronized (this.a.b)
    {
      paramString = this.a.b(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(149802);
        return;
      }
      paramString.c(paramFloat);
      this.a.b().a();
      AppMethodBeat.o(149802);
      return;
    }
  }
  
  void b(String paramString, int paramInt)
  {
    AppMethodBeat.i(149799);
    if ((this.a == null) || (this.a.b() == null))
    {
      AppMethodBeat.o(149799);
      return;
    }
    synchronized (this.a.b)
    {
      paramString = this.a.b(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(149799);
        return;
      }
      paramString.c(paramInt);
      this.a.b().a();
      AppMethodBeat.o(149799);
      return;
    }
  }
  
  void c(String paramString, int paramInt)
  {
    AppMethodBeat.i(149806);
    if ((this.a == null) || (this.a.b() == null))
    {
      AppMethodBeat.o(149806);
      return;
    }
    synchronized (this.a.b)
    {
      paramString = this.a.b(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(149806);
        return;
      }
      paramString.a_(paramInt);
      paramString.c();
      this.a.b().a();
      AppMethodBeat.o(149806);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.az
 * JD-Core Version:    0.7.0.1
 */