package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.tencent.map.lib.d;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class kz
{
  private static boolean b;
  
  static
  {
    if (!kz.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      b = false;
      return;
    }
  }
  
  public static File a(Context paramContext)
  {
    return new File(paramContext.getApplicationInfo().nativeLibraryDir);
  }
  
  private static ZipEntry a(ZipFile paramZipFile, String paramString)
  {
    ZipEntry localZipEntry = paramZipFile.getEntry("lib/" + Build.CPU_ABI + "/" + System.mapLibraryName(paramString));
    if (localZipEntry != null) {
      return localZipEntry;
    }
    return paramZipFile.getEntry("lib/" + Build.CPU_ABI2 + "/" + System.mapLibraryName(paramString));
  }
  
  private static void a(File paramFile)
  {
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
              break label102;
            }
            d.b("Failed to remove " + localFile.getAbsolutePath());
            break label102;
          }
        }
        if (!paramFile.delete()) {
          d.b("Failed to remove " + paramFile.getAbsolutePath());
        }
        return;
      }
      catch (Exception paramFile)
      {
        d.a("Failed to remove old libs, ", paramFile);
        return;
      }
      label102:
      i += 1;
    }
  }
  
  private static void a(File paramFile, String paramString, boolean paramBoolean)
  {
    if (paramFile == null) {}
    for (;;)
    {
      return;
      Object localObject = null;
      try
      {
        paramString = File.class.getMethod(paramString, new Class[] { Boolean.TYPE });
        if (paramString == null) {
          continue;
        }
        try
        {
          paramString.invoke(paramFile, new Object[] { Boolean.valueOf(paramBoolean) });
          return;
        }
        catch (IllegalArgumentException paramFile) {}catch (InvocationTargetException paramFile) {}catch (IllegalAccessException paramFile) {}
      }
      catch (NoSuchMethodException paramString)
      {
        for (;;)
        {
          paramString = localObject;
        }
      }
    }
  }
  
  private static void a(File paramFile, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramFile == null) {}
    for (;;)
    {
      return;
      Object localObject = null;
      try
      {
        paramString = File.class.getMethod(paramString, new Class[] { Boolean.TYPE, Boolean.TYPE });
        if (paramString == null) {
          continue;
        }
        try
        {
          paramString.invoke(paramFile, new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
          return;
        }
        catch (IllegalArgumentException paramFile) {}catch (InvocationTargetException paramFile) {}catch (IllegalAccessException paramFile) {}
      }
      catch (NoSuchMethodException paramString)
      {
        for (;;)
        {
          paramString = localObject;
        }
      }
    }
  }
  
  static boolean a(Context paramContext, String paramString)
  {
    if ((!a) && (paramContext == null)) {
      throw new AssertionError();
    }
    paramString = b(paramContext, paramString);
    boolean bool = paramString.exists();
    d.a("libary:" + paramString.getAbsolutePath() + " is exist:" + bool);
    if ((!bool) && (!b(paramContext))) {
      return false;
    }
    try
    {
      System.load(paramString.getAbsolutePath());
      return true;
    }
    catch (UnsatisfiedLinkError paramContext) {}
    return false;
  }
  
  private static File b(Context paramContext, String paramString)
  {
    paramString = System.mapLibraryName(paramString);
    return new File(a(paramContext), paramString);
  }
  
  /* Error */
  private static boolean b(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 19	com/tencent/tencentmap/mapsdk/a/kz:b	Z
    //   3: ifeq +5 -> 8
    //   6: iconst_0
    //   7: ireturn
    //   8: iconst_1
    //   9: putstatic 19	com/tencent/tencentmap/mapsdk/a/kz:b	Z
    //   12: aload_0
    //   13: invokestatic 163	com/tencent/tencentmap/mapsdk/a/kz:a	(Landroid/content/Context;)Ljava/io/File;
    //   16: astore 6
    //   18: aload 6
    //   20: invokestatic 170	com/tencent/tencentmap/mapsdk/a/kz:a	(Ljava/io/File;)V
    //   23: new 70	java/util/zip/ZipFile
    //   26: dup
    //   27: new 26	java/io/File
    //   30: dup
    //   31: aload_0
    //   32: invokevirtual 32	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   35: getfield 173	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   38: invokespecial 41	java/io/File:<init>	(Ljava/lang/String;)V
    //   41: iconst_1
    //   42: invokespecial 176	java/util/zip/ZipFile:<init>	(Ljava/io/File;I)V
    //   45: astore 7
    //   47: getstatic 181	com/tencent/tencentmap/mapsdk/a/ky:a	[Ljava/lang/String;
    //   50: astore 9
    //   52: aload 9
    //   54: arraylength
    //   55: istore_2
    //   56: iconst_0
    //   57: istore_1
    //   58: iload_1
    //   59: iload_2
    //   60: if_icmpge +312 -> 372
    //   63: aload 9
    //   65: iload_1
    //   66: aaload
    //   67: astore 5
    //   69: aload 7
    //   71: aload 5
    //   73: invokestatic 183	com/tencent/tencentmap/mapsdk/a/kz:a	(Ljava/util/zip/ZipFile;Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   76: astore 4
    //   78: aload 4
    //   80: ifnonnull +29 -> 109
    //   83: aload 7
    //   85: invokevirtual 186	java/util/zip/ZipFile:close	()V
    //   88: aload 6
    //   90: invokestatic 170	com/tencent/tencentmap/mapsdk/a/kz:a	(Ljava/io/File;)V
    //   93: iconst_0
    //   94: ireturn
    //   95: astore_0
    //   96: ldc 188
    //   98: aload_0
    //   99: invokestatic 104	com/tencent/map/lib/d:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   102: aload 6
    //   104: invokestatic 170	com/tencent/tencentmap/mapsdk/a/kz:a	(Ljava/io/File;)V
    //   107: iconst_0
    //   108: ireturn
    //   109: aload_0
    //   110: aload 5
    //   112: invokestatic 143	com/tencent/tencentmap/mapsdk/a/kz:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   115: astore 8
    //   117: new 44	java/lang/StringBuilder
    //   120: dup
    //   121: ldc 190
    //   123: invokespecial 47	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   126: aload 8
    //   128: invokevirtual 95	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   131: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 155	com/tencent/map/lib/d:a	(Ljava/lang/String;)V
    //   140: getstatic 17	com/tencent/tencentmap/mapsdk/a/kz:a	Z
    //   143: ifne +19 -> 162
    //   146: aload 8
    //   148: invokevirtual 146	java/io/File:exists	()Z
    //   151: ifeq +11 -> 162
    //   154: new 139	java/lang/AssertionError
    //   157: dup
    //   158: invokespecial 140	java/lang/AssertionError:<init>	()V
    //   161: athrow
    //   162: aload 8
    //   164: invokevirtual 193	java/io/File:createNewFile	()Z
    //   167: ifne +58 -> 225
    //   170: new 168	java/io/IOException
    //   173: dup
    //   174: invokespecial 194	java/io/IOException:<init>	()V
    //   177: athrow
    //   178: astore_0
    //   179: aload 8
    //   181: invokevirtual 146	java/io/File:exists	()Z
    //   184: ifeq +34 -> 218
    //   187: aload 8
    //   189: invokevirtual 90	java/io/File:delete	()Z
    //   192: ifne +26 -> 218
    //   195: new 44	java/lang/StringBuilder
    //   198: dup
    //   199: ldc 196
    //   201: invokespecial 47	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   204: aload 8
    //   206: invokevirtual 95	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   209: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokestatic 99	com/tencent/map/lib/d:b	(Ljava/lang/String;)V
    //   218: aload 7
    //   220: invokevirtual 186	java/util/zip/ZipFile:close	()V
    //   223: aload_0
    //   224: athrow
    //   225: aload 7
    //   227: aload 4
    //   229: invokevirtual 200	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   232: astore 5
    //   234: new 202	java/io/FileOutputStream
    //   237: dup
    //   238: aload 8
    //   240: invokespecial 204	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   243: astore 4
    //   245: sipush 16384
    //   248: newarray byte
    //   250: astore 10
    //   252: aload 5
    //   254: aload 10
    //   256: invokevirtual 210	java/io/InputStream:read	([B)I
    //   259: istore_3
    //   260: iload_3
    //   261: ifle +38 -> 299
    //   264: aload 4
    //   266: aload 10
    //   268: iconst_0
    //   269: iload_3
    //   270: invokevirtual 214	java/io/FileOutputStream:write	([BII)V
    //   273: goto -21 -> 252
    //   276: astore_0
    //   277: aload 5
    //   279: ifnull +8 -> 287
    //   282: aload 5
    //   284: invokevirtual 215	java/io/InputStream:close	()V
    //   287: aload 4
    //   289: ifnull +8 -> 297
    //   292: aload 4
    //   294: invokevirtual 216	java/io/FileOutputStream:close	()V
    //   297: aload_0
    //   298: athrow
    //   299: aload 5
    //   301: ifnull +8 -> 309
    //   304: aload 5
    //   306: invokevirtual 215	java/io/InputStream:close	()V
    //   309: aload 4
    //   311: invokevirtual 216	java/io/FileOutputStream:close	()V
    //   314: getstatic 222	android/os/Build$VERSION:SDK_INT	I
    //   317: bipush 9
    //   319: if_icmplt +77 -> 396
    //   322: aload 8
    //   324: ldc 224
    //   326: iconst_1
    //   327: iconst_0
    //   328: invokestatic 226	com/tencent/tencentmap/mapsdk/a/kz:a	(Ljava/io/File;Ljava/lang/String;ZZ)V
    //   331: aload 8
    //   333: ldc 228
    //   335: iconst_1
    //   336: iconst_0
    //   337: invokestatic 226	com/tencent/tencentmap/mapsdk/a/kz:a	(Ljava/io/File;Ljava/lang/String;ZZ)V
    //   340: aload 8
    //   342: ldc 230
    //   344: iconst_1
    //   345: invokestatic 232	com/tencent/tencentmap/mapsdk/a/kz:a	(Ljava/io/File;Ljava/lang/String;Z)V
    //   348: goto +48 -> 396
    //   351: astore_0
    //   352: aload 4
    //   354: invokevirtual 216	java/io/FileOutputStream:close	()V
    //   357: aload_0
    //   358: athrow
    //   359: astore_0
    //   360: aload 4
    //   362: ifnull +8 -> 370
    //   365: aload 4
    //   367: invokevirtual 216	java/io/FileOutputStream:close	()V
    //   370: aload_0
    //   371: athrow
    //   372: aload 7
    //   374: invokevirtual 186	java/util/zip/ZipFile:close	()V
    //   377: iconst_1
    //   378: ireturn
    //   379: astore_0
    //   380: aconst_null
    //   381: astore 4
    //   383: aconst_null
    //   384: astore 5
    //   386: goto -109 -> 277
    //   389: astore_0
    //   390: aconst_null
    //   391: astore 4
    //   393: goto -116 -> 277
    //   396: iload_1
    //   397: iconst_1
    //   398: iadd
    //   399: istore_1
    //   400: goto -342 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	403	0	paramContext	Context
    //   57	343	1	i	int
    //   55	6	2	j	int
    //   259	11	3	k	int
    //   76	316	4	localObject1	Object
    //   67	318	5	localObject2	Object
    //   16	87	6	localFile1	File
    //   45	328	7	localZipFile	ZipFile
    //   115	226	8	localFile2	File
    //   50	14	9	arrayOfString	String[]
    //   250	17	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   23	56	95	java/io/IOException
    //   69	78	95	java/io/IOException
    //   83	93	95	java/io/IOException
    //   109	162	95	java/io/IOException
    //   179	218	95	java/io/IOException
    //   218	225	95	java/io/IOException
    //   372	377	95	java/io/IOException
    //   162	178	178	java/io/IOException
    //   292	297	178	java/io/IOException
    //   297	299	178	java/io/IOException
    //   309	348	178	java/io/IOException
    //   352	359	178	java/io/IOException
    //   365	370	178	java/io/IOException
    //   370	372	178	java/io/IOException
    //   245	252	276	finally
    //   252	260	276	finally
    //   264	273	276	finally
    //   304	309	351	finally
    //   282	287	359	finally
    //   225	234	379	finally
    //   234	245	389	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.kz
 * JD-Core Version:    0.7.0.1
 */