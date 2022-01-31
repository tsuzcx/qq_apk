package com.tencent.mm.ui.widget.progress;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;
import com.tencent.matrix.trace.core.AppMethodBeat;

class MMProgressWheel$WheelSavedState
  extends View.BaseSavedState
{
  public static final Parcelable.Creator<WheelSavedState> CREATOR;
  int AJL;
  int AJM;
  boolean AJN;
  int AJT;
  int AJU;
  float AJY;
  boolean AKa;
  float AKb;
  boolean AKc;
  float Tb;
  int circleRadius;
  
  static
  {
    AppMethodBeat.i(112939);
    CREATOR = new MMProgressWheel.WheelSavedState.1();
    AppMethodBeat.o(112939);
  }
  
  private MMProgressWheel$WheelSavedState(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(112937);
    this.Tb = paramParcel.readFloat();
    this.AKb = paramParcel.readFloat();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.AKc = bool1;
      this.AJY = paramParcel.readFloat();
      this.AJL = paramParcel.readInt();
      this.AJT = paramParcel.readInt();
      this.AJM = paramParcel.readInt();
      this.AJU = paramParcel.readInt();
      this.circleRadius = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label129;
      }
      bool1 = true;
      label99:
      this.AKa = bool1;
      if (paramParcel.readByte() == 0) {
        break label134;
      }
    }
    label129:
    label134:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.AJN = bool1;
      AppMethodBeat.o(112937);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label99;
    }
  }
  
  MMProgressWheel$WheelSavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(112938);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.Tb);
    paramParcel.writeFloat(this.AKb);
    if (this.AKc)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeFloat(this.AJY);
      paramParcel.writeInt(this.AJL);
      paramParcel.writeInt(this.AJT);
      paramParcel.writeInt(this.AJM);
      paramParcel.writeInt(this.AJU);
      paramParcel.writeInt(this.circleRadius);
      if (!this.AKa) {
        break label133;
      }
      paramInt = 1;
      label101:
      paramParcel.writeByte((byte)paramInt);
      if (!this.AJN) {
        break label138;
      }
    }
    label133:
    label138:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      AppMethodBeat.o(112938);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label101;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.widget.progress.MMProgressWheel.WheelSavedState
 * JD-Core Version:    0.7.0.1
 */