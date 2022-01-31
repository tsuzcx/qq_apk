package com.tencent.mm.ui.widget.picker;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;
import com.tencent.matrix.trace.core.AppMethodBeat;

class YADatePicker$SavedState
  extends View.BaseSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR;
  private final int mDay;
  private final int mMonth;
  private final int mYear;
  
  static
  {
    AppMethodBeat.i(112908);
    CREATOR = new YADatePicker.SavedState.1();
    AppMethodBeat.o(112908);
  }
  
  private YADatePicker$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(112906);
    this.mYear = paramParcel.readInt();
    this.mMonth = paramParcel.readInt();
    this.mDay = paramParcel.readInt();
    AppMethodBeat.o(112906);
  }
  
  private YADatePicker$SavedState(Parcelable paramParcelable, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramParcelable);
    this.mYear = paramInt1;
    this.mMonth = paramInt2;
    this.mDay = paramInt3;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(112907);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.mYear);
    paramParcel.writeInt(this.mMonth);
    paramParcel.writeInt(this.mDay);
    AppMethodBeat.o(112907);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.YADatePicker.SavedState
 * JD-Core Version:    0.7.0.1
 */