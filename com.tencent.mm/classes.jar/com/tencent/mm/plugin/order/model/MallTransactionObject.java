package com.tencent.mm.plugin.order.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class MallTransactionObject
  implements Parcelable
{
  public static final Parcelable.Creator<MallTransactionObject> CREATOR;
  public int cLI;
  public int cii;
  public String cnJ;
  public String desc;
  public int fDT;
  public String hiQ;
  public double kNS;
  public List<MallOrderDetailObject.HelpCenter> poQ;
  public int poR;
  public String poT;
  public String ppA;
  public int ppB;
  public int ppC;
  public double ppD;
  public String ppE;
  public int ppF;
  public String ppG;
  public int ppH;
  public int ppI;
  public int ppJ;
  public String ppK;
  public String ppL;
  public String ppM;
  public String ppN;
  public String ppO;
  public String ppP;
  public double ppQ;
  public String ppR;
  public String ppb;
  public String ppc;
  public String ppd;
  public String ppe;
  public String ppf;
  public String ppg;
  public String pph;
  public String ppi;
  public String ppj;
  public String ppk;
  public int ppl;
  public String ppm;
  public String ppn;
  public String ppo;
  public String ppp;
  public String ppq;
  public String ppr;
  public String pps;
  public String ppt;
  public String ppu;
  public double ppv;
  public String ppw;
  public String ppx;
  public String ppy;
  public String ppz;
  public int subType;
  public int type;
  
  static
  {
    AppMethodBeat.i(43772);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(43772);
  }
  
  public MallTransactionObject()
  {
    AppMethodBeat.i(43767);
    this.kNS = 0.0D;
    this.poQ = new LinkedList();
    this.poR = -1;
    AppMethodBeat.o(43767);
  }
  
  public MallTransactionObject(Parcel paramParcel)
  {
    AppMethodBeat.i(43768);
    this.kNS = 0.0D;
    this.poQ = new LinkedList();
    this.poR = -1;
    this.subType = paramParcel.readInt();
    this.cLI = paramParcel.readInt();
    this.cii = paramParcel.readInt();
    this.ppb = paramParcel.readString();
    this.ppc = paramParcel.readString();
    this.ppd = paramParcel.readString();
    this.ppe = paramParcel.readString();
    this.desc = paramParcel.readString();
    this.ppf = paramParcel.readString();
    this.ppg = paramParcel.readString();
    this.kNS = paramParcel.readDouble();
    this.pph = paramParcel.readString();
    this.ppi = paramParcel.readString();
    this.ppj = paramParcel.readString();
    this.ppk = paramParcel.readString();
    this.fDT = paramParcel.readInt();
    this.ppl = paramParcel.readInt();
    this.cnJ = paramParcel.readString();
    this.ppm = paramParcel.readString();
    this.ppn = paramParcel.readString();
    this.ppp = paramParcel.readString();
    this.ppq = paramParcel.readString();
    this.poT = paramParcel.readString();
    this.ppr = paramParcel.readString();
    this.hiQ = paramParcel.readString();
    this.pps = paramParcel.readString();
    this.ppt = paramParcel.readString();
    this.ppu = paramParcel.readString();
    this.ppv = paramParcel.readDouble();
    this.ppw = paramParcel.readString();
    this.ppx = paramParcel.readString();
    this.ppy = paramParcel.readString();
    this.ppz = paramParcel.readString();
    this.ppB = paramParcel.readInt();
    this.ppH = paramParcel.readInt();
    this.ppD = paramParcel.readDouble();
    this.ppE = paramParcel.readString();
    this.ppF = paramParcel.readInt();
    this.ppG = paramParcel.readString();
    this.ppH = paramParcel.readInt();
    this.ppI = paramParcel.readInt();
    this.ppJ = paramParcel.readInt();
    this.ppK = paramParcel.readString();
    this.ppL = paramParcel.readString();
    this.ppM = paramParcel.readString();
    this.ppN = paramParcel.readString();
    this.ppO = paramParcel.readString();
    this.ppP = paramParcel.readString();
    this.ppQ = paramParcel.readDouble();
    this.ppR = paramParcel.readString();
    this.ppA = paramParcel.readString();
    this.poR = paramParcel.readInt();
    int j = paramParcel.readInt();
    this.poQ = new LinkedList();
    int i = 0;
    while (i < j)
    {
      MallOrderDetailObject.HelpCenter localHelpCenter = (MallOrderDetailObject.HelpCenter)paramParcel.readParcelable(MallOrderDetailObject.HelpCenter.class.getClassLoader());
      this.poQ.add(localHelpCenter);
      i += 1;
    }
    AppMethodBeat.o(43768);
  }
  
  public static MallTransactionObject am(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(43770);
    if (paramJSONObject != null)
    {
      MallTransactionObject localMallTransactionObject = new MallTransactionObject();
      localMallTransactionObject.type = paramJSONObject.optInt("rec_type", 1);
      localMallTransactionObject.subType = paramJSONObject.optInt("sub_pay_type", 0);
      localMallTransactionObject.cLI = paramJSONObject.optInt("pay_scene");
      localMallTransactionObject.cii = paramJSONObject.optInt("user_type");
      localMallTransactionObject.ppb = paramJSONObject.optString("buy_uin");
      localMallTransactionObject.ppc = paramJSONObject.optString("buy_name");
      localMallTransactionObject.ppd = paramJSONObject.optString("sale_uin");
      localMallTransactionObject.ppe = paramJSONObject.optString("sale_name");
      localMallTransactionObject.cnJ = paramJSONObject.optString("trans_id");
      localMallTransactionObject.ppm = paramJSONObject.optString("sp_billno");
      localMallTransactionObject.desc = paramJSONObject.optString("goods_name");
      localMallTransactionObject.ppf = paramJSONObject.optString("goods_detail");
      localMallTransactionObject.kNS = (paramJSONObject.optDouble("fee") / 100.0D);
      localMallTransactionObject.pph = paramJSONObject.optString("fee_color");
      localMallTransactionObject.ppi = paramJSONObject.optString("trade_state");
      localMallTransactionObject.ppj = paramJSONObject.optString("trade_state_name");
      localMallTransactionObject.ppk = paramJSONObject.optString("trade_state_color");
      localMallTransactionObject.ppn = paramJSONObject.optString("buy_bank_name");
      localMallTransactionObject.ppo = paramJSONObject.optString("card_tail");
      localMallTransactionObject.fDT = paramJSONObject.optInt("create_timestamp");
      localMallTransactionObject.ppl = paramJSONObject.optInt("modify_timestamp");
      localMallTransactionObject.ppp = paramJSONObject.optString("fee_type");
      JSONObject localJSONObject = paramJSONObject.optJSONObject("appinfo");
      if (localJSONObject != null)
      {
        localMallTransactionObject.ppq = localJSONObject.optString("app_username");
        localMallTransactionObject.poT = localJSONObject.optString("app_telephone");
        localMallTransactionObject.ppr = localJSONObject.optString("app_nickname");
        localMallTransactionObject.hiQ = localJSONObject.optString("app_icon_url");
        localMallTransactionObject.ppz = localJSONObject.optString("safeguard_url");
        localMallTransactionObject.ppA = localJSONObject.optString("display_name");
      }
      localMallTransactionObject.pps = paramJSONObject.optString("deliver_price");
      localMallTransactionObject.ppt = paramJSONObject.optString("preferential_price");
      localMallTransactionObject.ppu = paramJSONObject.optString("discount");
      localMallTransactionObject.ppv = (paramJSONObject.optDouble("original_total_fee") / 100.0D);
      localMallTransactionObject.ppw = paramJSONObject.optString("total_price");
      localMallTransactionObject.ppx = paramJSONObject.optString("receipt_company");
      localMallTransactionObject.ppy = paramJSONObject.optString("biz_pledge");
      localMallTransactionObject.ppB = paramJSONObject.optInt("pre_fetch_timestamp");
      localMallTransactionObject.ppC = paramJSONObject.optInt("arrived_timestamp");
      localMallTransactionObject.ppD = (paramJSONObject.optDouble("transfer_fee") / 100.0D);
      localMallTransactionObject.ppE = paramJSONObject.optString("receiver_name");
      localMallTransactionObject.ppF = paramJSONObject.optInt("allow_resend_msg");
      localMallTransactionObject.ppG = paramJSONObject.optString("charge_fee");
      localMallTransactionObject.ppH = paramJSONObject.optInt("receive_timestamp");
      localMallTransactionObject.ppI = paramJSONObject.optInt("refund_timestamp");
      localMallTransactionObject.ppJ = paramJSONObject.optInt("create_timestamp");
      localMallTransactionObject.ppK = paramJSONObject.optString("buy_bank_type");
      localMallTransactionObject.ppL = paramJSONObject.optString("payer_name");
      localMallTransactionObject.ppM = paramJSONObject.optString("true_name");
      localMallTransactionObject.ppN = paramJSONObject.optString("refund_bank_type");
      localMallTransactionObject.ppO = paramJSONObject.optString("rateinfo");
      localMallTransactionObject.ppP = paramJSONObject.optString("original_feeinfo");
      localMallTransactionObject.ppQ = (paramJSONObject.optDouble("fetch_total_fee") / 100.0D);
      localMallTransactionObject.ppR = paramJSONObject.optString("fetch_total_fee_color");
      localMallTransactionObject.poR = paramJSONObject.optInt("userroll_type");
      localMallTransactionObject.poQ = an(paramJSONObject);
      AppMethodBeat.o(43770);
      return localMallTransactionObject;
    }
    AppMethodBeat.o(43770);
    return null;
  }
  
  private static List<MallOrderDetailObject.HelpCenter> an(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(43771);
    localLinkedList = new LinkedList();
    try
    {
      paramJSONObject = paramJSONObject.getJSONArray("help_center");
      int i = 0;
      while (i < paramJSONObject.length())
      {
        MallOrderDetailObject.HelpCenter localHelpCenter = new MallOrderDetailObject.HelpCenter();
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        localHelpCenter.coy = localJSONObject.optBoolean("is_show_button");
        localHelpCenter.name = localJSONObject.optString("name");
        localHelpCenter.url = localJSONObject.optString("url");
        localLinkedList.add(localHelpCenter);
        i += 1;
      }
      return localLinkedList;
    }
    catch (Exception paramJSONObject)
    {
      ab.printErrStackTrace("MicroMsg.MallTransactionObject", paramJSONObject, "", new Object[0]);
      ab.e("MicroMsg.MallTransactionObject", "parseHelpCenter error %s", new Object[] { paramJSONObject.getMessage() });
      AppMethodBeat.o(43771);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(43769);
    paramParcel.writeInt(this.subType);
    paramParcel.writeInt(this.cLI);
    paramParcel.writeInt(this.cii);
    paramParcel.writeString(this.ppb);
    paramParcel.writeString(this.ppc);
    paramParcel.writeString(this.ppd);
    paramParcel.writeString(this.ppe);
    paramParcel.writeString(this.desc);
    paramParcel.writeString(this.ppf);
    paramParcel.writeString(this.ppg);
    paramParcel.writeDouble(this.kNS);
    paramParcel.writeString(this.pph);
    paramParcel.writeString(this.ppi);
    paramParcel.writeString(this.ppj);
    paramParcel.writeString(this.ppk);
    paramParcel.writeInt(this.fDT);
    paramParcel.writeInt(this.ppl);
    paramParcel.writeString(this.cnJ);
    paramParcel.writeString(this.ppm);
    paramParcel.writeString(this.ppn);
    paramParcel.writeString(this.ppp);
    paramParcel.writeString(this.ppq);
    paramParcel.writeString(this.poT);
    paramParcel.writeString(this.ppr);
    paramParcel.writeString(this.hiQ);
    paramParcel.writeString(this.pps);
    paramParcel.writeString(this.ppt);
    paramParcel.writeString(this.ppu);
    paramParcel.writeDouble(this.ppv);
    paramParcel.writeString(this.ppw);
    paramParcel.writeString(this.ppx);
    paramParcel.writeString(this.ppy);
    paramParcel.writeString(this.ppz);
    paramParcel.writeInt(this.ppB);
    paramParcel.writeInt(this.ppH);
    paramParcel.writeDouble(this.ppD);
    paramParcel.writeString(this.ppE);
    paramParcel.writeInt(this.ppF);
    paramParcel.writeString(this.ppG);
    paramParcel.writeInt(this.ppH);
    paramParcel.writeInt(this.ppI);
    paramParcel.writeInt(this.ppJ);
    paramParcel.writeString(this.ppK);
    paramParcel.writeString(this.ppL);
    paramParcel.writeString(this.ppM);
    paramParcel.writeString(this.ppN);
    paramParcel.writeString(this.ppO);
    paramParcel.writeString(this.ppP);
    paramParcel.writeDouble(this.ppQ);
    paramParcel.writeString(this.ppR);
    paramParcel.writeString(this.ppA);
    paramParcel.writeInt(this.poR);
    paramParcel.writeInt(this.poQ.size());
    Iterator localIterator = this.poQ.iterator();
    while (localIterator.hasNext()) {
      paramParcel.writeParcelable((MallOrderDetailObject.HelpCenter)localIterator.next(), paramInt);
    }
    AppMethodBeat.o(43769);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.MallTransactionObject
 * JD-Core Version:    0.7.0.1
 */