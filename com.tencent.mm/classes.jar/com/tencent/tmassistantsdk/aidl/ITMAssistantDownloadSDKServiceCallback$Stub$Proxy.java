package com.tencent.tmassistantsdk.aidl;

import android.os.IBinder;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

class ITMAssistantDownloadSDKServiceCallback$Stub$Proxy
  implements ITMAssistantDownloadSDKServiceCallback
{
  private IBinder mRemote;
  
  ITMAssistantDownloadSDKServiceCallback$Stub$Proxy(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  public void OnDownloadSDKServiceTaskProgressChanged(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(75595);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback");
      localParcel1.writeString(paramString1);
      localParcel1.writeString(paramString2);
      localParcel1.writeLong(paramLong1);
      localParcel1.writeLong(paramLong2);
      this.mRemote.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(75595);
    }
  }
  
  /* Error */
  public void OnDownloadSDKServiceTaskStateChanged(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 8
    //   3: ldc 65
    //   5: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   11: astore 9
    //   13: invokestatic 34	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   16: astore 10
    //   18: aload 9
    //   20: ldc 36
    //   22: invokevirtual 40	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   25: aload 9
    //   27: aload_1
    //   28: invokevirtual 43	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   31: aload 9
    //   33: aload_2
    //   34: invokevirtual 43	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   37: aload 9
    //   39: iload_3
    //   40: invokevirtual 68	android/os/Parcel:writeInt	(I)V
    //   43: aload 9
    //   45: iload 4
    //   47: invokevirtual 68	android/os/Parcel:writeInt	(I)V
    //   50: aload 9
    //   52: aload 5
    //   54: invokevirtual 43	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   57: iload 6
    //   59: ifeq +62 -> 121
    //   62: iconst_1
    //   63: istore_3
    //   64: aload 9
    //   66: iload_3
    //   67: invokevirtual 68	android/os/Parcel:writeInt	(I)V
    //   70: iload 7
    //   72: ifeq +54 -> 126
    //   75: iload 8
    //   77: istore_3
    //   78: aload 9
    //   80: iload_3
    //   81: invokevirtual 68	android/os/Parcel:writeInt	(I)V
    //   84: aload_0
    //   85: getfield 18	com/tencent/tmassistantsdk/aidl/ITMAssistantDownloadSDKServiceCallback$Stub$Proxy:mRemote	Landroid/os/IBinder;
    //   88: iconst_1
    //   89: aload 9
    //   91: aload 10
    //   93: iconst_0
    //   94: invokeinterface 53 5 0
    //   99: pop
    //   100: aload 10
    //   102: invokevirtual 56	android/os/Parcel:readException	()V
    //   105: aload 10
    //   107: invokevirtual 59	android/os/Parcel:recycle	()V
    //   110: aload 9
    //   112: invokevirtual 59	android/os/Parcel:recycle	()V
    //   115: ldc 65
    //   117: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: return
    //   121: iconst_0
    //   122: istore_3
    //   123: goto -59 -> 64
    //   126: iconst_0
    //   127: istore_3
    //   128: goto -50 -> 78
    //   131: astore_1
    //   132: aload 10
    //   134: invokevirtual 59	android/os/Parcel:recycle	()V
    //   137: aload 9
    //   139: invokevirtual 59	android/os/Parcel:recycle	()V
    //   142: ldc 65
    //   144: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   147: aload_1
    //   148: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	this	Proxy
    //   0	149	1	paramString1	String
    //   0	149	2	paramString2	String
    //   0	149	3	paramInt1	int
    //   0	149	4	paramInt2	int
    //   0	149	5	paramString3	String
    //   0	149	6	paramBoolean1	boolean
    //   0	149	7	paramBoolean2	boolean
    //   1	75	8	i	int
    //   11	127	9	localParcel1	Parcel
    //   16	117	10	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   18	57	131	finally
    //   64	70	131	finally
    //   78	105	131	finally
  }
  
  public IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public String getInterfaceDescriptor()
  {
    return "com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */