package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.util.SparseArray;
import android.view.View;
import com.tencent.mm.R.i;

public final class g
{
  public static final int rMU = R.i.note_editor_text_item;
  public static final int rMV = R.i.note_editor_other_item;
  public static final int rMW = R.i.note_editor_header_item;
  public SparseArray<Integer> rMX = new SparseArray();
  
  public g()
  {
    this.rMX.put(1, Integer.valueOf(rMU));
    this.rMX.put(2, Integer.valueOf(rMV));
    this.rMX.put(4, Integer.valueOf(rMV));
    this.rMX.put(3, Integer.valueOf(rMV));
    this.rMX.put(5, Integer.valueOf(rMV));
    this.rMX.put(6, Integer.valueOf(rMV));
    this.rMX.put(0, Integer.valueOf(rMV));
    this.rMX.put(-1, Integer.valueOf(rMV));
    this.rMX.put(-3, Integer.valueOf(rMW));
    this.rMX.put(-2, Integer.valueOf(rMV));
    this.rMX.put(-4, Integer.valueOf(rMV));
    this.rMX.put(20, Integer.valueOf(rMV));
  }
  
  public static a a(int paramInt, View paramView, com.tencent.mm.plugin.wenote.model.nativenote.manager.k paramk)
  {
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
      return null;
    case 1: 
      return new l(paramView, paramk);
    case 0: 
      return new m(paramView, paramk);
    case 2: 
      return new f(paramView, paramk);
    case 4: 
      return new o(paramView, paramk);
    case 3: 
      return new h(paramView, paramk);
    case 5: 
      return new d(paramView, paramk);
    case 6: 
      return new n(paramView, paramk);
    case -1: 
      return new k(paramView, paramk);
    case -3: 
      return new e(paramView, paramk);
    case -2: 
      return new b(paramView, paramk);
    case -4: 
      return new j(paramView, paramk);
    }
    return new c(paramView, paramk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.b.g
 * JD-Core Version:    0.7.0.1
 */