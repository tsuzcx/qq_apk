package com.tencent.mm.ui.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

public class MMPinProgressBtn$SavedState
  extends View.BaseSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR = new MMPinProgressBtn.SavedState.1();
  private int wjw;
  private int xL;
  
  private MMPinProgressBtn$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    this.xL = paramParcel.readInt();
    this.wjw = paramParcel.readInt();
  }
  
  public MMPinProgressBtn$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.xL);
    paramParcel.writeInt(this.wjw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMPinProgressBtn.SavedState
 * JD-Core Version:    0.7.0.1
 */