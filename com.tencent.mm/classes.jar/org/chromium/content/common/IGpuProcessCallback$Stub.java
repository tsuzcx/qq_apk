package org.chromium.content.common;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.view.Surface;
import org.chromium.base.UnguessableToken;

public abstract class IGpuProcessCallback$Stub
  extends Binder
  implements IGpuProcessCallback
{
  private static final String DESCRIPTOR = "org.chromium.content.common.IGpuProcessCallback";
  static final int TRANSACTION_forwardSurfaceForSurfaceRequest = 1;
  static final int TRANSACTION_getViewSurface = 2;
  static final int TRANSACTION_invokeMiscMethod = 3;
  
  public IGpuProcessCallback$Stub()
  {
    attachInterface(this, "org.chromium.content.common.IGpuProcessCallback");
  }
  
  public static IGpuProcessCallback asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("org.chromium.content.common.IGpuProcessCallback");
    if ((localIInterface != null) && ((localIInterface instanceof IGpuProcessCallback))) {
      return (IGpuProcessCallback)localIInterface;
    }
    return new IGpuProcessCallback.Stub.Proxy(paramIBinder);
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
      paramParcel2.writeString("org.chromium.content.common.IGpuProcessCallback");
      return true;
    case 1: 
      paramParcel1.enforceInterface("org.chromium.content.common.IGpuProcessCallback");
      if (paramParcel1.readInt() != 0)
      {
        paramParcel2 = (UnguessableToken)UnguessableToken.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label121;
        }
      }
      for (paramParcel1 = (Surface)Surface.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        forwardSurfaceForSurfaceRequest(paramParcel2, paramParcel1);
        return true;
        paramParcel2 = null;
        break;
      }
    case 2: 
      label121:
      paramParcel1.enforceInterface("org.chromium.content.common.IGpuProcessCallback");
      paramParcel1 = getViewSurface(paramParcel1.readInt());
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
      }
      for (;;)
      {
        return true;
        paramParcel2.writeInt(0);
      }
    }
    paramParcel1.enforceInterface("org.chromium.content.common.IGpuProcessCallback");
    paramParcel2 = paramParcel1.readString();
    if (paramParcel1.readInt() != 0) {}
    for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
    {
      invokeMiscMethod(paramParcel2, paramParcel1);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     org.chromium.content.common.IGpuProcessCallback.Stub
 * JD-Core Version:    0.7.0.1
 */