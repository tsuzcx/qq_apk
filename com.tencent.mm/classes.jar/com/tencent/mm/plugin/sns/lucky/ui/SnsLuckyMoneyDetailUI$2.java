package com.tencent.mm.plugin.sns.lucky.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsLuckyMoneyDetailUI$2
  implements MenuItem.OnMenuItemClickListener
{
  SnsLuckyMoneyDetailUI$2(SnsLuckyMoneyDetailUI paramSnsLuckyMoneyDetailUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(45184);
    this.rcz.finish();
    AppMethodBeat.o(45184);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.ui.SnsLuckyMoneyDetailUI.2
 * JD-Core Version:    0.7.0.1
 */