package com.tencent.mm.pluginsdk.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ny;
import com.tencent.mm.g.a.ny.a;
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
  public int CoD;
  public int CoE;
  public int CoF;
  public String CoG;
  public int CoH;
  public String CoI;
  public String CoJ;
  public String CoK;
  public boolean CoL;
  public String CoM;
  public Map<String, String> CoN;
  public ResultReceiver CoO;
  public String appId;
  public String dcE;
  public int dfg;
  public String dsZ;
  public String dta;
  public int dtb;
  public int dtc;
  public String extInfo;
  public String gMQ;
  public int gQd;
  public String nonceStr;
  public String packageExt;
  public String partnerId;
  public String signType;
  public String timeStamp;
  public String url;
  public String wUF;
  
  static
  {
    AppMethodBeat.i(117574);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(117574);
  }
  
  public WalletJsapiData()
  {
    this.CoF = 0;
    this.CoH = 0;
  }
  
  protected WalletJsapiData(Parcel paramParcel)
  {
    AppMethodBeat.i(117573);
    this.CoF = 0;
    this.CoH = 0;
    this.appId = paramParcel.readString();
    this.partnerId = paramParcel.readString();
    this.signType = paramParcel.readString();
    this.nonceStr = paramParcel.readString();
    this.timeStamp = paramParcel.readString();
    this.packageExt = paramParcel.readString();
    this.dcE = paramParcel.readString();
    this.CoD = paramParcel.readInt();
    this.gQd = paramParcel.readInt();
    this.dsZ = paramParcel.readString();
    this.gMQ = paramParcel.readString();
    this.url = paramParcel.readString();
    this.dta = paramParcel.readString();
    this.dtb = paramParcel.readInt();
    this.dtc = paramParcel.readInt();
    this.dfg = paramParcel.readInt();
    this.CoE = paramParcel.readInt();
    this.extInfo = paramParcel.readString();
    this.CoF = paramParcel.readInt();
    this.CoG = paramParcel.readString();
    this.CoH = paramParcel.readInt();
    this.CoI = paramParcel.readString();
    this.CoJ = paramParcel.readString();
    this.CoK = paramParcel.readString();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.CoL = bool;
      this.wUF = paramParcel.readString();
      int j = paramParcel.readInt();
      if (j <= 0) {
        break;
      }
      this.CoN = new HashMap();
      while (i < j)
      {
        String str1 = paramParcel.readString();
        String str2 = paramParcel.readString();
        this.CoN.put(str1, str2);
        i += 1;
      }
      bool = false;
    }
    this.CoM = paramParcel.readString();
    if ("PAY_SUCCESS_AHEAD_CALLBACK_RESULT_RECEIVER_MAGIC_WORD".equals(paramParcel.readString())) {
      this.CoO = ((ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramParcel));
    }
    AppMethodBeat.o(117573);
  }
  
  public WalletJsapiData(ny paramny)
  {
    AppMethodBeat.i(117570);
    this.CoF = 0;
    this.CoH = 0;
    if ((paramny == null) || (paramny.dsY == null))
    {
      AppMethodBeat.o(117570);
      return;
    }
    this.appId = paramny.dsY.appId;
    this.partnerId = paramny.dsY.partnerId;
    this.signType = paramny.dsY.signType;
    this.nonceStr = paramny.dsY.nonceStr;
    this.timeStamp = paramny.dsY.timeStamp;
    this.packageExt = paramny.dsY.packageExt;
    this.dsZ = paramny.dsY.dsZ;
    this.url = paramny.dsY.url;
    this.dta = paramny.dsY.dta;
    this.dtb = paramny.dsY.dtb;
    this.dfg = paramny.dsY.dfg;
    this.dtc = paramny.dsY.dtc;
    AppMethodBeat.o(117570);
  }
  
  public WalletJsapiData(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(117568);
    this.CoF = 0;
    this.CoH = 0;
    this.appId = ((String)paramMap.get("appId"));
    this.partnerId = ((String)paramMap.get("partnerId"));
    this.signType = ((String)paramMap.get("signType"));
    this.nonceStr = ((String)paramMap.get("nonceStr"));
    this.timeStamp = ((String)paramMap.get("timeStamp"));
    this.packageExt = ((String)paramMap.get("package"));
    this.dcE = ((String)paramMap.get("reqKey"));
    this.CoD = bt.getInt((String)paramMap.get("payScene"), 1);
    this.gQd = bt.getInt((String)paramMap.get("businessScene"), 1);
    this.dsZ = ((String)paramMap.get("paySign"));
    this.url = ((String)paramMap.get("url"));
    this.dta = ((String)paramMap.get("src_username"));
    this.dtb = bt.getInt((String)paramMap.get("scene"), 0);
    if (this.dtb == 0) {
      this.dtb = bt.getInt((String)paramMap.get("pay_scene"), 0);
    }
    this.dfg = bt.getInt((String)paramMap.get("pay_channel"), 0);
    this.extInfo = bt.nullAsNil((String)paramMap.get("ext_info"));
    this.CoG = bt.nullAsNil((String)paramMap.get("token"));
    this.CoH = bt.getInt(bt.by((String)paramMap.get("result_jump_mode"), "0"), 0);
    this.CoI = bt.nullAsNil((String)paramMap.get("key_appbrand_from_path"));
    this.CoJ = bt.nullAsNil((String)paramMap.get("key_appbrand_from_username"));
    this.CoK = bt.nullAsNil((String)paramMap.get("key_appbrand_from_scene"));
    AppMethodBeat.o(117568);
  }
  
  public WalletJsapiData(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(117569);
    this.CoF = 0;
    this.CoH = 0;
    this.appId = paramJSONObject.optString("appId");
    this.partnerId = paramJSONObject.optString("partnerId");
    this.signType = paramJSONObject.optString("signType");
    this.nonceStr = paramJSONObject.optString("nonceStr");
    this.timeStamp = paramJSONObject.optString("timeStamp");
    this.packageExt = paramJSONObject.optString("package");
    this.dcE = paramJSONObject.optString("reqKey");
    this.CoD = paramJSONObject.optInt("payScene", 1);
    this.gQd = paramJSONObject.optInt("businessScene", 1);
    this.dsZ = paramJSONObject.optString("paySign");
    this.gMQ = paramJSONObject.optString("cookie");
    this.url = paramJSONObject.optString("url");
    this.dta = paramJSONObject.optString("src_username");
    this.dtb = paramJSONObject.optInt("scene", 0);
    if (this.dtb == 0) {
      this.dtb = paramJSONObject.optInt("pay_scene", 0);
    }
    this.dfg = paramJSONObject.optInt("pay_channel", 0);
    this.extInfo = paramJSONObject.optString("ext_info", "");
    this.CoG = paramJSONObject.optString("token", "");
    this.CoH = bt.getInt(paramJSONObject.optString("result_jump_mode", "0"), 0);
    this.CoF = paramJSONObject.optInt("pay_for_wallet_type", 0);
    this.CoI = bt.nullAsNil(paramJSONObject.optString("key_appbrand_from_path"));
    this.CoJ = bt.nullAsNil(paramJSONObject.optString("key_appbrand_from_username"));
    this.CoK = bt.nullAsNil(paramJSONObject.optString("key_appbrand_from_scene"));
    this.CoL = paramJSONObject.optBoolean("key_joint_pay", false);
    AppMethodBeat.o(117569);
  }
  
  public static int iR(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 1037) {}
    while (paramInt2 <= 0) {
      return paramInt1;
    }
    return paramInt2;
  }
  
  public static int iS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117571);
    int j = iR(paramInt1, paramInt2);
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
    paramParcel.writeString(this.dcE);
    paramParcel.writeInt(this.CoD);
    paramParcel.writeInt(this.gQd);
    paramParcel.writeString(this.dsZ);
    paramParcel.writeString(this.gMQ);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.dta);
    paramParcel.writeInt(this.dtb);
    paramParcel.writeInt(this.dtc);
    paramParcel.writeInt(this.dfg);
    paramParcel.writeInt(this.CoE);
    paramParcel.writeString(this.extInfo);
    paramParcel.writeInt(this.CoF);
    paramParcel.writeString(this.CoG);
    paramParcel.writeInt(this.CoH);
    paramParcel.writeString(this.CoI);
    paramParcel.writeString(this.CoJ);
    paramParcel.writeString(this.CoK);
    if (this.CoL) {}
    for (int i = 1;; i = 0)
    {
      paramParcel.writeInt(i);
      paramParcel.writeString(this.wUF);
      if (this.CoN == null) {
        break;
      }
      paramParcel.writeInt(this.CoN.size());
      Iterator localIterator = this.CoN.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramParcel.writeString((String)localEntry.getKey());
        paramParcel.writeString((String)localEntry.getValue());
      }
    }
    paramParcel.writeInt(0);
    paramParcel.writeString(this.CoM);
    if (this.CoO != null)
    {
      paramParcel.writeString("PAY_SUCCESS_AHEAD_CALLBACK_RESULT_RECEIVER_MAGIC_WORD");
      this.CoO.writeToParcel(paramParcel, paramInt);
    }
    AppMethodBeat.o(117572);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.wallet.WalletJsapiData
 * JD-Core Version:    0.7.0.1
 */