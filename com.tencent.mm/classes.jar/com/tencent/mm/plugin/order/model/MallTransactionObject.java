package com.tencent.mm.plugin.order.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class MallTransactionObject
  implements Parcelable
{
  public static final Parcelable.Creator<MallTransactionObject> CREATOR = new Parcelable.Creator() {};
  public int bBt;
  public String bMY;
  public int brC;
  public int ccY;
  public String desc;
  public int enw;
  public String fPM;
  public double iHP = 0.0D;
  public List<MallOrderDetailObject.HelpCenter> mOA = new LinkedList();
  public int mOB = -1;
  public String mOD;
  public String mOL;
  public String mOM;
  public String mON;
  public String mOO;
  public String mOP;
  public String mOQ;
  public String mOR;
  public String mOS;
  public String mOT;
  public String mOU;
  public int mOV;
  public String mOW;
  public String mOX;
  public String mOY;
  public String mOZ;
  public double mPA;
  public String mPB;
  public String mPa;
  public String mPb;
  public String mPc;
  public String mPd;
  public String mPe;
  public double mPf;
  public String mPg;
  public String mPh;
  public String mPi;
  public String mPj;
  public String mPk;
  public int mPl;
  public int mPm;
  public double mPn;
  public String mPo;
  public int mPp;
  public String mPq;
  public int mPr;
  public int mPs;
  public int mPt;
  public String mPu;
  public String mPv;
  public String mPw;
  public String mPx;
  public String mPy;
  public String mPz;
  public int type;
  
  public MallTransactionObject() {}
  
  public MallTransactionObject(Parcel paramParcel)
  {
    this.brC = paramParcel.readInt();
    this.ccY = paramParcel.readInt();
    this.bBt = paramParcel.readInt();
    this.mOL = paramParcel.readString();
    this.mOM = paramParcel.readString();
    this.mON = paramParcel.readString();
    this.mOO = paramParcel.readString();
    this.desc = paramParcel.readString();
    this.mOP = paramParcel.readString();
    this.mOQ = paramParcel.readString();
    this.iHP = paramParcel.readDouble();
    this.mOR = paramParcel.readString();
    this.mOS = paramParcel.readString();
    this.mOT = paramParcel.readString();
    this.mOU = paramParcel.readString();
    this.enw = paramParcel.readInt();
    this.mOV = paramParcel.readInt();
    this.bMY = paramParcel.readString();
    this.mOW = paramParcel.readString();
    this.mOX = paramParcel.readString();
    this.mOZ = paramParcel.readString();
    this.mPa = paramParcel.readString();
    this.mOD = paramParcel.readString();
    this.mPb = paramParcel.readString();
    this.fPM = paramParcel.readString();
    this.mPc = paramParcel.readString();
    this.mPd = paramParcel.readString();
    this.mPe = paramParcel.readString();
    this.mPf = paramParcel.readDouble();
    this.mPg = paramParcel.readString();
    this.mPh = paramParcel.readString();
    this.mPi = paramParcel.readString();
    this.mPj = paramParcel.readString();
    this.mPl = paramParcel.readInt();
    this.mPr = paramParcel.readInt();
    this.mPn = paramParcel.readDouble();
    this.mPo = paramParcel.readString();
    this.mPp = paramParcel.readInt();
    this.mPq = paramParcel.readString();
    this.mPr = paramParcel.readInt();
    this.mPs = paramParcel.readInt();
    this.mPt = paramParcel.readInt();
    this.mPu = paramParcel.readString();
    this.mPv = paramParcel.readString();
    this.mPw = paramParcel.readString();
    this.mPx = paramParcel.readString();
    this.mPy = paramParcel.readString();
    this.mPz = paramParcel.readString();
    this.mPA = paramParcel.readDouble();
    this.mPB = paramParcel.readString();
    this.mPk = paramParcel.readString();
    this.mOB = paramParcel.readInt();
    int j = paramParcel.readInt();
    this.mOA = new LinkedList();
    int i = 0;
    while (i < j)
    {
      MallOrderDetailObject.HelpCenter localHelpCenter = (MallOrderDetailObject.HelpCenter)paramParcel.readParcelable(MallOrderDetailObject.HelpCenter.class.getClassLoader());
      this.mOA.add(localHelpCenter);
      i += 1;
    }
  }
  
  public static MallTransactionObject ab(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      MallTransactionObject localMallTransactionObject = new MallTransactionObject();
      localMallTransactionObject.type = paramJSONObject.optInt("rec_type", 1);
      localMallTransactionObject.brC = paramJSONObject.optInt("sub_pay_type", 0);
      localMallTransactionObject.ccY = paramJSONObject.optInt("pay_scene");
      localMallTransactionObject.bBt = paramJSONObject.optInt("user_type");
      localMallTransactionObject.mOL = paramJSONObject.optString("buy_uin");
      localMallTransactionObject.mOM = paramJSONObject.optString("buy_name");
      localMallTransactionObject.mON = paramJSONObject.optString("sale_uin");
      localMallTransactionObject.mOO = paramJSONObject.optString("sale_name");
      localMallTransactionObject.bMY = paramJSONObject.optString("trans_id");
      localMallTransactionObject.mOW = paramJSONObject.optString("sp_billno");
      localMallTransactionObject.desc = paramJSONObject.optString("goods_name");
      localMallTransactionObject.mOP = paramJSONObject.optString("goods_detail");
      localMallTransactionObject.iHP = (paramJSONObject.optDouble("fee") / 100.0D);
      localMallTransactionObject.mOR = paramJSONObject.optString("fee_color");
      localMallTransactionObject.mOS = paramJSONObject.optString("trade_state");
      localMallTransactionObject.mOT = paramJSONObject.optString("trade_state_name");
      localMallTransactionObject.mOU = paramJSONObject.optString("trade_state_color");
      localMallTransactionObject.mOX = paramJSONObject.optString("buy_bank_name");
      localMallTransactionObject.mOY = paramJSONObject.optString("card_tail");
      localMallTransactionObject.enw = paramJSONObject.optInt("create_timestamp");
      localMallTransactionObject.mOV = paramJSONObject.optInt("modify_timestamp");
      localMallTransactionObject.mOZ = paramJSONObject.optString("fee_type");
      JSONObject localJSONObject = paramJSONObject.optJSONObject("appinfo");
      if (localJSONObject != null)
      {
        localMallTransactionObject.mPa = localJSONObject.optString("app_username");
        localMallTransactionObject.mOD = localJSONObject.optString("app_telephone");
        localMallTransactionObject.mPb = localJSONObject.optString("app_nickname");
        localMallTransactionObject.fPM = localJSONObject.optString("app_icon_url");
        localMallTransactionObject.mPj = localJSONObject.optString("safeguard_url");
        localMallTransactionObject.mPk = localJSONObject.optString("display_name");
      }
      localMallTransactionObject.mPc = paramJSONObject.optString("deliver_price");
      localMallTransactionObject.mPd = paramJSONObject.optString("preferential_price");
      localMallTransactionObject.mPe = paramJSONObject.optString("discount");
      localMallTransactionObject.mPf = (paramJSONObject.optDouble("original_total_fee") / 100.0D);
      localMallTransactionObject.mPg = paramJSONObject.optString("total_price");
      localMallTransactionObject.mPh = paramJSONObject.optString("receipt_company");
      localMallTransactionObject.mPi = paramJSONObject.optString("biz_pledge");
      localMallTransactionObject.mPl = paramJSONObject.optInt("pre_fetch_timestamp");
      localMallTransactionObject.mPm = paramJSONObject.optInt("arrived_timestamp");
      localMallTransactionObject.mPn = (paramJSONObject.optDouble("transfer_fee") / 100.0D);
      localMallTransactionObject.mPo = paramJSONObject.optString("receiver_name");
      localMallTransactionObject.mPp = paramJSONObject.optInt("allow_resend_msg");
      localMallTransactionObject.mPq = paramJSONObject.optString("charge_fee");
      localMallTransactionObject.mPr = paramJSONObject.optInt("receive_timestamp");
      localMallTransactionObject.mPs = paramJSONObject.optInt("refund_timestamp");
      localMallTransactionObject.mPt = paramJSONObject.optInt("create_timestamp");
      localMallTransactionObject.mPu = paramJSONObject.optString("buy_bank_type");
      localMallTransactionObject.mPv = paramJSONObject.optString("payer_name");
      localMallTransactionObject.mPw = paramJSONObject.optString("true_name");
      localMallTransactionObject.mPx = paramJSONObject.optString("refund_bank_type");
      localMallTransactionObject.mPy = paramJSONObject.optString("rateinfo");
      localMallTransactionObject.mPz = paramJSONObject.optString("original_feeinfo");
      localMallTransactionObject.mPA = (paramJSONObject.optDouble("fetch_total_fee") / 100.0D);
      localMallTransactionObject.mPB = paramJSONObject.optString("fetch_total_fee_color");
      localMallTransactionObject.mOB = paramJSONObject.optInt("userroll_type");
      localMallTransactionObject.mOA = ac(paramJSONObject);
      return localMallTransactionObject;
    }
    return null;
  }
  
  private static List<MallOrderDetailObject.HelpCenter> ac(JSONObject paramJSONObject)
  {
    localLinkedList = new LinkedList();
    try
    {
      paramJSONObject = paramJSONObject.getJSONArray("help_center");
      int i = 0;
      while (i < paramJSONObject.length())
      {
        MallOrderDetailObject.HelpCenter localHelpCenter = new MallOrderDetailObject.HelpCenter();
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        localHelpCenter.bHj = localJSONObject.optBoolean("is_show_button");
        localHelpCenter.name = localJSONObject.optString("name");
        localHelpCenter.url = localJSONObject.optString("url");
        localLinkedList.add(localHelpCenter);
        i += 1;
      }
      return localLinkedList;
    }
    catch (Exception paramJSONObject)
    {
      y.printErrStackTrace("MicroMsg.MallTransactionObject", paramJSONObject, "", new Object[0]);
      y.e("MicroMsg.MallTransactionObject", "parseHelpCenter error %s", new Object[] { paramJSONObject.getMessage() });
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.brC);
    paramParcel.writeInt(this.ccY);
    paramParcel.writeInt(this.bBt);
    paramParcel.writeString(this.mOL);
    paramParcel.writeString(this.mOM);
    paramParcel.writeString(this.mON);
    paramParcel.writeString(this.mOO);
    paramParcel.writeString(this.desc);
    paramParcel.writeString(this.mOP);
    paramParcel.writeString(this.mOQ);
    paramParcel.writeDouble(this.iHP);
    paramParcel.writeString(this.mOR);
    paramParcel.writeString(this.mOS);
    paramParcel.writeString(this.mOT);
    paramParcel.writeString(this.mOU);
    paramParcel.writeInt(this.enw);
    paramParcel.writeInt(this.mOV);
    paramParcel.writeString(this.bMY);
    paramParcel.writeString(this.mOW);
    paramParcel.writeString(this.mOX);
    paramParcel.writeString(this.mOZ);
    paramParcel.writeString(this.mPa);
    paramParcel.writeString(this.mOD);
    paramParcel.writeString(this.mPb);
    paramParcel.writeString(this.fPM);
    paramParcel.writeString(this.mPc);
    paramParcel.writeString(this.mPd);
    paramParcel.writeString(this.mPe);
    paramParcel.writeDouble(this.mPf);
    paramParcel.writeString(this.mPg);
    paramParcel.writeString(this.mPh);
    paramParcel.writeString(this.mPi);
    paramParcel.writeString(this.mPj);
    paramParcel.writeInt(this.mPl);
    paramParcel.writeInt(this.mPr);
    paramParcel.writeDouble(this.mPn);
    paramParcel.writeString(this.mPo);
    paramParcel.writeInt(this.mPp);
    paramParcel.writeString(this.mPq);
    paramParcel.writeInt(this.mPr);
    paramParcel.writeInt(this.mPs);
    paramParcel.writeInt(this.mPt);
    paramParcel.writeString(this.mPu);
    paramParcel.writeString(this.mPv);
    paramParcel.writeString(this.mPw);
    paramParcel.writeString(this.mPx);
    paramParcel.writeString(this.mPy);
    paramParcel.writeString(this.mPz);
    paramParcel.writeDouble(this.mPA);
    paramParcel.writeString(this.mPB);
    paramParcel.writeString(this.mPk);
    paramParcel.writeInt(this.mOB);
    paramParcel.writeInt(this.mOA.size());
    Iterator localIterator = this.mOA.iterator();
    while (localIterator.hasNext()) {
      paramParcel.writeParcelable((MallOrderDetailObject.HelpCenter)localIterator.next(), paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.MallTransactionObject
 * JD-Core Version:    0.7.0.1
 */