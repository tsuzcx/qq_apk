package com.tencent.tmassistantsdk.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class ITMAssistantDownloadSDKServiceCallback$Stub
  extends Binder
  implements ITMAssistantDownloadSDKServiceCallback
{
  private static final String DESCRIPTOR = "com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback";
  static final int TRANSACTION_OnDownloadSDKServiceTaskProgressChanged = 2;
  static final int TRANSACTION_OnDownloadSDKServiceTaskStateChanged = 1;
  
  public ITMAssistantDownloadSDKServiceCallback$Stub()
  {
    attachInterface(this, "com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback");
  }
  
  public static ITMAssistantDownloadSDKServiceCallback asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback");
    if ((localIInterface != null) && ((localIInterface instanceof ITMAssistantDownloadSDKServiceCallback))) {
      return (ITMAssistantDownloadSDKServiceCallback)localIInterface;
    }
    return new ITMAssistantDownloadSDKServiceCallback.Stub.Proxy(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback");
      String str1 = paramParcel1.readString();
      String str2 = paramParcel1.readString();
      paramInt1 = paramParcel1.readInt();
      paramInt2 = paramParcel1.readInt();
      String str3 = paramParcel1.readString();
      boolean bool1;
      if (paramParcel1.readInt() != 0)
      {
        bool1 = true;
        if (paramParcel1.readInt() == 0) {
          break label138;
        }
      }
      label138:
      for (boolean bool2 = true;; bool2 = false)
      {
        OnDownloadSDKServiceTaskStateChanged(str1, str2, paramInt1, paramInt2, str3, bool1, bool2);
        paramParcel2.writeNoException();
        return true;
        bool1 = false;
        break;
      }
    }
    paramParcel1.enforceInterface("com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback");
    OnDownloadSDKServiceTaskProgressChanged(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readLong(), paramParcel1.readLong());
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback.Stub
 * JD-Core Version:    0.7.0.1
 */