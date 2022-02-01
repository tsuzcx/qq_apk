package com.tencent.shadow.dynamic.a;

import android.content.ComponentName;
import android.os.Binder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.shadow.dynamic.loader.PluginServiceConnection;

class e
  extends Binder
{
  private final PluginServiceConnection a;
  
  e(PluginServiceConnection paramPluginServiceConnection)
  {
    this.a = paramPluginServiceConnection;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    if (paramInt1 != 1598968902)
    {
      Object localObject2 = null;
      Object localObject1 = null;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 2: 
        paramParcel1.enforceInterface(PluginServiceConnection.DESCRIPTOR);
        if (paramParcel1.readInt() != 0) {
          localObject1 = (ComponentName)ComponentName.CREATOR.createFromParcel(paramParcel1);
        }
        this.a.onServiceDisconnected((ComponentName)localObject1);
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface(PluginServiceConnection.DESCRIPTOR);
      localObject1 = localObject2;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (ComponentName)ComponentName.CREATOR.createFromParcel(paramParcel1);
      }
      paramParcel1 = paramParcel1.readStrongBinder();
      this.a.onServiceConnected((ComponentName)localObject1, paramParcel1);
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel2.writeString(PluginServiceConnection.DESCRIPTOR);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\live_shopping_manager_apk\classes.jar
 * Qualified Name:     com.tencent.shadow.dynamic.a.e
 * JD-Core Version:    0.7.0.1
 */