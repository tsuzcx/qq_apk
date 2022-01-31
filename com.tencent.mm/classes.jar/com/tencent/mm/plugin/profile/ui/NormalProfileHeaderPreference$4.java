package com.tencent.mm.plugin.profile.ui;

import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.ad;

final class NormalProfileHeaderPreference$4
  implements PopupWindow.OnDismissListener
{
  NormalProfileHeaderPreference$4(NormalProfileHeaderPreference paramNormalProfileHeaderPreference, TextView paramTextView, ad paramad) {}
  
  public final void onDismiss()
  {
    AppMethodBeat.i(156693);
    NormalProfileHeaderPreference.a(this.pBf, this.pBg, this.ejm);
    AppMethodBeat.o(156693);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalProfileHeaderPreference.4
 * JD-Core Version:    0.7.0.1
 */