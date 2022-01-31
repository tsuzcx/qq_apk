package com.tencent.shadow.dynamic.manager;

import android.content.ComponentName;
import android.os.Binder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.shadow.dynamic.loader.PluginServiceConnection;

class PluginServiceConnectionBinder
  extends Binder
{
  private final PluginServiceConnection mPsc;
  
  PluginServiceConnectionBinder(PluginServiceConnection paramPluginServiceConnection)
  {
    this.mPsc = paramPluginServiceConnection;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString(PluginServiceConnection.DESCRIPTOR);
      return true;
    case 1: 
      paramParcel1.enforceInterface(PluginServiceConnection.DESCRIPTOR);
      if (paramParcel1.readInt() != 0) {
        localObject1 = (ComponentName)ComponentName.CREATOR.createFromParcel(paramParcel1);
      }
      paramParcel1 = paramParcel1.readStrongBinder();
      this.mPsc.onServiceConnected((ComponentName)localObject1, paramParcel1);
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface(PluginServiceConnection.DESCRIPTOR);
    localObject1 = localObject2;
    if (paramParcel1.readInt() != 0) {
      localObject1 = (ComponentName)ComponentName.CREATOR.createFromParcel(paramParcel1);
    }
    this.mPsc.onServiceDisconnected((ComponentName)localObject1);
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.shadow.dynamic.manager.PluginServiceConnectionBinder
 * JD-Core Version:    0.7.0.1
 */