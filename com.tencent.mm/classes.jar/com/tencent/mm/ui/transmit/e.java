package com.tencent.mm.ui.transmit;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.p;

public final class e
{
  e.a AAY;
  Context context;
  Runnable hGy;
  boolean iNk;
  boolean iNl;
  boolean iNm;
  int iNn;
  String text;
  p tipDialog;
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(35281);
    this.hGy = new e.1(this);
    this.context = paramContext;
    AppMethodBeat.o(35281);
  }
  
  public final void aMj()
  {
    AppMethodBeat.i(35282);
    if (this.AAY != null) {
      this.AAY.B(this.iNm, this.text);
    }
    AppMethodBeat.o(35282);
  }
  
  public final boolean lw()
  {
    return this.iNk & this.iNl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.e
 * JD-Core Version:    0.7.0.1
 */