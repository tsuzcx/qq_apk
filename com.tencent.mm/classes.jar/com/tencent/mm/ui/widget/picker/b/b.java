package com.tencent.mm.ui.widget.picker.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.c.a;
import com.tencent.mm.ui.widget.picker.d.g;
import com.tencent.mm.ui.widget.picker.h;
import java.util.Calendar;

public final class b
{
  public a QSH;
  
  public b(Context paramContext, g paramg)
  {
    AppMethodBeat.i(198514);
    this.QSH = new a(2);
    this.QSH.context = paramContext;
    this.QSH.QUA = paramg;
    AppMethodBeat.o(198514);
  }
  
  public final b b(Calendar paramCalendar)
  {
    this.QSH.jKY = paramCalendar;
    return this;
  }
  
  public final b b(Calendar paramCalendar1, Calendar paramCalendar2)
  {
    this.QSH.jKZ = paramCalendar1;
    this.QSH.jLa = paramCalendar2;
    return this;
  }
  
  public final b c(boolean[] paramArrayOfBoolean)
  {
    this.QSH.jKX = paramArrayOfBoolean;
    return this;
  }
  
  public final void c(h paramh)
  {
    AppMethodBeat.i(198515);
    paramh.a(this.QSH);
    AppMethodBeat.o(198515);
  }
  
  public final b hcv()
  {
    this.QSH.jKV = false;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.b.b
 * JD-Core Version:    0.7.0.1
 */