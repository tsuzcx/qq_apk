package com.tencent.mm.plugin.multitalk.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.ui.a;
import com.tencent.mm.plugin.voip.ui.e;
import com.tencent.mm.sdk.platformtools.ah;

final class f$14$1
  implements a
{
  f$14$1(f.14 param14) {}
  
  public final void a(Intent paramIntent, e parame)
  {
    AppMethodBeat.i(53953);
    if (!this.oTS.oTN.bSC())
    {
      parame.aeI(ah.getContext().getString(2131301716));
      AppMethodBeat.o(53953);
      return;
    }
    int i = this.oTS.oTN.oTv;
    parame.aeI(String.format("%02d:%02d", new Object[] { Integer.valueOf(i / 60), Integer.valueOf(i % 60) }));
    AppMethodBeat.o(53953);
  }
  
  public final boolean bIS()
  {
    AppMethodBeat.i(53952);
    if ((this.oTS.oTN.bTh()) || (this.oTS.oTN.bSC()))
    {
      AppMethodBeat.o(53952);
      return true;
    }
    AppMethodBeat.o(53952);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.f.14.1
 * JD-Core Version:    0.7.0.1
 */