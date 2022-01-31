package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class iq$a
  implements Cloneable
{
  private float a = 3.051758E-005F;
  private float b = 4.0F;
  private int c = 3;
  private int d = 20;
  private float e;
  private int f;
  
  float a()
  {
    return this.e;
  }
  
  float a(int paramInt)
  {
    return 1.907349E-006F * (1 << paramInt - 1);
  }
  
  public void a(float paramFloat)
  {
    this.e = paramFloat;
  }
  
  public void a(int paramInt, float paramFloat)
  {
    this.e = paramFloat;
    this.f = paramInt;
  }
  
  void a(a parama)
  {
    this.a = parama.a;
    this.b = parama.b;
    this.c = parama.c;
    this.d = parama.d;
    this.e = parama.e;
    this.f = parama.f;
  }
  
  int b()
  {
    return this.f;
  }
  
  void b(float paramFloat)
  {
    AppMethodBeat.i(148606);
    a locala = new a();
    this.c = locala.b();
    this.a = (paramFloat / locala.c());
    AppMethodBeat.o(148606);
  }
  
  void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  float c()
  {
    AppMethodBeat.i(148607);
    float f1 = this.e / a(this.f);
    AppMethodBeat.o(148607);
    return f1;
  }
  
  public Object clone()
  {
    AppMethodBeat.i(148610);
    Object localObject = super.clone();
    AppMethodBeat.o(148610);
    return localObject;
  }
  
  int d()
  {
    return this.c;
  }
  
  int e()
  {
    return this.d;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof a)) {}
    do
    {
      return false;
      paramObject = (a)paramObject;
    } while ((this.e != paramObject.e) || (this.f != paramObject.f));
    return true;
  }
  
  int f()
  {
    return 20;
  }
  
  float g()
  {
    return this.a;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(148608);
    int i = toString().hashCode();
    AppMethodBeat.o(148608);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(148609);
    String str = "scale:" + this.e + ", scaleLevel:" + this.f;
    AppMethodBeat.o(148609);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.iq.a
 * JD-Core Version:    0.7.0.1
 */