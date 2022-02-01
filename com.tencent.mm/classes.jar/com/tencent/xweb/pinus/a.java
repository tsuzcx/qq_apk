package com.tencent.xweb.pinus;

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
import com.tencent.xweb.pinus.sdk.WebViewExtension;
import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkFileUtil;
import org.xwalk.core.resource.XWalkResource;

public final class a
  extends ContextWrapper
{
  private static HashMap<Long, Integer> mResourcessKeyIdMap;
  private static PackageInfo sInfo;
  private static String sLastInfoStr;
  private static Resources sResources = null;
  public int apkVersion;
  public String extractedCoreDir;
  public int forceDarkBehavior;
  public boolean isForceDarkMode;
  private ApplicationInfo mApplicationInfo;
  public ClassLoader mClassLoader;
  private final Context mContext;
  private boolean mHasAddFilterResources;
  private final LayoutInflater mLayoutInflater;
  private Resources mResources;
  private Resources.Theme mTheme;
  public boolean usingCustomContext;
  
  public a(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(213334);
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
      Log.i("PSContextWrapper", "usingCustomContext:" + this.usingCustomContext + ", resources:" + this.mResources);
      Locale localLocale = XWalkEnvironment.getLocale();
      if (localLocale != null)
      {
        Log.i("PSContextWrapper", "updateResourceLocale, customize locale:" + localLocale.toLanguageTag());
        updateResourceLocale(localLocale);
      }
      if (!XWalkEnvironment.isCurrentVersionSupportForceDarkMode()) {
        break label328;
      }
      this.isForceDarkMode = XWalkEnvironment.getForceDarkMode();
      this.forceDarkBehavior = XWalkEnvironment.getForceDarkBehavior();
      Log.i("PSContextWrapper", "force dark mode supported, isForceDarkMode:" + this.isForceDarkMode + ", forceDarkBehavior:" + this.forceDarkBehavior);
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
      AppMethodBeat.o(213334);
      return;
      this.mResources = getResources(paramContext, str);
      break;
      label328:
      Log.i("PSContextWrapper", "force dark mode not supported");
    }
  }
  
  private Resources bHS(String paramString)
  {
    AppMethodBeat.i(213365);
    try
    {
      AssetManager localAssetManager = (AssetManager)AssetManager.class.newInstance();
      localAssetManager.getClass().getMethod("addAssetPath", new Class[] { String.class }).invoke(localAssetManager, new Object[] { paramString });
      paramString = super.getResources();
      paramString = new Resources(localAssetManager, paramString.getDisplayMetrics(), paramString.getConfiguration());
      AppMethodBeat.o(213365);
      return paramString;
    }
    finally
    {
      Log.e("PSContextWrapper", "getResourcesWithReflect error:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(213365);
    }
    return null;
  }
  
  private PackageInfo getPackageInfo(Context paramContext, String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(213374);
        if (paramString == null)
        {
          paramContext = null;
          AppMethodBeat.o(213374);
          return paramContext;
        }
        if (paramString.equals(sLastInfoStr))
        {
          paramContext = sInfo;
          AppMethodBeat.o(213374);
          continue;
        }
        sLastInfoStr = paramString;
      }
      finally {}
      paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramString, 0);
      sInfo = paramContext;
      AppMethodBeat.o(213374);
    }
  }
  
  private Intent getRealIntent(Intent paramIntent)
  {
    AppMethodBeat.i(213399);
    ComponentName localComponentName = paramIntent.getComponent();
    if (localComponentName != null) {
      paramIntent.setComponent(new ComponentName(getBaseContext(), localComponentName.getClassName()));
    }
    AppMethodBeat.o(213399);
    return paramIntent;
  }
  
  private Resources getResources(Context paramContext, String paramString)
  {
    int j = 0;
    AppMethodBeat.i(213354);
    if (sResources != null)
    {
      initByPath(paramContext, paramString);
      paramContext = sResources;
      AppMethodBeat.o(213354);
      return paramContext;
    }
    int i = j;
    if (paramString != null)
    {
      if (paramString.length() != 0) {
        break label128;
      }
      i = j;
    }
    while (i != 0)
    {
      this.mApplicationInfo = initByPath(paramContext, paramString);
      if (this.mApplicationInfo != null)
      {
        this.mApplicationInfo.sourceDir = paramString;
        this.mApplicationInfo.publicSourceDir = paramString;
        try
        {
          paramContext = paramContext.getPackageManager().getResourcesForApplication(this.mApplicationInfo);
          if (paramContext == null) {
            break label191;
          }
          sResources = paramContext;
          Log.i("PSContextWrapper", "getResources, use application resources");
          paramContext = sResources;
          AppMethodBeat.o(213354);
          return paramContext;
        }
        finally
        {
          label128:
          File localFile;
          Log.e("PSContextWrapper", "getResources, error:" + paramContext.getMessage());
        }
        localFile = new File(paramString);
        i = j;
        if (!localFile.exists()) {
          continue;
        }
        i = j;
        if (!localFile.isFile()) {
          continue;
        }
        i = 1;
        continue;
      }
      label191:
      Log.i("PSContextWrapper", "getResources failed, try getResourcesWithReflect");
      sResources = bHS(paramString);
    }
    Log.i("PSContextWrapper", "getResources, resources:" + sResources);
    paramContext = sResources;
    AppMethodBeat.o(213354);
    return paramContext;
  }
  
  /* Error */
  private HashMap<Long, Integer> getResourcesKeyIdMap(Resources paramResources)
  {
    // Byte code:
    //   0: ldc_w 362
    //   3: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 364	com/tencent/xweb/pinus/a:mResourcessKeyIdMap	Ljava/util/HashMap;
    //   9: ifnull +22 -> 31
    //   12: new 366	java/util/HashMap
    //   15: dup
    //   16: getstatic 364	com/tencent/xweb/pinus/a:mResourcessKeyIdMap	Ljava/util/HashMap;
    //   19: invokespecial 369	java/util/HashMap:<init>	(Ljava/util/Map;)V
    //   22: astore_1
    //   23: ldc_w 362
    //   26: invokestatic 206	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_1
    //   30: areturn
    //   31: ldc 111
    //   33: ldc_w 371
    //   36: invokestatic 139	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: new 366	java/util/HashMap
    //   42: dup
    //   43: invokespecial 373	java/util/HashMap:<init>	()V
    //   46: astore 7
    //   48: aload_0
    //   49: invokevirtual 377	com/tencent/xweb/pinus/a:getClassLoader	()Ljava/lang/ClassLoader;
    //   52: ldc_w 379
    //   55: invokevirtual 385	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   58: invokevirtual 389	java/lang/Class:getClasses	()[Ljava/lang/Class;
    //   61: astore 8
    //   63: aload 8
    //   65: arraylength
    //   66: istore 4
    //   68: iconst_0
    //   69: istore_2
    //   70: iload_2
    //   71: iload 4
    //   73: if_icmpge +314 -> 387
    //   76: aload 8
    //   78: iload_2
    //   79: aaload
    //   80: astore 9
    //   82: aload 9
    //   84: invokevirtual 392	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   87: ldc_w 394
    //   90: invokevirtual 273	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   93: ifeq +287 -> 380
    //   96: aload 9
    //   98: invokevirtual 398	java/lang/Class:getFields	()[Ljava/lang/reflect/Field;
    //   101: astore 9
    //   103: aload 9
    //   105: arraylength
    //   106: istore 5
    //   108: iconst_0
    //   109: istore_3
    //   110: iload_3
    //   111: iload 5
    //   113: if_icmpge +267 -> 380
    //   116: aload 9
    //   118: iload_3
    //   119: aaload
    //   120: astore 10
    //   122: aload 10
    //   124: invokevirtual 403	java/lang/reflect/Field:getModifiers	()I
    //   127: invokestatic 409	java/lang/reflect/Modifier:isFinal	(I)Z
    //   130: ifeq +9 -> 139
    //   133: aload 10
    //   135: iconst_1
    //   136: invokevirtual 413	java/lang/reflect/Field:setAccessible	(Z)V
    //   139: new 415	android/util/TypedValue
    //   142: dup
    //   143: invokespecial 416	android/util/TypedValue:<init>	()V
    //   146: astore 11
    //   148: aload 10
    //   150: aconst_null
    //   151: invokevirtual 420	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   154: istore 6
    //   156: aload_1
    //   157: iload 6
    //   159: aload 11
    //   161: iconst_1
    //   162: invokevirtual 424	android/content/res/Resources:getValue	(ILandroid/util/TypedValue;Z)V
    //   165: aload 7
    //   167: aload 11
    //   169: getfield 427	android/util/TypedValue:assetCookie	I
    //   172: i2l
    //   173: bipush 32
    //   175: lshl
    //   176: aload 11
    //   178: getfield 430	android/util/TypedValue:data	I
    //   181: i2l
    //   182: lor
    //   183: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   186: iload 6
    //   188: invokestatic 440	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   191: invokevirtual 444	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   194: pop
    //   195: aload 10
    //   197: invokevirtual 403	java/lang/reflect/Field:getModifiers	()I
    //   200: invokestatic 409	java/lang/reflect/Modifier:isFinal	(I)Z
    //   203: ifeq +240 -> 443
    //   206: aload 10
    //   208: iconst_0
    //   209: invokevirtual 413	java/lang/reflect/Field:setAccessible	(Z)V
    //   212: goto +231 -> 443
    //   215: astore 11
    //   217: ldc 111
    //   219: new 113	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 445	java/lang/StringBuilder:<init>	()V
    //   226: aload 10
    //   228: invokevirtual 448	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   231: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: ldc_w 450
    //   237: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: aload 11
    //   242: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   245: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokestatic 266	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   251: goto -56 -> 195
    //   254: astore_1
    //   255: ldc 111
    //   257: ldc_w 452
    //   260: aload_1
    //   261: invokestatic 259	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   264: invokevirtual 263	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   267: invokestatic 266	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   270: ldc_w 362
    //   273: invokestatic 206	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   276: aconst_null
    //   277: areturn
    //   278: astore 11
    //   280: ldc 111
    //   282: new 113	java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial 445	java/lang/StringBuilder:<init>	()V
    //   289: aload 10
    //   291: invokevirtual 448	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   294: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: ldc_w 454
    //   300: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: aload 11
    //   305: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   308: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   311: invokestatic 266	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   314: goto -119 -> 195
    //   317: astore_1
    //   318: ldc 111
    //   320: ldc_w 456
    //   323: aload_1
    //   324: invokestatic 259	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   327: invokevirtual 263	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   330: invokestatic 266	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   333: ldc_w 362
    //   336: invokestatic 206	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   339: aconst_null
    //   340: areturn
    //   341: astore 11
    //   343: ldc 111
    //   345: new 113	java/lang/StringBuilder
    //   348: dup
    //   349: invokespecial 445	java/lang/StringBuilder:<init>	()V
    //   352: aload 10
    //   354: invokevirtual 448	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   357: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: ldc_w 458
    //   363: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: aload 11
    //   368: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   371: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: invokestatic 266	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   377: goto -182 -> 195
    //   380: iload_2
    //   381: iconst_1
    //   382: iadd
    //   383: istore_2
    //   384: goto -314 -> 70
    //   387: aload 7
    //   389: putstatic 364	com/tencent/xweb/pinus/a:mResourcessKeyIdMap	Ljava/util/HashMap;
    //   392: ldc 111
    //   394: new 113	java/lang/StringBuilder
    //   397: dup
    //   398: ldc_w 460
    //   401: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   404: getstatic 364	com/tencent/xweb/pinus/a:mResourcessKeyIdMap	Ljava/util/HashMap;
    //   407: invokevirtual 464	java/util/HashMap:keySet	()Ljava/util/Set;
    //   410: invokeinterface 469 1 0
    //   415: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   418: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   421: invokestatic 139	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   424: new 366	java/util/HashMap
    //   427: dup
    //   428: getstatic 364	com/tencent/xweb/pinus/a:mResourcessKeyIdMap	Ljava/util/HashMap;
    //   431: invokespecial 369	java/util/HashMap:<init>	(Ljava/util/Map;)V
    //   434: astore_1
    //   435: ldc_w 362
    //   438: invokestatic 206	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   441: aload_1
    //   442: areturn
    //   443: iload_3
    //   444: iconst_1
    //   445: iadd
    //   446: istore_3
    //   447: goto -337 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	450	0	this	a
    //   0	450	1	paramResources	Resources
    //   69	315	2	i	int
    //   109	338	3	j	int
    //   66	8	4	k	int
    //   106	8	5	m	int
    //   154	33	6	n	int
    //   46	342	7	localHashMap	HashMap
    //   61	16	8	arrayOfClass	Class[]
    //   80	37	9	localObject1	Object
    //   120	233	10	localObject2	Object
    //   146	31	11	localTypedValue	android.util.TypedValue
    //   215	26	11	localIllegalAccessException	java.lang.IllegalAccessException
    //   278	26	11	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   341	26	11	localNotFoundException	android.content.res.Resources.NotFoundException
    // Exception table:
    //   from	to	target	type
    //   139	195	215	java/lang/IllegalAccessException
    //   48	68	254	java/lang/ClassNotFoundException
    //   82	108	254	java/lang/ClassNotFoundException
    //   122	139	254	java/lang/ClassNotFoundException
    //   139	195	254	java/lang/ClassNotFoundException
    //   195	212	254	java/lang/ClassNotFoundException
    //   217	251	254	java/lang/ClassNotFoundException
    //   280	314	254	java/lang/ClassNotFoundException
    //   343	377	254	java/lang/ClassNotFoundException
    //   139	195	278	java/lang/IllegalArgumentException
    //   48	68	317	finally
    //   82	108	317	finally
    //   122	139	317	finally
    //   139	195	317	finally
    //   195	212	317	finally
    //   217	251	317	finally
    //   280	314	317	finally
    //   343	377	317	finally
    //   139	195	341	android/content/res/Resources$NotFoundException
  }
  
  private ApplicationInfo initByPath(Context paramContext, String paramString)
  {
    AppMethodBeat.i(213342);
    Log.i("PSContextWrapper", "initByPath, path:".concat(String.valueOf(paramString)));
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
    AppMethodBeat.o(213342);
    return paramContext;
  }
  
  public final Context getApplicationContext()
  {
    AppMethodBeat.i(213421);
    Context localContext = this.mContext.getApplicationContext();
    AppMethodBeat.o(213421);
    return localContext;
  }
  
  public final AssetManager getAssets()
  {
    AppMethodBeat.i(213427);
    Object localObject = getResources();
    if (localObject != null)
    {
      localObject = ((Resources)localObject).getAssets();
      AppMethodBeat.o(213427);
      return localObject;
    }
    localObject = super.getAssets();
    AppMethodBeat.o(213427);
    return localObject;
  }
  
  public final Context getBaseContext()
  {
    return this.mContext;
  }
  
  public final ClassLoader getClassLoader()
  {
    AppMethodBeat.i(213486);
    if (this.mClassLoader != null)
    {
      Log.i("PSContextWrapper", "getClassLoader, customized class loader:" + this.mClassLoader);
      localClassLoader = this.mClassLoader;
      AppMethodBeat.o(213486);
      return localClassLoader;
    }
    ClassLoader localClassLoader = e.khp().getClassLoader();
    if (localClassLoader != null)
    {
      Log.i("PSContextWrapper", "getClassLoader, pinus class loader:".concat(String.valueOf(localClassLoader)));
      AppMethodBeat.o(213486);
      return localClassLoader;
    }
    Log.i("PSContextWrapper", "getClassLoader, super class loader");
    localClassLoader = super.getClassLoader();
    AppMethodBeat.o(213486);
    return localClassLoader;
  }
  
  public final String getPackageName()
  {
    AppMethodBeat.i(213438);
    String str = this.mContext.getPackageName();
    AppMethodBeat.o(213438);
    return str;
  }
  
  public final Resources getResources()
  {
    AppMethodBeat.i(213444);
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
      Log.i("PSContextWrapper", "getResources, mHasAddFilterResources = true");
    }
    for (;;)
    {
      localObject = this.mResources;
      if (localObject == null) {
        break;
      }
      AppMethodBeat.o(213444);
      return localObject;
      label67:
      Log.w("PSContextWrapper", "getResources, mHasAddFilterResources = false");
      continue;
      label78:
      Log.w("PSContextWrapper", "getResources, resourceKeyIdMap is empty");
    }
    Object localObject = super.getResources();
    AppMethodBeat.o(213444);
    return localObject;
  }
  
  public final Object getSystemService(String paramString)
  {
    AppMethodBeat.i(213450);
    if (paramString.equals("layout_inflater"))
    {
      Log.w("PSContextWrapper", "getSystemService, layoutInflater:" + this.mLayoutInflater);
      paramString = this.mLayoutInflater;
      AppMethodBeat.o(213450);
      return paramString;
    }
    try
    {
      Log.w("PSContextWrapper", "getSystemService, context:" + this.mContext + ", activity?" + (this.mContext instanceof Activity));
      paramString = this.mContext.getSystemService(paramString);
      AppMethodBeat.o(213450);
      return paramString;
    }
    finally
    {
      Log.e("PSContextWrapper", "getSystemService error:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(213450);
    }
    return null;
  }
  
  public final Resources.Theme getTheme()
  {
    AppMethodBeat.i(213457);
    if (this.mTheme != null)
    {
      localTheme = this.mTheme;
      AppMethodBeat.o(213457);
      return localTheme;
    }
    Resources.Theme localTheme = super.getTheme();
    AppMethodBeat.o(213457);
    return localTheme;
  }
  
  public final void setTheme(int paramInt)
  {
    AppMethodBeat.i(213463);
    if (this.mContext.getTheme() != null)
    {
      this.mContext.getTheme().applyStyle(paramInt, true);
      AppMethodBeat.o(213463);
      return;
    }
    super.setTheme(paramInt);
    AppMethodBeat.o(213463);
  }
  
  public final void startActivity(Intent paramIntent)
  {
    AppMethodBeat.i(213472);
    super.startActivity(getRealIntent(paramIntent));
    AppMethodBeat.o(213472);
  }
  
  public final ComponentName startService(Intent paramIntent)
  {
    AppMethodBeat.i(213478);
    paramIntent = super.startService(getRealIntent(paramIntent));
    AppMethodBeat.o(213478);
    return paramIntent;
  }
  
  public final void updateResourceLocale(Locale paramLocale)
  {
    AppMethodBeat.i(213417);
    try
    {
      Resources localResources = this.mResources;
      if (localResources == null)
      {
        Log.e("PSContextWrapper", "updateResourceLocale, resources is null");
        AppMethodBeat.o(213417);
        return;
      }
      Configuration localConfiguration = localResources.getConfiguration();
      Log.i("PSContextWrapper", "updateResourceLocale, resources:" + localResources + ", new locale:" + paramLocale + ", old locale:" + localConfiguration.locale);
      localConfiguration.setLocale(paramLocale);
      localResources.updateConfiguration(localConfiguration, localResources.getDisplayMetrics());
      AppMethodBeat.o(213417);
      return;
    }
    finally
    {
      Log.e("PSContextWrapper", "updateResourceLocale, error:".concat(String.valueOf(paramLocale)));
      AppMethodBeat.o(213417);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.pinus.a
 * JD-Core Version:    0.7.0.1
 */