package com.tencent.mm.plugin.music.cache.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.j;

public class IPCAudioParamResponse
  implements Parcelable
{
  public static final Parcelable.Creator<IPCAudioParamResponse> CREATOR;
  public String fMd;
  public String fileName;
  public byte[] lWa;
  public int lWb;
  public String lWc;
  public int lWd;
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
    this.fMd = paramParcel.readString();
    this.musicUrl = paramParcel.readString();
    this.fileName = paramParcel.readString();
    this.lWc = paramParcel.readString();
    this.lWb = paramParcel.readInt();
    this.lWd = paramParcel.readInt();
    int i = paramParcel.readInt();
    if (i > 0)
    {
      this.lWa = new byte[i];
      paramParcel.readByteArray(this.lWa);
    }
    AppMethodBeat.o(137212);
  }
  
  public IPCAudioParamResponse(j paramj)
  {
    this.fMd = paramj.fMd;
    this.musicUrl = paramj.musicUrl;
    this.fileName = paramj.fileName;
    this.lWb = paramj.lWb;
    this.lWc = paramj.lWc;
    this.lWa = paramj.lWa;
    this.lWd = paramj.lWd;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(137213);
    paramParcel.writeString(this.fMd);
    paramParcel.writeString(this.musicUrl);
    paramParcel.writeString(this.fileName);
    paramParcel.writeString(this.lWc);
    paramParcel.writeInt(this.lWb);
    paramParcel.writeInt(this.lWd);
    if (this.lWa != null)
    {
      paramParcel.writeInt(this.lWa.length);
      paramParcel.writeByteArray(this.lWa);
      AppMethodBeat.o(137213);
      return;
    }
    paramParcel.writeInt(0);
    AppMethodBeat.o(137213);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.cache.ipc.IPCAudioParamResponse
 * JD-Core Version:    0.7.0.1
 */