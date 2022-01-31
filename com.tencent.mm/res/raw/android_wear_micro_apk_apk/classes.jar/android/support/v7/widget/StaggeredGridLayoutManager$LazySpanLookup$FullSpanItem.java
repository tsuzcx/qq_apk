package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;

class StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem
  implements Parcelable
{
  public static final Parcelable.Creator<FullSpanItem> CREATOR = new Parcelable.Creator() {};
  int sx;
  int vQ;
  int[] vR;
  boolean vS;
  
  public StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem() {}
  
  public StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem(Parcel paramParcel)
  {
    this.sx = paramParcel.readInt();
    this.vQ = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.vS = bool;
      int i = paramParcel.readInt();
      if (i > 0)
      {
        this.vR = new int[i];
        paramParcel.readIntArray(this.vR);
      }
      return;
      bool = false;
    }
  }
  
  final int aH(int paramInt)
  {
    if (this.vR == null) {
      return 0;
    }
    return this.vR[paramInt];
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "FullSpanItem{mPosition=" + this.sx + ", mGapDir=" + this.vQ + ", mHasUnwantedGapAfter=" + this.vS + ", mGapPerSpan=" + Arrays.toString(this.vR) + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.sx);
    paramParcel.writeInt(this.vQ);
    if (this.vS) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      if ((this.vR == null) || (this.vR.length <= 0)) {
        break;
      }
      paramParcel.writeInt(this.vR.length);
      paramParcel.writeIntArray(this.vR);
      return;
    }
    paramParcel.writeInt(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem
 * JD-Core Version:    0.7.0.1
 */