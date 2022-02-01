package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.i;

public class WalletWXCreditOpenUI
  extends WalletBaseUI
{
  private Bankcard Vla;
  private Button qgp;
  
  public int getLayoutId()
  {
    return a.g.wallet_wxcredit_open_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(72397);
    setMMTitle(a.i.wallet_wxcredit_open_title);
    ((CheckBox)findViewById(a.f.agree_wx_cb)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(72393);
        WalletWXCreditOpenUI.a(WalletWXCreditOpenUI.this).setEnabled(paramAnonymousBoolean);
        AppMethodBeat.o(72393);
      }
    });
    findViewById(a.f.agree_btn).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72394);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditOpenUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        i.a(WalletWXCreditOpenUI.this, WalletWXCreditOpenUI.b(WalletWXCreditOpenUI.this).field_bankcardType, WalletWXCreditOpenUI.b(WalletWXCreditOpenUI.this).field_bankName, true, false);
        a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditOpenUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(72394);
      }
    });
    this.qgp = ((Button)findViewById(a.f.next_btn));
    this.qgp.setOnClickListener(new WalletWXCreditOpenUI.3(this));
    AppMethodBeat.o(72397);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(72396);
    super.onCreate(paramBundle);
    this.Vla = ((Bankcard)getInput().getParcelable("key_bankcard"));
    initView();
    AppMethodBeat.o(72396);
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
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenUI
 * JD-Core Version:    0.7.0.1
 */