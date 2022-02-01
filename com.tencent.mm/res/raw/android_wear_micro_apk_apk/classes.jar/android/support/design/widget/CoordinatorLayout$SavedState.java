package android.support.design.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.v4.view.AbsSavedState;
import android.util.SparseArray;

public class CoordinatorLayout$SavedState
  extends AbsSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator() {};
  SparseArray<Parcelable> bv;
  
  public CoordinatorLayout$SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    super(paramParcel, paramClassLoader);
    int j = paramParcel.readInt();
    int[] arrayOfInt = new int[j];
    paramParcel.readIntArray(arrayOfInt);
    paramParcel = paramParcel.readParcelableArray(paramClassLoader);
    this.bv = new SparseArray(j);
    int i = 0;
    while (i < j)
    {
      this.bv.append(arrayOfInt[i], paramParcel[i]);
      i += 1;
    }
  }
  
  public CoordinatorLayout$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = 0;
    super.writeToParcel(paramParcel, paramInt);
    if (this.bv != null) {}
    int[] arrayOfInt;
    Parcelable[] arrayOfParcelable;
    for (int i = this.bv.size();; i = 0)
    {
      paramParcel.writeInt(i);
      arrayOfInt = new int[i];
      arrayOfParcelable = new Parcelable[i];
      while (j < i)
      {
        arrayOfInt[j] = this.bv.keyAt(j);
        arrayOfParcelable[j] = ((Parcelable)this.bv.valueAt(j));
        j += 1;
      }
    }
    paramParcel.writeIntArray(arrayOfInt);
    paramParcel.writeParcelableArray(arrayOfParcelable, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.design.widget.CoordinatorLayout.SavedState
 * JD-Core Version:    0.7.0.1
 */