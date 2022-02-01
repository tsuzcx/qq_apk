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

public class q
  implements Comparable<q>
{
  private h.e YEC;
  final Uri mUri;
  
  public q(Uri paramUri)
  {
    AppMethodBeat.i(13230);
    this.YEC = null;
    String str = paramUri.getPath();
    Uri localUri = paramUri;
    if (str != null)
    {
      str = ad.r(str, false, false);
      localUri = paramUri;
      if (!paramUri.getPath().equals(str)) {
        localUri = paramUri.buildUpon().path(str).build();
      }
    }
    this.mUri = localUri;
    AppMethodBeat.o(13230);
  }
  
  private q(Uri paramUri, String paramString)
  {
    AppMethodBeat.i(13235);
    this.YEC = null;
    Object localObject;
    if (paramUri == null)
    {
      paramUri = new Uri.Builder().path(paramString);
      paramString = paramUri.build();
      localObject = paramString.getPath();
      if (localObject == null) {
        break label109;
      }
      localObject = ad.r((String)localObject, false, false);
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
  
  public q(q paramq, String paramString) {}
  
  @Deprecated
  public q(File paramFile)
  {
    this(ad.parseUri(paramFile.getPath()));
    AppMethodBeat.i(13231);
    AppMethodBeat.o(13231);
  }
  
  public q(File paramFile, String paramString) {}
  
  public q(String paramString)
  {
    this(ad.parseUri(paramString));
    AppMethodBeat.i(13229);
    AppMethodBeat.o(13229);
  }
  
  public q(String paramString1, String paramString2) {}
  
  public static q Q(File paramFile)
  {
    AppMethodBeat.i(177541);
    if (paramFile != null)
    {
      paramFile = new q(paramFile);
      AppMethodBeat.o(177541);
      return paramFile;
    }
    AppMethodBeat.o(177541);
    return null;
  }
  
  private Uri ifF()
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
  
  private Uri ifz()
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
  
  public final q[] a(s params)
  {
    AppMethodBeat.i(13252);
    if (params == null)
    {
      params = ifJ();
      AppMethodBeat.o(13252);
      return params;
    }
    Object localObject1 = ify();
    if (!((h.e)localObject1).fCF())
    {
      AppMethodBeat.o(13252);
      return null;
    }
    Object localObject2 = ((h.e)localObject1).YCO.dJ(((h.e)localObject1).path, false);
    if (localObject2 == null)
    {
      AppMethodBeat.o(13252);
      return null;
    }
    localObject1 = new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      q localq = new q(this, ((f)((Iterator)localObject2).next()).name);
      if (params.accept(localq)) {
        ((ArrayList)localObject1).add(localq);
      }
    }
    params = (q[])((ArrayList)localObject1).toArray(new q[0]);
    AppMethodBeat.o(13252);
    return params;
  }
  
  public final String[] a(z paramz)
  {
    AppMethodBeat.i(170162);
    if (paramz == null)
    {
      paramz = ifI();
      AppMethodBeat.o(170162);
      return paramz;
    }
    Object localObject1 = ify();
    if (!((h.e)localObject1).fCF())
    {
      AppMethodBeat.o(170162);
      return null;
    }
    Object localObject2 = ((h.e)localObject1).YCO.dJ(((h.e)localObject1).path, false);
    if (localObject2 == null)
    {
      AppMethodBeat.o(170162);
      return null;
    }
    localObject1 = new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      f localf = (f)((Iterator)localObject2).next();
      if (paramz.accept(this, localf.name)) {
        ((ArrayList)localObject1).add(localf.name);
      }
    }
    paramz = (String[])((ArrayList)localObject1).toArray(new String[0]);
    AppMethodBeat.o(170162);
    return paramz;
  }
  
  public final boolean aj(q paramq)
  {
    AppMethodBeat.i(13255);
    h.e locale = ify();
    paramq = paramq.ify();
    if ((!locale.fCF()) || (!paramq.fCF()))
    {
      AppMethodBeat.o(13255);
      return false;
    }
    try
    {
      boolean bool = paramq.YCO.a(paramq.path, locale.YCO, locale.path);
      AppMethodBeat.o(13255);
      return bool;
    }
    catch (IOException paramq)
    {
      AppMethodBeat.o(13255);
    }
    return false;
  }
  
  public final q[] b(z paramz)
  {
    AppMethodBeat.i(170163);
    Object localObject1 = ify();
    if (!((h.e)localObject1).fCF())
    {
      AppMethodBeat.o(170163);
      return null;
    }
    Object localObject2 = ((h.e)localObject1).YCO.dJ(((h.e)localObject1).path, false);
    if (localObject2 == null)
    {
      AppMethodBeat.o(170163);
      return null;
    }
    localObject1 = new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      f localf = (f)((Iterator)localObject2).next();
      if (paramz.accept(this, localf.name)) {
        ((ArrayList)localObject1).add(new q(this, localf.name));
      }
    }
    paramz = (q[])((ArrayList)localObject1).toArray(new q[0]);
    AppMethodBeat.o(170163);
    return paramz;
  }
  
  public final String bOF()
  {
    AppMethodBeat.i(185722);
    String str = ad.s(ifF());
    AppMethodBeat.o(185722);
    return str;
  }
  
  public final boolean cFq()
  {
    AppMethodBeat.i(13256);
    h.e locale = ify();
    if ((locale.fCF()) && (locale.YCO.ho(locale.path)))
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
    if (!(paramObject instanceof q))
    {
      AppMethodBeat.o(13259);
      return false;
    }
    boolean bool = this.mUri.equals(((q)paramObject).mUri);
    AppMethodBeat.o(13259);
    return bool;
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
  
  public final String getPath()
  {
    AppMethodBeat.i(185721);
    String str = ad.s(this.mUri);
    AppMethodBeat.o(185721);
    return str;
  }
  
  public final Uri getUri()
  {
    return this.mUri;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(13258);
    int i = ad.s(this.mUri).hashCode();
    AppMethodBeat.o(13258);
    return i ^ 0x12D591;
  }
  
  public final String ifA()
  {
    AppMethodBeat.i(13239);
    Object localObject = ifz();
    if (localObject == null)
    {
      AppMethodBeat.o(13239);
      return null;
    }
    localObject = ad.s((Uri)localObject);
    AppMethodBeat.o(13239);
    return localObject;
  }
  
  public final q ifB()
  {
    AppMethodBeat.i(13240);
    Object localObject = ifz();
    if (localObject == null)
    {
      AppMethodBeat.o(13240);
      return null;
    }
    localObject = new q((Uri)localObject);
    AppMethodBeat.o(13240);
    return localObject;
  }
  
  public final boolean ifC()
  {
    AppMethodBeat.i(13241);
    h.e locale = ify();
    if (!locale.fCF())
    {
      AppMethodBeat.o(13241);
      return false;
    }
    FileSystem.b localb = locale.YCO;
    String str = localb.dL(locale.path, false);
    if (str != null)
    {
      bool = new File(str).canRead();
      AppMethodBeat.o(13241);
      return bool;
    }
    boolean bool = localb.bBB(locale.path);
    AppMethodBeat.o(13241);
    return bool;
  }
  
  public final boolean ifD()
  {
    AppMethodBeat.i(170159);
    h.e locale = ify();
    if (!locale.fCF())
    {
      AppMethodBeat.o(170159);
      return false;
    }
    FileSystem.b localb = locale.YCO;
    if ((localb.ieY() & 0x1) == 0)
    {
      AppMethodBeat.o(170159);
      return false;
    }
    String str = localb.dL(locale.path, true);
    if (str != null)
    {
      bool = new File(str).canWrite();
      AppMethodBeat.o(170159);
      return bool;
    }
    boolean bool = localb.bBB(locale.path);
    AppMethodBeat.o(170159);
    return bool;
  }
  
  public final boolean ifE()
  {
    AppMethodBeat.i(13242);
    h.e locale = ify();
    if (!locale.fCF())
    {
      AppMethodBeat.o(13242);
      return false;
    }
    boolean bool = locale.YCO.bBB(locale.path);
    AppMethodBeat.o(13242);
    return bool;
  }
  
  public final q ifG()
  {
    AppMethodBeat.i(13245);
    q localq = new q(ifF());
    AppMethodBeat.o(13245);
    return localq;
  }
  
  public final boolean ifH()
  {
    AppMethodBeat.i(13247);
    Object localObject = ify();
    if (!((h.e)localObject).fCF())
    {
      AppMethodBeat.o(13247);
      return false;
    }
    localObject = ((h.e)localObject).YCO.bBC(((h.e)localObject).path);
    if ((localObject != null) && (!((f)localObject).YCj))
    {
      AppMethodBeat.o(13247);
      return true;
    }
    AppMethodBeat.o(13247);
    return false;
  }
  
  public final String[] ifI()
  {
    AppMethodBeat.i(13250);
    Object localObject1 = ify();
    if (!((h.e)localObject1).fCF())
    {
      AppMethodBeat.o(13250);
      return null;
    }
    Object localObject2 = ((h.e)localObject1).YCO.dJ(((h.e)localObject1).path, false);
    if (localObject2 == null)
    {
      AppMethodBeat.o(13250);
      return null;
    }
    localObject1 = new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ArrayList)localObject1).add(((f)((Iterator)localObject2).next()).name);
    }
    localObject1 = (String[])((ArrayList)localObject1).toArray(new String[0]);
    AppMethodBeat.o(13250);
    return localObject1;
  }
  
  public final q[] ifJ()
  {
    AppMethodBeat.i(13251);
    Object localObject1 = ify();
    if (!((h.e)localObject1).fCF())
    {
      AppMethodBeat.o(13251);
      return null;
    }
    Object localObject2 = ((h.e)localObject1).YCO.dJ(((h.e)localObject1).path, false);
    if (localObject2 == null)
    {
      AppMethodBeat.o(13251);
      return null;
    }
    localObject1 = new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ArrayList)localObject1).add(new q(this, ((f)((Iterator)localObject2).next()).name));
    }
    localObject1 = (q[])((ArrayList)localObject1).toArray(new q[0]);
    AppMethodBeat.o(13251);
    return localObject1;
  }
  
  public final boolean ifK()
  {
    AppMethodBeat.i(185723);
    boolean bool = ifL();
    AppMethodBeat.o(185723);
    return bool;
  }
  
  public final boolean ifL()
  {
    AppMethodBeat.i(13253);
    h.e locale = ify();
    if (!locale.fCF())
    {
      AppMethodBeat.o(13253);
      return false;
    }
    boolean bool = locale.YCO.bBD(locale.path);
    AppMethodBeat.o(13253);
    return bool;
  }
  
  public final boolean ifM()
  {
    AppMethodBeat.i(13254);
    Object localObject = ify();
    if (!((h.e)localObject).fCF())
    {
      localObject = new FileNotFoundException("Cannot resolve path or URI: " + this.mUri);
      AppMethodBeat.o(13254);
      throw ((Throwable)localObject);
    }
    if (((h.e)localObject).YCO.bBB(((h.e)localObject).path))
    {
      AppMethodBeat.o(13254);
      return false;
    }
    ((h.e)localObject).YCO.dI(((h.e)localObject).path, false).close();
    AppMethodBeat.o(13254);
    return true;
  }
  
  public final long ifN()
  {
    AppMethodBeat.i(13257);
    Object localObject = ify();
    if (!((h.e)localObject).fCF())
    {
      AppMethodBeat.o(13257);
      return 0L;
    }
    localObject = ((h.e)localObject).YCO.bBA(((h.e)localObject).path);
    if (localObject == null)
    {
      AppMethodBeat.o(13257);
      return 0L;
    }
    long l = ((FileSystem.a)localObject).YCl;
    AppMethodBeat.o(13257);
    return l;
  }
  
  final h.e ify()
  {
    AppMethodBeat.i(13228);
    this.YEC = h.iWH().a(this.mUri, this.YEC);
    h.e locale = this.YEC;
    AppMethodBeat.o(13228);
    return locale;
  }
  
  public final boolean isDirectory()
  {
    AppMethodBeat.i(13246);
    Object localObject = ify();
    if (!((h.e)localObject).fCF())
    {
      AppMethodBeat.o(13246);
      return false;
    }
    localObject = ((h.e)localObject).YCO.bBC(((h.e)localObject).path);
    if ((localObject != null) && (((f)localObject).YCj))
    {
      AppMethodBeat.o(13246);
      return true;
    }
    AppMethodBeat.o(13246);
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
    Object localObject = ify();
    if (!((h.e)localObject).fCF())
    {
      AppMethodBeat.o(13248);
      return 0L;
    }
    localObject = ((h.e)localObject).YCO.bBC(((h.e)localObject).path);
    if (localObject == null)
    {
      AppMethodBeat.o(13248);
      return 0L;
    }
    long l = ((f)localObject).YCi;
    AppMethodBeat.o(13248);
    return l;
  }
  
  public final long length()
  {
    AppMethodBeat.i(13249);
    Object localObject = ify();
    if (!((h.e)localObject).fCF())
    {
      AppMethodBeat.o(13249);
      return 0L;
    }
    localObject = ((h.e)localObject).YCO.bBC(((h.e)localObject).path);
    if (localObject == null)
    {
      AppMethodBeat.o(13249);
      return 0L;
    }
    long l = ((f)localObject).size;
    AppMethodBeat.o(13249);
    return l;
  }
  
  public String toString()
  {
    AppMethodBeat.i(13260);
    String str = this.mUri.toString();
    AppMethodBeat.o(13260);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vfs.q
 * JD-Core Version:    0.7.0.1
 */