package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.ArrayList;
import java.util.List;

public final class WalletForgotPwdUI$a
  extends BaseAdapter
{
  private Context context;
  List<Bankcard> items = new ArrayList();
  
  public WalletForgotPwdUI$a(WalletForgotPwdUI paramWalletForgotPwdUI, Context paramContext)
  {
    this.context = paramContext;
  }
  
  private Bankcard AH(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= this.items.size() - 1)) {
      return (Bankcard)this.items.get(paramInt);
    }
    return null;
  }
  
  public final int getCount()
  {
    return this.items.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {}
    for (paramView = (WalletFormView)View.inflate(this.context, a.g.wallet_bank_clickable_item, null);; paramView = (WalletFormView)paramView)
    {
      Bankcard localBankcard = AH(paramInt);
      if (localBankcard != null)
      {
        String str = localBankcard.field_desc;
        paramViewGroup = str;
        if (localBankcard.field_bankcardState == 1) {
          paramViewGroup = str + this.context.getString(a.i.wallet_forget_pwd_expired_suffix);
        }
        paramView.setText(paramViewGroup);
      }
      paramView.setOnClickListener(new WalletForgotPwdUI.a.1(this, localBankcard));
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdUI.a
 * JD-Core Version:    0.7.0.1
 */