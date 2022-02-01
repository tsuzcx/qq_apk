package com.tencent.mm.service;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class e
  extends Binder
  implements d
{
  public e()
  {
    attachInterface(this, "com.tencent.mm.service.IMMServiceStub_AIDL");
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    IInterface localIInterface = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.tencent.mm.service.IMMServiceStub_AIDL");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.mm.service.IMMServiceStub_AIDL");
      Intent localIntent;
      if (paramParcel1.readInt() != 0)
      {
        localIntent = (Intent)Intent.CREATOR.createFromParcel(paramParcel1);
        paramParcel1 = paramParcel1.readStrongBinder();
        if (paramParcel1 != null) {
          break label132;
        }
        paramParcel1 = localIInterface;
      }
      for (;;)
      {
        a(localIntent, paramParcel1);
        paramParcel2.writeNoException();
        return true;
        localIntent = null;
        break;
        localIInterface = paramParcel1.queryLocalInterface("com.tencent.mm.service.IMMServiceConnectionStub_AIDL");
        if ((localIInterface != null) && ((localIInterface instanceof a))) {
          paramParcel1 = (a)localIInterface;
        } else {
          paramParcel1 = new c(paramParcel1);
        }
      }
    case 2: 
      paramParcel1.enforceInterface("com.tencent.mm.service.IMMServiceStub_AIDL");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (Intent)Intent.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a(paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 3: 
      label132:
      paramParcel1.enforceInterface("com.tencent.mm.service.IMMServiceStub_AIDL");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (Intent)Intent.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        startService(paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    }
    paramParcel1.enforceInterface("com.tencent.mm.service.IMMServiceStub_AIDL");
    if (paramParcel1.readInt() != 0) {}
    for (paramParcel1 = (Intent)Intent.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
    {
      b(paramParcel1);
      paramParcel2.writeNoException();
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.service.e
 * JD-Core Version:    0.7.0.1
 */