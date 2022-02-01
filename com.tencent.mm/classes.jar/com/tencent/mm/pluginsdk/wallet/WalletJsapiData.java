package com.tencent.mm.pluginsdk.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.qh;
import com.tencent.mm.f.a.qh.a;
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
  public String Kkg;
  public String RzA;
  public boolean RzB;
  public String RzC;
  public Map<String, String> RzD;
  public ResultReceiver RzE;
  public int Rzt;
  public int Rzu;
  public int Rzv;
  public String Rzw;
  public int Rzx;
  public String Rzy;
  public String Rzz;
  public String appId;
  public int chatType;
  public String extInfo;
  public String fOW;
  public String fOX;
  public int fOY;
  public int fOZ;
  public String fwv;
  public String ltk;
  public int lwS;
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
    this.Rzv = 0;
    this.Rzx = 0;
  }
  
  protected WalletJsapiData(Parcel paramParcel)
  {
    AppMethodBeat.i(117573);
    this.Rzv = 0;
    this.Rzx = 0;
    this.appId = paramParcel.readString();
    this.partnerId = paramParcel.readString();
    this.signType = paramParcel.readString();
    this.nonceStr = paramParcel.readString();
    this.timeStamp = paramParcel.readString();
    this.packageExt = paramParcel.readString();
    this.fwv = paramParcel.readString();
    this.Rzt = paramParcel.readInt();
    this.lwS = paramParcel.readInt();
    this.fOW = paramParcel.readString();
    this.ltk = paramParcel.readString();
    this.url = paramParcel.readString();
    this.fOX = paramParcel.readString();
    this.fOY = paramParcel.readInt();
    this.fOZ = paramParcel.readInt();
    this.payChannel = paramParcel.readInt();
    this.Rzu = paramParcel.readInt();
    this.extInfo = paramParcel.readString();
    this.Rzv = paramParcel.readInt();
    this.Rzw = paramParcel.readString();
    this.Rzx = paramParcel.readInt();
    this.Rzy = paramParcel.readString();
    this.Rzz = paramParcel.readString();
    this.RzA = paramParcel.readString();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.RzB = bool;
      this.Kkg = paramParcel.readString();
      int j = paramParcel.readInt();
      if (j <= 0) {
        break;
      }
      this.RzD = new HashMap();
      while (i < j)
      {
        String str1 = paramParcel.readString();
        String str2 = paramParcel.readString();
        this.RzD.put(str1, str2);
        i += 1;
      }
      bool = false;
    }
    this.RzC = paramParcel.readString();
    this.chatType = paramParcel.readInt();
    if ("PAY_SUCCESS_AHEAD_CALLBACK_RESULT_RECEIVER_MAGIC_WORD".equals(paramParcel.readString())) {
      this.RzE = ((ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramParcel));
    }
    AppMethodBeat.o(117573);
  }
  
  public WalletJsapiData(qh paramqh)
  {
    AppMethodBeat.i(117570);
    this.Rzv = 0;
    this.Rzx = 0;
    if ((paramqh == null) || (paramqh.fOV == null))
    {
      AppMethodBeat.o(117570);
      return;
    }
    this.appId = paramqh.fOV.appId;
    this.partnerId = paramqh.fOV.partnerId;
    this.signType = paramqh.fOV.signType;
    this.nonceStr = paramqh.fOV.nonceStr;
    this.timeStamp = paramqh.fOV.timeStamp;
    this.packageExt = paramqh.fOV.packageExt;
    this.fOW = paramqh.fOV.fOW;
    this.url = paramqh.fOV.url;
    this.fOX = paramqh.fOV.fOX;
    this.fOY = paramqh.fOV.fOY;
    this.payChannel = paramqh.fOV.payChannel;
    this.fOZ = paramqh.fOV.fOZ;
    AppMethodBeat.o(117570);
  }
  
  public WalletJsapiData(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(117568);
    this.Rzv = 0;
    this.Rzx = 0;
    this.appId = ((String)paramMap.get("appId"));
    this.partnerId = ((String)paramMap.get("partnerId"));
    this.signType = ((String)paramMap.get("signType"));
    this.nonceStr = ((String)paramMap.get("nonceStr"));
    this.timeStamp = ((String)paramMap.get("timeStamp"));
    this.packageExt = ((String)paramMap.get("package"));
    this.fwv = ((String)paramMap.get("reqKey"));
    this.Rzt = Util.getInt((String)paramMap.get("payScene"), 1);
    this.lwS = Util.getInt((String)paramMap.get("businessScene"), 1);
    this.fOW = ((String)paramMap.get("paySign"));
    this.url = ((String)paramMap.get("url"));
    this.fOX = ((String)paramMap.get("src_username"));
    this.fOY = Util.getInt((String)paramMap.get("scene"), 0);
    if (this.fOY == 0) {
      this.fOY = Util.getInt((String)paramMap.get("pay_scene"), 0);
    }
    this.payChannel = Util.getInt((String)paramMap.get("pay_channel"), 0);
    this.extInfo = Util.nullAsNil((String)paramMap.get("ext_info"));
    this.Rzw = Util.nullAsNil((String)paramMap.get("token"));
    this.Rzx = Util.getInt(Util.nullAs((String)paramMap.get("result_jump_mode"), "0"), 0);
    this.Rzy = Util.nullAsNil((String)paramMap.get("key_appbrand_from_path"));
    this.Rzz = Util.nullAsNil((String)paramMap.get("key_appbrand_from_username"));
    this.RzA = Util.nullAsNil((String)paramMap.get("key_appbrand_from_scene"));
    this.chatType = Util.getInt((String)paramMap.get("key_chat_type"), 0);
    AppMethodBeat.o(117568);
  }
  
  public WalletJsapiData(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(117569);
    this.Rzv = 0;
    this.Rzx = 0;
    this.appId = paramJSONObject.optString("appId");
    this.partnerId = paramJSONObject.optString("partnerId");
    this.signType = paramJSONObject.optString("signType");
    this.nonceStr = paramJSONObject.optString("nonceStr");
    this.timeStamp = paramJSONObject.optString("timeStamp");
    this.packageExt = paramJSONObject.optString("package");
    this.fwv = paramJSONObject.optString("reqKey");
    this.Rzt = paramJSONObject.optInt("payScene", 1);
    this.lwS = paramJSONObject.optInt("businessScene", 1);
    this.fOW = paramJSONObject.optString("paySign");
    this.ltk = paramJSONObject.optString("cookie");
    this.url = paramJSONObject.optString("url");
    this.fOX = paramJSONObject.optString("src_username");
    this.fOY = paramJSONObject.optInt("scene", 0);
    if (this.fOY == 0) {
      this.fOY = paramJSONObject.optInt("pay_scene", 0);
    }
    this.payChannel = paramJSONObject.optInt("pay_channel", 0);
    this.extInfo = paramJSONObject.optString("ext_info", "");
    this.Rzw = paramJSONObject.optString("token", "");
    this.Rzx = Util.getInt(paramJSONObject.optString("result_jump_mode", "0"), 0);
    this.Rzv = paramJSONObject.optInt("pay_for_wallet_type", 0);
    this.Rzy = Util.nullAsNil(paramJSONObject.optString("key_appbrand_from_path"));
    this.Rzz = Util.nullAsNil(paramJSONObject.optString("key_appbrand_from_username"));
    this.RzA = Util.nullAsNil(paramJSONObject.optString("key_appbrand_from_scene"));
    this.RzB = paramJSONObject.optBoolean("key_joint_pay", false);
    this.chatType = paramJSONObject.optInt("key_chat_type", 0);
    AppMethodBeat.o(117569);
  }
  
  public static int ard(int paramInt)
  {
    return paramInt;
  }
  
  public static int lZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117571);
    int i;
    if ((paramInt1 == 1000) || (paramInt1 == 1018) || (paramInt1 == 1017) || (paramInt1 == 1033)) {
      i = 0;
    }
    for (;;)
    {
      Log.i("MicroMsg.WalletJsapiData", "parsePayChannelByScene, scene: %s, rawScene: %s, resultChannel: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
      AppMethodBeat.o(117571);
      return i;
      if (paramInt1 == 1019) {
        i = 1;
      } else if (paramInt1 == 1010) {
        i = 5;
      } else if ((paramInt1 == 1007) || (paramInt1 == 1008)) {
        i = 6;
      } else if (paramInt1 == 1009) {
        i = 7;
      } else if ((paramInt1 == 1035) || (paramInt1 == 1020)) {
        i = 8;
      } else if ((paramInt1 == 1011) || (paramInt1 == 1047) || (paramInt1 == 1025)) {
        i = 12;
      } else if ((paramInt1 == 1012) || (paramInt1 == 1032) || (paramInt1 == 1048) || (paramInt1 == 1050)) {
        i = 13;
      } else if ((paramInt1 == 1005) || (paramInt1 == 1027) || (paramInt1 == 1042) || (paramInt1 == 1006)) {
        i = 15;
      } else if ((paramInt1 == 1024) || (paramInt1 == 1021)) {
        i = 16;
      } else if ((paramInt1 == 1029) || (paramInt1 == 1028)) {
        i = 23;
      } else if ((paramInt1 == 1013) || (paramInt1 == 1031) || (paramInt1 == 1049)) {
        i = 24;
      } else if ((paramInt1 == 1001) || (paramInt1 == 1003)) {
        i = 25;
      } else if ((paramInt1 == 1045) || (paramInt1 == 1046)) {
        i = 26;
      } else if (paramInt1 == 1022) {
        i = 27;
      } else if (paramInt1 == 1023) {
        i = 28;
      } else if (paramInt1 == 1026) {
        i = 29;
      } else if (paramInt1 == 1039) {
        i = 30;
      } else if ((paramInt1 == 1034) || (paramInt1 == 1060)) {
        i = 31;
      } else if ((paramInt1 == 1014) || (paramInt1 == 1043) || (paramInt1 == 1044) || (paramInt1 == 1036)) {
        i = 32;
      } else {
        i = paramInt1;
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
    paramParcel.writeString(this.fwv);
    paramParcel.writeInt(this.Rzt);
    paramParcel.writeInt(this.lwS);
    paramParcel.writeString(this.fOW);
    paramParcel.writeString(this.ltk);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.fOX);
    paramParcel.writeInt(this.fOY);
    paramParcel.writeInt(this.fOZ);
    paramParcel.writeInt(this.payChannel);
    paramParcel.writeInt(this.Rzu);
    paramParcel.writeString(this.extInfo);
    paramParcel.writeInt(this.Rzv);
    paramParcel.writeString(this.Rzw);
    paramParcel.writeInt(this.Rzx);
    paramParcel.writeString(this.Rzy);
    paramParcel.writeString(this.Rzz);
    paramParcel.writeString(this.RzA);
    if (this.RzB) {}
    for (int i = 1;; i = 0)
    {
      paramParcel.writeInt(i);
      paramParcel.writeString(this.Kkg);
      if (this.RzD == null) {
        break;
      }
      paramParcel.writeInt(this.RzD.size());
      Iterator localIterator = this.RzD.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramParcel.writeString((String)localEntry.getKey());
        paramParcel.writeString((String)localEntry.getValue());
      }
    }
    paramParcel.writeInt(0);
    paramParcel.writeString(this.RzC);
    paramParcel.writeInt(this.chatType);
    if (this.RzE != null)
    {
      paramParcel.writeString("PAY_SUCCESS_AHEAD_CALLBACK_RESULT_RECEIVER_MAGIC_WORD");
      this.RzE.writeToParcel(paramParcel, paramInt);
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