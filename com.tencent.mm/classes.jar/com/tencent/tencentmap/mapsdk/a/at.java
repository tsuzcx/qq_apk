package com.tencent.tencentmap.mapsdk.a;

import com.qq.sim.Millis100TimeProvider;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class at
{
  final int a;
  boolean b;
  String c;
  String d;
  long e;
  aw f;
  String g;
  int h;
  String i;
  long j;
  long k;
  long l;
  protected Object m;
  protected CountDownLatch n = new CountDownLatch(1);
  private boolean o;
  private bo p;
  private boolean q;
  
  public at(int paramInt, long paramLong)
  {
    this.a = paramInt;
    this.k = Millis100TimeProvider.INSTANCE.currentTimeMillis();
    this.e = paramLong;
  }
  
  public void a()
  {
    this.l = (Millis100TimeProvider.INSTANCE.currentTimeMillis() - this.k);
  }
  
  public void a(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.j = paramLong;
  }
  
  public void a(aw paramaw)
  {
    this.f = paramaw;
  }
  
  public void a(bo parambo)
  {
    this.p = parambo;
    c();
  }
  
  public void a(String paramString)
  {
    this.d = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public Object b()
  {
    this.n.await(this.e, TimeUnit.MILLISECONDS);
    if (this.o) {
      throw new CancellationException();
    }
    if (this.p != null) {
      throw this.p;
    }
    if (this.q) {
      return this.m;
    }
    throw new bn(this.c + "." + this.d + " timout:" + this.e + " seq:" + this.a);
  }
  
  public void b(String paramString)
  {
    this.c = paramString;
  }
  
  protected void c()
  {
    this.n.countDown();
  }
  
  public void c(String paramString)
  {
    this.g = paramString;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public void d(String paramString)
  {
    this.i = paramString;
  }
  
  public long e()
  {
    return this.e;
  }
  
  public String f()
  {
    return this.c;
  }
  
  public boolean g()
  {
    return this.b;
  }
  
  public int h()
  {
    return this.a;
  }
  
  public long i()
  {
    return this.k;
  }
  
  public long j()
  {
    return this.l;
  }
  
  public String k()
  {
    return this.g;
  }
  
  public int l()
  {
    return this.h;
  }
  
  public String m()
  {
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.at
 * JD-Core Version:    0.7.0.1
 */