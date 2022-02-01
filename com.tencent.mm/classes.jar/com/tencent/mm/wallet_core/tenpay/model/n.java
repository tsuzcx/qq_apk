package com.tencent.mm.wallet_core.tenpay.model;

import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.id_verify.util.SetPwdInfo;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.e;
import com.tencent.mm.wallet_core.model.j;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public abstract class n
  extends p
  implements j
{
  private static int agUh = 0;
  public RealnameGuideHelper MyJ;
  private String MyK;
  private String MyL;
  private String MyM;
  private String MyN;
  private String MyO;
  public int VHg = 0;
  public String Vpz;
  protected Map<String, String> agUf = new HashMap();
  public int agUg = 0;
  private boolean agUi = false;
  public int agUj = 0;
  public int agUk = 0;
  public String agUl = null;
  public JSONObject agUm = null;
  private boolean agUn = false;
  public int agUo = -1;
  protected int igp;
  
  protected final void a(Orders paramOrders, Authen paramAuthen)
  {
    List localList = paramOrders.VGX;
    String str = null;
    if (localList.size() > 0) {
      str = ((Orders.Commodity)localList.get(0)).hAU;
    }
    b(paramOrders.hAT, str, paramAuthen.Nxi.hUR, paramAuthen.Nxi.channel, paramAuthen.hAk, paramAuthen.MDt);
  }
  
  protected final void b(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4)
  {
    agUh += 1;
    this.agUf.put("req_key", paramString1);
    this.agUf.put("transaction_id", paramString2);
    this.agUf.put("pay_scene", String.valueOf(paramInt1));
    this.agUf.put("bank_type", paramString3);
    this.agUf.put("channel", String.valueOf(paramInt2));
    this.agUf.put("bind_serial", paramString4);
  }
  
  public boolean canRetry()
  {
    return false;
  }
  
  public boolean ifV()
  {
    return false;
  }
  
  public final Map<String, String> jPi()
  {
    return this.agUf;
  }
  
  public final boolean jPj()
  {
    return this.agUg == 1;
  }
  
  public void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    if (!this.agUi)
    {
      this.agUk = paramInt;
      this.agUl = paramString;
      this.agUm = paramJSONObject;
      this.agUi = true;
      if (paramJSONObject != null) {
        this.agUg = paramJSONObject.optInt("query_order_flag", 0);
      }
    }
    Object localObject;
    if ((paramJSONObject != null) && (paramJSONObject.has("real_name_info")))
    {
      localObject = paramJSONObject.optJSONObject("real_name_info");
      this.MyK = ((JSONObject)localObject).optString("guide_flag");
      this.MyL = ((JSONObject)localObject).optString("guide_wording");
      this.MyM = ((JSONObject)localObject).optString("left_button_wording");
      this.MyN = ((JSONObject)localObject).optString("right_button_wording");
      this.MyO = ((JSONObject)localObject).optString("upload_credit_url");
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
          ((SetPwdInfo)localObject).KuO = localJSONObject.optString("guide_wording");
          ((SetPwdInfo)localObject).rGU = localJSONObject.optString("left_button_wording");
          ((SetPwdInfo)localObject).right_button_wording = localJSONObject.optString("right_button_wording");
          ((SetPwdInfo)localObject).VCy = localJSONObject.optInt("send_pwd_msg");
          j = 1;
        }
      }
      if ((j != 0) && (("1".equals(this.MyK)) || ("2".equals(this.MyK)) || (localObject != null)))
      {
        this.MyJ = new RealnameGuideHelper();
        this.MyJ.a(this.MyK, (SetPwdInfo)localObject, this.MyL, this.MyM, this.MyN, this.MyO, this.igp);
      }
      this.Vpz = paramJSONObject.optString("forget_pwd_url", "");
      this.agUo = paramJSONObject.optInt("is_clear_failure", -1);
      Log.i("MicroMsg.NetSceneTenpayDelayQueryBase", "forget_pwd_url %s", new Object[] { this.Vpz });
      this.agUn = true;
      super.onGYNetEnd(paramInt, paramString, paramJSONObject);
      return;
    }
  }
  
  public void onGYNetEnd2(e parame, JSONObject paramJSONObject)
  {
    Log.i("MicroMsg.NetSceneTenpayDelayQueryBase", "always callback: %s,%s", new Object[] { Integer.valueOf(parame.errCode), parame.errMsg });
    super.onGYNetEnd2(parame, paramJSONObject);
    if ((!this.agUn) && (!this.agUi))
    {
      this.agUj = parame.errType;
      this.agUk = parame.errCode;
      this.agUl = parame.errMsg;
      if (paramJSONObject != null)
      {
        this.agUg = paramJSONObject.optInt("query_order_flag", 0);
        this.agUm = paramJSONObject;
      }
      this.agUi = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.tenpay.model.n
 * JD-Core Version:    0.7.0.1
 */