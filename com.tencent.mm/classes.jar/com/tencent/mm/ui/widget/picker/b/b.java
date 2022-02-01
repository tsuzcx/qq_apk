package com.tencent.mm.ui.widget.picker.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.c.a;
import com.tencent.mm.ui.widget.picker.d.g;
import com.tencent.mm.ui.widget.picker.h;
import java.util.Calendar;

public final class b
{
  public a HID;
  
  public b(Context paramContext, g paramg)
  {
    AppMethodBeat.i(195366);
    this.HID = new a(2);
    this.HID.context = paramContext;
    this.HID.HKp = paramg;
    AppMethodBeat.o(195366);
  }
  
  public final b b(Calendar paramCalendar)
  {
    this.HID.hSi = paramCalendar;
    return this;
  }
  
  public final b b(Calendar paramCalendar1, Calendar paramCalendar2)
  {
    this.HID.hSj = paramCalendar1;
    this.HID.hSk = paramCalendar2;
    return this;
  }
  
  public final b c(boolean[] paramArrayOfBoolean)
  {
    this.HID.hSh = paramArrayOfBoolean;
    return this;
  }
  
  public final void c(h paramh)
  {
    AppMethodBeat.i(195367);
    paramh.a(this.HID);
    AppMethodBeat.o(195367);
  }
  
  public final b fgk()
  {
    this.HID.hSf = false;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.b.b
 * JD-Core Version:    0.7.0.1
 */