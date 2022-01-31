package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Point;
import java.util.ArrayList;
import java.util.List;

public final class ad
{
  public static ac a()
  {
    ns localns = new ns();
    localns.o = ns.a;
    return new ac(localns);
  }
  
  public static ac a(float paramFloat)
  {
    ns localns = new ns();
    localns.o = ns.d;
    localns.r = paramFloat;
    return new ac(localns);
  }
  
  public static ac a(float paramFloat1, float paramFloat2)
  {
    ns localns = new ns();
    localns.o = ns.c;
    localns.p = paramFloat1;
    localns.q = paramFloat2;
    return new ac(localns);
  }
  
  public static ac a(float paramFloat, Point paramPoint)
  {
    ns localns = new ns();
    localns.o = ns.f;
    localns.t = paramFloat;
    localns.u = paramPoint;
    return new ac(localns);
  }
  
  public static ac a(pu parampu)
  {
    ns localns = new ns();
    localns.o = ns.g;
    localns.v = parampu;
    return new ac(localns);
  }
  
  public static ac a(qc paramqc)
  {
    ns localns = new ns();
    localns.o = ns.h;
    localns.w = paramqc;
    return new ac(localns);
  }
  
  public static ac a(qc paramqc, float paramFloat)
  {
    ns localns = new ns();
    localns.o = ns.i;
    localns.x = paramqc;
    localns.y = paramFloat;
    return new ac(localns);
  }
  
  public static ac a(qd paramqd, int paramInt)
  {
    ns localns = new ns();
    localns.o = ns.j;
    localns.z = paramqd;
    localns.A = paramInt;
    return new ac(localns);
  }
  
  public static ac a(qd paramqd, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ns localns = new ns();
    localns.o = ns.l;
    localns.B = paramqd;
    localns.F = paramInt1;
    localns.G = paramInt2;
    localns.H = paramInt3;
    localns.I = paramInt4;
    return new ac(localns);
  }
  
  public static ac a(qd paramqd, qc paramqc, int paramInt)
  {
    if (paramqd == null) {
      return null;
    }
    qc localqc1 = paramqd.b;
    qc localqc2 = lq.a(paramqc, localqc1);
    paramqd = paramqd.a;
    paramqc = lq.a(paramqc, paramqd);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localqc1);
    localArrayList.add(localqc2);
    localArrayList.add(paramqd);
    localArrayList.add(paramqc);
    return a(new qd.a().a(localArrayList).a(), paramInt);
  }
  
  public static ac b()
  {
    ns localns = new ns();
    localns.o = ns.b;
    return new ac(localns);
  }
  
  public static ac b(float paramFloat)
  {
    ns localns = new ns();
    localns.o = ns.e;
    localns.s = paramFloat;
    return new ac(localns);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ad
 * JD-Core Version:    0.7.0.1
 */