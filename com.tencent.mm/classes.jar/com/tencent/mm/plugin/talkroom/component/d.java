package com.tencent.mm.plugin.talkroom.component;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface d
  extends IInterface
{
  public abstract void bgt();
  
  public abstract void ftI();
  
  public abstract int ftJ();
  
  public abstract void release();
  
  public abstract void start();
  
  public static abstract class a
    extends Binder
    implements d
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
    }
    
    public static d E(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
      if ((localIInterface != null) && ((localIInterface instanceof d))) {
        return (d)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public static d ftK()
    {
      return a.FOW;
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
        paramParcel2.writeString("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
        ftI();
        paramParcel2.writeNoException();
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
        bgt();
        paramParcel2.writeNoException();
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
        release();
        paramParcel2.writeNoException();
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
        paramInt1 = ftJ();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
      start();
      paramParcel2.writeNoException();
      return true;
    }
    
    static final class a
      implements d
    {
      public static d FOW;
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public final void bgt()
      {
        AppMethodBeat.i(29385);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
          if ((!this.mRemote.transact(2, localParcel1, localParcel2, 0)) && (d.a.ftK() != null))
          {
            d.a.ftK().bgt();
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(29385);
        }
      }
      
      public final void ftI()
      {
        AppMethodBeat.i(29384);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
          if ((!this.mRemote.transact(1, localParcel1, localParcel2, 0)) && (d.a.ftK() != null))
          {
            d.a.ftK().ftI();
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(29384);
        }
      }
      
      public final int ftJ()
      {
        AppMethodBeat.i(29387);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
          if ((!this.mRemote.transact(4, localParcel1, localParcel2, 0)) && (d.a.ftK() != null))
          {
            i = d.a.ftK().ftJ();
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
          AppMethodBeat.o(29387);
        }
      }
      
      public final void release()
      {
        AppMethodBeat.i(29386);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
          if ((!this.mRemote.transact(3, localParcel1, localParcel2, 0)) && (d.a.ftK() != null))
          {
            d.a.ftK().release();
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(29386);
        }
      }
      
      public final void start()
      {
        AppMethodBeat.i(29388);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
          if ((!this.mRemote.transact(5, localParcel1, localParcel2, 0)) && (d.a.ftK() != null))
          {
            d.a.ftK().start();
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(29388);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.component.d
 * JD-Core Version:    0.7.0.1
 */