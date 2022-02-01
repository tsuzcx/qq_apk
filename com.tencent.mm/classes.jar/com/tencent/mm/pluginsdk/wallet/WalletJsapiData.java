package com.tencent.mm.pluginsdk.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.or;
import com.tencent.mm.g.a.or.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class WalletJsapiData
  implements Parcelable
{
  public static final Parcelable.Creator<WalletJsapiData> CREATOR;
  public int FEA;
  public int FEB;
  public int FEC;
  public String FED;
  public int FEE;
  public String FEF;
  public String FEG;
  public String FEH;
  public boolean FEI;
  public String FEJ;
  public Map<String, String> FEK;
  public ResultReceiver FEL;
  public String appId;
  public String dDF;
  public String dDG;
  public int dDH;
  public int dDI;
  public String dmw;
  public int dpc;
  public String extInfo;
  public String hIA;
  public int hLO;
  public String nonceStr;
  public String packageExt;
  public String partnerId;
  public String signType;
  public String timeStamp;
  public String url;
  public String zOZ;
  
  static
  {
    AppMethodBeat.i(117574);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(117574);
  }
  
  public WalletJsapiData()
  {
    this.FEC = 0;
    this.FEE = 0;
  }
  
  protected WalletJsapiData(Parcel paramParcel)
  {
    AppMethodBeat.i(117573);
    this.FEC = 0;
    this.FEE = 0;
    this.appId = paramParcel.readString();
    this.partnerId = paramParcel.readString();
    this.signType = paramParcel.readString();
    this.nonceStr = paramParcel.readString();
    this.timeStamp = paramParcel.readString();
    this.packageExt = paramParcel.readString();
    this.dmw = paramParcel.readString();
    this.FEA = paramParcel.readInt();
    this.hLO = paramParcel.readInt();
    this.dDF = paramParcel.readString();
    this.hIA = paramParcel.readString();
    this.url = paramParcel.readString();
    this.dDG = paramParcel.readString();
    this.dDH = paramParcel.readInt();
    this.dDI = paramParcel.readInt();
    this.dpc = paramParcel.readInt();
    this.FEB = paramParcel.readInt();
    this.extInfo = paramParcel.readString();
    this.FEC = paramParcel.readInt();
    this.FED = paramParcel.readString();
    this.FEE = paramParcel.readInt();
    this.FEF = paramParcel.readString();
    this.FEG = paramParcel.readString();
    this.FEH = paramParcel.readString();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.FEI = bool;
      this.zOZ = paramParcel.readString();
      int j = paramParcel.readInt();
      if (j <= 0) {
        break;
      }
      this.FEK = new HashMap();
      while (i < j)
      {
        String str1 = paramParcel.readString();
        String str2 = paramParcel.readString();
        this.FEK.put(str1, str2);
        i += 1;
      }
      bool = false;
    }
    this.FEJ = paramParcel.readString();
    if ("PAY_SUCCESS_AHEAD_CALLBACK_RESULT_RECEIVER_MAGIC_WORD".equals(paramParcel.readString())) {
      this.FEL = ((ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramParcel));
    }
    AppMethodBeat.o(117573);
  }
  
  public WalletJsapiData(or paramor)
  {
    AppMethodBeat.i(117570);
    this.FEC = 0;
    this.FEE = 0;
    if ((paramor == null) || (paramor.dDE == null))
    {
      AppMethodBeat.o(117570);
      return;
    }
    this.appId = paramor.dDE.appId;
    this.partnerId = paramor.dDE.partnerId;
    this.signType = paramor.dDE.signType;
    this.nonceStr = paramor.dDE.nonceStr;
    this.timeStamp = paramor.dDE.timeStamp;
    this.packageExt = paramor.dDE.packageExt;
    this.dDF = paramor.dDE.dDF;
    this.url = paramor.dDE.url;
    this.dDG = paramor.dDE.dDG;
    this.dDH = paramor.dDE.dDH;
    this.dpc = paramor.dDE.dpc;
    this.dDI = paramor.dDE.dDI;
    AppMethodBeat.o(117570);
  }
  
  public WalletJsapiData(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(117568);
    this.FEC = 0;
    this.FEE = 0;
    this.appId = ((String)paramMap.get("appId"));
    this.partnerId = ((String)paramMap.get("partnerId"));
    this.signType = ((String)paramMap.get("signType"));
    this.nonceStr = ((String)paramMap.get("nonceStr"));
    this.timeStamp = ((String)paramMap.get("timeStamp"));
    this.packageExt = ((String)paramMap.get("package"));
    this.dmw = ((String)paramMap.get("reqKey"));
    this.FEA = bu.getInt((String)paramMap.get("payScene"), 1);
    this.hLO = bu.getInt((String)paramMap.get("businessScene"), 1);
    this.dDF = ((String)paramMap.get("paySign"));
    this.url = ((String)paramMap.get("url"));
    this.dDG = ((String)paramMap.get("src_username"));
    this.dDH = bu.getInt((String)paramMap.get("scene"), 0);
    if (this.dDH == 0) {
      this.dDH = bu.getInt((String)paramMap.get("pay_scene"), 0);
    }
    this.dpc = bu.getInt((String)paramMap.get("pay_channel"), 0);
    this.extInfo = bu.nullAsNil((String)paramMap.get("ext_info"));
    this.FED = bu.nullAsNil((String)paramMap.get("token"));
    this.FEE = bu.getInt(bu.bI((String)paramMap.get("result_jump_mode"), "0"), 0);
    this.FEF = bu.nullAsNil((String)paramMap.get("key_appbrand_from_path"));
    this.FEG = bu.nullAsNil((String)paramMap.get("key_appbrand_from_username"));
    this.FEH = bu.nullAsNil((String)paramMap.get("key_appbrand_from_scene"));
    AppMethodBeat.o(117568);
  }
  
  public WalletJsapiData(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(117569);
    this.FEC = 0;
    this.FEE = 0;
    this.appId = paramJSONObject.optString("appId");
    this.partnerId = paramJSONObject.optString("partnerId");
    this.signType = paramJSONObject.optString("signType");
    this.nonceStr = paramJSONObject.optString("nonceStr");
    this.timeStamp = paramJSONObject.optString("timeStamp");
    this.packageExt = paramJSONObject.optString("package");
    this.dmw = paramJSONObject.optString("reqKey");
    this.FEA = paramJSONObject.optInt("payScene", 1);
    this.hLO = paramJSONObject.optInt("businessScene", 1);
    this.dDF = paramJSONObject.optString("paySign");
    this.hIA = paramJSONObject.optString("cookie");
    this.url = paramJSONObject.optString("url");
    this.dDG = paramJSONObject.optString("src_username");
    this.dDH = paramJSONObject.optInt("scene", 0);
    if (this.dDH == 0) {
      this.dDH = paramJSONObject.optInt("pay_scene", 0);
    }
    this.dpc = paramJSONObject.optInt("pay_channel", 0);
    this.extInfo = paramJSONObject.optString("ext_info", "");
    this.FED = paramJSONObject.optString("token", "");
    this.FEE = bu.getInt(paramJSONObject.optString("result_jump_mode", "0"), 0);
    this.FEC = paramJSONObject.optInt("pay_for_wallet_type", 0);
    this.FEF = bu.nullAsNil(paramJSONObject.optString("key_appbrand_from_path"));
    this.FEG = bu.nullAsNil(paramJSONObject.optString("key_appbrand_from_username"));
    this.FEH = bu.nullAsNil(paramJSONObject.optString("key_appbrand_from_scene"));
    this.FEI = paramJSONObject.optBoolean("key_joint_pay", false);
    AppMethodBeat.o(117569);
  }
  
  public static int ju(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 1037) {}
    while (paramInt2 <= 0) {
      return paramInt1;
    }
    return paramInt2;
  }
  
  public static int jv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117571);
    int j = ju(paramInt1, paramInt2);
    int i;
    if ((j == 1000) || (j == 1018) || (j == 1017) || (j == 1033)) {
      i = 0;
    }
    for (;;)
    {
      ae.i("MicroMsg.WalletJsapiData", "parsePayChannelByScene, scene: %s, rawScene: %s, resultChannel: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
      AppMethodBeat.o(117571);
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
    AppMethodBeat.i(117572);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.partnerId);
    paramParcel.writeString(this.signType);
    paramParcel.writeString(this.nonceStr);
    paramParcel.writeString(this.timeStamp);
    paramParcel.writeString(this.packageExt);
    paramParcel.writeString(this.dmw);
    paramParcel.writeInt(this.FEA);
    paramParcel.writeInt(this.hLO);
    paramParcel.writeString(this.dDF);
    paramParcel.writeString(this.hIA);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.dDG);
    paramParcel.writeInt(this.dDH);
    paramParcel.writeInt(this.dDI);
    paramParcel.writeInt(this.dpc);
    paramParcel.writeInt(this.FEB);
    paramParcel.writeString(this.extInfo);
    paramParcel.writeInt(this.FEC);
    paramParcel.writeString(this.FED);
    paramParcel.writeInt(this.FEE);
    paramParcel.writeString(this.FEF);
    paramParcel.writeString(this.FEG);
    paramParcel.writeString(this.FEH);
    if (this.FEI) {}
    for (int i = 1;; i = 0)
    {
      paramParcel.writeInt(i);
      paramParcel.writeString(this.zOZ);
      if (this.FEK == null) {
        break;
      }
      paramParcel.writeInt(this.FEK.size());
      Iterator localIterator = this.FEK.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramParcel.writeString((String)localEntry.getKey());
        paramParcel.writeString((String)localEntry.getValue());
      }
    }
    paramParcel.writeInt(0);
    paramParcel.writeString(this.FEJ);
    if (this.FEL != null)
    {
      paramParcel.writeString("PAY_SUCCESS_AHEAD_CALLBACK_RESULT_RECEIVER_MAGIC_WORD");
      this.FEL.writeToParcel(paramParcel, paramInt);
    }
    AppMethodBeat.o(117572);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.wallet.WalletJsapiData
 * JD-Core Version:    0.7.0.1
 */