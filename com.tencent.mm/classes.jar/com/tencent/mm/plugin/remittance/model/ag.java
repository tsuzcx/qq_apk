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

public final class ag
  extends m
{
  public boolean DLI;
  public ArrayList<e> ECb;
  public String GHW;
  public String GHz;
  public int GIg;
  private String Ine;
  public String Inf;
  public int Ing;
  public String Inh;
  private String Ini;
  public String Inj;
  public int Ink;
  public String Inl;
  public String Inm;
  public int Inn;
  public a Ino;
  public c Inp;
  public e Inq;
  public ResendMsgInfo Inr;
  private e Ins;
  public ArrayList<ag.b> Int;
  public int Inu;
  public String Inv;
  public String Inw;
  public String desc;
  public int status;
  public double tVK;
  
  public ag(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(271158);
    this.Ine = null;
    this.Inf = null;
    this.Ine = paramString1;
    this.Inf = paramString2;
    this.GIg = paramInt1;
    HashMap localHashMap = new HashMap();
    localHashMap.put("transfer_id", paramString2);
    localHashMap.put("trans_id", paramString1);
    localHashMap.put("invalid_time", String.valueOf(paramInt2));
    localHashMap.put("group_username", paramString3);
    setRequestData(localHashMap);
    AppMethodBeat.o(271158);
  }
  
  private static ArrayList<e> B(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(271161);
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
          paramJSONArray.add(bu(localJSONObject));
        }
        i += 1;
      }
      return paramJSONArray;
    }
    catch (JSONException localJSONException)
    {
      Log.i("Micromsg.NetSceneTenpayRemittanceQuery", "parseOptionItemList error：%s", new Object[] { localJSONException.getMessage() });
      AppMethodBeat.o(271161);
    }
  }
  
  private static ArrayList<ag.b> G(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(271160);
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
          ag.b localb = new ag.b();
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
      AppMethodBeat.o(271160);
    }
  }
  
  private static d bt(JSONObject paramJSONObject)
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
    locald.InB = localJSONObject.optString("pagepath");
    AppMethodBeat.o(67895);
    return locald;
  }
  
  private static e bu(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(67896);
    e locale = new e();
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    locale.wording = localJSONObject.optString("wording");
    locale.InA = bt(localJSONObject.optJSONObject("jump_info"));
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
    this.Ing = paramJSONObject.optInt("pay_time");
    this.tVK = (paramJSONObject.optDouble("fee") / 100.0D);
    this.GHz = paramJSONObject.optString("fee_type");
    this.status = paramJSONObject.optInt("trans_status");
    this.Ini = paramJSONObject.optString("trans_status_name");
    this.Ink = paramJSONObject.optInt("modify_time");
    this.Inj = paramJSONObject.optString("payer_name");
    this.Inh = paramJSONObject.optString("receiver_name");
    this.DLI = paramJSONObject.optBoolean("is_payer");
    this.GHW = paramJSONObject.optString("refund_bank_type");
    this.Inl = paramJSONObject.optString("status_desc");
    this.Inm = paramJSONObject.optString("status_supplementary");
    this.Inn = paramJSONObject.optInt("delay_confirm_flag");
    this.Inv = paramJSONObject.optString("banner_content");
    this.Inw = paramJSONObject.optString("banner_url");
    this.desc = paramJSONObject.optString("desc");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("addr_info");
    Object localObject = new a();
    paramString = localJSONObject;
    if (localJSONObject == null) {
      paramString = new JSONObject();
    }
    ((a)localObject).Inx = paramString.optString("address_name");
    ((a)localObject).mZK = paramString.optString("phone_num");
    ((a)localObject).lLg = paramString.optString("address");
    this.Ino = ((a)localObject);
    localJSONObject = paramJSONObject.optJSONObject("exposure_info");
    localObject = new c();
    paramString = localJSONObject;
    if (localJSONObject == null) {
      paramString = new JSONObject();
    }
    ((c)localObject).icon = paramString.optString("icon");
    ((c)localObject).name = paramString.optString("name");
    ((c)localObject).wording = paramString.optString("wording");
    ((c)localObject).Iny = paramString.optInt("is_show_btn");
    ((c)localObject).Inz = paramString.optString("btn_wording");
    ((c)localObject).InA = bt(paramString.optJSONObject("jump_info"));
    this.Inp = ((c)localObject);
    this.Inq = bu(paramJSONObject.optJSONObject("text_info"));
    localJSONObject = paramJSONObject.optJSONObject("resend_info");
    localObject = new ResendMsgInfo();
    paramString = localJSONObject;
    if (localJSONObject == null) {
      paramString = new JSONObject();
    }
    ((ResendMsgInfo)localObject).title = paramString.optString("title");
    ((ResendMsgInfo)localObject).QPn = paramString.optString("pic");
    ((ResendMsgInfo)localObject).description = paramString.optString("description");
    ((ResendMsgInfo)localObject).oDJ = paramString.optString("left_button_wording");
    ((ResendMsgInfo)localObject).oDK = paramString.optString("right_button_wording");
    this.Inr = ((ResendMsgInfo)localObject);
    this.Ins = bu(paramJSONObject.optJSONObject("middle_info"));
    this.Int = G(paramJSONObject.optJSONArray("desc_item_list"));
    this.Inu = paramJSONObject.optInt("trade_mem_type", 0);
    this.ECb = B(paramJSONObject.optJSONArray("upright_corner_list"));
    AppMethodBeat.o(67894);
  }
  
  public static final class a
  {
    public String Inx;
    public String lLg;
    public String mZK;
    
    public final String toString()
    {
      AppMethodBeat.i(67889);
      String str = "AddressInfo{addressName='" + this.Inx + '\'' + ", phoneNum='" + this.mZK + '\'' + ", address='" + this.lLg + '\'' + '}';
      AppMethodBeat.o(67889);
      return str;
    }
  }
  
  public static final class c
  {
    public ag.d InA;
    public int Iny;
    public String Inz;
    public String icon;
    public String name;
    public String wording;
    
    public final String toString()
    {
      AppMethodBeat.i(67890);
      String str = "ExposureInfo{icon='" + this.icon + '\'' + ", name='" + this.name + '\'' + ", wording='" + this.wording + '\'' + ", isShowBtn=" + this.Iny + ", btnWording='" + this.Inz + '\'' + ", jumpInfo=" + this.InA + '}';
      AppMethodBeat.o(67890);
      return str;
    }
  }
  
  public static final class d
  {
    public String InB;
    public int type;
    public String url;
    public String username;
    
    public final String toString()
    {
      AppMethodBeat.i(67891);
      String str = "JumpInfo{type=" + this.type + ", url='" + this.url + '\'' + ", username='" + this.username + '\'' + ", pagepath='" + this.InB + '\'' + '}';
      AppMethodBeat.o(67891);
      return str;
    }
  }
  
  public static final class e
  {
    public ag.d InA;
    public String wording;
    
    public final String toString()
    {
      AppMethodBeat.i(67892);
      String str = "TextInfo{wording='" + this.wording + '\'' + ", jumpInfo=" + this.InA + '}';
      AppMethodBeat.o(67892);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.ag
 * JD-Core Version:    0.7.0.1
 */