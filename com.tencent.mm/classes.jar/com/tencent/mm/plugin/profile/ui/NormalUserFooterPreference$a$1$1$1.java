package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.ad;

final class NormalUserFooterPreference$a$1$1$1
  implements DialogInterface.OnClickListener
{
  NormalUserFooterPreference$a$1$1$1(NormalUserFooterPreference.a.1.1 param1, CheckBox paramCheckBox) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(23672);
    NormalUserFooterPreference.a.b(this.pCh.pCg.pCf);
    if (NormalUserFooterPreference.a(this.pCh.pCg.pCf.pCe).getSource() == 18)
    {
      NormalUserFooterPreference.a(this.pCh.pCg.pCf.pCe, 9);
      if (this.pxK.isChecked()) {
        NormalUserFooterPreference.a.c(this.pCh.pCg.pCf);
      }
    }
    AppMethodBeat.o(23672);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.1.1.1
 * JD-Core Version:    0.7.0.1
 */