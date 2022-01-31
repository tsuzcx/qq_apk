package com.tencent.tmassistantsdk.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;

public abstract class ITMAssistantDownloadSDKServiceInterface$Stub
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
  
  public ITMAssistantDownloadSDKServiceInterface$Stub()
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
    return new ITMAssistantDownloadSDKServiceInterface.Stub.Proxy(paramIBinder);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface.Stub
 * JD-Core Version:    0.7.0.1
 */