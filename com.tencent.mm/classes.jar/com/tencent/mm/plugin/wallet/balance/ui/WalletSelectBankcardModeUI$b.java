package com.tencent.mm.plugin.wallet.balance.ui;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import java.util.ArrayList;

@SuppressLint({"ViewHolder"})
final class WalletSelectBankcardModeUI$b
  extends BaseAdapter
{
  WalletSelectBankcardModeUI$b(WalletSelectBankcardModeUI paramWalletSelectBankcardModeUI) {}
  
  public final int getCount()
  {
    return WalletSelectBankcardModeUI.b(this.qhE).size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = View.inflate(this.qhE, a.g.wallet_select_bankcard_item, null);
    paramViewGroup = (WalletSelectBankcardModeUI.a)WalletSelectBankcardModeUI.b(this.qhE).get(paramInt);
    TextView localTextView1 = (TextView)paramView.findViewById(a.f.bankcard_title);
    TextView localTextView2 = (TextView)paramView.findViewById(a.f.bankcard_tips);
    ImageView localImageView = (ImageView)paramView.findViewById(a.f.selected_icon);
    localTextView1.setText(paramViewGroup.title);
    if (!TextUtils.isEmpty(paramViewGroup.ioU))
    {
      localTextView2.setVisibility(0);
      localTextView2.setText(paramViewGroup.ioU);
    }
    while (WalletSelectBankcardModeUI.c(this.qhE) == paramInt)
    {
      localImageView.setImageResource(a.h.radio_on);
      return paramView;
      localTextView2.setVisibility(8);
    }
    localImageView.setImageResource(a.h.radio_off);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletSelectBankcardModeUI.b
 * JD-Core Version:    0.7.0.1
 */