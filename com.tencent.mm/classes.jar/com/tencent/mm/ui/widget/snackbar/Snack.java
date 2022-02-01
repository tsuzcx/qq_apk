package com.tencent.mm.ui.widget.snackbar;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

class Snack
  implements Parcelable
{
  public static final Parcelable.Creator<Snack> CREATOR;
  final String HLd;
  final int HLe;
  final Parcelable HLf;
  final short HLg;
  final int HLh;
  final String ste;
  
  static
  {
    AppMethodBeat.i(159699);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(159699);
  }
  
  Snack(Parcel paramParcel)
  {
    AppMethodBeat.i(159697);
    this.ste = paramParcel.readString();
    this.HLd = paramParcel.readString();
    this.HLe = paramParcel.readInt();
    this.HLf = paramParcel.readParcelable(paramParcel.getClass().getClassLoader());
    this.HLg = ((short)paramParcel.readInt());
    this.HLh = paramParcel.readInt();
    AppMethodBeat.o(159697);
  }
  
  Snack(String paramString1, String paramString2, int paramInt1, Parcelable paramParcelable, short paramShort, int paramInt2)
  {
    this.ste = paramString1;
    this.HLd = paramString2;
    this.HLe = paramInt1;
    this.HLf = paramParcelable;
    this.HLg = paramShort;
    this.HLh = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(159698);
    paramParcel.writeString(this.ste);
    paramParcel.writeString(this.HLd);
    paramParcel.writeInt(this.HLe);
    paramParcel.writeParcelable(this.HLf, 0);
    paramParcel.writeInt(this.HLg);
    paramParcel.writeInt(this.HLh);
    AppMethodBeat.o(159698);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.snackbar.Snack
 * JD-Core Version:    0.7.0.1
 */