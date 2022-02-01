package com.tencent.mm.ui.widget.picker.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.c.a;
import com.tencent.mm.ui.widget.picker.d.g;
import com.tencent.mm.ui.widget.picker.h;
import java.util.Calendar;

public final class b
{
  public a Jja;
  
  public b(Context paramContext, g paramg)
  {
    AppMethodBeat.i(199837);
    this.Jja = new a(2);
    this.Jja.context = paramContext;
    this.Jja.JkM = paramg;
    AppMethodBeat.o(199837);
  }
  
  public final b b(Calendar paramCalendar)
  {
    this.Jja.isn = paramCalendar;
    return this;
  }
  
  public final b b(Calendar paramCalendar1, Calendar paramCalendar2)
  {
    this.Jja.iso = paramCalendar1;
    this.Jja.isp = paramCalendar2;
    return this;
  }
  
  public final b c(boolean[] paramArrayOfBoolean)
  {
    this.Jja.ism = paramArrayOfBoolean;
    return this;
  }
  
  public final void c(h paramh)
  {
    AppMethodBeat.i(199838);
    paramh.a(this.Jja);
    AppMethodBeat.o(199838);
  }
  
  public final b fwk()
  {
    this.Jja.isk = false;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.b.b
 * JD-Core Version:    0.7.0.1
 */