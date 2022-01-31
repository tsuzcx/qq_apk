package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

final class k$4
  implements View.OnClickListener
{
  k$4(Dialog paramDialog) {}
  
  public final void onClick(View paramView)
  {
    if ((this.oof != null) && (this.oof.isShowing())) {
      this.oof.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.k.4
 * JD-Core Version:    0.7.0.1
 */