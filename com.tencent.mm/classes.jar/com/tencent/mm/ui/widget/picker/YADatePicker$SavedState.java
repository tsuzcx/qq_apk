package com.tencent.mm.ui.widget.picker;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

class YADatePicker$SavedState
  extends View.BaseSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR = new YADatePicker.SavedState.1();
  private final int dtl;
  private final int dtp;
  private final int hVT;
  
  private YADatePicker$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    this.dtp = paramParcel.readInt();
    this.dtl = paramParcel.readInt();
    this.hVT = paramParcel.readInt();
  }
  
  private YADatePicker$SavedState(Parcelable paramParcelable, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramParcelable);
    this.dtp = paramInt1;
    this.dtl = paramInt2;
    this.hVT = paramInt3;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.dtp);
    paramParcel.writeInt(this.dtl);
    paramParcel.writeInt(this.hVT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.YADatePicker.SavedState
 * JD-Core Version:    0.7.0.1
 */