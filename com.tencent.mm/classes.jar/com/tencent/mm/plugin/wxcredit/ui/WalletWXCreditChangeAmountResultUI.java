package com.tencent.mm.plugin.wxcredit.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

public class WalletWXCreditChangeAmountResultUI
  extends WalletBaseUI
{
  public int getLayoutId()
  {
    return 2130971266;
  }
  
  public void initView()
  {
    AppMethodBeat.i(48687);
    ((TextView)findViewById(2131829418)).setText(e.F(getInput().getDouble("key_credit_amount")));
    showHomeBtn(false);
    enableBackMenu(false);
    addTextOptionMenu(0, getString(2131296964), new WalletWXCreditChangeAmountResultUI.1(this));
    AppMethodBeat.o(48687);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48686);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(48686);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountResultUI
 * JD-Core Version:    0.7.0.1
 */