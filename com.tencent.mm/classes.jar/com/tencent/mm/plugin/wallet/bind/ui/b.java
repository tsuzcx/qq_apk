package com.tencent.mm.plugin.wallet.bind.ui;

import android.text.TextUtils;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.storage.z;

public final class b
{
  public static boolean a(Bankcard paramBankcard)
  {
    if (paramBankcard == null) {
      return false;
    }
    g.DQ();
    Object localObject1 = (String)g.DP().Dz().get(196659, null);
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return true;
    }
    localObject1 = ((String)localObject1).split("&");
    if ((localObject1 == null) || (localObject1.length == 0)) {
      return true;
    }
    int i = 0;
    for (;;)
    {
      if (i >= localObject1.length) {
        break label87;
      }
      Object localObject2 = localObject1[i];
      if ((localObject2 != null) && (localObject2.equals(paramBankcard.field_bankcardType))) {
        break;
      }
      i += 1;
    }
    label87:
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.b
 * JD-Core Version:    0.7.0.1
 */