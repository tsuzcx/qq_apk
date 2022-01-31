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
  final int X;
  final int Y;
  final int ac;
  final int ad;
  final CharSequence ae;
  final int af;
  final CharSequence ag;
  final ArrayList<String> ah;
  final ArrayList<String> ai;
  final boolean aj;
  final int[] ar;
  final String mName;
  
  public BackStackState(Parcel paramParcel)
  {
    this.ar = paramParcel.createIntArray();
    this.X = paramParcel.readInt();
    this.Y = paramParcel.readInt();
    this.mName = paramParcel.readString();
    this.ac = paramParcel.readInt();
    this.ad = paramParcel.readInt();
    this.ae = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.af = paramParcel.readInt();
    this.ag = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.ah = paramParcel.createStringArrayList();
    this.ai = paramParcel.createStringArrayList();
    if (paramParcel.readInt() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.aj = bool;
      return;
    }
  }
  
  public BackStackState(d paramd)
  {
    int k = paramd.S.size();
    this.ar = new int[k * 6];
    if (!paramd.Z) {
      throw new IllegalStateException("Not on back stack");
    }
    int i = 0;
    int j = 0;
    if (i < k)
    {
      e locale = (e)paramd.S.get(i);
      int[] arrayOfInt = this.ar;
      int m = j + 1;
      arrayOfInt[j] = locale.al;
      arrayOfInt = this.ar;
      int n = m + 1;
      if (locale.am != null) {}
      for (j = locale.am.ac;; j = -1)
      {
        arrayOfInt[m] = j;
        arrayOfInt = this.ar;
        j = n + 1;
        arrayOfInt[n] = locale.an;
        arrayOfInt = this.ar;
        m = j + 1;
        arrayOfInt[j] = locale.ao;
        arrayOfInt = this.ar;
        n = m + 1;
        arrayOfInt[m] = locale.ap;
        arrayOfInt = this.ar;
        j = n + 1;
        arrayOfInt[n] = locale.aq;
        i += 1;
        break;
      }
    }
    this.X = paramd.X;
    this.Y = paramd.Y;
    this.mName = paramd.mName;
    this.ac = paramd.ac;
    this.ad = paramd.ad;
    this.ae = paramd.ae;
    this.af = paramd.af;
    this.ag = paramd.ag;
    this.ah = paramd.ah;
    this.ai = paramd.ai;
    this.aj = paramd.aj;
  }
  
  public final d a(t paramt)
  {
    d locald = new d(paramt);
    int i = 0;
    int j = 0;
    if (j < this.ar.length)
    {
      e locale = new e();
      int[] arrayOfInt = this.ar;
      int k = j + 1;
      locale.al = arrayOfInt[j];
      if (t.DEBUG) {
        Log.v("FragmentManager", "Instantiate " + locald + " op #" + i + " base fragment #" + this.ar[k]);
      }
      arrayOfInt = this.ar;
      j = k + 1;
      k = arrayOfInt[k];
      if (k >= 0) {}
      for (locale.am = ((Fragment)paramt.cr.get(k));; locale.am = null)
      {
        arrayOfInt = this.ar;
        k = j + 1;
        locale.an = arrayOfInt[j];
        arrayOfInt = this.ar;
        j = k + 1;
        locale.ao = arrayOfInt[k];
        arrayOfInt = this.ar;
        k = j + 1;
        locale.ap = arrayOfInt[j];
        arrayOfInt = this.ar;
        j = k + 1;
        locale.aq = arrayOfInt[k];
        locald.T = locale.an;
        locald.U = locale.ao;
        locald.V = locale.ap;
        locald.W = locale.aq;
        locald.a(locale);
        i += 1;
        break;
      }
    }
    locald.X = this.X;
    locald.Y = this.Y;
    locald.mName = this.mName;
    locald.ac = this.ac;
    locald.Z = true;
    locald.ad = this.ad;
    locald.ae = this.ae;
    locald.af = this.af;
    locald.ag = this.ag;
    locald.ah = this.ah;
    locald.ai = this.ai;
    locald.aj = this.aj;
    locald.b(1);
    return locald;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = 0;
    paramParcel.writeIntArray(this.ar);
    paramParcel.writeInt(this.X);
    paramParcel.writeInt(this.Y);
    paramParcel.writeString(this.mName);
    paramParcel.writeInt(this.ac);
    paramParcel.writeInt(this.ad);
    TextUtils.writeToParcel(this.ae, paramParcel, 0);
    paramParcel.writeInt(this.af);
    TextUtils.writeToParcel(this.ag, paramParcel, 0);
    paramParcel.writeStringList(this.ah);
    paramParcel.writeStringList(this.ai);
    if (this.aj) {
      paramInt = 1;
    }
    paramParcel.writeInt(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.BackStackState
 * JD-Core Version:    0.7.0.1
 */