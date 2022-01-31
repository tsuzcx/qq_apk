package com.tencent.mm.plugin.wallet_ecard.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_ecard.a.a;
import com.tencent.mm.plugin.wallet_ecard.a.d;
import com.tencent.mm.plugin.wallet_ecard.a.e;
import com.tencent.mm.protocal.c.bau;
import com.tencent.mm.protocal.c.baw;
import com.tencent.mm.protocal.c.bcd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.io.IOException;

final class b$c
  extends g
{
  public b$c(b paramb, MMActivity paramMMActivity, i parami)
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
          y.i("MicroMsg.OpenECardProcess", "req_serial: %s", new Object[] { paramm.qKw.sAU });
          b.f(this.qKz).putString(a.qJT, paramm.qKw.sAU);
          y.i("MicroMsg.OpenECardProcess", "authScene.token: %s, is_token_invalid: %s, is_reuse_existing_ecard: %s", new Object[] { paramm.token, Boolean.valueOf(paramm.qKw.twK), Boolean.valueOf(paramm.qKw.twL) });
          if (!bk.bl(paramm.token)) {
            paramString.putBoolean(a.qJU, paramm.qKw.twK);
          }
          if (paramm.qKw.twL) {
            paramString.putBoolean(a.qKj, true);
          }
          paramString.putInt("key_ecard_proxy_action", 1);
          this.qKz.a(this.gfb, 0, paramString);
        }
      }
      for (;;)
      {
        this.gfb.finish();
        return true;
        if ((!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.gfb, paramm.qKw.sAW)) && (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.gfb, paramm, paramm.iHq, paramm.iHr, paramm.qKw.ino, paramm.qKw.inp)))
        {
          paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.gfb, new String[] { paramm.qKw.inp, paramm.iHr, paramString });
          h.a(this.gfb, paramString, "", false, new b.c.1(this));
          continue;
          y.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramm });
          paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.gfb, new String[] { paramString });
          h.a(this.gfb, paramString, "", false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              b.c.this.qKz.b(b.c.this.gfb, null);
            }
          });
        }
      }
    }
    if ((paramm instanceof d))
    {
      this.wBd.ki(1985);
      paramm = (d)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        if (paramm.qKs.ino == 0)
        {
          b.g(this.qKz).putInt(a.qJV, a.qKm);
          b.h(this.qKz).putString(a.qJY, paramm.qKt);
          b.i(this.qKz).putString(a.qJZ, paramm.qKu);
          b.j(this.qKz).putString(a.qKa, paramm.qKv);
          paramString = new Bundle();
          if (paramm.qKs.sAX != null)
          {
            y.i("MicroMsg.OpenECardProcess", "no need verify sms");
            paramString.putBoolean(a.qKg, false);
          }
        }
      }
      for (;;)
      {
        try
        {
          b.k(this.qKz).putByteArray(a.qKk, paramm.qKs.sAX.toByteArray());
          paramString.putInt("key_ecard_proxy_action", 2);
          this.qKz.a(this.gfb, 0, paramString);
          return true;
        }
        catch (IOException paramm)
        {
          y.printErrStackTrace("MicroMsg.OpenECardProcess", paramm, "", new Object[0]);
          continue;
        }
        y.i("MicroMsg.OpenECardProcess", "need verfiy sms");
        paramString.putBoolean(a.qKg, true);
        paramString.putString(a.qKe, paramm.qKs.sAV);
        paramString.putString(a.qKf, paramm.qKs.twP);
        continue;
        if ((!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.gfb, paramm.qKs.sAW)) && (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.gfb, paramm, paramm.iHq, paramm.iHr, paramm.qKs.ino, paramm.qKs.inp)))
        {
          paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.gfb, new String[] { paramm.qKs.inp, paramm.iHr, paramString });
          h.a(this.gfb, paramString, "", false, new b.c.3(this));
          continue;
          y.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramm });
          paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.gfb, new String[] { paramString });
          h.a(this.gfb, paramString, "", false, new b.c.4(this));
        }
      }
    }
    return false;
  }
  
  public final boolean m(Object... paramVarArgs)
  {
    if (((Integer)paramVarArgs[0]).intValue() == 1)
    {
      y.i("MicroMsg.OpenECardProcess", "onNext do ecard auth");
      i = ((Integer)paramVarArgs[1]).intValue();
      paramVarArgs = (String)paramVarArgs[2];
      this.wBd.kh(1958);
      paramVarArgs = new e(b.b(this.qKz), null, i, paramVarArgs);
      this.wBd.a(paramVarArgs, true);
      return true;
    }
    y.i("MicroMsg.OpenECardProcess", "onNext do ecard open");
    int i = ((Integer)paramVarArgs[1]).intValue();
    this.wBd.kh(1985);
    paramVarArgs = new d(b.b(this.qKz), b.e(this.qKz), i);
    this.wBd.a(paramVarArgs, true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.b.b.c
 * JD-Core Version:    0.7.0.1
 */