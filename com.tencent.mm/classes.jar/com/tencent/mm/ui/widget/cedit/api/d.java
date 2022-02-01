package com.tencent.mm.ui.widget.cedit.api;

import android.text.InputFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.tools.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class d
  extends com.tencent.mm.ui.tools.b.c
{
  protected WeakReference<c> QFO;
  
  private d(WeakReference<c> paramWeakReference)
  {
    super("");
    this.QFO = paramWeakReference;
  }
  
  public static d a(c paramc)
  {
    AppMethodBeat.i(205446);
    paramc = new d(new WeakReference(paramc));
    AppMethodBeat.o(205446);
    return paramc;
  }
  
  public final int bCj()
  {
    AppMethodBeat.i(205448);
    if (Util.isNullOrNil(this.mText))
    {
      if (this.QFO == null)
      {
        AppMethodBeat.o(205448);
        return 1;
      }
      this.mText = ((c)this.QFO.get()).getText().toString().trim();
    }
    int j = f.a(this.mText, this.ots);
    if (j < 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w("MicroMsg.InputIEdtBoundaryCheck", "you are crazy =.=!that is 2 GB character!");
      AppMethodBeat.o(205448);
      return 2;
    }
    if (j < this.QxN)
    {
      AppMethodBeat.o(205448);
      return 1;
    }
    if (j > this.QxM)
    {
      AppMethodBeat.o(205448);
      return 2;
    }
    AppMethodBeat.o(205448);
    return 0;
  }
  
  public final void dSw()
  {
    AppMethodBeat.i(205447);
    Object localObject;
    if (!this.QxK)
    {
      if (this.QFO == null)
      {
        Log.w("MicroMsg.InputIEdtBoundaryCheck", "edit text view is null");
        AppMethodBeat.o(205447);
        return;
      }
      if (Util.isNullOrNil(this.QxO))
      {
        localObject = a(this.QxM, this.ots);
        ((c)this.QFO.get()).setFilters(new InputFilter[] { localObject });
      }
    }
    else if (this.QxP != null)
    {
      switch (bCj())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(205447);
      return;
      this.QxO.add(a(this.QxM, this.ots));
      localObject = (InputFilter[])this.QxO.toArray(new InputFilter[this.QxO.size()]);
      ((c)this.QFO.get()).setFilters((InputFilter[])localObject);
      break;
      this.QxP.Tw(this.mText);
      AppMethodBeat.o(205447);
      return;
      this.QxP.Tx(this.mText);
      AppMethodBeat.o(205447);
      return;
      this.QxP.dv(this.mText);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.api.d
 * JD-Core Version:    0.7.0.1
 */