package com.tencent.mm.plugin.wallet_payu.pwd.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.i;

final class g$1
  extends a
{
  g$1(g paramg, MMActivity paramMMActivity, i parami, Bundle paramBundle)
  {
    super(paramMMActivity, parami, paramBundle);
  }
  
  public final CharSequence getTips(int paramInt)
  {
    AppMethodBeat.i(48513);
    if (paramInt == 0)
    {
      localObject = this.hwZ.getString(2131305009);
      AppMethodBeat.o(48513);
      return localObject;
    }
    Object localObject = super.getTips(paramInt);
    AppMethodBeat.o(48513);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pwd.a.g.1
 * JD-Core Version:    0.7.0.1
 */