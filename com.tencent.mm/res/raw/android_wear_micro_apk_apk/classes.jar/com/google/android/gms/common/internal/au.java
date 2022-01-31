package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class au
  extends Binder
  implements at
{
  public static at g(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
    if ((localIInterface != null) && ((localIInterface instanceof at))) {
      return (at)localIInterface;
    }
    return new av(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    if (paramInt1 > 16777215) {
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    }
    paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
    Object localObject = paramParcel1.readStrongBinder();
    if (localObject == null)
    {
      localObject = null;
      if (paramInt1 != 46) {
        break label123;
      }
      if (paramParcel1.readInt() == 0) {
        break label540;
      }
    }
    label540:
    for (paramParcel1 = (zzj)zzj.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
    {
      a((aq)localObject, paramParcel1);
      paramParcel2.writeNoException();
      return true;
      IInterface localIInterface = ((IBinder)localObject).queryLocalInterface("com.google.android.gms.common.internal.IGmsCallbacks");
      if ((localIInterface != null) && ((localIInterface instanceof aq)))
      {
        localObject = (aq)localIInterface;
        break;
      }
      localObject = new as((IBinder)localObject);
      break;
      label123:
      if (paramInt1 == 47)
      {
        if (paramParcel1.readInt() != 0) {
          zzan.CREATOR.createFromParcel(paramParcel1);
        }
        throw new UnsupportedOperationException();
      }
      paramParcel1.readInt();
      if (paramInt1 != 4) {
        paramParcel1.readString();
      }
      switch (paramInt1)
      {
      }
      for (;;)
      {
        throw new UnsupportedOperationException();
        paramParcel1.readStrongBinder();
        if (paramParcel1.readInt() != 0)
        {
          Bundle.CREATOR.createFromParcel(paramParcel1);
          continue;
          paramParcel1.readString();
          paramParcel1.createStringArray();
          paramParcel1.readString();
          if (paramParcel1.readInt() != 0)
          {
            Bundle.CREATOR.createFromParcel(paramParcel1);
            continue;
            paramParcel1.readString();
            paramParcel1.createStringArray();
            paramParcel1.readString();
            paramParcel1.readStrongBinder();
            paramParcel1.readString();
            if (paramParcel1.readInt() != 0)
            {
              Bundle.CREATOR.createFromParcel(paramParcel1);
              continue;
              paramParcel1.createStringArray();
              paramParcel1.readString();
              if (paramParcel1.readInt() != 0)
              {
                Bundle.CREATOR.createFromParcel(paramParcel1);
                continue;
                paramParcel1.readString();
                paramParcel1.createStringArray();
                continue;
                paramParcel1.readString();
                continue;
                if (paramParcel1.readInt() != 0) {
                  Bundle.CREATOR.createFromParcel(paramParcel1);
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.au
 * JD-Core Version:    0.7.0.1
 */