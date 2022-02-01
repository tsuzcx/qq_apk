package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.i;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class t
{
  /* Error */
  public static boolean aFl(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aconst_null
    //   3: astore 7
    //   5: aconst_null
    //   6: astore 6
    //   8: ldc 9
    //   10: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   13: aload_0
    //   14: ifnull +10 -> 24
    //   17: aload_0
    //   18: invokevirtual 21	java/lang/String:length	()I
    //   21: ifne +17 -> 38
    //   24: ldc 23
    //   26: ldc 25
    //   28: invokestatic 31	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: ldc 9
    //   33: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: iconst_0
    //   37: ireturn
    //   38: aload_0
    //   39: invokevirtual 21	java/lang/String:length	()I
    //   42: iconst_3
    //   43: if_icmpge +10 -> 53
    //   46: ldc 9
    //   48: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: iconst_0
    //   52: ireturn
    //   53: new 36	android/graphics/BitmapFactory$Options
    //   56: dup
    //   57: invokespecial 40	android/graphics/BitmapFactory$Options:<init>	()V
    //   60: astore 8
    //   62: aload 8
    //   64: iconst_1
    //   65: putfield 44	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   68: aload 6
    //   70: astore 5
    //   72: aload 7
    //   74: astore 4
    //   76: aload_0
    //   77: invokestatic 49	com/tencent/mm/vfs/i:eK	(Ljava/lang/String;)Z
    //   80: istore_3
    //   81: iload_3
    //   82: ifne +14 -> 96
    //   85: aconst_null
    //   86: invokestatic 55	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   89: ldc 9
    //   91: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: iconst_0
    //   95: ireturn
    //   96: aload 6
    //   98: astore 5
    //   100: aload 7
    //   102: astore 4
    //   104: aload_0
    //   105: invokestatic 59	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   108: astore_0
    //   109: aload_0
    //   110: astore 5
    //   112: aload_0
    //   113: astore 4
    //   115: aload_0
    //   116: aconst_null
    //   117: aload 8
    //   119: invokestatic 65	com/tencent/mm/graphics/MMBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   122: pop
    //   123: aload_0
    //   124: astore 5
    //   126: aload_0
    //   127: astore 4
    //   129: aload 8
    //   131: getfield 69	android/graphics/BitmapFactory$Options:outWidth	I
    //   134: ifle +30 -> 164
    //   137: aload_0
    //   138: astore 5
    //   140: aload_0
    //   141: astore 4
    //   143: aload 8
    //   145: getfield 72	android/graphics/BitmapFactory$Options:outHeight	I
    //   148: istore_1
    //   149: iload_1
    //   150: ifle +14 -> 164
    //   153: aload_0
    //   154: invokestatic 55	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   157: ldc 9
    //   159: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   162: iload_2
    //   163: ireturn
    //   164: iconst_0
    //   165: istore_2
    //   166: goto -13 -> 153
    //   169: astore_0
    //   170: aload 5
    //   172: astore 4
    //   174: ldc 23
    //   176: aload_0
    //   177: ldc 74
    //   179: iconst_0
    //   180: anewarray 4	java/lang/Object
    //   183: invokestatic 78	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   186: aload 5
    //   188: invokestatic 55	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   191: ldc 9
    //   193: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   196: iconst_0
    //   197: ireturn
    //   198: astore_0
    //   199: aload 4
    //   201: invokestatic 55	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   204: ldc 9
    //   206: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   60	84	8	localOptions	android.graphics.BitmapFactory.Options
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
  public static boolean aFm(String paramString)
  {
    // Byte code:
    //   0: ldc 85
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore 4
    //   8: aconst_null
    //   9: astore_3
    //   10: aload_0
    //   11: invokestatic 59	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   14: astore_0
    //   15: aload_0
    //   16: astore_3
    //   17: aload_0
    //   18: astore 4
    //   20: bipush 6
    //   22: newarray byte
    //   24: astore 6
    //   26: ldc 87
    //   28: astore 5
    //   30: aload_0
    //   31: astore_3
    //   32: aload_0
    //   33: astore 4
    //   35: aload_0
    //   36: aload 6
    //   38: invokevirtual 93	java/io/InputStream:read	([B)I
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
    //   55: new 95	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   62: aload 5
    //   64: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload 6
    //   69: iload_1
    //   70: baload
    //   71: i2c
    //   72: invokevirtual 103	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   75: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
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
    //   94: ldc 109
    //   96: invokevirtual 112	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   99: istore_2
    //   100: iload_2
    //   101: ifne +18 -> 119
    //   104: aload_0
    //   105: ifnull +7 -> 112
    //   108: aload_0
    //   109: invokevirtual 115	java/io/InputStream:close	()V
    //   112: ldc 85
    //   114: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: iconst_0
    //   118: ireturn
    //   119: aload_0
    //   120: ifnull +7 -> 127
    //   123: aload_0
    //   124: invokevirtual 115	java/io/InputStream:close	()V
    //   127: ldc 85
    //   129: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   132: iconst_1
    //   133: ireturn
    //   134: astore_0
    //   135: aload_3
    //   136: ifnull +7 -> 143
    //   139: aload_3
    //   140: invokevirtual 115	java/io/InputStream:close	()V
    //   143: ldc 85
    //   145: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   148: iconst_0
    //   149: ireturn
    //   150: astore_0
    //   151: aload 4
    //   153: ifnull +8 -> 161
    //   156: aload 4
    //   158: invokevirtual 115	java/io/InputStream:close	()V
    //   161: ldc 85
    //   163: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  /* Error */
  public static boolean aFn(String paramString)
  {
    // Byte code:
    //   0: ldc 117
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore 4
    //   8: aconst_null
    //   9: astore_3
    //   10: aload_0
    //   11: invokestatic 59	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   14: astore_0
    //   15: aload_0
    //   16: astore_3
    //   17: aload_0
    //   18: astore 4
    //   20: bipush 8
    //   22: newarray byte
    //   24: astore 6
    //   26: ldc 87
    //   28: astore 5
    //   30: aload_0
    //   31: astore_3
    //   32: aload_0
    //   33: astore 4
    //   35: aload_0
    //   36: aload 6
    //   38: invokevirtual 93	java/io/InputStream:read	([B)I
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
    //   55: new 95	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   62: aload 5
    //   64: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload 6
    //   69: iload_1
    //   70: baload
    //   71: i2c
    //   72: invokevirtual 103	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   75: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
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
    //   94: ldc 119
    //   96: invokevirtual 112	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   99: istore_2
    //   100: iload_2
    //   101: ifne +18 -> 119
    //   104: aload_0
    //   105: ifnull +7 -> 112
    //   108: aload_0
    //   109: invokevirtual 115	java/io/InputStream:close	()V
    //   112: ldc 117
    //   114: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: iconst_0
    //   118: ireturn
    //   119: aload_0
    //   120: ifnull +7 -> 127
    //   123: aload_0
    //   124: invokevirtual 115	java/io/InputStream:close	()V
    //   127: ldc 117
    //   129: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   132: iconst_1
    //   133: ireturn
    //   134: astore_0
    //   135: aload_3
    //   136: ifnull +7 -> 143
    //   139: aload_3
    //   140: invokevirtual 115	java/io/InputStream:close	()V
    //   143: ldc 117
    //   145: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   148: iconst_0
    //   149: ireturn
    //   150: astore_0
    //   151: aload 4
    //   153: ifnull +8 -> 161
    //   156: aload 4
    //   158: invokevirtual 115	java/io/InputStream:close	()V
    //   161: ldc 117
    //   163: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static String aFo(String paramString)
  {
    AppMethodBeat.i(156188);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(156188);
      return "";
    }
    paramString = cq(i.aR(paramString, 0, 2));
    AppMethodBeat.o(156188);
    return paramString;
  }
  
  /* Error */
  public static boolean av(android.content.Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: ldc 137
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokevirtual 143	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   9: iload_1
    //   10: invokevirtual 149	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   13: astore_2
    //   14: ldc 87
    //   16: astore_0
    //   17: iconst_0
    //   18: istore_1
    //   19: iload_1
    //   20: bipush 6
    //   22: if_icmpge +49 -> 71
    //   25: new 95	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   32: aload_0
    //   33: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_2
    //   37: invokevirtual 151	java/io/InputStream:read	()I
    //   40: i2c
    //   41: invokevirtual 103	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   44: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: astore_0
    //   48: iload_1
    //   49: iconst_1
    //   50: iadd
    //   51: istore_1
    //   52: goto -33 -> 19
    //   55: astore_0
    //   56: ldc 137
    //   58: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: iconst_0
    //   62: ireturn
    //   63: astore_0
    //   64: ldc 137
    //   66: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: iconst_0
    //   70: ireturn
    //   71: aload_2
    //   72: ifnull +7 -> 79
    //   75: aload_2
    //   76: invokevirtual 115	java/io/InputStream:close	()V
    //   79: aload_0
    //   80: ldc 109
    //   82: invokevirtual 112	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   85: ifne +10 -> 95
    //   88: ldc 137
    //   90: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: iconst_0
    //   94: ireturn
    //   95: ldc 137
    //   97: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static boolean cn(byte[] paramArrayOfByte)
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
  
  public static boolean co(byte[] paramArrayOfByte)
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
  
  public static boolean cp(byte[] paramArrayOfByte)
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
  
  public static String cq(byte[] paramArrayOfByte)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.t
 * JD-Core Version:    0.7.0.1
 */