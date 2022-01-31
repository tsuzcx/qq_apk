package com.tencent.mm.plugin.wepkg.ipc;

import android.os.IBinder;

final class a$a$a
  implements a
{
  private IBinder mRemote;
  
  a$a$a(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  /* Error */
  public final void C(android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: ldc 22
    //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore_2
    //   9: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   12: astore_3
    //   13: aload_2
    //   14: ldc 36
    //   16: invokevirtual 40	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   19: aload_1
    //   20: ifnull +58 -> 78
    //   23: aload_2
    //   24: iconst_1
    //   25: invokevirtual 43	android/os/Parcel:writeInt	(I)V
    //   28: aload_1
    //   29: aload_2
    //   30: iconst_0
    //   31: invokevirtual 49	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
    //   34: aload_0
    //   35: getfield 18	com/tencent/mm/plugin/wepkg/ipc/a$a$a:mRemote	Landroid/os/IBinder;
    //   38: iconst_2
    //   39: aload_2
    //   40: aload_3
    //   41: iconst_0
    //   42: invokeinterface 55 5 0
    //   47: pop
    //   48: aload_3
    //   49: invokevirtual 58	android/os/Parcel:readException	()V
    //   52: aload_3
    //   53: invokevirtual 62	android/os/Parcel:readInt	()I
    //   56: ifeq +8 -> 64
    //   59: aload_1
    //   60: aload_3
    //   61: invokevirtual 66	android/os/Bundle:readFromParcel	(Landroid/os/Parcel;)V
    //   64: aload_3
    //   65: invokevirtual 69	android/os/Parcel:recycle	()V
    //   68: aload_2
    //   69: invokevirtual 69	android/os/Parcel:recycle	()V
    //   72: ldc 22
    //   74: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: return
    //   78: aload_2
    //   79: iconst_0
    //   80: invokevirtual 43	android/os/Parcel:writeInt	(I)V
    //   83: goto -49 -> 34
    //   86: astore_1
    //   87: aload_3
    //   88: invokevirtual 69	android/os/Parcel:recycle	()V
    //   91: aload_2
    //   92: invokevirtual 69	android/os/Parcel:recycle	()V
    //   95: ldc 22
    //   97: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: aload_1
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	a
    //   0	102	1	paramBundle	android.os.Bundle
    //   8	84	2	localParcel1	android.os.Parcel
    //   12	76	3	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   13	19	86	finally
    //   23	34	86	finally
    //   34	64	86	finally
    //   78	83	86	finally
  }
  
  public final IBinder asBinder()
  {
    return this.mRemote;
  }
  
  /* Error */
  public final void s(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: ldc 77
    //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore_2
    //   9: aload_2
    //   10: ldc 36
    //   12: invokevirtual 40	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_1
    //   16: ifnull +38 -> 54
    //   19: aload_2
    //   20: iconst_1
    //   21: invokevirtual 43	android/os/Parcel:writeInt	(I)V
    //   24: aload_1
    //   25: aload_2
    //   26: iconst_0
    //   27: invokevirtual 80	android/os/Message:writeToParcel	(Landroid/os/Parcel;I)V
    //   30: aload_0
    //   31: getfield 18	com/tencent/mm/plugin/wepkg/ipc/a$a$a:mRemote	Landroid/os/IBinder;
    //   34: iconst_1
    //   35: aload_2
    //   36: aconst_null
    //   37: iconst_1
    //   38: invokeinterface 55 5 0
    //   43: pop
    //   44: aload_2
    //   45: invokevirtual 69	android/os/Parcel:recycle	()V
    //   48: ldc 77
    //   50: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: return
    //   54: aload_2
    //   55: iconst_0
    //   56: invokevirtual 43	android/os/Parcel:writeInt	(I)V
    //   59: goto -29 -> 30
    //   62: astore_1
    //   63: aload_2
    //   64: invokevirtual 69	android/os/Parcel:recycle	()V
    //   67: ldc 77
    //   69: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	a
    //   0	74	1	paramMessage	android.os.Message
    //   8	56	2	localParcel	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   9	15	62	finally
    //   19	30	62	finally
    //   30	44	62	finally
    //   54	59	62	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.ipc.a.a.a
 * JD-Core Version:    0.7.0.1
 */