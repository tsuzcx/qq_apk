package org.xwalk.core.resource;

import android.app.Activity;
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
import android.view.LayoutInflater;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.xwalk.core.Log;
import org.xwalk.core.WebViewExtension;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkFileUtil;
import org.xwalk.core.XWalkStandAloneChannel;

public class XWalkContextWrapper
  extends ContextWrapper
{
  private static final String GENERATED_RESOURCE_CLASS = "org.xwalk.core.R";
  private static final String TAG = "XWalkContextWrapper";
  private static HashMap<Long, Integer> mResourcessKeyIdMap;
  private static PackageInfo sInfo;
  private static String sLastInfoStr;
  private static Resources sResources = null;
  public int apkVersion;
  public String extractedCoreDir;
  public int forceDarkBehavior;
  public boolean isForceDarkMode;
  private ApplicationInfo mApplicationInfo;
  private ClassLoader mClassLoader;
  private final Context mContext;
  private boolean mHasAddFilterResources;
  private final LayoutInflater mLayoutInflater;
  private Resources mResources;
  private Resources.Theme mTheme;
  public boolean usingCustomContext;
  
  public XWalkContextWrapper(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(155326);
    this.mHasAddFilterResources = false;
    this.apkVersion = 0;
    this.usingCustomContext = false;
    this.isForceDarkMode = false;
    this.forceDarkBehavior = 2;
    this.mContext = paramContext;
    this.apkVersion = paramInt;
    this.extractedCoreDir = XWalkFileUtil.getExtractedCoreDir(paramInt);
    this.mLayoutInflater = ((LayoutInflater)paramContext.getApplicationContext().getSystemService("layout_inflater")).cloneInContext(this);
    String str = XWalkFileUtil.getDownloadApkPath(paramInt);
    this.usingCustomContext = XWalkEnvironment.getUsingCustomContextInternal();
    if (this.usingCustomContext)
    {
      this.mResources = new XWalkResource(getResources(paramContext, str), paramContext);
      Log.i("XWalkContextWrapper", "usingCustomContext:" + this.usingCustomContext + ", resources:" + this.mResources);
      Locale localLocale = XWalkEnvironment.getLocale();
      if (localLocale != null)
      {
        Log.i("XWalkContextWrapper", "updateResourceLocale, customize locale:" + localLocale.toLanguageTag());
        updateResourceLocale(localLocale);
      }
      if (!XWalkEnvironment.isCurrentVersionSupportForceDarkMode()) {
        break label328;
      }
      this.isForceDarkMode = XWalkEnvironment.getForceDarkMode();
      this.forceDarkBehavior = XWalkEnvironment.getForceDarkBehavior();
      Log.i("XWalkContextWrapper", "force dark mode supported, isForceDarkMode:" + this.isForceDarkMode + ", forceDarkBehavior:" + this.forceDarkBehavior);
    }
    for (;;)
    {
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
      return;
      this.mResources = getResources(paramContext, str);
      break;
      label328:
      Log.i("XWalkContextWrapper", "force dark mode not supported");
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
        try
        {
          Resources localResources = paramContext.getPackageManager().getResourcesForApplication(this.mApplicationInfo);
          if (localResources != null)
          {
            sResources = localResources;
            Log.i("XWalkContextWrapper", "getResources, use application resources");
            localResources = sResources;
            AppMethodBeat.o(155328);
            return localResources;
          }
        }
        finally
        {
          Log.e("XWalkContextWrapper", "getResources, error:" + localObject.getMessage());
        }
      }
      Log.i("XWalkContextWrapper", "getResources failed, try getResourcesWithReflect");
      sResources = getResourcesWithReflect(paramContext, paramString);
    }
    Log.i("XWalkContextWrapper", "getResources, resources:" + sResources);
    paramContext = sResources;
    AppMethodBeat.o(155328);
    return paramContext;
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
    finally
    {
      Log.e("XWalkContextWrapper", "getResourcesWithReflect error:".concat(String.valueOf(paramContext)));
      AppMethodBeat.o(155329);
    }
    return null;
  }
  
  private ApplicationInfo initByPath(Context paramContext, String paramString)
  {
    AppMethodBeat.i(155327);
    Log.i("XWalkContextWrapper", "initByPath, path:".concat(String.valueOf(paramString)));
    paramContext = getPackageInfo(paramContext, paramString);
    if (paramContext != null)
    {
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
      Log.i("XWalkContextWrapper", "getClassLoader, customized class loader:" + this.mClassLoader);
      localClassLoader = this.mClassLoader;
      AppMethodBeat.o(155343);
      return localClassLoader;
    }
    ClassLoader localClassLoader = XWalkStandAloneChannel.getInstance().getClassLoader();
    if (localClassLoader != null)
    {
      Log.i("XWalkContextWrapper", "getClassLoader, xwalk class loader:".concat(String.valueOf(localClassLoader)));
      AppMethodBeat.o(155343);
      return localClassLoader;
    }
    Log.i("XWalkContextWrapper", "getClassLoader, super class loader");
    localClassLoader = super.getClassLoader();
    AppMethodBeat.o(155343);
    return localClassLoader;
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
      Log.i("XWalkContextWrapper", "getResources, mHasAddFilterResources = true");
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
      Log.w("XWalkContextWrapper", "getResources, mHasAddFilterResources = false");
      continue;
      label78:
      Log.w("XWalkContextWrapper", "getResources, resourceKeyIdMap is empty");
    }
    Object localObject = super.getResources();
    AppMethodBeat.o(155337);
    return localObject;
  }
  
  /* Error */
  public HashMap<Long, Integer> getResourcesKeyIdMap(Resources paramResources)
  {
    // Byte code:
    //   0: ldc_w 430
    //   3: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 432	org/xwalk/core/resource/XWalkContextWrapper:mResourcessKeyIdMap	Ljava/util/HashMap;
    //   9: ifnull +22 -> 31
    //   12: new 434	java/util/HashMap
    //   15: dup
    //   16: getstatic 432	org/xwalk/core/resource/XWalkContextWrapper:mResourcessKeyIdMap	Ljava/util/HashMap;
    //   19: invokespecial 437	java/util/HashMap:<init>	(Ljava/util/Map;)V
    //   22: astore_1
    //   23: ldc_w 430
    //   26: invokestatic 210	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_1
    //   30: areturn
    //   31: ldc 11
    //   33: ldc_w 439
    //   36: invokestatic 143	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: new 434	java/util/HashMap
    //   42: dup
    //   43: invokespecial 441	java/util/HashMap:<init>	()V
    //   46: astore 7
    //   48: aload_0
    //   49: invokevirtual 442	org/xwalk/core/resource/XWalkContextWrapper:getClassLoader	()Ljava/lang/ClassLoader;
    //   52: ldc 8
    //   54: invokevirtual 448	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   57: invokevirtual 452	java/lang/Class:getClasses	()[Ljava/lang/Class;
    //   60: astore 8
    //   62: aload 8
    //   64: arraylength
    //   65: istore 4
    //   67: iconst_0
    //   68: istore_2
    //   69: iload_2
    //   70: iload 4
    //   72: if_icmpge +314 -> 386
    //   75: aload 8
    //   77: iload_2
    //   78: aaload
    //   79: astore 9
    //   81: aload 9
    //   83: invokevirtual 455	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   86: ldc_w 457
    //   89: invokevirtual 236	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   92: ifeq +287 -> 379
    //   95: aload 9
    //   97: invokevirtual 461	java/lang/Class:getFields	()[Ljava/lang/reflect/Field;
    //   100: astore 9
    //   102: aload 9
    //   104: arraylength
    //   105: istore 5
    //   107: iconst_0
    //   108: istore_3
    //   109: iload_3
    //   110: iload 5
    //   112: if_icmpge +267 -> 379
    //   115: aload 9
    //   117: iload_3
    //   118: aaload
    //   119: astore 10
    //   121: aload 10
    //   123: invokevirtual 466	java/lang/reflect/Field:getModifiers	()I
    //   126: invokestatic 472	java/lang/reflect/Modifier:isFinal	(I)Z
    //   129: ifeq +9 -> 138
    //   132: aload 10
    //   134: iconst_1
    //   135: invokevirtual 476	java/lang/reflect/Field:setAccessible	(Z)V
    //   138: new 478	android/util/TypedValue
    //   141: dup
    //   142: invokespecial 479	android/util/TypedValue:<init>	()V
    //   145: astore 11
    //   147: aload 10
    //   149: aconst_null
    //   150: invokevirtual 483	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   153: istore 6
    //   155: aload_1
    //   156: iload 6
    //   158: aload 11
    //   160: iconst_1
    //   161: invokevirtual 487	android/content/res/Resources:getValue	(ILandroid/util/TypedValue;Z)V
    //   164: aload 7
    //   166: aload 11
    //   168: getfield 490	android/util/TypedValue:assetCookie	I
    //   171: i2l
    //   172: bipush 32
    //   174: lshl
    //   175: aload 11
    //   177: getfield 493	android/util/TypedValue:data	I
    //   180: i2l
    //   181: lor
    //   182: invokestatic 498	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   185: iload 6
    //   187: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   190: invokevirtual 507	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   193: pop
    //   194: aload 10
    //   196: invokevirtual 466	java/lang/reflect/Field:getModifiers	()I
    //   199: invokestatic 472	java/lang/reflect/Modifier:isFinal	(I)Z
    //   202: ifeq +240 -> 442
    //   205: aload 10
    //   207: iconst_0
    //   208: invokevirtual 476	java/lang/reflect/Field:setAccessible	(Z)V
    //   211: goto +231 -> 442
    //   214: astore 11
    //   216: ldc 11
    //   218: new 117	java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   225: aload 10
    //   227: invokevirtual 511	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   230: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: ldc_w 513
    //   236: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: aload 11
    //   241: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   244: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokestatic 301	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   250: goto -56 -> 194
    //   253: astore_1
    //   254: ldc 11
    //   256: ldc_w 515
    //   259: aload_1
    //   260: invokestatic 355	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   263: invokevirtual 359	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   266: invokestatic 301	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   269: ldc_w 430
    //   272: invokestatic 210	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   275: aconst_null
    //   276: areturn
    //   277: astore 11
    //   279: ldc 11
    //   281: new 117	java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   288: aload 10
    //   290: invokevirtual 511	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   293: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: ldc_w 517
    //   299: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: aload 11
    //   304: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   307: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: invokestatic 301	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   313: goto -119 -> 194
    //   316: astore_1
    //   317: ldc 11
    //   319: ldc_w 519
    //   322: aload_1
    //   323: invokestatic 355	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   326: invokevirtual 359	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   329: invokestatic 301	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   332: ldc_w 430
    //   335: invokestatic 210	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   338: aconst_null
    //   339: areturn
    //   340: astore 11
    //   342: ldc 11
    //   344: new 117	java/lang/StringBuilder
    //   347: dup
    //   348: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   351: aload 10
    //   353: invokevirtual 511	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   356: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: ldc_w 521
    //   362: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: aload 11
    //   367: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   370: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: invokestatic 301	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   376: goto -182 -> 194
    //   379: iload_2
    //   380: iconst_1
    //   381: iadd
    //   382: istore_2
    //   383: goto -314 -> 69
    //   386: aload 7
    //   388: putstatic 432	org/xwalk/core/resource/XWalkContextWrapper:mResourcessKeyIdMap	Ljava/util/HashMap;
    //   391: ldc 11
    //   393: new 117	java/lang/StringBuilder
    //   396: dup
    //   397: ldc_w 523
    //   400: invokespecial 122	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   403: getstatic 432	org/xwalk/core/resource/XWalkContextWrapper:mResourcessKeyIdMap	Ljava/util/HashMap;
    //   406: invokevirtual 527	java/util/HashMap:keySet	()Ljava/util/Set;
    //   409: invokeinterface 532 1 0
    //   414: invokevirtual 175	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   417: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   420: invokestatic 143	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   423: new 434	java/util/HashMap
    //   426: dup
    //   427: getstatic 432	org/xwalk/core/resource/XWalkContextWrapper:mResourcessKeyIdMap	Ljava/util/HashMap;
    //   430: invokespecial 437	java/util/HashMap:<init>	(Ljava/util/Map;)V
    //   433: astore_1
    //   434: ldc_w 430
    //   437: invokestatic 210	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   440: aload_1
    //   441: areturn
    //   442: iload_3
    //   443: iconst_1
    //   444: iadd
    //   445: istore_3
    //   446: goto -337 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	449	0	this	XWalkContextWrapper
    //   0	449	1	paramResources	Resources
    //   68	315	2	i	int
    //   108	338	3	j	int
    //   65	8	4	k	int
    //   105	8	5	m	int
    //   153	33	6	n	int
    //   46	341	7	localHashMap	HashMap
    //   60	16	8	arrayOfClass	Class[]
    //   79	37	9	localObject1	Object
    //   119	233	10	localObject2	Object
    //   145	31	11	localTypedValue	android.util.TypedValue
    //   214	26	11	localIllegalAccessException	java.lang.IllegalAccessException
    //   277	26	11	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   340	26	11	localNotFoundException	android.content.res.Resources.NotFoundException
    // Exception table:
    //   from	to	target	type
    //   138	194	214	java/lang/IllegalAccessException
    //   48	67	253	java/lang/ClassNotFoundException
    //   81	107	253	java/lang/ClassNotFoundException
    //   121	138	253	java/lang/ClassNotFoundException
    //   138	194	253	java/lang/ClassNotFoundException
    //   194	211	253	java/lang/ClassNotFoundException
    //   216	250	253	java/lang/ClassNotFoundException
    //   279	313	253	java/lang/ClassNotFoundException
    //   342	376	253	java/lang/ClassNotFoundException
    //   138	194	277	java/lang/IllegalArgumentException
    //   48	67	316	finally
    //   81	107	316	finally
    //   121	138	316	finally
    //   138	194	316	finally
    //   194	211	316	finally
    //   216	250	316	finally
    //   279	313	316	finally
    //   342	376	316	finally
    //   138	194	340	android/content/res/Resources$NotFoundException
  }
  
  public Object getSystemService(String paramString)
  {
    AppMethodBeat.i(155338);
    if (paramString.equals("layout_inflater"))
    {
      Log.w("XWalkContextWrapper", "getSystemService, layoutInflater:" + getLayoutInflater());
      paramString = getLayoutInflater();
      AppMethodBeat.o(155338);
      return paramString;
    }
    try
    {
      Log.w("XWalkContextWrapper", "getSystemService, context:" + this.mContext + ", activity?" + (this.mContext instanceof Activity));
      paramString = this.mContext.getSystemService(paramString);
      AppMethodBeat.o(155338);
      return paramString;
    }
    finally
    {
      Log.e("XWalkContextWrapper", "getSystemService error:".concat(String.valueOf(paramString)));
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
    AppMethodBeat.i(187750);
    try
    {
      Resources localResources = this.mResources;
      if (localResources == null)
      {
        Log.e("XWalkContextWrapper", "updateResourceLocale, resources is null");
        AppMethodBeat.o(187750);
        return;
      }
      Configuration localConfiguration = localResources.getConfiguration();
      Log.i("XWalkContextWrapper", "updateResourceLocale, resources:" + localResources + ", new locale:" + paramLocale + ", old locale:" + localConfiguration.locale);
      localConfiguration.setLocale(paramLocale);
      localResources.updateConfiguration(localConfiguration, localResources.getDisplayMetrics());
      AppMethodBeat.o(187750);
      return;
    }
    finally
    {
      Log.e("XWalkContextWrapper", "updateResourceLocale, error:".concat(String.valueOf(paramLocale)));
      AppMethodBeat.o(187750);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.xwalk.core.resource.XWalkContextWrapper
 * JD-Core Version:    0.7.0.1
 */