package com.tencent.mm.plugin.walletlock.gesture.ui.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;
import com.tencent.matrix.trace.core.AppMethodBeat;

class PatternLockView$SavedState
  extends View.BaseSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR;
  boolean uFB;
  boolean uFC;
  boolean uFD;
  String uFV;
  int uFW;
  
  static
  {
    AppMethodBeat.i(51656);
    CREATOR = new PatternLockView.SavedState.1();
    AppMethodBeat.o(51656);
  }
  
  public PatternLockView$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(51654);
    this.uFV = paramParcel.readString();
    this.uFW = paramParcel.readInt();
    this.uFC = ((Boolean)paramParcel.readValue(null)).booleanValue();
    this.uFD = ((Boolean)paramParcel.readValue(null)).booleanValue();
    this.uFB = ((Boolean)paramParcel.readValue(null)).booleanValue();
    AppMethodBeat.o(51654);
  }
  
  public PatternLockView$SavedState(Parcelable paramParcelable, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    super(paramParcelable);
    this.uFV = paramString;
    this.uFW = paramInt;
    this.uFC = paramBoolean1;
    this.uFD = paramBoolean2;
    this.uFB = paramBoolean3;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(51655);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.uFV);
    paramParcel.writeInt(this.uFW);
    paramParcel.writeValue(Boolean.valueOf(this.uFC));
    paramParcel.writeValue(Boolean.valueOf(this.uFD));
    paramParcel.writeValue(Boolean.valueOf(this.uFB));
    AppMethodBeat.o(51655);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView.SavedState
 * JD-Core Version:    0.7.0.1
 */