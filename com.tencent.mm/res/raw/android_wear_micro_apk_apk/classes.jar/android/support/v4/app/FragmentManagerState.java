package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class FragmentManagerState
  implements Parcelable
{
  public static final Parcelable.Creator<FragmentManagerState> CREATOR = new Parcelable.Creator() {};
  int dY;
  FragmentState[] fa;
  int[] fb;
  BackStackState[] fc;
  int fd = -1;
  
  public FragmentManagerState() {}
  
  public FragmentManagerState(Parcel paramParcel)
  {
    this.fa = ((FragmentState[])paramParcel.createTypedArray(FragmentState.CREATOR));
    this.fb = paramParcel.createIntArray();
    this.fc = ((BackStackState[])paramParcel.createTypedArray(BackStackState.CREATOR));
    this.fd = paramParcel.readInt();
    this.dY = paramParcel.readInt();
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeTypedArray(this.fa, paramInt);
    paramParcel.writeIntArray(this.fb);
    paramParcel.writeTypedArray(this.fc, paramInt);
    paramParcel.writeInt(this.fd);
    paramParcel.writeInt(this.dY);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.FragmentManagerState
 * JD-Core Version:    0.7.0.1
 */