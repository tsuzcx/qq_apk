package com.tencent.mm.ui.widget.snackbar;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

class Snack
  implements Parcelable
{
  public static final Parcelable.Creator<Snack> CREATOR;
  final String LcX;
  final int LcY;
  final Parcelable LcZ;
  final short Lda;
  final int Ldb;
  final String uDD;
  
  static
  {
    AppMethodBeat.i(159699);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(159699);
  }
  
  Snack(Parcel paramParcel)
  {
    AppMethodBeat.i(159697);
    this.uDD = paramParcel.readString();
    this.LcX = paramParcel.readString();
    this.LcY = paramParcel.readInt();
    this.LcZ = paramParcel.readParcelable(paramParcel.getClass().getClassLoader());
    this.Lda = ((short)paramParcel.readInt());
    this.Ldb = paramParcel.readInt();
    AppMethodBeat.o(159697);
  }
  
  Snack(String paramString1, String paramString2, int paramInt1, Parcelable paramParcelable, short paramShort, int paramInt2)
  {
    this.uDD = paramString1;
    this.LcX = paramString2;
    this.LcY = paramInt1;
    this.LcZ = paramParcelable;
    this.Lda = paramShort;
    this.Ldb = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(159698);
    paramParcel.writeString(this.uDD);
    paramParcel.writeString(this.LcX);
    paramParcel.writeInt(this.LcY);
    paramParcel.writeParcelable(this.LcZ, 0);
    paramParcel.writeInt(this.Lda);
    paramParcel.writeInt(this.Ldb);
    AppMethodBeat.o(159698);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.snackbar.Snack
 * JD-Core Version:    0.7.0.1
 */