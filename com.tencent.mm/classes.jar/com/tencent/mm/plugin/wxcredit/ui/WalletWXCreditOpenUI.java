package com.tencent.mm.plugin.wxcredit.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;

public class WalletWXCreditOpenUI
  extends WalletBaseUI
{
  private Bankcard CYh;
  private Button jtd;
  
  public int getLayoutId()
  {
    return 2131496051;
  }
  
  public void initView()
  {
    AppMethodBeat.i(72397);
    setMMTitle(2131766021);
    ((CheckBox)findViewById(2131296518)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(72393);
        WalletWXCreditOpenUI.a(WalletWXCreditOpenUI.this).setEnabled(paramAnonymousBoolean);
        AppMethodBeat.o(72393);
      }
    });
    findViewById(2131296513).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72394);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditOpenUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        f.b(WalletWXCreditOpenUI.this, WalletWXCreditOpenUI.b(WalletWXCreditOpenUI.this).field_bankcardType, WalletWXCreditOpenUI.b(WalletWXCreditOpenUI.this).field_bankName, true, false);
        a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditOpenUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(72394);
      }
    });
    this.jtd = ((Button)findViewById(2131302852));
    this.jtd.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72395);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditOpenUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        WalletWXCreditOpenUI.this.next();
        a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditOpenUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(72395);
      }
    });
    AppMethodBeat.o(72397);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(72396);
    super.onCreate(paramBundle);
    this.CYh = ((Bankcard)getInput().getParcelable("key_bankcard"));
    initView();
    AppMethodBeat.o(72396);
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
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenUI
 * JD-Core Version:    0.7.0.1
 */