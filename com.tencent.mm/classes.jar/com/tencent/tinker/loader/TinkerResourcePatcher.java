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

class TinkerResourcePatcher
{
  private static final String TAG = "Tinker.ResourcePatcher";
  private static final String TEST_ASSETS_VALUE = "only_use_to_test_tinker_resource.txt";
  private static Method addAssetPathAsSharedLibraryMethod;
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
    addAssetPathAsSharedLibraryMethod = null;
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
    finally
    {
      try
      {
        ShareTinkerLog.e("Tinker.ResourcePatcher", "checkResUpdate failed, can't find test resource assets file only_use_to_test_tinker_resource.txt e:" + paramContext.getMessage(), new Object[0]);
        return false;
      }
      finally
      {
        SharePatchFileUtil.closeQuietly(null);
      }
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
    finally
    {
      ShareTinkerLog.e("Tinker.ResourcePatcher", "clearPreloadTypedArrayIssue failed, ignore error: ".concat(String.valueOf(paramResources)), new Object[0]);
    }
  }
  
  public static void isResourceCanPatch(Context paramContext)
  {
    Object localObject3 = Class.forName("android.app.ActivityThread");
    currentActivityThread = ShareReflectUtil.getActivityThread(paramContext, (Class)localObject3);
    try
    {
      localObject1 = Class.forName("android.app.LoadedApk");
      resDir = ShareReflectUtil.findField((Class)localObject1, "mResDir");
      packagesFiled = ShareReflectUtil.findField((Class)localObject3, "mPackages");
      if (Build.VERSION.SDK_INT < 27) {
        resourcePackagesFiled = ShareReflectUtil.findField((Class)localObject3, "mResourcePackages");
      }
      localObject1 = paramContext.getAssets();
      addAssetPathMethod = ShareReflectUtil.findMethod(localObject1, "addAssetPath", new Class[] { String.class });
      if (shouldAddSharedLibraryAssets(paramContext.getApplicationInfo())) {
        addAssetPathAsSharedLibraryMethod = ShareReflectUtil.findMethod(localObject1, "addAssetPathAsSharedLibrary", new Class[] { String.class });
      }
    }
    catch (ClassNotFoundException localObject2)
    {
      try
      {
        Object localObject1;
        stringBlocksField = ShareReflectUtil.findField(localObject1, "mStringBlocks");
        ensureStringBlocksMethod = ShareReflectUtil.findMethod(localObject1, "ensureStringBlocks", new Class[0]);
        label128:
        newAssetManager = (AssetManager)ShareReflectUtil.findConstructor(localObject1, new Class[0]).newInstance(new Object[0]);
        if (Build.VERSION.SDK_INT >= 19)
        {
          localObject1 = Class.forName("android.app.ResourcesManager");
          localObject3 = ShareReflectUtil.findMethod((Class)localObject1, "getInstance", new Class[0]).invoke(null, new Object[0]);
        }
        for (;;)
        {
          try
          {
            references = ((ArrayMap)ShareReflectUtil.findField((Class)localObject1, "mActiveResources").get(localObject3)).values();
            if (references != null) {
              break label271;
            }
            throw new IllegalStateException("resource references is null");
            localClassNotFoundException = localClassNotFoundException;
            localClass = Class.forName("android.app.ActivityThread$PackageInfo");
          }
          catch (NoSuchFieldException localNoSuchFieldException)
          {
            Class localClass;
            references = (Collection)ShareReflectUtil.findField(localClass, "mResourceReferences").get(localObject3);
          }
          references = ((HashMap)ShareReflectUtil.findField((Class)localObject3, "mActiveResources").get(currentActivityThread)).values();
        }
        label271:
        paramContext = paramContext.getResources();
        if (Build.VERSION.SDK_INT >= 24) {
          try
          {
            resourcesImplFiled = ShareReflectUtil.findField(paramContext, "mResourcesImpl");
          }
          finally
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
            localObject2 = finally;
            assetsFiled = ShareReflectUtil.findField(paramContext, "mAssets");
          }
        }
        assetsFiled = ShareReflectUtil.findField(paramContext, "mAssets");
      }
      finally
      {
        break label128;
      }
    }
  }
  
  /* Error */
  public static void monkeyPatchExistingResources(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_0
    //   6: invokevirtual 198	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   9: astore 5
    //   11: getstatic 190	android/os/Build$VERSION:SDK_INT	I
    //   14: bipush 27
    //   16: if_icmpge +133 -> 149
    //   19: iconst_2
    //   20: anewarray 132	java/lang/reflect/Field
    //   23: dup
    //   24: iconst_0
    //   25: getstatic 52	com/tencent/tinker/loader/TinkerResourcePatcher:packagesFiled	Ljava/lang/reflect/Field;
    //   28: aastore
    //   29: dup
    //   30: iconst_1
    //   31: getstatic 54	com/tencent/tinker/loader/TinkerResourcePatcher:resourcePackagesFiled	Ljava/lang/reflect/Field;
    //   34: aastore
    //   35: astore 4
    //   37: aload 4
    //   39: arraylength
    //   40: istore_3
    //   41: iconst_0
    //   42: istore_2
    //   43: iload_2
    //   44: iload_3
    //   45: if_icmpge +126 -> 171
    //   48: aload 4
    //   50: iload_2
    //   51: aaload
    //   52: getstatic 36	com/tencent/tinker/loader/TinkerResourcePatcher:currentActivityThread	Ljava/lang/Object;
    //   55: invokevirtual 136	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   58: checkcast 266	java/util/Map
    //   61: invokeinterface 270 1 0
    //   66: invokeinterface 276 1 0
    //   71: astore 6
    //   73: aload 6
    //   75: invokeinterface 282 1 0
    //   80: ifeq +84 -> 164
    //   83: aload 6
    //   85: invokeinterface 286 1 0
    //   90: checkcast 288	java/util/Map$Entry
    //   93: invokeinterface 291 1 0
    //   98: checkcast 293	java/lang/ref/WeakReference
    //   101: invokevirtual 295	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   104: astore 7
    //   106: aload 7
    //   108: ifnull -35 -> 73
    //   111: getstatic 50	com/tencent/tinker/loader/TinkerResourcePatcher:resDir	Ljava/lang/reflect/Field;
    //   114: aload 7
    //   116: invokevirtual 136	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   119: checkcast 154	java/lang/String
    //   122: astore 8
    //   124: aload 5
    //   126: getfield 298	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   129: aload 8
    //   131: invokevirtual 302	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   134: ifeq -61 -> 73
    //   137: getstatic 50	com/tencent/tinker/loader/TinkerResourcePatcher:resDir	Ljava/lang/reflect/Field;
    //   140: aload 7
    //   142: aload_1
    //   143: invokevirtual 306	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   146: goto -73 -> 73
    //   149: iconst_1
    //   150: anewarray 132	java/lang/reflect/Field
    //   153: dup
    //   154: iconst_0
    //   155: getstatic 52	com/tencent/tinker/loader/TinkerResourcePatcher:packagesFiled	Ljava/lang/reflect/Field;
    //   158: aastore
    //   159: astore 4
    //   161: goto -124 -> 37
    //   164: iload_2
    //   165: iconst_1
    //   166: iadd
    //   167: istore_2
    //   168: goto -125 -> 43
    //   171: getstatic 40	com/tencent/tinker/loader/TinkerResourcePatcher:addAssetPathMethod	Ljava/lang/reflect/Method;
    //   174: getstatic 38	com/tencent/tinker/loader/TinkerResourcePatcher:newAssetManager	Landroid/content/res/AssetManager;
    //   177: iconst_1
    //   178: anewarray 4	java/lang/Object
    //   181: dup
    //   182: iconst_0
    //   183: aload_1
    //   184: aastore
    //   185: invokevirtual 150	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   188: checkcast 308	java/lang/Integer
    //   191: invokevirtual 312	java/lang/Integer:intValue	()I
    //   194: ifne +14 -> 208
    //   197: new 238	java/lang/IllegalStateException
    //   200: dup
    //   201: ldc_w 314
    //   204: invokespecial 241	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   207: athrow
    //   208: aload 5
    //   210: invokestatic 202	com/tencent/tinker/loader/TinkerResourcePatcher:shouldAddSharedLibraryAssets	(Landroid/content/pm/ApplicationInfo;)Z
    //   213: ifeq +83 -> 296
    //   216: aload 5
    //   218: getfield 318	android/content/pm/ApplicationInfo:sharedLibraryFiles	[Ljava/lang/String;
    //   221: astore 4
    //   223: aload 4
    //   225: arraylength
    //   226: istore_3
    //   227: iconst_0
    //   228: istore_2
    //   229: iload_2
    //   230: iload_3
    //   231: if_icmpge +65 -> 296
    //   234: aload 4
    //   236: iload_2
    //   237: aaload
    //   238: astore 5
    //   240: aload 5
    //   242: ldc_w 320
    //   245: invokevirtual 324	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   248: ifeq +41 -> 289
    //   251: getstatic 42	com/tencent/tinker/loader/TinkerResourcePatcher:addAssetPathAsSharedLibraryMethod	Ljava/lang/reflect/Method;
    //   254: getstatic 38	com/tencent/tinker/loader/TinkerResourcePatcher:newAssetManager	Landroid/content/res/AssetManager;
    //   257: iconst_1
    //   258: anewarray 4	java/lang/Object
    //   261: dup
    //   262: iconst_0
    //   263: aload 5
    //   265: aastore
    //   266: invokevirtual 150	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   269: checkcast 308	java/lang/Integer
    //   272: invokevirtual 312	java/lang/Integer:intValue	()I
    //   275: ifne +14 -> 289
    //   278: new 238	java/lang/IllegalStateException
    //   281: dup
    //   282: ldc_w 326
    //   285: invokespecial 241	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   288: athrow
    //   289: iload_2
    //   290: iconst_1
    //   291: iadd
    //   292: istore_2
    //   293: goto -64 -> 229
    //   296: getstatic 58	com/tencent/tinker/loader/TinkerResourcePatcher:stringBlocksField	Ljava/lang/reflect/Field;
    //   299: ifnull +33 -> 332
    //   302: getstatic 44	com/tencent/tinker/loader/TinkerResourcePatcher:ensureStringBlocksMethod	Ljava/lang/reflect/Method;
    //   305: ifnull +27 -> 332
    //   308: getstatic 58	com/tencent/tinker/loader/TinkerResourcePatcher:stringBlocksField	Ljava/lang/reflect/Field;
    //   311: getstatic 38	com/tencent/tinker/loader/TinkerResourcePatcher:newAssetManager	Landroid/content/res/AssetManager;
    //   314: aconst_null
    //   315: invokevirtual 306	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   318: getstatic 44	com/tencent/tinker/loader/TinkerResourcePatcher:ensureStringBlocksMethod	Ljava/lang/reflect/Method;
    //   321: getstatic 38	com/tencent/tinker/loader/TinkerResourcePatcher:newAssetManager	Landroid/content/res/AssetManager;
    //   324: iconst_0
    //   325: anewarray 4	java/lang/Object
    //   328: invokevirtual 150	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   331: pop
    //   332: getstatic 34	com/tencent/tinker/loader/TinkerResourcePatcher:references	Ljava/util/Collection;
    //   335: invokeinterface 327 1 0
    //   340: astore 4
    //   342: aload 4
    //   344: invokeinterface 282 1 0
    //   349: ifeq +91 -> 440
    //   352: aload 4
    //   354: invokeinterface 286 1 0
    //   359: checkcast 293	java/lang/ref/WeakReference
    //   362: invokevirtual 295	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   365: checkcast 122	android/content/res/Resources
    //   368: astore 5
    //   370: aload 5
    //   372: ifnull -30 -> 342
    //   375: getstatic 46	com/tencent/tinker/loader/TinkerResourcePatcher:assetsFiled	Ljava/lang/reflect/Field;
    //   378: aload 5
    //   380: getstatic 38	com/tencent/tinker/loader/TinkerResourcePatcher:newAssetManager	Landroid/content/res/AssetManager;
    //   383: invokevirtual 306	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   386: aload 5
    //   388: invokestatic 329	com/tencent/tinker/loader/TinkerResourcePatcher:clearPreloadTypedArrayIssue	(Landroid/content/res/Resources;)V
    //   391: aload 5
    //   393: aload 5
    //   395: invokevirtual 333	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   398: aload 5
    //   400: invokevirtual 337	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   403: invokevirtual 341	android/content/res/Resources:updateConfiguration	(Landroid/content/res/Configuration;Landroid/util/DisplayMetrics;)V
    //   406: goto -64 -> 342
    //   409: astore 6
    //   411: getstatic 48	com/tencent/tinker/loader/TinkerResourcePatcher:resourcesImplFiled	Ljava/lang/reflect/Field;
    //   414: aload 5
    //   416: invokevirtual 136	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   419: astore 6
    //   421: aload 6
    //   423: ldc_w 262
    //   426: invokestatic 209	com/tencent/tinker/loader/shareutil/ShareReflectUtil:findField	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   429: aload 6
    //   431: getstatic 38	com/tencent/tinker/loader/TinkerResourcePatcher:newAssetManager	Landroid/content/res/AssetManager;
    //   434: invokevirtual 306	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   437: goto -51 -> 386
    //   440: getstatic 190	android/os/Build$VERSION:SDK_INT	I
    //   443: bipush 24
    //   445: if_icmplt +20 -> 465
    //   448: getstatic 56	com/tencent/tinker/loader/TinkerResourcePatcher:publicSourceDirField	Ljava/lang/reflect/Field;
    //   451: ifnull +14 -> 465
    //   454: getstatic 56	com/tencent/tinker/loader/TinkerResourcePatcher:publicSourceDirField	Ljava/lang/reflect/Field;
    //   457: aload_0
    //   458: invokevirtual 198	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   461: aload_1
    //   462: invokevirtual 306	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   465: aload_0
    //   466: invokestatic 343	com/tencent/tinker/loader/TinkerResourcePatcher:checkResUpdate	(Landroid/content/Context;)Z
    //   469: ifne -465 -> 4
    //   472: new 345	com/tencent/tinker/loader/TinkerRuntimeException
    //   475: dup
    //   476: ldc_w 347
    //   479: invokespecial 348	com/tencent/tinker/loader/TinkerRuntimeException:<init>	(Ljava/lang/String;)V
    //   482: athrow
    //   483: astore_1
    //   484: goto -19 -> 465
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	487	0	paramContext	Context
    //   0	487	1	paramString	String
    //   42	251	2	i	int
    //   40	192	3	j	int
    //   35	318	4	localObject1	Object
    //   9	406	5	localObject2	Object
    //   71	13	6	localIterator	java.util.Iterator
    //   409	1	6	localObject3	Object
    //   419	11	6	localObject4	Object
    //   104	37	7	localObject5	Object
    //   122	8	8	str	String
    // Exception table:
    //   from	to	target	type
    //   375	386	409	finally
    //   448	465	483	finally
  }
  
  private static boolean shouldAddSharedLibraryAssets(ApplicationInfo paramApplicationInfo)
  {
    return (Build.VERSION.SDK_INT >= 24) && (paramApplicationInfo != null) && (paramApplicationInfo.sharedLibraryFiles != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.loader.TinkerResourcePatcher
 * JD-Core Version:    0.7.0.1
 */