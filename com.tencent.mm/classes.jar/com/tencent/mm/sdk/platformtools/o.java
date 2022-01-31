package com.tencent.mm.sdk.platformtools;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class o
{
  public static boolean YY(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      y.e("MicroMsg.ImgUtil", "isImgFile, invalid argument");
    }
    BitmapFactory.Options localOptions;
    MMBitmapFactory.DecodeResultLogger localDecodeResultLogger;
    do
    {
      do
      {
        return false;
      } while ((paramString.length() < 3) || (!new b(paramString).exists()));
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = false;
      localOptions.inSampleSize = YZ(paramString);
      localDecodeResultLogger = new MMBitmapFactory.DecodeResultLogger();
      paramString = MMBitmapFactory.decodeFile(paramString, localOptions, localDecodeResultLogger, 0, new int[0]);
      if (paramString != null)
      {
        y.i("MicroMsg.ImgUtil", "bitmap recycle %s", new Object[] { paramString });
        paramString.recycle();
      }
    } while ((localOptions.outWidth <= 0) || (localOptions.outHeight <= 0) || (localDecodeResultLogger.getDecodeResult() != 0));
    return true;
  }
  
  /* Error */
  private static int YZ(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: invokestatic 89	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   7: astore 4
    //   9: aload 4
    //   11: ifnonnull +102 -> 113
    //   14: aload 4
    //   16: astore_3
    //   17: ldc 14
    //   19: ldc 91
    //   21: invokestatic 94	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: aload 5
    //   26: astore_3
    //   27: aload_3
    //   28: ifnull +184 -> 212
    //   31: aload_3
    //   32: iconst_0
    //   33: iaload
    //   34: istore_1
    //   35: aload_3
    //   36: iconst_1
    //   37: iaload
    //   38: istore_2
    //   39: aload 4
    //   41: astore_3
    //   42: ldc 14
    //   44: ldc 96
    //   46: iconst_3
    //   47: anewarray 4	java/lang/Object
    //   50: dup
    //   51: iconst_0
    //   52: aload_0
    //   53: aastore
    //   54: dup
    //   55: iconst_1
    //   56: iload_1
    //   57: invokestatic 102	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   60: aastore
    //   61: dup
    //   62: iconst_2
    //   63: iload_2
    //   64: invokestatic 102	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   67: aastore
    //   68: invokestatic 105	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   71: aload 4
    //   73: astore_3
    //   74: iload_1
    //   75: iload_2
    //   76: invokestatic 109	com/tencent/mm/sdk/platformtools/o:fd	(II)I
    //   79: istore_1
    //   80: aload 4
    //   82: astore_3
    //   83: ldc 14
    //   85: ldc 111
    //   87: iconst_1
    //   88: anewarray 4	java/lang/Object
    //   91: dup
    //   92: iconst_0
    //   93: iload_1
    //   94: invokestatic 102	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   97: aastore
    //   98: invokestatic 105	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   101: aload 4
    //   103: ifnull +8 -> 111
    //   106: aload 4
    //   108: invokevirtual 116	java/io/InputStream:close	()V
    //   111: iload_1
    //   112: ireturn
    //   113: aload 4
    //   115: astore_3
    //   116: new 34	android/graphics/BitmapFactory$Options
    //   119: dup
    //   120: invokespecial 37	android/graphics/BitmapFactory$Options:<init>	()V
    //   123: astore 6
    //   125: aload 4
    //   127: astore_3
    //   128: aload 6
    //   130: iconst_1
    //   131: putfield 41	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   134: aload 4
    //   136: astore_3
    //   137: aload 4
    //   139: aconst_null
    //   140: aload 6
    //   142: invokestatic 120	com/tencent/mm/sdk/platformtools/MMBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   145: pop
    //   146: aload 4
    //   148: astore_3
    //   149: iconst_2
    //   150: newarray int
    //   152: astore 5
    //   154: aload 4
    //   156: astore_3
    //   157: aload 5
    //   159: iconst_0
    //   160: aload 6
    //   162: getfield 72	android/graphics/BitmapFactory$Options:outWidth	I
    //   165: iastore
    //   166: aload 4
    //   168: astore_3
    //   169: aload 5
    //   171: iconst_1
    //   172: aload 6
    //   174: getfield 75	android/graphics/BitmapFactory$Options:outHeight	I
    //   177: iastore
    //   178: aload 5
    //   180: astore_3
    //   181: goto -154 -> 27
    //   184: astore_0
    //   185: aload 4
    //   187: astore_3
    //   188: ldc 14
    //   190: aload_0
    //   191: ldc 122
    //   193: iconst_0
    //   194: anewarray 4	java/lang/Object
    //   197: invokestatic 126	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   200: aload 4
    //   202: ifnull +8 -> 210
    //   205: aload 4
    //   207: invokevirtual 116	java/io/InputStream:close	()V
    //   210: iconst_1
    //   211: ireturn
    //   212: aload 4
    //   214: astore_3
    //   215: ldc 14
    //   217: ldc 128
    //   219: invokestatic 94	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   222: aload 4
    //   224: ifnull +8 -> 232
    //   227: aload 4
    //   229: invokevirtual 116	java/io/InputStream:close	()V
    //   232: iconst_1
    //   233: ireturn
    //   234: astore_0
    //   235: aconst_null
    //   236: astore_3
    //   237: aload_3
    //   238: ifnull +7 -> 245
    //   241: aload_3
    //   242: invokevirtual 116	java/io/InputStream:close	()V
    //   245: aload_0
    //   246: athrow
    //   247: astore_0
    //   248: iload_1
    //   249: ireturn
    //   250: astore_0
    //   251: goto -19 -> 232
    //   254: astore_0
    //   255: goto -45 -> 210
    //   258: astore_3
    //   259: goto -14 -> 245
    //   262: astore_0
    //   263: goto -26 -> 237
    //   266: astore_0
    //   267: aconst_null
    //   268: astore 4
    //   270: goto -85 -> 185
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	273	0	paramString	String
    //   34	215	1	i	int
    //   38	38	2	j	int
    //   16	226	3	localObject	Object
    //   258	1	3	localIOException	IOException
    //   7	262	4	localInputStream	InputStream
    //   1	178	5	arrayOfInt	int[]
    //   123	50	6	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   17	24	184	java/io/FileNotFoundException
    //   42	71	184	java/io/FileNotFoundException
    //   74	80	184	java/io/FileNotFoundException
    //   83	101	184	java/io/FileNotFoundException
    //   116	125	184	java/io/FileNotFoundException
    //   128	134	184	java/io/FileNotFoundException
    //   137	146	184	java/io/FileNotFoundException
    //   149	154	184	java/io/FileNotFoundException
    //   157	166	184	java/io/FileNotFoundException
    //   169	178	184	java/io/FileNotFoundException
    //   215	222	184	java/io/FileNotFoundException
    //   3	9	234	finally
    //   106	111	247	java/io/IOException
    //   227	232	250	java/io/IOException
    //   205	210	254	java/io/IOException
    //   241	245	258	java/io/IOException
    //   17	24	262	finally
    //   42	71	262	finally
    //   74	80	262	finally
    //   83	101	262	finally
    //   116	125	262	finally
    //   128	134	262	finally
    //   137	146	262	finally
    //   149	154	262	finally
    //   157	166	262	finally
    //   169	178	262	finally
    //   188	200	262	finally
    //   215	222	262	finally
    //   3	9	266	java/io/FileNotFoundException
  }
  
  /* Error */
  public static boolean Za(String paramString)
  {
    // Byte code:
    //   0: new 133	com/tencent/mm/vfs/d
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 134	com/tencent/mm/vfs/d:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: bipush 6
    //   11: newarray byte
    //   13: astore 4
    //   15: ldc 136
    //   17: astore_3
    //   18: aload_0
    //   19: aload 4
    //   21: invokevirtual 140	java/io/InputStream:read	([B)I
    //   24: pop
    //   25: iconst_0
    //   26: istore_1
    //   27: iload_1
    //   28: bipush 6
    //   30: if_icmpge +33 -> 63
    //   33: new 142	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   40: aload_3
    //   41: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload 4
    //   46: iload_1
    //   47: baload
    //   48: i2c
    //   49: invokevirtual 150	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   52: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: astore_3
    //   56: iload_1
    //   57: iconst_1
    //   58: iadd
    //   59: istore_1
    //   60: goto -33 -> 27
    //   63: aload_3
    //   64: ldc 156
    //   66: invokevirtual 159	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   69: istore_2
    //   70: iload_2
    //   71: ifne +9 -> 80
    //   74: aload_0
    //   75: invokevirtual 116	java/io/InputStream:close	()V
    //   78: iconst_0
    //   79: ireturn
    //   80: aload_0
    //   81: invokevirtual 116	java/io/InputStream:close	()V
    //   84: iconst_1
    //   85: ireturn
    //   86: astore_0
    //   87: aconst_null
    //   88: astore_0
    //   89: aload_0
    //   90: ifnull -12 -> 78
    //   93: aload_0
    //   94: invokevirtual 116	java/io/InputStream:close	()V
    //   97: iconst_0
    //   98: ireturn
    //   99: astore_0
    //   100: iconst_0
    //   101: ireturn
    //   102: astore_3
    //   103: aconst_null
    //   104: astore_0
    //   105: aload_0
    //   106: ifnull +7 -> 113
    //   109: aload_0
    //   110: invokevirtual 116	java/io/InputStream:close	()V
    //   113: aload_3
    //   114: athrow
    //   115: astore_0
    //   116: iconst_0
    //   117: ireturn
    //   118: astore_0
    //   119: goto -35 -> 84
    //   122: astore_0
    //   123: goto -10 -> 113
    //   126: astore_3
    //   127: goto -22 -> 105
    //   130: astore_3
    //   131: goto -42 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	paramString	String
    //   26	34	1	i	int
    //   69	2	2	bool	boolean
    //   17	47	3	str	String
    //   102	12	3	localObject1	Object
    //   126	1	3	localObject2	Object
    //   130	1	3	localException	java.lang.Exception
    //   13	32	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   0	9	86	java/lang/Exception
    //   93	97	99	java/io/IOException
    //   0	9	102	finally
    //   74	78	115	java/io/IOException
    //   80	84	118	java/io/IOException
    //   109	113	122	java/io/IOException
    //   9	15	126	finally
    //   18	25	126	finally
    //   33	56	126	finally
    //   63	70	126	finally
    //   9	15	130	java/lang/Exception
    //   18	25	130	java/lang/Exception
    //   33	56	130	java/lang/Exception
    //   63	70	130	java/lang/Exception
  }
  
  /* Error */
  public static boolean Zb(String paramString)
  {
    // Byte code:
    //   0: new 133	com/tencent/mm/vfs/d
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 134	com/tencent/mm/vfs/d:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: bipush 8
    //   11: newarray byte
    //   13: astore 4
    //   15: ldc 136
    //   17: astore_3
    //   18: aload_0
    //   19: aload 4
    //   21: invokevirtual 140	java/io/InputStream:read	([B)I
    //   24: pop
    //   25: iconst_0
    //   26: istore_1
    //   27: iload_1
    //   28: bipush 8
    //   30: if_icmpge +33 -> 63
    //   33: new 142	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   40: aload_3
    //   41: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload 4
    //   46: iload_1
    //   47: baload
    //   48: i2c
    //   49: invokevirtual 150	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   52: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: astore_3
    //   56: iload_1
    //   57: iconst_1
    //   58: iadd
    //   59: istore_1
    //   60: goto -33 -> 27
    //   63: aload_3
    //   64: ldc 162
    //   66: invokevirtual 159	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   69: istore_2
    //   70: iload_2
    //   71: ifne +9 -> 80
    //   74: aload_0
    //   75: invokevirtual 116	java/io/InputStream:close	()V
    //   78: iconst_0
    //   79: ireturn
    //   80: aload_0
    //   81: invokevirtual 116	java/io/InputStream:close	()V
    //   84: iconst_1
    //   85: ireturn
    //   86: astore_0
    //   87: aconst_null
    //   88: astore_0
    //   89: aload_0
    //   90: ifnull -12 -> 78
    //   93: aload_0
    //   94: invokevirtual 116	java/io/InputStream:close	()V
    //   97: iconst_0
    //   98: ireturn
    //   99: astore_0
    //   100: iconst_0
    //   101: ireturn
    //   102: astore_3
    //   103: aconst_null
    //   104: astore_0
    //   105: aload_0
    //   106: ifnull +7 -> 113
    //   109: aload_0
    //   110: invokevirtual 116	java/io/InputStream:close	()V
    //   113: aload_3
    //   114: athrow
    //   115: astore_0
    //   116: iconst_0
    //   117: ireturn
    //   118: astore_0
    //   119: goto -35 -> 84
    //   122: astore_0
    //   123: goto -10 -> 113
    //   126: astore_3
    //   127: goto -22 -> 105
    //   130: astore_3
    //   131: goto -42 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	paramString	String
    //   26	34	1	i	int
    //   69	2	2	bool	boolean
    //   17	47	3	str	String
    //   102	12	3	localObject1	Object
    //   126	1	3	localObject2	Object
    //   130	1	3	localException	java.lang.Exception
    //   13	32	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   0	9	86	java/lang/Exception
    //   93	97	99	java/io/IOException
    //   0	9	102	finally
    //   74	78	115	java/io/IOException
    //   80	84	118	java/io/IOException
    //   109	113	122	java/io/IOException
    //   9	15	126	finally
    //   18	25	126	finally
    //   33	56	126	finally
    //   63	70	126	finally
    //   9	15	130	java/lang/Exception
    //   18	25	130	java/lang/Exception
    //   33	56	130	java/lang/Exception
    //   63	70	130	java/lang/Exception
  }
  
  public static String Zc(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      return "";
    }
    paramString = e.c(paramString, 0, 2);
    if ((paramString == null) || (paramString.length < 2)) {
      return "";
    }
    int j = paramString[0];
    int i = j;
    if (j < 0) {
      i = j + 256;
    }
    int k = paramString[1];
    j = k;
    if (k < 0) {
      j = k + 256;
    }
    if ((i == 66) && (j == 77)) {
      return ".bmp";
    }
    if ((i == 255) && (j == 216)) {
      return ".jpg";
    }
    if ((i == 137) && (j == 80)) {
      return ".png";
    }
    if ((i == 71) && (j == 73)) {
      return ".gif";
    }
    return ".jpg";
  }
  
  public static boolean a(String paramString, MMBitmapFactory.DecodeResultLogger paramDecodeResultLogger)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      y.e("MicroMsg.ImgUtil", "isImgFile, invalid argument");
      paramDecodeResultLogger.setDecodeResult(1005);
    }
    BitmapFactory.Options localOptions;
    do
    {
      return false;
      if (paramString.length() < 3)
      {
        paramDecodeResultLogger.setDecodeResult(1005);
        return false;
      }
      if (!new b(paramString).exists())
      {
        paramDecodeResultLogger.setDecodeResult(1005);
        return false;
      }
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = false;
      localOptions.inSampleSize = YZ(paramString);
      long l = System.currentTimeMillis();
      paramString = MMBitmapFactory.decodeFile(paramString, localOptions, paramDecodeResultLogger, 0, new int[0]);
      y.v("MicroMsg.ImgUtil", "hy: isImgFile decode using: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      if (paramString != null)
      {
        y.i("MicroMsg.ImgUtil", "bitmap recycle %s", new Object[] { paramString });
        paramString.recycle();
      }
    } while ((localOptions.outWidth <= 0) || (localOptions.outHeight <= 0) || (paramDecodeResultLogger.getDecodeResult() != 0));
    return true;
  }
  
  public static boolean bx(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    for (;;)
    {
      return false;
      ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
      paramArrayOfByte = "";
      int i = 0;
      if (i < 6) {}
      for (;;)
      {
        try
        {
          paramArrayOfByte = paramArrayOfByte + (char)localByteArrayInputStream.read();
          i += 1;
        }
        catch (IOException paramArrayOfByte) {}
        try
        {
          localByteArrayInputStream.close();
          if (!paramArrayOfByte.startsWith("GIF")) {
            break;
          }
          return true;
        }
        catch (IOException localIOException) {}
      }
    }
    return false;
  }
  
  public static boolean by(byte[] paramArrayOfByte)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 4)) {
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            if ((paramArrayOfByte[1] != 80) || (paramArrayOfByte[2] != 78)) {
              break;
            }
            bool1 = bool2;
          } while (paramArrayOfByte[3] == 71);
          if ((paramArrayOfByte[0] != 71) || (paramArrayOfByte[1] != 73)) {
            break;
          }
          bool1 = bool2;
        } while (paramArrayOfByte[2] == 70);
        if ((paramArrayOfByte[6] != 74) || (paramArrayOfByte[7] != 70) || (paramArrayOfByte[8] != 73)) {
          break;
        }
        bool1 = bool2;
      } while (paramArrayOfByte[9] == 70);
      if ((paramArrayOfByte[0] != 119) || (paramArrayOfByte[1] != 120) || (paramArrayOfByte[2] != 103)) {
        break;
      }
      bool1 = bool2;
    } while (paramArrayOfByte[3] == 102);
    return false;
  }
  
  public static boolean bz(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    for (;;)
    {
      return false;
      ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
      paramArrayOfByte = "";
      int i = 0;
      if (i < 8) {}
      for (;;)
      {
        try
        {
          paramArrayOfByte = paramArrayOfByte + (char)localByteArrayInputStream.read();
          i += 1;
        }
        catch (IOException paramArrayOfByte) {}
        try
        {
          localByteArrayInputStream.close();
          if (!paramArrayOfByte.startsWith("wxgf")) {
            break;
          }
          return true;
        }
        catch (IOException localIOException) {}
      }
    }
    return false;
  }
  
  private static int fd(int paramInt1, int paramInt2)
  {
    paramInt1 = Math.max(paramInt1, paramInt2);
    paramInt2 = 1;
    while (paramInt1 > 64)
    {
      paramInt2 *= 2;
      paramInt1 /= paramInt2;
    }
    return paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.o
 * JD-Core Version:    0.7.0.1
 */