package com.tencent.tmassistantsdk.aidl;

import android.os.IBinder;
import android.os.Parcel;

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
    }
  }
  
  /* Error */
  public void OnDownloadSDKServiceTaskStateChanged(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 8
    //   3: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   6: astore 9
    //   8: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   11: astore 10
    //   13: aload 9
    //   15: ldc 29
    //   17: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   20: aload 9
    //   22: aload_1
    //   23: invokevirtual 36	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   26: aload 9
    //   28: aload_2
    //   29: invokevirtual 36	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   32: aload 9
    //   34: iload_3
    //   35: invokevirtual 58	android/os/Parcel:writeInt	(I)V
    //   38: aload 9
    //   40: iload 4
    //   42: invokevirtual 58	android/os/Parcel:writeInt	(I)V
    //   45: aload 9
    //   47: aload 5
    //   49: invokevirtual 36	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   52: iload 6
    //   54: ifeq +57 -> 111
    //   57: iconst_1
    //   58: istore_3
    //   59: aload 9
    //   61: iload_3
    //   62: invokevirtual 58	android/os/Parcel:writeInt	(I)V
    //   65: iload 7
    //   67: ifeq +49 -> 116
    //   70: iload 8
    //   72: istore_3
    //   73: aload 9
    //   75: iload_3
    //   76: invokevirtual 58	android/os/Parcel:writeInt	(I)V
    //   79: aload_0
    //   80: getfield 18	com/tencent/tmassistantsdk/aidl/ITMAssistantDownloadSDKServiceCallback$Stub$Proxy:mRemote	Landroid/os/IBinder;
    //   83: iconst_1
    //   84: aload 9
    //   86: aload 10
    //   88: iconst_0
    //   89: invokeinterface 46 5 0
    //   94: pop
    //   95: aload 10
    //   97: invokevirtual 49	android/os/Parcel:readException	()V
    //   100: aload 10
    //   102: invokevirtual 52	android/os/Parcel:recycle	()V
    //   105: aload 9
    //   107: invokevirtual 52	android/os/Parcel:recycle	()V
    //   110: return
    //   111: iconst_0
    //   112: istore_3
    //   113: goto -54 -> 59
    //   116: iconst_0
    //   117: istore_3
    //   118: goto -45 -> 73
    //   121: astore_1
    //   122: aload 10
    //   124: invokevirtual 52	android/os/Parcel:recycle	()V
    //   127: aload 9
    //   129: invokevirtual 52	android/os/Parcel:recycle	()V
    //   132: aload_1
    //   133: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	Proxy
    //   0	134	1	paramString1	String
    //   0	134	2	paramString2	String
    //   0	134	3	paramInt1	int
    //   0	134	4	paramInt2	int
    //   0	134	5	paramString3	String
    //   0	134	6	paramBoolean1	boolean
    //   0	134	7	paramBoolean2	boolean
    //   1	70	8	i	int
    //   6	122	9	localParcel1	Parcel
    //   11	112	10	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   13	52	121	finally
    //   59	65	121	finally
    //   73	100	121	finally
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