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
  public String VBL;
  public String VBM;
  public String VBN;
  public int VBO;
  public String VBP;
  public Profession VBQ;
  public String VBR;
  public String VBS;
  public String VBT;
  public String VBU;
  public int VBV;
  public String VBW;
  public int VBX;
  public int VBY;
  public int VBZ;
  public String VCa;
  public int VCb;
  public int VCc;
  public int VCd;
  public String VCe;
  public String VCf;
  public String VCg;
  public String VCh;
  public String VCi;
  public int VCj;
  public int VCk;
  public int VCl;
  public String VCm;
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
    this.VBL = paramParcel.readString();
    this.VBM = paramParcel.readString();
    this.VBN = paramParcel.readString();
    this.VBO = paramParcel.readInt();
    this.VBP = paramParcel.readString();
    this.VBQ = ((Profession)paramParcel.readParcelable(Profession.class.getClassLoader()));
    this.VBR = paramParcel.readString();
    this.VBS = paramParcel.readString();
    this.VBT = paramParcel.readString();
    this.VBU = paramParcel.readString();
    this.VBV = paramParcel.readInt();
    this.VBW = paramParcel.readString();
    this.VBX = paramParcel.readInt();
    this.VBY = paramParcel.readInt();
    this.VBZ = paramParcel.readInt();
    this.VCa = paramParcel.readString();
    this.VCb = paramParcel.readInt();
    this.VCc = paramParcel.readInt();
    this.VCd = paramParcel.readInt();
    this.VCe = paramParcel.readString();
    this.VCf = paramParcel.readString();
    this.VCg = paramParcel.readString();
    this.VCh = paramParcel.readString();
    this.VCi = paramParcel.readString();
    this.VCj = paramParcel.readInt();
    this.VCk = paramParcel.readInt();
    this.VCl = paramParcel.readInt();
    this.VCm = paramParcel.readString();
    this.sex = paramParcel.readInt();
    AppMethodBeat.o(70165);
  }
  
  public final void bj(Map<String, String> paramMap)
  {
    AppMethodBeat.i(174505);
    paramMap.put("detail_address", this.VCh);
    paramMap.put("phone_no", this.VCm);
    paramMap.put("sex", String.valueOf(this.sex));
    paramMap.put("nationality", this.VCe);
    paramMap.put("birth_date", this.VCa);
    if (this.VBQ != null) {}
    for (String str = this.VBQ.VBJ;; str = "")
    {
      paramMap.put("profession_name", str);
      paramMap.put("user_country", this.VBR);
      paramMap.put("user_province", this.VBS);
      paramMap.put("user_city", this.VBT);
      paramMap.put("cre_expire_date", this.VBW);
      paramMap.put("creid_renewal", String.valueOf(this.VBV));
      paramMap.put("cre_effect_date", this.VCi);
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
    paramParcel.writeString(this.VBL);
    paramParcel.writeString(this.VBM);
    paramParcel.writeString(this.VBN);
    paramParcel.writeInt(this.VBO);
    paramParcel.writeString(this.VBP);
    paramParcel.writeParcelable(this.VBQ, 1);
    paramParcel.writeString(this.VBR);
    paramParcel.writeString(this.VBS);
    paramParcel.writeString(this.VBT);
    paramParcel.writeString(this.VBU);
    paramParcel.writeInt(this.VBV);
    paramParcel.writeString(this.VBW);
    paramParcel.writeInt(this.VBX);
    paramParcel.writeInt(this.VBY);
    paramParcel.writeInt(this.VBZ);
    paramParcel.writeString(this.VCa);
    paramParcel.writeInt(this.VCb);
    paramParcel.writeInt(this.VCc);
    paramParcel.writeInt(this.VCd);
    paramParcel.writeString(this.VCe);
    paramParcel.writeString(this.VCf);
    paramParcel.writeString(this.VCg);
    paramParcel.writeString(this.VCh);
    paramParcel.writeString(this.VCi);
    paramParcel.writeInt(this.VCj);
    paramParcel.writeInt(this.VCk);
    paramParcel.writeInt(this.VCl);
    paramParcel.writeString(this.VCm);
    paramParcel.writeInt(this.sex);
    AppMethodBeat.o(70166);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.RealNameBundle
 * JD-Core Version:    0.7.0.1
 */