package com.tencent.mm.service;

import android.os.IBinder;
import android.os.Parcel;

final class c
  implements a
{
  private IBinder jN;
  
  c(IBinder paramIBinder)
  {
    this.jN = paramIBinder;
  }
  
  public final IBinder asBinder()
  {
    return this.jN;
  }
  
  public final void s(IBinder paramIBinder)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.service.IMMServiceConnectionStub_AIDL");
      localParcel1.writeStrongBinder(paramIBinder);
      this.jN.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.service.c
 * JD-Core Version:    0.7.0.1
 */