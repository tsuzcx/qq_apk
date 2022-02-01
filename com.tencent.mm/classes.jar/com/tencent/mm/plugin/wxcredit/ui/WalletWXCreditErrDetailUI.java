package com.tencent.mm.plugin.wxcredit.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

public class WalletWXCreditErrDetailUI
  extends WalletBaseUI
{
  private Bankcard CzV;
  private String EHx;
  private TextView EHy;
  private TextView EHz;
  
  public int getLayoutId()
  {
    return 2131496048;
  }
  
  public void initView()
  {
    AppMethodBeat.i(72382);
    this.CzV = ((Bankcard)getInput().getParcelable("key_bankcard"));
    this.EHx = getInput().getString("key_repayment_url");
    if (this.CzV == null)
    {
      AppMethodBeat.o(72382);
      return;
    }
    this.EHy = ((TextView)findViewById(2131306683));
    this.EHy.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72379);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditErrDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        e.o(WalletWXCreditErrDetailUI.this, WalletWXCreditErrDetailUI.a(WalletWXCreditErrDetailUI.this), false);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditErrDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(72379);
      }
    });
    this.EHz = ((TextView)findViewById(2131306684));
    this.EHz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72380);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditErrDetailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        com.tencent.mm.wallet_core.a.k(WalletWXCreditErrDetailUI.this, WalletWXCreditErrDetailUI.this.getInput());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditErrDetailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(72380);
      }
    });
    boolean bool = getInput().getBoolean("key_can_unbind", true);
    TextView localTextView = this.EHz;
    if (bool) {}
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      AppMethodBeat.o(72382);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(72381);
    super.onCreate(paramBundle);
    setMMTitle(2131765054);
    initView();
    AppMethodBeat.o(72381);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditErrDetailUI
 * JD-Core Version:    0.7.0.1
 */