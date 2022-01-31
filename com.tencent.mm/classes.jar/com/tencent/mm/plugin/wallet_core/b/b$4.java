package com.tencent.mm.plugin.wallet_core.b;

import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_core.id_verify.model.h;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class b$4
  extends g
{
  b$4(b paramb, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof com.tencent.mm.plugin.wallet_core.b.a.b))
    {
      this.qqt.a(this.wBd);
      if (((com.tencent.mm.plugin.wallet_core.b.a.b)paramm).qqu != null) {
        b.h(this.qqt).putParcelable("key_bindcard_value_result", ((com.tencent.mm.plugin.wallet_core.b.a.b)paramm).qqu);
      }
    }
    while (!(paramm instanceof h)) {
      return false;
    }
    return true;
  }
  
  public final boolean m(Object... paramVarArgs)
  {
    paramVarArgs = (p)paramVarArgs[0];
    b.i(this.qqt).getString("verify_card_flag", "0");
    if ("realname_verify_process".equals(this.qqt.aTh()))
    {
      this.wBd.a(new com.tencent.mm.plugin.wallet_core.b.a.b(paramVarArgs, this.qqt.kke.getInt("entry_scene", -1)), true);
      return false;
    }
    this.wBd.a(new com.tencent.mm.plugin.wallet_core.b.a.b(paramVarArgs), true);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.b.b.4
 * JD-Core Version:    0.7.0.1
 */