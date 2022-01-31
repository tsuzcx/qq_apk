package com.tencent.mm.plugin.webview.stub;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class e$a
  extends Binder
  implements e
{
  public e$a()
  {
    attachInterface(this, "com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
  }
  
  public static e G(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
    if ((localIInterface != null) && ((localIInterface instanceof e))) {
      return (e)localIInterface;
    }
    return new e.a.a(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    String str1 = null;
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject5 = null;
    String str2 = null;
    int j = 0;
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    int i = 0;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
      bool1 = Ke(paramParcel1.readInt());
      paramParcel2.writeNoException();
      if (bool1) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        paramParcel2.writeInt(paramInt1);
        return true;
      }
    case 2: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
      paramInt1 = paramParcel1.readInt();
      localObject1 = str2;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      bool1 = e(paramInt1, (Bundle)localObject1);
      paramParcel2.writeNoException();
      if (bool1) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        paramParcel2.writeInt(paramInt1);
        if (localObject1 == null) {
          break;
        }
        paramParcel2.writeInt(1);
        ((Bundle)localObject1).writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 == null) {
        paramParcel1 = str1;
      }
      for (;;)
      {
        bool1 = a(paramParcel1);
        paramParcel2.writeNoException();
        paramInt1 = i;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
        localObject1 = paramParcel1.queryLocalInterface("com.tencent.mm.plugin.webview.stub.OnSceneEnd_AIDL");
        if ((localObject1 != null) && ((localObject1 instanceof c))) {
          paramParcel1 = (c)localObject1;
        } else {
          paramParcel1 = new c.a.a(paramParcel1);
        }
      }
    case 4: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
      str1 = paramParcel1.readString();
      str2 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      if (paramParcel1.readInt() != 0) {}
      for (bool1 = true;; bool1 = false)
      {
        bool1 = a(str1, str2, (Bundle)localObject1, bool1);
        paramParcel2.writeNoException();
        paramInt1 = j;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      }
    case 5: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
      paramParcel1 = dcW();
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 6: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
      paramParcel1 = getCurrentUrl();
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 7: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
      paramParcel1 = dcX();
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 8: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
      paramInt1 = dcY();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 9: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      om(bool1);
      paramParcel2.writeNoException();
      return true;
    case 10: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
      bool1 = bool2;
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      on(bool1);
      paramParcel2.writeNoException();
      return true;
    case 11: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
      paramInt1 = paramParcel1.readInt();
      localObject1 = localObject2;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      t(paramInt1, (Bundle)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 12: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
      dcZ();
      paramParcel2.writeNoException();
      return true;
    case 13: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
      localObject1 = localObject3;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      af((Bundle)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 14: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
      ahL(paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 15: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
      hu(paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 16: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
      dda();
      paramParcel2.writeNoException();
      return true;
    case 17: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
      e(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 18: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
      paramInt1 = paramParcel1.readInt();
      localObject1 = localObject4;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      paramParcel1 = i(paramInt1, (Bundle)localObject1);
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 19: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
      localObject1 = localObject5;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      ag((Bundle)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 20: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
      bool1 = bool3;
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      oo(bool1);
      paramParcel2.writeNoException();
      return true;
    case 21: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
      hv(paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
    paramParcel1 = dm(paramParcel1.readString(), paramParcel1.readString());
    paramParcel2.writeNoException();
    if (paramParcel1 != null)
    {
      paramParcel2.writeInt(1);
      paramParcel1.writeToParcel(paramParcel2, 1);
      return true;
    }
    paramParcel2.writeInt(0);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.e.a
 * JD-Core Version:    0.7.0.1
 */