package com.tencent.tencentmap.mapsdk.a;

import java.util.ArrayList;

public final class ld
  extends nm
{
  static ArrayList<le> g = new ArrayList();
  public ArrayList<le> a = null;
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  
  static
  {
    le localle = new le();
    g.add(localle);
  }
  
  public ld() {}
  
  public ld(ArrayList<le> paramArrayList, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.a = paramArrayList;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramString4;
    this.f = paramString5;
  }
  
  public final void readFrom(nk paramnk)
  {
    this.a = ((ArrayList)paramnk.a(g, 0, true));
    this.b = paramnk.a(1, false);
    this.c = paramnk.a(2, false);
    this.d = paramnk.a(3, false);
    this.e = paramnk.a(4, false);
    this.f = paramnk.a(5, false);
  }
  
  public final void writeTo(nl paramnl)
  {
    paramnl.a(this.a, 0);
    if (this.b != null) {
      paramnl.a(this.b, 1);
    }
    if (this.c != null) {
      paramnl.a(this.c, 2);
    }
    if (this.d != null) {
      paramnl.a(this.d, 3);
    }
    if (this.e != null) {
      paramnl.a(this.e, 4);
    }
    if (this.f != null) {
      paramnl.a(this.f, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ld
 * JD-Core Version:    0.7.0.1
 */