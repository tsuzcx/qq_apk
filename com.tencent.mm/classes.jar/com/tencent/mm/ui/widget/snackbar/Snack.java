package com.tencent.mm.ui.widget.snackbar;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

class Snack
  implements Parcelable
{
  public static final Parcelable.Creator<Snack> CREATOR;
  final Parcelable LzA;
  final short LzB;
  final int LzC;
  final String Lzy;
  final int Lzz;
  final String uPi;
  
  static
  {
    AppMethodBeat.i(159699);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(159699);
  }
  
  Snack(Parcel paramParcel)
  {
    AppMethodBeat.i(159697);
    this.uPi = paramParcel.readString();
    this.Lzy = paramParcel.readString();
    this.Lzz = paramParcel.readInt();
    this.LzA = paramParcel.readParcelable(paramParcel.getClass().getClassLoader());
    this.LzB = ((short)paramParcel.readInt());
    this.LzC = paramParcel.readInt();
    AppMethodBeat.o(159697);
  }
  
  Snack(String paramString1, String paramString2, int paramInt1, Parcelable paramParcelable, short paramShort, int paramInt2)
  {
    this.uPi = paramString1;
    this.Lzy = paramString2;
    this.Lzz = paramInt1;
    this.LzA = paramParcelable;
    this.LzB = paramShort;
    this.LzC = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(159698);
    paramParcel.writeString(this.uPi);
    paramParcel.writeString(this.Lzy);
    paramParcel.writeInt(this.Lzz);
    paramParcel.writeParcelable(this.LzA, 0);
    paramParcel.writeInt(this.LzB);
    paramParcel.writeInt(this.LzC);
    AppMethodBeat.o(159698);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.snackbar.Snack
 * JD-Core Version:    0.7.0.1
 */