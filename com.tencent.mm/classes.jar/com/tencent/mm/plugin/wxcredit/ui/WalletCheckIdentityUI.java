package com.tencent.mm.plugin.wxcredit.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class WalletCheckIdentityUI
  extends WalletBaseUI
{
  private WalletFormView HJY;
  private WalletFormView Idq;
  private String JQh;
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131497025;
  }
  
  public void initView()
  {
    AppMethodBeat.i(72327);
    setMMTitle(2131767635);
    this.Idq = ((WalletFormView)findViewById(2131305216));
    com.tencent.mm.wallet_core.ui.formview.a.e(this, this.Idq);
    this.HJY = ((WalletFormView)findViewById(2131302521));
    com.tencent.mm.wallet_core.ui.formview.a.c(this.HJY);
    setEditFocusListener(this.HJY, 1, false);
    String str = getInput().getString("key_pre_name");
    this.JQh = getInput().getString("key_pre_indentity");
    if (!Util.isNullOrNil(str))
    {
      this.Idq.getPrefilledTv().setText(str);
      this.Idq.setHint(getString(2131767624));
    }
    if (!Util.isNullOrNil(this.JQh))
    {
      this.HJY.setMaxInputLength(4);
      this.HJY.getPrefilledTv().setText(this.JQh);
      this.HJY.setHint(getString(2131767578));
    }
    findViewById(2131305423).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72325);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wxcredit/ui/WalletCheckIdentityUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
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