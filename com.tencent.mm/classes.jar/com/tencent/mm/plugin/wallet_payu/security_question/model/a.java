package com.tencent.mm.plugin.wallet_payu.security_question.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.g;
import com.tencent.mm.wallet_core.c.i;

public final class a
  extends g
{
  private Bundle hPH;
  
  public a(MMActivity paramMMActivity, i parami, Bundle paramBundle)
  {
    super(paramMMActivity, parami);
    this.hPH = paramBundle;
  }
  
  public final boolean D(Object... paramVarArgs)
  {
    AppMethodBeat.i(72206);
    this.agTR.b(new c(this.hPH.getString("payu_reference")), true);
    AppMethodBeat.o(72206);
    return true;
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(72207);
    if (((paramp instanceof c)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (c)paramp;
      this.hPH.putParcelable("key_security_question", new PayUSecurityQuestion(paramString.id, paramString.WdQ));
      AppMethodBeat.o(72207);
      return false;
    }
    if ((paramp instanceof b))
    {
      paramString = (b)paramp;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramString.zSb)
        {
          this.hPH.putString("payu_reference", paramString.WdP);
          com.tencent.mm.wallet_core.a.k(this.activity, this.hPH);
          AppMethodBeat.o(72207);
          return true;
        }
        AppMethodBeat.o(72207);
        return false;
      }
    }
    AppMethodBeat.o(72207);
    return false;
  }
  
  public final boolean t(Object... paramVarArgs)
  {
    AppMethodBeat.i(72208);
    paramVarArgs = (PayUSecurityQuestion)this.hPH.getParcelable("key_security_question");
    String str1 = this.hPH.getString("key_question_answer");
    String str2 = this.hPH.getString("payu_reference");
    this.agTR.b(new b(str2, paramVarArgs.id, str1), true);
    AppMethodBeat.o(72208);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.security_question.model.a
 * JD-Core Version:    0.7.0.1
 */