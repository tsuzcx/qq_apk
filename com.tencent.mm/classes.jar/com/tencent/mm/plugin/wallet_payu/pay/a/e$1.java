package com.tencent.mm.plugin.wallet_payu.pay.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.c.b.a;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class e$1
  extends g
{
  e$1(e parame, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    return false;
  }
  
  public final boolean x(Object... paramVarArgs)
  {
    AppMethodBeat.i(48446);
    paramVarArgs = (PayInfo)this.hwZ.getIntent().getParcelableExtra("key_pay_info");
    if ((paramVarArgs != null) && (!bo.isNullOrNil(paramVarArgs.cnI)))
    {
      this.AXB.a(new c(paramVarArgs.cnI), paramVarArgs.wgt, 1);
      this.AXB.a(new a(), paramVarArgs.wgt, 1);
      AppMethodBeat.o(48446);
      return true;
    }
    AppMethodBeat.o(48446);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.a.e.1
 * JD-Core Version:    0.7.0.1
 */