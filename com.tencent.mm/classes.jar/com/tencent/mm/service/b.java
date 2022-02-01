package com.tencent.mm.service;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface b
  extends IInterface
{
  public abstract void a(Intent paramIntent, a parama);
  
  public abstract void bf(Intent paramIntent);
  
  public abstract void bg(Intent paramIntent);
  
  public abstract void bm(Intent paramIntent);
  
  public static abstract class a
    extends Binder
    implements b
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.service.IMMServiceStub_AIDL");
    }
    
    public static b P(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.service.IMMServiceStub_AIDL");
      if ((localIInterface != null) && ((localIInterface instanceof b))) {
        return (b)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      IInterface localIInterface = null;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.mm.service.IMMServiceStub_AIDL");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.mm.service.IMMServiceStub_AIDL");
        Intent localIntent;
        if (paramParcel1.readInt() != 0)
        {
          localIntent = (Intent)Intent.CREATOR.createFromParcel(paramParcel1);
          paramParcel1 = paramParcel1.readStrongBinder();
          if (paramParcel1 != null) {
            break label132;
          }
          paramParcel1 = localIInterface;
        }
        for (;;)
        {
          a(localIntent, paramParcel1);
          paramParcel2.writeNoException();
          return true;
          localIntent = null;
          break;
          localIInterface = paramParcel1.queryLocalInterface("com.tencent.mm.service.IMMServiceConnectionStub_AIDL");
          if ((localIInterface != null) && ((localIInterface instanceof a))) {
            paramParcel1 = (a)localIInterface;
          } else {
            paramParcel1 = new a.a.a(paramParcel1);
          }
        }
      case 2: 
        paramParcel1.enforceInterface("com.tencent.mm.service.IMMServiceStub_AIDL");
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel1 = (Intent)Intent.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          bm(paramParcel1);
          paramParcel2.writeNoException();
          return true;
        }
      case 3: 
        label132:
        paramParcel1.enforceInterface("com.tencent.mm.service.IMMServiceStub_AIDL");
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel1 = (Intent)Intent.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          bf(paramParcel1);
          paramParcel2.writeNoException();
          return true;
        }
      }
      paramParcel1.enforceInterface("com.tencent.mm.service.IMMServiceStub_AIDL");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (Intent)Intent.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        bg(paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    }
    
    static final class a
      implements b
    {
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public final void a(Intent paramIntent, a parama)
      {
        AppMethodBeat.i(125305);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.tencent.mm.service.IMMServiceStub_AIDL");
            if (paramIntent != null)
            {
              localParcel1.writeInt(1);
              paramIntent.writeToParcel(localParcel1, 0);
              if (parama != null)
              {
                paramIntent = parama.asBinder();
                localParcel1.writeStrongBinder(paramIntent);
                this.mRemote.transact(1, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramIntent = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
            AppMethodBeat.o(125305);
          }
        }
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
      
      /* Error */
      public final void bf(Intent paramIntent)
      {
        // Byte code:
        //   0: ldc 75
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
        //   31: invokevirtual 48	android/content/Intent:writeToParcel	(Landroid/os/Parcel;I)V
        //   34: aload_0
        //   35: getfield 18	com/tencent/mm/service/b$a$a:mRemote	Landroid/os/IBinder;
        //   38: iconst_3
        //   39: aload_2
        //   40: aload_3
        //   41: iconst_0
        //   42: invokeinterface 63 5 0
        //   47: pop
        //   48: aload_3
        //   49: invokevirtual 66	android/os/Parcel:readException	()V
        //   52: aload_3
        //   53: invokevirtual 69	android/os/Parcel:recycle	()V
        //   56: aload_2
        //   57: invokevirtual 69	android/os/Parcel:recycle	()V
        //   60: ldc 75
        //   62: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   65: return
        //   66: aload_2
        //   67: iconst_0
        //   68: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   71: goto -37 -> 34
        //   74: astore_1
        //   75: aload_3
        //   76: invokevirtual 69	android/os/Parcel:recycle	()V
        //   79: aload_2
        //   80: invokevirtual 69	android/os/Parcel:recycle	()V
        //   83: ldc 75
        //   85: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   88: aload_1
        //   89: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	90	0	this	a
        //   0	90	1	paramIntent	Intent
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
      public final void bg(Intent paramIntent)
      {
        // Byte code:
        //   0: ldc 77
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
        //   31: invokevirtual 48	android/content/Intent:writeToParcel	(Landroid/os/Parcel;I)V
        //   34: aload_0
        //   35: getfield 18	com/tencent/mm/service/b$a$a:mRemote	Landroid/os/IBinder;
        //   38: iconst_4
        //   39: aload_2
        //   40: aload_3
        //   41: iconst_0
        //   42: invokeinterface 63 5 0
        //   47: pop
        //   48: aload_3
        //   49: invokevirtual 66	android/os/Parcel:readException	()V
        //   52: aload_3
        //   53: invokevirtual 69	android/os/Parcel:recycle	()V
        //   56: aload_2
        //   57: invokevirtual 69	android/os/Parcel:recycle	()V
        //   60: ldc 77
        //   62: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   65: return
        //   66: aload_2
        //   67: iconst_0
        //   68: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   71: goto -37 -> 34
        //   74: astore_1
        //   75: aload_3
        //   76: invokevirtual 69	android/os/Parcel:recycle	()V
        //   79: aload_2
        //   80: invokevirtual 69	android/os/Parcel:recycle	()V
        //   83: ldc 77
        //   85: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   88: aload_1
        //   89: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	90	0	this	a
        //   0	90	1	paramIntent	Intent
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
      public final void bm(Intent paramIntent)
      {
        // Byte code:
        //   0: ldc 79
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
        //   31: invokevirtual 48	android/content/Intent:writeToParcel	(Landroid/os/Parcel;I)V
        //   34: aload_0
        //   35: getfield 18	com/tencent/mm/service/b$a$a:mRemote	Landroid/os/IBinder;
        //   38: iconst_2
        //   39: aload_2
        //   40: aload_3
        //   41: iconst_0
        //   42: invokeinterface 63 5 0
        //   47: pop
        //   48: aload_3
        //   49: invokevirtual 66	android/os/Parcel:readException	()V
        //   52: aload_3
        //   53: invokevirtual 69	android/os/Parcel:recycle	()V
        //   56: aload_2
        //   57: invokevirtual 69	android/os/Parcel:recycle	()V
        //   60: ldc 79
        //   62: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   65: return
        //   66: aload_2
        //   67: iconst_0
        //   68: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   71: goto -37 -> 34
        //   74: astore_1
        //   75: aload_3
        //   76: invokevirtual 69	android/os/Parcel:recycle	()V
        //   79: aload_2
        //   80: invokevirtual 69	android/os/Parcel:recycle	()V
        //   83: ldc 79
        //   85: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   88: aload_1
        //   89: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	90	0	this	a
        //   0	90	1	paramIntent	Intent
        //   8	72	2	localParcel1	Parcel
        //   12	64	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   13	19	74	finally
        //   23	34	74	finally
        //   34	52	74	finally
        //   66	71	74	finally
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.service.b
 * JD-Core Version:    0.7.0.1
 */