package com.tencent.mm.plugin.music.cache.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.h;

public class IPCAudioParamResponse
  implements Parcelable
{
  public static final Parcelable.Creator<IPCAudioParamResponse> CREATOR;
  public String cAd;
  public byte[] fKK;
  public int fKL;
  public String fKM;
  public int fKN;
  public String fileName;
  public String musicUrl;
  
  static
  {
    AppMethodBeat.i(137464);
    CREATOR = new IPCAudioParamResponse.1();
    AppMethodBeat.o(137464);
  }
  
  public IPCAudioParamResponse() {}
  
  public IPCAudioParamResponse(Parcel paramParcel)
  {
    AppMethodBeat.i(137462);
    this.cAd = paramParcel.readString();
    this.musicUrl = paramParcel.readString();
    this.fileName = paramParcel.readString();
    this.fKM = paramParcel.readString();
    this.fKL = paramParcel.readInt();
    this.fKN = paramParcel.readInt();
    int i = paramParcel.readInt();
    if (i > 0)
    {
      this.fKK = new byte[i];
      paramParcel.readByteArray(this.fKK);
    }
    AppMethodBeat.o(137462);
  }
  
  public IPCAudioParamResponse(h paramh)
  {
    this.cAd = paramh.cAd;
    this.musicUrl = paramh.musicUrl;
    this.fileName = paramh.fileName;
    this.fKL = paramh.fKL;
    this.fKM = paramh.fKM;
    this.fKK = paramh.fKK;
    this.fKN = paramh.fKN;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(137463);
    paramParcel.writeString(this.cAd);
    paramParcel.writeString(this.musicUrl);
    paramParcel.writeString(this.fileName);
    paramParcel.writeString(this.fKM);
    paramParcel.writeInt(this.fKL);
    paramParcel.writeInt(this.fKN);
    if (this.fKK != null)
    {
      paramParcel.writeInt(this.fKK.length);
      paramParcel.writeByteArray(this.fKK);
      AppMethodBeat.o(137463);
      return;
    }
    paramParcel.writeInt(0);
    AppMethodBeat.o(137463);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.cache.ipc.IPCAudioParamResponse
 * JD-Core Version:    0.7.0.1
 */