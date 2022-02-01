package com.tencent.mm.plugin.order.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class MallTransactionObject
  implements Parcelable
{
  public static final Parcelable.Creator<MallTransactionObject> CREATOR;
  public int cXf;
  public int dCG;
  public String dcF;
  public String desc;
  public String hGe;
  public int hgr;
  public double nUf;
  public int subType;
  public int type;
  public List<MallOrderDetailObject.HelpCenter> unQ;
  public int unR;
  public String unT;
  public String uoA;
  public int uoB;
  public int uoC;
  public double uoD;
  public String uoE;
  public int uoF;
  public String uoG;
  public int uoH;
  public int uoI;
  public int uoJ;
  public String uoK;
  public String uoL;
  public String uoM;
  public String uoN;
  public String uoO;
  public String uoP;
  public double uoQ;
  public String uoR;
  public String uob;
  public String uoc;
  public String uod;
  public String uoe;
  public String uof;
  public String uog;
  public String uoh;
  public String uoi;
  public String uoj;
  public String uok;
  public int uol;
  public String uom;
  public String uon;
  public String uoo;
  public String uop;
  public String uoq;
  public String uor;
  public String uos;
  public String uot;
  public String uou;
  public double uov;
  public String uow;
  public String uox;
  public String uoy;
  public String uoz;
  
  static
  {
    AppMethodBeat.i(66680);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(66680);
  }
  
  public MallTransactionObject()
  {
    AppMethodBeat.i(66675);
    this.nUf = 0.0D;
    this.unQ = new LinkedList();
    this.unR = -1;
    AppMethodBeat.o(66675);
  }
  
  public MallTransactionObject(Parcel paramParcel)
  {
    AppMethodBeat.i(66676);
    this.nUf = 0.0D;
    this.unQ = new LinkedList();
    this.unR = -1;
    this.subType = paramParcel.readInt();
    this.dCG = paramParcel.readInt();
    this.cXf = paramParcel.readInt();
    this.uob = paramParcel.readString();
    this.uoc = paramParcel.readString();
    this.uod = paramParcel.readString();
    this.uoe = paramParcel.readString();
    this.desc = paramParcel.readString();
    this.uof = paramParcel.readString();
    this.uog = paramParcel.readString();
    this.nUf = paramParcel.readDouble();
    this.uoh = paramParcel.readString();
    this.uoi = paramParcel.readString();
    this.uoj = paramParcel.readString();
    this.uok = paramParcel.readString();
    this.hgr = paramParcel.readInt();
    this.uol = paramParcel.readInt();
    this.dcF = paramParcel.readString();
    this.uom = paramParcel.readString();
    this.uon = paramParcel.readString();
    this.uop = paramParcel.readString();
    this.uoq = paramParcel.readString();
    this.unT = paramParcel.readString();
    this.uor = paramParcel.readString();
    this.hGe = paramParcel.readString();
    this.uos = paramParcel.readString();
    this.uot = paramParcel.readString();
    this.uou = paramParcel.readString();
    this.uov = paramParcel.readDouble();
    this.uow = paramParcel.readString();
    this.uox = paramParcel.readString();
    this.uoy = paramParcel.readString();
    this.uoz = paramParcel.readString();
    this.uoB = paramParcel.readInt();
    this.uoH = paramParcel.readInt();
    this.uoD = paramParcel.readDouble();
    this.uoE = paramParcel.readString();
    this.uoF = paramParcel.readInt();
    this.uoG = paramParcel.readString();
    this.uoH = paramParcel.readInt();
    this.uoI = paramParcel.readInt();
    this.uoJ = paramParcel.readInt();
    this.uoK = paramParcel.readString();
    this.uoL = paramParcel.readString();
    this.uoM = paramParcel.readString();
    this.uoN = paramParcel.readString();
    this.uoO = paramParcel.readString();
    this.uoP = paramParcel.readString();
    this.uoQ = paramParcel.readDouble();
    this.uoR = paramParcel.readString();
    this.uoA = paramParcel.readString();
    this.unR = paramParcel.readInt();
    int j = paramParcel.readInt();
    this.unQ = new LinkedList();
    int i = 0;
    while (i < j)
    {
      MallOrderDetailObject.HelpCenter localHelpCenter = (MallOrderDetailObject.HelpCenter)paramParcel.readParcelable(MallOrderDetailObject.HelpCenter.class.getClassLoader());
      this.unQ.add(localHelpCenter);
      i += 1;
    }
    AppMethodBeat.o(66676);
  }
  
  public static MallTransactionObject aB(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(66678);
    if (paramJSONObject != null)
    {
      MallTransactionObject localMallTransactionObject = new MallTransactionObject();
      localMallTransactionObject.type = paramJSONObject.optInt("rec_type", 1);
      localMallTransactionObject.subType = paramJSONObject.optInt("sub_pay_type", 0);
      localMallTransactionObject.dCG = paramJSONObject.optInt("pay_scene");
      localMallTransactionObject.cXf = paramJSONObject.optInt("user_type");
      localMallTransactionObject.uob = paramJSONObject.optString("buy_uin");
      localMallTransactionObject.uoc = paramJSONObject.optString("buy_name");
      localMallTransactionObject.uod = paramJSONObject.optString("sale_uin");
      localMallTransactionObject.uoe = paramJSONObject.optString("sale_name");
      localMallTransactionObject.dcF = paramJSONObject.optString("trans_id");
      localMallTransactionObject.uom = paramJSONObject.optString("sp_billno");
      localMallTransactionObject.desc = paramJSONObject.optString("goods_name");
      localMallTransactionObject.uof = paramJSONObject.optString("goods_detail");
      localMallTransactionObject.nUf = (paramJSONObject.optDouble("fee") / 100.0D);
      localMallTransactionObject.uoh = paramJSONObject.optString("fee_color");
      localMallTransactionObject.uoi = paramJSONObject.optString("trade_state");
      localMallTransactionObject.uoj = paramJSONObject.optString("trade_state_name");
      localMallTransactionObject.uok = paramJSONObject.optString("trade_state_color");
      localMallTransactionObject.uon = paramJSONObject.optString("buy_bank_name");
      localMallTransactionObject.uoo = paramJSONObject.optString("card_tail");
      localMallTransactionObject.hgr = paramJSONObject.optInt("create_timestamp");
      localMallTransactionObject.uol = paramJSONObject.optInt("modify_timestamp");
      localMallTransactionObject.uop = paramJSONObject.optString("fee_type");
      JSONObject localJSONObject = paramJSONObject.optJSONObject("appinfo");
      if (localJSONObject != null)
      {
        localMallTransactionObject.uoq = localJSONObject.optString("app_username");
        localMallTransactionObject.unT = localJSONObject.optString("app_telephone");
        localMallTransactionObject.uor = localJSONObject.optString("app_nickname");
        localMallTransactionObject.hGe = localJSONObject.optString("app_icon_url");
        localMallTransactionObject.uoz = localJSONObject.optString("safeguard_url");
        localMallTransactionObject.uoA = localJSONObject.optString("display_name");
      }
      localMallTransactionObject.uos = paramJSONObject.optString("deliver_price");
      localMallTransactionObject.uot = paramJSONObject.optString("preferential_price");
      localMallTransactionObject.uou = paramJSONObject.optString("discount");
      localMallTransactionObject.uov = (paramJSONObject.optDouble("original_total_fee") / 100.0D);
      localMallTransactionObject.uow = paramJSONObject.optString("total_price");
      localMallTransactionObject.uox = paramJSONObject.optString("receipt_company");
      localMallTransactionObject.uoy = paramJSONObject.optString("biz_pledge");
      localMallTransactionObject.uoB = paramJSONObject.optInt("pre_fetch_timestamp");
      localMallTransactionObject.uoC = paramJSONObject.optInt("arrived_timestamp");
      localMallTransactionObject.uoD = (paramJSONObject.optDouble("transfer_fee") / 100.0D);
      localMallTransactionObject.uoE = paramJSONObject.optString("receiver_name");
      localMallTransactionObject.uoF = paramJSONObject.optInt("allow_resend_msg");
      localMallTransactionObject.uoG = paramJSONObject.optString("charge_fee");
      localMallTransactionObject.uoH = paramJSONObject.optInt("receive_timestamp");
      localMallTransactionObject.uoI = paramJSONObject.optInt("refund_timestamp");
      localMallTransactionObject.uoJ = paramJSONObject.optInt("create_timestamp");
      localMallTransactionObject.uoK = paramJSONObject.optString("buy_bank_type");
      localMallTransactionObject.uoL = paramJSONObject.optString("payer_name");
      localMallTransactionObject.uoM = paramJSONObject.optString("true_name");
      localMallTransactionObject.uoN = paramJSONObject.optString("refund_bank_type");
      localMallTransactionObject.uoO = paramJSONObject.optString("rateinfo");
      localMallTransactionObject.uoP = paramJSONObject.optString("original_feeinfo");
      localMallTransactionObject.uoQ = (paramJSONObject.optDouble("fetch_total_fee") / 100.0D);
      localMallTransactionObject.uoR = paramJSONObject.optString("fetch_total_fee_color");
      localMallTransactionObject.unR = paramJSONObject.optInt("userroll_type");
      localMallTransactionObject.unQ = aC(paramJSONObject);
      AppMethodBeat.o(66678);
      return localMallTransactionObject;
    }
    AppMethodBeat.o(66678);
    return null;
  }
  
  private static List<MallOrderDetailObject.HelpCenter> aC(JSONObject paramJSONObject)
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
        localHelpCenter.ddw = localJSONObject.optBoolean("is_show_button");
        localHelpCenter.name = localJSONObject.optString("name");
        localHelpCenter.url = localJSONObject.optString("url");
        localLinkedList.add(localHelpCenter);
        i += 1;
      }
      return localLinkedList;
    }
    catch (Exception paramJSONObject)
    {
      ad.printErrStackTrace("MicroMsg.MallTransactionObject", paramJSONObject, "", new Object[0]);
      ad.e("MicroMsg.MallTransactionObject", "parseHelpCenter error %s", new Object[] { paramJSONObject.getMessage() });
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
    paramParcel.writeInt(this.dCG);
    paramParcel.writeInt(this.cXf);
    paramParcel.writeString(this.uob);
    paramParcel.writeString(this.uoc);
    paramParcel.writeString(this.uod);
    paramParcel.writeString(this.uoe);
    paramParcel.writeString(this.desc);
    paramParcel.writeString(this.uof);
    paramParcel.writeString(this.uog);
    paramParcel.writeDouble(this.nUf);
    paramParcel.writeString(this.uoh);
    paramParcel.writeString(this.uoi);
    paramParcel.writeString(this.uoj);
    paramParcel.writeString(this.uok);
    paramParcel.writeInt(this.hgr);
    paramParcel.writeInt(this.uol);
    paramParcel.writeString(this.dcF);
    paramParcel.writeString(this.uom);
    paramParcel.writeString(this.uon);
    paramParcel.writeString(this.uop);
    paramParcel.writeString(this.uoq);
    paramParcel.writeString(this.unT);
    paramParcel.writeString(this.uor);
    paramParcel.writeString(this.hGe);
    paramParcel.writeString(this.uos);
    paramParcel.writeString(this.uot);
    paramParcel.writeString(this.uou);
    paramParcel.writeDouble(this.uov);
    paramParcel.writeString(this.uow);
    paramParcel.writeString(this.uox);
    paramParcel.writeString(this.uoy);
    paramParcel.writeString(this.uoz);
    paramParcel.writeInt(this.uoB);
    paramParcel.writeInt(this.uoH);
    paramParcel.writeDouble(this.uoD);
    paramParcel.writeString(this.uoE);
    paramParcel.writeInt(this.uoF);
    paramParcel.writeString(this.uoG);
    paramParcel.writeInt(this.uoH);
    paramParcel.writeInt(this.uoI);
    paramParcel.writeInt(this.uoJ);
    paramParcel.writeString(this.uoK);
    paramParcel.writeString(this.uoL);
    paramParcel.writeString(this.uoM);
    paramParcel.writeString(this.uoN);
    paramParcel.writeString(this.uoO);
    paramParcel.writeString(this.uoP);
    paramParcel.writeDouble(this.uoQ);
    paramParcel.writeString(this.uoR);
    paramParcel.writeString(this.uoA);
    paramParcel.writeInt(this.unR);
    paramParcel.writeInt(this.unQ.size());
    Iterator localIterator = this.unQ.iterator();
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