package com.tencent.mm.plugin.wallet_core.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import org.json.JSONObject;

public final class e
{
  public static void bo(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(71641);
    if (paramJSONObject == null)
    {
      ac.e("MicroMsg.WalletNetSceneUtil", "parseLuckyMoneySnsPayData() json is null");
      AppMethodBeat.o(71641);
      return;
    }
    ac.i("MicroMsg.WalletNetSceneUtil", "parseLuckyMoneySnsPayData()");
    String str2 = "";
    String str1 = "";
    int i = paramJSONObject.optInt("is_open_sns_pay", 0);
    int j = paramJSONObject.optInt("can_open_sns_pay", 0);
    int k = paramJSONObject.optInt("is_white_user", 0);
    if (j == 1)
    {
      str2 = paramJSONObject.optString("open_sns_pay_title");
      str1 = paramJSONObject.optString("open_sns_pay_wording");
      g.agS();
      g.agR().agA().set(ah.a.GIg, str2);
      g.agS();
      g.agR().agA().set(ah.a.GIh, str1);
    }
    ac.i("MicroMsg.WalletNetSceneUtil", "is_open_sns_pay:" + i + ", can_open_sns_pay:" + j + ", is_white_user:" + k);
    ac.i("MicroMsg.WalletNetSceneUtil", "open_sns_pay_title:" + str2 + ", open_sns_pay_wording:" + str1);
    g.agS();
    g.agR().agA().set(ah.a.GId, Integer.valueOf(i));
    g.agS();
    g.agR().agA().set(ah.a.GIe, Integer.valueOf(j));
    g.agS();
    g.agR().agA().set(ah.a.GIf, Integer.valueOf(k));
    if (k == 1)
    {
      str1 = paramJSONObject.optString("set_sns_pay_title");
      paramJSONObject = paramJSONObject.optString("set_sns_pay_wording");
      g.agS();
      g.agR().agA().set(ah.a.GIi, str1);
      g.agS();
      g.agR().agA().set(ah.a.GIj, paramJSONObject);
    }
    for (;;)
    {
      ac.i("MicroMsg.WalletNetSceneUtil", "set_sns_pay_title:" + str1 + ", set_sns_pay_wording:" + paramJSONObject);
      g.agS();
      g.agR().agA().faa();
      AppMethodBeat.o(71641);
      return;
      paramJSONObject = "";
      str1 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.e
 * JD-Core Version:    0.7.0.1
 */