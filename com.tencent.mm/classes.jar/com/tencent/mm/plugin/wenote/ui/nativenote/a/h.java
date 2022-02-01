package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.util.SparseArray;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
{
  public static final int CYI = 2131495031;
  public static final int CYJ = 2131495030;
  public static final int oOI = 2131495034;
  public static final int oOJ = 2131495033;
  public SparseArray<Integer> CYK;
  
  public h()
  {
    AppMethodBeat.i(30862);
    this.CYK = new SparseArray();
    this.CYK.put(1, Integer.valueOf(oOI));
    this.CYK.put(2, Integer.valueOf(oOJ));
    this.CYK.put(4, Integer.valueOf(oOJ));
    this.CYK.put(3, Integer.valueOf(oOJ));
    this.CYK.put(5, Integer.valueOf(oOJ));
    this.CYK.put(6, Integer.valueOf(oOJ));
    this.CYK.put(0, Integer.valueOf(oOJ));
    this.CYK.put(-1, Integer.valueOf(oOJ));
    this.CYK.put(-3, Integer.valueOf(CYI));
    this.CYK.put(-2, Integer.valueOf(oOJ));
    this.CYK.put(-4, Integer.valueOf(oOJ));
    this.CYK.put(20, Integer.valueOf(oOJ));
    this.CYK.put(30, Integer.valueOf(CYJ));
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