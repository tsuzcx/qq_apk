package com.tencent.mm.plugin.wallet_ecard.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class WalletECardElementInputUI
  extends WalletECardBaseUI
{
  private Button gHb;
  private ElementQuery udb;
  private WalletFormView uoK;
  
  private void bJ()
  {
    AppMethodBeat.i(48142);
    if (this.udb == null) {
      this.udb = new ElementQuery();
    }
    if (bo.isNullOrNil(this.udb.nLq))
    {
      this.uoK.setText("");
      AppMethodBeat.o(48142);
      return;
    }
    if (!bo.isNullOrNil(this.udb.uhy))
    {
      this.uoK.setText(this.udb.nLq + " " + this.udb.uhy);
      AppMethodBeat.o(48142);
      return;
    }
    if (2 == this.udb.uhx)
    {
      this.uoK.setText(this.udb.nLq + " " + getString(2131305029));
      AppMethodBeat.o(48142);
      return;
    }
    this.uoK.setText(this.udb.nLq + " " + getString(2131305049));
    AppMethodBeat.o(48142);
  }
  
  public int getLayoutId()
  {
    return 2130969343;
  }
  
  public void initView()
  {
    AppMethodBeat.i(48141);
    this.uoK = ((WalletFormView)findViewById(2131823480));
    this.uoK.setOnClickListener(new WalletECardElementInputUI.1(this));
    this.gHb = ((Button)findViewById(2131822914));
    this.gHb.setOnClickListener(new WalletECardElementInputUI.2(this));
    AppMethodBeat.o(48141);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(48143);
    ab.i("MicroMsg.WalletECardElementInputUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(48143);
      return;
    }
    switch (paramInt1)
    {
    default: 
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(48143);
      return;
    }
    this.udb = ((ElementQuery)paramIntent.getParcelableExtra("elemt_query"));
    bJ();
    AppMethodBeat.o(48143);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48140);
    super.onCreate(paramBundle);
    setMMTitle(2131299064);
    initView();
    bJ();
    AppMethodBeat.o(48140);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
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
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.ui.WalletECardElementInputUI
 * JD-Core Version:    0.7.0.1
 */