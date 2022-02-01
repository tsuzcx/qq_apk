package com.tencent.mm.wear.a.f;

import com.tencent.mm.wear.a.c.d;
import com.tencent.mm.wear.a.d.a;
import com.tencent.mm.wear.app.b.h;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class c
{
  public static final boolean Z(String paramString)
  {
    return b(new File(paramString));
  }
  
  private static void a(OutputStream paramOutputStream)
  {
    if (paramOutputStream != null) {}
    try
    {
      paramOutputStream.close();
      return;
    }
    catch (IOException localIOException)
    {
      d.b("MicroMsg.FileUtil", localIOException, "", new Object[0]);
      d.b("MicroMsg.FileUtil", "file op closeOutputStream e type:%s, e msg:%s, stream:%s", new Object[] { localIOException.getClass().getSimpleName(), localIOException.getMessage(), paramOutputStream });
    }
  }
  
  /* Error */
  public static boolean a(File paramFile, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 61	java/io/File:exists	()Z
    //   4: ifeq +8 -> 12
    //   7: aload_0
    //   8: invokevirtual 64	java/io/File:delete	()Z
    //   11: pop
    //   12: new 66	java/io/FileOutputStream
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 69	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   20: astore_2
    //   21: aload_2
    //   22: astore_0
    //   23: aload_2
    //   24: aload_1
    //   25: invokevirtual 73	java/io/OutputStream:write	([B)V
    //   28: aload_2
    //   29: astore_0
    //   30: aload_2
    //   31: invokevirtual 76	java/io/OutputStream:flush	()V
    //   34: aload_2
    //   35: astore_0
    //   36: aload_2
    //   37: invokevirtual 27	java/io/OutputStream:close	()V
    //   40: aload_2
    //   41: invokestatic 78	com/tencent/mm/wear/a/f/c:a	(Ljava/io/OutputStream;)V
    //   44: iconst_1
    //   45: ireturn
    //   46: astore_1
    //   47: aconst_null
    //   48: astore_2
    //   49: aload_2
    //   50: astore_0
    //   51: ldc 29
    //   53: aload_1
    //   54: invokestatic 81	com/tencent/mm/wear/a/c/d:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   57: aload_2
    //   58: invokestatic 78	com/tencent/mm/wear/a/f/c:a	(Ljava/io/OutputStream;)V
    //   61: iconst_0
    //   62: ireturn
    //   63: astore_1
    //   64: aconst_null
    //   65: astore_2
    //   66: aload_2
    //   67: astore_0
    //   68: ldc 29
    //   70: aload_1
    //   71: invokestatic 81	com/tencent/mm/wear/a/c/d:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   74: aload_2
    //   75: invokestatic 78	com/tencent/mm/wear/a/f/c:a	(Ljava/io/OutputStream;)V
    //   78: goto -17 -> 61
    //   81: astore_1
    //   82: aconst_null
    //   83: astore_0
    //   84: aload_0
    //   85: invokestatic 78	com/tencent/mm/wear/a/f/c:a	(Ljava/io/OutputStream;)V
    //   88: aload_1
    //   89: athrow
    //   90: astore_1
    //   91: goto -7 -> 84
    //   94: astore_1
    //   95: goto -29 -> 66
    //   98: astore_1
    //   99: goto -50 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	paramFile	File
    //   0	102	1	paramArrayOfByte	byte[]
    //   20	55	2	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   12	21	46	java/io/FileNotFoundException
    //   12	21	63	java/io/IOException
    //   12	21	81	finally
    //   23	28	90	finally
    //   30	34	90	finally
    //   36	40	90	finally
    //   51	57	90	finally
    //   68	74	90	finally
    //   23	28	94	java/io/IOException
    //   30	34	94	java/io/IOException
    //   36	40	94	java/io/IOException
    //   23	28	98	java/io/FileNotFoundException
    //   30	34	98	java/io/FileNotFoundException
    //   36	40	98	java/io/FileNotFoundException
  }
  
  /* Error */
  public static final byte[] a(File paramFile)
  {
    // Byte code:
    //   0: new 84	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 86	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_2
    //   8: new 88	java/io/FileInputStream
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 89	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   16: astore_0
    //   17: invokestatic 95	com/tencent/mm/wear/app/b/h:mN	()Lcom/tencent/mm/wear/a/d/a;
    //   20: invokevirtual 101	com/tencent/mm/wear/a/d/a:oz	()[B
    //   23: astore_3
    //   24: aload_0
    //   25: aload_3
    //   26: invokevirtual 107	java/io/InputStream:read	([B)I
    //   29: istore_1
    //   30: iload_1
    //   31: ifle +20 -> 51
    //   34: aload_2
    //   35: aload_3
    //   36: iconst_0
    //   37: iload_1
    //   38: invokevirtual 110	java/io/ByteArrayOutputStream:write	([BII)V
    //   41: goto -17 -> 24
    //   44: astore_2
    //   45: aload_0
    //   46: invokestatic 114	com/tencent/mm/wear/a/f/c:c	(Ljava/io/InputStream;)V
    //   49: aconst_null
    //   50: areturn
    //   51: invokestatic 95	com/tencent/mm/wear/app/b/h:mN	()Lcom/tencent/mm/wear/a/d/a;
    //   54: aload_3
    //   55: invokevirtual 117	com/tencent/mm/wear/a/d/a:o	([B)V
    //   58: aload_2
    //   59: invokevirtual 120	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   62: astore_2
    //   63: aload_0
    //   64: invokestatic 114	com/tencent/mm/wear/a/f/c:c	(Ljava/io/InputStream;)V
    //   67: aload_2
    //   68: areturn
    //   69: astore_0
    //   70: aconst_null
    //   71: astore_2
    //   72: aload_2
    //   73: invokestatic 114	com/tencent/mm/wear/a/f/c:c	(Ljava/io/InputStream;)V
    //   76: aload_0
    //   77: athrow
    //   78: astore_2
    //   79: aload_0
    //   80: astore_3
    //   81: aload_2
    //   82: astore_0
    //   83: aload_3
    //   84: astore_2
    //   85: goto -13 -> 72
    //   88: astore_0
    //   89: aconst_null
    //   90: astore_0
    //   91: goto -46 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	paramFile	File
    //   29	9	1	i	int
    //   7	28	2	localByteArrayOutputStream	ByteArrayOutputStream
    //   44	15	2	localIOException	IOException
    //   62	11	2	arrayOfByte	byte[]
    //   78	4	2	localObject1	Object
    //   84	1	2	localObject2	Object
    //   23	61	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   17	24	44	java/io/IOException
    //   24	30	44	java/io/IOException
    //   34	41	44	java/io/IOException
    //   51	63	44	java/io/IOException
    //   0	17	69	finally
    //   17	24	78	finally
    //   24	30	78	finally
    //   34	41	78	finally
    //   51	63	78	finally
    //   0	17	88	java/io/IOException
  }
  
  private static boolean b(File paramFile)
  {
    int i = 0;
    if ((paramFile == null) || (!paramFile.exists())) {
      return false;
    }
    if (paramFile.isFile()) {
      paramFile.delete();
    }
    for (;;)
    {
      paramFile.delete();
      return true;
      if (paramFile.isDirectory())
      {
        File[] arrayOfFile = paramFile.listFiles();
        if (arrayOfFile != null) {
          while (i < arrayOfFile.length)
          {
            b(arrayOfFile[i]);
            i += 1;
          }
        }
      }
    }
  }
  
  public static final byte[] b(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = h.mN().oz();
    int i = 0;
    for (;;)
    {
      try
      {
        int j = paramInputStream.read(arrayOfByte);
        i = j;
      }
      catch (IOException localIOException)
      {
        continue;
      }
      if (i <= 0) {
        continue;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    h.mN().o(arrayOfByte);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static void c(InputStream paramInputStream)
  {
    if (paramInputStream != null) {}
    try
    {
      paramInputStream.close();
      return;
    }
    catch (Exception localException)
    {
      d.b("MicroMsg.FileUtil", localException, "", new Object[0]);
      d.b("MicroMsg.FileUtil", "file op closeInputStream e type:%s, e msg:%s, stream:%s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage(), paramInputStream });
    }
  }
  
  /* Error */
  public static byte[] e(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +9 -> 10
    //   4: aconst_null
    //   5: astore 7
    //   7: aload 7
    //   9: areturn
    //   10: new 8	java/io/File
    //   13: dup
    //   14: aload_0
    //   15: invokespecial 12	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: astore 6
    //   20: aload 6
    //   22: invokevirtual 61	java/io/File:exists	()Z
    //   25: ifne +5 -> 30
    //   28: aconst_null
    //   29: areturn
    //   30: iload_2
    //   31: istore_3
    //   32: iload_2
    //   33: iconst_m1
    //   34: if_icmpne +10 -> 44
    //   37: aload 6
    //   39: invokevirtual 143	java/io/File:length	()J
    //   42: l2i
    //   43: istore_3
    //   44: iload_1
    //   45: ifge +5 -> 50
    //   48: aconst_null
    //   49: areturn
    //   50: iload_3
    //   51: ifgt +5 -> 56
    //   54: aconst_null
    //   55: areturn
    //   56: iload_1
    //   57: iload_3
    //   58: iadd
    //   59: aload 6
    //   61: invokevirtual 143	java/io/File:length	()J
    //   64: l2i
    //   65: if_icmple +5 -> 70
    //   68: aconst_null
    //   69: areturn
    //   70: new 145	java/io/RandomAccessFile
    //   73: dup
    //   74: aload_0
    //   75: ldc 147
    //   77: invokespecial 150	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   80: astore 8
    //   82: aload 8
    //   84: astore 7
    //   86: iload_3
    //   87: newarray byte
    //   89: astore 6
    //   91: iload_1
    //   92: i2l
    //   93: lstore 4
    //   95: aload 8
    //   97: astore 7
    //   99: aload 8
    //   101: lload 4
    //   103: invokevirtual 154	java/io/RandomAccessFile:seek	(J)V
    //   106: aload 8
    //   108: astore 7
    //   110: aload 8
    //   112: aload 6
    //   114: invokevirtual 157	java/io/RandomAccessFile:readFully	([B)V
    //   117: aload 8
    //   119: invokevirtual 158	java/io/RandomAccessFile:close	()V
    //   122: aload 6
    //   124: areturn
    //   125: astore 7
    //   127: ldc 29
    //   129: aload 7
    //   131: ldc 31
    //   133: iconst_0
    //   134: anewarray 4	java/lang/Object
    //   137: invokestatic 36	com/tencent/mm/wear/a/c/d:b	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   140: ldc 29
    //   142: ldc 160
    //   144: iconst_5
    //   145: anewarray 4	java/lang/Object
    //   148: dup
    //   149: iconst_0
    //   150: aload 7
    //   152: invokevirtual 42	java/lang/Object:getClass	()Ljava/lang/Class;
    //   155: invokevirtual 48	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   158: aastore
    //   159: dup
    //   160: iconst_1
    //   161: aload 7
    //   163: invokevirtual 51	java/io/IOException:getMessage	()Ljava/lang/String;
    //   166: aastore
    //   167: dup
    //   168: iconst_2
    //   169: aload_0
    //   170: aastore
    //   171: dup
    //   172: iconst_3
    //   173: iload_1
    //   174: invokestatic 166	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   177: aastore
    //   178: dup
    //   179: iconst_4
    //   180: iload_3
    //   181: invokestatic 166	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   184: aastore
    //   185: invokestatic 54	com/tencent/mm/wear/a/c/d:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   188: aload 6
    //   190: areturn
    //   191: astore 9
    //   193: aconst_null
    //   194: astore 8
    //   196: aconst_null
    //   197: astore 6
    //   199: aload 8
    //   201: astore 7
    //   203: ldc 29
    //   205: aload 9
    //   207: ldc 31
    //   209: iconst_0
    //   210: anewarray 4	java/lang/Object
    //   213: invokestatic 36	com/tencent/mm/wear/a/c/d:b	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   216: aload 8
    //   218: astore 7
    //   220: ldc 29
    //   222: ldc 168
    //   224: iconst_5
    //   225: anewarray 4	java/lang/Object
    //   228: dup
    //   229: iconst_0
    //   230: aload 9
    //   232: invokevirtual 42	java/lang/Object:getClass	()Ljava/lang/Class;
    //   235: invokevirtual 48	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   238: aastore
    //   239: dup
    //   240: iconst_1
    //   241: aload 9
    //   243: invokevirtual 137	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   246: aastore
    //   247: dup
    //   248: iconst_2
    //   249: aload_0
    //   250: aastore
    //   251: dup
    //   252: iconst_3
    //   253: iload_1
    //   254: invokestatic 166	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   257: aastore
    //   258: dup
    //   259: iconst_4
    //   260: iload_3
    //   261: invokestatic 166	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   264: aastore
    //   265: invokestatic 54	com/tencent/mm/wear/a/c/d:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   268: aload 6
    //   270: astore 7
    //   272: aload 8
    //   274: ifnull -267 -> 7
    //   277: aload 8
    //   279: invokevirtual 158	java/io/RandomAccessFile:close	()V
    //   282: aload 6
    //   284: areturn
    //   285: astore 7
    //   287: ldc 29
    //   289: aload 7
    //   291: ldc 31
    //   293: iconst_0
    //   294: anewarray 4	java/lang/Object
    //   297: invokestatic 36	com/tencent/mm/wear/a/c/d:b	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   300: ldc 29
    //   302: ldc 160
    //   304: iconst_5
    //   305: anewarray 4	java/lang/Object
    //   308: dup
    //   309: iconst_0
    //   310: aload 7
    //   312: invokevirtual 42	java/lang/Object:getClass	()Ljava/lang/Class;
    //   315: invokevirtual 48	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   318: aastore
    //   319: dup
    //   320: iconst_1
    //   321: aload 7
    //   323: invokevirtual 51	java/io/IOException:getMessage	()Ljava/lang/String;
    //   326: aastore
    //   327: dup
    //   328: iconst_2
    //   329: aload_0
    //   330: aastore
    //   331: dup
    //   332: iconst_3
    //   333: iload_1
    //   334: invokestatic 166	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   337: aastore
    //   338: dup
    //   339: iconst_4
    //   340: iload_3
    //   341: invokestatic 166	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   344: aastore
    //   345: invokestatic 54	com/tencent/mm/wear/a/c/d:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   348: aload 6
    //   350: areturn
    //   351: astore 6
    //   353: aconst_null
    //   354: astore 7
    //   356: aload 7
    //   358: ifnull +8 -> 366
    //   361: aload 7
    //   363: invokevirtual 158	java/io/RandomAccessFile:close	()V
    //   366: aload 6
    //   368: athrow
    //   369: astore 7
    //   371: ldc 29
    //   373: aload 7
    //   375: ldc 31
    //   377: iconst_0
    //   378: anewarray 4	java/lang/Object
    //   381: invokestatic 36	com/tencent/mm/wear/a/c/d:b	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   384: ldc 29
    //   386: ldc 160
    //   388: iconst_5
    //   389: anewarray 4	java/lang/Object
    //   392: dup
    //   393: iconst_0
    //   394: aload 7
    //   396: invokevirtual 42	java/lang/Object:getClass	()Ljava/lang/Class;
    //   399: invokevirtual 48	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   402: aastore
    //   403: dup
    //   404: iconst_1
    //   405: aload 7
    //   407: invokevirtual 51	java/io/IOException:getMessage	()Ljava/lang/String;
    //   410: aastore
    //   411: dup
    //   412: iconst_2
    //   413: aload_0
    //   414: aastore
    //   415: dup
    //   416: iconst_3
    //   417: iload_1
    //   418: invokestatic 166	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   421: aastore
    //   422: dup
    //   423: iconst_4
    //   424: iload_3
    //   425: invokestatic 166	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   428: aastore
    //   429: invokestatic 54	com/tencent/mm/wear/a/c/d:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   432: goto -66 -> 366
    //   435: astore 6
    //   437: goto -81 -> 356
    //   440: astore 9
    //   442: aconst_null
    //   443: astore 6
    //   445: goto -246 -> 199
    //   448: astore 9
    //   450: goto -251 -> 199
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	453	0	paramString	String
    //   0	453	1	paramInt1	int
    //   0	453	2	paramInt2	int
    //   31	394	3	i	int
    //   93	9	4	l	long
    //   18	331	6	localObject1	Object
    //   351	16	6	localObject2	Object
    //   435	1	6	localObject3	Object
    //   443	1	6	localObject4	Object
    //   5	104	7	localObject5	Object
    //   125	37	7	localIOException1	IOException
    //   201	70	7	localObject6	Object
    //   285	37	7	localIOException2	IOException
    //   354	8	7	localObject7	Object
    //   369	37	7	localIOException3	IOException
    //   80	198	8	localRandomAccessFile	java.io.RandomAccessFile
    //   191	51	9	localException1	Exception
    //   440	1	9	localException2	Exception
    //   448	1	9	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   117	122	125	java/io/IOException
    //   70	82	191	java/lang/Exception
    //   277	282	285	java/io/IOException
    //   70	82	351	finally
    //   361	366	369	java/io/IOException
    //   86	91	435	finally
    //   99	106	435	finally
    //   110	117	435	finally
    //   203	216	435	finally
    //   220	268	435	finally
    //   86	91	440	java/lang/Exception
    //   99	106	448	java/lang/Exception
    //   110	117	448	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.a.f.c
 * JD-Core Version:    0.7.0.1
 */