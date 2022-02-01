package com.tencent.mm.plugin.wallet_core.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import org.json.JSONObject;

public final class l
{
  public static void cD(JSONObject paramJSONObject)
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
      h.baF();
      h.baE().ban().set(at.a.acMr, str2);
      h.baF();
      h.baE().ban().set(at.a.acMs, str1);
    }
    Log.i("MicroMsg.WalletNetSceneUtil", "is_open_sns_pay:" + i + ", can_open_sns_pay:" + j + ", is_white_user:" + k);
    Log.i("MicroMsg.WalletNetSceneUtil", "open_sns_pay_title:" + str2 + ", open_sns_pay_wording:" + str1);
    h.baF();
    h.baE().ban().set(at.a.acMo, Integer.valueOf(i));
    h.baF();
    h.baE().ban().set(at.a.acMp, Integer.valueOf(j));
    h.baF();
    h.baE().ban().set(at.a.acMq, Integer.valueOf(k));
    if (k == 1)
    {
      str1 = paramJSONObject.optString("set_sns_pay_title");
      paramJSONObject = paramJSONObject.optString("set_sns_pay_wording");
      h.baF();
      h.baE().ban().set(at.a.acMt, str1);
      h.baF();
      h.baE().ban().set(at.a.acMu, paramJSONObject);
    }
    for (;;)
    {
      Log.i("MicroMsg.WalletNetSceneUtil", "set_sns_pay_title:" + str1 + ", set_sns_pay_wording:" + paramJSONObject);
      h.baF();
      h.baE().ban().iZy();
      AppMethodBeat.o(71641);
      return;
      paramJSONObject = "";
      str1 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.l
 * JD-Core Version:    0.7.0.1
 */