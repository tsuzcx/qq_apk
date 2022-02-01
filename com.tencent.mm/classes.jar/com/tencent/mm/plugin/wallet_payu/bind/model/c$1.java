package com.tencent.mm.plugin.wallet_payu.bind.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_payu.pwd.a.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.i;

final class c$1
  extends a
{
  c$1(c paramc, MMActivity paramMMActivity, i parami, Bundle paramBundle)
  {
    super(paramMMActivity, parami, paramBundle);
  }
  
  public final CharSequence getTips(int paramInt)
  {
    AppMethodBeat.i(71978);
    if (paramInt == 0)
    {
      localObject = this.activity.getString(a.i.wallet_check_pwd_bind_bankcard_tip_payu);
      AppMethodBeat.o(71978);
      return localObject;
    }
    Object localObject = super.getTips(paramInt);
    AppMethodBeat.o(71978);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.bind.model.c.1
 * JD-Core Version:    0.7.0.1
 */