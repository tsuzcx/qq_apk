package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.e;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class r
{
  /* Error */
  public static boolean aoX(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: iconst_1
    //   6: istore_2
    //   7: ldc 9
    //   9: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: aload_0
    //   13: ifnull +10 -> 23
    //   16: aload_0
    //   17: invokevirtual 21	java/lang/String:length	()I
    //   20: ifne +17 -> 37
    //   23: ldc 23
    //   25: ldc 25
    //   27: invokestatic 31	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: ldc 9
    //   32: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: iconst_0
    //   36: ireturn
    //   37: aload_0
    //   38: invokevirtual 21	java/lang/String:length	()I
    //   41: iconst_3
    //   42: if_icmpge +10 -> 52
    //   45: ldc 9
    //   47: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: iconst_0
    //   51: ireturn
    //   52: aload_0
    //   53: invokestatic 39	com/tencent/mm/vfs/e:cN	(Ljava/lang/String;)Z
    //   56: ifne +10 -> 66
    //   59: ldc 9
    //   61: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: iconst_0
    //   65: ireturn
    //   66: new 41	android/graphics/BitmapFactory$Options
    //   69: dup
    //   70: invokespecial 45	android/graphics/BitmapFactory$Options:<init>	()V
    //   73: astore 5
    //   75: aload 5
    //   77: iconst_1
    //   78: putfield 49	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   81: aload_0
    //   82: invokestatic 53	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   85: astore_0
    //   86: aload_0
    //   87: astore_3
    //   88: aload_0
    //   89: astore 4
    //   91: aload_0
    //   92: aconst_null
    //   93: aload 5
    //   95: invokestatic 59	com/tencent/mm/graphics/MMBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   98: pop
    //   99: aload_0
    //   100: astore_3
    //   101: aload_0
    //   102: astore 4
    //   104: aload 5
    //   106: getfield 63	android/graphics/BitmapFactory$Options:outWidth	I
    //   109: ifle +29 -> 138
    //   112: aload_0
    //   113: astore_3
    //   114: aload_0
    //   115: astore 4
    //   117: aload 5
    //   119: getfield 66	android/graphics/BitmapFactory$Options:outHeight	I
    //   122: istore_1
    //   123: iload_1
    //   124: ifle +14 -> 138
    //   127: aload_0
    //   128: invokestatic 72	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   131: ldc 9
    //   133: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: iload_2
    //   137: ireturn
    //   138: iconst_0
    //   139: istore_2
    //   140: goto -13 -> 127
    //   143: astore_0
    //   144: aload_3
    //   145: astore 4
    //   147: ldc 23
    //   149: aload_0
    //   150: ldc 74
    //   152: iconst_0
    //   153: anewarray 4	java/lang/Object
    //   156: invokestatic 78	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   159: aload_3
    //   160: invokestatic 72	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   163: ldc 9
    //   165: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   168: iconst_0
    //   169: ireturn
    //   170: astore_0
    //   171: aload 4
    //   173: invokestatic 72	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   176: ldc 9
    //   178: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   181: aload_0
    //   182: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	paramString	String
    //   122	2	1	i	int
    //   6	134	2	bool	boolean
    //   4	156	3	str	String
    //   1	171	4	localObject	Object
    //   73	45	5	localOptions	android.graphics.BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   81	86	143	java/lang/Throwable
    //   91	99	143	java/lang/Throwable
    //   104	112	143	java/lang/Throwable
    //   117	123	143	java/lang/Throwable
    //   81	86	170	finally
    //   91	99	170	finally
    //   104	112	170	finally
    //   117	123	170	finally
    //   147	159	170	finally
  }
  
  /* Error */
  public static boolean aoY(String paramString)
  {
    // Byte code:
    //   0: ldc 85
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 87	com/tencent/mm/vfs/d
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 90	com/tencent/mm/vfs/d:<init>	(Ljava/lang/String;)V
    //   13: astore_0
    //   14: bipush 6
    //   16: newarray byte
    //   18: astore 4
    //   20: ldc 92
    //   22: astore_3
    //   23: aload_0
    //   24: aload 4
    //   26: invokevirtual 98	java/io/InputStream:read	([B)I
    //   29: pop
    //   30: iconst_0
    //   31: istore_1
    //   32: iload_1
    //   33: bipush 6
    //   35: if_icmpge +33 -> 68
    //   38: new 100	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   45: aload_3
    //   46: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload 4
    //   51: iload_1
    //   52: baload
    //   53: i2c
    //   54: invokevirtual 108	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   57: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: astore_3
    //   61: iload_1
    //   62: iconst_1
    //   63: iadd
    //   64: istore_1
    //   65: goto -33 -> 32
    //   68: aload_3
    //   69: ldc 114
    //   71: invokevirtual 117	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   74: istore_2
    //   75: iload_2
    //   76: ifne +14 -> 90
    //   79: aload_0
    //   80: invokevirtual 120	java/io/InputStream:close	()V
    //   83: ldc 85
    //   85: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   88: iconst_0
    //   89: ireturn
    //   90: aload_0
    //   91: invokevirtual 120	java/io/InputStream:close	()V
    //   94: ldc 85
    //   96: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: iconst_1
    //   100: ireturn
    //   101: astore_0
    //   102: aconst_null
    //   103: astore_0
    //   104: aload_0
    //   105: ifnull +7 -> 112
    //   108: aload_0
    //   109: invokevirtual 120	java/io/InputStream:close	()V
    //   112: ldc 85
    //   114: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: iconst_0
    //   118: ireturn
    //   119: astore_3
    //   120: aconst_null
    //   121: astore_0
    //   122: aload_0
    //   123: ifnull +7 -> 130
    //   126: aload_0
    //   127: invokevirtual 120	java/io/InputStream:close	()V
    //   130: ldc 85
    //   132: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: aload_3
    //   136: athrow
    //   137: astore_0
    //   138: goto -55 -> 83
    //   141: astore_0
    //   142: goto -48 -> 94
    //   145: astore_0
    //   146: goto -34 -> 112
    //   149: astore_0
    //   150: goto -20 -> 130
    //   153: astore_3
    //   154: goto -32 -> 122
    //   157: astore_3
    //   158: goto -54 -> 104
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	paramString	String
    //   31	34	1	i	int
    //   74	2	2	bool	boolean
    //   22	47	3	str	String
    //   119	17	3	localObject1	Object
    //   153	1	3	localObject2	Object
    //   157	1	3	localException	java.lang.Exception
    //   18	32	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   5	14	101	java/lang/Exception
    //   5	14	119	finally
    //   79	83	137	java/io/IOException
    //   90	94	141	java/io/IOException
    //   108	112	145	java/io/IOException
    //   126	130	149	java/io/IOException
    //   14	20	153	finally
    //   23	30	153	finally
    //   38	61	153	finally
    //   68	75	153	finally
    //   14	20	157	java/lang/Exception
    //   23	30	157	java/lang/Exception
    //   38	61	157	java/lang/Exception
    //   68	75	157	java/lang/Exception
  }
  
  /* Error */
  public static boolean aoZ(String paramString)
  {
    // Byte code:
    //   0: ldc 122
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 87	com/tencent/mm/vfs/d
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 90	com/tencent/mm/vfs/d:<init>	(Ljava/lang/String;)V
    //   13: astore_0
    //   14: bipush 8
    //   16: newarray byte
    //   18: astore 4
    //   20: ldc 92
    //   22: astore_3
    //   23: aload_0
    //   24: aload 4
    //   26: invokevirtual 98	java/io/InputStream:read	([B)I
    //   29: pop
    //   30: iconst_0
    //   31: istore_1
    //   32: iload_1
    //   33: bipush 8
    //   35: if_icmpge +33 -> 68
    //   38: new 100	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   45: aload_3
    //   46: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload 4
    //   51: iload_1
    //   52: baload
    //   53: i2c
    //   54: invokevirtual 108	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   57: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: astore_3
    //   61: iload_1
    //   62: iconst_1
    //   63: iadd
    //   64: istore_1
    //   65: goto -33 -> 32
    //   68: aload_3
    //   69: ldc 124
    //   71: invokevirtual 117	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   74: istore_2
    //   75: iload_2
    //   76: ifne +14 -> 90
    //   79: aload_0
    //   80: invokevirtual 120	java/io/InputStream:close	()V
    //   83: ldc 122
    //   85: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   88: iconst_0
    //   89: ireturn
    //   90: aload_0
    //   91: invokevirtual 120	java/io/InputStream:close	()V
    //   94: ldc 122
    //   96: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: iconst_1
    //   100: ireturn
    //   101: astore_0
    //   102: aconst_null
    //   103: astore_0
    //   104: aload_0
    //   105: ifnull +7 -> 112
    //   108: aload_0
    //   109: invokevirtual 120	java/io/InputStream:close	()V
    //   112: ldc 122
    //   114: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: iconst_0
    //   118: ireturn
    //   119: astore_3
    //   120: aconst_null
    //   121: astore_0
    //   122: aload_0
    //   123: ifnull +7 -> 130
    //   126: aload_0
    //   127: invokevirtual 120	java/io/InputStream:close	()V
    //   130: ldc 122
    //   132: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: aload_3
    //   136: athrow
    //   137: astore_0
    //   138: goto -55 -> 83
    //   141: astore_0
    //   142: goto -48 -> 94
    //   145: astore_0
    //   146: goto -34 -> 112
    //   149: astore_0
    //   150: goto -20 -> 130
    //   153: astore_3
    //   154: goto -32 -> 122
    //   157: astore_3
    //   158: goto -54 -> 104
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	paramString	String
    //   31	34	1	i	int
    //   74	2	2	bool	boolean
    //   22	47	3	str	String
    //   119	17	3	localObject1	Object
    //   153	1	3	localObject2	Object
    //   157	1	3	localException	java.lang.Exception
    //   18	32	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   5	14	101	java/lang/Exception
    //   5	14	119	finally
    //   79	83	137	java/io/IOException
    //   90	94	141	java/io/IOException
    //   108	112	145	java/io/IOException
    //   126	130	149	java/io/IOException
    //   14	20	153	finally
    //   23	30	153	finally
    //   38	61	153	finally
    //   68	75	153	finally
    //   14	20	157	java/lang/Exception
    //   23	30	157	java/lang/Exception
    //   38	61	157	java/lang/Exception
    //   68	75	157	java/lang/Exception
  }
  
  public static String apa(String paramString)
  {
    AppMethodBeat.i(93399);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(93399);
      return "";
    }
    paramString = bY(e.i(paramString, 0, 2));
    AppMethodBeat.o(93399);
    return paramString;
  }
  
  public static boolean bV(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(93395);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(93395);
      return false;
    }
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
    paramArrayOfByte = "";
    int i = 0;
    while (i < 6) {
      try
      {
        paramArrayOfByte = paramArrayOfByte + (char)localByteArrayInputStream.read();
        i += 1;
      }
      catch (IOException paramArrayOfByte)
      {
        AppMethodBeat.o(93395);
        return false;
      }
    }
    try
    {
      localByteArrayInputStream.close();
      label78:
      if (!paramArrayOfByte.startsWith("GIF"))
      {
        AppMethodBeat.o(93395);
        return false;
      }
      AppMethodBeat.o(93395);
      return true;
    }
    catch (IOException localIOException)
    {
      break label78;
    }
  }
  
  public static boolean bW(byte[] paramArrayOfByte)
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
  
  public static boolean bX(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(93398);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(93398);
      return false;
    }
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
    paramArrayOfByte = "";
    int i = 0;
    while (i < 8) {
      try
      {
        paramArrayOfByte = paramArrayOfByte + (char)localByteArrayInputStream.read();
        i += 1;
      }
      catch (IOException paramArrayOfByte)
      {
        AppMethodBeat.o(93398);
        return false;
      }
    }
    try
    {
      localByteArrayInputStream.close();
      label78:
      if (!paramArrayOfByte.startsWith("wxgf"))
      {
        AppMethodBeat.o(93398);
        return false;
      }
      AppMethodBeat.o(93398);
      return true;
    }
    catch (IOException localIOException)
    {
      break label78;
    }
  }
  
  private static String bY(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 2)) {
      return "";
    }
    int j = paramArrayOfByte[0];
    int i = j;
    if (j < 0) {
      i = j + 256;
    }
    int k = paramArrayOfByte[1];
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.r
 * JD-Core Version:    0.7.0.1
 */