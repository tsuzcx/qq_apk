package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpaysdk.api.ResendMsgInfo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class y
  extends m
{
  public String desc;
  public double nUf;
  public int status;
  public boolean swU;
  public String uoN;
  public int uoX;
  public String uop;
  public int vBA;
  public String vBB;
  public String vBC;
  public int vBD;
  public a vBE;
  public b vBF;
  public d vBG;
  public ResendMsgInfo vBH;
  public d vBI;
  public String vBJ;
  public String vBK;
  private String vBv;
  public String vBw;
  public int vBx;
  private String vBy;
  public String vBz;
  
  public y(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(67893);
    this.vBv = null;
    this.vBw = null;
    this.vBv = paramString1;
    this.vBw = paramString2;
    this.uoX = paramInt1;
    HashMap localHashMap = new HashMap();
    localHashMap.put("transfer_id", paramString2);
    localHashMap.put("trans_id", paramString1);
    localHashMap.put("invalid_time", String.valueOf(paramInt2));
    setRequestData(localHashMap);
    AppMethodBeat.o(67893);
  }
  
  private static c aE(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(67895);
    c localc = new c();
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    localc.type = localJSONObject.optInt("type");
    localc.url = localJSONObject.optString("url");
    localc.username = localJSONObject.optString("username");
    localc.vBP = localJSONObject.optString("pagepath");
    AppMethodBeat.o(67895);
    return localc;
  }
  
  private static d aF(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(67896);
    d locald = new d();
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    locald.doh = localJSONObject.optString("wording");
    locald.vBO = aE(localJSONObject.optJSONObject("jump_info"));
    AppMethodBeat.o(67896);
    return locald;
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
    ad.d("Micromsg.NetSceneTenpayRemittanceQuery", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      AppMethodBeat.o(67894);
      return;
    }
    this.vBx = paramJSONObject.optInt("pay_time");
    this.nUf = (paramJSONObject.optDouble("fee") / 100.0D);
    this.uop = paramJSONObject.optString("fee_type");
    this.status = paramJSONObject.optInt("trans_status");
    this.vBy = paramJSONObject.optString("trans_status_name");
    this.vBA = paramJSONObject.optInt("modify_time");
    this.swU = paramJSONObject.optBoolean("is_payer");
    this.uoN = paramJSONObject.optString("refund_bank_type");
    this.vBB = paramJSONObject.optString("status_desc");
    this.vBC = paramJSONObject.optString("status_supplementary");
    this.vBD = paramJSONObject.optInt("delay_confirm_flag");
    this.vBJ = paramJSONObject.optString("banner_content");
    this.vBK = paramJSONObject.optString("banner_url");
    this.desc = paramJSONObject.optString("desc");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("addr_info");
    Object localObject = new a();
    paramString = localJSONObject;
    if (localJSONObject == null) {
      paramString = new JSONObject();
    }
    ((a)localObject).vBL = paramString.optString("address_name");
    ((a)localObject).ioa = paramString.optString("phone_num");
    ((a)localObject).hdQ = paramString.optString("address");
    this.vBE = ((a)localObject);
    localJSONObject = paramJSONObject.optJSONObject("exposure_info");
    localObject = new b();
    paramString = localJSONObject;
    if (localJSONObject == null) {
      paramString = new JSONObject();
    }
    ((b)localObject).dub = paramString.optString("icon");
    ((b)localObject).name = paramString.optString("name");
    ((b)localObject).doh = paramString.optString("wording");
    ((b)localObject).vBM = paramString.optInt("is_show_btn");
    ((b)localObject).vBN = paramString.optString("btn_wording");
    ((b)localObject).vBO = aE(paramString.optJSONObject("jump_info"));
    this.vBF = ((b)localObject);
    this.vBG = aF(paramJSONObject.optJSONObject("text_info"));
    localJSONObject = paramJSONObject.optJSONObject("resend_info");
    localObject = new ResendMsgInfo();
    paramString = localJSONObject;
    if (localJSONObject == null) {
      paramString = new JSONObject();
    }
    ((ResendMsgInfo)localObject).title = paramString.optString("title");
    ((ResendMsgInfo)localObject).BLA = paramString.optString("pic");
    ((ResendMsgInfo)localObject).description = paramString.optString("description");
    ((ResendMsgInfo)localObject).tfH = paramString.optString("left_button_wording");
    ((ResendMsgInfo)localObject).tfI = paramString.optString("right_button_wording");
    this.vBH = ((ResendMsgInfo)localObject);
    this.vBI = aF(paramJSONObject.optJSONObject("middle_info"));
    AppMethodBeat.o(67894);
  }
  
  public static final class a
  {
    public String hdQ;
    public String ioa;
    public String vBL;
    
    public final String toString()
    {
      AppMethodBeat.i(67889);
      String str = "AddressInfo{addressName='" + this.vBL + '\'' + ", phoneNum='" + this.ioa + '\'' + ", address='" + this.hdQ + '\'' + '}';
      AppMethodBeat.o(67889);
      return str;
    }
  }
  
  public static final class b
  {
    public String doh;
    public String dub;
    public String name;
    public int vBM;
    public String vBN;
    public y.c vBO;
    
    public final String toString()
    {
      AppMethodBeat.i(67890);
      String str = "ExposureInfo{icon='" + this.dub + '\'' + ", name='" + this.name + '\'' + ", wording='" + this.doh + '\'' + ", isShowBtn=" + this.vBM + ", btnWording='" + this.vBN + '\'' + ", jumpInfo=" + this.vBO + '}';
      AppMethodBeat.o(67890);
      return str;
    }
  }
  
  public static final class c
  {
    public int type;
    public String url;
    public String username;
    public String vBP;
    
    public final String toString()
    {
      AppMethodBeat.i(67891);
      String str = "JumpInfo{type=" + this.type + ", url='" + this.url + '\'' + ", username='" + this.username + '\'' + ", pagepath='" + this.vBP + '\'' + '}';
      AppMethodBeat.o(67891);
      return str;
    }
  }
  
  public static final class d
  {
    public String doh;
    public y.c vBO;
    
    public final String toString()
    {
      AppMethodBeat.i(67892);
      String str = "TextInfo{wording='" + this.doh + '\'' + ", jumpInfo=" + this.vBO + '}';
      AppMethodBeat.o(67892);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.y
 * JD-Core Version:    0.7.0.1
 */