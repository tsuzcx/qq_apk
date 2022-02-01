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
  public String DUX;
  public List<MallOrderDetailObject.HelpCenter> MDR;
  public int MDS;
  public String MDU;
  public int MEA;
  public int MEB;
  public double MEC;
  public String MED;
  public int MEE;
  public String MEF;
  public int MEG;
  public int MEH;
  public int MEI;
  public String MEJ;
  public String MEK;
  public String MEL;
  public String MEM;
  public String MEN;
  public String MEO;
  public double MEP;
  public String MEQ;
  public String MEc;
  public String MEd;
  public String MEe;
  public String MEf;
  public String MEg;
  public String MEh;
  public String MEi;
  public String MEj;
  public String MEk;
  public String MEl;
  public int MEm;
  public String MEn;
  public String MEo;
  public String MEp;
  public String MEq;
  public String MEr;
  public String MEs;
  public String MEt;
  public double MEu;
  public String MEv;
  public String MEw;
  public String MEx;
  public String MEy;
  public String MEz;
  public int createTime;
  public String desc;
  public String hAU;
  public int hva;
  public String hzv;
  public int igp;
  public String phA;
  public int subType;
  public int type;
  public double wZe;
  
  static
  {
    AppMethodBeat.i(66680);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(66680);
  }
  
  public MallTransactionObject()
  {
    AppMethodBeat.i(66675);
    this.wZe = 0.0D;
    this.MDR = new LinkedList();
    this.MDS = -1;
    AppMethodBeat.o(66675);
  }
  
  public MallTransactionObject(Parcel paramParcel)
  {
    AppMethodBeat.i(66676);
    this.wZe = 0.0D;
    this.MDR = new LinkedList();
    this.MDS = -1;
    this.subType = paramParcel.readInt();
    this.igp = paramParcel.readInt();
    this.hva = paramParcel.readInt();
    this.MEc = paramParcel.readString();
    this.MEd = paramParcel.readString();
    this.MEe = paramParcel.readString();
    this.MEf = paramParcel.readString();
    this.desc = paramParcel.readString();
    this.MEg = paramParcel.readString();
    this.MEh = paramParcel.readString();
    this.wZe = paramParcel.readDouble();
    this.MEi = paramParcel.readString();
    this.MEj = paramParcel.readString();
    this.MEk = paramParcel.readString();
    this.MEl = paramParcel.readString();
    this.createTime = paramParcel.readInt();
    this.MEm = paramParcel.readInt();
    this.hAU = paramParcel.readString();
    this.MEn = paramParcel.readString();
    this.MEo = paramParcel.readString();
    this.MEq = paramParcel.readString();
    this.hzv = paramParcel.readString();
    this.MDU = paramParcel.readString();
    this.MEr = paramParcel.readString();
    this.phA = paramParcel.readString();
    this.MEs = paramParcel.readString();
    this.MEt = paramParcel.readString();
    this.DUX = paramParcel.readString();
    this.MEu = paramParcel.readDouble();
    this.MEv = paramParcel.readString();
    this.MEw = paramParcel.readString();
    this.MEx = paramParcel.readString();
    this.MEy = paramParcel.readString();
    this.MEA = paramParcel.readInt();
    this.MEG = paramParcel.readInt();
    this.MEC = paramParcel.readDouble();
    this.MED = paramParcel.readString();
    this.MEE = paramParcel.readInt();
    this.MEF = paramParcel.readString();
    this.MEG = paramParcel.readInt();
    this.MEH = paramParcel.readInt();
    this.MEI = paramParcel.readInt();
    this.MEJ = paramParcel.readString();
    this.MEK = paramParcel.readString();
    this.MEL = paramParcel.readString();
    this.MEM = paramParcel.readString();
    this.MEN = paramParcel.readString();
    this.MEO = paramParcel.readString();
    this.MEP = paramParcel.readDouble();
    this.MEQ = paramParcel.readString();
    this.MEz = paramParcel.readString();
    this.MDS = paramParcel.readInt();
    int j = paramParcel.readInt();
    this.MDR = new LinkedList();
    int i = 0;
    while (i < j)
    {
      MallOrderDetailObject.HelpCenter localHelpCenter = (MallOrderDetailObject.HelpCenter)paramParcel.readParcelable(MallOrderDetailObject.HelpCenter.class.getClassLoader());
      this.MDR.add(localHelpCenter);
      i += 1;
    }
    AppMethodBeat.o(66676);
  }
  
  public static MallTransactionObject bF(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(66678);
    if (paramJSONObject != null)
    {
      MallTransactionObject localMallTransactionObject = new MallTransactionObject();
      localMallTransactionObject.type = paramJSONObject.optInt("rec_type", 1);
      localMallTransactionObject.subType = paramJSONObject.optInt("sub_pay_type", 0);
      localMallTransactionObject.igp = paramJSONObject.optInt("pay_scene");
      localMallTransactionObject.hva = paramJSONObject.optInt("user_type");
      localMallTransactionObject.MEc = paramJSONObject.optString("buy_uin");
      localMallTransactionObject.MEd = paramJSONObject.optString("buy_name");
      localMallTransactionObject.MEe = paramJSONObject.optString("sale_uin");
      localMallTransactionObject.MEf = paramJSONObject.optString("sale_name");
      localMallTransactionObject.hAU = paramJSONObject.optString("trans_id");
      localMallTransactionObject.MEn = paramJSONObject.optString("sp_billno");
      localMallTransactionObject.desc = paramJSONObject.optString("goods_name");
      localMallTransactionObject.MEg = paramJSONObject.optString("goods_detail");
      localMallTransactionObject.wZe = (paramJSONObject.optDouble("fee") / 100.0D);
      localMallTransactionObject.MEi = paramJSONObject.optString("fee_color");
      localMallTransactionObject.MEj = paramJSONObject.optString("trade_state");
      localMallTransactionObject.MEk = paramJSONObject.optString("trade_state_name");
      localMallTransactionObject.MEl = paramJSONObject.optString("trade_state_color");
      localMallTransactionObject.MEo = paramJSONObject.optString("buy_bank_name");
      localMallTransactionObject.MEp = paramJSONObject.optString("card_tail");
      localMallTransactionObject.createTime = paramJSONObject.optInt("create_timestamp");
      localMallTransactionObject.MEm = paramJSONObject.optInt("modify_timestamp");
      localMallTransactionObject.MEq = paramJSONObject.optString("fee_type");
      JSONObject localJSONObject = paramJSONObject.optJSONObject("appinfo");
      if (localJSONObject != null)
      {
        localMallTransactionObject.hzv = localJSONObject.optString("app_username");
        localMallTransactionObject.MDU = localJSONObject.optString("app_telephone");
        localMallTransactionObject.MEr = localJSONObject.optString("app_nickname");
        localMallTransactionObject.phA = localJSONObject.optString("app_icon_url");
        localMallTransactionObject.MEy = localJSONObject.optString("safeguard_url");
        localMallTransactionObject.MEz = localJSONObject.optString("display_name");
      }
      localMallTransactionObject.MEs = paramJSONObject.optString("deliver_price");
      localMallTransactionObject.MEt = paramJSONObject.optString("preferential_price");
      localMallTransactionObject.DUX = paramJSONObject.optString("discount");
      localMallTransactionObject.MEu = (paramJSONObject.optDouble("original_total_fee") / 100.0D);
      localMallTransactionObject.MEv = paramJSONObject.optString("total_price");
      localMallTransactionObject.MEw = paramJSONObject.optString("receipt_company");
      localMallTransactionObject.MEx = paramJSONObject.optString("biz_pledge");
      localMallTransactionObject.MEA = paramJSONObject.optInt("pre_fetch_timestamp");
      localMallTransactionObject.MEB = paramJSONObject.optInt("arrived_timestamp");
      localMallTransactionObject.MEC = (paramJSONObject.optDouble("transfer_fee") / 100.0D);
      localMallTransactionObject.MED = paramJSONObject.optString("receiver_name");
      localMallTransactionObject.MEE = paramJSONObject.optInt("allow_resend_msg");
      localMallTransactionObject.MEF = paramJSONObject.optString("charge_fee");
      localMallTransactionObject.MEG = paramJSONObject.optInt("receive_timestamp");
      localMallTransactionObject.MEH = paramJSONObject.optInt("refund_timestamp");
      localMallTransactionObject.MEI = paramJSONObject.optInt("create_timestamp");
      localMallTransactionObject.MEJ = paramJSONObject.optString("buy_bank_type");
      localMallTransactionObject.MEK = paramJSONObject.optString("payer_name");
      localMallTransactionObject.MEL = paramJSONObject.optString("true_name");
      localMallTransactionObject.MEM = paramJSONObject.optString("refund_bank_type");
      localMallTransactionObject.MEN = paramJSONObject.optString("rateinfo");
      localMallTransactionObject.MEO = paramJSONObject.optString("original_feeinfo");
      localMallTransactionObject.MEP = (paramJSONObject.optDouble("fetch_total_fee") / 100.0D);
      localMallTransactionObject.MEQ = paramJSONObject.optString("fetch_total_fee_color");
      localMallTransactionObject.MDS = paramJSONObject.optInt("userroll_type");
      localMallTransactionObject.MDR = bG(paramJSONObject);
      AppMethodBeat.o(66678);
      return localMallTransactionObject;
    }
    AppMethodBeat.o(66678);
    return null;
  }
  
  private static List<MallOrderDetailObject.HelpCenter> bG(JSONObject paramJSONObject)
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
        localHelpCenter.hBY = localJSONObject.optBoolean("is_show_button");
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
    paramParcel.writeInt(this.igp);
    paramParcel.writeInt(this.hva);
    paramParcel.writeString(this.MEc);
    paramParcel.writeString(this.MEd);
    paramParcel.writeString(this.MEe);
    paramParcel.writeString(this.MEf);
    paramParcel.writeString(this.desc);
    paramParcel.writeString(this.MEg);
    paramParcel.writeString(this.MEh);
    paramParcel.writeDouble(this.wZe);
    paramParcel.writeString(this.MEi);
    paramParcel.writeString(this.MEj);
    paramParcel.writeString(this.MEk);
    paramParcel.writeString(this.MEl);
    paramParcel.writeInt(this.createTime);
    paramParcel.writeInt(this.MEm);
    paramParcel.writeString(this.hAU);
    paramParcel.writeString(this.MEn);
    paramParcel.writeString(this.MEo);
    paramParcel.writeString(this.MEq);
    paramParcel.writeString(this.hzv);
    paramParcel.writeString(this.MDU);
    paramParcel.writeString(this.MEr);
    paramParcel.writeString(this.phA);
    paramParcel.writeString(this.MEs);
    paramParcel.writeString(this.MEt);
    paramParcel.writeString(this.DUX);
    paramParcel.writeDouble(this.MEu);
    paramParcel.writeString(this.MEv);
    paramParcel.writeString(this.MEw);
    paramParcel.writeString(this.MEx);
    paramParcel.writeString(this.MEy);
    paramParcel.writeInt(this.MEA);
    paramParcel.writeInt(this.MEG);
    paramParcel.writeDouble(this.MEC);
    paramParcel.writeString(this.MED);
    paramParcel.writeInt(this.MEE);
    paramParcel.writeString(this.MEF);
    paramParcel.writeInt(this.MEG);
    paramParcel.writeInt(this.MEH);
    paramParcel.writeInt(this.MEI);
    paramParcel.writeString(this.MEJ);
    paramParcel.writeString(this.MEK);
    paramParcel.writeString(this.MEL);
    paramParcel.writeString(this.MEM);
    paramParcel.writeString(this.MEN);
    paramParcel.writeString(this.MEO);
    paramParcel.writeDouble(this.MEP);
    paramParcel.writeString(this.MEQ);
    paramParcel.writeString(this.MEz);
    paramParcel.writeInt(this.MDS);
    paramParcel.writeInt(this.MDR.size());
    Iterator localIterator = this.MDR.iterator();
    while (localIterator.hasNext()) {
      paramParcel.writeParcelable((MallOrderDetailObject.HelpCenter)localIterator.next(), paramInt);
    }
    AppMethodBeat.o(66677);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.MallTransactionObject
 * JD-Core Version:    0.7.0.1
 */