package com.tencent.mm.plugin.remittance.bankcard.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aem;

public class EnterTimeParcel
  implements Parcelable
{
  public static final Parcelable.Creator<EnterTimeParcel> CREATOR;
  public String hiu;
  public int wEF;
  public String wEG;
  public String wEH;
  public int wEI;
  
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
    this.wEF = paramParcel.readInt();
    this.wEG = paramParcel.readString();
    this.wEH = paramParcel.readString();
    this.wEI = paramParcel.readInt();
    this.hiu = paramParcel.readString();
    AppMethodBeat.o(67406);
  }
  
  public EnterTimeParcel(aem paramaem)
  {
    this.wEF = paramaem.wEF;
    this.wEG = paramaem.wEG;
    this.wEH = paramaem.wEH;
    this.wEI = paramaem.wEI;
    this.hiu = paramaem.hiu;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(67407);
    paramParcel.writeInt(this.wEF);
    paramParcel.writeString(this.wEG);
    paramParcel.writeString(this.wEH);
    paramParcel.writeInt(this.wEI);
    paramParcel.writeString(this.hiu);
    AppMethodBeat.o(67407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.model.EnterTimeParcel
 * JD-Core Version:    0.7.0.1
 */