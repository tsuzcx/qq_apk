package com.tencent.mm.plugin.webview.luggage.ipc;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class a$a
  extends Binder
  implements a
{
  public a$a()
  {
    attachInterface(this, "com.tencent.mm.plugin.webview.luggage.ipc.IMainProcessService");
  }
  
  public static a F(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.plugin.webview.luggage.ipc.IMainProcessService");
    if ((localIInterface != null) && ((localIInterface instanceof a))) {
      return (a)localIInterface;
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
    Object localObject1 = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.tencent.mm.plugin.webview.luggage.ipc.IMainProcessService");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.luggage.ipc.IMainProcessService");
      paramParcel2 = (Parcel)localObject1;
      if (paramParcel1.readInt() != 0) {
        paramParcel2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      s(paramParcel2);
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.luggage.ipc.IMainProcessService");
      localObject1 = localObject2;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      t((Bundle)localObject1);
      paramParcel2.writeNoException();
      if (localObject1 != null)
      {
        paramParcel2.writeInt(1);
        ((Bundle)localObject1).writeToParcel(paramParcel2, 1);
      }
      for (;;)
      {
        return true;
        paramParcel2.writeInt(0);
      }
    }
    paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.luggage.ipc.IMainProcessService");
    a(paramParcel1.readStrongBinder(), paramParcel1.readString());
    paramParcel2.writeNoException();
    return true;
  }
  
  private static final class a
    implements a
  {
    private IBinder mRemote;
    
    a(IBinder paramIBinder)
    {
      this.mRemote = paramIBinder;
    }
    
    public final void a(IBinder paramIBinder, String paramString)
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.luggage.ipc.IMainProcessService");
        localParcel1.writeStrongBinder(paramIBinder);
        localParcel1.writeString(paramString);
        this.mRemote.transact(3, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
    
    public final IBinder asBinder()
    {
      return this.mRemote;
    }
    
    /* Error */
    public final void s(Bundle paramBundle)
    {
      // Byte code:
      //   0: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   3: astore_2
      //   4: aload_2
      //   5: ldc 28
      //   7: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   10: aload_1
      //   11: ifnull +33 -> 44
      //   14: aload_2
      //   15: iconst_1
      //   16: invokevirtual 58	android/os/Parcel:writeInt	(I)V
      //   19: aload_1
      //   20: aload_2
      //   21: iconst_0
      //   22: invokevirtual 64	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
      //   25: aload_0
      //   26: getfield 18	com/tencent/mm/plugin/webview/luggage/ipc/a$a$a:mRemote	Landroid/os/IBinder;
      //   29: iconst_1
      //   30: aload_2
      //   31: aconst_null
      //   32: iconst_1
      //   33: invokeinterface 44 5 0
      //   38: pop
      //   39: aload_2
      //   40: invokevirtual 50	android/os/Parcel:recycle	()V
      //   43: return
      //   44: aload_2
      //   45: iconst_0
      //   46: invokevirtual 58	android/os/Parcel:writeInt	(I)V
      //   49: goto -24 -> 25
      //   52: astore_1
      //   53: aload_2
      //   54: invokevirtual 50	android/os/Parcel:recycle	()V
      //   57: aload_1
      //   58: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	59	0	this	a
      //   0	59	1	paramBundle	Bundle
      //   3	51	2	localParcel	Parcel
      // Exception table:
      //   from	to	target	type
      //   4	10	52	finally
      //   14	25	52	finally
      //   25	39	52	finally
      //   44	49	52	finally
    }
    
    /* Error */
    public final void t(Bundle paramBundle)
    {
      // Byte code:
      //   0: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   3: astore_2
      //   4: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   7: astore_3
      //   8: aload_2
      //   9: ldc 28
      //   11: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   14: aload_1
      //   15: ifnull +53 -> 68
      //   18: aload_2
      //   19: iconst_1
      //   20: invokevirtual 58	android/os/Parcel:writeInt	(I)V
      //   23: aload_1
      //   24: aload_2
      //   25: iconst_0
      //   26: invokevirtual 64	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
      //   29: aload_0
      //   30: getfield 18	com/tencent/mm/plugin/webview/luggage/ipc/a$a$a:mRemote	Landroid/os/IBinder;
      //   33: iconst_2
      //   34: aload_2
      //   35: aload_3
      //   36: iconst_0
      //   37: invokeinterface 44 5 0
      //   42: pop
      //   43: aload_3
      //   44: invokevirtual 47	android/os/Parcel:readException	()V
      //   47: aload_3
      //   48: invokevirtual 69	android/os/Parcel:readInt	()I
      //   51: ifeq +8 -> 59
      //   54: aload_1
      //   55: aload_3
      //   56: invokevirtual 73	android/os/Bundle:readFromParcel	(Landroid/os/Parcel;)V
      //   59: aload_3
      //   60: invokevirtual 50	android/os/Parcel:recycle	()V
      //   63: aload_2
      //   64: invokevirtual 50	android/os/Parcel:recycle	()V
      //   67: return
      //   68: aload_2
      //   69: iconst_0
      //   70: invokevirtual 58	android/os/Parcel:writeInt	(I)V
      //   73: goto -44 -> 29
      //   76: astore_1
      //   77: aload_3
      //   78: invokevirtual 50	android/os/Parcel:recycle	()V
      //   81: aload_2
      //   82: invokevirtual 50	android/os/Parcel:recycle	()V
      //   85: aload_1
      //   86: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	87	0	this	a
      //   0	87	1	paramBundle	Bundle
      //   3	79	2	localParcel1	Parcel
      //   7	71	3	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   8	14	76	finally
      //   18	29	76	finally
      //   29	59	76	finally
      //   68	73	76	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.ipc.a.a
 * JD-Core Version:    0.7.0.1
 */