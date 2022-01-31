package com.tencent.mm.vfs;

import android.net.Uri;
import android.net.Uri.Builder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
  implements Comparable<b>
{
  public final Uri mUri;
  private FileSystemManager.d wvt = null;
  
  private b(Uri paramUri)
  {
    if (paramUri == null) {
      throw new NullPointerException("uri == null");
    }
    String str = paramUri.getPath();
    Uri localUri = paramUri;
    if (str != null)
    {
      str = j.h(str, false, false);
      localUri = paramUri;
      if (!paramUri.getPath().equals(str)) {
        localUri = paramUri.buildUpon().path(str).build();
      }
    }
    this.mUri = localUri;
  }
  
  private b(Uri paramUri, String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("name == null");
    }
    Object localObject;
    if (paramUri == null)
    {
      paramUri = new Uri.Builder().path(paramString);
      paramString = paramUri.build();
      localObject = paramString.getPath();
      if (localObject == null) {
        break label111;
      }
      localObject = j.h((String)localObject, false, false);
      if (paramString.getPath().equals(localObject)) {
        break label111;
      }
    }
    label111:
    for (paramUri = paramUri.path((String)localObject).build();; paramUri = paramString)
    {
      this.mUri = paramUri;
      return;
      localObject = paramUri.buildUpon();
      paramUri = (Uri)localObject;
      if (paramString.isEmpty()) {
        break;
      }
      ((Uri.Builder)localObject).appendPath(paramString);
      paramUri = (Uri)localObject;
      break;
    }
  }
  
  public b(b paramb, String paramString) {}
  
  public b(File paramFile, String paramString)
  {
    this(j.aeZ(paramFile.getPath()), paramString);
  }
  
  public b(String paramString)
  {
    this(j.aeZ(paramString));
  }
  
  public b(String paramString1, String paramString2)
  {
    this(j.aeZ(paramString1), paramString2);
  }
  
  private Uri cLp()
  {
    String str = this.mUri.getPath();
    int i = str.length();
    int j = str.lastIndexOf('/');
    if ((j == -1) || (str.charAt(i - 1) == '/')) {
      return null;
    }
    if ((str.indexOf('/') == j) && (str.charAt(0) == '/')) {}
    for (str = str.substring(0, j + 1);; str = str.substring(0, j)) {
      return this.mUri.buildUpon().path(str).build();
    }
  }
  
  public final b[] a(c paramc)
  {
    Object localObject1 = cLo();
    if (!((FileSystemManager.d)localObject1).valid()) {}
    do
    {
      return null;
      localObject2 = ((FileSystemManager.d)localObject1).wva.J(((FileSystemManager.d)localObject1).path, false);
    } while (localObject2 == null);
    localObject1 = new ArrayList();
    Object localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      b localb = new b(this, ((FileSystem.a)((Iterator)localObject2).next()).name);
      if (paramc.e(localb)) {
        ((ArrayList)localObject1).add(localb);
      }
    }
    return (b[])((ArrayList)localObject1).toArray(new b[((ArrayList)localObject1).size()]);
  }
  
  public final String[] a(i parami)
  {
    Object localObject1 = cLo();
    if (!((FileSystemManager.d)localObject1).valid()) {}
    do
    {
      return null;
      localObject2 = ((FileSystemManager.d)localObject1).wva.J(((FileSystemManager.d)localObject1).path, false);
    } while (localObject2 == null);
    localObject1 = new ArrayList();
    Object localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      FileSystem.a locala = (FileSystem.a)((Iterator)localObject2).next();
      if (parami.gx(locala.name)) {
        ((ArrayList)localObject1).add(locala.name);
      }
    }
    return (String[])((ArrayList)localObject1).toArray(new String[((ArrayList)localObject1).size()]);
  }
  
  public final FileSystemManager.d cLo()
  {
    this.wvt = FileSystemManager.cVw().a(this.mUri, this.wvt);
    return this.wvt;
  }
  
  public final b cLq()
  {
    Uri localUri = cLp();
    if (localUri == null) {
      return null;
    }
    return new b(localUri);
  }
  
  public final Uri cLr()
  {
    int j = 0;
    String str1 = this.mUri.getPath();
    int i;
    if (!this.mUri.isAbsolute())
    {
      i = j;
      if (str1.length() > 0)
      {
        i = j;
        if (str1.charAt(0) != '/') {}
      }
    }
    else
    {
      i = 1;
    }
    if (i != 0) {
      return this.mUri;
    }
    String str2 = this.mUri.getPath();
    str1 = System.getProperty("user.dir");
    if (str2.isEmpty()) {}
    for (;;)
    {
      return this.mUri.buildUpon().path(str1).build();
      str1 = str1 + '/' + str2;
    }
  }
  
  public final b cLs()
  {
    return new b(cLr());
  }
  
  public final b[] cLt()
  {
    Object localObject1 = cLo();
    if (!((FileSystemManager.d)localObject1).valid()) {
      return null;
    }
    Object localObject2 = ((FileSystemManager.d)localObject1).wva.J(((FileSystemManager.d)localObject1).path, false);
    if (localObject2 == null) {
      return null;
    }
    localObject1 = new b[((List)localObject2).size()];
    localObject2 = ((List)localObject2).iterator();
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      localObject1[i] = new b(this, ((FileSystem.a)((Iterator)localObject2).next()).name);
      i += 1;
    }
    return localObject1;
  }
  
  public final boolean canRead()
  {
    FileSystemManager.d locald = cLo();
    if (!locald.valid()) {
      return false;
    }
    FileSystem localFileSystem = locald.wva;
    String str = localFileSystem.L(locald.path, false);
    if (str != null) {
      return new File(str).canRead();
    }
    return localFileSystem.exists(locald.path);
  }
  
  public final boolean createNewFile()
  {
    FileSystemManager.d locald = cLo();
    if (!locald.valid()) {
      throw new FileNotFoundException("Cannot resolve path or URI: " + this.mUri);
    }
    if (locald.wva.exists(locald.path)) {
      return false;
    }
    locald.wva.I(locald.path, true).close();
    return true;
  }
  
  public final boolean delete()
  {
    FileSystemManager.d locald = cLo();
    return (locald.valid()) && (locald.wva.jJ(locald.path));
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof b)) {
      return false;
    }
    return this.mUri.equals(((b)paramObject).mUri);
  }
  
  public final boolean exists()
  {
    FileSystemManager.d locald = cLo();
    if (!locald.valid()) {
      return false;
    }
    return locald.wva.exists(locald.path);
  }
  
  public final String getAbsolutePath()
  {
    return j.n(cLr());
  }
  
  public final String getName()
  {
    String str = this.mUri.getPath();
    int i = str.lastIndexOf("/");
    if (i < 0) {
      return str;
    }
    return str.substring(i + 1, str.length());
  }
  
  public final String getParent()
  {
    Uri localUri = cLp();
    if (localUri == null) {
      return null;
    }
    return j.n(localUri);
  }
  
  public final String getPath()
  {
    return j.n(this.mUri);
  }
  
  public final int hashCode()
  {
    return j.n(this.mUri).hashCode() ^ 0x12D591;
  }
  
  public final boolean isDirectory()
  {
    Object localObject = cLo();
    if (!((FileSystemManager.d)localObject).valid()) {}
    do
    {
      return false;
      localObject = ((FileSystemManager.d)localObject).wva.na(((FileSystemManager.d)localObject).path);
    } while ((localObject == null) || (!((FileSystem.a)localObject).wuv));
    return true;
  }
  
  public final boolean isFile()
  {
    Object localObject = cLo();
    if (!((FileSystemManager.d)localObject).valid()) {}
    do
    {
      return false;
      localObject = ((FileSystemManager.d)localObject).wva.na(((FileSystemManager.d)localObject).path);
    } while ((localObject == null) || (((FileSystem.a)localObject).wuv));
    return true;
  }
  
  public final long lastModified()
  {
    Object localObject = cLo();
    if (!((FileSystemManager.d)localObject).valid()) {}
    do
    {
      return 0L;
      localObject = ((FileSystemManager.d)localObject).wva.na(((FileSystemManager.d)localObject).path);
    } while (localObject == null);
    return ((FileSystem.a)localObject).wuu;
  }
  
  public final long length()
  {
    Object localObject = cLo();
    if (!((FileSystemManager.d)localObject).valid()) {}
    do
    {
      return 0L;
      localObject = ((FileSystemManager.d)localObject).wva.na(((FileSystemManager.d)localObject).path);
    } while (localObject == null);
    return ((FileSystem.a)localObject).size;
  }
  
  public final String[] list()
  {
    Object localObject1 = cLo();
    if (!((FileSystemManager.d)localObject1).valid()) {
      return null;
    }
    Object localObject2 = ((FileSystemManager.d)localObject1).wva.J(((FileSystemManager.d)localObject1).path, false);
    if (localObject2 == null) {
      return null;
    }
    localObject1 = new String[((List)localObject2).size()];
    localObject2 = ((List)localObject2).iterator();
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      localObject1[i] = ((FileSystem.a)((Iterator)localObject2).next()).name;
      i += 1;
    }
    return localObject1;
  }
  
  public final boolean mkdirs()
  {
    FileSystemManager.d locald = cLo();
    if (!locald.valid()) {
      return false;
    }
    return locald.wva.nb(locald.path);
  }
  
  public final boolean n(b paramb)
  {
    FileSystemManager.d locald = cLo();
    paramb = paramb.cLo();
    if ((!locald.valid()) || (!paramb.valid())) {}
    while (locald.wva != paramb.wva) {
      return false;
    }
    return locald.wva.aC(locald.path, paramb.path);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.b
 * JD-Core Version:    0.7.0.1
 */