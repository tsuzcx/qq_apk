package com.tencent.mm.plugin.wallet_core.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import org.json.JSONObject;

public final class b
{
  public static void aP(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(48007);
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.WalletNetSceneUtil", "parseLuckyMoneySnsPayData() json is null");
      AppMethodBeat.o(48007);
      return;
    }
    ab.i("MicroMsg.WalletNetSceneUtil", "parseLuckyMoneySnsPayData()");
    String str2 = "";
    String str1 = "";
    int i = paramJSONObject.optInt("is_open_sns_pay", 0);
    int j = paramJSONObject.optInt("can_open_sns_pay", 0);
    int k = paramJSONObject.optInt("is_white_user", 0);
    if (j == 1)
    {
      str2 = paramJSONObject.optString("open_sns_pay_title");
      str1 = paramJSONObject.optString("open_sns_pay_wording");
      g.RM();
      g.RL().Ru().set(ac.a.yBV, str2);
      g.RM();
      g.RL().Ru().set(ac.a.yBW, str1);
    }
    ab.i("MicroMsg.WalletNetSceneUtil", "is_open_sns_pay:" + i + ", can_open_sns_pay:" + j + ", is_white_user:" + k);
    ab.i("MicroMsg.WalletNetSceneUtil", "open_sns_pay_title:" + str2 + ", open_sns_pay_wording:" + str1);
    g.RM();
    g.RL().Ru().set(ac.a.yBS, Integer.valueOf(i));
    g.RM();
    g.RL().Ru().set(ac.a.yBT, Integer.valueOf(j));
    g.RM();
    g.RL().Ru().set(ac.a.yBU, Integer.valueOf(k));
    if (k == 1)
    {
      str1 = paramJSONObject.optString("set_sns_pay_title");
      paramJSONObject = paramJSONObject.optString("set_sns_pay_wording");
      g.RM();
      g.RL().Ru().set(ac.a.yBX, str1);
      g.RM();
      g.RL().Ru().set(ac.a.yBY, paramJSONObject);
    }
    for (;;)
    {
      ab.i("MicroMsg.WalletNetSceneUtil", "set_sns_pay_title:" + str1 + ", set_sns_pay_wording:" + paramJSONObject);
      g.RM();
      g.RL().Ru().dww();
      AppMethodBeat.o(48007);
      return;
      paramJSONObject = "";
      str1 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.b
 * JD-Core Version:    0.7.0.1
 */