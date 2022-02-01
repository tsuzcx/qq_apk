package com.tencent.shadow.dynamic.a;

import android.content.ComponentName;
import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.shadow.core.common.Logger;
import com.tencent.shadow.core.common.LoggerFactory;
import com.tencent.shadow.dynamic.host.MultiLoaderPluginProcessService;
import com.tencent.shadow.dynamic.host.MultiLoaderPpsController;
import com.tencent.shadow.dynamic.host.PluginManagerImpl;
import com.tencent.shadow.dynamic.host.PpsStatus;
import com.tencent.shadow.dynamic.loader.PluginLoader;

public abstract class c
  extends a
  implements PluginManagerImpl
{
  private static final Logger e = LoggerFactory.getLogger(d.class);
  protected MultiLoaderPpsController c;
  protected PluginLoader d;
  
  public c(Context paramContext)
  {
    super(paramContext);
  }
  
  protected void a(ComponentName paramComponentName)
  {
    this.c = null;
    this.d = null;
  }
  
  protected void a(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.c = MultiLoaderPluginProcessService.wrapBinder(paramIBinder);
    try
    {
      this.c.setUuidManagerForPlugin(d(), new f(this));
    }
    catch (RemoteException localRemoteException)
    {
      if (localRemoteException.getClass().getSimpleName().equals("TransactionTooLargeException"))
      {
        if (e.isErrorEnabled())
        {
          localLogger = e;
          paramComponentName = new StringBuilder();
          paramIBinder = "onServiceConnected TransactionTooLargeException:";
          paramComponentName.append(paramIBinder);
          paramComponentName.append(localRemoteException);
          localLogger.error(paramComponentName.toString());
        }
      }
      else {
        throw new RuntimeException(localRemoteException);
      }
    }
    catch (DeadObjectException localDeadObjectException)
    {
      Logger localLogger;
      while (e.isErrorEnabled())
      {
        localLogger = e;
        paramComponentName = new StringBuilder();
        paramIBinder = "onServiceConnected RemoteException:";
      }
    }
    try
    {
      paramComponentName = this.c.getPluginLoaderForPlugin(d());
      if (paramComponentName != null)
      {
        this.d = new b(paramComponentName);
        return;
      }
    }
    catch (RemoteException paramComponentName)
    {
      if (e.isErrorEnabled()) {
        e.error("onServiceConnected mPpsController getPluginLoader:", paramComponentName);
      }
    }
  }
  
  public abstract String d();
  
  public final void d(String paramString)
  {
    if (e.isInfoEnabled())
    {
      Logger localLogger = e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadRunTime mPpsController:");
      localStringBuilder.append(this.c);
      localLogger.info(localStringBuilder.toString());
    }
    if (!this.c.getPpsStatusForPlugin(d()).runtimeLoaded) {
      this.c.loadRuntimeForPlugin(d(), paramString);
    }
  }
  
  public final void e(String paramString)
  {
    if (e.isInfoEnabled())
    {
      Logger localLogger = e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadPluginLoader mPluginLoader:");
      localStringBuilder.append(this.d);
      localLogger.info(localStringBuilder.toString());
    }
    if (this.d == null)
    {
      if (!this.c.getPpsStatusForPlugin(d()).loaderLoaded) {
        this.c.loadPluginLoaderForPlugin(d(), paramString);
      }
      this.d = new b(this.c.getPluginLoaderForPlugin(d()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\live_shopping_manager_apk\classes.jar
 * Qualified Name:     com.tencent.shadow.dynamic.a.c
 * JD-Core Version:    0.7.0.1
 */