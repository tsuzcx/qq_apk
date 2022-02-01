package com.tencent.mm.sdcard_migrate;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface e
  extends IInterface
{
  public abstract void a(ExtStorageMigrateConfig paramExtStorageMigrateConfig);
  
  public abstract void a(MigrateResultCallback paramMigrateResultCallback);
  
  public abstract void b(MigrateResultCallback paramMigrateResultCallback);
  
  public abstract boolean hsR();
  
  public abstract void hsV();
  
  public static abstract class a
    extends Binder
    implements e
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.sdcard_migrate.IMigrateServiceController");
    }
    
    public static e R(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.sdcard_migrate.IMigrateServiceController");
      if ((localIInterface != null) && ((localIInterface instanceof e))) {
        return (e)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public static e htj()
    {
      return a.UVe;
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      Object localObject2 = null;
      Object localObject3 = null;
      Object localObject1 = null;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.mm.sdcard_migrate.IMigrateServiceController");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.mm.sdcard_migrate.IMigrateServiceController");
        boolean bool = hsR();
        paramParcel2.writeNoException();
        if (bool) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          paramParcel2.writeInt(paramInt1);
          return true;
        }
      case 2: 
        paramParcel1.enforceInterface("com.tencent.mm.sdcard_migrate.IMigrateServiceController");
        if (paramParcel1.readInt() != 0) {
          localObject1 = (MigrateResultCallback)MigrateResultCallback.CREATOR.createFromParcel(paramParcel1);
        }
        a((MigrateResultCallback)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.mm.sdcard_migrate.IMigrateServiceController");
        localObject1 = localObject2;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (MigrateResultCallback)MigrateResultCallback.CREATOR.createFromParcel(paramParcel1);
        }
        b((MigrateResultCallback)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.tencent.mm.sdcard_migrate.IMigrateServiceController");
        localObject1 = localObject3;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (ExtStorageMigrateConfig)ExtStorageMigrateConfig.CREATOR.createFromParcel(paramParcel1);
        }
        a((ExtStorageMigrateConfig)localObject1);
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mm.sdcard_migrate.IMigrateServiceController");
      hsV();
      paramParcel2.writeNoException();
      return true;
    }
    
    static final class a
      implements e
    {
      public static e UVe;
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public final void a(ExtStorageMigrateConfig paramExtStorageMigrateConfig)
      {
        AppMethodBeat.i(191634);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.sdcard_migrate.IMigrateServiceController");
          if (paramExtStorageMigrateConfig != null)
          {
            localParcel1.writeInt(1);
            paramExtStorageMigrateConfig.writeToParcel(localParcel1, 0);
          }
          while ((!this.mRemote.transact(4, localParcel1, localParcel2, 0)) && (e.a.htj() != null))
          {
            e.a.htj().a(paramExtStorageMigrateConfig);
            return;
            localParcel1.writeInt(0);
          }
          localParcel2.readException();
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(191634);
        }
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(191634);
      }
      
      public final void a(MigrateResultCallback paramMigrateResultCallback)
      {
        AppMethodBeat.i(191626);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.sdcard_migrate.IMigrateServiceController");
          if (paramMigrateResultCallback != null)
          {
            localParcel1.writeInt(1);
            paramMigrateResultCallback.writeToParcel(localParcel1, 0);
          }
          while ((!this.mRemote.transact(2, localParcel1, localParcel2, 0)) && (e.a.htj() != null))
          {
            e.a.htj().a(paramMigrateResultCallback);
            return;
            localParcel1.writeInt(0);
          }
          localParcel2.readException();
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(191626);
        }
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(191626);
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public final void b(MigrateResultCallback paramMigrateResultCallback)
      {
        AppMethodBeat.i(191629);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.sdcard_migrate.IMigrateServiceController");
          if (paramMigrateResultCallback != null)
          {
            localParcel1.writeInt(1);
            paramMigrateResultCallback.writeToParcel(localParcel1, 0);
          }
          while ((!this.mRemote.transact(3, localParcel1, localParcel2, 0)) && (e.a.htj() != null))
          {
            e.a.htj().b(paramMigrateResultCallback);
            return;
            localParcel1.writeInt(0);
          }
          localParcel2.readException();
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(191629);
        }
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(191629);
      }
      
      /* Error */
      public final boolean hsR()
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore_2
        //   2: ldc 87
        //   4: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   7: invokestatic 35	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   10: astore_3
        //   11: invokestatic 35	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   14: astore 4
        //   16: aload_3
        //   17: ldc 37
        //   19: invokevirtual 41	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   22: aload_0
        //   23: getfield 20	com/tencent/mm/sdcard_migrate/e$a$a:mRemote	Landroid/os/IBinder;
        //   26: iconst_1
        //   27: aload_3
        //   28: aload 4
        //   30: iconst_0
        //   31: invokeinterface 56 5 0
        //   36: ifne +34 -> 70
        //   39: invokestatic 60	com/tencent/mm/sdcard_migrate/e$a:htj	()Lcom/tencent/mm/sdcard_migrate/e;
        //   42: ifnull +28 -> 70
        //   45: invokestatic 60	com/tencent/mm/sdcard_migrate/e$a:htj	()Lcom/tencent/mm/sdcard_migrate/e;
        //   48: invokeinterface 89 1 0
        //   53: istore_2
        //   54: aload 4
        //   56: invokevirtual 65	android/os/Parcel:recycle	()V
        //   59: aload_3
        //   60: invokevirtual 65	android/os/Parcel:recycle	()V
        //   63: ldc 87
        //   65: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   68: iload_2
        //   69: ireturn
        //   70: aload 4
        //   72: invokevirtual 71	android/os/Parcel:readException	()V
        //   75: aload 4
        //   77: invokevirtual 93	android/os/Parcel:readInt	()I
        //   80: istore_1
        //   81: iload_1
        //   82: ifeq +19 -> 101
        //   85: aload 4
        //   87: invokevirtual 65	android/os/Parcel:recycle	()V
        //   90: aload_3
        //   91: invokevirtual 65	android/os/Parcel:recycle	()V
        //   94: ldc 87
        //   96: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   99: iload_2
        //   100: ireturn
        //   101: iconst_0
        //   102: istore_2
        //   103: goto -18 -> 85
        //   106: astore 5
        //   108: aload 4
        //   110: invokevirtual 65	android/os/Parcel:recycle	()V
        //   113: aload_3
        //   114: invokevirtual 65	android/os/Parcel:recycle	()V
        //   117: ldc 87
        //   119: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   122: aload 5
        //   124: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	125	0	this	a
        //   80	2	1	i	int
        //   1	102	2	bool	boolean
        //   10	104	3	localParcel1	Parcel
        //   14	95	4	localParcel2	Parcel
        //   106	17	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   16	54	106	finally
        //   70	81	106	finally
      }
      
      public final void hsV()
      {
        AppMethodBeat.i(191640);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.sdcard_migrate.IMigrateServiceController");
          if ((!this.mRemote.transact(5, localParcel1, localParcel2, 0)) && (e.a.htj() != null))
          {
            e.a.htj().hsV();
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(191640);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.e
 * JD-Core Version:    0.7.0.1
 */