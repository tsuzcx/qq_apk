package com.tencent.mm.plugin.performance.elf;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ElfCheckRequest
  implements Parcelable
{
  public static final Parcelable.Creator<ElfCheckRequest> CREATOR;
  public long LIF;
  
  static
  {
    AppMethodBeat.i(124977);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(124977);
  }
  
  public ElfCheckRequest()
  {
    this.LIF = 0L;
  }
  
  protected ElfCheckRequest(Parcel paramParcel)
  {
    AppMethodBeat.i(124976);
    this.LIF = 0L;
    this.LIF = paramParcel.readLong();
    AppMethodBeat.o(124976);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(124975);
    paramParcel.writeLong(this.LIF);
    AppMethodBeat.o(124975);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.elf.ElfCheckRequest
 * JD-Core Version:    0.7.0.1
 */