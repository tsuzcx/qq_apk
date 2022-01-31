package com.tencent.mm.plugin.wallet_core.id_verify;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import java.util.List;

final class WalletRealNameVerifyUI$6
  implements View.OnClickListener
{
  WalletRealNameVerifyUI$6(WalletRealNameVerifyUI paramWalletRealNameVerifyUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(46626);
    paramView = new LinkedList();
    LinkedList localLinkedList = new LinkedList();
    paramView.add(this.udf.getString(2131304897));
    localLinkedList.add(Integer.valueOf(0));
    if ((WalletRealNameVerifyUI.e(this.udf) != null) && (WalletRealNameVerifyUI.e(this.udf).uhP))
    {
      paramView.add(this.udf.getString(2131304895));
      localLinkedList.add(Integer.valueOf(1));
    }
    h.a(this.udf, "", paramView, localLinkedList, "", new WalletRealNameVerifyUI.6.1(this));
    AppMethodBeat.o(46626);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WalletRealNameVerifyUI.6
 * JD-Core Version:    0.7.0.1
 */