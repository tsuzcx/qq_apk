package com.tencent.mm.ui.conversation;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.mm.h.c.as;
import com.tencent.mm.ui.widget.b.a;

final class SettingCheckUnProcessWalletConvUI$4
  implements AdapterView.OnItemLongClickListener
{
  SettingCheckUnProcessWalletConvUI$4(SettingCheckUnProcessWalletConvUI paramSettingCheckUnProcessWalletConvUI) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = SettingCheckUnProcessWalletConvUI.b(this.vUd).HS(paramInt - SettingCheckUnProcessWalletConvUI.c(this.vUd).getHeaderViewsCount());
    if (paramAdapterView == null) {
      return true;
    }
    String str = paramAdapterView.field_username;
    a locala = new a(this.vUd);
    locala.wog = new SettingCheckUnProcessWalletConvUI.4.1(this);
    locala.a(paramView, paramInt, paramLong, this.vUd, new SettingCheckUnProcessWalletConvUI.4.2(this, str, paramAdapterView), SettingCheckUnProcessWalletConvUI.a(this.vUd)[0], SettingCheckUnProcessWalletConvUI.a(this.vUd)[1]);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.SettingCheckUnProcessWalletConvUI.4
 * JD-Core Version:    0.7.0.1
 */