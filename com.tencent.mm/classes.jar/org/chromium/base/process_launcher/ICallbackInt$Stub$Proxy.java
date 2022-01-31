package org.chromium.base.process_launcher;

import android.os.IBinder;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

class ICallbackInt$Stub$Proxy
  implements ICallbackInt
{
  private IBinder mRemote;
  
  ICallbackInt$Stub$Proxy(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public void call(int paramInt)
  {
    AppMethodBeat.i(139534);
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("org.chromium.base.process_launcher.ICallbackInt");
      localParcel.writeInt(paramInt);
      this.mRemote.transact(1, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
      AppMethodBeat.o(139534);
    }
  }
  
  public String getInterfaceDescriptor()
  {
    return "org.chromium.base.process_launcher.ICallbackInt";
  }
  
  /* Error */
  public void invokeMiscMethod(String paramString, android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: ldc 61
    //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 35	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore_3
    //   9: aload_3
    //   10: ldc 37
    //   12: invokevirtual 41	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_3
    //   16: aload_1
    //   17: invokevirtual 64	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   20: aload_2
    //   21: ifnull +38 -> 59
    //   24: aload_3
    //   25: iconst_1
    //   26: invokevirtual 44	android/os/Parcel:writeInt	(I)V
    //   29: aload_2
    //   30: aload_3
    //   31: iconst_0
    //   32: invokevirtual 70	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
    //   35: aload_0
    //   36: getfield 18	org/chromium/base/process_launcher/ICallbackInt$Stub$Proxy:mRemote	Landroid/os/IBinder;
    //   39: iconst_2
    //   40: aload_3
    //   41: aconst_null
    //   42: iconst_1
    //   43: invokeinterface 50 5 0
    //   48: pop
    //   49: aload_3
    //   50: invokevirtual 53	android/os/Parcel:recycle	()V
    //   53: ldc 61
    //   55: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: return
    //   59: aload_3
    //   60: iconst_0
    //   61: invokevirtual 44	android/os/Parcel:writeInt	(I)V
    //   64: goto -29 -> 35
    //   67: astore_1
    //   68: aload_3
    //   69: invokevirtual 53	android/os/Parcel:recycle	()V
    //   72: ldc 61
    //   74: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: aload_1
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	Proxy
    //   0	79	1	paramString	String
    //   0	79	2	paramBundle	android.os.Bundle
    //   8	61	3	localParcel	Parcel
    // Exception table:
    //   from	to	target	type
    //   9	20	67	finally
    //   24	35	67	finally
    //   35	49	67	finally
    //   59	64	67	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.chromium.base.process_launcher.ICallbackInt.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */