package com.tencent.tencentmap.mapsdk.maps.a;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;

public class hh
  extends gw
{
  private static ThreadLocal<Object> b;
  private static final ThreadLocal<ArrayList<hh>> h;
  private static final ThreadLocal<ArrayList<hh>> i;
  private static final ThreadLocal<ArrayList<hh>> j;
  private static final ThreadLocal<ArrayList<hh>> k;
  private static final ThreadLocal<ArrayList<hh>> l;
  private static final Interpolator m;
  private static long v;
  long c = -1L;
  int d = 0;
  he[] e;
  HashMap<Integer, he> f;
  protected gv g;
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
  
  static
  {
    AppMethodBeat.i(148087);
    b = new ThreadLocal();
    h = new hh.1();
    i = new hh.2();
    j = new hh.3();
    k = new hh.4();
    l = new hh.5();
    m = new LinearInterpolator();
    v = 10L;
    AppMethodBeat.o(148087);
  }
  
  public hh(gv paramgv)
  {
    this.g = paramgv;
  }
  
  public static void a(long paramLong)
  {
    v = paramLong;
  }
  
  public gw a()
  {
    int i2 = 0;
    AppMethodBeat.i(148084);
    hh localhh = (hh)super.a();
    int i3;
    int i1;
    if (this.z != null)
    {
      localObject = this.z;
      localhh.z = new ArrayList();
      i3 = ((ArrayList)localObject).size();
      i1 = 0;
      while (i1 < i3)
      {
        localhh.z.add(((ArrayList)localObject).get(i1));
        i1 += 1;
      }
    }
    localhh.c = -1L;
    localhh.n = false;
    localhh.o = 0;
    localhh.d = 0;
    localhh.q = false;
    Object localObject = this.e;
    if (localObject != null)
    {
      i3 = localObject.length;
      localhh.e = new he[i3];
      localhh.f = new HashMap(i3);
      i1 = i2;
      while (i1 < i3)
      {
        he localhe = localObject[i1].a();
        localhh.e[i1] = localhe;
        localhh.f.put(Integer.valueOf(localhe.b()), localhe);
        i1 += 1;
      }
    }
    AppMethodBeat.o(148084);
    return localhh;
  }
  
  public void a(hg<?> paramhg)
  {
    AppMethodBeat.i(148083);
    if ((paramhg != null) && (this.e != null) && (this.e.length > 0)) {
      this.e[0].a(paramhg);
    }
    AppMethodBeat.o(148083);
  }
  
  public void a(double... paramVarArgs)
  {
    AppMethodBeat.i(148080);
    if ((paramVarArgs == null) || (paramVarArgs.length == 0))
    {
      AppMethodBeat.o(148080);
      return;
    }
    if ((this.e == null) || (this.e.length == 0))
    {
      a(new he[] { he.a(0, paramVarArgs) });
      AppMethodBeat.o(148080);
      return;
    }
    this.e[0].a(paramVarArgs);
    AppMethodBeat.o(148080);
  }
  
  public void a(he... paramVarArgs)
  {
    AppMethodBeat.i(148082);
    int i2 = paramVarArgs.length;
    this.e = paramVarArgs;
    this.f = new HashMap(i2);
    int i1 = 0;
    while (i1 < i2)
    {
      he localhe = paramVarArgs[i1];
      this.f.put(Integer.valueOf(localhe.b()), localhe);
      i1 += 1;
    }
    AppMethodBeat.o(148082);
  }
  
  public void a(Object... paramVarArgs)
  {
    AppMethodBeat.i(148081);
    if ((paramVarArgs == null) || (paramVarArgs.length == 0))
    {
      AppMethodBeat.o(148081);
      return;
    }
    if ((this.e == null) || (this.e.length == 0))
    {
      a(new he[] { he.a(0, null, paramVarArgs) });
      AppMethodBeat.o(148081);
      return;
    }
    this.e[0].a(paramVarArgs);
    AppMethodBeat.o(148081);
  }
  
  public String toString()
  {
    AppMethodBeat.i(148085);
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
    AppMethodBeat.o(148085);
    return str2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.hh
 * JD-Core Version:    0.7.0.1
 */