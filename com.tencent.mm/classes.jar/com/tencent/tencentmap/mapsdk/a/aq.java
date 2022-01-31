package com.tencent.tencentmap.mapsdk.a;

import com.qq.jutil.string.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aq
{
  String a;
  int b;
  int c;
  int d;
  int e;
  bd f;
  int g;
  public az h;
  int i;
  int j;
  boolean k;
  long l;
  String m;
  String n;
  String o;
  String p;
  private int q;
  
  public static an<ArrayList<bg>, ArrayList<bg>> a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramString2 = StringUtil.split(paramString2, ":");
    int i2 = paramString2.length;
    int i1 = 0;
    if (i1 < i2)
    {
      bg localbg = bg.a(paramString1, paramString2[i1], paramInt1, paramInt2, paramInt3);
      if (localbg.g()) {
        localArrayList1.add(localbg);
      }
      for (;;)
      {
        i1 += 1;
        break;
        localArrayList2.add(localbg);
      }
    }
    paramString1 = new an();
    paramString1.a = localArrayList1;
    paramString1.b = localArrayList2;
    return paramString1;
  }
  
  public int a()
  {
    return this.c;
  }
  
  public void a(az paramaz)
  {
    this.h = paramaz;
  }
  
  public String b()
  {
    Object localObject1 = new StringBuffer();
    Object localObject2 = this.h.c().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      bg localbg = (bg)((Iterator)localObject2).next();
      ((StringBuffer)localObject1).append(localbg.c() + ":");
    }
    localObject2 = ((StringBuffer)localObject1).toString();
    localObject1 = localObject2;
    if (((String)localObject2).endsWith(":")) {
      localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
    }
    return localObject1;
  }
  
  public String c()
  {
    return this.a;
  }
  
  public int d()
  {
    return this.e;
  }
  
  public bd e()
  {
    return this.f;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof aq)) && (((aq)paramObject).q == this.q);
  }
  
  public String f()
  {
    return this.n;
  }
  
  public String g()
  {
    return this.o;
  }
  
  public String h()
  {
    return this.p;
  }
  
  public int hashCode()
  {
    return this.q;
  }
  
  public String toString()
  {
    Object localObject1 = new StringBuffer();
    ((StringBuffer)localObject1).append(c() + "@");
    Object localObject2 = this.h.c().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      bg localbg = (bg)((Iterator)localObject2).next();
      ((StringBuffer)localObject1).append(localbg.d() + ":");
    }
    localObject2 = ((StringBuffer)localObject1).toString();
    localObject1 = localObject2;
    if (((String)localObject2).endsWith(":")) {
      localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.aq
 * JD-Core Version:    0.7.0.1
 */