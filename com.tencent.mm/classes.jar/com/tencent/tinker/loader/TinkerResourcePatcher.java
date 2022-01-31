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
  private static Collection<WeakReference<Resources>> BtN = null;
  private static Object BtO = null;
  private static AssetManager BtP = null;
  private static Method BtQ = null;
  private static Method BtR = null;
  private static Field BtS = null;
  private static Field BtT = null;
  private static Field BtU = null;
  private static Field BtV = null;
  private static Field BtW = null;
  private static Field BtX = null;
  private static Field BtY = null;
  
  public static void cf(Context paramContext, String paramString)
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
        localObject1 = new Field[] { BtV, BtW };
        j = localObject1.length;
        i = 0;
      }
      for (;;)
      {
        if (i >= j) {
          break label171;
        }
        Iterator localIterator = ((Map)localObject1[i].get(BtO)).entrySet().iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            Object localObject4 = ((WeakReference)((Map.Entry)localIterator.next()).getValue()).get();
            if (localObject4 != null)
            {
              String str = (String)BtU.get(localObject4);
              if (((ApplicationInfo)localObject2).sourceDir.equals(str))
              {
                BtU.set(localObject4, paramString);
                continue;
                localObject1 = new Field[] { BtV };
                break;
              }
            }
          }
        }
        i += 1;
      }
      label171:
      if (((Integer)BtQ.invoke(BtP, new Object[] { paramString })).intValue() == 0) {
        throw new IllegalStateException("Could not create new AssetManager");
      }
      if ((BtY != null) && (BtR != null))
      {
        BtY.set(BtP, null);
        BtR.invoke(BtP, new Object[0]);
      }
      Object localObject1 = BtN.iterator();
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
            BtS.set(localObject2, BtP);
            j((Resources)localObject2);
            ((Resources)localObject2).updateConfiguration(((Resources)localObject2).getConfiguration(), ((Resources)localObject2).getDisplayMetrics());
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              Object localObject3 = BtT.get(localObject2);
              ShareReflectUtil.b(localObject3, "mAssets").set(localObject3, BtP);
            }
          }
        }
      }
      if (Build.VERSION.SDK_INT >= 24) {}
      try
      {
        if (BtX != null) {
          BtX.set(paramContext.getApplicationInfo(), paramString);
        }
        label375:
        if (jv(paramContext)) {
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
  
  private static void j(Resources paramResources)
  {
    try
    {
      paramResources = ShareReflectUtil.g(Resources.class, "mTypedArrayPool").get(paramResources);
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
  
  public static void ju(Context paramContext)
  {
    Object localObject2 = Class.forName("android.app.ActivityThread");
    BtO = ShareReflectUtil.d(paramContext, (Class)localObject2);
    try
    {
      localObject1 = Class.forName("android.app.LoadedApk");
      BtU = ShareReflectUtil.g((Class)localObject1, "mResDir");
      BtV = ShareReflectUtil.g((Class)localObject2, "mPackages");
      if (Build.VERSION.SDK_INT < 27) {
        BtW = ShareReflectUtil.g((Class)localObject2, "mResourcePackages");
      }
      localObject1 = paramContext.getAssets();
      BtQ = ShareReflectUtil.b(localObject1, "addAssetPath", new Class[] { String.class });
    }
    catch (ClassNotFoundException localThrowable1)
    {
      try
      {
        Object localObject1;
        BtY = ShareReflectUtil.b(localObject1, "mStringBlocks");
        BtR = ShareReflectUtil.b(localObject1, "ensureStringBlocks", new Class[0]);
        label100:
        BtP = (AssetManager)ShareReflectUtil.a(localObject1, new Class[0]).newInstance(new Object[0]);
        if (Build.VERSION.SDK_INT >= 19)
        {
          localObject1 = Class.forName("android.app.ResourcesManager");
          localObject2 = ShareReflectUtil.d((Class)localObject1, "getInstance", new Class[0]).invoke(null, new Object[0]);
        }
        for (;;)
        {
          try
          {
            BtN = ((ArrayMap)ShareReflectUtil.g((Class)localObject1, "mActiveResources").get(localObject2)).values();
            if (BtN != null) {
              break label246;
            }
            throw new IllegalStateException("resource references is null");
            localClassNotFoundException = localClassNotFoundException;
            localClass = Class.forName("android.app.ActivityThread$PackageInfo");
          }
          catch (NoSuchFieldException localNoSuchFieldException)
          {
            Class localClass;
            BtN = (Collection)ShareReflectUtil.g(localClass, "mResourceReferences").get(localObject2);
            continue;
          }
          BtN = ((HashMap)ShareReflectUtil.g((Class)localObject2, "mActiveResources").get(BtO)).values();
        }
        label246:
        paramContext = paramContext.getResources();
        if (Build.VERSION.SDK_INT >= 24) {}
        for (;;)
        {
          try
          {
            BtT = ShareReflectUtil.b(paramContext, "mResourcesImpl");
          }
          catch (Throwable localThrowable1)
          {
            try
            {
              BtX = ShareReflectUtil.g(ApplicationInfo.class, "publicSourceDir");
              return;
            }
            catch (NoSuchFieldException paramContext)
            {
              return;
            }
            localThrowable1 = localThrowable1;
            BtS = ShareReflectUtil.b(paramContext, "mAssets");
            continue;
          }
          BtS = ShareReflectUtil.b(paramContext, "mAssets");
        }
      }
      catch (Throwable localThrowable2)
      {
        break label100;
      }
    }
  }
  
  private static boolean jv(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getAssets().open("only_use_to_test_tinker_resource.txt");
      SharePatchFileUtil.V(paramContext);
      return true;
    }
    catch (Throwable paramContext)
    {
      new StringBuilder("checkResUpdate failed, can't find test resource assets file only_use_to_test_tinker_resource.txt e:").append(paramContext.getMessage());
      return false;
    }
    finally
    {
      SharePatchFileUtil.V(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.TinkerResourcePatcher
 * JD-Core Version:    0.7.0.1
 */