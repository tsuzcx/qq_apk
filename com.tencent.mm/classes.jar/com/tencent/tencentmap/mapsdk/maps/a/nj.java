package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.map.lib.basemap.data.a;
import com.tencent.map.lib.basemap.data.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class nj
{
  private int a = 0;
  private int b = 0;
  private String c = "default";
  private String d = "";
  private String e = "";
  private String f;
  
  public nj(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.d = paramString1;
    this.e = paramString2;
    this.f = paramString3;
    this.c = paramString4;
  }
  
  private boolean b(a parama)
  {
    AppMethodBeat.i(149479);
    if ("default".equals(this.c))
    {
      AppMethodBeat.o(149479);
      return true;
    }
    if (parama == null)
    {
      AppMethodBeat.o(149479);
      return false;
    }
    boolean bool = nk.a(parama.a(), nk.a().c(this.c));
    AppMethodBeat.o(149479);
    return bool;
  }
  
  private boolean c(a parama)
  {
    AppMethodBeat.i(149480);
    if ("default".equals(this.c))
    {
      AppMethodBeat.o(149480);
      return true;
    }
    if (parama == null)
    {
      AppMethodBeat.o(149480);
      return false;
    }
    b[] arrayOfb = nk.a().c(this.c);
    parama = parama.b();
    if ((parama == null) || (arrayOfb == null))
    {
      AppMethodBeat.o(149480);
      return true;
    }
    boolean bool = nk.a(parama, arrayOfb);
    AppMethodBeat.o(149480);
    return bool;
  }
  
  public int a()
  {
    return this.a * 10 + this.b;
  }
  
  public boolean a(a parama)
  {
    AppMethodBeat.i(149478);
    switch (this.a)
    {
    default: 
      AppMethodBeat.o(149478);
      return false;
    case 0: 
      bool = b(parama);
      AppMethodBeat.o(149478);
      return bool;
    }
    boolean bool = c(parama);
    AppMethodBeat.o(149478);
    return bool;
  }
  
  public String b()
  {
    return this.d;
  }
  
  public String c()
  {
    return this.e;
  }
  
  public String d()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.nj
 * JD-Core Version:    0.7.0.1
 */