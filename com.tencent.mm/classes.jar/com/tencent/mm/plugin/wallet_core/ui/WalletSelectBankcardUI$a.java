package com.tencent.mm.plugin.wallet_core.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import java.util.List;

final class WalletSelectBankcardUI$a
  extends BaseAdapter
{
  private WalletSelectBankcardUI$a(WalletSelectBankcardUI paramWalletSelectBankcardUI) {}
  
  public final int getCount()
  {
    AppMethodBeat.i(47656);
    if (WalletSelectBankcardUI.a(this.utE))
    {
      if (WalletSelectBankcardUI.b(this.utE) == null)
      {
        AppMethodBeat.o(47656);
        return 1;
      }
      i = WalletSelectBankcardUI.b(this.utE).size();
      AppMethodBeat.o(47656);
      return i + 1;
    }
    if (WalletSelectBankcardUI.b(this.utE) == null)
    {
      AppMethodBeat.o(47656);
      return 0;
    }
    int i = WalletSelectBankcardUI.b(this.utE).size();
    AppMethodBeat.o(47656);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(47657);
    if ((WalletSelectBankcardUI.b(this.utE) == null) || (WalletSelectBankcardUI.b(this.utE).size() <= paramInt))
    {
      AppMethodBeat.o(47657);
      return null;
    }
    Object localObject = WalletSelectBankcardUI.b(this.utE).get(paramInt);
    AppMethodBeat.o(47657);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(47658);
    Bankcard localBankcard = (Bankcard)getItem(paramInt);
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.utE).inflate(2130971249, paramViewGroup, false);
      paramView = new WalletSelectBankcardUI.a.a(this);
      paramView.utH = ((TextView)localView.findViewById(2131829394));
      localView.setTag(paramView);
      paramViewGroup = paramView;
      if (localBankcard == null) {
        break label105;
      }
      paramViewGroup.utH.setText(localBankcard.field_desc);
    }
    for (;;)
    {
      AppMethodBeat.o(47658);
      return localView;
      paramViewGroup = (WalletSelectBankcardUI.a.a)paramView.getTag();
      localView = paramView;
      break;
      label105:
      paramViewGroup.utH.setText(2131305633);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletSelectBankcardUI.a
 * JD-Core Version:    0.7.0.1
 */