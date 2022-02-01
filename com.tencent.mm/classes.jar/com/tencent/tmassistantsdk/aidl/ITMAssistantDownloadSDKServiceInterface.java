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
  
  public static class Default
    implements ITMAssistantDownloadSDKServiceInterface
  {
    public IBinder asBinder()
    {
      return null;
    }
    
    public void cancelDownloadTask(String paramString1, String paramString2) {}
    
    public TMAssistantDownloadTaskInfo getDownloadTaskInfo(String paramString1, String paramString2)
    {
      return null;
    }
    
    public int getServiceVersion()
    {
      return 0;
    }
    
    public boolean isAllDownloadFinished()
    {
      return false;
    }
    
    public void pauseDownloadTask(String paramString1, String paramString2) {}
    
    public void registerDownloadTaskCallback(String paramString, ITMAssistantDownloadSDKServiceCallback paramITMAssistantDownloadSDKServiceCallback) {}
    
    public void setServiceSetingIsDownloadWifiOnly(boolean paramBoolean) {}
    
    public void setServiceSetingIsTaskAutoResume(boolean paramBoolean) {}
    
    public void setServiceSetingMaxTaskNum(int paramInt) {}
    
    public int startDownloadTask(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt, String paramString4, String paramString5, Map paramMap)
    {
      return 0;
    }
    
    public void unregisterDownloadTaskCallback(String paramString, ITMAssistantDownloadSDKServiceCallback paramITMAssistantDownloadSDKServiceCallback) {}
  }
  
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
    
    public static ITMAssistantDownloadSDKServiceInterface getDefaultImpl()
    {
      return Proxy.sDefaultImpl;
    }
    
    public static boolean setDefaultImpl(ITMAssistantDownloadSDKServiceInterface paramITMAssistantDownloadSDKServiceInterface)
    {
      if ((Proxy.sDefaultImpl == null) && (paramITMAssistantDownloadSDKServiceInterface != null))
      {
        Proxy.sDefaultImpl = paramITMAssistantDownloadSDKServiceInterface;
        return true;
      }
      return false;
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
      public static ITMAssistantDownloadSDKServiceInterface sDefaultImpl;
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
          if ((!this.mRemote.transact(9, localParcel1, localParcel2, 0)) && (ITMAssistantDownloadSDKServiceInterface.Stub.getDefaultImpl() != null))
          {
            ITMAssistantDownloadSDKServiceInterface.Stub.getDefaultImpl().cancelDownloadTask(paramString1, paramString2);
            return;
          }
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
        //   0: ldc 72
        //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 39	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_3
        //   9: invokestatic 39	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   12: astore 4
        //   14: aload_3
        //   15: ldc 41
        //   17: invokevirtual 45	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_3
        //   21: aload_1
        //   22: invokevirtual 48	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   25: aload_3
        //   26: aload_2
        //   27: invokevirtual 48	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   30: aload_0
        //   31: getfield 21	com/tencent/tmassistantsdk/aidl/ITMAssistantDownloadSDKServiceInterface$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   34: bipush 6
        //   36: aload_3
        //   37: aload 4
        //   39: iconst_0
        //   40: invokeinterface 54 5 0
        //   45: ifne +36 -> 81
        //   48: invokestatic 58	com/tencent/tmassistantsdk/aidl/ITMAssistantDownloadSDKServiceInterface$Stub:getDefaultImpl	()Lcom/tencent/tmassistantsdk/aidl/ITMAssistantDownloadSDKServiceInterface;
        //   51: ifnull +30 -> 81
        //   54: invokestatic 58	com/tencent/tmassistantsdk/aidl/ITMAssistantDownloadSDKServiceInterface$Stub:getDefaultImpl	()Lcom/tencent/tmassistantsdk/aidl/ITMAssistantDownloadSDKServiceInterface;
        //   57: aload_1
        //   58: aload_2
        //   59: invokeinterface 74 3 0
        //   64: astore_1
        //   65: aload 4
        //   67: invokevirtual 63	android/os/Parcel:recycle	()V
        //   70: aload_3
        //   71: invokevirtual 63	android/os/Parcel:recycle	()V
        //   74: ldc 72
        //   76: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   79: aload_1
        //   80: areturn
        //   81: aload 4
        //   83: invokevirtual 69	android/os/Parcel:readException	()V
        //   86: aload 4
        //   88: invokevirtual 78	android/os/Parcel:readInt	()I
        //   91: ifeq +33 -> 124
        //   94: getstatic 84	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadTaskInfo:CREATOR	Landroid/os/Parcelable$Creator;
        //   97: aload 4
        //   99: invokeinterface 90 2 0
        //   104: checkcast 80	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadTaskInfo
        //   107: astore_1
        //   108: aload 4
        //   110: invokevirtual 63	android/os/Parcel:recycle	()V
        //   113: aload_3
        //   114: invokevirtual 63	android/os/Parcel:recycle	()V
        //   117: ldc 72
        //   119: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   122: aload_1
        //   123: areturn
        //   124: aconst_null
        //   125: astore_1
        //   126: goto -18 -> 108
        //   129: astore_1
        //   130: aload 4
        //   132: invokevirtual 63	android/os/Parcel:recycle	()V
        //   135: aload_3
        //   136: invokevirtual 63	android/os/Parcel:recycle	()V
        //   139: ldc 72
        //   141: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   144: aload_1
        //   145: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	146	0	this	Proxy
        //   0	146	1	paramString1	String
        //   0	146	2	paramString2	String
        //   8	128	3	localParcel1	Parcel
        //   12	119	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   14	65	129	finally
        //   81	108	129	finally
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
          if ((!this.mRemote.transact(1, localParcel1, localParcel2, 0)) && (ITMAssistantDownloadSDKServiceInterface.Stub.getDefaultImpl() != null))
          {
            i = ITMAssistantDownloadSDKServiceInterface.Stub.getDefaultImpl().getServiceVersion();
            return i;
          }
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
          if ((!this.mRemote.transact(5, localParcel1, localParcel2, 0)) && (ITMAssistantDownloadSDKServiceInterface.Stub.getDefaultImpl() != null))
          {
            bool = ITMAssistantDownloadSDKServiceInterface.Stub.getDefaultImpl().isAllDownloadFinished();
            return bool;
          }
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
          if ((!this.mRemote.transact(8, localParcel1, localParcel2, 0)) && (ITMAssistantDownloadSDKServiceInterface.Stub.getDefaultImpl() != null))
          {
            ITMAssistantDownloadSDKServiceInterface.Stub.getDefaultImpl().pauseDownloadTask(paramString1, paramString2);
            return;
          }
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
      
      public void registerDownloadTaskCallback(String paramString, ITMAssistantDownloadSDKServiceCallback paramITMAssistantDownloadSDKServiceCallback)
      {
        AppMethodBeat.i(101851);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface");
          localParcel1.writeString(paramString);
          if (paramITMAssistantDownloadSDKServiceCallback != null) {}
          for (IBinder localIBinder = paramITMAssistantDownloadSDKServiceCallback.asBinder();; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            if ((this.mRemote.transact(10, localParcel1, localParcel2, 0)) || (ITMAssistantDownloadSDKServiceInterface.Stub.getDefaultImpl() == null)) {
              break;
            }
            ITMAssistantDownloadSDKServiceInterface.Stub.getDefaultImpl().registerDownloadTaskCallback(paramString, paramITMAssistantDownloadSDKServiceCallback);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(101851);
        }
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
          if ((!this.mRemote.transact(3, localParcel1, localParcel2, 0)) && (ITMAssistantDownloadSDKServiceInterface.Stub.getDefaultImpl() != null))
          {
            ITMAssistantDownloadSDKServiceInterface.Stub.getDefaultImpl().setServiceSetingIsDownloadWifiOnly(paramBoolean);
            return;
          }
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
          if ((!this.mRemote.transact(2, localParcel1, localParcel2, 0)) && (ITMAssistantDownloadSDKServiceInterface.Stub.getDefaultImpl() != null))
          {
            ITMAssistantDownloadSDKServiceInterface.Stub.getDefaultImpl().setServiceSetingIsTaskAutoResume(paramBoolean);
            return;
          }
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
          if ((!this.mRemote.transact(4, localParcel1, localParcel2, 0)) && (ITMAssistantDownloadSDKServiceInterface.Stub.getDefaultImpl() != null))
          {
            ITMAssistantDownloadSDKServiceInterface.Stub.getDefaultImpl().setServiceSetingMaxTaskNum(paramInt);
            return;
          }
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
          if ((!this.mRemote.transact(7, localParcel1, localParcel2, 0)) && (ITMAssistantDownloadSDKServiceInterface.Stub.getDefaultImpl() != null))
          {
            paramInt = ITMAssistantDownloadSDKServiceInterface.Stub.getDefaultImpl().startDownloadTask(paramString1, paramString2, paramString3, paramLong, paramInt, paramString4, paramString5, paramMap);
            return paramInt;
          }
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
      
      public void unregisterDownloadTaskCallback(String paramString, ITMAssistantDownloadSDKServiceCallback paramITMAssistantDownloadSDKServiceCallback)
      {
        AppMethodBeat.i(101852);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface");
          localParcel1.writeString(paramString);
          if (paramITMAssistantDownloadSDKServiceCallback != null) {}
          for (IBinder localIBinder = paramITMAssistantDownloadSDKServiceCallback.asBinder();; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            if ((this.mRemote.transact(11, localParcel1, localParcel2, 0)) || (ITMAssistantDownloadSDKServiceInterface.Stub.getDefaultImpl() == null)) {
              break;
            }
            ITMAssistantDownloadSDKServiceInterface.Stub.getDefaultImpl().unregisterDownloadTaskCallback(paramString, paramITMAssistantDownloadSDKServiceCallback);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(101852);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface
 * JD-Core Version:    0.7.0.1
 */