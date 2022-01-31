package org.xwalk.core.resource;

import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.view.LayoutInflater;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.xwalk.core.Log;
import org.xwalk.core.WebViewExtension;
import org.xwalk.core.XWalkCoreWrapper;
import org.xwalk.core.XWalkEnvironment;

public class XWalkContextWrapper
  extends ContextWrapper
{
  private static final String GENERATED_RESOURCE_CLASS = "org.xwalk.core.R";
  private static final String TAG = "XWalkLib";
  private static String mPackageName = null;
  private static HashMap<Long, Integer> mResourcessKeyIdMap;
  public int apkVersion = 0;
  public String extractedCoreDir;
  private ApplicationInfo mApplicationInfo;
  private ClassLoader mClassLoader;
  private Context mContext;
  private boolean mHasAddFilterResources = false;
  private final LayoutInflater mLayoutInflater;
  private Resources mResources;
  private Resources.Theme mTheme;
  
  public XWalkContextWrapper(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.apkVersion = paramInt;
    String str = XWalkEnvironment.getDownloadApkPath(paramInt);
    this.extractedCoreDir = XWalkEnvironment.getExtractedCoreDir(paramInt);
    this.mContext = paramContext;
    this.mLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).cloneInContext(this);
    XWalkContextWrapper.XWalkLayoutInflaterFactory localXWalkLayoutInflaterFactory = new XWalkContextWrapper.XWalkLayoutInflaterFactory(null);
    localXWalkLayoutInflaterFactory.layoutInflater = this.mLayoutInflater;
    try
    {
      Field localField = LayoutInflater.class.getDeclaredField("mFactorySet");
      localField.setAccessible(true);
      localField.setBoolean(this.mLayoutInflater, false);
      this.mLayoutInflater.setFactory(localXWalkLayoutInflaterFactory);
      this.mResources = getResources(paramContext, str);
      if ((this.mResources != null) && (this.mApplicationInfo != null))
      {
        this.mTheme = this.mResources.newTheme();
        if (getPackageInfo(paramContext, str) != null)
        {
          paramContext = paramContext.getTheme();
          if (paramContext != null) {
            this.mTheme.setTo(paramContext);
          }
          this.mTheme.applyStyle(this.mApplicationInfo.theme, true);
        }
      }
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        Log.e("XWalkLib", "XWalkContextWrapper mFactorySet" + localNoSuchFieldException.getMessage());
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        Log.e("XWalkLib", "XWalkContextWrapper mFactorySet" + localIllegalAccessException.getMessage());
      }
    }
  }
  
  private boolean checkResApkExist(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    do
    {
      return false;
      paramString = new File(paramString);
    } while ((!paramString.exists()) || (!paramString.isFile()));
    return true;
  }
  
  private PackageInfo getPackageInfo(Context paramContext, String paramString)
  {
    return paramContext.getPackageManager().getPackageArchiveInfo(paramString, 0);
  }
  
  private Intent getRealIntent(Intent paramIntent)
  {
    ComponentName localComponentName = paramIntent.getComponent();
    if (localComponentName != null) {
      paramIntent.setComponent(new ComponentName(getBaseContext(), localComponentName.getClassName()));
    }
    return paramIntent;
  }
  
  private Resources getResources(Context paramContext, String paramString)
  {
    Object localObject;
    if (checkResApkExist(paramString))
    {
      localObject = paramContext.getPackageManager().getPackageArchiveInfo(paramString, 0);
      if (localObject != null)
      {
        mPackageName = ((PackageInfo)localObject).packageName;
        this.mApplicationInfo = ((PackageInfo)localObject).applicationInfo;
        if (this.mApplicationInfo != null)
        {
          this.mApplicationInfo.sourceDir = paramString;
          this.mApplicationInfo.publicSourceDir = paramString;
        }
      }
    }
    try
    {
      localObject = paramContext.getPackageManager().getResourcesForApplication(this.mApplicationInfo);
      if (localObject != null) {
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      Log.i("XWalkLib", "XWalkContextWrapper try getResourcesNotWithReflect failed, use getResourcesWithReflect");
      return getResourcesWithReflect(paramContext, paramString);
      Log.i("XWalkLib", "XWalkContextWrapper checkResApkExist false");
      return null;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      label79:
      break label79;
    }
  }
  
  private Resources getResourcesWithReflect(Context paramContext, String paramString)
  {
    try
    {
      paramContext = (AssetManager)AssetManager.class.newInstance();
      paramContext.getClass().getMethod("addAssetPath", new Class[] { String.class }).invoke(paramContext, new Object[] { paramString });
      paramString = super.getResources();
      paramContext = new Resources(paramContext, paramString.getDisplayMetrics(), paramString.getConfiguration());
      return paramContext;
    }
    catch (Exception paramContext)
    {
      Log.e("XWalkLib", "XWalkContextWrapper getResourcesWithReflect error:" + paramContext.getMessage());
    }
    return null;
  }
  
  public Context getApplicationContext()
  {
    return this.mContext.getApplicationContext();
  }
  
  public AssetManager getAssets()
  {
    AssetManager localAssetManager = ((Resources)getResources()).getAssets();
    if (localAssetManager != null) {
      return (AssetManager)localAssetManager;
    }
    return super.getAssets();
  }
  
  public Context getBaseContext()
  {
    return this.mContext;
  }
  
  public ClassLoader getClassLoader()
  {
    if (this.mClassLoader != null) {
      return this.mClassLoader;
    }
    XWalkCoreWrapper localXWalkCoreWrapper = XWalkCoreWrapper.getInstance();
    if (localXWalkCoreWrapper != null) {
      return localXWalkCoreWrapper.getBridgeLoader();
    }
    return super.getClassLoader();
  }
  
  public LayoutInflater getLayoutInflater()
  {
    return this.mLayoutInflater;
  }
  
  public String getPackageName()
  {
    return this.mContext.getPackageName();
  }
  
  public Context getPlatformContext()
  {
    return this.mContext;
  }
  
  public Resources getResources()
  {
    if (!this.mHasAddFilterResources)
    {
      if (!WebViewExtension.addFilterResources(this.mResources, getResourcesKeyIdMap(this.mResources))) {
        break label41;
      }
      this.mHasAddFilterResources = true;
    }
    for (;;)
    {
      Resources localResources = this.mResources;
      if (localResources == null) {
        break;
      }
      return localResources;
      label41:
      Log.e("XWalkLib", "mHasAddFilterResources = false");
    }
    return super.getResources();
  }
  
  /* Error */
  public HashMap<Long, Integer> getResourcesKeyIdMap(Resources paramResources)
  {
    // Byte code:
    //   0: getstatic 352	org/xwalk/core/resource/XWalkContextWrapper:mResourcessKeyIdMap	Ljava/util/HashMap;
    //   3: ifnull +13 -> 16
    //   6: getstatic 352	org/xwalk/core/resource/XWalkContextWrapper:mResourcessKeyIdMap	Ljava/util/HashMap;
    //   9: invokevirtual 357	java/util/HashMap:clone	()Ljava/lang/Object;
    //   12: checkcast 354	java/util/HashMap
    //   15: areturn
    //   16: ldc 13
    //   18: ldc_w 359
    //   21: invokestatic 253	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: new 354	java/util/HashMap
    //   27: dup
    //   28: invokespecial 361	java/util/HashMap:<init>	()V
    //   31: astore 10
    //   33: aload_0
    //   34: invokevirtual 362	org/xwalk/core/resource/XWalkContextWrapper:getClassLoader	()Ljava/lang/ClassLoader;
    //   37: ldc 10
    //   39: invokevirtual 368	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   42: invokevirtual 372	java/lang/Class:getClasses	()[Ljava/lang/Class;
    //   45: astore 11
    //   47: aload 11
    //   49: arraylength
    //   50: istore 6
    //   52: iconst_0
    //   53: istore_2
    //   54: iload_2
    //   55: iload 6
    //   57: if_icmpge +264 -> 321
    //   60: aload 11
    //   62: iload_2
    //   63: aaload
    //   64: astore 12
    //   66: aload 12
    //   68: invokevirtual 375	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   71: ldc_w 377
    //   74: invokevirtual 381	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   77: ifeq +380 -> 457
    //   80: aload 12
    //   82: invokevirtual 385	java/lang/Class:getFields	()[Ljava/lang/reflect/Field;
    //   85: astore 12
    //   87: aload 12
    //   89: arraylength
    //   90: istore 7
    //   92: iconst_0
    //   93: istore_3
    //   94: iload_3
    //   95: iload 7
    //   97: if_icmpge +360 -> 457
    //   100: aload 12
    //   102: iload_3
    //   103: aaload
    //   104: astore 13
    //   106: aload 13
    //   108: invokevirtual 388	java/lang/reflect/Field:getModifiers	()I
    //   111: invokestatic 394	java/lang/reflect/Modifier:isFinal	(I)Z
    //   114: ifeq +9 -> 123
    //   117: aload 13
    //   119: iconst_1
    //   120: invokevirtual 101	java/lang/reflect/Field:setAccessible	(Z)V
    //   123: iconst_0
    //   124: istore 5
    //   126: iload 5
    //   128: istore 4
    //   130: new 396	android/util/TypedValue
    //   133: dup
    //   134: invokespecial 397	android/util/TypedValue:<init>	()V
    //   137: astore 14
    //   139: iload 5
    //   141: istore 4
    //   143: aload 13
    //   145: aconst_null
    //   146: invokevirtual 401	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   149: istore 5
    //   151: iload 5
    //   153: istore 4
    //   155: aload_1
    //   156: iload 5
    //   158: aload 14
    //   160: iconst_1
    //   161: invokevirtual 405	android/content/res/Resources:getValue	(ILandroid/util/TypedValue;Z)V
    //   164: iload 5
    //   166: istore 4
    //   168: aload 14
    //   170: getfield 408	android/util/TypedValue:assetCookie	I
    //   173: i2l
    //   174: bipush 32
    //   176: lshl
    //   177: aload 14
    //   179: getfield 411	android/util/TypedValue:data	I
    //   182: i2l
    //   183: lor
    //   184: lstore 8
    //   186: iload 5
    //   188: istore 4
    //   190: aload 10
    //   192: lload 8
    //   194: invokestatic 417	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   197: iload 5
    //   199: invokestatic 422	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   202: invokevirtual 426	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   205: pop
    //   206: iload 5
    //   208: istore 4
    //   210: ldc 13
    //   212: new 149	java/lang/StringBuilder
    //   215: dup
    //   216: ldc_w 428
    //   219: invokespecial 154	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   222: aload 13
    //   224: invokevirtual 431	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   227: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: ldc_w 433
    //   233: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: iload 5
    //   238: invokevirtual 436	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   241: ldc_w 438
    //   244: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: lload 8
    //   249: invokevirtual 441	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   252: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   255: invokestatic 444	org/xwalk/core/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   258: aload 13
    //   260: invokevirtual 388	java/lang/reflect/Field:getModifiers	()I
    //   263: invokestatic 394	java/lang/reflect/Modifier:isFinal	(I)Z
    //   266: ifeq +198 -> 464
    //   269: aload 13
    //   271: iconst_0
    //   272: invokevirtual 101	java/lang/reflect/Field:setAccessible	(Z)V
    //   275: goto +189 -> 464
    //   278: astore 14
    //   280: ldc 13
    //   282: new 149	java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial 445	java/lang/StringBuilder:<init>	()V
    //   289: aload 13
    //   291: invokevirtual 431	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   294: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: ldc_w 447
    //   300: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: invokestatic 450	org/xwalk/core/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   309: goto -51 -> 258
    //   312: astore_1
    //   313: ldc 13
    //   315: ldc_w 452
    //   318: invokestatic 171	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   321: aload 10
    //   323: putstatic 352	org/xwalk/core/resource/XWalkContextWrapper:mResourcessKeyIdMap	Ljava/util/HashMap;
    //   326: ldc 13
    //   328: new 149	java/lang/StringBuilder
    //   331: dup
    //   332: ldc_w 454
    //   335: invokespecial 154	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   338: getstatic 352	org/xwalk/core/resource/XWalkContextWrapper:mResourcessKeyIdMap	Ljava/util/HashMap;
    //   341: invokevirtual 458	java/util/HashMap:keySet	()Ljava/util/Set;
    //   344: invokeinterface 463 1 0
    //   349: invokevirtual 436	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   352: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   355: invokestatic 253	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   358: getstatic 352	org/xwalk/core/resource/XWalkContextWrapper:mResourcessKeyIdMap	Ljava/util/HashMap;
    //   361: invokevirtual 357	java/util/HashMap:clone	()Ljava/lang/Object;
    //   364: checkcast 354	java/util/HashMap
    //   367: areturn
    //   368: astore 14
    //   370: ldc 13
    //   372: new 149	java/lang/StringBuilder
    //   375: dup
    //   376: invokespecial 445	java/lang/StringBuilder:<init>	()V
    //   379: aload 13
    //   381: invokevirtual 431	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   384: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: ldc_w 465
    //   390: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   396: invokestatic 450	org/xwalk/core/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   399: goto -141 -> 258
    //   402: astore_1
    //   403: ldc 13
    //   405: aload_1
    //   406: invokevirtual 301	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   409: invokestatic 171	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   412: goto -91 -> 321
    //   415: astore 14
    //   417: ldc 13
    //   419: new 149	java/lang/StringBuilder
    //   422: dup
    //   423: invokespecial 445	java/lang/StringBuilder:<init>	()V
    //   426: aload 13
    //   428: invokevirtual 431	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   431: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: ldc_w 467
    //   437: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: iload 4
    //   442: invokestatic 470	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   445: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: invokestatic 450	org/xwalk/core/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   454: goto -196 -> 258
    //   457: iload_2
    //   458: iconst_1
    //   459: iadd
    //   460: istore_2
    //   461: goto -407 -> 54
    //   464: iload_3
    //   465: iconst_1
    //   466: iadd
    //   467: istore_3
    //   468: goto -374 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	471	0	this	XWalkContextWrapper
    //   0	471	1	paramResources	Resources
    //   53	408	2	i	int
    //   93	375	3	j	int
    //   128	313	4	k	int
    //   124	113	5	m	int
    //   50	8	6	n	int
    //   90	8	7	i1	int
    //   184	64	8	l	long
    //   31	291	10	localHashMap	HashMap
    //   45	16	11	arrayOfClass	Class[]
    //   64	37	12	localObject1	Object
    //   104	323	13	localObject2	Object
    //   137	41	14	localTypedValue	android.util.TypedValue
    //   278	1	14	localIllegalAccessException	IllegalAccessException
    //   368	1	14	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   415	1	14	localNotFoundException	android.content.res.Resources.NotFoundException
    // Exception table:
    //   from	to	target	type
    //   130	139	278	java/lang/IllegalAccessException
    //   143	151	278	java/lang/IllegalAccessException
    //   155	164	278	java/lang/IllegalAccessException
    //   168	186	278	java/lang/IllegalAccessException
    //   190	206	278	java/lang/IllegalAccessException
    //   210	258	278	java/lang/IllegalAccessException
    //   33	52	312	java/lang/ClassNotFoundException
    //   66	92	312	java/lang/ClassNotFoundException
    //   106	123	312	java/lang/ClassNotFoundException
    //   130	139	312	java/lang/ClassNotFoundException
    //   143	151	312	java/lang/ClassNotFoundException
    //   155	164	312	java/lang/ClassNotFoundException
    //   168	186	312	java/lang/ClassNotFoundException
    //   190	206	312	java/lang/ClassNotFoundException
    //   210	258	312	java/lang/ClassNotFoundException
    //   258	275	312	java/lang/ClassNotFoundException
    //   280	309	312	java/lang/ClassNotFoundException
    //   370	399	312	java/lang/ClassNotFoundException
    //   417	454	312	java/lang/ClassNotFoundException
    //   130	139	368	java/lang/IllegalArgumentException
    //   143	151	368	java/lang/IllegalArgumentException
    //   155	164	368	java/lang/IllegalArgumentException
    //   168	186	368	java/lang/IllegalArgumentException
    //   190	206	368	java/lang/IllegalArgumentException
    //   210	258	368	java/lang/IllegalArgumentException
    //   33	52	402	java/lang/Exception
    //   66	92	402	java/lang/Exception
    //   106	123	402	java/lang/Exception
    //   130	139	402	java/lang/Exception
    //   143	151	402	java/lang/Exception
    //   155	164	402	java/lang/Exception
    //   168	186	402	java/lang/Exception
    //   190	206	402	java/lang/Exception
    //   210	258	402	java/lang/Exception
    //   258	275	402	java/lang/Exception
    //   280	309	402	java/lang/Exception
    //   370	399	402	java/lang/Exception
    //   417	454	402	java/lang/Exception
    //   130	139	415	android/content/res/Resources$NotFoundException
    //   143	151	415	android/content/res/Resources$NotFoundException
    //   155	164	415	android/content/res/Resources$NotFoundException
    //   168	186	415	android/content/res/Resources$NotFoundException
    //   190	206	415	android/content/res/Resources$NotFoundException
    //   210	258	415	android/content/res/Resources$NotFoundException
  }
  
  public Object getSystemService(String paramString)
  {
    if (paramString.equals("layout_inflater")) {
      return getLayoutInflater();
    }
    return this.mContext.getSystemService(paramString);
  }
  
  public Resources.Theme getTheme()
  {
    if (this.mTheme != null) {
      return this.mTheme;
    }
    return super.getTheme();
  }
  
  public void setClassLoader(ClassLoader paramClassLoader)
  {
    this.mClassLoader = paramClassLoader;
  }
  
  public void setTheme(int paramInt)
  {
    if (this.mContext.getTheme() != null)
    {
      this.mContext.getTheme().applyStyle(paramInt, true);
      return;
    }
    super.setTheme(paramInt);
  }
  
  public void startActivity(Intent paramIntent)
  {
    super.startActivity(getRealIntent(paramIntent));
  }
  
  public ComponentName startService(Intent paramIntent)
  {
    return super.startService(getRealIntent(paramIntent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.xwalk.core.resource.XWalkContextWrapper
 * JD-Core Version:    0.7.0.1
 */