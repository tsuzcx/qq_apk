package com.tencent.xweb.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.File;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import org.xwalk.core.Log;

public final class g
{
  public static String Bq(long paramLong)
  {
    AppMethodBeat.i(212655);
    if (paramLong == -9223372036854775808L) {}
    for (long l1 = 9223372036854775807L; l1 < 1024L; l1 = Math.abs(paramLong))
    {
      localObject = paramLong + " B";
      AppMethodBeat.o(212655);
      return localObject;
    }
    Object localObject = new StringCharacterIterator("KMGTPE");
    int i = 40;
    long l2 = l1;
    while ((i >= 0) && (l1 > 1152865209611504844L >> i))
    {
      l2 >>= 10;
      ((CharacterIterator)localObject).next();
      i -= 10;
    }
    localObject = String.format("%.1f %ciB", new Object[] { Double.valueOf(l2 * Long.signum(paramLong) / 1024.0D), Character.valueOf(((CharacterIterator)localObject).current()) });
    AppMethodBeat.o(212655);
    return localObject;
  }
  
  /* Error */
  public static boolean a(android.content.res.AssetFileDescriptor paramAssetFileDescriptor, File paramFile)
  {
    // Byte code:
    //   0: ldc 96
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnonnull +17 -> 23
    //   9: ldc 98
    //   11: ldc 100
    //   13: invokestatic 106	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: ldc 96
    //   18: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: iconst_0
    //   22: ireturn
    //   23: aload_1
    //   24: invokevirtual 112	java/io/File:exists	()Z
    //   27: ifeq +15 -> 42
    //   30: aload_1
    //   31: invokevirtual 115	java/io/File:isFile	()Z
    //   34: ifeq +8 -> 42
    //   37: aload_1
    //   38: invokevirtual 118	java/io/File:delete	()Z
    //   41: pop
    //   42: new 120	java/io/FileOutputStream
    //   45: dup
    //   46: aload_1
    //   47: invokespecial 123	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   50: astore_2
    //   51: aload_0
    //   52: invokevirtual 129	android/content/res/AssetFileDescriptor:createInputStream	()Ljava/io/FileInputStream;
    //   55: aload_2
    //   56: invokestatic 133	com/tencent/xweb/util/g:h	(Ljava/io/InputStream;Ljava/io/OutputStream;)Z
    //   59: pop
    //   60: aload_2
    //   61: invokestatic 137	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   64: ldc 96
    //   66: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: iconst_1
    //   70: ireturn
    //   71: astore_1
    //   72: aconst_null
    //   73: astore_0
    //   74: ldc 98
    //   76: ldc 139
    //   78: aload_1
    //   79: invokestatic 142	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   82: invokevirtual 146	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   85: invokestatic 106	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: aload_0
    //   89: invokestatic 137	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   92: ldc 96
    //   94: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: iconst_0
    //   98: ireturn
    //   99: astore_1
    //   100: aload_0
    //   101: invokestatic 137	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   104: ldc 96
    //   106: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: aload_1
    //   110: athrow
    //   111: astore_1
    //   112: aload_2
    //   113: astore_0
    //   114: goto -40 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	paramAssetFileDescriptor	android.content.res.AssetFileDescriptor
    //   0	117	1	paramFile	File
    //   50	63	2	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   42	51	71	finally
    //   74	88	99	finally
    //   51	60	111	finally
  }
  
  private static void ai(File paramFile)
  {
    AppMethodBeat.i(156997);
    if ((paramFile == null) || (!paramFile.exists()))
    {
      AppMethodBeat.o(156997);
      return;
    }
    if (paramFile.isFile())
    {
      paramFile.delete();
      AppMethodBeat.o(156997);
      return;
    }
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length > 0))
      {
        int j = arrayOfFile.length;
        int i = 0;
        if (i < j)
        {
          File localFile = arrayOfFile[i];
          if ((localFile != null) && (localFile.exists()))
          {
            if (!localFile.isFile()) {
              break label110;
            }
            localFile.delete();
          }
          for (;;)
          {
            i += 1;
            break;
            label110:
            ai(localFile);
          }
        }
      }
      paramFile.delete();
    }
    AppMethodBeat.o(156997);
  }
  
  public static long b(File paramFile, boolean paramBoolean)
  {
    AppMethodBeat.i(212652);
    if (paramFile.isFile())
    {
      l1 = paramFile.length();
      if ((paramBoolean) && (l1 > 1048576L)) {
        Log.i("FileUtils", "getFileSize, size:" + Bq(l1) + ", file:" + paramFile.getName() + ", path:" + paramFile.getAbsolutePath());
      }
      AppMethodBeat.o(212652);
      return l1;
    }
    long l1 = 0L;
    paramFile = paramFile.listFiles();
    long l2 = l1;
    if (paramFile != null)
    {
      int j = paramFile.length;
      int i = 0;
      for (;;)
      {
        l2 = l1;
        if (i >= j) {
          break;
        }
        l1 += b(paramFile[i], paramBoolean);
        i += 1;
      }
    }
    AppMethodBeat.o(212652);
    return l2;
  }
  
  /* Error */
  public static boolean b(java.io.InputStream paramInputStream, File paramFile)
  {
    // Byte code:
    //   0: ldc 187
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnonnull +17 -> 23
    //   9: ldc 98
    //   11: ldc 189
    //   13: invokestatic 106	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: ldc 187
    //   18: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: iconst_0
    //   22: ireturn
    //   23: aload_1
    //   24: invokevirtual 112	java/io/File:exists	()Z
    //   27: ifeq +15 -> 42
    //   30: aload_1
    //   31: invokevirtual 115	java/io/File:isFile	()Z
    //   34: ifeq +8 -> 42
    //   37: aload_1
    //   38: invokevirtual 118	java/io/File:delete	()Z
    //   41: pop
    //   42: new 120	java/io/FileOutputStream
    //   45: dup
    //   46: aload_1
    //   47: invokespecial 123	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   50: astore_2
    //   51: aload_0
    //   52: aload_2
    //   53: invokestatic 133	com/tencent/xweb/util/g:h	(Ljava/io/InputStream;Ljava/io/OutputStream;)Z
    //   56: pop
    //   57: aload_2
    //   58: invokestatic 137	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   61: ldc 187
    //   63: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: iconst_1
    //   67: ireturn
    //   68: astore_1
    //   69: aconst_null
    //   70: astore_0
    //   71: ldc 98
    //   73: ldc 191
    //   75: aload_1
    //   76: invokestatic 142	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   79: invokevirtual 146	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   82: invokestatic 106	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: aload_0
    //   86: invokestatic 137	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   89: ldc 187
    //   91: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: iconst_0
    //   95: ireturn
    //   96: astore_1
    //   97: aload_0
    //   98: invokestatic 137	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   101: ldc 187
    //   103: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: aload_1
    //   107: athrow
    //   108: astore_1
    //   109: aload_2
    //   110: astore_0
    //   111: goto -40 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	paramInputStream	java.io.InputStream
    //   0	114	1	paramFile	File
    //   50	60	2	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   42	51	68	finally
    //   71	85	96	finally
    //   51	57	108	finally
  }
  
  public static boolean bHZ(String paramString)
  {
    AppMethodBeat.i(156996);
    try
    {
      ai(new File(paramString));
      AppMethodBeat.o(156996);
      return true;
    }
    finally
    {
      Log.i("FileUtils", String.format("deleteAll failed, path:%s, error:%s", new Object[] { paramString, localObject }));
      AppMethodBeat.o(156996);
    }
    return false;
  }
  
  public static boolean copyFile(String paramString1, String paramString2)
  {
    AppMethodBeat.i(156991);
    boolean bool = f(new File(paramString1), new File(paramString2));
    AppMethodBeat.o(156991);
    return bool;
  }
  
  public static void d(Closeable paramCloseable)
  {
    AppMethodBeat.i(156998);
    if (paramCloseable == null)
    {
      AppMethodBeat.o(156998);
      return;
    }
    try
    {
      paramCloseable.close();
      AppMethodBeat.o(156998);
      return;
    }
    finally
    {
      Log.e("FileUtils", "closeable close failed, error:".concat(String.valueOf(paramCloseable)));
      AppMethodBeat.o(156998);
    }
  }
  
  public static boolean deleteFile(String paramString)
  {
    AppMethodBeat.i(156995);
    paramString = new File(paramString);
    if ((paramString.exists()) && (paramString.isFile()))
    {
      boolean bool = paramString.delete();
      AppMethodBeat.o(156995);
      return bool;
    }
    AppMethodBeat.o(156995);
    return false;
  }
  
  /* Error */
  private static boolean f(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: ldc 215
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 217	java/io/FileInputStream
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 218	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   13: astore_3
    //   14: new 120	java/io/FileOutputStream
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 123	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   22: astore_1
    //   23: aload_3
    //   24: aload_1
    //   25: invokestatic 133	com/tencent/xweb/util/g:h	(Ljava/io/InputStream;Ljava/io/OutputStream;)Z
    //   28: istore_2
    //   29: aload_3
    //   30: invokestatic 137	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   33: aload_1
    //   34: invokestatic 137	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   37: ldc 215
    //   39: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: iload_2
    //   43: ireturn
    //   44: astore_0
    //   45: aconst_null
    //   46: astore_1
    //   47: aconst_null
    //   48: astore_3
    //   49: ldc 98
    //   51: ldc 220
    //   53: aload_0
    //   54: invokestatic 142	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   57: invokevirtual 146	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   60: invokestatic 106	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: aload_3
    //   64: invokestatic 137	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   67: aload_1
    //   68: invokestatic 137	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   71: ldc 215
    //   73: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: iconst_0
    //   77: ireturn
    //   78: astore_0
    //   79: aload_3
    //   80: invokestatic 137	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   83: aload_1
    //   84: invokestatic 137	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   87: ldc 215
    //   89: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: aload_0
    //   93: athrow
    //   94: astore_0
    //   95: aconst_null
    //   96: astore_1
    //   97: goto -48 -> 49
    //   100: astore_0
    //   101: goto -52 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	paramFile1	File
    //   0	104	1	paramFile2	File
    //   28	15	2	bool	boolean
    //   13	67	3	localFileInputStream	java.io.FileInputStream
    // Exception table:
    //   from	to	target	type
    //   5	14	44	finally
    //   49	63	78	finally
    //   14	23	94	finally
    //   23	29	100	finally
  }
  
  /* Error */
  private static boolean h(java.io.InputStream paramInputStream, java.io.OutputStream paramOutputStream)
  {
    // Byte code:
    //   0: ldc 223
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: sipush 8192
    //   8: newarray byte
    //   10: astore_3
    //   11: aload_0
    //   12: aload_3
    //   13: invokevirtual 229	java/io/InputStream:read	([B)I
    //   16: istore_2
    //   17: iload_2
    //   18: ifle +43 -> 61
    //   21: aload_1
    //   22: aload_3
    //   23: iconst_0
    //   24: iload_2
    //   25: invokevirtual 235	java/io/OutputStream:write	([BII)V
    //   28: goto -17 -> 11
    //   31: astore_3
    //   32: ldc 98
    //   34: ldc 220
    //   36: aload_3
    //   37: invokestatic 142	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   40: invokevirtual 146	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   43: invokestatic 106	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: aload_0
    //   47: invokestatic 137	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   50: aload_1
    //   51: invokestatic 137	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   54: ldc 223
    //   56: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: iconst_0
    //   60: ireturn
    //   61: aload_1
    //   62: invokevirtual 238	java/io/OutputStream:flush	()V
    //   65: aload_0
    //   66: invokestatic 137	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   69: aload_1
    //   70: invokestatic 137	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   73: ldc 223
    //   75: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: iconst_1
    //   79: ireturn
    //   80: astore_3
    //   81: aload_0
    //   82: invokestatic 137	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   85: aload_1
    //   86: invokestatic 137	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   89: ldc 223
    //   91: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: aload_3
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	paramInputStream	java.io.InputStream
    //   0	96	1	paramOutputStream	java.io.OutputStream
    //   16	9	2	i	int
    //   10	13	3	arrayOfByte	byte[]
    //   31	6	3	localIOException	java.io.IOException
    //   80	15	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	11	31	java/io/IOException
    //   11	17	31	java/io/IOException
    //   21	28	31	java/io/IOException
    //   61	65	31	java/io/IOException
    //   5	11	80	finally
    //   11	17	80	finally
    //   21	28	80	finally
    //   32	46	80	finally
    //   61	65	80	finally
  }
  
  public static boolean qZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(212625);
    File localFile = new File(paramString2);
    if ((!localFile.isDirectory()) || (!localFile.exists())) {
      localFile.mkdirs();
    }
    paramString1 = new File(paramString1).listFiles();
    if (paramString1 == null)
    {
      AppMethodBeat.o(212625);
      return false;
    }
    int i = 0;
    while (i < paramString1.length)
    {
      if ((paramString1[i].isFile()) && (!f(paramString1[i], new File(new File(paramString2).getAbsolutePath() + File.separator + paramString1[i].getName()))))
      {
        AppMethodBeat.o(212625);
        return false;
      }
      paramString1[i].isDirectory();
      i += 1;
    }
    AppMethodBeat.o(212625);
    return true;
  }
  
  public static boolean ra(String paramString1, String paramString2)
  {
    AppMethodBeat.i(212632);
    Object localObject = new File(paramString2);
    if ((!((File)localObject).isDirectory()) || (!((File)localObject).exists())) {
      ((File)localObject).mkdirs();
    }
    localObject = new File(paramString1).listFiles();
    if (localObject == null)
    {
      AppMethodBeat.o(212632);
      return false;
    }
    int i = 0;
    while (i < localObject.length)
    {
      if ((localObject[i].isFile()) && (!f(localObject[i], new File(new File(paramString2).getAbsolutePath() + File.separator + localObject[i].getName()))))
      {
        AppMethodBeat.o(212632);
        return false;
      }
      if ((localObject[i].isDirectory()) && (!ra(paramString1 + "/" + localObject[i].getName(), paramString2 + "/" + localObject[i].getName())))
      {
        AppMethodBeat.o(212632);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(212632);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.util.g
 * JD-Core Version:    0.7.0.1
 */