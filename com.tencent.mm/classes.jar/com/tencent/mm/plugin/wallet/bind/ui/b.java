package com.tencent.mm.plugin.wallet.bind.ui;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.storage.ao;

public final class b
{
  public static boolean c(Bankcard paramBankcard)
  {
    AppMethodBeat.i(69076);
    if (paramBankcard == null)
    {
      AppMethodBeat.o(69076);
      return false;
    }
    h.aHH();
    Object localObject1 = (String)h.aHG().aHp().b(196659, null);
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      AppMethodBeat.o(69076);
      return true;
    }
    localObject1 = ((String)localObject1).split("&");
    if ((localObject1 == null) || (localObject1.length == 0))
    {
      AppMethodBeat.o(69076);
      return true;
    }
    int i = 0;
    while (i < localObject1.length)
    {
      Object localObject2 = localObject1[i];
      if ((localObject2 != null) && (localObject2.equals(paramBankcard.field_bankcardType)))
      {
        AppMethodBeat.o(69076);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(69076);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.b
 * JD-Core Version:    0.7.0.1
 */