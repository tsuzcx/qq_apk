package com.tencent.mm.plugin.remittance.bankcard.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ahf;

public class EnterTimeParcel
  implements Parcelable
{
  public static final Parcelable.Creator<EnterTimeParcel> CREATOR;
  public String hDr;
  public int yif;
  public String yig;
  public String yih;
  public int yii;
  
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
    this.yif = paramParcel.readInt();
    this.yig = paramParcel.readString();
    this.yih = paramParcel.readString();
    this.yii = paramParcel.readInt();
    this.hDr = paramParcel.readString();
    AppMethodBeat.o(67406);
  }
  
  public EnterTimeParcel(ahf paramahf)
  {
    this.yif = paramahf.yif;
    this.yig = paramahf.yig;
    this.yih = paramahf.yih;
    this.yii = paramahf.yii;
    this.hDr = paramahf.hDr;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(67407);
    paramParcel.writeInt(this.yif);
    paramParcel.writeString(this.yig);
    paramParcel.writeString(this.yih);
    paramParcel.writeInt(this.yii);
    paramParcel.writeString(this.hDr);
    AppMethodBeat.o(67407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.model.EnterTimeParcel
 * JD-Core Version:    0.7.0.1
 */