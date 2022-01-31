package com.tencent.mm.plugin.wallet_core.id_verify.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class RealNameBundle
  implements Parcelable
{
  public static final Parcelable.Creator<RealNameBundle> CREATOR;
  public String ueA;
  public String ueB;
  public int ueC;
  public String ueD;
  public String ueE;
  public String ueF;
  public String ueG;
  public String ueu;
  public String uev;
  public int uew;
  public Profession uex;
  public String uey;
  public String uez;
  
  static
  {
    AppMethodBeat.i(142477);
    CREATOR = new RealNameBundle.1();
    AppMethodBeat.o(142477);
  }
  
  public RealNameBundle() {}
  
  protected RealNameBundle(Parcel paramParcel)
  {
    AppMethodBeat.i(142475);
    this.ueu = paramParcel.readString();
    this.uev = paramParcel.readString();
    this.uew = paramParcel.readInt();
    this.uex = ((Profession)paramParcel.readParcelable(Profession.class.getClassLoader()));
    this.uey = paramParcel.readString();
    this.uez = paramParcel.readString();
    this.ueA = paramParcel.readString();
    this.ueB = paramParcel.readString();
    this.ueC = paramParcel.readInt();
    this.ueD = paramParcel.readString();
    this.ueE = paramParcel.readString();
    this.ueF = paramParcel.readString();
    this.ueG = paramParcel.readString();
    AppMethodBeat.o(142475);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(142476);
    paramParcel.writeString(this.ueu);
    paramParcel.writeString(this.uev);
    paramParcel.writeInt(this.uew);
    paramParcel.writeParcelable(this.uex, 1);
    paramParcel.writeString(this.uey);
    paramParcel.writeString(this.uez);
    paramParcel.writeString(this.ueA);
    paramParcel.writeString(this.ueB);
    paramParcel.writeInt(this.ueC);
    paramParcel.writeString(this.ueD);
    paramParcel.writeString(this.ueE);
    paramParcel.writeString(this.ueF);
    paramParcel.writeString(this.ueG);
    AppMethodBeat.o(142476);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.model.RealNameBundle
 * JD-Core Version:    0.7.0.1
 */