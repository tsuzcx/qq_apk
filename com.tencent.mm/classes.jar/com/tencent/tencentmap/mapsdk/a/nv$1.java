package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.f;

class nv$1
  implements jf.a
{
  nv$1(nv paramnv) {}
  
  public void a(iv paramiv)
  {
    if (paramiv.a != 10000) {}
    do
    {
      do
      {
        return;
      } while (!(paramiv instanceof lx));
      paramiv = (lx)paramiv;
      if (paramiv.j())
      {
        i = paramiv.k();
        j = paramiv.l();
        nv.a(this.a).getMap().c(nv.a(this.a).D / 2 - i, nv.a(this.a).E / 2 - j);
      }
      if (paramiv.e())
      {
        i = paramiv.f();
        j = paramiv.g();
        nv.a(this.a).getMap().c(i, j);
      }
      float f;
      if (paramiv.h())
      {
        f = paramiv.i();
        nv.a(this.a).getMap().b(f);
      }
      if (paramiv.m())
      {
        i = paramiv.n();
        j = paramiv.o();
        nv.a(this.a).getMap().a(i, j);
        if (paramiv.t()) {
          nv.a(this.a).a(i, j);
        }
      }
      if (paramiv.q())
      {
        f = paramiv.p();
        nv.a(this.a).getMap().b(f);
      }
      if (paramiv.r())
      {
        f = paramiv.s();
        nv.a(this.a).getMap().a(f);
      }
    } while (!paramiv.j());
    int i = paramiv.k();
    int j = paramiv.l();
    nv.a(this.a).getMap().c(i - nv.a(this.a).D / 2, j - nv.a(this.a).E / 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.nv.1
 * JD-Core Version:    0.7.0.1
 */