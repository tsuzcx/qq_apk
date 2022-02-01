package com.tencent.mm.plugin.order.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class MallTransactionObject
  implements Parcelable
{
  public static final Parcelable.Creator<MallTransactionObject> CREATOR;
  public int cUB;
  public int dAs;
  public String dad;
  public String desc;
  public int hGU;
  public String igG;
  public double oxA;
  public int subType;
  public int type;
  public List<MallOrderDetailObject.HelpCenter> vwM;
  public int vwN;
  public String vwP;
  public String vwX;
  public String vwY;
  public String vwZ;
  public String vxA;
  public int vxB;
  public String vxC;
  public int vxD;
  public int vxE;
  public int vxF;
  public String vxG;
  public String vxH;
  public String vxI;
  public String vxJ;
  public String vxK;
  public String vxL;
  public double vxM;
  public String vxN;
  public String vxa;
  public String vxb;
  public String vxc;
  public String vxd;
  public String vxe;
  public String vxf;
  public String vxg;
  public int vxh;
  public String vxi;
  public String vxj;
  public String vxk;
  public String vxl;
  public String vxm;
  public String vxn;
  public String vxo;
  public String vxp;
  public String vxq;
  public double vxr;
  public String vxs;
  public String vxt;
  public String vxu;
  public String vxv;
  public String vxw;
  public int vxx;
  public int vxy;
  public double vxz;
  
  static
  {
    AppMethodBeat.i(66680);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(66680);
  }
  
  public MallTransactionObject()
  {
    AppMethodBeat.i(66675);
    this.oxA = 0.0D;
    this.vwM = new LinkedList();
    this.vwN = -1;
    AppMethodBeat.o(66675);
  }
  
  public MallTransactionObject(Parcel paramParcel)
  {
    AppMethodBeat.i(66676);
    this.oxA = 0.0D;
    this.vwM = new LinkedList();
    this.vwN = -1;
    this.subType = paramParcel.readInt();
    this.dAs = paramParcel.readInt();
    this.cUB = paramParcel.readInt();
    this.vwX = paramParcel.readString();
    this.vwY = paramParcel.readString();
    this.vwZ = paramParcel.readString();
    this.vxa = paramParcel.readString();
    this.desc = paramParcel.readString();
    this.vxb = paramParcel.readString();
    this.vxc = paramParcel.readString();
    this.oxA = paramParcel.readDouble();
    this.vxd = paramParcel.readString();
    this.vxe = paramParcel.readString();
    this.vxf = paramParcel.readString();
    this.vxg = paramParcel.readString();
    this.hGU = paramParcel.readInt();
    this.vxh = paramParcel.readInt();
    this.dad = paramParcel.readString();
    this.vxi = paramParcel.readString();
    this.vxj = paramParcel.readString();
    this.vxl = paramParcel.readString();
    this.vxm = paramParcel.readString();
    this.vwP = paramParcel.readString();
    this.vxn = paramParcel.readString();
    this.igG = paramParcel.readString();
    this.vxo = paramParcel.readString();
    this.vxp = paramParcel.readString();
    this.vxq = paramParcel.readString();
    this.vxr = paramParcel.readDouble();
    this.vxs = paramParcel.readString();
    this.vxt = paramParcel.readString();
    this.vxu = paramParcel.readString();
    this.vxv = paramParcel.readString();
    this.vxx = paramParcel.readInt();
    this.vxD = paramParcel.readInt();
    this.vxz = paramParcel.readDouble();
    this.vxA = paramParcel.readString();
    this.vxB = paramParcel.readInt();
    this.vxC = paramParcel.readString();
    this.vxD = paramParcel.readInt();
    this.vxE = paramParcel.readInt();
    this.vxF = paramParcel.readInt();
    this.vxG = paramParcel.readString();
    this.vxH = paramParcel.readString();
    this.vxI = paramParcel.readString();
    this.vxJ = paramParcel.readString();
    this.vxK = paramParcel.readString();
    this.vxL = paramParcel.readString();
    this.vxM = paramParcel.readDouble();
    this.vxN = paramParcel.readString();
    this.vxw = paramParcel.readString();
    this.vwN = paramParcel.readInt();
    int j = paramParcel.readInt();
    this.vwM = new LinkedList();
    int i = 0;
    while (i < j)
    {
      MallOrderDetailObject.HelpCenter localHelpCenter = (MallOrderDetailObject.HelpCenter)paramParcel.readParcelable(MallOrderDetailObject.HelpCenter.class.getClassLoader());
      this.vwM.add(localHelpCenter);
      i += 1;
    }
    AppMethodBeat.o(66676);
  }
  
  public static MallTransactionObject aC(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(66678);
    if (paramJSONObject != null)
    {
      MallTransactionObject localMallTransactionObject = new MallTransactionObject();
      localMallTransactionObject.type = paramJSONObject.optInt("rec_type", 1);
      localMallTransactionObject.subType = paramJSONObject.optInt("sub_pay_type", 0);
      localMallTransactionObject.dAs = paramJSONObject.optInt("pay_scene");
      localMallTransactionObject.cUB = paramJSONObject.optInt("user_type");
      localMallTransactionObject.vwX = paramJSONObject.optString("buy_uin");
      localMallTransactionObject.vwY = paramJSONObject.optString("buy_name");
      localMallTransactionObject.vwZ = paramJSONObject.optString("sale_uin");
      localMallTransactionObject.vxa = paramJSONObject.optString("sale_name");
      localMallTransactionObject.dad = paramJSONObject.optString("trans_id");
      localMallTransactionObject.vxi = paramJSONObject.optString("sp_billno");
      localMallTransactionObject.desc = paramJSONObject.optString("goods_name");
      localMallTransactionObject.vxb = paramJSONObject.optString("goods_detail");
      localMallTransactionObject.oxA = (paramJSONObject.optDouble("fee") / 100.0D);
      localMallTransactionObject.vxd = paramJSONObject.optString("fee_color");
      localMallTransactionObject.vxe = paramJSONObject.optString("trade_state");
      localMallTransactionObject.vxf = paramJSONObject.optString("trade_state_name");
      localMallTransactionObject.vxg = paramJSONObject.optString("trade_state_color");
      localMallTransactionObject.vxj = paramJSONObject.optString("buy_bank_name");
      localMallTransactionObject.vxk = paramJSONObject.optString("card_tail");
      localMallTransactionObject.hGU = paramJSONObject.optInt("create_timestamp");
      localMallTransactionObject.vxh = paramJSONObject.optInt("modify_timestamp");
      localMallTransactionObject.vxl = paramJSONObject.optString("fee_type");
      JSONObject localJSONObject = paramJSONObject.optJSONObject("appinfo");
      if (localJSONObject != null)
      {
        localMallTransactionObject.vxm = localJSONObject.optString("app_username");
        localMallTransactionObject.vwP = localJSONObject.optString("app_telephone");
        localMallTransactionObject.vxn = localJSONObject.optString("app_nickname");
        localMallTransactionObject.igG = localJSONObject.optString("app_icon_url");
        localMallTransactionObject.vxv = localJSONObject.optString("safeguard_url");
        localMallTransactionObject.vxw = localJSONObject.optString("display_name");
      }
      localMallTransactionObject.vxo = paramJSONObject.optString("deliver_price");
      localMallTransactionObject.vxp = paramJSONObject.optString("preferential_price");
      localMallTransactionObject.vxq = paramJSONObject.optString("discount");
      localMallTransactionObject.vxr = (paramJSONObject.optDouble("original_total_fee") / 100.0D);
      localMallTransactionObject.vxs = paramJSONObject.optString("total_price");
      localMallTransactionObject.vxt = paramJSONObject.optString("receipt_company");
      localMallTransactionObject.vxu = paramJSONObject.optString("biz_pledge");
      localMallTransactionObject.vxx = paramJSONObject.optInt("pre_fetch_timestamp");
      localMallTransactionObject.vxy = paramJSONObject.optInt("arrived_timestamp");
      localMallTransactionObject.vxz = (paramJSONObject.optDouble("transfer_fee") / 100.0D);
      localMallTransactionObject.vxA = paramJSONObject.optString("receiver_name");
      localMallTransactionObject.vxB = paramJSONObject.optInt("allow_resend_msg");
      localMallTransactionObject.vxC = paramJSONObject.optString("charge_fee");
      localMallTransactionObject.vxD = paramJSONObject.optInt("receive_timestamp");
      localMallTransactionObject.vxE = paramJSONObject.optInt("refund_timestamp");
      localMallTransactionObject.vxF = paramJSONObject.optInt("create_timestamp");
      localMallTransactionObject.vxG = paramJSONObject.optString("buy_bank_type");
      localMallTransactionObject.vxH = paramJSONObject.optString("payer_name");
      localMallTransactionObject.vxI = paramJSONObject.optString("true_name");
      localMallTransactionObject.vxJ = paramJSONObject.optString("refund_bank_type");
      localMallTransactionObject.vxK = paramJSONObject.optString("rateinfo");
      localMallTransactionObject.vxL = paramJSONObject.optString("original_feeinfo");
      localMallTransactionObject.vxM = (paramJSONObject.optDouble("fetch_total_fee") / 100.0D);
      localMallTransactionObject.vxN = paramJSONObject.optString("fetch_total_fee_color");
      localMallTransactionObject.vwN = paramJSONObject.optInt("userroll_type");
      localMallTransactionObject.vwM = aD(paramJSONObject);
      AppMethodBeat.o(66678);
      return localMallTransactionObject;
    }
    AppMethodBeat.o(66678);
    return null;
  }
  
  private static List<MallOrderDetailObject.HelpCenter> aD(JSONObject paramJSONObject)
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
        localHelpCenter.daU = localJSONObject.optBoolean("is_show_button");
        localHelpCenter.name = localJSONObject.optString("name");
        localHelpCenter.url = localJSONObject.optString("url");
        localLinkedList.add(localHelpCenter);
        i += 1;
      }
      return localLinkedList;
    }
    catch (Exception paramJSONObject)
    {
      ac.printErrStackTrace("MicroMsg.MallTransactionObject", paramJSONObject, "", new Object[0]);
      ac.e("MicroMsg.MallTransactionObject", "parseHelpCenter error %s", new Object[] { paramJSONObject.getMessage() });
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
    paramParcel.writeInt(this.dAs);
    paramParcel.writeInt(this.cUB);
    paramParcel.writeString(this.vwX);
    paramParcel.writeString(this.vwY);
    paramParcel.writeString(this.vwZ);
    paramParcel.writeString(this.vxa);
    paramParcel.writeString(this.desc);
    paramParcel.writeString(this.vxb);
    paramParcel.writeString(this.vxc);
    paramParcel.writeDouble(this.oxA);
    paramParcel.writeString(this.vxd);
    paramParcel.writeString(this.vxe);
    paramParcel.writeString(this.vxf);
    paramParcel.writeString(this.vxg);
    paramParcel.writeInt(this.hGU);
    paramParcel.writeInt(this.vxh);
    paramParcel.writeString(this.dad);
    paramParcel.writeString(this.vxi);
    paramParcel.writeString(this.vxj);
    paramParcel.writeString(this.vxl);
    paramParcel.writeString(this.vxm);
    paramParcel.writeString(this.vwP);
    paramParcel.writeString(this.vxn);
    paramParcel.writeString(this.igG);
    paramParcel.writeString(this.vxo);
    paramParcel.writeString(this.vxp);
    paramParcel.writeString(this.vxq);
    paramParcel.writeDouble(this.vxr);
    paramParcel.writeString(this.vxs);
    paramParcel.writeString(this.vxt);
    paramParcel.writeString(this.vxu);
    paramParcel.writeString(this.vxv);
    paramParcel.writeInt(this.vxx);
    paramParcel.writeInt(this.vxD);
    paramParcel.writeDouble(this.vxz);
    paramParcel.writeString(this.vxA);
    paramParcel.writeInt(this.vxB);
    paramParcel.writeString(this.vxC);
    paramParcel.writeInt(this.vxD);
    paramParcel.writeInt(this.vxE);
    paramParcel.writeInt(this.vxF);
    paramParcel.writeString(this.vxG);
    paramParcel.writeString(this.vxH);
    paramParcel.writeString(this.vxI);
    paramParcel.writeString(this.vxJ);
    paramParcel.writeString(this.vxK);
    paramParcel.writeString(this.vxL);
    paramParcel.writeDouble(this.vxM);
    paramParcel.writeString(this.vxN);
    paramParcel.writeString(this.vxw);
    paramParcel.writeInt(this.vwN);
    paramParcel.writeInt(this.vwM.size());
    Iterator localIterator = this.vwM.iterator();
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