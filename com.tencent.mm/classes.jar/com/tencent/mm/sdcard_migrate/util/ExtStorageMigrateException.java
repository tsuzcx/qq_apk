package com.tencent.mm.sdcard_migrate.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ExtStorageMigrateException
  extends RemoteException
  implements Parcelable
{
  public static final Parcelable.Creator<ExtStorageMigrateException> CREATOR;
  
  static
  {
    AppMethodBeat.i(211934);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(211934);
  }
  
  public ExtStorageMigrateException(Throwable paramThrowable)
  {
    AppMethodBeat.i(211932);
    initCause(paramThrowable);
    AppMethodBeat.o(211932);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(211933);
    paramParcel.writeParcelable(this, paramInt);
    AppMethodBeat.o(211933);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.util.ExtStorageMigrateException
 * JD-Core Version:    0.7.0.1
 */