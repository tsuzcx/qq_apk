package com.tencent.shadow.dynamic.impl;

import android.content.Context;
import com.tencent.shadow.a.a.a;
import com.tencent.shadow.dynamic.host.ManagerFactory;
import com.tencent.shadow.dynamic.host.PluginManagerImpl;

public final class ManagerFactoryImpl
  implements ManagerFactory
{
  public PluginManagerImpl buildManager(Context paramContext)
  {
    return new a(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\live_shopping_manager_apk\classes.jar
 * Qualified Name:     com.tencent.shadow.dynamic.impl.ManagerFactoryImpl
 * JD-Core Version:    0.7.0.1
 */