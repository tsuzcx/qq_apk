package com.tencent.mm.plugin.remittance.bankcard.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aks;

public class EnterTimeParcel
  implements Parcelable
{
  public static final Parcelable.Creator<EnterTimeParcel> CREATOR;
  public int IfZ;
  public String Iga;
  public String Igb;
  public int Igc;
  public String lmL;
  
  static
  {
    AppMethodBeat.i(67408);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(67408);
  }
  
  public EnterTimeParcel() {}
  
  public EnterTimeParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(67406);
    this.IfZ = paramParcel.readInt();
    this.Iga = paramParcel.readString();
    this.Igb = paramParcel.readString();
    this.Igc = paramParcel.readInt();
    this.lmL = paramParcel.readString();
    AppMethodBeat.o(67406);
  }
  
  public EnterTimeParcel(aks paramaks)
  {
    this.IfZ = paramaks.IfZ;
    this.Iga = paramaks.Iga;
    this.Igb = paramaks.Igb;
    this.Igc = paramaks.Igc;
    this.lmL = paramaks.lmL;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(67407);
    paramParcel.writeInt(this.IfZ);
    paramParcel.writeString(this.Iga);
    paramParcel.writeString(this.Igb);
    paramParcel.writeInt(this.Igc);
    paramParcel.writeString(this.lmL);
    AppMethodBeat.o(67407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.model.EnterTimeParcel
 * JD-Core Version:    0.7.0.1
 */