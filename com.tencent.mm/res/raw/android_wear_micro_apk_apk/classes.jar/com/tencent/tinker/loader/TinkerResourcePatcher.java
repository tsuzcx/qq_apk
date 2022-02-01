package com.tencent.tinker.loader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.ArrayMap;
import android.util.Log;
import com.tencent.tinker.loader.a.f;
import com.tencent.tinker.loader.a.h;
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
  private static Collection<WeakReference<Resources>> aoj = null;
  private static Object aok = null;
  private static AssetManager aol = null;
  private static Method aom = null;
  private static Method aon = null;
  private static Field aoo = null;
  private static Field aop = null;
  private static Field aoq = null;
  private static Field aor = null;
  private static Field aos = null;
  private static Field aot = null;
  private static Field aou = null;
  
  public static void J(Context paramContext)
  {
    Object localObject2 = Class.forName("android.app.ActivityThread");
    aok = h.b(paramContext, (Class)localObject2);
    try
    {
      localObject1 = Class.forName("android.app.LoadedApk");
      aoq = h.a((Class)localObject1, "mResDir");
      aor = h.a((Class)localObject2, "mPackages");
      if (Build.VERSION.SDK_INT < 27) {
        aos = h.a((Class)localObject2, "mResourcePackages");
      }
      localObject1 = paramContext.getAssets();
      aom = h.a(localObject1, "addAssetPath", new Class[] { String.class });
    }
    catch (ClassNotFoundException localThrowable1)
    {
      try
      {
        Object localObject1;
        aou = h.d(localObject1, "mStringBlocks");
        aon = h.a(localObject1, "ensureStringBlocks", new Class[0]);
        label100:
        aol = (AssetManager)h.a(localObject1, new Class[0]).newInstance(new Object[0]);
        if (Build.VERSION.SDK_INT >= 19)
        {
          localObject1 = Class.forName("android.app.ResourcesManager");
          localObject2 = h.a((Class)localObject1, "getInstance", new Class[0]).invoke(null, new Object[0]);
        }
        for (;;)
        {
          try
          {
            aoj = ((ArrayMap)h.a((Class)localObject1, "mActiveResources").get(localObject2)).values();
            if (aoj != null) {
              break label243;
            }
            throw new IllegalStateException("resource references is null");
            localClassNotFoundException = localClassNotFoundException;
            localClass = Class.forName("android.app.ActivityThread$PackageInfo");
          }
          catch (NoSuchFieldException localNoSuchFieldException)
          {
            Class localClass;
            aoj = (Collection)h.a(localClass, "mResourceReferences").get(localObject2);
            continue;
          }
          aoj = ((HashMap)h.a((Class)localObject2, "mActiveResources").get(aok)).values();
        }
        label243:
        paramContext = paramContext.getResources();
        if (Build.VERSION.SDK_INT >= 24) {}
        for (;;)
        {
          try
          {
            aop = h.d(paramContext, "mResourcesImpl");
          }
          catch (Throwable localThrowable1)
          {
            try
            {
              aot = h.a(ApplicationInfo.class, "publicSourceDir");
              return;
            }
            catch (NoSuchFieldException paramContext)
            {
              return;
            }
            localThrowable1 = localThrowable1;
            aoo = h.d(paramContext, "mAssets");
            continue;
          }
          aoo = h.d(paramContext, "mAssets");
        }
      }
      catch (Throwable localThrowable2)
      {
        break label100;
      }
    }
  }
  
  private static boolean K(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getAssets().open("only_use_to_test_tinker_resource.txt");
      f.aa(paramContext);
      Log.i("Tinker.ResourcePatcher", "checkResUpdate success, found test resource assets file only_use_to_test_tinker_resource.txt");
      return true;
    }
    catch (Throwable paramContext)
    {
      Log.e("Tinker.ResourcePatcher", "checkResUpdate failed, can't find test resource assets file only_use_to_test_tinker_resource.txt e:" + paramContext.getMessage());
      return false;
    }
    finally
    {
      f.aa(null);
    }
  }
  
  private static void a(Resources paramResources)
  {
    Log.w("Tinker.ResourcePatcher", "try to clear typedArray cache!");
    try
    {
      paramResources = h.a(Resources.class, "mTypedArrayPool").get(paramResources);
      Method localMethod = h.a(paramResources, "acquire", new Class[0]);
      Object localObject;
      do
      {
        localObject = localMethod.invoke(paramResources, new Object[0]);
      } while (localObject != null);
      return;
    }
    catch (Throwable paramResources)
    {
      Log.e("Tinker.ResourcePatcher", "clearPreloadTypedArrayIssue failed, ignore error: ".concat(String.valueOf(paramResources)));
    }
  }
  
  public static void k(Context paramContext, String paramString)
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
        localObject1 = new Field[] { aor, aos };
        j = localObject1.length;
        i = 0;
      }
      for (;;)
      {
        if (i >= j) {
          break label171;
        }
        Iterator localIterator = ((Map)localObject1[i].get(aok)).entrySet().iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            Object localObject4 = ((WeakReference)((Map.Entry)localIterator.next()).getValue()).get();
            if (localObject4 != null)
            {
              String str = (String)aoq.get(localObject4);
              if (((ApplicationInfo)localObject2).sourceDir.equals(str))
              {
                aoq.set(localObject4, paramString);
                continue;
                localObject1 = new Field[] { aor };
                break;
              }
            }
          }
        }
        i += 1;
      }
      label171:
      if (((Integer)aom.invoke(aol, new Object[] { paramString })).intValue() == 0) {
        throw new IllegalStateException("Could not create new AssetManager");
      }
      if ((aou != null) && (aon != null))
      {
        aou.set(aol, null);
        aon.invoke(aol, new Object[0]);
      }
      Object localObject1 = aoj.iterator();
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
            aoo.set(localObject2, aol);
            a((Resources)localObject2);
            ((Resources)localObject2).updateConfiguration(((Resources)localObject2).getConfiguration(), ((Resources)localObject2).getDisplayMetrics());
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              Object localObject3 = aop.get(localObject2);
              h.d(localObject3, "mAssets").set(localObject3, aol);
            }
          }
        }
      }
      if (Build.VERSION.SDK_INT >= 24) {}
      try
      {
        if (aot != null) {
          aot.set(paramContext.getApplicationInfo(), paramString);
        }
        label376:
        if (K(paramContext)) {
          continue;
        }
        throw new TinkerRuntimeException("checkResInstall failed");
      }
      catch (Throwable paramString)
      {
        break label376;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.TinkerResourcePatcher
 * JD-Core Version:    0.7.0.1
 */