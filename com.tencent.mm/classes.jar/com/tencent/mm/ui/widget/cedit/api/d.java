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
  protected WeakReference<c> YeD;
  
  private d(WeakReference<c> paramWeakReference)
  {
    super("");
    this.YeD = paramWeakReference;
  }
  
  public static d a(c paramc)
  {
    AppMethodBeat.i(210078);
    paramc = new d(new WeakReference(paramc));
    AppMethodBeat.o(210078);
    return paramc;
  }
  
  public final int bNF()
  {
    AppMethodBeat.i(210082);
    if (Util.isNullOrNil(this.mText))
    {
      if (this.YeD == null)
      {
        AppMethodBeat.o(210082);
        return 1;
      }
      this.mText = ((c)this.YeD.get()).getText().toString().trim();
    }
    int j = g.a(this.mText, this.rvC);
    if (j < 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w("MicroMsg.InputIEdtBoundaryCheck", "you are crazy =.=!that is 2 GB character!");
      AppMethodBeat.o(210082);
      return 2;
    }
    if (j < this.XVS)
    {
      AppMethodBeat.o(210082);
      return 1;
    }
    if (j > this.XVR)
    {
      AppMethodBeat.o(210082);
      return 2;
    }
    AppMethodBeat.o(210082);
    return 0;
  }
  
  public final void euX()
  {
    AppMethodBeat.i(210080);
    Object localObject;
    if (!this.XVP)
    {
      if (this.YeD == null)
      {
        Log.w("MicroMsg.InputIEdtBoundaryCheck", "edit text view is null");
        AppMethodBeat.o(210080);
        return;
      }
      if (Util.isNullOrNil(this.XVT))
      {
        localObject = a(this.XVR, this.rvC);
        ((c)this.YeD.get()).setFilters(new InputFilter[] { localObject });
      }
    }
    else if (this.XVU != null)
    {
      switch (bNF())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(210080);
      return;
      this.XVT.add(a(this.XVR, this.rvC));
      localObject = (InputFilter[])this.XVT.toArray(new InputFilter[this.XVT.size()]);
      ((c)this.YeD.get()).setFilters((InputFilter[])localObject);
      break;
      this.XVU.abc(this.mText);
      AppMethodBeat.o(210080);
      return;
      this.XVU.abd(this.mText);
      AppMethodBeat.o(210080);
      return;
      this.XVU.dN(this.mText);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.api.d
 * JD-Core Version:    0.7.0.1
 */