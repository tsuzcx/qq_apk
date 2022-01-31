package com.tencent.mm.plugin.profile.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.pluginsdk.ui.f;

final class BizInfoHeaderPreference$1
  implements View.OnClickListener
{
  BizInfoHeaderPreference$1(BizInfoHeaderPreference paramBizInfoHeaderPreference) {}
  
  public final void onClick(View paramView)
  {
    paramView = BizInfoHeaderPreference.a(this.mVz).field_username;
    new f(BizInfoHeaderPreference.b(this.mVz), paramView, BizInfoHeaderPreference.c(this.mVz)).cmi();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.BizInfoHeaderPreference.1
 * JD-Core Version:    0.7.0.1
 */