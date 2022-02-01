package com.tencent.mm.ui.gridviewheaders;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;
import com.tencent.matrix.trace.core.AppMethodBeat;

class GridHeadersGridView$SavedState
  extends View.BaseSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR;
  boolean QkO;
  
  static
  {
    AppMethodBeat.i(142803);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(142803);
  }
  
  private GridHeadersGridView$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(142800);
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.QkO = bool;
      AppMethodBeat.o(142800);
      return;
    }
  }
  
  public GridHeadersGridView$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public String toString()
  {
    AppMethodBeat.i(142801);
    String str = "StickyGridHeadersGridView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " areHeadersSticky=" + this.QkO + "}";
    AppMethodBeat.o(142801);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(142802);
    super.writeToParcel(paramParcel, paramInt);
    if (this.QkO) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      AppMethodBeat.o(142802);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.gridviewheaders.GridHeadersGridView.SavedState
 * JD-Core Version:    0.7.0.1
 */