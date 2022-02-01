package com.tencent.mm.plugin.wallet_core.id_verify;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.wallet_core.id_verify.model.j;
import com.tencent.mm.plugin.wallet_core.id_verify.model.k;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class a$b
  extends g
{
  int CPW = 0;
  
  public a$b(a parama, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(174440);
    if ((paramn instanceof j))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        AppMethodBeat.o(174440);
        return true;
      }
    }
    else if (((paramn instanceof k)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      this.CPT.a(this.activity, 0, new Bundle());
      AppMethodBeat.o(174440);
      return true;
    }
    AppMethodBeat.o(174440);
    return false;
  }
  
  public final boolean s(Object... paramVarArgs)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.a.b
 * JD-Core Version:    0.7.0.1
 */