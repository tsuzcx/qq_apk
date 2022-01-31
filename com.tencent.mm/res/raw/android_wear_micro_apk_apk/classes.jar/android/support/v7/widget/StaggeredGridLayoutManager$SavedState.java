package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

class StaggeredGridLayoutManager$SavedState
  implements Parcelable
{
  public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {};
  int sK;
  boolean sM;
  boolean sn;
  boolean vD;
  List<StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem> vP;
  int vT;
  int vU;
  int[] vV;
  int vW;
  int[] vX;
  
  public StaggeredGridLayoutManager$SavedState() {}
  
  StaggeredGridLayoutManager$SavedState(Parcel paramParcel)
  {
    this.sK = paramParcel.readInt();
    this.vT = paramParcel.readInt();
    this.vU = paramParcel.readInt();
    if (this.vU > 0)
    {
      this.vV = new int[this.vU];
      paramParcel.readIntArray(this.vV);
    }
    this.vW = paramParcel.readInt();
    if (this.vW > 0)
    {
      this.vX = new int[this.vW];
      paramParcel.readIntArray(this.vX);
    }
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.sn = bool1;
      if (paramParcel.readInt() != 1) {
        break label152;
      }
      bool1 = true;
      label113:
      this.sM = bool1;
      if (paramParcel.readInt() != 1) {
        break label157;
      }
    }
    label152:
    label157:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.vD = bool1;
      this.vP = paramParcel.readArrayList(StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.class.getClassLoader());
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label113;
    }
  }
  
  public StaggeredGridLayoutManager$SavedState(SavedState paramSavedState)
  {
    this.vU = paramSavedState.vU;
    this.sK = paramSavedState.sK;
    this.vT = paramSavedState.vT;
    this.vV = paramSavedState.vV;
    this.vW = paramSavedState.vW;
    this.vX = paramSavedState.vX;
    this.sn = paramSavedState.sn;
    this.sM = paramSavedState.sM;
    this.vD = paramSavedState.vD;
    this.vP = paramSavedState.vP;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeInt(this.sK);
    paramParcel.writeInt(this.vT);
    paramParcel.writeInt(this.vU);
    if (this.vU > 0) {
      paramParcel.writeIntArray(this.vV);
    }
    paramParcel.writeInt(this.vW);
    if (this.vW > 0) {
      paramParcel.writeIntArray(this.vX);
    }
    if (this.sn)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.sM) {
        break label120;
      }
      paramInt = 1;
      label87:
      paramParcel.writeInt(paramInt);
      if (!this.vD) {
        break label125;
      }
    }
    label120:
    label125:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeList(this.vP);
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