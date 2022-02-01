package com.tencent.xweb;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.l;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkFileUtil;

public class XWebCoreContentProvider
  extends ContentProvider
{
  public static final String[] aifP;
  private static AtomicBoolean aifQ;
  private static AtomicLong aifR;
  
  static
  {
    AppMethodBeat.i(212393);
    aifP = new String[] { "com.tencent.mm" };
    aifQ = new AtomicBoolean(false);
    aifR = new AtomicLong(0L);
    AppMethodBeat.o(212393);
  }
  
  private static void a(Context paramContext, c paramc)
  {
    AppMethodBeat.i(156928);
    String str1;
    Object localObject;
    if (paramc.aifT.length() > 100)
    {
      str1 = paramc.aifT.substring(0, 99);
      if (paramc.aifU.aifV.length() <= 100) {
        break label223;
      }
      localObject = paramc.aifU.aifV.substring(0, 99);
      label57:
      if (paramc.aifU.aifW.length() <= 100) {
        break label234;
      }
    }
    label223:
    label234:
    for (String str2 = paramc.aifU.aifW.substring(0, 99);; str2 = paramc.aifU.aifW)
    {
      str1 = paramc.errCode + "," + str1 + "," + paramc.aifU.opType + "," + (String)localObject + "," + paramc.aifU.tQy + "," + str2;
      if ((paramContext == null) || ("com.tencent.mm".equals(paramc.aifT))) {
        break label300;
      }
      Log.d("XWebCoreContentProvider", "doReport need post to mm ".concat(String.valueOf(str1)));
      paramContext = paramContext.getContentResolver();
      if (paramContext != null) {
        break label246;
      }
      Log.e("XWebCoreContentProvider", "doReport content resolver is null");
      AppMethodBeat.o(156928);
      return;
      str1 = paramc.aifT;
      break;
      localObject = paramc.aifU.aifV;
      break label57;
    }
    try
    {
      label246:
      localObject = new ContentValues();
      ((ContentValues)localObject).put("15625", str1);
      paramContext.insert(c("com.tencent.mm", paramc.aifT, 3, 0, ""), (ContentValues)localObject);
      AppMethodBeat.o(156928);
      return;
    }
    finally
    {
      Log.d("XWebCoreContentProvider", "doReport error post to mm");
      AppMethodBeat.o(156928);
      return;
    }
    label300:
    if (l.gBh())
    {
      Log.d("XWebCoreContentProvider", "doReport ".concat(String.valueOf(str1)));
      l.ev(15625, str1);
      AppMethodBeat.o(156928);
      return;
    }
    Log.d("XWebCoreContentProvider", "doReport reporter not init, cache ".concat(String.valueOf(str1)));
    paramContext = new b();
    paramContext.key = 15625;
    paramContext.value = str1;
    a.a(paramContext);
    AppMethodBeat.o(156928);
  }
  
  /* Error */
  private static Map<String, String> ag(File paramFile)
  {
    // Byte code:
    //   0: ldc 188
    //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 190	java/util/HashMap
    //   8: dup
    //   9: invokespecial 191	java/util/HashMap:<init>	()V
    //   12: astore_2
    //   13: new 193	java/io/BufferedReader
    //   16: dup
    //   17: new 195	java/io/FileReader
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 198	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   25: invokespecial 201	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   28: astore_0
    //   29: aload_0
    //   30: invokevirtual 204	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   33: astore_1
    //   34: aload_1
    //   35: ifnull +118 -> 153
    //   38: aload_1
    //   39: invokevirtual 207	java/lang/String:isEmpty	()Z
    //   42: ifne -13 -> 29
    //   45: aload_1
    //   46: ldc 209
    //   48: invokevirtual 213	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   51: astore_1
    //   52: aload_1
    //   53: arraylength
    //   54: iconst_2
    //   55: if_icmpne -26 -> 29
    //   58: aload_1
    //   59: iconst_0
    //   60: aaload
    //   61: ifnull -32 -> 29
    //   64: aload_1
    //   65: iconst_0
    //   66: aaload
    //   67: invokevirtual 207	java/lang/String:isEmpty	()Z
    //   70: ifne -41 -> 29
    //   73: aload_1
    //   74: iconst_1
    //   75: aaload
    //   76: ifnull -47 -> 29
    //   79: aload_1
    //   80: iconst_1
    //   81: aaload
    //   82: invokevirtual 207	java/lang/String:isEmpty	()Z
    //   85: ifne -56 -> 29
    //   88: aload_2
    //   89: aload_1
    //   90: iconst_0
    //   91: aaload
    //   92: aload_1
    //   93: iconst_1
    //   94: aaload
    //   95: invokeinterface 218 3 0
    //   100: pop
    //   101: ldc 114
    //   103: new 84	java/lang/StringBuilder
    //   106: dup
    //   107: ldc 220
    //   109: invokespecial 223	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   112: aload_1
    //   113: iconst_0
    //   114: aaload
    //   115: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokestatic 129	org/xwalk/core/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   124: goto -95 -> 29
    //   127: astore_1
    //   128: ldc 114
    //   130: ldc 225
    //   132: aload_1
    //   133: invokestatic 120	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   136: invokevirtual 124	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   139: invokestatic 140	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   142: aload_0
    //   143: invokestatic 230	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   146: ldc 188
    //   148: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   151: aload_2
    //   152: areturn
    //   153: aload_0
    //   154: invokestatic 230	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   157: goto -11 -> 146
    //   160: astore_1
    //   161: aload_0
    //   162: invokestatic 230	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   165: ldc 188
    //   167: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   170: aload_1
    //   171: athrow
    //   172: astore_1
    //   173: aconst_null
    //   174: astore_0
    //   175: goto -47 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	paramFile	File
    //   33	80	1	localObject1	Object
    //   127	6	1	localObject2	Object
    //   160	11	1	localObject3	Object
    //   172	1	1	localObject4	Object
    //   12	140	2	localHashMap	java.util.HashMap
    // Exception table:
    //   from	to	target	type
    //   29	34	127	finally
    //   38	58	127	finally
    //   64	73	127	finally
    //   79	124	127	finally
    //   128	142	160	finally
    //   13	29	172	finally
  }
  
  private static boolean bHL(String paramString)
  {
    AppMethodBeat.i(212372);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      Log.e("XWebCoreContentProvider", "isProvider, packageName is null or empty");
      AppMethodBeat.o(212372);
      return false;
    }
    String[] arrayOfString = aifP;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfString[i].equals(paramString))
      {
        AppMethodBeat.o(212372);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(212372);
    return false;
  }
  
  public static Uri c(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(156931);
    String str = paramString2;
    if (paramString2.isEmpty()) {
      str = " ";
    }
    switch (paramInt1)
    {
    default: 
      paramString1 = Uri.parse("content://" + paramString1 + ".sdk.xweb.XWebCoreProvider/" + str + "/" + paramInt1);
      AppMethodBeat.o(156931);
      return paramString1;
    }
    paramString1 = Uri.parse("content://" + paramString1 + ".sdk.xweb.XWebCoreProvider/" + str + "/" + paramInt1 + "/" + paramInt2 + "/" + paramString3);
    AppMethodBeat.o(156931);
    return paramString1;
  }
  
  public static boolean isBusy()
  {
    AppMethodBeat.i(212375);
    if (!aifQ.get())
    {
      Log.i("XWebCoreContentProvider", "isBusy = true, xweb not init yet");
      AppMethodBeat.o(212375);
      return true;
    }
    long l = System.currentTimeMillis() - aifR.get();
    if ((l >= 0L) && (l <= 10000L))
    {
      Log.i("XWebCoreContentProvider", "isBusy = true, is operating now");
      AppMethodBeat.o(212375);
      return true;
    }
    Log.i("XWebCoreContentProvider", "isBusy = false");
    AppMethodBeat.o(212375);
    return false;
  }
  
  public static boolean kga()
  {
    AppMethodBeat.i(212371);
    if (XWalkEnvironment.getApplicationContext() == null)
    {
      Log.e("XWebCoreContentProvider", "isSelfProvider, sApplicationContext is null");
      AppMethodBeat.o(212371);
      return true;
    }
    boolean bool = bHL(XWalkEnvironment.getApplicationContext().getPackageName());
    AppMethodBeat.o(212371);
    return bool;
  }
  
  public static void kgb()
  {
    AppMethodBeat.i(156932);
    Log.i("XWebCoreContentProvider", "onXWebInitFinished");
    a.kgc();
    aifQ.set(true);
    AppMethodBeat.o(156932);
  }
  
  private static d x(Uri paramUri)
  {
    AppMethodBeat.i(156930);
    d locald = new d();
    locald.opType = -1;
    Object localObject1 = paramUri.toString();
    if (((String)localObject1).length() > 1000)
    {
      Log.d("XWebCoreContentProvider", "parseUri exceed max length");
      AppMethodBeat.o(156930);
      return locald;
    }
    Log.d("XWebCoreContentProvider", "parseUri ".concat(String.valueOf(localObject1)));
    localObject1 = paramUri.getPathSegments();
    if ((localObject1 == null) || (((List)localObject1).size() < 2))
    {
      Log.d("XWebCoreContentProvider", "parseUri strList invalid");
      AppMethodBeat.o(156930);
      return locald;
    }
    paramUri = (String)((List)localObject1).get(0);
    if ((paramUri == null) || (paramUri.isEmpty()))
    {
      Log.d("XWebCoreContentProvider", "parseUri callerName invalid");
      AppMethodBeat.o(156930);
      return locald;
    }
    locald.aifV = paramUri;
    int j;
    try
    {
      j = Integer.parseInt((String)((List)localObject1).get(1));
      switch (j)
      {
      default: 
        Log.d("XWebCoreContentProvider", "parseUri invalid opType");
        AppMethodBeat.o(156930);
        return locald;
      }
    }
    finally
    {
      Log.d("XWebCoreContentProvider", "parseUri error parse opType, error:".concat(String.valueOf(paramUri)));
      AppMethodBeat.o(156930);
      return locald;
    }
    if (((List)localObject1).size() == 2)
    {
      locald.opType = j;
      Log.d("XWebCoreContentProvider", "parseUri result: ".concat(String.valueOf(j)));
    }
    for (;;)
    {
      AppMethodBeat.o(156930);
      return locald;
      Log.d("XWebCoreContentProvider", "parseUri wrong params on test or report");
    }
    paramUri = "";
    if (((List)localObject1).size() == 4) {
      paramUri = (String)((List)localObject1).get(3);
    }
    for (;;)
    {
      try
      {
        i = Integer.parseInt((String)((List)localObject1).get(2));
        if ((i != -1) && (paramUri != null) && (!paramUri.isEmpty()))
        {
          locald.opType = j;
          locald.tQy = i;
          locald.aifW = paramUri;
          Log.d("XWebCoreContentProvider", "parseUri result: " + j + " " + i + " " + paramUri);
          AppMethodBeat.o(156930);
          return locald;
        }
      }
      finally
      {
        Log.e("XWebCoreContentProvider", "parseUri error parse targetVersion, error:".concat(String.valueOf(localObject2)));
        i = -1;
        continue;
        Log.d("XWebCoreContentProvider", "parseUri wrong params on get file");
        continue;
      }
      int i = -1;
    }
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    AppMethodBeat.i(156926);
    aifR.set(System.currentTimeMillis());
    if ((paramContentValues == null) || (paramContentValues.size() == 0))
    {
      Log.d("XWebCoreContentProvider", "insert values is null or empty");
      AppMethodBeat.o(156926);
      return null;
    }
    if (x(paramUri).opType != 3)
    {
      Log.d("XWebCoreContentProvider", "insert wrong opType");
      AppMethodBeat.o(156926);
      return null;
    }
    paramUri = getContext();
    if (paramUri == null)
    {
      Log.e("XWebCoreContentProvider", "insert context is null");
      AppMethodBeat.o(156926);
      return null;
    }
    if (!"com.tencent.mm".equals(paramUri.getPackageName()))
    {
      Log.e("XWebCoreContentProvider", "insert current not mm, return");
      AppMethodBeat.o(156926);
      return null;
    }
    Log.d("XWebCoreContentProvider", "insert start report");
    paramUri = paramContentValues.valueSet().iterator();
    while (paramUri.hasNext())
    {
      paramContentValues = (Map.Entry)paramUri.next();
      int i;
      try
      {
        i = Integer.parseInt((String)paramContentValues.getKey());
        paramContentValues = (String)paramContentValues.getValue();
        if ((!l.aJE(i)) || (paramContentValues == null) || (paramContentValues.isEmpty())) {
          continue;
        }
        if (!l.gBh()) {
          break label264;
        }
        Log.d("XWebCoreContentProvider", "insert report " + i + " " + paramContentValues);
        l.ev(i, paramContentValues);
        continue;
      }
      finally
      {
        Log.e("XWebCoreContentProvider", "insert parse error:".concat(String.valueOf(paramContentValues)));
      }
      continue;
      label264:
      Log.d("XWebCoreContentProvider", "insert reporter not init, cache " + i + " " + paramContentValues);
      b localb = new b();
      localb.key = i;
      localb.value = paramContentValues;
      a.a(localb);
    }
    AppMethodBeat.o(156926);
    return null;
  }
  
  public boolean onCreate()
  {
    return true;
  }
  
  public ParcelFileDescriptor openFile(Uri paramUri, String paramString)
  {
    AppMethodBeat.i(156927);
    aifR.set(System.currentTimeMillis());
    d locald = x(paramUri);
    c localc = new c();
    localc.errCode = -1;
    localc.aifU = locald;
    Context localContext = getContext();
    if (localContext == null)
    {
      Log.e("XWebCoreContentProvider", "openFile context is null");
      localc.errCode = -2;
      a(null, localc);
      AppMethodBeat.o(156927);
      return null;
    }
    try
    {
      paramUri = localContext.getPackageManager().getPackagesForUid(Binder.getCallingUid());
      if (paramUri != null) {
        break label163;
      }
    }
    finally
    {
      for (;;)
      {
        Log.e("XWebCoreContentProvider", "tryRefillCallerName error:".concat(String.valueOf(paramUri)));
        continue;
        paramUri = paramString.toString();
        if (!paramUri.isEmpty()) {
          locald.aifV = paramUri;
        }
      }
      switch (locald.opType)
      {
      default: 
        Log.d("XWebCoreContentProvider", "openFile invalid uri");
        localc.errCode = -1;
        a(localContext, localc);
        AppMethodBeat.o(156927);
        return null;
      }
    }
    paramUri = localContext.getPackageName();
    localc.aifT = paramUri;
    Log.d("XWebCoreContentProvider", "openFile current package: ".concat(String.valueOf(paramUri)));
    label163:
    int i;
    if (!bHL(paramUri))
    {
      Log.e("XWebCoreContentProvider", "openFile current is not provider");
      localc.errCode = -3;
      a(localContext, localc);
      AppMethodBeat.o(156927);
      return null;
      paramString = new StringBuilder();
      i = 0;
    }
    for (;;)
    {
      if (i < paramUri.length)
      {
        if (i != paramUri.length - 1) {
          paramString.append(paramUri[i]).append("+");
        } else {
          paramString.append(paramUri[i]);
        }
      }
      else
      {
        Log.d("XWebCoreContentProvider", "openFile test msg from " + locald.aifV);
        localc.errCode = 2;
        a(localContext, localc);
        AppMethodBeat.o(156927);
        return null;
        Log.d("XWebCoreContentProvider", "openFile request from " + locald.aifV);
        paramString = new File(XWalkFileUtil.getPatchFileListConfig(localContext, locald.tQy));
        paramUri = paramString;
        if (!paramString.exists())
        {
          paramString = new File(XWalkFileUtil.getDownloadZipFileListConfig(localContext, locald.tQy));
          paramUri = paramString;
          if (!paramString.exists())
          {
            Log.d("XWebCoreContentProvider", "openFile cannot find listConfigFile of ver " + locald.tQy);
            localc.errCode = -4;
            a(localContext, localc);
            AppMethodBeat.o(156927);
            return null;
          }
        }
        if (locald.aifW.equals("filelist.config"))
        {
          if (XWalkEnvironment.getInstalledNewstVersion(localContext) == -1)
          {
            Log.d("XWebCoreContentProvider", "openFile can not get current version");
            localc.errCode = -8;
            a(localContext, localc);
            AppMethodBeat.o(156927);
            return null;
          }
          Log.d("XWebCoreContentProvider", "openFile return listConfigFile");
          localc.errCode = 1;
          a(localContext, localc);
          paramUri = ParcelFileDescriptor.open(paramUri, 268435456);
          AppMethodBeat.o(156927);
          return paramUri;
        }
        paramUri = ag(paramUri);
        if ((paramUri == null) || (paramUri.size() == 0))
        {
          Log.e("XWebCoreContentProvider", "openFile fileMap is null or empty");
          localc.errCode = -5;
          a(localContext, localc);
          AppMethodBeat.o(156927);
          return null;
        }
        if (paramUri.containsKey(locald.aifW))
        {
          if (locald.aifW.equals("base.apk")) {}
          for (paramUri = new File(XWalkFileUtil.getDownloadApkPath(localContext, locald.tQy)); paramUri.exists(); paramUri = new File(XWalkFileUtil.getExtractedCoreFile(localContext, locald.tQy, locald.aifW)))
          {
            Log.d("XWebCoreContentProvider", "openFile return file " + locald.aifW);
            localc.errCode = 0;
            a(localContext, localc);
            paramUri = ParcelFileDescriptor.open(paramUri, 268435456);
            AppMethodBeat.o(156927);
            return paramUri;
          }
          Log.d("XWebCoreContentProvider", "openFile file not exist " + locald.aifW);
          localc.errCode = -6;
          a(localContext, localc);
          AppMethodBeat.o(156927);
          return null;
        }
        Log.d("XWebCoreContentProvider", "openFile caller attempt to get file " + locald.aifW);
        localc.errCode = -7;
        a(localContext, localc);
        AppMethodBeat.o(156927);
        return null;
      }
      i += 1;
    }
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return null;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  public static final class a
  {
    private static final Object aieq;
    private static List<XWebCoreContentProvider.b> aifS;
    
    static
    {
      AppMethodBeat.i(156924);
      aifS = new ArrayList();
      aieq = new Object();
      AppMethodBeat.o(156924);
    }
    
    public static void a(XWebCoreContentProvider.b paramb)
    {
      AppMethodBeat.i(156922);
      synchronized (aieq)
      {
        aifS.add(paramb);
        AppMethodBeat.o(156922);
        return;
      }
    }
    
    public static void kgc()
    {
      AppMethodBeat.i(156923);
      Log.i("XWebCoreContentProvider", "CachedInfoMgr process cached info");
      synchronized (aieq)
      {
        Iterator localIterator = aifS.iterator();
        if (localIterator.hasNext())
        {
          XWebCoreContentProvider.b localb = (XWebCoreContentProvider.b)localIterator.next();
          l.ev(localb.key, localb.value);
        }
      }
      aifS.clear();
      AppMethodBeat.o(156923);
    }
  }
  
  public static final class b
  {
    public int key = -1;
    public String value = "";
  }
  
  public static final class c
  {
    public String aifT;
    public XWebCoreContentProvider.d aifU;
    public int errCode;
    
    public c()
    {
      AppMethodBeat.i(156925);
      this.errCode = -1;
      this.aifT = "";
      this.aifU = new XWebCoreContentProvider.d();
      AppMethodBeat.o(156925);
    }
  }
  
  public static final class d
  {
    public String aifV = "";
    public String aifW = "";
    public int opType = -1;
    public int tQy = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.XWebCoreContentProvider
 * JD-Core Version:    0.7.0.1
 */