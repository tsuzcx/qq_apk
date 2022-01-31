package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.tencent.map.lib.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ji
{
  private static boolean b;
  
  static
  {
    AppMethodBeat.i(148700);
    if (!ji.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      b = false;
      AppMethodBeat.o(148700);
      return;
    }
  }
  
  public static File a(Context paramContext)
  {
    AppMethodBeat.i(148695);
    paramContext = new File(paramContext.getApplicationInfo().nativeLibraryDir);
    AppMethodBeat.o(148695);
    return paramContext;
  }
  
  private static ZipEntry a(ZipFile paramZipFile, String paramString)
  {
    AppMethodBeat.i(148698);
    ZipEntry localZipEntry = paramZipFile.getEntry("lib/" + Build.CPU_ABI + "/" + System.mapLibraryName(paramString));
    if (localZipEntry != null)
    {
      AppMethodBeat.o(148698);
      return localZipEntry;
    }
    paramZipFile = paramZipFile.getEntry("lib/" + Build.CPU_ABI2 + "/" + System.mapLibraryName(paramString));
    AppMethodBeat.o(148698);
    return paramZipFile;
  }
  
  private static void a(File paramFile)
  {
    AppMethodBeat.i(148699);
    for (;;)
    {
      int i;
      try
      {
        File[] arrayOfFile = paramFile.listFiles();
        if (arrayOfFile != null)
        {
          int j = arrayOfFile.length;
          i = 0;
          if (i < j)
          {
            File localFile = arrayOfFile[i];
            localFile.getName();
            if (localFile.delete()) {
              break label117;
            }
            d.b("Failed to remove " + localFile.getAbsolutePath());
            break label117;
          }
        }
        if (!paramFile.delete()) {
          d.b("Failed to remove " + paramFile.getAbsolutePath());
        }
        AppMethodBeat.o(148699);
        return;
      }
      catch (Exception paramFile)
      {
        d.a("Failed to remove old libs, ", paramFile);
        AppMethodBeat.o(148699);
        return;
      }
      label117:
      i += 1;
    }
  }
  
  static boolean a(Context paramContext, String paramString)
  {
    AppMethodBeat.i(148694);
    if ((!a) && (paramContext == null))
    {
      paramContext = new AssertionError();
      AppMethodBeat.o(148694);
      throw paramContext;
    }
    paramString = b(paramContext, paramString);
    boolean bool = paramString.exists();
    d.a("libary:" + paramString.getAbsolutePath() + " is exist:" + bool);
    if ((!bool) && (!b(paramContext)))
    {
      AppMethodBeat.o(148694);
      return false;
    }
    try
    {
      System.load(paramString.getAbsolutePath());
      AppMethodBeat.o(148694);
      return true;
    }
    catch (UnsatisfiedLinkError paramContext)
    {
      AppMethodBeat.o(148694);
    }
    return false;
  }
  
  private static File b(Context paramContext, String paramString)
  {
    AppMethodBeat.i(148696);
    paramString = System.mapLibraryName(paramString);
    paramContext = new File(a(paramContext), paramString);
    AppMethodBeat.o(148696);
    return paramContext;
  }
  
  /* Error */
  private static boolean b(Context paramContext)
  {
    // Byte code:
    //   0: ldc 154
    //   2: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 26	com/tencent/tencentmap/mapsdk/maps/a/ji:b	Z
    //   8: ifeq +10 -> 18
    //   11: ldc 154
    //   13: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: iconst_0
    //   17: ireturn
    //   18: iconst_1
    //   19: putstatic 26	com/tencent/tencentmap/mapsdk/maps/a/ji:b	Z
    //   22: aload_0
    //   23: invokestatic 148	com/tencent/tencentmap/mapsdk/maps/a/ji:a	(Landroid/content/Context;)Ljava/io/File;
    //   26: astore 6
    //   28: aload 6
    //   30: invokestatic 156	com/tencent/tencentmap/mapsdk/maps/a/ji:a	(Ljava/io/File;)V
    //   33: new 82	java/util/zip/ZipFile
    //   36: dup
    //   37: new 37	java/io/File
    //   40: dup
    //   41: aload_0
    //   42: invokevirtual 43	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   45: getfield 159	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   48: invokespecial 52	java/io/File:<init>	(Ljava/lang/String;)V
    //   51: iconst_1
    //   52: invokespecial 162	java/util/zip/ZipFile:<init>	(Ljava/io/File;I)V
    //   55: astore 7
    //   57: getstatic 167	com/tencent/tencentmap/mapsdk/maps/a/jh:a	[Ljava/lang/String;
    //   60: astore 9
    //   62: aload 9
    //   64: arraylength
    //   65: istore_2
    //   66: iconst_0
    //   67: istore_1
    //   68: iload_1
    //   69: iload_2
    //   70: if_icmpge +353 -> 423
    //   73: aload 9
    //   75: iload_1
    //   76: aaload
    //   77: astore 5
    //   79: aload 7
    //   81: aload 5
    //   83: invokestatic 169	com/tencent/tencentmap/mapsdk/maps/a/ji:a	(Ljava/util/zip/ZipFile;Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   86: astore 4
    //   88: aload 4
    //   90: ifnonnull +20 -> 110
    //   93: aload 7
    //   95: invokevirtual 172	java/util/zip/ZipFile:close	()V
    //   98: aload 6
    //   100: invokestatic 156	com/tencent/tencentmap/mapsdk/maps/a/ji:a	(Ljava/io/File;)V
    //   103: ldc 154
    //   105: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   108: iconst_0
    //   109: ireturn
    //   110: aload_0
    //   111: aload 5
    //   113: invokestatic 127	com/tencent/tencentmap/mapsdk/maps/a/ji:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   116: astore 8
    //   118: new 56	java/lang/StringBuilder
    //   121: dup
    //   122: ldc 174
    //   124: invokespecial 59	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   127: aload 8
    //   129: invokevirtual 108	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   132: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 139	com/tencent/map/lib/d:a	(Ljava/lang/String;)V
    //   141: getstatic 24	com/tencent/tencentmap/mapsdk/maps/a/ji:a	Z
    //   144: ifne +45 -> 189
    //   147: aload 8
    //   149: invokevirtual 130	java/io/File:exists	()Z
    //   152: ifeq +37 -> 189
    //   155: new 123	java/lang/AssertionError
    //   158: dup
    //   159: invokespecial 124	java/lang/AssertionError:<init>	()V
    //   162: astore_0
    //   163: ldc 154
    //   165: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   168: aload_0
    //   169: athrow
    //   170: astore_0
    //   171: ldc 176
    //   173: aload_0
    //   174: invokestatic 117	com/tencent/map/lib/d:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   177: aload 6
    //   179: invokestatic 156	com/tencent/tencentmap/mapsdk/maps/a/ji:a	(Ljava/io/File;)V
    //   182: ldc 154
    //   184: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   187: iconst_0
    //   188: ireturn
    //   189: aload 8
    //   191: invokevirtual 179	java/io/File:createNewFile	()Z
    //   194: ifne +70 -> 264
    //   197: new 153	java/io/IOException
    //   200: dup
    //   201: invokespecial 180	java/io/IOException:<init>	()V
    //   204: astore_0
    //   205: ldc 154
    //   207: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   210: aload_0
    //   211: athrow
    //   212: astore_0
    //   213: aload 8
    //   215: invokevirtual 130	java/io/File:exists	()Z
    //   218: ifeq +34 -> 252
    //   221: aload 8
    //   223: invokevirtual 103	java/io/File:delete	()Z
    //   226: ifne +26 -> 252
    //   229: new 56	java/lang/StringBuilder
    //   232: dup
    //   233: ldc 182
    //   235: invokespecial 59	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   238: aload 8
    //   240: invokevirtual 108	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   243: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: invokestatic 112	com/tencent/map/lib/d:b	(Ljava/lang/String;)V
    //   252: aload 7
    //   254: invokevirtual 172	java/util/zip/ZipFile:close	()V
    //   257: ldc 154
    //   259: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   262: aload_0
    //   263: athrow
    //   264: aload 7
    //   266: aload 4
    //   268: invokevirtual 186	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   271: astore 5
    //   273: new 188	java/io/FileOutputStream
    //   276: dup
    //   277: aload 8
    //   279: invokespecial 190	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   282: astore 4
    //   284: sipush 16384
    //   287: newarray byte
    //   289: astore 10
    //   291: aload 5
    //   293: aload 10
    //   295: invokevirtual 196	java/io/InputStream:read	([B)I
    //   298: istore_3
    //   299: iload_3
    //   300: ifle +43 -> 343
    //   303: aload 4
    //   305: aload 10
    //   307: iconst_0
    //   308: iload_3
    //   309: invokevirtual 200	java/io/FileOutputStream:write	([BII)V
    //   312: goto -21 -> 291
    //   315: astore_0
    //   316: aload 5
    //   318: ifnull +8 -> 326
    //   321: aload 5
    //   323: invokevirtual 201	java/io/InputStream:close	()V
    //   326: aload 4
    //   328: ifnull +8 -> 336
    //   331: aload 4
    //   333: invokevirtual 202	java/io/FileOutputStream:close	()V
    //   336: ldc 154
    //   338: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   341: aload_0
    //   342: athrow
    //   343: aload 5
    //   345: ifnull +8 -> 353
    //   348: aload 5
    //   350: invokevirtual 201	java/io/InputStream:close	()V
    //   353: aload 4
    //   355: invokevirtual 202	java/io/FileOutputStream:close	()V
    //   358: getstatic 208	android/os/Build$VERSION:SDK_INT	I
    //   361: bipush 9
    //   363: if_icmplt +89 -> 452
    //   366: aload 8
    //   368: iconst_1
    //   369: iconst_0
    //   370: invokevirtual 212	java/io/File:setReadable	(ZZ)Z
    //   373: pop
    //   374: aload 8
    //   376: iconst_1
    //   377: iconst_0
    //   378: invokevirtual 215	java/io/File:setExecutable	(ZZ)Z
    //   381: pop
    //   382: aload 8
    //   384: iconst_1
    //   385: invokevirtual 219	java/io/File:setWritable	(Z)Z
    //   388: pop
    //   389: goto +63 -> 452
    //   392: astore_0
    //   393: aload 4
    //   395: invokevirtual 202	java/io/FileOutputStream:close	()V
    //   398: ldc 154
    //   400: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   403: aload_0
    //   404: athrow
    //   405: astore_0
    //   406: aload 4
    //   408: ifnull +8 -> 416
    //   411: aload 4
    //   413: invokevirtual 202	java/io/FileOutputStream:close	()V
    //   416: ldc 154
    //   418: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   421: aload_0
    //   422: athrow
    //   423: aload 7
    //   425: invokevirtual 172	java/util/zip/ZipFile:close	()V
    //   428: ldc 154
    //   430: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   433: iconst_1
    //   434: ireturn
    //   435: astore_0
    //   436: aconst_null
    //   437: astore 4
    //   439: aconst_null
    //   440: astore 5
    //   442: goto -126 -> 316
    //   445: astore_0
    //   446: aconst_null
    //   447: astore 4
    //   449: goto -133 -> 316
    //   452: iload_1
    //   453: iconst_1
    //   454: iadd
    //   455: istore_1
    //   456: goto -388 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	459	0	paramContext	Context
    //   67	389	1	i	int
    //   65	6	2	j	int
    //   298	11	3	k	int
    //   86	362	4	localObject1	Object
    //   77	364	5	localObject2	Object
    //   26	152	6	localFile1	File
    //   55	369	7	localZipFile	ZipFile
    //   116	267	8	localFile2	File
    //   60	14	9	arrayOfString	String[]
    //   289	17	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   33	66	170	java/io/IOException
    //   79	88	170	java/io/IOException
    //   93	103	170	java/io/IOException
    //   110	170	170	java/io/IOException
    //   213	252	170	java/io/IOException
    //   252	264	170	java/io/IOException
    //   423	428	170	java/io/IOException
    //   189	212	212	java/io/IOException
    //   331	336	212	java/io/IOException
    //   336	343	212	java/io/IOException
    //   353	389	212	java/io/IOException
    //   393	405	212	java/io/IOException
    //   411	416	212	java/io/IOException
    //   416	423	212	java/io/IOException
    //   284	291	315	finally
    //   291	299	315	finally
    //   303	312	315	finally
    //   348	353	392	finally
    //   321	326	405	finally
    //   264	273	435	finally
    //   273	284	445	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ji
 * JD-Core Version:    0.7.0.1
 */