package com.tencent.mm.plugin.wallet.balance.ui;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

@SuppressLint({"ViewHolder"})
final class WalletSelectBankcardModeUI$b
  extends BaseAdapter
{
  WalletSelectBankcardModeUI$b(WalletSelectBankcardModeUI paramWalletSelectBankcardModeUI) {}
  
  public final int getCount()
  {
    AppMethodBeat.i(45491);
    int i = WalletSelectBankcardModeUI.b(this.tOZ).size();
    AppMethodBeat.o(45491);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(45492);
    paramView = View.inflate(this.tOZ, 2130971248, null);
    paramViewGroup = (WalletSelectBankcardModeUI.a)WalletSelectBankcardModeUI.b(this.tOZ).get(paramInt);
    TextView localTextView1 = (TextView)paramView.findViewById(2131829391);
    TextView localTextView2 = (TextView)paramView.findViewById(2131829392);
    ImageView localImageView = (ImageView)paramView.findViewById(2131829393);
    localTextView1.setText(paramViewGroup.title);
    if (!TextUtils.isEmpty(paramViewGroup.kqb))
    {
      localTextView2.setVisibility(0);
      localTextView2.setText(paramViewGroup.kqb);
      if (WalletSelectBankcardModeUI.c(this.tOZ) != paramInt) {
        break label133;
      }
      localImageView.setImageResource(2131231906);
    }
    for (;;)
    {
      AppMethodBeat.o(45492);
      return paramView;
      localTextView2.setVisibility(8);
      break;
      label133:
      localImageView.setImageResource(2131231905);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletSelectBankcardModeUI.b
 * JD-Core Version:    0.7.0.1
 */