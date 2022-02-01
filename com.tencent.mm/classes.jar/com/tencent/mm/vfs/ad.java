package com.tencent.mm.vfs;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ad
{
  private static final Pattern YFG;
  
  static
  {
    AppMethodBeat.i(13334);
    YFG = Pattern.compile("\\$\\{([A-Za-z0-9_]+)\\}");
    AppMethodBeat.o(13334);
  }
  
  /* Error */
  public static long a(FileSystem.b paramb1, String paramString1, FileSystem.b paramb2, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: ldc 36
    //   5: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: aload_1
    //   10: invokeinterface 42 2 0
    //   15: astore 7
    //   17: aload_2
    //   18: aload_3
    //   19: iconst_0
    //   20: invokeinterface 46 3 0
    //   25: astore_1
    //   26: aload_0
    //   27: invokeinterface 50 1 0
    //   32: aload_2
    //   33: invokeinterface 50 1 0
    //   38: iand
    //   39: iconst_2
    //   40: iand
    //   41: ifeq +6 -> 47
    //   44: iconst_1
    //   45: istore 4
    //   47: iload 4
    //   49: ifeq +67 -> 116
    //   52: sipush 8192
    //   55: invokestatic 56	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   58: astore_0
    //   59: goto +99 -> 158
    //   62: aload 7
    //   64: aload_0
    //   65: invokeinterface 62 2 0
    //   70: iflt +56 -> 126
    //   73: aload_0
    //   74: invokevirtual 66	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   77: pop
    //   78: lload 5
    //   80: aload_1
    //   81: aload_0
    //   82: invokeinterface 71 2 0
    //   87: i2l
    //   88: ladd
    //   89: lstore 5
    //   91: aload_0
    //   92: invokevirtual 74	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   95: pop
    //   96: goto -34 -> 62
    //   99: astore_0
    //   100: aload 7
    //   102: invokestatic 78	com/tencent/mm/vfs/ad:closeQuietly	(Ljava/io/Closeable;)V
    //   105: aload_1
    //   106: invokestatic 78	com/tencent/mm/vfs/ad:closeQuietly	(Ljava/io/Closeable;)V
    //   109: ldc 36
    //   111: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: aload_0
    //   115: athrow
    //   116: sipush 8192
    //   119: invokestatic 81	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   122: astore_0
    //   123: goto +35 -> 158
    //   126: aload 7
    //   128: invokestatic 78	com/tencent/mm/vfs/ad:closeQuietly	(Ljava/io/Closeable;)V
    //   131: aload_1
    //   132: invokestatic 78	com/tencent/mm/vfs/ad:closeQuietly	(Ljava/io/Closeable;)V
    //   135: ldc 36
    //   137: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static void a(Parcel paramParcel, Class<? extends FileSystem> paramClass, int paramInt)
  {
    AppMethodBeat.i(13331);
    paramInt = paramClass.getName().hashCode() ^ paramInt;
    int i = paramParcel.readInt();
    if (i != paramInt)
    {
      paramParcel = new ad.a(paramClass, i, paramInt);
      AppMethodBeat.o(13331);
      throw paramParcel;
    }
    AppMethodBeat.o(13331);
  }
  
  public static void a(FileSystem.b paramb, b paramb1)
  {
    AppMethodBeat.i(236986);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramb);
    do
    {
      paramb = (FileSystem.b)localArrayList.remove(localArrayList.size() - 1);
      if (paramb != null)
      {
        paramb1.a(paramb);
        if ((paramb instanceof d))
        {
          paramb = ((d)paramb).ifa();
          int i = paramb.size() - 1;
          while (i >= 0)
          {
            localArrayList.add(paramb.get(i));
            i -= 1;
          }
        }
      }
    } while (!localArrayList.isEmpty());
    AppMethodBeat.o(236986);
  }
  
  static String ad(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(13325);
    if (paramString == null)
    {
      AppMethodBeat.o(13325);
      return null;
    }
    Matcher localMatcher = YFG.matcher(paramString);
    StringBuilder localStringBuilder;
    int i;
    if (localMatcher.find())
    {
      localStringBuilder = new StringBuilder(paramString.length());
      i = 0;
    }
    for (;;)
    {
      String str = (String)paramMap.get(localMatcher.group(1));
      if (str == null)
      {
        AppMethodBeat.o(13325);
        return null;
      }
      localStringBuilder.append(paramString.substring(i, localMatcher.start())).append(str);
      i = localMatcher.end();
      if (!localMatcher.find())
      {
        paramString = paramString.substring(i);
        AppMethodBeat.o(13325);
        return paramString;
        AppMethodBeat.o(13325);
        return paramString;
      }
    }
  }
  
  static String b(Uri paramUri, boolean paramBoolean)
  {
    AppMethodBeat.i(13328);
    paramUri = h.iWH().a(paramUri, null);
    if (!paramUri.fCF())
    {
      AppMethodBeat.o(13328);
      return null;
    }
    if ((paramUri.YCO.ieY() & 0x2) != 0)
    {
      paramUri = paramUri.YCO.dL(paramUri.path, paramBoolean);
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
  
  static String bCb(String paramString)
  {
    AppMethodBeat.i(236968);
    paramString = new File(paramString);
    try
    {
      String str = paramString.getCanonicalPath();
      AppMethodBeat.o(236968);
      return str;
    }
    catch (IOException localIOException)
    {
      paramString = paramString.getAbsolutePath();
      AppMethodBeat.o(236968);
    }
    return paramString;
  }
  
  static String bCc(String paramString)
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
  
  public static void bCd(String paramString)
  {
    AppMethodBeat.i(236975);
    if (paramString.isEmpty())
    {
      AppMethodBeat.o(236975);
      return;
    }
    File localFile = new File(h.iWH().abST, paramString + ".timestamp");
    try
    {
      localFile.createNewFile();
      localFile.setLastModified(System.currentTimeMillis());
      AppMethodBeat.o(236975);
      return;
    }
    catch (IOException localIOException)
    {
      Log.w("VFS.Utils", localIOException, "Unable to update timestamp: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(236975);
    }
  }
  
  public static long bCe(String paramString)
  {
    AppMethodBeat.i(236977);
    if (paramString.isEmpty())
    {
      AppMethodBeat.o(236977);
      return 0L;
    }
    paramString = new File(h.iWH().abST, paramString + ".timestamp");
    long l1 = System.currentTimeMillis();
    long l2 = paramString.lastModified();
    AppMethodBeat.o(236977);
    return l1 - l2;
  }
  
  public static long c(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(236978);
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
    AppMethodBeat.o(236978);
    return l;
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
  
  public static int hash(Object... paramVarArgs)
  {
    AppMethodBeat.i(236985);
    int i = Arrays.deepHashCode(paramVarArgs);
    AppMethodBeat.o(236985);
    return i;
  }
  
  static Uri parseUri(String paramString)
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
  
  static String r(String paramString, boolean paramBoolean1, boolean paramBoolean2)
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
  
  static String s(Uri paramUri)
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
  
  public static abstract interface b
  {
    public abstract boolean a(FileSystem.b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vfs.ad
 * JD-Core Version:    0.7.0.1
 */