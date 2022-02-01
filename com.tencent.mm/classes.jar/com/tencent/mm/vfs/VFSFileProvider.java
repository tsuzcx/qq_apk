package com.tencent.mm.vfs;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.ParcelFileDescriptor;
import android.webkit.MimeTypeMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.regex.Pattern;

public class VFSFileProvider
  extends ContentProvider
{
  private static final String[] COLUMNS;
  private static final Pattern Jtw;
  private String GV;
  
  static
  {
    AppMethodBeat.i(13316);
    COLUMNS = new String[] { "_display_name", "_size" };
    Jtw = Pattern.compile("/");
    AppMethodBeat.o(13316);
  }
  
  private static Uri A(Uri paramUri)
  {
    AppMethodBeat.i(13308);
    Object localObject = paramUri.getPath();
    if ((localObject == null) || (((String)localObject).isEmpty()))
    {
      AppMethodBeat.o(13308);
      return null;
    }
    paramUri = (Uri)localObject;
    if (((String)localObject).startsWith("/")) {
      paramUri = ((String)localObject).substring(1);
    }
    String[] arrayOfString = Jtw.split(paramUri, 3);
    if (arrayOfString.length < 2)
    {
      AppMethodBeat.o(13308);
      return null;
    }
    localObject = new Uri.Builder();
    String str = arrayOfString[0];
    if (str.startsWith("@"))
    {
      if (arrayOfString.length < 3)
      {
        AppMethodBeat.o(13308);
        return null;
      }
      ((Uri.Builder)localObject).scheme(str.substring(1));
      if (arrayOfString[1].equals("@"))
      {
        ((Uri.Builder)localObject).authority(null);
        ((Uri.Builder)localObject).path(arrayOfString[2]);
      }
    }
    for (;;)
    {
      paramUri = ((Uri.Builder)localObject).build();
      AppMethodBeat.o(13308);
      return paramUri;
      ((Uri.Builder)localObject).authority(arrayOfString[1]);
      break;
      paramUri = paramUri.substring(str.length() + 1);
      ((Uri.Builder)localObject).scheme("wcf").authority(str).path(paramUri);
    }
  }
  
  public void attachInfo(Context paramContext, ProviderInfo paramProviderInfo)
  {
    AppMethodBeat.i(13309);
    super.attachInfo(paramContext, paramProviderInfo);
    if (paramProviderInfo.exported)
    {
      paramContext = new SecurityException("Provider must not be exported");
      AppMethodBeat.o(13309);
      throw paramContext;
    }
    if (!paramProviderInfo.grantUriPermissions)
    {
      paramContext = new SecurityException("Provider must grant uri permissions");
      AppMethodBeat.o(13309);
      throw paramContext;
    }
    this.GV = paramProviderInfo.authority;
    AppMethodBeat.o(13309);
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(13313);
    paramString = A(paramUri);
    if (paramString == null)
    {
      paramUri = new IllegalArgumentException("No mapping found for ".concat(String.valueOf(paramUri)));
      AppMethodBeat.o(13313);
      throw paramUri;
    }
    if (new e(paramString).delete())
    {
      AppMethodBeat.o(13313);
      return 1;
    }
    AppMethodBeat.o(13313);
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    AppMethodBeat.i(13311);
    Uri localUri = A(paramUri);
    if (localUri == null)
    {
      paramUri = new IllegalArgumentException("No mapping found for ".concat(String.valueOf(paramUri)));
      AppMethodBeat.o(13311);
      throw paramUri;
    }
    paramUri = localUri.getScheme();
    if ((paramUri != null) && (paramUri.equals("content")))
    {
      paramUri = getContext();
      if (paramUri != null)
      {
        paramUri = paramUri.getContentResolver().getType(localUri);
        AppMethodBeat.o(13311);
        return paramUri;
      }
    }
    paramUri = new e(localUri);
    int i = paramUri.getName().lastIndexOf('.');
    if (i >= 0)
    {
      paramUri = paramUri.getName().substring(i + 1);
      paramUri = MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramUri);
      if (paramUri != null)
      {
        AppMethodBeat.o(13311);
        return paramUri;
      }
    }
    AppMethodBeat.o(13311);
    return "application/octet-stream";
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    AppMethodBeat.i(13312);
    paramUri = new UnsupportedOperationException("No external inserts");
    AppMethodBeat.o(13312);
    throw paramUri;
  }
  
  public boolean onCreate()
  {
    return true;
  }
  
  public ParcelFileDescriptor openFile(Uri paramUri, String paramString)
  {
    AppMethodBeat.i(13315);
    Object localObject = A(paramUri);
    if (localObject == null)
    {
      paramUri = new FileNotFoundException("File not found: ".concat(String.valueOf(paramUri)));
      AppMethodBeat.o(13315);
      throw paramUri;
    }
    localObject = a.ghk().a((Uri)localObject, null);
    if (((a.e)localObject).valid()) {
      try
      {
        paramUri = ((a.e)localObject).Jsh.lT(((a.e)localObject).path, paramString);
        AppMethodBeat.o(13315);
        return paramUri;
      }
      catch (FileNotFoundException paramUri)
      {
        AppMethodBeat.o(13315);
        throw paramUri;
      }
    }
    paramUri = new FileNotFoundException("File not found: ".concat(String.valueOf(paramUri)));
    AppMethodBeat.o(13315);
    throw paramUri;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    AppMethodBeat.i(13310);
    paramString1 = A(paramUri);
    if (paramString1 == null)
    {
      paramUri = new IllegalArgumentException("No mapping found for ".concat(String.valueOf(paramUri)));
      AppMethodBeat.o(13310);
      throw paramUri;
    }
    paramString1 = new e(paramString1);
    paramUri = paramArrayOfString1;
    if (paramArrayOfString1 == null) {
      paramUri = COLUMNS;
    }
    paramArrayOfString2 = new String[paramUri.length];
    paramArrayOfString1 = new Object[paramUri.length];
    int i = 0;
    int m = paramUri.length;
    int j = 0;
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
        paramUri = (String[])Arrays.copyOf(paramArrayOfString2, i);
        paramArrayOfString1 = Arrays.copyOf(paramArrayOfString1, i);
        paramUri = new MatrixCursor(paramUri, 1);
        paramUri.addRow(paramArrayOfString1);
        AppMethodBeat.o(13310);
        return paramUri;
      }
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(13314);
    paramUri = new UnsupportedOperationException("No external updates");
    AppMethodBeat.o(13314);
    throw paramUri;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vfs.VFSFileProvider
 * JD-Core Version:    0.7.0.1
 */