package com.tencent.mm.service;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface b
  extends IInterface
{
  public abstract void a(Intent paramIntent, a parama);
  
  public abstract void bV(Intent paramIntent);
  
  public abstract void ca(Intent paramIntent);
  
  public abstract void startService(Intent paramIntent);
  
  public static abstract class a
    extends Binder
    implements b
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.service.IMMServiceStub_AIDL");
    }
    
    public static b Y(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.service.IMMServiceStub_AIDL");
      if ((localIInterface != null) && ((localIInterface instanceof b))) {
        return (b)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public static b iUD()
    {
      return a.acwp;
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      IInterface localIInterface = null;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.mm.service.IMMServiceStub_AIDL");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.mm.service.IMMServiceStub_AIDL");
        Intent localIntent;
        if (paramParcel1.readInt() != 0)
        {
          localIntent = (Intent)Intent.CREATOR.createFromParcel(paramParcel1);
          paramParcel1 = paramParcel1.readStrongBinder();
          if (paramParcel1 != null) {
            break label132;
          }
          paramParcel1 = localIInterface;
        }
        for (;;)
        {
          a(localIntent, paramParcel1);
          paramParcel2.writeNoException();
          return true;
          localIntent = null;
          break;
          localIInterface = paramParcel1.queryLocalInterface("com.tencent.mm.service.IMMServiceConnectionStub_AIDL");
          if ((localIInterface != null) && ((localIInterface instanceof a))) {
            paramParcel1 = (a)localIInterface;
          } else {
            paramParcel1 = new a.a.a(paramParcel1);
          }
        }
      case 2: 
        paramParcel1.enforceInterface("com.tencent.mm.service.IMMServiceStub_AIDL");
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel1 = (Intent)Intent.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          ca(paramParcel1);
          paramParcel2.writeNoException();
          return true;
        }
      case 3: 
        label132:
        paramParcel1.enforceInterface("com.tencent.mm.service.IMMServiceStub_AIDL");
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel1 = (Intent)Intent.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          startService(paramParcel1);
          paramParcel2.writeNoException();
          return true;
        }
      }
      paramParcel1.enforceInterface("com.tencent.mm.service.IMMServiceStub_AIDL");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (Intent)Intent.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        bV(paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    }
    
    static final class a
      implements b
    {
      public static b acwp;
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public final void a(Intent paramIntent, a parama)
      {
        AppMethodBeat.i(125305);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.mm.service.IMMServiceStub_AIDL");
            if (paramIntent != null)
            {
              localParcel1.writeInt(1);
              paramIntent.writeToParcel(localParcel1, 0);
              if (parama != null)
              {
                localIBinder = parama.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                if ((this.mRemote.transact(1, localParcel1, localParcel2, 0)) || (b.a.iUD() == null)) {
                  break;
                }
                b.a.iUD().a(paramIntent, parama);
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
            AppMethodBeat.o(125305);
          }
        }
        localParcel2.readException();
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(125305);
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public final void bV(Intent paramIntent)
      {
        AppMethodBeat.i(125308);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.service.IMMServiceStub_AIDL");
          if (paramIntent != null)
          {
            localParcel1.writeInt(1);
            paramIntent.writeToParcel(localParcel1, 0);
          }
          while ((!this.mRemote.transact(4, localParcel1, localParcel2, 0)) && (b.a.iUD() != null))
          {
            b.a.iUD().bV(paramIntent);
            return;
            localParcel1.writeInt(0);
          }
          localParcel2.readException();
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(125308);
        }
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(125308);
      }
      
      public final void ca(Intent paramIntent)
      {
        AppMethodBeat.i(125306);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.service.IMMServiceStub_AIDL");
          if (paramIntent != null)
          {
            localParcel1.writeInt(1);
            paramIntent.writeToParcel(localParcel1, 0);
          }
          while ((!this.mRemote.transact(2, localParcel1, localParcel2, 0)) && (b.a.iUD() != null))
          {
            b.a.iUD().ca(paramIntent);
            return;
            localParcel1.writeInt(0);
          }
          localParcel2.readException();
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(125306);
        }
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(125306);
      }
      
      public final void startService(Intent paramIntent)
      {
        AppMethodBeat.i(125307);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.service.IMMServiceStub_AIDL");
          if (paramIntent != null)
          {
            localParcel1.writeInt(1);
            paramIntent.writeToParcel(localParcel1, 0);
          }
          while ((!this.mRemote.transact(3, localParcel1, localParcel2, 0)) && (b.a.iUD() != null))
          {
            b.a.iUD().startService(paramIntent);
            return;
            localParcel1.writeInt(0);
          }
          localParcel2.readException();
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(125307);
        }
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(125307);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.service.b
 * JD-Core Version:    0.7.0.1
 */