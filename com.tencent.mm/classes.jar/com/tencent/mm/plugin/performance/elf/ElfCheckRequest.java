package com.tencent.mm.plugin.performance.elf;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ElfCheckRequest
  implements Parcelable
{
  public static final Parcelable.Creator<ElfCheckRequest> CREATOR;
  public long bQx;
  
  static
  {
    AppMethodBeat.i(111050);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(111050);
  }
  
  public ElfCheckRequest()
  {
    this.bQx = 0L;
  }
  
  protected ElfCheckRequest(Parcel paramParcel)
  {
    AppMethodBeat.i(111049);
    this.bQx = 0L;
    this.bQx = paramParcel.readLong();
    AppMethodBeat.o(111049);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(111048);
    paramParcel.writeLong(this.bQx);
    AppMethodBeat.o(111048);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.elf.ElfCheckRequest
 * JD-Core Version:    0.7.0.1
 */