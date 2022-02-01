package com.tencent.shadow.dynamic.a;

import android.content.ComponentName;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.shadow.dynamic.loader.PluginLoader;
import com.tencent.shadow.dynamic.loader.PluginServiceConnection;
import java.util.HashMap;
import java.util.Map;

class b
  implements PluginLoader
{
  private final IBinder a;
  
  b(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public boolean bindPluginService(Intent paramIntent, PluginServiceConnection paramPluginServiceConnection, int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken(DESCRIPTOR);
        boolean bool = true;
        if (paramIntent != null)
        {
          localParcel1.writeInt(1);
          paramIntent.writeToParcel(localParcel1, 0);
        }
        else
        {
          localParcel1.writeInt(0);
        }
        if (paramPluginServiceConnection != null)
        {
          paramIntent = new e(paramPluginServiceConnection);
          localParcel1.writeStrongBinder(paramIntent);
          localParcel1.writeInt(paramInt);
          this.a.transact(7, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramInt = localParcel2.readInt();
          if (paramInt == 0) {
            bool = false;
          }
          return bool;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      paramIntent = null;
    }
  }
  
  public void callApplicationOnCreate(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken(DESCRIPTOR);
      localParcel1.writeString(paramString);
      this.a.transact(3, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public Intent convertActivityIntent(Intent paramIntent)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken(DESCRIPTOR);
      if (paramIntent != null)
      {
        localParcel1.writeInt(1);
        paramIntent.writeToParcel(localParcel1, 0);
      }
      else
      {
        localParcel1.writeInt(0);
      }
      this.a.transact(4, localParcel1, localParcel2, 0);
      localParcel2.readException();
      if (localParcel2.readInt() != 0) {
        paramIntent = (Intent)Intent.CREATOR.createFromParcel(localParcel2);
      } else {
        paramIntent = null;
      }
      return paramIntent;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public Map getLoadedPlugin()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken(DESCRIPTOR);
      this.a.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      HashMap localHashMap = localParcel2.readHashMap(getClass().getClassLoader());
      return localHashMap;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void loadPlugin(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken(DESCRIPTOR);
      localParcel1.writeString(paramString);
      this.a.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public ComponentName startPluginService(Intent paramIntent)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken(DESCRIPTOR);
      if (paramIntent != null)
      {
        localParcel1.writeInt(1);
        paramIntent.writeToParcel(localParcel1, 0);
      }
      else
      {
        localParcel1.writeInt(0);
      }
      this.a.transact(5, localParcel1, localParcel2, 0);
      localParcel2.readException();
      if (localParcel2.readInt() != 0) {
        paramIntent = (ComponentName)ComponentName.CREATOR.createFromParcel(localParcel2);
      } else {
        paramIntent = null;
      }
      return paramIntent;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public boolean stopPluginService(Intent paramIntent)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken(DESCRIPTOR);
      boolean bool = true;
      if (paramIntent != null)
      {
        localParcel1.writeInt(1);
        paramIntent.writeToParcel(localParcel1, 0);
      }
      else
      {
        localParcel1.writeInt(0);
      }
      this.a.transact(6, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      if (i == 0) {
        bool = false;
      }
      return bool;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void unbindService(PluginServiceConnection paramPluginServiceConnection)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken(DESCRIPTOR);
        if (paramPluginServiceConnection != null)
        {
          paramPluginServiceConnection = new e(paramPluginServiceConnection);
          localParcel1.writeStrongBinder(paramPluginServiceConnection);
          this.a.transact(8, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      paramPluginServiceConnection = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\live_shopping_manager_apk\classes.jar
 * Qualified Name:     com.tencent.shadow.dynamic.a.b
 * JD-Core Version:    0.7.0.1
 */