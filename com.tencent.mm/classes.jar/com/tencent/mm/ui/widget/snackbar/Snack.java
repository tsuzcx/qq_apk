package com.tencent.mm.ui.widget.snackbar;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

class Snack
  implements Parcelable
{
  public static final Parcelable.Creator<Snack> CREATOR;
  final String agms;
  final int agmt;
  final Parcelable agmu;
  final short agmv;
  final int agmw;
  final String mMessage;
  
  static
  {
    AppMethodBeat.i(159699);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(159699);
  }
  
  Snack(Parcel paramParcel)
  {
    AppMethodBeat.i(159697);
    this.mMessage = paramParcel.readString();
    this.agms = paramParcel.readString();
    this.agmt = paramParcel.readInt();
    this.agmu = paramParcel.readParcelable(paramParcel.getClass().getClassLoader());
    this.agmv = ((short)paramParcel.readInt());
    this.agmw = paramParcel.readInt();
    AppMethodBeat.o(159697);
  }
  
  Snack(String paramString1, String paramString2, int paramInt1, Parcelable paramParcelable, short paramShort, int paramInt2)
  {
    this.mMessage = paramString1;
    this.agms = paramString2;
    this.agmt = paramInt1;
    this.agmu = paramParcelable;
    this.agmv = paramShort;
    this.agmw = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(159698);
    paramParcel.writeString(this.mMessage);
    paramParcel.writeString(this.agms);
    paramParcel.writeInt(this.agmt);
    paramParcel.writeParcelable(this.agmu, 0);
    paramParcel.writeInt(this.agmv);
    paramParcel.writeInt(this.agmw);
    AppMethodBeat.o(159698);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.widget.snackbar.Snack
 * JD-Core Version:    0.7.0.1
 */