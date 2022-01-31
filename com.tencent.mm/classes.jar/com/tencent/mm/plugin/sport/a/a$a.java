package com.tencent.mm.plugin.sport.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class a$a
  extends Binder
  implements a
{
  public a$a()
  {
    attachInterface(this, "com.tencent.mm.plugin.sport.aidl.ISport_AIDL");
  }
  
  public static a B(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.plugin.sport.aidl.ISport_AIDL");
    if ((localIInterface != null) && ((localIInterface instanceof a))) {
      return (a)localIInterface;
    }
    return new a.a.a(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    long l;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.tencent.mm.plugin.sport.aidl.ISport_AIDL");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.sport.aidl.ISport_AIDL");
      l = bLd();
      paramParcel2.writeNoException();
      paramParcel2.writeLong(l);
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.sport.aidl.ISport_AIDL");
      Pu(paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.sport.aidl.ISport_AIDL");
      bLe();
      paramParcel2.writeNoException();
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.sport.aidl.ISport_AIDL");
      P(paramParcel1.readInt(), paramParcel1.readLong());
      paramParcel2.writeNoException();
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.sport.aidl.ISport_AIDL");
      l = getLong(paramParcel1.readInt(), paramParcel1.readLong());
      paramParcel2.writeNoException();
      paramParcel2.writeLong(l);
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mm.plugin.sport.aidl.ISport_AIDL");
    bLf();
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.a.a.a
 * JD-Core Version:    0.7.0.1
 */