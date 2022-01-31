package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.t;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;

final class NormalUserFooterPreference$j$2
  implements View.OnClickListener
{
  NormalUserFooterPreference$j$2(NormalUserFooterPreference.j paramj) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(23727);
    if (NormalUserFooterPreference.a(this.pCq.pCe).NW())
    {
      t.j(NormalUserFooterPreference.a(this.pCq.pCe));
      NormalUserFooterPreference.a(this.pCq.pCe).NA();
      this.pCq.ccx();
      AppMethodBeat.o(23727);
      return;
    }
    paramView = this.pCq.pCe.mContext;
    Context localContext = this.pCq.pCe.mContext;
    if (ad.arf(NormalUserFooterPreference.a(this.pCq.pCe).field_username)) {}
    for (int i = 2131298677;; i = 2131298676)
    {
      h.a(paramView, localContext.getString(i), this.pCq.pCe.mContext.getString(2131298675), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(23726);
          t.i(NormalUserFooterPreference.a(NormalUserFooterPreference.j.2.this.pCq.pCe));
          NormalUserFooterPreference.a(NormalUserFooterPreference.j.2.this.pCq.pCe).Nz();
          NormalUserFooterPreference.j.2.this.pCq.ccx();
          AppMethodBeat.o(23726);
        }
      }, null);
      AppMethodBeat.o(23727);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.j.2
 * JD-Core Version:    0.7.0.1
 */