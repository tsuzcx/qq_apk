package android.support.wearable.view;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

class GridViewPager$SavedState
  extends View.BaseSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {};
  int Do;
  int Dp;
  
  private GridViewPager$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    this.Do = paramParcel.readInt();
    this.Dp = paramParcel.readInt();
  }
  
  public GridViewPager$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.Do);
    paramParcel.writeInt(this.Dp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.view.GridViewPager.SavedState
 * JD-Core Version:    0.7.0.1
 */