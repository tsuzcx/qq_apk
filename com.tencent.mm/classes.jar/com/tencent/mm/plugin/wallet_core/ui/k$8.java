package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

public final class k$8
  implements View.OnClickListener
{
  public k$8(Dialog paramDialog) {}
  
  public final void onClick(View paramView)
  {
    if ((this.oof != null) && (this.oof.isShowing())) {
      this.oof.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.k.8
 * JD-Core Version:    0.7.0.1
 */