package com.google.android.gms.wearable.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class ah
  extends Binder
  implements ag
{
  public static ag n(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IChannelStreamCallbacks");
    if ((localIInterface != null) && ((localIInterface instanceof ag))) {
      return (ag)localIInterface;
    }
    return new ai(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.wearable.internal.IChannelStreamCallbacks");
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IChannelStreamCallbacks");
    ag(paramParcel1.readInt(), paramParcel1.readInt());
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.ah
 * JD-Core Version:    0.7.0.1
 */