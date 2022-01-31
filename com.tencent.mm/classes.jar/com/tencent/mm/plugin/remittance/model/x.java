package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpaysdk.api.ResendMsgInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class x
  extends m
{
  public String desc;
  public double kNS;
  public boolean nJo;
  public String ppN;
  public int ppX;
  public String ppp;
  public int qkA;
  public x.a qkB;
  public b qkC;
  public x.d qkD;
  public ResendMsgInfo qkE;
  public String qkF;
  public String qkG;
  private String qkt;
  public int qku;
  private String qkv;
  public String qkw;
  public int qkx;
  public String qky;
  public String qkz;
  public int status;
  
  public x(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(44785);
    this.qkt = null;
    this.qkt = paramString1;
    this.ppX = paramInt1;
    HashMap localHashMap = new HashMap();
    localHashMap.put("transfer_id", paramString2);
    localHashMap.put("trans_id", paramString1);
    localHashMap.put("invalid_time", String.valueOf(paramInt2));
    setRequestData(localHashMap);
    AppMethodBeat.o(44785);
  }
  
  private static c ap(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(44787);
    c localc = new c();
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    localc.type = localJSONObject.optInt("type");
    localc.url = localJSONObject.optString("url");
    localc.username = localJSONObject.optString("username");
    localc.qkL = localJSONObject.optString("pagepath");
    AppMethodBeat.o(44787);
    return localc;
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
    AppMethodBeat.i(44786);
    ab.d("Micromsg.NetSceneTenpayRemittanceQuery", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      AppMethodBeat.o(44786);
      return;
    }
    this.qku = paramJSONObject.optInt("pay_time");
    this.kNS = (paramJSONObject.optDouble("fee") / 100.0D);
    this.ppp = paramJSONObject.optString("fee_type");
    this.status = paramJSONObject.optInt("trans_status");
    this.qkv = paramJSONObject.optString("trans_status_name");
    this.qkx = paramJSONObject.optInt("modify_time");
    this.nJo = paramJSONObject.optBoolean("is_payer");
    this.ppN = paramJSONObject.optString("refund_bank_type");
    this.qky = paramJSONObject.optString("status_desc");
    this.qkz = paramJSONObject.optString("status_supplementary");
    this.qkA = paramJSONObject.optInt("delay_confirm_flag");
    this.qkF = paramJSONObject.optString("banner_content");
    this.qkG = paramJSONObject.optString("banner_url");
    this.desc = paramJSONObject.optString("desc");
    Object localObject1 = paramJSONObject.optJSONObject("addr_info");
    Object localObject2 = new x.a();
    paramString = (String)localObject1;
    if (localObject1 == null) {
      paramString = new JSONObject();
    }
    ((x.a)localObject2).qkH = paramString.optString("address_name");
    ((x.a)localObject2).gAF = paramString.optString("phone_num");
    ((x.a)localObject2).fBq = paramString.optString("address");
    this.qkB = ((x.a)localObject2);
    localObject1 = paramJSONObject.optJSONObject("exposure_info");
    localObject2 = new b();
    paramString = (String)localObject1;
    if (localObject1 == null) {
      paramString = new JSONObject();
    }
    ((b)localObject2).cDz = paramString.optString("icon");
    ((b)localObject2).name = paramString.optString("name");
    ((b)localObject2).cyA = paramString.optString("wording");
    ((b)localObject2).qkI = paramString.optInt("is_show_btn");
    ((b)localObject2).qkJ = paramString.optString("btn_wording");
    ((b)localObject2).qkK = ap(paramString.optJSONObject("jump_info"));
    this.qkC = ((b)localObject2);
    localObject1 = paramJSONObject.optJSONObject("text_info");
    localObject2 = new x.d();
    paramString = (String)localObject1;
    if (localObject1 == null) {
      paramString = new JSONObject();
    }
    ((x.d)localObject2).cyA = paramString.optString("wording");
    ((x.d)localObject2).qkK = ap(paramString.optJSONObject("jump_info"));
    this.qkD = ((x.d)localObject2);
    paramJSONObject = paramJSONObject.optJSONObject("resend_info");
    localObject1 = new ResendMsgInfo();
    paramString = paramJSONObject;
    if (paramJSONObject == null) {
      paramString = new JSONObject();
    }
    ((ResendMsgInfo)localObject1).title = paramString.optString("title");
    ((ResendMsgInfo)localObject1).vIO = paramString.optString("pic");
    ((ResendMsgInfo)localObject1).description = paramString.optString("description");
    ((ResendMsgInfo)localObject1).opC = paramString.optString("left_button_wording");
    ((ResendMsgInfo)localObject1).opD = paramString.optString("right_button_wording");
    this.qkE = ((ResendMsgInfo)localObject1);
    AppMethodBeat.o(44786);
  }
  
  public static final class b
  {
    public String cDz;
    public String cyA;
    public String name;
    public int qkI;
    public String qkJ;
    public x.c qkK;
    
    public final String toString()
    {
      AppMethodBeat.i(44777);
      String str = "ExposureInfo{icon='" + this.cDz + '\'' + ", name='" + this.name + '\'' + ", wording='" + this.cyA + '\'' + ", isShowBtn=" + this.qkI + ", btnWording='" + this.qkJ + '\'' + ", jumpInfo=" + this.qkK + '}';
      AppMethodBeat.o(44777);
      return str;
    }
  }
  
  public static final class c
  {
    public String qkL;
    public int type;
    public String url;
    public String username;
    
    public final String toString()
    {
      AppMethodBeat.i(44778);
      String str = "JumpInfo{type=" + this.type + ", url='" + this.url + '\'' + ", username='" + this.username + '\'' + ", pagepath='" + this.qkL + '\'' + '}';
      AppMethodBeat.o(44778);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.x
 * JD-Core Version:    0.7.0.1
 */