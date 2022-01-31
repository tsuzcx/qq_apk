package com.tencent.mm.plugin.profile.ui;

import android.content.ClipboardManager;
import android.content.Context;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;

final class NormalProfileHeaderPreference$3
  implements n.d
{
  NormalProfileHeaderPreference$3(NormalProfileHeaderPreference paramNormalProfileHeaderPreference, ClipboardManager paramClipboardManager, String paramString) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(156692);
    if (paramInt == 0)
    {
      this.gMy.setText(this.efI);
      h.bN(NormalProfileHeaderPreference.c(this.pBf), NormalProfileHeaderPreference.c(this.pBf).getString(2131296896));
    }
    AppMethodBeat.o(156692);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalProfileHeaderPreference.3
 * JD-Core Version:    0.7.0.1
 */