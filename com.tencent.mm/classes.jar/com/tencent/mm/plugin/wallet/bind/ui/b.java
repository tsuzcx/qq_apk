package com.tencent.mm.plugin.wallet.bind.ui;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.storage.z;

public final class b
{
  public static boolean b(Bankcard paramBankcard)
  {
    AppMethodBeat.i(45739);
    if (paramBankcard == null)
    {
      AppMethodBeat.o(45739);
      return false;
    }
    g.RM();
    Object localObject1 = (String)g.RL().Ru().get(196659, null);
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      AppMethodBeat.o(45739);
      return true;
    }
    localObject1 = ((String)localObject1).split("&");
    if ((localObject1 == null) || (localObject1.length == 0))
    {
      AppMethodBeat.o(45739);
      return true;
    }
    int i = 0;
    while (i < localObject1.length)
    {
      Object localObject2 = localObject1[i];
      if ((localObject2 != null) && (localObject2.equals(paramBankcard.field_bankcardType)))
      {
        AppMethodBeat.o(45739);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(45739);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.b
 * JD-Core Version:    0.7.0.1
 */