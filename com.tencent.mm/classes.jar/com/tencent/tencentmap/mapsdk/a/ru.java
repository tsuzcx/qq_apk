package com.tencent.tencentmap.mapsdk.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class ru
  implements Parcelable
{
  public static final Parcelable.Creator<ru> CREATOR = new ru.1();
  private final ry a;
  private float b = -1.0F;
  
  public ru(ry paramry, float paramFloat)
  {
    this.a = paramry;
    this.b = paramFloat;
  }
  
  public static ru.a a()
  {
    return new ru.a();
  }
  
  public final ry b()
  {
    return this.a;
  }
  
  public final float c()
  {
    return this.b;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof ru)) {
        return false;
      }
      paramObject = (ru)paramObject;
    } while ((b().equals(paramObject.b())) && (Float.floatToIntBits(c()) == Float.floatToIntBits(paramObject.c())));
    return false;
  }
  
  public final int hashCode()
  {
    return super.hashCode();
  }
  
  public final String toString()
  {
    return ub.a(new String[] { ub.a("target", b()), ub.a("zoom", Float.valueOf(c())) });
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeFloat((float)b().b());
    paramParcel.writeFloat((float)b().c());
    paramParcel.writeFloat(c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ru
 * JD-Core Version:    0.7.0.1
 */