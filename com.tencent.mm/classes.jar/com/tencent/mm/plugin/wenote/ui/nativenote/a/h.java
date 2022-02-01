package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.util.SparseArray;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;

public final class h
{
  public static final int XDL = R.i.gmE;
  public static final int XDM = R.i.gmD;
  public static final int xwO = R.i.gmH;
  public static final int xwP = R.i.gmG;
  public SparseArray<Integer> XDN;
  
  public h()
  {
    AppMethodBeat.i(30862);
    this.XDN = new SparseArray();
    this.XDN.put(1, Integer.valueOf(xwO));
    this.XDN.put(2, Integer.valueOf(xwP));
    this.XDN.put(4, Integer.valueOf(xwP));
    this.XDN.put(3, Integer.valueOf(xwP));
    this.XDN.put(5, Integer.valueOf(xwP));
    this.XDN.put(6, Integer.valueOf(xwP));
    this.XDN.put(0, Integer.valueOf(xwP));
    this.XDN.put(-1, Integer.valueOf(xwP));
    this.XDN.put(-3, Integer.valueOf(XDL));
    this.XDN.put(-2, Integer.valueOf(xwP));
    this.XDN.put(-4, Integer.valueOf(xwP));
    this.XDN.put(20, Integer.valueOf(xwP));
    this.XDN.put(30, Integer.valueOf(XDM));
    AppMethodBeat.o(30862);
  }
  
  public static a a(int paramInt, View paramView, com.tencent.mm.plugin.wenote.model.nativenote.manager.k paramk)
  {
    AppMethodBeat.i(30863);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(30863);
      return null;
    case 1: 
      paramView = new m(paramView, paramk);
      AppMethodBeat.o(30863);
      return paramView;
    case 30: 
      paramView = new d(paramView, paramk);
      AppMethodBeat.o(30863);
      return paramView;
    case 0: 
      paramView = new n(paramView, paramk);
      AppMethodBeat.o(30863);
      return paramView;
    case 2: 
      paramView = new g(paramView, paramk);
      AppMethodBeat.o(30863);
      return paramView;
    case 4: 
      paramView = new p(paramView, paramk);
      AppMethodBeat.o(30863);
      return paramView;
    case 3: 
      paramView = new i(paramView, paramk);
      AppMethodBeat.o(30863);
      return paramView;
    case 5: 
      paramView = new e(paramView, paramk);
      AppMethodBeat.o(30863);
      return paramView;
    case 6: 
      paramView = new o(paramView, paramk);
      AppMethodBeat.o(30863);
      return paramView;
    case -1: 
      paramView = new l(paramView, paramk);
      AppMethodBeat.o(30863);
      return paramView;
    case -3: 
      paramView = new f(paramView, paramk);
      AppMethodBeat.o(30863);
      return paramView;
    case -2: 
      paramView = new b(paramView, paramk);
      AppMethodBeat.o(30863);
      return paramView;
    case -4: 
      paramView = new k(paramView, paramk);
      AppMethodBeat.o(30863);
      return paramView;
    }
    paramView = new c(paramView, paramk);
    AppMethodBeat.o(30863);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.h
 * JD-Core Version:    0.7.0.1
 */