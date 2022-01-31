package com.tencent.mm.vfs;

import android.net.Uri;
import android.net.Uri.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
  implements Comparable<b>
{
  private FileSystemManager.d AQt;
  public final Uri mUri;
  
  private b(Uri paramUri)
  {
    AppMethodBeat.i(54592);
    this.AQt = null;
    if (paramUri == null)
    {
      paramUri = new NullPointerException("uri == null");
      AppMethodBeat.o(54592);
      throw paramUri;
    }
    String str = paramUri.getPath();
    Uri localUri = paramUri;
    if (str != null)
    {
      str = j.l(str, false, false);
      localUri = paramUri;
      if (!paramUri.getPath().equals(str)) {
        localUri = paramUri.buildUpon().path(str).build();
      }
    }
    this.mUri = localUri;
    AppMethodBeat.o(54592);
  }
  
  private b(Uri paramUri, String paramString)
  {
    AppMethodBeat.i(54597);
    this.AQt = null;
    if (paramString == null)
    {
      paramUri = new NullPointerException("name == null");
      AppMethodBeat.o(54597);
      throw paramUri;
    }
    Object localObject;
    if (paramUri == null)
    {
      paramUri = new Uri.Builder().path(paramString);
      paramString = paramUri.build();
      localObject = paramString.getPath();
      if (localObject == null) {
        break label128;
      }
      localObject = j.l((String)localObject, false, false);
      if (paramString.getPath().equals(localObject)) {
        break label128;
      }
    }
    label128:
    for (paramUri = paramUri.path((String)localObject).build();; paramUri = paramString)
    {
      this.mUri = paramUri;
      AppMethodBeat.o(54597);
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
  
  public b(File paramFile)
  {
    this(j.parseUri(paramFile.getPath()));
    AppMethodBeat.i(54593);
    AppMethodBeat.o(54593);
  }
  
  public b(File paramFile, String paramString)
  {
    this(j.parseUri(paramFile.getPath()), paramString);
    AppMethodBeat.i(54596);
    AppMethodBeat.o(54596);
  }
  
  public b(String paramString)
  {
    this(j.parseUri(paramString));
    AppMethodBeat.i(54591);
    AppMethodBeat.o(54591);
  }
  
  public b(String paramString1, String paramString2)
  {
    this(j.parseUri(paramString1), paramString2);
    AppMethodBeat.i(54594);
    AppMethodBeat.o(54594);
  }
  
  private Uri dQH()
  {
    AppMethodBeat.i(54600);
    Object localObject = this.mUri.getPath();
    int i = ((String)localObject).length();
    int j = ((String)localObject).lastIndexOf('/');
    if ((j == -1) || (((String)localObject).charAt(i - 1) == '/'))
    {
      AppMethodBeat.o(54600);
      return null;
    }
    if ((((String)localObject).indexOf('/') == j) && (((String)localObject).charAt(0) == '/')) {}
    for (localObject = ((String)localObject).substring(0, j + 1);; localObject = ((String)localObject).substring(0, j))
    {
      localObject = this.mUri.buildUpon().path((String)localObject).build();
      AppMethodBeat.o(54600);
      return localObject;
    }
  }
  
  public final b[] a(c paramc)
  {
    AppMethodBeat.i(54615);
    Object localObject1 = dQG();
    if (!((FileSystemManager.d)localObject1).valid())
    {
      AppMethodBeat.o(54615);
      return null;
    }
    Object localObject2 = ((FileSystemManager.d)localObject1).AQb.N(((FileSystemManager.d)localObject1).path, false);
    if (localObject2 == null)
    {
      AppMethodBeat.o(54615);
      return null;
    }
    localObject1 = new ArrayList();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      b localb = new b(this, ((FileSystem.a)((Iterator)localObject2).next()).name);
      if (paramc.g(localb)) {
        ((ArrayList)localObject1).add(localb);
      }
    }
    paramc = (b[])((ArrayList)localObject1).toArray(new b[((ArrayList)localObject1).size()]);
    AppMethodBeat.o(54615);
    return paramc;
  }
  
  public final String[] a(i parami)
  {
    AppMethodBeat.i(54613);
    Object localObject1 = dQG();
    if (!((FileSystemManager.d)localObject1).valid())
    {
      AppMethodBeat.o(54613);
      return null;
    }
    Object localObject2 = ((FileSystemManager.d)localObject1).AQb.N(((FileSystemManager.d)localObject1).path, false);
    if (localObject2 == null)
    {
      AppMethodBeat.o(54613);
      return null;
    }
    localObject1 = new ArrayList();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      FileSystem.a locala = (FileSystem.a)((Iterator)localObject2).next();
      if (parami.nf(locala.name)) {
        ((ArrayList)localObject1).add(locala.name);
      }
    }
    parami = (String[])((ArrayList)localObject1).toArray(new String[((ArrayList)localObject1).size()]);
    AppMethodBeat.o(54613);
    return parami;
  }
  
  public final boolean canRead()
  {
    AppMethodBeat.i(54603);
    FileSystemManager.d locald = dQG();
    if (!locald.valid())
    {
      AppMethodBeat.o(54603);
      return false;
    }
    FileSystem localFileSystem = locald.AQb;
    String str = localFileSystem.P(locald.path, false);
    if (str != null)
    {
      bool = new File(str).canRead();
      AppMethodBeat.o(54603);
      return bool;
    }
    boolean bool = localFileSystem.exists(locald.path);
    AppMethodBeat.o(54603);
    return bool;
  }
  
  public final boolean createNewFile()
  {
    AppMethodBeat.i(54617);
    Object localObject = dQG();
    if (!((FileSystemManager.d)localObject).valid())
    {
      localObject = new FileNotFoundException("Cannot resolve path or URI: " + this.mUri);
      AppMethodBeat.o(54617);
      throw ((Throwable)localObject);
    }
    if (((FileSystemManager.d)localObject).AQb.exists(((FileSystemManager.d)localObject).path))
    {
      AppMethodBeat.o(54617);
      return false;
    }
    ((FileSystemManager.d)localObject).AQb.M(((FileSystemManager.d)localObject).path, true).close();
    AppMethodBeat.o(54617);
    return true;
  }
  
  public final FileSystemManager.d dQG()
  {
    AppMethodBeat.i(54590);
    this.AQt = FileSystemManager.dQE().a(this.mUri, this.AQt);
    FileSystemManager.d locald = this.AQt;
    AppMethodBeat.o(54590);
    return locald;
  }
  
  public final b dQI()
  {
    AppMethodBeat.i(54602);
    Object localObject = dQH();
    if (localObject == null)
    {
      AppMethodBeat.o(54602);
      return null;
    }
    localObject = new b((Uri)localObject);
    AppMethodBeat.o(54602);
    return localObject;
  }
  
  public final Uri dQJ()
  {
    int j = 0;
    AppMethodBeat.i(54605);
    Object localObject = this.mUri.getPath();
    int i;
    if (!this.mUri.isAbsolute())
    {
      i = j;
      if (((String)localObject).length() > 0)
      {
        i = j;
        if (((String)localObject).charAt(0) != '/') {}
      }
    }
    else
    {
      i = 1;
    }
    if (i != 0)
    {
      localObject = this.mUri;
      AppMethodBeat.o(54605);
      return localObject;
    }
    String str = this.mUri.getPath();
    localObject = System.getProperty("user.dir");
    if (str.isEmpty()) {}
    for (;;)
    {
      localObject = this.mUri.buildUpon().path((String)localObject).build();
      AppMethodBeat.o(54605);
      return localObject;
      localObject = (String)localObject + '/' + str;
    }
  }
  
  public final b dQK()
  {
    AppMethodBeat.i(54607);
    b localb = new b(dQJ());
    AppMethodBeat.o(54607);
    return localb;
  }
  
  public final b[] dQL()
  {
    AppMethodBeat.i(54614);
    Object localObject1 = dQG();
    if (!((FileSystemManager.d)localObject1).valid())
    {
      AppMethodBeat.o(54614);
      return null;
    }
    Object localObject2 = ((FileSystemManager.d)localObject1).AQb.N(((FileSystemManager.d)localObject1).path, false);
    if (localObject2 == null)
    {
      AppMethodBeat.o(54614);
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
    AppMethodBeat.o(54614);
    return localObject1;
  }
  
  public final boolean delete()
  {
    AppMethodBeat.i(54619);
    FileSystemManager.d locald = dQG();
    if ((locald.valid()) && (locald.AQb.qD(locald.path)))
    {
      AppMethodBeat.o(54619);
      return true;
    }
    AppMethodBeat.o(54619);
    return false;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(54621);
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(54621);
      return false;
    }
    boolean bool = this.mUri.equals(((b)paramObject).mUri);
    AppMethodBeat.o(54621);
    return bool;
  }
  
  public final boolean exists()
  {
    AppMethodBeat.i(54604);
    FileSystemManager.d locald = dQG();
    if (!locald.valid())
    {
      AppMethodBeat.o(54604);
      return false;
    }
    boolean bool = locald.AQb.exists(locald.path);
    AppMethodBeat.o(54604);
    return bool;
  }
  
  public final String getAbsolutePath()
  {
    AppMethodBeat.i(156748);
    String str = j.p(dQJ());
    AppMethodBeat.o(156748);
    return str;
  }
  
  public final String getName()
  {
    AppMethodBeat.i(54599);
    String str = this.mUri.getPath();
    int i = str.lastIndexOf("/");
    if (i < 0)
    {
      AppMethodBeat.o(54599);
      return str;
    }
    str = str.substring(i + 1, str.length());
    AppMethodBeat.o(54599);
    return str;
  }
  
  public final String getParent()
  {
    AppMethodBeat.i(54601);
    Object localObject = dQH();
    if (localObject == null)
    {
      AppMethodBeat.o(54601);
      return null;
    }
    localObject = j.p((Uri)localObject);
    AppMethodBeat.o(54601);
    return localObject;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(156747);
    String str = j.p(this.mUri);
    AppMethodBeat.o(156747);
    return str;
  }
  
  public final long getUsableSpace()
  {
    AppMethodBeat.i(154896);
    Object localObject = dQG();
    if (!((FileSystemManager.d)localObject).valid())
    {
      AppMethodBeat.o(154896);
      return 0L;
    }
    localObject = ((FileSystemManager.d)localObject).AQb.uk(((FileSystemManager.d)localObject).path);
    if (localObject == null)
    {
      AppMethodBeat.o(154896);
      return 0L;
    }
    long l = ((FileSystem.b)localObject).APw;
    AppMethodBeat.o(154896);
    return l;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(54620);
    int i = j.p(this.mUri).hashCode();
    AppMethodBeat.o(54620);
    return i ^ 0x12D591;
  }
  
  public final boolean isDirectory()
  {
    AppMethodBeat.i(54608);
    Object localObject = dQG();
    if (!((FileSystemManager.d)localObject).valid())
    {
      AppMethodBeat.o(54608);
      return false;
    }
    localObject = ((FileSystemManager.d)localObject).AQb.ul(((FileSystemManager.d)localObject).path);
    if ((localObject != null) && (((FileSystem.a)localObject).APu))
    {
      AppMethodBeat.o(54608);
      return true;
    }
    AppMethodBeat.o(54608);
    return false;
  }
  
  public final boolean isFile()
  {
    AppMethodBeat.i(54609);
    Object localObject = dQG();
    if (!((FileSystemManager.d)localObject).valid())
    {
      AppMethodBeat.o(54609);
      return false;
    }
    localObject = ((FileSystemManager.d)localObject).AQb.ul(((FileSystemManager.d)localObject).path);
    if ((localObject != null) && (!((FileSystem.a)localObject).APu))
    {
      AppMethodBeat.o(54609);
      return true;
    }
    AppMethodBeat.o(54609);
    return false;
  }
  
  public final long lastModified()
  {
    AppMethodBeat.i(54610);
    Object localObject = dQG();
    if (!((FileSystemManager.d)localObject).valid())
    {
      AppMethodBeat.o(54610);
      return 0L;
    }
    localObject = ((FileSystemManager.d)localObject).AQb.ul(((FileSystemManager.d)localObject).path);
    if (localObject == null)
    {
      AppMethodBeat.o(54610);
      return 0L;
    }
    long l = ((FileSystem.a)localObject).APt;
    AppMethodBeat.o(54610);
    return l;
  }
  
  public final long length()
  {
    AppMethodBeat.i(54611);
    Object localObject = dQG();
    if (!((FileSystemManager.d)localObject).valid())
    {
      AppMethodBeat.o(54611);
      return 0L;
    }
    localObject = ((FileSystemManager.d)localObject).AQb.ul(((FileSystemManager.d)localObject).path);
    if (localObject == null)
    {
      AppMethodBeat.o(54611);
      return 0L;
    }
    long l = ((FileSystem.a)localObject).size;
    AppMethodBeat.o(54611);
    return l;
  }
  
  public final String[] list()
  {
    AppMethodBeat.i(54612);
    Object localObject1 = dQG();
    if (!((FileSystemManager.d)localObject1).valid())
    {
      AppMethodBeat.o(54612);
      return null;
    }
    Object localObject2 = ((FileSystemManager.d)localObject1).AQb.N(((FileSystemManager.d)localObject1).path, false);
    if (localObject2 == null)
    {
      AppMethodBeat.o(54612);
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
    AppMethodBeat.o(54612);
    return localObject1;
  }
  
  public final boolean mkdirs()
  {
    AppMethodBeat.i(54616);
    FileSystemManager.d locald = dQG();
    if (!locald.valid())
    {
      AppMethodBeat.o(54616);
      return false;
    }
    boolean bool = locald.AQb.um(locald.path);
    AppMethodBeat.o(54616);
    return bool;
  }
  
  public final boolean p(b paramb)
  {
    AppMethodBeat.i(54618);
    FileSystemManager.d locald = dQG();
    paramb = paramb.dQG();
    if ((!locald.valid()) || (!paramb.valid()))
    {
      AppMethodBeat.o(54618);
      return false;
    }
    if (locald.AQb != paramb.AQb)
    {
      AppMethodBeat.o(54618);
      return false;
    }
    boolean bool = locald.AQb.aV(locald.path, paramb.path);
    AppMethodBeat.o(54618);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.b
 * JD-Core Version:    0.7.0.1
 */