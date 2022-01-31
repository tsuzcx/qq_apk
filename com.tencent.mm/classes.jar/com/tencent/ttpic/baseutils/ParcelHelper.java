package com.tencent.ttpic.baseutils;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ParcelHelper
{
  public static <T> T copy(Parcelable paramParcelable)
  {
    AppMethodBeat.i(49791);
    Object localObject = null;
    try
    {
      Parcel localParcel = Parcel.obtain();
      localObject = localParcel;
      localParcel.writeParcelable(paramParcelable, 0);
      localObject = localParcel;
      localParcel.setDataPosition(0);
      localObject = localParcel;
      paramParcelable = localParcel.readParcelable(paramParcelable.getClass().getClassLoader());
      return paramParcelable;
    }
    finally
    {
      localObject.recycle();
      AppMethodBeat.o(49791);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.ParcelHelper
 * JD-Core Version:    0.7.0.1
 */