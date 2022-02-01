package com.tencent.mm.wallet_core.tenpay.model;

import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.id_verify.util.SetPwdInfo;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.e;
import com.tencent.mm.wallet_core.c.j;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public abstract class n
  extends p
  implements j
{
  private static int RuP = 0;
  public RealnameGuideHelper AJr;
  private String AJs;
  private String AJt;
  private String AJu;
  private String AJv;
  private String AJw;
  public String HIu;
  public int HZm = 0;
  protected Map<String, String> RuN = new HashMap();
  public int RuO = 0;
  private boolean RuQ = false;
  public int RuR = 0;
  public int RuS = 0;
  public String RuT = null;
  public JSONObject RuU = null;
  private boolean RuV = false;
  public int RuW = -1;
  protected int efQ;
  
  protected final void a(Orders paramOrders, Authen paramAuthen)
  {
    List localList = paramOrders.HZd;
    String str = null;
    if (localList.size() > 0) {
      str = ((Orders.Commodity)localList.get(0)).dDM;
    }
    b(paramOrders.dDL, str, paramAuthen.BDB.dVv, paramAuthen.BDB.channel, paramAuthen.dDj, paramAuthen.ANo);
  }
  
  protected final void b(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4)
  {
    RuP += 1;
    this.RuN.put("req_key", paramString1);
    this.RuN.put("transaction_id", paramString2);
    this.RuN.put("pay_scene", String.valueOf(paramInt1));
    this.RuN.put("bank_type", paramString3);
    this.RuN.put("channel", String.valueOf(paramInt2));
    this.RuN.put("bind_serial", paramString4);
  }
  
  public boolean canRetry()
  {
    return false;
  }
  
  public boolean fOn()
  {
    return false;
  }
  
  public final Map<String, String> hhM()
  {
    return this.RuN;
  }
  
  public final boolean hhN()
  {
    return this.RuO == 1;
  }
  
  public void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    if (!this.RuQ)
    {
      this.RuS = paramInt;
      this.RuT = paramString;
      this.RuU = paramJSONObject;
      this.RuQ = true;
      if (paramJSONObject != null) {
        this.RuO = paramJSONObject.optInt("query_order_flag", 0);
      }
    }
    Object localObject;
    if ((paramJSONObject != null) && (paramJSONObject.has("real_name_info")))
    {
      localObject = paramJSONObject.optJSONObject("real_name_info");
      this.AJs = ((JSONObject)localObject).optString("guide_flag");
      this.AJt = ((JSONObject)localObject).optString("guide_wording");
      this.AJu = ((JSONObject)localObject).optString("left_button_wording");
      this.AJv = ((JSONObject)localObject).optString("right_button_wording");
      this.AJw = ((JSONObject)localObject).optString("upload_credit_url");
    }
    for (int i = 1;; i = 0)
    {
      JSONObject localJSONObject = null;
      int j = i;
      localObject = localJSONObject;
      if (paramJSONObject != null)
      {
        j = i;
        localObject = localJSONObject;
        if (paramJSONObject.has("set_pwd_info"))
        {
          localJSONObject = paramJSONObject.optJSONObject("set_pwd_info");
          localObject = new SetPwdInfo();
          ((SetPwdInfo)localObject).yXJ = localJSONObject.optString("guide_wording");
          ((SetPwdInfo)localObject).lHA = localJSONObject.optString("left_button_wording");
          ((SetPwdInfo)localObject).lHB = localJSONObject.optString("right_button_wording");
          ((SetPwdInfo)localObject).HUM = localJSONObject.optInt("send_pwd_msg");
          j = 1;
        }
      }
      if ((j != 0) && (("1".equals(this.AJs)) || ("2".equals(this.AJs)) || (localObject != null)))
      {
        this.AJr = new RealnameGuideHelper();
        this.AJr.a(this.AJs, (SetPwdInfo)localObject, this.AJt, this.AJu, this.AJv, this.AJw, this.efQ);
      }
      this.HIu = paramJSONObject.optString("forget_pwd_url", "");
      this.RuW = paramJSONObject.optInt("is_clear_failure", -1);
      Log.i("MicroMsg.NetSceneTenpayDelayQueryBase", "forget_pwd_url %s", new Object[] { this.HIu });
      this.RuV = true;
      super.onGYNetEnd(paramInt, paramString, paramJSONObject);
      return;
    }
  }
  
  public void onGYNetEnd2(e parame, JSONObject paramJSONObject)
  {
    Log.i("MicroMsg.NetSceneTenpayDelayQueryBase", "always callback: %s,%s", new Object[] { Integer.valueOf(parame.errCode), parame.errMsg });
    super.onGYNetEnd2(parame, paramJSONObject);
    if ((!this.RuV) && (!this.RuQ))
    {
      this.RuR = parame.errType;
      this.RuS = parame.errCode;
      this.RuT = parame.errMsg;
      if (paramJSONObject != null)
      {
        this.RuO = paramJSONObject.optInt("query_order_flag", 0);
        this.RuU = paramJSONObject;
      }
      this.RuQ = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.tenpay.model.n
 * JD-Core Version:    0.7.0.1
 */