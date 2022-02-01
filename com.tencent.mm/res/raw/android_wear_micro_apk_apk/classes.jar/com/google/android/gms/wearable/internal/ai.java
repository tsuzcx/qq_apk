package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;

final class ai
  implements ag
{
  private IBinder Mt;
  
  ai(IBinder paramIBinder)
  {
    this.Mt = paramIBinder;
  }
  
  public final void ag(int paramInt1, int paramInt2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IChannelStreamCallbacks");
      localParcel1.writeInt(paramInt1);
      localParcel1.writeInt(paramInt2);
      this.Mt.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public final IBinder asBinder()
  {
    return this.Mt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.ai
 * JD-Core Version:    0.7.0.1
 */