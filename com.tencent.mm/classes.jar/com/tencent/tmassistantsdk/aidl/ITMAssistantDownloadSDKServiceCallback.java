package com.tencent.tmassistantsdk.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface ITMAssistantDownloadSDKServiceCallback
  extends IInterface
{
  public abstract void OnDownloadSDKServiceTaskProgressChanged(String paramString1, String paramString2, long paramLong1, long paramLong2);
  
  public abstract void OnDownloadSDKServiceTaskStateChanged(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, boolean paramBoolean1, boolean paramBoolean2);
  
  public static class Default
    implements ITMAssistantDownloadSDKServiceCallback
  {
    public void OnDownloadSDKServiceTaskProgressChanged(String paramString1, String paramString2, long paramLong1, long paramLong2) {}
    
    public void OnDownloadSDKServiceTaskStateChanged(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, boolean paramBoolean1, boolean paramBoolean2) {}
    
    public IBinder asBinder()
    {
      return null;
    }
  }
  
  public static abstract class Stub
    extends Binder
    implements ITMAssistantDownloadSDKServiceCallback
  {
    private static final String DESCRIPTOR = "com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback";
    static final int TRANSACTION_OnDownloadSDKServiceTaskProgressChanged = 2;
    static final int TRANSACTION_OnDownloadSDKServiceTaskStateChanged = 1;
    
    public Stub()
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
      return new Proxy(paramIBinder);
    }
    
    public static ITMAssistantDownloadSDKServiceCallback getDefaultImpl()
    {
      return Proxy.sDefaultImpl;
    }
    
    public static boolean setDefaultImpl(ITMAssistantDownloadSDKServiceCallback paramITMAssistantDownloadSDKServiceCallback)
    {
      if (Proxy.sDefaultImpl != null) {
        throw new IllegalStateException("setDefaultImpl() called twice");
      }
      if (paramITMAssistantDownloadSDKServiceCallback != null)
      {
        Proxy.sDefaultImpl = paramITMAssistantDownloadSDKServiceCallback;
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
    
    static class Proxy
      implements ITMAssistantDownloadSDKServiceCallback
    {
      public static ITMAssistantDownloadSDKServiceCallback sDefaultImpl;
      private IBinder mRemote;
      
      Proxy(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public void OnDownloadSDKServiceTaskProgressChanged(String paramString1, String paramString2, long paramLong1, long paramLong2)
      {
        AppMethodBeat.i(101841);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          localParcel1.writeLong(paramLong1);
          localParcel1.writeLong(paramLong2);
          if ((!this.mRemote.transact(2, localParcel1, localParcel2, 0)) && (ITMAssistantDownloadSDKServiceCallback.Stub.getDefaultImpl() != null))
          {
            ITMAssistantDownloadSDKServiceCallback.Stub.getDefaultImpl().OnDownloadSDKServiceTaskProgressChanged(paramString1, paramString2, paramLong1, paramLong2);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(101841);
        }
      }
      
      public void OnDownloadSDKServiceTaskStateChanged(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
      {
        AppMethodBeat.i(101840);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          localParcel1.writeString(paramString3);
          if (paramBoolean1)
          {
            i = 1;
            localParcel1.writeInt(i);
            if (!paramBoolean2) {
              break label149;
            }
          }
          label149:
          for (int i = 1;; i = 0)
          {
            localParcel1.writeInt(i);
            if ((this.mRemote.transact(1, localParcel1, localParcel2, 0)) || (ITMAssistantDownloadSDKServiceCallback.Stub.getDefaultImpl() == null)) {
              break label155;
            }
            ITMAssistantDownloadSDKServiceCallback.Stub.getDefaultImpl().OnDownloadSDKServiceTaskStateChanged(paramString1, paramString2, paramInt1, paramInt2, paramString3, paramBoolean1, paramBoolean2);
            return;
            i = 0;
            break;
          }
          label155:
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(101840);
        }
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback
 * JD-Core Version:    0.7.0.1
 */