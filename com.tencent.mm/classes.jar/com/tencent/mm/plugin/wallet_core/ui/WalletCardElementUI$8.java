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

final class WalletCardElementUI$8
  extends BaseAdapter
{
  WalletCardElementUI$8(WalletCardElementUI paramWalletCardElementUI) {}
  
  private Integer IE(int paramInt)
  {
    AppMethodBeat.i(47219);
    Integer localInteger = (Integer)WalletCardElementUI.o(this.uoW).cTw().get(paramInt);
    AppMethodBeat.o(47219);
    return localInteger;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(47218);
    if (WalletCardElementUI.o(this.uoW).cTw() != null)
    {
      int i = WalletCardElementUI.o(this.uoW).cTw().size();
      AppMethodBeat.o(47218);
      return i;
    }
    AppMethodBeat.o(47218);
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(47220);
    paramView = (CheckedTextView)View.inflate(this.uoW, 2130971195, null);
    paramView.setText(t.cTV().ab(this.uoW, IE(paramInt).intValue()));
    if (WalletCardElementUI.w(this.uoW) == IE(paramInt).intValue()) {
      paramView.setChecked(true);
    }
    for (;;)
    {
      AppMethodBeat.o(47220);
      return paramView;
      paramView.setChecked(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.8
 * JD-Core Version:    0.7.0.1
 */