package com.tencent.mm.ui.widget.textview;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a$a
{
  public int QPi = 2131101045;
  public int QPj = 2131100228;
  View QXP;
  a.f QXQ;
  View.OnTouchListener QXR;
  com.tencent.mm.ui.widget.b.a QYf;
  public int QYg = 0;
  public int QYh = 0;
  View.OnClickListener hEZ;
  
  private a$a(View paramView, com.tencent.mm.ui.widget.b.a parama)
  {
    this.QXP = paramView;
    this.QYf = parama;
  }
  
  public a$a(View paramView, com.tencent.mm.ui.widget.b.a parama, a.f paramf, View.OnClickListener paramOnClickListener, View.OnTouchListener paramOnTouchListener)
  {
    this(paramView, parama);
    this.QXQ = paramf;
    this.hEZ = paramOnClickListener;
    this.QXR = paramOnTouchListener;
  }
  
  public final a hcW()
  {
    AppMethodBeat.i(159863);
    a locala = new a(this);
    AppMethodBeat.o(159863);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.a.a
 * JD-Core Version:    0.7.0.1
 */