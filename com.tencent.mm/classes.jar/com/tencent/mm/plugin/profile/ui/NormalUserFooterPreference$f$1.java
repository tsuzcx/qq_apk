package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.plugin.normsg.a.b;
import com.tencent.mm.plugin.profile.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.e.a;

final class NormalUserFooterPreference$f$1
  implements View.OnClickListener
{
  NormalUserFooterPreference$f$1(NormalUserFooterPreference.f paramf) {}
  
  public final void onClick(View paramView)
  {
    b.mGK.S(1, 1, 5);
    paramView = new Intent();
    paramView.putExtra("Contact_User", NormalUserFooterPreference.a(this.mYU.mYC).field_username);
    paramView.putExtra("Contact_Scene", NormalUserFooterPreference.l(this.mYU.mYC));
    paramView.putExtra(e.a.uHO, NormalUserFooterPreference.a(this.mYU.mYC).cCQ);
    a.eUR.a(paramView, this.mYU.mYC.mContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.f.1
 * JD-Core Version:    0.7.0.1
 */