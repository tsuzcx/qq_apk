package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;

class StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem
  implements Parcelable
{
  public static final Parcelable.Creator<FullSpanItem> CREATOR = new Parcelable.Creator() {};
  int un;
  int xF;
  int[] xG;
  boolean xH;
  
  public StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem() {}
  
  public StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem(Parcel paramParcel)
  {
    this.un = paramParcel.readInt();
    this.xF = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.xH = bool;
      int i = paramParcel.readInt();
      if (i > 0)
      {
        this.xG = new int[i];
        paramParcel.readIntArray(this.xG);
      }
      return;
      bool = false;
    }
  }
  
  final int bb(int paramInt)
  {
    if (this.xG == null) {
      return 0;
    }
    return this.xG[paramInt];
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "FullSpanItem{mPosition=" + this.un + ", mGapDir=" + this.xF + ", mHasUnwantedGapAfter=" + this.xH + ", mGapPerSpan=" + Arrays.toString(this.xG) + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.un);
    paramParcel.writeInt(this.xF);
    if (this.xH) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      if ((this.xG == null) || (this.xG.length <= 0)) {
        break;
      }
      paramParcel.writeInt(this.xG.length);
      paramParcel.writeIntArray(this.xG);
      return;
    }
    paramParcel.writeInt(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem
 * JD-Core Version:    0.7.0.1
 */