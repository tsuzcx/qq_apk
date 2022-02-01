package com.tencent.mm.plugin.wallet_core.id_verify.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public class RealNameBundle
  implements Parcelable
{
  public static final Parcelable.Creator<RealNameBundle> CREATOR;
  public int CTA;
  public String CTB;
  public String CTa;
  public String CTb;
  public String CTc;
  public int CTd;
  public String CTe;
  public Profession CTf;
  public String CTg;
  public String CTh;
  public String CTi;
  public String CTj;
  public int CTk;
  public String CTl;
  public int CTm;
  public int CTn;
  public int CTo;
  public String CTp;
  public int CTq;
  public int CTr;
  public int CTs;
  public String CTt;
  public String CTu;
  public String CTv;
  public String CTw;
  public String CTx;
  public int CTy;
  public int CTz;
  public int ePk;
  
  static
  {
    AppMethodBeat.i(70167);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70167);
  }
  
  public RealNameBundle() {}
  
  protected RealNameBundle(Parcel paramParcel)
  {
    AppMethodBeat.i(70165);
    this.CTa = paramParcel.readString();
    this.CTb = paramParcel.readString();
    this.CTc = paramParcel.readString();
    this.CTd = paramParcel.readInt();
    this.CTe = paramParcel.readString();
    this.CTf = ((Profession)paramParcel.readParcelable(Profession.class.getClassLoader()));
    this.CTg = paramParcel.readString();
    this.CTh = paramParcel.readString();
    this.CTi = paramParcel.readString();
    this.CTj = paramParcel.readString();
    this.CTk = paramParcel.readInt();
    this.CTl = paramParcel.readString();
    this.CTm = paramParcel.readInt();
    this.CTn = paramParcel.readInt();
    this.CTo = paramParcel.readInt();
    this.CTp = paramParcel.readString();
    this.CTq = paramParcel.readInt();
    this.CTr = paramParcel.readInt();
    this.CTs = paramParcel.readInt();
    this.CTt = paramParcel.readString();
    this.CTu = paramParcel.readString();
    this.CTv = paramParcel.readString();
    this.CTw = paramParcel.readString();
    this.CTx = paramParcel.readString();
    this.CTy = paramParcel.readInt();
    this.CTz = paramParcel.readInt();
    this.CTA = paramParcel.readInt();
    this.CTB = paramParcel.readString();
    this.ePk = paramParcel.readInt();
    AppMethodBeat.o(70165);
  }
  
  public final void aT(Map<String, String> paramMap)
  {
    AppMethodBeat.i(174505);
    paramMap.put("detail_address", this.CTw);
    paramMap.put("phone_no", this.CTB);
    paramMap.put("sex", String.valueOf(this.ePk));
    paramMap.put("nationality", this.CTt);
    paramMap.put("birth_date", this.CTp);
    if (this.CTf != null) {}
    for (String str = this.CTf.CSY;; str = "")
    {
      paramMap.put("profession_name", str);
      paramMap.put("user_country", this.CTg);
      paramMap.put("user_province", this.CTh);
      paramMap.put("user_city", this.CTi);
      paramMap.put("cre_expire_date", this.CTl);
      paramMap.put("creid_renewal", String.valueOf(this.CTk));
      paramMap.put("cre_effect_date", this.CTx);
      AppMethodBeat.o(174505);
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(70166);
    paramParcel.writeString(this.CTa);
    paramParcel.writeString(this.CTb);
    paramParcel.writeString(this.CTc);
    paramParcel.writeInt(this.CTd);
    paramParcel.writeString(this.CTe);
    paramParcel.writeParcelable(this.CTf, 1);
    paramParcel.writeString(this.CTg);
    paramParcel.writeString(this.CTh);
    paramParcel.writeString(this.CTi);
    paramParcel.writeString(this.CTj);
    paramParcel.writeInt(this.CTk);
    paramParcel.writeString(this.CTl);
    paramParcel.writeInt(this.CTm);
    paramParcel.writeInt(this.CTn);
    paramParcel.writeInt(this.CTo);
    paramParcel.writeString(this.CTp);
    paramParcel.writeInt(this.CTq);
    paramParcel.writeInt(this.CTr);
    paramParcel.writeInt(this.CTs);
    paramParcel.writeString(this.CTt);
    paramParcel.writeString(this.CTu);
    paramParcel.writeString(this.CTv);
    paramParcel.writeString(this.CTw);
    paramParcel.writeString(this.CTx);
    paramParcel.writeInt(this.CTy);
    paramParcel.writeInt(this.CTz);
    paramParcel.writeInt(this.CTA);
    paramParcel.writeString(this.CTB);
    paramParcel.writeInt(this.ePk);
    AppMethodBeat.o(70166);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.RealNameBundle
 * JD-Core Version:    0.7.0.1
 */