package com.tencent.mm.ui.widget.textview;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a$a
{
  View AMT;
  a.f AMU;
  View.OnTouchListener AMV;
  public int ANa = 2131690431;
  public int ANb = 2131689914;
  com.tencent.mm.ui.widget.c.a ANt;
  public int ANu = 0;
  View.OnClickListener lPx;
  
  public a$a(View paramView, com.tencent.mm.ui.widget.c.a parama)
  {
    this.AMT = paramView;
    this.ANt = parama;
  }
  
  public a$a(View paramView, com.tencent.mm.ui.widget.c.a parama, a.f paramf, View.OnClickListener paramOnClickListener, View.OnTouchListener paramOnTouchListener)
  {
    this(paramView, parama);
    this.AMU = paramf;
    this.lPx = paramOnClickListener;
    this.AMV = paramOnTouchListener;
  }
  
  public final a dPX()
  {
    AppMethodBeat.i(113130);
    a locala = new a(this);
    AppMethodBeat.o(113130);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.a.a
 * JD-Core Version:    0.7.0.1
 */