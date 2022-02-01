package com.tencent.mm.sdk.platformtools;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ImgUtil
{
  private static final int MAX_CHECK_IMG_SIZE = 64;
  private static final String TAG = "MicroMsg.ImgUtil";
  
  public static int[] getImgWdithAndHeightFromStream(InputStream paramInputStream)
  {
    AppMethodBeat.i(215367);
    if (paramInputStream == null)
    {
      Log.w("MicroMsg.ImgUtil", "hy: the input stream is null");
      AppMethodBeat.o(215367);
      return null;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    MMBitmapFactory.decodeStream(paramInputStream, null, localOptions);
    int i = localOptions.outWidth;
    int j = localOptions.outHeight;
    AppMethodBeat.o(215367);
    return new int[] { i, j };
  }
  
  /* Error */
  private static int getMaxSampleRateFromFile(String paramString)
  {
    // Byte code:
    //   0: ldc 62
    //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore 4
    //   8: aconst_null
    //   9: astore_3
    //   10: aload_0
    //   11: invokestatic 68	com/tencent/mm/vfs/s:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   14: astore 5
    //   16: aload 5
    //   18: astore_3
    //   19: aload 5
    //   21: astore 4
    //   23: aload 5
    //   25: invokestatic 70	com/tencent/mm/sdk/platformtools/ImgUtil:getImgWdithAndHeightFromStream	(Ljava/io/InputStream;)[I
    //   28: astore 6
    //   30: aload 6
    //   32: ifnull +118 -> 150
    //   35: aload 5
    //   37: astore_3
    //   38: aload 5
    //   40: astore 4
    //   42: aload 6
    //   44: arraylength
    //   45: iconst_2
    //   46: if_icmplt +104 -> 150
    //   49: aload 6
    //   51: iconst_0
    //   52: iaload
    //   53: istore_1
    //   54: aload 6
    //   56: iconst_1
    //   57: iaload
    //   58: istore_2
    //   59: aload 5
    //   61: astore_3
    //   62: aload 5
    //   64: astore 4
    //   66: ldc 11
    //   68: ldc 72
    //   70: iconst_3
    //   71: anewarray 4	java/lang/Object
    //   74: dup
    //   75: iconst_0
    //   76: aload_0
    //   77: aastore
    //   78: dup
    //   79: iconst_1
    //   80: iload_1
    //   81: invokestatic 78	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   84: aastore
    //   85: dup
    //   86: iconst_2
    //   87: iload_2
    //   88: invokestatic 78	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   91: aastore
    //   92: invokestatic 82	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   95: aload 5
    //   97: astore_3
    //   98: aload 5
    //   100: astore 4
    //   102: iload_1
    //   103: iload_2
    //   104: invokestatic 86	com/tencent/mm/sdk/platformtools/ImgUtil:getSampleRate	(II)I
    //   107: istore_1
    //   108: aload 5
    //   110: astore_3
    //   111: aload 5
    //   113: astore 4
    //   115: ldc 11
    //   117: ldc 88
    //   119: iconst_1
    //   120: anewarray 4	java/lang/Object
    //   123: dup
    //   124: iconst_0
    //   125: iload_1
    //   126: invokestatic 78	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   129: aastore
    //   130: invokestatic 82	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   133: aload 5
    //   135: ifnull +8 -> 143
    //   138: aload 5
    //   140: invokevirtual 93	java/io/InputStream:close	()V
    //   143: ldc 62
    //   145: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   148: iload_1
    //   149: ireturn
    //   150: aload 5
    //   152: astore_3
    //   153: aload 5
    //   155: astore 4
    //   157: ldc 11
    //   159: ldc 95
    //   161: invokestatic 33	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   164: aload 5
    //   166: ifnull +8 -> 174
    //   169: aload 5
    //   171: invokevirtual 93	java/io/InputStream:close	()V
    //   174: ldc 62
    //   176: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   179: iconst_1
    //   180: ireturn
    //   181: astore_0
    //   182: aload_3
    //   183: astore 4
    //   185: ldc 11
    //   187: aload_0
    //   188: ldc 97
    //   190: iconst_0
    //   191: anewarray 4	java/lang/Object
    //   194: invokestatic 101	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   197: aload_3
    //   198: ifnull +7 -> 205
    //   201: aload_3
    //   202: invokevirtual 93	java/io/InputStream:close	()V
    //   205: ldc 62
    //   207: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   210: iconst_1
    //   211: ireturn
    //   212: astore_0
    //   213: aload 4
    //   215: ifnull +8 -> 223
    //   218: aload 4
    //   220: invokevirtual 93	java/io/InputStream:close	()V
    //   223: ldc 62
    //   225: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   228: aload_0
    //   229: athrow
    //   230: astore_0
    //   231: goto -88 -> 143
    //   234: astore_0
    //   235: goto -61 -> 174
    //   238: astore_0
    //   239: goto -34 -> 205
    //   242: astore_3
    //   243: goto -20 -> 223
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	paramString	String
    //   53	96	1	i	int
    //   58	46	2	j	int
    //   9	193	3	localObject1	Object
    //   242	1	3	localIOException	IOException
    //   6	213	4	localObject2	Object
    //   14	156	5	localInputStream	InputStream
    //   28	27	6	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   10	16	181	java/io/FileNotFoundException
    //   23	30	181	java/io/FileNotFoundException
    //   42	49	181	java/io/FileNotFoundException
    //   66	95	181	java/io/FileNotFoundException
    //   102	108	181	java/io/FileNotFoundException
    //   115	133	181	java/io/FileNotFoundException
    //   157	164	181	java/io/FileNotFoundException
    //   10	16	212	finally
    //   23	30	212	finally
    //   42	49	212	finally
    //   66	95	212	finally
    //   102	108	212	finally
    //   115	133	212	finally
    //   157	164	212	finally
    //   185	197	212	finally
    //   138	143	230	java/io/IOException
    //   169	174	234	java/io/IOException
    //   201	205	238	java/io/IOException
    //   218	223	242	java/io/IOException
  }
  
  private static int getSampleRate(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(215368);
    paramInt1 = Math.max(paramInt1, paramInt2);
    paramInt2 = 1;
    while (paramInt1 > 64)
    {
      paramInt2 *= 2;
      paramInt1 /= paramInt2;
    }
    AppMethodBeat.o(215368);
    return paramInt2;
  }
  
  public static String identifyImgType(String paramString)
  {
    AppMethodBeat.i(156188);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(156188);
      return "";
    }
    paramString = identifyImgType(s.aW(paramString, 0, 2));
    AppMethodBeat.o(156188);
    return paramString;
  }
  
  public static String identifyImgType(byte[] paramArrayOfByte)
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
  
  /* Error */
  public static boolean isGif(android.content.Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: ldc 138
    //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokevirtual 144	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   9: iload_1
    //   10: invokevirtual 150	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   13: astore_2
    //   14: ldc 112
    //   16: astore_0
    //   17: iconst_0
    //   18: istore_1
    //   19: iload_1
    //   20: bipush 6
    //   22: if_icmpge +49 -> 71
    //   25: new 152	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   32: aload_0
    //   33: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_2
    //   37: invokevirtual 161	java/io/InputStream:read	()I
    //   40: i2c
    //   41: invokevirtual 164	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   44: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: astore_0
    //   48: iload_1
    //   49: iconst_1
    //   50: iadd
    //   51: istore_1
    //   52: goto -33 -> 19
    //   55: astore_0
    //   56: ldc 138
    //   58: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: iconst_0
    //   62: ireturn
    //   63: astore_0
    //   64: ldc 138
    //   66: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: iconst_0
    //   70: ireturn
    //   71: aload_2
    //   72: ifnull +7 -> 79
    //   75: aload_2
    //   76: invokevirtual 93	java/io/InputStream:close	()V
    //   79: aload_0
    //   80: ldc 170
    //   82: invokevirtual 174	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   85: ifne +10 -> 95
    //   88: ldc 138
    //   90: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: iconst_0
    //   94: ireturn
    //   95: ldc 138
    //   97: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: iconst_1
    //   101: ireturn
    //   102: astore_2
    //   103: goto -24 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	paramContext	android.content.Context
    //   0	106	1	paramInt	int
    //   13	63	2	localInputStream	InputStream
    //   102	1	2	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   5	14	55	java/lang/Exception
    //   25	48	63	java/io/IOException
    //   75	79	102	java/io/IOException
  }
  
  /* Error */
  public static boolean isGif(String paramString)
  {
    // Byte code:
    //   0: ldc 175
    //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore 4
    //   8: aconst_null
    //   9: astore_3
    //   10: aload_0
    //   11: invokestatic 68	com/tencent/mm/vfs/s:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   14: astore_0
    //   15: aload_0
    //   16: astore_3
    //   17: aload_0
    //   18: astore 4
    //   20: bipush 6
    //   22: newarray byte
    //   24: astore 6
    //   26: ldc 112
    //   28: astore 5
    //   30: aload_0
    //   31: astore_3
    //   32: aload_0
    //   33: astore 4
    //   35: aload_0
    //   36: aload 6
    //   38: invokevirtual 178	java/io/InputStream:read	([B)I
    //   41: pop
    //   42: iconst_0
    //   43: istore_1
    //   44: iload_1
    //   45: bipush 6
    //   47: if_icmpge +40 -> 87
    //   50: aload_0
    //   51: astore_3
    //   52: aload_0
    //   53: astore 4
    //   55: new 152	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   62: aload 5
    //   64: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload 6
    //   69: iload_1
    //   70: baload
    //   71: i2c
    //   72: invokevirtual 164	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   75: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: astore 5
    //   80: iload_1
    //   81: iconst_1
    //   82: iadd
    //   83: istore_1
    //   84: goto -40 -> 44
    //   87: aload_0
    //   88: astore_3
    //   89: aload_0
    //   90: astore 4
    //   92: aload 5
    //   94: ldc 170
    //   96: invokevirtual 174	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   99: istore_2
    //   100: iload_2
    //   101: ifne +18 -> 119
    //   104: aload_0
    //   105: ifnull +7 -> 112
    //   108: aload_0
    //   109: invokevirtual 93	java/io/InputStream:close	()V
    //   112: ldc 175
    //   114: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: iconst_0
    //   118: ireturn
    //   119: aload_0
    //   120: ifnull +7 -> 127
    //   123: aload_0
    //   124: invokevirtual 93	java/io/InputStream:close	()V
    //   127: ldc 175
    //   129: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   132: iconst_1
    //   133: ireturn
    //   134: astore_0
    //   135: aload_3
    //   136: ifnull +7 -> 143
    //   139: aload_3
    //   140: invokevirtual 93	java/io/InputStream:close	()V
    //   143: ldc 175
    //   145: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   148: iconst_0
    //   149: ireturn
    //   150: astore_0
    //   151: aload 4
    //   153: ifnull +8 -> 161
    //   156: aload 4
    //   158: invokevirtual 93	java/io/InputStream:close	()V
    //   161: ldc 175
    //   163: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   166: aload_0
    //   167: athrow
    //   168: astore_0
    //   169: goto -57 -> 112
    //   172: astore_0
    //   173: goto -46 -> 127
    //   176: astore_0
    //   177: goto -34 -> 143
    //   180: astore_3
    //   181: goto -20 -> 161
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	paramString	String
    //   43	41	1	i	int
    //   99	2	2	bool	boolean
    //   9	131	3	str1	String
    //   180	1	3	localIOException	IOException
    //   6	151	4	str2	String
    //   28	65	5	str3	String
    //   24	44	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   10	15	134	java/lang/Exception
    //   20	26	134	java/lang/Exception
    //   35	42	134	java/lang/Exception
    //   55	80	134	java/lang/Exception
    //   92	100	134	java/lang/Exception
    //   10	15	150	finally
    //   20	26	150	finally
    //   35	42	150	finally
    //   55	80	150	finally
    //   92	100	150	finally
    //   108	112	168	java/io/IOException
    //   123	127	172	java/io/IOException
    //   139	143	176	java/io/IOException
    //   156	161	180	java/io/IOException
  }
  
  public static boolean isGif(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(156182);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(156182);
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
        AppMethodBeat.o(156182);
        return false;
      }
    }
    try
    {
      localByteArrayInputStream.close();
      label78:
      if (!paramArrayOfByte.startsWith("GIF"))
      {
        AppMethodBeat.o(156182);
        return false;
      }
      AppMethodBeat.o(156182);
      return true;
    }
    catch (IOException localIOException)
    {
      break label78;
    }
  }
  
  public static boolean isImageFile(byte[] paramArrayOfByte)
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
  
  /* Error */
  public static boolean isImgFile(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aconst_null
    //   3: astore 7
    //   5: aconst_null
    //   6: astore 6
    //   8: ldc 190
    //   10: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   13: aload_0
    //   14: ifnull +10 -> 24
    //   17: aload_0
    //   18: invokevirtual 193	java/lang/String:length	()I
    //   21: ifne +17 -> 38
    //   24: ldc 11
    //   26: ldc 195
    //   28: invokestatic 198	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: ldc 190
    //   33: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: iconst_0
    //   37: ireturn
    //   38: aload_0
    //   39: invokevirtual 193	java/lang/String:length	()I
    //   42: iconst_3
    //   43: if_icmpge +10 -> 53
    //   46: ldc 190
    //   48: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: iconst_0
    //   52: ireturn
    //   53: new 38	android/graphics/BitmapFactory$Options
    //   56: dup
    //   57: invokespecial 39	android/graphics/BitmapFactory$Options:<init>	()V
    //   60: astore 8
    //   62: aload 8
    //   64: iconst_1
    //   65: putfield 43	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   68: aload 6
    //   70: astore 5
    //   72: aload 7
    //   74: astore 4
    //   76: aload_0
    //   77: invokestatic 201	com/tencent/mm/vfs/s:YS	(Ljava/lang/String;)Z
    //   80: istore_3
    //   81: iload_3
    //   82: ifne +14 -> 96
    //   85: aconst_null
    //   86: invokestatic 207	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   89: ldc 190
    //   91: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: iconst_0
    //   95: ireturn
    //   96: aload 6
    //   98: astore 5
    //   100: aload 7
    //   102: astore 4
    //   104: aload_0
    //   105: invokestatic 68	com/tencent/mm/vfs/s:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   108: astore_0
    //   109: aload_0
    //   110: astore 5
    //   112: aload_0
    //   113: astore 4
    //   115: aload_0
    //   116: aconst_null
    //   117: aload 8
    //   119: invokestatic 49	com/tencent/mm/graphics/MMBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   122: pop
    //   123: aload_0
    //   124: astore 5
    //   126: aload_0
    //   127: astore 4
    //   129: aload 8
    //   131: getfield 52	android/graphics/BitmapFactory$Options:outWidth	I
    //   134: ifle +30 -> 164
    //   137: aload_0
    //   138: astore 5
    //   140: aload_0
    //   141: astore 4
    //   143: aload 8
    //   145: getfield 55	android/graphics/BitmapFactory$Options:outHeight	I
    //   148: istore_1
    //   149: iload_1
    //   150: ifle +14 -> 164
    //   153: aload_0
    //   154: invokestatic 207	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   157: ldc 190
    //   159: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   162: iload_2
    //   163: ireturn
    //   164: iconst_0
    //   165: istore_2
    //   166: goto -13 -> 153
    //   169: astore_0
    //   170: aload 5
    //   172: astore 4
    //   174: ldc 11
    //   176: aload_0
    //   177: ldc 209
    //   179: iconst_0
    //   180: anewarray 4	java/lang/Object
    //   183: invokestatic 101	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   186: aload 5
    //   188: invokestatic 207	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   191: ldc 190
    //   193: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   196: iconst_0
    //   197: ireturn
    //   198: astore_0
    //   199: aload 4
    //   201: invokestatic 207	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   204: ldc 190
    //   206: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   209: aload_0
    //   210: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	211	0	paramString	String
    //   148	2	1	i	int
    //   1	165	2	bool1	boolean
    //   80	2	3	bool2	boolean
    //   74	126	4	localObject1	Object
    //   70	117	5	localObject2	Object
    //   6	91	6	localObject3	Object
    //   3	98	7	localObject4	Object
    //   60	84	8	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   76	81	169	java/lang/Throwable
    //   104	109	169	java/lang/Throwable
    //   115	123	169	java/lang/Throwable
    //   129	137	169	java/lang/Throwable
    //   143	149	169	java/lang/Throwable
    //   76	81	198	finally
    //   104	109	198	finally
    //   115	123	198	finally
    //   129	137	198	finally
    //   143	149	198	finally
    //   174	186	198	finally
  }
  
  /* Error */
  public static boolean isWXGF(String paramString)
  {
    // Byte code:
    //   0: ldc 211
    //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore 4
    //   8: aconst_null
    //   9: astore_3
    //   10: aload_0
    //   11: invokestatic 68	com/tencent/mm/vfs/s:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   14: astore_0
    //   15: aload_0
    //   16: astore_3
    //   17: aload_0
    //   18: astore 4
    //   20: bipush 8
    //   22: newarray byte
    //   24: astore 6
    //   26: ldc 112
    //   28: astore 5
    //   30: aload_0
    //   31: astore_3
    //   32: aload_0
    //   33: astore 4
    //   35: aload_0
    //   36: aload 6
    //   38: invokevirtual 178	java/io/InputStream:read	([B)I
    //   41: pop
    //   42: iconst_0
    //   43: istore_1
    //   44: iload_1
    //   45: bipush 8
    //   47: if_icmpge +40 -> 87
    //   50: aload_0
    //   51: astore_3
    //   52: aload_0
    //   53: astore 4
    //   55: new 152	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   62: aload 5
    //   64: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload 6
    //   69: iload_1
    //   70: baload
    //   71: i2c
    //   72: invokevirtual 164	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   75: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: astore 5
    //   80: iload_1
    //   81: iconst_1
    //   82: iadd
    //   83: istore_1
    //   84: goto -40 -> 44
    //   87: aload_0
    //   88: astore_3
    //   89: aload_0
    //   90: astore 4
    //   92: aload 5
    //   94: ldc 213
    //   96: invokevirtual 174	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   99: istore_2
    //   100: iload_2
    //   101: ifne +18 -> 119
    //   104: aload_0
    //   105: ifnull +7 -> 112
    //   108: aload_0
    //   109: invokevirtual 93	java/io/InputStream:close	()V
    //   112: ldc 211
    //   114: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: iconst_0
    //   118: ireturn
    //   119: aload_0
    //   120: ifnull +7 -> 127
    //   123: aload_0
    //   124: invokevirtual 93	java/io/InputStream:close	()V
    //   127: ldc 211
    //   129: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   132: iconst_1
    //   133: ireturn
    //   134: astore_0
    //   135: aload_3
    //   136: ifnull +7 -> 143
    //   139: aload_3
    //   140: invokevirtual 93	java/io/InputStream:close	()V
    //   143: ldc 211
    //   145: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   148: iconst_0
    //   149: ireturn
    //   150: astore_0
    //   151: aload 4
    //   153: ifnull +8 -> 161
    //   156: aload 4
    //   158: invokevirtual 93	java/io/InputStream:close	()V
    //   161: ldc 211
    //   163: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   166: aload_0
    //   167: athrow
    //   168: astore_0
    //   169: goto -57 -> 112
    //   172: astore_0
    //   173: goto -46 -> 127
    //   176: astore_0
    //   177: goto -34 -> 143
    //   180: astore_3
    //   181: goto -20 -> 161
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	paramString	String
    //   43	41	1	i	int
    //   99	2	2	bool	boolean
    //   9	131	3	str1	String
    //   180	1	3	localIOException	IOException
    //   6	151	4	str2	String
    //   28	65	5	str3	String
    //   24	44	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   10	15	134	java/lang/Exception
    //   20	26	134	java/lang/Exception
    //   35	42	134	java/lang/Exception
    //   55	80	134	java/lang/Exception
    //   92	100	134	java/lang/Exception
    //   10	15	150	finally
    //   20	26	150	finally
    //   35	42	150	finally
    //   55	80	150	finally
    //   92	100	150	finally
    //   108	112	168	java/io/IOException
    //   123	127	172	java/io/IOException
    //   139	143	176	java/io/IOException
    //   156	161	180	java/io/IOException
  }
  
  public static boolean isWXGF(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(156186);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(156186);
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
        AppMethodBeat.o(156186);
        return false;
      }
    }
    try
    {
      localByteArrayInputStream.close();
      label78:
      if (!paramArrayOfByte.startsWith("wxgf"))
      {
        AppMethodBeat.o(156186);
        return false;
      }
      AppMethodBeat.o(156186);
      return true;
    }
    catch (IOException localIOException)
    {
      break label78;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ImgUtil
 * JD-Core Version:    0.7.0.1
 */