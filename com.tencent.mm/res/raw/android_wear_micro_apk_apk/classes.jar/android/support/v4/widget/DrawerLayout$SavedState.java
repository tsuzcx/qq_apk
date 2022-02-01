package android.support.v4.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.v4.view.AbsSavedState;

public class DrawerLayout$SavedState
  extends AbsSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator() {};
  int qC = 0;
  int qD;
  int qE;
  int qF;
  int qG;
  
  public DrawerLayout$SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    super(paramParcel, paramClassLoader);
    this.qC = paramParcel.readInt();
    this.qD = paramParcel.readInt();
    this.qE = paramParcel.readInt();
    this.qF = paramParcel.readInt();
    this.qG = paramParcel.readInt();
  }
  
  public DrawerLayout$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.qC);
    paramParcel.writeInt(this.qD);
    paramParcel.writeInt(this.qE);
    paramParcel.writeInt(this.qF);
    paramParcel.writeInt(this.qG);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.widget.DrawerLayout.SavedState
 * JD-Core Version:    0.7.0.1
 */