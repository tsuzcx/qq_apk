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
import com.tencent.xweb.util.e;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
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
    String str1;
    Object localObject;
    if (paramc.xhu.length() > 100)
    {
      str1 = paramc.xhu.substring(0, 99);
      if (paramc.xhv.xhw.length() <= 100) {
        break label220;
      }
      localObject = paramc.xhv.xhw.substring(0, 99);
      label52:
      if (paramc.xhv.xhx.length() <= 100) {
        break label231;
      }
    }
    label220:
    label231:
    for (String str2 = paramc.xhv.xhx.substring(0, 99);; str2 = paramc.xhv.xhx)
    {
      str1 = paramc.errCode + "," + str1 + "," + paramc.xhv.opType + "," + (String)localObject + "," + paramc.xhv.gKH + "," + str2;
      if ((paramContext == null) || ("com.tencent.mm".equals(paramc.xhu))) {
        break label287;
      }
      Log.d("XWebCoreContentProvider", "doReport need post to mm " + str1);
      paramContext = paramContext.getContentResolver();
      if (paramContext != null) {
        break label243;
      }
      Log.e("XWebCoreContentProvider", "doReport content resolver is null");
      return;
      str1 = paramc.xhu;
      break;
      localObject = paramc.xhv.xhw;
      break label52;
    }
    try
    {
      label243:
      localObject = new ContentValues();
      ((ContentValues)localObject).put("15625", str1);
      paramContext.insert(b("com.tencent.mm", paramc.xhu, 3, 0, ""), (ContentValues)localObject);
      return;
    }
    catch (Exception paramContext)
    {
      Log.d("XWebCoreContentProvider", "doReport error post to mm");
      return;
    }
    label287:
    if (e.bsu())
    {
      Log.d("XWebCoreContentProvider", "doReport " + str1);
      e.bp(15625, str1);
      return;
    }
    Log.d("XWebCoreContentProvider", "doReport reporter not init, cache " + str1);
    paramContext = new b();
    paramContext.key = 15625;
    paramContext.value = str1;
    XWebCoreContentProvider.a.a(paramContext);
  }
  
  private static Map<String, String> am(File paramFile)
  {
    HashMap localHashMap = new HashMap();
    try
    {
      paramFile = new BufferedReader(new FileReader(paramFile));
      for (;;)
      {
        Object localObject = paramFile.readLine();
        if (localObject == null) {
          break;
        }
        if (!((String)localObject).isEmpty())
        {
          localObject = ((String)localObject).split(":");
          if ((localObject.length == 2) && (localObject[0] != null) && (!localObject[0].isEmpty()) && (localObject[1] != null) && (!localObject[1].isEmpty()))
          {
            localHashMap.put(localObject[0], localObject[1]);
            Log.d("XWebCoreContentProvider", "readListConfigFile found " + localObject[0]);
          }
        }
      }
      paramFile.close();
    }
    catch (Exception paramFile)
    {
      Log.e("XWebCoreContentProvider", "readListConfigFile error: " + paramFile.getMessage());
      return localHashMap;
    }
    return localHashMap;
  }
  
  public static Uri b(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    String str = paramString2;
    if (paramString2.isEmpty()) {
      str = " ";
    }
    switch (paramInt1)
    {
    default: 
      return Uri.parse("content://" + paramString1 + ".sdk.xweb.XWebCoreProvider/" + str + "/" + paramInt1);
    }
    return Uri.parse("content://" + paramString1 + ".sdk.xweb.XWebCoreProvider/" + str + "/" + paramInt1 + "/" + paramInt2 + "/" + paramString3);
  }
  
  public static void cSw() {}
  
  private static XWebCoreContentProvider.d p(Uri paramUri)
  {
    XWebCoreContentProvider.d locald = new XWebCoreContentProvider.d();
    locald.opType = -1;
    Object localObject = paramUri.toString();
    if (((String)localObject).length() > 1000)
    {
      Log.d("XWebCoreContentProvider", "parseUri exceed max length");
      return locald;
    }
    Log.d("XWebCoreContentProvider", "parseUri " + (String)localObject);
    localObject = paramUri.getPathSegments();
    if ((localObject == null) || (((List)localObject).size() < 2))
    {
      Log.d("XWebCoreContentProvider", "parseUri strList invalid");
      return locald;
    }
    paramUri = (String)((List)localObject).get(0);
    if ((paramUri == null) || (paramUri.isEmpty()))
    {
      Log.d("XWebCoreContentProvider", "parseUri callerName invalid");
      return locald;
    }
    locald.xhw = paramUri;
    int j;
    try
    {
      j = Integer.parseInt((String)((List)localObject).get(1));
      switch (j)
      {
      default: 
        Log.d("XWebCoreContentProvider", "parseUri invalid opType");
        return locald;
      }
    }
    catch (Exception paramUri)
    {
      Log.d("XWebCoreContentProvider", "parseUri error parse opType");
      return locald;
    }
    if (((List)localObject).size() == 2)
    {
      locald.opType = j;
      Log.d("XWebCoreContentProvider", "parseUri result: " + j);
    }
    for (;;)
    {
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
          locald.gKH = i;
          locald.xhx = paramUri;
          Log.d("XWebCoreContentProvider", "parseUri result: " + j + " " + i + " " + paramUri);
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
    if ((paramContentValues == null) || (paramContentValues.size() == 0)) {
      Log.d("XWebCoreContentProvider", "insert values is null or empty");
    }
    for (;;)
    {
      return null;
      if (p(paramUri).opType != 3)
      {
        Log.d("XWebCoreContentProvider", "insert wrong opType");
        return null;
      }
      paramUri = getContext();
      if (paramUri == null)
      {
        Log.e("XWebCoreContentProvider", "insert context is null");
        return null;
      }
      if (!"com.tencent.mm".equals(paramUri.getPackageName()))
      {
        Log.e("XWebCoreContentProvider", "insert current not mm, return");
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
          if ((!e.KF(i)) || (paramContentValues == null) || (paramContentValues.isEmpty())) {
            continue;
          }
          if (!e.bsu()) {
            break label218;
          }
          Log.d("XWebCoreContentProvider", "insert report " + i + " " + paramContentValues);
          e.bp(i, paramContentValues);
        }
        catch (Exception paramContentValues)
        {
          Log.d("XWebCoreContentProvider", "insert parse error");
        }
        continue;
        label218:
        Log.d("XWebCoreContentProvider", "insert reporter not init, cache " + i + " " + paramContentValues);
        b localb = new b();
        localb.key = i;
        localb.value = paramContentValues;
        XWebCoreContentProvider.a.a(localb);
      }
    }
  }
  
  public boolean onCreate()
  {
    return true;
  }
  
  public ParcelFileDescriptor openFile(Uri paramUri, String paramString)
  {
    XWebCoreContentProvider.d locald = p(paramUri);
    XWebCoreContentProvider.c localc = new XWebCoreContentProvider.c();
    localc.errCode = -1;
    localc.xhv = locald;
    Context localContext = getContext();
    if (localContext == null)
    {
      Log.e("XWebCoreContentProvider", "openFile context is null");
      localc.errCode = -2;
      a(null, localc);
      return null;
    }
    try
    {
      paramUri = localContext.getPackageManager().getPackagesForUid(Binder.getCallingUid());
      if (paramUri != null) {
        break label143;
      }
    }
    catch (Exception paramUri)
    {
      for (;;)
      {
        label143:
        Log.e("XWebCoreContentProvider", "tryRefillCallerName error " + paramUri.getMessage());
        continue;
        paramUri = paramString.toString();
        if (!paramUri.isEmpty()) {
          locald.xhw = paramUri;
        }
      }
      switch (locald.opType)
      {
      default: 
        Log.d("XWebCoreContentProvider", "openFile invalid uri");
        localc.errCode = -1;
        a(localContext, localc);
        return null;
      }
    }
    paramUri = localContext.getPackageName();
    localc.xhu = paramUri;
    Log.d("XWebCoreContentProvider", "openFile current package: " + paramUri);
    int i;
    if (!XWalkEnvironment.isProvider(paramUri))
    {
      Log.e("XWebCoreContentProvider", "openFile current is not provider");
      localc.errCode = -3;
      a(localContext, localc);
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
        Log.d("XWebCoreContentProvider", "openFile test msg from " + locald.xhw);
        localc.errCode = 2;
        a(localContext, localc);
        return null;
        Log.d("XWebCoreContentProvider", "openFile request from " + locald.xhw);
        paramString = new File(XWalkEnvironment.getPatchFileListConfig(localContext, locald.gKH));
        paramUri = paramString;
        if (!paramString.exists())
        {
          paramString = new File(XWalkEnvironment.getDownloadZipFileListConfig(localContext, locald.gKH));
          paramUri = paramString;
          if (!paramString.exists())
          {
            Log.d("XWebCoreContentProvider", "openFile cannot find listConfigFile of ver " + locald.gKH);
            localc.errCode = -4;
            a(localContext, localc);
            return null;
          }
        }
        if (locald.xhx.equals("filelist.config"))
        {
          i = XWalkEnvironment.readAvailableVersionFromSP(localContext);
          if (i == -1)
          {
            Log.d("XWebCoreContentProvider", "openFile can not get current version");
            localc.errCode = -8;
            a(localContext, localc);
            return null;
          }
          if (locald.gKH > i)
          {
            Log.d("XWebCoreContentProvider", "openFile target version installing");
            localc.errCode = -9;
            a(localContext, localc);
            return null;
          }
          Log.d("XWebCoreContentProvider", "openFile return listConfigFile");
          localc.errCode = 1;
          a(localContext, localc);
          return ParcelFileDescriptor.open(paramUri, 268435456);
        }
        paramUri = am(paramUri);
        if (paramUri.size() == 0)
        {
          Log.e("XWebCoreContentProvider", "openFile fileMap is null or empty");
          localc.errCode = -5;
          a(localContext, localc);
          return null;
        }
        if (paramUri.containsKey(locald.xhx))
        {
          if (locald.xhx.equals("base.apk")) {}
          for (paramUri = new File(XWalkEnvironment.getDownloadApkPath(localContext, locald.gKH)); paramUri.exists(); paramUri = new File(XWalkEnvironment.getExtractedCoreFile(localContext, locald.gKH, locald.xhx)))
          {
            Log.d("XWebCoreContentProvider", "openFile return file " + locald.xhx);
            localc.errCode = 0;
            a(localContext, localc);
            return ParcelFileDescriptor.open(paramUri, 268435456);
          }
          Log.d("XWebCoreContentProvider", "openFile file not exist " + locald.xhx);
          localc.errCode = -6;
          a(localContext, localc);
          return null;
        }
        Log.d("XWebCoreContentProvider", "openFile caller attempt to get file " + locald.xhx);
        localc.errCode = -7;
        a(localContext, localc);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.xweb.XWebCoreContentProvider
 * JD-Core Version:    0.7.0.1
 */