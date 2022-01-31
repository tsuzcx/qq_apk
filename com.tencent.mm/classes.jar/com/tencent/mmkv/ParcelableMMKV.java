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
  String AZZ;
  int Baa;
  int Bab;
  String Bac;
  
  static
  {
    AppMethodBeat.i(124055);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(124055);
  }
  
  public ParcelableMMKV(MMKV paramMMKV)
  {
    AppMethodBeat.i(124053);
    this.Baa = -1;
    this.Bab = -1;
    this.Bac = null;
    this.AZZ = paramMMKV.mmapID();
    this.Baa = paramMMKV.ashmemFD();
    this.Bab = paramMMKV.ashmemMetaFD();
    this.Bac = paramMMKV.cryptKey();
    AppMethodBeat.o(124053);
  }
  
  private ParcelableMMKV(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    this.Baa = -1;
    this.Bab = -1;
    this.Bac = null;
    this.AZZ = paramString1;
    this.Baa = paramInt1;
    this.Bab = paramInt2;
    this.Bac = paramString2;
  }
  
  public final int describeContents()
  {
    return 1;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(124054);
    try
    {
      paramParcel.writeString(this.AZZ);
      ParcelFileDescriptor localParcelFileDescriptor1 = ParcelFileDescriptor.fromFd(this.Baa);
      ParcelFileDescriptor localParcelFileDescriptor2 = ParcelFileDescriptor.fromFd(this.Bab);
      paramInt |= 0x1;
      localParcelFileDescriptor1.writeToParcel(paramParcel, paramInt);
      localParcelFileDescriptor2.writeToParcel(paramParcel, paramInt);
      if (this.Bac != null) {
        paramParcel.writeString(this.Bac);
      }
      AppMethodBeat.o(124054);
      return;
    }
    catch (IOException paramParcel)
    {
      AppMethodBeat.o(124054);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mmkv.ParcelableMMKV
 * JD-Core Version:    0.7.0.1
 */