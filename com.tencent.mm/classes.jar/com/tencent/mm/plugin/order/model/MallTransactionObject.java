package com.tencent.mm.plugin.order.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class MallTransactionObject
  implements Parcelable
{
  public static final Parcelable.Creator<MallTransactionObject> CREATOR;
  public int dNV;
  public String desc;
  public int dgT;
  public String dmx;
  public String iCT;
  public int icw;
  public double phz;
  public int subType;
  public int type;
  public List<MallOrderDetailObject.HelpCenter> wRR;
  public int wRS;
  public String wRU;
  public String wSA;
  public String wSB;
  public int wSC;
  public int wSD;
  public double wSE;
  public String wSF;
  public int wSG;
  public String wSH;
  public int wSI;
  public int wSJ;
  public int wSK;
  public String wSL;
  public String wSM;
  public String wSN;
  public String wSO;
  public String wSP;
  public String wSQ;
  public double wSR;
  public String wSS;
  public String wSc;
  public String wSd;
  public String wSe;
  public String wSf;
  public String wSg;
  public String wSh;
  public String wSi;
  public String wSj;
  public String wSk;
  public String wSl;
  public int wSm;
  public String wSn;
  public String wSo;
  public String wSp;
  public String wSq;
  public String wSr;
  public String wSs;
  public String wSt;
  public String wSu;
  public String wSv;
  public double wSw;
  public String wSx;
  public String wSy;
  public String wSz;
  
  static
  {
    AppMethodBeat.i(66680);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(66680);
  }
  
  public MallTransactionObject()
  {
    AppMethodBeat.i(66675);
    this.phz = 0.0D;
    this.wRR = new LinkedList();
    this.wRS = -1;
    AppMethodBeat.o(66675);
  }
  
  public MallTransactionObject(Parcel paramParcel)
  {
    AppMethodBeat.i(66676);
    this.phz = 0.0D;
    this.wRR = new LinkedList();
    this.wRS = -1;
    this.subType = paramParcel.readInt();
    this.dNV = paramParcel.readInt();
    this.dgT = paramParcel.readInt();
    this.wSc = paramParcel.readString();
    this.wSd = paramParcel.readString();
    this.wSe = paramParcel.readString();
    this.wSf = paramParcel.readString();
    this.desc = paramParcel.readString();
    this.wSg = paramParcel.readString();
    this.wSh = paramParcel.readString();
    this.phz = paramParcel.readDouble();
    this.wSi = paramParcel.readString();
    this.wSj = paramParcel.readString();
    this.wSk = paramParcel.readString();
    this.wSl = paramParcel.readString();
    this.icw = paramParcel.readInt();
    this.wSm = paramParcel.readInt();
    this.dmx = paramParcel.readString();
    this.wSn = paramParcel.readString();
    this.wSo = paramParcel.readString();
    this.wSq = paramParcel.readString();
    this.wSr = paramParcel.readString();
    this.wRU = paramParcel.readString();
    this.wSs = paramParcel.readString();
    this.iCT = paramParcel.readString();
    this.wSt = paramParcel.readString();
    this.wSu = paramParcel.readString();
    this.wSv = paramParcel.readString();
    this.wSw = paramParcel.readDouble();
    this.wSx = paramParcel.readString();
    this.wSy = paramParcel.readString();
    this.wSz = paramParcel.readString();
    this.wSA = paramParcel.readString();
    this.wSC = paramParcel.readInt();
    this.wSI = paramParcel.readInt();
    this.wSE = paramParcel.readDouble();
    this.wSF = paramParcel.readString();
    this.wSG = paramParcel.readInt();
    this.wSH = paramParcel.readString();
    this.wSI = paramParcel.readInt();
    this.wSJ = paramParcel.readInt();
    this.wSK = paramParcel.readInt();
    this.wSL = paramParcel.readString();
    this.wSM = paramParcel.readString();
    this.wSN = paramParcel.readString();
    this.wSO = paramParcel.readString();
    this.wSP = paramParcel.readString();
    this.wSQ = paramParcel.readString();
    this.wSR = paramParcel.readDouble();
    this.wSS = paramParcel.readString();
    this.wSB = paramParcel.readString();
    this.wRS = paramParcel.readInt();
    int j = paramParcel.readInt();
    this.wRR = new LinkedList();
    int i = 0;
    while (i < j)
    {
      MallOrderDetailObject.HelpCenter localHelpCenter = (MallOrderDetailObject.HelpCenter)paramParcel.readParcelable(MallOrderDetailObject.HelpCenter.class.getClassLoader());
      this.wRR.add(localHelpCenter);
      i += 1;
    }
    AppMethodBeat.o(66676);
  }
  
  public static MallTransactionObject aL(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(66678);
    if (paramJSONObject != null)
    {
      MallTransactionObject localMallTransactionObject = new MallTransactionObject();
      localMallTransactionObject.type = paramJSONObject.optInt("rec_type", 1);
      localMallTransactionObject.subType = paramJSONObject.optInt("sub_pay_type", 0);
      localMallTransactionObject.dNV = paramJSONObject.optInt("pay_scene");
      localMallTransactionObject.dgT = paramJSONObject.optInt("user_type");
      localMallTransactionObject.wSc = paramJSONObject.optString("buy_uin");
      localMallTransactionObject.wSd = paramJSONObject.optString("buy_name");
      localMallTransactionObject.wSe = paramJSONObject.optString("sale_uin");
      localMallTransactionObject.wSf = paramJSONObject.optString("sale_name");
      localMallTransactionObject.dmx = paramJSONObject.optString("trans_id");
      localMallTransactionObject.wSn = paramJSONObject.optString("sp_billno");
      localMallTransactionObject.desc = paramJSONObject.optString("goods_name");
      localMallTransactionObject.wSg = paramJSONObject.optString("goods_detail");
      localMallTransactionObject.phz = (paramJSONObject.optDouble("fee") / 100.0D);
      localMallTransactionObject.wSi = paramJSONObject.optString("fee_color");
      localMallTransactionObject.wSj = paramJSONObject.optString("trade_state");
      localMallTransactionObject.wSk = paramJSONObject.optString("trade_state_name");
      localMallTransactionObject.wSl = paramJSONObject.optString("trade_state_color");
      localMallTransactionObject.wSo = paramJSONObject.optString("buy_bank_name");
      localMallTransactionObject.wSp = paramJSONObject.optString("card_tail");
      localMallTransactionObject.icw = paramJSONObject.optInt("create_timestamp");
      localMallTransactionObject.wSm = paramJSONObject.optInt("modify_timestamp");
      localMallTransactionObject.wSq = paramJSONObject.optString("fee_type");
      JSONObject localJSONObject = paramJSONObject.optJSONObject("appinfo");
      if (localJSONObject != null)
      {
        localMallTransactionObject.wSr = localJSONObject.optString("app_username");
        localMallTransactionObject.wRU = localJSONObject.optString("app_telephone");
        localMallTransactionObject.wSs = localJSONObject.optString("app_nickname");
        localMallTransactionObject.iCT = localJSONObject.optString("app_icon_url");
        localMallTransactionObject.wSA = localJSONObject.optString("safeguard_url");
        localMallTransactionObject.wSB = localJSONObject.optString("display_name");
      }
      localMallTransactionObject.wSt = paramJSONObject.optString("deliver_price");
      localMallTransactionObject.wSu = paramJSONObject.optString("preferential_price");
      localMallTransactionObject.wSv = paramJSONObject.optString("discount");
      localMallTransactionObject.wSw = (paramJSONObject.optDouble("original_total_fee") / 100.0D);
      localMallTransactionObject.wSx = paramJSONObject.optString("total_price");
      localMallTransactionObject.wSy = paramJSONObject.optString("receipt_company");
      localMallTransactionObject.wSz = paramJSONObject.optString("biz_pledge");
      localMallTransactionObject.wSC = paramJSONObject.optInt("pre_fetch_timestamp");
      localMallTransactionObject.wSD = paramJSONObject.optInt("arrived_timestamp");
      localMallTransactionObject.wSE = (paramJSONObject.optDouble("transfer_fee") / 100.0D);
      localMallTransactionObject.wSF = paramJSONObject.optString("receiver_name");
      localMallTransactionObject.wSG = paramJSONObject.optInt("allow_resend_msg");
      localMallTransactionObject.wSH = paramJSONObject.optString("charge_fee");
      localMallTransactionObject.wSI = paramJSONObject.optInt("receive_timestamp");
      localMallTransactionObject.wSJ = paramJSONObject.optInt("refund_timestamp");
      localMallTransactionObject.wSK = paramJSONObject.optInt("create_timestamp");
      localMallTransactionObject.wSL = paramJSONObject.optString("buy_bank_type");
      localMallTransactionObject.wSM = paramJSONObject.optString("payer_name");
      localMallTransactionObject.wSN = paramJSONObject.optString("true_name");
      localMallTransactionObject.wSO = paramJSONObject.optString("refund_bank_type");
      localMallTransactionObject.wSP = paramJSONObject.optString("rateinfo");
      localMallTransactionObject.wSQ = paramJSONObject.optString("original_feeinfo");
      localMallTransactionObject.wSR = (paramJSONObject.optDouble("fetch_total_fee") / 100.0D);
      localMallTransactionObject.wSS = paramJSONObject.optString("fetch_total_fee_color");
      localMallTransactionObject.wRS = paramJSONObject.optInt("userroll_type");
      localMallTransactionObject.wRR = aM(paramJSONObject);
      AppMethodBeat.o(66678);
      return localMallTransactionObject;
    }
    AppMethodBeat.o(66678);
    return null;
  }
  
  private static List<MallOrderDetailObject.HelpCenter> aM(JSONObject paramJSONObject)
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
        localHelpCenter.dnq = localJSONObject.optBoolean("is_show_button");
        localHelpCenter.name = localJSONObject.optString("name");
        localHelpCenter.url = localJSONObject.optString("url");
        localLinkedList.add(localHelpCenter);
        i += 1;
      }
      return localLinkedList;
    }
    catch (Exception paramJSONObject)
    {
      ae.printErrStackTrace("MicroMsg.MallTransactionObject", paramJSONObject, "", new Object[0]);
      ae.e("MicroMsg.MallTransactionObject", "parseHelpCenter error %s", new Object[] { paramJSONObject.getMessage() });
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
    paramParcel.writeInt(this.dNV);
    paramParcel.writeInt(this.dgT);
    paramParcel.writeString(this.wSc);
    paramParcel.writeString(this.wSd);
    paramParcel.writeString(this.wSe);
    paramParcel.writeString(this.wSf);
    paramParcel.writeString(this.desc);
    paramParcel.writeString(this.wSg);
    paramParcel.writeString(this.wSh);
    paramParcel.writeDouble(this.phz);
    paramParcel.writeString(this.wSi);
    paramParcel.writeString(this.wSj);
    paramParcel.writeString(this.wSk);
    paramParcel.writeString(this.wSl);
    paramParcel.writeInt(this.icw);
    paramParcel.writeInt(this.wSm);
    paramParcel.writeString(this.dmx);
    paramParcel.writeString(this.wSn);
    paramParcel.writeString(this.wSo);
    paramParcel.writeString(this.wSq);
    paramParcel.writeString(this.wSr);
    paramParcel.writeString(this.wRU);
    paramParcel.writeString(this.wSs);
    paramParcel.writeString(this.iCT);
    paramParcel.writeString(this.wSt);
    paramParcel.writeString(this.wSu);
    paramParcel.writeString(this.wSv);
    paramParcel.writeDouble(this.wSw);
    paramParcel.writeString(this.wSx);
    paramParcel.writeString(this.wSy);
    paramParcel.writeString(this.wSz);
    paramParcel.writeString(this.wSA);
    paramParcel.writeInt(this.wSC);
    paramParcel.writeInt(this.wSI);
    paramParcel.writeDouble(this.wSE);
    paramParcel.writeString(this.wSF);
    paramParcel.writeInt(this.wSG);
    paramParcel.writeString(this.wSH);
    paramParcel.writeInt(this.wSI);
    paramParcel.writeInt(this.wSJ);
    paramParcel.writeInt(this.wSK);
    paramParcel.writeString(this.wSL);
    paramParcel.writeString(this.wSM);
    paramParcel.writeString(this.wSN);
    paramParcel.writeString(this.wSO);
    paramParcel.writeString(this.wSP);
    paramParcel.writeString(this.wSQ);
    paramParcel.writeDouble(this.wSR);
    paramParcel.writeString(this.wSS);
    paramParcel.writeString(this.wSB);
    paramParcel.writeInt(this.wRS);
    paramParcel.writeInt(this.wRR.size());
    Iterator localIterator = this.wRR.iterator();
    while (localIterator.hasNext()) {
      paramParcel.writeParcelable((MallOrderDetailObject.HelpCenter)localIterator.next(), paramInt);
    }
    AppMethodBeat.o(66677);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.MallTransactionObject
 * JD-Core Version:    0.7.0.1
 */