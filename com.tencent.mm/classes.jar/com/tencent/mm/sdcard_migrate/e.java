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
  
  public abstract boolean eEq();
  
  public abstract void eEu();
  
  public static abstract class a
    extends Binder
    implements e
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.sdcard_migrate.IMigrateServiceController");
    }
    
    public static e M(IBinder paramIBinder)
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
        boolean bool = eEq();
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
      eEu();
      paramParcel2.writeNoException();
      return true;
    }
    
    static final class a
      implements e
    {
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      /* Error */
      public final void a(ExtStorageMigrateConfig paramExtStorageMigrateConfig)
      {
        // Byte code:
        //   0: ldc 21
        //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_2
        //   9: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   12: astore_3
        //   13: aload_2
        //   14: ldc 35
        //   16: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   19: aload_1
        //   20: ifnull +46 -> 66
        //   23: aload_2
        //   24: iconst_1
        //   25: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   28: aload_1
        //   29: aload_2
        //   30: iconst_0
        //   31: invokevirtual 48	com/tencent/mm/sdcard_migrate/ExtStorageMigrateConfig:writeToParcel	(Landroid/os/Parcel;I)V
        //   34: aload_0
        //   35: getfield 18	com/tencent/mm/sdcard_migrate/e$a$a:mRemote	Landroid/os/IBinder;
        //   38: iconst_4
        //   39: aload_2
        //   40: aload_3
        //   41: iconst_0
        //   42: invokeinterface 54 5 0
        //   47: pop
        //   48: aload_3
        //   49: invokevirtual 57	android/os/Parcel:readException	()V
        //   52: aload_3
        //   53: invokevirtual 60	android/os/Parcel:recycle	()V
        //   56: aload_2
        //   57: invokevirtual 60	android/os/Parcel:recycle	()V
        //   60: ldc 21
        //   62: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   65: return
        //   66: aload_2
        //   67: iconst_0
        //   68: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   71: goto -37 -> 34
        //   74: astore_1
        //   75: aload_3
        //   76: invokevirtual 60	android/os/Parcel:recycle	()V
        //   79: aload_2
        //   80: invokevirtual 60	android/os/Parcel:recycle	()V
        //   83: ldc 21
        //   85: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   88: aload_1
        //   89: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	90	0	this	a
        //   0	90	1	paramExtStorageMigrateConfig	ExtStorageMigrateConfig
        //   8	72	2	localParcel1	Parcel
        //   12	64	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   13	19	74	finally
        //   23	34	74	finally
        //   34	52	74	finally
        //   66	71	74	finally
      }
      
      /* Error */
      public final void a(MigrateResultCallback paramMigrateResultCallback)
      {
        // Byte code:
        //   0: ldc 65
        //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_2
        //   9: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   12: astore_3
        //   13: aload_2
        //   14: ldc 35
        //   16: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   19: aload_1
        //   20: ifnull +46 -> 66
        //   23: aload_2
        //   24: iconst_1
        //   25: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   28: aload_1
        //   29: aload_2
        //   30: iconst_0
        //   31: invokevirtual 68	com/tencent/mm/sdcard_migrate/MigrateResultCallback:writeToParcel	(Landroid/os/Parcel;I)V
        //   34: aload_0
        //   35: getfield 18	com/tencent/mm/sdcard_migrate/e$a$a:mRemote	Landroid/os/IBinder;
        //   38: iconst_2
        //   39: aload_2
        //   40: aload_3
        //   41: iconst_0
        //   42: invokeinterface 54 5 0
        //   47: pop
        //   48: aload_3
        //   49: invokevirtual 57	android/os/Parcel:readException	()V
        //   52: aload_3
        //   53: invokevirtual 60	android/os/Parcel:recycle	()V
        //   56: aload_2
        //   57: invokevirtual 60	android/os/Parcel:recycle	()V
        //   60: ldc 65
        //   62: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   65: return
        //   66: aload_2
        //   67: iconst_0
        //   68: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   71: goto -37 -> 34
        //   74: astore_1
        //   75: aload_3
        //   76: invokevirtual 60	android/os/Parcel:recycle	()V
        //   79: aload_2
        //   80: invokevirtual 60	android/os/Parcel:recycle	()V
        //   83: ldc 65
        //   85: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   88: aload_1
        //   89: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	90	0	this	a
        //   0	90	1	paramMigrateResultCallback	MigrateResultCallback
        //   8	72	2	localParcel1	Parcel
        //   12	64	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   13	19	74	finally
        //   23	34	74	finally
        //   34	52	74	finally
        //   66	71	74	finally
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
      
      /* Error */
      public final void b(MigrateResultCallback paramMigrateResultCallback)
      {
        // Byte code:
        //   0: ldc 72
        //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_2
        //   9: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   12: astore_3
        //   13: aload_2
        //   14: ldc 35
        //   16: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   19: aload_1
        //   20: ifnull +46 -> 66
        //   23: aload_2
        //   24: iconst_1
        //   25: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   28: aload_1
        //   29: aload_2
        //   30: iconst_0
        //   31: invokevirtual 68	com/tencent/mm/sdcard_migrate/MigrateResultCallback:writeToParcel	(Landroid/os/Parcel;I)V
        //   34: aload_0
        //   35: getfield 18	com/tencent/mm/sdcard_migrate/e$a$a:mRemote	Landroid/os/IBinder;
        //   38: iconst_3
        //   39: aload_2
        //   40: aload_3
        //   41: iconst_0
        //   42: invokeinterface 54 5 0
        //   47: pop
        //   48: aload_3
        //   49: invokevirtual 57	android/os/Parcel:readException	()V
        //   52: aload_3
        //   53: invokevirtual 60	android/os/Parcel:recycle	()V
        //   56: aload_2
        //   57: invokevirtual 60	android/os/Parcel:recycle	()V
        //   60: ldc 72
        //   62: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   65: return
        //   66: aload_2
        //   67: iconst_0
        //   68: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   71: goto -37 -> 34
        //   74: astore_1
        //   75: aload_3
        //   76: invokevirtual 60	android/os/Parcel:recycle	()V
        //   79: aload_2
        //   80: invokevirtual 60	android/os/Parcel:recycle	()V
        //   83: ldc 72
        //   85: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   88: aload_1
        //   89: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	90	0	this	a
        //   0	90	1	paramMigrateResultCallback	MigrateResultCallback
        //   8	72	2	localParcel1	Parcel
        //   12	64	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   13	19	74	finally
        //   23	34	74	finally
        //   34	52	74	finally
        //   66	71	74	finally
      }
      
      /* Error */
      public final boolean eEq()
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore_2
        //   2: ldc 75
        //   4: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   7: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   10: astore_3
        //   11: invokestatic 33	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   14: astore 4
        //   16: aload_3
        //   17: ldc 35
        //   19: invokevirtual 39	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   22: aload_0
        //   23: getfield 18	com/tencent/mm/sdcard_migrate/e$a$a:mRemote	Landroid/os/IBinder;
        //   26: iconst_1
        //   27: aload_3
        //   28: aload 4
        //   30: iconst_0
        //   31: invokeinterface 54 5 0
        //   36: pop
        //   37: aload 4
        //   39: invokevirtual 57	android/os/Parcel:readException	()V
        //   42: aload 4
        //   44: invokevirtual 79	android/os/Parcel:readInt	()I
        //   47: istore_1
        //   48: iload_1
        //   49: ifeq +19 -> 68
        //   52: aload 4
        //   54: invokevirtual 60	android/os/Parcel:recycle	()V
        //   57: aload_3
        //   58: invokevirtual 60	android/os/Parcel:recycle	()V
        //   61: ldc 75
        //   63: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   66: iload_2
        //   67: ireturn
        //   68: iconst_0
        //   69: istore_2
        //   70: goto -18 -> 52
        //   73: astore 5
        //   75: aload 4
        //   77: invokevirtual 60	android/os/Parcel:recycle	()V
        //   80: aload_3
        //   81: invokevirtual 60	android/os/Parcel:recycle	()V
        //   84: ldc 75
        //   86: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   89: aload 5
        //   91: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	92	0	this	a
        //   47	2	1	i	int
        //   1	69	2	bool	boolean
        //   10	71	3	localParcel1	Parcel
        //   14	62	4	localParcel2	Parcel
        //   73	17	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   16	48	73	finally
      }
      
      public final void eEu()
      {
        AppMethodBeat.i(196844);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.sdcard_migrate.IMigrateServiceController");
          this.mRemote.transact(5, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(196844);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.e
 * JD-Core Version:    0.7.0.1
 */