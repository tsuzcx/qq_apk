package com.tencent.mm.ui.widget.picker.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.c.a;
import com.tencent.mm.ui.widget.picker.d.g;
import com.tencent.mm.ui.widget.picker.h;
import java.util.Calendar;

public final class b
{
  public a LwV;
  
  public b(Context paramContext, g paramg)
  {
    AppMethodBeat.i(200556);
    this.LwV = new a(2);
    this.LwV.context = paramContext;
    this.LwV.LyK = paramg;
    AppMethodBeat.o(200556);
  }
  
  public final b b(Calendar paramCalendar)
  {
    this.LwV.iOj = paramCalendar;
    return this;
  }
  
  public final b b(Calendar paramCalendar1, Calendar paramCalendar2)
  {
    this.LwV.iOk = paramCalendar1;
    this.LwV.iOl = paramCalendar2;
    return this;
  }
  
  public final b c(boolean[] paramArrayOfBoolean)
  {
    this.LwV.iOi = paramArrayOfBoolean;
    return this;
  }
  
  public final void c(h paramh)
  {
    AppMethodBeat.i(200557);
    paramh.a(this.LwV);
    AppMethodBeat.o(200557);
  }
  
  public final b fRt()
  {
    this.LwV.iOg = false;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.b.b
 * JD-Core Version:    0.7.0.1
 */