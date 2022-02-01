package com.tencent.mm.remoteservice;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface c
  extends IInterface
{
  public abstract void a(String paramString1, String paramString2, Bundle paramBundle, b paramb);
  
  public static abstract class a
    extends Binder
    implements c
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.remoteservice.ICommRemoteServer");
    }
    
    public static c L(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.remoteservice.ICommRemoteServer");
      if ((localIInterface != null) && ((localIInterface instanceof c))) {
        return (c)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public static c gvb()
    {
      return a.NCy;
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
    
    static final class a
      implements c
    {
      public static c NCy;
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public final void a(String paramString1, String paramString2, Bundle paramBundle, b paramb)
      {
        AppMethodBeat.i(152740);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.mm.remoteservice.ICommRemoteServer");
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            if (paramBundle != null)
            {
              localParcel1.writeInt(1);
              paramBundle.writeToParcel(localParcel1, 0);
              if (paramb != null)
              {
                localIBinder = paramb.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                if ((this.mRemote.transact(1, localParcel1, localParcel2, 0)) || (c.a.gvb() == null)) {
                  break;
                }
                c.a.gvb().a(paramString1, paramString2, paramBundle, paramb);
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            IBinder localIBinder = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
            AppMethodBeat.o(152740);
          }
        }
        localParcel2.readException();
        if (localParcel2.readInt() != 0) {
          paramBundle.readFromParcel(localParcel2);
        }
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(152740);
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.remoteservice.c
 * JD-Core Version:    0.7.0.1
 */