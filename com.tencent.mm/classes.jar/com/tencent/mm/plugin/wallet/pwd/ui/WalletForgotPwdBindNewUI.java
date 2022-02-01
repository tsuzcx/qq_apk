package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WalletForgotPwdBindNewUI
  extends WalletForgotPwdUI
{
  public void initView()
  {
    AppMethodBeat.i(69643);
    super.initView();
    AppMethodBeat.o(69643);
  }
  
  public boolean needConfirmFinish()
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdBindNewUI
 * JD-Core Version:    0.7.0.1
 */