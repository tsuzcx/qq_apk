package com.tencent.mm.plugin.wallet_payu.security_question.model;

import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public final class a
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
    if (((paramm instanceof c)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (c)paramm;
      this.kke.putParcelable("key_security_question", new PayUSecurityQuestion(paramString.id, paramString.qON));
    }
    do
    {
      do
      {
        return false;
      } while (!(paramm instanceof b));
      paramString = (b)paramm;
    } while ((paramInt1 != 0) || (paramInt2 != 0) || (!paramString.jMT));
    this.kke.putString("payu_reference", paramString.qOM);
    com.tencent.mm.wallet_core.a.j(this.gfb, this.kke);
    return true;
  }
  
  public final boolean m(Object... paramVarArgs)
  {
    paramVarArgs = (PayUSecurityQuestion)this.kke.getParcelable("key_security_question");
    String str1 = this.kke.getString("key_question_answer");
    String str2 = this.kke.getString("payu_reference");
    this.wBd.a(new b(str2, paramVarArgs.id, str1), true);
    return false;
  }
  
  public final boolean s(Object... paramVarArgs)
  {
    this.wBd.a(new c(this.kke.getString("payu_reference")), true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.security_question.model.a
 * JD-Core Version:    0.7.0.1
 */