package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpaysdk.api.ResendMsgInfo;
import com.tencent.mm.protocal.protobuf.dus;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import com.tencent.mm.wallet_core.ui.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ah
  extends m
{
  public boolean JCS;
  public ArrayList<e> Kvc;
  public String MEM;
  public int MEW;
  public String MEq;
  public String OkA;
  public int OkB;
  public a OkC;
  public c OkD;
  public e OkE;
  public ResendMsgInfo OkF;
  private e OkG;
  public ArrayList<ah.b> OkH;
  public int OkI;
  private String OkJ;
  private String OkK;
  private String Oks;
  public String Okt;
  public int Oku;
  public String Okv;
  private String Okw;
  public String Okx;
  public int Oky;
  public String Okz;
  public String desc;
  public dus pGr;
  public int status;
  public double wZe;
  
  public ah(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(288806);
    this.Oks = null;
    this.Okt = null;
    this.Oks = paramString1;
    this.Okt = paramString2;
    this.MEW = paramInt1;
    HashMap localHashMap = new HashMap();
    localHashMap.put("transfer_id", paramString2);
    localHashMap.put("trans_id", paramString1);
    localHashMap.put("invalid_time", String.valueOf(paramInt2));
    localHashMap.put("group_username", paramString3);
    setRequestData(localHashMap);
    AppMethodBeat.o(288806);
  }
  
  private static ArrayList<e> F(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(288818);
    JSONArray localJSONArray = paramJSONArray;
    if (paramJSONArray == null) {
      localJSONArray = new JSONArray();
    }
    Log.i("Micromsg.NetSceneTenpayRemittanceQuery", "parseOptionItemList res：%s", new Object[] { localJSONArray.toString() });
    paramJSONArray = new ArrayList();
    int i = 0;
    try
    {
      while (i < localJSONArray.length())
      {
        JSONObject localJSONObject = localJSONArray.getJSONObject(i);
        if (localJSONObject != null) {
          paramJSONArray.add(bL(localJSONObject));
        }
        i += 1;
      }
      return paramJSONArray;
    }
    catch (JSONException localJSONException)
    {
      Log.i("Micromsg.NetSceneTenpayRemittanceQuery", "parseOptionItemList error：%s", new Object[] { localJSONException.getMessage() });
      AppMethodBeat.o(288818);
    }
  }
  
  private static ArrayList<ah.b> L(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(288814);
    JSONArray localJSONArray = paramJSONArray;
    if (paramJSONArray == null) {
      localJSONArray = new JSONArray();
    }
    Log.i("Micromsg.NetSceneTenpayRemittanceQuery", "parseDescItemList res：%s", new Object[] { localJSONArray.toString() });
    paramJSONArray = new ArrayList();
    int i = 0;
    try
    {
      while (i < localJSONArray.length())
      {
        JSONObject localJSONObject = localJSONArray.getJSONObject(i);
        if (localJSONObject != null)
        {
          ah.b localb = new ah.b();
          localb.title = localJSONObject.optString("key");
          localb.content = localJSONObject.optString("value");
          paramJSONArray.add(localb);
        }
        i += 1;
      }
      return paramJSONArray;
    }
    catch (JSONException localJSONException)
    {
      Log.i("Micromsg.NetSceneTenpayRemittanceQuery", "parseDescItemList error：%s", new Object[] { localJSONException.getMessage() });
      AppMethodBeat.o(288814);
    }
  }
  
  private static d bK(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(67895);
    d locald = new d();
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    locald.type = localJSONObject.optInt("type");
    locald.url = localJSONObject.optString("url");
    locald.username = localJSONObject.optString("username");
    locald.OkP = localJSONObject.optString("pagepath");
    AppMethodBeat.o(67895);
    return locald;
  }
  
  private static e bL(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(67896);
    e locale = new e();
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    locale.wording = localJSONObject.optString("wording");
    locale.OkO = bK(localJSONObject.optJSONObject("jump_info"));
    AppMethodBeat.o(67896);
    return locale;
  }
  
  public final int getFuncId()
  {
    return 1628;
  }
  
  public final int getTenpayCgicmd()
  {
    return 0;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/transferquery";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(67894);
    Log.d("Micromsg.NetSceneTenpayRemittanceQuery", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      AppMethodBeat.o(67894);
      return;
    }
    this.Oku = paramJSONObject.optInt("pay_time");
    this.wZe = (paramJSONObject.optDouble("fee") / 100.0D);
    this.MEq = paramJSONObject.optString("fee_type");
    this.status = paramJSONObject.optInt("trans_status");
    this.Okw = paramJSONObject.optString("trans_status_name");
    this.Oky = paramJSONObject.optInt("modify_time");
    this.Okx = paramJSONObject.optString("payer_name");
    this.Okv = paramJSONObject.optString("receiver_name");
    this.JCS = paramJSONObject.optBoolean("is_payer");
    this.MEM = paramJSONObject.optString("refund_bank_type");
    this.Okz = paramJSONObject.optString("status_desc");
    this.OkA = paramJSONObject.optString("status_supplementary");
    this.OkB = paramJSONObject.optInt("delay_confirm_flag");
    this.OkJ = paramJSONObject.optString("banner_content");
    this.OkK = paramJSONObject.optString("banner_url");
    this.desc = paramJSONObject.optString("desc");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("addr_info");
    Object localObject = new a();
    paramString = localJSONObject;
    if (localJSONObject == null) {
      paramString = new JSONObject();
    }
    ((a)localObject).OkL = paramString.optString("address_name");
    ((a)localObject).pWt = paramString.optString("phone_num");
    ((a)localObject).oDI = paramString.optString("address");
    this.OkC = ((a)localObject);
    localJSONObject = paramJSONObject.optJSONObject("exposure_info");
    localObject = new c();
    paramString = localJSONObject;
    if (localJSONObject == null) {
      paramString = new JSONObject();
    }
    ((c)localObject).icon = paramString.optString("icon");
    ((c)localObject).name = paramString.optString("name");
    ((c)localObject).wording = paramString.optString("wording");
    ((c)localObject).OkM = paramString.optInt("is_show_btn");
    ((c)localObject).OkN = paramString.optString("btn_wording");
    ((c)localObject).OkO = bK(paramString.optJSONObject("jump_info"));
    this.OkD = ((c)localObject);
    this.OkE = bL(paramJSONObject.optJSONObject("text_info"));
    localJSONObject = paramJSONObject.optJSONObject("resend_info");
    localObject = new ResendMsgInfo();
    paramString = localJSONObject;
    if (localJSONObject == null) {
      paramString = new JSONObject();
    }
    ((ResendMsgInfo)localObject).title = paramString.optString("title");
    ((ResendMsgInfo)localObject).XJO = paramString.optString("pic");
    ((ResendMsgInfo)localObject).description = paramString.optString("description");
    ((ResendMsgInfo)localObject).rGU = paramString.optString("left_button_wording");
    ((ResendMsgInfo)localObject).right_button_wording = paramString.optString("right_button_wording");
    this.OkF = ((ResendMsgInfo)localObject);
    this.OkG = bL(paramJSONObject.optJSONObject("middle_info"));
    this.OkH = L(paramJSONObject.optJSONArray("desc_item_list"));
    this.OkI = paramJSONObject.optInt("trade_mem_type", 0);
    this.Kvc = F(paramJSONObject.optJSONArray("upright_corner_list"));
    this.pGr = i.cR(paramJSONObject.optJSONObject("notice_item"));
    AppMethodBeat.o(67894);
  }
  
  public static final class a
  {
    public String OkL;
    public String oDI;
    public String pWt;
    
    public final String toString()
    {
      AppMethodBeat.i(67889);
      String str = "AddressInfo{addressName='" + this.OkL + '\'' + ", phoneNum='" + this.pWt + '\'' + ", address='" + this.oDI + '\'' + '}';
      AppMethodBeat.o(67889);
      return str;
    }
  }
  
  public static final class c
  {
    public int OkM;
    public String OkN;
    public ah.d OkO;
    public String icon;
    public String name;
    public String wording;
    
    public final String toString()
    {
      AppMethodBeat.i(67890);
      String str = "ExposureInfo{icon='" + this.icon + '\'' + ", name='" + this.name + '\'' + ", wording='" + this.wording + '\'' + ", isShowBtn=" + this.OkM + ", btnWording='" + this.OkN + '\'' + ", jumpInfo=" + this.OkO + '}';
      AppMethodBeat.o(67890);
      return str;
    }
  }
  
  public static final class d
  {
    public String OkP;
    public int type;
    public String url;
    public String username;
    
    public final String toString()
    {
      AppMethodBeat.i(67891);
      String str = "JumpInfo{type=" + this.type + ", url='" + this.url + '\'' + ", username='" + this.username + '\'' + ", pagepath='" + this.OkP + '\'' + '}';
      AppMethodBeat.o(67891);
      return str;
    }
  }
  
  public static final class e
  {
    public ah.d OkO;
    public String wording;
    
    public final String toString()
    {
      AppMethodBeat.i(67892);
      String str = "TextInfo{wording='" + this.wording + '\'' + ", jumpInfo=" + this.OkO + '}';
      AppMethodBeat.o(67892);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.ah
 * JD-Core Version:    0.7.0.1
 */