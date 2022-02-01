package com.tencent.mm.plugin.wallet_payu.security_question.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public final class a
  extends g
{
  private Bundle dxT;
  
  public a(MMActivity paramMMActivity, i parami, Bundle paramBundle)
  {
    super(paramMMActivity, parami);
    this.dxT = paramBundle;
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(72207);
    if (((paramn instanceof c)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (c)paramn;
      this.dxT.putParcelable("key_security_question", new PayUSecurityQuestion(paramString.id, paramString.DtO));
      AppMethodBeat.o(72207);
      return false;
    }
    if ((paramn instanceof b))
    {
      paramString = (b)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramString.rgp)
        {
          this.dxT.putString("payu_reference", paramString.DtN);
          com.tencent.mm.wallet_core.a.k(this.activity, this.dxT);
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
    paramVarArgs = (PayUSecurityQuestion)this.dxT.getParcelable("key_security_question");
    String str1 = this.dxT.getString("key_question_answer");
    String str2 = this.dxT.getString("payu_reference");
    this.LyU.b(new b(str2, paramVarArgs.id, str1), true);
    AppMethodBeat.o(72208);
    return false;
  }
  
  public final boolean z(Object... paramVarArgs)
  {
    AppMethodBeat.i(72206);
    this.LyU.b(new c(this.dxT.getString("payu_reference")), true);
    AppMethodBeat.o(72206);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.security_question.model.a
 * JD-Core Version:    0.7.0.1
 */