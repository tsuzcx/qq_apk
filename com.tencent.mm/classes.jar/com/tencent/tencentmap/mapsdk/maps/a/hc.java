package com.tencent.tencentmap.mapsdk.maps.a;

import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;

public class hc
{
  int a;
  hb b;
  hb c;
  Interpolator d;
  ArrayList<hb> e;
  hg f;
  
  public hc(hb... paramVarArgs)
  {
    AppMethodBeat.i(148040);
    this.a = paramVarArgs.length;
    this.e = new ArrayList();
    this.e.addAll(Arrays.asList(paramVarArgs));
    this.b = ((hb)this.e.get(0));
    this.c = ((hb)this.e.get(this.a - 1));
    this.d = this.c.c();
    AppMethodBeat.o(148040);
  }
  
  public static hc a(double... paramVarArgs)
  {
    int i = 1;
    AppMethodBeat.i(148041);
    int j = paramVarArgs.length;
    hb.a[] arrayOfa = new hb.a[Math.max(j, 2)];
    if (j == 1)
    {
      arrayOfa[0] = ((hb.a)hb.a(0.0F));
      arrayOfa[1] = ((hb.a)hb.a(1.0F, paramVarArgs[0]));
    }
    for (;;)
    {
      paramVarArgs = new gy(arrayOfa);
      AppMethodBeat.o(148041);
      return paramVarArgs;
      arrayOfa[0] = ((hb.a)hb.a(0.0F, paramVarArgs[0]));
      while (i < j)
      {
        arrayOfa[i] = ((hb.a)hb.a(i / (j - 1), paramVarArgs[i]));
        i += 1;
      }
    }
  }
  
  public static hc a(Object... paramVarArgs)
  {
    int i = 1;
    AppMethodBeat.i(148042);
    int j = paramVarArgs.length;
    hb.b[] arrayOfb = new hb.b[Math.max(j, 2)];
    if (j == 1)
    {
      arrayOfb[0] = ((hb.b)hb.b(0.0F));
      arrayOfb[1] = ((hb.b)hb.a(1.0F, paramVarArgs[0]));
    }
    for (;;)
    {
      paramVarArgs = new hc(arrayOfb);
      AppMethodBeat.o(148042);
      return paramVarArgs;
      arrayOfb[0] = ((hb.b)hb.a(0.0F, paramVarArgs[0]));
      while (i < j)
      {
        arrayOfb[i] = ((hb.b)hb.a(i / (j - 1), paramVarArgs[i]));
        i += 1;
      }
    }
  }
  
  public void a(hg paramhg)
  {
    this.f = paramhg;
  }
  
  public hc b()
  {
    AppMethodBeat.i(148043);
    Object localObject = this.e;
    int j = this.e.size();
    hb[] arrayOfhb = new hb[j];
    int i = 0;
    while (i < j)
    {
      arrayOfhb[i] = ((hb)((ArrayList)localObject).get(i)).d();
      i += 1;
    }
    localObject = new hc(arrayOfhb);
    AppMethodBeat.o(148043);
    return localObject;
  }
  
  public String toString()
  {
    AppMethodBeat.i(148044);
    String str = " ";
    int i = 0;
    while (i < this.a)
    {
      str = str + ((hb)this.e.get(i)).a() + "  ";
      i += 1;
    }
    AppMethodBeat.o(148044);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.hc
 * JD-Core Version:    0.7.0.1
 */