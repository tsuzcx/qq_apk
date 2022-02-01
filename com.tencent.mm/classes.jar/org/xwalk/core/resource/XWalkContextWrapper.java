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
    this.mLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).cloneInContext(this);
    XWalkLayoutInflaterFactory localXWalkLayoutInflaterFactory = new XWalkLayoutInflaterFactory(null);
    localXWalkLayoutInflaterFactory.layoutInflater = this.mLayoutInflater;
    try
    {
      Field localField = LayoutInflater.class.getDeclaredField("mFactorySet");
      localField.setAccessible(true);
      localField.setBoolean(this.mLayoutInflater, false);
      this.mLayoutInflater.setFactory(localXWalkLayoutInflaterFactory);
      this.usingCustomContext = XWalkEnvironment.getUsingCustomContext();
      if (this.usingCustomContext)
      {
        this.mResources = new XWalkResource(getResources(paramContext, str), paramContext);
        if (!XWalkEnvironment.isCurrentVersionSupportForceDarkMode()) {
          break label361;
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
        label361:
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
      label101:
      break label101;
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
      localObject = this.mClassLoader;
      AppMethodBeat.o(155343);
      return localObject;
    }
    Object localObject = XWalkCoreWrapper.getInstance();
    if (localObject != null)
    {
      localObject = ((XWalkCoreWrapper)localObject).getBridgeLoader();
      AppMethodBeat.o(155343);
      return localObject;
    }
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
      if (!WebViewExtension.addFilterResources(this.mResources, getResourcesKeyIdMap(this.mResources))) {
        break label53;
      }
      this.mHasAddFilterResources = true;
    }
    for (;;)
    {
      localResources = this.mResources;
      if (localResources == null) {
        break;
      }
      AppMethodBeat.o(155337);
      return localResources;
      label53:
      Log.e("XWalkLib", "mHasAddFilterResources = false");
    }
    Resources localResources = super.getResources();
    AppMethodBeat.o(155337);
    return localResources;
  }
  
  /* Error */
  public HashMap<Long, Integer> getResourcesKeyIdMap(Resources paramResources)
  {
    // Byte code:
    //   0: ldc_w 429
    //   3: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 431	org/xwalk/core/resource/XWalkContextWrapper:mResourcessKeyIdMap	Ljava/util/HashMap;
    //   9: ifnull +21 -> 30
    //   12: getstatic 431	org/xwalk/core/resource/XWalkContextWrapper:mResourcessKeyIdMap	Ljava/util/HashMap;
    //   15: invokevirtual 436	java/util/HashMap:clone	()Ljava/lang/Object;
    //   18: checkcast 433	java/util/HashMap
    //   21: astore_1
    //   22: ldc_w 429
    //   25: invokestatic 222	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: aload_1
    //   29: areturn
    //   30: ldc 16
    //   32: ldc_w 438
    //   35: invokestatic 187	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: new 433	java/util/HashMap
    //   41: dup
    //   42: invokespecial 440	java/util/HashMap:<init>	()V
    //   45: astore 10
    //   47: aload_0
    //   48: invokevirtual 441	org/xwalk/core/resource/XWalkContextWrapper:getClassLoader	()Ljava/lang/ClassLoader;
    //   51: ldc 13
    //   53: invokevirtual 447	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   56: invokevirtual 451	java/lang/Class:getClasses	()[Ljava/lang/Class;
    //   59: astore 11
    //   61: aload 11
    //   63: arraylength
    //   64: istore 6
    //   66: iconst_0
    //   67: istore_2
    //   68: iload_2
    //   69: iload 6
    //   71: if_icmpge +264 -> 335
    //   74: aload 11
    //   76: iload_2
    //   77: aaload
    //   78: astore 12
    //   80: aload 12
    //   82: invokevirtual 454	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   85: ldc_w 456
    //   88: invokevirtual 257	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   91: ifeq +388 -> 479
    //   94: aload 12
    //   96: invokevirtual 460	java/lang/Class:getFields	()[Ljava/lang/reflect/Field;
    //   99: astore 12
    //   101: aload 12
    //   103: arraylength
    //   104: istore 7
    //   106: iconst_0
    //   107: istore_3
    //   108: iload_3
    //   109: iload 7
    //   111: if_icmpge +368 -> 479
    //   114: aload 12
    //   116: iload_3
    //   117: aaload
    //   118: astore 13
    //   120: aload 13
    //   122: invokevirtual 463	java/lang/reflect/Field:getModifiers	()I
    //   125: invokestatic 469	java/lang/reflect/Modifier:isFinal	(I)Z
    //   128: ifeq +9 -> 137
    //   131: aload 13
    //   133: iconst_1
    //   134: invokevirtual 126	java/lang/reflect/Field:setAccessible	(Z)V
    //   137: iconst_0
    //   138: istore 5
    //   140: iload 5
    //   142: istore 4
    //   144: new 471	android/util/TypedValue
    //   147: dup
    //   148: invokespecial 472	android/util/TypedValue:<init>	()V
    //   151: astore 14
    //   153: iload 5
    //   155: istore 4
    //   157: aload 13
    //   159: aconst_null
    //   160: invokevirtual 476	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   163: istore 5
    //   165: iload 5
    //   167: istore 4
    //   169: aload_1
    //   170: iload 5
    //   172: aload 14
    //   174: iconst_1
    //   175: invokevirtual 480	android/content/res/Resources:getValue	(ILandroid/util/TypedValue;Z)V
    //   178: iload 5
    //   180: istore 4
    //   182: aload 14
    //   184: getfield 483	android/util/TypedValue:assetCookie	I
    //   187: i2l
    //   188: bipush 32
    //   190: lshl
    //   191: aload 14
    //   193: getfield 486	android/util/TypedValue:data	I
    //   196: i2l
    //   197: lor
    //   198: lstore 8
    //   200: iload 5
    //   202: istore 4
    //   204: aload 10
    //   206: lload 8
    //   208: invokestatic 492	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   211: iload 5
    //   213: invokestatic 497	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   216: invokevirtual 501	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   219: pop
    //   220: iload 5
    //   222: istore 4
    //   224: ldc 16
    //   226: new 161	java/lang/StringBuilder
    //   229: dup
    //   230: ldc_w 503
    //   233: invokespecial 166	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   236: aload 13
    //   238: invokevirtual 506	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   241: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: ldc_w 508
    //   247: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: iload 5
    //   252: invokevirtual 178	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   255: ldc_w 510
    //   258: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: lload 8
    //   263: invokevirtual 513	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   266: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   269: invokestatic 516	org/xwalk/core/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   272: aload 13
    //   274: invokevirtual 463	java/lang/reflect/Field:getModifiers	()I
    //   277: invokestatic 469	java/lang/reflect/Modifier:isFinal	(I)Z
    //   280: ifeq +206 -> 486
    //   283: aload 13
    //   285: iconst_0
    //   286: invokevirtual 126	java/lang/reflect/Field:setAccessible	(Z)V
    //   289: goto +197 -> 486
    //   292: astore 14
    //   294: ldc 16
    //   296: new 161	java/lang/StringBuilder
    //   299: dup
    //   300: invokespecial 517	java/lang/StringBuilder:<init>	()V
    //   303: aload 13
    //   305: invokevirtual 506	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   308: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: ldc_w 519
    //   314: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: invokestatic 522	org/xwalk/core/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   323: goto -51 -> 272
    //   326: astore_1
    //   327: ldc 16
    //   329: ldc_w 524
    //   332: invokestatic 230	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   335: aload 10
    //   337: putstatic 431	org/xwalk/core/resource/XWalkContextWrapper:mResourcessKeyIdMap	Ljava/util/HashMap;
    //   340: ldc 16
    //   342: new 161	java/lang/StringBuilder
    //   345: dup
    //   346: ldc_w 526
    //   349: invokespecial 166	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   352: getstatic 431	org/xwalk/core/resource/XWalkContextWrapper:mResourcessKeyIdMap	Ljava/util/HashMap;
    //   355: invokevirtual 530	java/util/HashMap:keySet	()Ljava/util/Set;
    //   358: invokeinterface 535 1 0
    //   363: invokevirtual 178	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   366: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   369: invokestatic 187	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   372: getstatic 431	org/xwalk/core/resource/XWalkContextWrapper:mResourcessKeyIdMap	Ljava/util/HashMap;
    //   375: invokevirtual 436	java/util/HashMap:clone	()Ljava/lang/Object;
    //   378: checkcast 433	java/util/HashMap
    //   381: astore_1
    //   382: ldc_w 429
    //   385: invokestatic 222	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   388: aload_1
    //   389: areturn
    //   390: astore 14
    //   392: ldc 16
    //   394: new 161	java/lang/StringBuilder
    //   397: dup
    //   398: invokespecial 517	java/lang/StringBuilder:<init>	()V
    //   401: aload 13
    //   403: invokevirtual 506	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   406: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: ldc_w 537
    //   412: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   418: invokestatic 522	org/xwalk/core/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   421: goto -149 -> 272
    //   424: astore_1
    //   425: ldc 16
    //   427: aload_1
    //   428: invokevirtual 366	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   431: invokestatic 230	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   434: goto -99 -> 335
    //   437: astore 14
    //   439: ldc 16
    //   441: new 161	java/lang/StringBuilder
    //   444: dup
    //   445: invokespecial 517	java/lang/StringBuilder:<init>	()V
    //   448: aload 13
    //   450: invokevirtual 506	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   453: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: ldc_w 539
    //   459: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: iload 4
    //   464: invokestatic 542	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   467: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   473: invokestatic 522	org/xwalk/core/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   476: goto -204 -> 272
    //   479: iload_2
    //   480: iconst_1
    //   481: iadd
    //   482: istore_2
    //   483: goto -415 -> 68
    //   486: iload_3
    //   487: iconst_1
    //   488: iadd
    //   489: istore_3
    //   490: goto -382 -> 108
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	493	0	this	XWalkContextWrapper
    //   0	493	1	paramResources	Resources
    //   67	416	2	i	int
    //   107	383	3	j	int
    //   142	321	4	k	int
    //   138	113	5	m	int
    //   64	8	6	n	int
    //   104	8	7	i1	int
    //   198	64	8	l	long
    //   45	291	10	localHashMap	HashMap
    //   59	16	11	arrayOfClass	Class[]
    //   78	37	12	localObject1	Object
    //   118	331	13	localObject2	Object
    //   151	41	14	localTypedValue	android.util.TypedValue
    //   292	1	14	localIllegalAccessException	IllegalAccessException
    //   390	1	14	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   437	1	14	localNotFoundException	android.content.res.Resources.NotFoundException
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
    //   392	421	326	java/lang/ClassNotFoundException
    //   439	476	326	java/lang/ClassNotFoundException
    //   144	153	390	java/lang/IllegalArgumentException
    //   157	165	390	java/lang/IllegalArgumentException
    //   169	178	390	java/lang/IllegalArgumentException
    //   182	200	390	java/lang/IllegalArgumentException
    //   204	220	390	java/lang/IllegalArgumentException
    //   224	272	390	java/lang/IllegalArgumentException
    //   47	66	424	java/lang/Exception
    //   80	106	424	java/lang/Exception
    //   120	137	424	java/lang/Exception
    //   144	153	424	java/lang/Exception
    //   157	165	424	java/lang/Exception
    //   169	178	424	java/lang/Exception
    //   182	200	424	java/lang/Exception
    //   204	220	424	java/lang/Exception
    //   224	272	424	java/lang/Exception
    //   272	289	424	java/lang/Exception
    //   294	323	424	java/lang/Exception
    //   392	421	424	java/lang/Exception
    //   439	476	424	java/lang/Exception
    //   144	153	437	android/content/res/Resources$NotFoundException
    //   157	165	437	android/content/res/Resources$NotFoundException
    //   169	178	437	android/content/res/Resources$NotFoundException
    //   182	200	437	android/content/res/Resources$NotFoundException
    //   204	220	437	android/content/res/Resources$NotFoundException
    //   224	272	437	android/content/res/Resources$NotFoundException
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