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
  public String HTZ;
  public String HUA;
  public String HUa;
  public String HUb;
  public int HUc;
  public String HUd;
  public Profession HUe;
  public String HUf;
  public String HUg;
  public String HUh;
  public String HUi;
  public int HUj;
  public String HUk;
  public int HUl;
  public int HUm;
  public int HUn;
  public String HUo;
  public int HUp;
  public int HUq;
  public int HUr;
  public String HUs;
  public String HUt;
  public String HUu;
  public String HUv;
  public String HUw;
  public int HUx;
  public int HUy;
  public int HUz;
  public int fuA;
  
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
    this.HTZ = paramParcel.readString();
    this.HUa = paramParcel.readString();
    this.HUb = paramParcel.readString();
    this.HUc = paramParcel.readInt();
    this.HUd = paramParcel.readString();
    this.HUe = ((Profession)paramParcel.readParcelable(Profession.class.getClassLoader()));
    this.HUf = paramParcel.readString();
    this.HUg = paramParcel.readString();
    this.HUh = paramParcel.readString();
    this.HUi = paramParcel.readString();
    this.HUj = paramParcel.readInt();
    this.HUk = paramParcel.readString();
    this.HUl = paramParcel.readInt();
    this.HUm = paramParcel.readInt();
    this.HUn = paramParcel.readInt();
    this.HUo = paramParcel.readString();
    this.HUp = paramParcel.readInt();
    this.HUq = paramParcel.readInt();
    this.HUr = paramParcel.readInt();
    this.HUs = paramParcel.readString();
    this.HUt = paramParcel.readString();
    this.HUu = paramParcel.readString();
    this.HUv = paramParcel.readString();
    this.HUw = paramParcel.readString();
    this.HUx = paramParcel.readInt();
    this.HUy = paramParcel.readInt();
    this.HUz = paramParcel.readInt();
    this.HUA = paramParcel.readString();
    this.fuA = paramParcel.readInt();
    AppMethodBeat.o(70165);
  }
  
  public final void aY(Map<String, String> paramMap)
  {
    AppMethodBeat.i(174505);
    paramMap.put("detail_address", this.HUv);
    paramMap.put("phone_no", this.HUA);
    paramMap.put("sex", String.valueOf(this.fuA));
    paramMap.put("nationality", this.HUs);
    paramMap.put("birth_date", this.HUo);
    if (this.HUe != null) {}
    for (String str = this.HUe.HTX;; str = "")
    {
      paramMap.put("profession_name", str);
      paramMap.put("user_country", this.HUf);
      paramMap.put("user_province", this.HUg);
      paramMap.put("user_city", this.HUh);
      paramMap.put("cre_expire_date", this.HUk);
      paramMap.put("creid_renewal", String.valueOf(this.HUj));
      paramMap.put("cre_effect_date", this.HUw);
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
    paramParcel.writeString(this.HTZ);
    paramParcel.writeString(this.HUa);
    paramParcel.writeString(this.HUb);
    paramParcel.writeInt(this.HUc);
    paramParcel.writeString(this.HUd);
    paramParcel.writeParcelable(this.HUe, 1);
    paramParcel.writeString(this.HUf);
    paramParcel.writeString(this.HUg);
    paramParcel.writeString(this.HUh);
    paramParcel.writeString(this.HUi);
    paramParcel.writeInt(this.HUj);
    paramParcel.writeString(this.HUk);
    paramParcel.writeInt(this.HUl);
    paramParcel.writeInt(this.HUm);
    paramParcel.writeInt(this.HUn);
    paramParcel.writeString(this.HUo);
    paramParcel.writeInt(this.HUp);
    paramParcel.writeInt(this.HUq);
    paramParcel.writeInt(this.HUr);
    paramParcel.writeString(this.HUs);
    paramParcel.writeString(this.HUt);
    paramParcel.writeString(this.HUu);
    paramParcel.writeString(this.HUv);
    paramParcel.writeString(this.HUw);
    paramParcel.writeInt(this.HUx);
    paramParcel.writeInt(this.HUy);
    paramParcel.writeInt(this.HUz);
    paramParcel.writeString(this.HUA);
    paramParcel.writeInt(this.fuA);
    AppMethodBeat.o(70166);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.RealNameBundle
 * JD-Core Version:    0.7.0.1
 */