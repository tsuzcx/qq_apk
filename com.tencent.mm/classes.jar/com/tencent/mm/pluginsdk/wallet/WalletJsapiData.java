package com.tencent.mm.pluginsdk.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.oh;
import com.tencent.mm.g.a.oh.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
  public int DGV;
  public int DGW;
  public int DGX;
  public String DGY;
  public int DGZ;
  public String DHa;
  public String DHb;
  public String DHc;
  public boolean DHd;
  public String DHe;
  public Map<String, String> DHf;
  public ResultReceiver DHg;
  public String appId;
  public String dac;
  public int dcB;
  public String dqJ;
  public String dqK;
  public int dqL;
  public int dqM;
  public String extInfo;
  public String hnq;
  public int hqD;
  public String nonceStr;
  public String packageExt;
  public String partnerId;
  public String signType;
  public String timeStamp;
  public String url;
  public String yht;
  
  static
  {
    AppMethodBeat.i(117574);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(117574);
  }
  
  public WalletJsapiData()
  {
    this.DGX = 0;
    this.DGZ = 0;
  }
  
  protected WalletJsapiData(Parcel paramParcel)
  {
    AppMethodBeat.i(117573);
    this.DGX = 0;
    this.DGZ = 0;
    this.appId = paramParcel.readString();
    this.partnerId = paramParcel.readString();
    this.signType = paramParcel.readString();
    this.nonceStr = paramParcel.readString();
    this.timeStamp = paramParcel.readString();
    this.packageExt = paramParcel.readString();
    this.dac = paramParcel.readString();
    this.DGV = paramParcel.readInt();
    this.hqD = paramParcel.readInt();
    this.dqJ = paramParcel.readString();
    this.hnq = paramParcel.readString();
    this.url = paramParcel.readString();
    this.dqK = paramParcel.readString();
    this.dqL = paramParcel.readInt();
    this.dqM = paramParcel.readInt();
    this.dcB = paramParcel.readInt();
    this.DGW = paramParcel.readInt();
    this.extInfo = paramParcel.readString();
    this.DGX = paramParcel.readInt();
    this.DGY = paramParcel.readString();
    this.DGZ = paramParcel.readInt();
    this.DHa = paramParcel.readString();
    this.DHb = paramParcel.readString();
    this.DHc = paramParcel.readString();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.DHd = bool;
      this.yht = paramParcel.readString();
      int j = paramParcel.readInt();
      if (j <= 0) {
        break;
      }
      this.DHf = new HashMap();
      while (i < j)
      {
        String str1 = paramParcel.readString();
        String str2 = paramParcel.readString();
        this.DHf.put(str1, str2);
        i += 1;
      }
      bool = false;
    }
    this.DHe = paramParcel.readString();
    if ("PAY_SUCCESS_AHEAD_CALLBACK_RESULT_RECEIVER_MAGIC_WORD".equals(paramParcel.readString())) {
      this.DHg = ((ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramParcel));
    }
    AppMethodBeat.o(117573);
  }
  
  public WalletJsapiData(oh paramoh)
  {
    AppMethodBeat.i(117570);
    this.DGX = 0;
    this.DGZ = 0;
    if ((paramoh == null) || (paramoh.dqI == null))
    {
      AppMethodBeat.o(117570);
      return;
    }
    this.appId = paramoh.dqI.appId;
    this.partnerId = paramoh.dqI.partnerId;
    this.signType = paramoh.dqI.signType;
    this.nonceStr = paramoh.dqI.nonceStr;
    this.timeStamp = paramoh.dqI.timeStamp;
    this.packageExt = paramoh.dqI.packageExt;
    this.dqJ = paramoh.dqI.dqJ;
    this.url = paramoh.dqI.url;
    this.dqK = paramoh.dqI.dqK;
    this.dqL = paramoh.dqI.dqL;
    this.dcB = paramoh.dqI.dcB;
    this.dqM = paramoh.dqI.dqM;
    AppMethodBeat.o(117570);
  }
  
  public WalletJsapiData(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(117568);
    this.DGX = 0;
    this.DGZ = 0;
    this.appId = ((String)paramMap.get("appId"));
    this.partnerId = ((String)paramMap.get("partnerId"));
    this.signType = ((String)paramMap.get("signType"));
    this.nonceStr = ((String)paramMap.get("nonceStr"));
    this.timeStamp = ((String)paramMap.get("timeStamp"));
    this.packageExt = ((String)paramMap.get("package"));
    this.dac = ((String)paramMap.get("reqKey"));
    this.DGV = bs.getInt((String)paramMap.get("payScene"), 1);
    this.hqD = bs.getInt((String)paramMap.get("businessScene"), 1);
    this.dqJ = ((String)paramMap.get("paySign"));
    this.url = ((String)paramMap.get("url"));
    this.dqK = ((String)paramMap.get("src_username"));
    this.dqL = bs.getInt((String)paramMap.get("scene"), 0);
    if (this.dqL == 0) {
      this.dqL = bs.getInt((String)paramMap.get("pay_scene"), 0);
    }
    this.dcB = bs.getInt((String)paramMap.get("pay_channel"), 0);
    this.extInfo = bs.nullAsNil((String)paramMap.get("ext_info"));
    this.DGY = bs.nullAsNil((String)paramMap.get("token"));
    this.DGZ = bs.getInt(bs.bG((String)paramMap.get("result_jump_mode"), "0"), 0);
    this.DHa = bs.nullAsNil((String)paramMap.get("key_appbrand_from_path"));
    this.DHb = bs.nullAsNil((String)paramMap.get("key_appbrand_from_username"));
    this.DHc = bs.nullAsNil((String)paramMap.get("key_appbrand_from_scene"));
    AppMethodBeat.o(117568);
  }
  
  public WalletJsapiData(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(117569);
    this.DGX = 0;
    this.DGZ = 0;
    this.appId = paramJSONObject.optString("appId");
    this.partnerId = paramJSONObject.optString("partnerId");
    this.signType = paramJSONObject.optString("signType");
    this.nonceStr = paramJSONObject.optString("nonceStr");
    this.timeStamp = paramJSONObject.optString("timeStamp");
    this.packageExt = paramJSONObject.optString("package");
    this.dac = paramJSONObject.optString("reqKey");
    this.DGV = paramJSONObject.optInt("payScene", 1);
    this.hqD = paramJSONObject.optInt("businessScene", 1);
    this.dqJ = paramJSONObject.optString("paySign");
    this.hnq = paramJSONObject.optString("cookie");
    this.url = paramJSONObject.optString("url");
    this.dqK = paramJSONObject.optString("src_username");
    this.dqL = paramJSONObject.optInt("scene", 0);
    if (this.dqL == 0) {
      this.dqL = paramJSONObject.optInt("pay_scene", 0);
    }
    this.dcB = paramJSONObject.optInt("pay_channel", 0);
    this.extInfo = paramJSONObject.optString("ext_info", "");
    this.DGY = paramJSONObject.optString("token", "");
    this.DGZ = bs.getInt(paramJSONObject.optString("result_jump_mode", "0"), 0);
    this.DGX = paramJSONObject.optInt("pay_for_wallet_type", 0);
    this.DHa = bs.nullAsNil(paramJSONObject.optString("key_appbrand_from_path"));
    this.DHb = bs.nullAsNil(paramJSONObject.optString("key_appbrand_from_username"));
    this.DHc = bs.nullAsNil(paramJSONObject.optString("key_appbrand_from_scene"));
    this.DHd = paramJSONObject.optBoolean("key_joint_pay", false);
    AppMethodBeat.o(117569);
  }
  
  public static int je(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 1037) {}
    while (paramInt2 <= 0) {
      return paramInt1;
    }
    return paramInt2;
  }
  
  public static int jf(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117571);
    int j = je(paramInt1, paramInt2);
    int i;
    if ((j == 1000) || (j == 1018) || (j == 1017) || (j == 1033)) {
      i = 0;
    }
    for (;;)
    {
      ac.i("MicroMsg.WalletJsapiData", "parsePayChannelByScene, scene: %s, rawScene: %s, resultChannel: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
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
    paramParcel.writeString(this.dac);
    paramParcel.writeInt(this.DGV);
    paramParcel.writeInt(this.hqD);
    paramParcel.writeString(this.dqJ);
    paramParcel.writeString(this.hnq);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.dqK);
    paramParcel.writeInt(this.dqL);
    paramParcel.writeInt(this.dqM);
    paramParcel.writeInt(this.dcB);
    paramParcel.writeInt(this.DGW);
    paramParcel.writeString(this.extInfo);
    paramParcel.writeInt(this.DGX);
    paramParcel.writeString(this.DGY);
    paramParcel.writeInt(this.DGZ);
    paramParcel.writeString(this.DHa);
    paramParcel.writeString(this.DHb);
    paramParcel.writeString(this.DHc);
    if (this.DHd) {}
    for (int i = 1;; i = 0)
    {
      paramParcel.writeInt(i);
      paramParcel.writeString(this.yht);
      if (this.DHf == null) {
        break;
      }
      paramParcel.writeInt(this.DHf.size());
      Iterator localIterator = this.DHf.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramParcel.writeString((String)localEntry.getKey());
        paramParcel.writeString((String)localEntry.getValue());
      }
    }
    paramParcel.writeInt(0);
    paramParcel.writeString(this.DHe);
    if (this.DHg != null)
    {
      paramParcel.writeString("PAY_SUCCESS_AHEAD_CALLBACK_RESULT_RECEIVER_MAGIC_WORD");
      this.DHg.writeToParcel(paramParcel, paramInt);
    }
    AppMethodBeat.o(117572);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.wallet.WalletJsapiData
 * JD-Core Version:    0.7.0.1
 */