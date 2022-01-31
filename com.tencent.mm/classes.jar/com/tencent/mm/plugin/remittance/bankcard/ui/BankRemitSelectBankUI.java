package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.remittance.bankcard.a.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p;

public class BankRemitSelectBankUI
  extends BankRemitBaseUI
{
  private BankRemitSortView qis;
  
  public int getLayoutId()
  {
    return 2130968830;
  }
  
  public void initView()
  {
    AppMethodBeat.i(44668);
    this.qis = ((BankRemitSortView)findViewById(2131821725));
    this.qis.setOnItemClickListener(new BankRemitSelectBankUI.1(this));
    AppMethodBeat.o(44668);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(44667);
    super.onCreate(paramBundle);
    setMMTitle(2131297511);
    addSceneEndListener(1399);
    initView();
    ab.i("MicroMsg.BankRemitSelectBankUI", "do fetch data");
    paramBundle = new h();
    paramBundle.o(this);
    doSceneProgress(paramBundle);
    AppMethodBeat.o(44667);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(44670);
    super.onDestroy();
    removeSceneEndListener(1399);
    AppMethodBeat.o(44670);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(44669);
    if ((paramm instanceof h))
    {
      paramString = (h)paramm;
      paramString.a(new BankRemitSelectBankUI.4(this, paramString)).b(new BankRemitSelectBankUI.3(this, paramString)).c(new BankRemitSelectBankUI.2(this, paramString));
    }
    AppMethodBeat.o(44669);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectBankUI
 * JD-Core Version:    0.7.0.1
 */