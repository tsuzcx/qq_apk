package com.tencent.wcdb;

import android.os.IBinder;

class IContentObserver$Stub$Proxy
  implements IContentObserver
{
  private IBinder mRemote;
  
  IContentObserver$Stub$Proxy(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public String getInterfaceDescriptor()
  {
    return "com.tencent.wcdb.IContentObserver";
  }
  
  /* Error */
  public void onChange(boolean paramBoolean, android.net.Uri paramUri)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: sipush 12173
    //   5: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 39	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   11: astore 4
    //   13: aload 4
    //   15: ldc 25
    //   17: invokevirtual 43	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   20: iload_1
    //   21: ifeq +53 -> 74
    //   24: aload 4
    //   26: iload_3
    //   27: invokevirtual 46	android/os/Parcel:writeInt	(I)V
    //   30: aload_2
    //   31: ifnull +48 -> 79
    //   34: aload 4
    //   36: iconst_1
    //   37: invokevirtual 46	android/os/Parcel:writeInt	(I)V
    //   40: aload_2
    //   41: aload 4
    //   43: iconst_0
    //   44: invokevirtual 52	android/net/Uri:writeToParcel	(Landroid/os/Parcel;I)V
    //   47: aload_0
    //   48: getfield 18	com/tencent/wcdb/IContentObserver$Stub$Proxy:mRemote	Landroid/os/IBinder;
    //   51: iconst_1
    //   52: aload 4
    //   54: aconst_null
    //   55: iconst_1
    //   56: invokeinterface 58 5 0
    //   61: pop
    //   62: aload 4
    //   64: invokevirtual 61	android/os/Parcel:recycle	()V
    //   67: sipush 12173
    //   70: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: return
    //   74: iconst_0
    //   75: istore_3
    //   76: goto -52 -> 24
    //   79: aload 4
    //   81: iconst_0
    //   82: invokevirtual 46	android/os/Parcel:writeInt	(I)V
    //   85: goto -38 -> 47
    //   88: astore_2
    //   89: aload 4
    //   91: invokevirtual 61	android/os/Parcel:recycle	()V
    //   94: sipush 12173
    //   97: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: aload_2
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	Proxy
    //   0	102	1	paramBoolean	boolean
    //   0	102	2	paramUri	android.net.Uri
    //   1	75	3	i	int
    //   11	79	4	localParcel	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   13	20	88	finally
    //   24	30	88	finally
    //   34	47	88	finally
    //   47	62	88	finally
    //   79	85	88	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wcdb.IContentObserver.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */