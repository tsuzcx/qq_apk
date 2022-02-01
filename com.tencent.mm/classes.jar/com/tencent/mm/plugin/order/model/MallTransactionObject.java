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
  public int dMF;
  public String desc;
  public int dfR;
  public String dlv;
  public int hZE;
  public String iAa;
  public double paV;
  public int subType;
  public int type;
  public String wCA;
  public int wCB;
  public String wCC;
  public String wCD;
  public String wCE;
  public String wCF;
  public String wCG;
  public String wCH;
  public String wCI;
  public String wCJ;
  public String wCK;
  public double wCL;
  public String wCM;
  public String wCN;
  public String wCO;
  public String wCP;
  public String wCQ;
  public int wCR;
  public int wCS;
  public double wCT;
  public String wCU;
  public int wCV;
  public String wCW;
  public int wCX;
  public int wCY;
  public int wCZ;
  public List<MallOrderDetailObject.HelpCenter> wCg;
  public int wCh;
  public String wCj;
  public String wCr;
  public String wCs;
  public String wCt;
  public String wCu;
  public String wCv;
  public String wCw;
  public String wCx;
  public String wCy;
  public String wCz;
  public String wDa;
  public String wDb;
  public String wDc;
  public String wDd;
  public String wDe;
  public String wDf;
  public double wDg;
  public String wDh;
  
  static
  {
    AppMethodBeat.i(66680);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(66680);
  }
  
  public MallTransactionObject()
  {
    AppMethodBeat.i(66675);
    this.paV = 0.0D;
    this.wCg = new LinkedList();
    this.wCh = -1;
    AppMethodBeat.o(66675);
  }
  
  public MallTransactionObject(Parcel paramParcel)
  {
    AppMethodBeat.i(66676);
    this.paV = 0.0D;
    this.wCg = new LinkedList();
    this.wCh = -1;
    this.subType = paramParcel.readInt();
    this.dMF = paramParcel.readInt();
    this.dfR = paramParcel.readInt();
    this.wCr = paramParcel.readString();
    this.wCs = paramParcel.readString();
    this.wCt = paramParcel.readString();
    this.wCu = paramParcel.readString();
    this.desc = paramParcel.readString();
    this.wCv = paramParcel.readString();
    this.wCw = paramParcel.readString();
    this.paV = paramParcel.readDouble();
    this.wCx = paramParcel.readString();
    this.wCy = paramParcel.readString();
    this.wCz = paramParcel.readString();
    this.wCA = paramParcel.readString();
    this.hZE = paramParcel.readInt();
    this.wCB = paramParcel.readInt();
    this.dlv = paramParcel.readString();
    this.wCC = paramParcel.readString();
    this.wCD = paramParcel.readString();
    this.wCF = paramParcel.readString();
    this.wCG = paramParcel.readString();
    this.wCj = paramParcel.readString();
    this.wCH = paramParcel.readString();
    this.iAa = paramParcel.readString();
    this.wCI = paramParcel.readString();
    this.wCJ = paramParcel.readString();
    this.wCK = paramParcel.readString();
    this.wCL = paramParcel.readDouble();
    this.wCM = paramParcel.readString();
    this.wCN = paramParcel.readString();
    this.wCO = paramParcel.readString();
    this.wCP = paramParcel.readString();
    this.wCR = paramParcel.readInt();
    this.wCX = paramParcel.readInt();
    this.wCT = paramParcel.readDouble();
    this.wCU = paramParcel.readString();
    this.wCV = paramParcel.readInt();
    this.wCW = paramParcel.readString();
    this.wCX = paramParcel.readInt();
    this.wCY = paramParcel.readInt();
    this.wCZ = paramParcel.readInt();
    this.wDa = paramParcel.readString();
    this.wDb = paramParcel.readString();
    this.wDc = paramParcel.readString();
    this.wDd = paramParcel.readString();
    this.wDe = paramParcel.readString();
    this.wDf = paramParcel.readString();
    this.wDg = paramParcel.readDouble();
    this.wDh = paramParcel.readString();
    this.wCQ = paramParcel.readString();
    this.wCh = paramParcel.readInt();
    int j = paramParcel.readInt();
    this.wCg = new LinkedList();
    int i = 0;
    while (i < j)
    {
      MallOrderDetailObject.HelpCenter localHelpCenter = (MallOrderDetailObject.HelpCenter)paramParcel.readParcelable(MallOrderDetailObject.HelpCenter.class.getClassLoader());
      this.wCg.add(localHelpCenter);
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
      localMallTransactionObject.dMF = paramJSONObject.optInt("pay_scene");
      localMallTransactionObject.dfR = paramJSONObject.optInt("user_type");
      localMallTransactionObject.wCr = paramJSONObject.optString("buy_uin");
      localMallTransactionObject.wCs = paramJSONObject.optString("buy_name");
      localMallTransactionObject.wCt = paramJSONObject.optString("sale_uin");
      localMallTransactionObject.wCu = paramJSONObject.optString("sale_name");
      localMallTransactionObject.dlv = paramJSONObject.optString("trans_id");
      localMallTransactionObject.wCC = paramJSONObject.optString("sp_billno");
      localMallTransactionObject.desc = paramJSONObject.optString("goods_name");
      localMallTransactionObject.wCv = paramJSONObject.optString("goods_detail");
      localMallTransactionObject.paV = (paramJSONObject.optDouble("fee") / 100.0D);
      localMallTransactionObject.wCx = paramJSONObject.optString("fee_color");
      localMallTransactionObject.wCy = paramJSONObject.optString("trade_state");
      localMallTransactionObject.wCz = paramJSONObject.optString("trade_state_name");
      localMallTransactionObject.wCA = paramJSONObject.optString("trade_state_color");
      localMallTransactionObject.wCD = paramJSONObject.optString("buy_bank_name");
      localMallTransactionObject.wCE = paramJSONObject.optString("card_tail");
      localMallTransactionObject.hZE = paramJSONObject.optInt("create_timestamp");
      localMallTransactionObject.wCB = paramJSONObject.optInt("modify_timestamp");
      localMallTransactionObject.wCF = paramJSONObject.optString("fee_type");
      JSONObject localJSONObject = paramJSONObject.optJSONObject("appinfo");
      if (localJSONObject != null)
      {
        localMallTransactionObject.wCG = localJSONObject.optString("app_username");
        localMallTransactionObject.wCj = localJSONObject.optString("app_telephone");
        localMallTransactionObject.wCH = localJSONObject.optString("app_nickname");
        localMallTransactionObject.iAa = localJSONObject.optString("app_icon_url");
        localMallTransactionObject.wCP = localJSONObject.optString("safeguard_url");
        localMallTransactionObject.wCQ = localJSONObject.optString("display_name");
      }
      localMallTransactionObject.wCI = paramJSONObject.optString("deliver_price");
      localMallTransactionObject.wCJ = paramJSONObject.optString("preferential_price");
      localMallTransactionObject.wCK = paramJSONObject.optString("discount");
      localMallTransactionObject.wCL = (paramJSONObject.optDouble("original_total_fee") / 100.0D);
      localMallTransactionObject.wCM = paramJSONObject.optString("total_price");
      localMallTransactionObject.wCN = paramJSONObject.optString("receipt_company");
      localMallTransactionObject.wCO = paramJSONObject.optString("biz_pledge");
      localMallTransactionObject.wCR = paramJSONObject.optInt("pre_fetch_timestamp");
      localMallTransactionObject.wCS = paramJSONObject.optInt("arrived_timestamp");
      localMallTransactionObject.wCT = (paramJSONObject.optDouble("transfer_fee") / 100.0D);
      localMallTransactionObject.wCU = paramJSONObject.optString("receiver_name");
      localMallTransactionObject.wCV = paramJSONObject.optInt("allow_resend_msg");
      localMallTransactionObject.wCW = paramJSONObject.optString("charge_fee");
      localMallTransactionObject.wCX = paramJSONObject.optInt("receive_timestamp");
      localMallTransactionObject.wCY = paramJSONObject.optInt("refund_timestamp");
      localMallTransactionObject.wCZ = paramJSONObject.optInt("create_timestamp");
      localMallTransactionObject.wDa = paramJSONObject.optString("buy_bank_type");
      localMallTransactionObject.wDb = paramJSONObject.optString("payer_name");
      localMallTransactionObject.wDc = paramJSONObject.optString("true_name");
      localMallTransactionObject.wDd = paramJSONObject.optString("refund_bank_type");
      localMallTransactionObject.wDe = paramJSONObject.optString("rateinfo");
      localMallTransactionObject.wDf = paramJSONObject.optString("original_feeinfo");
      localMallTransactionObject.wDg = (paramJSONObject.optDouble("fetch_total_fee") / 100.0D);
      localMallTransactionObject.wDh = paramJSONObject.optString("fetch_total_fee_color");
      localMallTransactionObject.wCh = paramJSONObject.optInt("userroll_type");
      localMallTransactionObject.wCg = aM(paramJSONObject);
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
        localHelpCenter.dmo = localJSONObject.optBoolean("is_show_button");
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
    paramParcel.writeInt(this.dMF);
    paramParcel.writeInt(this.dfR);
    paramParcel.writeString(this.wCr);
    paramParcel.writeString(this.wCs);
    paramParcel.writeString(this.wCt);
    paramParcel.writeString(this.wCu);
    paramParcel.writeString(this.desc);
    paramParcel.writeString(this.wCv);
    paramParcel.writeString(this.wCw);
    paramParcel.writeDouble(this.paV);
    paramParcel.writeString(this.wCx);
    paramParcel.writeString(this.wCy);
    paramParcel.writeString(this.wCz);
    paramParcel.writeString(this.wCA);
    paramParcel.writeInt(this.hZE);
    paramParcel.writeInt(this.wCB);
    paramParcel.writeString(this.dlv);
    paramParcel.writeString(this.wCC);
    paramParcel.writeString(this.wCD);
    paramParcel.writeString(this.wCF);
    paramParcel.writeString(this.wCG);
    paramParcel.writeString(this.wCj);
    paramParcel.writeString(this.wCH);
    paramParcel.writeString(this.iAa);
    paramParcel.writeString(this.wCI);
    paramParcel.writeString(this.wCJ);
    paramParcel.writeString(this.wCK);
    paramParcel.writeDouble(this.wCL);
    paramParcel.writeString(this.wCM);
    paramParcel.writeString(this.wCN);
    paramParcel.writeString(this.wCO);
    paramParcel.writeString(this.wCP);
    paramParcel.writeInt(this.wCR);
    paramParcel.writeInt(this.wCX);
    paramParcel.writeDouble(this.wCT);
    paramParcel.writeString(this.wCU);
    paramParcel.writeInt(this.wCV);
    paramParcel.writeString(this.wCW);
    paramParcel.writeInt(this.wCX);
    paramParcel.writeInt(this.wCY);
    paramParcel.writeInt(this.wCZ);
    paramParcel.writeString(this.wDa);
    paramParcel.writeString(this.wDb);
    paramParcel.writeString(this.wDc);
    paramParcel.writeString(this.wDd);
    paramParcel.writeString(this.wDe);
    paramParcel.writeString(this.wDf);
    paramParcel.writeDouble(this.wDg);
    paramParcel.writeString(this.wDh);
    paramParcel.writeString(this.wCQ);
    paramParcel.writeInt(this.wCh);
    paramParcel.writeInt(this.wCg.size());
    Iterator localIterator = this.wCg.iterator();
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