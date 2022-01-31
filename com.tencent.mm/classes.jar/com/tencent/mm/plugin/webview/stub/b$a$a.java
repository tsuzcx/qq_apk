package com.tencent.mm.plugin.webview.stub;

import android.os.IBinder;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$a$a
  implements b
{
  private IBinder mRemote;
  
  b$a$a(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  public final IBinder asBinder()
  {
    return this.mRemote;
  }
  
  /* Error */
  public final boolean dcU()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: sipush 7059
    //   5: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 35	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   11: astore_3
    //   12: invokestatic 35	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   15: astore 4
    //   17: aload_3
    //   18: ldc 37
    //   20: invokevirtual 41	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   23: aload_0
    //   24: getfield 18	com/tencent/mm/plugin/webview/stub/b$a$a:mRemote	Landroid/os/IBinder;
    //   27: iconst_1
    //   28: aload_3
    //   29: aload 4
    //   31: iconst_0
    //   32: invokeinterface 47 5 0
    //   37: pop
    //   38: aload 4
    //   40: invokevirtual 50	android/os/Parcel:readException	()V
    //   43: aload 4
    //   45: invokevirtual 54	android/os/Parcel:readInt	()I
    //   48: istore_1
    //   49: iload_1
    //   50: ifeq +20 -> 70
    //   53: aload 4
    //   55: invokevirtual 57	android/os/Parcel:recycle	()V
    //   58: aload_3
    //   59: invokevirtual 57	android/os/Parcel:recycle	()V
    //   62: sipush 7059
    //   65: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: iload_2
    //   69: ireturn
    //   70: iconst_0
    //   71: istore_2
    //   72: goto -19 -> 53
    //   75: astore 5
    //   77: aload 4
    //   79: invokevirtual 57	android/os/Parcel:recycle	()V
    //   82: aload_3
    //   83: invokevirtual 57	android/os/Parcel:recycle	()V
    //   86: sipush 7059
    //   89: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: aload 5
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	a
    //   48	2	1	i	int
    //   1	71	2	bool	boolean
    //   11	72	3	localParcel1	Parcel
    //   15	63	4	localParcel2	Parcel
    //   75	18	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	49	75	finally
  }
  
  public final boolean getResult()
  {
    boolean bool = false;
    AppMethodBeat.i(7060);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.FavUrl_Result_AIDL");
      this.mRemote.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7060);
    }
  }
  
  public final int getRet()
  {
    AppMethodBeat.i(7061);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.FavUrl_Result_AIDL");
      this.mRemote.transact(3, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7061);
    }
  }
  
  public final int getType()
  {
    AppMethodBeat.i(7062);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.FavUrl_Result_AIDL");
      this.mRemote.transact(4, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7062);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.b.a.a
 * JD-Core Version:    0.7.0.1
 */