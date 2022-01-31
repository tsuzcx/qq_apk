package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.mm.R.l;
import com.tencent.mm.h.c.ao;
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
    switch (paramMenuItem.getItemId())
    {
    default: 
      return;
    case 1: 
      this.mYL.mYE.KW(NormalUserFooterPreference.a(this.mYL.mYE.mYC).field_username);
      return;
    case 8: 
      NormalUserFooterPreference.a.a(this.mYL.mYE);
      return;
    }
    paramMenuItem = this.mYL.mYE.mYC.mContext;
    Context localContext = this.mYL.mYE.mYC.mContext;
    if (ad.aaU(NormalUserFooterPreference.a(this.mYL.mYE.mYC).field_username)) {}
    for (paramInt = R.l.contact_info_movein_blacklist_confirm_for_openim;; paramInt = R.l.contact_info_movein_blacklist_confirm)
    {
      h.a(paramMenuItem, localContext.getString(paramInt), this.mYL.mYE.mYC.mContext.getString(R.l.contact_info_movein_blacklist), new NormalUserFooterPreference.a.11.1.1(this), null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.11.1
 * JD-Core Version:    0.7.0.1
 */