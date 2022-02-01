package com.tencent.mm.wallet_core.tenpay.model;

import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.id_verify.util.SetPwdInfo;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ac;
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
  private static int JGg = 0;
  public String BkM;
  public int Bya = 0;
  protected Map<String, String> JGe = new HashMap();
  public int JGf = 0;
  private boolean JGh = false;
  public int JGi = 0;
  public int JGj = 0;
  public String JGk = null;
  public JSONObject JGl = null;
  private boolean JGm = false;
  public int JGn = -1;
  protected int dAs;
  public RealnameGuideHelper vsI;
  private String vsJ;
  private String vsK;
  private String vsL;
  private String vsM;
  private String vsN;
  
  protected final void a(Orders paramOrders, Authen paramAuthen)
  {
    List localList = paramOrders.BxR;
    String str = null;
    if (localList.size() > 0) {
      str = ((Orders.Commodity)localList.get(0)).dad;
    }
    c(paramOrders.dac, str, paramAuthen.wfX.dqL, paramAuthen.wfX.channel, paramAuthen.cZz, paramAuthen.vwo);
  }
  
  protected final void c(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4)
  {
    JGg += 1;
    this.JGe.put("req_key", paramString1);
    this.JGe.put("transaction_id", paramString2);
    this.JGe.put("pay_scene", String.valueOf(paramInt1));
    this.JGe.put("bank_type", paramString3);
    this.JGe.put("channel", String.valueOf(paramInt2));
    this.JGe.put("bind_serial", paramString4);
  }
  
  public boolean canRetry()
  {
    return false;
  }
  
  public boolean epw()
  {
    return false;
  }
  
  public final Map<String, String> fAI()
  {
    return this.JGe;
  }
  
  public final boolean fAJ()
  {
    return this.JGf == 1;
  }
  
  public void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    if (!this.JGh)
    {
      this.JGj = paramInt;
      this.JGk = paramString;
      this.JGl = paramJSONObject;
      this.JGh = true;
      if (paramJSONObject != null) {
        this.JGf = paramJSONObject.optInt("query_order_flag", 0);
      }
    }
    Object localObject;
    if ((paramJSONObject != null) && (paramJSONObject.has("real_name_info")))
    {
      localObject = paramJSONObject.optJSONObject("real_name_info");
      this.vsJ = ((JSONObject)localObject).optString("guide_flag");
      this.vsK = ((JSONObject)localObject).optString("guide_wording");
      this.vsL = ((JSONObject)localObject).optString("left_button_wording");
      this.vsM = ((JSONObject)localObject).optString("right_button_wording");
      this.vsN = ((JSONObject)localObject).optString("upload_credit_url");
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
          ((SetPwdInfo)localObject).unV = localJSONObject.optString("guide_wording");
          ((SetPwdInfo)localObject).unW = localJSONObject.optString("left_button_wording");
          ((SetPwdInfo)localObject).unX = localJSONObject.optString("right_button_wording");
          ((SetPwdInfo)localObject).Bty = localJSONObject.optInt("send_pwd_msg");
          j = 1;
        }
      }
      if ((j != 0) && (("1".equals(this.vsJ)) || ("2".equals(this.vsJ)) || (localObject != null)))
      {
        this.vsI = new RealnameGuideHelper();
        this.vsI.a(this.vsJ, (SetPwdInfo)localObject, this.vsK, this.vsL, this.vsM, this.vsN, this.dAs);
      }
      this.BkM = paramJSONObject.optString("forget_pwd_url", "");
      this.JGn = paramJSONObject.optInt("is_clear_failure", -1);
      ac.i("MicroMsg.NetSceneTenpayDelayQueryBase", "forget_pwd_url %s", new Object[] { this.BkM });
      this.JGm = true;
      super.onGYNetEnd(paramInt, paramString, paramJSONObject);
      return;
    }
  }
  
  public void onGYNetEnd2(e parame, JSONObject paramJSONObject)
  {
    ac.i("MicroMsg.NetSceneTenpayDelayQueryBase", "always callback: %s,%s", new Object[] { Integer.valueOf(parame.errCode), parame.errMsg });
    super.onGYNetEnd2(parame, paramJSONObject);
    if ((!this.JGm) && (!this.JGh))
    {
      this.JGi = parame.errType;
      this.JGj = parame.errCode;
      this.JGk = parame.errMsg;
      if (paramJSONObject != null)
      {
        this.JGf = paramJSONObject.optInt("query_order_flag", 0);
        this.JGl = paramJSONObject;
      }
      this.JGh = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.tenpay.model.n
 * JD-Core Version:    0.7.0.1
 */