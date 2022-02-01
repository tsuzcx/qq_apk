package com.tencent.mm.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface a
  extends IInterface
{
  public abstract void X(IBinder paramIBinder);
  
  public static abstract class a
    extends Binder
    implements a
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.service.IMMServiceConnectionStub_AIDL");
    }
    
    public static a iUC()
    {
      return a.acwo;
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
        paramParcel2.writeString("com.tencent.mm.service.IMMServiceConnectionStub_AIDL");
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mm.service.IMMServiceConnectionStub_AIDL");
      X(paramParcel1.readStrongBinder());
      paramParcel2.writeNoException();
      return true;
    }
    
    static final class a
      implements a
    {
      public static a acwo;
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public final void X(IBinder paramIBinder)
      {
        AppMethodBeat.i(125304);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.service.IMMServiceConnectionStub_AIDL");
          localParcel1.writeStrongBinder(paramIBinder);
          if ((!this.mRemote.transact(1, localParcel1, localParcel2, 0)) && (a.a.iUC() != null))
          {
            a.a.iUC().X(paramIBinder);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(125304);
        }
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.service.a
 * JD-Core Version:    0.7.0.1
 */