package com.tencent.tinker.loader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.ArrayMap;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
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
  private static final String TAG = "Tinker.ResourcePatcher";
  private static final String TEST_ASSETS_VALUE = "only_use_to_test_tinker_resource.txt";
  private static Method addAssetPathMethod;
  private static Field assetsFiled;
  private static Object currentActivityThread;
  private static Method ensureStringBlocksMethod;
  private static AssetManager newAssetManager;
  private static Field packagesFiled;
  private static Field publicSourceDirField = null;
  private static Collection<WeakReference<Resources>> references = null;
  private static Field resDir;
  private static Field resourcePackagesFiled;
  private static Field resourcesImplFiled;
  private static Field stringBlocksField = null;
  
  static
  {
    currentActivityThread = null;
    newAssetManager = null;
    addAssetPathMethod = null;
    ensureStringBlocksMethod = null;
    assetsFiled = null;
    resourcesImplFiled = null;
    resDir = null;
    packagesFiled = null;
    resourcePackagesFiled = null;
  }
  
  private static boolean checkResUpdate(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getAssets().open("only_use_to_test_tinker_resource.txt");
      SharePatchFileUtil.closeQuietly(paramContext);
      ShareTinkerLog.i("Tinker.ResourcePatcher", "checkResUpdate success, found test resource assets file only_use_to_test_tinker_resource.txt", new Object[0]);
      return true;
    }
    catch (Throwable paramContext)
    {
      ShareTinkerLog.e("Tinker.ResourcePatcher", "checkResUpdate failed, can't find test resource assets file only_use_to_test_tinker_resource.txt e:" + paramContext.getMessage(), new Object[0]);
      return false;
    }
    finally
    {
      SharePatchFileUtil.closeQuietly(null);
    }
  }
  
  private static void clearPreloadTypedArrayIssue(Resources paramResources)
  {
    ShareTinkerLog.w("Tinker.ResourcePatcher", "try to clear typedArray cache!", new Object[0]);
    try
    {
      paramResources = ShareReflectUtil.findField(Resources.class, "mTypedArrayPool").get(paramResources);
      Method localMethod = ShareReflectUtil.findMethod(paramResources, "acquire", new Class[0]);
      Object localObject;
      do
      {
        localObject = localMethod.invoke(paramResources, new Object[0]);
      } while (localObject != null);
      return;
    }
    catch (Throwable paramResources)
    {
      ShareTinkerLog.e("Tinker.ResourcePatcher", "clearPreloadTypedArrayIssue failed, ignore error: ".concat(String.valueOf(paramResources)), new Object[0]);
    }
  }
  
  public static void isResourceCanPatch(Context paramContext)
  {
    Object localObject2 = Class.forName("android.app.ActivityThread");
    currentActivityThread = ShareReflectUtil.getActivityThread(paramContext, (Class)localObject2);
    try
    {
      localObject1 = Class.forName("android.app.LoadedApk");
      resDir = ShareReflectUtil.findField((Class)localObject1, "mResDir");
      packagesFiled = ShareReflectUtil.findField((Class)localObject2, "mPackages");
      if (Build.VERSION.SDK_INT < 27) {
        resourcePackagesFiled = ShareReflectUtil.findField((Class)localObject2, "mResourcePackages");
      }
      localObject1 = paramContext.getAssets();
      addAssetPathMethod = ShareReflectUtil.findMethod(localObject1, "addAssetPath", new Class[] { String.class });
    }
    catch (ClassNotFoundException localThrowable1)
    {
      try
      {
        Object localObject1;
        stringBlocksField = ShareReflectUtil.findField(localObject1, "mStringBlocks");
        ensureStringBlocksMethod = ShareReflectUtil.findMethod(localObject1, "ensureStringBlocks", new Class[0]);
        label100:
        newAssetManager = (AssetManager)ShareReflectUtil.findConstructor(localObject1, new Class[0]).newInstance(new Object[0]);
        if (Build.VERSION.SDK_INT >= 19)
        {
          localObject1 = Class.forName("android.app.ResourcesManager");
          localObject2 = ShareReflectUtil.findMethod((Class)localObject1, "getInstance", new Class[0]).invoke(null, new Object[0]);
        }
        for (;;)
        {
          try
          {
            references = ((ArrayMap)ShareReflectUtil.findField((Class)localObject1, "mActiveResources").get(localObject2)).values();
            if (references != null) {
              break label243;
            }
            throw new IllegalStateException("resource references is null");
            localClassNotFoundException = localClassNotFoundException;
            localClass = Class.forName("android.app.ActivityThread$PackageInfo");
          }
          catch (NoSuchFieldException localNoSuchFieldException)
          {
            Class localClass;
            references = (Collection)ShareReflectUtil.findField(localClass, "mResourceReferences").get(localObject2);
            continue;
          }
          references = ((HashMap)ShareReflectUtil.findField((Class)localObject2, "mActiveResources").get(currentActivityThread)).values();
        }
        label243:
        paramContext = paramContext.getResources();
        if (Build.VERSION.SDK_INT >= 24) {}
        for (;;)
        {
          try
          {
            resourcesImplFiled = ShareReflectUtil.findField(paramContext, "mResourcesImpl");
          }
          catch (Throwable localThrowable1)
          {
            try
            {
              publicSourceDirField = ShareReflectUtil.findField(ApplicationInfo.class, "publicSourceDir");
              return;
            }
            catch (NoSuchFieldException paramContext)
            {
              return;
            }
            localThrowable1 = localThrowable1;
            assetsFiled = ShareReflectUtil.findField(paramContext, "mAssets");
            continue;
          }
          assetsFiled = ShareReflectUtil.findField(paramContext, "mAssets");
        }
      }
      catch (Throwable localThrowable2)
      {
        break label100;
      }
    }
  }
  
  public static void monkeyPatchExistingResources(Context paramContext, String paramString)
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
        localObject1 = new Field[] { packagesFiled, resourcePackagesFiled };
        j = localObject1.length;
        i = 0;
      }
      for (;;)
      {
        if (i >= j) {
          break label171;
        }
        Iterator localIterator = ((Map)localObject1[i].get(currentActivityThread)).entrySet().iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            Object localObject4 = ((WeakReference)((Map.Entry)localIterator.next()).getValue()).get();
            if (localObject4 != null)
            {
              String str = (String)resDir.get(localObject4);
              if (((ApplicationInfo)localObject2).sourceDir.equals(str))
              {
                resDir.set(localObject4, paramString);
                continue;
                localObject1 = new Field[] { packagesFiled };
                break;
              }
            }
          }
        }
        i += 1;
      }
      label171:
      if (((Integer)addAssetPathMethod.invoke(newAssetManager, new Object[] { paramString })).intValue() == 0) {
        throw new IllegalStateException("Could not create new AssetManager");
      }
      if ((stringBlocksField != null) && (ensureStringBlocksMethod != null))
      {
        stringBlocksField.set(newAssetManager, null);
        ensureStringBlocksMethod.invoke(newAssetManager, new Object[0]);
      }
      Object localObject1 = references.iterator();
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
            assetsFiled.set(localObject2, newAssetManager);
            clearPreloadTypedArrayIssue((Resources)localObject2);
            ((Resources)localObject2).updateConfiguration(((Resources)localObject2).getConfiguration(), ((Resources)localObject2).getDisplayMetrics());
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              Object localObject3 = resourcesImplFiled.get(localObject2);
              ShareReflectUtil.findField(localObject3, "mAssets").set(localObject3, newAssetManager);
            }
          }
        }
      }
      if (Build.VERSION.SDK_INT >= 24) {}
      try
      {
        if (publicSourceDirField != null) {
          publicSourceDirField.set(paramContext.getApplicationInfo(), paramString);
        }
        label376:
        if (checkResUpdate(paramContext)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.TinkerResourcePatcher
 * JD-Core Version:    0.7.0.1
 */