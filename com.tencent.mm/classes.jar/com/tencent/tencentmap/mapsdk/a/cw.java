package com.tencent.tencentmap.mapsdk.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class cw
  extends dc
{
  private static ArrayList<cx> e;
  private static Map<String, String> f;
  public ArrayList<cx> a = null;
  public int b = 0;
  public String c = "";
  public Map<String, String> d = null;
  
  public final void a(da paramda)
  {
    if (e == null)
    {
      e = new ArrayList();
      cx localcx = new cx();
      e.add(localcx);
    }
    this.a = ((ArrayList)paramda.a(e, 0, true));
    this.b = paramda.a(this.b, 1, true);
    this.c = paramda.a(2, true);
    if (f == null)
    {
      f = new HashMap();
      f.put("", "");
    }
    this.d = ((Map)paramda.a(f, 3, false));
  }
  
  public final void a(db paramdb)
  {
    paramdb.a(this.a, 0);
    paramdb.a(this.b, 1);
    paramdb.a(this.c, 2);
    if (this.d != null) {
      paramdb.a(this.d, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.cw
 * JD-Core Version:    0.7.0.1
 */