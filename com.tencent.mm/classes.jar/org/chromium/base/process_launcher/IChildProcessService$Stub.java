package org.chromium.base.process_launcher;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class IChildProcessService$Stub
  extends Binder
  implements IChildProcessService
{
  private static final String DESCRIPTOR = "org.chromium.base.process_launcher.IChildProcessService";
  static final int TRANSACTION_bindToCaller = 1;
  static final int TRANSACTION_crashIntentionallyForTesting = 3;
  static final int TRANSACTION_invokeMiscMethod = 4;
  static final int TRANSACTION_setupConnection = 2;
  
  public IChildProcessService$Stub()
  {
    attachInterface(this, "org.chromium.base.process_launcher.IChildProcessService");
  }
  
  public static IChildProcessService asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("org.chromium.base.process_launcher.IChildProcessService");
    if ((localIInterface != null) && ((localIInterface instanceof IChildProcessService))) {
      return (IChildProcessService)localIInterface;
    }
    return new IChildProcessService.Stub.Proxy(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Object localObject = null;
    String str = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("org.chromium.base.process_launcher.IChildProcessService");
      return true;
    case 1: 
      paramParcel1.enforceInterface("org.chromium.base.process_launcher.IChildProcessService");
      boolean bool = bindToCaller();
      paramParcel2.writeNoException();
      if (bool) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        paramParcel2.writeInt(paramInt1);
        return true;
      }
    case 2: 
      paramParcel1.enforceInterface("org.chromium.base.process_launcher.IChildProcessService");
      paramParcel2 = str;
      if (paramParcel1.readInt() != 0) {
        paramParcel2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      setupConnection(paramParcel2, ICallbackInt.Stub.asInterface(paramParcel1.readStrongBinder()), paramParcel1.createBinderArrayList());
      return true;
    case 3: 
      paramParcel1.enforceInterface("org.chromium.base.process_launcher.IChildProcessService");
      crashIntentionallyForTesting();
      return true;
    }
    paramParcel1.enforceInterface("org.chromium.base.process_launcher.IChildProcessService");
    str = paramParcel1.readString();
    paramParcel2 = localObject;
    if (paramParcel1.readInt() != 0) {
      paramParcel2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
    }
    invokeMiscMethod(str, paramParcel2);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     org.chromium.base.process_launcher.IChildProcessService.Stub
 * JD-Core Version:    0.7.0.1
 */