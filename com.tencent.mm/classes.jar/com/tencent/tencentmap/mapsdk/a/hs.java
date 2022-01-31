package com.tencent.tencentmap.mapsdk.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class hs
  extends av
{
  protected String a = "GBK";
  
  public final int a(String paramString, mn parammn1, mn parammn2)
  {
    return a(paramString, parammn1, parammn2, a());
  }
  
  public final int a(String paramString, mn parammn1, mn parammn2, Map paramMap)
  {
    nl localnl = new nl(0);
    localnl.a(this.a);
    localnl.a(paramString, 1);
    if (parammn1.a != null) {
      localnl.a(parammn1.a, 2);
    }
    if (parammn2.a != null) {
      localnl.a(parammn2.a, 3);
    }
    paramString = new nk(taf_invoke("findObjectByIdInSameGroup", nn.a(localnl.a()), paramMap, new HashMap()));
    paramString.a(this.a);
    int i = paramString.a(0, 0, true);
    parammn1.a = new ArrayList();
    paramMap = new fq();
    parammn1.a.add(paramMap);
    parammn1.a = ((ArrayList)paramString.a(parammn1.a, 2, true));
    parammn2.a = new ArrayList();
    parammn1 = new fq();
    parammn2.a.add(parammn1);
    parammn2.a = ((ArrayList)paramString.a(parammn2.a, 3, true));
    return i;
  }
  
  public final int a(String paramString1, String paramString2, mn parammn1, mn parammn2)
  {
    return a(paramString1, paramString2, parammn1, parammn2, a());
  }
  
  public final int a(String paramString1, String paramString2, mn parammn1, mn parammn2, Map paramMap)
  {
    nl localnl = new nl(0);
    localnl.a(this.a);
    localnl.a(paramString1, 1);
    localnl.a(paramString2, 2);
    if (parammn1.a != null) {
      localnl.a(parammn1.a, 3);
    }
    if (parammn2.a != null) {
      localnl.a(parammn2.a, 4);
    }
    paramString1 = new nk(taf_invoke("findObjectByIdInSameSet", nn.a(localnl.a()), paramMap, new HashMap()));
    paramString1.a(this.a);
    int i = paramString1.a(0, 0, true);
    parammn1.a = new ArrayList();
    paramString2 = new fq();
    parammn1.a.add(paramString2);
    parammn1.a = ((ArrayList)paramString1.a(parammn1.a, 3, true));
    parammn2.a = new ArrayList();
    paramString2 = new fq();
    parammn2.a.add(paramString2);
    parammn2.a = ((ArrayList)paramString1.a(parammn2.a, 4, true));
    return i;
  }
  
  public final hs a(int paramInt)
  {
    super.taf_hash(paramInt);
    return this;
  }
  
  public final Map a()
  {
    return new HashMap();
  }
  
  public final void a(gr paramgr, String paramString)
  {
    a(paramgr, paramString, a());
  }
  
  public final void a(gr paramgr, String paramString1, String paramString2)
  {
    a(paramgr, paramString1, paramString2, a());
  }
  
  public final void a(gr paramgr, String paramString1, String paramString2, Map paramMap)
  {
    nl localnl = new nl(0);
    localnl.a(this.a);
    localnl.a(paramString1, 1);
    localnl.a(paramString2, 2);
    a(paramgr, "findObjectByIdInSameSet", nn.a(localnl.a()), paramMap, new HashMap());
  }
  
  public final void a(gr paramgr, String paramString, Map paramMap)
  {
    nl localnl = new nl(0);
    localnl.a(this.a);
    localnl.a(paramString, 1);
    a(paramgr, "findObjectByIdInSameGroup", nn.a(localnl.a()), paramMap, new HashMap());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.hs
 * JD-Core Version:    0.7.0.1
 */