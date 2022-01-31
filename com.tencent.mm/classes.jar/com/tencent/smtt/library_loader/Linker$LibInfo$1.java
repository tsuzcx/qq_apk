package com.tencent.smtt.library_loader;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class Linker$LibInfo$1
  implements Parcelable.Creator<Linker.LibInfo>
{
  public final Linker.LibInfo createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(138975);
    paramParcel = new Linker.LibInfo(paramParcel);
    AppMethodBeat.o(138975);
    return paramParcel;
  }
  
  public final Linker.LibInfo[] newArray(int paramInt)
  {
    return new Linker.LibInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.smtt.library_loader.Linker.LibInfo.1
 * JD-Core Version:    0.7.0.1
 */