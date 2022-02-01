package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class RatingCompat
  implements Parcelable
{
  public static final Parcelable.Creator<RatingCompat> CREATOR = new Parcelable.Creator() {};
  private final int jL;
  private final float jM;
  
  RatingCompat(int paramInt, float paramFloat)
  {
    this.jL = paramInt;
    this.jM = paramFloat;
  }
  
  public final int describeContents()
  {
    return this.jL;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Rating:style=").append(this.jL).append(" rating=");
    if (this.jM < 0.0F) {}
    for (String str = "unrated";; str = String.valueOf(this.jM)) {
      return str;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jL);
    paramParcel.writeFloat(this.jM);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.RatingCompat
 * JD-Core Version:    0.7.0.1
 */