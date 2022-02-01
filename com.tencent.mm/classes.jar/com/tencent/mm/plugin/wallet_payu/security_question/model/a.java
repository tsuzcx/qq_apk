package com.tencent.mm.plugin.wallet_payu.security_question.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public final class a
  extends g
{
  private Bundle dQL;
  
  public a(MMActivity paramMMActivity, i parami, Bundle paramBundle)
  {
    super(paramMMActivity, parami);
    this.dQL = paramBundle;
  }
  
  public final boolean A(Object... paramVarArgs)
  {
    AppMethodBeat.i(72206);
    this.Ruz.b(new c(this.dQL.getString("payu_reference")), true);
    AppMethodBeat.o(72206);
    return true;
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(72207);
    if (((paramq instanceof c)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (c)paramq;
      this.dQL.putParcelable("key_security_question", new PayUSecurityQuestion(paramString.id, paramString.IuI));
      AppMethodBeat.o(72207);
      return false;
    }
    if ((paramq instanceof b))
    {
      paramString = (b)paramq;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramString.sPX)
        {
          this.dQL.putString("payu_reference", paramString.IuH);
          com.tencent.mm.wallet_core.a.l(this.activity, this.dQL);
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
  
  public final boolean r(Object... paramVarArgs)
  {
    AppMethodBeat.i(72208);
    paramVarArgs = (PayUSecurityQuestion)this.dQL.getParcelable("key_security_question");
    String str1 = this.dQL.getString("key_question_answer");
    String str2 = this.dQL.getString("payu_reference");
    this.Ruz.b(new b(str2, paramVarArgs.id, str1), true);
    AppMethodBeat.o(72208);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.security_question.model.a
 * JD-Core Version:    0.7.0.1
 */