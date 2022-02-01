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
  private static int YWn = 0;
  private String GCA;
  private String GCB;
  private String GCC;
  private String GCD;
  public RealnameGuideHelper GCy;
  private String GCz;
  public String OAm;
  public int ORm = 0;
  protected Map<String, String> YWl = new HashMap();
  public int YWm = 0;
  private boolean YWo = false;
  public int YWp = 0;
  public int YWq = 0;
  public String YWr = null;
  public JSONObject YWs = null;
  private boolean YWt = false;
  public int YWu = -1;
  protected int gag;
  
  protected final void a(Orders paramOrders, Authen paramAuthen)
  {
    List localList = paramOrders.ORd;
    String str = null;
    if (localList.size() > 0) {
      str = ((Orders.Commodity)localList.get(0)).fww;
    }
    b(paramOrders.fwv, str, paramAuthen.HzF.fOY, paramAuthen.HzF.channel, paramAuthen.fvP, paramAuthen.GGC);
  }
  
  protected final void b(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4)
  {
    YWn += 1;
    this.YWl.put("req_key", paramString1);
    this.YWl.put("transaction_id", paramString2);
    this.YWl.put("pay_scene", String.valueOf(paramInt1));
    this.YWl.put("bank_type", paramString3);
    this.YWl.put("channel", String.valueOf(paramInt2));
    this.YWl.put("bind_serial", paramString4);
  }
  
  public boolean canRetry()
  {
    return false;
  }
  
  public boolean gGS()
  {
    return false;
  }
  
  public final Map<String, String> ijn()
  {
    return this.YWl;
  }
  
  public final boolean ijo()
  {
    return this.YWm == 1;
  }
  
  public void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    if (!this.YWo)
    {
      this.YWq = paramInt;
      this.YWr = paramString;
      this.YWs = paramJSONObject;
      this.YWo = true;
      if (paramJSONObject != null) {
        this.YWm = paramJSONObject.optInt("query_order_flag", 0);
      }
    }
    Object localObject;
    if ((paramJSONObject != null) && (paramJSONObject.has("real_name_info")))
    {
      localObject = paramJSONObject.optJSONObject("real_name_info");
      this.GCz = ((JSONObject)localObject).optString("guide_flag");
      this.GCA = ((JSONObject)localObject).optString("guide_wording");
      this.GCB = ((JSONObject)localObject).optString("left_button_wording");
      this.GCC = ((JSONObject)localObject).optString("right_button_wording");
      this.GCD = ((JSONObject)localObject).optString("upload_credit_url");
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
          ((SetPwdInfo)localObject).EBN = localJSONObject.optString("guide_wording");
          ((SetPwdInfo)localObject).oDJ = localJSONObject.optString("left_button_wording");
          ((SetPwdInfo)localObject).oDK = localJSONObject.optString("right_button_wording");
          ((SetPwdInfo)localObject).OMN = localJSONObject.optInt("send_pwd_msg");
          j = 1;
        }
      }
      if ((j != 0) && (("1".equals(this.GCz)) || ("2".equals(this.GCz)) || (localObject != null)))
      {
        this.GCy = new RealnameGuideHelper();
        this.GCy.a(this.GCz, (SetPwdInfo)localObject, this.GCA, this.GCB, this.GCC, this.GCD, this.gag);
      }
      this.OAm = paramJSONObject.optString("forget_pwd_url", "");
      this.YWu = paramJSONObject.optInt("is_clear_failure", -1);
      Log.i("MicroMsg.NetSceneTenpayDelayQueryBase", "forget_pwd_url %s", new Object[] { this.OAm });
      this.YWt = true;
      super.onGYNetEnd(paramInt, paramString, paramJSONObject);
      return;
    }
  }
  
  public void onGYNetEnd2(e parame, JSONObject paramJSONObject)
  {
    Log.i("MicroMsg.NetSceneTenpayDelayQueryBase", "always callback: %s,%s", new Object[] { Integer.valueOf(parame.errCode), parame.errMsg });
    super.onGYNetEnd2(parame, paramJSONObject);
    if ((!this.YWt) && (!this.YWo))
    {
      this.YWp = parame.errType;
      this.YWq = parame.errCode;
      this.YWr = parame.errMsg;
      if (paramJSONObject != null)
      {
        this.YWm = paramJSONObject.optInt("query_order_flag", 0);
        this.YWs = paramJSONObject;
      }
      this.YWo = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.tenpay.model.n
 * JD-Core Version:    0.7.0.1
 */