package com.google.android.gms.iid;

import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;

public class MessengerCompat
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<MessengerCompat> CREATOR = new Parcelable.Creator() {};
  Messenger NK;
  a NL;
  
  public MessengerCompat(IBinder paramIBinder)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.NK = new Messenger(paramIBinder);
      return;
    }
    this.NL = b.k(paramIBinder);
  }
  
  private IBinder getBinder()
  {
    if (this.NK != null) {
      return this.NK.getBinder();
    }
    return this.NL.asBinder();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    try
    {
      boolean bool = getBinder().equals(((MessengerCompat)paramObject).getBinder());
      return bool;
    }
    catch (ClassCastException paramObject) {}
    return false;
  }
  
  public int hashCode()
  {
    return getBinder().hashCode();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.NK != null)
    {
      paramParcel.writeStrongBinder(this.NK.getBinder());
      return;
    }
    paramParcel.writeStrongBinder(this.NL.asBinder());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.iid.MessengerCompat
 * JD-Core Version:    0.7.0.1
 */