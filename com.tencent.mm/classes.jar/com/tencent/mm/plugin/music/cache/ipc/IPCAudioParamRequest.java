package com.tencent.mm.plugin.music.cache.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class IPCAudioParamRequest
  implements Parcelable
{
  public static final Parcelable.Creator<IPCAudioParamRequest> CREATOR = new IPCAudioParamRequest.1();
  public String bSB = "";
  public byte[] euY;
  public String mimeType = "";
  public int myn = 0;
  
  public IPCAudioParamRequest() {}
  
  public IPCAudioParamRequest(Parcel paramParcel)
  {
    this.bSB = paramParcel.readString();
    this.myn = paramParcel.readInt();
    this.mimeType = paramParcel.readString();
    int i = paramParcel.readInt();
    if (i > 0)
    {
      this.euY = new byte[i];
      paramParcel.readByteArray(this.euY);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.bSB);
    paramParcel.writeInt(this.myn);
    paramParcel.writeString(this.mimeType);
    if (this.euY != null)
    {
      paramParcel.writeInt(this.euY.length);
      paramParcel.writeByteArray(this.euY);
      return;
    }
    paramParcel.writeInt(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.cache.ipc.IPCAudioParamRequest
 * JD-Core Version:    0.7.0.1
 */