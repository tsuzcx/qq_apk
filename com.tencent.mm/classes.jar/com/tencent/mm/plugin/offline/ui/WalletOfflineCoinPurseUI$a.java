package com.tencent.mm.plugin.offline.ui;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.g;
import java.util.ArrayList;

final class WalletOfflineCoinPurseUI$a
  extends BaseAdapter
{
  ArrayList<String> hka = new ArrayList();
  ArrayList<Boolean> mNH = new ArrayList();
  
  public WalletOfflineCoinPurseUI$a(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI) {}
  
  public final int getCount()
  {
    return this.hka.size();
  }
  
  public final Object getItem(int paramInt)
  {
    return this.hka.get(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (CheckedTextView)View.inflate(this.mNj, a.g.wallet_list_dialog_item_singlechoice, null);
    paramView.setText((String)this.hka.get(paramInt));
    if (WalletOfflineCoinPurseUI.bqF() == paramInt) {
      paramView.setChecked(true);
    }
    while (isEnabled(paramInt))
    {
      paramView.setTextColor(this.mNj.getResources().getColor(a.c.normal_text_color));
      paramView.setEnabled(true);
      return paramView;
      paramView.setChecked(false);
    }
    paramView.setTextColor(this.mNj.getResources().getColor(a.c.hint_text_color));
    paramView.setEnabled(false);
    return paramView;
  }
  
  public final boolean isEnabled(int paramInt)
  {
    return ((Boolean)this.mNH.get(paramInt)).booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.a
 * JD-Core Version:    0.7.0.1
 */