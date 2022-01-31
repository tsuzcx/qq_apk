package com.tencent.smtt.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.zip.CRC32;

@SuppressLint({"NewApi"})
public class k
{
  public static String a;
  public static final k.a b;
  private static final int c;
  private static RandomAccessFile d;
  
  static
  {
    AppMethodBeat.i(65253);
    c = 4;
    a = null;
    d = null;
    b = new m();
    AppMethodBeat.o(65253);
  }
  
  public static File a(Context paramContext, String paramString)
  {
    AppMethodBeat.i(139522);
    paramContext = new File(paramContext.getFilesDir(), "tbs");
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    if (!paramContext.canWrite())
    {
      TbsLog.e("FileHelper", "getPermanentTbsFile -- no permission!");
      AppMethodBeat.o(139522);
      return null;
    }
    paramContext = new File(paramContext, paramString);
    if (!paramContext.exists()) {}
    try
    {
      paramContext.createNewFile();
      AppMethodBeat.o(139522);
      return paramContext;
    }
    catch (IOException paramContext)
    {
      TbsLog.e("FileHelper", "getPermanentTbsFile -- exception: ".concat(String.valueOf(paramContext)));
      AppMethodBeat.o(139522);
    }
    return null;
  }
  
  public static File a(Context paramContext, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(65244);
    if (paramBoolean) {}
    for (paramContext = d(paramContext); paramContext == null; paramContext = c(paramContext))
    {
      AppMethodBeat.o(65244);
      return null;
    }
    paramContext = new File(paramContext);
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    if (!paramContext.canWrite())
    {
      AppMethodBeat.o(65244);
      return null;
    }
    paramContext = new File(paramContext, paramString);
    if (!paramContext.exists()) {}
    try
    {
      paramContext.createNewFile();
      AppMethodBeat.o(65244);
      return paramContext;
    }
    catch (IOException paramContext)
    {
      AppMethodBeat.o(65244);
    }
    return null;
  }
  
  public static String a(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(65221);
    paramContext = a(paramContext, paramContext.getApplicationInfo().packageName, paramInt, true);
    AppMethodBeat.o(65221);
    return paramContext;
  }
  
  public static String a(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(65222);
    if (paramContext == null)
    {
      AppMethodBeat.o(65222);
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
      AppMethodBeat.o(65222);
      return "";
    case 1: 
      if (((String)localObject1).equals(""))
      {
        AppMethodBeat.o(65222);
        return localObject1;
      }
      paramContext = (String)localObject1 + "tencent" + File.separator + "tbs" + File.separator + paramString;
      AppMethodBeat.o(65222);
      return paramContext;
    case 2: 
      if (((String)localObject1).equals(""))
      {
        AppMethodBeat.o(65222);
        return localObject1;
      }
      paramContext = (String)localObject1 + "tbs" + File.separator + "backup" + File.separator + paramString;
      AppMethodBeat.o(65222);
      return paramContext;
    case 3: 
      if (((String)localObject1).equals(""))
      {
        AppMethodBeat.o(65222);
        return localObject1;
      }
      paramContext = (String)localObject1 + "tencent" + File.separator + "tbs" + File.separator + "backup" + File.separator + paramString;
      AppMethodBeat.o(65222);
      return paramContext;
    case 4: 
      if (((String)localObject1).equals(""))
      {
        paramContext = b(paramContext, "backup");
        AppMethodBeat.o(65222);
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
        AppMethodBeat.o(65222);
        return paramString;
      }
    case 5: 
      if (((String)localObject1).equals(""))
      {
        AppMethodBeat.o(65222);
        return localObject1;
      }
      paramContext = (String)localObject1 + "tencent" + File.separator + "tbs" + File.separator + paramString;
      AppMethodBeat.o(65222);
      return paramContext;
    case 6: 
      if (a != null)
      {
        paramContext = a;
        AppMethodBeat.o(65222);
        return paramContext;
      }
      paramContext = b(paramContext, "tbslog");
      a = paramContext;
      AppMethodBeat.o(65222);
      return paramContext;
    }
    if (((String)localObject1).equals(""))
    {
      AppMethodBeat.o(65222);
      return localObject1;
    }
    paramContext = (String)localObject1 + "tencent" + File.separator + "tbs" + File.separator + "backup" + File.separator + "core";
    AppMethodBeat.o(65222);
    return paramContext;
  }
  
  public static FileLock a(Context paramContext, FileOutputStream paramFileOutputStream)
  {
    AppMethodBeat.i(65246);
    if (paramFileOutputStream == null)
    {
      AppMethodBeat.o(65246);
      return null;
    }
    try
    {
      paramContext = paramFileOutputStream.getChannel().tryLock();
      boolean bool = paramContext.isValid();
      if (bool)
      {
        AppMethodBeat.o(65246);
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(65246);
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
    //   3: ldc 186
    //   5: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 74
    //   10: ldc 188
    //   12: aload_1
    //   13: invokestatic 93	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   16: invokevirtual 97	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   19: invokestatic 190	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: aload_1
    //   23: invokevirtual 193	java/nio/channels/FileLock:channel	()Ljava/nio/channels/FileChannel;
    //   26: astore_0
    //   27: aload_0
    //   28: ifnull +26 -> 54
    //   31: aload_0
    //   32: invokevirtual 196	java/nio/channels/FileChannel:isOpen	()Z
    //   35: istore_2
    //   36: iload_2
    //   37: ifeq +17 -> 54
    //   40: aload_1
    //   41: invokevirtual 199	java/nio/channels/FileLock:release	()V
    //   44: ldc 186
    //   46: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: ldc 2
    //   51: monitorexit
    //   52: return
    //   53: astore_0
    //   54: ldc 186
    //   56: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(65237);
    TbsLog.i("FileUtils", "delete file,ignore=" + paramBoolean + paramFile + Log.getStackTraceString(new Throwable()));
    if ((paramFile == null) || (!paramFile.exists()))
    {
      AppMethodBeat.o(65237);
      return;
    }
    if (paramFile.isFile())
    {
      paramFile.delete();
      AppMethodBeat.o(65237);
      return;
    }
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile == null)
    {
      AppMethodBeat.o(65237);
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
    AppMethodBeat.o(65237);
  }
  
  public static void a(File paramFile, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(65238);
    TbsLog.i("FileUtils", "delete file,ignore=" + paramBoolean + "except" + paramString + paramFile + Log.getStackTraceString(new Throwable()));
    if ((paramFile == null) || (!paramFile.exists()))
    {
      AppMethodBeat.o(65238);
      return;
    }
    if (paramFile.isFile())
    {
      paramFile.delete();
      AppMethodBeat.o(65238);
      return;
    }
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile == null)
    {
      AppMethodBeat.o(65238);
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
    AppMethodBeat.o(65238);
  }
  
  public static void a(FileLock paramFileLock, FileOutputStream paramFileOutputStream)
  {
    AppMethodBeat.i(65247);
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
        AppMethodBeat.o(65247);
        return;
      }
      catch (Exception paramFileLock) {}
    }
    AppMethodBeat.o(65247);
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool = true;
    AppMethodBeat.i(65224);
    if (Build.VERSION.SDK_INT < 23)
    {
      AppMethodBeat.o(65224);
      return true;
    }
    if (paramContext != null) {
      if (paramContext.getApplicationContext().checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {}
    }
    for (;;)
    {
      AppMethodBeat.o(65224);
      return bool;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  public static boolean a(File paramFile)
  {
    AppMethodBeat.i(65235);
    if (paramFile == null)
    {
      AppMethodBeat.o(65235);
      return false;
    }
    if ((paramFile.exists()) && (paramFile.isDirectory()))
    {
      AppMethodBeat.o(65235);
      return true;
    }
    b(paramFile);
    boolean bool = paramFile.mkdirs();
    AppMethodBeat.o(65235);
    return bool;
  }
  
  public static boolean a(File paramFile1, File paramFile2)
  {
    AppMethodBeat.i(65225);
    boolean bool = a(paramFile1.getPath(), paramFile2.getPath());
    AppMethodBeat.o(65225);
    return bool;
  }
  
  public static boolean a(File paramFile1, File paramFile2, FileFilter paramFileFilter)
  {
    AppMethodBeat.i(65232);
    boolean bool = a(paramFile1, paramFile2, paramFileFilter, b);
    AppMethodBeat.o(65232);
    return bool;
  }
  
  public static boolean a(File paramFile1, File paramFile2, FileFilter paramFileFilter, k.a parama)
  {
    AppMethodBeat.i(65233);
    if ((paramFile1 == null) || (paramFile2 == null))
    {
      AppMethodBeat.o(65233);
      return false;
    }
    if (!paramFile1.exists())
    {
      AppMethodBeat.o(65233);
      return false;
    }
    if (paramFile1.isFile())
    {
      bool = b(paramFile1, paramFile2, paramFileFilter, parama);
      AppMethodBeat.o(65233);
      return bool;
    }
    paramFile1 = paramFile1.listFiles(paramFileFilter);
    if (paramFile1 == null)
    {
      AppMethodBeat.o(65233);
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
    AppMethodBeat.o(65233);
    return bool;
  }
  
  private static boolean a(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(65230);
    paramString = new File(paramString);
    if (paramString.length() != paramLong1)
    {
      TbsLog.e("FileHelper", "file size doesn't match: " + paramString.length() + " vs " + paramLong1);
      AppMethodBeat.o(65230);
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
    AppMethodBeat.o(65230);
    throw paramString;
    paramLong1 = localCRC32.getValue();
    TbsLog.i("FileHelper", paramString.getName() + ": crc = " + paramLong1 + ", zipCrc = " + paramLong3);
    if (paramLong1 != paramLong3)
    {
      localFileInputStream.close();
      AppMethodBeat.o(65230);
      return true;
    }
    localFileInputStream.close();
    AppMethodBeat.o(65230);
    return false;
  }
  
  @SuppressLint({"InlinedApi"})
  public static boolean a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(65226);
    String str2 = Build.CPU_ABI;
    if (Build.VERSION.SDK_INT >= 8) {}
    for (String str1 = Build.CPU_ABI2;; str1 = null)
    {
      boolean bool = a(paramString1, paramString2, str2, str1, q.a("ro.product.cpu.upgradeabi", "armeabi"));
      AppMethodBeat.o(65226);
      return bool;
    }
  }
  
  /* Error */
  private static boolean a(String paramString1, String paramString2, String paramString3, String paramString4, k.b paramb)
  {
    // Byte code:
    //   0: ldc_w 353
    //   3: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 355	java/util/zip/ZipFile
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 356	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   14: astore_0
    //   15: iconst_0
    //   16: istore 6
    //   18: iconst_0
    //   19: istore 5
    //   21: aload_0
    //   22: invokevirtual 360	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   25: astore 10
    //   27: aload 10
    //   29: invokeinterface 365 1 0
    //   34: ifeq +375 -> 409
    //   37: aload 10
    //   39: invokeinterface 369 1 0
    //   44: checkcast 371	java/util/zip/ZipEntry
    //   47: astore 11
    //   49: aload 11
    //   51: invokevirtual 372	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   54: astore 13
    //   56: aload 13
    //   58: ifnull -31 -> 27
    //   61: aload 13
    //   63: ldc_w 374
    //   66: invokevirtual 378	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   69: ifne -42 -> 27
    //   72: aload 13
    //   74: ldc_w 380
    //   77: invokevirtual 384	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   80: ifne +14 -> 94
    //   83: aload 13
    //   85: ldc_w 386
    //   88: invokevirtual 384	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   91: ifeq -64 -> 27
    //   94: aload 13
    //   96: aload 13
    //   98: bipush 47
    //   100: invokevirtual 390	java/lang/String:lastIndexOf	(I)I
    //   103: invokevirtual 394	java/lang/String:substring	(I)Ljava/lang/String;
    //   106: astore 12
    //   108: iload 5
    //   110: istore 7
    //   112: iload 6
    //   114: istore 8
    //   116: aload 12
    //   118: ldc_w 396
    //   121: invokevirtual 399	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   124: ifeq +45 -> 169
    //   127: aload 13
    //   129: getstatic 30	com/tencent/smtt/utils/k:c	I
    //   132: aload_1
    //   133: iconst_0
    //   134: aload_1
    //   135: invokevirtual 402	java/lang/String:length	()I
    //   138: invokevirtual 406	java/lang/String:regionMatches	(ILjava/lang/String;II)Z
    //   141: ifeq +82 -> 223
    //   144: aload 13
    //   146: getstatic 30	com/tencent/smtt/utils/k:c	I
    //   149: aload_1
    //   150: invokevirtual 402	java/lang/String:length	()I
    //   153: iadd
    //   154: invokevirtual 410	java/lang/String:charAt	(I)C
    //   157: bipush 47
    //   159: if_icmpne +64 -> 223
    //   162: iconst_1
    //   163: istore 8
    //   165: iload 5
    //   167: istore 7
    //   169: aload_0
    //   170: aload 11
    //   172: invokevirtual 414	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   175: astore 13
    //   177: aload 4
    //   179: aload 13
    //   181: aload 11
    //   183: aload 12
    //   185: iconst_1
    //   186: invokevirtual 394	java/lang/String:substring	(I)Ljava/lang/String;
    //   189: invokeinterface 417 4 0
    //   194: istore 9
    //   196: iload 9
    //   198: ifne +142 -> 340
    //   201: aload 13
    //   203: ifnull +8 -> 211
    //   206: aload 13
    //   208: invokevirtual 420	java/io/InputStream:close	()V
    //   211: aload_0
    //   212: invokevirtual 421	java/util/zip/ZipFile:close	()V
    //   215: ldc_w 353
    //   218: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   221: iconst_0
    //   222: ireturn
    //   223: aload_2
    //   224: ifnull +56 -> 280
    //   227: aload 13
    //   229: getstatic 30	com/tencent/smtt/utils/k:c	I
    //   232: aload_2
    //   233: iconst_0
    //   234: aload_2
    //   235: invokevirtual 402	java/lang/String:length	()I
    //   238: invokevirtual 406	java/lang/String:regionMatches	(ILjava/lang/String;II)Z
    //   241: ifeq +39 -> 280
    //   244: aload 13
    //   246: getstatic 30	com/tencent/smtt/utils/k:c	I
    //   249: aload_2
    //   250: invokevirtual 402	java/lang/String:length	()I
    //   253: iadd
    //   254: invokevirtual 410	java/lang/String:charAt	(I)C
    //   257: bipush 47
    //   259: if_icmpne +21 -> 280
    //   262: iconst_1
    //   263: istore 7
    //   265: iconst_1
    //   266: istore 5
    //   268: iload 6
    //   270: istore 8
    //   272: iload 6
    //   274: ifeq -105 -> 169
    //   277: goto -250 -> 27
    //   280: aload_3
    //   281: ifnull -254 -> 27
    //   284: aload 13
    //   286: getstatic 30	com/tencent/smtt/utils/k:c	I
    //   289: aload_3
    //   290: iconst_0
    //   291: aload_3
    //   292: invokevirtual 402	java/lang/String:length	()I
    //   295: invokevirtual 406	java/lang/String:regionMatches	(ILjava/lang/String;II)Z
    //   298: ifeq -271 -> 27
    //   301: aload 13
    //   303: getstatic 30	com/tencent/smtt/utils/k:c	I
    //   306: aload_3
    //   307: invokevirtual 402	java/lang/String:length	()I
    //   310: iadd
    //   311: invokevirtual 410	java/lang/String:charAt	(I)C
    //   314: bipush 47
    //   316: if_icmpne -289 -> 27
    //   319: iload 6
    //   321: ifne -294 -> 27
    //   324: iload 5
    //   326: ifne -299 -> 27
    //   329: iload 5
    //   331: istore 7
    //   333: iload 6
    //   335: istore 8
    //   337: goto -168 -> 169
    //   340: iload 7
    //   342: istore 5
    //   344: iload 8
    //   346: istore 6
    //   348: aload 13
    //   350: ifnull -323 -> 27
    //   353: aload 13
    //   355: invokevirtual 420	java/io/InputStream:close	()V
    //   358: iload 7
    //   360: istore 5
    //   362: iload 8
    //   364: istore 6
    //   366: goto -339 -> 27
    //   369: astore_2
    //   370: aload_0
    //   371: astore_1
    //   372: aload_2
    //   373: astore_0
    //   374: aload_1
    //   375: ifnull +7 -> 382
    //   378: aload_1
    //   379: invokevirtual 421	java/util/zip/ZipFile:close	()V
    //   382: ldc_w 353
    //   385: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   388: aload_0
    //   389: athrow
    //   390: astore_1
    //   391: aload 13
    //   393: ifnull +8 -> 401
    //   396: aload 13
    //   398: invokevirtual 420	java/io/InputStream:close	()V
    //   401: ldc_w 353
    //   404: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   407: aload_1
    //   408: athrow
    //   409: aload_0
    //   410: invokevirtual 421	java/util/zip/ZipFile:close	()V
    //   413: ldc_w 353
    //   416: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   419: iconst_1
    //   420: ireturn
    //   421: astore_0
    //   422: aconst_null
    //   423: astore_1
    //   424: goto -50 -> 374
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	427	0	paramString1	String
    //   0	427	1	paramString2	String
    //   0	427	2	paramString3	String
    //   0	427	3	paramString4	String
    //   0	427	4	paramb	k.b
    //   19	342	5	i	int
    //   16	349	6	j	int
    //   110	249	7	k	int
    //   114	249	8	m	int
    //   194	3	9	bool	boolean
    //   25	13	10	localEnumeration	java.util.Enumeration
    //   47	135	11	localZipEntry	java.util.zip.ZipEntry
    //   106	78	12	str	String
    //   54	343	13	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   21	27	369	finally
    //   27	56	369	finally
    //   61	94	369	finally
    //   94	108	369	finally
    //   116	162	369	finally
    //   169	177	369	finally
    //   206	211	369	finally
    //   227	262	369	finally
    //   284	319	369	finally
    //   353	358	369	finally
    //   396	401	369	finally
    //   401	409	369	finally
    //   177	196	390	finally
    //   6	15	421	finally
  }
  
  private static boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(65227);
    boolean bool = a(paramString1, paramString3, paramString4, paramString5, new l(paramString2));
    AppMethodBeat.o(65227);
    return bool;
  }
  
  public static FileOutputStream b(Context paramContext, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(65245);
    paramContext = a(paramContext, paramBoolean, paramString);
    if (paramContext != null) {
      try
      {
        paramContext = new FileOutputStream(paramContext);
        AppMethodBeat.o(65245);
        return paramContext;
      }
      catch (FileNotFoundException paramContext) {}
    }
    AppMethodBeat.o(65245);
    return null;
  }
  
  private static String b(Context paramContext, String paramString)
  {
    AppMethodBeat.i(139521);
    if (paramContext == null)
    {
      AppMethodBeat.o(139521);
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
          AppMethodBeat.o(139521);
          return "";
        }
      }
      AppMethodBeat.o(139521);
      return paramContext;
      paramContext = localThrowable;
    }
  }
  
  public static void b(File paramFile)
  {
    AppMethodBeat.i(65236);
    a(paramFile, false);
    AppMethodBeat.o(65236);
  }
  
  public static boolean b(Context paramContext)
  {
    AppMethodBeat.i(65241);
    long l = y.a();
    if (l >= TbsDownloadConfig.getInstance(paramContext).getDownloadMinFreeSpace()) {}
    for (boolean bool = true;; bool = false)
    {
      if (!bool) {
        TbsLog.e("TbsDownload", "[TbsApkDwonloader.hasEnoughFreeSpace] freeSpace too small,  freeSpace = ".concat(String.valueOf(l)));
      }
      AppMethodBeat.o(65241);
      return bool;
    }
  }
  
  public static boolean b(File paramFile1, File paramFile2)
  {
    AppMethodBeat.i(65231);
    boolean bool = a(paramFile1, paramFile2, null);
    AppMethodBeat.o(65231);
    return bool;
  }
  
  /* Error */
  private static boolean b(File paramFile1, File paramFile2, FileFilter paramFileFilter, k.a parama)
  {
    // Byte code:
    //   0: ldc_w 472
    //   3: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnull +7 -> 14
    //   10: aload_1
    //   11: ifnonnull +11 -> 22
    //   14: ldc_w 472
    //   17: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: iconst_0
    //   21: ireturn
    //   22: aload_2
    //   23: ifnull +21 -> 44
    //   26: aload_2
    //   27: aload_0
    //   28: invokeinterface 477 2 0
    //   33: ifne +11 -> 44
    //   36: ldc_w 472
    //   39: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: iconst_0
    //   43: ireturn
    //   44: aload_0
    //   45: invokevirtual 66	java/io/File:exists	()Z
    //   48: ifeq +14 -> 62
    //   51: aload_0
    //   52: invokevirtual 221	java/io/File:isFile	()Z
    //   55: istore 4
    //   57: iload 4
    //   59: ifne +11 -> 70
    //   62: ldc_w 472
    //   65: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: iconst_0
    //   69: ireturn
    //   70: aload_1
    //   71: invokevirtual 66	java/io/File:exists	()Z
    //   74: ifeq +34 -> 108
    //   77: aload_3
    //   78: ifnull +26 -> 104
    //   81: aload_3
    //   82: aload_0
    //   83: aload_1
    //   84: invokeinterface 479 3 0
    //   89: istore 4
    //   91: iload 4
    //   93: ifeq +11 -> 104
    //   96: ldc_w 472
    //   99: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: iconst_1
    //   103: ireturn
    //   104: aload_1
    //   105: invokestatic 267	com/tencent/smtt/utils/k:b	(Ljava/io/File;)V
    //   108: aload_1
    //   109: invokevirtual 482	java/io/File:getParentFile	()Ljava/io/File;
    //   112: astore_2
    //   113: aload_2
    //   114: invokevirtual 221	java/io/File:isFile	()Z
    //   117: ifeq +7 -> 124
    //   120: aload_2
    //   121: invokestatic 267	com/tencent/smtt/utils/k:b	(Ljava/io/File;)V
    //   124: aload_2
    //   125: invokevirtual 66	java/io/File:exists	()Z
    //   128: ifne +22 -> 150
    //   131: aload_2
    //   132: invokevirtual 69	java/io/File:mkdirs	()Z
    //   135: istore 4
    //   137: iload 4
    //   139: ifne +11 -> 150
    //   142: ldc_w 472
    //   145: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   148: iconst_0
    //   149: ireturn
    //   150: new 307	java/io/FileInputStream
    //   153: dup
    //   154: aload_0
    //   155: invokespecial 309	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   158: invokevirtual 483	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   161: astore_0
    //   162: new 169	java/io/FileOutputStream
    //   165: dup
    //   166: aload_1
    //   167: invokespecial 434	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   170: invokevirtual 173	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   173: astore_2
    //   174: aload_0
    //   175: invokevirtual 486	java/nio/channels/FileChannel:size	()J
    //   178: lstore 5
    //   180: aload_2
    //   181: aload_0
    //   182: lconst_0
    //   183: lload 5
    //   185: invokevirtual 490	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   188: lload 5
    //   190: lcmp
    //   191: ifeq +31 -> 222
    //   194: aload_1
    //   195: invokestatic 267	com/tencent/smtt/utils/k:b	(Ljava/io/File;)V
    //   198: aload_0
    //   199: ifnull +7 -> 206
    //   202: aload_0
    //   203: invokevirtual 491	java/nio/channels/FileChannel:close	()V
    //   206: aload_2
    //   207: ifnull +7 -> 214
    //   210: aload_2
    //   211: invokevirtual 491	java/nio/channels/FileChannel:close	()V
    //   214: ldc_w 472
    //   217: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   220: iconst_0
    //   221: ireturn
    //   222: aload_0
    //   223: ifnull +7 -> 230
    //   226: aload_0
    //   227: invokevirtual 491	java/nio/channels/FileChannel:close	()V
    //   230: aload_2
    //   231: ifnull +7 -> 238
    //   234: aload_2
    //   235: invokevirtual 491	java/nio/channels/FileChannel:close	()V
    //   238: ldc_w 472
    //   241: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   244: iconst_1
    //   245: ireturn
    //   246: astore_0
    //   247: aconst_null
    //   248: astore_1
    //   249: aconst_null
    //   250: astore_2
    //   251: aload_2
    //   252: ifnull +7 -> 259
    //   255: aload_2
    //   256: invokevirtual 491	java/nio/channels/FileChannel:close	()V
    //   259: aload_1
    //   260: ifnull +7 -> 267
    //   263: aload_1
    //   264: invokevirtual 491	java/nio/channels/FileChannel:close	()V
    //   267: ldc_w 472
    //   270: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   273: aload_0
    //   274: athrow
    //   275: astore_1
    //   276: aconst_null
    //   277: astore_3
    //   278: aload_0
    //   279: astore_2
    //   280: aload_1
    //   281: astore_0
    //   282: aload_3
    //   283: astore_1
    //   284: goto -33 -> 251
    //   287: astore_3
    //   288: aload_2
    //   289: astore_1
    //   290: aload_0
    //   291: astore_2
    //   292: aload_3
    //   293: astore_0
    //   294: goto -43 -> 251
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	297	0	paramFile1	File
    //   0	297	1	paramFile2	File
    //   0	297	2	paramFileFilter	FileFilter
    //   0	297	3	parama	k.a
    //   55	83	4	bool	boolean
    //   178	11	5	l	long
    // Exception table:
    //   from	to	target	type
    //   44	57	246	finally
    //   70	77	246	finally
    //   81	91	246	finally
    //   104	108	246	finally
    //   108	124	246	finally
    //   124	137	246	finally
    //   150	162	246	finally
    //   162	174	275	finally
    //   174	198	287	finally
  }
  
  /* Error */
  @SuppressLint({"NewApi"})
  private static boolean b(java.io.InputStream paramInputStream, java.util.zip.ZipEntry paramZipEntry, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 492
    //   3: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 51	java/io/File
    //   9: dup
    //   10: aload_2
    //   11: invokespecial 107	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: invokestatic 494	com/tencent/smtt/utils/k:a	(Ljava/io/File;)Z
    //   17: pop
    //   18: new 128	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   25: aload_2
    //   26: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: getstatic 141	java/io/File:separator	Ljava/lang/String;
    //   32: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_3
    //   36: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: astore 5
    //   44: new 51	java/io/File
    //   47: dup
    //   48: aload 5
    //   50: invokespecial 107	java/io/File:<init>	(Ljava/lang/String;)V
    //   53: astore_3
    //   54: new 169	java/io/FileOutputStream
    //   57: dup
    //   58: aload_3
    //   59: invokespecial 434	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   62: astore_2
    //   63: sipush 8192
    //   66: newarray byte
    //   68: astore 6
    //   70: aload_0
    //   71: aload 6
    //   73: invokevirtual 495	java/io/InputStream:read	([B)I
    //   76: istore 4
    //   78: iload 4
    //   80: ifle +70 -> 150
    //   83: aload_2
    //   84: aload 6
    //   86: iconst_0
    //   87: iload 4
    //   89: invokevirtual 498	java/io/FileOutputStream:write	([BII)V
    //   92: goto -22 -> 70
    //   95: astore_1
    //   96: aload_2
    //   97: astore_0
    //   98: aload_3
    //   99: invokestatic 267	com/tencent/smtt/utils/k:b	(Ljava/io/File;)V
    //   102: new 48	java/io/IOException
    //   105: dup
    //   106: ldc_w 500
    //   109: aload_3
    //   110: invokestatic 93	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   113: invokevirtual 97	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   116: aload_1
    //   117: invokespecial 503	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   120: astore_1
    //   121: ldc_w 492
    //   124: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: aload_1
    //   128: athrow
    //   129: astore_2
    //   130: aload_0
    //   131: astore_1
    //   132: aload_2
    //   133: astore_0
    //   134: aload_1
    //   135: ifnull +7 -> 142
    //   138: aload_1
    //   139: invokevirtual 242	java/io/FileOutputStream:close	()V
    //   142: ldc_w 492
    //   145: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   148: aload_0
    //   149: athrow
    //   150: aload_2
    //   151: invokevirtual 242	java/io/FileOutputStream:close	()V
    //   154: aload 5
    //   156: aload_1
    //   157: invokevirtual 506	java/util/zip/ZipEntry:getSize	()J
    //   160: aload_1
    //   161: invokevirtual 509	java/util/zip/ZipEntry:getTime	()J
    //   164: aload_1
    //   165: invokevirtual 512	java/util/zip/ZipEntry:getCrc	()J
    //   168: invokestatic 514	com/tencent/smtt/utils/k:a	(Ljava/lang/String;JJJ)Z
    //   171: ifeq +27 -> 198
    //   174: ldc 74
    //   176: ldc_w 516
    //   179: aload 5
    //   181: invokestatic 93	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   184: invokevirtual 97	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   187: invokestatic 82	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   190: ldc_w 492
    //   193: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   196: iconst_0
    //   197: ireturn
    //   198: aload_3
    //   199: aload_1
    //   200: invokevirtual 509	java/util/zip/ZipEntry:getTime	()J
    //   203: invokevirtual 520	java/io/File:setLastModified	(J)Z
    //   206: ifne +18 -> 224
    //   209: ldc 74
    //   211: ldc_w 522
    //   214: aload_3
    //   215: invokestatic 93	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   218: invokevirtual 97	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   221: invokestatic 82	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   224: ldc_w 492
    //   227: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   230: iconst_1
    //   231: ireturn
    //   232: astore_0
    //   233: aconst_null
    //   234: astore_1
    //   235: goto -101 -> 134
    //   238: astore_0
    //   239: aload_2
    //   240: astore_1
    //   241: goto -107 -> 134
    //   244: astore_1
    //   245: aconst_null
    //   246: astore_0
    //   247: goto -149 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	250	0	paramInputStream	java.io.InputStream
    //   0	250	1	paramZipEntry	java.util.zip.ZipEntry
    //   0	250	2	paramString1	String
    //   0	250	3	paramString2	String
    //   76	12	4	i	int
    //   42	138	5	str	String
    //   68	17	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   63	70	95	java/io/IOException
    //   70	78	95	java/io/IOException
    //   83	92	95	java/io/IOException
    //   98	129	129	finally
    //   54	63	232	finally
    //   63	70	238	finally
    //   70	78	238	finally
    //   83	92	238	finally
    //   54	63	244	java/io/IOException
  }
  
  public static String c(Context paramContext)
  {
    AppMethodBeat.i(65242);
    paramContext = Environment.getExternalStorageDirectory() + File.separator + "tbs" + File.separator + "file_locks";
    AppMethodBeat.o(65242);
    return paramContext;
  }
  
  public static boolean c(File paramFile)
  {
    AppMethodBeat.i(65239);
    if ((paramFile != null) && (paramFile.exists()) && (paramFile.isFile()) && (paramFile.length() > 0L))
    {
      AppMethodBeat.o(65239);
      return true;
    }
    AppMethodBeat.o(65239);
    return false;
  }
  
  public static FileOutputStream d(File paramFile)
  {
    AppMethodBeat.i(65240);
    if (paramFile.exists())
    {
      if (paramFile.isDirectory())
      {
        paramFile = new IOException("File '" + paramFile + "' exists but is a directory");
        AppMethodBeat.o(65240);
        throw paramFile;
      }
      if (!paramFile.canWrite())
      {
        paramFile = new IOException("File '" + paramFile + "' cannot be written to");
        AppMethodBeat.o(65240);
        throw paramFile;
      }
    }
    else
    {
      File localFile = paramFile.getParentFile();
      if ((localFile != null) && (!localFile.exists()) && (!localFile.mkdirs()))
      {
        paramFile = new IOException("File '" + paramFile + "' could not be created");
        AppMethodBeat.o(65240);
        throw paramFile;
      }
    }
    paramFile = new FileOutputStream(paramFile);
    AppMethodBeat.o(65240);
    return paramFile;
  }
  
  static String d(Context paramContext)
  {
    AppMethodBeat.i(65243);
    paramContext = new File(paramContext.getDir("tbs", 0), "core_private");
    if ((!paramContext.isDirectory()) && (!paramContext.mkdir()))
    {
      AppMethodBeat.o(65243);
      return null;
    }
    paramContext = paramContext.getAbsolutePath();
    AppMethodBeat.o(65243);
    return paramContext;
  }
  
  public static FileLock e(Context paramContext)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(65248);
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
          AppMethodBeat.o(65248);
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
      AppMethodBeat.o(65248);
      return localObject2;
    }
  }
  
  public static FileLock f(Context paramContext)
  {
    AppMethodBeat.i(65250);
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
        AppMethodBeat.o(65250);
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
    AppMethodBeat.i(65249);
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
            AppMethodBeat.o(65249);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.utils.k
 * JD-Core Version:    0.7.0.1
 */