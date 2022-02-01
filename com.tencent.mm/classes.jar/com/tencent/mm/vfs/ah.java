package com.tencent.mm.vfs;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.a.a;
import com.tencent.mm.vfs.a.a.a;
import com.tencent.stubs.logger.Log;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public final class ah
{
  private static final Pattern agBj;
  
  static
  {
    AppMethodBeat.i(13334);
    agBj = Pattern.compile("\\$\\{([A-Za-z0-9_]+)\\}");
    AppMethodBeat.o(13334);
  }
  
  /* Error */
  public static long a(FileSystem.b paramb1, String paramString1, FileSystem.b paramb2, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: ldc 41
    //   5: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: aload_1
    //   10: invokeinterface 47 2 0
    //   15: astore 7
    //   17: aload_2
    //   18: aload_3
    //   19: iconst_0
    //   20: invokeinterface 51 3 0
    //   25: astore_1
    //   26: aload_0
    //   27: invokeinterface 55 1 0
    //   32: aload_2
    //   33: invokeinterface 55 1 0
    //   38: iand
    //   39: iconst_2
    //   40: iand
    //   41: ifeq +6 -> 47
    //   44: iconst_1
    //   45: istore 4
    //   47: iload 4
    //   49: ifeq +67 -> 116
    //   52: sipush 8192
    //   55: invokestatic 61	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   58: astore_0
    //   59: goto +99 -> 158
    //   62: aload 7
    //   64: aload_0
    //   65: invokeinterface 67 2 0
    //   70: iflt +56 -> 126
    //   73: aload_0
    //   74: invokevirtual 71	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   77: pop
    //   78: lload 5
    //   80: aload_1
    //   81: aload_0
    //   82: invokeinterface 76 2 0
    //   87: i2l
    //   88: ladd
    //   89: lstore 5
    //   91: aload_0
    //   92: invokevirtual 79	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   95: pop
    //   96: goto -34 -> 62
    //   99: astore_0
    //   100: aload 7
    //   102: invokestatic 83	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
    //   105: aload_1
    //   106: invokestatic 83	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
    //   109: ldc 41
    //   111: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: aload_0
    //   115: athrow
    //   116: sipush 8192
    //   119: invokestatic 86	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   122: astore_0
    //   123: goto +35 -> 158
    //   126: aload 7
    //   128: invokestatic 83	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
    //   131: aload_1
    //   132: invokestatic 83	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
    //   135: ldc 41
    //   137: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   140: lload 5
    //   142: lreturn
    //   143: astore_0
    //   144: aconst_null
    //   145: astore_1
    //   146: aconst_null
    //   147: astore 7
    //   149: goto -49 -> 100
    //   152: astore_0
    //   153: aconst_null
    //   154: astore_1
    //   155: goto -55 -> 100
    //   158: lconst_0
    //   159: lstore 5
    //   161: goto -99 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	paramb1	FileSystem.b
    //   0	164	1	paramString1	String
    //   0	164	2	paramb2	FileSystem.b
    //   0	164	3	paramString2	String
    //   1	47	4	i	int
    //   78	1	5	localObject	Object
    //   89	71	5	l	long
    //   15	133	7	localReadableByteChannel	java.nio.channels.ReadableByteChannel
    // Exception table:
    //   from	to	target	type
    //   26	44	99	finally
    //   52	59	99	finally
    //   62	96	99	finally
    //   116	123	99	finally
    //   8	17	143	finally
    //   17	26	152	finally
  }
  
  public static Iterable<j> a(FileSystem.b paramb, String paramString)
  {
    AppMethodBeat.i(238147);
    paramb = a(paramb, paramString, false, null);
    AppMethodBeat.o(238147);
    return paramb;
  }
  
  public static Iterable<j> a(FileSystem.b paramb, String paramString, boolean paramBoolean, a parama)
  {
    AppMethodBeat.i(238158);
    paramString = paramb.bDW(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(238158);
      return null;
    }
    paramb = new a(paramString, new b(paramb, paramBoolean, parama));
    AppMethodBeat.o(238158);
    return paramb;
  }
  
  public static void a(Parcel paramParcel, Class<? extends FileSystem> paramClass, int paramInt)
  {
    AppMethodBeat.i(13331);
    paramInt = paramClass.getName().hashCode() ^ paramInt;
    int i = paramParcel.readInt();
    if (i != paramInt)
    {
      paramParcel = new ah.c(paramClass, i, paramInt);
      AppMethodBeat.o(13331);
      throw paramParcel;
    }
    AppMethodBeat.o(13331);
  }
  
  public static void a(FileSystem.b paramb, d paramd)
  {
    AppMethodBeat.i(238189);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramb);
    do
    {
      paramb = (FileSystem.b)localArrayList.remove(localArrayList.size() - 1);
      if (paramb != null)
      {
        if (paramd.a(paramb))
        {
          AppMethodBeat.o(238189);
          return;
        }
        if ((paramb instanceof f))
        {
          paramb = ((f)paramb).jKf();
          int i = paramb.size() - 1;
          while (i >= 0)
          {
            localArrayList.add(paramb.get(i));
            i -= 1;
          }
        }
      }
    } while (!localArrayList.isEmpty());
    AppMethodBeat.o(238189);
  }
  
  public static String aA(Map<String, Object> paramMap, String paramString)
  {
    AppMethodBeat.i(238172);
    paramMap = paramMap.get(paramString);
    if ((paramMap instanceof String))
    {
      paramMap = (String)paramMap;
      AppMethodBeat.o(238172);
      return paramMap;
    }
    if ((paramMap instanceof String[]))
    {
      paramMap = ((String[])(String[])paramMap)[0];
      AppMethodBeat.o(238172);
      return paramMap;
    }
    AppMethodBeat.o(238172);
    return null;
  }
  
  public static Iterable<j> b(FileSystem.b paramb, String paramString)
  {
    AppMethodBeat.i(238153);
    paramb = a(paramb, paramString, true, null);
    AppMethodBeat.o(238153);
    return paramb;
  }
  
  static String b(Uri paramUri, boolean paramBoolean)
  {
    AppMethodBeat.i(13328);
    paramUri = k.kMs().a(paramUri, null);
    if (!paramUri.boj())
    {
      AppMethodBeat.o(13328);
      return null;
    }
    if ((paramUri.agxM.jKc() & 0x2) != 0)
    {
      paramUri = paramUri.agxM.ex(paramUri.path, paramBoolean);
      AppMethodBeat.o(13328);
      return paramUri;
    }
    AppMethodBeat.o(13328);
    return null;
  }
  
  public static void b(Parcel paramParcel, Class<? extends FileSystem> paramClass, int paramInt)
  {
    AppMethodBeat.i(13332);
    paramParcel.writeInt(paramClass.getName().hashCode() ^ paramInt);
    AppMethodBeat.o(13332);
  }
  
  static String bEu(String paramString)
  {
    AppMethodBeat.i(238118);
    paramString = new File(paramString);
    try
    {
      String str = paramString.getCanonicalPath();
      AppMethodBeat.o(238118);
      return str;
    }
    catch (IOException localIOException)
    {
      paramString = paramString.getAbsolutePath();
      AppMethodBeat.o(238118);
    }
    return paramString;
  }
  
  static String bEv(String paramString)
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
  
  public static void bEw(String paramString)
  {
    AppMethodBeat.i(238125);
    if (paramString.isEmpty())
    {
      AppMethodBeat.o(238125);
      return;
    }
    File localFile = new File(k.kMs().akmx, paramString + ".timestamp");
    try
    {
      localFile.createNewFile();
      localFile.setLastModified(System.currentTimeMillis());
      AppMethodBeat.o(238125);
      return;
    }
    catch (IOException localIOException)
    {
      Log.w("VFS.Utils", localIOException, "Unable to update timestamp: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(238125);
    }
  }
  
  public static long bEx(String paramString)
  {
    AppMethodBeat.i(238127);
    long l2 = System.currentTimeMillis();
    if (paramString.isEmpty()) {}
    for (long l1 = 0L;; l1 = new File(k.kMs().akmx, paramString + ".timestamp").lastModified())
    {
      AppMethodBeat.o(238127);
      return l2 - l1;
    }
  }
  
  public static <T> List<T> c(Iterable<? extends T> paramIterable)
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
  
  public static long e(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(238135);
    long l = 0L;
    byte[] arrayOfByte = new byte[2048];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
      l += i;
    }
    AppMethodBeat.o(238135);
    return l;
  }
  
  public static boolean equals(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(238182);
    if ((paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2))))
    {
      AppMethodBeat.o(238182);
      return true;
    }
    AppMethodBeat.o(238182);
    return false;
  }
  
  public static int hash(Object... paramVarArgs)
  {
    AppMethodBeat.i(238175);
    int i = Arrays.deepHashCode(paramVarArgs);
    AppMethodBeat.o(238175);
    return i;
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
  
  public static String v(Uri paramUri)
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
  
  static String v(String paramString, boolean paramBoolean1, boolean paramBoolean2)
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
        break label200;
      }
      String str = localStringTokenizer.nextToken();
      if ((paramBoolean1) && ("..".equals(str)))
      {
        if (!paramString.isEmpty()) {
          paramString.remove(paramString.size() - 1);
        }
        i = 0;
        continue;
        j = 0;
        break;
      }
      if (((paramBoolean1) && (".".equals(str))) || ("".equals(str))) {
        i = 0;
      } else {
        paramString.add(str);
      }
    }
    label200:
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
  
  public static abstract interface a
  {
    public abstract boolean b(j paramj);
  }
  
  static final class b
    implements a.a<j, j>
  {
    private final FileSystem.b agBk;
    private final boolean agBl;
    private final ah.a agBm;
    private final List<j> agBn;
    private final j[] agwg;
    
    b(FileSystem.b paramb, boolean paramBoolean, ah.a parama)
    {
      AppMethodBeat.i(238219);
      this.agBk = paramb;
      this.agBl = paramBoolean;
      this.agBm = parama;
      this.agwg = new j[1];
      this.agBn = Arrays.asList(this.agwg);
      AppMethodBeat.o(238219);
    }
  }
  
  public static abstract interface d
  {
    public abstract boolean a(FileSystem.b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.ah
 * JD-Core Version:    0.7.0.1
 */