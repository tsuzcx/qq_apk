package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.widget.a.f;
import java.util.HashMap;
import java.util.List;

public final class l
{
  public static void a(Context paramContext, List<Bankcard> paramList, Bankcard paramBankcard, String paramString1, String paramString2, String paramString3, u.i parami)
  {
    int i = 0;
    AppMethodBeat.i(301259);
    f localf = new f(paramContext, 2, true);
    localf.Vtg = new l.1(paramList, paramContext, new HashMap(), localf, false, paramString3);
    localf.GAC = parami;
    localf.Vto = true;
    paramContext = LayoutInflater.from(paramContext).inflate(a.g.wallet_balance_fetch_bankcard_bottomsheet_header, null);
    if (!Util.isNullOrNil(paramString1)) {
      ((TextView)paramContext.findViewById(a.f.bfbh_header_title_tv)).setText(paramString1);
    }
    if (!Util.isNullOrNil(paramString2)) {
      ((TextView)paramContext.findViewById(a.f.bfbh_header_desc_tv)).setText(paramString2);
    }
    for (;;)
    {
      localf.af(paramContext, false);
      if (paramBankcard == null) {
        break;
      }
      while (i < paramList.size())
      {
        if (((Bankcard)paramList.get(i)).field_bindSerial.equals(paramBankcard.field_bindSerial)) {
          localf.pym = i;
        }
        i += 1;
      }
      paramContext.findViewById(a.f.bfbh_header_desc_tv).setVisibility(8);
    }
    localf.dDn();
    AppMethodBeat.o(301259);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.l
 * JD-Core Version:    0.7.0.1
 */