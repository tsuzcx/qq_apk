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
    AppMethodBeat.i(195913);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(195913);
  }
  
  public ExtStorageMigrateException(Throwable paramThrowable)
  {
    AppMethodBeat.i(195911);
    initCause(paramThrowable);
    AppMethodBeat.o(195911);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(195912);
    paramParcel.writeParcelable(this, paramInt);
    AppMethodBeat.o(195912);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.util.ExtStorageMigrateException
 * JD-Core Version:    0.7.0.1
 */