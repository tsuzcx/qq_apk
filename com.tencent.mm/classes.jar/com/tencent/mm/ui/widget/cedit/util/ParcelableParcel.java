package com.tencent.mm.ui.widget.cedit.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ParcelableParcel
  implements Parcelable
{
  public static final Parcelable.ClassLoaderCreator<ParcelableParcel> CREATOR;
  public final Parcel cjB;
  final ClassLoader mClassLoader;
  
  static
  {
    AppMethodBeat.i(252164);
    CREATOR = new Parcelable.ClassLoaderCreator() {};
    AppMethodBeat.o(252164);
  }
  
  public ParcelableParcel(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(252156);
    this.cjB = Parcel.obtain();
    this.mClassLoader = paramClassLoader;
    int k = paramParcel.readInt();
    if (k < 0)
    {
      paramParcel = new IllegalArgumentException("Negative size read from parcel");
      AppMethodBeat.o(252156);
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
      this.cjB.appendFrom(paramParcel, j, k);
      AppMethodBeat.o(252156);
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
    AppMethodBeat.o(252156);
    throw paramParcel;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(252182);
    paramParcel.writeInt(this.cjB.dataSize());
    paramParcel.appendFrom(this.cjB, 0, this.cjB.dataSize());
    AppMethodBeat.o(252182);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.util.ParcelableParcel
 * JD-Core Version:    0.7.0.1
 */