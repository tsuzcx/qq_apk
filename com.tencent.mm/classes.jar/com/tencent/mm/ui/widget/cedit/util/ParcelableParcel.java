package com.tencent.mm.ui.widget.cedit.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ParcelableParcel
  implements Parcelable
{
  public static final Parcelable.ClassLoaderCreator<ParcelableParcel> CREATOR;
  public final Parcel ave;
  final ClassLoader mClassLoader;
  
  static
  {
    AppMethodBeat.i(189012);
    CREATOR = new Parcelable.ClassLoaderCreator() {};
    AppMethodBeat.o(189012);
  }
  
  public ParcelableParcel(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(188991);
    this.ave = Parcel.obtain();
    this.mClassLoader = paramClassLoader;
    int k = paramParcel.readInt();
    if (k < 0)
    {
      paramParcel = new IllegalArgumentException("Negative size read from parcel");
      AppMethodBeat.o(188991);
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
      this.ave.appendFrom(paramParcel, j, k);
      AppMethodBeat.o(188991);
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
    AppMethodBeat.o(188991);
    throw paramParcel;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(189005);
    paramParcel.writeInt(this.ave.dataSize());
    paramParcel.appendFrom(this.ave, 0, this.ave.dataSize());
    AppMethodBeat.o(189005);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.util.ParcelableParcel
 * JD-Core Version:    0.7.0.1
 */