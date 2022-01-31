package com.tencent.tmassistantsdk.aidl;

import android.os.IBinder;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

class ITMAssistantDownloadSDKServiceInterface$Stub$Proxy
  implements ITMAssistantDownloadSDKServiceInterface
{
  private IBinder mRemote;
  
  ITMAssistantDownloadSDKServiceInterface$Stub$Proxy(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public void cancelDownloadTask(String paramString1, String paramString2)
  {
    AppMethodBeat.i(75604);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface");
      localParcel1.writeString(paramString1);
      localParcel1.writeString(paramString2);
      this.mRemote.transact(9, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(75604);
    }
  }
  
  /* Error */
  public com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo getDownloadTaskInfo(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 63
    //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore_3
    //   9: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   12: astore 4
    //   14: aload_3
    //   15: ldc 38
    //   17: invokevirtual 42	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   20: aload_3
    //   21: aload_1
    //   22: invokevirtual 45	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   25: aload_3
    //   26: aload_2
    //   27: invokevirtual 45	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   30: aload_0
    //   31: getfield 18	com/tencent/tmassistantsdk/aidl/ITMAssistantDownloadSDKServiceInterface$Stub$Proxy:mRemote	Landroid/os/IBinder;
    //   34: bipush 6
    //   36: aload_3
    //   37: aload 4
    //   39: iconst_0
    //   40: invokeinterface 51 5 0
    //   45: pop
    //   46: aload 4
    //   48: invokevirtual 54	android/os/Parcel:readException	()V
    //   51: aload 4
    //   53: invokevirtual 67	android/os/Parcel:readInt	()I
    //   56: ifeq +33 -> 89
    //   59: getstatic 73	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadTaskInfo:CREATOR	Landroid/os/Parcelable$Creator;
    //   62: aload 4
    //   64: invokeinterface 79 2 0
    //   69: checkcast 69	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadTaskInfo
    //   72: astore_1
    //   73: aload 4
    //   75: invokevirtual 57	android/os/Parcel:recycle	()V
    //   78: aload_3
    //   79: invokevirtual 57	android/os/Parcel:recycle	()V
    //   82: ldc 63
    //   84: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: aload_1
    //   88: areturn
    //   89: aconst_null
    //   90: astore_1
    //   91: goto -18 -> 73
    //   94: astore_1
    //   95: aload 4
    //   97: invokevirtual 57	android/os/Parcel:recycle	()V
    //   100: aload_3
    //   101: invokevirtual 57	android/os/Parcel:recycle	()V
    //   104: ldc 63
    //   106: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: aload_1
    //   110: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	Proxy
    //   0	111	1	paramString1	String
    //   0	111	2	paramString2	String
    //   8	93	3	localParcel1	Parcel
    //   12	84	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   14	73	94	finally
  }
  
  public String getInterfaceDescriptor()
  {
    return "com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface";
  }
  
  public int getServiceVersion()
  {
    AppMethodBeat.i(75596);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface");
      this.mRemote.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(75596);
    }
  }
  
  public boolean isAllDownloadFinished()
  {
    boolean bool = false;
    AppMethodBeat.i(75600);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface");
      this.mRemote.transact(5, localParcel1, localParcel2, 0);
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
      AppMethodBeat.o(75600);
    }
  }
  
  public void pauseDownloadTask(String paramString1, String paramString2)
  {
    AppMethodBeat.i(75603);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface");
      localParcel1.writeString(paramString1);
      localParcel1.writeString(paramString2);
      this.mRemote.transact(8, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(75603);
    }
  }
  
  /* Error */
  public void registerDownloadTaskCallback(String paramString, ITMAssistantDownloadSDKServiceCallback paramITMAssistantDownloadSDKServiceCallback)
  {
    // Byte code:
    //   0: ldc 91
    //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore_3
    //   9: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   12: astore 4
    //   14: aload_3
    //   15: ldc 38
    //   17: invokevirtual 42	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   20: aload_3
    //   21: aload_1
    //   22: invokevirtual 45	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   25: aload_2
    //   26: ifnull +51 -> 77
    //   29: aload_2
    //   30: invokeinterface 95 1 0
    //   35: astore_1
    //   36: aload_3
    //   37: aload_1
    //   38: invokevirtual 98	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   41: aload_0
    //   42: getfield 18	com/tencent/tmassistantsdk/aidl/ITMAssistantDownloadSDKServiceInterface$Stub$Proxy:mRemote	Landroid/os/IBinder;
    //   45: bipush 10
    //   47: aload_3
    //   48: aload 4
    //   50: iconst_0
    //   51: invokeinterface 51 5 0
    //   56: pop
    //   57: aload 4
    //   59: invokevirtual 54	android/os/Parcel:readException	()V
    //   62: aload 4
    //   64: invokevirtual 57	android/os/Parcel:recycle	()V
    //   67: aload_3
    //   68: invokevirtual 57	android/os/Parcel:recycle	()V
    //   71: ldc 91
    //   73: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: return
    //   77: aconst_null
    //   78: astore_1
    //   79: goto -43 -> 36
    //   82: astore_1
    //   83: aload 4
    //   85: invokevirtual 57	android/os/Parcel:recycle	()V
    //   88: aload_3
    //   89: invokevirtual 57	android/os/Parcel:recycle	()V
    //   92: ldc 91
    //   94: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: aload_1
    //   98: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	this	Proxy
    //   0	99	1	paramString	String
    //   0	99	2	paramITMAssistantDownloadSDKServiceCallback	ITMAssistantDownloadSDKServiceCallback
    //   8	81	3	localParcel1	Parcel
    //   12	72	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   14	25	82	finally
    //   29	36	82	finally
    //   36	62	82	finally
  }
  
  public void setServiceSetingIsDownloadWifiOnly(boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(75598);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface");
      if (paramBoolean) {
        i = 1;
      }
      localParcel1.writeInt(i);
      this.mRemote.transact(3, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(75598);
    }
  }
  
  public void setServiceSetingIsTaskAutoResume(boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(75597);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface");
      if (paramBoolean) {
        i = 1;
      }
      localParcel1.writeInt(i);
      this.mRemote.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(75597);
    }
  }
  
  public void setServiceSetingMaxTaskNum(int paramInt)
  {
    AppMethodBeat.i(75599);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface");
      localParcel1.writeInt(paramInt);
      this.mRemote.transact(4, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(75599);
    }
  }
  
  public int startDownloadTask(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt, String paramString4, String paramString5, Map paramMap)
  {
    AppMethodBeat.i(75602);
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface");
      localParcel1.writeString(paramString1);
      localParcel1.writeString(paramString2);
      localParcel1.writeString(paramString3);
      localParcel1.writeLong(paramLong);
      localParcel1.writeInt(paramInt);
      localParcel1.writeString(paramString4);
      localParcel1.writeString(paramString5);
      localParcel1.writeMap(paramMap);
      this.mRemote.transact(7, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramInt = localParcel2.readInt();
      return paramInt;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
      AppMethodBeat.o(75602);
    }
  }
  
  /* Error */
  public void unregisterDownloadTaskCallback(String paramString, ITMAssistantDownloadSDKServiceCallback paramITMAssistantDownloadSDKServiceCallback)
  {
    // Byte code:
    //   0: ldc 121
    //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore_3
    //   9: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   12: astore 4
    //   14: aload_3
    //   15: ldc 38
    //   17: invokevirtual 42	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   20: aload_3
    //   21: aload_1
    //   22: invokevirtual 45	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   25: aload_2
    //   26: ifnull +51 -> 77
    //   29: aload_2
    //   30: invokeinterface 95 1 0
    //   35: astore_1
    //   36: aload_3
    //   37: aload_1
    //   38: invokevirtual 98	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   41: aload_0
    //   42: getfield 18	com/tencent/tmassistantsdk/aidl/ITMAssistantDownloadSDKServiceInterface$Stub$Proxy:mRemote	Landroid/os/IBinder;
    //   45: bipush 11
    //   47: aload_3
    //   48: aload 4
    //   50: iconst_0
    //   51: invokeinterface 51 5 0
    //   56: pop
    //   57: aload 4
    //   59: invokevirtual 54	android/os/Parcel:readException	()V
    //   62: aload 4
    //   64: invokevirtual 57	android/os/Parcel:recycle	()V
    //   67: aload_3
    //   68: invokevirtual 57	android/os/Parcel:recycle	()V
    //   71: ldc 121
    //   73: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: return
    //   77: aconst_null
    //   78: astore_1
    //   79: goto -43 -> 36
    //   82: astore_1
    //   83: aload 4
    //   85: invokevirtual 57	android/os/Parcel:recycle	()V
    //   88: aload_3
    //   89: invokevirtual 57	android/os/Parcel:recycle	()V
    //   92: ldc 121
    //   94: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: aload_1
    //   98: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	this	Proxy
    //   0	99	1	paramString	String
    //   0	99	2	paramITMAssistantDownloadSDKServiceCallback	ITMAssistantDownloadSDKServiceCallback
    //   8	81	3	localParcel1	Parcel
    //   12	72	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   14	25	82	finally
    //   29	36	82	finally
    //   36	62	82	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */