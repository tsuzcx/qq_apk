package com.tencent.mm.plugin.music.cache.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.j;

public class IPCAudioParamResponse
  implements Parcelable
{
  public static final Parcelable.Creator<IPCAudioParamResponse> CREATOR;
  public String fileName;
  public String musicId;
  public String musicUrl;
  public byte[] oPd;
  public int oPe;
  public String oPf;
  public int oPg;
  
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
    this.musicId = paramParcel.readString();
    this.musicUrl = paramParcel.readString();
    this.fileName = paramParcel.readString();
    this.oPf = paramParcel.readString();
    this.oPe = paramParcel.readInt();
    this.oPg = paramParcel.readInt();
    int i = paramParcel.readInt();
    if (i > 0)
    {
      this.oPd = new byte[i];
      paramParcel.readByteArray(this.oPd);
    }
    AppMethodBeat.o(137212);
  }
  
  public IPCAudioParamResponse(j paramj)
  {
    this.musicId = paramj.musicId;
    this.musicUrl = paramj.musicUrl;
    this.fileName = paramj.fileName;
    this.oPe = paramj.oPe;
    this.oPf = paramj.oPf;
    this.oPd = paramj.oPd;
    this.oPg = paramj.oPg;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(137213);
    paramParcel.writeString(this.musicId);
    paramParcel.writeString(this.musicUrl);
    paramParcel.writeString(this.fileName);
    paramParcel.writeString(this.oPf);
    paramParcel.writeInt(this.oPe);
    paramParcel.writeInt(this.oPg);
    if (this.oPd != null)
    {
      paramParcel.writeInt(this.oPd.length);
      paramParcel.writeByteArray(this.oPd);
      AppMethodBeat.o(137213);
      return;
    }
    paramParcel.writeInt(0);
    AppMethodBeat.o(137213);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.cache.ipc.IPCAudioParamResponse
 * JD-Core Version:    0.7.0.1
 */