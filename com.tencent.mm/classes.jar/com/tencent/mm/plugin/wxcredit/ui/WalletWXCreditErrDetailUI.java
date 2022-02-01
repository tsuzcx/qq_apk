package com.tencent.mm.plugin.wxcredit.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;

public class WalletWXCreditErrDetailUI
  extends WalletBaseUI
{
  private Bankcard Hww;
  private String JQL;
  private TextView JQM;
  private TextView JQN;
  
  public int getLayoutId()
  {
    return 2131497028;
  }
  
  public void initView()
  {
    AppMethodBeat.i(72382);
    this.Hww = ((Bankcard)getInput().getParcelable("key_bankcard"));
    this.JQL = getInput().getString("key_repayment_url");
    if (this.Hww == null)
    {
      AppMethodBeat.o(72382);
      return;
    }
    this.JQM = ((TextView)findViewById(2131310143));
    this.JQM.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72379);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditErrDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        f.p(WalletWXCreditErrDetailUI.this, WalletWXCreditErrDetailUI.a(WalletWXCreditErrDetailUI.this), false);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditErrDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(72379);
      }
    });
    this.JQN = ((TextView)findViewById(2131310144));
    this.JQN.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72380);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditErrDetailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        com.tencent.mm.wallet_core.a.l(WalletWXCreditErrDetailUI.this, WalletWXCreditErrDetailUI.this.getInput());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditErrDetailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(72380);
      }
    });
    boolean bool = getInput().getBoolean("key_can_unbind", true);
    TextView localTextView = this.JQN;
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
    setMMTitle(2131767497);
    initView();
    AppMethodBeat.o(72381);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditErrDetailUI
 * JD-Core Version:    0.7.0.1
 */