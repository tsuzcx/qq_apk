package com.tencent.mm.plugin.wxcredit.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class WalletCheckIdentityUI
  extends WalletBaseUI
{
  private WalletFormView CMx;
  private WalletFormView DcA;
  private String EGT;
  
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
    this.DcA = ((WalletFormView)findViewById(2131302662));
    com.tencent.mm.wallet_core.ui.formview.a.e(this, this.DcA);
    this.CMx = ((WalletFormView)findViewById(2131300910));
    com.tencent.mm.wallet_core.ui.formview.a.c(this.CMx);
    setEditFocusListener(this.CMx, 1, false);
    String str = getInput().getString("key_pre_name");
    this.EGT = getInput().getString("key_pre_indentity");
    if (!bt.isNullOrNil(str))
    {
      this.DcA.getPrefilledTv().setText(str);
      this.DcA.setHint(getString(2131765181));
    }
    if (!bt.isNullOrNil(this.EGT))
    {
      this.CMx.setMaxInputLength(4);
      this.CMx.getPrefilledTv().setText(this.EGT);
      this.CMx.setHint(getString(2131765135));
    }
    findViewById(2131302852).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72325);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wxcredit/ui/WalletCheckIdentityUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
        paramAnonymousView = WalletCheckIdentityUI.a(WalletCheckIdentityUI.this).getText();
        localObject = WalletCheckIdentityUI.b(WalletCheckIdentityUI.this).getText();
        if (WalletCheckIdentityUI.a(WalletCheckIdentityUI.this, paramAnonymousView, (String)localObject)) {
          WalletCheckIdentityUI.this.getNetController().s(new Object[] { paramAnonymousView, localObject });
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletCheckIdentityUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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