package com.tencent.mm.plugin.nearby.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.a.c;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.a.g;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.ui.MMWizardActivity;

final class BindMobileOrQQHeaderView$1
  implements View.OnClickListener
{
  BindMobileOrQQHeaderView$1(BindMobileOrQQHeaderView paramBindMobileOrQQHeaderView) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.setClass(this.mCK.getContext(), BindMContactIntroUI.class);
    paramView.putExtra("key_upload_scene", 7);
    MMWizardActivity.C(this.mCK.getContext(), paramView);
    if (g.Iy().iX("3") != null)
    {
      g.Iy().iX("3").result = "1";
      f.jc("3");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.BindMobileOrQQHeaderView.1
 * JD-Core Version:    0.7.0.1
 */