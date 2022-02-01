package com.tencent.mm.wallet_core.tenpay.model;

import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.id_verify.util.SetPwdInfo;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ae;
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
  private static int LVZ = 0;
  public String DcG;
  public int DpY = 0;
  protected Map<String, String> LVX = new HashMap();
  public int LVY = 0;
  private boolean LWa = false;
  public int LWb = 0;
  public int LWc = 0;
  public String LWd = null;
  public JSONObject LWe = null;
  private boolean LWf = false;
  public int LWg = -1;
  protected int dNV;
  public RealnameGuideHelper wNL;
  private String wNM;
  private String wNN;
  private String wNO;
  private String wNP;
  private String wNQ;
  
  protected final void a(Orders paramOrders, Authen paramAuthen)
  {
    List localList = paramOrders.DpP;
    String str = null;
    if (localList.size() > 0) {
      str = ((Orders.Commodity)localList.get(0)).dmx;
    }
    b(paramOrders.dmw, str, paramAuthen.xDC.dDH, paramAuthen.xDC.channel, paramAuthen.dlT, paramAuthen.wRt);
  }
  
  protected final void b(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4)
  {
    LVZ += 1;
    this.LVX.put("req_key", paramString1);
    this.LVX.put("transaction_id", paramString2);
    this.LVX.put("pay_scene", String.valueOf(paramInt1));
    this.LVX.put("bank_type", paramString3);
    this.LVX.put("channel", String.valueOf(paramInt2));
    this.LVX.put("bind_serial", paramString4);
  }
  
  public boolean canRetry()
  {
    return false;
  }
  
  public boolean eHd()
  {
    return false;
  }
  
  public final Map<String, String> fWo()
  {
    return this.LVX;
  }
  
  public final boolean fWp()
  {
    return this.LVY == 1;
  }
  
  public void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    if (!this.LWa)
    {
      this.LWc = paramInt;
      this.LWd = paramString;
      this.LWe = paramJSONObject;
      this.LWa = true;
      if (paramJSONObject != null) {
        this.LVY = paramJSONObject.optInt("query_order_flag", 0);
      }
    }
    Object localObject;
    if ((paramJSONObject != null) && (paramJSONObject.has("real_name_info")))
    {
      localObject = paramJSONObject.optJSONObject("real_name_info");
      this.wNM = ((JSONObject)localObject).optString("guide_flag");
      this.wNN = ((JSONObject)localObject).optString("guide_wording");
      this.wNO = ((JSONObject)localObject).optString("left_button_wording");
      this.wNP = ((JSONObject)localObject).optString("right_button_wording");
      this.wNQ = ((JSONObject)localObject).optString("upload_credit_url");
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
          ((SetPwdInfo)localObject).vCG = localJSONObject.optString("guide_wording");
          ((SetPwdInfo)localObject).kCZ = localJSONObject.optString("left_button_wording");
          ((SetPwdInfo)localObject).kDa = localJSONObject.optString("right_button_wording");
          ((SetPwdInfo)localObject).Dlt = localJSONObject.optInt("send_pwd_msg");
          j = 1;
        }
      }
      if ((j != 0) && (("1".equals(this.wNM)) || ("2".equals(this.wNM)) || (localObject != null)))
      {
        this.wNL = new RealnameGuideHelper();
        this.wNL.a(this.wNM, (SetPwdInfo)localObject, this.wNN, this.wNO, this.wNP, this.wNQ, this.dNV);
      }
      this.DcG = paramJSONObject.optString("forget_pwd_url", "");
      this.LWg = paramJSONObject.optInt("is_clear_failure", -1);
      ae.i("MicroMsg.NetSceneTenpayDelayQueryBase", "forget_pwd_url %s", new Object[] { this.DcG });
      this.LWf = true;
      super.onGYNetEnd(paramInt, paramString, paramJSONObject);
      return;
    }
  }
  
  public void onGYNetEnd2(e parame, JSONObject paramJSONObject)
  {
    ae.i("MicroMsg.NetSceneTenpayDelayQueryBase", "always callback: %s,%s", new Object[] { Integer.valueOf(parame.errCode), parame.errMsg });
    super.onGYNetEnd2(parame, paramJSONObject);
    if ((!this.LWf) && (!this.LWa))
    {
      this.LWb = parame.errType;
      this.LWc = parame.errCode;
      this.LWd = parame.errMsg;
      if (paramJSONObject != null)
      {
        this.LVY = paramJSONObject.optInt("query_order_flag", 0);
        this.LWe = paramJSONObject;
      }
      this.LWa = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.tenpay.model.n
 * JD-Core Version:    0.7.0.1
 */