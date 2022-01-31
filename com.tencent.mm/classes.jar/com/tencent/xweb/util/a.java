package com.tencent.xweb.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.xwalk.core.Log;

public final class a
{
  public static boolean agX(String paramString)
  {
    try
    {
      an(new File(paramString));
      return true;
    }
    catch (Exception localException)
    {
      Log.i("FileUtils", String.format("delete all files.(%s)", new Object[] { paramString }));
    }
    return false;
  }
  
  private static void an(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists())) {}
    do
    {
      return;
      if (paramFile.isFile())
      {
        paramFile.delete();
        return;
      }
    } while (!paramFile.isDirectory());
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
            break label95;
          }
          localFile.delete();
        }
        for (;;)
        {
          i += 1;
          break;
          label95:
          an(localFile);
        }
      }
    }
    paramFile.delete();
  }
  
  /* Error */
  public static boolean copyFile(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 58	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 59	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   8: astore_2
    //   9: aload_2
    //   10: invokevirtual 63	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   13: astore 6
    //   15: new 65	java/io/FileOutputStream
    //   18: dup
    //   19: aload_1
    //   20: invokespecial 66	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   23: astore_3
    //   24: aload_3
    //   25: invokevirtual 67	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   28: astore 4
    //   30: aload 4
    //   32: aload 6
    //   34: lconst_0
    //   35: aload 6
    //   37: invokevirtual 73	java/nio/channels/FileChannel:size	()J
    //   40: invokevirtual 77	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   43: pop2
    //   44: aload 4
    //   46: iconst_1
    //   47: invokevirtual 81	java/nio/channels/FileChannel:force	(Z)V
    //   50: aload_2
    //   51: invokevirtual 85	java/io/FileInputStream:close	()V
    //   54: aload_3
    //   55: invokevirtual 86	java/io/FileOutputStream:close	()V
    //   58: aload 6
    //   60: ifnull +8 -> 68
    //   63: aload 6
    //   65: invokevirtual 87	java/nio/channels/FileChannel:close	()V
    //   68: aload 4
    //   70: ifnull +8 -> 78
    //   73: aload 4
    //   75: invokevirtual 87	java/nio/channels/FileChannel:close	()V
    //   78: iconst_1
    //   79: ireturn
    //   80: astore 5
    //   82: aconst_null
    //   83: astore_2
    //   84: aconst_null
    //   85: astore 4
    //   87: aconst_null
    //   88: astore_3
    //   89: aconst_null
    //   90: astore 6
    //   92: ldc 20
    //   94: ldc 89
    //   96: iconst_4
    //   97: anewarray 4	java/lang/Object
    //   100: dup
    //   101: iconst_0
    //   102: aload 5
    //   104: invokevirtual 93	java/lang/Object:getClass	()Ljava/lang/Class;
    //   107: invokevirtual 99	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   110: aastore
    //   111: dup
    //   112: iconst_1
    //   113: aload 5
    //   115: invokevirtual 102	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   118: aastore
    //   119: dup
    //   120: iconst_2
    //   121: aload_0
    //   122: aastore
    //   123: dup
    //   124: iconst_3
    //   125: aload_1
    //   126: aastore
    //   127: invokestatic 28	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   130: invokestatic 105	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   133: aload 4
    //   135: ifnull +8 -> 143
    //   138: aload 4
    //   140: invokevirtual 85	java/io/FileInputStream:close	()V
    //   143: aload_2
    //   144: ifnull +7 -> 151
    //   147: aload_2
    //   148: invokevirtual 86	java/io/FileOutputStream:close	()V
    //   151: aload 6
    //   153: ifnull +8 -> 161
    //   156: aload 6
    //   158: invokevirtual 87	java/nio/channels/FileChannel:close	()V
    //   161: aload_3
    //   162: ifnull +7 -> 169
    //   165: aload_3
    //   166: invokevirtual 87	java/nio/channels/FileChannel:close	()V
    //   169: iconst_0
    //   170: ireturn
    //   171: astore_0
    //   172: aconst_null
    //   173: astore_2
    //   174: aconst_null
    //   175: astore 4
    //   177: aconst_null
    //   178: astore_3
    //   179: aconst_null
    //   180: astore 6
    //   182: aload 4
    //   184: ifnull +8 -> 192
    //   187: aload 4
    //   189: invokevirtual 85	java/io/FileInputStream:close	()V
    //   192: aload_2
    //   193: ifnull +7 -> 200
    //   196: aload_2
    //   197: invokevirtual 86	java/io/FileOutputStream:close	()V
    //   200: aload 6
    //   202: ifnull +8 -> 210
    //   205: aload 6
    //   207: invokevirtual 87	java/nio/channels/FileChannel:close	()V
    //   210: aload_3
    //   211: ifnull +7 -> 218
    //   214: aload_3
    //   215: invokevirtual 87	java/nio/channels/FileChannel:close	()V
    //   218: aload_0
    //   219: athrow
    //   220: astore_0
    //   221: goto -167 -> 54
    //   224: astore_0
    //   225: goto -167 -> 58
    //   228: astore_0
    //   229: goto -161 -> 68
    //   232: astore_0
    //   233: goto -155 -> 78
    //   236: astore_0
    //   237: goto -94 -> 143
    //   240: astore_0
    //   241: goto -90 -> 151
    //   244: astore_0
    //   245: goto -84 -> 161
    //   248: astore_0
    //   249: goto -80 -> 169
    //   252: astore_1
    //   253: goto -61 -> 192
    //   256: astore_1
    //   257: goto -57 -> 200
    //   260: astore_1
    //   261: goto -51 -> 210
    //   264: astore_1
    //   265: goto -47 -> 218
    //   268: astore_0
    //   269: aconst_null
    //   270: astore_1
    //   271: aload_2
    //   272: astore 4
    //   274: aconst_null
    //   275: astore_3
    //   276: aconst_null
    //   277: astore 6
    //   279: aload_1
    //   280: astore_2
    //   281: goto -99 -> 182
    //   284: astore_0
    //   285: aconst_null
    //   286: astore_1
    //   287: aload_2
    //   288: astore 4
    //   290: aconst_null
    //   291: astore_3
    //   292: aload_1
    //   293: astore_2
    //   294: goto -112 -> 182
    //   297: astore_0
    //   298: aload_2
    //   299: astore 4
    //   301: aconst_null
    //   302: astore_1
    //   303: aload_3
    //   304: astore_2
    //   305: aload_1
    //   306: astore_3
    //   307: goto -125 -> 182
    //   310: astore_0
    //   311: aload_2
    //   312: astore_1
    //   313: aload 4
    //   315: astore 5
    //   317: aload_3
    //   318: astore_2
    //   319: aload_1
    //   320: astore 4
    //   322: aload 5
    //   324: astore_3
    //   325: goto -143 -> 182
    //   328: astore_0
    //   329: goto -147 -> 182
    //   332: astore 5
    //   334: aconst_null
    //   335: astore 7
    //   337: aload_2
    //   338: astore 4
    //   340: aconst_null
    //   341: astore_3
    //   342: aconst_null
    //   343: astore 6
    //   345: aload 7
    //   347: astore_2
    //   348: goto -256 -> 92
    //   351: astore 5
    //   353: aconst_null
    //   354: astore 7
    //   356: aload_2
    //   357: astore 4
    //   359: aconst_null
    //   360: astore_3
    //   361: aload 7
    //   363: astore_2
    //   364: goto -272 -> 92
    //   367: astore 5
    //   369: aload_2
    //   370: astore 4
    //   372: aconst_null
    //   373: astore 7
    //   375: aload_3
    //   376: astore_2
    //   377: aload 7
    //   379: astore_3
    //   380: goto -288 -> 92
    //   383: astore 5
    //   385: aload_2
    //   386: astore 7
    //   388: aload 4
    //   390: astore 8
    //   392: aload_3
    //   393: astore_2
    //   394: aload 7
    //   396: astore 4
    //   398: aload 8
    //   400: astore_3
    //   401: goto -309 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	404	0	paramString1	String
    //   0	404	1	paramString2	String
    //   8	386	2	localObject1	Object
    //   23	378	3	localObject2	Object
    //   28	369	4	localObject3	Object
    //   80	34	5	localException1	Exception
    //   315	8	5	localObject4	Object
    //   332	1	5	localException2	Exception
    //   351	1	5	localException3	Exception
    //   367	1	5	localException4	Exception
    //   383	1	5	localException5	Exception
    //   13	331	6	localFileChannel	java.nio.channels.FileChannel
    //   335	60	7	localObject5	Object
    //   390	9	8	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   0	9	80	java/lang/Exception
    //   0	9	171	finally
    //   50	54	220	java/lang/Exception
    //   54	58	224	java/lang/Exception
    //   63	68	228	java/io/IOException
    //   73	78	232	java/io/IOException
    //   138	143	236	java/lang/Exception
    //   147	151	240	java/lang/Exception
    //   156	161	244	java/io/IOException
    //   165	169	248	java/io/IOException
    //   187	192	252	java/lang/Exception
    //   196	200	256	java/lang/Exception
    //   205	210	260	java/io/IOException
    //   214	218	264	java/io/IOException
    //   9	15	268	finally
    //   15	24	284	finally
    //   24	30	297	finally
    //   30	50	310	finally
    //   92	133	328	finally
    //   9	15	332	java/lang/Exception
    //   15	24	351	java/lang/Exception
    //   24	30	367	java/lang/Exception
    //   30	50	383	java/lang/Exception
  }
  
  public static boolean deleteFile(String paramString)
  {
    paramString = new File(paramString);
    if ((paramString.exists()) && (paramString.isFile()))
    {
      paramString.delete();
      return true;
    }
    return false;
  }
  
  public static boolean gQ(String paramString1, String paramString2)
  {
    Object localObject = new File(paramString2);
    if ((!((File)localObject).isDirectory()) || (!((File)localObject).exists())) {
      ((File)localObject).mkdirs();
    }
    localObject = new File(paramString1).listFiles();
    int i = 0;
    while (i < localObject.length)
    {
      if ((localObject[i].isFile()) && (!m(localObject[i], new File(new File(paramString2).getAbsolutePath() + File.separator + localObject[i].getName())))) {}
      while ((localObject[i].isDirectory()) && (gQ(paramString1 + "/" + localObject[i].getName(), paramString2 + "/" + localObject[i].getName()))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private static boolean m(File paramFile1, File paramFile2)
  {
    BufferedInputStream localBufferedInputStream;
    BufferedOutputStream localBufferedOutputStream;
    try
    {
      paramFile1 = new FileInputStream(paramFile1);
      localBufferedInputStream = new BufferedInputStream(paramFile1);
      paramFile2 = new FileOutputStream(paramFile2);
      localBufferedOutputStream = new BufferedOutputStream(paramFile2);
      byte[] arrayOfByte = new byte[5120];
      for (;;)
      {
        int i = localBufferedInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localBufferedOutputStream.write(arrayOfByte, 0, i);
      }
      localBufferedOutputStream.flush();
    }
    catch (Exception paramFile1)
    {
      Log.e("FileUtils", "copyFile error:" + paramFile1.getMessage());
      return false;
    }
    localBufferedInputStream.close();
    localBufferedOutputStream.close();
    paramFile2.close();
    paramFile1.close();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.util.a
 * JD-Core Version:    0.7.0.1
 */