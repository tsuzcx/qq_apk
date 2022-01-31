package com.tencent.mm.plugin.webview.stub;

import android.os.IBinder;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$a$a
  implements c
{
  private IBinder mRemote;
  
  c$a$a(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  public final IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public final int dcV()
  {
    AppMethodBeat.i(7064);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.OnSceneEnd_AIDL");
      this.mRemote.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7064);
    }
  }
  
  /* Error */
  public final android.os.Bundle getData()
  {
    // Byte code:
    //   0: sipush 7067
    //   3: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 35	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   9: astore_2
    //   10: invokestatic 35	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   13: astore_3
    //   14: aload_2
    //   15: ldc 37
    //   17: invokevirtual 41	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   20: aload_0
    //   21: getfield 18	com/tencent/mm/plugin/webview/stub/c$a$a:mRemote	Landroid/os/IBinder;
    //   24: iconst_5
    //   25: aload_2
    //   26: aload_3
    //   27: iconst_0
    //   28: invokeinterface 47 5 0
    //   33: pop
    //   34: aload_3
    //   35: invokevirtual 50	android/os/Parcel:readException	()V
    //   38: aload_3
    //   39: invokevirtual 53	android/os/Parcel:readInt	()I
    //   42: ifeq +32 -> 74
    //   45: getstatic 67	android/os/Bundle:CREATOR	Landroid/os/Parcelable$Creator;
    //   48: aload_3
    //   49: invokeinterface 73 2 0
    //   54: checkcast 63	android/os/Bundle
    //   57: astore_1
    //   58: aload_3
    //   59: invokevirtual 56	android/os/Parcel:recycle	()V
    //   62: aload_2
    //   63: invokevirtual 56	android/os/Parcel:recycle	()V
    //   66: sipush 7067
    //   69: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: aload_1
    //   73: areturn
    //   74: aconst_null
    //   75: astore_1
    //   76: goto -18 -> 58
    //   79: astore_1
    //   80: aload_3
    //   81: invokevirtual 56	android/os/Parcel:recycle	()V
    //   84: aload_2
    //   85: invokevirtual 56	android/os/Parcel:recycle	()V
    //   88: sipush 7067
    //   91: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: aload_1
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	a
    //   57	19	1	localBundle	android.os.Bundle
    //   79	16	1	localObject	Object
    //   9	76	2	localParcel1	Parcel
    //   13	68	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   14	58	79	finally
  }
  
  public final int getErrCode()
  {
    AppMethodBeat.i(7065);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.OnSceneEnd_AIDL");
      this.mRemote.transact(3, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7065);
    }
  }
  
  public final String getErrMsg()
  {
    AppMethodBeat.i(7066);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.OnSceneEnd_AIDL");
      this.mRemote.transact(4, localParcel1, localParcel2, 0);
      localParcel2.readException();
      String str = localParcel2.readString();
      return str;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7066);
    }
  }
  
  public final int getType()
  {
    AppMethodBeat.i(7063);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.OnSceneEnd_AIDL");
      this.mRemote.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(7063);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.c.a.a
 * JD-Core Version:    0.7.0.1
 */