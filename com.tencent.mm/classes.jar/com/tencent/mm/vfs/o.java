package com.tencent.mm.vfs;

import android.net.Uri;
import android.net.Uri.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class o
  implements Comparable<o>
{
  private g.e RdK;
  public final Uri mUri;
  
  public o(Uri paramUri)
  {
    AppMethodBeat.i(13230);
    this.RdK = null;
    String str = paramUri.getPath();
    Uri localUri = paramUri;
    if (str != null)
    {
      str = aa.q(str, false, false);
      localUri = paramUri;
      if (!paramUri.getPath().equals(str)) {
        localUri = paramUri.buildUpon().path(str).build();
      }
    }
    this.mUri = localUri;
    AppMethodBeat.o(13230);
  }
  
  private o(Uri paramUri, String paramString)
  {
    AppMethodBeat.i(13235);
    this.RdK = null;
    Object localObject;
    if (paramUri == null)
    {
      paramUri = new Uri.Builder().path(paramString);
      paramString = paramUri.build();
      localObject = paramString.getPath();
      if (localObject == null) {
        break label109;
      }
      localObject = aa.q((String)localObject, false, false);
      if (paramString.getPath().equals(localObject)) {
        break label109;
      }
    }
    label109:
    for (paramUri = paramUri.path((String)localObject).build();; paramUri = paramString)
    {
      this.mUri = paramUri;
      AppMethodBeat.o(13235);
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
  
  public o(o paramo, String paramString) {}
  
  @Deprecated
  public o(File paramFile)
  {
    this(aa.parseUri(paramFile.getPath()));
    AppMethodBeat.i(13231);
    AppMethodBeat.o(13231);
  }
  
  public o(File paramFile, String paramString) {}
  
  public o(String paramString)
  {
    this(aa.parseUri(paramString));
    AppMethodBeat.i(13229);
    AppMethodBeat.o(13229);
  }
  
  public o(String paramString1, String paramString2) {}
  
  public static o X(File paramFile)
  {
    AppMethodBeat.i(177541);
    if (paramFile != null)
    {
      paramFile = new o(paramFile);
      AppMethodBeat.o(177541);
      return paramFile;
    }
    AppMethodBeat.o(177541);
    return null;
  }
  
  private Uri hep()
  {
    AppMethodBeat.i(13238);
    Object localObject = this.mUri.getPath();
    int i = ((String)localObject).length();
    int j = ((String)localObject).lastIndexOf('/');
    if ((j == -1) || (((String)localObject).charAt(i - 1) == '/'))
    {
      AppMethodBeat.o(13238);
      return null;
    }
    if ((((String)localObject).indexOf('/') == j) && (((String)localObject).charAt(0) == '/')) {}
    for (localObject = ((String)localObject).substring(0, j + 1);; localObject = ((String)localObject).substring(0, j))
    {
      localObject = this.mUri.buildUpon().path((String)localObject).build();
      AppMethodBeat.o(13238);
      return localObject;
    }
  }
  
  public final o[] a(q paramq)
  {
    AppMethodBeat.i(13252);
    if (paramq == null)
    {
      paramq = het();
      AppMethodBeat.o(13252);
      return paramq;
    }
    Object localObject1 = heo();
    if (!((g.e)localObject1).valid())
    {
      AppMethodBeat.o(13252);
      return null;
    }
    Object localObject2 = ((g.e)localObject1).Rcl.dx(((g.e)localObject1).path, false);
    if (localObject2 == null)
    {
      AppMethodBeat.o(13252);
      return null;
    }
    localObject1 = new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      o localo = new o(this, ((e)((Iterator)localObject2).next()).name);
      if (paramq.accept(localo)) {
        ((ArrayList)localObject1).add(localo);
      }
    }
    paramq = (o[])((ArrayList)localObject1).toArray(new o[0]);
    AppMethodBeat.o(13252);
    return paramq;
  }
  
  public final String[] a(w paramw)
  {
    AppMethodBeat.i(170162);
    if (paramw == null)
    {
      paramw = list();
      AppMethodBeat.o(170162);
      return paramw;
    }
    Object localObject1 = heo();
    if (!((g.e)localObject1).valid())
    {
      AppMethodBeat.o(170162);
      return null;
    }
    Object localObject2 = ((g.e)localObject1).Rcl.dx(((g.e)localObject1).path, false);
    if (localObject2 == null)
    {
      AppMethodBeat.o(170162);
      return null;
    }
    localObject1 = new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      e locale = (e)((Iterator)localObject2).next();
      if (paramw.accept(this, locale.name)) {
        ((ArrayList)localObject1).add(locale.name);
      }
    }
    paramw = (String[])((ArrayList)localObject1).toArray(new String[0]);
    AppMethodBeat.o(170162);
    return paramw;
  }
  
  public final boolean am(o paramo)
  {
    AppMethodBeat.i(13255);
    g.e locale = heo();
    paramo = paramo.heo();
    if ((!locale.valid()) || (!paramo.valid()))
    {
      AppMethodBeat.o(13255);
      return false;
    }
    try
    {
      paramo.Rcl.a(paramo.path, locale.Rcl, locale.path);
      AppMethodBeat.o(13255);
      return true;
    }
    catch (IOException paramo)
    {
      AppMethodBeat.o(13255);
    }
    return false;
  }
  
  public final o[] b(w paramw)
  {
    AppMethodBeat.i(170163);
    Object localObject1 = heo();
    if (!((g.e)localObject1).valid())
    {
      AppMethodBeat.o(170163);
      return null;
    }
    Object localObject2 = ((g.e)localObject1).Rcl.dx(((g.e)localObject1).path, false);
    if (localObject2 == null)
    {
      AppMethodBeat.o(170163);
      return null;
    }
    localObject1 = new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      e locale = (e)((Iterator)localObject2).next();
      if (paramw.accept(this, locale.name)) {
        ((ArrayList)localObject1).add(new o(this, locale.name));
      }
    }
    paramw = (o[])((ArrayList)localObject1).toArray(new o[0]);
    AppMethodBeat.o(170163);
    return paramw;
  }
  
  public final boolean canRead()
  {
    AppMethodBeat.i(13241);
    g.e locale = heo();
    if (!locale.valid())
    {
      AppMethodBeat.o(13241);
      return false;
    }
    FileSystem.b localb = locale.Rcl;
    String str = localb.dz(locale.path, false);
    if (str != null)
    {
      bool = new File(str).canRead();
      AppMethodBeat.o(13241);
      return bool;
    }
    boolean bool = localb.boL(locale.path);
    AppMethodBeat.o(13241);
    return bool;
  }
  
  public final boolean canWrite()
  {
    AppMethodBeat.i(170159);
    g.e locale = heo();
    if (!locale.valid())
    {
      AppMethodBeat.o(170159);
      return false;
    }
    FileSystem.b localb = locale.Rcl;
    if ((localb.hdR() & 0x1) == 0)
    {
      AppMethodBeat.o(170159);
      return false;
    }
    String str = localb.dz(locale.path, true);
    if (str != null)
    {
      bool = new File(str).canWrite();
      AppMethodBeat.o(170159);
      return bool;
    }
    boolean bool = localb.boL(locale.path);
    AppMethodBeat.o(170159);
    return bool;
  }
  
  public final boolean createNewFile()
  {
    AppMethodBeat.i(13254);
    Object localObject = heo();
    if (!((g.e)localObject).valid())
    {
      localObject = new FileNotFoundException("Cannot resolve path or URI: " + this.mUri);
      AppMethodBeat.o(13254);
      throw ((Throwable)localObject);
    }
    if (((g.e)localObject).Rcl.boL(((g.e)localObject).path))
    {
      AppMethodBeat.o(13254);
      return false;
    }
    ((g.e)localObject).Rcl.dw(((g.e)localObject).path, false).close();
    AppMethodBeat.o(13254);
    return true;
  }
  
  public final boolean delete()
  {
    AppMethodBeat.i(13256);
    g.e locale = heo();
    if ((locale.valid()) && (locale.Rcl.gC(locale.path)))
    {
      AppMethodBeat.o(13256);
      return true;
    }
    AppMethodBeat.o(13256);
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(13259);
    if (!(paramObject instanceof o))
    {
      AppMethodBeat.o(13259);
      return false;
    }
    boolean bool = this.mUri.equals(((o)paramObject).mUri);
    AppMethodBeat.o(13259);
    return bool;
  }
  
  public final boolean exists()
  {
    AppMethodBeat.i(13242);
    g.e locale = heo();
    if (!locale.valid())
    {
      AppMethodBeat.o(13242);
      return false;
    }
    boolean bool = locale.Rcl.boL(locale.path);
    AppMethodBeat.o(13242);
    return bool;
  }
  
  public final String getAbsolutePath()
  {
    AppMethodBeat.i(258505);
    String str = aa.z(her());
    AppMethodBeat.o(258505);
    return str;
  }
  
  public final String getName()
  {
    AppMethodBeat.i(13237);
    String str = this.mUri.getPath();
    int i = str.lastIndexOf("/");
    if (i < 0)
    {
      AppMethodBeat.o(13237);
      return str;
    }
    str = str.substring(i + 1);
    AppMethodBeat.o(13237);
    return str;
  }
  
  public final String getParent()
  {
    AppMethodBeat.i(13239);
    Object localObject = hep();
    if (localObject == null)
    {
      AppMethodBeat.o(13239);
      return null;
    }
    localObject = aa.z((Uri)localObject);
    AppMethodBeat.o(13239);
    return localObject;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(258504);
    String str = aa.z(this.mUri);
    AppMethodBeat.o(258504);
    return str;
  }
  
  public final long getUsableSpace()
  {
    AppMethodBeat.i(13257);
    Object localObject = heo();
    if (!((g.e)localObject).valid())
    {
      AppMethodBeat.o(13257);
      return 0L;
    }
    localObject = ((g.e)localObject).Rcl.boK(((g.e)localObject).path);
    if (localObject == null)
    {
      AppMethodBeat.o(13257);
      return 0L;
    }
    long l = ((FileSystem.a)localObject).RbL;
    AppMethodBeat.o(13257);
    return l;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(13258);
    int i = aa.z(this.mUri).hashCode();
    AppMethodBeat.o(13258);
    return i ^ 0x12D591;
  }
  
  public final g.e heo()
  {
    AppMethodBeat.i(13228);
    this.RdK = g.hRR().a(this.mUri, this.RdK);
    g.e locale = this.RdK;
    AppMethodBeat.o(13228);
    return locale;
  }
  
  public final o heq()
  {
    AppMethodBeat.i(13240);
    Object localObject = hep();
    if (localObject == null)
    {
      AppMethodBeat.o(13240);
      return null;
    }
    localObject = new o((Uri)localObject);
    AppMethodBeat.o(13240);
    return localObject;
  }
  
  public final Uri her()
  {
    int j = 0;
    AppMethodBeat.i(13243);
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
      AppMethodBeat.o(13243);
      return localObject;
    }
    String str = this.mUri.getPath();
    localObject = System.getProperty("user.dir");
    if (str.isEmpty()) {}
    for (;;)
    {
      localObject = this.mUri.buildUpon().path((String)localObject).build();
      AppMethodBeat.o(13243);
      return localObject;
      localObject = (String)localObject + '/' + str;
    }
  }
  
  public final o hes()
  {
    AppMethodBeat.i(13245);
    o localo = new o(her());
    AppMethodBeat.o(13245);
    return localo;
  }
  
  public final o[] het()
  {
    AppMethodBeat.i(13251);
    Object localObject1 = heo();
    if (!((g.e)localObject1).valid())
    {
      AppMethodBeat.o(13251);
      return null;
    }
    Object localObject2 = ((g.e)localObject1).Rcl.dx(((g.e)localObject1).path, false);
    if (localObject2 == null)
    {
      AppMethodBeat.o(13251);
      return null;
    }
    localObject1 = new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ArrayList)localObject1).add(new o(this, ((e)((Iterator)localObject2).next()).name));
    }
    localObject1 = (o[])((ArrayList)localObject1).toArray(new o[0]);
    AppMethodBeat.o(13251);
    return localObject1;
  }
  
  public final boolean isDirectory()
  {
    AppMethodBeat.i(13246);
    Object localObject = heo();
    if (!((g.e)localObject).valid())
    {
      AppMethodBeat.o(13246);
      return false;
    }
    localObject = ((g.e)localObject).Rcl.boM(((g.e)localObject).path);
    if ((localObject != null) && (((e)localObject).RbJ))
    {
      AppMethodBeat.o(13246);
      return true;
    }
    AppMethodBeat.o(13246);
    return false;
  }
  
  public final boolean isFile()
  {
    AppMethodBeat.i(13247);
    Object localObject = heo();
    if (!((g.e)localObject).valid())
    {
      AppMethodBeat.o(13247);
      return false;
    }
    localObject = ((g.e)localObject).Rcl.boM(((g.e)localObject).path);
    if ((localObject != null) && (!((e)localObject).RbJ))
    {
      AppMethodBeat.o(13247);
      return true;
    }
    AppMethodBeat.o(13247);
    return false;
  }
  
  public final boolean isHidden()
  {
    AppMethodBeat.i(170161);
    if (this.mUri.getPath().isEmpty())
    {
      AppMethodBeat.o(170161);
      return false;
    }
    boolean bool = getName().startsWith(".");
    AppMethodBeat.o(170161);
    return bool;
  }
  
  public final long lastModified()
  {
    AppMethodBeat.i(13248);
    Object localObject = heo();
    if (!((g.e)localObject).valid())
    {
      AppMethodBeat.o(13248);
      return 0L;
    }
    localObject = ((g.e)localObject).Rcl.boM(((g.e)localObject).path);
    if (localObject == null)
    {
      AppMethodBeat.o(13248);
      return 0L;
    }
    long l = ((e)localObject).RbI;
    AppMethodBeat.o(13248);
    return l;
  }
  
  public final long length()
  {
    AppMethodBeat.i(13249);
    Object localObject = heo();
    if (!((g.e)localObject).valid())
    {
      AppMethodBeat.o(13249);
      return 0L;
    }
    localObject = ((g.e)localObject).Rcl.boM(((g.e)localObject).path);
    if (localObject == null)
    {
      AppMethodBeat.o(13249);
      return 0L;
    }
    long l = ((e)localObject).size;
    AppMethodBeat.o(13249);
    return l;
  }
  
  public final String[] list()
  {
    AppMethodBeat.i(13250);
    Object localObject1 = heo();
    if (!((g.e)localObject1).valid())
    {
      AppMethodBeat.o(13250);
      return null;
    }
    Object localObject2 = ((g.e)localObject1).Rcl.dx(((g.e)localObject1).path, false);
    if (localObject2 == null)
    {
      AppMethodBeat.o(13250);
      return null;
    }
    localObject1 = new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ArrayList)localObject1).add(((e)((Iterator)localObject2).next()).name);
    }
    localObject1 = (String[])((ArrayList)localObject1).toArray(new String[0]);
    AppMethodBeat.o(13250);
    return localObject1;
  }
  
  public final boolean mkdir()
  {
    AppMethodBeat.i(258506);
    boolean bool = mkdirs();
    AppMethodBeat.o(258506);
    return bool;
  }
  
  public final boolean mkdirs()
  {
    AppMethodBeat.i(13253);
    g.e locale = heo();
    if (!locale.valid())
    {
      AppMethodBeat.o(13253);
      return false;
    }
    boolean bool = locale.Rcl.boN(locale.path);
    AppMethodBeat.o(13253);
    return bool;
  }
  
  public String toString()
  {
    AppMethodBeat.i(13260);
    String str = this.mUri.toString();
    AppMethodBeat.o(13260);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.o
 * JD-Core Version:    0.7.0.1
 */