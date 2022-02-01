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

public class k
  implements Comparable<k>
{
  private e.e LHJ;
  public final Uri mUri;
  
  public k(Uri paramUri)
  {
    AppMethodBeat.i(13230);
    this.LHJ = null;
    if (paramUri == null)
    {
      paramUri = new NullPointerException("uri == null");
      AppMethodBeat.o(13230);
      throw paramUri;
    }
    String str = paramUri.getPath();
    Uri localUri = paramUri;
    if (str != null)
    {
      str = w.o(str, false, false);
      localUri = paramUri;
      if (!paramUri.getPath().equals(str)) {
        localUri = paramUri.buildUpon().path(str).build();
      }
    }
    this.mUri = localUri;
    AppMethodBeat.o(13230);
  }
  
  private k(Uri paramUri, String paramString)
  {
    AppMethodBeat.i(13235);
    this.LHJ = null;
    if (paramString == null)
    {
      paramUri = new NullPointerException("name == null");
      AppMethodBeat.o(13235);
      throw paramUri;
    }
    Object localObject;
    if (paramUri == null)
    {
      paramUri = new Uri.Builder().path(paramString);
      paramString = paramUri.build();
      localObject = paramString.getPath();
      if (localObject == null) {
        break label131;
      }
      localObject = w.o((String)localObject, false, false);
      if (paramString.getPath().equals(localObject)) {
        break label131;
      }
    }
    label131:
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
  
  public k(k paramk, String paramString) {}
  
  public k(File paramFile)
  {
    this(w.parseUri(paramFile.getPath()));
    AppMethodBeat.i(13231);
    AppMethodBeat.o(13231);
  }
  
  public k(File paramFile, String paramString) {}
  
  public k(String paramString)
  {
    this(w.parseUri(paramString));
    AppMethodBeat.i(13229);
    AppMethodBeat.o(13229);
  }
  
  public k(String paramString1, String paramString2) {}
  
  public static k W(File paramFile)
  {
    AppMethodBeat.i(177541);
    if (paramFile != null)
    {
      paramFile = new k(paramFile);
      AppMethodBeat.o(177541);
      return paramFile;
    }
    AppMethodBeat.o(177541);
    return null;
  }
  
  private Uri fTf()
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
  
  public final k[] a(m paramm)
  {
    AppMethodBeat.i(13252);
    if (paramm == null)
    {
      paramm = fTj();
      AppMethodBeat.o(13252);
      return paramm;
    }
    Object localObject1 = fTe();
    if (!((e.e)localObject1).valid())
    {
      AppMethodBeat.o(13252);
      return null;
    }
    Object localObject2 = ((e.e)localObject1).LGE.dc(((e.e)localObject1).path, false);
    if (localObject2 == null)
    {
      AppMethodBeat.o(13252);
      return null;
    }
    localObject1 = new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      k localk = new k(this, ((c)((Iterator)localObject2).next()).name);
      if (paramm.accept(localk)) {
        ((ArrayList)localObject1).add(localk);
      }
    }
    paramm = (k[])((ArrayList)localObject1).toArray(new k[0]);
    AppMethodBeat.o(13252);
    return paramm;
  }
  
  public final String[] a(s params)
  {
    AppMethodBeat.i(170162);
    Object localObject1 = fTe();
    if (!((e.e)localObject1).valid())
    {
      AppMethodBeat.o(170162);
      return null;
    }
    Object localObject2 = ((e.e)localObject1).LGE.dc(((e.e)localObject1).path, false);
    if (localObject2 == null)
    {
      AppMethodBeat.o(170162);
      return null;
    }
    localObject1 = new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      c localc = (c)((Iterator)localObject2).next();
      if (params.xH(localc.name)) {
        ((ArrayList)localObject1).add(localc.name);
      }
    }
    params = (String[])((ArrayList)localObject1).toArray(new String[0]);
    AppMethodBeat.o(170162);
    return params;
  }
  
  public final boolean ag(k paramk)
  {
    AppMethodBeat.i(13255);
    e.e locale = fTe();
    paramk = paramk.fTe();
    if ((!locale.valid()) || (!paramk.valid()))
    {
      AppMethodBeat.o(13255);
      return false;
    }
    try
    {
      paramk.LGE.a(paramk.path, locale.LGE, locale.path);
      AppMethodBeat.o(13255);
      return true;
    }
    catch (IOException paramk)
    {
      AppMethodBeat.o(13255);
    }
    return false;
  }
  
  public final k[] b(s params)
  {
    AppMethodBeat.i(170163);
    Object localObject1 = fTe();
    if (!((e.e)localObject1).valid())
    {
      AppMethodBeat.o(170163);
      return null;
    }
    Object localObject2 = ((e.e)localObject1).LGE.dc(((e.e)localObject1).path, false);
    if (localObject2 == null)
    {
      AppMethodBeat.o(170163);
      return null;
    }
    localObject1 = new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      c localc = (c)((Iterator)localObject2).next();
      if (params.xH(localc.name)) {
        ((ArrayList)localObject1).add(new k(this, localc.name));
      }
    }
    params = (k[])((ArrayList)localObject1).toArray(new k[0]);
    AppMethodBeat.o(170163);
    return params;
  }
  
  public final boolean canRead()
  {
    AppMethodBeat.i(13241);
    e.e locale = fTe();
    if (!locale.valid())
    {
      AppMethodBeat.o(13241);
      return false;
    }
    FileSystem.b localb = locale.LGE;
    String str = localb.de(locale.path, false);
    if (str != null)
    {
      bool = new File(str).canRead();
      AppMethodBeat.o(13241);
      return bool;
    }
    boolean bool = localb.aZG(locale.path);
    AppMethodBeat.o(13241);
    return bool;
  }
  
  public final boolean canWrite()
  {
    AppMethodBeat.i(170159);
    e.e locale = fTe();
    if (!locale.valid())
    {
      AppMethodBeat.o(170159);
      return false;
    }
    FileSystem.b localb = locale.LGE;
    if ((localb.fSL() & 0x1) == 0)
    {
      AppMethodBeat.o(170159);
      return false;
    }
    String str = localb.de(locale.path, true);
    if (str != null)
    {
      bool = new File(str).canWrite();
      AppMethodBeat.o(170159);
      return bool;
    }
    boolean bool = localb.aZG(locale.path);
    AppMethodBeat.o(170159);
    return bool;
  }
  
  public final boolean createNewFile()
  {
    AppMethodBeat.i(13254);
    Object localObject = fTe();
    if (!((e.e)localObject).valid())
    {
      localObject = new FileNotFoundException("Cannot resolve path or URI: " + this.mUri);
      AppMethodBeat.o(13254);
      throw ((Throwable)localObject);
    }
    if (((e.e)localObject).LGE.aZG(((e.e)localObject).path))
    {
      AppMethodBeat.o(13254);
      return false;
    }
    ((e.e)localObject).LGE.db(((e.e)localObject).path, false).close();
    AppMethodBeat.o(13254);
    return true;
  }
  
  public final boolean delete()
  {
    AppMethodBeat.i(13256);
    e.e locale = fTe();
    if ((locale.valid()) && (locale.LGE.Dc(locale.path)))
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
    if (!(paramObject instanceof k))
    {
      AppMethodBeat.o(13259);
      return false;
    }
    boolean bool = this.mUri.equals(((k)paramObject).mUri);
    AppMethodBeat.o(13259);
    return bool;
  }
  
  public final boolean exists()
  {
    AppMethodBeat.i(13242);
    e.e locale = fTe();
    if (!locale.valid())
    {
      AppMethodBeat.o(13242);
      return false;
    }
    boolean bool = locale.LGE.aZG(locale.path);
    AppMethodBeat.o(13242);
    return bool;
  }
  
  public final e.e fTe()
  {
    AppMethodBeat.i(13228);
    this.LHJ = e.fSU().a(this.mUri, this.LHJ);
    e.e locale = this.LHJ;
    AppMethodBeat.o(13228);
    return locale;
  }
  
  public final k fTg()
  {
    AppMethodBeat.i(13240);
    Object localObject = fTf();
    if (localObject == null)
    {
      AppMethodBeat.o(13240);
      return null;
    }
    localObject = new k((Uri)localObject);
    AppMethodBeat.o(13240);
    return localObject;
  }
  
  public final Uri fTh()
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
  
  public final k fTi()
  {
    AppMethodBeat.i(13245);
    k localk = new k(fTh());
    AppMethodBeat.o(13245);
    return localk;
  }
  
  public final k[] fTj()
  {
    AppMethodBeat.i(13251);
    Object localObject1 = fTe();
    if (!((e.e)localObject1).valid())
    {
      AppMethodBeat.o(13251);
      return null;
    }
    Object localObject2 = ((e.e)localObject1).LGE.dc(((e.e)localObject1).path, false);
    if (localObject2 == null)
    {
      AppMethodBeat.o(13251);
      return null;
    }
    localObject1 = new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ArrayList)localObject1).add(new k(this, ((c)((Iterator)localObject2).next()).name));
    }
    localObject1 = (k[])((ArrayList)localObject1).toArray(new k[0]);
    AppMethodBeat.o(13251);
    return localObject1;
  }
  
  public final String getAbsolutePath()
  {
    AppMethodBeat.i(224164);
    String str = w.B(fTh());
    AppMethodBeat.o(224164);
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
    str = str.substring(i + 1, str.length());
    AppMethodBeat.o(13237);
    return str;
  }
  
  public final String getParent()
  {
    AppMethodBeat.i(13239);
    Object localObject = fTf();
    if (localObject == null)
    {
      AppMethodBeat.o(13239);
      return null;
    }
    localObject = w.B((Uri)localObject);
    AppMethodBeat.o(13239);
    return localObject;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(224163);
    String str = w.B(this.mUri);
    AppMethodBeat.o(224163);
    return str;
  }
  
  public final long getUsableSpace()
  {
    AppMethodBeat.i(13257);
    Object localObject = fTe();
    if (!((e.e)localObject).valid())
    {
      AppMethodBeat.o(13257);
      return 0L;
    }
    localObject = ((e.e)localObject).LGE.aZF(((e.e)localObject).path);
    if (localObject == null)
    {
      AppMethodBeat.o(13257);
      return 0L;
    }
    long l = ((FileSystem.a)localObject).LGf;
    AppMethodBeat.o(13257);
    return l;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(13258);
    int i = w.B(this.mUri).hashCode();
    AppMethodBeat.o(13258);
    return i ^ 0x12D591;
  }
  
  public final boolean isDirectory()
  {
    AppMethodBeat.i(13246);
    Object localObject = fTe();
    if (!((e.e)localObject).valid())
    {
      AppMethodBeat.o(13246);
      return false;
    }
    localObject = ((e.e)localObject).LGE.aZH(((e.e)localObject).path);
    if ((localObject != null) && (((c)localObject).LGd))
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
    Object localObject = fTe();
    if (!((e.e)localObject).valid())
    {
      AppMethodBeat.o(13247);
      return false;
    }
    localObject = ((e.e)localObject).LGE.aZH(((e.e)localObject).path);
    if ((localObject != null) && (!((c)localObject).LGd))
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
    Object localObject = fTe();
    if (!((e.e)localObject).valid())
    {
      AppMethodBeat.o(13248);
      return 0L;
    }
    localObject = ((e.e)localObject).LGE.aZH(((e.e)localObject).path);
    if (localObject == null)
    {
      AppMethodBeat.o(13248);
      return 0L;
    }
    long l = ((c)localObject).LGc;
    AppMethodBeat.o(13248);
    return l;
  }
  
  public final long length()
  {
    AppMethodBeat.i(13249);
    Object localObject = fTe();
    if (!((e.e)localObject).valid())
    {
      AppMethodBeat.o(13249);
      return 0L;
    }
    localObject = ((e.e)localObject).LGE.aZH(((e.e)localObject).path);
    if (localObject == null)
    {
      AppMethodBeat.o(13249);
      return 0L;
    }
    long l = ((c)localObject).size;
    AppMethodBeat.o(13249);
    return l;
  }
  
  public final String[] list()
  {
    AppMethodBeat.i(13250);
    Object localObject1 = fTe();
    if (!((e.e)localObject1).valid())
    {
      AppMethodBeat.o(13250);
      return null;
    }
    Object localObject2 = ((e.e)localObject1).LGE.dc(((e.e)localObject1).path, false);
    if (localObject2 == null)
    {
      AppMethodBeat.o(13250);
      return null;
    }
    localObject1 = new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ArrayList)localObject1).add(((c)((Iterator)localObject2).next()).name);
    }
    localObject1 = (String[])((ArrayList)localObject1).toArray(new String[0]);
    AppMethodBeat.o(13250);
    return localObject1;
  }
  
  public final boolean mkdir()
  {
    AppMethodBeat.i(224165);
    boolean bool = mkdirs();
    AppMethodBeat.o(224165);
    return bool;
  }
  
  public final boolean mkdirs()
  {
    AppMethodBeat.i(13253);
    e.e locale = fTe();
    if (!locale.valid())
    {
      AppMethodBeat.o(13253);
      return false;
    }
    boolean bool = locale.LGE.aZI(locale.path);
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
 * Qualified Name:     com.tencent.mm.vfs.k
 * JD-Core Version:    0.7.0.1
 */