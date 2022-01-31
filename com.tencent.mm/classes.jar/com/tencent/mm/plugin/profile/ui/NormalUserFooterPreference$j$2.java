package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.s;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;

final class NormalUserFooterPreference$j$2
  implements View.OnClickListener
{
  NormalUserFooterPreference$j$2(NormalUserFooterPreference.j paramj) {}
  
  public final void onClick(View paramView)
  {
    if (NormalUserFooterPreference.a(this.mYW.mYC).Bg())
    {
      s.j(NormalUserFooterPreference.a(this.mYW.mYC));
      NormalUserFooterPreference.a(this.mYW.mYC).AK();
      this.mYW.bsI();
      return;
    }
    paramView = this.mYW.mYC.mContext;
    Context localContext = this.mYW.mYC.mContext;
    if (ad.aaU(NormalUserFooterPreference.a(this.mYW.mYC).field_username)) {}
    for (int i = R.l.contact_info_movein_blacklist_confirm_for_openim;; i = R.l.contact_info_movein_blacklist_confirm)
    {
      h.a(paramView, localContext.getString(i), this.mYW.mYC.mContext.getString(R.l.contact_info_movein_blacklist), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          s.i(NormalUserFooterPreference.a(NormalUserFooterPreference.j.2.this.mYW.mYC));
          NormalUserFooterPreference.a(NormalUserFooterPreference.j.2.this.mYW.mYC).AJ();
          NormalUserFooterPreference.j.2.this.mYW.bsI();
        }
      }, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.j.2
 * JD-Core Version:    0.7.0.1
 */