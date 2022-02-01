package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpaysdk.api.ResendMsgInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class y
  extends m
{
  public String AOI;
  public int AOS;
  public String AOl;
  private String CpP;
  public String CpQ;
  public int CpR;
  private String CpS;
  public String CpT;
  public int CpU;
  public String CpV;
  public String CpW;
  public int CpX;
  public a CpY;
  public c CpZ;
  public e Cqa;
  public ResendMsgInfo Cqb;
  private e Cqc;
  public ArrayList<y.b> Cqd;
  public String Cqe;
  public String Cqf;
  public String desc;
  public double qwJ;
  public int status;
  public boolean ylG;
  
  public y(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(67893);
    this.CpP = null;
    this.CpQ = null;
    this.CpP = paramString1;
    this.CpQ = paramString2;
    this.AOS = paramInt1;
    HashMap localHashMap = new HashMap();
    localHashMap.put("transfer_id", paramString2);
    localHashMap.put("trans_id", paramString1);
    localHashMap.put("invalid_time", String.valueOf(paramInt2));
    setRequestData(localHashMap);
    AppMethodBeat.o(67893);
  }
  
  private static ArrayList<y.b> F(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(213735);
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
          y.b localb = new y.b();
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
      AppMethodBeat.o(213735);
    }
  }
  
  private static d bk(JSONObject paramJSONObject)
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
    locald.Cqk = localJSONObject.optString("pagepath");
    AppMethodBeat.o(67895);
    return locald;
  }
  
  private static e bl(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(67896);
    e locale = new e();
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    locale.dQx = localJSONObject.optString("wording");
    locale.Cqj = bk(localJSONObject.optJSONObject("jump_info"));
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
    this.CpR = paramJSONObject.optInt("pay_time");
    this.qwJ = (paramJSONObject.optDouble("fee") / 100.0D);
    this.AOl = paramJSONObject.optString("fee_type");
    this.status = paramJSONObject.optInt("trans_status");
    this.CpS = paramJSONObject.optString("trans_status_name");
    this.CpU = paramJSONObject.optInt("modify_time");
    this.ylG = paramJSONObject.optBoolean("is_payer");
    this.AOI = paramJSONObject.optString("refund_bank_type");
    this.CpV = paramJSONObject.optString("status_desc");
    this.CpW = paramJSONObject.optString("status_supplementary");
    this.CpX = paramJSONObject.optInt("delay_confirm_flag");
    this.Cqe = paramJSONObject.optString("banner_content");
    this.Cqf = paramJSONObject.optString("banner_url");
    this.desc = paramJSONObject.optString("desc");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("addr_info");
    Object localObject = new a();
    paramString = localJSONObject;
    if (localJSONObject == null) {
      paramString = new JSONObject();
    }
    ((a)localObject).Cqg = paramString.optString("address_name");
    ((a)localObject).kik = paramString.optString("phone_num");
    ((a)localObject).iUO = paramString.optString("address");
    this.CpY = ((a)localObject);
    localJSONObject = paramJSONObject.optJSONObject("exposure_info");
    localObject = new c();
    paramString = localJSONObject;
    if (localJSONObject == null) {
      paramString = new JSONObject();
    }
    ((c)localObject).icon = paramString.optString("icon");
    ((c)localObject).name = paramString.optString("name");
    ((c)localObject).dQx = paramString.optString("wording");
    ((c)localObject).Cqh = paramString.optInt("is_show_btn");
    ((c)localObject).Cqi = paramString.optString("btn_wording");
    ((c)localObject).Cqj = bk(paramString.optJSONObject("jump_info"));
    this.CpZ = ((c)localObject);
    this.Cqa = bl(paramJSONObject.optJSONObject("text_info"));
    localJSONObject = paramJSONObject.optJSONObject("resend_info");
    localObject = new ResendMsgInfo();
    paramString = localJSONObject;
    if (localJSONObject == null) {
      paramString = new JSONObject();
    }
    ((ResendMsgInfo)localObject).title = paramString.optString("title");
    ((ResendMsgInfo)localObject).JQW = paramString.optString("pic");
    ((ResendMsgInfo)localObject).description = paramString.optString("description");
    ((ResendMsgInfo)localObject).lHA = paramString.optString("left_button_wording");
    ((ResendMsgInfo)localObject).lHB = paramString.optString("right_button_wording");
    this.Cqb = ((ResendMsgInfo)localObject);
    this.Cqc = bl(paramJSONObject.optJSONObject("middle_info"));
    this.Cqd = F(paramJSONObject.optJSONArray("desc_item_list"));
    AppMethodBeat.o(67894);
  }
  
  public static final class a
  {
    public String Cqg;
    public String iUO;
    public String kik;
    
    public final String toString()
    {
      AppMethodBeat.i(67889);
      String str = "AddressInfo{addressName='" + this.Cqg + '\'' + ", phoneNum='" + this.kik + '\'' + ", address='" + this.iUO + '\'' + '}';
      AppMethodBeat.o(67889);
      return str;
    }
  }
  
  public static final class c
  {
    public int Cqh;
    public String Cqi;
    public y.d Cqj;
    public String dQx;
    public String icon;
    public String name;
    
    public final String toString()
    {
      AppMethodBeat.i(67890);
      String str = "ExposureInfo{icon='" + this.icon + '\'' + ", name='" + this.name + '\'' + ", wording='" + this.dQx + '\'' + ", isShowBtn=" + this.Cqh + ", btnWording='" + this.Cqi + '\'' + ", jumpInfo=" + this.Cqj + '}';
      AppMethodBeat.o(67890);
      return str;
    }
  }
  
  public static final class d
  {
    public String Cqk;
    public int type;
    public String url;
    public String username;
    
    public final String toString()
    {
      AppMethodBeat.i(67891);
      String str = "JumpInfo{type=" + this.type + ", url='" + this.url + '\'' + ", username='" + this.username + '\'' + ", pagepath='" + this.Cqk + '\'' + '}';
      AppMethodBeat.o(67891);
      return str;
    }
  }
  
  public static final class e
  {
    public y.d Cqj;
    public String dQx;
    
    public final String toString()
    {
      AppMethodBeat.i(67892);
      String str = "TextInfo{wording='" + this.dQx + '\'' + ", jumpInfo=" + this.Cqj + '}';
      AppMethodBeat.o(67892);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.y
 * JD-Core Version:    0.7.0.1
 */