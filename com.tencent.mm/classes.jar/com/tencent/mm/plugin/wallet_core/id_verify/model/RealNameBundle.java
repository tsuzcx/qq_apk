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
  public String AaA;
  public int AaB;
  public String AaC;
  public int AaD;
  public int AaE;
  public int AaF;
  public String AaG;
  public int AaH;
  public int AaI;
  public int AaJ;
  public String AaK;
  public String AaL;
  public String AaM;
  public String AaN;
  public String AaO;
  public int AaP;
  public int AaQ;
  public int AaR;
  public String AaS;
  public String Aar;
  public String Aas;
  public String Aat;
  public int Aau;
  public String Aav;
  public Profession Aaw;
  public String Aax;
  public String Aay;
  public String Aaz;
  public int evp;
  
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
    this.Aar = paramParcel.readString();
    this.Aas = paramParcel.readString();
    this.Aat = paramParcel.readString();
    this.Aau = paramParcel.readInt();
    this.Aav = paramParcel.readString();
    this.Aaw = ((Profession)paramParcel.readParcelable(Profession.class.getClassLoader()));
    this.Aax = paramParcel.readString();
    this.Aay = paramParcel.readString();
    this.Aaz = paramParcel.readString();
    this.AaA = paramParcel.readString();
    this.AaB = paramParcel.readInt();
    this.AaC = paramParcel.readString();
    this.AaD = paramParcel.readInt();
    this.AaE = paramParcel.readInt();
    this.AaF = paramParcel.readInt();
    this.AaG = paramParcel.readString();
    this.AaH = paramParcel.readInt();
    this.AaI = paramParcel.readInt();
    this.AaJ = paramParcel.readInt();
    this.AaK = paramParcel.readString();
    this.AaL = paramParcel.readString();
    this.AaM = paramParcel.readString();
    this.AaN = paramParcel.readString();
    this.AaO = paramParcel.readString();
    this.AaP = paramParcel.readInt();
    this.AaQ = paramParcel.readInt();
    this.AaR = paramParcel.readInt();
    this.AaS = paramParcel.readString();
    this.evp = paramParcel.readInt();
    AppMethodBeat.o(70165);
  }
  
  public final void aM(Map<String, String> paramMap)
  {
    AppMethodBeat.i(174505);
    paramMap.put("detail_address", this.AaN);
    paramMap.put("phone_no", this.AaS);
    paramMap.put("sex", String.valueOf(this.evp));
    paramMap.put("nationality", this.AaK);
    paramMap.put("birth_date", this.AaG);
    if (this.Aaw != null) {}
    for (String str = this.Aaw.Aap;; str = "")
    {
      paramMap.put("profession_name", str);
      paramMap.put("user_country", this.Aax);
      paramMap.put("user_province", this.Aay);
      paramMap.put("user_city", this.Aaz);
      paramMap.put("cre_expire_date", this.AaC);
      paramMap.put("creid_renewal", String.valueOf(this.AaB));
      paramMap.put("cre_effect_date", this.AaO);
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
    paramParcel.writeString(this.Aar);
    paramParcel.writeString(this.Aas);
    paramParcel.writeString(this.Aat);
    paramParcel.writeInt(this.Aau);
    paramParcel.writeString(this.Aav);
    paramParcel.writeParcelable(this.Aaw, 1);
    paramParcel.writeString(this.Aax);
    paramParcel.writeString(this.Aay);
    paramParcel.writeString(this.Aaz);
    paramParcel.writeString(this.AaA);
    paramParcel.writeInt(this.AaB);
    paramParcel.writeString(this.AaC);
    paramParcel.writeInt(this.AaD);
    paramParcel.writeInt(this.AaE);
    paramParcel.writeInt(this.AaF);
    paramParcel.writeString(this.AaG);
    paramParcel.writeInt(this.AaH);
    paramParcel.writeInt(this.AaI);
    paramParcel.writeInt(this.AaJ);
    paramParcel.writeString(this.AaK);
    paramParcel.writeString(this.AaL);
    paramParcel.writeString(this.AaM);
    paramParcel.writeString(this.AaN);
    paramParcel.writeString(this.AaO);
    paramParcel.writeInt(this.AaP);
    paramParcel.writeInt(this.AaQ);
    paramParcel.writeInt(this.AaR);
    paramParcel.writeString(this.AaS);
    paramParcel.writeInt(this.evp);
    AppMethodBeat.o(70166);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.RealNameBundle
 * JD-Core Version:    0.7.0.1
 */