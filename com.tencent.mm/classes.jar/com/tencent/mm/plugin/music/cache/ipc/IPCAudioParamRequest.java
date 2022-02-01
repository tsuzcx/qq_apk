package com.tencent.mm.plugin.music.cache.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class IPCAudioParamRequest
  implements Parcelable
{
  public static final Parcelable.Creator<IPCAudioParamRequest> CREATOR;
  public int LKM;
  public String mimeType;
  public String musicId;
  public byte[] oPd;
  
  static
  {
    AppMethodBeat.i(137210);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(137210);
  }
  
  public IPCAudioParamRequest()
  {
    this.musicId = "";
    this.LKM = 0;
    this.mimeType = "";
  }
  
  public IPCAudioParamRequest(Parcel paramParcel)
  {
    AppMethodBeat.i(137208);
    this.musicId = "";
    this.LKM = 0;
    this.mimeType = "";
    this.musicId = paramParcel.readString();
    this.LKM = paramParcel.readInt();
    this.mimeType = paramParcel.readString();
    int i = paramParcel.readInt();
    if (i > 0)
    {
      this.oPd = new byte[i];
      paramParcel.readByteArray(this.oPd);
    }
    AppMethodBeat.o(137208);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(137209);
    paramParcel.writeString(this.musicId);
    paramParcel.writeInt(this.LKM);
    paramParcel.writeString(this.mimeType);
    if (this.oPd != null)
    {
      paramParcel.writeInt(this.oPd.length);
      paramParcel.writeByteArray(this.oPd);
      AppMethodBeat.o(137209);
      return;
    }
    paramParcel.writeInt(0);
    AppMethodBeat.o(137209);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.cache.ipc.IPCAudioParamRequest
 * JD-Core Version:    0.7.0.1
 */