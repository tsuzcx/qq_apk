package com.tencent.tmassistantsdk.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import java.util.Map;

public abstract interface ITMAssistantDownloadSDKServiceInterface
  extends IInterface
{
  public abstract void cancelDownloadTask(String paramString1, String paramString2);
  
  public abstract TMAssistantDownloadTaskInfo getDownloadTaskInfo(String paramString1, String paramString2);
  
  public abstract int getServiceVersion();
  
  public abstract boolean isAllDownloadFinished();
  
  public abstract void pauseDownloadTask(String paramString1, String paramString2);
  
  public abstract void registerDownloadTaskCallback(String paramString, ITMAssistantDownloadSDKServiceCallback paramITMAssistantDownloadSDKServiceCallback);
  
  public abstract void setServiceSetingIsDownloadWifiOnly(boolean paramBoolean);
  
  public abstract void setServiceSetingIsTaskAutoResume(boolean paramBoolean);
  
  public abstract void setServiceSetingMaxTaskNum(int paramInt);
  
  public abstract int startDownloadTask(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt, String paramString4, String paramString5, Map paramMap);
  
  public abstract void unregisterDownloadTaskCallback(String paramString, ITMAssistantDownloadSDKServiceCallback paramITMAssistantDownloadSDKServiceCallback);
  
  public static abstract class Stub
    extends Binder
    implements ITMAssistantDownloadSDKServiceInterface
  {
    private static final String DESCRIPTOR = "com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface";
    static final int TRANSACTION_cancelDownloadTask = 9;
    static final int TRANSACTION_getDownloadTaskInfo = 6;
    static final int TRANSACTION_getServiceVersion = 1;
    static final int TRANSACTION_isAllDownloadFinished = 5;
    static final int TRANSACTION_pauseDownloadTask = 8;
    static final int TRANSACTION_registerDownloadTaskCallback = 10;
    static final int TRANSACTION_setServiceSetingIsDownloadWifiOnly = 3;
    static final int TRANSACTION_setServiceSetingIsTaskAutoResume = 2;
    static final int TRANSACTION_setServiceSetingMaxTaskNum = 4;
    static final int TRANSACTION_startDownloadTask = 7;
    static final int TRANSACTION_unregisterDownloadTaskCallback = 11;
    
    public Stub()
    {
      attachInterface(this, "com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface");
    }
    
    public static ITMAssistantDownloadSDKServiceInterface asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface");
      if ((localIInterface != null) && ((localIInterface instanceof ITMAssistantDownloadSDKServiceInterface))) {
        return (ITMAssistantDownloadSDKServiceInterface)localIInterface;
      }
      return new Proxy(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      boolean bool2 = false;
      int i = 0;
      boolean bool1 = false;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface");
        paramInt1 = getServiceVersion();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface");
        if (paramParcel1.readInt() != 0) {
          bool1 = true;
        }
        setServiceSetingIsTaskAutoResume(bool1);
        paramParcel2.writeNoException();
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface");
        bool1 = bool2;
        if (paramParcel1.readInt() != 0) {
          bool1 = true;
        }
        setServiceSetingIsDownloadWifiOnly(bool1);
        paramParcel2.writeNoException();
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface");
        setServiceSetingMaxTaskNum(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface");
        bool1 = isAllDownloadFinished();
        paramParcel2.writeNoException();
        paramInt1 = i;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface");
        paramParcel1 = getDownloadTaskInfo(paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface");
        paramInt1 = startDownloadTask(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readLong(), paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readHashMap(getClass().getClassLoader()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface");
        pauseDownloadTask(paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface");
        cancelDownloadTask(paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 10: 
        paramParcel1.enforceInterface("com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface");
        registerDownloadTaskCallback(paramParcel1.readString(), ITMAssistantDownloadSDKServiceCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface");
      unregisterDownloadTaskCallback(paramParcel1.readString(), ITMAssistantDownloadSDKServiceCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    }
    
    static class Proxy
      implements ITMAssistantDownloadSDKServiceInterface
    {
      private IBinder mRemote;
      
      Proxy(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public void cancelDownloadTask(String paramString1, String paramString2)
      {
        AppMethodBeat.i(101850);
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
          AppMethodBeat.o(101850);
        }
      }
      
      /* Error */
      public TMAssistantDownloadTaskInfo getDownloadTaskInfo(String paramString1, String paramString2)
      {
        // Byte code:
        //   0: ldc 64
        //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 37	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_3
        //   9: invokestatic 37	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   12: astore 4
        //   14: aload_3
        //   15: ldc 39
        //   17: invokevirtual 43	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_3
        //   21: aload_1
        //   22: invokevirtual 46	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   25: aload_3
        //   26: aload_2
        //   27: invokevirtual 46	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   30: aload_0
        //   31: getfield 19	com/tencent/tmassistantsdk/aidl/ITMAssistantDownloadSDKServiceInterface$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   34: bipush 6
        //   36: aload_3
        //   37: aload 4
        //   39: iconst_0
        //   40: invokeinterface 52 5 0
        //   45: pop
        //   46: aload 4
        //   48: invokevirtual 55	android/os/Parcel:readException	()V
        //   51: aload 4
        //   53: invokevirtual 68	android/os/Parcel:readInt	()I
        //   56: ifeq +33 -> 89
        //   59: getstatic 74	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadTaskInfo:CREATOR	Landroid/os/Parcelable$Creator;
        //   62: aload 4
        //   64: invokeinterface 80 2 0
        //   69: checkcast 70	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadTaskInfo
        //   72: astore_1
        //   73: aload 4
        //   75: invokevirtual 58	android/os/Parcel:recycle	()V
        //   78: aload_3
        //   79: invokevirtual 58	android/os/Parcel:recycle	()V
        //   82: ldc 64
        //   84: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   87: aload_1
        //   88: areturn
        //   89: aconst_null
        //   90: astore_1
        //   91: goto -18 -> 73
        //   94: astore_1
        //   95: aload 4
        //   97: invokevirtual 58	android/os/Parcel:recycle	()V
        //   100: aload_3
        //   101: invokevirtual 58	android/os/Parcel:recycle	()V
        //   104: ldc 64
        //   106: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
        AppMethodBeat.i(101842);
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
          AppMethodBeat.o(101842);
        }
      }
      
      public boolean isAllDownloadFinished()
      {
        boolean bool = false;
        AppMethodBeat.i(101846);
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
          AppMethodBeat.o(101846);
        }
      }
      
      public void pauseDownloadTask(String paramString1, String paramString2)
      {
        AppMethodBeat.i(101849);
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
          AppMethodBeat.o(101849);
        }
      }
      
      /* Error */
      public void registerDownloadTaskCallback(String paramString, ITMAssistantDownloadSDKServiceCallback paramITMAssistantDownloadSDKServiceCallback)
      {
        // Byte code:
        //   0: ldc 92
        //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 37	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_3
        //   9: invokestatic 37	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   12: astore 4
        //   14: aload_3
        //   15: ldc 39
        //   17: invokevirtual 43	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_3
        //   21: aload_1
        //   22: invokevirtual 46	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   25: aload_2
        //   26: ifnull +51 -> 77
        //   29: aload_2
        //   30: invokeinterface 96 1 0
        //   35: astore_1
        //   36: aload_3
        //   37: aload_1
        //   38: invokevirtual 99	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   41: aload_0
        //   42: getfield 19	com/tencent/tmassistantsdk/aidl/ITMAssistantDownloadSDKServiceInterface$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   45: bipush 10
        //   47: aload_3
        //   48: aload 4
        //   50: iconst_0
        //   51: invokeinterface 52 5 0
        //   56: pop
        //   57: aload 4
        //   59: invokevirtual 55	android/os/Parcel:readException	()V
        //   62: aload 4
        //   64: invokevirtual 58	android/os/Parcel:recycle	()V
        //   67: aload_3
        //   68: invokevirtual 58	android/os/Parcel:recycle	()V
        //   71: ldc 92
        //   73: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   76: return
        //   77: aconst_null
        //   78: astore_1
        //   79: goto -43 -> 36
        //   82: astore_1
        //   83: aload 4
        //   85: invokevirtual 58	android/os/Parcel:recycle	()V
        //   88: aload_3
        //   89: invokevirtual 58	android/os/Parcel:recycle	()V
        //   92: ldc 92
        //   94: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
        AppMethodBeat.i(101844);
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
          AppMethodBeat.o(101844);
        }
      }
      
      public void setServiceSetingIsTaskAutoResume(boolean paramBoolean)
      {
        int i = 0;
        AppMethodBeat.i(101843);
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
          AppMethodBeat.o(101843);
        }
      }
      
      public void setServiceSetingMaxTaskNum(int paramInt)
      {
        AppMethodBeat.i(101845);
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
          AppMethodBeat.o(101845);
        }
      }
      
      public int startDownloadTask(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt, String paramString4, String paramString5, Map paramMap)
      {
        AppMethodBeat.i(101848);
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
          AppMethodBeat.o(101848);
        }
      }
      
      /* Error */
      public void unregisterDownloadTaskCallback(String paramString, ITMAssistantDownloadSDKServiceCallback paramITMAssistantDownloadSDKServiceCallback)
      {
        // Byte code:
        //   0: ldc 122
        //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 37	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_3
        //   9: invokestatic 37	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   12: astore 4
        //   14: aload_3
        //   15: ldc 39
        //   17: invokevirtual 43	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_3
        //   21: aload_1
        //   22: invokevirtual 46	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   25: aload_2
        //   26: ifnull +51 -> 77
        //   29: aload_2
        //   30: invokeinterface 96 1 0
        //   35: astore_1
        //   36: aload_3
        //   37: aload_1
        //   38: invokevirtual 99	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   41: aload_0
        //   42: getfield 19	com/tencent/tmassistantsdk/aidl/ITMAssistantDownloadSDKServiceInterface$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   45: bipush 11
        //   47: aload_3
        //   48: aload 4
        //   50: iconst_0
        //   51: invokeinterface 52 5 0
        //   56: pop
        //   57: aload 4
        //   59: invokevirtual 55	android/os/Parcel:readException	()V
        //   62: aload 4
        //   64: invokevirtual 58	android/os/Parcel:recycle	()V
        //   67: aload_3
        //   68: invokevirtual 58	android/os/Parcel:recycle	()V
        //   71: ldc 122
        //   73: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   76: return
        //   77: aconst_null
        //   78: astore_1
        //   79: goto -43 -> 36
        //   82: astore_1
        //   83: aload 4
        //   85: invokevirtual 58	android/os/Parcel:recycle	()V
        //   88: aload_3
        //   89: invokevirtual 58	android/os/Parcel:recycle	()V
        //   92: ldc 122
        //   94: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface
 * JD-Core Version:    0.7.0.1
 */