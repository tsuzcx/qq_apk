package com.tencent.mm.plugin.wxcredit.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

public class WalletWXCreditOpenUI
  extends WalletBaseUI
{
  private Button gJr;
  private Bankcard tTH;
  
  public int getLayoutId()
  {
    return 2130971274;
  }
  
  public void initView()
  {
    AppMethodBeat.i(48754);
    setMMTitle(2131305801);
    ((CheckBox)findViewById(2131829071)).setOnCheckedChangeListener(new WalletWXCreditOpenUI.1(this));
    findViewById(2131826245).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(48751);
        e.a(WalletWXCreditOpenUI.this, WalletWXCreditOpenUI.b(WalletWXCreditOpenUI.this).field_bankcardType, WalletWXCreditOpenUI.b(WalletWXCreditOpenUI.this).field_bankName, true, false);
        AppMethodBeat.o(48751);
      }
    });
    this.gJr = ((Button)findViewById(2131822914));
    this.gJr.setOnClickListener(new WalletWXCreditOpenUI.3(this));
    AppMethodBeat.o(48754);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48753);
    super.onCreate(paramBundle);
    this.tTH = ((Bankcard)getInput().getParcelable("key_bankcard"));
    initView();
    AppMethodBeat.o(48753);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenUI
 * JD-Core Version:    0.7.0.1
 */