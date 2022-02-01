package android.support.v4.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParserException;

public class FileProvider
  extends ContentProvider
{
  private static final String[] hH = { "_display_name", "_size" };
  private static final File hI = new File("/");
  private static HashMap<String, b> hJ = new HashMap();
  private b hK;
  
  private static File a(File paramFile, String... paramVarArgs)
  {
    int i = 0;
    if (i <= 0)
    {
      String str = paramVarArgs[0];
      if (str == null) {
        break label33;
      }
      paramFile = new File(paramFile, str);
    }
    label33:
    for (;;)
    {
      i += 1;
      break;
      return paramFile;
    }
  }
  
  private static b c(Context paramContext, String paramString)
  {
    Object localObject2;
    Object localObject1;
    synchronized (hJ)
    {
      localObject2 = (b)hJ.get(paramString);
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    for (;;)
    {
      try
      {
        localObject2 = new c(paramString);
        localXmlResourceParser = paramContext.getPackageManager().resolveContentProvider(paramString, 128).loadXmlMetaData(paramContext.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
        if (localXmlResourceParser == null) {
          throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
        }
      }
      catch (IOException paramContext)
      {
        XmlResourceParser localXmlResourceParser;
        throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", paramContext);
        paramContext = finally;
        throw paramContext;
        int i = localXmlResourceParser.next();
        if (i == 1) {
          break label331;
        }
        if (i != 2) {
          continue;
        }
        localObject1 = localXmlResourceParser.getName();
        String str1 = localXmlResourceParser.getAttributeValue(null, "name");
        String str2 = localXmlResourceParser.getAttributeValue(null, "path");
        if ("root-path".equals(localObject1))
        {
          localObject1 = hI;
          if (localObject1 == null) {
            continue;
          }
          ((c)localObject2).a(str1, a((File)localObject1, new String[] { str2 }));
          continue;
        }
      }
      catch (XmlPullParserException paramContext)
      {
        throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", paramContext);
      }
      if ("files-path".equals(localObject1))
      {
        localObject1 = paramContext.getFilesDir();
      }
      else if ("cache-path".equals(localObject1))
      {
        localObject1 = paramContext.getCacheDir();
      }
      else if ("external-path".equals(localObject1))
      {
        localObject1 = Environment.getExternalStorageDirectory();
      }
      else
      {
        if ("external-files-path".equals(localObject1))
        {
          localObject1 = a.a(paramContext);
          if (localObject1.length > 0) {
            localObject1 = localObject1[0];
          }
        }
        else if ("external-cache-path".equals(localObject1))
        {
          localObject1 = a.b(paramContext);
          if (localObject1.length > 0) {
            localObject1 = localObject1[0];
          }
        }
        else if ((Build.VERSION.SDK_INT >= 21) && ("external-media-path".equals(localObject1)))
        {
          localObject1 = paramContext.getExternalMediaDirs();
          if (localObject1.length > 0)
          {
            localObject1 = localObject1[0];
            continue;
            label331:
            hJ.put(paramString, localObject2);
            localObject1 = localObject2;
            return localObject1;
          }
        }
        localObject1 = null;
      }
    }
  }
  
  public void attachInfo(Context paramContext, ProviderInfo paramProviderInfo)
  {
    super.attachInfo(paramContext, paramProviderInfo);
    if (paramProviderInfo.exported) {
      throw new SecurityException("Provider must not be exported");
    }
    if (!paramProviderInfo.grantUriPermissions) {
      throw new SecurityException("Provider must grant uri permissions");
    }
    this.hK = c(paramContext, paramProviderInfo.authority);
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    if (this.hK.a(paramUri).delete()) {
      return 1;
    }
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    paramUri = this.hK.a(paramUri);
    int i = paramUri.getName().lastIndexOf('.');
    if (i >= 0)
    {
      paramUri = paramUri.getName().substring(i + 1);
      paramUri = MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramUri);
      if (paramUri != null) {
        return paramUri;
      }
    }
    return "application/octet-stream";
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    throw new UnsupportedOperationException("No external inserts");
  }
  
  public boolean onCreate()
  {
    return true;
  }
  
  public ParcelFileDescriptor openFile(Uri paramUri, String paramString)
  {
    paramUri = this.hK.a(paramUri);
    int i;
    if ("r".equals(paramString)) {
      i = 268435456;
    }
    for (;;)
    {
      return ParcelFileDescriptor.open(paramUri, i);
      if (("w".equals(paramString)) || ("wt".equals(paramString)))
      {
        i = 738197504;
      }
      else if ("wa".equals(paramString))
      {
        i = 704643072;
      }
      else if ("rw".equals(paramString))
      {
        i = 939524096;
      }
      else
      {
        if (!"rwt".equals(paramString)) {
          break;
        }
        i = 1006632960;
      }
    }
    throw new IllegalArgumentException("Invalid mode: ".concat(String.valueOf(paramString)));
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    paramString1 = this.hK.a(paramUri);
    paramUri = paramArrayOfString1;
    if (paramArrayOfString1 == null) {
      paramUri = hH;
    }
    paramArrayOfString2 = new String[paramUri.length];
    paramArrayOfString1 = new Object[paramUri.length];
    int m = paramUri.length;
    int j = 0;
    int i = 0;
    int k;
    if (j < m)
    {
      paramString2 = paramUri[j];
      if ("_display_name".equals(paramString2))
      {
        paramArrayOfString2[i] = "_display_name";
        k = i + 1;
        paramArrayOfString1[i] = paramString1.getName();
        i = k;
      }
    }
    for (;;)
    {
      j += 1;
      break;
      if ("_size".equals(paramString2))
      {
        paramArrayOfString2[i] = "_size";
        k = i + 1;
        paramArrayOfString1[i] = Long.valueOf(paramString1.length());
        i = k;
        continue;
        paramUri = new String[i];
        System.arraycopy(paramArrayOfString2, 0, paramUri, 0, i);
        paramString1 = new Object[i];
        System.arraycopy(paramArrayOfString1, 0, paramString1, 0, i);
        paramUri = new MatrixCursor(paramUri, 1);
        paramUri.addRow(paramString1);
        return paramUri;
      }
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    throw new UnsupportedOperationException("No external updates");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.content.FileProvider
 * JD-Core Version:    0.7.0.1
 */