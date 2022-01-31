package com.tencent.tencentmap.mapsdk.a;

public final class sv
{
  private sw a;
  private sw b;
  
  public sv(sw paramsw1, sw paramsw2)
  {
    paramsw1 = new sv.a().a(paramsw1).a(paramsw2);
    this.a = new sw(sv.a.a(paramsw1), sv.a.b(paramsw1));
    this.b = new sw(sv.a.c(paramsw1), sv.a.d(paramsw1));
  }
  
  public final sw a()
  {
    return this.a;
  }
  
  public final sw b()
  {
    return this.b;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof sv)) {
        return false;
      }
      paramObject = (sv)paramObject;
    } while ((this.a.equals(paramObject.a)) && (this.b.equals(paramObject.b)));
    return false;
  }
  
  public final int hashCode()
  {
    return ub.a(new Object[] { this.a, this.b });
  }
  
  public final String toString()
  {
    return ub.a(new String[] { ub.a("southwest", this.a), ub.a("northeast", this.b) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.sv
 * JD-Core Version:    0.7.0.1
 */