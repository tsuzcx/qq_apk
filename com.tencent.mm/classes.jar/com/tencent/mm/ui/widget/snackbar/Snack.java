package com.tencent.mm.ui.widget.snackbar;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

class Snack
  implements Parcelable
{
  public static final Parcelable.Creator<Snack> CREATOR;
  final String YtZ;
  final int Yua;
  final Parcelable Yub;
  final short Yuc;
  final int Yud;
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
    this.YtZ = paramParcel.readString();
    this.Yua = paramParcel.readInt();
    this.Yub = paramParcel.readParcelable(paramParcel.getClass().getClassLoader());
    this.Yuc = ((short)paramParcel.readInt());
    this.Yud = paramParcel.readInt();
    AppMethodBeat.o(159697);
  }
  
  Snack(String paramString1, String paramString2, int paramInt1, Parcelable paramParcelable, short paramShort, int paramInt2)
  {
    this.mMessage = paramString1;
    this.YtZ = paramString2;
    this.Yua = paramInt1;
    this.Yub = paramParcelable;
    this.Yuc = paramShort;
    this.Yud = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(159698);
    paramParcel.writeString(this.mMessage);
    paramParcel.writeString(this.YtZ);
    paramParcel.writeInt(this.Yua);
    paramParcel.writeParcelable(this.Yub, 0);
    paramParcel.writeInt(this.Yuc);
    paramParcel.writeInt(this.Yud);
    AppMethodBeat.o(159698);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.snackbar.Snack
 * JD-Core Version:    0.7.0.1
 */