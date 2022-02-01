package com.tencent.mm.ui.widget.snackbar;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

class Snack
  implements Parcelable
{
  public static final Parcelable.Creator<Snack> CREATOR;
  final String JlA;
  final int JlB;
  final Parcelable JlC;
  final short JlD;
  final int JlE;
  final String tAU;
  
  static
  {
    AppMethodBeat.i(159699);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(159699);
  }
  
  Snack(Parcel paramParcel)
  {
    AppMethodBeat.i(159697);
    this.tAU = paramParcel.readString();
    this.JlA = paramParcel.readString();
    this.JlB = paramParcel.readInt();
    this.JlC = paramParcel.readParcelable(paramParcel.getClass().getClassLoader());
    this.JlD = ((short)paramParcel.readInt());
    this.JlE = paramParcel.readInt();
    AppMethodBeat.o(159697);
  }
  
  Snack(String paramString1, String paramString2, int paramInt1, Parcelable paramParcelable, short paramShort, int paramInt2)
  {
    this.tAU = paramString1;
    this.JlA = paramString2;
    this.JlB = paramInt1;
    this.JlC = paramParcelable;
    this.JlD = paramShort;
    this.JlE = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(159698);
    paramParcel.writeString(this.tAU);
    paramParcel.writeString(this.JlA);
    paramParcel.writeInt(this.JlB);
    paramParcel.writeParcelable(this.JlC, 0);
    paramParcel.writeInt(this.JlD);
    paramParcel.writeInt(this.JlE);
    AppMethodBeat.o(159698);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.snackbar.Snack
 * JD-Core Version:    0.7.0.1
 */