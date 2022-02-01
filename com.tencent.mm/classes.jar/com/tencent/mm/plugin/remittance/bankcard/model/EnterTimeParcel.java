package com.tencent.mm.plugin.remittance.bankcard.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.adn;

public class EnterTimeParcel
  implements Parcelable
{
  public static final Parcelable.Creator<EnterTimeParcel> CREATOR;
  public String gHT;
  public int vuA;
  public String vuB;
  public String vuC;
  public int vuD;
  
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
    this.vuA = paramParcel.readInt();
    this.vuB = paramParcel.readString();
    this.vuC = paramParcel.readString();
    this.vuD = paramParcel.readInt();
    this.gHT = paramParcel.readString();
    AppMethodBeat.o(67406);
  }
  
  public EnterTimeParcel(adn paramadn)
  {
    this.vuA = paramadn.vuA;
    this.vuB = paramadn.vuB;
    this.vuC = paramadn.vuC;
    this.vuD = paramadn.vuD;
    this.gHT = paramadn.gHT;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(67407);
    paramParcel.writeInt(this.vuA);
    paramParcel.writeString(this.vuB);
    paramParcel.writeString(this.vuC);
    paramParcel.writeInt(this.vuD);
    paramParcel.writeString(this.gHT);
    AppMethodBeat.o(67407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.model.EnterTimeParcel
 * JD-Core Version:    0.7.0.1
 */