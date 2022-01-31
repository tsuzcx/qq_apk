package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.e.a;

final class NormalUserFooterPreference$b$2
  implements View.OnClickListener
{
  NormalUserFooterPreference$b$2(NormalUserFooterPreference.b paramb) {}
  
  public final void onClick(View paramView)
  {
    if ((NormalUserFooterPreference.c(this.mYN.mYC)) && (com.tencent.mm.bp.a.cki()))
    {
      paramView = new Intent();
      paramView.putExtra("Chat_User", NormalUserFooterPreference.a(this.mYN.mYC).field_encryptUsername);
      paramView.putExtra("lbs_mode", true);
      paramView.putExtra("lbs_ticket", NormalUserFooterPreference.C(this.mYN.mYC));
      paramView.putExtra("add_scene", NormalUserFooterPreference.l(this.mYN.mYC));
      com.tencent.mm.plugin.profile.a.eUR.e(paramView, NormalUserFooterPreference.b(this.mYN.mYC));
      return;
    }
    paramView = new Intent();
    paramView.putExtra("Contact_User", NormalUserFooterPreference.a(this.mYN.mYC).field_username);
    paramView.putExtra("Contact_Scene", NormalUserFooterPreference.l(this.mYN.mYC));
    paramView.putExtra(e.a.uHO, NormalUserFooterPreference.a(this.mYN.mYC).cCQ);
    com.tencent.mm.plugin.profile.a.eUR.a(paramView, this.mYN.mYC.mContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.b.2
 * JD-Core Version:    0.7.0.1
 */