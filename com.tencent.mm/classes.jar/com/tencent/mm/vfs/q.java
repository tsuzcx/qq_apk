package com.tencent.mm.vfs;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.stubs.logger.Log;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class q
{
  private static final Pattern HTN;
  
  static
  {
    AppMethodBeat.i(13334);
    HTN = Pattern.compile("\\$\\{([A-Za-z0-9_]+)\\}");
    AppMethodBeat.o(13334);
  }
  
  public static String B(Uri paramUri)
  {
    AppMethodBeat.i(13324);
    StringBuilder localStringBuilder = new StringBuilder();
    String str = paramUri.getScheme();
    if ((str != null) && (!str.isEmpty())) {
      localStringBuilder.append(str).append(':');
    }
    str = paramUri.getAuthority();
    if ((str != null) && (!str.isEmpty())) {
      localStringBuilder.append("//").append(str);
    }
    paramUri = paramUri.getPath();
    if (paramUri != null) {
      localStringBuilder.append(paramUri);
    }
    paramUri = localStringBuilder.toString();
    AppMethodBeat.o(13324);
    return paramUri;
  }
  
  static String P(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(13325);
    if (paramString == null)
    {
      AppMethodBeat.o(13325);
      return null;
    }
    Matcher localMatcher = HTN.matcher(paramString);
    StringBuilder localStringBuilder;
    int i;
    if (localMatcher.find())
    {
      localStringBuilder = new StringBuilder(paramString.length());
      i = 0;
    }
    for (;;)
    {
      String str1 = localMatcher.group(1);
      String str2 = (String)paramMap.get(str1);
      if (str2 == null)
      {
        Log.d("VFS.Utils", "Macro resolve: " + paramString + " cannot resolve ${" + str1 + "}.");
        AppMethodBeat.o(13325);
        return null;
      }
      localStringBuilder.append(paramString.substring(i, localMatcher.start())).append(str2);
      i = localMatcher.end();
      if (!localMatcher.find())
      {
        paramMap = paramString.substring(i);
        Log.d("VFS.Utils", "Macro resolve: " + paramString + " => " + paramMap);
        AppMethodBeat.o(13325);
        return paramMap;
        Log.d("VFS.Utils", "Macro resolve: " + paramString + " contains no macros.");
        AppMethodBeat.o(13325);
        return paramString;
      }
    }
  }
  
  public static long a(FileSystem paramFileSystem1, String paramString1, FileSystem paramFileSystem2, String paramString2)
  {
    AppMethodBeat.i(13330);
    long l = 0L;
    try
    {
      InputStream localInputStream = paramFileSystem1.openRead(paramString1);
      label33:
      int i;
      closeQuietly(localInputStream);
    }
    finally
    {
      try
      {
        paramString1 = paramFileSystem2.cM(paramString2, false);
      }
      finally
      {
        paramString1 = null;
      }
      try
      {
        paramFileSystem1 = new byte[2048];
        i = localInputStream.read(paramFileSystem1);
        if (i != -1)
        {
          paramString1.write(paramFileSystem1, 0, i);
          l += i;
          break label33;
        }
        closeQuietly(localInputStream);
        closeQuietly(paramString1);
        AppMethodBeat.o(13330);
        return l;
      }
      finally
      {
        break label90;
      }
      paramFileSystem1 = finally;
      paramString1 = null;
      localInputStream = null;
    }
    label90:
    closeQuietly(paramString1);
    AppMethodBeat.o(13330);
    throw paramFileSystem1;
  }
  
  public static void a(Parcel paramParcel, Class<? extends FileSystem> paramClass, int paramInt)
  {
    AppMethodBeat.i(13331);
    paramInt = paramClass.getName().hashCode() ^ paramInt;
    int i = paramParcel.readInt();
    if (i != paramInt)
    {
      paramParcel = new b(paramClass, i, paramInt);
      AppMethodBeat.o(13331);
      throw paramParcel;
    }
    AppMethodBeat.o(13331);
  }
  
  static String aMW(String paramString)
  {
    AppMethodBeat.i(13327);
    int i = paramString.lastIndexOf('/');
    if (i <= 0)
    {
      AppMethodBeat.o(13327);
      return null;
    }
    paramString = paramString.substring(0, i);
    AppMethodBeat.o(13327);
    return paramString;
  }
  
  static String b(Uri paramUri, boolean paramBoolean)
  {
    AppMethodBeat.i(13328);
    paramUri = a.gap().a(paramUri, null);
    if (!paramUri.valid())
    {
      AppMethodBeat.o(13328);
      return null;
    }
    if ((paramUri.HRC.fhA() & 0x2) != 0)
    {
      paramUri = paramUri.HRC.cP(paramUri.path, paramBoolean);
      AppMethodBeat.o(13328);
      return paramUri;
    }
    AppMethodBeat.o(13328);
    return null;
  }
  
  public static <T> List<T> b(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(13333);
    if (paramIterable == null)
    {
      AppMethodBeat.o(13333);
      return null;
    }
    if ((paramIterable instanceof List))
    {
      paramIterable = (List)paramIterable;
      AppMethodBeat.o(13333);
      return paramIterable;
    }
    ArrayList localArrayList = new ArrayList();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      localArrayList.add(paramIterable.next());
    }
    AppMethodBeat.o(13333);
    return localArrayList;
  }
  
  public static void b(Parcel paramParcel, Class<? extends FileSystem> paramClass, int paramInt)
  {
    AppMethodBeat.i(13332);
    paramParcel.writeInt(paramClass.getName().hashCode() ^ paramInt);
    AppMethodBeat.o(13332);
  }
  
  public static void closeQuietly(Closeable paramCloseable)
  {
    AppMethodBeat.i(13329);
    if (paramCloseable == null)
    {
      AppMethodBeat.o(13329);
      return;
    }
    try
    {
      paramCloseable.close();
      AppMethodBeat.o(13329);
      return;
    }
    catch (IOException paramCloseable)
    {
      Log.w("VFS.Utils", "Failed to close object: " + paramCloseable.toString());
      AppMethodBeat.o(13329);
    }
  }
  
  static String l(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    AppMethodBeat.i(13326);
    if (paramString.isEmpty())
    {
      AppMethodBeat.o(13326);
      return paramString;
    }
    int j;
    StringTokenizer localStringTokenizer;
    if (paramString.startsWith("/"))
    {
      j = 1;
      localObject = paramString;
      if (paramString.endsWith("/"))
      {
        localObject = paramString;
        if (paramString.length() > 1) {
          localObject = paramString.substring(0, paramString.length() - 1);
        }
      }
      localStringTokenizer = new StringTokenizer(((String)localObject).substring(j), "/");
      paramString = new ArrayList();
    }
    for (;;)
    {
      if (!localStringTokenizer.hasMoreTokens()) {
        break label208;
      }
      String str = localStringTokenizer.nextToken();
      if ((paramBoolean1) && ("..".equals(str)))
      {
        if (paramString.isEmpty())
        {
          AppMethodBeat.o(13326);
          return null;
          j = 0;
          break;
        }
        paramString.remove(paramString.size() - 1);
        i = 0;
        continue;
      }
      if (((paramBoolean1) && (".".equals(str))) || ("".equals(str))) {
        i = 0;
      } else {
        paramString.add(str);
      }
    }
    label208:
    if (i != 0)
    {
      if (paramBoolean2)
      {
        paramString = ((String)localObject).substring(j);
        AppMethodBeat.o(13326);
        return paramString;
      }
      AppMethodBeat.o(13326);
      return localObject;
    }
    Object localObject = new StringBuilder();
    if ((!paramBoolean2) && (j > 0)) {
      ((StringBuilder)localObject).append('/');
    }
    paramString = paramString.iterator();
    if (paramString.hasNext())
    {
      ((StringBuilder)localObject).append(paramString.next());
      while (paramString.hasNext())
      {
        ((StringBuilder)localObject).append('/');
        ((StringBuilder)localObject).append(paramString.next());
      }
    }
    paramString = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(13326);
    return paramString;
  }
  
  public static Uri parseUri(String paramString)
  {
    AppMethodBeat.i(13323);
    Uri.Builder localBuilder = new Uri.Builder();
    if ((paramString.isEmpty()) || (paramString.charAt(0) == '/'))
    {
      paramString = localBuilder.path(paramString).build();
      AppMethodBeat.o(13323);
      return paramString;
    }
    int j = paramString.indexOf(':');
    if (j < 0) {
      localBuilder.path(paramString);
    }
    for (;;)
    {
      paramString = localBuilder.build();
      AppMethodBeat.o(13323);
      return paramString;
      localBuilder.scheme(paramString.substring(0, j));
      int k = paramString.length();
      if ((k > j + 2) && (paramString.charAt(j + 1) == '/') && (paramString.charAt(j + 2) == '/'))
      {
        int i = j + 3;
        while (i < k) {
          switch (paramString.charAt(i))
          {
          default: 
            i += 1;
          }
        }
        localBuilder.authority(paramString.substring(j + 3, i));
        if (i < k) {
          localBuilder.path(paramString.substring(i + 1));
        }
      }
      else
      {
        localBuilder.path(paramString.substring(j + 1));
      }
    }
  }
  
  static abstract class a<From, To>
    implements Iterator<To>
  {
    private final Iterator<? extends From> HTO;
    protected final boolean HTP;
    private From HTQ;
    private To HTR;
    private To HTS;
    private Iterator<? extends To> HTT;
    
    static
    {
      if (!q.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        return;
      }
    }
    
    a(Iterator<? extends From> paramIterator)
    {
      this.HTO = paramIterator;
      this.HTP = false;
    }
    
    a(Iterator<? extends From> paramIterator, boolean paramBoolean)
    {
      this.HTO = paramIterator;
      this.HTP = paramBoolean;
    }
    
    protected abstract Iterator<? extends To> M(From paramFrom, To paramTo);
    
    protected abstract To convert(From paramFrom);
    
    public boolean hasNext()
    {
      while (this.HTS == null)
      {
        if (this.HTQ != null)
        {
          this.HTT = M(this.HTQ, this.HTR);
          this.HTQ = null;
        }
        if (this.HTT != null)
        {
          if (this.HTT.hasNext())
          {
            this.HTS = this.HTT.next();
            continue;
          }
          this.HTT = null;
          if (this.HTP)
          {
            this.HTS = this.HTR;
            continue;
          }
        }
        assert ((this.HTQ == null) && (this.HTT == null) && (this.HTS == null));
        if (!this.HTO.hasNext())
        {
          this.HTR = null;
          return false;
        }
        this.HTQ = this.HTO.next();
        if (this.HTQ != null)
        {
          this.HTR = convert(this.HTQ);
          if (!this.HTP) {
            this.HTS = this.HTR;
          }
        }
      }
      return true;
    }
    
    public To next()
    {
      if ((this.HTS == null) && (!hasNext())) {
        throw new NoSuchElementException();
      }
      Object localObject = this.HTS;
      this.HTS = null;
      return localObject;
    }
  }
  
  static final class b
    extends RuntimeException
  {
    b(Class<?> paramClass, int paramInt1, int paramInt2)
    {
      super();
      AppMethodBeat.i(13322);
      AppMethodBeat.o(13322);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.q
 * JD-Core Version:    0.7.0.1
 */