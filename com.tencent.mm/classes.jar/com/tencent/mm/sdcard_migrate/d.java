package com.tencent.mm.sdcard_migrate;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdcard_migrate.util.ExtStorageMigrateException;

public abstract interface d
  extends IInterface
{
  public abstract void ajH(int paramInt);
  
  public abstract void ajI(int paramInt);
  
  public abstract void b(int paramInt, ExtStorageMigrateException paramExtStorageMigrateException);
  
  public abstract void gxi();
  
  public abstract void kJ(int paramInt1, int paramInt2);
  
  public abstract void mN(String paramString1, String paramString2);
  
  public static abstract class a
    extends Binder
    implements d
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.sdcard_migrate.IMigrateResultCallback");
    }
    
    public static d M(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.sdcard_migrate.IMigrateResultCallback");
      if ((localIInterface != null) && ((localIInterface instanceof d))) {
        return (d)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public static d gxj()
    {
      return a.NHC;
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
        paramParcel2.writeString("com.tencent.mm.sdcard_migrate.IMigrateResultCallback");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.mm.sdcard_migrate.IMigrateResultCallback");
        ajH(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.tencent.mm.sdcard_migrate.IMigrateResultCallback");
        mN(paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.mm.sdcard_migrate.IMigrateResultCallback");
        ajI(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.tencent.mm.sdcard_migrate.IMigrateResultCallback");
        paramInt1 = paramParcel1.readInt();
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel1 = (ExtStorageMigrateException)ExtStorageMigrateException.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          b(paramInt1, paramParcel1);
          paramParcel2.writeNoException();
          return true;
        }
      case 5: 
        paramParcel1.enforceInterface("com.tencent.mm.sdcard_migrate.IMigrateResultCallback");
        gxi();
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mm.sdcard_migrate.IMigrateResultCallback");
      kJ(paramParcel1.readInt(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    }
    
    static final class a
      implements d
    {
      public static d NHC;
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public final void ajH(int paramInt)
      {
        AppMethodBeat.i(204635);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.sdcard_migrate.IMigrateResultCallback");
          localParcel1.writeInt(paramInt);
          if ((!this.mRemote.transact(1, localParcel1, localParcel2, 0)) && (d.a.gxj() != null))
          {
            d.a.gxj().ajH(paramInt);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(204635);
        }
      }
      
      public final void ajI(int paramInt)
      {
        AppMethodBeat.i(204637);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.sdcard_migrate.IMigrateResultCallback");
          localParcel1.writeInt(paramInt);
          if ((!this.mRemote.transact(3, localParcel1, localParcel2, 0)) && (d.a.gxj() != null))
          {
            d.a.gxj().ajI(paramInt);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(204637);
        }
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public final void b(int paramInt, ExtStorageMigrateException paramExtStorageMigrateException)
      {
        AppMethodBeat.i(204638);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.sdcard_migrate.IMigrateResultCallback");
          localParcel1.writeInt(paramInt);
          if (paramExtStorageMigrateException != null)
          {
            localParcel1.writeInt(1);
            paramExtStorageMigrateException.writeToParcel(localParcel1, 0);
          }
          while ((!this.mRemote.transact(4, localParcel1, localParcel2, 0)) && (d.a.gxj() != null))
          {
            d.a.gxj().b(paramInt, paramExtStorageMigrateException);
            return;
            localParcel1.writeInt(0);
          }
          localParcel2.readException();
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(204638);
        }
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(204638);
      }
      
      public final void gxi()
      {
        AppMethodBeat.i(204639);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.sdcard_migrate.IMigrateResultCallback");
          if ((!this.mRemote.transact(5, localParcel1, localParcel2, 0)) && (d.a.gxj() != null))
          {
            d.a.gxj().gxi();
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(204639);
        }
      }
      
      public final void kJ(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(204640);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.sdcard_migrate.IMigrateResultCallback");
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          if ((!this.mRemote.transact(6, localParcel1, localParcel2, 0)) && (d.a.gxj() != null))
          {
            d.a.gxj().kJ(paramInt1, paramInt2);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(204640);
        }
      }
      
      public final void mN(String paramString1, String paramString2)
      {
        AppMethodBeat.i(204636);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.sdcard_migrate.IMigrateResultCallback");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          if ((!this.mRemote.transact(2, localParcel1, localParcel2, 0)) && (d.a.gxj() != null))
          {
            d.a.gxj().mN(paramString1, paramString2);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(204636);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.d
 * JD-Core Version:    0.7.0.1
 */