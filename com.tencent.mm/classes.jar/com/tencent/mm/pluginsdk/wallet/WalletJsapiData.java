package com.tencent.mm.pluginsdk.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.oq;
import com.tencent.mm.g.a.oq.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  public int Fmc;
  public int Fmd;
  public int Fme;
  public String Fmf;
  public int Fmg;
  public String Fmh;
  public String Fmi;
  public String Fmj;
  public boolean Fmk;
  public String Fml;
  public Map<String, String> Fmm;
  public ResultReceiver Fmn;
  public String appId;
  public String dCA;
  public String dCB;
  public int dCC;
  public int dCD;
  public String dlu;
  public int dnX;
  public String extInfo;
  public String hFI;
  public int hIV;
  public String nonceStr;
  public String packageExt;
  public String partnerId;
  public String signType;
  public String timeStamp;
  public String url;
  public String zxA;
  
  static
  {
    AppMethodBeat.i(117574);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(117574);
  }
  
  public WalletJsapiData()
  {
    this.Fme = 0;
    this.Fmg = 0;
  }
  
  protected WalletJsapiData(Parcel paramParcel)
  {
    AppMethodBeat.i(117573);
    this.Fme = 0;
    this.Fmg = 0;
    this.appId = paramParcel.readString();
    this.partnerId = paramParcel.readString();
    this.signType = paramParcel.readString();
    this.nonceStr = paramParcel.readString();
    this.timeStamp = paramParcel.readString();
    this.packageExt = paramParcel.readString();
    this.dlu = paramParcel.readString();
    this.Fmc = paramParcel.readInt();
    this.hIV = paramParcel.readInt();
    this.dCA = paramParcel.readString();
    this.hFI = paramParcel.readString();
    this.url = paramParcel.readString();
    this.dCB = paramParcel.readString();
    this.dCC = paramParcel.readInt();
    this.dCD = paramParcel.readInt();
    this.dnX = paramParcel.readInt();
    this.Fmd = paramParcel.readInt();
    this.extInfo = paramParcel.readString();
    this.Fme = paramParcel.readInt();
    this.Fmf = paramParcel.readString();
    this.Fmg = paramParcel.readInt();
    this.Fmh = paramParcel.readString();
    this.Fmi = paramParcel.readString();
    this.Fmj = paramParcel.readString();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.Fmk = bool;
      this.zxA = paramParcel.readString();
      int j = paramParcel.readInt();
      if (j <= 0) {
        break;
      }
      this.Fmm = new HashMap();
      while (i < j)
      {
        String str1 = paramParcel.readString();
        String str2 = paramParcel.readString();
        this.Fmm.put(str1, str2);
        i += 1;
      }
      bool = false;
    }
    this.Fml = paramParcel.readString();
    if ("PAY_SUCCESS_AHEAD_CALLBACK_RESULT_RECEIVER_MAGIC_WORD".equals(paramParcel.readString())) {
      this.Fmn = ((ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramParcel));
    }
    AppMethodBeat.o(117573);
  }
  
  public WalletJsapiData(oq paramoq)
  {
    AppMethodBeat.i(117570);
    this.Fme = 0;
    this.Fmg = 0;
    if ((paramoq == null) || (paramoq.dCz == null))
    {
      AppMethodBeat.o(117570);
      return;
    }
    this.appId = paramoq.dCz.appId;
    this.partnerId = paramoq.dCz.partnerId;
    this.signType = paramoq.dCz.signType;
    this.nonceStr = paramoq.dCz.nonceStr;
    this.timeStamp = paramoq.dCz.timeStamp;
    this.packageExt = paramoq.dCz.packageExt;
    this.dCA = paramoq.dCz.dCA;
    this.url = paramoq.dCz.url;
    this.dCB = paramoq.dCz.dCB;
    this.dCC = paramoq.dCz.dCC;
    this.dnX = paramoq.dCz.dnX;
    this.dCD = paramoq.dCz.dCD;
    AppMethodBeat.o(117570);
  }
  
  public WalletJsapiData(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(117568);
    this.Fme = 0;
    this.Fmg = 0;
    this.appId = ((String)paramMap.get("appId"));
    this.partnerId = ((String)paramMap.get("partnerId"));
    this.signType = ((String)paramMap.get("signType"));
    this.nonceStr = ((String)paramMap.get("nonceStr"));
    this.timeStamp = ((String)paramMap.get("timeStamp"));
    this.packageExt = ((String)paramMap.get("package"));
    this.dlu = ((String)paramMap.get("reqKey"));
    this.Fmc = bt.getInt((String)paramMap.get("payScene"), 1);
    this.hIV = bt.getInt((String)paramMap.get("businessScene"), 1);
    this.dCA = ((String)paramMap.get("paySign"));
    this.url = ((String)paramMap.get("url"));
    this.dCB = ((String)paramMap.get("src_username"));
    this.dCC = bt.getInt((String)paramMap.get("scene"), 0);
    if (this.dCC == 0) {
      this.dCC = bt.getInt((String)paramMap.get("pay_scene"), 0);
    }
    this.dnX = bt.getInt((String)paramMap.get("pay_channel"), 0);
    this.extInfo = bt.nullAsNil((String)paramMap.get("ext_info"));
    this.Fmf = bt.nullAsNil((String)paramMap.get("token"));
    this.Fmg = bt.getInt(bt.bI((String)paramMap.get("result_jump_mode"), "0"), 0);
    this.Fmh = bt.nullAsNil((String)paramMap.get("key_appbrand_from_path"));
    this.Fmi = bt.nullAsNil((String)paramMap.get("key_appbrand_from_username"));
    this.Fmj = bt.nullAsNil((String)paramMap.get("key_appbrand_from_scene"));
    AppMethodBeat.o(117568);
  }
  
  public WalletJsapiData(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(117569);
    this.Fme = 0;
    this.Fmg = 0;
    this.appId = paramJSONObject.optString("appId");
    this.partnerId = paramJSONObject.optString("partnerId");
    this.signType = paramJSONObject.optString("signType");
    this.nonceStr = paramJSONObject.optString("nonceStr");
    this.timeStamp = paramJSONObject.optString("timeStamp");
    this.packageExt = paramJSONObject.optString("package");
    this.dlu = paramJSONObject.optString("reqKey");
    this.Fmc = paramJSONObject.optInt("payScene", 1);
    this.hIV = paramJSONObject.optInt("businessScene", 1);
    this.dCA = paramJSONObject.optString("paySign");
    this.hFI = paramJSONObject.optString("cookie");
    this.url = paramJSONObject.optString("url");
    this.dCB = paramJSONObject.optString("src_username");
    this.dCC = paramJSONObject.optInt("scene", 0);
    if (this.dCC == 0) {
      this.dCC = paramJSONObject.optInt("pay_scene", 0);
    }
    this.dnX = paramJSONObject.optInt("pay_channel", 0);
    this.extInfo = paramJSONObject.optString("ext_info", "");
    this.Fmf = paramJSONObject.optString("token", "");
    this.Fmg = bt.getInt(paramJSONObject.optString("result_jump_mode", "0"), 0);
    this.Fme = paramJSONObject.optInt("pay_for_wallet_type", 0);
    this.Fmh = bt.nullAsNil(paramJSONObject.optString("key_appbrand_from_path"));
    this.Fmi = bt.nullAsNil(paramJSONObject.optString("key_appbrand_from_username"));
    this.Fmj = bt.nullAsNil(paramJSONObject.optString("key_appbrand_from_scene"));
    this.Fmk = paramJSONObject.optBoolean("key_joint_pay", false);
    AppMethodBeat.o(117569);
  }
  
  public static int jq(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 1037) {}
    while (paramInt2 <= 0) {
      return paramInt1;
    }
    return paramInt2;
  }
  
  public static int jr(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117571);
    int j = jq(paramInt1, paramInt2);
    int i;
    if ((j == 1000) || (j == 1018) || (j == 1017) || (j == 1033)) {
      i = 0;
    }
    for (;;)
    {
      ad.i("MicroMsg.WalletJsapiData", "parsePayChannelByScene, scene: %s, rawScene: %s, resultChannel: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
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
    paramParcel.writeString(this.dlu);
    paramParcel.writeInt(this.Fmc);
    paramParcel.writeInt(this.hIV);
    paramParcel.writeString(this.dCA);
    paramParcel.writeString(this.hFI);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.dCB);
    paramParcel.writeInt(this.dCC);
    paramParcel.writeInt(this.dCD);
    paramParcel.writeInt(this.dnX);
    paramParcel.writeInt(this.Fmd);
    paramParcel.writeString(this.extInfo);
    paramParcel.writeInt(this.Fme);
    paramParcel.writeString(this.Fmf);
    paramParcel.writeInt(this.Fmg);
    paramParcel.writeString(this.Fmh);
    paramParcel.writeString(this.Fmi);
    paramParcel.writeString(this.Fmj);
    if (this.Fmk) {}
    for (int i = 1;; i = 0)
    {
      paramParcel.writeInt(i);
      paramParcel.writeString(this.zxA);
      if (this.Fmm == null) {
        break;
      }
      paramParcel.writeInt(this.Fmm.size());
      Iterator localIterator = this.Fmm.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramParcel.writeString((String)localEntry.getKey());
        paramParcel.writeString((String)localEntry.getValue());
      }
    }
    paramParcel.writeInt(0);
    paramParcel.writeString(this.Fml);
    if (this.Fmn != null)
    {
      paramParcel.writeString("PAY_SUCCESS_AHEAD_CALLBACK_RESULT_RECEIVER_MAGIC_WORD");
      this.Fmn.writeToParcel(paramParcel, paramInt);
    }
    AppMethodBeat.o(117572);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.wallet.WalletJsapiData
 * JD-Core Version:    0.7.0.1
 */