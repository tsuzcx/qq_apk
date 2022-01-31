package com.tencent.tencentmap.mapsdk.a;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ql
{
  private static String z = "tencentmap/mapsdk_vector/color_texture_flat_style.png";
  private boolean A;
  private ql.a B = ql.a.a;
  private pz C;
  private int D = 100;
  private final List<qc> a = new ArrayList();
  private float b = -1.0F;
  private float c;
  private int d = lq.k;
  private int e = 0;
  private boolean f = true;
  private boolean g = false;
  private boolean h;
  private boolean i;
  private float j = 1.0F;
  private boolean k = false;
  private pp l;
  private List<Integer> m;
  private int[] n = null;
  private int[] o = { -16711936 };
  private int[] p = null;
  private int q = 0;
  @Deprecated
  private String r = z;
  private pr s = ps.a(z);
  private boolean t = false;
  private int u = 0;
  private boolean v = true;
  private List<qc> w = new ArrayList();
  private boolean x = false;
  private pr y = null;
  
  public int a()
  {
    return this.u;
  }
  
  public ql a(float paramFloat)
  {
    if (paramFloat < 0.0F)
    {
      this.b = 1.0F;
      return this;
    }
    this.b = paramFloat;
    return this;
  }
  
  public ql a(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
  
  public ql a(pr parampr)
  {
    this.s = parampr;
    this.B = ql.a.b;
    return this;
  }
  
  public ql a(pz parampz)
  {
    if (parampz != null)
    {
      this.C = parampz;
      this.i = true;
    }
    return this;
  }
  
  public ql a(qc paramqc, qc... paramVarArgs)
  {
    this.a.add(paramqc);
    if (paramVarArgs != null) {
      a(paramVarArgs);
    }
    return this;
  }
  
  public ql a(Iterable<qc> paramIterable)
  {
    if (paramIterable != null)
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        a((qc)paramIterable.next(), new qc[0]);
      }
    }
    return this;
  }
  
  public ql a(boolean paramBoolean)
  {
    this.f = paramBoolean;
    return this;
  }
  
  public ql a(qc[] paramArrayOfqc)
  {
    if (paramArrayOfqc != null) {
      this.a.addAll(Arrays.asList(paramArrayOfqc));
    }
    return this;
  }
  
  @Deprecated
  public void a(List<qc> paramList)
  {
    b(paramList);
  }
  
  public ql b(float paramFloat)
  {
    if (paramFloat < 0.0F)
    {
      this.c = 1.0F;
      return this;
    }
    this.c = paramFloat;
    return this;
  }
  
  public ql b(int paramInt)
  {
    this.o = new int[] { paramInt };
    return this;
  }
  
  public ql b(pr parampr)
  {
    this.y = parampr;
    return this;
  }
  
  public ql b(List<qc> paramList)
  {
    if (paramList != null)
    {
      this.a.clear();
      this.a.addAll(paramList);
    }
    return this;
  }
  
  public ql b(boolean paramBoolean)
  {
    this.h = paramBoolean;
    return this;
  }
  
  public List<qc> b()
  {
    return this.w;
  }
  
  public ql.a c()
  {
    return this.B;
  }
  
  public ql c(int paramInt)
  {
    this.e = Math.max(0, paramInt);
    return this;
  }
  
  public ql c(List<Integer> paramList)
  {
    this.m = paramList;
    return this;
  }
  
  public ql d(int paramInt)
  {
    this.q = paramInt;
    return this;
  }
  
  public List<qc> d()
  {
    return this.a;
  }
  
  public float e()
  {
    return this.b;
  }
  
  public ql e(int paramInt)
  {
    this.D = paramInt;
    return this;
  }
  
  public int f()
  {
    return this.d;
  }
  
  public int[][] g()
  {
    if ((this.n == null) || (this.p == null)) {}
    while (this.n.length != this.p.length) {
      return null;
    }
    int i1 = this.n.length;
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { 2, i1 });
    arrayOfInt[0] = this.n;
    arrayOfInt[1] = this.p;
    return arrayOfInt;
  }
  
  public int h()
  {
    return this.e;
  }
  
  public pz i()
  {
    return this.C;
  }
  
  public boolean j()
  {
    return this.f;
  }
  
  public boolean k()
  {
    return this.h;
  }
  
  public boolean l()
  {
    return this.i;
  }
  
  public float m()
  {
    return this.j;
  }
  
  public boolean n()
  {
    return this.k;
  }
  
  public pp o()
  {
    return this.l;
  }
  
  public int p()
  {
    return this.q;
  }
  
  public pr q()
  {
    return this.s;
  }
  
  public boolean r()
  {
    return this.v;
  }
  
  public pr s()
  {
    return this.y;
  }
  
  public int t()
  {
    return this.D;
  }
  
  public boolean u()
  {
    return this.A;
  }
  
  public List<Integer> v()
  {
    return this.m;
  }
  
  public float w()
  {
    return this.c;
  }
  
  public int[] x()
  {
    return this.o;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ql
 * JD-Core Version:    0.7.0.1
 */