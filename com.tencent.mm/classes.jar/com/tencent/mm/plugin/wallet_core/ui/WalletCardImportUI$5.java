package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import java.util.List;

final class WalletCardImportUI$5
  implements View.OnClickListener
{
  WalletCardImportUI$5(WalletCardImportUI paramWalletCardImportUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47270);
    paramView = new LinkedList();
    LinkedList localLinkedList = new LinkedList();
    paramView.add(this.uph.getString(2131304897));
    localLinkedList.add(Integer.valueOf(0));
    if ((WalletCardImportUI.c(this.uph) != null) && (WalletCardImportUI.c(this.uph).uhP))
    {
      paramView.add(this.uph.getString(2131304895));
      localLinkedList.add(Integer.valueOf(1));
    }
    h.a(this.uph, "", paramView, localLinkedList, "", new WalletCardImportUI.5.1(this));
    AppMethodBeat.o(47270);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI.5
 * JD-Core Version:    0.7.0.1
 */