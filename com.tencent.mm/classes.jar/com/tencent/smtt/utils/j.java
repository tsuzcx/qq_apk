package com.tencent.smtt.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import com.tencent.smtt.sdk.TbsDownloadConfig;
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
public class j
{
  public static String a;
  public static final a b = new l();
  private static final int c = 4;
  private static RandomAccessFile d;
  
  static
  {
    a = null;
    d = null;
  }
  
  public static File a(Context paramContext, boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      paramContext = d(paramContext);
      if (paramContext != null) {
        break label23;
      }
    }
    label23:
    do
    {
      return null;
      paramContext = c(paramContext);
      break;
      paramContext = new File(paramContext);
      if (!paramContext.exists()) {
        paramContext.mkdirs();
      }
    } while (!paramContext.canWrite());
    paramContext = new File(paramContext, paramString);
    if (!paramContext.exists()) {}
    try
    {
      paramContext.createNewFile();
      return paramContext;
    }
    catch (IOException paramContext) {}
    return null;
  }
  
  public static String a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramContext.getApplicationInfo().packageName, paramInt, true);
  }
  
  private static String a(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return "";
    }
    Object localObject = paramContext.getApplicationContext();
    if (localObject == null) {}
    for (;;)
    {
      try
      {
        localObject = paramContext.getExternalFilesDir(paramString).getAbsolutePath();
        return localObject;
      }
      catch (Throwable localThrowable)
      {
        try
        {
          paramContext = Environment.getExternalStorageDirectory() + File.separator + "Android" + File.separator + "data" + File.separator + paramContext.getApplicationInfo().packageName + File.separator + "files" + File.separator + paramString;
          return paramContext;
        }
        catch (Exception paramContext)
        {
          return "";
        }
      }
      paramContext = localThrowable;
    }
  }
  
  public static String a(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    Object localObject1;
    if (paramContext == null) {
      localObject1 = "";
    }
    Object localObject2;
    label43:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return localObject1;
                  localObject2 = "";
                  try
                  {
                    localObject1 = Environment.getExternalStorageDirectory() + File.separator;
                    localObject2 = localObject1;
                  }
                  catch (Exception localException)
                  {
                    break label43;
                  }
                  switch (paramInt)
                  {
                  default: 
                    return "";
                  case 1: 
                    localObject1 = localObject2;
                  }
                } while (((String)localObject2).equals(""));
                return (String)localObject2 + "tencent" + File.separator + "tbs" + File.separator + paramString;
                localObject1 = localObject2;
              } while (((String)localObject2).equals(""));
              return (String)localObject2 + "tbs" + File.separator + "backup" + File.separator + paramString;
              localObject1 = localObject2;
            } while (((String)localObject2).equals(""));
            return (String)localObject2 + "tencent" + File.separator + "tbs" + File.separator + "backup" + File.separator + paramString;
            if (((String)localObject2).equals("")) {
              return a(paramContext, "backup");
            }
            paramString = (String)localObject2 + "tencent" + File.separator + "tbs" + File.separator + "backup" + File.separator + paramString;
            localObject1 = paramString;
          } while (!paramBoolean);
          localObject2 = new File(paramString);
          if (!((File)localObject2).exists()) {
            break;
          }
          localObject1 = paramString;
        } while (((File)localObject2).canWrite());
        if (((File)localObject2).exists()) {
          break;
        }
        ((File)localObject2).mkdirs();
        localObject1 = paramString;
      } while (((File)localObject2).canWrite());
      return a(paramContext, "backup");
      return a(paramContext, "backup");
      localObject1 = localObject2;
    } while (((String)localObject2).equals(""));
    return (String)localObject2 + "tencent" + File.separator + "tbs" + File.separator + paramString;
    if (a != null) {
      return a;
    }
    paramContext = a(paramContext, "tbslog");
    a = paramContext;
    return paramContext;
  }
  
  public static FileLock a(Context paramContext, FileOutputStream paramFileOutputStream)
  {
    if (paramFileOutputStream == null) {}
    for (;;)
    {
      return null;
      try
      {
        paramContext = paramFileOutputStream.getChannel().tryLock();
        boolean bool = paramContext.isValid();
        if (bool) {
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
        return null;
      }
      catch (OverlappingFileLockException paramContext) {}
    }
    return null;
  }
  
  /* Error */
  public static void a(Context paramContext, FileLock paramFileLock)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_1
    //   4: invokevirtual 166	java/nio/channels/FileLock:channel	()Ljava/nio/channels/FileChannel;
    //   7: astore_0
    //   8: aload_0
    //   9: ifnull +16 -> 25
    //   12: aload_0
    //   13: invokevirtual 169	java/nio/channels/FileChannel:isOpen	()Z
    //   16: istore_2
    //   17: iload_2
    //   18: ifeq +7 -> 25
    //   21: aload_1
    //   22: invokevirtual 172	java/nio/channels/FileLock:release	()V
    //   25: ldc 2
    //   27: monitorexit
    //   28: return
    //   29: astore_0
    //   30: goto -5 -> 25
    //   33: astore_0
    //   34: ldc 2
    //   36: monitorexit
    //   37: aload_0
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	paramContext	Context
    //   0	39	1	paramFileLock	FileLock
    //   16	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   21	25	29	java/io/IOException
    //   3	8	33	finally
    //   12	17	33	finally
    //   21	25	33	finally
  }
  
  public static void a(File paramFile, boolean paramBoolean)
  {
    if ((paramFile == null) || (!paramFile.exists())) {}
    do
    {
      File[] arrayOfFile;
      do
      {
        return;
        if (paramFile.isFile())
        {
          paramFile.delete();
          return;
        }
        arrayOfFile = paramFile.listFiles();
      } while (arrayOfFile == null);
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        a(arrayOfFile[i], paramBoolean);
        i += 1;
      }
    } while (paramBoolean);
    paramFile.delete();
  }
  
  public static void a(File paramFile, boolean paramBoolean, String paramString)
  {
    if ((paramFile == null) || (!paramFile.exists())) {}
    do
    {
      File[] arrayOfFile;
      do
      {
        return;
        if (paramFile.isFile())
        {
          paramFile.delete();
          return;
        }
        arrayOfFile = paramFile.listFiles();
      } while (arrayOfFile == null);
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
    } while (paramBoolean);
    paramFile.delete();
  }
  
  public static void a(FileLock paramFileLock, FileOutputStream paramFileOutputStream)
  {
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
      label24:
      break label24;
    }
    if (paramFileOutputStream != null) {}
    try
    {
      paramFileOutputStream.close();
      return;
    }
    catch (Exception paramFileLock) {}
  }
  
  public static boolean a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 23) {}
    do
    {
      return true;
      if (paramContext == null) {
        break;
      }
    } while (paramContext.getApplicationContext().checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0);
    return false;
    return false;
  }
  
  public static boolean a(File paramFile)
  {
    if (paramFile == null) {
      return false;
    }
    if ((paramFile.exists()) && (paramFile.isDirectory())) {
      return true;
    }
    b(paramFile);
    return paramFile.mkdirs();
  }
  
  public static boolean a(File paramFile1, File paramFile2)
  {
    return a(paramFile1.getPath(), paramFile2.getPath());
  }
  
  public static boolean a(File paramFile1, File paramFile2, FileFilter paramFileFilter)
  {
    return a(paramFile1, paramFile2, paramFileFilter, b);
  }
  
  public static boolean a(File paramFile1, File paramFile2, FileFilter paramFileFilter, a parama)
  {
    if ((paramFile1 == null) || (paramFile2 == null)) {}
    do
    {
      do
      {
        return false;
      } while (!paramFile1.exists());
      if (paramFile1.isFile()) {
        return b(paramFile1, paramFile2, paramFileFilter, parama);
      }
      paramFile1 = paramFile1.listFiles(paramFileFilter);
    } while (paramFile1 == null);
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
    return bool;
  }
  
  private static boolean a(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    paramString = new File(paramString);
    if (paramString.length() != paramLong1) {
      TbsLog.e("FileHelper", "file size doesn't match: " + paramString.length() + " vs " + paramLong1);
    }
    label117:
    do
    {
      return true;
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
            break label117;
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
      throw paramString;
      paramLong1 = localCRC32.getValue();
      TbsLog.i("FileHelper", paramString.getName() + ": crc = " + paramLong1 + ", zipCrc = " + paramLong3);
      if (paramLong1 == paramLong3) {
        break;
      }
    } while (localFileInputStream == null);
    localFileInputStream.close();
    return true;
    if (localFileInputStream != null) {
      localFileInputStream.close();
    }
    return false;
  }
  
  @SuppressLint({"InlinedApi"})
  public static boolean a(String paramString1, String paramString2)
  {
    String str2 = Build.CPU_ABI;
    if (Build.VERSION.SDK_INT >= 8) {}
    for (String str1 = Build.CPU_ABI2;; str1 = null) {
      return a(paramString1, paramString2, str2, str1, p.a("ro.product.cpu.upgradeabi", "armeabi"));
    }
  }
  
  /* Error */
  private static boolean a(String paramString1, String paramString2, String paramString3, String paramString4, j.b paramb)
  {
    // Byte code:
    //   0: new 305	java/util/zip/ZipFile
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 306	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: iconst_0
    //   10: istore 6
    //   12: iconst_0
    //   13: istore 5
    //   15: aload_0
    //   16: invokevirtual 310	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   19: astore 10
    //   21: aload 10
    //   23: invokeinterface 315 1 0
    //   28: ifeq +332 -> 360
    //   31: aload 10
    //   33: invokeinterface 319 1 0
    //   38: checkcast 321	java/util/zip/ZipEntry
    //   41: astore 11
    //   43: aload 11
    //   45: invokevirtual 322	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   48: astore 13
    //   50: aload 13
    //   52: ifnull -31 -> 21
    //   55: aload 13
    //   57: ldc_w 324
    //   60: invokevirtual 328	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   63: ifne -42 -> 21
    //   66: aload 13
    //   68: ldc_w 330
    //   71: invokevirtual 334	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   74: ifne +14 -> 88
    //   77: aload 13
    //   79: ldc_w 336
    //   82: invokevirtual 334	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   85: ifeq -64 -> 21
    //   88: aload 13
    //   90: aload 13
    //   92: bipush 47
    //   94: invokevirtual 340	java/lang/String:lastIndexOf	(I)I
    //   97: invokevirtual 344	java/lang/String:substring	(I)Ljava/lang/String;
    //   100: astore 12
    //   102: iload 5
    //   104: istore 7
    //   106: iload 6
    //   108: istore 8
    //   110: aload 12
    //   112: ldc_w 346
    //   115: invokevirtual 349	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   118: ifeq +45 -> 163
    //   121: aload 13
    //   123: getstatic 23	com/tencent/smtt/utils/j:c	I
    //   126: aload_1
    //   127: iconst_0
    //   128: aload_1
    //   129: invokevirtual 352	java/lang/String:length	()I
    //   132: invokevirtual 356	java/lang/String:regionMatches	(ILjava/lang/String;II)Z
    //   135: ifeq +80 -> 215
    //   138: aload 13
    //   140: getstatic 23	com/tencent/smtt/utils/j:c	I
    //   143: aload_1
    //   144: invokevirtual 352	java/lang/String:length	()I
    //   147: iadd
    //   148: invokevirtual 360	java/lang/String:charAt	(I)C
    //   151: bipush 47
    //   153: if_icmpne +62 -> 215
    //   156: iconst_1
    //   157: istore 8
    //   159: iload 5
    //   161: istore 7
    //   163: aload_0
    //   164: aload 11
    //   166: invokevirtual 364	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   169: astore 13
    //   171: aload 4
    //   173: aload 13
    //   175: aload 11
    //   177: aload 12
    //   179: iconst_1
    //   180: invokevirtual 344	java/lang/String:substring	(I)Ljava/lang/String;
    //   183: invokeinterface 367 4 0
    //   188: istore 9
    //   190: iload 9
    //   192: ifne +178 -> 370
    //   195: aload 13
    //   197: ifnull +8 -> 205
    //   200: aload 13
    //   202: invokevirtual 370	java/io/InputStream:close	()V
    //   205: aload_0
    //   206: ifnull +7 -> 213
    //   209: aload_0
    //   210: invokevirtual 371	java/util/zip/ZipFile:close	()V
    //   213: iconst_0
    //   214: ireturn
    //   215: aload_2
    //   216: ifnull +56 -> 272
    //   219: aload 13
    //   221: getstatic 23	com/tencent/smtt/utils/j:c	I
    //   224: aload_2
    //   225: iconst_0
    //   226: aload_2
    //   227: invokevirtual 352	java/lang/String:length	()I
    //   230: invokevirtual 356	java/lang/String:regionMatches	(ILjava/lang/String;II)Z
    //   233: ifeq +39 -> 272
    //   236: aload 13
    //   238: getstatic 23	com/tencent/smtt/utils/j:c	I
    //   241: aload_2
    //   242: invokevirtual 352	java/lang/String:length	()I
    //   245: iadd
    //   246: invokevirtual 360	java/lang/String:charAt	(I)C
    //   249: bipush 47
    //   251: if_icmpne +21 -> 272
    //   254: iconst_1
    //   255: istore 7
    //   257: iconst_1
    //   258: istore 5
    //   260: iload 6
    //   262: istore 8
    //   264: iload 6
    //   266: ifeq -103 -> 163
    //   269: goto -248 -> 21
    //   272: aload_3
    //   273: ifnull -252 -> 21
    //   276: aload 13
    //   278: getstatic 23	com/tencent/smtt/utils/j:c	I
    //   281: aload_3
    //   282: iconst_0
    //   283: aload_3
    //   284: invokevirtual 352	java/lang/String:length	()I
    //   287: invokevirtual 356	java/lang/String:regionMatches	(ILjava/lang/String;II)Z
    //   290: ifeq -269 -> 21
    //   293: aload 13
    //   295: getstatic 23	com/tencent/smtt/utils/j:c	I
    //   298: aload_3
    //   299: invokevirtual 352	java/lang/String:length	()I
    //   302: iadd
    //   303: invokevirtual 360	java/lang/String:charAt	(I)C
    //   306: bipush 47
    //   308: if_icmpne -287 -> 21
    //   311: iload 6
    //   313: ifne -292 -> 21
    //   316: iload 5
    //   318: ifne -297 -> 21
    //   321: iload 5
    //   323: istore 7
    //   325: iload 6
    //   327: istore 8
    //   329: goto -166 -> 163
    //   332: astore_1
    //   333: aload 13
    //   335: ifnull +8 -> 343
    //   338: aload 13
    //   340: invokevirtual 370	java/io/InputStream:close	()V
    //   343: aload_1
    //   344: athrow
    //   345: astore_2
    //   346: aload_0
    //   347: astore_1
    //   348: aload_2
    //   349: astore_0
    //   350: aload_1
    //   351: ifnull +7 -> 358
    //   354: aload_1
    //   355: invokevirtual 371	java/util/zip/ZipFile:close	()V
    //   358: aload_0
    //   359: athrow
    //   360: aload_0
    //   361: ifnull +7 -> 368
    //   364: aload_0
    //   365: invokevirtual 371	java/util/zip/ZipFile:close	()V
    //   368: iconst_1
    //   369: ireturn
    //   370: iload 7
    //   372: istore 5
    //   374: iload 8
    //   376: istore 6
    //   378: aload 13
    //   380: ifnull -359 -> 21
    //   383: aload 13
    //   385: invokevirtual 370	java/io/InputStream:close	()V
    //   388: iload 7
    //   390: istore 5
    //   392: iload 8
    //   394: istore 6
    //   396: goto -375 -> 21
    //   399: astore_0
    //   400: aconst_null
    //   401: astore_1
    //   402: goto -52 -> 350
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	405	0	paramString1	String
    //   0	405	1	paramString2	String
    //   0	405	2	paramString3	String
    //   0	405	3	paramString4	String
    //   0	405	4	paramb	j.b
    //   13	378	5	i	int
    //   10	385	6	j	int
    //   104	285	7	k	int
    //   108	285	8	m	int
    //   188	3	9	bool	boolean
    //   19	13	10	localEnumeration	java.util.Enumeration
    //   41	135	11	localZipEntry	java.util.zip.ZipEntry
    //   100	78	12	str	String
    //   48	336	13	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   171	190	332	finally
    //   15	21	345	finally
    //   21	50	345	finally
    //   55	88	345	finally
    //   88	102	345	finally
    //   110	156	345	finally
    //   163	171	345	finally
    //   200	205	345	finally
    //   219	254	345	finally
    //   276	311	345	finally
    //   338	343	345	finally
    //   343	345	345	finally
    //   383	388	345	finally
    //   0	9	399	finally
  }
  
  private static boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    return a(paramString1, paramString3, paramString4, paramString5, new k(paramString2));
  }
  
  public static FileOutputStream b(Context paramContext, boolean paramBoolean, String paramString)
  {
    paramContext = a(paramContext, paramBoolean, paramString);
    if (paramContext != null) {
      try
      {
        paramContext = new FileOutputStream(paramContext);
        return paramContext;
      }
      catch (FileNotFoundException paramContext) {}
    }
    return null;
  }
  
  public static void b(File paramFile)
  {
    a(paramFile, false);
  }
  
  public static boolean b(Context paramContext)
  {
    long l = v.a();
    if (l >= TbsDownloadConfig.getInstance(paramContext).getDownloadMinFreeSpace()) {}
    for (boolean bool = true;; bool = false)
    {
      if (!bool) {
        TbsLog.e("TbsDownload", "[TbsApkDwonloader.hasEnoughFreeSpace] freeSpace too small,  freeSpace = " + l);
      }
      return bool;
    }
  }
  
  public static boolean b(File paramFile1, File paramFile2)
  {
    return a(paramFile1, paramFile2, null);
  }
  
  /* Error */
  private static boolean b(File paramFile1, File paramFile2, FileFilter paramFileFilter, a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +7 -> 8
    //   4: aload_1
    //   5: ifnonnull +5 -> 10
    //   8: iconst_0
    //   9: ireturn
    //   10: aload_2
    //   11: ifnull +15 -> 26
    //   14: aload_2
    //   15: aload_0
    //   16: invokeinterface 404 2 0
    //   21: ifne +5 -> 26
    //   24: iconst_0
    //   25: ireturn
    //   26: aload_0
    //   27: invokevirtual 52	java/io/File:exists	()Z
    //   30: ifeq +14 -> 44
    //   33: aload_0
    //   34: invokevirtual 176	java/io/File:isFile	()Z
    //   37: istore 4
    //   39: iload 4
    //   41: ifne +29 -> 70
    //   44: iconst_0
    //   45: ifeq +11 -> 56
    //   48: new 406	java/lang/NullPointerException
    //   51: dup
    //   52: invokespecial 407	java/lang/NullPointerException:<init>	()V
    //   55: athrow
    //   56: iconst_0
    //   57: ifeq +11 -> 68
    //   60: new 406	java/lang/NullPointerException
    //   63: dup
    //   64: invokespecial 407	java/lang/NullPointerException:<init>	()V
    //   67: athrow
    //   68: iconst_0
    //   69: ireturn
    //   70: aload_1
    //   71: invokevirtual 52	java/io/File:exists	()Z
    //   74: ifeq +52 -> 126
    //   77: aload_3
    //   78: ifnull +44 -> 122
    //   81: aload_3
    //   82: aload_0
    //   83: aload_1
    //   84: invokeinterface 409 3 0
    //   89: istore 4
    //   91: iload 4
    //   93: ifeq +29 -> 122
    //   96: iconst_0
    //   97: ifeq +11 -> 108
    //   100: new 406	java/lang/NullPointerException
    //   103: dup
    //   104: invokespecial 407	java/lang/NullPointerException:<init>	()V
    //   107: athrow
    //   108: iconst_0
    //   109: ifeq +11 -> 120
    //   112: new 406	java/lang/NullPointerException
    //   115: dup
    //   116: invokespecial 407	java/lang/NullPointerException:<init>	()V
    //   119: athrow
    //   120: iconst_1
    //   121: ireturn
    //   122: aload_1
    //   123: invokestatic 212	com/tencent/smtt/utils/j:b	(Ljava/io/File;)V
    //   126: aload_1
    //   127: invokevirtual 412	java/io/File:getParentFile	()Ljava/io/File;
    //   130: astore_2
    //   131: aload_2
    //   132: invokevirtual 176	java/io/File:isFile	()Z
    //   135: ifeq +7 -> 142
    //   138: aload_2
    //   139: invokestatic 212	com/tencent/smtt/utils/j:b	(Ljava/io/File;)V
    //   142: aload_2
    //   143: invokevirtual 52	java/io/File:exists	()Z
    //   146: ifne +40 -> 186
    //   149: aload_2
    //   150: invokevirtual 55	java/io/File:mkdirs	()Z
    //   153: istore 4
    //   155: iload 4
    //   157: ifne +29 -> 186
    //   160: iconst_0
    //   161: ifeq +11 -> 172
    //   164: new 406	java/lang/NullPointerException
    //   167: dup
    //   168: invokespecial 407	java/lang/NullPointerException:<init>	()V
    //   171: athrow
    //   172: iconst_0
    //   173: ifeq +11 -> 184
    //   176: new 406	java/lang/NullPointerException
    //   179: dup
    //   180: invokespecial 407	java/lang/NullPointerException:<init>	()V
    //   183: athrow
    //   184: iconst_0
    //   185: ireturn
    //   186: new 256	java/io/FileInputStream
    //   189: dup
    //   190: aload_0
    //   191: invokespecial 258	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   194: invokevirtual 413	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   197: astore_0
    //   198: new 147	java/io/FileOutputStream
    //   201: dup
    //   202: aload_1
    //   203: invokespecial 382	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   206: invokevirtual 151	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   209: astore_2
    //   210: aload_0
    //   211: invokevirtual 416	java/nio/channels/FileChannel:size	()J
    //   214: lstore 5
    //   216: aload_2
    //   217: aload_0
    //   218: lconst_0
    //   219: lload 5
    //   221: invokevirtual 420	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   224: lload 5
    //   226: lcmp
    //   227: ifeq +48 -> 275
    //   230: aload_1
    //   231: invokestatic 212	com/tencent/smtt/utils/j:b	(Ljava/io/File;)V
    //   234: aload_0
    //   235: ifnull +7 -> 242
    //   238: aload_0
    //   239: invokevirtual 421	java/nio/channels/FileChannel:close	()V
    //   242: aload_2
    //   243: ifnull +7 -> 250
    //   246: aload_2
    //   247: invokevirtual 421	java/nio/channels/FileChannel:close	()V
    //   250: iconst_0
    //   251: ireturn
    //   252: astore_0
    //   253: aconst_null
    //   254: astore_1
    //   255: aconst_null
    //   256: astore_2
    //   257: aload_2
    //   258: ifnull +7 -> 265
    //   261: aload_2
    //   262: invokevirtual 421	java/nio/channels/FileChannel:close	()V
    //   265: aload_1
    //   266: ifnull +7 -> 273
    //   269: aload_1
    //   270: invokevirtual 421	java/nio/channels/FileChannel:close	()V
    //   273: aload_0
    //   274: athrow
    //   275: aload_0
    //   276: ifnull +7 -> 283
    //   279: aload_0
    //   280: invokevirtual 421	java/nio/channels/FileChannel:close	()V
    //   283: aload_2
    //   284: ifnull +7 -> 291
    //   287: aload_2
    //   288: invokevirtual 421	java/nio/channels/FileChannel:close	()V
    //   291: iconst_1
    //   292: ireturn
    //   293: astore_1
    //   294: aconst_null
    //   295: astore_3
    //   296: aload_0
    //   297: astore_2
    //   298: aload_1
    //   299: astore_0
    //   300: aload_3
    //   301: astore_1
    //   302: goto -45 -> 257
    //   305: astore_3
    //   306: aload_2
    //   307: astore_1
    //   308: aload_0
    //   309: astore_2
    //   310: aload_3
    //   311: astore_0
    //   312: goto -55 -> 257
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	315	0	paramFile1	File
    //   0	315	1	paramFile2	File
    //   0	315	2	paramFileFilter	FileFilter
    //   0	315	3	parama	a
    //   37	119	4	bool	boolean
    //   214	11	5	l	long
    // Exception table:
    //   from	to	target	type
    //   26	39	252	finally
    //   70	77	252	finally
    //   81	91	252	finally
    //   122	126	252	finally
    //   126	142	252	finally
    //   142	155	252	finally
    //   186	198	252	finally
    //   198	210	293	finally
    //   210	234	305	finally
  }
  
  /* Error */
  @SuppressLint({"NewApi"})
  private static boolean b(java.io.InputStream paramInputStream, java.util.zip.ZipEntry paramZipEntry, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 45	java/io/File
    //   3: dup
    //   4: aload_2
    //   5: invokespecial 48	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: invokestatic 423	com/tencent/smtt/utils/j:a	(Ljava/io/File;)Z
    //   11: pop
    //   12: new 100	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   19: aload_2
    //   20: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: getstatic 114	java/io/File:separator	Ljava/lang/String;
    //   26: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_3
    //   30: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: astore 5
    //   38: new 45	java/io/File
    //   41: dup
    //   42: aload 5
    //   44: invokespecial 48	java/io/File:<init>	(Ljava/lang/String;)V
    //   47: astore_3
    //   48: new 147	java/io/FileOutputStream
    //   51: dup
    //   52: aload_3
    //   53: invokespecial 382	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   56: astore_2
    //   57: sipush 8192
    //   60: newarray byte
    //   62: astore 6
    //   64: aload_0
    //   65: aload 6
    //   67: invokevirtual 424	java/io/InputStream:read	([B)I
    //   70: istore 4
    //   72: iload 4
    //   74: ifle +63 -> 137
    //   77: aload_2
    //   78: aload 6
    //   80: iconst_0
    //   81: iload 4
    //   83: invokevirtual 427	java/io/FileOutputStream:write	([BII)V
    //   86: goto -22 -> 64
    //   89: astore_1
    //   90: aload_2
    //   91: astore_0
    //   92: aload_3
    //   93: invokestatic 212	com/tencent/smtt/utils/j:b	(Ljava/io/File;)V
    //   96: new 38	java/io/IOException
    //   99: dup
    //   100: new 100	java/lang/StringBuilder
    //   103: dup
    //   104: ldc_w 429
    //   107: invokespecial 243	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   110: aload_3
    //   111: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: aload_1
    //   118: invokespecial 432	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   121: athrow
    //   122: astore_2
    //   123: aload_0
    //   124: astore_1
    //   125: aload_2
    //   126: astore_0
    //   127: aload_1
    //   128: ifnull +7 -> 135
    //   131: aload_1
    //   132: invokevirtual 193	java/io/FileOutputStream:close	()V
    //   135: aload_0
    //   136: athrow
    //   137: aload_2
    //   138: ifnull +7 -> 145
    //   141: aload_2
    //   142: invokevirtual 193	java/io/FileOutputStream:close	()V
    //   145: aload 5
    //   147: aload_1
    //   148: invokevirtual 435	java/util/zip/ZipEntry:getSize	()J
    //   151: aload_1
    //   152: invokevirtual 438	java/util/zip/ZipEntry:getTime	()J
    //   155: aload_1
    //   156: invokevirtual 441	java/util/zip/ZipEntry:getCrc	()J
    //   159: invokestatic 443	com/tencent/smtt/utils/j:a	(Ljava/lang/String;JJJ)Z
    //   162: ifeq +28 -> 190
    //   165: ldc 240
    //   167: new 100	java/lang/StringBuilder
    //   170: dup
    //   171: ldc_w 445
    //   174: invokespecial 243	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   177: aload 5
    //   179: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 254	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   188: iconst_0
    //   189: ireturn
    //   190: aload_3
    //   191: aload_1
    //   192: invokevirtual 438	java/util/zip/ZipEntry:getTime	()J
    //   195: invokevirtual 449	java/io/File:setLastModified	(J)Z
    //   198: ifne +25 -> 223
    //   201: ldc 240
    //   203: new 100	java/lang/StringBuilder
    //   206: dup
    //   207: ldc_w 451
    //   210: invokespecial 243	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   213: aload_3
    //   214: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   217: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 254	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   223: iconst_1
    //   224: ireturn
    //   225: astore_0
    //   226: aconst_null
    //   227: astore_1
    //   228: goto -101 -> 127
    //   231: astore_0
    //   232: aload_2
    //   233: astore_1
    //   234: goto -107 -> 127
    //   237: astore_1
    //   238: aconst_null
    //   239: astore_0
    //   240: goto -148 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	paramInputStream	java.io.InputStream
    //   0	243	1	paramZipEntry	java.util.zip.ZipEntry
    //   0	243	2	paramString1	String
    //   0	243	3	paramString2	String
    //   70	12	4	i	int
    //   36	142	5	str	String
    //   62	17	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   57	64	89	java/io/IOException
    //   64	72	89	java/io/IOException
    //   77	86	89	java/io/IOException
    //   92	122	122	finally
    //   48	57	225	finally
    //   57	64	231	finally
    //   64	72	231	finally
    //   77	86	231	finally
    //   48	57	237	java/io/IOException
  }
  
  public static String c(Context paramContext)
  {
    return Environment.getExternalStorageDirectory() + File.separator + "tbs" + File.separator + "file_locks";
  }
  
  public static boolean c(File paramFile)
  {
    return (paramFile != null) && (paramFile.exists()) && (paramFile.isFile()) && (paramFile.length() > 0L);
  }
  
  public static FileOutputStream d(File paramFile)
  {
    if (paramFile.exists())
    {
      if (paramFile.isDirectory()) {
        throw new IOException("File '" + paramFile + "' exists but is a directory");
      }
      if (!paramFile.canWrite()) {
        throw new IOException("File '" + paramFile + "' cannot be written to");
      }
    }
    else
    {
      File localFile = paramFile.getParentFile();
      if ((localFile != null) && (!localFile.exists()) && (!localFile.mkdirs())) {
        throw new IOException("File '" + paramFile + "' could not be created");
      }
    }
    return new FileOutputStream(paramFile);
  }
  
  static String d(Context paramContext)
  {
    paramContext = new File(paramContext.getDir("tbs", 0), "core_private");
    if ((!paramContext.isDirectory()) && (!paramContext.mkdir())) {
      return null;
    }
    return paramContext.getAbsolutePath();
  }
  
  public static FileLock e(Context paramContext)
  {
    Object localObject1 = null;
    Object localObject2 = null;
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
          TbsLog.i("FileHelper", "getTbsCoreLoadFileLock #2 renameFileLock is " + paramContext);
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
      localObject2 = a(paramContext, true, "tbs_rename_lock");
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
      label160:
      break label160;
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = g(paramContext);
    }
    if (localObject2 == null)
    {
      TbsLog.i("FileHelper", "getTbsCoreLoadFileLock -- failed: " + "tbs_rename_lock");
      return localObject2;
    }
    TbsLog.i("FileHelper", "getTbsCoreLoadFileLock -- success: " + "tbs_rename_lock");
    return localObject2;
  }
  
  public static FileLock f(Context paramContext)
  {
    Object localObject = null;
    paramContext = a(paramContext, true, "tbs_rename_lock");
    try
    {
      paramContext = new RandomAccessFile(paramContext.getAbsolutePath(), "rw");
      d = paramContext;
      paramContext = paramContext.getChannel().tryLock(0L, 9223372036854775807L, false);
      if (paramContext == null)
      {
        TbsLog.i("FileHelper", "getTbsCoreRenameFileLock -- failed: " + "tbs_rename_lock");
        return paramContext;
      }
      TbsLog.i("FileHelper", "getTbsCoreRenameFileLock -- success: " + "tbs_rename_lock");
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext = localObject;
      }
    }
  }
  
  /* Error */
  private static FileLock g(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore_3
    //   5: aload 5
    //   7: astore 4
    //   9: aload_0
    //   10: invokestatic 528	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   13: invokevirtual 532	com/tencent/smtt/sdk/TbsLogReport:tbsLogInfo	()Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   16: astore 6
    //   18: aload 5
    //   20: astore 4
    //   22: aload 6
    //   24: sipush 803
    //   27: invokevirtual 538	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setErrorCode	(I)V
    //   30: aload 5
    //   32: astore 4
    //   34: aload_0
    //   35: iconst_1
    //   36: ldc_w 483
    //   39: invokestatic 381	com/tencent/smtt/utils/j:a	(Landroid/content/Context;ZLjava/lang/String;)Ljava/io/File;
    //   42: astore 7
    //   44: aload 5
    //   46: astore 4
    //   48: aload_0
    //   49: invokestatic 392	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   52: invokevirtual 541	com/tencent/smtt/sdk/TbsDownloadConfig:getTbsCoreLoadRenameFileLockWaitEnable	()Z
    //   55: istore_2
    //   56: iload_2
    //   57: ifeq +188 -> 245
    //   60: iconst_0
    //   61: istore_1
    //   62: iload_1
    //   63: bipush 20
    //   65: if_icmpge +69 -> 134
    //   68: aload_3
    //   69: ifnonnull +65 -> 134
    //   72: ldc2_w 542
    //   75: invokestatic 549	java/lang/Thread:sleep	(J)V
    //   78: aload_3
    //   79: astore 4
    //   81: new 499	java/io/RandomAccessFile
    //   84: dup
    //   85: aload 7
    //   87: invokevirtual 98	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   90: ldc_w 501
    //   93: invokespecial 503	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: astore 5
    //   98: aload_3
    //   99: astore 4
    //   101: aload 5
    //   103: putstatic 27	com/tencent/smtt/utils/j:d	Ljava/io/RandomAccessFile;
    //   106: aload_3
    //   107: astore 4
    //   109: aload 5
    //   111: invokevirtual 504	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   114: lconst_0
    //   115: ldc2_w 505
    //   118: iconst_1
    //   119: invokevirtual 509	java/nio/channels/FileChannel:tryLock	(JJZ)Ljava/nio/channels/FileLock;
    //   122: astore 5
    //   124: aload 5
    //   126: astore_3
    //   127: iload_1
    //   128: iconst_1
    //   129: iadd
    //   130: istore_1
    //   131: goto -69 -> 62
    //   134: aload_3
    //   135: ifnull +77 -> 212
    //   138: aload_3
    //   139: astore 4
    //   141: aload 6
    //   143: sipush 802
    //   146: invokevirtual 538	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setErrorCode	(I)V
    //   149: aload_3
    //   150: astore 4
    //   152: aload_0
    //   153: invokestatic 528	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   156: getstatic 555	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_SDK_REPORT_INFO	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
    //   159: aload 6
    //   161: invokevirtual 559	com/tencent/smtt/sdk/TbsLogReport:eventReport	(Lcom/tencent/smtt/sdk/TbsLogReport$EventType;Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;)V
    //   164: aload_3
    //   165: astore 4
    //   167: new 100	java/lang/StringBuilder
    //   170: dup
    //   171: ldc_w 561
    //   174: invokespecial 243	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   177: iload_1
    //   178: invokevirtual 564	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   181: ldc_w 566
    //   184: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: astore_0
    //   188: aload_3
    //   189: ifnonnull +41 -> 230
    //   192: iconst_1
    //   193: istore_2
    //   194: aload_3
    //   195: astore 4
    //   197: ldc 240
    //   199: aload_0
    //   200: iload_2
    //   201: invokevirtual 569	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   204: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokestatic 280	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   210: aload_3
    //   211: areturn
    //   212: aload_3
    //   213: astore 4
    //   215: aload 6
    //   217: sipush 801
    //   220: invokevirtual 538	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setErrorCode	(I)V
    //   223: goto -74 -> 149
    //   226: astore_0
    //   227: aload 4
    //   229: areturn
    //   230: iconst_0
    //   231: istore_2
    //   232: goto -38 -> 194
    //   235: astore 4
    //   237: goto -159 -> 78
    //   240: astore 4
    //   242: goto -115 -> 127
    //   245: aconst_null
    //   246: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	247	0	paramContext	Context
    //   61	117	1	i	int
    //   55	177	2	bool	boolean
    //   4	209	3	localObject1	Object
    //   7	221	4	localObject2	Object
    //   235	1	4	localException	Exception
    //   240	1	4	localThrowable	Throwable
    //   1	124	5	localObject3	Object
    //   16	200	6	localTbsLogInfo	com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo
    //   42	44	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   9	18	226	java/lang/Exception
    //   22	30	226	java/lang/Exception
    //   34	44	226	java/lang/Exception
    //   48	56	226	java/lang/Exception
    //   81	98	226	java/lang/Exception
    //   101	106	226	java/lang/Exception
    //   109	124	226	java/lang/Exception
    //   141	149	226	java/lang/Exception
    //   152	164	226	java/lang/Exception
    //   167	188	226	java/lang/Exception
    //   197	210	226	java/lang/Exception
    //   215	223	226	java/lang/Exception
    //   72	78	235	java/lang/Exception
    //   72	78	240	java/lang/Throwable
    //   81	98	240	java/lang/Throwable
    //   101	106	240	java/lang/Throwable
    //   109	124	240	java/lang/Throwable
  }
  
  public static abstract interface a
  {
    public abstract boolean a(File paramFile1, File paramFile2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.smtt.utils.j
 * JD-Core Version:    0.7.0.1
 */