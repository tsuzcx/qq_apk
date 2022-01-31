package com.tencent.mm.plugin.music.cache.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.av.h;

public class IPCAudioParamResponse
  implements Parcelable
{
  public static final Parcelable.Creator<IPCAudioParamResponse> CREATOR = new IPCAudioParamResponse.1();
  public String bSB;
  public byte[] euY;
  public int euZ;
  public String eva;
  public String fileName;
  public String musicUrl;
  
  public IPCAudioParamResponse() {}
  
  public IPCAudioParamResponse(Parcel paramParcel)
  {
    this.bSB = paramParcel.readString();
    this.musicUrl = paramParcel.readString();
    this.fileName = paramParcel.readString();
    this.eva = paramParcel.readString();
    this.euZ = paramParcel.readInt();
    int i = paramParcel.readInt();
    if (i > 0)
    {
      this.euY = new byte[i];
      paramParcel.readByteArray(this.euY);
    }
  }
  
  public IPCAudioParamResponse(h paramh)
  {
    this.bSB = paramh.bSB;
    this.musicUrl = paramh.musicUrl;
    this.fileName = paramh.fileName;
    this.euZ = paramh.euZ;
    this.eva = paramh.eva;
    this.euY = paramh.euY;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.bSB);
    paramParcel.writeString(this.musicUrl);
    paramParcel.writeString(this.fileName);
    paramParcel.writeString(this.eva);
    paramParcel.writeInt(this.euZ);
    if (this.euY != null)
    {
      paramParcel.writeInt(this.euY.length);
      paramParcel.writeByteArray(this.euY);
      return;
    }
    paramParcel.writeInt(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.cache.ipc.IPCAudioParamResponse
 * JD-Core Version:    0.7.0.1
 */