package com.tencent.mm.ui.widget.progress;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

class MMProgressWheel$WheelSavedState
  extends View.BaseSavedState
{
  public static final Parcelable.Creator<WheelSavedState> CREATOR = new MMProgressWheel.WheelSavedState.1();
  float St;
  boolean wpA;
  float wpB;
  boolean wpC;
  int wpk;
  int wpl;
  int wpm;
  boolean wpn;
  int wpt;
  int wpu;
  float wpy;
  
  private MMProgressWheel$WheelSavedState(Parcel paramParcel)
  {
    super(paramParcel);
    this.St = paramParcel.readFloat();
    this.wpB = paramParcel.readFloat();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.wpC = bool1;
      this.wpy = paramParcel.readFloat();
      this.wpl = paramParcel.readInt();
      this.wpt = paramParcel.readInt();
      this.wpm = paramParcel.readInt();
      this.wpu = paramParcel.readInt();
      this.wpk = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label119;
      }
      bool1 = true;
      label94:
      this.wpA = bool1;
      if (paramParcel.readByte() == 0) {
        break label124;
      }
    }
    label119:
    label124:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.wpn = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label94;
    }
  }
  
  MMProgressWheel$WheelSavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.St);
    paramParcel.writeFloat(this.wpB);
    if (this.wpC)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeFloat(this.wpy);
      paramParcel.writeInt(this.wpl);
      paramParcel.writeInt(this.wpt);
      paramParcel.writeInt(this.wpm);
      paramParcel.writeInt(this.wpu);
      paramParcel.writeInt(this.wpk);
      if (!this.wpA) {
        break label123;
      }
      paramInt = 1;
      label96:
      paramParcel.writeByte((byte)paramInt);
      if (!this.wpn) {
        break label128;
      }
    }
    label128:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
      paramInt = 0;
      break;
      label123:
      paramInt = 0;
      break label96;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.widget.progress.MMProgressWheel.WheelSavedState
 * JD-Core Version:    0.7.0.1
 */