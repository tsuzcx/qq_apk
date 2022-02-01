package com.tencent.mm.plugin.music.cache.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.i;

public class IPCAudioParamResponse
  implements Parcelable
{
  public static final Parcelable.Creator<IPCAudioParamResponse> CREATOR;
  public String dnX;
  public String fileName;
  public byte[] hOu;
  public int hOv;
  public String hOw;
  public int hOx;
  public String musicUrl;
  
  static
  {
    AppMethodBeat.i(137214);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(137214);
  }
  
  public IPCAudioParamResponse() {}
  
  public IPCAudioParamResponse(Parcel paramParcel)
  {
    AppMethodBeat.i(137212);
    this.dnX = paramParcel.readString();
    this.musicUrl = paramParcel.readString();
    this.fileName = paramParcel.readString();
    this.hOw = paramParcel.readString();
    this.hOv = paramParcel.readInt();
    this.hOx = paramParcel.readInt();
    int i = paramParcel.readInt();
    if (i > 0)
    {
      this.hOu = new byte[i];
      paramParcel.readByteArray(this.hOu);
    }
    AppMethodBeat.o(137212);
  }
  
  public IPCAudioParamResponse(i parami)
  {
    this.dnX = parami.dnX;
    this.musicUrl = parami.musicUrl;
    this.fileName = parami.fileName;
    this.hOv = parami.hOv;
    this.hOw = parami.hOw;
    this.hOu = parami.hOu;
    this.hOx = parami.hOx;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(137213);
    paramParcel.writeString(this.dnX);
    paramParcel.writeString(this.musicUrl);
    paramParcel.writeString(this.fileName);
    paramParcel.writeString(this.hOw);
    paramParcel.writeInt(this.hOv);
    paramParcel.writeInt(this.hOx);
    if (this.hOu != null)
    {
      paramParcel.writeInt(this.hOu.length);
      paramParcel.writeByteArray(this.hOu);
      AppMethodBeat.o(137213);
      return;
    }
    paramParcel.writeInt(0);
    AppMethodBeat.o(137213);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.cache.ipc.IPCAudioParamResponse
 * JD-Core Version:    0.7.0.1
 */