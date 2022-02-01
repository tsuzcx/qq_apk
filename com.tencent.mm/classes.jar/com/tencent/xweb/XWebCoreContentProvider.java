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
import com.tencent.xweb.util.g;
import java.io.File;
import java.util.ArrayList;
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
  private static d D(Uri paramUri)
  {
    AppMethodBeat.i(156930);
    d locald = new d();
    locald.opType = -1;
    Object localObject = paramUri.toString();
    if (((String)localObject).length() > 1000)
    {
      Log.d("XWebCoreContentProvider", "parseUri exceed max length");
      AppMethodBeat.o(156930);
      return locald;
    }
    Log.d("XWebCoreContentProvider", "parseUri ".concat(String.valueOf(localObject)));
    localObject = paramUri.getPathSegments();
    if ((localObject == null) || (((List)localObject).size() < 2))
    {
      Log.d("XWebCoreContentProvider", "parseUri strList invalid");
      AppMethodBeat.o(156930);
      return locald;
    }
    paramUri = (String)((List)localObject).get(0);
    if ((paramUri == null) || (paramUri.isEmpty()))
    {
      Log.d("XWebCoreContentProvider", "parseUri callerName invalid");
      AppMethodBeat.o(156930);
      return locald;
    }
    locald.INK = paramUri;
    int j;
    try
    {
      j = Integer.parseInt((String)((List)localObject).get(1));
      switch (j)
      {
      default: 
        Log.d("XWebCoreContentProvider", "parseUri invalid opType");
        AppMethodBeat.o(156930);
        return locald;
      }
    }
    catch (Exception paramUri)
    {
      Log.d("XWebCoreContentProvider", "parseUri error parse opType");
      AppMethodBeat.o(156930);
      return locald;
    }
    if (((List)localObject).size() == 2)
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
          locald.kIK = i;
          locald.INL = paramUri;
          Log.d("XWebCoreContentProvider", "parseUri result: " + j + " " + i + " " + paramUri);
          AppMethodBeat.o(156930);
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
  
  private static void a(Context paramContext, c paramc)
  {
    AppMethodBeat.i(156928);
    String str1;
    Object localObject;
    if (paramc.INI.length() > 100)
    {
      str1 = paramc.INI.substring(0, 99);
      if (paramc.INJ.INK.length() <= 100) {
        break label223;
      }
      localObject = paramc.INJ.INK.substring(0, 99);
      label57:
      if (paramc.INJ.INL.length() <= 100) {
        break label234;
      }
    }
    label223:
    label234:
    for (String str2 = paramc.INJ.INL.substring(0, 99);; str2 = paramc.INJ.INL)
    {
      str1 = paramc.errCode + "," + str1 + "," + paramc.INJ.opType + "," + (String)localObject + "," + paramc.INJ.kIK + "," + str2;
      if ((paramContext == null) || ("com.tencent.mm".equals(paramc.INI))) {
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
      str1 = paramc.INI;
      break;
      localObject = paramc.INJ.INK;
      break label57;
    }
    try
    {
      label246:
      localObject = new ContentValues();
      ((ContentValues)localObject).put("15625", str1);
      paramContext.insert(d("com.tencent.mm", paramc.INI, 3, 0, ""), (ContentValues)localObject);
      AppMethodBeat.o(156928);
      return;
    }
    catch (Exception paramContext)
    {
      Log.d("XWebCoreContentProvider", "doReport error post to mm");
      AppMethodBeat.o(156928);
      return;
    }
    label300:
    if (g.dch())
    {
      Log.d("XWebCoreContentProvider", "doReport ".concat(String.valueOf(str1)));
      g.cR(15625, str1);
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
  private static Map<String, String> aa(File paramFile)
  {
    // Byte code:
    //   0: ldc 223
    //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 225	java/util/HashMap
    //   8: dup
    //   9: invokespecial 226	java/util/HashMap:<init>	()V
    //   12: astore_3
    //   13: new 228	java/io/BufferedReader
    //   16: dup
    //   17: new 230	java/io/FileReader
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 233	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   25: invokespecial 236	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   28: astore_1
    //   29: aload_1
    //   30: astore_0
    //   31: aload_1
    //   32: invokevirtual 239	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   35: astore_2
    //   36: aload_2
    //   37: ifnull +144 -> 181
    //   40: aload_1
    //   41: astore_0
    //   42: aload_2
    //   43: invokevirtual 90	java/lang/String:isEmpty	()Z
    //   46: ifne -17 -> 29
    //   49: aload_1
    //   50: astore_0
    //   51: aload_2
    //   52: ldc 241
    //   54: invokevirtual 245	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   57: astore_2
    //   58: aload_1
    //   59: astore_0
    //   60: aload_2
    //   61: arraylength
    //   62: iconst_2
    //   63: if_icmpne -34 -> 29
    //   66: aload_2
    //   67: iconst_0
    //   68: aaload
    //   69: ifnull -40 -> 29
    //   72: aload_1
    //   73: astore_0
    //   74: aload_2
    //   75: iconst_0
    //   76: aaload
    //   77: invokevirtual 90	java/lang/String:isEmpty	()Z
    //   80: ifne -51 -> 29
    //   83: aload_2
    //   84: iconst_1
    //   85: aaload
    //   86: ifnull -57 -> 29
    //   89: aload_1
    //   90: astore_0
    //   91: aload_2
    //   92: iconst_1
    //   93: aaload
    //   94: invokevirtual 90	java/lang/String:isEmpty	()Z
    //   97: ifne -68 -> 29
    //   100: aload_1
    //   101: astore_0
    //   102: aload_3
    //   103: aload_2
    //   104: iconst_0
    //   105: aaload
    //   106: aload_2
    //   107: iconst_1
    //   108: aaload
    //   109: invokeinterface 250 3 0
    //   114: pop
    //   115: aload_1
    //   116: astore_0
    //   117: ldc 51
    //   119: new 121	java/lang/StringBuilder
    //   122: dup
    //   123: ldc 252
    //   125: invokespecial 124	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   128: aload_2
    //   129: iconst_0
    //   130: aaload
    //   131: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 58	org/xwalk/core/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   140: goto -111 -> 29
    //   143: astore_2
    //   144: aload_1
    //   145: astore_0
    //   146: ldc 51
    //   148: new 121	java/lang/StringBuilder
    //   151: dup
    //   152: ldc 254
    //   154: invokespecial 124	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   157: aload_2
    //   158: invokevirtual 257	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   161: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 176	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   170: aload_1
    //   171: invokestatic 263	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   174: ldc 223
    //   176: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   179: aload_3
    //   180: areturn
    //   181: aload_1
    //   182: invokestatic 263	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   185: goto -11 -> 174
    //   188: astore_1
    //   189: aconst_null
    //   190: astore_0
    //   191: aload_0
    //   192: invokestatic 263	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   195: ldc 223
    //   197: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   200: aload_1
    //   201: athrow
    //   202: astore_1
    //   203: goto -12 -> 191
    //   206: astore_2
    //   207: aconst_null
    //   208: astore_1
    //   209: goto -65 -> 144
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	212	0	paramFile	File
    //   28	154	1	localBufferedReader	java.io.BufferedReader
    //   188	13	1	localObject1	Object
    //   202	1	1	localObject2	Object
    //   208	1	1	localObject3	Object
    //   35	94	2	localObject4	Object
    //   143	15	2	localException1	Exception
    //   206	1	2	localException2	Exception
    //   12	168	3	localHashMap	java.util.HashMap
    // Exception table:
    //   from	to	target	type
    //   31	36	143	java/lang/Exception
    //   42	49	143	java/lang/Exception
    //   51	58	143	java/lang/Exception
    //   60	66	143	java/lang/Exception
    //   74	83	143	java/lang/Exception
    //   91	100	143	java/lang/Exception
    //   102	115	143	java/lang/Exception
    //   117	140	143	java/lang/Exception
    //   13	29	188	finally
    //   31	36	202	finally
    //   42	49	202	finally
    //   51	58	202	finally
    //   60	66	202	finally
    //   74	83	202	finally
    //   91	100	202	finally
    //   102	115	202	finally
    //   117	140	202	finally
    //   146	170	202	finally
    //   13	29	206	java/lang/Exception
  }
  
  public static Uri d(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
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
  
  public static void frl()
  {
    AppMethodBeat.i(156932);
    a.frm();
    AppMethodBeat.o(156932);
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
    if ((paramContentValues == null) || (paramContentValues.size() == 0))
    {
      Log.d("XWebCoreContentProvider", "insert values is null or empty");
      AppMethodBeat.o(156926);
      return null;
    }
    if (D(paramUri).opType != 3)
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
        if ((!g.ade(i)) || (paramContentValues == null) || (paramContentValues.isEmpty())) {
          continue;
        }
        if (!g.dch()) {
          break label248;
        }
        Log.d("XWebCoreContentProvider", "insert report " + i + " " + paramContentValues);
        g.cR(i, paramContentValues);
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
    d locald = D(paramUri);
    c localc = new c();
    localc.errCode = -1;
    localc.INJ = locald;
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
          locald.INK = paramUri;
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
    localc.INI = paramUri;
    Log.d("XWebCoreContentProvider", "openFile current package: ".concat(String.valueOf(paramUri)));
    label154:
    int i;
    if (!XWalkEnvironment.isProvider(paramUri))
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
        Log.d("XWebCoreContentProvider", "openFile test msg from " + locald.INK);
        localc.errCode = 2;
        a(localContext, localc);
        AppMethodBeat.o(156927);
        return null;
        Log.d("XWebCoreContentProvider", "openFile request from " + locald.INK);
        paramString = new File(XWalkEnvironment.getPatchFileListConfig(localContext, locald.kIK));
        paramUri = paramString;
        if (!paramString.exists())
        {
          paramString = new File(XWalkEnvironment.getDownloadZipFileListConfig(localContext, locald.kIK));
          paramUri = paramString;
          if (!paramString.exists())
          {
            Log.d("XWebCoreContentProvider", "openFile cannot find listConfigFile of ver " + locald.kIK);
            localc.errCode = -4;
            a(localContext, localc);
            AppMethodBeat.o(156927);
            return null;
          }
        }
        if (locald.INL.equals("filelist.config"))
        {
          i = XWalkEnvironment.readAvailableVersionFromSP(localContext);
          if (i == -1)
          {
            Log.d("XWebCoreContentProvider", "openFile can not get current version");
            localc.errCode = -8;
            a(localContext, localc);
            AppMethodBeat.o(156927);
            return null;
          }
          if (locald.kIK > i)
          {
            Log.d("XWebCoreContentProvider", "openFile target version installing");
            localc.errCode = -9;
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
        paramUri = aa(paramUri);
        if (paramUri.size() == 0)
        {
          Log.e("XWebCoreContentProvider", "openFile fileMap is null or empty");
          localc.errCode = -5;
          a(localContext, localc);
          AppMethodBeat.o(156927);
          return null;
        }
        if (paramUri.containsKey(locald.INL))
        {
          if (locald.INL.equals("base.apk")) {}
          for (paramUri = new File(XWalkEnvironment.getDownloadApkPath(localContext, locald.kIK)); paramUri.exists(); paramUri = new File(XWalkEnvironment.getExtractedCoreFile(localContext, locald.kIK, locald.INL)))
          {
            Log.d("XWebCoreContentProvider", "openFile return file " + locald.INL);
            localc.errCode = 0;
            a(localContext, localc);
            paramUri = ParcelFileDescriptor.open(paramUri, 268435456);
            AppMethodBeat.o(156927);
            return paramUri;
          }
          Log.d("XWebCoreContentProvider", "openFile file not exist " + locald.INL);
          localc.errCode = -6;
          a(localContext, localc);
          AppMethodBeat.o(156927);
          return null;
        }
        Log.d("XWebCoreContentProvider", "openFile caller attempt to get file " + locald.INL);
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
    private static final Object IMq;
    private static List<XWebCoreContentProvider.b> INH;
    
    static
    {
      AppMethodBeat.i(156924);
      INH = new ArrayList();
      IMq = new Object();
      AppMethodBeat.o(156924);
    }
    
    public static void a(XWebCoreContentProvider.b paramb)
    {
      AppMethodBeat.i(156922);
      synchronized (IMq)
      {
        INH.add(paramb);
        AppMethodBeat.o(156922);
        return;
      }
    }
    
    public static void frm()
    {
      AppMethodBeat.i(156923);
      Log.i("XWebCoreContentProvider", "CachedInfoMgr process cached info");
      synchronized (IMq)
      {
        Iterator localIterator = INH.iterator();
        if (localIterator.hasNext())
        {
          XWebCoreContentProvider.b localb = (XWebCoreContentProvider.b)localIterator.next();
          g.cR(localb.key, localb.value);
        }
      }
      INH.clear();
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
    public String INI;
    public XWebCoreContentProvider.d INJ;
    public int errCode;
    
    public c()
    {
      AppMethodBeat.i(156925);
      this.errCode = -1;
      this.INI = "";
      this.INJ = new XWebCoreContentProvider.d();
      AppMethodBeat.o(156925);
    }
  }
  
  public static final class d
  {
    public String INK = "";
    public String INL = "";
    public int kIK = 0;
    public int opType = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.XWebCoreContentProvider
 * JD-Core Version:    0.7.0.1
 */