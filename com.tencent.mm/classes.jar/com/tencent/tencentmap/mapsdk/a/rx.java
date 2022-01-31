package com.tencent.tencentmap.mapsdk.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class rx
  implements Parcelable
{
  public static final Parcelable.Creator<rx> CREATOR = new rx.1();
  private int a = 0;
  private int b = 0;
  
  public rx(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  private rx(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return false;
      } while (paramObject.getClass() != getClass());
      paramObject = (rx)paramObject;
    } while ((this.a != paramObject.a) || (this.b != paramObject.b));
    return true;
  }
  
  public final int hashCode()
  {
    return this.b * 7 + this.a * 11;
  }
  
  public final String toString()
  {
    return this.a + "," + this.b;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.rx
 * JD-Core Version:    0.7.0.1
 */