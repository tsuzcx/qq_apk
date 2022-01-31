package com.tencent.mm.pluginsdk.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mm;
import com.tencent.mm.g.a.mm.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;
import org.json.JSONObject;

public class WalletJsapiData
  implements Parcelable
{
  public static final Parcelable.Creator<WalletJsapiData> CREATOR;
  public String appId;
  public String cCB;
  public String cCC;
  public int cCD;
  public int cCE;
  public String cnI;
  public int cqj;
  public String extInfo;
  public String flC;
  public int foC;
  public String nonceStr;
  public String packageExt;
  public String partnerId;
  public String signType;
  public String timeStamp;
  public String url;
  public int wgG;
  public int wgH;
  public int wgI;
  public String wgJ;
  public int wgK;
  public String wgL;
  public String wgM;
  public String wgN;
  
  static
  {
    AppMethodBeat.i(141115);
    CREATOR = new WalletJsapiData.1();
    AppMethodBeat.o(141115);
  }
  
  public WalletJsapiData()
  {
    this.wgI = 0;
    this.wgK = 0;
  }
  
  protected WalletJsapiData(Parcel paramParcel)
  {
    AppMethodBeat.i(141114);
    this.wgI = 0;
    this.wgK = 0;
    this.appId = paramParcel.readString();
    this.partnerId = paramParcel.readString();
    this.signType = paramParcel.readString();
    this.nonceStr = paramParcel.readString();
    this.timeStamp = paramParcel.readString();
    this.packageExt = paramParcel.readString();
    this.cnI = paramParcel.readString();
    this.wgG = paramParcel.readInt();
    this.foC = paramParcel.readInt();
    this.cCB = paramParcel.readString();
    this.flC = paramParcel.readString();
    this.url = paramParcel.readString();
    this.cCC = paramParcel.readString();
    this.cCD = paramParcel.readInt();
    this.cCE = paramParcel.readInt();
    this.cqj = paramParcel.readInt();
    this.wgH = paramParcel.readInt();
    this.extInfo = paramParcel.readString();
    this.wgI = paramParcel.readInt();
    this.wgJ = paramParcel.readString();
    this.wgK = paramParcel.readInt();
    this.wgL = paramParcel.readString();
    this.wgM = paramParcel.readString();
    AppMethodBeat.o(141114);
  }
  
  public WalletJsapiData(mm parammm)
  {
    AppMethodBeat.i(135774);
    this.wgI = 0;
    this.wgK = 0;
    if ((parammm == null) || (parammm.cCA == null))
    {
      AppMethodBeat.o(135774);
      return;
    }
    this.appId = parammm.cCA.appId;
    this.partnerId = parammm.cCA.partnerId;
    this.signType = parammm.cCA.signType;
    this.nonceStr = parammm.cCA.nonceStr;
    this.timeStamp = parammm.cCA.timeStamp;
    this.packageExt = parammm.cCA.packageExt;
    this.cCB = parammm.cCA.cCB;
    this.url = parammm.cCA.url;
    this.cCC = parammm.cCA.cCC;
    this.cCD = parammm.cCA.cCD;
    this.cqj = parammm.cCA.cqj;
    this.cCE = parammm.cCA.cCE;
    AppMethodBeat.o(135774);
  }
  
  public WalletJsapiData(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(135772);
    this.wgI = 0;
    this.wgK = 0;
    this.appId = ((String)paramMap.get("appId"));
    this.partnerId = ((String)paramMap.get("partnerId"));
    this.signType = ((String)paramMap.get("signType"));
    this.nonceStr = ((String)paramMap.get("nonceStr"));
    this.timeStamp = ((String)paramMap.get("timeStamp"));
    this.packageExt = ((String)paramMap.get("package"));
    this.cnI = ((String)paramMap.get("reqKey"));
    this.wgG = bo.getInt((String)paramMap.get("payScene"), 1);
    this.foC = bo.getInt((String)paramMap.get("businessScene"), 1);
    this.cCB = ((String)paramMap.get("paySign"));
    this.url = ((String)paramMap.get("url"));
    this.cCC = ((String)paramMap.get("src_username"));
    this.cCD = bo.getInt((String)paramMap.get("scene"), 0);
    if (this.cCD == 0) {
      this.cCD = bo.getInt((String)paramMap.get("pay_scene"), 0);
    }
    this.cqj = bo.getInt((String)paramMap.get("pay_channel"), 0);
    this.extInfo = bo.nullAsNil((String)paramMap.get("ext_info"));
    this.wgJ = bo.nullAsNil((String)paramMap.get("token"));
    this.wgK = bo.getInt(bo.bf((String)paramMap.get("result_jump_mode"), "0"), 0);
    this.wgL = bo.nullAsNil((String)paramMap.get("key_appbrand_from_path"));
    this.wgM = bo.nullAsNil((String)paramMap.get("key_appbrand_from_username"));
    this.wgN = bo.nullAsNil((String)paramMap.get("key_appbrand_from_scene"));
    AppMethodBeat.o(135772);
  }
  
  public WalletJsapiData(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(135773);
    this.wgI = 0;
    this.wgK = 0;
    this.appId = paramJSONObject.optString("appId");
    this.partnerId = paramJSONObject.optString("partnerId");
    this.signType = paramJSONObject.optString("signType");
    this.nonceStr = paramJSONObject.optString("nonceStr");
    this.timeStamp = paramJSONObject.optString("timeStamp");
    this.packageExt = paramJSONObject.optString("package");
    this.cnI = paramJSONObject.optString("reqKey");
    this.wgG = paramJSONObject.optInt("payScene", 1);
    this.foC = paramJSONObject.optInt("businessScene", 1);
    this.cCB = paramJSONObject.optString("paySign");
    this.flC = paramJSONObject.optString("cookie");
    this.url = paramJSONObject.optString("url");
    this.cCC = paramJSONObject.optString("src_username");
    this.cCD = paramJSONObject.optInt("scene", 0);
    if (this.cCD == 0) {
      this.cCD = paramJSONObject.optInt("pay_scene", 0);
    }
    this.cqj = paramJSONObject.optInt("pay_channel", 0);
    this.extInfo = paramJSONObject.optString("ext_info", "");
    this.wgJ = paramJSONObject.optString("token", "");
    this.wgK = bo.getInt(paramJSONObject.optString("result_jump_mode", "0"), 0);
    this.wgI = paramJSONObject.optInt("pay_for_wallet_type", 0);
    this.wgL = bo.nullAsNil(paramJSONObject.optString("key_appbrand_from_path"));
    this.wgM = bo.nullAsNil(paramJSONObject.optString("key_appbrand_from_username"));
    this.wgN = bo.nullAsNil(paramJSONObject.optString("key_appbrand_from_scene"));
    AppMethodBeat.o(135773);
  }
  
  public static int hh(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 1037) {}
    while (paramInt2 <= 0) {
      return paramInt1;
    }
    return paramInt2;
  }
  
  public static int hi(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(135775);
    int j = hh(paramInt1, paramInt2);
    int i;
    if ((j == 1000) || (j == 1018) || (j == 1017) || (j == 1033)) {
      i = 0;
    }
    for (;;)
    {
      ab.i("MicroMsg.WalletJsapiData", "parsePayChannelByScene, scene: %s, rawScene: %s, resultChannel: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
      AppMethodBeat.o(135775);
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
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(141113);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.partnerId);
    paramParcel.writeString(this.signType);
    paramParcel.writeString(this.nonceStr);
    paramParcel.writeString(this.timeStamp);
    paramParcel.writeString(this.packageExt);
    paramParcel.writeString(this.cnI);
    paramParcel.writeInt(this.wgG);
    paramParcel.writeInt(this.foC);
    paramParcel.writeString(this.cCB);
    paramParcel.writeString(this.flC);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.cCC);
    paramParcel.writeInt(this.cCD);
    paramParcel.writeInt(this.cCE);
    paramParcel.writeInt(this.cqj);
    paramParcel.writeInt(this.wgH);
    paramParcel.writeString(this.extInfo);
    paramParcel.writeInt(this.wgI);
    paramParcel.writeString(this.wgJ);
    paramParcel.writeInt(this.wgK);
    paramParcel.writeString(this.wgL);
    paramParcel.writeString(this.wgM);
    AppMethodBeat.o(141113);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.wallet.WalletJsapiData
 * JD-Core Version:    0.7.0.1
 */