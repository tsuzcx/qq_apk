package com.tencent.tencentmap.mapsdk.a;

import com.tencent.tencentmap.mapsdk.maps.a.fn;

public abstract class c
  implements d
{
  private cz a;
  private cz b;
  
  public abstract String a();
  
  protected String a(cz paramcz)
  {
    return paramcz.a + "," + paramcz.b;
  }
  
  public boolean b()
  {
    return (this.a != null) && (this.b != null);
  }
  
  public fn c()
  {
    fn localfn = new fn();
    localfn.a("from", a(this.a));
    localfn.a("to", a(this.b));
    return localfn;
  }
  
  public abstract Class<?> d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.c
 * JD-Core Version:    0.7.0.1
 */