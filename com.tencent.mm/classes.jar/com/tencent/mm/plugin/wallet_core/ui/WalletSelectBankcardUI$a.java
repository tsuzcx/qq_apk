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
    AppMethodBeat.i(71224);
    if (WalletSelectBankcardUI.a(this.Aqy))
    {
      if (WalletSelectBankcardUI.b(this.Aqy) == null)
      {
        AppMethodBeat.o(71224);
        return 1;
      }
      i = WalletSelectBankcardUI.b(this.Aqy).size();
      AppMethodBeat.o(71224);
      return i + 1;
    }
    if (WalletSelectBankcardUI.b(this.Aqy) == null)
    {
      AppMethodBeat.o(71224);
      return 0;
    }
    int i = WalletSelectBankcardUI.b(this.Aqy).size();
    AppMethodBeat.o(71224);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(71225);
    if ((WalletSelectBankcardUI.b(this.Aqy) == null) || (WalletSelectBankcardUI.b(this.Aqy).size() <= paramInt))
    {
      AppMethodBeat.o(71225);
      return null;
    }
    Object localObject = WalletSelectBankcardUI.b(this.Aqy).get(paramInt);
    AppMethodBeat.o(71225);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(71226);
    Bankcard localBankcard = (Bankcard)getItem(paramInt);
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.Aqy).inflate(2131496026, paramViewGroup, false);
      paramView = new a();
      paramView.AqB = ((TextView)localView.findViewById(2131297154));
      localView.setTag(paramView);
      paramViewGroup = paramView;
      if (localBankcard == null) {
        break label105;
      }
      paramViewGroup.AqB.setText(localBankcard.field_desc);
    }
    for (;;)
    {
      AppMethodBeat.o(71226);
      return localView;
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
      break;
      label105:
      paramViewGroup.AqB.setText(2131765849);
    }
  }
  
  final class a
  {
    TextView AqB;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletSelectBankcardUI.a
 * JD-Core Version:    0.7.0.1
 */