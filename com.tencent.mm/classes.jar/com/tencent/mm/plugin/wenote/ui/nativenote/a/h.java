package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.util.SparseArray;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
{
  public static final int BGB = 2131495031;
  public static final int BGC = 2131495030;
  public static final int oli = 2131495034;
  public static final int olj = 2131495033;
  public SparseArray<Integer> BGD;
  
  public h()
  {
    AppMethodBeat.i(30862);
    this.BGD = new SparseArray();
    this.BGD.put(1, Integer.valueOf(oli));
    this.BGD.put(2, Integer.valueOf(olj));
    this.BGD.put(4, Integer.valueOf(olj));
    this.BGD.put(3, Integer.valueOf(olj));
    this.BGD.put(5, Integer.valueOf(olj));
    this.BGD.put(6, Integer.valueOf(olj));
    this.BGD.put(0, Integer.valueOf(olj));
    this.BGD.put(-1, Integer.valueOf(olj));
    this.BGD.put(-3, Integer.valueOf(BGB));
    this.BGD.put(-2, Integer.valueOf(olj));
    this.BGD.put(-4, Integer.valueOf(olj));
    this.BGD.put(20, Integer.valueOf(olj));
    this.BGD.put(30, Integer.valueOf(BGC));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.h
 * JD-Core Version:    0.7.0.1
 */