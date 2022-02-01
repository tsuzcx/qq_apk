package com.tencent.mm.ui.widget.cedit.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ParcelableParcel
  implements Parcelable
{
  public static final Parcelable.ClassLoaderCreator<ParcelableParcel> CREATOR;
  public final Parcel aBu;
  final ClassLoader mClassLoader;
  
  static
  {
    AppMethodBeat.i(206124);
    CREATOR = new Parcelable.ClassLoaderCreator() {};
    AppMethodBeat.o(206124);
  }
  
  public ParcelableParcel(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(206122);
    this.aBu = Parcel.obtain();
    this.mClassLoader = paramClassLoader;
    int k = paramParcel.readInt();
    if (k < 0)
    {
      paramParcel = new IllegalArgumentException("Negative size read from parcel");
      AppMethodBeat.o(206122);
      throw paramParcel;
    }
    int j = paramParcel.dataPosition();
    int i;
    if (k == 0) {
      i = j;
    }
    for (;;)
    {
      paramParcel.setDataPosition(i);
      this.aBu.appendFrom(paramParcel, j, k);
      AppMethodBeat.o(206122);
      return;
      if ((k > 0) && (j <= 2147483647 - k))
      {
        i = j + k;
      }
      else
      {
        if ((k >= 0) || (j < -2147483648 - k)) {
          break;
        }
        i = j + k;
      }
    }
    paramParcel = new IllegalArgumentException("Addition overflow: " + j + " + " + k);
    AppMethodBeat.o(206122);
    throw paramParcel;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(206123);
    paramParcel.writeInt(this.aBu.dataSize());
    paramParcel.appendFrom(this.aBu, 0, this.aBu.dataSize());
    AppMethodBeat.o(206123);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.util.ParcelableParcel
 * JD-Core Version:    0.7.0.1
 */