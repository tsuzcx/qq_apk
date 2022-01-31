package com.tencent.tmassistantsdk.aidl;

import android.os.IBinder;
import android.os.Parcel;
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
    }
  }
  
  /* Error */
  public com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo getDownloadTaskInfo(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: aload_3
    //   10: ldc 31
    //   12: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_3
    //   16: aload_1
    //   17: invokevirtual 38	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   20: aload_3
    //   21: aload_2
    //   22: invokevirtual 38	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   25: aload_0
    //   26: getfield 18	com/tencent/tmassistantsdk/aidl/ITMAssistantDownloadSDKServiceInterface$Stub$Proxy:mRemote	Landroid/os/IBinder;
    //   29: bipush 6
    //   31: aload_3
    //   32: aload 4
    //   34: iconst_0
    //   35: invokeinterface 44 5 0
    //   40: pop
    //   41: aload 4
    //   43: invokevirtual 47	android/os/Parcel:readException	()V
    //   46: aload 4
    //   48: invokevirtual 56	android/os/Parcel:readInt	()I
    //   51: ifeq +28 -> 79
    //   54: getstatic 62	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadTaskInfo:CREATOR	Landroid/os/Parcelable$Creator;
    //   57: aload 4
    //   59: invokeinterface 68 2 0
    //   64: checkcast 58	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadTaskInfo
    //   67: astore_1
    //   68: aload 4
    //   70: invokevirtual 50	android/os/Parcel:recycle	()V
    //   73: aload_3
    //   74: invokevirtual 50	android/os/Parcel:recycle	()V
    //   77: aload_1
    //   78: areturn
    //   79: aconst_null
    //   80: astore_1
    //   81: goto -13 -> 68
    //   84: astore_1
    //   85: aload 4
    //   87: invokevirtual 50	android/os/Parcel:recycle	()V
    //   90: aload_3
    //   91: invokevirtual 50	android/os/Parcel:recycle	()V
    //   94: aload_1
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	Proxy
    //   0	96	1	paramString1	String
    //   0	96	2	paramString2	String
    //   3	88	3	localParcel1	Parcel
    //   7	79	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   9	68	84	finally
  }
  
  public String getInterfaceDescriptor()
  {
    return "com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface";
  }
  
  public int getServiceVersion()
  {
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
    }
  }
  
  public boolean isAllDownloadFinished()
  {
    boolean bool = false;
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
    }
  }
  
  public void pauseDownloadTask(String paramString1, String paramString2)
  {
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
    }
  }
  
  /* Error */
  public void registerDownloadTaskCallback(String paramString, ITMAssistantDownloadSDKServiceCallback paramITMAssistantDownloadSDKServiceCallback)
  {
    // Byte code:
    //   0: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: aload_3
    //   10: ldc 31
    //   12: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_3
    //   16: aload_1
    //   17: invokevirtual 38	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   20: aload_2
    //   21: ifnull +46 -> 67
    //   24: aload_2
    //   25: invokeinterface 80 1 0
    //   30: astore_1
    //   31: aload_3
    //   32: aload_1
    //   33: invokevirtual 83	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   36: aload_0
    //   37: getfield 18	com/tencent/tmassistantsdk/aidl/ITMAssistantDownloadSDKServiceInterface$Stub$Proxy:mRemote	Landroid/os/IBinder;
    //   40: bipush 10
    //   42: aload_3
    //   43: aload 4
    //   45: iconst_0
    //   46: invokeinterface 44 5 0
    //   51: pop
    //   52: aload 4
    //   54: invokevirtual 47	android/os/Parcel:readException	()V
    //   57: aload 4
    //   59: invokevirtual 50	android/os/Parcel:recycle	()V
    //   62: aload_3
    //   63: invokevirtual 50	android/os/Parcel:recycle	()V
    //   66: return
    //   67: aconst_null
    //   68: astore_1
    //   69: goto -38 -> 31
    //   72: astore_1
    //   73: aload 4
    //   75: invokevirtual 50	android/os/Parcel:recycle	()V
    //   78: aload_3
    //   79: invokevirtual 50	android/os/Parcel:recycle	()V
    //   82: aload_1
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	Proxy
    //   0	84	1	paramString	String
    //   0	84	2	paramITMAssistantDownloadSDKServiceCallback	ITMAssistantDownloadSDKServiceCallback
    //   3	76	3	localParcel1	Parcel
    //   7	67	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   9	20	72	finally
    //   24	31	72	finally
    //   31	57	72	finally
  }
  
  public void setServiceSetingIsDownloadWifiOnly(boolean paramBoolean)
  {
    int i = 0;
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
    }
  }
  
  public void setServiceSetingIsTaskAutoResume(boolean paramBoolean)
  {
    int i = 0;
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
    }
  }
  
  public void setServiceSetingMaxTaskNum(int paramInt)
  {
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
    }
  }
  
  public int startDownloadTask(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt, String paramString4, String paramString5, Map paramMap)
  {
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
    }
  }
  
  /* Error */
  public void unregisterDownloadTaskCallback(String paramString, ITMAssistantDownloadSDKServiceCallback paramITMAssistantDownloadSDKServiceCallback)
  {
    // Byte code:
    //   0: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: aload_3
    //   10: ldc 31
    //   12: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_3
    //   16: aload_1
    //   17: invokevirtual 38	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   20: aload_2
    //   21: ifnull +46 -> 67
    //   24: aload_2
    //   25: invokeinterface 80 1 0
    //   30: astore_1
    //   31: aload_3
    //   32: aload_1
    //   33: invokevirtual 83	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   36: aload_0
    //   37: getfield 18	com/tencent/tmassistantsdk/aidl/ITMAssistantDownloadSDKServiceInterface$Stub$Proxy:mRemote	Landroid/os/IBinder;
    //   40: bipush 11
    //   42: aload_3
    //   43: aload 4
    //   45: iconst_0
    //   46: invokeinterface 44 5 0
    //   51: pop
    //   52: aload 4
    //   54: invokevirtual 47	android/os/Parcel:readException	()V
    //   57: aload 4
    //   59: invokevirtual 50	android/os/Parcel:recycle	()V
    //   62: aload_3
    //   63: invokevirtual 50	android/os/Parcel:recycle	()V
    //   66: return
    //   67: aconst_null
    //   68: astore_1
    //   69: goto -38 -> 31
    //   72: astore_1
    //   73: aload 4
    //   75: invokevirtual 50	android/os/Parcel:recycle	()V
    //   78: aload_3
    //   79: invokevirtual 50	android/os/Parcel:recycle	()V
    //   82: aload_1
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	Proxy
    //   0	84	1	paramString	String
    //   0	84	2	paramITMAssistantDownloadSDKServiceCallback	ITMAssistantDownloadSDKServiceCallback
    //   3	76	3	localParcel1	Parcel
    //   7	67	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   9	20	72	finally
    //   24	31	72	finally
    //   31	57	72	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */