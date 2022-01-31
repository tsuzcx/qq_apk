package com.tencent.mm.plugin.profile.ui;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bf.a;

final class NormalUserFooterPreference$a$9
  implements bf.a
{
  NormalUserFooterPreference$a$9(NormalUserFooterPreference.a parama) {}
  
  public final boolean JS()
  {
    return this.pCf.isDeleteCancel;
  }
  
  public final void JT()
  {
    AppMethodBeat.i(23683);
    if (this.pCf.pCe.eeN != null) {
      this.pCf.pCe.eeN.dismiss();
    }
    AppMethodBeat.o(23683);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.9
 * JD-Core Version:    0.7.0.1
 */