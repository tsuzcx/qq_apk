package com.tencent.tencentmap.mapsdk.a;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.HashMap;

public class ig
  extends hv
{
  private static ThreadLocal<Object> b = new ThreadLocal();
  private static final ThreadLocal<ArrayList<ig>> h = new ig.1();
  private static final ThreadLocal<ArrayList<ig>> i = new ig.2();
  private static final ThreadLocal<ArrayList<ig>> j = new ThreadLocal()
  {
    protected final ArrayList<ig> a()
    {
      return new ArrayList();
    }
  };
  private static final ThreadLocal<ArrayList<ig>> k = new ThreadLocal()
  {
    protected final ArrayList<ig> a()
    {
      return new ArrayList();
    }
  };
  private static final ThreadLocal<ArrayList<ig>> l = new ig.5();
  private static final Interpolator m = new LinearInterpolator();
  private static long v = 10L;
  long c = -1L;
  int d = 0;
  id[] e;
  HashMap<Integer, id> f;
  protected hu g;
  private boolean n = false;
  private int o = 0;
  private float p = 0.0F;
  private boolean q = false;
  private boolean r = false;
  private boolean s = false;
  private long t = 300L;
  private long u = 0L;
  private int w = 0;
  private int x = 1;
  private Interpolator y = m;
  private ArrayList<Object> z = null;
  
  public ig(hu paramhu)
  {
    this.g = paramhu;
  }
  
  public static void a(long paramLong)
  {
    v = paramLong;
  }
  
  public hv a()
  {
    int i2 = 0;
    ig localig = (ig)super.a();
    int i3;
    int i1;
    if (this.z != null)
    {
      localObject = this.z;
      localig.z = new ArrayList();
      i3 = ((ArrayList)localObject).size();
      i1 = 0;
      while (i1 < i3)
      {
        localig.z.add(((ArrayList)localObject).get(i1));
        i1 += 1;
      }
    }
    localig.c = -1L;
    localig.n = false;
    localig.o = 0;
    localig.d = 0;
    localig.q = false;
    Object localObject = this.e;
    if (localObject != null)
    {
      i3 = localObject.length;
      localig.e = new id[i3];
      localig.f = new HashMap(i3);
      i1 = i2;
      while (i1 < i3)
      {
        id localid = localObject[i1].a();
        localig.e[i1] = localid;
        localig.f.put(Integer.valueOf(localid.b()), localid);
        i1 += 1;
      }
    }
    return localig;
  }
  
  public void a(if<?> paramif)
  {
    if ((paramif != null) && (this.e != null) && (this.e.length > 0)) {
      this.e[0].a(paramif);
    }
  }
  
  public void a(double... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      return;
    }
    if ((this.e == null) || (this.e.length == 0))
    {
      a(new id[] { id.a(0, paramVarArgs) });
      return;
    }
    this.e[0].a(paramVarArgs);
  }
  
  public void a(id... paramVarArgs)
  {
    int i2 = paramVarArgs.length;
    this.e = paramVarArgs;
    this.f = new HashMap(i2);
    int i1 = 0;
    while (i1 < i2)
    {
      id localid = paramVarArgs[i1];
      this.f.put(Integer.valueOf(localid.b()), localid);
      i1 += 1;
    }
  }
  
  public void a(Object... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      return;
    }
    if ((this.e == null) || (this.e.length == 0))
    {
      a(new id[] { id.a(0, null, paramVarArgs) });
      return;
    }
    this.e[0].a(paramVarArgs);
  }
  
  public String toString()
  {
    String str1 = "ValueAnimator@" + Integer.toHexString(hashCode());
    String str2 = str1;
    if (this.e != null)
    {
      int i1 = 0;
      for (;;)
      {
        str2 = str1;
        if (i1 >= this.e.length) {
          break;
        }
        str1 = str1 + "\n    " + this.e[i1].toString();
        i1 += 1;
      }
    }
    return str2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ig
 * JD-Core Version:    0.7.0.1
 */