package com.tencent.mm.remoteservice;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract interface b
  extends IInterface
{
  public abstract void onCallback(String paramString, Bundle paramBundle, boolean paramBoolean);
  
  public static abstract class a
    extends Binder
    implements b
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.remoteservice.ICommClientCallback");
    }
    
    public static b asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.remoteservice.ICommClientCallback");
      if ((localIInterface != null) && ((localIInterface instanceof b))) {
        return (b)localIInterface;
      }
      return new b.a.a(paramIBinder);
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
        paramParcel2.writeString("com.tencent.mm.remoteservice.ICommClientCallback");
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mm.remoteservice.ICommClientCallback");
      String str = paramParcel1.readString();
      Bundle localBundle;
      if (paramParcel1.readInt() != 0)
      {
        localBundle = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label128;
        }
      }
      label128:
      for (boolean bool = true;; bool = false)
      {
        onCallback(str, localBundle, bool);
        paramParcel2.writeNoException();
        if (localBundle == null) {
          break label134;
        }
        paramParcel2.writeInt(1);
        localBundle.writeToParcel(paramParcel2, 1);
        return true;
        localBundle = null;
        break;
      }
      label134:
      paramParcel2.writeInt(0);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.remoteservice.b
 * JD-Core Version:    0.7.0.1
 */