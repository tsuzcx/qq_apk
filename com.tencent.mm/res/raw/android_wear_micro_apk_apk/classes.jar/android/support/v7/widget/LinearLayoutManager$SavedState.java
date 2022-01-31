package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

class LinearLayoutManager$SavedState
  implements Parcelable
{
  public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {};
  int sK;
  int sL;
  boolean sM;
  
  public LinearLayoutManager$SavedState() {}
  
  LinearLayoutManager$SavedState(Parcel paramParcel)
  {
    this.sK = paramParcel.readInt();
    this.sL = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.sM = bool;
      return;
      bool = false;
    }
  }
  
  public LinearLayoutManager$SavedState(SavedState paramSavedState)
  {
    this.sK = paramSavedState.sK;
    this.sL = paramSavedState.sL;
    this.sM = paramSavedState.sM;
  }
  
  final boolean cX()
  {
    return this.sK >= 0;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.sK);
    paramParcel.writeInt(this.sL);
    if (this.sM) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.LinearLayoutManager.SavedState
 * JD-Core Version:    0.7.0.1
 */