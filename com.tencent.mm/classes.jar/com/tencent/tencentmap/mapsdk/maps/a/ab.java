package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ab
  extends aa
{
  public ab(y paramy)
  {
    super(paramy);
  }
  
  public final be a()
  {
    AppMethodBeat.i(147191);
    cw.d().a(1);
    be localbe = super.a();
    AppMethodBeat.o(147191);
    return localbe;
  }
  
  protected final be a(int paramInt)
  {
    AppMethodBeat.i(147190);
    Object localObject = new bb(this.c, this.a.d, this.a.c, this.a.b, paramInt, this.a.g, false, 0, this.a.l, cw.d().f(), this.a.o);
    ((bb)localObject).a = this.b;
    ((bb)localObject).o = this.d;
    ((bb)localObject).a("app");
    this.e = ((az)localObject);
    this.e.l = this.a.n;
    localObject = this.e.a();
    AppMethodBeat.o(147190);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ab
 * JD-Core Version:    0.7.0.1
 */