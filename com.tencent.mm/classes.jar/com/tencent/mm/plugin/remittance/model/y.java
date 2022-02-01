package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpaysdk.api.ResendMsgInfo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class y
  extends m
{
  public String desc;
  public double phz;
  public int status;
  public boolean uTf;
  public String wSO;
  public int wSY;
  public String wSq;
  private String yoZ;
  public String ypa;
  public int ypb;
  private String ypc;
  public String ypd;
  public int ype;
  public String ypf;
  public String ypg;
  public int yph;
  public a ypi;
  public b ypj;
  public d ypk;
  public ResendMsgInfo ypl;
  public d ypm;
  public String ypn;
  public String ypo;
  
  public y(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(67893);
    this.yoZ = null;
    this.ypa = null;
    this.yoZ = paramString1;
    this.ypa = paramString2;
    this.wSY = paramInt1;
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
    localc.ypt = localJSONObject.optString("pagepath");
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
    locald.dyI = localJSONObject.optString("wording");
    locald.yps = aO(localJSONObject.optJSONObject("jump_info"));
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
    ae.d("Micromsg.NetSceneTenpayRemittanceQuery", "errCode " + paramInt + " errMsg: " + paramString);
    if (paramInt != 0)
    {
      AppMethodBeat.o(67894);
      return;
    }
    this.ypb = paramJSONObject.optInt("pay_time");
    this.phz = (paramJSONObject.optDouble("fee") / 100.0D);
    this.wSq = paramJSONObject.optString("fee_type");
    this.status = paramJSONObject.optInt("trans_status");
    this.ypc = paramJSONObject.optString("trans_status_name");
    this.ype = paramJSONObject.optInt("modify_time");
    this.uTf = paramJSONObject.optBoolean("is_payer");
    this.wSO = paramJSONObject.optString("refund_bank_type");
    this.ypf = paramJSONObject.optString("status_desc");
    this.ypg = paramJSONObject.optString("status_supplementary");
    this.yph = paramJSONObject.optInt("delay_confirm_flag");
    this.ypn = paramJSONObject.optString("banner_content");
    this.ypo = paramJSONObject.optString("banner_url");
    this.desc = paramJSONObject.optString("desc");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("addr_info");
    Object localObject = new a();
    paramString = localJSONObject;
    if (localJSONObject == null) {
      paramString = new JSONObject();
    }
    ((a)localObject).ypp = paramString.optString("address_name");
    ((a)localObject).jki = paramString.optString("phone_num");
    ((a)localObject).hZQ = paramString.optString("address");
    this.ypi = ((a)localObject);
    localJSONObject = paramJSONObject.optJSONObject("exposure_info");
    localObject = new b();
    paramString = localJSONObject;
    if (localJSONObject == null) {
      paramString = new JSONObject();
    }
    ((b)localObject).dEM = paramString.optString("icon");
    ((b)localObject).name = paramString.optString("name");
    ((b)localObject).dyI = paramString.optString("wording");
    ((b)localObject).ypq = paramString.optInt("is_show_btn");
    ((b)localObject).ypr = paramString.optString("btn_wording");
    ((b)localObject).yps = aO(paramString.optJSONObject("jump_info"));
    this.ypj = ((b)localObject);
    this.ypk = aP(paramJSONObject.optJSONObject("text_info"));
    localJSONObject = paramJSONObject.optJSONObject("resend_info");
    localObject = new ResendMsgInfo();
    paramString = localJSONObject;
    if (localJSONObject == null) {
      paramString = new JSONObject();
    }
    ((ResendMsgInfo)localObject).title = paramString.optString("title");
    ((ResendMsgInfo)localObject).Fae = paramString.optString("pic");
    ((ResendMsgInfo)localObject).description = paramString.optString("description");
    ((ResendMsgInfo)localObject).kCZ = paramString.optString("left_button_wording");
    ((ResendMsgInfo)localObject).kDa = paramString.optString("right_button_wording");
    this.ypl = ((ResendMsgInfo)localObject);
    this.ypm = aP(paramJSONObject.optJSONObject("middle_info"));
    AppMethodBeat.o(67894);
  }
  
  public static final class a
  {
    public String hZQ;
    public String jki;
    public String ypp;
    
    public final String toString()
    {
      AppMethodBeat.i(67889);
      String str = "AddressInfo{addressName='" + this.ypp + '\'' + ", phoneNum='" + this.jki + '\'' + ", address='" + this.hZQ + '\'' + '}';
      AppMethodBeat.o(67889);
      return str;
    }
  }
  
  public static final class b
  {
    public String dEM;
    public String dyI;
    public String name;
    public int ypq;
    public String ypr;
    public y.c yps;
    
    public final String toString()
    {
      AppMethodBeat.i(67890);
      String str = "ExposureInfo{icon='" + this.dEM + '\'' + ", name='" + this.name + '\'' + ", wording='" + this.dyI + '\'' + ", isShowBtn=" + this.ypq + ", btnWording='" + this.ypr + '\'' + ", jumpInfo=" + this.yps + '}';
      AppMethodBeat.o(67890);
      return str;
    }
  }
  
  public static final class c
  {
    public int type;
    public String url;
    public String username;
    public String ypt;
    
    public final String toString()
    {
      AppMethodBeat.i(67891);
      String str = "JumpInfo{type=" + this.type + ", url='" + this.url + '\'' + ", username='" + this.username + '\'' + ", pagepath='" + this.ypt + '\'' + '}';
      AppMethodBeat.o(67891);
      return str;
    }
  }
  
  public static final class d
  {
    public String dyI;
    public y.c yps;
    
    public final String toString()
    {
      AppMethodBeat.i(67892);
      String str = "TextInfo{wording='" + this.dyI + '\'' + ", jumpInfo=" + this.yps + '}';
      AppMethodBeat.o(67892);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.y
 * JD-Core Version:    0.7.0.1
 */