package com.tencent.mm.plugin.wallet_core.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import org.json.JSONObject;

public final class e
{
  public static void bn(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(71641);
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.WalletNetSceneUtil", "parseLuckyMoneySnsPayData() json is null");
      AppMethodBeat.o(71641);
      return;
    }
    ad.i("MicroMsg.WalletNetSceneUtil", "parseLuckyMoneySnsPayData()");
    String str2 = "";
    String str1 = "";
    int i = paramJSONObject.optInt("is_open_sns_pay", 0);
    int j = paramJSONObject.optInt("can_open_sns_pay", 0);
    int k = paramJSONObject.optInt("is_white_user", 0);
    if (j == 1)
    {
      str2 = paramJSONObject.optString("open_sns_pay_title");
      str1 = paramJSONObject.optString("open_sns_pay_wording");
      g.afC();
      g.afB().afk().set(ae.a.Fkr, str2);
      g.afC();
      g.afB().afk().set(ae.a.Fks, str1);
    }
    ad.i("MicroMsg.WalletNetSceneUtil", "is_open_sns_pay:" + i + ", can_open_sns_pay:" + j + ", is_white_user:" + k);
    ad.i("MicroMsg.WalletNetSceneUtil", "open_sns_pay_title:" + str2 + ", open_sns_pay_wording:" + str1);
    g.afC();
    g.afB().afk().set(ae.a.Fko, Integer.valueOf(i));
    g.afC();
    g.afB().afk().set(ae.a.Fkp, Integer.valueOf(j));
    g.afC();
    g.afB().afk().set(ae.a.Fkq, Integer.valueOf(k));
    if (k == 1)
    {
      str1 = paramJSONObject.optString("set_sns_pay_title");
      paramJSONObject = paramJSONObject.optString("set_sns_pay_wording");
      g.afC();
      g.afB().afk().set(ae.a.Fkt, str1);
      g.afC();
      g.afB().afk().set(ae.a.Fku, paramJSONObject);
    }
    for (;;)
    {
      ad.i("MicroMsg.WalletNetSceneUtil", "set_sns_pay_title:" + str1 + ", set_sns_pay_wording:" + paramJSONObject);
      g.afC();
      g.afB().afk().eKy();
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