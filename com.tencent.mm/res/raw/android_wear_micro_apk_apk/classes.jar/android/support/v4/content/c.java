package android.support.v4.content;

import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

final class c
  implements b
{
  private final String fO;
  private final HashMap<String, File> fP = new HashMap();
  
  public c(String paramString)
  {
    this.fO = paramString;
  }
  
  public final File a(Uri paramUri)
  {
    Object localObject2 = paramUri.getEncodedPath();
    int i = ((String)localObject2).indexOf('/', 1);
    Object localObject1 = Uri.decode(((String)localObject2).substring(1, i));
    localObject2 = Uri.decode(((String)localObject2).substring(i + 1));
    localObject1 = (File)this.fP.get(localObject1);
    if (localObject1 == null) {
      throw new IllegalArgumentException("Unable to find configured root for " + paramUri);
    }
    paramUri = new File((File)localObject1, (String)localObject2);
    try
    {
      localObject2 = paramUri.getCanonicalFile();
      if (!((File)localObject2).getPath().startsWith(((File)localObject1).getPath())) {
        throw new SecurityException("Resolved path jumped beyond configured root");
      }
    }
    catch (IOException localIOException)
    {
      throw new IllegalArgumentException("Failed to resolve canonical path for " + paramUri);
    }
    return localObject2;
  }
  
  public final void a(String paramString, File paramFile)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("Name must not be empty");
    }
    try
    {
      File localFile = paramFile.getCanonicalFile();
      this.fP.put(paramString, localFile);
      return;
    }
    catch (IOException paramString)
    {
      throw new IllegalArgumentException("Failed to resolve canonical path for " + paramFile, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.content.c
 * JD-Core Version:    0.7.0.1
 */