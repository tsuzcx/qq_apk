package com.tencent.smtt.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsLogReport;
import com.tencent.smtt.sdk.TbsLogReport.EventType;
import com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;

@SuppressLint({"NewApi"})
public class f
{
  public static String a;
  public static final a b;
  private static final int c;
  private static RandomAccessFile d;
  
  static
  {
    AppMethodBeat.i(53915);
    c = 4;
    a = null;
    d = null;
    b = new a()
    {
      public final boolean a(File paramAnonymousFile1, File paramAnonymousFile2)
      {
        AppMethodBeat.i(54043);
        if ((paramAnonymousFile1.length() == paramAnonymousFile2.length()) && (paramAnonymousFile1.lastModified() == paramAnonymousFile2.lastModified()))
        {
          AppMethodBeat.o(54043);
          return true;
        }
        AppMethodBeat.o(54043);
        return false;
      }
    };
    AppMethodBeat.o(53915);
  }
  
  public static File a(Context paramContext, String paramString)
  {
    AppMethodBeat.i(53906);
    paramContext = new File(paramContext.getFilesDir(), "tbs");
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    if (!paramContext.canWrite())
    {
      TbsLog.e("FileHelper", "getPermanentTbsFile -- no permission!");
      AppMethodBeat.o(53906);
      return null;
    }
    paramContext = new File(paramContext, paramString);
    if (!paramContext.exists()) {}
    try
    {
      paramContext.createNewFile();
      AppMethodBeat.o(53906);
      return paramContext;
    }
    catch (IOException paramContext)
    {
      TbsLog.e("FileHelper", "getPermanentTbsFile -- exception: ".concat(String.valueOf(paramContext)));
      AppMethodBeat.o(53906);
    }
    return null;
  }
  
  public static File a(Context paramContext, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(53905);
    if (paramBoolean) {}
    for (paramContext = d(paramContext); paramContext == null; paramContext = c(paramContext))
    {
      AppMethodBeat.o(53905);
      return null;
    }
    paramContext = new File(paramContext);
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    if (!paramContext.canWrite())
    {
      AppMethodBeat.o(53905);
      return null;
    }
    paramContext = new File(paramContext, paramString);
    if (!paramContext.exists()) {}
    try
    {
      paramContext.createNewFile();
      AppMethodBeat.o(53905);
      return paramContext;
    }
    catch (IOException paramContext)
    {
      AppMethodBeat.o(53905);
    }
    return null;
  }
  
  public static String a(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(53882);
    paramContext = a(paramContext, paramContext.getApplicationInfo().packageName, paramInt, true);
    AppMethodBeat.o(53882);
    return paramContext;
  }
  
  public static String a(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(53883);
    if (paramContext == null)
    {
      AppMethodBeat.o(53883);
      return "";
    }
    Object localObject1 = "";
    try
    {
      localObject2 = Environment.getExternalStorageDirectory() + File.separator;
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      Object localObject2;
      label49:
      label466:
      break label49;
    }
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(53883);
      return "";
    case 1: 
      if (((String)localObject1).equals(""))
      {
        AppMethodBeat.o(53883);
        return localObject1;
      }
      paramContext = (String)localObject1 + "tencent" + File.separator + "tbs" + File.separator + paramString;
      AppMethodBeat.o(53883);
      return paramContext;
    case 2: 
      if (((String)localObject1).equals(""))
      {
        AppMethodBeat.o(53883);
        return localObject1;
      }
      paramContext = (String)localObject1 + "tbs" + File.separator + "backup" + File.separator + paramString;
      AppMethodBeat.o(53883);
      return paramContext;
    case 3: 
      if (((String)localObject1).equals(""))
      {
        AppMethodBeat.o(53883);
        return localObject1;
      }
      paramContext = (String)localObject1 + "tencent" + File.separator + "tbs" + File.separator + "backup" + File.separator + paramString;
      AppMethodBeat.o(53883);
      return paramContext;
    case 4: 
      if (((String)localObject1).equals(""))
      {
        paramContext = b(paramContext, "backup");
        AppMethodBeat.o(53883);
        return paramContext;
      }
      localObject1 = (String)localObject1 + "tencent" + File.separator + "tbs" + File.separator + "backup" + File.separator + paramString;
      paramString = (String)localObject1;
      if (paramBoolean)
      {
        localObject2 = new File((String)localObject1);
        if (((File)localObject2).exists())
        {
          paramString = (String)localObject1;
          if (((File)localObject2).canWrite()) {}
        }
        else
        {
          if (((File)localObject2).exists()) {
            break label466;
          }
          ((File)localObject2).mkdirs();
          paramString = (String)localObject1;
          if (((File)localObject2).canWrite()) {}
        }
      }
      for (paramString = b(paramContext, "backup");; paramString = b(paramContext, "backup"))
      {
        AppMethodBeat.o(53883);
        return paramString;
      }
    case 5: 
      if (((String)localObject1).equals(""))
      {
        AppMethodBeat.o(53883);
        return localObject1;
      }
      paramContext = (String)localObject1 + "tencent" + File.separator + "tbs" + File.separator + paramString;
      AppMethodBeat.o(53883);
      return paramContext;
    case 6: 
      if (a != null)
      {
        paramContext = a;
        AppMethodBeat.o(53883);
        return paramContext;
      }
      paramContext = b(paramContext, "tbslog");
      a = paramContext;
      AppMethodBeat.o(53883);
      return paramContext;
    }
    if (((String)localObject1).equals(""))
    {
      AppMethodBeat.o(53883);
      return localObject1;
    }
    paramContext = (String)localObject1 + "tencent" + File.separator + "tbs" + File.separator + "backup" + File.separator + "core";
    AppMethodBeat.o(53883);
    return paramContext;
  }
  
  public static FileLock a(Context paramContext, FileOutputStream paramFileOutputStream)
  {
    AppMethodBeat.i(53908);
    if (paramFileOutputStream == null)
    {
      AppMethodBeat.o(53908);
      return null;
    }
    try
    {
      paramContext = paramFileOutputStream.getChannel().tryLock();
      boolean bool = paramContext.isValid();
      if (bool)
      {
        AppMethodBeat.o(53908);
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(53908);
      return null;
    }
    catch (OverlappingFileLockException paramContext)
    {
      label41:
      break label41;
    }
  }
  
  /* Error */
  public static void a(Context paramContext, FileLock paramFileLock)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 188
    //   5: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 76
    //   10: ldc 190
    //   12: aload_1
    //   13: invokestatic 95	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   16: invokevirtual 99	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   19: invokestatic 192	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: aload_1
    //   23: invokevirtual 195	java/nio/channels/FileLock:channel	()Ljava/nio/channels/FileChannel;
    //   26: astore_0
    //   27: aload_0
    //   28: ifnull +26 -> 54
    //   31: aload_0
    //   32: invokevirtual 198	java/nio/channels/FileChannel:isOpen	()Z
    //   35: istore_2
    //   36: iload_2
    //   37: ifeq +17 -> 54
    //   40: aload_1
    //   41: invokevirtual 201	java/nio/channels/FileLock:release	()V
    //   44: ldc 188
    //   46: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: ldc 2
    //   51: monitorexit
    //   52: return
    //   53: astore_0
    //   54: ldc 188
    //   56: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: goto -10 -> 49
    //   62: astore_0
    //   63: ldc 2
    //   65: monitorexit
    //   66: aload_0
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	paramContext	Context
    //   0	68	1	paramFileLock	FileLock
    //   35	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   40	44	53	java/io/IOException
    //   3	27	62	finally
    //   31	36	62	finally
    //   40	44	62	finally
    //   44	49	62	finally
    //   54	59	62	finally
  }
  
  public static void a(File paramFile, boolean paramBoolean)
  {
    AppMethodBeat.i(53898);
    TbsLog.i("FileUtils", "delete file,ignore=" + paramBoolean + paramFile + Log.getStackTraceString(new Throwable()));
    if ((paramFile == null) || (!paramFile.exists()))
    {
      AppMethodBeat.o(53898);
      return;
    }
    if (paramFile.isFile())
    {
      paramFile.delete();
      AppMethodBeat.o(53898);
      return;
    }
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile == null)
    {
      AppMethodBeat.o(53898);
      return;
    }
    int j = arrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      a(arrayOfFile[i], paramBoolean);
      i += 1;
    }
    if (!paramBoolean) {
      paramFile.delete();
    }
    AppMethodBeat.o(53898);
  }
  
  public static void a(File paramFile, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(53899);
    TbsLog.i("FileUtils", "delete file,ignore=" + paramBoolean + "except" + paramString + paramFile + Log.getStackTraceString(new Throwable()));
    if ((paramFile == null) || (!paramFile.exists()))
    {
      AppMethodBeat.o(53899);
      return;
    }
    if (paramFile.isFile())
    {
      paramFile.delete();
      AppMethodBeat.o(53899);
      return;
    }
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile == null)
    {
      AppMethodBeat.o(53899);
      return;
    }
    int j = arrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      File localFile = arrayOfFile[i];
      if (!localFile.getName().equals(paramString)) {
        a(localFile, paramBoolean);
      }
      i += 1;
    }
    if (!paramBoolean) {
      paramFile.delete();
    }
    AppMethodBeat.o(53899);
  }
  
  public static void a(FileLock paramFileLock, FileOutputStream paramFileOutputStream)
  {
    AppMethodBeat.i(53909);
    if (paramFileLock != null) {}
    try
    {
      FileChannel localFileChannel = paramFileLock.channel();
      if ((localFileChannel != null) && (localFileChannel.isOpen())) {
        paramFileLock.release();
      }
    }
    catch (Exception paramFileLock)
    {
      label29:
      break label29;
    }
    if (paramFileOutputStream != null) {
      try
      {
        paramFileOutputStream.close();
        AppMethodBeat.o(53909);
        return;
      }
      catch (Exception paramFileLock) {}
    }
    AppMethodBeat.o(53909);
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool = true;
    AppMethodBeat.i(53885);
    if (Build.VERSION.SDK_INT < 23)
    {
      AppMethodBeat.o(53885);
      return true;
    }
    if (paramContext != null) {
      if (paramContext.getApplicationContext().checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {}
    }
    for (;;)
    {
      AppMethodBeat.o(53885);
      return bool;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  public static boolean a(File paramFile)
  {
    AppMethodBeat.i(53896);
    if (paramFile == null)
    {
      AppMethodBeat.o(53896);
      return false;
    }
    if ((paramFile.exists()) && (paramFile.isDirectory()))
    {
      AppMethodBeat.o(53896);
      return true;
    }
    b(paramFile);
    boolean bool = paramFile.mkdirs();
    AppMethodBeat.o(53896);
    return bool;
  }
  
  public static boolean a(File paramFile1, File paramFile2)
  {
    AppMethodBeat.i(53886);
    boolean bool = a(paramFile1.getPath(), paramFile2.getPath());
    AppMethodBeat.o(53886);
    return bool;
  }
  
  public static boolean a(File paramFile1, File paramFile2, FileFilter paramFileFilter)
  {
    AppMethodBeat.i(53893);
    boolean bool = a(paramFile1, paramFile2, paramFileFilter, b);
    AppMethodBeat.o(53893);
    return bool;
  }
  
  public static boolean a(File paramFile1, File paramFile2, FileFilter paramFileFilter, a parama)
  {
    AppMethodBeat.i(53894);
    if ((paramFile1 == null) || (paramFile2 == null))
    {
      AppMethodBeat.o(53894);
      return false;
    }
    if (!paramFile1.exists())
    {
      AppMethodBeat.o(53894);
      return false;
    }
    if (paramFile1.isFile())
    {
      bool = b(paramFile1, paramFile2, paramFileFilter, parama);
      AppMethodBeat.o(53894);
      return bool;
    }
    paramFile1 = paramFile1.listFiles(paramFileFilter);
    if (paramFile1 == null)
    {
      AppMethodBeat.o(53894);
      return false;
    }
    boolean bool = true;
    int j = paramFile1.length;
    int i = 0;
    while (i < j)
    {
      parama = paramFile1[i];
      if (!a(parama, new File(paramFile2, parama.getName()), paramFileFilter)) {
        bool = false;
      }
      i += 1;
    }
    AppMethodBeat.o(53894);
    return bool;
  }
  
  private static boolean a(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(53891);
    paramString = new File(paramString);
    if (paramString.length() != paramLong1)
    {
      TbsLog.e("FileHelper", "file size doesn't match: " + paramString.length() + " vs " + paramLong1);
      AppMethodBeat.o(53891);
      return true;
    }
    try
    {
      localFileInputStream = new FileInputStream(paramString);
      try
      {
        localCRC32 = new CRC32();
        byte[] arrayOfByte = new byte[8192];
        for (;;)
        {
          int i = localFileInputStream.read(arrayOfByte);
          if (i <= 0) {
            break;
          }
          localCRC32.update(arrayOfByte, 0, i);
        }
        if (localFileInputStream == null) {
          break label131;
        }
      }
      finally {}
    }
    finally
    {
      for (;;)
      {
        CRC32 localCRC32;
        FileInputStream localFileInputStream = null;
      }
    }
    localFileInputStream.close();
    label131:
    AppMethodBeat.o(53891);
    throw paramString;
    paramLong1 = localCRC32.getValue();
    TbsLog.i("FileHelper", paramString.getName() + ": crc = " + paramLong1 + ", zipCrc = " + paramLong3);
    if (paramLong1 != paramLong3)
    {
      localFileInputStream.close();
      AppMethodBeat.o(53891);
      return true;
    }
    localFileInputStream.close();
    AppMethodBeat.o(53891);
    return false;
  }
  
  @SuppressLint({"InlinedApi"})
  public static boolean a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(53887);
    String str2 = Build.CPU_ABI;
    if (Build.VERSION.SDK_INT >= 8) {}
    for (String str1 = Build.CPU_ABI2;; str1 = null)
    {
      boolean bool = a(paramString1, paramString2, str2, str1, j.a("ro.product.cpu.upgradeabi", "armeabi"));
      AppMethodBeat.o(53887);
      return bool;
    }
  }
  
  /* Error */
  private static boolean a(String paramString1, String paramString2, String paramString3, String paramString4, b paramb)
  {
    // Byte code:
    //   0: ldc_w 355
    //   3: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 76
    //   8: ldc_w 357
    //   11: aload_0
    //   12: invokestatic 95	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   15: invokevirtual 99	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   18: invokestatic 359	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: new 361	java/util/zip/ZipFile
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 362	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   29: astore_0
    //   30: iconst_0
    //   31: istore 6
    //   33: iconst_0
    //   34: istore 5
    //   36: aload_0
    //   37: invokevirtual 366	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   40: astore 10
    //   42: aload 10
    //   44: invokeinterface 371 1 0
    //   49: ifeq +490 -> 539
    //   52: aload 10
    //   54: invokeinterface 375 1 0
    //   59: checkcast 377	java/util/zip/ZipEntry
    //   62: astore 11
    //   64: aload 11
    //   66: invokevirtual 378	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   69: astore 13
    //   71: aload 13
    //   73: ifnull -31 -> 42
    //   76: aload 13
    //   78: ldc_w 380
    //   81: invokevirtual 384	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   84: ifne -42 -> 42
    //   87: aload 13
    //   89: ldc_w 386
    //   92: invokevirtual 390	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   95: ifne +14 -> 109
    //   98: aload 13
    //   100: ldc_w 392
    //   103: invokevirtual 390	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   106: ifeq -64 -> 42
    //   109: aload 13
    //   111: aload 13
    //   113: bipush 47
    //   115: invokevirtual 396	java/lang/String:lastIndexOf	(I)I
    //   118: invokevirtual 400	java/lang/String:substring	(I)Ljava/lang/String;
    //   121: astore 12
    //   123: iload 5
    //   125: istore 7
    //   127: iload 6
    //   129: istore 8
    //   131: aload 12
    //   133: ldc_w 402
    //   136: invokevirtual 405	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   139: ifeq +45 -> 184
    //   142: aload 13
    //   144: getstatic 34	com/tencent/smtt/utils/f:c	I
    //   147: aload_1
    //   148: iconst_0
    //   149: aload_1
    //   150: invokevirtual 408	java/lang/String:length	()I
    //   153: invokevirtual 412	java/lang/String:regionMatches	(ILjava/lang/String;II)Z
    //   156: ifeq +82 -> 238
    //   159: aload 13
    //   161: getstatic 34	com/tencent/smtt/utils/f:c	I
    //   164: aload_1
    //   165: invokevirtual 408	java/lang/String:length	()I
    //   168: iadd
    //   169: invokevirtual 416	java/lang/String:charAt	(I)C
    //   172: bipush 47
    //   174: if_icmpne +64 -> 238
    //   177: iconst_1
    //   178: istore 8
    //   180: iload 5
    //   182: istore 7
    //   184: aload_0
    //   185: aload 11
    //   187: invokevirtual 420	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   190: astore 13
    //   192: aload 4
    //   194: aload 13
    //   196: aload 11
    //   198: aload 12
    //   200: iconst_1
    //   201: invokevirtual 400	java/lang/String:substring	(I)Ljava/lang/String;
    //   204: invokeinterface 423 4 0
    //   209: istore 9
    //   211: iload 9
    //   213: ifne +278 -> 491
    //   216: aload 13
    //   218: ifnull +8 -> 226
    //   221: aload 13
    //   223: invokevirtual 426	java/io/InputStream:close	()V
    //   226: aload_0
    //   227: invokevirtual 427	java/util/zip/ZipFile:close	()V
    //   230: ldc_w 355
    //   233: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   236: iconst_0
    //   237: ireturn
    //   238: aload_2
    //   239: ifnull +110 -> 349
    //   242: aload 13
    //   244: getstatic 34	com/tencent/smtt/utils/f:c	I
    //   247: aload_2
    //   248: iconst_0
    //   249: aload_2
    //   250: invokevirtual 408	java/lang/String:length	()I
    //   253: invokevirtual 412	java/lang/String:regionMatches	(ILjava/lang/String;II)Z
    //   256: ifeq +93 -> 349
    //   259: aload 13
    //   261: getstatic 34	com/tencent/smtt/utils/f:c	I
    //   264: aload_2
    //   265: invokevirtual 408	java/lang/String:length	()I
    //   268: iadd
    //   269: invokevirtual 416	java/lang/String:charAt	(I)C
    //   272: bipush 47
    //   274: if_icmpne +75 -> 349
    //   277: iconst_1
    //   278: istore 7
    //   280: iconst_1
    //   281: istore 5
    //   283: iload 6
    //   285: ifeq +42 -> 327
    //   288: ldc 76
    //   290: ldc_w 429
    //   293: aload_2
    //   294: invokestatic 95	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   297: invokevirtual 99	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   300: invokestatic 359	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   303: goto -261 -> 42
    //   306: astore_2
    //   307: aload_0
    //   308: astore_1
    //   309: aload_2
    //   310: astore_0
    //   311: aload_1
    //   312: ifnull +7 -> 319
    //   315: aload_1
    //   316: invokevirtual 427	java/util/zip/ZipFile:close	()V
    //   319: ldc_w 355
    //   322: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   325: aload_0
    //   326: athrow
    //   327: ldc 76
    //   329: ldc_w 431
    //   332: aload_2
    //   333: invokestatic 95	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   336: invokevirtual 99	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   339: invokestatic 359	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   342: iload 6
    //   344: istore 8
    //   346: goto -162 -> 184
    //   349: aload_3
    //   350: ifnull +92 -> 442
    //   353: aload 13
    //   355: getstatic 34	com/tencent/smtt/utils/f:c	I
    //   358: aload_3
    //   359: iconst_0
    //   360: aload_3
    //   361: invokevirtual 408	java/lang/String:length	()I
    //   364: invokevirtual 412	java/lang/String:regionMatches	(ILjava/lang/String;II)Z
    //   367: ifeq +75 -> 442
    //   370: aload 13
    //   372: getstatic 34	com/tencent/smtt/utils/f:c	I
    //   375: aload_3
    //   376: invokevirtual 408	java/lang/String:length	()I
    //   379: iadd
    //   380: invokevirtual 416	java/lang/String:charAt	(I)C
    //   383: bipush 47
    //   385: if_icmpne +57 -> 442
    //   388: iload 6
    //   390: ifne +8 -> 398
    //   393: iload 5
    //   395: ifeq +21 -> 416
    //   398: ldc 76
    //   400: ldc_w 433
    //   403: aload_3
    //   404: invokestatic 95	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   407: invokevirtual 99	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   410: invokestatic 359	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   413: goto -371 -> 42
    //   416: ldc 76
    //   418: ldc_w 435
    //   421: aload_3
    //   422: invokestatic 95	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   425: invokevirtual 99	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   428: invokestatic 359	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   431: iload 5
    //   433: istore 7
    //   435: iload 6
    //   437: istore 8
    //   439: goto -255 -> 184
    //   442: new 130	java/lang/StringBuilder
    //   445: dup
    //   446: ldc_w 437
    //   449: invokespecial 208	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   452: aload 13
    //   454: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: ldc_w 439
    //   460: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: aload_1
    //   464: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: ldc_w 441
    //   470: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: aload_2
    //   474: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: ldc_w 443
    //   480: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: aload_3
    //   484: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: pop
    //   488: goto -446 -> 42
    //   491: iload 7
    //   493: istore 5
    //   495: iload 8
    //   497: istore 6
    //   499: aload 13
    //   501: ifnull -459 -> 42
    //   504: aload 13
    //   506: invokevirtual 426	java/io/InputStream:close	()V
    //   509: iload 7
    //   511: istore 5
    //   513: iload 8
    //   515: istore 6
    //   517: goto -475 -> 42
    //   520: astore_1
    //   521: aload 13
    //   523: ifnull +8 -> 531
    //   526: aload 13
    //   528: invokevirtual 426	java/io/InputStream:close	()V
    //   531: ldc_w 355
    //   534: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   537: aload_1
    //   538: athrow
    //   539: aload_0
    //   540: invokevirtual 427	java/util/zip/ZipFile:close	()V
    //   543: ldc_w 355
    //   546: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   549: iconst_1
    //   550: ireturn
    //   551: astore_0
    //   552: aconst_null
    //   553: astore_1
    //   554: goto -243 -> 311
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	557	0	paramString1	String
    //   0	557	1	paramString2	String
    //   0	557	2	paramString3	String
    //   0	557	3	paramString4	String
    //   0	557	4	paramb	b
    //   34	478	5	i	int
    //   31	485	6	j	int
    //   125	385	7	k	int
    //   129	385	8	m	int
    //   209	3	9	bool	boolean
    //   40	13	10	localEnumeration	java.util.Enumeration
    //   62	135	11	localZipEntry	ZipEntry
    //   121	78	12	str	String
    //   69	458	13	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   36	42	306	finally
    //   42	71	306	finally
    //   76	109	306	finally
    //   109	123	306	finally
    //   131	177	306	finally
    //   184	192	306	finally
    //   221	226	306	finally
    //   242	277	306	finally
    //   288	303	306	finally
    //   327	342	306	finally
    //   353	388	306	finally
    //   398	413	306	finally
    //   416	431	306	finally
    //   442	488	306	finally
    //   504	509	306	finally
    //   526	531	306	finally
    //   531	539	306	finally
    //   192	211	520	finally
    //   21	30	551	finally
  }
  
  private static boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(53888);
    boolean bool = a(paramString1, paramString3, paramString4, paramString5, new b()
    {
      public final boolean a(InputStream paramAnonymousInputStream, ZipEntry paramAnonymousZipEntry, String paramAnonymousString)
      {
        AppMethodBeat.i(54004);
        try
        {
          boolean bool = f.a(paramAnonymousInputStream, paramAnonymousZipEntry, this.a, paramAnonymousString);
          AppMethodBeat.o(54004);
          return bool;
        }
        catch (Exception paramAnonymousInputStream)
        {
          paramAnonymousInputStream = new Exception("copyFileIfChanged Exception", paramAnonymousInputStream);
          AppMethodBeat.o(54004);
          throw paramAnonymousInputStream;
        }
      }
    });
    AppMethodBeat.o(53888);
    return bool;
  }
  
  public static FileOutputStream b(Context paramContext, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(53907);
    paramContext = a(paramContext, paramBoolean, paramString);
    if (paramContext != null) {
      try
      {
        paramContext = new FileOutputStream(paramContext);
        AppMethodBeat.o(53907);
        return paramContext;
      }
      catch (FileNotFoundException paramContext) {}
    }
    AppMethodBeat.o(53907);
    return null;
  }
  
  private static String b(Context paramContext, String paramString)
  {
    AppMethodBeat.i(53884);
    if (paramContext == null)
    {
      AppMethodBeat.o(53884);
      return "";
    }
    Object localObject = paramContext.getApplicationContext();
    if (localObject == null) {}
    for (;;)
    {
      try
      {
        localObject = paramContext.getExternalFilesDir(paramString).getAbsolutePath();
        paramContext = (Context)localObject;
      }
      catch (Throwable localThrowable)
      {
        try
        {
          paramContext = Environment.getExternalStorageDirectory() + File.separator + "Android" + File.separator + "data" + File.separator + paramContext.getApplicationInfo().packageName + File.separator + "files" + File.separator + paramString;
        }
        catch (Exception paramContext)
        {
          AppMethodBeat.o(53884);
          return "";
        }
      }
      AppMethodBeat.o(53884);
      return paramContext;
      paramContext = localThrowable;
    }
  }
  
  public static void b(File paramFile)
  {
    AppMethodBeat.i(53897);
    a(paramFile, false);
    AppMethodBeat.o(53897);
  }
  
  public static boolean b(Context paramContext)
  {
    AppMethodBeat.i(53902);
    long l = r.a();
    if (l >= TbsDownloadConfig.getInstance(paramContext).getDownloadMinFreeSpace()) {}
    for (boolean bool = true;; bool = false)
    {
      if (!bool) {
        TbsLog.e("TbsDownload", "[TbsApkDwonloader.hasEnoughFreeSpace] freeSpace too small,  freeSpace = ".concat(String.valueOf(l)));
      }
      AppMethodBeat.o(53902);
      return bool;
    }
  }
  
  public static boolean b(File paramFile1, File paramFile2)
  {
    AppMethodBeat.i(53892);
    boolean bool = a(paramFile1, paramFile2, null);
    AppMethodBeat.o(53892);
    return bool;
  }
  
  /* Error */
  private static boolean b(File paramFile1, File paramFile2, FileFilter paramFileFilter, a parama)
  {
    // Byte code:
    //   0: ldc_w 492
    //   3: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 130	java/lang/StringBuilder
    //   9: dup
    //   10: ldc_w 494
    //   13: invokespecial 208	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   16: aload_0
    //   17: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   20: ldc_w 496
    //   23: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_1
    //   27: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   30: ldc_w 498
    //   33: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_2
    //   37: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload_0
    //   42: ifnull +7 -> 49
    //   45: aload_1
    //   46: ifnonnull +11 -> 57
    //   49: ldc_w 492
    //   52: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: iconst_0
    //   56: ireturn
    //   57: aload_2
    //   58: ifnull +21 -> 79
    //   61: aload_2
    //   62: aload_0
    //   63: invokeinterface 503 2 0
    //   68: ifne +11 -> 79
    //   71: ldc_w 492
    //   74: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: iconst_0
    //   78: ireturn
    //   79: aload_0
    //   80: invokevirtual 68	java/io/File:exists	()Z
    //   83: ifeq +14 -> 97
    //   86: aload_0
    //   87: invokevirtual 223	java/io/File:isFile	()Z
    //   90: istore 4
    //   92: iload 4
    //   94: ifne +11 -> 105
    //   97: ldc_w 492
    //   100: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: iconst_0
    //   104: ireturn
    //   105: aload_1
    //   106: invokevirtual 68	java/io/File:exists	()Z
    //   109: ifeq +34 -> 143
    //   112: aload_3
    //   113: ifnull +26 -> 139
    //   116: aload_3
    //   117: aload_0
    //   118: aload_1
    //   119: invokeinterface 505 3 0
    //   124: istore 4
    //   126: iload 4
    //   128: ifeq +11 -> 139
    //   131: ldc_w 492
    //   134: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: iconst_1
    //   138: ireturn
    //   139: aload_1
    //   140: invokestatic 269	com/tencent/smtt/utils/f:b	(Ljava/io/File;)V
    //   143: aload_1
    //   144: invokevirtual 508	java/io/File:getParentFile	()Ljava/io/File;
    //   147: astore_2
    //   148: aload_2
    //   149: invokevirtual 223	java/io/File:isFile	()Z
    //   152: ifeq +7 -> 159
    //   155: aload_2
    //   156: invokestatic 269	com/tencent/smtt/utils/f:b	(Ljava/io/File;)V
    //   159: aload_2
    //   160: invokevirtual 68	java/io/File:exists	()Z
    //   163: ifne +22 -> 185
    //   166: aload_2
    //   167: invokevirtual 71	java/io/File:mkdirs	()Z
    //   170: istore 4
    //   172: iload 4
    //   174: ifne +11 -> 185
    //   177: ldc_w 492
    //   180: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   183: iconst_0
    //   184: ireturn
    //   185: new 309	java/io/FileInputStream
    //   188: dup
    //   189: aload_0
    //   190: invokespecial 311	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   193: invokevirtual 509	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   196: astore_0
    //   197: new 171	java/io/FileOutputStream
    //   200: dup
    //   201: aload_1
    //   202: invokespecial 454	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   205: invokevirtual 175	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   208: astore_2
    //   209: aload_0
    //   210: invokevirtual 512	java/nio/channels/FileChannel:size	()J
    //   213: lstore 5
    //   215: aload_2
    //   216: aload_0
    //   217: lconst_0
    //   218: lload 5
    //   220: invokevirtual 516	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   223: lload 5
    //   225: lcmp
    //   226: ifeq +31 -> 257
    //   229: aload_1
    //   230: invokestatic 269	com/tencent/smtt/utils/f:b	(Ljava/io/File;)V
    //   233: aload_0
    //   234: ifnull +7 -> 241
    //   237: aload_0
    //   238: invokevirtual 517	java/nio/channels/FileChannel:close	()V
    //   241: aload_2
    //   242: ifnull +7 -> 249
    //   245: aload_2
    //   246: invokevirtual 517	java/nio/channels/FileChannel:close	()V
    //   249: ldc_w 492
    //   252: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   255: iconst_0
    //   256: ireturn
    //   257: aload_0
    //   258: ifnull +7 -> 265
    //   261: aload_0
    //   262: invokevirtual 517	java/nio/channels/FileChannel:close	()V
    //   265: aload_2
    //   266: ifnull +7 -> 273
    //   269: aload_2
    //   270: invokevirtual 517	java/nio/channels/FileChannel:close	()V
    //   273: ldc_w 492
    //   276: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   279: iconst_1
    //   280: ireturn
    //   281: astore_0
    //   282: aconst_null
    //   283: astore_1
    //   284: aconst_null
    //   285: astore_2
    //   286: aload_2
    //   287: ifnull +7 -> 294
    //   290: aload_2
    //   291: invokevirtual 517	java/nio/channels/FileChannel:close	()V
    //   294: aload_1
    //   295: ifnull +7 -> 302
    //   298: aload_1
    //   299: invokevirtual 517	java/nio/channels/FileChannel:close	()V
    //   302: ldc_w 492
    //   305: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   308: aload_0
    //   309: athrow
    //   310: astore_1
    //   311: aconst_null
    //   312: astore_3
    //   313: aload_0
    //   314: astore_2
    //   315: aload_1
    //   316: astore_0
    //   317: aload_3
    //   318: astore_1
    //   319: goto -33 -> 286
    //   322: astore_3
    //   323: aload_2
    //   324: astore_1
    //   325: aload_0
    //   326: astore_2
    //   327: aload_3
    //   328: astore_0
    //   329: goto -43 -> 286
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	332	0	paramFile1	File
    //   0	332	1	paramFile2	File
    //   0	332	2	paramFileFilter	FileFilter
    //   0	332	3	parama	a
    //   90	83	4	bool	boolean
    //   213	11	5	l	long
    // Exception table:
    //   from	to	target	type
    //   79	92	281	finally
    //   105	112	281	finally
    //   116	126	281	finally
    //   139	143	281	finally
    //   143	159	281	finally
    //   159	172	281	finally
    //   185	197	281	finally
    //   197	209	310	finally
    //   209	233	322	finally
  }
  
  /* Error */
  @SuppressLint({"NewApi"})
  private static boolean b(InputStream paramInputStream, ZipEntry paramZipEntry, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 518
    //   3: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 53	java/io/File
    //   9: dup
    //   10: aload_2
    //   11: invokespecial 109	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: invokestatic 520	com/tencent/smtt/utils/f:a	(Ljava/io/File;)Z
    //   17: pop
    //   18: new 130	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   25: aload_2
    //   26: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: getstatic 143	java/io/File:separator	Ljava/lang/String;
    //   32: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_3
    //   36: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: astore 5
    //   44: new 53	java/io/File
    //   47: dup
    //   48: aload 5
    //   50: invokespecial 109	java/io/File:<init>	(Ljava/lang/String;)V
    //   53: astore_3
    //   54: new 171	java/io/FileOutputStream
    //   57: dup
    //   58: aload_3
    //   59: invokespecial 454	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   62: astore_2
    //   63: sipush 8192
    //   66: newarray byte
    //   68: astore 6
    //   70: aload_0
    //   71: aload 6
    //   73: invokevirtual 521	java/io/InputStream:read	([B)I
    //   76: istore 4
    //   78: iload 4
    //   80: ifle +85 -> 165
    //   83: aload_2
    //   84: aload 6
    //   86: iconst_0
    //   87: iload 4
    //   89: invokevirtual 524	java/io/FileOutputStream:write	([BII)V
    //   92: goto -22 -> 70
    //   95: astore_1
    //   96: aload_2
    //   97: astore_0
    //   98: new 130	java/lang/StringBuilder
    //   101: dup
    //   102: ldc_w 526
    //   105: invokespecial 208	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   108: aload_3
    //   109: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload_3
    //   114: invokestatic 269	com/tencent/smtt/utils/f:b	(Ljava/io/File;)V
    //   117: new 50	java/io/IOException
    //   120: dup
    //   121: ldc_w 526
    //   124: aload_3
    //   125: invokestatic 95	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   128: invokevirtual 99	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   131: aload_1
    //   132: invokespecial 529	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   135: astore_1
    //   136: ldc_w 518
    //   139: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   142: aload_1
    //   143: athrow
    //   144: astore_2
    //   145: aload_0
    //   146: astore_1
    //   147: aload_2
    //   148: astore_0
    //   149: aload_1
    //   150: ifnull +7 -> 157
    //   153: aload_1
    //   154: invokevirtual 244	java/io/FileOutputStream:close	()V
    //   157: ldc_w 518
    //   160: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   163: aload_0
    //   164: athrow
    //   165: aload_2
    //   166: invokevirtual 244	java/io/FileOutputStream:close	()V
    //   169: aload 5
    //   171: aload_1
    //   172: invokevirtual 532	java/util/zip/ZipEntry:getSize	()J
    //   175: aload_1
    //   176: invokevirtual 535	java/util/zip/ZipEntry:getTime	()J
    //   179: aload_1
    //   180: invokevirtual 538	java/util/zip/ZipEntry:getCrc	()J
    //   183: invokestatic 540	com/tencent/smtt/utils/f:a	(Ljava/lang/String;JJJ)Z
    //   186: ifeq +27 -> 213
    //   189: ldc 76
    //   191: ldc_w 542
    //   194: aload 5
    //   196: invokestatic 95	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   199: invokevirtual 99	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   202: invokestatic 84	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   205: ldc_w 518
    //   208: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   211: iconst_0
    //   212: ireturn
    //   213: aload_3
    //   214: aload_1
    //   215: invokevirtual 535	java/util/zip/ZipEntry:getTime	()J
    //   218: invokevirtual 546	java/io/File:setLastModified	(J)Z
    //   221: ifne +18 -> 239
    //   224: ldc 76
    //   226: ldc_w 548
    //   229: aload_3
    //   230: invokestatic 95	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   233: invokevirtual 99	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   236: invokestatic 84	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   239: ldc_w 518
    //   242: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   245: iconst_1
    //   246: ireturn
    //   247: astore_0
    //   248: aconst_null
    //   249: astore_1
    //   250: goto -101 -> 149
    //   253: astore_0
    //   254: aload_2
    //   255: astore_1
    //   256: goto -107 -> 149
    //   259: astore_1
    //   260: aconst_null
    //   261: astore_0
    //   262: goto -164 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	265	0	paramInputStream	InputStream
    //   0	265	1	paramZipEntry	ZipEntry
    //   0	265	2	paramString1	String
    //   0	265	3	paramString2	String
    //   76	12	4	i	int
    //   42	153	5	str	String
    //   68	17	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   63	70	95	java/io/IOException
    //   70	78	95	java/io/IOException
    //   83	92	95	java/io/IOException
    //   98	144	144	finally
    //   54	63	247	finally
    //   63	70	253	finally
    //   70	78	253	finally
    //   83	92	253	finally
    //   54	63	259	java/io/IOException
  }
  
  public static String c(Context paramContext)
  {
    AppMethodBeat.i(53903);
    paramContext = Environment.getExternalStorageDirectory() + File.separator + "tbs" + File.separator + "file_locks";
    AppMethodBeat.o(53903);
    return paramContext;
  }
  
  public static boolean c(File paramFile)
  {
    AppMethodBeat.i(53900);
    if ((paramFile != null) && (paramFile.exists()) && (paramFile.isFile()) && (paramFile.length() > 0L))
    {
      AppMethodBeat.o(53900);
      return true;
    }
    AppMethodBeat.o(53900);
    return false;
  }
  
  public static FileOutputStream d(File paramFile)
  {
    AppMethodBeat.i(53901);
    if (paramFile.exists())
    {
      if (paramFile.isDirectory())
      {
        paramFile = new IOException("File '" + paramFile + "' exists but is a directory");
        AppMethodBeat.o(53901);
        throw paramFile;
      }
      if (!paramFile.canWrite())
      {
        paramFile = new IOException("File '" + paramFile + "' cannot be written to");
        AppMethodBeat.o(53901);
        throw paramFile;
      }
    }
    else
    {
      File localFile = paramFile.getParentFile();
      if ((localFile != null) && (!localFile.exists()) && (!localFile.mkdirs()))
      {
        paramFile = new IOException("File '" + paramFile + "' could not be created");
        AppMethodBeat.o(53901);
        throw paramFile;
      }
    }
    paramFile = new FileOutputStream(paramFile);
    AppMethodBeat.o(53901);
    return paramFile;
  }
  
  static String d(Context paramContext)
  {
    AppMethodBeat.i(53904);
    paramContext = new File(QbSdk.getTbsFolderDir(paramContext), "core_private");
    if ((!paramContext.isDirectory()) && (!paramContext.mkdir()))
    {
      AppMethodBeat.o(53904);
      return null;
    }
    paramContext = paramContext.getAbsolutePath();
    AppMethodBeat.o(53904);
    return paramContext;
  }
  
  public static FileLock e(Context paramContext)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(53910);
    TbsLog.i("FileHelper", "getTbsCoreLoadFileLock #1");
    try
    {
      bool = TbsDownloadConfig.getInstance().getTbsCoreLoadRenameFileLockEnable();
      if (!bool)
      {
        localObject1 = b(paramContext, true, "tbs_rename_lock");
        if (localObject1 == null)
        {
          TbsLog.i("FileHelper", "init -- failed to get rename fileLock#1!");
          paramContext = (Context)localObject2;
          TbsLog.i("FileHelper", "getTbsCoreLoadFileLock #2 renameFileLock is ".concat(String.valueOf(paramContext)));
          AppMethodBeat.o(53910);
          return paramContext;
        }
      }
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        boolean bool = true;
        continue;
        paramContext = a(paramContext, (FileOutputStream)localObject1);
        if (paramContext == null) {
          TbsLog.i("FileHelper", "init -- failed to get rename fileLock#2!");
        } else {
          TbsLog.i("FileHelper", "init -- get rename fileLock success!");
        }
      }
      TbsLog.i("FileHelper", "getTbsCoreLoadFileLock #3");
      localObject2 = a(paramContext, "tbs_rename_lock");
      TbsLog.i("FileHelper", "getTbsCoreLoadFileLock #4 ".concat(String.valueOf(localObject2)));
    }
    try
    {
      localObject2 = new RandomAccessFile(((File)localObject2).getAbsolutePath(), "r");
      d = (RandomAccessFile)localObject2;
      localObject2 = ((RandomAccessFile)localObject2).getChannel().tryLock(0L, 9223372036854775807L, true);
      localObject1 = localObject2;
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        TbsLog.e("FileHelper", "getTbsCoreLoadFileLock -- exception: ".concat(String.valueOf(localThrowable1)));
        continue;
        TbsLog.i("FileHelper", "getTbsCoreLoadFileLock -- success: ".concat(String.valueOf("tbs_rename_lock")));
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = g(paramContext);
    }
    if (localObject2 == null)
    {
      TbsLog.i("FileHelper", "getTbsCoreLoadFileLock -- failed: ".concat(String.valueOf("tbs_rename_lock")));
      AppMethodBeat.o(53910);
      return localObject2;
    }
  }
  
  public static FileLock f(Context paramContext)
  {
    AppMethodBeat.i(53912);
    TbsLog.d("FileHelper", "getTbsCoreRenameFileLock begin");
    Object localObject = null;
    paramContext = a(paramContext, "tbs_rename_lock");
    TbsLog.i("FileHelper", "getTbsCoreRenameFileLock #1 ".concat(String.valueOf(paramContext)));
    try
    {
      paramContext = new RandomAccessFile(paramContext.getAbsolutePath(), "rw");
      d = paramContext;
      paramContext = paramContext.getChannel().tryLock(0L, 9223372036854775807L, false);
      if (paramContext == null)
      {
        TbsLog.i("FileHelper", "getTbsCoreRenameFileLock -- failed: ".concat(String.valueOf("tbs_rename_lock")));
        AppMethodBeat.o(53912);
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        TbsLog.e("FileHelper", "getTbsCoreRenameFileLock -- excpetion: ".concat(String.valueOf("tbs_rename_lock")));
        paramContext = localObject;
        continue;
        TbsLog.i("FileHelper", "getTbsCoreRenameFileLock -- success: ".concat(String.valueOf("tbs_rename_lock")));
      }
    }
  }
  
  private static FileLock g(Context paramContext)
  {
    AppMethodBeat.i(53911);
    localObject1 = null;
    Object localObject4 = null;
    localObject3 = null;
    localObject2 = localObject4;
    try
    {
      localTbsLogInfo = TbsLogReport.getInstance(paramContext).tbsLogInfo();
      localObject2 = localObject4;
      localTbsLogInfo.setErrorCode(803);
      localObject2 = localObject4;
      localFile = a(paramContext, "tbs_rename_lock");
      localObject2 = localObject4;
      bool = TbsDownloadConfig.getInstance(paramContext).getTbsCoreLoadRenameFileLockWaitEnable();
      if (!bool) {
        break label221;
      }
      i = 0;
      localObject1 = localObject3;
    }
    catch (Exception paramContext)
    {
      try
      {
        TbsLogReport.TbsLogInfo localTbsLogInfo;
        int i;
        for (;;)
        {
          File localFile;
          Thread.sleep(100L);
          localObject2 = localObject1;
          localObject3 = new RandomAccessFile(localFile.getAbsolutePath(), "r");
          localObject2 = localObject1;
          d = (RandomAccessFile)localObject3;
          localObject2 = localObject1;
          localObject3 = ((RandomAccessFile)localObject3).getChannel().tryLock(0L, 9223372036854775807L, true);
          localObject1 = localObject3;
          i += 1;
        }
        if (localObject1 == null) {
          break label229;
        }
        localObject2 = localObject1;
        localTbsLogInfo.setErrorCode(802);
        localObject2 = localObject1;
        TbsLogReport.getInstance(paramContext).eventReport(TbsLogReport.EventType.TYPE_SDK_REPORT_INFO, localTbsLogInfo);
        localObject2 = localObject1;
        paramContext = new StringBuilder("getTbsCoreLoadFileLock,retry num=").append(i).append("success=");
        if (localObject1 != null) {
          break label250;
        }
        for (boolean bool = true;; bool = false)
        {
          localObject2 = localObject1;
          TbsLog.i("FileHelper", bool);
          for (;;)
          {
            AppMethodBeat.o(53911);
            return localObject1;
            localObject2 = localObject1;
            localTbsLogInfo.setErrorCode(801);
            break;
            paramContext = paramContext;
            localObject1 = localObject2;
          }
        }
      }
      catch (Exception localException)
      {
        break label89;
      }
      catch (Throwable localThrowable)
      {
        break label138;
      }
    }
    if ((i >= 20) || (localObject1 != null)) {}
  }
  
  public static abstract interface a
  {
    public abstract boolean a(File paramFile1, File paramFile2);
  }
  
  public static abstract interface b
  {
    public abstract boolean a(InputStream paramInputStream, ZipEntry paramZipEntry, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.utils.f
 * JD-Core Version:    0.7.0.1
 */