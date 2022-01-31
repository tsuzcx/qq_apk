package com.tencent.soter.soterserver;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SoterSessionResult
  implements Parcelable
{
  public static final Parcelable.Creator<SoterSessionResult> CREATOR = new SoterSessionResult.1();
  public int aYY;
  public long wPs;
  
  public SoterSessionResult() {}
  
  protected SoterSessionResult(Parcel paramParcel)
  {
    this.wPs = paramParcel.readLong();
    this.aYY = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.wPs);
    paramParcel.writeInt(this.aYY);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.soter.soterserver.SoterSessionResult
 * JD-Core Version:    0.7.0.1
 */