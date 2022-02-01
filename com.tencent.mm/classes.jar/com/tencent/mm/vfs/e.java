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

public class e
  implements Comparable<e>
{
  private a.e Llb;
  public final Uri mUri;
  
  public e(Uri paramUri)
  {
    AppMethodBeat.i(13230);
    this.Llb = null;
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
      str = q.o(str, false, false);
      localUri = paramUri;
      if (!paramUri.getPath().equals(str)) {
        localUri = paramUri.buildUpon().path(str).build();
      }
    }
    this.mUri = localUri;
    AppMethodBeat.o(13230);
  }
  
  private e(Uri paramUri, String paramString)
  {
    AppMethodBeat.i(13235);
    this.Llb = null;
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
      localObject = q.o((String)localObject, false, false);
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
  
  public e(e parame, String paramString) {}
  
  public e(File paramFile)
  {
    this(q.parseUri(paramFile.getPath()));
    AppMethodBeat.i(13231);
    AppMethodBeat.o(13231);
  }
  
  public e(File paramFile, String paramString) {}
  
  public e(String paramString)
  {
    this(q.parseUri(paramString));
    AppMethodBeat.i(13229);
    AppMethodBeat.o(13229);
  }
  
  public e(String paramString1, String paramString2) {}
  
  public static e X(File paramFile)
  {
    AppMethodBeat.i(177541);
    if (paramFile != null)
    {
      paramFile = new e(paramFile);
      AppMethodBeat.o(177541);
      return paramFile;
    }
    AppMethodBeat.o(177541);
    return null;
  }
  
  private Uri fOI()
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
  
  public final e[] a(g paramg)
  {
    AppMethodBeat.i(13252);
    if (paramg == null)
    {
      paramg = fOM();
      AppMethodBeat.o(13252);
      return paramg;
    }
    Object localObject1 = fOH();
    if (!((a.e)localObject1).valid())
    {
      AppMethodBeat.o(13252);
      return null;
    }
    Object localObject2 = ((a.e)localObject1).LjM.cY(((a.e)localObject1).path, false);
    if (localObject2 == null)
    {
      AppMethodBeat.o(13252);
      return null;
    }
    localObject1 = new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      e locale = new e(this, ((FileSystem.a)((Iterator)localObject2).next()).name);
      if (paramg.accept(locale)) {
        ((ArrayList)localObject1).add(locale);
      }
    }
    paramg = (e[])((ArrayList)localObject1).toArray(new e[0]);
    AppMethodBeat.o(13252);
    return paramg;
  }
  
  public final String[] a(m paramm)
  {
    AppMethodBeat.i(170162);
    Object localObject1 = fOH();
    if (!((a.e)localObject1).valid())
    {
      AppMethodBeat.o(170162);
      return null;
    }
    Object localObject2 = ((a.e)localObject1).LjM.cY(((a.e)localObject1).path, false);
    if (localObject2 == null)
    {
      AppMethodBeat.o(170162);
      return null;
    }
    localObject1 = new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      FileSystem.a locala = (FileSystem.a)((Iterator)localObject2).next();
      if (paramm.wY(locala.name)) {
        ((ArrayList)localObject1).add(locala.name);
      }
    }
    paramm = (String[])((ArrayList)localObject1).toArray(new String[0]);
    AppMethodBeat.o(170162);
    return paramm;
  }
  
  public final boolean ag(e parame)
  {
    AppMethodBeat.i(13255);
    a.e locale = fOH();
    parame = parame.fOH();
    if ((!locale.valid()) || (!parame.valid()))
    {
      AppMethodBeat.o(13255);
      return false;
    }
    try
    {
      parame.LjM.a(parame.path, locale.LjM, locale.path);
      AppMethodBeat.o(13255);
      return true;
    }
    catch (IOException parame)
    {
      AppMethodBeat.o(13255);
    }
    return false;
  }
  
  public final e[] b(m paramm)
  {
    AppMethodBeat.i(170163);
    Object localObject1 = fOH();
    if (!((a.e)localObject1).valid())
    {
      AppMethodBeat.o(170163);
      return null;
    }
    Object localObject2 = ((a.e)localObject1).LjM.cY(((a.e)localObject1).path, false);
    if (localObject2 == null)
    {
      AppMethodBeat.o(170163);
      return null;
    }
    localObject1 = new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      FileSystem.a locala = (FileSystem.a)((Iterator)localObject2).next();
      if (paramm.wY(locala.name)) {
        ((ArrayList)localObject1).add(new e(this, locala.name));
      }
    }
    paramm = (e[])((ArrayList)localObject1).toArray(new e[0]);
    AppMethodBeat.o(170163);
    return paramm;
  }
  
  public final boolean canRead()
  {
    AppMethodBeat.i(13241);
    a.e locale = fOH();
    if (!locale.valid())
    {
      AppMethodBeat.o(13241);
      return false;
    }
    FileSystem localFileSystem = locale.LjM;
    String str = localFileSystem.da(locale.path, false);
    if (str != null)
    {
      bool = new File(str).canRead();
      AppMethodBeat.o(13241);
      return bool;
    }
    boolean bool = localFileSystem.aYe(locale.path);
    AppMethodBeat.o(13241);
    return bool;
  }
  
  public final boolean canWrite()
  {
    AppMethodBeat.i(170159);
    a.e locale = fOH();
    if (!locale.valid())
    {
      AppMethodBeat.o(170159);
      return false;
    }
    FileSystem localFileSystem = locale.LjM;
    if ((localFileSystem.fOp() & 0x1) == 0)
    {
      AppMethodBeat.o(170159);
      return false;
    }
    String str = localFileSystem.da(locale.path, true);
    if (str != null)
    {
      bool = new File(str).canWrite();
      AppMethodBeat.o(170159);
      return bool;
    }
    boolean bool = localFileSystem.aYe(locale.path);
    AppMethodBeat.o(170159);
    return bool;
  }
  
  public final boolean createNewFile()
  {
    AppMethodBeat.i(13254);
    Object localObject = fOH();
    if (!((a.e)localObject).valid())
    {
      localObject = new FileNotFoundException("Cannot resolve path or URI: " + this.mUri);
      AppMethodBeat.o(13254);
      throw ((Throwable)localObject);
    }
    if (((a.e)localObject).LjM.aYe(((a.e)localObject).path))
    {
      AppMethodBeat.o(13254);
      return false;
    }
    ((a.e)localObject).LjM.cX(((a.e)localObject).path, false).close();
    AppMethodBeat.o(13254);
    return true;
  }
  
  public final boolean delete()
  {
    AppMethodBeat.i(13256);
    a.e locale = fOH();
    if ((locale.valid()) && (locale.LjM.CA(locale.path)))
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
    if (!(paramObject instanceof e))
    {
      AppMethodBeat.o(13259);
      return false;
    }
    boolean bool = this.mUri.equals(((e)paramObject).mUri);
    AppMethodBeat.o(13259);
    return bool;
  }
  
  public final boolean exists()
  {
    AppMethodBeat.i(13242);
    a.e locale = fOH();
    if (!locale.valid())
    {
      AppMethodBeat.o(13242);
      return false;
    }
    boolean bool = locale.LjM.aYe(locale.path);
    AppMethodBeat.o(13242);
    return bool;
  }
  
  public final a.e fOH()
  {
    AppMethodBeat.i(13228);
    this.Llb = a.gzU().a(this.mUri, this.Llb);
    a.e locale = this.Llb;
    AppMethodBeat.o(13228);
    return locale;
  }
  
  public final e fOJ()
  {
    AppMethodBeat.i(13240);
    Object localObject = fOI();
    if (localObject == null)
    {
      AppMethodBeat.o(13240);
      return null;
    }
    localObject = new e((Uri)localObject);
    AppMethodBeat.o(13240);
    return localObject;
  }
  
  public final Uri fOK()
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
  
  public final e fOL()
  {
    AppMethodBeat.i(13245);
    e locale = new e(fOK());
    AppMethodBeat.o(13245);
    return locale;
  }
  
  public final e[] fOM()
  {
    AppMethodBeat.i(13251);
    Object localObject1 = fOH();
    if (!((a.e)localObject1).valid())
    {
      AppMethodBeat.o(13251);
      return null;
    }
    Object localObject2 = ((a.e)localObject1).LjM.cY(((a.e)localObject1).path, false);
    if (localObject2 == null)
    {
      AppMethodBeat.o(13251);
      return null;
    }
    localObject1 = new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ArrayList)localObject1).add(new e(this, ((FileSystem.a)((Iterator)localObject2).next()).name));
    }
    localObject1 = (e[])((ArrayList)localObject1).toArray(new e[0]);
    AppMethodBeat.o(13251);
    return localObject1;
  }
  
  public final String getAbsolutePath()
  {
    AppMethodBeat.i(221179);
    String str = q.B(fOK());
    AppMethodBeat.o(221179);
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
    Object localObject = fOI();
    if (localObject == null)
    {
      AppMethodBeat.o(13239);
      return null;
    }
    localObject = q.B((Uri)localObject);
    AppMethodBeat.o(13239);
    return localObject;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(221178);
    String str = q.B(this.mUri);
    AppMethodBeat.o(221178);
    return str;
  }
  
  public final long getUsableSpace()
  {
    AppMethodBeat.i(13257);
    Object localObject = fOH();
    if (!((a.e)localObject).valid())
    {
      AppMethodBeat.o(13257);
      return 0L;
    }
    localObject = ((a.e)localObject).LjM.aYd(((a.e)localObject).path);
    if (localObject == null)
    {
      AppMethodBeat.o(13257);
      return 0L;
    }
    long l = ((FileSystem.b)localObject).LjN;
    AppMethodBeat.o(13257);
    return l;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(13258);
    int i = q.B(this.mUri).hashCode();
    AppMethodBeat.o(13258);
    return i ^ 0x12D591;
  }
  
  public final boolean isDirectory()
  {
    AppMethodBeat.i(13246);
    Object localObject = fOH();
    if (!((a.e)localObject).valid())
    {
      AppMethodBeat.o(13246);
      return false;
    }
    localObject = ((a.e)localObject).LjM.aYf(((a.e)localObject).path);
    if ((localObject != null) && (((FileSystem.a)localObject).LjL))
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
    Object localObject = fOH();
    if (!((a.e)localObject).valid())
    {
      AppMethodBeat.o(13247);
      return false;
    }
    localObject = ((a.e)localObject).LjM.aYf(((a.e)localObject).path);
    if ((localObject != null) && (!((FileSystem.a)localObject).LjL))
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
    Object localObject = fOH();
    if (!((a.e)localObject).valid())
    {
      AppMethodBeat.o(13248);
      return 0L;
    }
    localObject = ((a.e)localObject).LjM.aYf(((a.e)localObject).path);
    if (localObject == null)
    {
      AppMethodBeat.o(13248);
      return 0L;
    }
    long l = ((FileSystem.a)localObject).LjK;
    AppMethodBeat.o(13248);
    return l;
  }
  
  public final long length()
  {
    AppMethodBeat.i(13249);
    Object localObject = fOH();
    if (!((a.e)localObject).valid())
    {
      AppMethodBeat.o(13249);
      return 0L;
    }
    localObject = ((a.e)localObject).LjM.aYf(((a.e)localObject).path);
    if (localObject == null)
    {
      AppMethodBeat.o(13249);
      return 0L;
    }
    long l = ((FileSystem.a)localObject).size;
    AppMethodBeat.o(13249);
    return l;
  }
  
  public final String[] list()
  {
    AppMethodBeat.i(13250);
    Object localObject1 = fOH();
    if (!((a.e)localObject1).valid())
    {
      AppMethodBeat.o(13250);
      return null;
    }
    Object localObject2 = ((a.e)localObject1).LjM.cY(((a.e)localObject1).path, false);
    if (localObject2 == null)
    {
      AppMethodBeat.o(13250);
      return null;
    }
    localObject1 = new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ArrayList)localObject1).add(((FileSystem.a)((Iterator)localObject2).next()).name);
    }
    localObject1 = (String[])((ArrayList)localObject1).toArray(new String[0]);
    AppMethodBeat.o(13250);
    return localObject1;
  }
  
  public final boolean mkdir()
  {
    AppMethodBeat.i(221180);
    boolean bool = mkdirs();
    AppMethodBeat.o(221180);
    return bool;
  }
  
  public final boolean mkdirs()
  {
    AppMethodBeat.i(13253);
    a.e locale = fOH();
    if (!locale.valid())
    {
      AppMethodBeat.o(13253);
      return false;
    }
    boolean bool = locale.LjM.aYg(locale.path);
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
 * Qualified Name:     com.tencent.mm.vfs.e
 * JD-Core Version:    0.7.0.1
 */