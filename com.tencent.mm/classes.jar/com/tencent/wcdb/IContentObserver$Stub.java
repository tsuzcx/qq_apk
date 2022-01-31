package com.tencent.wcdb;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class IContentObserver$Stub
  extends Binder
  implements IContentObserver
{
  private static final String DESCRIPTOR = "com.tencent.wcdb.IContentObserver";
  static final int TRANSACTION_onChange = 1;
  
  public IContentObserver$Stub()
  {
    attachInterface(this, "com.tencent.wcdb.IContentObserver");
  }
  
  public static IContentObserver asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.wcdb.IContentObserver");
    if ((localIInterface != null) && ((localIInterface instanceof IContentObserver))) {
      return (IContentObserver)localIInterface;
    }
    return new IContentObserver.Stub.Proxy(paramIBinder);
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
      paramParcel2.writeString("com.tencent.wcdb.IContentObserver");
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.wcdb.IContentObserver");
    boolean bool;
    if (paramParcel1.readInt() != 0)
    {
      bool = true;
      if (paramParcel1.readInt() == 0) {
        break label97;
      }
    }
    label97:
    for (paramParcel1 = (Uri)Uri.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
    {
      onChange(bool, paramParcel1);
      return true;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wcdb.IContentObserver.Stub
 * JD-Core Version:    0.7.0.1
 */