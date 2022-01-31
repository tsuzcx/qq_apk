package com.tencent.mm.plugin.radar.ui;

import a.b;
import a.d.a.a;
import a.d.b.g;
import a.e;
import a.f;
import a.o;
import android.app.Activity;
import android.view.View;

public final class i
{
  public static final <T extends View> b<T> N(View paramView, int paramInt)
  {
    g.k(paramView, "$receiver");
    return e((a)new i.b(paramView, paramInt));
  }
  
  static final <T> b<T> e(a<? extends T> parama)
  {
    e locale = e.xnZ;
    g.k(locale, "mode");
    g.k(parama, "initializer");
    switch (a.d.fHS[locale.ordinal()])
    {
    default: 
      throw new f();
    case 1: 
      return (b)new a.i(parama, (byte)0);
    case 2: 
      return (b)new a.h(parama);
    }
    return (b)new o(parama);
  }
  
  static final class a
    extends a.d.b.h
    implements a<T>
  {
    a(Activity paramActivity, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.i
 * JD-Core Version:    0.7.0.1
 */