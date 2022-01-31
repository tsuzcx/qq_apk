package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.a.d;
import java.util.HashMap;
import java.util.List;

public final class f
{
  public static void a(Context paramContext, List<Bankcard> paramList, Bankcard paramBankcard, String paramString1, String paramString2, n.d paramd)
  {
    d locald = new d(paramContext, 2, true);
    locald.phH = new f.1(paramList, paramContext, new HashMap(), locald);
    locald.phI = paramd;
    locald.wnm = true;
    paramContext = LayoutInflater.from(paramContext).inflate(a.g.wallet_balance_fetch_bankcard_bottomsheet_header, null);
    if (!bk.bl(paramString1)) {
      ((TextView)paramContext.findViewById(a.f.bfbh_header_title_tv)).setText(paramString1);
    }
    if (!bk.bl(paramString2)) {
      ((TextView)paramContext.findViewById(a.f.bfbh_header_desc_tv)).setText(paramString2);
    }
    locald.ej(paramContext);
    if (paramBankcard != null)
    {
      int i = 0;
      while (i < paramList.size())
      {
        if (((Bankcard)paramList.get(i)).field_bindSerial.equals(paramBankcard.field_bindSerial)) {
          locald.wno = i;
        }
        i += 1;
      }
    }
    locald.cfU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.f
 * JD-Core Version:    0.7.0.1
 */