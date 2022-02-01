package com.tencent.mm.plugin.wallet_ecard.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardSelectUI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class WalletECardElementInputUI
  extends WalletECardBaseUI
{
  private ElementQuery Dif;
  private WalletFormView DvN;
  private Button fSn;
  
  private void updateView()
  {
    AppMethodBeat.i(71776);
    if (this.Dif == null) {
      this.Dif = new ElementQuery();
    }
    if (bu.isNullOrNil(this.Dif.uVs))
    {
      this.DvN.setText("");
      AppMethodBeat.o(71776);
      return;
    }
    if (!bu.isNullOrNil(this.Dif.DnU))
    {
      this.DvN.setText(this.Dif.uVs + " " + this.Dif.DnU);
      AppMethodBeat.o(71776);
      return;
    }
    if (2 == this.Dif.DnT)
    {
      this.DvN.setText(this.Dif.uVs + " " + getString(2131765221));
      AppMethodBeat.o(71776);
      return;
    }
    this.DvN.setText(this.Dif.uVs + " " + getString(2131765241));
    AppMethodBeat.o(71776);
  }
  
  public int getLayoutId()
  {
    return 2131493732;
  }
  
  public void initView()
  {
    AppMethodBeat.i(71775);
    this.DvN = ((WalletFormView)findViewById(2131306717));
    this.DvN.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71772);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_ecard/ui/WalletECardElementInputUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        paramAnonymousView = new Bundle();
        paramAnonymousView.putInt("key_support_bankcard", WalletECardElementInputUI.this.getInput().getInt("key_support_bankcard", 3));
        paramAnonymousView.putInt("key_bind_scene", WalletECardElementInputUI.this.getInput().getInt("key_bind_scene", -1));
        if (!bu.isNullOrNil(WalletECardElementInputUI.a(WalletECardElementInputUI.this).getText()))
        {
          paramAnonymousView.putString("key_bank_type", WalletECardElementInputUI.b(WalletECardElementInputUI.this).dlT);
          paramAnonymousView.putInt("key_bankcard_type", WalletECardElementInputUI.b(WalletECardElementInputUI.this).DnT);
        }
        localObject = com.tencent.mm.wallet_core.a.bs(WalletECardElementInputUI.this);
        if (localObject != null) {
          ((d)localObject).a(WalletECardElementInputUI.this, WalletCardSelectUI.class, paramAnonymousView, 1);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_ecard/ui/WalletECardElementInputUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(71772);
      }
    });
    this.fSn = ((Button)findViewById(2131302852));
    this.fSn.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71773);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_ecard/ui/WalletECardElementInputUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ae.i("MicroMsg.WalletECardElementInputUI", "goto next: %s", new Object[] { WalletECardElementInputUI.b(WalletECardElementInputUI.this).dlT });
        WalletECardElementInputUI.this.getNetController().r(new Object[] { WalletECardElementInputUI.b(WalletECardElementInputUI.this) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_ecard/ui/WalletECardElementInputUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(71773);
      }
    });
    AppMethodBeat.o(71775);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(71777);
    ae.i("MicroMsg.WalletECardElementInputUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(71777);
      return;
    }
    switch (paramInt1)
    {
    default: 
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(71777);
      return;
    }
    this.Dif = ((ElementQuery)paramIntent.getParcelableExtra("elemt_query"));
    updateView();
    AppMethodBeat.o(71777);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71774);
    super.onCreate(paramBundle);
    setMMTitle(2131758169);
    initView();
    updateView();
    AppMethodBeat.o(71774);
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
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.ui.WalletECardElementInputUI
 * JD-Core Version:    0.7.0.1
 */