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
  String LCk;
  int LCl;
  int LCm;
  String LCn;
  
  static
  {
    AppMethodBeat.i(13546);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(13546);
  }
  
  public ParcelableMMKV(MMKV paramMMKV)
  {
    AppMethodBeat.i(13544);
    this.LCl = -1;
    this.LCm = -1;
    this.LCn = null;
    this.LCk = paramMMKV.mmapID();
    this.LCl = paramMMKV.ashmemFD();
    this.LCm = paramMMKV.ashmemMetaFD();
    this.LCn = paramMMKV.cryptKey();
    AppMethodBeat.o(13544);
  }
  
  private ParcelableMMKV(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    this.LCl = -1;
    this.LCm = -1;
    this.LCn = null;
    this.LCk = paramString1;
    this.LCl = paramInt1;
    this.LCm = paramInt2;
    this.LCn = paramString2;
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
      paramParcel.writeString(this.LCk);
      ParcelFileDescriptor localParcelFileDescriptor1 = ParcelFileDescriptor.fromFd(this.LCl);
      ParcelFileDescriptor localParcelFileDescriptor2 = ParcelFileDescriptor.fromFd(this.LCm);
      paramInt |= 0x1;
      localParcelFileDescriptor1.writeToParcel(paramParcel, paramInt);
      localParcelFileDescriptor2.writeToParcel(paramParcel, paramInt);
      if (this.LCn != null) {
        paramParcel.writeString(this.LCn);
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