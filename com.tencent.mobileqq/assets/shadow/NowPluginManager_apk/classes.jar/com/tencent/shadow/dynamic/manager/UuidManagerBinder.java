package com.tencent.shadow.dynamic.manager;

import android.os.Binder;
import android.os.Parcel;
import android.util.Log;
import com.tencent.shadow.core.common.InstalledApk;
import com.tencent.shadow.dynamic.host.FailedException;
import com.tencent.shadow.dynamic.host.NotFoundException;
import com.tencent.shadow.dynamic.host.UuidManager;

class UuidManagerBinder
  extends Binder
{
  private final PluginManagerThatUseDynamicLoader mUuidManager;
  
  UuidManagerBinder(PluginManagerThatUseDynamicLoader paramPluginManagerThatUseDynamicLoader)
  {
    this.mUuidManager = paramPluginManagerThatUseDynamicLoader;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return false;
    case 1598968902: 
      paramParcel2.writeString(UuidManager.DESCRIPTOR);
      return true;
    case 1: 
      paramParcel1.enforceInterface(UuidManager.DESCRIPTOR);
      String str = paramParcel1.readString();
      paramParcel1 = paramParcel1.readString();
      try
      {
        paramParcel1 = this.mUuidManager.getPlugin(str, paramParcel1);
        paramParcel2.writeInt(0);
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
          return true;
        }
      }
      catch (NotFoundException paramParcel1)
      {
        paramParcel2.writeInt(2);
        paramParcel1.writeToParcel(paramParcel2, 0);
        return true;
        paramParcel2.writeInt(0);
        return true;
      }
      catch (FailedException paramParcel1)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 0);
        return true;
      }
    case 2: 
      paramParcel1.enforceInterface(UuidManager.DESCRIPTOR);
      paramParcel1 = paramParcel1.readString();
      try
      {
        paramParcel1 = this.mUuidManager.getPluginLoader(paramParcel1);
        paramParcel2.writeInt(0);
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
          return true;
        }
      }
      catch (NotFoundException paramParcel1)
      {
        paramParcel2.writeInt(2);
        paramParcel1.writeToParcel(paramParcel2, 0);
        return true;
        paramParcel2.writeInt(0);
        return true;
      }
      catch (FailedException paramParcel1)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 0);
        return true;
      }
    }
    paramParcel1.enforceInterface(UuidManager.DESCRIPTOR);
    paramParcel1 = paramParcel1.readString();
    try
    {
      Log.i("InstalledDao", "mUuidManager.getRuntime(_arg0) " + paramParcel1);
      paramParcel1 = this.mUuidManager.getRuntime(paramParcel1);
      paramParcel2.writeInt(0);
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
    }
    catch (NotFoundException paramParcel1)
    {
      paramParcel2.writeInt(2);
      paramParcel1.writeToParcel(paramParcel2, 0);
      return true;
      paramParcel2.writeInt(0);
      return true;
    }
    catch (FailedException paramParcel1)
    {
      paramParcel2.writeInt(1);
      paramParcel1.writeToParcel(paramParcel2, 0);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.shadow.dynamic.manager.UuidManagerBinder
 * JD-Core Version:    0.7.0.1
 */