package com.tencent.mm.plugin.remittance.bankcard.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.agv;

public class EnterTimeParcel
  implements Parcelable
{
  public static final Parcelable.Creator<EnterTimeParcel> CREATOR;
  public String hAD;
  public int xSm;
  public String xSn;
  public String xSo;
  public int xSp;
  
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
    this.xSm = paramParcel.readInt();
    this.xSn = paramParcel.readString();
    this.xSo = paramParcel.readString();
    this.xSp = paramParcel.readInt();
    this.hAD = paramParcel.readString();
    AppMethodBeat.o(67406);
  }
  
  public EnterTimeParcel(agv paramagv)
  {
    this.xSm = paramagv.xSm;
    this.xSn = paramagv.xSn;
    this.xSo = paramagv.xSo;
    this.xSp = paramagv.xSp;
    this.hAD = paramagv.hAD;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(67407);
    paramParcel.writeInt(this.xSm);
    paramParcel.writeString(this.xSn);
    paramParcel.writeString(this.xSo);
    paramParcel.writeInt(this.xSp);
    paramParcel.writeString(this.hAD);
    AppMethodBeat.o(67407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.model.EnterTimeParcel
 * JD-Core Version:    0.7.0.1
 */