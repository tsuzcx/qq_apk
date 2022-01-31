package com.tencent.mm.plugin.talkroom.component;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class d$a
  extends Binder
  implements d
{
  public d$a()
  {
    attachInterface(this, "com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
  }
  
  public static d C(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
    if ((localIInterface != null) && ((localIInterface instanceof d))) {
      return (d)localIInterface;
    }
    return new d.a.a(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
      cHp();
      paramParcel2.writeNoException();
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
      akP();
      paramParcel2.writeNoException();
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
      release();
      paramParcel2.writeNoException();
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
      paramInt1 = cHq();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
    start();
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.component.d.a
 * JD-Core Version:    0.7.0.1
 */