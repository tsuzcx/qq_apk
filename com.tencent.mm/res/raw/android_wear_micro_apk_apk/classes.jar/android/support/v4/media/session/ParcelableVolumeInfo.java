package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ParcelableVolumeInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new Parcelable.Creator() {};
  public int kp;
  public int kq;
  public int kr;
  public int ks;
  public int kt;
  
  public ParcelableVolumeInfo(Parcel paramParcel)
  {
    this.kp = paramParcel.readInt();
    this.kr = paramParcel.readInt();
    this.ks = paramParcel.readInt();
    this.kt = paramParcel.readInt();
    this.kq = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.kp);
    paramParcel.writeInt(this.kr);
    paramParcel.writeInt(this.ks);
    paramParcel.writeInt(this.kt);
    paramParcel.writeInt(this.kq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.session.ParcelableVolumeInfo
 * JD-Core Version:    0.7.0.1
 */