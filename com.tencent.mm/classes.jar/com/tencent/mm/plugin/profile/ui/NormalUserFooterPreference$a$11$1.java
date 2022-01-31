package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.preference.Preference;

final class NormalUserFooterPreference$a$11$1
  implements n.d
{
  NormalUserFooterPreference$a$11$1(NormalUserFooterPreference.a.11 param11) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(23686);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(23686);
      return;
    case 1: 
      this.pCk.pCf.Xg(NormalUserFooterPreference.a(this.pCk.pCf.pCe).field_username);
      AppMethodBeat.o(23686);
      return;
    case 8: 
      NormalUserFooterPreference.a.a(this.pCk.pCf);
      AppMethodBeat.o(23686);
      return;
    }
    paramMenuItem = this.pCk.pCf.pCe.mContext;
    Context localContext = this.pCk.pCf.pCe.mContext;
    if (ad.arf(NormalUserFooterPreference.a(this.pCk.pCf.pCe).field_username)) {}
    for (paramInt = 2131298677;; paramInt = 2131298676)
    {
      h.a(paramMenuItem, localContext.getString(paramInt), this.pCk.pCf.pCe.mContext.getString(2131298675), new NormalUserFooterPreference.a.11.1.1(this), null);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.11.1
 * JD-Core Version:    0.7.0.1
 */