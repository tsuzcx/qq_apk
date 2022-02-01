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
  public List<MallOrderDetailObject.HelpCenter> ANM;
  public int ANN;
  public String ANP;
  public String ANX;
  public String ANY;
  public String ANZ;
  public int AOA;
  public String AOB;
  public int AOC;
  public int AOD;
  public int AOE;
  public String AOF;
  public String AOG;
  public String AOH;
  public String AOI;
  public String AOJ;
  public String AOK;
  public double AOL;
  public String AOM;
  public String AOa;
  public String AOb;
  public String AOc;
  public String AOd;
  public String AOe;
  public String AOf;
  public String AOg;
  public int AOh;
  public String AOi;
  public String AOj;
  public String AOk;
  public String AOl;
  public String AOm;
  public String AOn;
  public String AOo;
  public String AOp;
  public double AOq;
  public String AOr;
  public String AOs;
  public String AOt;
  public String AOu;
  public String AOv;
  public int AOw;
  public int AOx;
  public double AOy;
  public String AOz;
  public String dCu;
  public String dDM;
  public String desc;
  public int dyc;
  public int efQ;
  public int iXu;
  public String jyi;
  public double qwJ;
  public int subType;
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
    this.qwJ = 0.0D;
    this.ANM = new LinkedList();
    this.ANN = -1;
    AppMethodBeat.o(66675);
  }
  
  public MallTransactionObject(Parcel paramParcel)
  {
    AppMethodBeat.i(66676);
    this.qwJ = 0.0D;
    this.ANM = new LinkedList();
    this.ANN = -1;
    this.subType = paramParcel.readInt();
    this.efQ = paramParcel.readInt();
    this.dyc = paramParcel.readInt();
    this.ANX = paramParcel.readString();
    this.ANY = paramParcel.readString();
    this.ANZ = paramParcel.readString();
    this.AOa = paramParcel.readString();
    this.desc = paramParcel.readString();
    this.AOb = paramParcel.readString();
    this.AOc = paramParcel.readString();
    this.qwJ = paramParcel.readDouble();
    this.AOd = paramParcel.readString();
    this.AOe = paramParcel.readString();
    this.AOf = paramParcel.readString();
    this.AOg = paramParcel.readString();
    this.iXu = paramParcel.readInt();
    this.AOh = paramParcel.readInt();
    this.dDM = paramParcel.readString();
    this.AOi = paramParcel.readString();
    this.AOj = paramParcel.readString();
    this.AOl = paramParcel.readString();
    this.dCu = paramParcel.readString();
    this.ANP = paramParcel.readString();
    this.AOm = paramParcel.readString();
    this.jyi = paramParcel.readString();
    this.AOn = paramParcel.readString();
    this.AOo = paramParcel.readString();
    this.AOp = paramParcel.readString();
    this.AOq = paramParcel.readDouble();
    this.AOr = paramParcel.readString();
    this.AOs = paramParcel.readString();
    this.AOt = paramParcel.readString();
    this.AOu = paramParcel.readString();
    this.AOw = paramParcel.readInt();
    this.AOC = paramParcel.readInt();
    this.AOy = paramParcel.readDouble();
    this.AOz = paramParcel.readString();
    this.AOA = paramParcel.readInt();
    this.AOB = paramParcel.readString();
    this.AOC = paramParcel.readInt();
    this.AOD = paramParcel.readInt();
    this.AOE = paramParcel.readInt();
    this.AOF = paramParcel.readString();
    this.AOG = paramParcel.readString();
    this.AOH = paramParcel.readString();
    this.AOI = paramParcel.readString();
    this.AOJ = paramParcel.readString();
    this.AOK = paramParcel.readString();
    this.AOL = paramParcel.readDouble();
    this.AOM = paramParcel.readString();
    this.AOv = paramParcel.readString();
    this.ANN = paramParcel.readInt();
    int j = paramParcel.readInt();
    this.ANM = new LinkedList();
    int i = 0;
    while (i < j)
    {
      MallOrderDetailObject.HelpCenter localHelpCenter = (MallOrderDetailObject.HelpCenter)paramParcel.readParcelable(MallOrderDetailObject.HelpCenter.class.getClassLoader());
      this.ANM.add(localHelpCenter);
      i += 1;
    }
    AppMethodBeat.o(66676);
  }
  
  public static MallTransactionObject bh(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(66678);
    if (paramJSONObject != null)
    {
      MallTransactionObject localMallTransactionObject = new MallTransactionObject();
      localMallTransactionObject.type = paramJSONObject.optInt("rec_type", 1);
      localMallTransactionObject.subType = paramJSONObject.optInt("sub_pay_type", 0);
      localMallTransactionObject.efQ = paramJSONObject.optInt("pay_scene");
      localMallTransactionObject.dyc = paramJSONObject.optInt("user_type");
      localMallTransactionObject.ANX = paramJSONObject.optString("buy_uin");
      localMallTransactionObject.ANY = paramJSONObject.optString("buy_name");
      localMallTransactionObject.ANZ = paramJSONObject.optString("sale_uin");
      localMallTransactionObject.AOa = paramJSONObject.optString("sale_name");
      localMallTransactionObject.dDM = paramJSONObject.optString("trans_id");
      localMallTransactionObject.AOi = paramJSONObject.optString("sp_billno");
      localMallTransactionObject.desc = paramJSONObject.optString("goods_name");
      localMallTransactionObject.AOb = paramJSONObject.optString("goods_detail");
      localMallTransactionObject.qwJ = (paramJSONObject.optDouble("fee") / 100.0D);
      localMallTransactionObject.AOd = paramJSONObject.optString("fee_color");
      localMallTransactionObject.AOe = paramJSONObject.optString("trade_state");
      localMallTransactionObject.AOf = paramJSONObject.optString("trade_state_name");
      localMallTransactionObject.AOg = paramJSONObject.optString("trade_state_color");
      localMallTransactionObject.AOj = paramJSONObject.optString("buy_bank_name");
      localMallTransactionObject.AOk = paramJSONObject.optString("card_tail");
      localMallTransactionObject.iXu = paramJSONObject.optInt("create_timestamp");
      localMallTransactionObject.AOh = paramJSONObject.optInt("modify_timestamp");
      localMallTransactionObject.AOl = paramJSONObject.optString("fee_type");
      JSONObject localJSONObject = paramJSONObject.optJSONObject("appinfo");
      if (localJSONObject != null)
      {
        localMallTransactionObject.dCu = localJSONObject.optString("app_username");
        localMallTransactionObject.ANP = localJSONObject.optString("app_telephone");
        localMallTransactionObject.AOm = localJSONObject.optString("app_nickname");
        localMallTransactionObject.jyi = localJSONObject.optString("app_icon_url");
        localMallTransactionObject.AOu = localJSONObject.optString("safeguard_url");
        localMallTransactionObject.AOv = localJSONObject.optString("display_name");
      }
      localMallTransactionObject.AOn = paramJSONObject.optString("deliver_price");
      localMallTransactionObject.AOo = paramJSONObject.optString("preferential_price");
      localMallTransactionObject.AOp = paramJSONObject.optString("discount");
      localMallTransactionObject.AOq = (paramJSONObject.optDouble("original_total_fee") / 100.0D);
      localMallTransactionObject.AOr = paramJSONObject.optString("total_price");
      localMallTransactionObject.AOs = paramJSONObject.optString("receipt_company");
      localMallTransactionObject.AOt = paramJSONObject.optString("biz_pledge");
      localMallTransactionObject.AOw = paramJSONObject.optInt("pre_fetch_timestamp");
      localMallTransactionObject.AOx = paramJSONObject.optInt("arrived_timestamp");
      localMallTransactionObject.AOy = (paramJSONObject.optDouble("transfer_fee") / 100.0D);
      localMallTransactionObject.AOz = paramJSONObject.optString("receiver_name");
      localMallTransactionObject.AOA = paramJSONObject.optInt("allow_resend_msg");
      localMallTransactionObject.AOB = paramJSONObject.optString("charge_fee");
      localMallTransactionObject.AOC = paramJSONObject.optInt("receive_timestamp");
      localMallTransactionObject.AOD = paramJSONObject.optInt("refund_timestamp");
      localMallTransactionObject.AOE = paramJSONObject.optInt("create_timestamp");
      localMallTransactionObject.AOF = paramJSONObject.optString("buy_bank_type");
      localMallTransactionObject.AOG = paramJSONObject.optString("payer_name");
      localMallTransactionObject.AOH = paramJSONObject.optString("true_name");
      localMallTransactionObject.AOI = paramJSONObject.optString("refund_bank_type");
      localMallTransactionObject.AOJ = paramJSONObject.optString("rateinfo");
      localMallTransactionObject.AOK = paramJSONObject.optString("original_feeinfo");
      localMallTransactionObject.AOL = (paramJSONObject.optDouble("fetch_total_fee") / 100.0D);
      localMallTransactionObject.AOM = paramJSONObject.optString("fetch_total_fee_color");
      localMallTransactionObject.ANN = paramJSONObject.optInt("userroll_type");
      localMallTransactionObject.ANM = bi(paramJSONObject);
      AppMethodBeat.o(66678);
      return localMallTransactionObject;
    }
    AppMethodBeat.o(66678);
    return null;
  }
  
  private static List<MallOrderDetailObject.HelpCenter> bi(JSONObject paramJSONObject)
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
        localHelpCenter.dEF = localJSONObject.optBoolean("is_show_button");
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
    paramParcel.writeInt(this.efQ);
    paramParcel.writeInt(this.dyc);
    paramParcel.writeString(this.ANX);
    paramParcel.writeString(this.ANY);
    paramParcel.writeString(this.ANZ);
    paramParcel.writeString(this.AOa);
    paramParcel.writeString(this.desc);
    paramParcel.writeString(this.AOb);
    paramParcel.writeString(this.AOc);
    paramParcel.writeDouble(this.qwJ);
    paramParcel.writeString(this.AOd);
    paramParcel.writeString(this.AOe);
    paramParcel.writeString(this.AOf);
    paramParcel.writeString(this.AOg);
    paramParcel.writeInt(this.iXu);
    paramParcel.writeInt(this.AOh);
    paramParcel.writeString(this.dDM);
    paramParcel.writeString(this.AOi);
    paramParcel.writeString(this.AOj);
    paramParcel.writeString(this.AOl);
    paramParcel.writeString(this.dCu);
    paramParcel.writeString(this.ANP);
    paramParcel.writeString(this.AOm);
    paramParcel.writeString(this.jyi);
    paramParcel.writeString(this.AOn);
    paramParcel.writeString(this.AOo);
    paramParcel.writeString(this.AOp);
    paramParcel.writeDouble(this.AOq);
    paramParcel.writeString(this.AOr);
    paramParcel.writeString(this.AOs);
    paramParcel.writeString(this.AOt);
    paramParcel.writeString(this.AOu);
    paramParcel.writeInt(this.AOw);
    paramParcel.writeInt(this.AOC);
    paramParcel.writeDouble(this.AOy);
    paramParcel.writeString(this.AOz);
    paramParcel.writeInt(this.AOA);
    paramParcel.writeString(this.AOB);
    paramParcel.writeInt(this.AOC);
    paramParcel.writeInt(this.AOD);
    paramParcel.writeInt(this.AOE);
    paramParcel.writeString(this.AOF);
    paramParcel.writeString(this.AOG);
    paramParcel.writeString(this.AOH);
    paramParcel.writeString(this.AOI);
    paramParcel.writeString(this.AOJ);
    paramParcel.writeString(this.AOK);
    paramParcel.writeDouble(this.AOL);
    paramParcel.writeString(this.AOM);
    paramParcel.writeString(this.AOv);
    paramParcel.writeInt(this.ANN);
    paramParcel.writeInt(this.ANM.size());
    Iterator localIterator = this.ANM.iterator();
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