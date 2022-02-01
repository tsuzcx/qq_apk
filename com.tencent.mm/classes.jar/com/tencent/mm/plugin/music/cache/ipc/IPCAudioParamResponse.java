package com.tencent.mm.plugin.music.cache.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.j;

public class IPCAudioParamResponse
  implements Parcelable
{
  public static final Parcelable.Creator<IPCAudioParamResponse> CREATOR;
  public String dSF;
  public String fileName;
  public byte[] jfA;
  public int jfB;
  public String jfC;
  public int jfD;
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
    this.dSF = paramParcel.readString();
    this.musicUrl = paramParcel.readString();
    this.fileName = paramParcel.readString();
    this.jfC = paramParcel.readString();
    this.jfB = paramParcel.readInt();
    this.jfD = paramParcel.readInt();
    int i = paramParcel.readInt();
    if (i > 0)
    {
      this.jfA = new byte[i];
      paramParcel.readByteArray(this.jfA);
    }
    AppMethodBeat.o(137212);
  }
  
  public IPCAudioParamResponse(j paramj)
  {
    this.dSF = paramj.dSF;
    this.musicUrl = paramj.musicUrl;
    this.fileName = paramj.fileName;
    this.jfB = paramj.jfB;
    this.jfC = paramj.jfC;
    this.jfA = paramj.jfA;
    this.jfD = paramj.jfD;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(137213);
    paramParcel.writeString(this.dSF);
    paramParcel.writeString(this.musicUrl);
    paramParcel.writeString(this.fileName);
    paramParcel.writeString(this.jfC);
    paramParcel.writeInt(this.jfB);
    paramParcel.writeInt(this.jfD);
    if (this.jfA != null)
    {
      paramParcel.writeInt(this.jfA.length);
      paramParcel.writeByteArray(this.jfA);
      AppMethodBeat.o(137213);
      return;
    }
    paramParcel.writeInt(0);
    AppMethodBeat.o(137213);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.cache.ipc.IPCAudioParamResponse
 * JD-Core Version:    0.7.0.1
 */