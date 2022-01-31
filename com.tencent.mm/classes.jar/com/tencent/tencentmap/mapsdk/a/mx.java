package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.basemap.data.a;
import com.tencent.map.lib.basemap.data.b;

public class mx
{
  private int a = 0;
  private int b = 0;
  private String c = "default";
  private String d = "";
  private String e = "";
  private String f;
  
  public mx(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.d = paramString1;
    this.e = paramString2;
    this.f = paramString3;
    this.c = paramString4;
  }
  
  private boolean b(a parama)
  {
    if ("default".equals(this.c)) {
      return true;
    }
    if (parama == null) {
      return false;
    }
    return my.a(parama.a(), my.a().c(this.c));
  }
  
  private boolean c(a parama)
  {
    if ("default".equals(this.c)) {
      return true;
    }
    if (parama == null) {
      return false;
    }
    b[] arrayOfb = my.a().c(this.c);
    return my.a(parama.b(), arrayOfb);
  }
  
  public int a()
  {
    return this.a * 10 + this.b;
  }
  
  public boolean a(a parama)
  {
    switch (this.a)
    {
    default: 
      return false;
    case 0: 
      return b(parama);
    }
    return c(parama);
  }
  
  public String b()
  {
    return this.d;
  }
  
  public String c()
  {
    return this.e;
  }
  
  public String d()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.mx
 * JD-Core Version:    0.7.0.1
 */