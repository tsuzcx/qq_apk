package com.tencent.tencentmap.mapsdk.a;

import java.util.ArrayList;

public final class cv
  extends dc
  implements Cloneable
{
  private static ArrayList<cu> b;
  public ArrayList<cu> a = null;
  
  public final void a(da paramda)
  {
    if (b == null)
    {
      b = new ArrayList();
      cu localcu = new cu();
      b.add(localcu);
    }
    this.a = ((ArrayList)paramda.a(b, 0, true));
  }
  
  public final void a(db paramdb)
  {
    paramdb.a(this.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.cv
 * JD-Core Version:    0.7.0.1
 */