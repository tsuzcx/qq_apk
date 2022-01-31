package com.tencent.mm.plugin.wallet_payu.pay.a;

import android.content.Intent;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_core.c.b.a;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bk;
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
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  public final boolean m(Object... paramVarArgs)
  {
    return false;
  }
  
  public final boolean s(Object... paramVarArgs)
  {
    paramVarArgs = (PayInfo)this.gfb.getIntent().getParcelableExtra("key_pay_info");
    if ((paramVarArgs != null) && (!bk.bl(paramVarArgs.bMX)))
    {
      this.wBd.a(new c(paramVarArgs.bMX), paramVarArgs.snV, 1);
      this.wBd.a(new a(), paramVarArgs.snV, 1);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.a.e.1
 * JD-Core Version:    0.7.0.1
 */