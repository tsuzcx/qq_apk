package com.tencent.mm.plugin.wallet_ecard.b;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_ecard.a.a;
import com.tencent.mm.plugin.wallet_ecard.a.d;
import com.tencent.mm.protocal.c.baw;
import com.tencent.mm.protocal.c.bcd;
import com.tencent.mm.protocal.c.hr;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.io.IOException;

final class b$g
  extends g
{
  public b$g(b paramb, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof com.tencent.mm.plugin.wallet_ecard.a.c))
    {
      this.wBd.ki(1986);
      paramm = (com.tencent.mm.plugin.wallet_ecard.a.c)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramm.qKr.ino != 0) {
          break label145;
        }
        paramString = new Bundle();
        if (paramm.qKr.sAX != null) {
          y.i("MicroMsg.OpenECardProcess", "succ title: %s", new Object[] { paramm.qKr.sAX.title });
        }
      }
      for (;;)
      {
        try
        {
          b.C(this.qKz).putByteArray(a.qKk, paramm.qKr.sAX.toByteArray());
          this.qKz.a(this.gfb, 0, paramString);
          return true;
        }
        catch (IOException paramm)
        {
          y.printErrStackTrace("MicroMsg.OpenECardProcess", paramm, "", new Object[0]);
          continue;
        }
        label145:
        if (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.gfb, paramm.qKr.sAW))
        {
          paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.gfb, new String[] { paramm.qKr.inp, paramString });
          h.b(this.gfb, paramString, "", false);
        }
      }
    }
    if ((paramm instanceof d))
    {
      this.wBd.ki(1985);
      paramm = (d)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        if (paramm.qKs.ino == 0) {
          this.gfb.getIntent().putExtra(a.qKe, paramm.qKs.sAV);
        }
      }
      for (;;)
      {
        return true;
        if ((!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.gfb, paramm.qKs.sAW)) && (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI)this.gfb, paramm, paramm.iHq, paramm.iHr, paramm.qKs.ino, paramm.qKs.inp)))
        {
          paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.gfb, new String[] { paramm.qKs.inp, paramm.iHr, paramString });
          h.b(this.gfb, paramString, "", false);
          continue;
          y.w("MicroMsg.OpenECardProcess", "net error: %s", new Object[] { paramm });
          paramString = com.tencent.mm.plugin.wallet_ecard.a.b.d(this.gfb, new String[] { paramString });
          h.b(this.gfb, paramString, "", false);
        }
      }
    }
    return false;
  }
  
  public final boolean m(Object... paramVarArgs)
  {
    b.z(this.qKz).getString("key_pwd1");
    paramVarArgs = b.A(this.qKz).getString("key_verify_code");
    String str1 = b.e(this.qKz);
    int i = b.B(this.qKz).getInt(a.qJR);
    String str2 = this.gfb.getIntent().getStringExtra(a.qKe);
    paramVarArgs = new com.tencent.mm.plugin.wallet_ecard.a.c(b.b(this.qKz), str1, paramVarArgs, str2, i);
    this.wBd.kh(1986);
    this.wBd.a(paramVarArgs, true, 3);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    y.i("MicroMsg.OpenECardProcess", "reqCode: %s, resCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.qKz.b(this.gfb, new Bundle());
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public final boolean t(Object... paramVarArgs)
  {
    int i = b.s(this.qKz).getInt(a.qJV);
    paramVarArgs = b.e(this.qKz);
    y.i("MicroMsg.OpenECardProcess", "bind action: %s", new Object[] { Integer.valueOf(i) });
    String str1;
    String str2;
    String str3;
    if (i == a.qKm)
    {
      str1 = b.t(this.qKz).getString(a.qJY);
      str2 = b.u(this.qKz).getString(a.qJZ);
      str3 = b.v(this.qKz).getString(a.qKa);
    }
    for (paramVarArgs = new d(b.b(this.qKz), paramVarArgs, str1, str2, str3, b.m(this.qKz), true, true);; paramVarArgs = new d(b.b(this.qKz), paramVarArgs, str1, str2, str3, b.m(this.qKz), false, true))
    {
      this.wBd.kh(1985);
      this.wBd.a(paramVarArgs, true);
      return true;
      str1 = b.w(this.qKz).getString(a.qKb);
      str2 = b.x(this.qKz).getString(a.qKc);
      str3 = b.y(this.qKz).getString(a.qKd);
    }
  }
  
  public final CharSequence vy(int paramInt)
  {
    return this.gfb.getIntent().getStringExtra(a.qKf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.b.b.g
 * JD-Core Version:    0.7.0.1
 */