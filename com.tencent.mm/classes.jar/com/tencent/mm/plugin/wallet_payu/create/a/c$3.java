package com.tencent.mm.plugin.wallet_payu.create.a;

import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_payu.security_question.model.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class c$3
  extends g
{
  c$3(c paramc, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (((paramm instanceof d)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      this.qNi.kke.putParcelableArrayList("key_security_question_list", ((d)paramm).qOO);
      return true;
    }
    return false;
  }
  
  public final boolean m(Object... paramVarArgs)
  {
    return false;
  }
  
  public final boolean s(Object... paramVarArgs)
  {
    this.wBd.a(new d(), true);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.create.a.c.3
 * JD-Core Version:    0.7.0.1
 */