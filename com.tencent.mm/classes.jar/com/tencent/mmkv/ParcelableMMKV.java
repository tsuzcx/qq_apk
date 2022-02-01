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
  String IgT;
  int IgU;
  int IgV;
  String IgW;
  
  static
  {
    AppMethodBeat.i(13546);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(13546);
  }
  
  public ParcelableMMKV(MMKV paramMMKV)
  {
    AppMethodBeat.i(13544);
    this.IgU = -1;
    this.IgV = -1;
    this.IgW = null;
    this.IgT = paramMMKV.mmapID();
    this.IgU = paramMMKV.ashmemFD();
    this.IgV = paramMMKV.ashmemMetaFD();
    this.IgW = paramMMKV.cryptKey();
    AppMethodBeat.o(13544);
  }
  
  private ParcelableMMKV(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    this.IgU = -1;
    this.IgV = -1;
    this.IgW = null;
    this.IgT = paramString1;
    this.IgU = paramInt1;
    this.IgV = paramInt2;
    this.IgW = paramString2;
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
      paramParcel.writeString(this.IgT);
      ParcelFileDescriptor localParcelFileDescriptor1 = ParcelFileDescriptor.fromFd(this.IgU);
      ParcelFileDescriptor localParcelFileDescriptor2 = ParcelFileDescriptor.fromFd(this.IgV);
      paramInt |= 0x1;
      localParcelFileDescriptor1.writeToParcel(paramParcel, paramInt);
      localParcelFileDescriptor2.writeToParcel(paramParcel, paramInt);
      if (this.IgW != null) {
        paramParcel.writeString(this.IgW);
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