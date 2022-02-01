package com.tencent.mm.ui.widget.snackbar;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

class Snack
  implements Parcelable
{
  public static final Parcelable.Creator<Snack> CREATOR;
  final String QVo;
  final int QVp;
  final Parcelable QVq;
  final short QVr;
  final int QVs;
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
    this.QVo = paramParcel.readString();
    this.QVp = paramParcel.readInt();
    this.QVq = paramParcel.readParcelable(paramParcel.getClass().getClassLoader());
    this.QVr = ((short)paramParcel.readInt());
    this.QVs = paramParcel.readInt();
    AppMethodBeat.o(159697);
  }
  
  Snack(String paramString1, String paramString2, int paramInt1, Parcelable paramParcelable, short paramShort, int paramInt2)
  {
    this.mMessage = paramString1;
    this.QVo = paramString2;
    this.QVp = paramInt1;
    this.QVq = paramParcelable;
    this.QVr = paramShort;
    this.QVs = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(159698);
    paramParcel.writeString(this.mMessage);
    paramParcel.writeString(this.QVo);
    paramParcel.writeInt(this.QVp);
    paramParcel.writeParcelable(this.QVq, 0);
    paramParcel.writeInt(this.QVr);
    paramParcel.writeInt(this.QVs);
    AppMethodBeat.o(159698);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.snackbar.Snack
 * JD-Core Version:    0.7.0.1
 */