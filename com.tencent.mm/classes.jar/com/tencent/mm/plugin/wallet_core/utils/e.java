package com.tencent.mm.plugin.wallet_core.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import org.json.JSONObject;

public final class e
{
  public static void bW(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(71641);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.WalletNetSceneUtil", "parseLuckyMoneySnsPayData() json is null");
      AppMethodBeat.o(71641);
      return;
    }
    Log.i("MicroMsg.WalletNetSceneUtil", "parseLuckyMoneySnsPayData()");
    String str2 = "";
    String str1 = "";
    int i = paramJSONObject.optInt("is_open_sns_pay", 0);
    int j = paramJSONObject.optInt("can_open_sns_pay", 0);
    int k = paramJSONObject.optInt("is_white_user", 0);
    if (j == 1)
    {
      str2 = paramJSONObject.optString("open_sns_pay_title");
      str1 = paramJSONObject.optString("open_sns_pay_wording");
      g.aAi();
      g.aAh().azQ().set(ar.a.NWX, str2);
      g.aAi();
      g.aAh().azQ().set(ar.a.NWY, str1);
    }
    Log.i("MicroMsg.WalletNetSceneUtil", "is_open_sns_pay:" + i + ", can_open_sns_pay:" + j + ", is_white_user:" + k);
    Log.i("MicroMsg.WalletNetSceneUtil", "open_sns_pay_title:" + str2 + ", open_sns_pay_wording:" + str1);
    g.aAi();
    g.aAh().azQ().set(ar.a.NWU, Integer.valueOf(i));
    g.aAi();
    g.aAh().azQ().set(ar.a.NWV, Integer.valueOf(j));
    g.aAi();
    g.aAh().azQ().set(ar.a.NWW, Integer.valueOf(k));
    if (k == 1)
    {
      str1 = paramJSONObject.optString("set_sns_pay_title");
      paramJSONObject = paramJSONObject.optString("set_sns_pay_wording");
      g.aAi();
      g.aAh().azQ().set(ar.a.NWZ, str1);
      g.aAi();
      g.aAh().azQ().set(ar.a.NXa, paramJSONObject);
    }
    for (;;)
    {
      Log.i("MicroMsg.WalletNetSceneUtil", "set_sns_pay_title:" + str1 + ", set_sns_pay_wording:" + paramJSONObject);
      g.aAi();
      g.aAh().azQ().gBI();
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