package com.tencent.mm.plugin.wallet_payu.pwd.a;

import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class a
  extends g
{
  private Bundle kke;
  
  public a(MMActivity paramMMActivity, i parami, Bundle paramBundle)
  {
    super(paramMMActivity, parami);
    this.kke = paramBundle;
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof c))
    {
      paramString = (c)paramm;
      if (bk.bl(paramString.token)) {
        break label57;
      }
      y.d("MicroMsg.CommonCheckPwdController", "hy: check pwd pass");
      this.kke.putString("payu_reference", paramString.token);
      com.tencent.mm.wallet_core.a.j(this.gfb, this.kke);
    }
    for (;;)
    {
      return false;
      label57:
      y.w("MicroMsg.CommonCheckPwdController", "hy: check pwd failed");
    }
  }
  
  public final boolean m(Object... paramVarArgs)
  {
    this.kke.putString("key_pwd1", (String)paramVarArgs[0]);
    this.wBd.a(new c(this.kke.getString("key_pwd1")), true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pwd.a.a
 * JD-Core Version:    0.7.0.1
 */