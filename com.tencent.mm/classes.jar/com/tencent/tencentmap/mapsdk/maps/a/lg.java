package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.p;

public class lg
  implements iv
{
  private Context a;
  private final p b;
  private String c;
  
  public lg(Context paramContext, String paramString)
  {
    AppMethodBeat.i(149143);
    if (paramContext != null)
    {
      this.a = paramContext.getApplicationContext();
      this.b = p.a(this.a);
      this.c = paramString;
      AppMethodBeat.o(149143);
      return;
    }
    this.b = null;
    AppMethodBeat.o(149143);
  }
  
  public String a()
  {
    AppMethodBeat.i(149144);
    if (this.b != null)
    {
      String str = this.b.b();
      AppMethodBeat.o(149144);
      return str;
    }
    AppMethodBeat.o(149144);
    return null;
  }
  
  public String b()
  {
    AppMethodBeat.i(149145);
    if (this.b != null)
    {
      String str = this.b.c();
      AppMethodBeat.o(149145);
      return str;
    }
    AppMethodBeat.o(149145);
    return null;
  }
  
  public String c()
  {
    AppMethodBeat.i(149146);
    if (this.b != null)
    {
      String str = this.b.b(this.c);
      AppMethodBeat.o(149146);
      return str;
    }
    AppMethodBeat.o(149146);
    return null;
  }
  
  public String d()
  {
    AppMethodBeat.i(149147);
    if (this.b != null)
    {
      String str = this.b.c(this.c);
      AppMethodBeat.o(149147);
      return str;
    }
    AppMethodBeat.o(149147);
    return null;
  }
  
  public String e()
  {
    AppMethodBeat.i(149148);
    if (this.b != null)
    {
      String str = this.b.d();
      AppMethodBeat.o(149148);
      return str;
    }
    AppMethodBeat.o(149148);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.lg
 * JD-Core Version:    0.7.0.1
 */