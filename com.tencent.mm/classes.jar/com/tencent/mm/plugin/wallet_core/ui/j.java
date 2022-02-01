package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.a.e;
import java.util.HashMap;
import java.util.List;

public final class j
{
  public static void a(Context paramContext, List<Bankcard> paramList, Bankcard paramBankcard, String paramString1, String paramString2, boolean paramBoolean, String paramString3, n.d paramd)
  {
    AppMethodBeat.i(70721);
    e locale = new e(paramContext, 2, true);
    locale.HrX = new j.1(paramList, paramContext, new HashMap(), locale, paramBoolean, paramString3);
    locale.HrY = paramd;
    locale.HFm = true;
    paramContext = LayoutInflater.from(paramContext).inflate(2131495898, null);
    if (!bt.isNullOrNil(paramString1)) {
      ((TextView)paramContext.findViewById(2131297202)).setText(paramString1);
    }
    if (!bt.isNullOrNil(paramString2)) {
      ((TextView)paramContext.findViewById(2131297201)).setText(paramString2);
    }
    for (;;)
    {
      locale.J(paramContext, false);
      if (paramBankcard == null) {
        break;
      }
      int i = 0;
      while (i < paramList.size())
      {
        if (((Bankcard)paramList.get(i)).field_bindSerial.equals(paramBankcard.field_bindSerial)) {
          locale.hRK = i;
        }
        i += 1;
      }
      paramContext.findViewById(2131297201).setVisibility(8);
    }
    locale.csG();
    AppMethodBeat.o(70721);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.j
 * JD-Core Version:    0.7.0.1
 */