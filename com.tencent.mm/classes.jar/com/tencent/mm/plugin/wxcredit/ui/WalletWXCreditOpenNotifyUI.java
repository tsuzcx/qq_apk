package com.tencent.mm.plugin.wxcredit.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.z;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class WalletWXCreditOpenNotifyUI
  extends WalletBaseUI
{
  public int getLayoutId()
  {
    return 2130971272;
  }
  
  public void initView()
  {
    int i = 0;
    AppMethodBeat.i(48743);
    setMMTitle(2131305792);
    showHomeBtn(false);
    enableBackMenu(false);
    addTextOptionMenu(0, getString(2131296964), new WalletWXCreditOpenNotifyUI.1(this));
    ((TextView)findViewById(2131829418)).setText(com.tencent.mm.wallet_core.ui.e.F(getInput().getDouble("key_total_amount")));
    Button localButton = (Button)findViewById(2131822914);
    localButton.setOnClickListener(new WalletWXCreditOpenNotifyUI.2(this));
    if (getInput().getBoolean("key_can_upgrade_amount", true)) {}
    for (;;)
    {
      localButton.setVisibility(i);
      AppMethodBeat.o(48743);
      return;
      i = 8;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48742);
    super.onCreate(paramBundle);
    g.RM();
    g.RL().Ru().set(196658, Boolean.FALSE);
    initView();
    AppMethodBeat.o(48742);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenNotifyUI
 * JD-Core Version:    0.7.0.1
 */