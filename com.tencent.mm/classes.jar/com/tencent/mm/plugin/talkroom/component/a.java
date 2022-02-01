package com.tencent.mm.plugin.talkroom.component;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface a
  extends IInterface
{
  public abstract int Close();
  
  public abstract int SetCurrentMicId(int paramInt);
  
  public abstract int a(ILiveConEngineCallback_AIDL paramILiveConEngineCallback_AIDL, int paramInt1, int paramInt2, int paramInt3, long paramLong, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt4, String[] paramArrayOfString);
  
  public abstract d a(b paramb);
  
  public abstract byte[] e(int[] paramArrayOfInt, String paramString);
  
  public abstract int gid();
  
  public abstract c gie();
  
  public abstract int uninitLive();
  
  public static abstract class a
    extends Binder
    implements a
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
    }
    
    public static a G(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
      if ((localIInterface != null) && ((localIInterface instanceof a))) {
        return (a)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public static a gif()
    {
      return a.MiU;
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
        paramInt1 = gid();
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
        paramInt1 = a(ILiveConEngineCallback_AIDL.a.H(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readLong(), paramParcel1.createIntArray(), paramParcel1.createIntArray(), paramParcel1.readInt(), paramParcel1.createStringArray());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
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
            break label398;
          }
        }
        label398:
        for (paramParcel1 = paramParcel1.asBinder();; paramParcel1 = null)
        {
          paramParcel2.writeStrongBinder(paramParcel1);
          return true;
          localObject = paramParcel1.queryLocalInterface("com.tencent.mm.plugin.talkroom.component.IMemberUpdateCallback_AIDL");
          if ((localObject != null) && ((localObject instanceof b)))
          {
            paramParcel1 = (b)localObject;
            break;
          }
          paramParcel1 = new b.a.a(paramParcel1);
          break;
        }
      }
      paramParcel1.enforceInterface("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
      paramParcel1 = gie();
      paramParcel2.writeNoException();
      if (paramParcel1 != null) {}
      for (paramParcel1 = paramParcel1.asBinder();; paramParcel1 = null)
      {
        paramParcel2.writeStrongBinder(paramParcel1);
        return true;
      }
    }
    
    static final class a
      implements a
    {
      public static a MiU;
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public final int Close()
      {
        AppMethodBeat.i(29377);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
          if ((!this.mRemote.transact(5, localParcel1, localParcel2, 0)) && (a.a.gif() != null))
          {
            i = a.a.gif().Close();
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
          AppMethodBeat.o(29377);
        }
      }
      
      public final int SetCurrentMicId(int paramInt)
      {
        AppMethodBeat.i(29376);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
          localParcel1.writeInt(paramInt);
          if ((!this.mRemote.transact(4, localParcel1, localParcel2, 0)) && (a.a.gif() != null))
          {
            paramInt = a.a.gif().SetCurrentMicId(paramInt);
            return paramInt;
          }
          localParcel2.readException();
          paramInt = localParcel2.readInt();
          return paramInt;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(29376);
        }
      }
      
      public final int a(ILiveConEngineCallback_AIDL paramILiveConEngineCallback_AIDL, int paramInt1, int paramInt2, int paramInt3, long paramLong, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt4, String[] paramArrayOfString)
      {
        AppMethodBeat.i(29375);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
          if (paramILiveConEngineCallback_AIDL != null) {}
          for (IBinder localIBinder = paramILiveConEngineCallback_AIDL.asBinder();; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            localParcel1.writeInt(paramInt1);
            localParcel1.writeInt(paramInt2);
            localParcel1.writeInt(paramInt3);
            localParcel1.writeLong(paramLong);
            localParcel1.writeIntArray(paramArrayOfInt1);
            localParcel1.writeIntArray(paramArrayOfInt2);
            localParcel1.writeInt(paramInt4);
            localParcel1.writeStringArray(paramArrayOfString);
            if ((this.mRemote.transact(3, localParcel1, localParcel2, 0)) || (a.a.gif() == null)) {
              break;
            }
            paramInt1 = a.a.gif().a(paramILiveConEngineCallback_AIDL, paramInt1, paramInt2, paramInt3, paramLong, paramArrayOfInt1, paramArrayOfInt2, paramInt4, paramArrayOfString);
            return paramInt1;
          }
          localParcel2.readException();
          paramInt1 = localParcel2.readInt();
          return paramInt1;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(29375);
        }
      }
      
      public final d a(b paramb)
      {
        AppMethodBeat.i(29379);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
          if (paramb != null) {}
          for (IBinder localIBinder = paramb.asBinder();; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            if ((this.mRemote.transact(7, localParcel1, localParcel2, 0)) || (a.a.gif() == null)) {
              break;
            }
            paramb = a.a.gif().a(paramb);
            return paramb;
          }
          localParcel2.readException();
          paramb = d.a.J(localParcel2.readStrongBinder());
          return paramb;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(29379);
        }
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public final byte[] e(int[] paramArrayOfInt, String paramString)
      {
        AppMethodBeat.i(29378);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
          if (paramArrayOfInt == null) {
            localParcel1.writeInt(-1);
          }
          for (;;)
          {
            localParcel1.writeString(paramString);
            if ((this.mRemote.transact(6, localParcel1, localParcel2, 0)) || (a.a.gif() == null)) {
              break;
            }
            paramArrayOfInt = a.a.gif().e(paramArrayOfInt, paramString);
            return paramArrayOfInt;
            localParcel1.writeInt(paramArrayOfInt.length);
          }
          localParcel2.readException();
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(29378);
        }
        paramString = localParcel2.createByteArray();
        localParcel2.readIntArray(paramArrayOfInt);
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(29378);
        return paramString;
      }
      
      public final int gid()
      {
        AppMethodBeat.i(29373);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
          if ((!this.mRemote.transact(1, localParcel1, localParcel2, 0)) && (a.a.gif() != null))
          {
            i = a.a.gif().gid();
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
          AppMethodBeat.o(29373);
        }
      }
      
      public final c gie()
      {
        AppMethodBeat.i(29380);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
          if ((!this.mRemote.transact(8, localParcel1, localParcel2, 0)) && (a.a.gif() != null))
          {
            localc = a.a.gif().gie();
            return localc;
          }
          localParcel2.readException();
          c localc = c.a.I(localParcel2.readStrongBinder());
          return localc;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(29380);
        }
      }
      
      public final int uninitLive()
      {
        AppMethodBeat.i(29374);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
          if ((!this.mRemote.transact(2, localParcel1, localParcel2, 0)) && (a.a.gif() != null))
          {
            i = a.a.gif().uninitLive();
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
          AppMethodBeat.o(29374);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.component.a
 * JD-Core Version:    0.7.0.1
 */