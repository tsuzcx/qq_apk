package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.map.lib.basemap.data.b;
import com.tencent.map.lib.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.cy;
import com.tencent.tencentmap.mapsdk.a.p;
import com.tencent.tencentmap.mapsdk.a.t;
import java.io.File;

public class np
{
  private kx a;
  private nl b;
  private nq c;
  private volatile boolean d;
  
  public np(kx paramkx)
  {
    AppMethodBeat.i(149507);
    this.a = null;
    this.b = null;
    this.c = new nq();
    this.d = false;
    this.a = paramkx;
    f();
    AppMethodBeat.o(149507);
  }
  
  private boolean a(b[] paramArrayOfb)
  {
    AppMethodBeat.i(149517);
    if (this.a == null)
    {
      AppMethodBeat.o(149517);
      return true;
    }
    b[] arrayOfb = this.a.T();
    if ((arrayOfb == null) || (paramArrayOfb == null))
    {
      AppMethodBeat.o(149517);
      return true;
    }
    boolean bool = nk.a(arrayOfb, paramArrayOfb);
    AppMethodBeat.o(149517);
    return bool;
  }
  
  private void f()
  {
    AppMethodBeat.i(149510);
    t.c(p.b(this.a.i()) + "/tencentmapsdk/rastermap/unmainland");
    t.c(p.a(this.a.i()).a().getPath() + "/rastermap/taiwan");
    AppMethodBeat.o(149510);
  }
  
  private void g()
  {
    AppMethodBeat.i(149515);
    if ((this.a == null) || (this.a.b() == null) || (this.b == null))
    {
      AppMethodBeat.o(149515);
      return;
    }
    f localf = this.a.b();
    a(this.b.A());
    localf.g(true);
    localf.h(true);
    this.b = null;
    AppMethodBeat.o(149515);
  }
  
  private void h()
  {
    AppMethodBeat.i(149516);
    if ((this.a == null) || (this.a.b() == null))
    {
      AppMethodBeat.o(149516);
      return;
    }
    f localf = this.a.b();
    localf.g(false);
    localf.h(false);
    this.b = a(this.c);
    AppMethodBeat.o(149516);
  }
  
  public kx a()
  {
    return this.a;
  }
  
  public nl a(nq paramnq)
  {
    AppMethodBeat.i(149508);
    if (this.a == null)
    {
      AppMethodBeat.o(149508);
      return null;
    }
    paramnq = new nl(this, paramnq);
    this.a.a(paramnq);
    this.a.b().a();
    AppMethodBeat.o(149508);
    return paramnq;
  }
  
  public void a(int paramInt)
  {
    AppMethodBeat.i(149512);
    try
    {
      if ((this.a != null) && (this.a.o() != null)) {
        this.a.o().a(paramInt);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(149512);
    }
  }
  
  public void a(cy paramcy)
  {
    AppMethodBeat.i(149514);
    this.c.a(paramcy);
    AppMethodBeat.o(149514);
  }
  
  public void a(String paramString)
  {
    AppMethodBeat.i(149509);
    if (this.a == null)
    {
      AppMethodBeat.o(149509);
      return;
    }
    this.a.b(paramString, true);
    this.a.b().a();
    AppMethodBeat.o(149509);
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void b()
  {
    this.a = null;
  }
  
  public boolean c()
  {
    return this.d;
  }
  
  public void d()
  {
    AppMethodBeat.i(149511);
    if (this.b != null) {
      this.b.e();
    }
    AppMethodBeat.o(149511);
  }
  
  public void e()
  {
    AppMethodBeat.i(149513);
    if ((this.a == null) || (this.a.b() == null))
    {
      AppMethodBeat.o(149513);
      return;
    }
    if (this.a.b().h() < 7)
    {
      g();
      AppMethodBeat.o(149513);
      return;
    }
    if (!nn.d())
    {
      if (this.b != null) {
        g();
      }
      AppMethodBeat.o(149513);
      return;
    }
    if (a(nk.a().c("china")))
    {
      if (this.b != null) {
        g();
      }
      AppMethodBeat.o(149513);
      return;
    }
    if (this.b == null) {
      h();
    }
    AppMethodBeat.o(149513);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.np
 * JD-Core Version:    0.7.0.1
 */