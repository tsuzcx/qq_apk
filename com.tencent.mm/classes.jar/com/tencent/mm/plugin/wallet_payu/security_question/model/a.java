package com.tencent.mm.plugin.wallet_payu.security_question.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public final class a
  extends g
{
  private Bundle dmf;
  
  public a(MMActivity paramMMActivity, i parami, Bundle paramBundle)
  {
    super(paramMMActivity, parami);
    this.dmf = paramBundle;
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(72207);
    if (((paramn instanceof c)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (c)paramn;
      this.dmf.putParcelable("key_security_question", new PayUSecurityQuestion(paramString.id, paramString.BTu));
      AppMethodBeat.o(72207);
      return false;
    }
    if ((paramn instanceof b))
    {
      paramString = (b)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramString.qwz)
        {
          this.dmf.putString("payu_reference", paramString.BTt);
          com.tencent.mm.wallet_core.a.k(this.activity, this.dmf);
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
  
  public final boolean s(Object... paramVarArgs)
  {
    AppMethodBeat.i(72208);
    paramVarArgs = (PayUSecurityQuestion)this.dmf.getParcelable("key_security_question");
    String str1 = this.dmf.getString("key_question_answer");
    String str2 = this.dmf.getString("payu_reference");
    this.JFQ.b(new b(str2, paramVarArgs.id, str1), true);
    AppMethodBeat.o(72208);
    return false;
  }
  
  public final boolean z(Object... paramVarArgs)
  {
    AppMethodBeat.i(72206);
    this.JFQ.b(new c(this.dmf.getString("payu_reference")), true);
    AppMethodBeat.o(72206);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.security_question.model.a
 * JD-Core Version:    0.7.0.1
 */