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
  public double paV;
  public int status;
  public boolean uHs;
  public String wCF;
  public String wDd;
  public int wDn;
  private String xZh;
  public String xZi;
  public int xZj;
  private String xZk;
  public String xZl;
  public int xZm;
  public String xZn;
  public String xZo;
  public int xZp;
  public a xZq;
  public b xZr;
  public d xZs;
  public ResendMsgInfo xZt;
  public d xZu;
  public String xZv;
  public String xZw;
  
  public y(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(67893);
    this.xZh = null;
    this.xZi = null;
    this.xZh = paramString1;
    this.xZi = paramString2;
    this.wDn = paramInt1;
    HashMap localHashMap = new HashMap();
    localHashMap.put("transfer_id", paramString2);
    localHashMap.put("trans_id", paramString1);
    localHashMap.put("invalid_time", String.valueOf(paramInt2));
    setRequestData(localHashMap);
    AppMethodBeat.o(67893);
  }
  
  private static c aO(JSONObject paramJSONObject)
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
    localc.xZB = localJSONObject.optString("pagepath");
    AppMethodBeat.o(67895);
    return localc;
  }
  
  private static d aP(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(67896);
    d locald = new d();
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    locald.dxD = localJSONObject.optString("wording");
    locald.xZA = aO(localJSONObject.optJSONObject("jump_info"));
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
    this.xZj = paramJSONObject.optInt("pay_time");
    this.paV = (paramJSONObject.optDouble("fee") / 100.0D);
    this.wCF = paramJSONObject.optString("fee_type");
    this.status = paramJSONObject.optInt("trans_status");
    this.xZk = paramJSONObject.optString("trans_status_name");
    this.xZm = paramJSONObject.optInt("modify_time");
    this.uHs = paramJSONObject.optBoolean("is_payer");
    this.wDd = paramJSONObject.optString("refund_bank_type");
    this.xZn = paramJSONObject.optString("status_desc");
    this.xZo = paramJSONObject.optString("status_supplementary");
    this.xZp = paramJSONObject.optInt("delay_confirm_flag");
    this.xZv = paramJSONObject.optString("banner_content");
    this.xZw = paramJSONObject.optString("banner_url");
    this.desc = paramJSONObject.optString("desc");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("addr_info");
    Object localObject = new a();
    paramString = localJSONObject;
    if (localJSONObject == null) {
      paramString = new JSONObject();
    }
    ((a)localObject).xZx = paramString.optString("address_name");
    ((a)localObject).jhp = paramString.optString("phone_num");
    ((a)localObject).hWY = paramString.optString("address");
    this.xZq = ((a)localObject);
    localJSONObject = paramJSONObject.optJSONObject("exposure_info");
    localObject = new b();
    paramString = localJSONObject;
    if (localJSONObject == null) {
      paramString = new JSONObject();
    }
    ((b)localObject).dDH = paramString.optString("icon");
    ((b)localObject).name = paramString.optString("name");
    ((b)localObject).dxD = paramString.optString("wording");
    ((b)localObject).xZy = paramString.optInt("is_show_btn");
    ((b)localObject).xZz = paramString.optString("btn_wording");
    ((b)localObject).xZA = aO(paramString.optJSONObject("jump_info"));
    this.xZr = ((b)localObject);
    this.xZs = aP(paramJSONObject.optJSONObject("text_info"));
    localJSONObject = paramJSONObject.optJSONObject("resend_info");
    localObject = new ResendMsgInfo();
    paramString = localJSONObject;
    if (localJSONObject == null) {
      paramString = new JSONObject();
    }
    ((ResendMsgInfo)localObject).title = paramString.optString("title");
    ((ResendMsgInfo)localObject).EHI = paramString.optString("pic");
    ((ResendMsgInfo)localObject).description = paramString.optString("description");
    ((ResendMsgInfo)localObject).kzK = paramString.optString("left_button_wording");
    ((ResendMsgInfo)localObject).kzL = paramString.optString("right_button_wording");
    this.xZt = ((ResendMsgInfo)localObject);
    this.xZu = aP(paramJSONObject.optJSONObject("middle_info"));
    AppMethodBeat.o(67894);
  }
  
  public static final class a
  {
    public String hWY;
    public String jhp;
    public String xZx;
    
    public final String toString()
    {
      AppMethodBeat.i(67889);
      String str = "AddressInfo{addressName='" + this.xZx + '\'' + ", phoneNum='" + this.jhp + '\'' + ", address='" + this.hWY + '\'' + '}';
      AppMethodBeat.o(67889);
      return str;
    }
  }
  
  public static final class b
  {
    public String dDH;
    public String dxD;
    public String name;
    public y.c xZA;
    public int xZy;
    public String xZz;
    
    public final String toString()
    {
      AppMethodBeat.i(67890);
      String str = "ExposureInfo{icon='" + this.dDH + '\'' + ", name='" + this.name + '\'' + ", wording='" + this.dxD + '\'' + ", isShowBtn=" + this.xZy + ", btnWording='" + this.xZz + '\'' + ", jumpInfo=" + this.xZA + '}';
      AppMethodBeat.o(67890);
      return str;
    }
  }
  
  public static final class c
  {
    public int type;
    public String url;
    public String username;
    public String xZB;
    
    public final String toString()
    {
      AppMethodBeat.i(67891);
      String str = "JumpInfo{type=" + this.type + ", url='" + this.url + '\'' + ", username='" + this.username + '\'' + ", pagepath='" + this.xZB + '\'' + '}';
      AppMethodBeat.o(67891);
      return str;
    }
  }
  
  public static final class d
  {
    public String dxD;
    public y.c xZA;
    
    public final String toString()
    {
      AppMethodBeat.i(67892);
      String str = "TextInfo{wording='" + this.dxD + '\'' + ", jumpInfo=" + this.xZA + '}';
      AppMethodBeat.o(67892);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.y
 * JD-Core Version:    0.7.0.1
 */