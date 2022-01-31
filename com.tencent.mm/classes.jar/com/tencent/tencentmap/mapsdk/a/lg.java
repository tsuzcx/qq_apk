package com.tencent.tencentmap.mapsdk.a;

import java.util.ArrayList;

public final class lg
  extends nm
{
  static ArrayList<lf> c = new ArrayList();
  public int a = 0;
  public ArrayList<lf> b = null;
  
  static
  {
    lf locallf = new lf();
    c.add(locallf);
  }
  
  public final void readFrom(nk paramnk)
  {
    this.a = paramnk.a(this.a, 0, true);
    this.b = ((ArrayList)paramnk.a(c, 1, false));
  }
  
  public final void writeTo(nl paramnl)
  {
    paramnl.a(this.a, 0);
    if (this.b != null) {
      paramnl.a(this.b, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.lg
 * JD-Core Version:    0.7.0.1
 */