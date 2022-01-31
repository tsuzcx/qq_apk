package com.tencent.qqvideo.proxy.httpproxy;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class TVHttpProxyLoadLibrary
{
  public static final String ASSETS_LIBRARY_SRC_DIR = "libs/";
  private static Context mContext;
  private static final HashMap<String, WeakReference<ClassLoader>> mLoadedLibs;
  
  static
  {
    AppMethodBeat.i(124392);
    mLoadedLibs = new HashMap();
    mContext = null;
    AppMethodBeat.o(124392);
  }
  
  /* Error */
  private static void extractAllLibraries(Context paramContext)
  {
    // Byte code:
    //   0: ldc 47
    //   2: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnonnull +9 -> 15
    //   9: ldc 47
    //   11: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   14: return
    //   15: invokestatic 51	com/tencent/qqvideo/proxy/httpproxy/TVHttpProxyLoadLibrary:generateAbiList	()Ljava/util/List;
    //   18: astore_2
    //   19: aload_0
    //   20: ldc 53
    //   22: iconst_0
    //   23: invokevirtual 59	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   26: astore_3
    //   27: new 61	java/util/zip/ZipFile
    //   30: dup
    //   31: aload_0
    //   32: invokevirtual 65	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   35: getfield 70	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   38: invokespecial 73	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   41: astore_0
    //   42: new 75	java/util/HashSet
    //   45: dup
    //   46: invokespecial 76	java/util/HashSet:<init>	()V
    //   49: astore 4
    //   51: ldc 78
    //   53: invokestatic 84	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   56: astore 5
    //   58: aload_0
    //   59: invokevirtual 88	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   62: astore 6
    //   64: aload 6
    //   66: invokeinterface 94 1 0
    //   71: istore_1
    //   72: iload_1
    //   73: ifne +13 -> 86
    //   76: aload_0
    //   77: invokevirtual 97	java/util/zip/ZipFile:close	()V
    //   80: ldc 47
    //   82: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: return
    //   86: aload 5
    //   88: aload 6
    //   90: invokeinterface 101 1 0
    //   95: checkcast 103	java/util/zip/ZipEntry
    //   98: invokevirtual 107	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   101: invokevirtual 111	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   104: astore 7
    //   106: aload 7
    //   108: invokevirtual 116	java/util/regex/Matcher:matches	()Z
    //   111: ifeq -47 -> 64
    //   114: aload 7
    //   116: iconst_1
    //   117: invokevirtual 120	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   120: astore 7
    //   122: aload 4
    //   124: aload 7
    //   126: invokevirtual 124	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   129: ifne -65 -> 64
    //   132: aload_0
    //   133: aload 7
    //   135: aload_2
    //   136: new 126	java/io/File
    //   139: dup
    //   140: aload_3
    //   141: new 128	java/lang/StringBuilder
    //   144: dup
    //   145: ldc 130
    //   147: invokespecial 131	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   150: aload 7
    //   152: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: ldc 137
    //   157: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokespecial 143	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   166: invokestatic 147	com/tencent/qqvideo/proxy/httpproxy/TVHttpProxyLoadLibrary:extractLibrary	(Ljava/util/zip/ZipFile;Ljava/lang/String;Ljava/util/List;Ljava/io/File;)Z
    //   169: pop
    //   170: aload 4
    //   172: aload 7
    //   174: invokevirtual 150	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   177: pop
    //   178: goto -114 -> 64
    //   181: astore_2
    //   182: aload_0
    //   183: invokevirtual 97	java/util/zip/ZipFile:close	()V
    //   186: ldc 47
    //   188: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   191: aload_2
    //   192: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	paramContext	Context
    //   71	2	1	bool	boolean
    //   18	118	2	localList	List
    //   181	11	2	localObject1	Object
    //   26	115	3	localFile	File
    //   49	122	4	localHashSet	java.util.HashSet
    //   56	31	5	localPattern	java.util.regex.Pattern
    //   62	27	6	localEnumeration	java.util.Enumeration
    //   104	69	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   42	64	181	finally
    //   64	72	181	finally
    //   86	178	181	finally
  }
  
  /* Error */
  private static boolean extractLibrary(java.util.zip.ZipFile paramZipFile, String paramString, List<String> paramList, File paramFile)
  {
    // Byte code:
    //   0: ldc 151
    //   2: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_3
    //   6: invokevirtual 154	java/io/File:isFile	()Z
    //   9: ifeq +10 -> 19
    //   12: ldc 151
    //   14: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: iconst_1
    //   18: ireturn
    //   19: aload_2
    //   20: invokeinterface 160 1 0
    //   25: astore_2
    //   26: aload_2
    //   27: invokeinterface 165 1 0
    //   32: ifne +10 -> 42
    //   35: ldc 151
    //   37: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: iconst_0
    //   41: ireturn
    //   42: aload_2
    //   43: invokeinterface 168 1 0
    //   48: checkcast 170	java/lang/String
    //   51: astore 5
    //   53: aload_0
    //   54: new 128	java/lang/StringBuilder
    //   57: dup
    //   58: ldc 172
    //   60: invokespecial 131	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   63: aload 5
    //   65: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: ldc 174
    //   70: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_1
    //   74: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: ldc 137
    //   79: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokevirtual 178	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   88: astore 5
    //   90: aload 5
    //   92: ifnull -66 -> 26
    //   95: aload_0
    //   96: aload 5
    //   98: invokevirtual 182	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   101: astore_0
    //   102: new 184	java/io/FileOutputStream
    //   105: dup
    //   106: aload_3
    //   107: invokespecial 187	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   110: astore_1
    //   111: sipush 2048
    //   114: newarray byte
    //   116: astore_2
    //   117: aload_0
    //   118: aload_2
    //   119: iconst_0
    //   120: sipush 2048
    //   123: invokevirtual 193	java/io/InputStream:read	([BII)I
    //   126: istore 4
    //   128: iload 4
    //   130: iconst_m1
    //   131: if_icmpne +23 -> 154
    //   134: aload_0
    //   135: invokevirtual 194	java/io/InputStream:close	()V
    //   138: aload_1
    //   139: invokevirtual 195	java/io/FileOutputStream:close	()V
    //   142: aload_3
    //   143: invokevirtual 198	java/io/File:setReadOnly	()Z
    //   146: pop
    //   147: ldc 151
    //   149: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: iconst_1
    //   153: ireturn
    //   154: aload_1
    //   155: aload_2
    //   156: iconst_0
    //   157: iload 4
    //   159: invokevirtual 202	java/io/FileOutputStream:write	([BII)V
    //   162: goto -45 -> 117
    //   165: astore_2
    //   166: aload_0
    //   167: invokevirtual 194	java/io/InputStream:close	()V
    //   170: aload_1
    //   171: invokevirtual 195	java/io/FileOutputStream:close	()V
    //   174: ldc 151
    //   176: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   179: aload_2
    //   180: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	paramZipFile	java.util.zip.ZipFile
    //   0	181	1	paramString	String
    //   0	181	2	paramList	List<String>
    //   0	181	3	paramFile	File
    //   126	32	4	i	int
    //   51	46	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   117	128	165	finally
    //   154	162	165	finally
  }
  
  public static String find(String paramString, Context paramContext)
  {
    AppMethodBeat.i(124393);
    if (paramContext == null)
    {
      AppMethodBeat.o(124393);
      return null;
    }
    try
    {
      Object localObject1 = TVHttpProxyLoadLibrary.class.getClassLoader();
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
      AppMethodBeat.o(124393);
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
    AppMethodBeat.i(124397);
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
    AppMethodBeat.o(124397);
    return localArrayList;
  }
  
  /* Error */
  public static void load(String paramString, ClassLoader paramClassLoader, Context arg2)
  {
    // Byte code:
    //   0: ldc_w 278
    //   3: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnull +14 -> 21
    //   10: aload_0
    //   11: invokevirtual 261	java/lang/String:length	()I
    //   14: ifeq +7 -> 21
    //   17: aload_1
    //   18: ifnonnull +10 -> 28
    //   21: ldc_w 278
    //   24: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: return
    //   28: aload_2
    //   29: putstatic 33	com/tencent/qqvideo/proxy/httpproxy/TVHttpProxyLoadLibrary:mContext	Landroid/content/Context;
    //   32: getstatic 31	com/tencent/qqvideo/proxy/httpproxy/TVHttpProxyLoadLibrary:mLoadedLibs	Ljava/util/HashMap;
    //   35: astore 4
    //   37: aload 4
    //   39: monitorenter
    //   40: getstatic 31	com/tencent/qqvideo/proxy/httpproxy/TVHttpProxyLoadLibrary:mLoadedLibs	Ljava/util/HashMap;
    //   43: aload_0
    //   44: invokevirtual 281	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   47: checkcast 283	java/lang/ref/WeakReference
    //   50: astore_3
    //   51: aload_3
    //   52: ifnull +858 -> 910
    //   55: aload_3
    //   56: invokevirtual 285	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   59: checkcast 217	java/lang/ClassLoader
    //   62: astore_3
    //   63: aload_3
    //   64: ifnull +69 -> 133
    //   67: aload_3
    //   68: aload_1
    //   69: if_acmpne +13 -> 82
    //   72: aload 4
    //   74: monitorexit
    //   75: ldc_w 278
    //   78: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: return
    //   82: new 273	java/lang/UnsatisfiedLinkError
    //   85: dup
    //   86: new 128	java/lang/StringBuilder
    //   89: dup
    //   90: ldc_w 287
    //   93: invokespecial 131	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   96: aload_0
    //   97: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: ldc_w 289
    //   103: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokespecial 290	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   112: astore_0
    //   113: ldc_w 278
    //   116: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   119: aload_0
    //   120: athrow
    //   121: astore_0
    //   122: aload 4
    //   124: monitorexit
    //   125: ldc_w 278
    //   128: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   131: aload_0
    //   132: athrow
    //   133: aload 4
    //   135: monitorexit
    //   136: aload_2
    //   137: ifnonnull +121 -> 258
    //   140: aload_0
    //   141: aload_1
    //   142: invokestatic 294	com/tencent/qqvideo/proxy/httpproxy/TVHttpProxyLoadLibrary:reflectSystemLoadlibrary	(Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   145: getstatic 31	com/tencent/qqvideo/proxy/httpproxy/TVHttpProxyLoadLibrary:mLoadedLibs	Ljava/util/HashMap;
    //   148: astore_2
    //   149: aload_2
    //   150: monitorenter
    //   151: getstatic 31	com/tencent/qqvideo/proxy/httpproxy/TVHttpProxyLoadLibrary:mLoadedLibs	Ljava/util/HashMap;
    //   154: aload_0
    //   155: new 283	java/lang/ref/WeakReference
    //   158: dup
    //   159: aload_1
    //   160: invokespecial 297	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   163: invokevirtual 301	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   166: pop
    //   167: aload_2
    //   168: monitorexit
    //   169: ldc_w 278
    //   172: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   175: return
    //   176: astore_1
    //   177: new 273	java/lang/UnsatisfiedLinkError
    //   180: dup
    //   181: ldc_w 303
    //   184: aload_0
    //   185: invokestatic 307	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   188: invokevirtual 311	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   191: invokespecial 290	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   194: aload_1
    //   195: invokevirtual 315	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   198: invokevirtual 319	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   201: checkcast 273	java/lang/UnsatisfiedLinkError
    //   204: astore_0
    //   205: ldc_w 278
    //   208: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   211: aload_0
    //   212: athrow
    //   213: astore_1
    //   214: aload_2
    //   215: monitorexit
    //   216: ldc_w 278
    //   219: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   222: aload_1
    //   223: athrow
    //   224: astore_1
    //   225: new 273	java/lang/UnsatisfiedLinkError
    //   228: dup
    //   229: ldc_w 303
    //   232: aload_0
    //   233: invokestatic 307	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   236: invokevirtual 311	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   239: invokespecial 290	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   242: aload_1
    //   243: invokevirtual 319	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   246: checkcast 273	java/lang/UnsatisfiedLinkError
    //   249: astore_0
    //   250: ldc_w 278
    //   253: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   256: aload_0
    //   257: athrow
    //   258: new 126	java/io/File
    //   261: dup
    //   262: aload_2
    //   263: ldc 53
    //   265: iconst_0
    //   266: invokevirtual 59	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   269: new 128	java/lang/StringBuilder
    //   272: dup
    //   273: ldc 130
    //   275: invokespecial 131	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   278: aload_0
    //   279: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: ldc 137
    //   284: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokespecial 143	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   293: astore 5
    //   295: aload 5
    //   297: invokevirtual 154	java/io/File:isFile	()Z
    //   300: ifeq +605 -> 905
    //   303: aload 5
    //   305: invokevirtual 239	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   308: aload_1
    //   309: invokestatic 322	com/tencent/qqvideo/proxy/httpproxy/TVHttpProxyLoadLibrary:reflectSystemLoad	(Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   312: getstatic 31	com/tencent/qqvideo/proxy/httpproxy/TVHttpProxyLoadLibrary:mLoadedLibs	Ljava/util/HashMap;
    //   315: astore_3
    //   316: aload_3
    //   317: monitorenter
    //   318: getstatic 31	com/tencent/qqvideo/proxy/httpproxy/TVHttpProxyLoadLibrary:mLoadedLibs	Ljava/util/HashMap;
    //   321: aload_0
    //   322: new 283	java/lang/ref/WeakReference
    //   325: dup
    //   326: aload_1
    //   327: invokespecial 297	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   330: invokevirtual 301	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   333: pop
    //   334: aload_3
    //   335: monitorexit
    //   336: ldc_w 278
    //   339: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   342: return
    //   343: astore_3
    //   344: aload 5
    //   346: invokevirtual 325	java/io/File:delete	()Z
    //   349: pop
    //   350: aload_0
    //   351: aload_1
    //   352: invokestatic 294	com/tencent/qqvideo/proxy/httpproxy/TVHttpProxyLoadLibrary:reflectSystemLoadlibrary	(Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   355: getstatic 31	com/tencent/qqvideo/proxy/httpproxy/TVHttpProxyLoadLibrary:mLoadedLibs	Ljava/util/HashMap;
    //   358: astore 4
    //   360: aload 4
    //   362: monitorenter
    //   363: getstatic 31	com/tencent/qqvideo/proxy/httpproxy/TVHttpProxyLoadLibrary:mLoadedLibs	Ljava/util/HashMap;
    //   366: aload_0
    //   367: new 283	java/lang/ref/WeakReference
    //   370: dup
    //   371: aload_1
    //   372: invokespecial 297	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   375: invokevirtual 301	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   378: pop
    //   379: aload 4
    //   381: monitorexit
    //   382: ldc_w 278
    //   385: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   388: return
    //   389: astore 4
    //   391: aload_3
    //   392: ifnonnull +510 -> 902
    //   395: aload 4
    //   397: astore_3
    //   398: new 61	java/util/zip/ZipFile
    //   401: dup
    //   402: aload_2
    //   403: invokevirtual 65	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   406: getfield 70	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   409: invokespecial 73	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   412: astore 4
    //   414: aload 4
    //   416: astore_2
    //   417: aload 4
    //   419: aload_0
    //   420: invokestatic 51	com/tencent/qqvideo/proxy/httpproxy/TVHttpProxyLoadLibrary:generateAbiList	()Ljava/util/List;
    //   423: aload 5
    //   425: invokestatic 147	com/tencent/qqvideo/proxy/httpproxy/TVHttpProxyLoadLibrary:extractLibrary	(Ljava/util/zip/ZipFile;Ljava/lang/String;Ljava/util/List;Ljava/io/File;)Z
    //   428: ifne +310 -> 738
    //   431: aload 4
    //   433: astore_2
    //   434: new 327	java/lang/RuntimeException
    //   437: dup
    //   438: ldc_w 329
    //   441: aload_0
    //   442: invokestatic 307	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   445: invokevirtual 311	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   448: invokespecial 330	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   451: astore_0
    //   452: aload 4
    //   454: astore_2
    //   455: ldc_w 278
    //   458: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   461: aload 4
    //   463: astore_2
    //   464: aload_0
    //   465: athrow
    //   466: astore_1
    //   467: aload 4
    //   469: astore_0
    //   470: aload_0
    //   471: astore_2
    //   472: new 273	java/lang/UnsatisfiedLinkError
    //   475: dup
    //   476: ldc_w 332
    //   479: invokespecial 290	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   482: aload_1
    //   483: invokevirtual 319	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   486: checkcast 273	java/lang/UnsatisfiedLinkError
    //   489: astore_1
    //   490: aload_0
    //   491: astore_2
    //   492: ldc_w 278
    //   495: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   498: aload_0
    //   499: astore_2
    //   500: aload_1
    //   501: athrow
    //   502: astore_0
    //   503: aload_2
    //   504: ifnull +7 -> 511
    //   507: aload_2
    //   508: invokevirtual 97	java/util/zip/ZipFile:close	()V
    //   511: ldc_w 278
    //   514: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   517: aload_0
    //   518: athrow
    //   519: astore 4
    //   521: aload_3
    //   522: monitorexit
    //   523: ldc_w 278
    //   526: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   529: aload 4
    //   531: athrow
    //   532: astore_3
    //   533: aload_3
    //   534: invokevirtual 315	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   537: instanceof 273
    //   540: ifeq +14 -> 554
    //   543: aload_3
    //   544: invokevirtual 315	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   547: checkcast 273	java/lang/UnsatisfiedLinkError
    //   550: astore_3
    //   551: goto -207 -> 344
    //   554: new 273	java/lang/UnsatisfiedLinkError
    //   557: dup
    //   558: ldc_w 334
    //   561: aload_0
    //   562: invokestatic 307	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   565: invokevirtual 311	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   568: invokespecial 290	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   571: aload_3
    //   572: invokevirtual 315	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   575: invokevirtual 319	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   578: checkcast 273	java/lang/UnsatisfiedLinkError
    //   581: astore_0
    //   582: ldc_w 278
    //   585: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   588: aload_0
    //   589: athrow
    //   590: astore_1
    //   591: new 273	java/lang/UnsatisfiedLinkError
    //   594: dup
    //   595: ldc_w 334
    //   598: aload_0
    //   599: invokestatic 307	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   602: invokevirtual 311	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   605: invokespecial 290	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   608: aload_1
    //   609: invokevirtual 319	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   612: checkcast 273	java/lang/UnsatisfiedLinkError
    //   615: astore_0
    //   616: ldc_w 278
    //   619: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   622: aload_0
    //   623: athrow
    //   624: astore 6
    //   626: aload 4
    //   628: monitorexit
    //   629: ldc_w 278
    //   632: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   635: aload 6
    //   637: athrow
    //   638: astore 4
    //   640: aload 4
    //   642: invokevirtual 315	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   645: instanceof 273
    //   648: ifeq +19 -> 667
    //   651: aload_3
    //   652: ifnonnull +250 -> 902
    //   655: aload 4
    //   657: invokevirtual 315	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   660: checkcast 273	java/lang/UnsatisfiedLinkError
    //   663: astore_3
    //   664: goto -266 -> 398
    //   667: new 273	java/lang/UnsatisfiedLinkError
    //   670: dup
    //   671: ldc_w 334
    //   674: aload_0
    //   675: invokestatic 307	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   678: invokevirtual 311	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   681: invokespecial 290	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   684: aload 4
    //   686: invokevirtual 315	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   689: invokevirtual 319	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   692: checkcast 273	java/lang/UnsatisfiedLinkError
    //   695: astore_0
    //   696: ldc_w 278
    //   699: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   702: aload_0
    //   703: athrow
    //   704: astore_1
    //   705: new 273	java/lang/UnsatisfiedLinkError
    //   708: dup
    //   709: ldc_w 334
    //   712: aload_0
    //   713: invokestatic 307	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   716: invokevirtual 311	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   719: invokespecial 290	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   722: aload_1
    //   723: invokevirtual 319	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   726: checkcast 273	java/lang/UnsatisfiedLinkError
    //   729: astore_0
    //   730: ldc_w 278
    //   733: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   736: aload_0
    //   737: athrow
    //   738: aload 4
    //   740: invokevirtual 97	java/util/zip/ZipFile:close	()V
    //   743: aload 5
    //   745: invokevirtual 239	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   748: aload_1
    //   749: invokestatic 322	com/tencent/qqvideo/proxy/httpproxy/TVHttpProxyLoadLibrary:reflectSystemLoad	(Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   752: getstatic 31	com/tencent/qqvideo/proxy/httpproxy/TVHttpProxyLoadLibrary:mLoadedLibs	Ljava/util/HashMap;
    //   755: astore_2
    //   756: aload_2
    //   757: monitorenter
    //   758: getstatic 31	com/tencent/qqvideo/proxy/httpproxy/TVHttpProxyLoadLibrary:mLoadedLibs	Ljava/util/HashMap;
    //   761: aload_0
    //   762: new 283	java/lang/ref/WeakReference
    //   765: dup
    //   766: aload_1
    //   767: invokespecial 297	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   770: invokevirtual 301	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   773: pop
    //   774: aload_2
    //   775: monitorexit
    //   776: ldc_w 278
    //   779: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   782: return
    //   783: astore_1
    //   784: aload_3
    //   785: ifnonnull +81 -> 866
    //   788: new 273	java/lang/UnsatisfiedLinkError
    //   791: dup
    //   792: ldc_w 334
    //   795: aload_0
    //   796: invokestatic 307	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   799: invokevirtual 311	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   802: invokespecial 290	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   805: aload_1
    //   806: invokevirtual 315	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   809: invokevirtual 319	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   812: checkcast 273	java/lang/UnsatisfiedLinkError
    //   815: astore_0
    //   816: ldc_w 278
    //   819: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   822: aload_0
    //   823: athrow
    //   824: astore_1
    //   825: aload_2
    //   826: monitorexit
    //   827: ldc_w 278
    //   830: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   833: aload_1
    //   834: athrow
    //   835: astore_0
    //   836: aload_3
    //   837: ifnonnull +37 -> 874
    //   840: new 273	java/lang/UnsatisfiedLinkError
    //   843: dup
    //   844: ldc_w 332
    //   847: invokespecial 290	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   850: aload_0
    //   851: invokevirtual 319	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   854: checkcast 273	java/lang/UnsatisfiedLinkError
    //   857: astore_0
    //   858: ldc_w 278
    //   861: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   864: aload_0
    //   865: athrow
    //   866: ldc_w 278
    //   869: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   872: aload_3
    //   873: athrow
    //   874: ldc_w 278
    //   877: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   880: aload_3
    //   881: athrow
    //   882: astore_1
    //   883: goto -372 -> 511
    //   886: astore_2
    //   887: goto -144 -> 743
    //   890: astore_0
    //   891: aconst_null
    //   892: astore_2
    //   893: goto -390 -> 503
    //   896: astore_1
    //   897: aconst_null
    //   898: astore_0
    //   899: goto -429 -> 470
    //   902: goto -504 -> 398
    //   905: aconst_null
    //   906: astore_3
    //   907: goto -557 -> 350
    //   910: aconst_null
    //   911: astore_3
    //   912: goto -849 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	915	0	paramString	String
    //   0	915	1	paramClassLoader	ClassLoader
    //   50	285	3	localObject1	Object
    //   343	49	3	localUnsatisfiedLinkError1	java.lang.UnsatisfiedLinkError
    //   397	125	3	localUnsatisfiedLinkError2	java.lang.UnsatisfiedLinkError
    //   532	12	3	localInvocationTargetException1	java.lang.reflect.InvocationTargetException
    //   550	362	3	localUnsatisfiedLinkError3	java.lang.UnsatisfiedLinkError
    //   35	345	4	localHashMap	HashMap
    //   389	7	4	localUnsatisfiedLinkError4	java.lang.UnsatisfiedLinkError
    //   412	56	4	localZipFile	java.util.zip.ZipFile
    //   519	108	4	localObject2	Object
    //   638	101	4	localInvocationTargetException2	java.lang.reflect.InvocationTargetException
    //   293	451	5	localFile	File
    //   624	12	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   40	51	121	finally
    //   55	63	121	finally
    //   72	75	121	finally
    //   82	121	121	finally
    //   122	125	121	finally
    //   133	136	121	finally
    //   140	151	176	java/lang/reflect/InvocationTargetException
    //   169	175	176	java/lang/reflect/InvocationTargetException
    //   216	224	176	java/lang/reflect/InvocationTargetException
    //   151	169	213	finally
    //   214	216	213	finally
    //   140	151	224	java/lang/Exception
    //   169	175	224	java/lang/Exception
    //   216	224	224	java/lang/Exception
    //   303	318	343	java/lang/UnsatisfiedLinkError
    //   336	342	343	java/lang/UnsatisfiedLinkError
    //   523	532	343	java/lang/UnsatisfiedLinkError
    //   350	363	389	java/lang/UnsatisfiedLinkError
    //   382	388	389	java/lang/UnsatisfiedLinkError
    //   629	638	389	java/lang/UnsatisfiedLinkError
    //   417	431	466	java/lang/Exception
    //   434	452	466	java/lang/Exception
    //   455	461	466	java/lang/Exception
    //   464	466	466	java/lang/Exception
    //   417	431	502	finally
    //   434	452	502	finally
    //   455	461	502	finally
    //   464	466	502	finally
    //   472	490	502	finally
    //   492	498	502	finally
    //   500	502	502	finally
    //   318	336	519	finally
    //   521	523	519	finally
    //   303	318	532	java/lang/reflect/InvocationTargetException
    //   336	342	532	java/lang/reflect/InvocationTargetException
    //   523	532	532	java/lang/reflect/InvocationTargetException
    //   303	318	590	java/lang/Throwable
    //   336	342	590	java/lang/Throwable
    //   523	532	590	java/lang/Throwable
    //   363	382	624	finally
    //   626	629	624	finally
    //   350	363	638	java/lang/reflect/InvocationTargetException
    //   382	388	638	java/lang/reflect/InvocationTargetException
    //   629	638	638	java/lang/reflect/InvocationTargetException
    //   350	363	704	java/lang/Throwable
    //   382	388	704	java/lang/Throwable
    //   629	638	704	java/lang/Throwable
    //   743	758	783	java/lang/reflect/InvocationTargetException
    //   776	782	783	java/lang/reflect/InvocationTargetException
    //   827	835	783	java/lang/reflect/InvocationTargetException
    //   758	776	824	finally
    //   825	827	824	finally
    //   743	758	835	java/lang/Exception
    //   776	782	835	java/lang/Exception
    //   827	835	835	java/lang/Exception
    //   507	511	882	java/io/IOException
    //   738	743	886	java/io/IOException
    //   398	414	890	finally
    //   398	414	896	java/lang/Exception
  }
  
  private static void reflectSystemLoad(String paramString, ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(124395);
    Runtime localRuntime = Runtime.getRuntime();
    Method localMethod = localRuntime.getClass().getDeclaredMethod("load", new Class[] { String.class, ClassLoader.class });
    localMethod.setAccessible(true);
    localMethod.invoke(localRuntime, new Object[] { paramString, paramClassLoader });
    AppMethodBeat.o(124395);
  }
  
  private static void reflectSystemLoadlibrary(String paramString, ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(124396);
    Runtime localRuntime = Runtime.getRuntime();
    Method localMethod = localRuntime.getClass().getDeclaredMethod("loadLibrary", new Class[] { String.class, ClassLoader.class });
    localMethod.setAccessible(true);
    localMethod.invoke(localRuntime, new Object[] { paramString, paramClassLoader });
    AppMethodBeat.o(124396);
  }
  
  public static void setupBrokenLibraryHandler()
  {
    AppMethodBeat.i(124400);
    Thread.setDefaultUncaughtExceptionHandler(new TVHttpProxyLoadLibrary.LibraryBrokenHandler(Thread.getDefaultUncaughtExceptionHandler()));
    AppMethodBeat.o(124400);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.qqvideo.proxy.httpproxy.TVHttpProxyLoadLibrary
 * JD-Core Version:    0.7.0.1
 */