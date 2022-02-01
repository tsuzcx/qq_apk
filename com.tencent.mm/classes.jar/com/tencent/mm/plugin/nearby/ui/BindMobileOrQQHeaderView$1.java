package com.tencent.mm.plugin.nearby.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
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
    AppMethodBeat.i(89797);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/nearby/ui/BindMobileOrQQHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    paramView = new Intent();
    paramView.setClass(this.GsN.getContext(), BindMContactIntroUI.class);
    paramView.putExtra("key_upload_scene", 7);
    MMWizardActivity.aH(this.GsN.getContext(), paramView);
    if (g.bga().Sk("3") != null)
    {
      g.bga().Sk("3").result = "1";
      f.Sp("3");
    }
    a.a(this, "com/tencent/mm/plugin/nearby/ui/BindMobileOrQQHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(89797);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.BindMobileOrQQHeaderView.1
 * JD-Core Version:    0.7.0.1
 */