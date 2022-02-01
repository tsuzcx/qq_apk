package com.tencent.mm.plugin.wxcredit.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.a;

public class WalletCheckIdentityUI
  extends WalletBaseUI
{
  private WalletFormView BCi;
  private WalletFormView Bmi;
  private String DcT;
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131496045;
  }
  
  public void initView()
  {
    AppMethodBeat.i(72327);
    setMMTitle(2131765192);
    this.BCi = ((WalletFormView)findViewById(2131302662));
    a.e(this, this.BCi);
    this.Bmi = ((WalletFormView)findViewById(2131300910));
    a.c(this.Bmi);
    setEditFocusListener(this.Bmi, 1, false);
    String str = getInput().getString("key_pre_name");
    this.DcT = getInput().getString("key_pre_indentity");
    if (!bs.isNullOrNil(str))
    {
      this.BCi.getPrefilledTv().setText(str);
      this.BCi.setHint(getString(2131765181));
    }
    if (!bs.isNullOrNil(this.DcT))
    {
      this.Bmi.setMaxInputLength(4);
      this.Bmi.getPrefilledTv().setText(this.DcT);
      this.Bmi.setHint(getString(2131765135));
    }
    findViewById(2131302852).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72325);
        paramAnonymousView = WalletCheckIdentityUI.a(WalletCheckIdentityUI.this).getText();
        String str = WalletCheckIdentityUI.b(WalletCheckIdentityUI.this).getText();
        if (WalletCheckIdentityUI.a(WalletCheckIdentityUI.this, paramAnonymousView, str)) {
          WalletCheckIdentityUI.this.getNetController().s(new Object[] { paramAnonymousView, str });
        }
        AppMethodBeat.o(72325);
      }
    });
    AppMethodBeat.o(72327);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(72326);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(72326);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletCheckIdentityUI
 * JD-Core Version:    0.7.0.1
 */