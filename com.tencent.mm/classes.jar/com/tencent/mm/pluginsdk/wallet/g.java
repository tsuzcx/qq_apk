package com.tencent.mm.pluginsdk.wallet;

import com.tencent.mm.h.a.lv;
import com.tencent.mm.h.a.lv.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;
import org.json.JSONObject;

public final class g
{
  public String appId;
  public int bIO;
  public String bMX;
  public String bUT;
  public String bUU;
  public int bUV;
  public int bUW;
  public String dVt;
  public int dYx;
  public String extInfo;
  public String nonceStr;
  public String packageExt;
  public String partnerId;
  public String signType;
  public int soh;
  public int soi;
  public int soj = 0;
  public String sok;
  public int sol = 0;
  public String timeStamp;
  public String url;
  
  public g() {}
  
  public g(lv paramlv)
  {
    if ((paramlv == null) || (paramlv.bUS == null)) {
      return;
    }
    this.appId = paramlv.bUS.appId;
    this.partnerId = paramlv.bUS.partnerId;
    this.signType = paramlv.bUS.signType;
    this.nonceStr = paramlv.bUS.nonceStr;
    this.timeStamp = paramlv.bUS.timeStamp;
    this.packageExt = paramlv.bUS.packageExt;
    this.bUT = paramlv.bUS.bUT;
    this.url = paramlv.bUS.url;
    this.bUU = paramlv.bUS.bUU;
    this.bUV = paramlv.bUS.bUV;
    this.bIO = paramlv.bUS.bIO;
    this.bUW = paramlv.bUS.bUW;
  }
  
  public g(Map<String, Object> paramMap)
  {
    this.appId = ((String)paramMap.get("appId"));
    this.partnerId = ((String)paramMap.get("partnerId"));
    this.signType = ((String)paramMap.get("signType"));
    this.nonceStr = ((String)paramMap.get("nonceStr"));
    this.timeStamp = ((String)paramMap.get("timeStamp"));
    this.packageExt = ((String)paramMap.get("package"));
    this.bMX = ((String)paramMap.get("reqKey"));
    this.soh = bk.getInt((String)paramMap.get("payScene"), 1);
    this.dYx = bk.getInt((String)paramMap.get("businessScene"), 1);
    this.bUT = ((String)paramMap.get("paySign"));
    this.url = ((String)paramMap.get("url"));
    this.bUU = ((String)paramMap.get("src_username"));
    this.bUV = bk.getInt((String)paramMap.get("scene"), 0);
    if (this.bUV == 0) {
      this.bUV = bk.getInt((String)paramMap.get("pay_scene"), 0);
    }
    this.bIO = bk.getInt((String)paramMap.get("pay_channel"), 0);
    this.extInfo = bk.pm((String)paramMap.get("ext_info"));
    this.sok = bk.pm((String)paramMap.get("token"));
    this.sol = bk.getInt(bk.aM((String)paramMap.get("result_jump_mode"), "0"), 0);
  }
  
  public g(JSONObject paramJSONObject)
  {
    this.appId = paramJSONObject.optString("appId");
    this.partnerId = paramJSONObject.optString("partnerId");
    this.signType = paramJSONObject.optString("signType");
    this.nonceStr = paramJSONObject.optString("nonceStr");
    this.timeStamp = paramJSONObject.optString("timeStamp");
    this.packageExt = paramJSONObject.optString("package");
    this.bMX = paramJSONObject.optString("reqKey");
    this.soh = paramJSONObject.optInt("payScene", 1);
    this.dYx = paramJSONObject.optInt("businessScene", 1);
    this.bUT = paramJSONObject.optString("paySign");
    this.dVt = paramJSONObject.optString("cookie");
    this.url = paramJSONObject.optString("url");
    this.bUU = paramJSONObject.optString("src_username");
    this.bUV = paramJSONObject.optInt("scene", 0);
    if (this.bUV == 0) {
      this.bUV = paramJSONObject.optInt("pay_scene", 0);
    }
    this.bIO = paramJSONObject.optInt("pay_channel", 0);
    this.extInfo = paramJSONObject.optString("ext_info", "");
    this.sok = paramJSONObject.optString("token", "");
    this.sol = bk.getInt(paramJSONObject.optString("result_jump_mode", "0"), 0);
    this.soj = paramJSONObject.optInt("pay_for_wallet_type", 0);
  }
  
  public static int fb(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 1037) {}
    while (paramInt2 <= 0) {
      return paramInt1;
    }
    return paramInt2;
  }
  
  public static int fc(int paramInt1, int paramInt2)
  {
    int j = fb(paramInt1, paramInt2);
    int i;
    if ((j == 1000) || (j == 1018) || (j == 1017) || (j == 1033)) {
      i = 0;
    }
    for (;;)
    {
      y.i("MicroMsg.WalletJsapiData", "parsePayChannelByScene, scene: %s, rawScene: %s, resultChannel: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
      return i;
      if (j == 1019)
      {
        i = 1;
      }
      else if (j == 1010)
      {
        i = 5;
      }
      else if ((j == 1007) || (j == 1008))
      {
        i = 6;
      }
      else if (j == 1009)
      {
        i = 7;
      }
      else if ((j == 1035) || (j == 1020))
      {
        i = 8;
      }
      else if ((j == 1011) || (j == 1047) || (j == 1025))
      {
        i = 12;
      }
      else if ((j == 1012) || (j == 1032) || (j == 1048) || (j == 1050))
      {
        i = 13;
      }
      else if ((j == 1005) || (j == 1027) || (j == 1042) || (j == 1006))
      {
        i = 15;
      }
      else if ((j == 1024) || (j == 1021))
      {
        i = 16;
      }
      else if ((j == 1029) || (j == 1028))
      {
        i = 23;
      }
      else if ((j == 1013) || (j == 1031) || (j == 1049))
      {
        i = 24;
      }
      else if ((j == 1001) || (j == 1003))
      {
        i = 25;
      }
      else if ((j == 1045) || (j == 1046))
      {
        i = 26;
      }
      else if (j == 1022)
      {
        i = 27;
      }
      else if (j == 1023)
      {
        i = 28;
      }
      else if (j == 1026)
      {
        i = 29;
      }
      else if (j == 1039)
      {
        i = 30;
      }
      else if ((j == 1034) || (j == 1060))
      {
        i = 31;
      }
      else if ((j != 1014) && (j != 1043) && (j != 1044))
      {
        i = j;
        if (j != 1036) {}
      }
      else
      {
        i = 32;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.wallet.g
 * JD-Core Version:    0.7.0.1
 */