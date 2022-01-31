package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ParcelableVolumeInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new Parcelable.Creator() {};
  public int ir;
  public int is;
  public int it;
  public int iu;
  public int iv;
  
  public ParcelableVolumeInfo(Parcel paramParcel)
  {
    this.ir = paramParcel.readInt();
    this.it = paramParcel.readInt();
    this.iu = paramParcel.readInt();
    this.iv = paramParcel.readInt();
    this.is = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.ir);
    paramParcel.writeInt(this.it);
    paramParcel.writeInt(this.iu);
    paramParcel.writeInt(this.iv);
    paramParcel.writeInt(this.is);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.session.ParcelableVolumeInfo
 * JD-Core Version:    0.7.0.1
 */