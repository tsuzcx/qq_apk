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
  public String DkG;
  public String DkH;
  public String DkI;
  public int DkJ;
  public String DkK;
  public Profession DkL;
  public String DkM;
  public String DkN;
  public String DkO;
  public String DkP;
  public int DkQ;
  public String DkR;
  public int DkS;
  public int DkT;
  public int DkU;
  public String DkV;
  public int DkW;
  public int DkX;
  public int DkY;
  public String DkZ;
  public String Dla;
  public String Dlb;
  public String Dlc;
  public String Dld;
  public int Dle;
  public int Dlf;
  public int Dlg;
  public String Dlh;
  public int eQV;
  
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
    this.DkG = paramParcel.readString();
    this.DkH = paramParcel.readString();
    this.DkI = paramParcel.readString();
    this.DkJ = paramParcel.readInt();
    this.DkK = paramParcel.readString();
    this.DkL = ((Profession)paramParcel.readParcelable(Profession.class.getClassLoader()));
    this.DkM = paramParcel.readString();
    this.DkN = paramParcel.readString();
    this.DkO = paramParcel.readString();
    this.DkP = paramParcel.readString();
    this.DkQ = paramParcel.readInt();
    this.DkR = paramParcel.readString();
    this.DkS = paramParcel.readInt();
    this.DkT = paramParcel.readInt();
    this.DkU = paramParcel.readInt();
    this.DkV = paramParcel.readString();
    this.DkW = paramParcel.readInt();
    this.DkX = paramParcel.readInt();
    this.DkY = paramParcel.readInt();
    this.DkZ = paramParcel.readString();
    this.Dla = paramParcel.readString();
    this.Dlb = paramParcel.readString();
    this.Dlc = paramParcel.readString();
    this.Dld = paramParcel.readString();
    this.Dle = paramParcel.readInt();
    this.Dlf = paramParcel.readInt();
    this.Dlg = paramParcel.readInt();
    this.Dlh = paramParcel.readString();
    this.eQV = paramParcel.readInt();
    AppMethodBeat.o(70165);
  }
  
  public final void aZ(Map<String, String> paramMap)
  {
    AppMethodBeat.i(174505);
    paramMap.put("detail_address", this.Dlc);
    paramMap.put("phone_no", this.Dlh);
    paramMap.put("sex", String.valueOf(this.eQV));
    paramMap.put("nationality", this.DkZ);
    paramMap.put("birth_date", this.DkV);
    if (this.DkL != null) {}
    for (String str = this.DkL.DkE;; str = "")
    {
      paramMap.put("profession_name", str);
      paramMap.put("user_country", this.DkM);
      paramMap.put("user_province", this.DkN);
      paramMap.put("user_city", this.DkO);
      paramMap.put("cre_expire_date", this.DkR);
      paramMap.put("creid_renewal", String.valueOf(this.DkQ));
      paramMap.put("cre_effect_date", this.Dld);
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
    paramParcel.writeString(this.DkG);
    paramParcel.writeString(this.DkH);
    paramParcel.writeString(this.DkI);
    paramParcel.writeInt(this.DkJ);
    paramParcel.writeString(this.DkK);
    paramParcel.writeParcelable(this.DkL, 1);
    paramParcel.writeString(this.DkM);
    paramParcel.writeString(this.DkN);
    paramParcel.writeString(this.DkO);
    paramParcel.writeString(this.DkP);
    paramParcel.writeInt(this.DkQ);
    paramParcel.writeString(this.DkR);
    paramParcel.writeInt(this.DkS);
    paramParcel.writeInt(this.DkT);
    paramParcel.writeInt(this.DkU);
    paramParcel.writeString(this.DkV);
    paramParcel.writeInt(this.DkW);
    paramParcel.writeInt(this.DkX);
    paramParcel.writeInt(this.DkY);
    paramParcel.writeString(this.DkZ);
    paramParcel.writeString(this.Dla);
    paramParcel.writeString(this.Dlb);
    paramParcel.writeString(this.Dlc);
    paramParcel.writeString(this.Dld);
    paramParcel.writeInt(this.Dle);
    paramParcel.writeInt(this.Dlf);
    paramParcel.writeInt(this.Dlg);
    paramParcel.writeString(this.Dlh);
    paramParcel.writeInt(this.eQV);
    AppMethodBeat.o(70166);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.RealNameBundle
 * JD-Core Version:    0.7.0.1
 */