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
import com.tencent.mm.ak.n;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@com.tencent.mm.ui.base.a(19)
public class WalletWXCreditOpenResultUI
  extends WalletBaseUI
{
  private CheckBox EZY;
  
  private void aUI()
  {
    AppMethodBeat.i(72390);
    getNetController().r(new Object[] { Boolean.valueOf(this.EZY.isChecked()) });
    AppMethodBeat.o(72390);
  }
  
  public int getLayoutId()
  {
    return 2131496050;
  }
  
  public void initView()
  {
    AppMethodBeat.i(72389);
    setMMTitle(2131766015);
    TextView localTextView = (TextView)findViewById(2131306855);
    this.EZY = ((CheckBox)findViewById(2131296965));
    Bankcard localBankcard = (Bankcard)getInput().getParcelable("key_bankcard");
    if (localBankcard != null)
    {
      this.EZY.setText(getString(2131766017, new Object[] { localBankcard.field_bankName }));
      localTextView.setText(2131766018);
    }
    ((Button)findViewById(2131302852)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72387);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditOpenResultUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajR().ajA().set(196658, Boolean.TRUE);
    t.eJf().DsG = bu.aRi();
    initView();
    AppMethodBeat.o(72388);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(72391);
    if (paramInt == 4)
    {
      aUI();
      AppMethodBeat.o(72391);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(72391);
    return bool;
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
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenResultUI
 * JD-Core Version:    0.7.0.1
 */