package com.tencent.tencentmap.mapsdk.a;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ru$1
  implements Parcelable.Creator<ru>
{
  public final ru a(Parcel paramParcel)
  {
    float f1 = paramParcel.readFloat();
    float f2 = paramParcel.readFloat();
    float f3 = paramParcel.readFloat();
    return new ru(new ry(f1, f2), f3);
  }
  
  public final ru[] a(int paramInt)
  {
    return new ru[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ru.1
 * JD-Core Version:    0.7.0.1
 */