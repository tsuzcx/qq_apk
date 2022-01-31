package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class ar
  extends Binder
  implements aq
{
  public ar()
  {
    attachInterface(this, "com.google.android.gms.common.internal.IGmsCallbacks");
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    IBinder localIBinder = null;
    Object localObject = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.common.internal.IGmsCallbacks");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsCallbacks");
      paramInt1 = paramParcel1.readInt();
      localIBinder = paramParcel1.readStrongBinder();
      if (paramParcel1.readInt() != 0) {
        localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      a(paramInt1, localIBinder, (Bundle)localObject);
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsCallbacks");
    paramInt1 = paramParcel1.readInt();
    localObject = localIBinder;
    if (paramParcel1.readInt() != 0) {
      localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
    }
    b(paramInt1, (Bundle)localObject);
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.ar
 * JD-Core Version:    0.7.0.1
 */