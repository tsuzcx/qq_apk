package com.tencent.tbs.one.impl.c.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.impl.a.f;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public final class b
  extends ContextWrapper
{
  private static Method b;
  public a a;
  private Resources c;
  private Resources.Theme d;
  private String e;
  
  static
  {
    AppMethodBeat.i(173868);
    try
    {
      b = AssetManager.class.getDeclaredMethod("addAssetPath", new Class[] { String.class });
      AppMethodBeat.o(173868);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(173868);
    }
  }
  
  public b(Context paramContext, String paramString)
  {
    super(paramContext);
    AppMethodBeat.i(173858);
    Object localObject = paramContext.getPackageManager().getPackageArchiveInfo(paramString, 0);
    if (localObject != null)
    {
      localObject = ((PackageInfo)localObject).applicationInfo;
      if (localObject != null)
      {
        this.e = ((ApplicationInfo)localObject).packageName;
        ((ApplicationInfo)localObject).sourceDir = paramString;
        ((ApplicationInfo)localObject).publicSourceDir = paramString;
      }
    }
    for (;;)
    {
      try
      {
        this.c = paramContext.getPackageManager().getResourcesForApplication((ApplicationInfo)localObject);
        if (this.c != null)
        {
          this.d = this.c.newTheme();
          paramContext = getBaseContext().getTheme();
          if (paramContext != null) {
            this.d.setTo(paramContext);
          }
          int i = ((ApplicationInfo)localObject).theme;
          if (i != 0) {
            this.d.applyStyle(i, true);
          }
          this.a = new a(this);
          AppMethodBeat.o(173858);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        this.c = a(paramContext, paramString);
        continue;
        f.b("Failed to create resource info from %s", new Object[] { paramString });
        continue;
      }
      f.b("Failed to get application info from %s", new Object[] { paramString });
      continue;
      f.b("Failed to get package info from %s", new Object[] { paramString });
    }
  }
  
  private Intent a(Intent paramIntent)
  {
    AppMethodBeat.i(173865);
    ComponentName localComponentName = paramIntent.getComponent();
    if (localComponentName != null) {
      paramIntent.setComponent(new ComponentName(getBaseContext(), localComponentName.getClassName()));
    }
    AppMethodBeat.o(173865);
    return paramIntent;
  }
  
  private static Resources a(Context paramContext, String paramString)
  {
    AppMethodBeat.i(173857);
    if (b == null)
    {
      AppMethodBeat.o(173857);
      return null;
    }
    try
    {
      AssetManager localAssetManager = (AssetManager)AssetManager.class.newInstance();
      b.invoke(localAssetManager, new Object[] { paramString });
      Object localObject = paramContext.getResources();
      paramContext = ((Resources)localObject).getDisplayMetrics();
      Configuration localConfiguration = ((Resources)localObject).getConfiguration();
      localObject = localObject.getClass();
      boolean bool = "android.taobao.atlas.runtime.DelegateResources".equals(((Class)localObject).getName());
      if (!bool) {
        try
        {
          localObject = (Resources)((Class)localObject).getConstructor(new Class[] { AssetManager.class, DisplayMetrics.class, Configuration.class }).newInstance(new Object[] { localAssetManager, paramContext, localConfiguration });
          AppMethodBeat.o(173857);
          return localObject;
        }
        catch (Throwable localThrowable) {}
      }
      paramContext = new Resources(localAssetManager, paramContext, localConfiguration);
      AppMethodBeat.o(173857);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      f.b("Failed to new resources from %s", new Object[] { paramString, paramContext });
      AppMethodBeat.o(173857);
    }
    return null;
  }
  
  public final AssetManager getAssets()
  {
    AppMethodBeat.i(173862);
    Object localObject = getResources();
    if (localObject != null)
    {
      localObject = ((Resources)localObject).getAssets();
      if (localObject != null)
      {
        AppMethodBeat.o(173862);
        return localObject;
      }
    }
    localObject = super.getAssets();
    AppMethodBeat.o(173862);
    return localObject;
  }
  
  public final String getPackageName()
  {
    AppMethodBeat.i(173859);
    if (this.e != null)
    {
      str = this.e;
      AppMethodBeat.o(173859);
      return str;
    }
    String str = super.getPackageName();
    AppMethodBeat.o(173859);
    return str;
  }
  
  public final Resources getResources()
  {
    AppMethodBeat.i(173861);
    if (this.c != null)
    {
      localResources = this.c;
      AppMethodBeat.o(173861);
      return localResources;
    }
    Resources localResources = super.getResources();
    AppMethodBeat.o(173861);
    return localResources;
  }
  
  public final Object getSystemService(String paramString)
  {
    AppMethodBeat.i(173860);
    if ("layout_inflater".equals(paramString))
    {
      paramString = this.a;
      AppMethodBeat.o(173860);
      return paramString;
    }
    paramString = super.getSystemService(paramString);
    AppMethodBeat.o(173860);
    return paramString;
  }
  
  public final Resources.Theme getTheme()
  {
    AppMethodBeat.i(173863);
    if (this.d != null)
    {
      localTheme = this.d;
      AppMethodBeat.o(173863);
      return localTheme;
    }
    Resources.Theme localTheme = super.getTheme();
    AppMethodBeat.o(173863);
    return localTheme;
  }
  
  public final void setTheme(int paramInt)
  {
    AppMethodBeat.i(173864);
    if (this.d != null)
    {
      this.d.applyStyle(paramInt, true);
      AppMethodBeat.o(173864);
      return;
    }
    super.setTheme(paramInt);
    AppMethodBeat.o(173864);
  }
  
  public final void startActivity(Intent paramIntent)
  {
    AppMethodBeat.i(173866);
    super.startActivity(a(paramIntent));
    AppMethodBeat.o(173866);
  }
  
  public final ComponentName startService(Intent paramIntent)
  {
    AppMethodBeat.i(173867);
    paramIntent = super.startService(a(paramIntent));
    AppMethodBeat.o(173867);
    return paramIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tbs.one.impl.c.b.b
 * JD-Core Version:    0.7.0.1
 */