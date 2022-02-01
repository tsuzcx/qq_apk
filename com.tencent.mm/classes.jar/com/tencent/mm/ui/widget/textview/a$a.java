package com.tencent.mm.ui.widget.textview;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a$a
{
  View LfA;
  a.f LfB;
  View.OnTouchListener LfC;
  public int LfH = 2131100846;
  public int LfI = 2131100195;
  com.tencent.mm.ui.widget.b.a Lga;
  public int Lgb = 0;
  public int Lgc = 0;
  View.OnClickListener gMe;
  
  public a$a(View paramView, com.tencent.mm.ui.widget.b.a parama)
  {
    this.LfA = paramView;
    this.Lga = parama;
  }
  
  public a$a(View paramView, com.tencent.mm.ui.widget.b.a parama, a.f paramf, View.OnClickListener paramOnClickListener, View.OnTouchListener paramOnTouchListener)
  {
    this(paramView, parama);
    this.LfB = paramf;
    this.gMe = paramOnClickListener;
    this.LfC = paramOnTouchListener;
  }
  
  public final a fNB()
  {
    AppMethodBeat.i(159863);
    a locala = new a(this);
    AppMethodBeat.o(159863);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.a.a
 * JD-Core Version:    0.7.0.1
 */