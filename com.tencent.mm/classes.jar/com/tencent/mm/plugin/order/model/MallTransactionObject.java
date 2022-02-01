package com.tencent.mm.plugin.order.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class MallTransactionObject
  implements Parcelable
{
  public static final Parcelable.Creator<MallTransactionObject> CREATOR;
  public String GHA;
  public String GHB;
  public String GHC;
  public String GHD;
  public double GHE;
  public String GHF;
  public String GHG;
  public String GHH;
  public String GHI;
  public String GHJ;
  public int GHK;
  public int GHL;
  public double GHM;
  public String GHN;
  public int GHO;
  public String GHP;
  public int GHQ;
  public int GHR;
  public int GHS;
  public String GHT;
  public String GHU;
  public String GHV;
  public String GHW;
  public String GHX;
  public String GHY;
  public double GHZ;
  public List<MallOrderDetailObject.HelpCenter> GHa;
  public int GHb;
  public String GHd;
  public String GHl;
  public String GHm;
  public String GHn;
  public String GHo;
  public String GHp;
  public String GHq;
  public String GHr;
  public String GHs;
  public String GHt;
  public String GHu;
  public int GHv;
  public String GHw;
  public String GHx;
  public String GHy;
  public String GHz;
  public String GIa;
  public int createTime;
  public String desc;
  public int fqR;
  public String fvb;
  public String fww;
  public int gag;
  public String mnM;
  public int subType;
  public double tVK;
  public int type;
  
  static
  {
    AppMethodBeat.i(66680);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(66680);
  }
  
  public MallTransactionObject()
  {
    AppMethodBeat.i(66675);
    this.tVK = 0.0D;
    this.GHa = new LinkedList();
    this.GHb = -1;
    AppMethodBeat.o(66675);
  }
  
  public MallTransactionObject(Parcel paramParcel)
  {
    AppMethodBeat.i(66676);
    this.tVK = 0.0D;
    this.GHa = new LinkedList();
    this.GHb = -1;
    this.subType = paramParcel.readInt();
    this.gag = paramParcel.readInt();
    this.fqR = paramParcel.readInt();
    this.GHl = paramParcel.readString();
    this.GHm = paramParcel.readString();
    this.GHn = paramParcel.readString();
    this.GHo = paramParcel.readString();
    this.desc = paramParcel.readString();
    this.GHp = paramParcel.readString();
    this.GHq = paramParcel.readString();
    this.tVK = paramParcel.readDouble();
    this.GHr = paramParcel.readString();
    this.GHs = paramParcel.readString();
    this.GHt = paramParcel.readString();
    this.GHu = paramParcel.readString();
    this.createTime = paramParcel.readInt();
    this.GHv = paramParcel.readInt();
    this.fww = paramParcel.readString();
    this.GHw = paramParcel.readString();
    this.GHx = paramParcel.readString();
    this.GHz = paramParcel.readString();
    this.fvb = paramParcel.readString();
    this.GHd = paramParcel.readString();
    this.GHA = paramParcel.readString();
    this.mnM = paramParcel.readString();
    this.GHB = paramParcel.readString();
    this.GHC = paramParcel.readString();
    this.GHD = paramParcel.readString();
    this.GHE = paramParcel.readDouble();
    this.GHF = paramParcel.readString();
    this.GHG = paramParcel.readString();
    this.GHH = paramParcel.readString();
    this.GHI = paramParcel.readString();
    this.GHK = paramParcel.readInt();
    this.GHQ = paramParcel.readInt();
    this.GHM = paramParcel.readDouble();
    this.GHN = paramParcel.readString();
    this.GHO = paramParcel.readInt();
    this.GHP = paramParcel.readString();
    this.GHQ = paramParcel.readInt();
    this.GHR = paramParcel.readInt();
    this.GHS = paramParcel.readInt();
    this.GHT = paramParcel.readString();
    this.GHU = paramParcel.readString();
    this.GHV = paramParcel.readString();
    this.GHW = paramParcel.readString();
    this.GHX = paramParcel.readString();
    this.GHY = paramParcel.readString();
    this.GHZ = paramParcel.readDouble();
    this.GIa = paramParcel.readString();
    this.GHJ = paramParcel.readString();
    this.GHb = paramParcel.readInt();
    int j = paramParcel.readInt();
    this.GHa = new LinkedList();
    int i = 0;
    while (i < j)
    {
      MallOrderDetailObject.HelpCenter localHelpCenter = (MallOrderDetailObject.HelpCenter)paramParcel.readParcelable(MallOrderDetailObject.HelpCenter.class.getClassLoader());
      this.GHa.add(localHelpCenter);
      i += 1;
    }
    AppMethodBeat.o(66676);
  }
  
  public static MallTransactionObject bo(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(66678);
    if (paramJSONObject != null)
    {
      MallTransactionObject localMallTransactionObject = new MallTransactionObject();
      localMallTransactionObject.type = paramJSONObject.optInt("rec_type", 1);
      localMallTransactionObject.subType = paramJSONObject.optInt("sub_pay_type", 0);
      localMallTransactionObject.gag = paramJSONObject.optInt("pay_scene");
      localMallTransactionObject.fqR = paramJSONObject.optInt("user_type");
      localMallTransactionObject.GHl = paramJSONObject.optString("buy_uin");
      localMallTransactionObject.GHm = paramJSONObject.optString("buy_name");
      localMallTransactionObject.GHn = paramJSONObject.optString("sale_uin");
      localMallTransactionObject.GHo = paramJSONObject.optString("sale_name");
      localMallTransactionObject.fww = paramJSONObject.optString("trans_id");
      localMallTransactionObject.GHw = paramJSONObject.optString("sp_billno");
      localMallTransactionObject.desc = paramJSONObject.optString("goods_name");
      localMallTransactionObject.GHp = paramJSONObject.optString("goods_detail");
      localMallTransactionObject.tVK = (paramJSONObject.optDouble("fee") / 100.0D);
      localMallTransactionObject.GHr = paramJSONObject.optString("fee_color");
      localMallTransactionObject.GHs = paramJSONObject.optString("trade_state");
      localMallTransactionObject.GHt = paramJSONObject.optString("trade_state_name");
      localMallTransactionObject.GHu = paramJSONObject.optString("trade_state_color");
      localMallTransactionObject.GHx = paramJSONObject.optString("buy_bank_name");
      localMallTransactionObject.GHy = paramJSONObject.optString("card_tail");
      localMallTransactionObject.createTime = paramJSONObject.optInt("create_timestamp");
      localMallTransactionObject.GHv = paramJSONObject.optInt("modify_timestamp");
      localMallTransactionObject.GHz = paramJSONObject.optString("fee_type");
      JSONObject localJSONObject = paramJSONObject.optJSONObject("appinfo");
      if (localJSONObject != null)
      {
        localMallTransactionObject.fvb = localJSONObject.optString("app_username");
        localMallTransactionObject.GHd = localJSONObject.optString("app_telephone");
        localMallTransactionObject.GHA = localJSONObject.optString("app_nickname");
        localMallTransactionObject.mnM = localJSONObject.optString("app_icon_url");
        localMallTransactionObject.GHI = localJSONObject.optString("safeguard_url");
        localMallTransactionObject.GHJ = localJSONObject.optString("display_name");
      }
      localMallTransactionObject.GHB = paramJSONObject.optString("deliver_price");
      localMallTransactionObject.GHC = paramJSONObject.optString("preferential_price");
      localMallTransactionObject.GHD = paramJSONObject.optString("discount");
      localMallTransactionObject.GHE = (paramJSONObject.optDouble("original_total_fee") / 100.0D);
      localMallTransactionObject.GHF = paramJSONObject.optString("total_price");
      localMallTransactionObject.GHG = paramJSONObject.optString("receipt_company");
      localMallTransactionObject.GHH = paramJSONObject.optString("biz_pledge");
      localMallTransactionObject.GHK = paramJSONObject.optInt("pre_fetch_timestamp");
      localMallTransactionObject.GHL = paramJSONObject.optInt("arrived_timestamp");
      localMallTransactionObject.GHM = (paramJSONObject.optDouble("transfer_fee") / 100.0D);
      localMallTransactionObject.GHN = paramJSONObject.optString("receiver_name");
      localMallTransactionObject.GHO = paramJSONObject.optInt("allow_resend_msg");
      localMallTransactionObject.GHP = paramJSONObject.optString("charge_fee");
      localMallTransactionObject.GHQ = paramJSONObject.optInt("receive_timestamp");
      localMallTransactionObject.GHR = paramJSONObject.optInt("refund_timestamp");
      localMallTransactionObject.GHS = paramJSONObject.optInt("create_timestamp");
      localMallTransactionObject.GHT = paramJSONObject.optString("buy_bank_type");
      localMallTransactionObject.GHU = paramJSONObject.optString("payer_name");
      localMallTransactionObject.GHV = paramJSONObject.optString("true_name");
      localMallTransactionObject.GHW = paramJSONObject.optString("refund_bank_type");
      localMallTransactionObject.GHX = paramJSONObject.optString("rateinfo");
      localMallTransactionObject.GHY = paramJSONObject.optString("original_feeinfo");
      localMallTransactionObject.GHZ = (paramJSONObject.optDouble("fetch_total_fee") / 100.0D);
      localMallTransactionObject.GIa = paramJSONObject.optString("fetch_total_fee_color");
      localMallTransactionObject.GHb = paramJSONObject.optInt("userroll_type");
      localMallTransactionObject.GHa = bp(paramJSONObject);
      AppMethodBeat.o(66678);
      return localMallTransactionObject;
    }
    AppMethodBeat.o(66678);
    return null;
  }
  
  private static List<MallOrderDetailObject.HelpCenter> bp(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(66679);
    localLinkedList = new LinkedList();
    try
    {
      paramJSONObject = paramJSONObject.getJSONArray("help_center");
      int i = 0;
      while (i < paramJSONObject.length())
      {
        MallOrderDetailObject.HelpCenter localHelpCenter = new MallOrderDetailObject.HelpCenter();
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        localHelpCenter.fxt = localJSONObject.optBoolean("is_show_button");
        localHelpCenter.name = localJSONObject.optString("name");
        localHelpCenter.url = localJSONObject.optString("url");
        localLinkedList.add(localHelpCenter);
        i += 1;
      }
      return localLinkedList;
    }
    catch (Exception paramJSONObject)
    {
      Log.printErrStackTrace("MicroMsg.MallTransactionObject", paramJSONObject, "", new Object[0]);
      Log.e("MicroMsg.MallTransactionObject", "parseHelpCenter error %s", new Object[] { paramJSONObject.getMessage() });
      AppMethodBeat.o(66679);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(66677);
    paramParcel.writeInt(this.subType);
    paramParcel.writeInt(this.gag);
    paramParcel.writeInt(this.fqR);
    paramParcel.writeString(this.GHl);
    paramParcel.writeString(this.GHm);
    paramParcel.writeString(this.GHn);
    paramParcel.writeString(this.GHo);
    paramParcel.writeString(this.desc);
    paramParcel.writeString(this.GHp);
    paramParcel.writeString(this.GHq);
    paramParcel.writeDouble(this.tVK);
    paramParcel.writeString(this.GHr);
    paramParcel.writeString(this.GHs);
    paramParcel.writeString(this.GHt);
    paramParcel.writeString(this.GHu);
    paramParcel.writeInt(this.createTime);
    paramParcel.writeInt(this.GHv);
    paramParcel.writeString(this.fww);
    paramParcel.writeString(this.GHw);
    paramParcel.writeString(this.GHx);
    paramParcel.writeString(this.GHz);
    paramParcel.writeString(this.fvb);
    paramParcel.writeString(this.GHd);
    paramParcel.writeString(this.GHA);
    paramParcel.writeString(this.mnM);
    paramParcel.writeString(this.GHB);
    paramParcel.writeString(this.GHC);
    paramParcel.writeString(this.GHD);
    paramParcel.writeDouble(this.GHE);
    paramParcel.writeString(this.GHF);
    paramParcel.writeString(this.GHG);
    paramParcel.writeString(this.GHH);
    paramParcel.writeString(this.GHI);
    paramParcel.writeInt(this.GHK);
    paramParcel.writeInt(this.GHQ);
    paramParcel.writeDouble(this.GHM);
    paramParcel.writeString(this.GHN);
    paramParcel.writeInt(this.GHO);
    paramParcel.writeString(this.GHP);
    paramParcel.writeInt(this.GHQ);
    paramParcel.writeInt(this.GHR);
    paramParcel.writeInt(this.GHS);
    paramParcel.writeString(this.GHT);
    paramParcel.writeString(this.GHU);
    paramParcel.writeString(this.GHV);
    paramParcel.writeString(this.GHW);
    paramParcel.writeString(this.GHX);
    paramParcel.writeString(this.GHY);
    paramParcel.writeDouble(this.GHZ);
    paramParcel.writeString(this.GIa);
    paramParcel.writeString(this.GHJ);
    paramParcel.writeInt(this.GHb);
    paramParcel.writeInt(this.GHa.size());
    Iterator localIterator = this.GHa.iterator();
    while (localIterator.hasNext()) {
      paramParcel.writeParcelable((MallOrderDetailObject.HelpCenter)localIterator.next(), paramInt);
    }
    AppMethodBeat.o(66677);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.MallTransactionObject
 * JD-Core Version:    0.7.0.1
 */