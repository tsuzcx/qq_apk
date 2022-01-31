package com.tencent.mm.plugin.wallet_payu.security_question.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public final class a
  extends g
{
  private Bundle mEJ;
  
  public a(MMActivity paramMMActivity, i parami, Bundle paramBundle)
  {
    super(paramMMActivity, parami);
    this.mEJ = paramBundle;
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(48566);
    if (((paramm instanceof c)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (c)paramm;
      this.mEJ.putParcelable("key_security_question", new PayUSecurityQuestion(paramString.id, paramString.uDU));
      AppMethodBeat.o(48566);
      return false;
    }
    if ((paramm instanceof b))
    {
      paramString = (b)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramString.mhc)
        {
          this.mEJ.putString("payu_reference", paramString.uDT);
          com.tencent.mm.wallet_core.a.j(this.hwZ, this.mEJ);
          AppMethodBeat.o(48566);
          return true;
        }
        AppMethodBeat.o(48566);
        return false;
      }
    }
    AppMethodBeat.o(48566);
    return false;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    AppMethodBeat.i(48567);
    paramVarArgs = (PayUSecurityQuestion)this.mEJ.getParcelable("key_security_question");
    String str1 = this.mEJ.getString("key_question_answer");
    String str2 = this.mEJ.getString("payu_reference");
    this.AXB.a(new b(str2, paramVarArgs.id, str1), true);
    AppMethodBeat.o(48567);
    return false;
  }
  
  public final boolean x(Object... paramVarArgs)
  {
    AppMethodBeat.i(48565);
    this.AXB.a(new c(this.mEJ.getString("payu_reference")), true);
    AppMethodBeat.o(48565);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.security_question.model.a
 * JD-Core Version:    0.7.0.1
 */