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
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.View;
import android.view.ViewStub;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
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
  static PackageInfo sInfo;
  static String sLastInfoStr;
  static Resources sResources = null;
  public int apkVersion;
  public String extractedCoreDir;
  public int forceDarkBehavior;
  public boolean isForceDarkMode;
  private ApplicationInfo mApplicationInfo;
  private ClassLoader mClassLoader;
  private Context mContext;
  private boolean mHasAddFilterResources;
  private final LayoutInflater mLayoutInflater;
  private Resources mResources;
  private Resources.Theme mTheme;
  public boolean usingCustomContext;
  
  public XWalkContextWrapper(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(155326);
    this.apkVersion = 0;
    this.mHasAddFilterResources = false;
    this.usingCustomContext = false;
    this.isForceDarkMode = false;
    this.forceDarkBehavior = 2;
    this.apkVersion = paramInt;
    String str = XWalkEnvironment.getDownloadApkPath(paramInt);
    this.extractedCoreDir = XWalkEnvironment.getExtractedCoreDir(paramInt);
    this.mContext = paramContext;
    this.mLayoutInflater = ((LayoutInflater)paramContext.getApplicationContext().getSystemService("layout_inflater")).cloneInContext(this);
    Object localObject = new XWalkLayoutInflaterFactory(null);
    ((XWalkLayoutInflaterFactory)localObject).layoutInflater = this.mLayoutInflater;
    try
    {
      Field localField = LayoutInflater.class.getDeclaredField("mFactorySet");
      localField.setAccessible(true);
      localField.setBoolean(this.mLayoutInflater, false);
      this.mLayoutInflater.setFactory((LayoutInflater.Factory)localObject);
      this.usingCustomContext = XWalkEnvironment.getUsingCustomContext();
      if (this.usingCustomContext)
      {
        this.mResources = new XWalkResource(getResources(paramContext, str), paramContext);
        localObject = XWalkEnvironment.getLocale();
        if (localObject != null)
        {
          Log.i("XWalkLib", "[XWalkContextWrapper] updateResourceLocale, customize locale:" + ((Locale)localObject).toLanguageTag());
          updateResourceLocale((Locale)localObject);
        }
        if (!XWalkEnvironment.isCurrentVersionSupportForceDarkMode()) {
          break label405;
        }
        this.isForceDarkMode = XWalkEnvironment.getForceDarkMode();
        this.forceDarkBehavior = XWalkEnvironment.getForceDarkBehavior();
        Log.i("XWalkLib", "force dark mode suopported isForceDarkMode:" + this.isForceDarkMode + ", forceDarkBehavior:" + this.forceDarkBehavior);
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
        AppMethodBeat.o(155326);
      }
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
        continue;
        this.mResources = getResources(paramContext, str);
        continue;
        label405:
        Log.i("XWalkLib", "force dark mode not suopported");
      }
    }
  }
  
  private boolean checkResApkExist(String paramString)
  {
    AppMethodBeat.i(155330);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(155330);
      return false;
    }
    paramString = new File(paramString);
    if ((paramString.exists()) && (paramString.isFile()))
    {
      AppMethodBeat.o(155330);
      return true;
    }
    AppMethodBeat.o(155330);
    return false;
  }
  
  private PackageInfo getPackageInfo(Context paramContext, String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(155331);
        if (paramString == null)
        {
          paramContext = null;
          AppMethodBeat.o(155331);
          return paramContext;
        }
        if (paramString.equals(sLastInfoStr))
        {
          paramContext = sInfo;
          AppMethodBeat.o(155331);
          continue;
        }
        sLastInfoStr = paramString;
      }
      finally {}
      paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramString, 0);
      sInfo = paramContext;
      AppMethodBeat.o(155331);
    }
  }
  
  private Intent getRealIntent(Intent paramIntent)
  {
    AppMethodBeat.i(155333);
    ComponentName localComponentName = paramIntent.getComponent();
    if (localComponentName != null) {
      paramIntent.setComponent(new ComponentName(getBaseContext(), localComponentName.getClassName()));
    }
    AppMethodBeat.o(155333);
    return paramIntent;
  }
  
  private Resources getResources(Context paramContext, String paramString)
  {
    AppMethodBeat.i(155328);
    if (sResources != null)
    {
      initByPath(paramContext, paramString);
      paramContext = sResources;
      AppMethodBeat.o(155328);
      return paramContext;
    }
    if (checkResApkExist(paramString))
    {
      this.mApplicationInfo = initByPath(paramContext, paramString);
      if (this.mApplicationInfo != null)
      {
        this.mApplicationInfo.sourceDir = paramString;
        this.mApplicationInfo.publicSourceDir = paramString;
      }
    }
    try
    {
      Resources localResources = paramContext.getPackageManager().getResourcesForApplication(this.mApplicationInfo);
      if (localResources != null)
      {
        sResources = localResources;
        Log.i("XWalkLib", "XWalkContextWrapper get application resources");
        localResources = sResources;
        AppMethodBeat.o(155328);
        return localResources;
      }
    }
    catch (Throwable localThrowable)
    {
      Log.i("XWalkLib", "XWalkContextWrapper try getResourcesNotWithReflect failed, use getResourcesWithReflect");
      sResources = getResourcesWithReflect(paramContext, paramString);
      Log.i("XWalkLib", "XWalkContextWrapper checkResApkExist false");
      paramContext = sResources;
      AppMethodBeat.o(155328);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      label113:
      break label113;
    }
  }
  
  private Resources getResourcesWithReflect(Context paramContext, String paramString)
  {
    AppMethodBeat.i(155329);
    try
    {
      paramContext = (AssetManager)AssetManager.class.newInstance();
      paramContext.getClass().getMethod("addAssetPath", new Class[] { String.class }).invoke(paramContext, new Object[] { paramString });
      paramString = super.getResources();
      paramContext = new Resources(paramContext, paramString.getDisplayMetrics(), paramString.getConfiguration());
      AppMethodBeat.o(155329);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      Log.e("XWalkLib", "XWalkContextWrapper getResourcesWithReflect error:" + paramContext.getMessage());
      AppMethodBeat.o(155329);
    }
    return null;
  }
  
  private ApplicationInfo initByPath(Context paramContext, String paramString)
  {
    AppMethodBeat.i(155327);
    paramContext = getPackageInfo(paramContext, paramString);
    if (paramContext != null)
    {
      mPackageName = paramContext.packageName;
      this.mApplicationInfo = paramContext.applicationInfo;
      if (this.mApplicationInfo != null)
      {
        this.mApplicationInfo.sourceDir = paramString;
        this.mApplicationInfo.publicSourceDir = paramString;
      }
    }
    paramContext = this.mApplicationInfo;
    AppMethodBeat.o(155327);
    return paramContext;
  }
  
  public Context getApplicationContext()
  {
    AppMethodBeat.i(155334);
    Context localContext = this.mContext.getApplicationContext();
    AppMethodBeat.o(155334);
    return localContext;
  }
  
  public AssetManager getAssets()
  {
    AppMethodBeat.i(155335);
    Object localObject = getResources();
    if (localObject != null)
    {
      localObject = ((Resources)localObject).getAssets();
      AppMethodBeat.o(155335);
      return localObject;
    }
    localObject = super.getAssets();
    AppMethodBeat.o(155335);
    return localObject;
  }
  
  public Context getBaseContext()
  {
    return this.mContext;
  }
  
  public ClassLoader getClassLoader()
  {
    AppMethodBeat.i(155343);
    if (this.mClassLoader != null)
    {
      Log.i("XWalkLib", "[getClassLoader] customized class loader");
      localObject = this.mClassLoader;
      AppMethodBeat.o(155343);
      return localObject;
    }
    Object localObject = XWalkCoreWrapper.getInstance();
    if (localObject != null)
    {
      Log.i("XWalkLib", "[getClassLoader] xwalk bridge loader");
      localObject = ((XWalkCoreWrapper)localObject).getBridgeLoader();
      AppMethodBeat.o(155343);
      return localObject;
    }
    Log.i("XWalkLib", "[getClassLoader] super class loader");
    localObject = super.getClassLoader();
    AppMethodBeat.o(155343);
    return localObject;
  }
  
  public LayoutInflater getLayoutInflater()
  {
    return this.mLayoutInflater;
  }
  
  public String getPackageName()
  {
    AppMethodBeat.i(155336);
    String str = this.mContext.getPackageName();
    AppMethodBeat.o(155336);
    return str;
  }
  
  public Context getPlatformContext()
  {
    return this.mContext;
  }
  
  public Resources getResources()
  {
    AppMethodBeat.i(155337);
    if (!this.mHasAddFilterResources)
    {
      localObject = getResourcesKeyIdMap(this.mResources);
      if (localObject == null) {
        break label78;
      }
      if (!WebViewExtension.addFilterResources(this.mResources, (Map)localObject)) {
        break label67;
      }
      this.mHasAddFilterResources = true;
      Log.i("XWalkLib", "getResources, mHasAddFilterResources = true");
    }
    for (;;)
    {
      localObject = this.mResources;
      if (localObject == null) {
        break;
      }
      AppMethodBeat.o(155337);
      return localObject;
      label67:
      Log.w("XWalkLib", "getResources, mHasAddFilterResources = false");
      continue;
      label78:
      Log.w("XWalkLib", "getResources, resourceKeyIdMap is empty");
    }
    Object localObject = super.getResources();
    AppMethodBeat.o(155337);
    return localObject;
  }
  
  /* Error */
  public HashMap<Long, Integer> getResourcesKeyIdMap(Resources paramResources)
  {
    // Byte code:
    //   0: ldc_w 459
    //   3: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 461	org/xwalk/core/resource/XWalkContextWrapper:mResourcessKeyIdMap	Ljava/util/HashMap;
    //   9: ifnull +21 -> 30
    //   12: getstatic 461	org/xwalk/core/resource/XWalkContextWrapper:mResourcessKeyIdMap	Ljava/util/HashMap;
    //   15: invokevirtual 466	java/util/HashMap:clone	()Ljava/lang/Object;
    //   18: checkcast 463	java/util/HashMap
    //   21: astore_1
    //   22: ldc_w 459
    //   25: invokestatic 241	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: aload_1
    //   29: areturn
    //   30: ldc 16
    //   32: ldc_w 468
    //   35: invokestatic 182	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: new 463	java/util/HashMap
    //   41: dup
    //   42: invokespecial 470	java/util/HashMap:<init>	()V
    //   45: astore 10
    //   47: aload_0
    //   48: invokevirtual 471	org/xwalk/core/resource/XWalkContextWrapper:getClassLoader	()Ljava/lang/ClassLoader;
    //   51: ldc 13
    //   53: invokevirtual 477	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   56: invokevirtual 481	java/lang/Class:getClasses	()[Ljava/lang/Class;
    //   59: astore 11
    //   61: aload 11
    //   63: arraylength
    //   64: istore 6
    //   66: iconst_0
    //   67: istore_2
    //   68: iload_2
    //   69: iload 6
    //   71: if_icmpge +386 -> 457
    //   74: aload 11
    //   76: iload_2
    //   77: aaload
    //   78: astore 12
    //   80: aload 12
    //   82: invokevirtual 484	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   85: ldc_w 486
    //   88: invokevirtual 276	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   91: ifeq +359 -> 450
    //   94: aload 12
    //   96: invokevirtual 490	java/lang/Class:getFields	()[Ljava/lang/reflect/Field;
    //   99: astore 12
    //   101: aload 12
    //   103: arraylength
    //   104: istore 7
    //   106: iconst_0
    //   107: istore_3
    //   108: iload_3
    //   109: iload 7
    //   111: if_icmpge +339 -> 450
    //   114: aload 12
    //   116: iload_3
    //   117: aaload
    //   118: astore 13
    //   120: aload 13
    //   122: invokevirtual 493	java/lang/reflect/Field:getModifiers	()I
    //   125: invokestatic 499	java/lang/reflect/Modifier:isFinal	(I)Z
    //   128: ifeq +9 -> 137
    //   131: aload 13
    //   133: iconst_1
    //   134: invokevirtual 130	java/lang/reflect/Field:setAccessible	(Z)V
    //   137: iconst_0
    //   138: istore 5
    //   140: iload 5
    //   142: istore 4
    //   144: new 501	android/util/TypedValue
    //   147: dup
    //   148: invokespecial 502	android/util/TypedValue:<init>	()V
    //   151: astore 14
    //   153: iload 5
    //   155: istore 4
    //   157: aload 13
    //   159: aconst_null
    //   160: invokevirtual 506	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   163: istore 5
    //   165: iload 5
    //   167: istore 4
    //   169: aload_1
    //   170: iload 5
    //   172: aload 14
    //   174: iconst_1
    //   175: invokevirtual 510	android/content/res/Resources:getValue	(ILandroid/util/TypedValue;Z)V
    //   178: iload 5
    //   180: istore 4
    //   182: aload 14
    //   184: getfield 513	android/util/TypedValue:assetCookie	I
    //   187: i2l
    //   188: bipush 32
    //   190: lshl
    //   191: aload 14
    //   193: getfield 516	android/util/TypedValue:data	I
    //   196: i2l
    //   197: lor
    //   198: lstore 8
    //   200: iload 5
    //   202: istore 4
    //   204: aload 10
    //   206: lload 8
    //   208: invokestatic 522	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   211: iload 5
    //   213: invokestatic 527	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   216: invokevirtual 531	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   219: pop
    //   220: iload 5
    //   222: istore 4
    //   224: ldc 16
    //   226: new 159	java/lang/StringBuilder
    //   229: dup
    //   230: ldc_w 533
    //   233: invokespecial 164	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   236: aload 13
    //   238: invokevirtual 536	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   241: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: ldc_w 538
    //   247: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: iload 5
    //   252: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   255: ldc_w 540
    //   258: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: lload 8
    //   263: invokevirtual 543	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   266: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   269: invokestatic 546	org/xwalk/core/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   272: aload 13
    //   274: invokevirtual 493	java/lang/reflect/Field:getModifiers	()I
    //   277: invokestatic 499	java/lang/reflect/Modifier:isFinal	(I)Z
    //   280: ifeq +232 -> 512
    //   283: aload 13
    //   285: iconst_0
    //   286: invokevirtual 130	java/lang/reflect/Field:setAccessible	(Z)V
    //   289: goto +223 -> 512
    //   292: astore 14
    //   294: ldc 16
    //   296: new 159	java/lang/StringBuilder
    //   299: dup
    //   300: invokespecial 547	java/lang/StringBuilder:<init>	()V
    //   303: aload 13
    //   305: invokevirtual 536	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   308: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: ldc_w 549
    //   314: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: invokestatic 450	org/xwalk/core/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   323: goto -51 -> 272
    //   326: astore_1
    //   327: ldc 16
    //   329: ldc_w 551
    //   332: aload_1
    //   333: invokestatic 554	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   336: invokevirtual 558	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   339: invokestatic 249	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   342: ldc_w 459
    //   345: invokestatic 241	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   348: aconst_null
    //   349: areturn
    //   350: astore 14
    //   352: ldc 16
    //   354: new 159	java/lang/StringBuilder
    //   357: dup
    //   358: invokespecial 547	java/lang/StringBuilder:<init>	()V
    //   361: aload 13
    //   363: invokevirtual 536	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   366: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: ldc_w 560
    //   372: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   378: invokestatic 450	org/xwalk/core/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   381: goto -109 -> 272
    //   384: astore_1
    //   385: ldc 16
    //   387: ldc_w 562
    //   390: aload_1
    //   391: invokestatic 554	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   394: invokevirtual 558	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   397: invokestatic 249	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   400: ldc_w 459
    //   403: invokestatic 241	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   406: aconst_null
    //   407: areturn
    //   408: astore 14
    //   410: ldc 16
    //   412: new 159	java/lang/StringBuilder
    //   415: dup
    //   416: invokespecial 547	java/lang/StringBuilder:<init>	()V
    //   419: aload 13
    //   421: invokevirtual 536	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   424: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: ldc_w 564
    //   430: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: iload 4
    //   435: invokestatic 567	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   438: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   444: invokestatic 450	org/xwalk/core/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   447: goto -175 -> 272
    //   450: iload_2
    //   451: iconst_1
    //   452: iadd
    //   453: istore_2
    //   454: goto -386 -> 68
    //   457: aload 10
    //   459: putstatic 461	org/xwalk/core/resource/XWalkContextWrapper:mResourcessKeyIdMap	Ljava/util/HashMap;
    //   462: ldc 16
    //   464: new 159	java/lang/StringBuilder
    //   467: dup
    //   468: ldc_w 569
    //   471: invokespecial 164	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   474: getstatic 461	org/xwalk/core/resource/XWalkContextWrapper:mResourcessKeyIdMap	Ljava/util/HashMap;
    //   477: invokevirtual 573	java/util/HashMap:keySet	()Ljava/util/Set;
    //   480: invokeinterface 578 1 0
    //   485: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   488: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   491: invokestatic 182	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   494: getstatic 461	org/xwalk/core/resource/XWalkContextWrapper:mResourcessKeyIdMap	Ljava/util/HashMap;
    //   497: invokevirtual 466	java/util/HashMap:clone	()Ljava/lang/Object;
    //   500: checkcast 463	java/util/HashMap
    //   503: astore_1
    //   504: ldc_w 459
    //   507: invokestatic 241	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   510: aload_1
    //   511: areturn
    //   512: iload_3
    //   513: iconst_1
    //   514: iadd
    //   515: istore_3
    //   516: goto -408 -> 108
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	519	0	this	XWalkContextWrapper
    //   0	519	1	paramResources	Resources
    //   67	387	2	i	int
    //   107	409	3	j	int
    //   142	292	4	k	int
    //   138	113	5	m	int
    //   64	8	6	n	int
    //   104	8	7	i1	int
    //   198	64	8	l	long
    //   45	413	10	localHashMap	HashMap
    //   59	16	11	arrayOfClass	Class[]
    //   78	37	12	localObject1	Object
    //   118	302	13	localObject2	Object
    //   151	41	14	localTypedValue	android.util.TypedValue
    //   292	1	14	localIllegalAccessException	IllegalAccessException
    //   350	1	14	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   408	1	14	localNotFoundException	android.content.res.Resources.NotFoundException
    // Exception table:
    //   from	to	target	type
    //   144	153	292	java/lang/IllegalAccessException
    //   157	165	292	java/lang/IllegalAccessException
    //   169	178	292	java/lang/IllegalAccessException
    //   182	200	292	java/lang/IllegalAccessException
    //   204	220	292	java/lang/IllegalAccessException
    //   224	272	292	java/lang/IllegalAccessException
    //   47	66	326	java/lang/ClassNotFoundException
    //   80	106	326	java/lang/ClassNotFoundException
    //   120	137	326	java/lang/ClassNotFoundException
    //   144	153	326	java/lang/ClassNotFoundException
    //   157	165	326	java/lang/ClassNotFoundException
    //   169	178	326	java/lang/ClassNotFoundException
    //   182	200	326	java/lang/ClassNotFoundException
    //   204	220	326	java/lang/ClassNotFoundException
    //   224	272	326	java/lang/ClassNotFoundException
    //   272	289	326	java/lang/ClassNotFoundException
    //   294	323	326	java/lang/ClassNotFoundException
    //   352	381	326	java/lang/ClassNotFoundException
    //   410	447	326	java/lang/ClassNotFoundException
    //   144	153	350	java/lang/IllegalArgumentException
    //   157	165	350	java/lang/IllegalArgumentException
    //   169	178	350	java/lang/IllegalArgumentException
    //   182	200	350	java/lang/IllegalArgumentException
    //   204	220	350	java/lang/IllegalArgumentException
    //   224	272	350	java/lang/IllegalArgumentException
    //   47	66	384	java/lang/Throwable
    //   80	106	384	java/lang/Throwable
    //   120	137	384	java/lang/Throwable
    //   144	153	384	java/lang/Throwable
    //   157	165	384	java/lang/Throwable
    //   169	178	384	java/lang/Throwable
    //   182	200	384	java/lang/Throwable
    //   204	220	384	java/lang/Throwable
    //   224	272	384	java/lang/Throwable
    //   272	289	384	java/lang/Throwable
    //   294	323	384	java/lang/Throwable
    //   352	381	384	java/lang/Throwable
    //   410	447	384	java/lang/Throwable
    //   144	153	408	android/content/res/Resources$NotFoundException
    //   157	165	408	android/content/res/Resources$NotFoundException
    //   169	178	408	android/content/res/Resources$NotFoundException
    //   182	200	408	android/content/res/Resources$NotFoundException
    //   204	220	408	android/content/res/Resources$NotFoundException
    //   224	272	408	android/content/res/Resources$NotFoundException
  }
  
  public Object getSystemService(String paramString)
  {
    AppMethodBeat.i(155338);
    if (paramString.equals("layout_inflater"))
    {
      paramString = getLayoutInflater();
      AppMethodBeat.o(155338);
      return paramString;
    }
    try
    {
      paramString = this.mContext.getSystemService(paramString);
      AppMethodBeat.o(155338);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.e("XWalkLib", "getSystemService failed " + paramString.getMessage());
      AppMethodBeat.o(155338);
    }
    return null;
  }
  
  public Resources.Theme getTheme()
  {
    AppMethodBeat.i(155339);
    if (this.mTheme != null)
    {
      localTheme = this.mTheme;
      AppMethodBeat.o(155339);
      return localTheme;
    }
    Resources.Theme localTheme = super.getTheme();
    AppMethodBeat.o(155339);
    return localTheme;
  }
  
  public void setClassLoader(ClassLoader paramClassLoader)
  {
    this.mClassLoader = paramClassLoader;
  }
  
  public void setTheme(int paramInt)
  {
    AppMethodBeat.i(155340);
    if (this.mContext.getTheme() != null)
    {
      this.mContext.getTheme().applyStyle(paramInt, true);
      AppMethodBeat.o(155340);
      return;
    }
    super.setTheme(paramInt);
    AppMethodBeat.o(155340);
  }
  
  public void startActivity(Intent paramIntent)
  {
    AppMethodBeat.i(155341);
    super.startActivity(getRealIntent(paramIntent));
    AppMethodBeat.o(155341);
  }
  
  public ComponentName startService(Intent paramIntent)
  {
    AppMethodBeat.i(155342);
    paramIntent = super.startService(getRealIntent(paramIntent));
    AppMethodBeat.o(155342);
    return paramIntent;
  }
  
  public void updateResourceLocale(Locale paramLocale)
  {
    AppMethodBeat.i(206985);
    try
    {
      Resources localResources = this.mResources;
      if (localResources == null)
      {
        Log.e("XWalkLib", "[updateResourceLocale] resources is null");
        AppMethodBeat.o(206985);
        return;
      }
      Configuration localConfiguration = localResources.getConfiguration();
      Log.i("XWalkLib", "[updateResourceLocale] resources:" + localResources + ", new locale:" + paramLocale + ", old locale:" + localConfiguration.locale);
      localConfiguration.setLocale(paramLocale);
      localResources.updateConfiguration(localConfiguration, localResources.getDisplayMetrics());
      AppMethodBeat.o(206985);
      return;
    }
    catch (Exception paramLocale)
    {
      Log.e("XWalkLib", "[updateResourceLocale] error:", paramLocale);
      AppMethodBeat.o(206985);
    }
  }
  
  static final class XWalkLayoutInflaterFactory
    implements LayoutInflater.Factory
  {
    LayoutInflater layoutInflater;
    
    private View createView(String paramString1, String paramString2, AttributeSet paramAttributeSet)
    {
      AppMethodBeat.i(155325);
      Object localObject = null;
      try
      {
        paramString1 = this.layoutInflater.createView(paramString1, paramString2, paramAttributeSet);
        AppMethodBeat.o(155325);
        return paramString1;
      }
      catch (ClassNotFoundException paramString1)
      {
        for (;;)
        {
          paramString1 = localObject;
        }
      }
      catch (InflateException paramString1)
      {
        for (;;)
        {
          paramString1 = localObject;
        }
      }
    }
    
    public final View inflateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
    {
      Object localObject = null;
      AppMethodBeat.i(155324);
      if (paramString.indexOf(".") == -1)
      {
        if (paramString.equals("WebView")) {
          localObject = createView(paramString, "android.webkit.", paramAttributeSet);
        }
        paramContext = (Context)localObject;
        if (localObject == null) {
          paramContext = createView(paramString, "android.widget.", paramAttributeSet);
        }
        localObject = paramContext;
        if (paramContext != null) {}
      }
      for (localObject = createView(paramString, "android.view.", paramAttributeSet);; localObject = this.layoutInflater.createView(paramString, null, paramAttributeSet))
      {
        AppMethodBeat.o(155324);
        return localObject;
      }
    }
    
    public final View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
    {
      AppMethodBeat.i(155323);
      localContext2 = null;
      localContext1 = null;
      try
      {
        paramContext = inflateView(paramString, paramContext, paramAttributeSet);
        paramAttributeSet = paramContext;
        localContext1 = paramContext;
        localContext2 = paramContext;
        if ((paramContext instanceof ViewStub))
        {
          paramAttributeSet = paramContext;
          localContext1 = paramContext;
          localContext2 = paramContext;
          if (Build.VERSION.SDK_INT >= 21)
          {
            localContext1 = paramContext;
            localContext2 = paramContext;
            ((ViewStub)paramContext).setLayoutInflater(this.layoutInflater);
            paramAttributeSet = paramContext;
          }
        }
      }
      catch (ClassNotFoundException paramContext)
      {
        for (;;)
        {
          Log.w("XWalkLib", String.format("[XWalkContextWrapper] class not found. name:%s. Use default Inflate.", new Object[] { paramString }));
          paramAttributeSet = localContext1;
        }
      }
      catch (InflateException paramContext)
      {
        for (;;)
        {
          Log.w("XWalkLib", String.format("[XWalkContextWrapper] Inflate failed. name:%s. Use default Inflate.", new Object[] { paramString }));
          paramAttributeSet = localContext2;
        }
      }
      AppMethodBeat.o(155323);
      return paramAttributeSet;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.xwalk.core.resource.XWalkContextWrapper
 * JD-Core Version:    0.7.0.1
 */