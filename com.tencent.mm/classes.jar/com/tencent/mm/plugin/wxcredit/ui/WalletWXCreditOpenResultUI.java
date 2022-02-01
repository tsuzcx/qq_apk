package com.tencent.mm.plugin.wxcredit.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@com.tencent.mm.ui.base.a(19)
public class WalletWXCreditOpenResultUI
  extends WalletBaseUI
{
  private CheckBox JQQ;
  
  private void bpv()
  {
    AppMethodBeat.i(72390);
    getNetController().r(new Object[] { Boolean.valueOf(this.JQQ.isChecked()) });
    AppMethodBeat.o(72390);
  }
  
  public int getLayoutId()
  {
    return 2131497030;
  }
  
  public void initView()
  {
    AppMethodBeat.i(72389);
    setMMTitle(2131768468);
    TextView localTextView = (TextView)findViewById(2131310317);
    this.JQQ = ((CheckBox)findViewById(2131297080));
    Bankcard localBankcard = (Bankcard)getInput().getParcelable("key_bankcard");
    if (localBankcard != null)
    {
      this.JQQ.setText(getString(2131768470, new Object[] { localBankcard.field_bankName }));
      localTextView.setText(2131768471);
    }
    ((Button)findViewById(2131305423)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72387);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditOpenResultUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        WalletWXCreditOpenResultUI.a(WalletWXCreditOpenResultUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditOpenResultUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(72387);
      }
    });
    AppMethodBeat.o(72389);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(72388);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAh().azQ().set(196658, Boolean.TRUE);
    t.fQI().IbS = Util.nowSecond();
    initView();
    AppMethodBeat.o(72388);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(72391);
    if (paramInt == 4)
    {
      bpv();
      AppMethodBeat.o(72391);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(72391);
    return bool;
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
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenResultUI
 * JD-Core Version:    0.7.0.1
 */