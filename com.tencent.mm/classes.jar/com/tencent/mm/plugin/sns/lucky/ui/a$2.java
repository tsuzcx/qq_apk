package com.tencent.mm.plugin.sns.lucky.ui;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

final class a$2
  implements View.OnClickListener
{
  a$2(Dialog paramDialog, View paramView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(95198);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/sns/lucky/ui/SnsLuckyCommentAlertUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    Log.i("MicroMsg.SnsLuckyCommentAlertUI", "showTipsDialog onClick");
    if ((this.Qqb != null) && (this.Qqb.isShowing())) {
      this.Qqb.dismiss();
    }
    paramView = this.Qqc;
    if (paramView != null) {
      paramView.performClick();
    }
    a.a(this, "com/tencent/mm/plugin/sns/lucky/ui/SnsLuckyCommentAlertUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(95198);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.ui.a.2
 * JD-Core Version:    0.7.0.1
 */