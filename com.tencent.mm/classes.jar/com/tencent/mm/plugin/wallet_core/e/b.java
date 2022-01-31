package com.tencent.mm.plugin.wallet_core.e;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import org.json.JSONObject;

public final class b
{
  public static void aw(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.WalletNetSceneUtil", "parseLuckyMoneySnsPayData() json is null");
      return;
    }
    y.i("MicroMsg.WalletNetSceneUtil", "parseLuckyMoneySnsPayData()");
    String str2 = "";
    String str1 = "";
    int i = paramJSONObject.optInt("is_open_sns_pay", 0);
    int j = paramJSONObject.optInt("can_open_sns_pay", 0);
    int k = paramJSONObject.optInt("is_white_user", 0);
    if (j == 1)
    {
      str2 = paramJSONObject.optString("open_sns_pay_title");
      str1 = paramJSONObject.optString("open_sns_pay_wording");
      g.DQ();
      g.DP().Dz().c(ac.a.urV, str2);
      g.DQ();
      g.DP().Dz().c(ac.a.urW, str1);
    }
    y.i("MicroMsg.WalletNetSceneUtil", "is_open_sns_pay:" + i + ", can_open_sns_pay:" + j + ", is_white_user:" + k);
    y.i("MicroMsg.WalletNetSceneUtil", "open_sns_pay_title:" + str2 + ", open_sns_pay_wording:" + str1);
    g.DQ();
    g.DP().Dz().c(ac.a.urS, Integer.valueOf(i));
    g.DQ();
    g.DP().Dz().c(ac.a.urT, Integer.valueOf(j));
    g.DQ();
    g.DP().Dz().c(ac.a.urU, Integer.valueOf(k));
    if (k == 1)
    {
      str1 = paramJSONObject.optString("set_sns_pay_title");
      paramJSONObject = paramJSONObject.optString("set_sns_pay_wording");
      g.DQ();
      g.DP().Dz().c(ac.a.urX, str1);
      g.DQ();
      g.DP().Dz().c(ac.a.urY, paramJSONObject);
    }
    for (;;)
    {
      y.i("MicroMsg.WalletNetSceneUtil", "set_sns_pay_title:" + str1 + ", set_sns_pay_wording:" + paramJSONObject);
      g.DQ();
      g.DP().Dz().mC(true);
      return;
      paramJSONObject = "";
      str1 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.e.b
 * JD-Core Version:    0.7.0.1
 */