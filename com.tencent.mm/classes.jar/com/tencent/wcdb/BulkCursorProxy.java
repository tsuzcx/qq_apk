package com.tencent.wcdb;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BulkCursorProxy
  implements IBulkCursor
{
  private Bundle mExtras;
  private IBinder mRemote;
  
  public BulkCursorProxy(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
    this.mExtras = null;
  }
  
  public final IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public final void close()
  {
    AppMethodBeat.i(2651);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("android.content.IBulkCursor");
      this.mRemote.transact(7, localParcel1, localParcel2, 0);
      DatabaseUtils.readExceptionFromParcel(localParcel2);
      return;
    }
    finally
    {
      localParcel1.recycle();
      localParcel2.recycle();
      AppMethodBeat.o(2651);
    }
  }
  
  public final void deactivate()
  {
    AppMethodBeat.i(2650);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("android.content.IBulkCursor");
      this.mRemote.transact(2, localParcel1, localParcel2, 0);
      DatabaseUtils.readExceptionFromParcel(localParcel2);
      return;
    }
    finally
    {
      localParcel1.recycle();
      localParcel2.recycle();
      AppMethodBeat.o(2650);
    }
  }
  
  public final Bundle getExtras()
  {
    AppMethodBeat.i(2653);
    Object localObject1;
    Parcel localParcel;
    if (this.mExtras == null)
    {
      localObject1 = Parcel.obtain();
      localParcel = Parcel.obtain();
    }
    try
    {
      ((Parcel)localObject1).writeInterfaceToken("android.content.IBulkCursor");
      this.mRemote.transact(5, (Parcel)localObject1, localParcel, 0);
      DatabaseUtils.readExceptionFromParcel(localParcel);
      this.mExtras = localParcel.readBundle(getClass().getClassLoader());
      ((Parcel)localObject1).recycle();
      localParcel.recycle();
      localObject1 = this.mExtras;
      AppMethodBeat.o(2653);
      return localObject1;
    }
    finally
    {
      ((Parcel)localObject1).recycle();
      localParcel.recycle();
      AppMethodBeat.o(2653);
    }
  }
  
  public final CursorWindow getWindow(int paramInt)
  {
    AppMethodBeat.i(2648);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("android.content.IBulkCursor");
      localParcel1.writeInt(paramInt);
      this.mRemote.transact(1, localParcel1, localParcel2, 0);
      DatabaseUtils.readExceptionFromParcel(localParcel2);
      CursorWindow localCursorWindow = null;
      if (localParcel2.readInt() == 1) {
        localCursorWindow = CursorWindow.newFromParcel(localParcel2);
      }
      return localCursorWindow;
    }
    finally
    {
      localParcel1.recycle();
      localParcel2.recycle();
      AppMethodBeat.o(2648);
    }
  }
  
  public final void onMove(int paramInt)
  {
    AppMethodBeat.i(2649);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("android.content.IBulkCursor");
      localParcel1.writeInt(paramInt);
      this.mRemote.transact(4, localParcel1, localParcel2, 0);
      DatabaseUtils.readExceptionFromParcel(localParcel2);
      return;
    }
    finally
    {
      localParcel1.recycle();
      localParcel2.recycle();
      AppMethodBeat.o(2649);
    }
  }
  
  /* Error */
  public final int requery(IContentObserver paramIContentObserver)
  {
    // Byte code:
    //   0: sipush 2652
    //   3: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 35	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   9: astore 4
    //   11: invokestatic 35	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   14: astore 5
    //   16: aload 4
    //   18: ldc 37
    //   20: invokevirtual 41	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   23: aload 4
    //   25: aload_1
    //   26: invokevirtual 98	android/os/Parcel:writeStrongInterface	(Landroid/os/IInterface;)V
    //   29: aload_0
    //   30: getfield 17	com/tencent/wcdb/BulkCursorProxy:mRemote	Landroid/os/IBinder;
    //   33: iconst_3
    //   34: aload 4
    //   36: aload 5
    //   38: iconst_0
    //   39: invokeinterface 47 5 0
    //   44: istore_3
    //   45: aload 5
    //   47: invokestatic 53	com/tencent/wcdb/DatabaseUtils:readExceptionFromParcel	(Landroid/os/Parcel;)V
    //   50: iload_3
    //   51: ifne +23 -> 74
    //   54: iconst_m1
    //   55: istore_2
    //   56: aload 4
    //   58: invokevirtual 56	android/os/Parcel:recycle	()V
    //   61: aload 5
    //   63: invokevirtual 56	android/os/Parcel:recycle	()V
    //   66: sipush 2652
    //   69: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: iload_2
    //   73: ireturn
    //   74: aload 5
    //   76: invokevirtual 85	android/os/Parcel:readInt	()I
    //   79: istore_2
    //   80: aload_0
    //   81: aload 5
    //   83: aload_0
    //   84: invokevirtual 66	java/lang/Object:getClass	()Ljava/lang/Class;
    //   87: invokevirtual 72	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   90: invokevirtual 76	android/os/Parcel:readBundle	(Ljava/lang/ClassLoader;)Landroid/os/Bundle;
    //   93: putfield 19	com/tencent/wcdb/BulkCursorProxy:mExtras	Landroid/os/Bundle;
    //   96: goto -40 -> 56
    //   99: astore_1
    //   100: aload 4
    //   102: invokevirtual 56	android/os/Parcel:recycle	()V
    //   105: aload 5
    //   107: invokevirtual 56	android/os/Parcel:recycle	()V
    //   110: sipush 2652
    //   113: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   116: aload_1
    //   117: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	BulkCursorProxy
    //   0	118	1	paramIContentObserver	IContentObserver
    //   55	25	2	i	int
    //   44	7	3	bool	boolean
    //   9	92	4	localParcel1	Parcel
    //   14	92	5	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   16	50	99	finally
    //   74	96	99	finally
  }
  
  public final Bundle respond(Bundle paramBundle)
  {
    AppMethodBeat.i(2654);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("android.content.IBulkCursor");
      localParcel1.writeBundle(paramBundle);
      this.mRemote.transact(6, localParcel1, localParcel2, 0);
      DatabaseUtils.readExceptionFromParcel(localParcel2);
      paramBundle = localParcel2.readBundle(getClass().getClassLoader());
      return paramBundle;
    }
    finally
    {
      localParcel1.recycle();
      localParcel2.recycle();
      AppMethodBeat.o(2654);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wcdb.BulkCursorProxy
 * JD-Core Version:    0.7.0.1
 */