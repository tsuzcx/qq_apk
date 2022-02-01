package com.tencent.mm.service;

import android.os.Binder;
import android.os.Parcel;

public abstract class b
  extends Binder
  implements a
{
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.tencent.mm.service.IMMServiceConnectionStub_AIDL");
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mm.service.IMMServiceConnectionStub_AIDL");
    s(paramParcel1.readStrongBinder());
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.service.b
 * JD-Core Version:    0.7.0.1
 */