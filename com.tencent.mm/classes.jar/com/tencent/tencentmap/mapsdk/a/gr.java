package com.tencent.tencentmap.mapsdk.a;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class gr
  extends aw
{
  protected String[] b = { "findObjectById", "findObjectById4All", "findObjectById4Any", "findObjectByIdInSameGroup", "findObjectByIdInSameSet", "findObjectByIdInSameStation" };
  protected String c = "GBK";
  
  public final int _onDispatch(String paramString, ju paramju)
  {
    int i = Arrays.binarySearch(this.b, paramString);
    if ((i < 0) || (i >= 6)) {
      return -1;
    }
    switch (i)
    {
    }
    for (;;)
    {
      return 0;
      if (paramju.e != 0)
      {
        a(paramju.e);
        return paramju.e;
      }
      paramString = new nk(paramju.f);
      paramString.a(this.c);
      paramju = new ArrayList();
      paramju.add(new fq());
      a((ArrayList)paramString.a(paramju, 0, true));
      continue;
      if (paramju.e != 0)
      {
        b(paramju.e);
        return paramju.e;
      }
      paramString = new nk(paramju.f);
      paramString.a(this.c);
      i = paramString.a(0, 0, true);
      paramju = new ArrayList();
      paramju.add(new fq());
      paramju = (ArrayList)paramString.a(paramju, 2, true);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new fq());
      a(i, paramju, (ArrayList)paramString.a(localArrayList, 3, true));
      continue;
      if (paramju.e != 0)
      {
        f(paramju.e);
        return paramju.e;
      }
      paramString = new nk(paramju.f);
      paramString.a(this.c);
      i = paramString.a(0, 0, true);
      paramju = new ArrayList();
      paramju.add(new fq());
      paramju = (ArrayList)paramString.a(paramju, 2, true);
      localArrayList = new ArrayList();
      localArrayList.add(new fq());
      e(i, paramju, (ArrayList)paramString.a(localArrayList, 3, true));
      continue;
      if (paramju.e != 0)
      {
        c(paramju.e);
        return paramju.e;
      }
      paramString = new nk(paramju.f);
      paramString.a(this.c);
      i = paramString.a(0, 0, true);
      paramju = new ArrayList();
      paramju.add(new fq());
      paramju = (ArrayList)paramString.a(paramju, 2, true);
      localArrayList = new ArrayList();
      localArrayList.add(new fq());
      b(i, paramju, (ArrayList)paramString.a(localArrayList, 3, true));
      continue;
      if (paramju.e != 0)
      {
        e(paramju.e);
        return paramju.e;
      }
      paramString = new nk(paramju.f);
      paramString.a(this.c);
      i = paramString.a(0, 0, true);
      paramju = new ArrayList();
      paramju.add(new fq());
      paramju = (ArrayList)paramString.a(paramju, 3, true);
      localArrayList = new ArrayList();
      localArrayList.add(new fq());
      d(i, paramju, (ArrayList)paramString.a(localArrayList, 4, true));
      continue;
      if (paramju.e != 0)
      {
        d(paramju.e);
        return paramju.e;
      }
      paramString = new nk(paramju.f);
      paramString.a(this.c);
      i = paramString.a(0, 0, true);
      paramju = new ArrayList();
      paramju.add(new fq());
      paramju = (ArrayList)paramString.a(paramju, 3, true);
      localArrayList = new ArrayList();
      localArrayList.add(new fq());
      c(i, paramju, (ArrayList)paramString.a(localArrayList, 4, true));
    }
  }
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt, ArrayList<fq> paramArrayList1, ArrayList<fq> paramArrayList2);
  
  public abstract void a(ArrayList<fq> paramArrayList);
  
  public abstract void b(int paramInt);
  
  public abstract void b(int paramInt, ArrayList<fq> paramArrayList1, ArrayList<fq> paramArrayList2);
  
  public abstract void c(int paramInt);
  
  public abstract void c(int paramInt, ArrayList<fq> paramArrayList1, ArrayList<fq> paramArrayList2);
  
  public abstract void d(int paramInt);
  
  public abstract void d(int paramInt, ArrayList<fq> paramArrayList1, ArrayList<fq> paramArrayList2);
  
  public abstract void e(int paramInt);
  
  public abstract void e(int paramInt, ArrayList<fq> paramArrayList1, ArrayList<fq> paramArrayList2);
  
  public abstract void f(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.gr
 * JD-Core Version:    0.7.0.1
 */