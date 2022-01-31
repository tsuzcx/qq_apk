package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.a.a;
import com.google.android.gms.a.b;

public abstract class ba
  extends Binder
  implements az
{
  public static az i(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
    if ((localIInterface != null) && ((localIInterface instanceof az))) {
      return (az)localIInterface;
    }
    return new bb(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Object localObject = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.common.internal.ISignInButtonCreator");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
      paramParcel1 = a(b.j(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      if (paramParcel1 != null) {}
      for (paramParcel1 = paramParcel1.asBinder();; paramParcel1 = null)
      {
        paramParcel2.writeStrongBinder(paramParcel1);
        return true;
      }
    }
    paramParcel1.enforceInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
    a locala = b.j(paramParcel1.readStrongBinder());
    if (paramParcel1.readInt() != 0) {}
    for (paramParcel1 = (zzah)zzah.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
    {
      locala = a(locala, paramParcel1);
      paramParcel2.writeNoException();
      paramParcel1 = localObject;
      if (locala != null) {
        paramParcel1 = locala.asBinder();
      }
      paramParcel2.writeStrongBinder(paramParcel1);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.ba
 * JD-Core Version:    0.7.0.1
 */