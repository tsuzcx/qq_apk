package com.tencent.mm.plugin.webview.stub;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract interface b
  extends IInterface
{
  public abstract boolean dcU();
  
  public abstract boolean getResult();
  
  public abstract int getRet();
  
  public abstract int getType();
  
  public static abstract class a
    extends Binder
    implements b
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.plugin.webview.stub.FavUrl_Result_AIDL");
    }
    
    public static b E(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.plugin.webview.stub.FavUrl_Result_AIDL");
      if ((localIInterface != null) && ((localIInterface instanceof b))) {
        return (b)localIInterface;
      }
      return new b.a.a(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      int j = 0;
      int i = 0;
      boolean bool;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.mm.plugin.webview.stub.FavUrl_Result_AIDL");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.FavUrl_Result_AIDL");
        bool = dcU();
        paramParcel2.writeNoException();
        paramInt1 = i;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.FavUrl_Result_AIDL");
        bool = getResult();
        paramParcel2.writeNoException();
        paramInt1 = j;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.FavUrl_Result_AIDL");
        paramInt1 = getRet();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mm.plugin.webview.stub.FavUrl_Result_AIDL");
      paramInt1 = getType();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.b
 * JD-Core Version:    0.7.0.1
 */