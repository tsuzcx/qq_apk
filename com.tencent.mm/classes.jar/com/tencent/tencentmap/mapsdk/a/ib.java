package com.tencent.tencentmap.mapsdk.a;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Arrays;

public class ib
{
  int a;
  ia b;
  ia c;
  Interpolator d;
  ArrayList<ia> e;
  if f;
  
  public ib(ia... paramVarArgs)
  {
    this.a = paramVarArgs.length;
    this.e = new ArrayList();
    this.e.addAll(Arrays.asList(paramVarArgs));
    this.b = ((ia)this.e.get(0));
    this.c = ((ia)this.e.get(this.a - 1));
    this.d = this.c.c();
  }
  
  public static ib a(double... paramVarArgs)
  {
    int i = 1;
    int j = paramVarArgs.length;
    ia.a[] arrayOfa = new ia.a[Math.max(j, 2)];
    if (j == 1)
    {
      arrayOfa[0] = ((ia.a)ia.a(0.0F));
      arrayOfa[1] = ((ia.a)ia.a(1.0F, paramVarArgs[0]));
    }
    for (;;)
    {
      return new hx(arrayOfa);
      arrayOfa[0] = ((ia.a)ia.a(0.0F, paramVarArgs[0]));
      while (i < j)
      {
        arrayOfa[i] = ((ia.a)ia.a(i / (j - 1), paramVarArgs[i]));
        i += 1;
      }
    }
  }
  
  public static ib a(Object... paramVarArgs)
  {
    int i = 1;
    int j = paramVarArgs.length;
    ia.b[] arrayOfb = new ia.b[Math.max(j, 2)];
    if (j == 1)
    {
      arrayOfb[0] = ((ia.b)ia.b(0.0F));
      arrayOfb[1] = ((ia.b)ia.a(1.0F, paramVarArgs[0]));
    }
    for (;;)
    {
      return new ib(arrayOfb);
      arrayOfb[0] = ((ia.b)ia.a(0.0F, paramVarArgs[0]));
      while (i < j)
      {
        arrayOfb[i] = ((ia.b)ia.a(i / (j - 1), paramVarArgs[i]));
        i += 1;
      }
    }
  }
  
  public void a(if paramif)
  {
    this.f = paramif;
  }
  
  public ib b()
  {
    ArrayList localArrayList = this.e;
    int j = this.e.size();
    ia[] arrayOfia = new ia[j];
    int i = 0;
    while (i < j)
    {
      arrayOfia[i] = ((ia)localArrayList.get(i)).d();
      i += 1;
    }
    return new ib(arrayOfia);
  }
  
  public String toString()
  {
    String str = " ";
    int i = 0;
    while (i < this.a)
    {
      str = str + ((ia)this.e.get(i)).a() + "  ";
      i += 1;
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ib
 * JD-Core Version:    0.7.0.1
 */