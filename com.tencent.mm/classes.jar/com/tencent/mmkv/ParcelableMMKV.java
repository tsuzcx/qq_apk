package com.tencent.mmkv;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public final class ParcelableMMKV
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelableMMKV> CREATOR;
  String LZo;
  int LZp;
  int LZq;
  String LZr;
  
  static
  {
    AppMethodBeat.i(13546);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(13546);
  }
  
  public ParcelableMMKV(MMKV paramMMKV)
  {
    AppMethodBeat.i(13544);
    this.LZp = -1;
    this.LZq = -1;
    this.LZr = null;
    this.LZo = paramMMKV.mmapID();
    this.LZp = paramMMKV.ashmemFD();
    this.LZq = paramMMKV.ashmemMetaFD();
    this.LZr = paramMMKV.cryptKey();
    AppMethodBeat.o(13544);
  }
  
  private ParcelableMMKV(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    this.LZp = -1;
    this.LZq = -1;
    this.LZr = null;
    this.LZo = paramString1;
    this.LZp = paramInt1;
    this.LZq = paramInt2;
    this.LZr = paramString2;
  }
  
  public final int describeContents()
  {
    return 1;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(13545);
    try
    {
      paramParcel.writeString(this.LZo);
      ParcelFileDescriptor localParcelFileDescriptor1 = ParcelFileDescriptor.fromFd(this.LZp);
      ParcelFileDescriptor localParcelFileDescriptor2 = ParcelFileDescriptor.fromFd(this.LZq);
      paramInt |= 0x1;
      localParcelFileDescriptor1.writeToParcel(paramParcel, paramInt);
      localParcelFileDescriptor2.writeToParcel(paramParcel, paramInt);
      if (this.LZr != null) {
        paramParcel.writeString(this.LZr);
      }
      AppMethodBeat.o(13545);
      return;
    }
    catch (IOException paramParcel)
    {
      AppMethodBeat.o(13545);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mmkv.ParcelableMMKV
 * JD-Core Version:    0.7.0.1
 */