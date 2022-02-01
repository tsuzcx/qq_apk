package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class WalletCheckIdentityUI
  extends WalletBaseUI
{
  private WalletFormView VLW;
  private WalletFormView Vre;
  private String XHW;
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return a.g.wallet_wxcredit_check_indentity_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(72327);
    setMMTitle(a.i.wallet_check_indentity_title);
    this.VLW = ((WalletFormView)findViewById(a.f.name_et));
    com.tencent.mm.wallet_core.ui.formview.a.e(this, this.VLW);
    this.Vre = ((WalletFormView)findViewById(a.f.identity_et));
    com.tencent.mm.wallet_core.ui.formview.a.c(this.Vre);
    setEditFocusListener(this.Vre, 1, false);
    String str = getInput().getString("key_pre_name");
    this.XHW = getInput().getString("key_pre_indentity");
    if (!Util.isNullOrNil(str))
    {
      this.VLW.getPrefilledTv().setText(str);
      this.VLW.setHint(getString(a.i.wallet_card_username_last_hint));
    }
    if (!Util.isNullOrNil(this.XHW))
    {
      this.Vre.setMaxInputLength(4);
      this.Vre.getPrefilledTv().setText(this.XHW);
      this.Vre.setHint(getString(a.i.wallet_card_identify_last_hint));
    }
    findViewById(a.f.next_btn).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72325);
        Object localObject = new b();
        ((b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wxcredit/ui/WalletCheckIdentityUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
        paramAnonymousView = WalletCheckIdentityUI.a(WalletCheckIdentityUI.this).getText();
        localObject = WalletCheckIdentityUI.b(WalletCheckIdentityUI.this).getText();
        if (WalletCheckIdentityUI.a(WalletCheckIdentityUI.this, paramAnonymousView, (String)localObject)) {
          WalletCheckIdentityUI.this.getNetController().t(new Object[] { paramAnonymousView, localObject });
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletCheckIdentityUI
 * JD-Core Version:    0.7.0.1
 */