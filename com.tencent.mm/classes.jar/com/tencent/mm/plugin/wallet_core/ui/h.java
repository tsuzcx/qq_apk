package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.b.d;
import java.util.HashMap;
import java.util.List;

public final class h
{
  public static void a(Context paramContext, List<Bankcard> paramList, Bankcard paramBankcard, String paramString1, String paramString2, boolean paramBoolean, String paramString3, n.d paramd)
  {
    AppMethodBeat.i(47158);
    d locald = new d(paramContext, 2, true);
    locald.sao = new h.1(paramList, paramContext, new HashMap(), locald, paramBoolean, paramString3);
    locald.sap = paramd;
    locald.AHi = true;
    paramContext = LayoutInflater.from(paramContext).inflate(2130971126, null);
    if (!bo.isNullOrNil(paramString1)) {
      ((TextView)paramContext.findViewById(2131828929)).setText(paramString1);
    }
    if (!bo.isNullOrNil(paramString2)) {
      ((TextView)paramContext.findViewById(2131828930)).setText(paramString2);
    }
    for (;;)
    {
      locald.G(paramContext, false);
      if (paramBankcard == null) {
        break;
      }
      int i = 0;
      while (i < paramList.size())
      {
        if (((Bankcard)paramList.get(i)).field_bindSerial.equals(paramBankcard.field_bindSerial)) {
          locald.udx = i;
        }
        i += 1;
      }
      paramContext.findViewById(2131828930).setVisibility(8);
    }
    locald.crd();
    AppMethodBeat.o(47158);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.h
 * JD-Core Version:    0.7.0.1
 */