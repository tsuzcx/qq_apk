package com.tencent.tinker.loader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.ArrayMap;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class TinkerResourcePatcher
{
  private static Collection<WeakReference<Resources>> wXj = null;
  private static Object wXk = null;
  private static AssetManager wXl = null;
  private static Method wXm = null;
  private static Method wXn = null;
  private static Field wXo = null;
  private static Field wXp = null;
  private static Field wXq = null;
  private static Field wXr = null;
  private static Field wXs = null;
  private static Field wXt = null;
  private static Field wXu = null;
  
  public static void bS(Context paramContext, String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return;
      Object localObject2 = paramContext.getApplicationInfo();
      int j;
      int i;
      if (Build.VERSION.SDK_INT < 27)
      {
        localObject1 = new Field[] { wXr, wXs };
        j = localObject1.length;
        i = 0;
      }
      for (;;)
      {
        if (i >= j) {
          break label171;
        }
        Iterator localIterator = ((Map)localObject1[i].get(wXk)).entrySet().iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            Object localObject4 = ((WeakReference)((Map.Entry)localIterator.next()).getValue()).get();
            if (localObject4 != null)
            {
              String str = (String)wXq.get(localObject4);
              if (((ApplicationInfo)localObject2).sourceDir.equals(str))
              {
                wXq.set(localObject4, paramString);
                continue;
                localObject1 = new Field[] { wXr };
                break;
              }
            }
          }
        }
        i += 1;
      }
      label171:
      if (((Integer)wXm.invoke(wXl, new Object[] { paramString })).intValue() == 0) {
        throw new IllegalStateException("Could not create new AssetManager");
      }
      if ((wXu != null) && (wXn != null))
      {
        wXu.set(wXl, null);
        wXn.invoke(wXl, new Object[0]);
      }
      Object localObject1 = wXj.iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Resources)((WeakReference)((Iterator)localObject1).next()).get();
          if (localObject2 == null) {
            continue;
          }
          try
          {
            wXo.set(localObject2, wXl);
            f((Resources)localObject2);
            ((Resources)localObject2).updateConfiguration(((Resources)localObject2).getConfiguration(), ((Resources)localObject2).getDisplayMetrics());
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              Object localObject3 = wXp.get(localObject2);
              ShareReflectUtil.b(localObject3, "mAssets").set(localObject3, wXl);
            }
          }
        }
      }
      if (Build.VERSION.SDK_INT >= 24) {}
      try
      {
        if (wXt != null) {
          wXt.set(paramContext.getApplicationInfo(), paramString);
        }
        label375:
        if (hU(paramContext)) {
          continue;
        }
        throw new TinkerRuntimeException("checkResInstall failed");
      }
      catch (Throwable paramString)
      {
        break label375;
      }
    }
  }
  
  private static void f(Resources paramResources)
  {
    try
    {
      paramResources = ShareReflectUtil.d(Resources.class, "mTypedArrayPool").get(paramResources);
      Method localMethod = ShareReflectUtil.b(paramResources, "acquire", new Class[0]);
      Object localObject;
      do
      {
        localObject = localMethod.invoke(paramResources, new Object[0]);
      } while (localObject != null);
      return;
    }
    catch (Throwable paramResources)
    {
      new StringBuilder("clearPreloadTypedArrayIssue failed, ignore error: ").append(paramResources);
    }
  }
  
  public static void hT(Context paramContext)
  {
    Object localObject2 = Class.forName("android.app.ActivityThread");
    wXk = ShareReflectUtil.c(paramContext, (Class)localObject2);
    try
    {
      localObject1 = Class.forName("android.app.LoadedApk");
      wXq = ShareReflectUtil.d((Class)localObject1, "mResDir");
      wXr = ShareReflectUtil.d((Class)localObject2, "mPackages");
      if (Build.VERSION.SDK_INT < 27) {
        wXs = ShareReflectUtil.d((Class)localObject2, "mResourcePackages");
      }
      localObject1 = paramContext.getAssets();
      wXm = ShareReflectUtil.b(localObject1, "addAssetPath", new Class[] { String.class });
    }
    catch (ClassNotFoundException localThrowable1)
    {
      try
      {
        Object localObject1;
        wXu = ShareReflectUtil.b(localObject1, "mStringBlocks");
        wXn = ShareReflectUtil.b(localObject1, "ensureStringBlocks", new Class[0]);
        label100:
        wXl = (AssetManager)ShareReflectUtil.a(localObject1, new Class[0]).newInstance(new Object[0]);
        if (Build.VERSION.SDK_INT >= 19)
        {
          localObject1 = Class.forName("android.app.ResourcesManager");
          localObject2 = ShareReflectUtil.c((Class)localObject1, "getInstance", new Class[0]).invoke(null, new Object[0]);
        }
        for (;;)
        {
          try
          {
            wXj = ((ArrayMap)ShareReflectUtil.d((Class)localObject1, "mActiveResources").get(localObject2)).values();
            if (wXj != null) {
              break label246;
            }
            throw new IllegalStateException("resource references is null");
            localClassNotFoundException = localClassNotFoundException;
            localClass = Class.forName("android.app.ActivityThread$PackageInfo");
          }
          catch (NoSuchFieldException localNoSuchFieldException)
          {
            Class localClass;
            wXj = (Collection)ShareReflectUtil.d(localClass, "mResourceReferences").get(localObject2);
            continue;
          }
          wXj = ((HashMap)ShareReflectUtil.d((Class)localObject2, "mActiveResources").get(wXk)).values();
        }
        label246:
        paramContext = paramContext.getResources();
        if (Build.VERSION.SDK_INT >= 24) {}
        for (;;)
        {
          try
          {
            wXp = ShareReflectUtil.b(paramContext, "mResourcesImpl");
          }
          catch (Throwable localThrowable1)
          {
            try
            {
              wXt = ShareReflectUtil.d(ApplicationInfo.class, "publicSourceDir");
              return;
            }
            catch (NoSuchFieldException paramContext)
            {
              return;
            }
            localThrowable1 = localThrowable1;
            wXo = ShareReflectUtil.b(paramContext, "mAssets");
            continue;
          }
          wXo = ShareReflectUtil.b(paramContext, "mAssets");
        }
      }
      catch (Throwable localThrowable2)
      {
        break label100;
      }
    }
  }
  
  private static boolean hU(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getAssets().open("only_use_to_test_tinker_resource.txt");
      SharePatchFileUtil.S(paramContext);
      return true;
    }
    catch (Throwable paramContext)
    {
      new StringBuilder("checkResUpdate failed, can't find test resource assets file only_use_to_test_tinker_resource.txt e:").append(paramContext.getMessage());
      return false;
    }
    finally
    {
      SharePatchFileUtil.S(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.TinkerResourcePatcher
 * JD-Core Version:    0.7.0.1
 */