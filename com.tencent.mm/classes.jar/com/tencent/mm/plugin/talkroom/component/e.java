package com.tencent.mm.plugin.talkroom.component;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface e
  extends IInterface
{
  public abstract void cXa();
  
  public abstract void eYd();
  
  public abstract int ftJ();
  
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
    
    public static e F(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.plugin.talkroom.component.ITalkRoomPlayer_AIDL");
      if ((localIInterface != null) && ((localIInterface instanceof e))) {
        return (e)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public static e ftL()
    {
      return a.FOX;
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
        cXa();
        paramParcel2.writeNoException();
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.talkroom.component.ITalkRoomPlayer_AIDL");
        eYd();
        paramParcel2.writeNoException();
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.talkroom.component.ITalkRoomPlayer_AIDL");
        release();
        paramParcel2.writeNoException();
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.talkroom.component.ITalkRoomPlayer_AIDL");
        paramInt1 = ftJ();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mm.plugin.talkroom.component.ITalkRoomPlayer_AIDL");
      start();
      paramParcel2.writeNoException();
      return true;
    }
    
    static final class a
      implements e
    {
      public static e FOX;
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public final void cXa()
      {
        AppMethodBeat.i(29389);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.ITalkRoomPlayer_AIDL");
          if ((!this.mRemote.transact(1, localParcel1, localParcel2, 0)) && (e.a.ftL() != null))
          {
            e.a.ftL().cXa();
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(29389);
        }
      }
      
      public final void eYd()
      {
        AppMethodBeat.i(29390);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.ITalkRoomPlayer_AIDL");
          if ((!this.mRemote.transact(2, localParcel1, localParcel2, 0)) && (e.a.ftL() != null))
          {
            e.a.ftL().eYd();
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(29390);
        }
      }
      
      public final int ftJ()
      {
        AppMethodBeat.i(29392);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.ITalkRoomPlayer_AIDL");
          if ((!this.mRemote.transact(4, localParcel1, localParcel2, 0)) && (e.a.ftL() != null))
          {
            i = e.a.ftL().ftJ();
            return i;
          }
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(29392);
        }
      }
      
      public final void release()
      {
        AppMethodBeat.i(29391);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.ITalkRoomPlayer_AIDL");
          if ((!this.mRemote.transact(3, localParcel1, localParcel2, 0)) && (e.a.ftL() != null))
          {
            e.a.ftL().release();
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(29391);
        }
      }
      
      public final void start()
      {
        AppMethodBeat.i(29393);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.ITalkRoomPlayer_AIDL");
          if ((!this.mRemote.transact(5, localParcel1, localParcel2, 0)) && (e.a.ftL() != null))
          {
            e.a.ftL().start();
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(29393);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.component.e
 * JD-Core Version:    0.7.0.1
 */