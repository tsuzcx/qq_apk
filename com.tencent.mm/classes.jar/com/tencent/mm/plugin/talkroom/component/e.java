package com.tencent.mm.plugin.talkroom.component;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract interface e
  extends IInterface
{
  public abstract int cHq();
  
  public abstract void crn();
  
  public abstract void ctY();
  
  public abstract void release();
  
  public abstract void start();
  
  public static abstract class a
    extends Binder
    implements e
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.plugin.talkroom.component.ITalkRoomPlayer_AIDL");
    }
    
    public static e D(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.plugin.talkroom.component.ITalkRoomPlayer_AIDL");
      if ((localIInterface != null) && ((localIInterface instanceof e))) {
        return (e)localIInterface;
      }
      return new e.a.a(paramIBinder);
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
        paramParcel2.writeString("com.tencent.mm.plugin.talkroom.component.ITalkRoomPlayer_AIDL");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.talkroom.component.ITalkRoomPlayer_AIDL");
        crn();
        paramParcel2.writeNoException();
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.talkroom.component.ITalkRoomPlayer_AIDL");
        ctY();
        paramParcel2.writeNoException();
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.talkroom.component.ITalkRoomPlayer_AIDL");
        release();
        paramParcel2.writeNoException();
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.talkroom.component.ITalkRoomPlayer_AIDL");
        paramInt1 = cHq();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mm.plugin.talkroom.component.ITalkRoomPlayer_AIDL");
      start();
      paramParcel2.writeNoException();
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.component.e
 * JD-Core Version:    0.7.0.1
 */