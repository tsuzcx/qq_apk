package com.tencent.wcdb;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

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
    }
  }
  
  public final void deactivate()
  {
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
    }
  }
  
  public final Bundle getExtras()
  {
    Parcel localParcel1;
    Parcel localParcel2;
    if (this.mExtras == null)
    {
      localParcel1 = Parcel.obtain();
      localParcel2 = Parcel.obtain();
    }
    try
    {
      localParcel1.writeInterfaceToken("android.content.IBulkCursor");
      this.mRemote.transact(5, localParcel1, localParcel2, 0);
      DatabaseUtils.readExceptionFromParcel(localParcel2);
      this.mExtras = localParcel2.readBundle(getClass().getClassLoader());
      return this.mExtras;
    }
    finally
    {
      localParcel1.recycle();
      localParcel2.recycle();
    }
  }
  
  public final CursorWindow getWindow(int paramInt)
  {
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
    }
  }
  
  public final void onMove(int paramInt)
  {
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
    }
  }
  
  /* Error */
  public final int requery(IContentObserver paramIContentObserver)
  {
    // Byte code:
    //   0: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 4
    //   5: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore 5
    //   10: aload 4
    //   12: ldc 31
    //   14: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload 4
    //   19: aload_1
    //   20: invokevirtual 90	android/os/Parcel:writeStrongInterface	(Landroid/os/IInterface;)V
    //   23: aload_0
    //   24: getfield 17	com/tencent/wcdb/BulkCursorProxy:mRemote	Landroid/os/IBinder;
    //   27: iconst_3
    //   28: aload 4
    //   30: aload 5
    //   32: iconst_0
    //   33: invokeinterface 41 5 0
    //   38: istore_3
    //   39: aload 5
    //   41: invokestatic 47	com/tencent/wcdb/DatabaseUtils:readExceptionFromParcel	(Landroid/os/Parcel;)V
    //   44: iload_3
    //   45: ifne +17 -> 62
    //   48: iconst_m1
    //   49: istore_2
    //   50: aload 4
    //   52: invokevirtual 50	android/os/Parcel:recycle	()V
    //   55: aload 5
    //   57: invokevirtual 50	android/os/Parcel:recycle	()V
    //   60: iload_2
    //   61: ireturn
    //   62: aload 5
    //   64: invokevirtual 77	android/os/Parcel:readInt	()I
    //   67: istore_2
    //   68: aload_0
    //   69: aload 5
    //   71: aload_0
    //   72: invokevirtual 57	java/lang/Object:getClass	()Ljava/lang/Class;
    //   75: invokevirtual 63	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   78: invokevirtual 67	android/os/Parcel:readBundle	(Ljava/lang/ClassLoader;)Landroid/os/Bundle;
    //   81: putfield 19	com/tencent/wcdb/BulkCursorProxy:mExtras	Landroid/os/Bundle;
    //   84: goto -34 -> 50
    //   87: astore_1
    //   88: aload 4
    //   90: invokevirtual 50	android/os/Parcel:recycle	()V
    //   93: aload 5
    //   95: invokevirtual 50	android/os/Parcel:recycle	()V
    //   98: aload_1
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	BulkCursorProxy
    //   0	100	1	paramIContentObserver	IContentObserver
    //   49	19	2	i	int
    //   38	7	3	bool	boolean
    //   3	86	4	localParcel1	Parcel
    //   8	86	5	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   10	44	87	finally
    //   62	84	87	finally
  }
  
  public final Bundle respond(Bundle paramBundle)
  {
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wcdb.BulkCursorProxy
 * JD-Core Version:    0.7.0.1
 */