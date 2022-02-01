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
  public String dzL;
  public String fileName;
  public byte[] ihI;
  public int ihJ;
  public String ihK;
  public int ihL;
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
    this.dzL = paramParcel.readString();
    this.musicUrl = paramParcel.readString();
    this.fileName = paramParcel.readString();
    this.ihK = paramParcel.readString();
    this.ihJ = paramParcel.readInt();
    this.ihL = paramParcel.readInt();
    int i = paramParcel.readInt();
    if (i > 0)
    {
      this.ihI = new byte[i];
      paramParcel.readByteArray(this.ihI);
    }
    AppMethodBeat.o(137212);
  }
  
  public IPCAudioParamResponse(i parami)
  {
    this.dzL = parami.dzL;
    this.musicUrl = parami.musicUrl;
    this.fileName = parami.fileName;
    this.ihJ = parami.ihJ;
    this.ihK = parami.ihK;
    this.ihI = parami.ihI;
    this.ihL = parami.ihL;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(137213);
    paramParcel.writeString(this.dzL);
    paramParcel.writeString(this.musicUrl);
    paramParcel.writeString(this.fileName);
    paramParcel.writeString(this.ihK);
    paramParcel.writeInt(this.ihJ);
    paramParcel.writeInt(this.ihL);
    if (this.ihI != null)
    {
      paramParcel.writeInt(this.ihI.length);
      paramParcel.writeByteArray(this.ihI);
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