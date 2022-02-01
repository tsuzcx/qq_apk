package com.tencent.mm.plugin.remittance.bankcard.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aoc;

public class EnterTimeParcel
  implements Parcelable
{
  public static final Parcelable.Creator<EnterTimeParcel> CREATOR;
  public String OcA;
  public int OcB;
  public int Ocy;
  public String Ocz;
  public String nRQ;
  
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
    this.Ocy = paramParcel.readInt();
    this.Ocz = paramParcel.readString();
    this.OcA = paramParcel.readString();
    this.OcB = paramParcel.readInt();
    this.nRQ = paramParcel.readString();
    AppMethodBeat.o(67406);
  }
  
  public EnterTimeParcel(aoc paramaoc)
  {
    this.Ocy = paramaoc.Ocy;
    this.Ocz = paramaoc.Ocz;
    this.OcA = paramaoc.OcA;
    this.OcB = paramaoc.OcB;
    this.nRQ = paramaoc.nRQ;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(67407);
    paramParcel.writeInt(this.Ocy);
    paramParcel.writeString(this.Ocz);
    paramParcel.writeString(this.OcA);
    paramParcel.writeInt(this.OcB);
    paramParcel.writeString(this.nRQ);
    AppMethodBeat.o(67407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.model.EnterTimeParcel
 * JD-Core Version:    0.7.0.1
 */