package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import java.util.ArrayList;

final class BackStackState
  implements Parcelable
{
  public static final Parcelable.Creator<BackStackState> CREATOR = new Parcelable.Creator() {};
  final int bG;
  final int bH;
  final int bL;
  final int bM;
  final CharSequence bN;
  final int bO;
  final CharSequence bP;
  final ArrayList<String> bQ;
  final ArrayList<String> bR;
  final boolean bS;
  final int[] ca;
  final String mName;
  
  public BackStackState(Parcel paramParcel)
  {
    this.ca = paramParcel.createIntArray();
    this.bG = paramParcel.readInt();
    this.bH = paramParcel.readInt();
    this.mName = paramParcel.readString();
    this.bL = paramParcel.readInt();
    this.bM = paramParcel.readInt();
    this.bN = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.bO = paramParcel.readInt();
    this.bP = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.bQ = paramParcel.createStringArrayList();
    this.bR = paramParcel.createStringArrayList();
    if (paramParcel.readInt() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.bS = bool;
      return;
    }
  }
  
  public BackStackState(e parame)
  {
    int k = parame.bB.size();
    this.ca = new int[k * 6];
    if (!parame.bI) {
      throw new IllegalStateException("Not on back stack");
    }
    int i = 0;
    int j = 0;
    if (i < k)
    {
      f localf = (f)parame.bB.get(i);
      int[] arrayOfInt = this.ca;
      int m = j + 1;
      arrayOfInt[j] = localf.bU;
      arrayOfInt = this.ca;
      int n = m + 1;
      if (localf.bV != null) {}
      for (j = localf.bV.bL;; j = -1)
      {
        arrayOfInt[m] = j;
        arrayOfInt = this.ca;
        j = n + 1;
        arrayOfInt[n] = localf.bW;
        arrayOfInt = this.ca;
        m = j + 1;
        arrayOfInt[j] = localf.bX;
        arrayOfInt = this.ca;
        n = m + 1;
        arrayOfInt[m] = localf.bY;
        arrayOfInt = this.ca;
        j = n + 1;
        arrayOfInt[n] = localf.bZ;
        i += 1;
        break;
      }
    }
    this.bG = parame.bG;
    this.bH = parame.bH;
    this.mName = parame.mName;
    this.bL = parame.bL;
    this.bM = parame.bM;
    this.bN = parame.bN;
    this.bO = parame.bO;
    this.bP = parame.bP;
    this.bQ = parame.bQ;
    this.bR = parame.bR;
    this.bS = parame.bS;
  }
  
  public final e a(u paramu)
  {
    e locale = new e(paramu);
    int i = 0;
    int j = 0;
    if (j < this.ca.length)
    {
      f localf = new f();
      int[] arrayOfInt = this.ca;
      int k = j + 1;
      localf.bU = arrayOfInt[j];
      if (u.DEBUG) {
        Log.v("FragmentManager", "Instantiate " + locale + " op #" + i + " base fragment #" + this.ca[k]);
      }
      arrayOfInt = this.ca;
      j = k + 1;
      k = arrayOfInt[k];
      if (k >= 0) {}
      for (localf.bV = ((Fragment)paramu.ea.get(k));; localf.bV = null)
      {
        arrayOfInt = this.ca;
        k = j + 1;
        localf.bW = arrayOfInt[j];
        arrayOfInt = this.ca;
        j = k + 1;
        localf.bX = arrayOfInt[k];
        arrayOfInt = this.ca;
        k = j + 1;
        localf.bY = arrayOfInt[j];
        arrayOfInt = this.ca;
        j = k + 1;
        localf.bZ = arrayOfInt[k];
        locale.bC = localf.bW;
        locale.bD = localf.bX;
        locale.bE = localf.bY;
        locale.bF = localf.bZ;
        locale.a(localf);
        i += 1;
        break;
      }
    }
    locale.bG = this.bG;
    locale.bH = this.bH;
    locale.mName = this.mName;
    locale.bL = this.bL;
    locale.bI = true;
    locale.bM = this.bM;
    locale.bN = this.bN;
    locale.bO = this.bO;
    locale.bP = this.bP;
    locale.bQ = this.bQ;
    locale.bR = this.bR;
    locale.bS = this.bS;
    locale.k(1);
    return locale;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = 0;
    paramParcel.writeIntArray(this.ca);
    paramParcel.writeInt(this.bG);
    paramParcel.writeInt(this.bH);
    paramParcel.writeString(this.mName);
    paramParcel.writeInt(this.bL);
    paramParcel.writeInt(this.bM);
    TextUtils.writeToParcel(this.bN, paramParcel, 0);
    paramParcel.writeInt(this.bO);
    TextUtils.writeToParcel(this.bP, paramParcel, 0);
    paramParcel.writeStringList(this.bQ);
    paramParcel.writeStringList(this.bR);
    if (this.bS) {
      paramInt = 1;
    }
    paramParcel.writeInt(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.BackStackState
 * JD-Core Version:    0.7.0.1
 */