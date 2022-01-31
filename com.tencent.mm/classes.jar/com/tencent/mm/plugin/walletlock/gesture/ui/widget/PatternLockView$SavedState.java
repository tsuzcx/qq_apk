package com.tencent.mm.plugin.walletlock.gesture.ui.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

class PatternLockView$SavedState
  extends View.BaseSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {};
  String qQN;
  int qQO;
  boolean qQt;
  boolean qQu;
  boolean qQv;
  
  public PatternLockView$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    this.qQN = paramParcel.readString();
    this.qQO = paramParcel.readInt();
    this.qQu = ((Boolean)paramParcel.readValue(null)).booleanValue();
    this.qQv = ((Boolean)paramParcel.readValue(null)).booleanValue();
    this.qQt = ((Boolean)paramParcel.readValue(null)).booleanValue();
  }
  
  public PatternLockView$SavedState(Parcelable paramParcelable, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    super(paramParcelable);
    this.qQN = paramString;
    this.qQO = paramInt;
    this.qQu = paramBoolean1;
    this.qQv = paramBoolean2;
    this.qQt = paramBoolean3;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.qQN);
    paramParcel.writeInt(this.qQO);
    paramParcel.writeValue(Boolean.valueOf(this.qQu));
    paramParcel.writeValue(Boolean.valueOf(this.qQv));
    paramParcel.writeValue(Boolean.valueOf(this.qQt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView.SavedState
 * JD-Core Version:    0.7.0.1
 */