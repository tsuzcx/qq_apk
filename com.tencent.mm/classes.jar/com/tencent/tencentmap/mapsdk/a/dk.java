package com.tencent.tencentmap.mapsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.ka;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class dk
{
  private static String A = "color_texture_flat_style.png";
  private boolean B;
  private a C;
  private cv D;
  private int E;
  private int F;
  private final List<cz> a;
  private float b;
  private float c;
  private int d;
  private int e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  private float j;
  private boolean k;
  private ci l;
  private List<Integer> m;
  private int[] n;
  private int[] o;
  private int[] p;
  private int q;
  private int r;
  @Deprecated
  private String s;
  private ck t;
  private boolean u;
  private int v;
  private boolean w;
  private List<cz> x;
  private boolean y;
  private ck z;
  
  public dk()
  {
    AppMethodBeat.i(101056);
    this.i = false;
    this.n = null;
    this.o = new int[] { -16711936 };
    this.p = null;
    this.q = -7829368;
    this.r = 0;
    this.s = A;
    this.t = cl.a(A);
    this.u = false;
    this.v = 0;
    this.w = true;
    this.y = false;
    this.z = null;
    this.C = a.a;
    this.E = dg.a;
    this.F = 100;
    this.b = -1.0F;
    this.d = ka.l;
    this.f = true;
    this.g = false;
    this.a = new ArrayList();
    this.j = 1.0F;
    this.k = false;
    this.v = 0;
    this.e = 0;
    this.x = new ArrayList();
    AppMethodBeat.o(101056);
  }
  
  public int a()
  {
    return this.v;
  }
  
  public dk a(float paramFloat)
  {
    if (paramFloat < 0.0F)
    {
      this.b = 9.0F;
      return this;
    }
    this.b = paramFloat;
    return this;
  }
  
  public dk a(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
  
  public dk a(ck paramck)
  {
    this.t = paramck;
    this.C = a.b;
    return this;
  }
  
  public dk a(cv paramcv)
  {
    if (paramcv != null)
    {
      this.D = paramcv;
      this.i = true;
    }
    return this;
  }
  
  public dk a(cz paramcz, cz... paramVarArgs)
  {
    AppMethodBeat.i(150116);
    this.a.add(paramcz);
    if (paramVarArgs != null) {
      a(paramVarArgs);
    }
    AppMethodBeat.o(150116);
    return this;
  }
  
  public dk a(Iterable<cz> paramIterable)
  {
    AppMethodBeat.i(150118);
    if (paramIterable != null)
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        a((cz)paramIterable.next(), new cz[0]);
      }
    }
    AppMethodBeat.o(150118);
    return this;
  }
  
  public dk a(boolean paramBoolean)
  {
    this.f = paramBoolean;
    return this;
  }
  
  public dk a(cz[] paramArrayOfcz)
  {
    AppMethodBeat.i(150117);
    if (paramArrayOfcz != null) {
      this.a.addAll(Arrays.asList(paramArrayOfcz));
    }
    AppMethodBeat.o(150117);
    return this;
  }
  
  @Deprecated
  public void a(List<cz> paramList)
  {
    AppMethodBeat.i(150114);
    b(paramList);
    AppMethodBeat.o(150114);
  }
  
  public dk b(float paramFloat)
  {
    if (paramFloat < 0.0F)
    {
      this.c = 1.0F;
      return this;
    }
    this.c = paramFloat;
    return this;
  }
  
  public dk b(int paramInt)
  {
    this.o = new int[] { paramInt };
    return this;
  }
  
  public dk b(ck paramck)
  {
    this.z = paramck;
    return this;
  }
  
  public dk b(List<cz> paramList)
  {
    AppMethodBeat.i(150115);
    if (paramList != null)
    {
      this.a.clear();
      this.a.addAll(paramList);
    }
    AppMethodBeat.o(150115);
    return this;
  }
  
  public dk b(boolean paramBoolean)
  {
    this.h = paramBoolean;
    return this;
  }
  
  public List<cz> b()
  {
    return this.x;
  }
  
  public a c()
  {
    return this.C;
  }
  
  public dk c(int paramInt)
  {
    this.q = paramInt;
    return this;
  }
  
  public dk c(List<Integer> paramList)
  {
    this.m = paramList;
    return this;
  }
  
  public int d()
  {
    return this.q;
  }
  
  public dk d(int paramInt)
  {
    AppMethodBeat.i(150119);
    this.e = Math.max(0, paramInt);
    AppMethodBeat.o(150119);
    return this;
  }
  
  public dk e(int paramInt)
  {
    this.r = paramInt;
    return this;
  }
  
  public List<cz> e()
  {
    return this.a;
  }
  
  public float f()
  {
    return this.b;
  }
  
  public dk f(int paramInt)
  {
    if ((paramInt < dg.a) || (paramInt > dg.c)) {
      return this;
    }
    this.E = paramInt;
    return this;
  }
  
  public int g()
  {
    return this.d;
  }
  
  public dk g(int paramInt)
  {
    this.F = paramInt;
    return this;
  }
  
  public int[][] h()
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
  
  public int i()
  {
    return this.e;
  }
  
  public cv j()
  {
    return this.D;
  }
  
  public boolean k()
  {
    return this.f;
  }
  
  public boolean l()
  {
    return this.h;
  }
  
  public boolean m()
  {
    return this.i;
  }
  
  public float n()
  {
    return this.j;
  }
  
  public boolean o()
  {
    return this.k;
  }
  
  public ci p()
  {
    return this.l;
  }
  
  public int q()
  {
    return this.r;
  }
  
  public ck r()
  {
    return this.t;
  }
  
  public boolean s()
  {
    return this.w;
  }
  
  public int t()
  {
    return this.E;
  }
  
  public ck u()
  {
    return this.z;
  }
  
  public int v()
  {
    return this.F;
  }
  
  public boolean w()
  {
    return this.B;
  }
  
  public List<Integer> x()
  {
    return this.m;
  }
  
  public float y()
  {
    return this.c;
  }
  
  public int[] z()
  {
    return this.o;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(150113);
      a = new a("LINE_COLOR_NONE", 0);
      b = new a("LINE_COLOR_TEXTURE", 1);
      c = new a("LINE_COLOR_ARGB", 2);
      d = new a[] { a, b, c };
      AppMethodBeat.o(150113);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.dk
 * JD-Core Version:    0.7.0.1
 */