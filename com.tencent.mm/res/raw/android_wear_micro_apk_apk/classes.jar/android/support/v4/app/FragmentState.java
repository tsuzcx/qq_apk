package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class FragmentState
  implements Parcelable
{
  public static final Parcelable.Creator<FragmentState> CREATOR = new Parcelable.Creator() {};
  final int bL;
  final boolean cD;
  final int cO;
  final int cP;
  final String cQ;
  final boolean cR;
  final boolean cS;
  final boolean cT;
  Bundle ct;
  final Bundle cx;
  final String fe;
  Fragment ff;
  
  FragmentState(Parcel paramParcel)
  {
    this.fe = paramParcel.readString();
    this.bL = paramParcel.readInt();
    if (paramParcel.readInt() != 0)
    {
      bool1 = true;
      this.cD = bool1;
      this.cO = paramParcel.readInt();
      this.cP = paramParcel.readInt();
      this.cQ = paramParcel.readString();
      if (paramParcel.readInt() == 0) {
        break label124;
      }
      bool1 = true;
      label69:
      this.cT = bool1;
      if (paramParcel.readInt() == 0) {
        break label129;
      }
      bool1 = true;
      label83:
      this.cS = bool1;
      this.cx = paramParcel.readBundle();
      if (paramParcel.readInt() == 0) {
        break label134;
      }
    }
    label129:
    label134:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.cR = bool1;
      this.ct = paramParcel.readBundle();
      return;
      bool1 = false;
      break;
      label124:
      bool1 = false;
      break label69;
      bool1 = false;
      break label83;
    }
  }
  
  FragmentState(Fragment paramFragment)
  {
    this.fe = paramFragment.getClass().getName();
    this.bL = paramFragment.bL;
    this.cD = paramFragment.cD;
    this.cO = paramFragment.cO;
    this.cP = paramFragment.cP;
    this.cQ = paramFragment.cQ;
    this.cT = paramFragment.cT;
    this.cS = paramFragment.cS;
    this.cx = paramFragment.cx;
    this.cR = paramFragment.cR;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(this.fe);
    paramParcel.writeInt(this.bL);
    if (this.cD)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.cO);
      paramParcel.writeInt(this.cP);
      paramParcel.writeString(this.cQ);
      if (!this.cT) {
        break label120;
      }
      paramInt = 1;
      label65:
      paramParcel.writeInt(paramInt);
      if (!this.cS) {
        break label125;
      }
      paramInt = 1;
      label79:
      paramParcel.writeInt(paramInt);
      paramParcel.writeBundle(this.cx);
      if (!this.cR) {
        break label130;
      }
    }
    label130:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeBundle(this.ct);
      return;
      paramInt = 0;
      break;
      label120:
      paramInt = 0;
      break label65;
      label125:
      paramInt = 0;
      break label79;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.FragmentState
 * JD-Core Version:    0.7.0.1
 */