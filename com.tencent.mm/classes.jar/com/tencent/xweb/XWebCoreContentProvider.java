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
import com.tencent.xweb.util.f;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public class XWebCoreContentProvider
  extends ContentProvider
{
  private static void a(Context paramContext, XWebCoreContentProvider.c paramc)
  {
    AppMethodBeat.i(3950);
    String str1;
    Object localObject;
    if (paramc.BEx.length() > 100)
    {
      str1 = paramc.BEx.substring(0, 99);
      if (paramc.BEy.BEz.length() <= 100) {
        break label225;
      }
      localObject = paramc.BEy.BEz.substring(0, 99);
      label58:
      if (paramc.BEy.BEA.length() <= 100) {
        break label236;
      }
    }
    label225:
    label236:
    for (String str2 = paramc.BEy.BEA.substring(0, 99);; str2 = paramc.BEy.BEA)
    {
      str1 = paramc.errCode + "," + str1 + "," + paramc.BEy.opType + "," + (String)localObject + "," + paramc.BEy.ilI + "," + str2;
      if ((paramContext == null) || ("com.tencent.mm".equals(paramc.BEx))) {
        break label304;
      }
      Log.d("XWebCoreContentProvider", "doReport need post to mm ".concat(String.valueOf(str1)));
      paramContext = paramContext.getContentResolver();
      if (paramContext != null) {
        break label248;
      }
      Log.e("XWebCoreContentProvider", "doReport content resolver is null");
      AppMethodBeat.o(3950);
      return;
      str1 = paramc.BEx;
      break;
      localObject = paramc.BEy.BEz;
      break label58;
    }
    try
    {
      label248:
      localObject = new ContentValues();
      ((ContentValues)localObject).put("15625", str1);
      paramContext.insert(b("com.tencent.mm", paramc.BEx, 3, 0, ""), (ContentValues)localObject);
      AppMethodBeat.o(3950);
      return;
    }
    catch (Exception paramContext)
    {
      Log.d("XWebCoreContentProvider", "doReport error post to mm");
      AppMethodBeat.o(3950);
      return;
    }
    label304:
    if (f.cbQ())
    {
      Log.d("XWebCoreContentProvider", "doReport ".concat(String.valueOf(str1)));
      f.bW(15625, str1);
      AppMethodBeat.o(3950);
      return;
    }
    Log.d("XWebCoreContentProvider", "doReport reporter not init, cache ".concat(String.valueOf(str1)));
    paramContext = new b();
    paramContext.key = 15625;
    paramContext.value = str1;
    XWebCoreContentProvider.a.a(paramContext);
    AppMethodBeat.o(3950);
  }
  
  /* Error */
  private static Map<String, String> au(File paramFile)
  {
    // Byte code:
    //   0: sipush 3951
    //   3: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 165	java/util/HashMap
    //   9: dup
    //   10: invokespecial 166	java/util/HashMap:<init>	()V
    //   13: astore_3
    //   14: new 168	java/io/BufferedReader
    //   17: dup
    //   18: new 170	java/io/FileReader
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 173	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   26: invokespecial 176	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   29: astore_1
    //   30: aload_1
    //   31: astore_0
    //   32: aload_1
    //   33: invokevirtual 179	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   36: astore_2
    //   37: aload_2
    //   38: ifnull +145 -> 183
    //   41: aload_1
    //   42: astore_0
    //   43: aload_2
    //   44: invokevirtual 182	java/lang/String:isEmpty	()Z
    //   47: ifne -17 -> 30
    //   50: aload_1
    //   51: astore_0
    //   52: aload_2
    //   53: ldc 184
    //   55: invokevirtual 188	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   58: astore_2
    //   59: aload_1
    //   60: astore_0
    //   61: aload_2
    //   62: arraylength
    //   63: iconst_2
    //   64: if_icmpne -34 -> 30
    //   67: aload_2
    //   68: iconst_0
    //   69: aaload
    //   70: ifnull -40 -> 30
    //   73: aload_1
    //   74: astore_0
    //   75: aload_2
    //   76: iconst_0
    //   77: aaload
    //   78: invokevirtual 182	java/lang/String:isEmpty	()Z
    //   81: ifne -51 -> 30
    //   84: aload_2
    //   85: iconst_1
    //   86: aaload
    //   87: ifnull -57 -> 30
    //   90: aload_1
    //   91: astore_0
    //   92: aload_2
    //   93: iconst_1
    //   94: aaload
    //   95: invokevirtual 182	java/lang/String:isEmpty	()Z
    //   98: ifne -68 -> 30
    //   101: aload_1
    //   102: astore_0
    //   103: aload_3
    //   104: aload_2
    //   105: iconst_0
    //   106: aaload
    //   107: aload_2
    //   108: iconst_1
    //   109: aaload
    //   110: invokeinterface 193 3 0
    //   115: pop
    //   116: aload_1
    //   117: astore_0
    //   118: ldc 86
    //   120: new 54	java/lang/StringBuilder
    //   123: dup
    //   124: ldc 195
    //   126: invokespecial 198	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   129: aload_2
    //   130: iconst_0
    //   131: aaload
    //   132: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 102	org/xwalk/core/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   141: goto -111 -> 30
    //   144: astore_2
    //   145: aload_1
    //   146: astore_0
    //   147: ldc 86
    //   149: new 54	java/lang/StringBuilder
    //   152: dup
    //   153: ldc 200
    //   155: invokespecial 198	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   158: aload_2
    //   159: invokevirtual 203	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   162: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokestatic 113	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   171: aload_1
    //   172: invokestatic 209	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   175: sipush 3951
    //   178: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   181: aload_3
    //   182: areturn
    //   183: aload_1
    //   184: invokestatic 209	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   187: goto -12 -> 175
    //   190: astore_1
    //   191: aconst_null
    //   192: astore_0
    //   193: aload_0
    //   194: invokestatic 209	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   197: sipush 3951
    //   200: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   203: aload_1
    //   204: athrow
    //   205: astore_1
    //   206: goto -13 -> 193
    //   209: astore_2
    //   210: aconst_null
    //   211: astore_1
    //   212: goto -67 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	paramFile	File
    //   29	155	1	localBufferedReader	java.io.BufferedReader
    //   190	14	1	localObject1	Object
    //   205	1	1	localObject2	Object
    //   211	1	1	localObject3	Object
    //   36	94	2	localObject4	Object
    //   144	15	2	localException1	Exception
    //   209	1	2	localException2	Exception
    //   13	169	3	localHashMap	java.util.HashMap
    // Exception table:
    //   from	to	target	type
    //   32	37	144	java/lang/Exception
    //   43	50	144	java/lang/Exception
    //   52	59	144	java/lang/Exception
    //   61	67	144	java/lang/Exception
    //   75	84	144	java/lang/Exception
    //   92	101	144	java/lang/Exception
    //   103	116	144	java/lang/Exception
    //   118	141	144	java/lang/Exception
    //   14	30	190	finally
    //   32	37	205	finally
    //   43	50	205	finally
    //   52	59	205	finally
    //   61	67	205	finally
    //   75	84	205	finally
    //   92	101	205	finally
    //   103	116	205	finally
    //   118	141	205	finally
    //   147	171	205	finally
    //   14	30	209	java/lang/Exception
  }
  
  public static Uri b(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(3953);
    String str = paramString2;
    if (paramString2.isEmpty()) {
      str = " ";
    }
    switch (paramInt1)
    {
    default: 
      paramString1 = Uri.parse("content://" + paramString1 + ".sdk.xweb.XWebCoreProvider/" + str + "/" + paramInt1);
      AppMethodBeat.o(3953);
      return paramString1;
    }
    paramString1 = Uri.parse("content://" + paramString1 + ".sdk.xweb.XWebCoreProvider/" + str + "/" + paramInt1 + "/" + paramInt2 + "/" + paramString3);
    AppMethodBeat.o(3953);
    return paramString1;
  }
  
  public static void dYC()
  {
    AppMethodBeat.i(3954);
    XWebCoreContentProvider.a.dYD();
    AppMethodBeat.o(3954);
  }
  
  private static XWebCoreContentProvider.d r(Uri paramUri)
  {
    AppMethodBeat.i(3952);
    XWebCoreContentProvider.d locald = new XWebCoreContentProvider.d();
    locald.opType = -1;
    Object localObject = paramUri.toString();
    if (((String)localObject).length() > 1000)
    {
      Log.d("XWebCoreContentProvider", "parseUri exceed max length");
      AppMethodBeat.o(3952);
      return locald;
    }
    Log.d("XWebCoreContentProvider", "parseUri ".concat(String.valueOf(localObject)));
    localObject = paramUri.getPathSegments();
    if ((localObject == null) || (((List)localObject).size() < 2))
    {
      Log.d("XWebCoreContentProvider", "parseUri strList invalid");
      AppMethodBeat.o(3952);
      return locald;
    }
    paramUri = (String)((List)localObject).get(0);
    if ((paramUri == null) || (paramUri.isEmpty()))
    {
      Log.d("XWebCoreContentProvider", "parseUri callerName invalid");
      AppMethodBeat.o(3952);
      return locald;
    }
    locald.BEz = paramUri;
    int j;
    try
    {
      j = Integer.parseInt((String)((List)localObject).get(1));
      switch (j)
      {
      default: 
        Log.d("XWebCoreContentProvider", "parseUri invalid opType");
        AppMethodBeat.o(3952);
        return locald;
      }
    }
    catch (Exception paramUri)
    {
      Log.d("XWebCoreContentProvider", "parseUri error parse opType");
      AppMethodBeat.o(3952);
      return locald;
    }
    if (((List)localObject).size() == 2)
    {
      locald.opType = j;
      Log.d("XWebCoreContentProvider", "parseUri result: ".concat(String.valueOf(j)));
    }
    for (;;)
    {
      AppMethodBeat.o(3952);
      return locald;
      Log.d("XWebCoreContentProvider", "parseUri wrong params on test or report");
    }
    paramUri = null;
    if (((List)localObject).size() == 4) {
      paramUri = (String)((List)localObject).get(3);
    }
    for (;;)
    {
      try
      {
        i = Integer.parseInt((String)((List)localObject).get(2));
        if ((i != -1) && (paramUri != null) && (!paramUri.isEmpty()))
        {
          locald.opType = j;
          locald.ilI = i;
          locald.BEA = paramUri;
          Log.d("XWebCoreContentProvider", "parseUri result: " + j + " " + i + " " + paramUri);
          AppMethodBeat.o(3952);
          return locald;
        }
      }
      catch (Exception localException)
      {
        Log.d("XWebCoreContentProvider", "parseUri error parse targetVersion");
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
    AppMethodBeat.i(3948);
    if ((paramContentValues == null) || (paramContentValues.size() == 0))
    {
      Log.d("XWebCoreContentProvider", "insert values is null or empty");
      AppMethodBeat.o(3948);
      return null;
    }
    if (r(paramUri).opType != 3)
    {
      Log.d("XWebCoreContentProvider", "insert wrong opType");
      AppMethodBeat.o(3948);
      return null;
    }
    paramUri = getContext();
    if (paramUri == null)
    {
      Log.e("XWebCoreContentProvider", "insert context is null");
      AppMethodBeat.o(3948);
      return null;
    }
    if (!"com.tencent.mm".equals(paramUri.getPackageName()))
    {
      Log.e("XWebCoreContentProvider", "insert current not mm, return");
      AppMethodBeat.o(3948);
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
        if ((!f.Tz(i)) || (paramContentValues == null) || (paramContentValues.isEmpty())) {
          continue;
        }
        if (!f.cbQ()) {
          break label248;
        }
        Log.d("XWebCoreContentProvider", "insert report " + i + " " + paramContentValues);
        f.bW(i, paramContentValues);
      }
      catch (Exception paramContentValues)
      {
        Log.d("XWebCoreContentProvider", "insert parse error");
      }
      continue;
      label248:
      Log.d("XWebCoreContentProvider", "insert reporter not init, cache " + i + " " + paramContentValues);
      b localb = new b();
      localb.key = i;
      localb.value = paramContentValues;
      XWebCoreContentProvider.a.a(localb);
    }
    AppMethodBeat.o(3948);
    return null;
  }
  
  public boolean onCreate()
  {
    return true;
  }
  
  public ParcelFileDescriptor openFile(Uri paramUri, String paramString)
  {
    AppMethodBeat.i(3949);
    XWebCoreContentProvider.d locald = r(paramUri);
    XWebCoreContentProvider.c localc = new XWebCoreContentProvider.c();
    localc.errCode = -1;
    localc.BEy = locald;
    Context localContext = getContext();
    if (localContext == null)
    {
      Log.e("XWebCoreContentProvider", "openFile context is null");
      localc.errCode = -2;
      a(null, localc);
      AppMethodBeat.o(3949);
      return null;
    }
    try
    {
      paramUri = localContext.getPackageManager().getPackagesForUid(Binder.getCallingUid());
      if (paramUri != null) {
        break label154;
      }
    }
    catch (Exception paramUri)
    {
      for (;;)
      {
        Log.e("XWebCoreContentProvider", "tryRefillCallerName error " + paramUri.getMessage());
        continue;
        paramUri = paramString.toString();
        if (!paramUri.isEmpty()) {
          locald.BEz = paramUri;
        }
      }
      switch (locald.opType)
      {
      default: 
        Log.d("XWebCoreContentProvider", "openFile invalid uri");
        localc.errCode = -1;
        a(localContext, localc);
        AppMethodBeat.o(3949);
        return null;
      }
    }
    paramUri = localContext.getPackageName();
    localc.BEx = paramUri;
    Log.d("XWebCoreContentProvider", "openFile current package: ".concat(String.valueOf(paramUri)));
    label154:
    int i;
    if (!XWalkEnvironment.isProvider(paramUri))
    {
      Log.e("XWebCoreContentProvider", "openFile current is not provider");
      localc.errCode = -3;
      a(localContext, localc);
      AppMethodBeat.o(3949);
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
        Log.d("XWebCoreContentProvider", "openFile test msg from " + locald.BEz);
        localc.errCode = 2;
        a(localContext, localc);
        AppMethodBeat.o(3949);
        return null;
        Log.d("XWebCoreContentProvider", "openFile request from " + locald.BEz);
        paramString = new File(XWalkEnvironment.getPatchFileListConfig(localContext, locald.ilI));
        paramUri = paramString;
        if (!paramString.exists())
        {
          paramString = new File(XWalkEnvironment.getDownloadZipFileListConfig(localContext, locald.ilI));
          paramUri = paramString;
          if (!paramString.exists())
          {
            Log.d("XWebCoreContentProvider", "openFile cannot find listConfigFile of ver " + locald.ilI);
            localc.errCode = -4;
            a(localContext, localc);
            AppMethodBeat.o(3949);
            return null;
          }
        }
        if (locald.BEA.equals("filelist.config"))
        {
          i = XWalkEnvironment.readAvailableVersionFromSP(localContext);
          if (i == -1)
          {
            Log.d("XWebCoreContentProvider", "openFile can not get current version");
            localc.errCode = -8;
            a(localContext, localc);
            AppMethodBeat.o(3949);
            return null;
          }
          if (locald.ilI > i)
          {
            Log.d("XWebCoreContentProvider", "openFile target version installing");
            localc.errCode = -9;
            a(localContext, localc);
            AppMethodBeat.o(3949);
            return null;
          }
          Log.d("XWebCoreContentProvider", "openFile return listConfigFile");
          localc.errCode = 1;
          a(localContext, localc);
          paramUri = ParcelFileDescriptor.open(paramUri, 268435456);
          AppMethodBeat.o(3949);
          return paramUri;
        }
        paramUri = au(paramUri);
        if (paramUri.size() == 0)
        {
          Log.e("XWebCoreContentProvider", "openFile fileMap is null or empty");
          localc.errCode = -5;
          a(localContext, localc);
          AppMethodBeat.o(3949);
          return null;
        }
        if (paramUri.containsKey(locald.BEA))
        {
          if (locald.BEA.equals("base.apk")) {}
          for (paramUri = new File(XWalkEnvironment.getDownloadApkPath(localContext, locald.ilI)); paramUri.exists(); paramUri = new File(XWalkEnvironment.getExtractedCoreFile(localContext, locald.ilI, locald.BEA)))
          {
            Log.d("XWebCoreContentProvider", "openFile return file " + locald.BEA);
            localc.errCode = 0;
            a(localContext, localc);
            paramUri = ParcelFileDescriptor.open(paramUri, 268435456);
            AppMethodBeat.o(3949);
            return paramUri;
          }
          Log.d("XWebCoreContentProvider", "openFile file not exist " + locald.BEA);
          localc.errCode = -6;
          a(localContext, localc);
          AppMethodBeat.o(3949);
          return null;
        }
        Log.d("XWebCoreContentProvider", "openFile caller attempt to get file " + locald.BEA);
        localc.errCode = -7;
        a(localContext, localc);
        AppMethodBeat.o(3949);
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
  
  public static final class b
  {
    public int key = -1;
    public String value = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.XWebCoreContentProvider
 * JD-Core Version:    0.7.0.1
 */