package com.tencent.mm.plugin.wxcredit.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class WalletCheckIdentityUI
  extends WalletBaseUI
{
  private WalletFormView Def;
  private WalletFormView Due;
  private String EZp;
  
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
    this.Due = ((WalletFormView)findViewById(2131302662));
    com.tencent.mm.wallet_core.ui.formview.a.e(this, this.Due);
    this.Def = ((WalletFormView)findViewById(2131300910));
    com.tencent.mm.wallet_core.ui.formview.a.c(this.Def);
    setEditFocusListener(this.Def, 1, false);
    String str = getInput().getString("key_pre_name");
    this.EZp = getInput().getString("key_pre_indentity");
    if (!bu.isNullOrNil(str))
    {
      this.Due.getPrefilledTv().setText(str);
      this.Due.setHint(getString(2131765181));
    }
    if (!bu.isNullOrNil(this.EZp))
    {
      this.Def.setMaxInputLength(4);
      this.Def.getPrefilledTv().setText(this.EZp);
      this.Def.setHint(getString(2131765135));
    }
    findViewById(2131302852).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72325);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wxcredit/ui/WalletCheckIdentityUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        paramAnonymousView = WalletCheckIdentityUI.a(WalletCheckIdentityUI.this).getText();
        localObject = WalletCheckIdentityUI.b(WalletCheckIdentityUI.this).getText();
        if (WalletCheckIdentityUI.a(WalletCheckIdentityUI.this, paramAnonymousView, (String)localObject)) {
          WalletCheckIdentityUI.this.getNetController().r(new Object[] { paramAnonymousView, localObject });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletCheckIdentityUI
 * JD-Core Version:    0.7.0.1
 */