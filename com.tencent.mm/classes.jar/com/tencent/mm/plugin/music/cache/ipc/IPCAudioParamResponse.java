package com.tencent.mm.plugin.music.cache.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.i;

public class IPCAudioParamResponse
  implements Parcelable
{
  public static final Parcelable.Creator<IPCAudioParamResponse> CREATOR;
  public String dqm;
  public String fileName;
  public byte[] hnR;
  public int hnS;
  public String hnT;
  public int hnU;
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
    this.dqm = paramParcel.readString();
    this.musicUrl = paramParcel.readString();
    this.fileName = paramParcel.readString();
    this.hnT = paramParcel.readString();
    this.hnS = paramParcel.readInt();
    this.hnU = paramParcel.readInt();
    int i = paramParcel.readInt();
    if (i > 0)
    {
      this.hnR = new byte[i];
      paramParcel.readByteArray(this.hnR);
    }
    AppMethodBeat.o(137212);
  }
  
  public IPCAudioParamResponse(i parami)
  {
    this.dqm = parami.dqm;
    this.musicUrl = parami.musicUrl;
    this.fileName = parami.fileName;
    this.hnS = parami.hnS;
    this.hnT = parami.hnT;
    this.hnR = parami.hnR;
    this.hnU = parami.hnU;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(137213);
    paramParcel.writeString(this.dqm);
    paramParcel.writeString(this.musicUrl);
    paramParcel.writeString(this.fileName);
    paramParcel.writeString(this.hnT);
    paramParcel.writeInt(this.hnS);
    paramParcel.writeInt(this.hnU);
    if (this.hnR != null)
    {
      paramParcel.writeInt(this.hnR.length);
      paramParcel.writeByteArray(this.hnR);
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