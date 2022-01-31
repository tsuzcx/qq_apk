package com.tencent.mm.plugin.wallet_ecard.b;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.ah.m;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.wallet.balance.a.a.q;
import com.tencent.mm.protocal.c.bca;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class b$f
  extends g
{
  public b$f(b paramb, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof q))
    {
      y.i("MicroMsg.OpenECardProcess", "openLqbAccount scene end, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      q localq = (q)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = localq.qgm;
        if (paramString.ino == 0)
        {
          paramString = new Intent();
          paramString.putExtra("key_account_type", 2);
          d.b(this.gfb, "wallet", ".balance.ui.lqt.WalletLqtDetailUI", paramString);
        }
      }
      for (;;)
      {
        this.gfb.finish();
        this.qKz.b(this.gfb, new Bundle());
        return true;
        Toast.makeText(this.gfb, paramString.inp, 1).show();
        continue;
        y.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramm });
        paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.gfb, new String[] { paramString });
        h.b(this.gfb, paramString, "", false);
      }
    }
    return false;
  }
  
  public final boolean m(Object... paramVarArgs)
  {
    ((Integer)paramVarArgs[0]).intValue();
    paramVarArgs = (String)paramVarArgs[1];
    this.wBd.kh(2996);
    paramVarArgs = new q(b.b(this.qKz), paramVarArgs);
    this.wBd.a(paramVarArgs, true);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.b.b.f
 * JD-Core Version:    0.7.0.1
 */