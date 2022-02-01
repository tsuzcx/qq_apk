package com.tencent.mm.pluginsdk.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  public String QIe;
  public int YvR;
  public int YvS;
  public int YvT;
  public int YvU;
  public String YvV;
  public int YvW;
  public String YvX;
  public String YvY;
  public String YvZ;
  public boolean Ywa;
  public String Ywb;
  public Map<String, String> Ywc;
  public ResultReceiver Ywd;
  public String appId;
  public int chatType;
  public String extInfo;
  public String hAT;
  public String hUP;
  public String hUQ;
  public int hUR;
  public int hUS;
  public String nonceStr;
  public String okK;
  public int oor;
  public String packageExt;
  public String partnerId;
  public int payChannel;
  public String signType;
  public int tOn;
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
    this.YvU = 0;
    this.YvW = 0;
  }
  
  protected WalletJsapiData(Parcel paramParcel)
  {
    AppMethodBeat.i(117573);
    this.YvU = 0;
    this.YvW = 0;
    this.appId = paramParcel.readString();
    this.partnerId = paramParcel.readString();
    this.signType = paramParcel.readString();
    this.nonceStr = paramParcel.readString();
    this.timeStamp = paramParcel.readString();
    this.packageExt = paramParcel.readString();
    this.hAT = paramParcel.readString();
    this.YvR = paramParcel.readInt();
    this.oor = paramParcel.readInt();
    this.hUP = paramParcel.readString();
    this.okK = paramParcel.readString();
    this.url = paramParcel.readString();
    this.hUQ = paramParcel.readString();
    this.hUR = paramParcel.readInt();
    this.hUS = paramParcel.readInt();
    this.payChannel = paramParcel.readInt();
    this.tOn = paramParcel.readInt();
    this.YvS = paramParcel.readInt();
    this.extInfo = paramParcel.readString();
    this.YvU = paramParcel.readInt();
    this.YvV = paramParcel.readString();
    this.YvW = paramParcel.readInt();
    this.YvX = paramParcel.readString();
    this.YvY = paramParcel.readString();
    this.YvZ = paramParcel.readString();
    this.YvT = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.Ywa = bool;
      this.QIe = paramParcel.readString();
      int j = paramParcel.readInt();
      if (j <= 0) {
        break;
      }
      this.Ywc = new HashMap();
      while (i < j)
      {
        String str1 = paramParcel.readString();
        String str2 = paramParcel.readString();
        this.Ywc.put(str1, str2);
        i += 1;
      }
      bool = false;
    }
    this.Ywb = paramParcel.readString();
    this.chatType = paramParcel.readInt();
    if ("PAY_SUCCESS_AHEAD_CALLBACK_RESULT_RECEIVER_MAGIC_WORD".equals(paramParcel.readString())) {
      this.Ywd = ((ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramParcel));
    }
    AppMethodBeat.o(117573);
  }
  
  public WalletJsapiData(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(117568);
    this.YvU = 0;
    this.YvW = 0;
    this.appId = ((String)paramMap.get("appId"));
    this.partnerId = ((String)paramMap.get("partnerId"));
    this.signType = ((String)paramMap.get("signType"));
    this.nonceStr = ((String)paramMap.get("nonceStr"));
    this.timeStamp = ((String)paramMap.get("timeStamp"));
    this.packageExt = ((String)paramMap.get("package"));
    this.hAT = ((String)paramMap.get("reqKey"));
    this.YvR = Util.getInt((String)paramMap.get("payScene"), 1);
    this.oor = Util.getInt((String)paramMap.get("businessScene"), 1);
    this.hUP = ((String)paramMap.get("paySign"));
    this.url = ((String)paramMap.get("url"));
    this.hUQ = ((String)paramMap.get("src_username"));
    this.hUR = Util.getInt((String)paramMap.get("scene"), 0);
    if (this.hUR == 0) {
      this.hUR = Util.getInt((String)paramMap.get("pay_scene"), 0);
    }
    this.payChannel = Util.getInt((String)paramMap.get("pay_channel"), 0);
    this.tOn = Util.getInt((String)paramMap.get("pay_code_scene"), 0);
    this.extInfo = Util.nullAsNil((String)paramMap.get("ext_info"));
    this.YvV = Util.nullAsNil((String)paramMap.get("token"));
    this.YvW = Util.getInt(Util.nullAs((String)paramMap.get("result_jump_mode"), "0"), 0);
    this.YvX = Util.nullAsNil((String)paramMap.get("key_appbrand_from_path"));
    this.YvY = Util.nullAsNil((String)paramMap.get("key_appbrand_from_username"));
    this.YvZ = Util.nullAsNil((String)paramMap.get("key_appbrand_from_scene"));
    this.chatType = Util.getInt((String)paramMap.get("key_chat_type"), 0);
    AppMethodBeat.o(117568);
  }
  
  public WalletJsapiData(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(117569);
    this.YvU = 0;
    this.YvW = 0;
    this.appId = paramJSONObject.optString("appId");
    this.partnerId = paramJSONObject.optString("partnerId");
    this.signType = paramJSONObject.optString("signType");
    this.nonceStr = paramJSONObject.optString("nonceStr");
    this.timeStamp = paramJSONObject.optString("timeStamp");
    this.packageExt = paramJSONObject.optString("package");
    this.hAT = paramJSONObject.optString("reqKey");
    this.YvR = paramJSONObject.optInt("payScene", 1);
    this.oor = paramJSONObject.optInt("businessScene", 1);
    this.hUP = paramJSONObject.optString("paySign");
    this.okK = paramJSONObject.optString("cookie");
    this.url = paramJSONObject.optString("url");
    this.hUQ = paramJSONObject.optString("src_username");
    this.hUR = paramJSONObject.optInt("scene", 0);
    if (this.hUR == 0) {
      this.hUR = paramJSONObject.optInt("pay_scene", 0);
    }
    this.payChannel = paramJSONObject.optInt("pay_channel", 0);
    this.tOn = paramJSONObject.optInt("pay_code_scene", 0);
    this.extInfo = paramJSONObject.optString("ext_info", "");
    this.YvV = paramJSONObject.optString("token", "");
    this.YvW = Util.getInt(paramJSONObject.optString("result_jump_mode", "0"), 0);
    this.YvU = paramJSONObject.optInt("pay_for_wallet_type", 0);
    this.YvX = Util.nullAsNil(paramJSONObject.optString("key_appbrand_from_path"));
    this.YvY = Util.nullAsNil(paramJSONObject.optString("key_appbrand_from_username"));
    this.YvZ = Util.nullAsNil(paramJSONObject.optString("key_appbrand_from_scene"));
    this.Ywa = paramJSONObject.optBoolean("key_joint_pay", false);
    this.chatType = paramJSONObject.optInt("key_chat_type", 0);
    AppMethodBeat.o(117569);
  }
  
  public static int axk(int paramInt)
  {
    return paramInt;
  }
  
  public static int nO(int paramInt1, int paramInt2)
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
    paramParcel.writeString(this.hAT);
    paramParcel.writeInt(this.YvR);
    paramParcel.writeInt(this.oor);
    paramParcel.writeString(this.hUP);
    paramParcel.writeString(this.okK);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.hUQ);
    paramParcel.writeInt(this.hUR);
    paramParcel.writeInt(this.hUS);
    paramParcel.writeInt(this.payChannel);
    paramParcel.writeInt(this.tOn);
    paramParcel.writeInt(this.YvS);
    paramParcel.writeString(this.extInfo);
    paramParcel.writeInt(this.YvU);
    paramParcel.writeString(this.YvV);
    paramParcel.writeInt(this.YvW);
    paramParcel.writeString(this.YvX);
    paramParcel.writeString(this.YvY);
    paramParcel.writeString(this.YvZ);
    paramParcel.writeInt(this.YvT);
    if (this.Ywa) {}
    for (int i = 1;; i = 0)
    {
      paramParcel.writeInt(i);
      paramParcel.writeString(this.QIe);
      if (this.Ywc == null) {
        break;
      }
      paramParcel.writeInt(this.Ywc.size());
      Iterator localIterator = this.Ywc.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramParcel.writeString((String)localEntry.getKey());
        paramParcel.writeString((String)localEntry.getValue());
      }
    }
    paramParcel.writeInt(0);
    paramParcel.writeString(this.Ywb);
    paramParcel.writeInt(this.chatType);
    if (this.Ywd != null)
    {
      paramParcel.writeString("PAY_SUCCESS_AHEAD_CALLBACK_RESULT_RECEIVER_MAGIC_WORD");
      this.Ywd.writeToParcel(paramParcel, paramInt);
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