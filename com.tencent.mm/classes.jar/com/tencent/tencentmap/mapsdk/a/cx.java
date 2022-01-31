package com.tencent.tencentmap.mapsdk.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class cx
  extends dc
{
  private static Map<String, String> g;
  private static ArrayList<String> h;
  private static ArrayList<String> i;
  public byte a = 0;
  public byte b = 0;
  public String c = "";
  public Map<String, String> d = null;
  public ArrayList<String> e = null;
  public ArrayList<String> f = null;
  
  public final void a(da paramda)
  {
    this.a = paramda.a(this.a, 0, true);
    this.b = paramda.a(this.b, 1, true);
    this.c = paramda.a(2, true);
    if (g == null)
    {
      g = new HashMap();
      g.put("", "");
    }
    this.d = ((Map)paramda.a(g, 3, true));
    if (h == null)
    {
      h = new ArrayList();
      h.add("");
    }
    this.e = ((ArrayList)paramda.a(h, 4, false));
    if (i == null)
    {
      i = new ArrayList();
      i.add("");
    }
    this.f = ((ArrayList)paramda.a(i, 6, false));
  }
  
  public final void a(db paramdb)
  {
    paramdb.a(this.a, 0);
    paramdb.a(this.b, 1);
    paramdb.a(this.c, 2);
    paramdb.a(this.d, 3);
    if (this.e != null) {
      paramdb.a(this.e, 4);
    }
    if (this.f != null) {
      paramdb.a(this.f, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.cx
 * JD-Core Version:    0.7.0.1
 */