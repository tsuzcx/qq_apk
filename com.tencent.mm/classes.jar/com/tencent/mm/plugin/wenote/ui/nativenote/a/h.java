package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.util.SparseArray;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
{
  public static final int JKT = 2131495863;
  public static final int JKU = 2131495862;
  public static final int qOn = 2131495866;
  public static final int qOo = 2131495865;
  public SparseArray<Integer> JKV;
  
  public h()
  {
    AppMethodBeat.i(30862);
    this.JKV = new SparseArray();
    this.JKV.put(1, Integer.valueOf(qOn));
    this.JKV.put(2, Integer.valueOf(qOo));
    this.JKV.put(4, Integer.valueOf(qOo));
    this.JKV.put(3, Integer.valueOf(qOo));
    this.JKV.put(5, Integer.valueOf(qOo));
    this.JKV.put(6, Integer.valueOf(qOo));
    this.JKV.put(0, Integer.valueOf(qOo));
    this.JKV.put(-1, Integer.valueOf(qOo));
    this.JKV.put(-3, Integer.valueOf(JKT));
    this.JKV.put(-2, Integer.valueOf(qOo));
    this.JKV.put(-4, Integer.valueOf(qOo));
    this.JKV.put(20, Integer.valueOf(qOo));
    this.JKV.put(30, Integer.valueOf(JKU));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.h
 * JD-Core Version:    0.7.0.1
 */