package com.tencent.mm.plugin.sns.lucky.ui;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

final class a$3
  implements View.OnClickListener
{
  a$3(Dialog paramDialog) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(95199);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/sns/lucky/ui/SnsLuckyCommentAlertUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    Log.i("MicroMsg.SnsLuckyCommentAlertUI", "showTipsDialog OnClick: close");
    if ((this.Qqb != null) && (this.Qqb.isShowing())) {
      this.Qqb.dismiss();
    }
    a.a(this, "com/tencent/mm/plugin/sns/lucky/ui/SnsLuckyCommentAlertUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(95199);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.ui.a.3
 * JD-Core Version:    0.7.0.1
 */