package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

class RecyclerView$SavedState
  extends View.BaseSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {};
  Parcelable uB;
  
  RecyclerView$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    this.uB = paramParcel.readParcelable(ab.class.getClassLoader());
  }
  
  RecyclerView$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.uB, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.SavedState
 * JD-Core Version:    0.7.0.1
 */