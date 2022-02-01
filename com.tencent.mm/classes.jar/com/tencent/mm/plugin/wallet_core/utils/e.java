package com.tencent.mm.plugin.wallet_core.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import org.json.JSONObject;

public final class e
{
  public static void bx(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(71641);
    if (paramJSONObject == null)
    {
      ae.e("MicroMsg.WalletNetSceneUtil", "parseLuckyMoneySnsPayData() json is null");
      AppMethodBeat.o(71641);
      return;
    }
    ae.i("MicroMsg.WalletNetSceneUtil", "parseLuckyMoneySnsPayData()");
    String str2 = "";
    String str1 = "";
    int i = paramJSONObject.optInt("is_open_sns_pay", 0);
    int j = paramJSONObject.optInt("can_open_sns_pay", 0);
    int k = paramJSONObject.optInt("is_white_user", 0);
    if (j == 1)
    {
      str2 = paramJSONObject.optString("open_sns_pay_title");
      str1 = paramJSONObject.optString("open_sns_pay_wording");
      g.ajS();
      g.ajR().ajA().set(am.a.IOW, str2);
      g.ajS();
      g.ajR().ajA().set(am.a.IOX, str1);
    }
    ae.i("MicroMsg.WalletNetSceneUtil", "is_open_sns_pay:" + i + ", can_open_sns_pay:" + j + ", is_white_user:" + k);
    ae.i("MicroMsg.WalletNetSceneUtil", "open_sns_pay_title:" + str2 + ", open_sns_pay_wording:" + str1);
    g.ajS();
    g.ajR().ajA().set(am.a.IOT, Integer.valueOf(i));
    g.ajS();
    g.ajR().ajA().set(am.a.IOU, Integer.valueOf(j));
    g.ajS();
    g.ajR().ajA().set(am.a.IOV, Integer.valueOf(k));
    if (k == 1)
    {
      str1 = paramJSONObject.optString("set_sns_pay_title");
      paramJSONObject = paramJSONObject.optString("set_sns_pay_wording");
      g.ajS();
      g.ajR().ajA().set(am.a.IOY, str1);
      g.ajS();
      g.ajR().ajA().set(am.a.IOZ, paramJSONObject);
    }
    for (;;)
    {
      ae.i("MicroMsg.WalletNetSceneUtil", "set_sns_pay_title:" + str1 + ", set_sns_pay_wording:" + paramJSONObject);
      g.ajS();
      g.ajR().ajA().fuc();
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