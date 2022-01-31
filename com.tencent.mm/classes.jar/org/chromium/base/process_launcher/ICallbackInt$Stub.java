package org.chromium.base.process_launcher;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class ICallbackInt$Stub
  extends Binder
  implements ICallbackInt
{
  private static final String DESCRIPTOR = "org.chromium.base.process_launcher.ICallbackInt";
  static final int TRANSACTION_call = 1;
  static final int TRANSACTION_invokeMiscMethod = 2;
  
  public ICallbackInt$Stub()
  {
    attachInterface(this, "org.chromium.base.process_launcher.ICallbackInt");
  }
  
  public static ICallbackInt asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("org.chromium.base.process_launcher.ICallbackInt");
    if ((localIInterface != null) && ((localIInterface instanceof ICallbackInt))) {
      return (ICallbackInt)localIInterface;
    }
    return new ICallbackInt.Stub.Proxy(paramIBinder);
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
      paramParcel2.writeString("org.chromium.base.process_launcher.ICallbackInt");
      return true;
    case 1: 
      paramParcel1.enforceInterface("org.chromium.base.process_launcher.ICallbackInt");
      call(paramParcel1.readInt());
      return true;
    }
    paramParcel1.enforceInterface("org.chromium.base.process_launcher.ICallbackInt");
    paramParcel2 = paramParcel1.readString();
    if (paramParcel1.readInt() != 0) {}
    for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
    {
      invokeMiscMethod(paramParcel2, paramParcel1);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     org.chromium.base.process_launcher.ICallbackInt.Stub
 * JD-Core Version:    0.7.0.1
 */