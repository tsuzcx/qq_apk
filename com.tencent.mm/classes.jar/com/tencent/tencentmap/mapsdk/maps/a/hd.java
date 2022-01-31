package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class hd
  extends hh
{
  int b;
  
  private hd(gv paramgv, int paramInt)
  {
    super(paramgv);
    AppMethodBeat.i(148047);
    a(paramInt);
    AppMethodBeat.o(148047);
  }
  
  public static hd a(gv paramgv, int paramInt, hg paramhg, Object... paramVarArgs)
  {
    AppMethodBeat.i(148049);
    paramgv = new hd(paramgv, paramInt);
    paramgv.a(paramVarArgs);
    paramgv.a(paramhg);
    AppMethodBeat.o(148049);
    return paramgv;
  }
  
  public static hd a(gv paramgv, int paramInt, double... paramVarArgs)
  {
    AppMethodBeat.i(148048);
    paramgv = new hd(paramgv, paramInt);
    paramgv.a(paramVarArgs);
    AppMethodBeat.o(148048);
    return paramgv;
  }
  
  public final void a(int paramInt)
  {
    AppMethodBeat.i(148046);
    if (this.e != null)
    {
      he localhe = this.e[0];
      int i = localhe.b();
      this.f.remove(Integer.valueOf(i));
      this.f.put(Integer.valueOf(paramInt), localhe);
    }
    this.b = paramInt;
    AppMethodBeat.o(148046);
  }
  
  public final void a(double... paramVarArgs)
  {
    AppMethodBeat.i(148050);
    if ((this.e == null) || (this.e.length == 0))
    {
      a(new he[] { he.a(this.b, paramVarArgs) });
      AppMethodBeat.o(148050);
      return;
    }
    super.a(paramVarArgs);
    AppMethodBeat.o(148050);
  }
  
  public final void a(Object... paramVarArgs)
  {
    AppMethodBeat.i(148051);
    if ((this.e == null) || (this.e.length == 0))
    {
      a(new he[] { he.a(this.b, null, paramVarArgs) });
      AppMethodBeat.o(148051);
      return;
    }
    super.a(paramVarArgs);
    AppMethodBeat.o(148051);
  }
  
  public final hd b()
  {
    AppMethodBeat.i(148052);
    hd localhd = (hd)super.a();
    AppMethodBeat.o(148052);
    return localhd;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(148053);
    String str1 = "ObjectAnimator@" + Integer.toHexString(hashCode()) + ", target " + this.g;
    String str2 = str1;
    if (this.e != null)
    {
      int i = 0;
      for (;;)
      {
        str2 = str1;
        if (i >= this.e.length) {
          break;
        }
        str1 = str1 + "\n    " + this.e[i].toString();
        i += 1;
      }
    }
    AppMethodBeat.o(148053);
    return str2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.hd
 * JD-Core Version:    0.7.0.1
 */