package com.tencent.mm.plugin.remittance.bankcard.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.zz;

public class EnterTimeParcel
  implements Parcelable
{
  public static final Parcelable.Creator<EnterTimeParcel> CREATOR;
  public String color;
  public int qgh;
  public String qgi;
  public String qgj;
  public int qgk;
  
  static
  {
    AppMethodBeat.i(44499);
    CREATOR = new EnterTimeParcel.1();
    AppMethodBeat.o(44499);
  }
  
  public EnterTimeParcel() {}
  
  public EnterTimeParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(44497);
    this.qgh = paramParcel.readInt();
    this.qgi = paramParcel.readString();
    this.qgj = paramParcel.readString();
    this.qgk = paramParcel.readInt();
    this.color = paramParcel.readString();
    AppMethodBeat.o(44497);
  }
  
  public EnterTimeParcel(zz paramzz)
  {
    this.qgh = paramzz.qgh;
    this.qgi = paramzz.qgi;
    this.qgj = paramzz.qgj;
    this.qgk = paramzz.qgk;
    this.color = paramzz.color;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(44498);
    paramParcel.writeInt(this.qgh);
    paramParcel.writeString(this.qgi);
    paramParcel.writeString(this.qgj);
    paramParcel.writeInt(this.qgk);
    paramParcel.writeString(this.color);
    AppMethodBeat.o(44498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.model.EnterTimeParcel
 * JD-Core Version:    0.7.0.1
 */