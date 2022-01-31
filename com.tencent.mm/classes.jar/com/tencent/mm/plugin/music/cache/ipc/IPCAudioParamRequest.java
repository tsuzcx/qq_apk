package com.tencent.mm.plugin.music.cache.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class IPCAudioParamRequest
  implements Parcelable
{
  public static final Parcelable.Creator<IPCAudioParamRequest> CREATOR;
  public String cAd;
  public byte[] fKK;
  public String mimeType;
  public int oYu;
  
  static
  {
    AppMethodBeat.i(137460);
    CREATOR = new IPCAudioParamRequest.1();
    AppMethodBeat.o(137460);
  }
  
  public IPCAudioParamRequest()
  {
    this.cAd = "";
    this.oYu = 0;
    this.mimeType = "";
  }
  
  public IPCAudioParamRequest(Parcel paramParcel)
  {
    AppMethodBeat.i(137458);
    this.cAd = "";
    this.oYu = 0;
    this.mimeType = "";
    this.cAd = paramParcel.readString();
    this.oYu = paramParcel.readInt();
    this.mimeType = paramParcel.readString();
    int i = paramParcel.readInt();
    if (i > 0)
    {
      this.fKK = new byte[i];
      paramParcel.readByteArray(this.fKK);
    }
    AppMethodBeat.o(137458);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(137459);
    paramParcel.writeString(this.cAd);
    paramParcel.writeInt(this.oYu);
    paramParcel.writeString(this.mimeType);
    if (this.fKK != null)
    {
      paramParcel.writeInt(this.fKK.length);
      paramParcel.writeByteArray(this.fKK);
      AppMethodBeat.o(137459);
      return;
    }
    paramParcel.writeInt(0);
    AppMethodBeat.o(137459);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.cache.ipc.IPCAudioParamRequest
 * JD-Core Version:    0.7.0.1
 */