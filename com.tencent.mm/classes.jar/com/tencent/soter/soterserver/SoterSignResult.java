package com.tencent.soter.soterserver;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SoterSignResult
  implements Parcelable
{
  public static final Parcelable.Creator<SoterSignResult> CREATOR = new SoterSignResult.1();
  public int aYY;
  public byte[] wPq;
  public int wPr;
  
  public SoterSignResult() {}
  
  protected SoterSignResult(Parcel paramParcel)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.soter.soterserver.SoterSignResult
 * JD-Core Version:    0.7.0.1
 */