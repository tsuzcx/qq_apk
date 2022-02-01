package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
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
    AppMethodBeat.i(72204);
    doSceneProgress(new f(paramString1, getIntent().getIntExtra("total_fee", 0), getIntent().getStringExtra("fee_type"), paramString3, paramInt1));
    AppMethodBeat.o(72204);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(72203);
    super.onCreate(paramBundle);
    AppMethodBeat.o(72203);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(72205);
    if ((paramq instanceof f))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        h.cD(this, getString(2131764588));
        finish();
        AppMethodBeat.o(72205);
        return true;
      }
      h.cD(this, paramString);
      finish();
      AppMethodBeat.o(72205);
      return true;
    }
    AppMethodBeat.o(72205);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceResendMsgUI
 * JD-Core Version:    0.7.0.1
 */