package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class FragmentState
  implements Parcelable
{
  public static final Parcelable.Creator<FragmentState> CREATOR = new Parcelable.Creator() {};
  Bundle aK;
  final Bundle aN;
  final boolean aT;
  final int ac;
  final int bd;
  final int be;
  final String bf;
  final boolean bg;
  final boolean bh;
  final boolean bi;
  final String dp;
  Fragment dq;
  
  public FragmentState(Parcel paramParcel)
  {
    this.dp = paramParcel.readString();
    this.ac = paramParcel.readInt();
    if (paramParcel.readInt() != 0)
    {
      bool1 = true;
      this.aT = bool1;
      this.bd = paramParcel.readInt();
      this.be = paramParcel.readInt();
      this.bf = paramParcel.readString();
      if (paramParcel.readInt() == 0) {
        break label124;
      }
      bool1 = true;
      label69:
      this.bi = bool1;
      if (paramParcel.readInt() == 0) {
        break label129;
      }
      bool1 = true;
      label83:
      this.bh = bool1;
      this.aN = paramParcel.readBundle();
      if (paramParcel.readInt() == 0) {
        break label134;
      }
    }
    label129:
    label134:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.bg = bool1;
      this.aK = paramParcel.readBundle();
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
  
  public FragmentState(Fragment paramFragment)
  {
    this.dp = paramFragment.getClass().getName();
    this.ac = paramFragment.ac;
    this.aT = paramFragment.aT;
    this.bd = paramFragment.bd;
    this.be = paramFragment.be;
    this.bf = paramFragment.bf;
    this.bi = paramFragment.bi;
    this.bh = paramFragment.bh;
    this.aN = paramFragment.aN;
    this.bg = paramFragment.bg;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(this.dp);
    paramParcel.writeInt(this.ac);
    if (this.aT)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.bd);
      paramParcel.writeInt(this.be);
      paramParcel.writeString(this.bf);
      if (!this.bi) {
        break label120;
      }
      paramInt = 1;
      label65:
      paramParcel.writeInt(paramInt);
      if (!this.bh) {
        break label125;
      }
      paramInt = 1;
      label79:
      paramParcel.writeInt(paramInt);
      paramParcel.writeBundle(this.aN);
      if (!this.bg) {
        break label130;
      }
    }
    label130:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeBundle(this.aK);
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