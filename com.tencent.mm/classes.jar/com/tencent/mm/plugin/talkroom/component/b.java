package com.tencent.mm.plugin.talkroom.component;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface b
  extends IInterface
{
  public abstract void keep_OnError(int paramInt);
  
  public abstract void keep_OnOpenSuccess();
  
  public static abstract class a
    extends Binder
    implements b
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.plugin.talkroom.component.ILiveConEngineCallback_AIDL");
    }
    
    public static b ftG()
    {
      return a.FOU;
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
        paramParcel2.writeString("com.tencent.mm.plugin.talkroom.component.ILiveConEngineCallback_AIDL");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.talkroom.component.ILiveConEngineCallback_AIDL");
        keep_OnOpenSuccess();
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mm.plugin.talkroom.component.ILiveConEngineCallback_AIDL");
      keep_OnError(paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    }
    
    static final class a
      implements b
    {
      public static b FOU;
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public final void keep_OnError(int paramInt)
      {
        AppMethodBeat.i(29382);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.ILiveConEngineCallback_AIDL");
          localParcel1.writeInt(paramInt);
          if ((!this.mRemote.transact(2, localParcel1, localParcel2, 0)) && (b.a.ftG() != null))
          {
            b.a.ftG().keep_OnError(paramInt);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(29382);
        }
      }
      
      public final void keep_OnOpenSuccess()
      {
        AppMethodBeat.i(29381);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.ILiveConEngineCallback_AIDL");
          if ((!this.mRemote.transact(1, localParcel1, localParcel2, 0)) && (b.a.ftG() != null))
          {
            b.a.ftG().keep_OnOpenSuccess();
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(29381);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.component.b
 * JD-Core Version:    0.7.0.1
 */