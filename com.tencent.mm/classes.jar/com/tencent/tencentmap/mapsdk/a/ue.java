package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Canvas;
import android.graphics.PointF;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ue
{
  private tn a;
  private final int b;
  private final int c;
  private final int d;
  private final int e;
  private final int f;
  private PointF g;
  private ue.a h = ue.a.a;
  private List<uf> i = new ArrayList();
  private List<uf> j = new ArrayList();
  
  public ue(tn paramtn, int paramInt1, int paramInt2, int paramInt3, int paramInt4, ue.a parama, List<tw> paramList)
  {
    this.a = paramtn;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramInt4;
    if ((paramtn.r()) && (parama == ue.a.a))
    {
      paramInt1 = 7;
      this.f = paramInt1;
      this.h = parama;
      paramtn = new uf(uk.a(this.a, parama), this.b, this.c, this.d, this.f, this.e, parama);
      if (this.i.size() <= 0) {
        break label265;
      }
      this.i.set(0, paramtn);
      this.j.set(0, paramtn);
    }
    for (;;)
    {
      if ((paramList == null) || (paramList.isEmpty())) {
        return;
      }
      paramtn = paramList.iterator();
      while (paramtn.hasNext()) {
        a((tw)paramtn.next());
      }
      switch (ue.1.a[parama.ordinal()])
      {
      default: 
        paramInt1 = 1000;
        break;
      case 1: 
        paramInt1 = tp.a();
        break;
      case 2: 
        paramInt1 = tp.e();
        break;
        label265:
        this.i.add(paramtn);
        this.j.add(paramtn);
      }
    }
  }
  
  public final int a()
  {
    return this.d;
  }
  
  public final void a(PointF paramPointF)
  {
    this.g = paramPointF;
  }
  
  public final void a(tw paramtw)
  {
    this.i.size();
    paramtw = new uf(paramtw, this.b, this.c, this.d);
    this.i.add(paramtw);
    this.j.add(paramtw);
  }
  
  public final boolean a(Canvas paramCanvas)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.i != null)
    {
      bool1 = bool2;
      if (this.i.size() > 0)
      {
        Collections.sort(this.j, uf.k());
        paramCanvas.save();
        paramCanvas.translate(this.g.x, this.g.y);
        Iterator localIterator = this.j.iterator();
        for (bool1 = true; localIterator.hasNext(); bool1 = ((uf)localIterator.next()).a(paramCanvas) & bool1) {}
        paramCanvas.restore();
      }
    }
    return bool1;
  }
  
  public final boolean a(List<uf> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      if (((uf)localIterator.next()).a() != null) {
        return true;
      }
    }
    this.i.clear();
    this.i.addAll(paramList);
    this.j.clear();
    this.j.addAll(paramList);
    paramList = this.i.iterator();
    while (paramList.hasNext()) {
      if (((uf)paramList.next()).f() == null) {
        return true;
      }
    }
    return false;
  }
  
  public final List<uf> b()
  {
    return new ArrayList(this.i);
  }
  
  public final void b(tw paramtw)
  {
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext())
    {
      uf localuf = (uf)localIterator.next();
      if (localuf.a(paramtw))
      {
        localuf.h();
        localIterator.remove();
      }
    }
  }
  
  public final void c()
  {
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext()) {
      ((uf)localIterator.next()).h();
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof ue)) {
        return false;
      }
      paramObject = (ue)paramObject;
    } while ((this.b == paramObject.b) && (this.c == paramObject.c) && (this.d == paramObject.d) && (this.e == paramObject.e) && (this.f == paramObject.f));
    return false;
  }
  
  public final int hashCode()
  {
    return this.b * 7 + this.c * 11 + this.d * 13;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("MapTile(");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",");
    localStringBuilder.append(this.h);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ue
 * JD-Core Version:    0.7.0.1
 */