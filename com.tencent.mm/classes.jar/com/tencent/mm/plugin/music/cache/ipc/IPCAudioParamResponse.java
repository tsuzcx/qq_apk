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
  public String dAQ;
  public String fileName;
  public byte[] ikB;
  public int ikC;
  public String ikD;
  public int ikE;
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
    this.dAQ = paramParcel.readString();
    this.musicUrl = paramParcel.readString();
    this.fileName = paramParcel.readString();
    this.ikD = paramParcel.readString();
    this.ikC = paramParcel.readInt();
    this.ikE = paramParcel.readInt();
    int i = paramParcel.readInt();
    if (i > 0)
    {
      this.ikB = new byte[i];
      paramParcel.readByteArray(this.ikB);
    }
    AppMethodBeat.o(137212);
  }
  
  public IPCAudioParamResponse(i parami)
  {
    this.dAQ = parami.dAQ;
    this.musicUrl = parami.musicUrl;
    this.fileName = parami.fileName;
    this.ikC = parami.ikC;
    this.ikD = parami.ikD;
    this.ikB = parami.ikB;
    this.ikE = parami.ikE;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(137213);
    paramParcel.writeString(this.dAQ);
    paramParcel.writeString(this.musicUrl);
    paramParcel.writeString(this.fileName);
    paramParcel.writeString(this.ikD);
    paramParcel.writeInt(this.ikC);
    paramParcel.writeInt(this.ikE);
    if (this.ikB != null)
    {
      paramParcel.writeInt(this.ikB.length);
      paramParcel.writeByteArray(this.ikB);
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