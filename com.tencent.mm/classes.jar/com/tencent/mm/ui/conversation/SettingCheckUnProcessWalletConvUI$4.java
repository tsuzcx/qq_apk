package com.tencent.mm.ui.conversation;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.ui.widget.c.a;

final class SettingCheckUnProcessWalletConvUI$4
  implements AdapterView.OnItemLongClickListener
{
  SettingCheckUnProcessWalletConvUI$4(SettingCheckUnProcessWalletConvUI paramSettingCheckUnProcessWalletConvUI) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(34616);
    paramAdapterView = SettingCheckUnProcessWalletConvUI.b(this.AlZ).QE(paramInt - SettingCheckUnProcessWalletConvUI.c(this.AlZ).getHeaderViewsCount());
    if (paramAdapterView == null)
    {
      AppMethodBeat.o(34616);
      return true;
    }
    String str = paramAdapterView.field_username;
    a locala = new a(this.AlZ);
    locala.AIG = new SettingCheckUnProcessWalletConvUI.4.1(this);
    locala.a(paramView, paramInt, paramLong, this.AlZ, new SettingCheckUnProcessWalletConvUI.4.2(this, str, paramAdapterView), SettingCheckUnProcessWalletConvUI.a(this.AlZ)[0], SettingCheckUnProcessWalletConvUI.a(this.AlZ)[1]);
    AppMethodBeat.o(34616);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.SettingCheckUnProcessWalletConvUI.4
 * JD-Core Version:    0.7.0.1
 */