package com.tencent.mm.ui.widget.snackbar;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

class Snack
  implements Parcelable
{
  public static final Parcelable.Creator<Snack> CREATOR;
  final String AKn;
  final int AKo;
  final Parcelable AKp;
  final short AKq;
  final int AKr;
  final String nGF;
  
  static
  {
    AppMethodBeat.i(112971);
    CREATOR = new Snack.1();
    AppMethodBeat.o(112971);
  }
  
  Snack(Parcel paramParcel)
  {
    AppMethodBeat.i(112969);
    this.nGF = paramParcel.readString();
    this.AKn = paramParcel.readString();
    this.AKo = paramParcel.readInt();
    this.AKp = paramParcel.readParcelable(paramParcel.getClass().getClassLoader());
    this.AKq = ((short)paramParcel.readInt());
    this.AKr = paramParcel.readInt();
    AppMethodBeat.o(112969);
  }
  
  Snack(String paramString1, String paramString2, int paramInt1, Parcelable paramParcelable, short paramShort, int paramInt2)
  {
    this.nGF = paramString1;
    this.AKn = paramString2;
    this.AKo = paramInt1;
    this.AKp = paramParcelable;
    this.AKq = paramShort;
    this.AKr = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(112970);
    paramParcel.writeString(this.nGF);
    paramParcel.writeString(this.AKn);
    paramParcel.writeInt(this.AKo);
    paramParcel.writeParcelable(this.AKp, 0);
    paramParcel.writeInt(this.AKq);
    paramParcel.writeInt(this.AKr);
    AppMethodBeat.o(112970);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.snackbar.Snack
 * JD-Core Version:    0.7.0.1
 */