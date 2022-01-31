package com.tencent.mm.plugin.talkroom.component;

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
    attachInterface(this, "com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
  }
  
  public static a C(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
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
    Object localObject;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
      paramInt1 = bMo();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
      paramInt1 = uninitLive();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
      localObject = paramParcel1.readStrongBinder();
      if (localObject == null) {
        localObject = null;
      }
      for (;;)
      {
        paramInt1 = a((b)localObject, paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readLong(), paramParcel1.createIntArray(), paramParcel1.createIntArray(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
        IInterface localIInterface = ((IBinder)localObject).queryLocalInterface("com.tencent.mm.plugin.talkroom.component.ILiveConEngineCallback_AIDL");
        if ((localIInterface != null) && ((localIInterface instanceof b))) {
          localObject = (b)localIInterface;
        } else {
          localObject = new b.a.a((IBinder)localObject);
        }
      }
    case 4: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
      paramInt1 = SetCurrentMicId(paramParcel1.readInt());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
      paramInt1 = Close();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 6: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
      paramInt1 = paramParcel1.readInt();
      if (paramInt1 < 0) {}
      for (localObject = null;; localObject = new int[paramInt1])
      {
        paramParcel1 = e((int[])localObject, paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeByteArray(paramParcel1);
        paramParcel2.writeIntArray((int[])localObject);
        return true;
      }
    case 7: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 == null)
      {
        paramParcel1 = null;
        paramParcel1 = a(paramParcel1);
        paramParcel2.writeNoException();
        if (paramParcel1 == null) {
          break label451;
        }
      }
      label451:
      for (paramParcel1 = paramParcel1.asBinder();; paramParcel1 = null)
      {
        paramParcel2.writeStrongBinder(paramParcel1);
        return true;
        localObject = paramParcel1.queryLocalInterface("com.tencent.mm.plugin.talkroom.component.IMemberUpdateCallback_AIDL");
        if ((localObject != null) && ((localObject instanceof c)))
        {
          paramParcel1 = (c)localObject;
          break;
        }
        paramParcel1 = new c.a.a(paramParcel1);
        break;
      }
    }
    paramParcel1.enforceInterface("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
    paramParcel1 = bMp();
    paramParcel2.writeNoException();
    if (paramParcel1 != null) {}
    for (paramParcel1 = paramParcel1.asBinder();; paramParcel1 = null)
    {
      paramParcel2.writeStrongBinder(paramParcel1);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.component.a.a
 * JD-Core Version:    0.7.0.1
 */