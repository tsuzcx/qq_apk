package com.tencent.tbs.one.impl.a;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class c
{
  public static InputStream a(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(173916);
    if (a(paramString2))
    {
      paramString1 = b(paramString2);
      paramContext = paramContext.getResources().getAssets().open(paramString1);
      AppMethodBeat.o(173916);
      return paramContext;
    }
    if (new File(paramString2).isAbsolute())
    {
      paramContext = new FileInputStream(paramString2);
      AppMethodBeat.o(173916);
      return paramContext;
    }
    paramString1 = new File(paramString1, paramString2).getAbsolutePath();
    if (a(paramString1))
    {
      paramString1 = b(paramString1);
      paramContext = paramContext.getResources().getAssets().open(paramString1);
      AppMethodBeat.o(173916);
      return paramContext;
    }
    paramContext = new FileInputStream(paramString1);
    AppMethodBeat.o(173916);
    return paramContext;
  }
  
  public static String a(InputStream paramInputStream, String paramString)
  {
    AppMethodBeat.i(173907);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    a(paramInputStream, localByteArrayOutputStream);
    paramInputStream = new String(localByteArrayOutputStream.toByteArray(), paramString);
    AppMethodBeat.o(173907);
    return paramInputStream;
  }
  
  /* Error */
  public static String a(InputStream paramInputStream, String paramString, File paramFile)
  {
    // Byte code:
    //   0: ldc 83
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 66	java/io/ByteArrayOutputStream
    //   8: dup
    //   9: invokespecial 69	java/io/ByteArrayOutputStream:<init>	()V
    //   12: astore 4
    //   14: new 43	java/io/File
    //   17: dup
    //   18: new 85	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   25: aload_2
    //   26: invokevirtual 89	java/io/File:getPath	()Ljava/lang/String;
    //   29: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: ldc 95
    //   34: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokespecial 47	java/io/File:<init>	(Ljava/lang/String;)V
    //   43: astore 5
    //   45: new 100	com/tencent/tbs/one/impl/a/h
    //   48: dup
    //   49: iconst_2
    //   50: anewarray 102	java/io/OutputStream
    //   53: dup
    //   54: iconst_0
    //   55: aload 4
    //   57: aastore
    //   58: dup
    //   59: iconst_1
    //   60: new 104	java/io/FileOutputStream
    //   63: dup
    //   64: aload 5
    //   66: invokespecial 107	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   69: aastore
    //   70: invokespecial 110	com/tencent/tbs/one/impl/a/h:<init>	([Ljava/io/OutputStream;)V
    //   73: astore_3
    //   74: aload_0
    //   75: aload_3
    //   76: invokestatic 72	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   79: aload_3
    //   80: invokestatic 113	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   83: aload 5
    //   85: aload_2
    //   86: invokevirtual 117	java/io/File:renameTo	(Ljava/io/File;)Z
    //   89: ifne +32 -> 121
    //   92: new 119	java/io/IOException
    //   95: dup
    //   96: invokespecial 120	java/io/IOException:<init>	()V
    //   99: astore_0
    //   100: ldc 83
    //   102: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: aload_0
    //   106: athrow
    //   107: astore_0
    //   108: aconst_null
    //   109: astore_1
    //   110: aload_1
    //   111: invokestatic 113	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   114: ldc 83
    //   116: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   119: aload_0
    //   120: athrow
    //   121: new 74	java/lang/String
    //   124: dup
    //   125: aload 4
    //   127: invokevirtual 78	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   130: aload_1
    //   131: invokespecial 81	java/lang/String:<init>	([BLjava/lang/String;)V
    //   134: astore_0
    //   135: ldc 83
    //   137: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   140: aload_0
    //   141: areturn
    //   142: astore_0
    //   143: aload_3
    //   144: astore_1
    //   145: goto -35 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	paramInputStream	InputStream
    //   0	148	1	paramString	String
    //   0	148	2	paramFile	File
    //   73	71	3	localh	h
    //   12	114	4	localByteArrayOutputStream	ByteArrayOutputStream
    //   43	41	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   45	74	107	finally
    //   74	79	142	finally
  }
  
  public static void a(Closeable paramCloseable)
  {
    AppMethodBeat.i(173904);
    if (paramCloseable == null)
    {
      AppMethodBeat.o(173904);
      return;
    }
    try
    {
      paramCloseable.close();
      AppMethodBeat.o(173904);
      return;
    }
    catch (IOException localIOException)
    {
      f.c("Failed to close %s", new Object[] { paramCloseable, localIOException });
      AppMethodBeat.o(173904);
    }
  }
  
  /* Error */
  public static void a(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: ldc 136
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 53	java/io/FileInputStream
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 137	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   13: invokevirtual 141	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   16: astore_0
    //   17: new 104	java/io/FileOutputStream
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 107	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   25: invokevirtual 142	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   28: astore_1
    //   29: aload_1
    //   30: aload_0
    //   31: lconst_0
    //   32: aload_0
    //   33: invokevirtual 148	java/nio/channels/FileChannel:size	()J
    //   36: invokevirtual 152	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   39: pop2
    //   40: aload_0
    //   41: invokestatic 113	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   44: aload_1
    //   45: invokestatic 113	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   48: ldc 136
    //   50: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: return
    //   54: astore_0
    //   55: aconst_null
    //   56: astore_1
    //   57: aconst_null
    //   58: astore_2
    //   59: aload_2
    //   60: invokestatic 113	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   63: aload_1
    //   64: invokestatic 113	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   67: ldc 136
    //   69: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: aload_0
    //   73: athrow
    //   74: astore_1
    //   75: aconst_null
    //   76: astore_3
    //   77: aload_0
    //   78: astore_2
    //   79: aload_1
    //   80: astore_0
    //   81: aload_3
    //   82: astore_1
    //   83: goto -24 -> 59
    //   86: astore_3
    //   87: aload_0
    //   88: astore_2
    //   89: aload_3
    //   90: astore_0
    //   91: goto -32 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	paramFile1	File
    //   0	94	1	paramFile2	File
    //   58	31	2	localObject1	Object
    //   76	6	3	localObject2	Object
    //   86	4	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   5	17	54	finally
    //   17	29	74	finally
    //   29	40	86	finally
  }
  
  /* Error */
  public static void a(InputStream paramInputStream, File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: ldc 154
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 156	java/util/zip/ZipInputStream
    //   8: dup
    //   9: new 158	java/io/BufferedInputStream
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 161	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: invokespecial 162	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   20: astore 5
    //   22: aload_2
    //   23: ifnull +330 -> 353
    //   26: new 164	java/util/zip/ZipOutputStream
    //   29: dup
    //   30: new 104	java/io/FileOutputStream
    //   33: dup
    //   34: aload_2
    //   35: invokespecial 107	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   38: invokespecial 167	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   41: astore_2
    //   42: aload 5
    //   44: invokevirtual 171	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   47: astore 6
    //   49: aload 6
    //   51: ifnull +253 -> 304
    //   54: new 43	java/io/File
    //   57: dup
    //   58: aload_1
    //   59: aload 6
    //   61: invokevirtual 176	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   64: invokespecial 179	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   67: astore 4
    //   69: aload 6
    //   71: invokevirtual 182	java/util/zip/ZipEntry:isDirectory	()Z
    //   74: ifeq +73 -> 147
    //   77: aload 4
    //   79: invokevirtual 185	java/io/File:exists	()Z
    //   82: ifne +193 -> 275
    //   85: aload 4
    //   87: invokevirtual 188	java/io/File:mkdirs	()Z
    //   90: ifne +185 -> 275
    //   93: new 119	java/io/IOException
    //   96: dup
    //   97: new 85	java/lang/StringBuilder
    //   100: dup
    //   101: ldc 190
    //   103: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   106: aload 4
    //   108: invokevirtual 61	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   111: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokespecial 192	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   120: astore_0
    //   121: ldc 154
    //   123: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: aload_0
    //   127: athrow
    //   128: astore_0
    //   129: aload 5
    //   131: astore_1
    //   132: aload_1
    //   133: invokestatic 113	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   136: aload_2
    //   137: invokestatic 113	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   140: ldc 154
    //   142: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   145: aload_0
    //   146: athrow
    //   147: aload 4
    //   149: invokevirtual 196	java/io/File:getParentFile	()Ljava/io/File;
    //   152: astore 7
    //   154: aload 7
    //   156: invokevirtual 185	java/io/File:exists	()Z
    //   159: ifne +46 -> 205
    //   162: aload 7
    //   164: invokevirtual 188	java/io/File:mkdirs	()Z
    //   167: ifne +38 -> 205
    //   170: new 119	java/io/IOException
    //   173: dup
    //   174: new 85	java/lang/StringBuilder
    //   177: dup
    //   178: ldc 190
    //   180: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   183: aload 7
    //   185: invokevirtual 61	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   188: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokespecial 192	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   197: astore_0
    //   198: ldc 154
    //   200: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   203: aload_0
    //   204: athrow
    //   205: new 198	java/io/BufferedOutputStream
    //   208: dup
    //   209: new 104	java/io/FileOutputStream
    //   212: dup
    //   213: aload 4
    //   215: invokespecial 107	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   218: invokespecial 199	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   221: astore 7
    //   223: aload_2
    //   224: ifnull +59 -> 283
    //   227: new 100	com/tencent/tbs/one/impl/a/h
    //   230: dup
    //   231: iconst_2
    //   232: anewarray 102	java/io/OutputStream
    //   235: dup
    //   236: iconst_0
    //   237: aload 7
    //   239: aastore
    //   240: dup
    //   241: iconst_1
    //   242: aload_2
    //   243: aastore
    //   244: invokespecial 110	com/tencent/tbs/one/impl/a/h:<init>	([Ljava/io/OutputStream;)V
    //   247: astore 4
    //   249: aload_2
    //   250: aload 6
    //   252: invokevirtual 203	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   255: aload 5
    //   257: aload 4
    //   259: invokestatic 72	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   262: aload 7
    //   264: invokevirtual 204	java/io/OutputStream:close	()V
    //   267: aload_2
    //   268: ifnull +7 -> 275
    //   271: aload_2
    //   272: invokevirtual 207	java/util/zip/ZipOutputStream:closeEntry	()V
    //   275: aload 5
    //   277: invokevirtual 208	java/util/zip/ZipInputStream:closeEntry	()V
    //   280: goto -238 -> 42
    //   283: new 100	com/tencent/tbs/one/impl/a/h
    //   286: dup
    //   287: iconst_1
    //   288: anewarray 102	java/io/OutputStream
    //   291: dup
    //   292: iconst_0
    //   293: aload 7
    //   295: aastore
    //   296: invokespecial 110	com/tencent/tbs/one/impl/a/h:<init>	([Ljava/io/OutputStream;)V
    //   299: astore 4
    //   301: goto -46 -> 255
    //   304: sipush 8192
    //   307: newarray byte
    //   309: astore_1
    //   310: aload_0
    //   311: aload_1
    //   312: invokevirtual 214	java/io/InputStream:read	([B)I
    //   315: istore_3
    //   316: iload_3
    //   317: iconst_m1
    //   318: if_icmpne -8 -> 310
    //   321: aload 5
    //   323: invokestatic 113	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   326: aload_2
    //   327: invokestatic 113	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   330: ldc 154
    //   332: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   335: return
    //   336: astore_0
    //   337: aconst_null
    //   338: astore_2
    //   339: aconst_null
    //   340: astore_1
    //   341: goto -209 -> 132
    //   344: astore_0
    //   345: aconst_null
    //   346: astore_2
    //   347: aload 5
    //   349: astore_1
    //   350: goto -218 -> 132
    //   353: aconst_null
    //   354: astore_2
    //   355: goto -313 -> 42
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	358	0	paramInputStream	InputStream
    //   0	358	1	paramFile1	File
    //   0	358	2	paramFile2	File
    //   315	4	3	i	int
    //   67	233	4	localObject1	Object
    //   20	328	5	localZipInputStream	java.util.zip.ZipInputStream
    //   47	204	6	localZipEntry	java.util.zip.ZipEntry
    //   152	142	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   42	49	128	finally
    //   54	128	128	finally
    //   147	205	128	finally
    //   205	223	128	finally
    //   227	255	128	finally
    //   255	267	128	finally
    //   271	275	128	finally
    //   275	280	128	finally
    //   283	301	128	finally
    //   304	310	128	finally
    //   310	316	128	finally
    //   5	22	336	finally
    //   26	42	344	finally
  }
  
  public static void a(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(173906);
    byte[] arrayOfByte = new byte[8192];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
    AppMethodBeat.o(173906);
  }
  
  public static void a(String paramString1, String paramString2, File paramFile)
  {
    AppMethodBeat.i(173913);
    try
    {
      paramFile = new FileOutputStream(paramFile);
      a(paramString2);
    }
    finally
    {
      try
      {
        paramFile.write(paramString1.getBytes(paramString2));
        a(paramFile);
        AppMethodBeat.o(173913);
        return;
      }
      finally
      {
        paramString2 = paramFile;
      }
      paramString1 = finally;
      paramString2 = null;
    }
    AppMethodBeat.o(173913);
    throw paramString1;
  }
  
  public static boolean a(File paramFile)
  {
    AppMethodBeat.i(173905);
    try
    {
      boolean bool = paramFile.exists();
      if (!bool)
      {
        AppMethodBeat.o(173905);
        return true;
      }
      if (paramFile.isDirectory())
      {
        File[] arrayOfFile = paramFile.listFiles();
        if (arrayOfFile != null)
        {
          int j = arrayOfFile.length;
          int i = 0;
          while (i < j)
          {
            a(arrayOfFile[i]);
            i += 1;
          }
        }
      }
      bool = paramFile.delete();
      AppMethodBeat.o(173905);
      return bool;
    }
    catch (Exception localException)
    {
      f.c("recursivelyDeleteFile failed,current file is %s,exception is %s", new Object[] { paramFile.getAbsolutePath(), Log.getStackTraceString(localException) });
      AppMethodBeat.o(173905);
    }
    return false;
  }
  
  private static boolean a(String paramString)
  {
    AppMethodBeat.i(173914);
    if ((!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("/android_asset/")) || (paramString.startsWith("file:///android_asset/"))))
    {
      AppMethodBeat.o(173914);
      return true;
    }
    AppMethodBeat.o(173914);
    return false;
  }
  
  private static String b(String paramString)
  {
    AppMethodBeat.i(173915);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(173915);
      return null;
    }
    if (paramString.startsWith("/android_asset/"))
    {
      paramString = paramString.substring(15);
      AppMethodBeat.o(173915);
      return paramString;
    }
    if (paramString.startsWith("file:///android_asset/"))
    {
      paramString = paramString.substring(22);
      AppMethodBeat.o(173915);
      return paramString;
    }
    AppMethodBeat.o(173915);
    return null;
  }
  
  public static void b(File paramFile)
  {
    AppMethodBeat.i(173917);
    try
    {
      if (!paramFile.createNewFile()) {
        f.c("Failed to create file %s, file already exists", new Object[] { paramFile.getAbsolutePath() });
      }
      AppMethodBeat.o(173917);
      return;
    }
    catch (IOException localIOException)
    {
      f.c("Failed to create file %s", new Object[] { paramFile.getAbsolutePath(), localIOException });
      AppMethodBeat.o(173917);
    }
  }
  
  public static void b(File paramFile1, File paramFile2)
  {
    AppMethodBeat.i(173910);
    if (paramFile1.isDirectory())
    {
      if ((!paramFile2.exists()) && (!paramFile2.mkdirs()))
      {
        paramFile1 = new IOException("Failed to create directory " + paramFile2.getAbsolutePath());
        AppMethodBeat.o(173910);
        throw paramFile1;
      }
      paramFile1 = paramFile1.listFiles();
      if (paramFile1 != null)
      {
        int j = paramFile1.length;
        int i = 0;
        while (i < j)
        {
          File localFile = paramFile1[i];
          b(localFile, new File(paramFile2, localFile.getName()));
          i += 1;
        }
      }
      AppMethodBeat.o(173910);
      return;
    }
    if (paramFile1.canRead()) {
      a(paramFile1, paramFile2);
    }
    AppMethodBeat.o(173910);
  }
  
  public static void c(File paramFile)
  {
    AppMethodBeat.i(173918);
    if (!a(paramFile)) {
      f.c("Failed to delete file %s", new Object[] { paramFile.getAbsolutePath() });
    }
    AppMethodBeat.o(173918);
  }
  
  public static void c(File paramFile1, File paramFile2)
  {
    AppMethodBeat.i(173911);
    if (!paramFile1.renameTo(paramFile2))
    {
      b(paramFile1, paramFile2);
      a(paramFile1);
    }
    AppMethodBeat.o(173911);
  }
  
  public static void d(File paramFile)
  {
    AppMethodBeat.i(173919);
    if (!paramFile.exists())
    {
      if (!paramFile.mkdirs())
      {
        f.c("Failed to create non-exist directory %s", new Object[] { paramFile.getAbsolutePath() });
        AppMethodBeat.o(173919);
      }
    }
    else if ((!paramFile.isDirectory()) && ((!paramFile.delete()) || (!paramFile.mkdirs()))) {
      f.c("Failed to create namesake directory %s", new Object[] { paramFile.getAbsolutePath() });
    }
    AppMethodBeat.o(173919);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tbs.one.impl.a.c
 * JD-Core Version:    0.7.0.1
 */