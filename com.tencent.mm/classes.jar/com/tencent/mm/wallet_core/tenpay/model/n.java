package com.tencent.mm.wallet_core.tenpay.model;

import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.id_verify.util.SetPwdInfo;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ad;
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
  private static int IeE = 0;
  public int AfG = 0;
  protected Map<String, String> IeC = new HashMap();
  public int IeD = 0;
  private boolean IeF = false;
  public int IeG = 0;
  public int IeH = 0;
  public String IeI = null;
  public JSONObject IeJ = null;
  private boolean IeK = false;
  public int IeL = -1;
  protected int dCG;
  public RealnameGuideHelper ujM;
  private String ujN;
  private String ujO;
  private String ujP;
  private String ujQ;
  private String ujR;
  public String zSs;
  
  protected final void a(Orders paramOrders, Authen paramAuthen)
  {
    List localList = paramOrders.Afx;
    String str = null;
    if (localList.size() > 0) {
      str = ((Orders.Commodity)localList.get(0)).dcF;
    }
    c(paramOrders.dcE, str, paramAuthen.uXi.dtb, paramAuthen.uXi.channel, paramAuthen.dca, paramAuthen.uns);
  }
  
  protected final void c(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4)
  {
    IeE += 1;
    this.IeC.put("req_key", paramString1);
    this.IeC.put("transaction_id", paramString2);
    this.IeC.put("pay_scene", String.valueOf(paramInt1));
    this.IeC.put("bank_type", paramString3);
    this.IeC.put("channel", String.valueOf(paramInt2));
    this.IeC.put("bind_serial", paramString4);
  }
  
  public boolean canRetry()
  {
    return false;
  }
  
  public boolean eaa()
  {
    return false;
  }
  
  public final Map<String, String> fks()
  {
    return this.IeC;
  }
  
  public final boolean fkt()
  {
    return this.IeD == 1;
  }
  
  public void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    if (!this.IeF)
    {
      this.IeH = paramInt;
      this.IeI = paramString;
      this.IeJ = paramJSONObject;
      this.IeF = true;
      if (paramJSONObject != null) {
        this.IeD = paramJSONObject.optInt("query_order_flag", 0);
      }
    }
    Object localObject;
    if ((paramJSONObject != null) && (paramJSONObject.has("real_name_info")))
    {
      localObject = paramJSONObject.optJSONObject("real_name_info");
      this.ujN = ((JSONObject)localObject).optString("guide_flag");
      this.ujO = ((JSONObject)localObject).optString("guide_wording");
      this.ujP = ((JSONObject)localObject).optString("left_button_wording");
      this.ujQ = ((JSONObject)localObject).optString("right_button_wording");
      this.ujR = ((JSONObject)localObject).optString("upload_credit_url");
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
          ((SetPwdInfo)localObject).tfG = localJSONObject.optString("guide_wording");
          ((SetPwdInfo)localObject).tfH = localJSONObject.optString("left_button_wording");
          ((SetPwdInfo)localObject).tfI = localJSONObject.optString("right_button_wording");
          ((SetPwdInfo)localObject).Abe = localJSONObject.optInt("send_pwd_msg");
          j = 1;
        }
      }
      if ((j != 0) && (("1".equals(this.ujN)) || ("2".equals(this.ujN)) || (localObject != null)))
      {
        this.ujM = new RealnameGuideHelper();
        this.ujM.a(this.ujN, (SetPwdInfo)localObject, this.ujO, this.ujP, this.ujQ, this.ujR, this.dCG);
      }
      this.zSs = paramJSONObject.optString("forget_pwd_url", "");
      this.IeL = paramJSONObject.optInt("is_clear_failure", -1);
      ad.i("MicroMsg.NetSceneTenpayDelayQueryBase", "forget_pwd_url %s", new Object[] { this.zSs });
      this.IeK = true;
      super.onGYNetEnd(paramInt, paramString, paramJSONObject);
      return;
    }
  }
  
  public void onGYNetEnd2(e parame, JSONObject paramJSONObject)
  {
    ad.i("MicroMsg.NetSceneTenpayDelayQueryBase", "always callback: %s,%s", new Object[] { Integer.valueOf(parame.errCode), parame.errMsg });
    super.onGYNetEnd2(parame, paramJSONObject);
    if ((!this.IeK) && (!this.IeF))
    {
      this.IeG = parame.errType;
      this.IeH = parame.errCode;
      this.IeI = parame.errMsg;
      if (paramJSONObject != null)
      {
        this.IeD = paramJSONObject.optInt("query_order_flag", 0);
        this.IeJ = paramJSONObject;
      }
      this.IeF = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.tenpay.model.n
 * JD-Core Version:    0.7.0.1
 */