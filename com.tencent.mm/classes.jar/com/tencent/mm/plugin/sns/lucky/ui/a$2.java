package com.tencent.mm.plugin.sns.lucky.ui;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class a$2
  implements View.OnClickListener
{
  a$2(Dialog paramDialog, View paramView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(35901);
    ab.i("MicroMsg.SnsLuckyCommentAlertUI", "showTipsDialog onClick");
    if ((this.rcw != null) && (this.rcw.isShowing())) {
      this.rcw.dismiss();
    }
    paramView = this.rcx;
    if (paramView != null) {
      paramView.performClick();
    }
    AppMethodBeat.o(35901);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.ui.a.2
 * JD-Core Version:    0.7.0.1
 */