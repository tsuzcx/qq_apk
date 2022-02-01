package com.tencent.thumbplayer.core.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class TPLoadLibFromApk
{
  private static Context mContext;
  private static final HashMap<String, WeakReference<ClassLoader>> mLoadedLibs;
  
  static
  {
    AppMethodBeat.i(189768);
    mLoadedLibs = new HashMap();
    mContext = null;
    AppMethodBeat.o(189768);
  }
  
  private static void extractAllLibraries(Context paramContext)
  {
    AppMethodBeat.i(189765);
    if (paramContext == null)
    {
      AppMethodBeat.o(189765);
      return;
    }
    Object localObject1 = generateAbiList();
    File localFile = paramContext.getDir("recover_lib", 0);
    paramContext = new ZipFile(paramContext.getApplicationInfo().sourceDir);
    for (;;)
    {
      HashSet localHashSet;
      Pattern localPattern;
      try
      {
        localHashSet = new HashSet();
        localPattern = Pattern.compile("lib/[A-Za-z0-9-_=]+/lib([A-Za-z0-9-_=]+)\\.so");
        Enumeration localEnumeration = paramContext.entries();
        if (!localEnumeration.hasMoreElements()) {
          break;
        }
        localObject2 = (ZipEntry)localEnumeration.nextElement();
        String str = ((ZipEntry)localObject2).getName();
        if ((!TextUtils.isEmpty(str)) && (str.contains("../")))
        {
          localObject1 = new Exception("contain ../, throw err");
          AppMethodBeat.o(189765);
          throw ((Throwable)localObject1);
        }
      }
      finally
      {
        paramContext.close();
        AppMethodBeat.o(189765);
      }
      Object localObject2 = localPattern.matcher(((ZipEntry)localObject2).getName());
      if (((Matcher)localObject2).matches())
      {
        localObject2 = ((Matcher)localObject2).group(1);
        if (!localHashSet.contains(localObject2))
        {
          extractLibrary(paramContext, (String)localObject2, localList, new File(localFile, "lib" + (String)localObject2 + ".so"));
          localHashSet.add(localObject2);
        }
      }
    }
    paramContext.close();
    AppMethodBeat.o(189765);
  }
  
  private static boolean extractLibrary(ZipFile paramZipFile, String paramString, List<String> paramList, File paramFile)
  {
    AppMethodBeat.i(189764);
    if (paramFile.isFile())
    {
      AppMethodBeat.o(189764);
      return true;
    }
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      paramList = (String)paramList.next();
      paramString = paramZipFile.getEntry("lib/" + paramList + "/lib" + paramString + ".so");
      if (paramString == null)
      {
        AppMethodBeat.o(189764);
        return false;
      }
      paramList = paramString.getName();
      if ((!TextUtils.isEmpty(paramList)) && (paramList.contains("../")))
      {
        AppMethodBeat.o(189764);
        return false;
      }
      paramZipFile = paramZipFile.getInputStream(paramString);
      paramString = new FileOutputStream(paramFile);
      paramList = new byte[2048];
      try
      {
        for (;;)
        {
          int i = paramZipFile.read(paramList, 0, 2048);
          if (i == -1) {
            break;
          }
          paramString.write(paramList, 0, i);
        }
        paramZipFile.close();
      }
      finally
      {
        paramZipFile.close();
        paramString.close();
        AppMethodBeat.o(189764);
      }
      paramString.close();
      try
      {
        paramFile.setReadOnly();
        AppMethodBeat.o(189764);
        return true;
      }
      catch (Throwable paramZipFile)
      {
        AppMethodBeat.o(189764);
        return false;
      }
    }
    AppMethodBeat.o(189764);
    return false;
  }
  
  public static String find(String paramString, Context paramContext)
  {
    AppMethodBeat.i(189760);
    if (paramContext == null)
    {
      AppMethodBeat.o(189760);
      return null;
    }
    try
    {
      Object localObject1 = TPLoadLibFromApk.class.getClassLoader();
      Object localObject3 = ClassLoader.class.getDeclaredMethod("findLibrary", new Class[] { String.class });
      ((Method)localObject3).setAccessible(true);
      localObject1 = (String)((Method)localObject3).invoke(localObject1, new Object[] { paramString });
      localObject3 = localObject1;
      if (localObject1 == null)
      {
        paramString = new File(paramContext.getDir("recover_lib", 0), "lib" + paramString + ".so");
        localObject3 = localObject1;
        if (paramString.canRead()) {
          localObject3 = paramString.getAbsolutePath();
        }
      }
      AppMethodBeat.o(189760);
      return localObject3;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = null;
      }
    }
  }
  
  private static List<String> generateAbiList()
  {
    AppMethodBeat.i(189763);
    ArrayList localArrayList = new ArrayList(3);
    Object localObject = Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class });
    String str = (String)((Method)localObject).invoke(null, new Object[] { "ro.product.cpu.abi" });
    if ((str != null) && (str.length() > 0)) {
      localArrayList.add(str);
    }
    localObject = (String)((Method)localObject).invoke(null, new Object[] { "ro.product.cpu.abi2" });
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      localArrayList.add(localObject);
    }
    localArrayList.add("armeabi");
    AppMethodBeat.o(189763);
    return localArrayList;
  }
  
  public static boolean load(String paramString, ClassLoader paramClassLoader, Context arg2)
  {
    AppMethodBeat.i(189757);
    if ((paramString == null) || (paramString.length() == 0) || (paramClassLoader == null))
    {
      AppMethodBeat.o(189757);
      return false;
    }
    mContext = ???;
    for (;;)
    {
      synchronized (mLoadedLibs)
      {
        localObject1 = (WeakReference)mLoadedLibs.get(paramString);
        if (localObject1 == null) {
          break label392;
        }
        localObject1 = (ClassLoader)((WeakReference)localObject1).get();
        if (localObject1 != null)
        {
          if (localObject1 == paramClassLoader)
          {
            TPNativeLog.printLog(2, "callerClassLoader has already load ! name=".concat(String.valueOf(paramString)));
            AppMethodBeat.o(189757);
            return true;
          }
          paramString = new UnsatisfiedLinkError("Library '" + paramString + "' was loaded by a different ClassLoader.");
          AppMethodBeat.o(189757);
          throw paramString;
        }
      }
      if (??? == null) {
        try
        {
          TPNativeLog.printLog(2, "context is null,load by System.loadLibrary,name= ".concat(String.valueOf(paramString)));
          reflectSystemLoadLibrary(paramString, paramClassLoader);
          synchronized (mLoadedLibs)
          {
            mLoadedLibs.put(paramString, new WeakReference(paramClassLoader));
            AppMethodBeat.o(189757);
            return true;
          }
          localObject1 = new File(???.getDir("recover_lib", 0), "lib" + paramString + ".so");
        }
        catch (InvocationTargetException paramClassLoader)
        {
          paramString = (UnsatisfiedLinkError)new UnsatisfiedLinkError("Failed loading library: ".concat(String.valueOf(paramString))).initCause(paramClassLoader.getCause());
          AppMethodBeat.o(189757);
          throw paramString;
        }
        catch (Exception paramClassLoader)
        {
          paramString = (UnsatisfiedLinkError)new UnsatisfiedLinkError("Failed loading library: ".concat(String.valueOf(paramString))).initCause(paramClassLoader);
          AppMethodBeat.o(189757);
          throw paramString;
        }
      }
      try
      {
        ??? = loadFromRecovery(paramString, paramClassLoader, ???, (File)localObject1);
        if (??? == null)
        {
          AppMethodBeat.o(189757);
          return true;
        }
      }
      catch (Throwable paramString)
      {
        AppMethodBeat.o(189757);
        throw paramString;
      }
      try
      {
        boolean bool = loadFromApk(paramString, paramClassLoader, ???, (File)localObject1, (UnsatisfiedLinkError)???);
        AppMethodBeat.o(189757);
        return bool;
      }
      catch (Throwable paramString)
      {
        AppMethodBeat.o(189757);
        throw paramString;
      }
      label392:
      Object localObject1 = null;
    }
  }
  
  /* Error */
  private static boolean loadFromApk(String paramString, ClassLoader paramClassLoader, Context arg2, File paramFile, UnsatisfiedLinkError paramUnsatisfiedLinkError)
  {
    // Byte code:
    //   0: ldc_w 349
    //   3: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_2
    //   7: invokevirtual 62	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   10: getfield 68	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   13: astore 6
    //   15: new 58	java/util/zip/ZipFile
    //   18: dup
    //   19: aload 6
    //   21: invokespecial 71	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   24: astore 5
    //   26: aload 5
    //   28: astore_2
    //   29: iconst_2
    //   30: new 143	java/lang/StringBuilder
    //   33: dup
    //   34: ldc_w 351
    //   37: invokespecial 146	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   40: aload_0
    //   41: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: ldc_w 353
    //   47: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload 6
    //   52: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokestatic 308	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   61: aload 5
    //   63: astore_2
    //   64: aload 5
    //   66: aload_0
    //   67: invokestatic 48	com/tencent/thumbplayer/core/common/TPLoadLibFromApk:generateAbiList	()Ljava/util/List;
    //   70: aload_3
    //   71: invokestatic 162	com/tencent/thumbplayer/core/common/TPLoadLibFromApk:extractLibrary	(Ljava/util/zip/ZipFile;Ljava/lang/String;Ljava/util/List;Ljava/io/File;)Z
    //   74: ifne +91 -> 165
    //   77: aload 5
    //   79: astore_2
    //   80: new 355	java/lang/RuntimeException
    //   83: dup
    //   84: ldc_w 357
    //   87: aload_0
    //   88: invokestatic 298	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   91: invokevirtual 302	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   94: invokespecial 358	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   97: astore_0
    //   98: aload 5
    //   100: astore_2
    //   101: ldc_w 349
    //   104: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload 5
    //   109: astore_2
    //   110: aload_0
    //   111: athrow
    //   112: astore_1
    //   113: aload 5
    //   115: astore_0
    //   116: aload_0
    //   117: astore_2
    //   118: new 310	java/lang/UnsatisfiedLinkError
    //   121: dup
    //   122: ldc_w 360
    //   125: invokespecial 315	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   128: aload_1
    //   129: invokevirtual 338	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   132: checkcast 310	java/lang/UnsatisfiedLinkError
    //   135: astore_1
    //   136: aload_0
    //   137: astore_2
    //   138: ldc_w 349
    //   141: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   144: aload_0
    //   145: astore_2
    //   146: aload_1
    //   147: athrow
    //   148: astore_0
    //   149: aload_2
    //   150: ifnull +7 -> 157
    //   153: aload_2
    //   154: invokevirtual 123	java/util/zip/ZipFile:close	()V
    //   157: ldc_w 349
    //   160: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   163: aload_0
    //   164: athrow
    //   165: aload 5
    //   167: invokevirtual 123	java/util/zip/ZipFile:close	()V
    //   170: iconst_2
    //   171: ldc_w 362
    //   174: aload_0
    //   175: invokestatic 298	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   178: invokevirtual 302	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   181: invokestatic 308	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   184: aload_3
    //   185: invokevirtual 252	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   188: aload_1
    //   189: invokestatic 365	com/tencent/thumbplayer/core/common/TPLoadLibFromApk:reflectSystemLoad	(Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   192: getstatic 28	com/tencent/thumbplayer/core/common/TPLoadLibFromApk:mLoadedLibs	Ljava/util/HashMap;
    //   195: astore_2
    //   196: aload_2
    //   197: monitorenter
    //   198: getstatic 28	com/tencent/thumbplayer/core/common/TPLoadLibFromApk:mLoadedLibs	Ljava/util/HashMap;
    //   201: aload_0
    //   202: new 290	java/lang/ref/WeakReference
    //   205: dup
    //   206: aload_1
    //   207: invokespecial 324	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   210: invokevirtual 328	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   213: pop
    //   214: aload_2
    //   215: monitorexit
    //   216: ldc_w 349
    //   219: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   222: iconst_1
    //   223: ireturn
    //   224: astore_0
    //   225: ldc_w 349
    //   228: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   231: iconst_0
    //   232: ireturn
    //   233: astore_0
    //   234: ldc_w 349
    //   237: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   240: iconst_0
    //   241: ireturn
    //   242: astore_1
    //   243: aload_2
    //   244: monitorexit
    //   245: ldc_w 349
    //   248: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   251: aload_1
    //   252: athrow
    //   253: astore_1
    //   254: aload 4
    //   256: ifnonnull +39 -> 295
    //   259: new 310	java/lang/UnsatisfiedLinkError
    //   262: dup
    //   263: ldc_w 367
    //   266: aload_0
    //   267: invokestatic 298	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   270: invokevirtual 302	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   273: invokespecial 315	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   276: aload_1
    //   277: invokevirtual 334	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   280: invokevirtual 338	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   283: checkcast 310	java/lang/UnsatisfiedLinkError
    //   286: astore_0
    //   287: ldc_w 349
    //   290: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   293: aload_0
    //   294: athrow
    //   295: ldc_w 349
    //   298: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   301: aload 4
    //   303: athrow
    //   304: astore_0
    //   305: aload 4
    //   307: ifnonnull +29 -> 336
    //   310: new 310	java/lang/UnsatisfiedLinkError
    //   313: dup
    //   314: ldc_w 360
    //   317: invokespecial 315	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   320: aload_0
    //   321: invokevirtual 338	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   324: checkcast 310	java/lang/UnsatisfiedLinkError
    //   327: astore_0
    //   328: ldc_w 349
    //   331: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   334: aload_0
    //   335: athrow
    //   336: ldc_w 349
    //   339: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   342: aload 4
    //   344: athrow
    //   345: astore_0
    //   346: aconst_null
    //   347: astore_2
    //   348: goto -199 -> 149
    //   351: astore_1
    //   352: aconst_null
    //   353: astore_0
    //   354: goto -238 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	357	0	paramString	String
    //   0	357	1	paramClassLoader	ClassLoader
    //   0	357	3	paramFile	File
    //   0	357	4	paramUnsatisfiedLinkError	UnsatisfiedLinkError
    //   24	142	5	localZipFile	ZipFile
    //   13	38	6	str	String
    // Exception table:
    //   from	to	target	type
    //   29	61	112	java/lang/Exception
    //   64	77	112	java/lang/Exception
    //   80	98	112	java/lang/Exception
    //   101	107	112	java/lang/Exception
    //   110	112	112	java/lang/Exception
    //   29	61	148	finally
    //   64	77	148	finally
    //   80	98	148	finally
    //   101	107	148	finally
    //   110	112	148	finally
    //   118	136	148	finally
    //   138	144	148	finally
    //   146	148	148	finally
    //   165	170	224	java/io/IOException
    //   153	157	233	java/io/IOException
    //   198	216	242	finally
    //   243	245	242	finally
    //   170	198	253	java/lang/reflect/InvocationTargetException
    //   245	253	253	java/lang/reflect/InvocationTargetException
    //   170	198	304	java/lang/Exception
    //   245	253	304	java/lang/Exception
    //   6	26	345	finally
    //   6	26	351	java/lang/Exception
  }
  
  /* Error */
  private static UnsatisfiedLinkError loadFromRecovery(String paramString, ClassLoader paramClassLoader, Context arg2, File arg3)
  {
    // Byte code:
    //   0: ldc_w 368
    //   3: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_3
    //   7: invokevirtual 171	java/io/File:isFile	()Z
    //   10: ifeq +380 -> 390
    //   13: iconst_2
    //   14: new 143	java/lang/StringBuilder
    //   17: dup
    //   18: ldc_w 370
    //   21: invokespecial 146	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   24: aload_0
    //   25: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc_w 372
    //   31: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_3
    //   35: invokevirtual 375	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 308	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   44: aload_3
    //   45: invokevirtual 252	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   48: aload_1
    //   49: invokestatic 365	com/tencent/thumbplayer/core/common/TPLoadLibFromApk:reflectSystemLoad	(Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   52: getstatic 28	com/tencent/thumbplayer/core/common/TPLoadLibFromApk:mLoadedLibs	Ljava/util/HashMap;
    //   55: astore_2
    //   56: aload_2
    //   57: monitorenter
    //   58: getstatic 28	com/tencent/thumbplayer/core/common/TPLoadLibFromApk:mLoadedLibs	Ljava/util/HashMap;
    //   61: aload_0
    //   62: new 290	java/lang/ref/WeakReference
    //   65: dup
    //   66: aload_1
    //   67: invokespecial 324	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   70: invokevirtual 328	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   73: pop
    //   74: aload_2
    //   75: monitorexit
    //   76: ldc_w 368
    //   79: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   82: aconst_null
    //   83: areturn
    //   84: astore 4
    //   86: aload_2
    //   87: monitorexit
    //   88: ldc_w 368
    //   91: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: aload 4
    //   96: athrow
    //   97: astore_2
    //   98: iconst_2
    //   99: ldc_w 377
    //   102: aload_0
    //   103: invokestatic 298	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   106: invokevirtual 302	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   109: invokestatic 308	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   112: aload_3
    //   113: invokevirtual 380	java/io/File:delete	()Z
    //   116: pop
    //   117: aload_0
    //   118: aload_1
    //   119: invokestatic 321	com/tencent/thumbplayer/core/common/TPLoadLibFromApk:reflectSystemLoadLibrary	(Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   122: iconst_2
    //   123: ldc_w 382
    //   126: aload_0
    //   127: invokestatic 298	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   130: invokevirtual 302	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   133: invokestatic 308	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   136: getstatic 28	com/tencent/thumbplayer/core/common/TPLoadLibFromApk:mLoadedLibs	Ljava/util/HashMap;
    //   139: astore_3
    //   140: aload_3
    //   141: monitorenter
    //   142: getstatic 28	com/tencent/thumbplayer/core/common/TPLoadLibFromApk:mLoadedLibs	Ljava/util/HashMap;
    //   145: aload_0
    //   146: new 290	java/lang/ref/WeakReference
    //   149: dup
    //   150: aload_1
    //   151: invokespecial 324	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   154: invokevirtual 328	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   157: pop
    //   158: aload_3
    //   159: monitorexit
    //   160: ldc_w 368
    //   163: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   166: aconst_null
    //   167: areturn
    //   168: astore_2
    //   169: aload_2
    //   170: invokevirtual 334	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   173: instanceof 310
    //   176: ifeq +14 -> 190
    //   179: aload_2
    //   180: invokevirtual 334	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   183: checkcast 310	java/lang/UnsatisfiedLinkError
    //   186: astore_2
    //   187: goto -89 -> 98
    //   190: new 310	java/lang/UnsatisfiedLinkError
    //   193: dup
    //   194: ldc_w 367
    //   197: aload_0
    //   198: invokestatic 298	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   201: invokevirtual 302	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   204: invokespecial 315	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   207: aload_2
    //   208: invokevirtual 334	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   211: invokevirtual 338	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   214: checkcast 310	java/lang/UnsatisfiedLinkError
    //   217: astore_0
    //   218: ldc_w 368
    //   221: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   224: aload_0
    //   225: athrow
    //   226: astore_1
    //   227: new 310	java/lang/UnsatisfiedLinkError
    //   230: dup
    //   231: ldc_w 367
    //   234: aload_0
    //   235: invokestatic 298	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   238: invokevirtual 302	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   241: invokespecial 315	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   244: aload_1
    //   245: invokevirtual 338	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   248: checkcast 310	java/lang/UnsatisfiedLinkError
    //   251: astore_0
    //   252: ldc_w 368
    //   255: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   258: aload_0
    //   259: athrow
    //   260: astore_1
    //   261: aload_3
    //   262: monitorexit
    //   263: ldc_w 368
    //   266: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   269: aload_1
    //   270: athrow
    //   271: astore_0
    //   272: aload_2
    //   273: ifnonnull +112 -> 385
    //   276: ldc_w 368
    //   279: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   282: aload_0
    //   283: areturn
    //   284: astore_1
    //   285: aload_1
    //   286: invokevirtual 334	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   289: instanceof 310
    //   292: ifeq +18 -> 310
    //   295: aload_2
    //   296: ifnonnull +50 -> 346
    //   299: aload_1
    //   300: invokevirtual 334	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   303: checkcast 310	java/lang/UnsatisfiedLinkError
    //   306: astore_0
    //   307: goto -31 -> 276
    //   310: new 310	java/lang/UnsatisfiedLinkError
    //   313: dup
    //   314: ldc_w 367
    //   317: aload_0
    //   318: invokestatic 298	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   321: invokevirtual 302	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   324: invokespecial 315	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   327: aload_1
    //   328: invokevirtual 334	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   331: invokevirtual 338	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   334: checkcast 310	java/lang/UnsatisfiedLinkError
    //   337: astore_0
    //   338: ldc_w 368
    //   341: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   344: aload_0
    //   345: athrow
    //   346: aload_2
    //   347: astore_0
    //   348: goto -72 -> 276
    //   351: astore_1
    //   352: new 310	java/lang/UnsatisfiedLinkError
    //   355: dup
    //   356: ldc_w 367
    //   359: aload_0
    //   360: invokestatic 298	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   363: invokevirtual 302	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   366: invokespecial 315	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   369: aload_1
    //   370: invokevirtual 338	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   373: checkcast 310	java/lang/UnsatisfiedLinkError
    //   376: astore_0
    //   377: ldc_w 368
    //   380: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   383: aload_0
    //   384: athrow
    //   385: aload_2
    //   386: astore_0
    //   387: goto -111 -> 276
    //   390: aconst_null
    //   391: astore_2
    //   392: goto -275 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	395	0	paramString	String
    //   0	395	1	paramClassLoader	ClassLoader
    //   84	11	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   58	76	84	finally
    //   86	88	84	finally
    //   13	58	97	java/lang/UnsatisfiedLinkError
    //   88	97	97	java/lang/UnsatisfiedLinkError
    //   13	58	168	java/lang/reflect/InvocationTargetException
    //   88	97	168	java/lang/reflect/InvocationTargetException
    //   13	58	226	java/lang/Throwable
    //   88	97	226	java/lang/Throwable
    //   142	160	260	finally
    //   261	263	260	finally
    //   117	142	271	java/lang/UnsatisfiedLinkError
    //   263	271	271	java/lang/UnsatisfiedLinkError
    //   117	142	284	java/lang/reflect/InvocationTargetException
    //   263	271	284	java/lang/reflect/InvocationTargetException
    //   117	142	351	java/lang/Throwable
    //   263	271	351	java/lang/Throwable
  }
  
  private static void reflectSystemLoad(String paramString, ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(189761);
    Runtime localRuntime = Runtime.getRuntime();
    Method localMethod = localRuntime.getClass().getDeclaredMethod("load", new Class[] { String.class, ClassLoader.class });
    localMethod.setAccessible(true);
    localMethod.invoke(localRuntime, new Object[] { paramString, paramClassLoader });
    AppMethodBeat.o(189761);
  }
  
  private static void reflectSystemLoadLibrary(String paramString, ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(189762);
    Runtime localRuntime = Runtime.getRuntime();
    Method localMethod = localRuntime.getClass().getDeclaredMethod("loadLibrary", new Class[] { String.class, ClassLoader.class });
    localMethod.setAccessible(true);
    localMethod.invoke(localRuntime, new Object[] { paramString, paramClassLoader });
    AppMethodBeat.o(189762);
  }
  
  public static void setupBrokenLibraryHandler()
  {
    AppMethodBeat.i(189766);
    Thread.setDefaultUncaughtExceptionHandler(new LibraryBrokenHandler(Thread.getDefaultUncaughtExceptionHandler()));
    AppMethodBeat.o(189766);
  }
  
  static class LibraryBrokenHandler
    implements Thread.UncaughtExceptionHandler
  {
    private Thread.UncaughtExceptionHandler mParent;
    
    LibraryBrokenHandler(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler)
    {
      this.mParent = paramUncaughtExceptionHandler;
    }
    
    public void uncaughtException(Thread paramThread, Throwable paramThrowable)
    {
      int j = 1;
      AppMethodBeat.i(189756);
      int i;
      if (((paramThrowable instanceof UnsatisfiedLinkError)) || (((paramThrowable instanceof NoSuchMethodError)) && (paramThrowable.getMessage().matches(".*sig(nature)?[=:].*"))))
      {
        i = 1;
        if (i == 0) {
          break label101;
        }
      }
      for (;;)
      {
        try
        {
          TPLoadLibFromApk.access$100(TPLoadLibFromApk.mContext);
          i = j;
        }
        catch (Exception localException)
        {
          Throwable localThrowable;
          i = 0;
          continue;
        }
        localThrowable = paramThrowable;
        if (i != 0) {
          localThrowable = new UnsatisfiedLinkError("Invalid so detected and recovered.").initCause(paramThrowable);
        }
        this.mParent.uncaughtException(paramThread, localThrowable);
        AppMethodBeat.o(189756);
        return;
        i = 0;
        break;
        label101:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPLoadLibFromApk
 * JD-Core Version:    0.7.0.1
 */