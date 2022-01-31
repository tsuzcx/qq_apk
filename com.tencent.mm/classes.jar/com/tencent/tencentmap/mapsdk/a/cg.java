package com.tencent.tencentmap.mapsdk.a;

import android.location.Location;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class cg
{
  bt a = null;
  
  public cg(bt parambt)
  {
    this.a = parambt;
  }
  
  public void a()
  {
    if (this.a != null) {
      this.a = null;
    }
  }
  
  public final Location b()
  {
    AppMethodBeat.i(149982);
    if (this.a != null)
    {
      Location localLocation = this.a.d();
      AppMethodBeat.o(149982);
      return localLocation;
    }
    AppMethodBeat.o(149982);
    return null;
  }
  
  public void c()
  {
    AppMethodBeat.i(149983);
    if (this.a != null) {
      this.a.a();
    }
    AppMethodBeat.o(149983);
  }
  
  public void d()
  {
    AppMethodBeat.i(149984);
    if (this.a != null) {
      this.a.b();
    }
    AppMethodBeat.o(149984);
  }
  
  public boolean e()
  {
    AppMethodBeat.i(149985);
    if (this.a != null)
    {
      boolean bool = this.a.c();
      AppMethodBeat.o(149985);
      return bool;
    }
    AppMethodBeat.o(149985);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.cg
 * JD-Core Version:    0.7.0.1
 */