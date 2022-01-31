package com.tencent.mm.wallet_core.tenpay.model;

import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.id_verify.util.SetPwdInfo;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.d;
import com.tencent.mm.wallet_core.c.i;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public abstract class n
  extends p
  implements i
{
  private static int AXR = 0;
  protected Map<String, String> AXP = new HashMap();
  public int AXQ = 0;
  private boolean AXS = false;
  public int AXT = 0;
  public int AXU = 0;
  public String AXV = null;
  public JSONObject AXW = null;
  private boolean AXX = false;
  public int AXY = -1;
  protected int cLI;
  public RealnameGuideHelper plg;
  private String plh;
  private String pli;
  private String plj;
  private String plk;
  private String pll;
  public String tYb;
  public int uju = 0;
  
  protected final void a(Orders paramOrders, Authen paramAuthen)
  {
    List localList = paramOrders.ujl;
    String str = null;
    if (localList.size() > 0) {
      str = ((Orders.Commodity)localList.get(0)).cnJ;
    }
    b(paramOrders.cnI, str, paramAuthen.pVo.cCD, paramAuthen.pVo.cCy, paramAuthen.poq, paramAuthen.por);
  }
  
  protected final void b(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4)
  {
    AXR += 1;
    this.AXP.put("req_key", paramString1);
    this.AXP.put("transaction_id", paramString2);
    this.AXP.put("pay_scene", String.valueOf(paramInt1));
    this.AXP.put("bank_type", paramString3);
    this.AXP.put("channel", String.valueOf(paramInt2));
    this.AXP.put("bind_serial", paramString4);
  }
  
  public boolean cRN()
  {
    return false;
  }
  
  public boolean canRetry()
  {
    return false;
  }
  
  public final Map<String, String> dSL()
  {
    return this.AXP;
  }
  
  public final boolean dSM()
  {
    return this.AXQ == 1;
  }
  
  public void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    if (!this.AXS)
    {
      this.AXU = paramInt;
      this.AXV = paramString;
      this.AXW = paramJSONObject;
      this.AXS = true;
      if (paramJSONObject != null) {
        this.AXQ = paramJSONObject.optInt("query_order_flag", 0);
      }
    }
    Object localObject;
    if ((paramJSONObject != null) && (paramJSONObject.has("real_name_info")))
    {
      localObject = paramJSONObject.optJSONObject("real_name_info");
      this.plh = ((JSONObject)localObject).optString("guide_flag");
      this.pli = ((JSONObject)localObject).optString("guide_wording");
      this.plj = ((JSONObject)localObject).optString("left_button_wording");
      this.plk = ((JSONObject)localObject).optString("right_button_wording");
      this.pll = ((JSONObject)localObject).optString("upload_credit_url");
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
          ((SetPwdInfo)localObject).opB = localJSONObject.optString("guide_wording");
          ((SetPwdInfo)localObject).opC = localJSONObject.optString("left_button_wording");
          ((SetPwdInfo)localObject).opD = localJSONObject.optString("right_button_wording");
          ((SetPwdInfo)localObject).ueS = localJSONObject.optInt("send_pwd_msg");
          j = 1;
        }
      }
      if ((j != 0) && (("1".equals(this.plh)) || ("2".equals(this.plh)) || (localObject != null)))
      {
        this.plg = new RealnameGuideHelper();
        this.plg.a(this.plh, (SetPwdInfo)localObject, this.pli, this.plj, this.plk, this.pll, this.cLI);
      }
      this.tYb = paramJSONObject.optString("forget_pwd_url", "");
      this.AXY = paramJSONObject.optInt("is_clear_failure", -1);
      ab.i("MicroMsg.NetSceneTenpayDelayQueryBase", "forget_pwd_url %s", new Object[] { this.tYb });
      this.AXX = true;
      super.onGYNetEnd(paramInt, paramString, paramJSONObject);
      return;
    }
  }
  
  public void onGYNetEnd2(d paramd, JSONObject paramJSONObject)
  {
    ab.i("MicroMsg.NetSceneTenpayDelayQueryBase", "always callback: %s,%s", new Object[] { Integer.valueOf(paramd.errCode), paramd.errMsg });
    super.onGYNetEnd2(paramd, paramJSONObject);
    if ((!this.AXX) && (!this.AXS))
    {
      this.AXT = paramd.errType;
      this.AXU = paramd.errCode;
      this.AXV = paramd.errMsg;
      if (paramJSONObject != null)
      {
        this.AXQ = paramJSONObject.optInt("query_order_flag", 0);
        this.AXW = paramJSONObject;
      }
      this.AXS = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.tenpay.model.n
 * JD-Core Version:    0.7.0.1
 */