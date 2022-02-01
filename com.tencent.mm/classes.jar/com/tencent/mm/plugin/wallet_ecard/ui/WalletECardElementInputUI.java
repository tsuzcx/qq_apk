package com.tencent.mm.plugin.wallet_ecard.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardSelectUI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class WalletECardElementInputUI
  extends WalletECardBaseUI
{
  private WalletFormView BDR;
  private ElementQuery Bqm;
  private Button fwU;
  
  private void cL()
  {
    AppMethodBeat.i(71776);
    if (this.Bqm == null) {
      this.Bqm = new ElementQuery();
    }
    if (bs.isNullOrNil(this.Bqm.tGS))
    {
      this.BDR.setText("");
      AppMethodBeat.o(71776);
      return;
    }
    if (!bs.isNullOrNil(this.Bqm.BvZ))
    {
      this.BDR.setText(this.Bqm.tGS + " " + this.Bqm.BvZ);
      AppMethodBeat.o(71776);
      return;
    }
    if (2 == this.Bqm.BvY)
    {
      this.BDR.setText(this.Bqm.tGS + " " + getString(2131765221));
      AppMethodBeat.o(71776);
      return;
    }
    this.BDR.setText(this.Bqm.tGS + " " + getString(2131765241));
    AppMethodBeat.o(71776);
  }
  
  public int getLayoutId()
  {
    return 2131493732;
  }
  
  public void initView()
  {
    AppMethodBeat.i(71775);
    this.BDR = ((WalletFormView)findViewById(2131306717));
    this.BDR.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71772);
        paramAnonymousView = new Bundle();
        paramAnonymousView.putInt("key_support_bankcard", WalletECardElementInputUI.this.getInput().getInt("key_support_bankcard", 3));
        paramAnonymousView.putInt("key_bind_scene", WalletECardElementInputUI.this.getInput().getInt("key_bind_scene", -1));
        if (!bs.isNullOrNil(WalletECardElementInputUI.a(WalletECardElementInputUI.this).getText()))
        {
          paramAnonymousView.putString("key_bank_type", WalletECardElementInputUI.b(WalletECardElementInputUI.this).cZz);
          paramAnonymousView.putInt("key_bankcard_type", WalletECardElementInputUI.b(WalletECardElementInputUI.this).BvY);
        }
        d locald = a.br(WalletECardElementInputUI.this);
        if (locald != null) {
          locald.a(WalletECardElementInputUI.this, WalletCardSelectUI.class, paramAnonymousView, 1);
        }
        AppMethodBeat.o(71772);
      }
    });
    this.fwU = ((Button)findViewById(2131302852));
    this.fwU.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71773);
        ac.i("MicroMsg.WalletECardElementInputUI", "goto next: %s", new Object[] { WalletECardElementInputUI.b(WalletECardElementInputUI.this).cZz });
        WalletECardElementInputUI.this.getNetController().s(new Object[] { WalletECardElementInputUI.b(WalletECardElementInputUI.this) });
        AppMethodBeat.o(71773);
      }
    });
    AppMethodBeat.o(71775);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(71777);
    ac.i("MicroMsg.WalletECardElementInputUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
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
    this.Bqm = ((ElementQuery)paramIntent.getParcelableExtra("elemt_query"));
    cL();
    AppMethodBeat.o(71777);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71774);
    super.onCreate(paramBundle);
    setMMTitle(2131758169);
    initView();
    cL();
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