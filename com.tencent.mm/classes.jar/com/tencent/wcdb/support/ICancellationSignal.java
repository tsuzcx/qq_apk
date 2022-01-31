package com.tencent.wcdb.support;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract interface ICancellationSignal
  extends IInterface
{
  public abstract void cancel();
  
  public static abstract class Stub
    extends Binder
    implements ICancellationSignal
  {
    private static final String DESCRIPTOR = "com.tencent.wcdb.support.ICancellationSignal";
    static final int TRANSACTION_cancel = 1;
    
    public Stub()
    {
      attachInterface(this, "com.tencent.wcdb.support.ICancellationSignal");
    }
    
    public static ICancellationSignal asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.wcdb.support.ICancellationSignal");
      if ((localIInterface != null) && ((localIInterface instanceof ICancellationSignal))) {
        return (ICancellationSignal)localIInterface;
      }
      return new Proxy(paramIBinder);
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
        paramParcel2.writeString("com.tencent.wcdb.support.ICancellationSignal");
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.wcdb.support.ICancellationSignal");
      cancel();
      return true;
    }
    
    private static class Proxy
      implements ICancellationSignal
    {
      private IBinder mRemote;
      
      Proxy(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public void cancel()
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.wcdb.support.ICancellationSignal");
          this.mRemote.transact(1, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public String getInterfaceDescriptor()
      {
        return "com.tencent.wcdb.support.ICancellationSignal";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wcdb.support.ICancellationSignal
 * JD-Core Version:    0.7.0.1
 */