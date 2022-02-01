package com.tencent.mm.plugin.wallet_ecard.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardSelectUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class WalletECardElementInputUI
  extends WalletECardBaseUI
{
  private WalletFormView Alw;
  private Button ftn;
  private ElementQuery zXS;
  
  private void cE()
  {
    AppMethodBeat.i(71776);
    if (this.zXS == null) {
      this.zXS = new ElementQuery();
    }
    if (bt.isNullOrNil(this.zXS.szi))
    {
      this.Alw.setText("");
      AppMethodBeat.o(71776);
      return;
    }
    if (!bt.isNullOrNil(this.zXS.AdF))
    {
      this.Alw.setText(this.zXS.szi + " " + this.zXS.AdF);
      AppMethodBeat.o(71776);
      return;
    }
    if (2 == this.zXS.AdE)
    {
      this.Alw.setText(this.zXS.szi + " " + getString(2131765221));
      AppMethodBeat.o(71776);
      return;
    }
    this.Alw.setText(this.zXS.szi + " " + getString(2131765241));
    AppMethodBeat.o(71776);
  }
  
  public int getLayoutId()
  {
    return 2131493732;
  }
  
  public void initView()
  {
    AppMethodBeat.i(71775);
    this.Alw = ((WalletFormView)findViewById(2131306717));
    this.Alw.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71772);
        paramAnonymousView = new Bundle();
        paramAnonymousView.putInt("key_support_bankcard", WalletECardElementInputUI.this.getInput().getInt("key_support_bankcard", 3));
        paramAnonymousView.putInt("key_bind_scene", WalletECardElementInputUI.this.getInput().getInt("key_bind_scene", -1));
        if (!bt.isNullOrNil(WalletECardElementInputUI.a(WalletECardElementInputUI.this).getText()))
        {
          paramAnonymousView.putString("key_bank_type", WalletECardElementInputUI.b(WalletECardElementInputUI.this).dca);
          paramAnonymousView.putInt("key_bankcard_type", WalletECardElementInputUI.b(WalletECardElementInputUI.this).AdE);
        }
        d locald = a.bo(WalletECardElementInputUI.this);
        if (locald != null) {
          locald.a(WalletECardElementInputUI.this, WalletCardSelectUI.class, paramAnonymousView, 1);
        }
        AppMethodBeat.o(71772);
      }
    });
    this.ftn = ((Button)findViewById(2131302852));
    this.ftn.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71773);
        ad.i("MicroMsg.WalletECardElementInputUI", "goto next: %s", new Object[] { WalletECardElementInputUI.b(WalletECardElementInputUI.this).dca });
        WalletECardElementInputUI.this.getNetController().q(new Object[] { WalletECardElementInputUI.b(WalletECardElementInputUI.this) });
        AppMethodBeat.o(71773);
      }
    });
    AppMethodBeat.o(71775);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(71777);
    ad.i("MicroMsg.WalletECardElementInputUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
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
    this.zXS = ((ElementQuery)paramIntent.getParcelableExtra("elemt_query"));
    cE();
    AppMethodBeat.o(71777);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71774);
    super.onCreate(paramBundle);
    setMMTitle(2131758169);
    initView();
    cE();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.ui.WalletECardElementInputUI
 * JD-Core Version:    0.7.0.1
 */