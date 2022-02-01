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

public class u
  implements Comparable<u>
{
  private k.f agAc;
  public final Uri mUri;
  
  public u(Uri paramUri)
  {
    AppMethodBeat.i(13230);
    this.agAc = null;
    String str = paramUri.getPath();
    Uri localUri = paramUri;
    if (str != null)
    {
      str = ah.v(str, false, false);
      localUri = paramUri;
      if (!paramUri.getPath().equals(str)) {
        localUri = paramUri.buildUpon().path(str).build();
      }
    }
    this.mUri = localUri;
    AppMethodBeat.o(13230);
  }
  
  private u(Uri paramUri, String paramString)
  {
    AppMethodBeat.i(13235);
    this.agAc = null;
    Object localObject;
    if (paramUri == null)
    {
      paramUri = new Uri.Builder().path(paramString);
      paramString = paramUri.build();
      localObject = paramString.getPath();
      if (localObject == null) {
        break label109;
      }
      localObject = ah.v((String)localObject, false, false);
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
  
  public u(u paramu, String paramString) {}
  
  @Deprecated
  public u(File paramFile)
  {
    this(ah.parseUri(paramFile.getPath()));
    AppMethodBeat.i(13231);
    AppMethodBeat.o(13231);
  }
  
  public u(File paramFile, String paramString) {}
  
  public u(String paramString)
  {
    this(ah.parseUri(paramString));
    AppMethodBeat.i(13229);
    AppMethodBeat.o(13229);
  }
  
  public u(String paramString1, String paramString2) {}
  
  public static u V(File paramFile)
  {
    AppMethodBeat.i(177541);
    if (paramFile != null)
    {
      paramFile = new u(paramFile);
      AppMethodBeat.o(177541);
      return paramFile;
    }
    AppMethodBeat.o(177541);
    return null;
  }
  
  private Uri jKN()
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
  
  public final u[] a(w paramw)
  {
    AppMethodBeat.i(13252);
    if (paramw == null)
    {
      paramw = jKX();
      AppMethodBeat.o(13252);
      return paramw;
    }
    Object localObject1 = jKM();
    if (!((k.f)localObject1).boj())
    {
      AppMethodBeat.o(13252);
      return null;
    }
    Object localObject2 = ((k.f)localObject1).agxM.bDW(((k.f)localObject1).path);
    if (localObject2 == null)
    {
      AppMethodBeat.o(13252);
      return null;
    }
    localObject1 = new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      u localu = new u(this, ((j)((Iterator)localObject2).next()).name);
      if (paramw.accept(localu)) {
        ((ArrayList)localObject1).add(localu);
      }
    }
    paramw = (u[])((ArrayList)localObject1).toArray(new u[0]);
    AppMethodBeat.o(13252);
    return paramw;
  }
  
  public final String[] a(ad paramad)
  {
    AppMethodBeat.i(170162);
    if (paramad == null)
    {
      paramad = jKW();
      AppMethodBeat.o(170162);
      return paramad;
    }
    Object localObject1 = jKM();
    if (!((k.f)localObject1).boj())
    {
      AppMethodBeat.o(170162);
      return null;
    }
    Object localObject2 = ((k.f)localObject1).agxM.bDW(((k.f)localObject1).path);
    if (localObject2 == null)
    {
      AppMethodBeat.o(170162);
      return null;
    }
    localObject1 = new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      j localj = (j)((Iterator)localObject2).next();
      if (paramad.accept(this, localj.name)) {
        ((ArrayList)localObject1).add(localj.name);
      }
    }
    paramad = (String[])((ArrayList)localObject1).toArray(new String[0]);
    AppMethodBeat.o(170162);
    return paramad;
  }
  
  public final boolean am(u paramu)
  {
    AppMethodBeat.i(13255);
    k.f localf = jKM();
    paramu = paramu.jKM();
    if ((!localf.boj()) || (!paramu.boj()))
    {
      AppMethodBeat.o(13255);
      return false;
    }
    try
    {
      boolean bool = paramu.agxM.a(paramu.path, localf.agxM, localf.path);
      AppMethodBeat.o(13255);
      return bool;
    }
    catch (IOException paramu)
    {
      AppMethodBeat.o(13255);
    }
    return false;
  }
  
  public final u[] b(ad paramad)
  {
    AppMethodBeat.i(170163);
    if (paramad == null)
    {
      paramad = jKX();
      AppMethodBeat.o(170163);
      return paramad;
    }
    Object localObject1 = jKM();
    if (!((k.f)localObject1).boj())
    {
      AppMethodBeat.o(170163);
      return null;
    }
    Object localObject2 = ((k.f)localObject1).agxM.bDW(((k.f)localObject1).path);
    if (localObject2 == null)
    {
      AppMethodBeat.o(170163);
      return null;
    }
    localObject1 = new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      j localj = (j)((Iterator)localObject2).next();
      if (paramad.accept(this, localj.name)) {
        ((ArrayList)localObject1).add(new u(this, localj.name));
      }
    }
    paramad = (u[])((ArrayList)localObject1).toArray(new u[0]);
    AppMethodBeat.o(170163);
    return paramad;
  }
  
  public final String coT()
  {
    AppMethodBeat.i(369570);
    String str = ah.v(jKT());
    AppMethodBeat.o(369570);
    return str;
  }
  
  public final boolean diJ()
  {
    AppMethodBeat.i(13256);
    k.f localf = jKM();
    if ((localf.boj()) && (localf.agxM.iP(localf.path)))
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
    if (!(paramObject instanceof u))
    {
      AppMethodBeat.o(13259);
      return false;
    }
    boolean bool = this.mUri.equals(((u)paramObject).mUri);
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
    AppMethodBeat.i(369569);
    String str = ah.v(this.mUri);
    AppMethodBeat.o(369569);
    return str;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(13258);
    int i = ah.v(this.mUri).hashCode();
    AppMethodBeat.o(13258);
    return i ^ 0x12D591;
  }
  
  public final boolean isDirectory()
  {
    AppMethodBeat.i(13246);
    Object localObject = jKM();
    if (!((k.f)localObject).boj())
    {
      AppMethodBeat.o(13246);
      return false;
    }
    localObject = ((k.f)localObject).agxM.bDV(((k.f)localObject).path);
    if ((localObject != null) && (((j)localObject).agxh))
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
  
  public final k.f jKM()
  {
    AppMethodBeat.i(13228);
    this.agAc = k.kMs().a(this.mUri, this.agAc);
    k.f localf = this.agAc;
    AppMethodBeat.o(13228);
    return localf;
  }
  
  public final String jKO()
  {
    AppMethodBeat.i(13239);
    Object localObject = jKN();
    if (localObject == null)
    {
      AppMethodBeat.o(13239);
      return null;
    }
    localObject = ah.v((Uri)localObject);
    AppMethodBeat.o(13239);
    return localObject;
  }
  
  public final u jKP()
  {
    AppMethodBeat.i(13240);
    Object localObject = jKN();
    if (localObject == null)
    {
      AppMethodBeat.o(13240);
      return null;
    }
    localObject = new u((Uri)localObject);
    AppMethodBeat.o(13240);
    return localObject;
  }
  
  public final boolean jKQ()
  {
    AppMethodBeat.i(13241);
    k.f localf = jKM();
    if (!localf.boj())
    {
      AppMethodBeat.o(13241);
      return false;
    }
    FileSystem.b localb = localf.agxM;
    String str = localb.ex(localf.path, false);
    if (str != null)
    {
      bool = new File(str).canRead();
      AppMethodBeat.o(13241);
      return bool;
    }
    boolean bool = localb.bDU(localf.path);
    AppMethodBeat.o(13241);
    return bool;
  }
  
  public final boolean jKR()
  {
    AppMethodBeat.i(170159);
    k.f localf = jKM();
    if (!localf.boj())
    {
      AppMethodBeat.o(170159);
      return false;
    }
    FileSystem.b localb = localf.agxM;
    if ((localb.jKc() & 0x1) == 0)
    {
      AppMethodBeat.o(170159);
      return false;
    }
    String str = localb.ex(localf.path, true);
    if (str != null)
    {
      bool = new File(str).canWrite();
      AppMethodBeat.o(170159);
      return bool;
    }
    boolean bool = localb.bDU(localf.path);
    AppMethodBeat.o(170159);
    return bool;
  }
  
  public final boolean jKS()
  {
    AppMethodBeat.i(13242);
    k.f localf = jKM();
    if (!localf.boj())
    {
      AppMethodBeat.o(13242);
      return false;
    }
    boolean bool = localf.agxM.bDU(localf.path);
    AppMethodBeat.o(13242);
    return bool;
  }
  
  public final Uri jKT()
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
  
  public final u jKU()
  {
    AppMethodBeat.i(13245);
    u localu = new u(jKT());
    AppMethodBeat.o(13245);
    return localu;
  }
  
  public final boolean jKV()
  {
    AppMethodBeat.i(13247);
    Object localObject = jKM();
    if (!((k.f)localObject).boj())
    {
      AppMethodBeat.o(13247);
      return false;
    }
    localObject = ((k.f)localObject).agxM.bDV(((k.f)localObject).path);
    if ((localObject != null) && (!((j)localObject).agxh))
    {
      AppMethodBeat.o(13247);
      return true;
    }
    AppMethodBeat.o(13247);
    return false;
  }
  
  public final String[] jKW()
  {
    AppMethodBeat.i(13250);
    Object localObject1 = jKM();
    if (!((k.f)localObject1).boj())
    {
      AppMethodBeat.o(13250);
      return null;
    }
    Object localObject2 = ((k.f)localObject1).agxM.bDW(((k.f)localObject1).path);
    if (localObject2 == null)
    {
      AppMethodBeat.o(13250);
      return null;
    }
    localObject1 = new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ArrayList)localObject1).add(((j)((Iterator)localObject2).next()).name);
    }
    localObject1 = (String[])((ArrayList)localObject1).toArray(new String[0]);
    AppMethodBeat.o(13250);
    return localObject1;
  }
  
  public final u[] jKX()
  {
    AppMethodBeat.i(13251);
    Object localObject1 = jKM();
    if (!((k.f)localObject1).boj())
    {
      AppMethodBeat.o(13251);
      return null;
    }
    Object localObject2 = ((k.f)localObject1).agxM.bDW(((k.f)localObject1).path);
    if (localObject2 == null)
    {
      AppMethodBeat.o(13251);
      return null;
    }
    localObject1 = new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ArrayList)localObject1).add(new u(this, ((j)((Iterator)localObject2).next()).name));
    }
    localObject1 = (u[])((ArrayList)localObject1).toArray(new u[0]);
    AppMethodBeat.o(13251);
    return localObject1;
  }
  
  public final boolean jKY()
  {
    AppMethodBeat.i(13253);
    k.f localf = jKM();
    if (!localf.boj())
    {
      AppMethodBeat.o(13253);
      return false;
    }
    boolean bool = localf.agxM.bDX(localf.path);
    AppMethodBeat.o(13253);
    return bool;
  }
  
  public final boolean jKZ()
  {
    AppMethodBeat.i(13254);
    Object localObject = jKM();
    if (!((k.f)localObject).boj())
    {
      localObject = new FileNotFoundException("Cannot resolve path or URI: " + this.mUri);
      AppMethodBeat.o(13254);
      throw ((Throwable)localObject);
    }
    if (((k.f)localObject).agxM.bDU(((k.f)localObject).path))
    {
      AppMethodBeat.o(13254);
      return false;
    }
    ((k.f)localObject).agxM.ev(((k.f)localObject).path, false).close();
    AppMethodBeat.o(13254);
    return true;
  }
  
  public final long jLa()
  {
    AppMethodBeat.i(13257);
    Object localObject = jKM();
    if (!((k.f)localObject).boj())
    {
      AppMethodBeat.o(13257);
      return 0L;
    }
    localObject = ((k.f)localObject).agxM.bDY(((k.f)localObject).path);
    if (localObject == null)
    {
      AppMethodBeat.o(13257);
      return 0L;
    }
    long l = ((FileSystem.a)localObject).agxj;
    AppMethodBeat.o(13257);
    return l;
  }
  
  public final long lastModified()
  {
    AppMethodBeat.i(13248);
    Object localObject = jKM();
    if (!((k.f)localObject).boj())
    {
      AppMethodBeat.o(13248);
      return 0L;
    }
    localObject = ((k.f)localObject).agxM.bDV(((k.f)localObject).path);
    if (localObject == null)
    {
      AppMethodBeat.o(13248);
      return 0L;
    }
    long l = ((j)localObject).agxg;
    AppMethodBeat.o(13248);
    return l;
  }
  
  public final long length()
  {
    AppMethodBeat.i(13249);
    Object localObject = jKM();
    if (!((k.f)localObject).boj())
    {
      AppMethodBeat.o(13249);
      return 0L;
    }
    localObject = ((k.f)localObject).agxM.bDV(((k.f)localObject).path);
    if (localObject == null)
    {
      AppMethodBeat.o(13249);
      return 0L;
    }
    long l = ((j)localObject).size;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.u
 * JD-Core Version:    0.7.0.1
 */