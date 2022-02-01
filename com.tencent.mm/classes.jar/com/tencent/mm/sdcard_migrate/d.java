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
  public abstract void aaS(int paramInt);
  
  public abstract void aaT(int paramInt);
  
  public abstract void b(int paramInt, ExtStorageMigrateException paramExtStorageMigrateException);
  
  public abstract void fnw();
  
  public abstract void jx(int paramInt1, int paramInt2);
  
  public abstract void lP(String paramString1, String paramString2);
  
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
        aaS(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.tencent.mm.sdcard_migrate.IMigrateResultCallback");
        lP(paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.mm.sdcard_migrate.IMigrateResultCallback");
        aaT(paramParcel1.readInt());
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
        fnw();
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mm.sdcard_migrate.IMigrateResultCallback");
      jx(paramParcel1.readInt(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    }
    
    static final class a
      implements d
    {
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public final void aaS(int paramInt)
      {
        AppMethodBeat.i(211873);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.sdcard_migrate.IMigrateResultCallback");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(211873);
        }
      }
      
      public final void aaT(int paramInt)
      {
        AppMethodBeat.i(211875);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.sdcard_migrate.IMigrateResultCallback");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(211875);
        }
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
      
      /* Error */
      public final void b(int paramInt, ExtStorageMigrateException paramExtStorageMigrateException)
      {
        // Byte code:
        //   0: ldc 64
        //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_3
        //   9: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   12: astore 4
        //   14: aload_3
        //   15: ldc 35
        //   17: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_3
        //   21: iload_1
        //   22: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   25: aload_2
        //   26: ifnull +49 -> 75
        //   29: aload_3
        //   30: iconst_1
        //   31: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   34: aload_2
        //   35: aload_3
        //   36: iconst_0
        //   37: invokevirtual 70	com/tencent/mm/sdcard_migrate/util/ExtStorageMigrateException:writeToParcel	(Landroid/os/Parcel;I)V
        //   40: aload_0
        //   41: getfield 18	com/tencent/mm/sdcard_migrate/d$a$a:mRemote	Landroid/os/IBinder;
        //   44: iconst_4
        //   45: aload_3
        //   46: aload 4
        //   48: iconst_0
        //   49: invokeinterface 48 5 0
        //   54: pop
        //   55: aload 4
        //   57: invokevirtual 51	android/os/Parcel:readException	()V
        //   60: aload 4
        //   62: invokevirtual 54	android/os/Parcel:recycle	()V
        //   65: aload_3
        //   66: invokevirtual 54	android/os/Parcel:recycle	()V
        //   69: ldc 64
        //   71: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   74: return
        //   75: aload_3
        //   76: iconst_0
        //   77: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   80: goto -40 -> 40
        //   83: astore_2
        //   84: aload 4
        //   86: invokevirtual 54	android/os/Parcel:recycle	()V
        //   89: aload_3
        //   90: invokevirtual 54	android/os/Parcel:recycle	()V
        //   93: ldc 64
        //   95: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   98: aload_2
        //   99: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	100	0	this	a
        //   0	100	1	paramInt	int
        //   0	100	2	paramExtStorageMigrateException	ExtStorageMigrateException
        //   8	82	3	localParcel1	Parcel
        //   12	73	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   14	25	83	finally
        //   29	40	83	finally
        //   40	60	83	finally
        //   75	80	83	finally
      }
      
      public final void fnw()
      {
        AppMethodBeat.i(211877);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.sdcard_migrate.IMigrateResultCallback");
          this.mRemote.transact(5, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(211877);
        }
      }
      
      public final void jx(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(211878);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.sdcard_migrate.IMigrateResultCallback");
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          this.mRemote.transact(6, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(211878);
        }
      }
      
      public final void lP(String paramString1, String paramString2)
      {
        AppMethodBeat.i(211874);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.sdcard_migrate.IMigrateResultCallback");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          this.mRemote.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(211874);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.d
 * JD-Core Version:    0.7.0.1
 */