package com.tencent.soter.soterserver;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SoterExportResult
  implements Parcelable
{
  public static final Parcelable.Creator<SoterExportResult> CREATOR = new Parcelable.Creator() {};
  public int aYY;
  public byte[] wPq;
  public int wPr;
  
  public SoterExportResult() {}
  
  public SoterExportResult(Parcel paramParcel)
  {
    this.aYY = paramParcel.readInt();
    this.wPq = paramParcel.createByteArray();
    this.wPr = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.aYY);
    paramParcel.writeByteArray(this.wPq);
    paramParcel.writeInt(this.wPr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.soter.soterserver.SoterExportResult
 * JD-Core Version:    0.7.0.1
 */