package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class jg<E>
{
  private int a;
  private Object[] b;
  private int c;
  private int d;
  
  public jg(int paramInt)
  {
    AppMethodBeat.i(148689);
    this.a = paramInt;
    this.b = new Object[paramInt];
    this.d = 0;
    this.c = 0;
    AppMethodBeat.o(148689);
  }
  
  private void e()
  {
    this.d = 0;
    this.c = 0;
  }
  
  public E a()
  {
    AppMethodBeat.i(148691);
    if (d())
    {
      AppMethodBeat.o(148691);
      return null;
    }
    this.c %= this.a;
    Object localObject = this.b[this.c];
    this.b[this.c] = null;
    this.c += 1;
    AppMethodBeat.o(148691);
    return localObject;
  }
  
  public boolean a(E paramE)
  {
    AppMethodBeat.i(148690);
    if (c())
    {
      AppMethodBeat.o(148690);
      return false;
    }
    this.d %= this.a;
    Object[] arrayOfObject = this.b;
    int i = this.d;
    this.d = (i + 1);
    arrayOfObject[i] = paramE;
    AppMethodBeat.o(148690);
    return true;
  }
  
  public void b()
  {
    AppMethodBeat.i(148692);
    e();
    int i = 0;
    while (i < this.b.length)
    {
      this.b[i] = null;
      i += 1;
    }
    AppMethodBeat.o(148692);
  }
  
  public boolean c()
  {
    return (this.d + 1) % this.a == this.c;
  }
  
  public boolean d()
  {
    return this.d == this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.jg
 * JD-Core Version:    0.7.0.1
 */