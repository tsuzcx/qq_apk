package com.tencent.mm.wallet_core.ui.formview;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.picker.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class b$1
  implements View.OnClickListener
{
  int AZb = -1;
  int year = -1;
  
  b$1(MMActivity paramMMActivity, WalletFormView paramWalletFormView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(49402);
    this.lHl.hideVKB();
    if ((this.lHl instanceof WalletBaseUI)) {
      ((WalletBaseUI)this.lHl).hideTenpayKB();
    }
    paramView = new a(this.lHl);
    paramView.am(true, false);
    paramView.AIQ = new b.1.1(this, paramView);
    if ((this.year >= b.access$000()) && (this.AZb >= b.access$100())) {
      paramView.aA(this.year, this.AZb + 1, 1);
    }
    paramView.show();
    AppMethodBeat.o(49402);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.b.1
 * JD-Core Version:    0.7.0.1
 */