package com.tencent.mm.wallet_core.ui.formview;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.picker.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class b$1
  implements View.OnClickListener
{
  int wCQ = -1;
  int year = -1;
  
  b$1(MMActivity paramMMActivity, WalletFormView paramWalletFormView) {}
  
  public final void onClick(View paramView)
  {
    this.jxM.XM();
    if ((this.jxM instanceof WalletBaseUI)) {
      ((WalletBaseUI)this.jxM).VH();
    }
    paramView = new a(this.jxM);
    paramView.Z(true, false);
    paramView.woo = new b.1.1(this, paramView);
    if ((this.year >= b.access$000()) && (this.wCQ >= b.access$100())) {
      paramView.ao(this.year, this.wCQ + 1, 1);
    }
    paramView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.b.1
 * JD-Core Version:    0.7.0.1
 */