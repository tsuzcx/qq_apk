package com.tencent.mm.ui.widget.snackbar;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

class Snack
  implements Parcelable
{
  public static final Parcelable.Creator<Snack> CREATOR = new Snack.1();
  final String ljq;
  final String wpJ;
  final int wpK;
  final Parcelable wpL;
  final short wpM;
  final int wpN;
  
  Snack(Parcel paramParcel)
  {
    this.ljq = paramParcel.readString();
    this.wpJ = paramParcel.readString();
    this.wpK = paramParcel.readInt();
    this.wpL = paramParcel.readParcelable(paramParcel.getClass().getClassLoader());
    this.wpM = ((short)paramParcel.readInt());
    this.wpN = paramParcel.readInt();
  }
  
  Snack(String paramString1, String paramString2, int paramInt1, Parcelable paramParcelable, short paramShort, int paramInt2)
  {
    this.ljq = paramString1;
    this.wpJ = paramString2;
    this.wpK = paramInt1;
    this.wpL = paramParcelable;
    this.wpM = paramShort;
    this.wpN = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.ljq);
    paramParcel.writeString(this.wpJ);
    paramParcel.writeInt(this.wpK);
    paramParcel.writeParcelable(this.wpL, 0);
    paramParcel.writeInt(this.wpM);
    paramParcel.writeInt(this.wpN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.snackbar.Snack
 * JD-Core Version:    0.7.0.1
 */