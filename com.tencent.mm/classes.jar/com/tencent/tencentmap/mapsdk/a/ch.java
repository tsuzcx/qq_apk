package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Color;
import android.location.Location;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ch
  extends bt
{
  private ar a;
  private bn b;
  private bp c;
  private ad.a d;
  private ad e;
  private boolean f;
  private dc g;
  private co h;
  private ah.n i;
  private df j;
  private int k;
  private Location l;
  
  public ch(ar paramar, bn parambn, bp parambp)
  {
    AppMethodBeat.i(149986);
    this.a = null;
    this.b = null;
    this.c = null;
    this.d = null;
    this.e = null;
    this.f = false;
    this.g = null;
    this.h = null;
    this.i = null;
    this.j = new df();
    this.k = Color.argb(102, 0, 163, 255);
    this.l = null;
    this.a = paramar;
    this.b = parambn;
    this.c = parambp;
    this.d = f();
    AppMethodBeat.o(149986);
  }
  
  private ad.a f()
  {
    AppMethodBeat.i(149989);
    ch.1 local1 = new ch.1(this);
    AppMethodBeat.o(149989);
    return local1;
  }
  
  void a()
  {
    AppMethodBeat.i(149988);
    if (this.f == true)
    {
      AppMethodBeat.o(149988);
      return;
    }
    this.f = true;
    if (this.d == null) {
      this.d = f();
    }
    if (this.g != null) {
      this.g.b(true);
    }
    if (this.h != null) {
      this.h.a(true);
    }
    if (this.e != null) {
      this.e.a(this.d);
    }
    AppMethodBeat.o(149988);
  }
  
  void b()
  {
    AppMethodBeat.i(100935);
    if (this.g != null)
    {
      this.g.b(false);
      this.g.b();
      this.g = null;
    }
    if (this.h != null)
    {
      this.h.a(false);
      this.h.b();
      this.h = null;
    }
    if (!this.f)
    {
      AppMethodBeat.o(100935);
      return;
    }
    this.f = false;
    this.d = null;
    if (this.e != null) {
      this.e.a();
    }
    AppMethodBeat.o(100935);
  }
  
  boolean c()
  {
    return this.f;
  }
  
  Location d()
  {
    AppMethodBeat.i(149990);
    if (this.l == null)
    {
      AppMethodBeat.o(149990);
      return null;
    }
    Location localLocation = new Location(this.l);
    AppMethodBeat.o(149990);
    return localLocation;
  }
  
  public void e()
  {
    AppMethodBeat.i(149987);
    b();
    this.a = null;
    this.b = null;
    this.c = null;
    AppMethodBeat.o(149987);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ch
 * JD-Core Version:    0.7.0.1
 */