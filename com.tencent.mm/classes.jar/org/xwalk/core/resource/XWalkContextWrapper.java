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
    AppMethodBeat.i(86212);
    this.apkVersion = 0;
    this.mHasAddFilterResources = false;
    this.usingCustomContext = false;
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
      this.usingCustomContext = XWalkEnvironment.getUsingCustomContext();
      if (this.usingCustomContext)
      {
        this.mResources = new XWalkResource(getResources(paramContext, str), paramContext);
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
        AppMethodBeat.o(86212);
        return;
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
      }
    }
  }
  
  private boolean checkResApkExist(String paramString)
  {
    AppMethodBeat.i(86215);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(86215);
      return false;
    }
    paramString = new File(paramString);
    if ((paramString.exists()) && (paramString.isFile()))
    {
      AppMethodBeat.o(86215);
      return true;
    }
    AppMethodBeat.o(86215);
    return false;
  }
  
  private PackageInfo getPackageInfo(Context paramContext, String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(86216);
        if (paramString == null)
        {
          paramContext = null;
          AppMethodBeat.o(86216);
          return paramContext;
        }
        if (paramString.equals(sLastInfoStr))
        {
          paramContext = sInfo;
          AppMethodBeat.o(86216);
          continue;
        }
        sLastInfoStr = paramString;
      }
      finally {}
      paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramString, 0);
      sInfo = paramContext;
      AppMethodBeat.o(86216);
    }
  }
  
  private Intent getRealIntent(Intent paramIntent)
  {
    AppMethodBeat.i(86218);
    ComponentName localComponentName = paramIntent.getComponent();
    if (localComponentName != null) {
      paramIntent.setComponent(new ComponentName(getBaseContext(), localComponentName.getClassName()));
    }
    AppMethodBeat.o(86218);
    return paramIntent;
  }
  
  private Resources getResources(Context paramContext, String paramString)
  {
    AppMethodBeat.i(86213);
    if (sResources != null)
    {
      initByPath(paramContext, paramString);
      paramContext = sResources;
      AppMethodBeat.o(86213);
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
        AppMethodBeat.o(86213);
        return localResources;
      }
    }
    catch (Throwable localThrowable)
    {
      Log.i("XWalkLib", "XWalkContextWrapper try getResourcesNotWithReflect failed, use getResourcesWithReflect");
      sResources = getResourcesWithReflect(paramContext, paramString);
      Log.i("XWalkLib", "XWalkContextWrapper checkResApkExist false");
      paramContext = sResources;
      AppMethodBeat.o(86213);
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
    AppMethodBeat.i(86214);
    try
    {
      paramContext = (AssetManager)AssetManager.class.newInstance();
      paramContext.getClass().getMethod("addAssetPath", new Class[] { String.class }).invoke(paramContext, new Object[] { paramString });
      paramString = super.getResources();
      paramContext = new Resources(paramContext, paramString.getDisplayMetrics(), paramString.getConfiguration());
      AppMethodBeat.o(86214);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      Log.e("XWalkLib", "XWalkContextWrapper getResourcesWithReflect error:" + paramContext.getMessage());
      AppMethodBeat.o(86214);
    }
    return null;
  }
  
  private ApplicationInfo initByPath(Context paramContext, String paramString)
  {
    AppMethodBeat.i(154235);
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
    AppMethodBeat.o(154235);
    return paramContext;
  }
  
  public Context getApplicationContext()
  {
    AppMethodBeat.i(86219);
    Context localContext = this.mContext.getApplicationContext();
    AppMethodBeat.o(86219);
    return localContext;
  }
  
  public AssetManager getAssets()
  {
    AppMethodBeat.i(86220);
    Object localObject = getResources();
    if (localObject != null)
    {
      localObject = ((Resources)localObject).getAssets();
      AppMethodBeat.o(86220);
      return localObject;
    }
    localObject = super.getAssets();
    AppMethodBeat.o(86220);
    return localObject;
  }
  
  public Context getBaseContext()
  {
    return this.mContext;
  }
  
  public ClassLoader getClassLoader()
  {
    AppMethodBeat.i(86228);
    if (this.mClassLoader != null)
    {
      localObject = this.mClassLoader;
      AppMethodBeat.o(86228);
      return localObject;
    }
    Object localObject = XWalkCoreWrapper.getInstance();
    if (localObject != null)
    {
      localObject = ((XWalkCoreWrapper)localObject).getBridgeLoader();
      AppMethodBeat.o(86228);
      return localObject;
    }
    localObject = super.getClassLoader();
    AppMethodBeat.o(86228);
    return localObject;
  }
  
  public LayoutInflater getLayoutInflater()
  {
    return this.mLayoutInflater;
  }
  
  public String getPackageName()
  {
    AppMethodBeat.i(86221);
    String str = this.mContext.getPackageName();
    AppMethodBeat.o(86221);
    return str;
  }
  
  public Context getPlatformContext()
  {
    return this.mContext;
  }
  
  public Resources getResources()
  {
    AppMethodBeat.i(86222);
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
      AppMethodBeat.o(86222);
      return localResources;
      label53:
      Log.e("XWalkLib", "mHasAddFilterResources = false");
    }
    Resources localResources = super.getResources();
    AppMethodBeat.o(86222);
    return localResources;
  }
  
  /* Error */
  public HashMap<Long, Integer> getResourcesKeyIdMap(Resources paramResources)
  {
    // Byte code:
    //   0: ldc_w 400
    //   3: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 402	org/xwalk/core/resource/XWalkContextWrapper:mResourcessKeyIdMap	Ljava/util/HashMap;
    //   9: ifnull +21 -> 30
    //   12: getstatic 402	org/xwalk/core/resource/XWalkContextWrapper:mResourcessKeyIdMap	Ljava/util/HashMap;
    //   15: invokevirtual 407	java/util/HashMap:clone	()Ljava/lang/Object;
    //   18: checkcast 404	java/util/HashMap
    //   21: astore_1
    //   22: ldc_w 400
    //   25: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: aload_1
    //   29: areturn
    //   30: ldc 13
    //   32: ldc_w 409
    //   35: invokestatic 287	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: new 404	java/util/HashMap
    //   41: dup
    //   42: invokespecial 411	java/util/HashMap:<init>	()V
    //   45: astore 10
    //   47: aload_0
    //   48: invokevirtual 412	org/xwalk/core/resource/XWalkContextWrapper:getClassLoader	()Ljava/lang/ClassLoader;
    //   51: ldc 10
    //   53: invokevirtual 418	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   56: invokevirtual 422	java/lang/Class:getClasses	()[Ljava/lang/Class;
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
    //   82: invokevirtual 425	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   85: ldc_w 427
    //   88: invokevirtual 225	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   91: ifeq +388 -> 479
    //   94: aload 12
    //   96: invokevirtual 431	java/lang/Class:getFields	()[Ljava/lang/reflect/Field;
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
    //   122: invokevirtual 434	java/lang/reflect/Field:getModifiers	()I
    //   125: invokestatic 440	java/lang/reflect/Modifier:isFinal	(I)Z
    //   128: ifeq +9 -> 137
    //   131: aload 13
    //   133: iconst_1
    //   134: invokevirtual 117	java/lang/reflect/Field:setAccessible	(Z)V
    //   137: iconst_0
    //   138: istore 5
    //   140: iload 5
    //   142: istore 4
    //   144: new 442	android/util/TypedValue
    //   147: dup
    //   148: invokespecial 443	android/util/TypedValue:<init>	()V
    //   151: astore 14
    //   153: iload 5
    //   155: istore 4
    //   157: aload 13
    //   159: aconst_null
    //   160: invokevirtual 447	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   163: istore 5
    //   165: iload 5
    //   167: istore 4
    //   169: aload_1
    //   170: iload 5
    //   172: aload 14
    //   174: iconst_1
    //   175: invokevirtual 451	android/content/res/Resources:getValue	(ILandroid/util/TypedValue;Z)V
    //   178: iload 5
    //   180: istore 4
    //   182: aload 14
    //   184: getfield 454	android/util/TypedValue:assetCookie	I
    //   187: i2l
    //   188: bipush 32
    //   190: lshl
    //   191: aload 14
    //   193: getfield 457	android/util/TypedValue:data	I
    //   196: i2l
    //   197: lor
    //   198: lstore 8
    //   200: iload 5
    //   202: istore 4
    //   204: aload 10
    //   206: lload 8
    //   208: invokestatic 463	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   211: iload 5
    //   213: invokestatic 468	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   216: invokevirtual 472	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   219: pop
    //   220: iload 5
    //   222: istore 4
    //   224: ldc 13
    //   226: new 177	java/lang/StringBuilder
    //   229: dup
    //   230: ldc_w 474
    //   233: invokespecial 182	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   236: aload 13
    //   238: invokevirtual 477	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   241: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: ldc_w 479
    //   247: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: iload 5
    //   252: invokevirtual 482	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   255: ldc_w 484
    //   258: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: lload 8
    //   263: invokevirtual 487	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   266: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   269: invokestatic 490	org/xwalk/core/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   272: aload 13
    //   274: invokevirtual 434	java/lang/reflect/Field:getModifiers	()I
    //   277: invokestatic 440	java/lang/reflect/Modifier:isFinal	(I)Z
    //   280: ifeq +206 -> 486
    //   283: aload 13
    //   285: iconst_0
    //   286: invokevirtual 117	java/lang/reflect/Field:setAccessible	(Z)V
    //   289: goto +197 -> 486
    //   292: astore 14
    //   294: ldc 13
    //   296: new 177	java/lang/StringBuilder
    //   299: dup
    //   300: invokespecial 491	java/lang/StringBuilder:<init>	()V
    //   303: aload 13
    //   305: invokevirtual 477	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   308: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: ldc_w 493
    //   314: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: invokestatic 496	org/xwalk/core/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   323: goto -51 -> 272
    //   326: astore_1
    //   327: ldc 13
    //   329: ldc_w 498
    //   332: invokestatic 199	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   335: aload 10
    //   337: putstatic 402	org/xwalk/core/resource/XWalkContextWrapper:mResourcessKeyIdMap	Ljava/util/HashMap;
    //   340: ldc 13
    //   342: new 177	java/lang/StringBuilder
    //   345: dup
    //   346: ldc_w 500
    //   349: invokespecial 182	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   352: getstatic 402	org/xwalk/core/resource/XWalkContextWrapper:mResourcessKeyIdMap	Ljava/util/HashMap;
    //   355: invokevirtual 504	java/util/HashMap:keySet	()Ljava/util/Set;
    //   358: invokeinterface 509 1 0
    //   363: invokevirtual 482	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   366: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   369: invokestatic 287	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   372: getstatic 402	org/xwalk/core/resource/XWalkContextWrapper:mResourcessKeyIdMap	Ljava/util/HashMap;
    //   375: invokevirtual 407	java/util/HashMap:clone	()Ljava/lang/Object;
    //   378: checkcast 404	java/util/HashMap
    //   381: astore_1
    //   382: ldc_w 400
    //   385: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   388: aload_1
    //   389: areturn
    //   390: astore 14
    //   392: ldc 13
    //   394: new 177	java/lang/StringBuilder
    //   397: dup
    //   398: invokespecial 491	java/lang/StringBuilder:<init>	()V
    //   401: aload 13
    //   403: invokevirtual 477	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   406: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: ldc_w 511
    //   412: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   418: invokestatic 496	org/xwalk/core/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   421: goto -149 -> 272
    //   424: astore_1
    //   425: ldc 13
    //   427: aload_1
    //   428: invokevirtual 336	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   431: invokestatic 199	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   434: goto -99 -> 335
    //   437: astore 14
    //   439: ldc 13
    //   441: new 177	java/lang/StringBuilder
    //   444: dup
    //   445: invokespecial 491	java/lang/StringBuilder:<init>	()V
    //   448: aload 13
    //   450: invokevirtual 477	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   453: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: ldc_w 513
    //   459: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: iload 4
    //   464: invokestatic 516	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   467: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   473: invokestatic 496	org/xwalk/core/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
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
    AppMethodBeat.i(86223);
    if (paramString.equals("layout_inflater"))
    {
      paramString = getLayoutInflater();
      AppMethodBeat.o(86223);
      return paramString;
    }
    try
    {
      paramString = this.mContext.getSystemService(paramString);
      AppMethodBeat.o(86223);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.e("XWalkLib", "getSystemService failed " + paramString.getMessage());
      AppMethodBeat.o(86223);
    }
    return null;
  }
  
  public Resources.Theme getTheme()
  {
    AppMethodBeat.i(86224);
    if (this.mTheme != null)
    {
      localTheme = this.mTheme;
      AppMethodBeat.o(86224);
      return localTheme;
    }
    Resources.Theme localTheme = super.getTheme();
    AppMethodBeat.o(86224);
    return localTheme;
  }
  
  public void setClassLoader(ClassLoader paramClassLoader)
  {
    this.mClassLoader = paramClassLoader;
  }
  
  public void setTheme(int paramInt)
  {
    AppMethodBeat.i(86225);
    if (this.mContext.getTheme() != null)
    {
      this.mContext.getTheme().applyStyle(paramInt, true);
      AppMethodBeat.o(86225);
      return;
    }
    super.setTheme(paramInt);
    AppMethodBeat.o(86225);
  }
  
  public void startActivity(Intent paramIntent)
  {
    AppMethodBeat.i(86226);
    super.startActivity(getRealIntent(paramIntent));
    AppMethodBeat.o(86226);
  }
  
  public ComponentName startService(Intent paramIntent)
  {
    AppMethodBeat.i(86227);
    paramIntent = super.startService(getRealIntent(paramIntent));
    AppMethodBeat.o(86227);
    return paramIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     org.xwalk.core.resource.XWalkContextWrapper
 * JD-Core Version:    0.7.0.1
 */