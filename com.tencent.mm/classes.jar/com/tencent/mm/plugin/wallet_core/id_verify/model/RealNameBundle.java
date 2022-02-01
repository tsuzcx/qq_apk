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
  public int OMA;
  public String OMB;
  public String OMa;
  public String OMb;
  public String OMc;
  public int OMd;
  public String OMe;
  public Profession OMf;
  public String OMg;
  public String OMh;
  public String OMi;
  public String OMj;
  public int OMk;
  public String OMl;
  public int OMm;
  public int OMn;
  public int OMo;
  public String OMp;
  public int OMq;
  public int OMr;
  public int OMs;
  public String OMt;
  public String OMu;
  public String OMv;
  public String OMw;
  public String OMx;
  public int OMy;
  public int OMz;
  public int sex;
  
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
    this.OMa = paramParcel.readString();
    this.OMb = paramParcel.readString();
    this.OMc = paramParcel.readString();
    this.OMd = paramParcel.readInt();
    this.OMe = paramParcel.readString();
    this.OMf = ((Profession)paramParcel.readParcelable(Profession.class.getClassLoader()));
    this.OMg = paramParcel.readString();
    this.OMh = paramParcel.readString();
    this.OMi = paramParcel.readString();
    this.OMj = paramParcel.readString();
    this.OMk = paramParcel.readInt();
    this.OMl = paramParcel.readString();
    this.OMm = paramParcel.readInt();
    this.OMn = paramParcel.readInt();
    this.OMo = paramParcel.readInt();
    this.OMp = paramParcel.readString();
    this.OMq = paramParcel.readInt();
    this.OMr = paramParcel.readInt();
    this.OMs = paramParcel.readInt();
    this.OMt = paramParcel.readString();
    this.OMu = paramParcel.readString();
    this.OMv = paramParcel.readString();
    this.OMw = paramParcel.readString();
    this.OMx = paramParcel.readString();
    this.OMy = paramParcel.readInt();
    this.OMz = paramParcel.readInt();
    this.OMA = paramParcel.readInt();
    this.OMB = paramParcel.readString();
    this.sex = paramParcel.readInt();
    AppMethodBeat.o(70165);
  }
  
  public final void aS(Map<String, String> paramMap)
  {
    AppMethodBeat.i(174505);
    paramMap.put("detail_address", this.OMw);
    paramMap.put("phone_no", this.OMB);
    paramMap.put("sex", String.valueOf(this.sex));
    paramMap.put("nationality", this.OMt);
    paramMap.put("birth_date", this.OMp);
    if (this.OMf != null) {}
    for (String str = this.OMf.OLY;; str = "")
    {
      paramMap.put("profession_name", str);
      paramMap.put("user_country", this.OMg);
      paramMap.put("user_province", this.OMh);
      paramMap.put("user_city", this.OMi);
      paramMap.put("cre_expire_date", this.OMl);
      paramMap.put("creid_renewal", String.valueOf(this.OMk));
      paramMap.put("cre_effect_date", this.OMx);
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
    paramParcel.writeString(this.OMa);
    paramParcel.writeString(this.OMb);
    paramParcel.writeString(this.OMc);
    paramParcel.writeInt(this.OMd);
    paramParcel.writeString(this.OMe);
    paramParcel.writeParcelable(this.OMf, 1);
    paramParcel.writeString(this.OMg);
    paramParcel.writeString(this.OMh);
    paramParcel.writeString(this.OMi);
    paramParcel.writeString(this.OMj);
    paramParcel.writeInt(this.OMk);
    paramParcel.writeString(this.OMl);
    paramParcel.writeInt(this.OMm);
    paramParcel.writeInt(this.OMn);
    paramParcel.writeInt(this.OMo);
    paramParcel.writeString(this.OMp);
    paramParcel.writeInt(this.OMq);
    paramParcel.writeInt(this.OMr);
    paramParcel.writeInt(this.OMs);
    paramParcel.writeString(this.OMt);
    paramParcel.writeString(this.OMu);
    paramParcel.writeString(this.OMv);
    paramParcel.writeString(this.OMw);
    paramParcel.writeString(this.OMx);
    paramParcel.writeInt(this.OMy);
    paramParcel.writeInt(this.OMz);
    paramParcel.writeInt(this.OMA);
    paramParcel.writeString(this.OMB);
    paramParcel.writeInt(this.sex);
    AppMethodBeat.o(70166);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.RealNameBundle
 * JD-Core Version:    0.7.0.1
 */