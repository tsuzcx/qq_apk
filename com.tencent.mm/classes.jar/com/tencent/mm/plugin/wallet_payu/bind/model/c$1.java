package com.tencent.mm.plugin.wallet_payu.bind.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_payu.pwd.a.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.i;

final class c$1
  extends a
{
  c$1(c paramc, MMActivity paramMMActivity, i parami, Bundle paramBundle)
  {
    super(paramMMActivity, parami, paramBundle);
  }
  
  public final CharSequence getTips(int paramInt)
  {
    AppMethodBeat.i(48338);
    if (paramInt == 0)
    {
      localObject = this.hwZ.getString(2131305004);
      AppMethodBeat.o(48338);
      return localObject;
    }
    Object localObject = super.getTips(paramInt);
    AppMethodBeat.o(48338);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.bind.model.c.1
 * JD-Core Version:    0.7.0.1
 */