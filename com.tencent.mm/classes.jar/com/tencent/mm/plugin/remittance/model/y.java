package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpaysdk.api.ResendMsgInfo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class y
  extends m
{
  public String desc;
  public double oxA;
  public int status;
  public boolean tEJ;
  public String vxJ;
  public int vxT;
  public String vxl;
  private String wLA;
  public String wLB;
  public int wLC;
  private String wLD;
  public String wLE;
  public int wLF;
  public String wLG;
  public String wLH;
  public int wLI;
  public a wLJ;
  public b wLK;
  public d wLL;
  public ResendMsgInfo wLM;
  public d wLN;
  public String wLO;
  public String wLP;
  
  public y(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(67893);
    this.wLA = null;
    this.wLB = null;
    this.wLA = paramString1;
    this.wLB = paramString2;
    this.vxT = paramInt1;
    HashMap localHashMap = new HashMap();
    localHashMap.put("transfer_id", paramString2);
    localHashMap.put("trans_id", paramString1);
    localHashMap.put("invalid_time", String.valueOf(paramInt2));
    setRequestData(localHashMap);
    AppMethodBeat.o(67893);
  }
  
  private static c aF(JSONObject paramJSONObject)
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
    localc.wLU = localJSONObject.optString("pagepath");
    AppMethodBeat.o(67895);
    return localc;
  }
  
  private static d aG(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(67896);
    d locald = new d();
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    locald.dlQ = localJSONObject.optString("wording");
    locald.wLT = aF(localJSONObject.optJSONObject("jump_info"));
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
    ac.d("Micromsg.NetSceneTenpayRemittanceQuery", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      AppMethodBeat.o(67894);
      return;
    }
    this.wLC = paramJSONObject.optInt("pay_time");
    this.oxA = (paramJSONObject.optDouble("fee") / 100.0D);
    this.vxl = paramJSONObject.optString("fee_type");
    this.status = paramJSONObject.optInt("trans_status");
    this.wLD = paramJSONObject.optString("trans_status_name");
    this.wLF = paramJSONObject.optInt("modify_time");
    this.tEJ = paramJSONObject.optBoolean("is_payer");
    this.vxJ = paramJSONObject.optString("refund_bank_type");
    this.wLG = paramJSONObject.optString("status_desc");
    this.wLH = paramJSONObject.optString("status_supplementary");
    this.wLI = paramJSONObject.optInt("delay_confirm_flag");
    this.wLO = paramJSONObject.optString("banner_content");
    this.wLP = paramJSONObject.optString("banner_url");
    this.desc = paramJSONObject.optString("desc");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("addr_info");
    Object localObject = new a();
    paramString = localJSONObject;
    if (localJSONObject == null) {
      paramString = new JSONObject();
    }
    ((a)localObject).wLQ = paramString.optString("address_name");
    ((a)localObject).iOg = paramString.optString("phone_num");
    ((a)localObject).hEt = paramString.optString("address");
    this.wLJ = ((a)localObject);
    localJSONObject = paramJSONObject.optJSONObject("exposure_info");
    localObject = new b();
    paramString = localJSONObject;
    if (localJSONObject == null) {
      paramString = new JSONObject();
    }
    ((b)localObject).drM = paramString.optString("icon");
    ((b)localObject).name = paramString.optString("name");
    ((b)localObject).dlQ = paramString.optString("wording");
    ((b)localObject).wLR = paramString.optInt("is_show_btn");
    ((b)localObject).wLS = paramString.optString("btn_wording");
    ((b)localObject).wLT = aF(paramString.optJSONObject("jump_info"));
    this.wLK = ((b)localObject);
    this.wLL = aG(paramJSONObject.optJSONObject("text_info"));
    localJSONObject = paramJSONObject.optJSONObject("resend_info");
    localObject = new ResendMsgInfo();
    paramString = localJSONObject;
    if (localJSONObject == null) {
      paramString = new JSONObject();
    }
    ((ResendMsgInfo)localObject).title = paramString.optString("title");
    ((ResendMsgInfo)localObject).DdI = paramString.optString("pic");
    ((ResendMsgInfo)localObject).description = paramString.optString("description");
    ((ResendMsgInfo)localObject).unW = paramString.optString("left_button_wording");
    ((ResendMsgInfo)localObject).unX = paramString.optString("right_button_wording");
    this.wLM = ((ResendMsgInfo)localObject);
    this.wLN = aG(paramJSONObject.optJSONObject("middle_info"));
    AppMethodBeat.o(67894);
  }
  
  public static final class a
  {
    public String hEt;
    public String iOg;
    public String wLQ;
    
    public final String toString()
    {
      AppMethodBeat.i(67889);
      String str = "AddressInfo{addressName='" + this.wLQ + '\'' + ", phoneNum='" + this.iOg + '\'' + ", address='" + this.hEt + '\'' + '}';
      AppMethodBeat.o(67889);
      return str;
    }
  }
  
  public static final class b
  {
    public String dlQ;
    public String drM;
    public String name;
    public int wLR;
    public String wLS;
    public y.c wLT;
    
    public final String toString()
    {
      AppMethodBeat.i(67890);
      String str = "ExposureInfo{icon='" + this.drM + '\'' + ", name='" + this.name + '\'' + ", wording='" + this.dlQ + '\'' + ", isShowBtn=" + this.wLR + ", btnWording='" + this.wLS + '\'' + ", jumpInfo=" + this.wLT + '}';
      AppMethodBeat.o(67890);
      return str;
    }
  }
  
  public static final class c
  {
    public int type;
    public String url;
    public String username;
    public String wLU;
    
    public final String toString()
    {
      AppMethodBeat.i(67891);
      String str = "JumpInfo{type=" + this.type + ", url='" + this.url + '\'' + ", username='" + this.username + '\'' + ", pagepath='" + this.wLU + '\'' + '}';
      AppMethodBeat.o(67891);
      return str;
    }
  }
  
  public static final class d
  {
    public String dlQ;
    public y.c wLT;
    
    public final String toString()
    {
      AppMethodBeat.i(67892);
      String str = "TextInfo{wording='" + this.dlQ + '\'' + ", jumpInfo=" + this.wLT + '}';
      AppMethodBeat.o(67892);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.y
 * JD-Core Version:    0.7.0.1
 */