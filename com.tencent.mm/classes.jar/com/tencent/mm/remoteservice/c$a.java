package com.tencent.mm.remoteservice;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class c$a
  extends Binder
  implements c
{
  public c$a()
  {
    attachInterface(this, "com.tencent.mm.remoteservice.ICommRemoteServer");
  }
  
  public static c K(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.remoteservice.ICommRemoteServer");
    if ((localIInterface != null) && ((localIInterface instanceof c))) {
      return (c)localIInterface;
    }
    return new c.a.a(paramIBinder);
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
      paramParcel2.writeString("com.tencent.mm.remoteservice.ICommRemoteServer");
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mm.remoteservice.ICommRemoteServer");
    String str1 = paramParcel1.readString();
    String str2 = paramParcel1.readString();
    Bundle localBundle;
    if (paramParcel1.readInt() != 0)
    {
      localBundle = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      a(str1, str2, localBundle, b.a.asInterface(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      if (localBundle == null) {
        break label131;
      }
      paramParcel2.writeInt(1);
      localBundle.writeToParcel(paramParcel2, 1);
    }
    for (;;)
    {
      return true;
      localBundle = null;
      break;
      label131:
      paramParcel2.writeInt(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.remoteservice.c.a
 * JD-Core Version:    0.7.0.1
 */