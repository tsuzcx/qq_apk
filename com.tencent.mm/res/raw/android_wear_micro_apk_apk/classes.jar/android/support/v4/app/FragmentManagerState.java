package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class FragmentManagerState
  implements Parcelable
{
  public static final Parcelable.Creator<FragmentManagerState> CREATOR = new Parcelable.Creator() {};
  int cp;
  FragmentState[] dl;
  int[] dm;
  BackStackState[] dn;
  int jdField_do = -1;
  
  public FragmentManagerState() {}
  
  public FragmentManagerState(Parcel paramParcel)
  {
    this.dl = ((FragmentState[])paramParcel.createTypedArray(FragmentState.CREATOR));
    this.dm = paramParcel.createIntArray();
    this.dn = ((BackStackState[])paramParcel.createTypedArray(BackStackState.CREATOR));
    this.jdField_do = paramParcel.readInt();
    this.cp = paramParcel.readInt();
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeTypedArray(this.dl, paramInt);
    paramParcel.writeIntArray(this.dm);
    paramParcel.writeTypedArray(this.dn, paramInt);
    paramParcel.writeInt(this.jdField_do);
    paramParcel.writeInt(this.cp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.FragmentManagerState
 * JD-Core Version:    0.7.0.1
 */