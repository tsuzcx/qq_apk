package com.tencent.mm.plugin.wallet_ecard.b;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_ecard.a.a;
import com.tencent.mm.plugin.wallet_ecard.a.e;
import com.tencent.mm.protocal.c.bau;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class b$b
  extends g
{
  public b$b(b paramb, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof e))
    {
      this.wBd.ki(1958);
      paramm = (e)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        if (paramm.qKw.ino == 0)
        {
          paramString = new Bundle();
          y.i("MicroMsg.OpenECardProcess", "req_serial: %s, is_reuse_existing_ecard: %s", new Object[] { paramm.qKw.sAU, Boolean.valueOf(paramm.qKw.twL) });
          b.d(this.qKz).putString(a.qJT, paramm.qKw.sAU);
          if (paramm.qKw.twL) {
            paramString.putBoolean(a.qKj, true);
          }
          this.qKz.a(this.gfb, 0, paramString);
        }
      }
      for (;;)
      {
        return true;
        if ((!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.gfb, paramm.qKw.sAW)) && (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.gfb, paramm, paramm.iHq, paramm.iHr, paramm.qKw.ino, paramm.qKw.inp)))
        {
          paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.gfb, new String[] { paramm.qKw.inp, paramm.iHr, paramString });
          h.a(this.gfb, paramString, "", false, new b.b.1(this));
          continue;
          y.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramm });
          paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.gfb, new String[] { paramString });
          h.a(this.gfb, paramString, "", false, new b.b.2(this));
        }
      }
    }
    return false;
  }
  
  public final boolean m(Object... paramVarArgs)
  {
    paramVarArgs = (String)paramVarArgs[0];
    int i = b.a(this.qKz).getInt(a.qJR);
    this.wBd.kh(1958);
    e locale = new e(b.b(this.qKz), paramVarArgs, i, null);
    this.wBd.a(locale, true);
    b.c(this.qKz).putString("key_pwd1", paramVarArgs);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    y.i("MicroMsg.OpenECardProcess", "reqCode: %s, resCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramIntent = new Bundle();
    paramIntent.putInt("key_process_result_code", 0);
    this.qKz.b(this.gfb, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.b.b.b
 * JD-Core Version:    0.7.0.1
 */