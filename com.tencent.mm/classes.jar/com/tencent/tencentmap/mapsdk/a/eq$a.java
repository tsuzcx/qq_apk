package com.tencent.tencentmap.mapsdk.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class eq$a
{
  Integer a;
  String b;
  String c;
  String d;
  private String e;
  private List<en> f;
  private List<en> g;
  private List<en> h;
  private List<en> i;
  
  public eq$a(String paramString)
  {
    this.e = paramString;
  }
  
  public final List<en> a()
  {
    ArrayList localArrayList = new ArrayList();
    List localList = this.f;
    if ((localList != null) && (localList.size() > 0)) {
      localArrayList.addAll(localList);
    }
    localList = this.g;
    if ((localList != null) && (localList.size() > 0)) {
      localArrayList.addAll(localList);
    }
    localList = this.h;
    if ((localList != null) && (localList.size() > 0)) {
      localArrayList.addAll(localList);
    }
    localList = this.i;
    if ((localList != null) && (localList.size() > 0)) {
      localArrayList.addAll(localList);
    }
    return localArrayList;
  }
  
  public final void a(en paramen)
  {
    if (paramen == null) {
      return;
    }
    if (paramen.b() == 1)
    {
      if (this.f == null) {
        this.f = new ArrayList();
      }
      this.f.add(paramen);
      return;
    }
    if (paramen.b() == 2)
    {
      if (this.g == null) {
        this.g = new ArrayList();
      }
      this.g.add(paramen);
      return;
    }
    if (paramen.b() == 3)
    {
      if (this.h == null) {
        this.h = new ArrayList();
      }
      this.h.add(paramen);
      return;
    }
    if (paramen.b() == 4)
    {
      if (this.i == null) {
        this.i = new ArrayList();
      }
      this.i.add(paramen);
      return;
    }
    if (this.f == null) {
      this.f = new ArrayList();
    }
    this.f.add(paramen);
  }
  
  public final void b(en paramen)
  {
    if (paramen == null) {}
    for (;;)
    {
      return;
      try
      {
        if (paramen.b() == 1)
        {
          if ((this.f == null) || (this.f.isEmpty()) || (!paramen.a((en)this.f.get(0)))) {
            continue;
          }
          this.f.remove(0);
          continue;
        }
      }
      finally {}
      if ((paramen.b() == 2) && (this.g != null) && (!this.g.isEmpty()) && (paramen.a((en)this.g.get(0)))) {
        this.g.remove(0);
      }
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Appid：" + this.a + " domain：" + this.b + "\r\n");
    localStringBuilder.append("apn：" + this.e + " ckIP：" + this.c + "\r\n");
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
    {
      en localen = (en)localIterator.next();
      localStringBuilder.append("accessIP：" + localen.toString() + "\r\n");
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.eq.a
 * JD-Core Version:    0.7.0.1
 */