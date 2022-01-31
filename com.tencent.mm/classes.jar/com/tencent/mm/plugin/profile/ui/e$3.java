package com.tencent.mm.plugin.profile.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bf.a;
import com.tencent.mm.ui.base.p;

final class e$3
  implements bf.a
{
  e$3(e parame) {}
  
  public final boolean JS()
  {
    return this.pAa.isDeleteCancel;
  }
  
  public final void JT()
  {
    AppMethodBeat.i(23503);
    if (this.pAa.tipDialog != null)
    {
      this.pAa.tipDialog.dismiss();
      this.pAa.tipDialog = null;
    }
    AppMethodBeat.o(23503);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.e.3
 * JD-Core Version:    0.7.0.1
 */