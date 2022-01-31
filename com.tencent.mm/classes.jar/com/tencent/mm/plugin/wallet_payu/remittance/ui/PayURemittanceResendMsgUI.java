package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.remittance.ui.RemittanceResendMsgUI;
import com.tencent.mm.plugin.wallet_payu.remittance.a.f;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;

@a(3)
public class PayURemittanceResendMsgUI
  extends RemittanceResendMsgUI
{
  public final void f(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(48563);
    doSceneProgress(new f(paramString1, getIntent().getIntExtra("total_fee", 0), getIntent().getStringExtra("fee_type"), paramString3, paramInt1));
    AppMethodBeat.o(48563);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48562);
    super.onCreate(paramBundle);
    AppMethodBeat.o(48562);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(48564);
    if ((paramm instanceof f))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        h.bO(this, getString(2131302615));
        finish();
        AppMethodBeat.o(48564);
        return true;
      }
      h.bO(this, paramString);
      finish();
      AppMethodBeat.o(48564);
      return true;
    }
    AppMethodBeat.o(48564);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceResendMsgUI
 * JD-Core Version:    0.7.0.1
 */