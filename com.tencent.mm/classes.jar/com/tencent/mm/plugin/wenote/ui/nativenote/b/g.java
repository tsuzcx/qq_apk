package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.util.SparseArray;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
{
  public static final int vDA = 2130970369;
  public static final int vDy = 2130970372;
  public static final int vDz = 2130970371;
  public SparseArray<Integer> vDB;
  
  public g()
  {
    AppMethodBeat.i(27161);
    this.vDB = new SparseArray();
    this.vDB.put(1, Integer.valueOf(vDy));
    this.vDB.put(2, Integer.valueOf(vDz));
    this.vDB.put(4, Integer.valueOf(vDz));
    this.vDB.put(3, Integer.valueOf(vDz));
    this.vDB.put(5, Integer.valueOf(vDz));
    this.vDB.put(6, Integer.valueOf(vDz));
    this.vDB.put(0, Integer.valueOf(vDz));
    this.vDB.put(-1, Integer.valueOf(vDz));
    this.vDB.put(-3, Integer.valueOf(vDA));
    this.vDB.put(-2, Integer.valueOf(vDz));
    this.vDB.put(-4, Integer.valueOf(vDz));
    this.vDB.put(20, Integer.valueOf(vDz));
    AppMethodBeat.o(27161);
  }
  
  public static a a(int paramInt, View paramView, com.tencent.mm.plugin.wenote.model.nativenote.manager.k paramk)
  {
    AppMethodBeat.i(27162);
    switch (paramInt)
    {
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    default: 
      AppMethodBeat.o(27162);
      return null;
    case 1: 
      paramView = new l(paramView, paramk);
      AppMethodBeat.o(27162);
      return paramView;
    case 0: 
      paramView = new m(paramView, paramk);
      AppMethodBeat.o(27162);
      return paramView;
    case 2: 
      paramView = new f(paramView, paramk);
      AppMethodBeat.o(27162);
      return paramView;
    case 4: 
      paramView = new o(paramView, paramk);
      AppMethodBeat.o(27162);
      return paramView;
    case 3: 
      paramView = new h(paramView, paramk);
      AppMethodBeat.o(27162);
      return paramView;
    case 5: 
      paramView = new d(paramView, paramk);
      AppMethodBeat.o(27162);
      return paramView;
    case 6: 
      paramView = new n(paramView, paramk);
      AppMethodBeat.o(27162);
      return paramView;
    case -1: 
      paramView = new k(paramView, paramk);
      AppMethodBeat.o(27162);
      return paramView;
    case -3: 
      paramView = new e(paramView, paramk);
      AppMethodBeat.o(27162);
      return paramView;
    case -2: 
      paramView = new b(paramView, paramk);
      AppMethodBeat.o(27162);
      return paramView;
    case -4: 
      paramView = new j(paramView, paramk);
      AppMethodBeat.o(27162);
      return paramView;
    }
    paramView = new c(paramView, paramk);
    AppMethodBeat.o(27162);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.b.g
 * JD-Core Version:    0.7.0.1
 */