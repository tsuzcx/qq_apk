package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

class StaggeredGridLayoutManager$SavedState
  implements Parcelable
{
  public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {};
  int uA;
  boolean uC;
  boolean ud;
  List<StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem> xE;
  int xI;
  int xJ;
  int[] xK;
  int xL;
  int[] xM;
  boolean xs;
  
  public StaggeredGridLayoutManager$SavedState() {}
  
  StaggeredGridLayoutManager$SavedState(Parcel paramParcel)
  {
    this.uA = paramParcel.readInt();
    this.xI = paramParcel.readInt();
    this.xJ = paramParcel.readInt();
    if (this.xJ > 0)
    {
      this.xK = new int[this.xJ];
      paramParcel.readIntArray(this.xK);
    }
    this.xL = paramParcel.readInt();
    if (this.xL > 0)
    {
      this.xM = new int[this.xL];
      paramParcel.readIntArray(this.xM);
    }
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.ud = bool1;
      if (paramParcel.readInt() != 1) {
        break label152;
      }
      bool1 = true;
      label113:
      this.uC = bool1;
      if (paramParcel.readInt() != 1) {
        break label157;
      }
    }
    label152:
    label157:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.xs = bool1;
      this.xE = paramParcel.readArrayList(StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.class.getClassLoader());
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label113;
    }
  }
  
  public StaggeredGridLayoutManager$SavedState(SavedState paramSavedState)
  {
    this.xJ = paramSavedState.xJ;
    this.uA = paramSavedState.uA;
    this.xI = paramSavedState.xI;
    this.xK = paramSavedState.xK;
    this.xL = paramSavedState.xL;
    this.xM = paramSavedState.xM;
    this.ud = paramSavedState.ud;
    this.uC = paramSavedState.uC;
    this.xs = paramSavedState.xs;
    this.xE = paramSavedState.xE;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeInt(this.uA);
    paramParcel.writeInt(this.xI);
    paramParcel.writeInt(this.xJ);
    if (this.xJ > 0) {
      paramParcel.writeIntArray(this.xK);
    }
    paramParcel.writeInt(this.xL);
    if (this.xL > 0) {
      paramParcel.writeIntArray(this.xM);
    }
    if (this.ud)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.uC) {
        break label120;
      }
      paramInt = 1;
      label87:
      paramParcel.writeInt(paramInt);
      if (!this.xs) {
        break label125;
      }
    }
    label120:
    label125:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeList(this.xE);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label87;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.StaggeredGridLayoutManager.SavedState
 * JD-Core Version:    0.7.0.1
 */