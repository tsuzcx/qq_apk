package com.tencent.mm.plugin.remittance.bankcard.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ajr;

public class EnterTimeParcel
  implements Parcelable
{
  public static final Parcelable.Creator<EnterTimeParcel> CREATOR;
  public int Cjg;
  public String Cjh;
  public String Cji;
  public int Cjj;
  public String ixw;
  
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
    this.Cjg = paramParcel.readInt();
    this.Cjh = paramParcel.readString();
    this.Cji = paramParcel.readString();
    this.Cjj = paramParcel.readInt();
    this.ixw = paramParcel.readString();
    AppMethodBeat.o(67406);
  }
  
  public EnterTimeParcel(ajr paramajr)
  {
    this.Cjg = paramajr.Cjg;
    this.Cjh = paramajr.Cjh;
    this.Cji = paramajr.Cji;
    this.Cjj = paramajr.Cjj;
    this.ixw = paramajr.ixw;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(67407);
    paramParcel.writeInt(this.Cjg);
    paramParcel.writeString(this.Cjh);
    paramParcel.writeString(this.Cji);
    paramParcel.writeInt(this.Cjj);
    paramParcel.writeString(this.ixw);
    AppMethodBeat.o(67407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.model.EnterTimeParcel
 * JD-Core Version:    0.7.0.1
 */