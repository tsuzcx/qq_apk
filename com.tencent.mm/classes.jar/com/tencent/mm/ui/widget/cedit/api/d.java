package com.tencent.mm.ui.widget.cedit.api;

import android.text.InputFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.tools.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class d
  extends com.tencent.mm.ui.tools.b.c
{
  protected WeakReference<c> afWy;
  
  private d(WeakReference<c> paramWeakReference)
  {
    super("");
    this.afWy = paramWeakReference;
  }
  
  public static d a(c paramc)
  {
    AppMethodBeat.i(252230);
    paramc = new d(new WeakReference(paramc));
    AppMethodBeat.o(252230);
    return paramc;
  }
  
  public final int cnU()
  {
    AppMethodBeat.i(252250);
    if (Util.isNullOrNil(this.mText))
    {
      if (this.afWy == null)
      {
        AppMethodBeat.o(252250);
        return 1;
      }
      this.mText = ((c)this.afWy.get()).getText().toString().trim();
    }
    int j = g.a(this.mText, this.uGI);
    if (j < 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w("MicroMsg.InputIEdtBoundaryCheck", "you are crazy =.=!that is 2 GB character!");
      AppMethodBeat.o(252250);
      return 2;
    }
    if (j < this.afMh)
    {
      AppMethodBeat.o(252250);
      return 1;
    }
    if (j > this.afMg)
    {
      AppMethodBeat.o(252250);
      return 2;
    }
    AppMethodBeat.o(252250);
    return 0;
  }
  
  public final void fBQ()
  {
    AppMethodBeat.i(252243);
    Object localObject;
    if (!this.afMe)
    {
      if (this.afWy == null)
      {
        Log.w("MicroMsg.InputIEdtBoundaryCheck", "edit text view is null");
        AppMethodBeat.o(252243);
        return;
      }
      if (Util.isNullOrNil(this.afMi))
      {
        localObject = a(this.afMg, this.uGI);
        ((c)this.afWy.get()).setFilters(new InputFilter[] { localObject });
      }
    }
    else if (this.afMj != null)
    {
      switch (cnU())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(252243);
      return;
      this.afMi.add(a(this.afMg, this.uGI));
      localObject = (InputFilter[])this.afMi.toArray(new InputFilter[this.afMi.size()]);
      ((c)this.afWy.get()).setFilters((InputFilter[])localObject);
      break;
      this.afMj.Tw(this.mText);
      AppMethodBeat.o(252243);
      return;
      this.afMj.Tx(this.mText);
      AppMethodBeat.o(252243);
      return;
      this.afMj.eY(this.mText);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.api.d
 * JD-Core Version:    0.7.0.1
 */