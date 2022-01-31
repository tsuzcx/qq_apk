package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.model.v;
import java.util.List;

final class WalletCardImportUI$9
  extends BaseAdapter
{
  WalletCardImportUI$9(WalletCardImportUI paramWalletCardImportUI) {}
  
  private Integer IE(int paramInt)
  {
    AppMethodBeat.i(47275);
    Integer localInteger = (Integer)WalletCardImportUI.c(this.uph).cTw().get(paramInt);
    AppMethodBeat.o(47275);
    return localInteger;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(47274);
    if (WalletCardImportUI.c(this.uph).cTw() != null)
    {
      int i = WalletCardImportUI.c(this.uph).cTw().size();
      AppMethodBeat.o(47274);
      return i;
    }
    AppMethodBeat.o(47274);
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(47276);
    paramView = (CheckedTextView)View.inflate(this.uph, 2130971195, null);
    paramView.setText(t.cTV().ab(this.uph, IE(paramInt).intValue()));
    if (WalletCardImportUI.f(this.uph) == IE(paramInt).intValue()) {
      paramView.setChecked(true);
    }
    for (;;)
    {
      paramView.setBackgroundResource(2130838445);
      AppMethodBeat.o(47276);
      return paramView;
      paramView.setChecked(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI.9
 * JD-Core Version:    0.7.0.1
 */