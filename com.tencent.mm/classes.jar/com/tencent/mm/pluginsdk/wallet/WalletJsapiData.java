package com.tencent.mm.pluginsdk.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pj;
import com.tencent.mm.g.a.pj.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
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
  public String DWX;
  public int KxF;
  public int KxG;
  public int KxH;
  public String KxI;
  public int KxJ;
  public String KxK;
  public String KxL;
  public String KxM;
  public boolean KxN;
  public String KxO;
  public Map<String, String> KxP;
  public ResultReceiver KxQ;
  public String appId;
  public String dDL;
  public String dVt;
  public String dVu;
  public int dVv;
  public int dVw;
  public String extInfo;
  public String iDk;
  public int iGQ;
  public String nonceStr;
  public String packageExt;
  public String partnerId;
  public int payChannel;
  public String signType;
  public String timeStamp;
  public String url;
  
  static
  {
    AppMethodBeat.i(117574);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(117574);
  }
  
  public WalletJsapiData()
  {
    this.KxH = 0;
    this.KxJ = 0;
  }
  
  protected WalletJsapiData(Parcel paramParcel)
  {
    AppMethodBeat.i(117573);
    this.KxH = 0;
    this.KxJ = 0;
    this.appId = paramParcel.readString();
    this.partnerId = paramParcel.readString();
    this.signType = paramParcel.readString();
    this.nonceStr = paramParcel.readString();
    this.timeStamp = paramParcel.readString();
    this.packageExt = paramParcel.readString();
    this.dDL = paramParcel.readString();
    this.KxF = paramParcel.readInt();
    this.iGQ = paramParcel.readInt();
    this.dVt = paramParcel.readString();
    this.iDk = paramParcel.readString();
    this.url = paramParcel.readString();
    this.dVu = paramParcel.readString();
    this.dVv = paramParcel.readInt();
    this.dVw = paramParcel.readInt();
    this.payChannel = paramParcel.readInt();
    this.KxG = paramParcel.readInt();
    this.extInfo = paramParcel.readString();
    this.KxH = paramParcel.readInt();
    this.KxI = paramParcel.readString();
    this.KxJ = paramParcel.readInt();
    this.KxK = paramParcel.readString();
    this.KxL = paramParcel.readString();
    this.KxM = paramParcel.readString();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.KxN = bool;
      this.DWX = paramParcel.readString();
      int j = paramParcel.readInt();
      if (j <= 0) {
        break;
      }
      this.KxP = new HashMap();
      while (i < j)
      {
        String str1 = paramParcel.readString();
        String str2 = paramParcel.readString();
        this.KxP.put(str1, str2);
        i += 1;
      }
      bool = false;
    }
    this.KxO = paramParcel.readString();
    if ("PAY_SUCCESS_AHEAD_CALLBACK_RESULT_RECEIVER_MAGIC_WORD".equals(paramParcel.readString())) {
      this.KxQ = ((ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramParcel));
    }
    AppMethodBeat.o(117573);
  }
  
  public WalletJsapiData(pj parampj)
  {
    AppMethodBeat.i(117570);
    this.KxH = 0;
    this.KxJ = 0;
    if ((parampj == null) || (parampj.dVs == null))
    {
      AppMethodBeat.o(117570);
      return;
    }
    this.appId = parampj.dVs.appId;
    this.partnerId = parampj.dVs.partnerId;
    this.signType = parampj.dVs.signType;
    this.nonceStr = parampj.dVs.nonceStr;
    this.timeStamp = parampj.dVs.timeStamp;
    this.packageExt = parampj.dVs.packageExt;
    this.dVt = parampj.dVs.dVt;
    this.url = parampj.dVs.url;
    this.dVu = parampj.dVs.dVu;
    this.dVv = parampj.dVs.dVv;
    this.payChannel = parampj.dVs.payChannel;
    this.dVw = parampj.dVs.dVw;
    AppMethodBeat.o(117570);
  }
  
  public WalletJsapiData(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(117568);
    this.KxH = 0;
    this.KxJ = 0;
    this.appId = ((String)paramMap.get("appId"));
    this.partnerId = ((String)paramMap.get("partnerId"));
    this.signType = ((String)paramMap.get("signType"));
    this.nonceStr = ((String)paramMap.get("nonceStr"));
    this.timeStamp = ((String)paramMap.get("timeStamp"));
    this.packageExt = ((String)paramMap.get("package"));
    this.dDL = ((String)paramMap.get("reqKey"));
    this.KxF = Util.getInt((String)paramMap.get("payScene"), 1);
    this.iGQ = Util.getInt((String)paramMap.get("businessScene"), 1);
    this.dVt = ((String)paramMap.get("paySign"));
    this.url = ((String)paramMap.get("url"));
    this.dVu = ((String)paramMap.get("src_username"));
    this.dVv = Util.getInt((String)paramMap.get("scene"), 0);
    if (this.dVv == 0) {
      this.dVv = Util.getInt((String)paramMap.get("pay_scene"), 0);
    }
    this.payChannel = Util.getInt((String)paramMap.get("pay_channel"), 0);
    this.extInfo = Util.nullAsNil((String)paramMap.get("ext_info"));
    this.KxI = Util.nullAsNil((String)paramMap.get("token"));
    this.KxJ = Util.getInt(Util.nullAs((String)paramMap.get("result_jump_mode"), "0"), 0);
    this.KxK = Util.nullAsNil((String)paramMap.get("key_appbrand_from_path"));
    this.KxL = Util.nullAsNil((String)paramMap.get("key_appbrand_from_username"));
    this.KxM = Util.nullAsNil((String)paramMap.get("key_appbrand_from_scene"));
    AppMethodBeat.o(117568);
  }
  
  public WalletJsapiData(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(117569);
    this.KxH = 0;
    this.KxJ = 0;
    this.appId = paramJSONObject.optString("appId");
    this.partnerId = paramJSONObject.optString("partnerId");
    this.signType = paramJSONObject.optString("signType");
    this.nonceStr = paramJSONObject.optString("nonceStr");
    this.timeStamp = paramJSONObject.optString("timeStamp");
    this.packageExt = paramJSONObject.optString("package");
    this.dDL = paramJSONObject.optString("reqKey");
    this.KxF = paramJSONObject.optInt("payScene", 1);
    this.iGQ = paramJSONObject.optInt("businessScene", 1);
    this.dVt = paramJSONObject.optString("paySign");
    this.iDk = paramJSONObject.optString("cookie");
    this.url = paramJSONObject.optString("url");
    this.dVu = paramJSONObject.optString("src_username");
    this.dVv = paramJSONObject.optInt("scene", 0);
    if (this.dVv == 0) {
      this.dVv = paramJSONObject.optInt("pay_scene", 0);
    }
    this.payChannel = paramJSONObject.optInt("pay_channel", 0);
    this.extInfo = paramJSONObject.optString("ext_info", "");
    this.KxI = paramJSONObject.optString("token", "");
    this.KxJ = Util.getInt(paramJSONObject.optString("result_jump_mode", "0"), 0);
    this.KxH = paramJSONObject.optInt("pay_for_wallet_type", 0);
    this.KxK = Util.nullAsNil(paramJSONObject.optString("key_appbrand_from_path"));
    this.KxL = Util.nullAsNil(paramJSONObject.optString("key_appbrand_from_username"));
    this.KxM = Util.nullAsNil(paramJSONObject.optString("key_appbrand_from_scene"));
    this.KxN = paramJSONObject.optBoolean("key_joint_pay", false);
    AppMethodBeat.o(117569);
  }
  
  public static int kG(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 1037) {}
    while (paramInt2 <= 0) {
      return paramInt1;
    }
    return paramInt2;
  }
  
  public static int kH(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117571);
    int j = kG(paramInt1, paramInt2);
    int i;
    if ((j == 1000) || (j == 1018) || (j == 1017) || (j == 1033)) {
      i = 0;
    }
    for (;;)
    {
      Log.i("MicroMsg.WalletJsapiData", "parsePayChannelByScene, scene: %s, rawScene: %s, resultChannel: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
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
    paramParcel.writeString(this.dDL);
    paramParcel.writeInt(this.KxF);
    paramParcel.writeInt(this.iGQ);
    paramParcel.writeString(this.dVt);
    paramParcel.writeString(this.iDk);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.dVu);
    paramParcel.writeInt(this.dVv);
    paramParcel.writeInt(this.dVw);
    paramParcel.writeInt(this.payChannel);
    paramParcel.writeInt(this.KxG);
    paramParcel.writeString(this.extInfo);
    paramParcel.writeInt(this.KxH);
    paramParcel.writeString(this.KxI);
    paramParcel.writeInt(this.KxJ);
    paramParcel.writeString(this.KxK);
    paramParcel.writeString(this.KxL);
    paramParcel.writeString(this.KxM);
    if (this.KxN) {}
    for (int i = 1;; i = 0)
    {
      paramParcel.writeInt(i);
      paramParcel.writeString(this.DWX);
      if (this.KxP == null) {
        break;
      }
      paramParcel.writeInt(this.KxP.size());
      Iterator localIterator = this.KxP.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramParcel.writeString((String)localEntry.getKey());
        paramParcel.writeString((String)localEntry.getValue());
      }
    }
    paramParcel.writeInt(0);
    paramParcel.writeString(this.KxO);
    if (this.KxQ != null)
    {
      paramParcel.writeString("PAY_SUCCESS_AHEAD_CALLBACK_RESULT_RECEIVER_MAGIC_WORD");
      this.KxQ.writeToParcel(paramParcel, paramInt);
      AppMethodBeat.o(117572);
      return;
    }
    paramParcel.writeString(null);
    AppMethodBeat.o(117572);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.wallet.WalletJsapiData
 * JD-Core Version:    0.7.0.1
 */