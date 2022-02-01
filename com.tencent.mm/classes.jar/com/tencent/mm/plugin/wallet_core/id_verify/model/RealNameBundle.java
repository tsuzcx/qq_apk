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
  public String BsL;
  public String BsM;
  public String BsN;
  public int BsO;
  public String BsP;
  public Profession BsQ;
  public String BsR;
  public String BsS;
  public String BsT;
  public String BsU;
  public int BsV;
  public String BsW;
  public int BsX;
  public int BsY;
  public int BsZ;
  public String Bta;
  public int Btb;
  public int Btc;
  public int Btd;
  public String Bte;
  public String Btf;
  public String Btg;
  public String Bth;
  public String Bti;
  public int Btj;
  public int Btk;
  public int Btl;
  public String Btm;
  public int exL;
  
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
    this.BsL = paramParcel.readString();
    this.BsM = paramParcel.readString();
    this.BsN = paramParcel.readString();
    this.BsO = paramParcel.readInt();
    this.BsP = paramParcel.readString();
    this.BsQ = ((Profession)paramParcel.readParcelable(Profession.class.getClassLoader()));
    this.BsR = paramParcel.readString();
    this.BsS = paramParcel.readString();
    this.BsT = paramParcel.readString();
    this.BsU = paramParcel.readString();
    this.BsV = paramParcel.readInt();
    this.BsW = paramParcel.readString();
    this.BsX = paramParcel.readInt();
    this.BsY = paramParcel.readInt();
    this.BsZ = paramParcel.readInt();
    this.Bta = paramParcel.readString();
    this.Btb = paramParcel.readInt();
    this.Btc = paramParcel.readInt();
    this.Btd = paramParcel.readInt();
    this.Bte = paramParcel.readString();
    this.Btf = paramParcel.readString();
    this.Btg = paramParcel.readString();
    this.Bth = paramParcel.readString();
    this.Bti = paramParcel.readString();
    this.Btj = paramParcel.readInt();
    this.Btk = paramParcel.readInt();
    this.Btl = paramParcel.readInt();
    this.Btm = paramParcel.readString();
    this.exL = paramParcel.readInt();
    AppMethodBeat.o(70165);
  }
  
  public final void aQ(Map<String, String> paramMap)
  {
    AppMethodBeat.i(174505);
    paramMap.put("detail_address", this.Bth);
    paramMap.put("phone_no", this.Btm);
    paramMap.put("sex", String.valueOf(this.exL));
    paramMap.put("nationality", this.Bte);
    paramMap.put("birth_date", this.Bta);
    if (this.BsQ != null) {}
    for (String str = this.BsQ.BsJ;; str = "")
    {
      paramMap.put("profession_name", str);
      paramMap.put("user_country", this.BsR);
      paramMap.put("user_province", this.BsS);
      paramMap.put("user_city", this.BsT);
      paramMap.put("cre_expire_date", this.BsW);
      paramMap.put("creid_renewal", String.valueOf(this.BsV));
      paramMap.put("cre_effect_date", this.Bti);
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
    paramParcel.writeString(this.BsL);
    paramParcel.writeString(this.BsM);
    paramParcel.writeString(this.BsN);
    paramParcel.writeInt(this.BsO);
    paramParcel.writeString(this.BsP);
    paramParcel.writeParcelable(this.BsQ, 1);
    paramParcel.writeString(this.BsR);
    paramParcel.writeString(this.BsS);
    paramParcel.writeString(this.BsT);
    paramParcel.writeString(this.BsU);
    paramParcel.writeInt(this.BsV);
    paramParcel.writeString(this.BsW);
    paramParcel.writeInt(this.BsX);
    paramParcel.writeInt(this.BsY);
    paramParcel.writeInt(this.BsZ);
    paramParcel.writeString(this.Bta);
    paramParcel.writeInt(this.Btb);
    paramParcel.writeInt(this.Btc);
    paramParcel.writeInt(this.Btd);
    paramParcel.writeString(this.Bte);
    paramParcel.writeString(this.Btf);
    paramParcel.writeString(this.Btg);
    paramParcel.writeString(this.Bth);
    paramParcel.writeString(this.Bti);
    paramParcel.writeInt(this.Btj);
    paramParcel.writeInt(this.Btk);
    paramParcel.writeInt(this.Btl);
    paramParcel.writeString(this.Btm);
    paramParcel.writeInt(this.exL);
    AppMethodBeat.o(70166);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.RealNameBundle
 * JD-Core Version:    0.7.0.1
 */