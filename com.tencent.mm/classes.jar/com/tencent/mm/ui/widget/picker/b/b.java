package com.tencent.mm.ui.widget.picker.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.c.a;
import com.tencent.mm.ui.widget.picker.d.g;
import com.tencent.mm.ui.widget.picker.h;
import java.util.Calendar;

public final class b
{
  public a Lax;
  
  public b(Context paramContext, g paramg)
  {
    AppMethodBeat.i(192783);
    this.Lax = new a(2);
    this.Lax.context = paramContext;
    this.Lax.Lcj = paramg;
    AppMethodBeat.o(192783);
  }
  
  public final b b(Calendar paramCalendar)
  {
    this.Lax.iLq = paramCalendar;
    return this;
  }
  
  public final b b(Calendar paramCalendar1, Calendar paramCalendar2)
  {
    this.Lax.iLr = paramCalendar1;
    this.Lax.iLs = paramCalendar2;
    return this;
  }
  
  public final b c(boolean[] paramArrayOfBoolean)
  {
    this.Lax.iLp = paramArrayOfBoolean;
    return this;
  }
  
  public final void c(h paramh)
  {
    AppMethodBeat.i(192784);
    paramh.a(this.Lax);
    AppMethodBeat.o(192784);
  }
  
  public final b fMY()
  {
    this.Lax.iLn = false;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.b.b
 * JD-Core Version:    0.7.0.1
 */