package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckedTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.List;

final class WalletCardElementUI$7
  implements AdapterView.OnItemClickListener
{
  WalletCardElementUI$7(WalletCardElementUI paramWalletCardElementUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(47217);
    this.uoW.dismissDialog(1);
    paramInt = ((Integer)WalletCardElementUI.o(this.uoW).cTw().get(paramInt)).intValue();
    if (WalletCardElementUI.w(this.uoW) != paramInt)
    {
      WalletCardElementUI.i(this.uoW, paramInt);
      WalletCardElementUI.a(this.uoW, WalletCardElementUI.x(this.uoW).getText());
      WalletCardElementUI.x(this.uoW).setText(((CheckedTextView)paramView).getText().toString());
      WalletCardElementUI.b(WalletCardElementUI.y(this.uoW), WalletCardElementUI.w(this.uoW));
      WalletCardElementUI.y(this.uoW).cfK();
      WalletCardElementUI.g(this.uoW);
      WalletCardElementUI.j(this.uoW, WalletCardElementUI.w(this.uoW));
    }
    AppMethodBeat.o(47217);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.7
 * JD-Core Version:    0.7.0.1
 */