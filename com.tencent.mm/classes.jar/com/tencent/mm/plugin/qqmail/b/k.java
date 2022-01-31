package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public final class k
{
  public static int ndz = 100;
  private int dng = ndz;
  public String ndA = null;
  
  public k(String paramString, int paramInt)
  {
    y.i("Msg.Plugin.HttpRequestCache", "HttpRequestCache constructor, path = " + paramString + ", maxCount = " + paramInt);
    this.ndA = paramString;
    paramString = new File(this.ndA);
    if (!paramString.exists()) {
      paramString.mkdir();
    }
    if (paramInt > 0) {}
    for (;;)
    {
      this.dng = paramInt;
      return;
      paramInt = ndz;
    }
  }
  
  private static byte[] Lf(String paramString)
  {
    return g.o(paramString.toString().getBytes()).substring(8, 16).getBytes();
  }
  
  private static byte[] decrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      paramArrayOfByte2 = new DESKeySpec(paramArrayOfByte2);
      paramArrayOfByte2 = SecretKeyFactory.getInstance("DES").generateSecret(paramArrayOfByte2);
      Cipher localCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
      localCipher.init(2, paramArrayOfByte2, new IvParameterSpec("12345678".getBytes()));
      paramArrayOfByte1 = localCipher.doFinal(paramArrayOfByte1);
      return paramArrayOfByte1;
    }
    catch (Exception paramArrayOfByte1)
    {
      y.printErrStackTrace("Msg.Plugin.HttpRequestCache", paramArrayOfByte1, "", new Object[0]);
    }
    return null;
  }
  
  private static byte[] encrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      paramArrayOfByte2 = new DESKeySpec(paramArrayOfByte2);
      paramArrayOfByte2 = SecretKeyFactory.getInstance("DES").generateSecret(paramArrayOfByte2);
      Cipher localCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
      localCipher.init(1, paramArrayOfByte2, new IvParameterSpec("12345678".getBytes()));
      paramArrayOfByte1 = localCipher.doFinal(paramArrayOfByte1);
      return paramArrayOfByte1;
    }
    catch (Exception paramArrayOfByte1)
    {
      y.printErrStackTrace("Msg.Plugin.HttpRequestCache", paramArrayOfByte1, "", new Object[0]);
    }
    return null;
  }
  
  private static String q(String paramString, Map<String, String> paramMap)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramString);
    if (paramMap != null)
    {
      paramString = paramMap.entrySet().iterator();
      while (paramString.hasNext())
      {
        Object localObject = (Map.Entry)paramString.next();
        paramMap = (String)((Map.Entry)localObject).getKey();
        localObject = (String)((Map.Entry)localObject).getValue();
        localStringBuffer.append(paramMap);
        localStringBuffer.append((String)localObject);
      }
    }
    return g.o(localStringBuffer.toString().getBytes());
  }
  
  /* Error */
  public static boolean r(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: new 173	java/io/FileOutputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 174	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   10: astore_3
    //   11: aload_3
    //   12: astore_0
    //   13: aload_3
    //   14: aload_1
    //   15: invokevirtual 177	java/io/FileOutputStream:write	([B)V
    //   18: aload_3
    //   19: astore_0
    //   20: aload_3
    //   21: invokevirtual 180	java/io/FileOutputStream:flush	()V
    //   24: aload_3
    //   25: invokevirtual 183	java/io/FileOutputStream:close	()V
    //   28: iconst_1
    //   29: istore_2
    //   30: iload_2
    //   31: ireturn
    //   32: astore_0
    //   33: ldc 24
    //   35: aload_0
    //   36: ldc 122
    //   38: iconst_0
    //   39: anewarray 4	java/lang/Object
    //   42: invokestatic 126	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   45: goto -17 -> 28
    //   48: astore 4
    //   50: aconst_null
    //   51: astore_1
    //   52: aload_1
    //   53: astore_0
    //   54: ldc 24
    //   56: aload 4
    //   58: ldc 122
    //   60: iconst_0
    //   61: anewarray 4	java/lang/Object
    //   64: invokestatic 126	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   67: aload_1
    //   68: ifnull -38 -> 30
    //   71: aload_1
    //   72: invokevirtual 183	java/io/FileOutputStream:close	()V
    //   75: iconst_0
    //   76: ireturn
    //   77: astore_0
    //   78: ldc 24
    //   80: aload_0
    //   81: ldc 122
    //   83: iconst_0
    //   84: anewarray 4	java/lang/Object
    //   87: invokestatic 126	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   90: iconst_0
    //   91: ireturn
    //   92: astore_1
    //   93: aconst_null
    //   94: astore_0
    //   95: aload_0
    //   96: ifnull +7 -> 103
    //   99: aload_0
    //   100: invokevirtual 183	java/io/FileOutputStream:close	()V
    //   103: aload_1
    //   104: athrow
    //   105: astore_0
    //   106: ldc 24
    //   108: aload_0
    //   109: ldc 122
    //   111: iconst_0
    //   112: anewarray 4	java/lang/Object
    //   115: invokestatic 126	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   118: goto -15 -> 103
    //   121: astore_1
    //   122: goto -27 -> 95
    //   125: astore 4
    //   127: aload_3
    //   128: astore_1
    //   129: goto -77 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	paramString	String
    //   0	132	1	paramArrayOfByte	byte[]
    //   1	30	2	bool	boolean
    //   10	118	3	localFileOutputStream	java.io.FileOutputStream
    //   48	9	4	localException1	Exception
    //   125	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   24	28	32	java/io/IOException
    //   2	11	48	java/lang/Exception
    //   71	75	77	java/io/IOException
    //   2	11	92	finally
    //   99	103	105	java/io/IOException
    //   13	18	121	finally
    //   20	24	121	finally
    //   54	67	121	finally
    //   13	18	125	java/lang/Exception
    //   20	24	125	java/lang/Exception
  }
  
  /* Error */
  public static byte[] readFromFile(String paramString)
  {
    // Byte code:
    //   0: new 52	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 53	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 57	java/io/File:exists	()Z
    //   13: ifne +5 -> 18
    //   16: aconst_null
    //   17: areturn
    //   18: aload_0
    //   19: invokevirtual 188	java/io/File:length	()J
    //   22: l2i
    //   23: istore_1
    //   24: new 190	java/io/FileInputStream
    //   27: dup
    //   28: aload_0
    //   29: invokespecial 193	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   32: astore_3
    //   33: aload_3
    //   34: astore_0
    //   35: iload_1
    //   36: newarray byte
    //   38: astore 4
    //   40: aload_3
    //   41: astore_0
    //   42: aload_3
    //   43: aload 4
    //   45: invokevirtual 197	java/io/FileInputStream:read	([B)I
    //   48: istore_2
    //   49: iload_2
    //   50: iload_1
    //   51: if_icmpeq +24 -> 75
    //   54: aload_3
    //   55: invokevirtual 198	java/io/FileInputStream:close	()V
    //   58: aconst_null
    //   59: areturn
    //   60: astore_0
    //   61: ldc 24
    //   63: aload_0
    //   64: ldc 122
    //   66: iconst_0
    //   67: anewarray 4	java/lang/Object
    //   70: invokestatic 126	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   73: aconst_null
    //   74: areturn
    //   75: aload_3
    //   76: invokevirtual 198	java/io/FileInputStream:close	()V
    //   79: aload 4
    //   81: areturn
    //   82: astore_0
    //   83: ldc 24
    //   85: aload_0
    //   86: ldc 122
    //   88: iconst_0
    //   89: anewarray 4	java/lang/Object
    //   92: invokestatic 126	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   95: goto -16 -> 79
    //   98: astore 4
    //   100: aconst_null
    //   101: astore_3
    //   102: aload_3
    //   103: astore_0
    //   104: ldc 24
    //   106: aload 4
    //   108: ldc 122
    //   110: iconst_0
    //   111: anewarray 4	java/lang/Object
    //   114: invokestatic 126	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   117: aload_3
    //   118: ifnull +62 -> 180
    //   121: aload_3
    //   122: invokevirtual 198	java/io/FileInputStream:close	()V
    //   125: aconst_null
    //   126: areturn
    //   127: astore_0
    //   128: ldc 24
    //   130: aload_0
    //   131: ldc 122
    //   133: iconst_0
    //   134: anewarray 4	java/lang/Object
    //   137: invokestatic 126	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   140: aconst_null
    //   141: areturn
    //   142: astore_3
    //   143: aconst_null
    //   144: astore_0
    //   145: aload_0
    //   146: ifnull +7 -> 153
    //   149: aload_0
    //   150: invokevirtual 198	java/io/FileInputStream:close	()V
    //   153: aload_3
    //   154: athrow
    //   155: astore_0
    //   156: ldc 24
    //   158: aload_0
    //   159: ldc 122
    //   161: iconst_0
    //   162: anewarray 4	java/lang/Object
    //   165: invokestatic 126	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   168: goto -15 -> 153
    //   171: astore_3
    //   172: goto -27 -> 145
    //   175: astore 4
    //   177: goto -75 -> 102
    //   180: aconst_null
    //   181: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	paramString	String
    //   23	29	1	i	int
    //   48	4	2	j	int
    //   32	90	3	localFileInputStream	java.io.FileInputStream
    //   142	12	3	localObject1	Object
    //   171	1	3	localObject2	Object
    //   38	42	4	arrayOfByte	byte[]
    //   98	9	4	localException1	Exception
    //   175	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   54	58	60	java/io/IOException
    //   75	79	82	java/io/IOException
    //   0	16	98	java/lang/Exception
    //   18	33	98	java/lang/Exception
    //   121	125	127	java/io/IOException
    //   0	16	142	finally
    //   18	33	142	finally
    //   149	153	155	java/io/IOException
    //   35	40	171	finally
    //   42	49	171	finally
    //   104	117	171	finally
    //   35	40	175	java/lang/Exception
    //   42	49	175	java/lang/Exception
  }
  
  public final boolean a(String paramString, Map<String, String> paramMap, byte[] paramArrayOfByte)
  {
    if ((paramString == null) || (paramString.length() == 0) || (paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      y.e("Msg.Plugin.HttpRequestCache", "setCache, invalid argument");
      return false;
    }
    bts();
    paramString = q(paramString, paramMap);
    paramMap = encrypt(paramArrayOfByte, Lf(paramString));
    if (paramMap == null)
    {
      y.e("Msg.Plugin.HttpRequestCache", "encrypt fail, cipherText is null");
      return false;
    }
    return r(this.ndA + paramString, paramMap);
  }
  
  public final void bts()
  {
    int j = 0;
    Object localObject = new File(this.ndA).list();
    int i;
    if (localObject != null)
    {
      i = localObject.length;
      if (i >= this.dng) {
        break label41;
      }
    }
    label41:
    do
    {
      return;
      i = 0;
      break;
      String[] arrayOfString = new File(this.ndA).list();
      localObject = null;
      int k = arrayOfString.length;
      i = j;
      while (i < k)
      {
        localObject = new File(arrayOfString[i]);
        ((File)localObject).lastModified();
        i += 1;
      }
    } while (!((File)localObject).exists());
    ((File)localObject).delete();
  }
  
  public final byte[] p(String paramString, Map<String, String> paramMap)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      y.e("Msg.Plugin.HttpRequestCache", "getCache, invalid argument");
      return null;
    }
    paramString = q(paramString, paramMap);
    paramMap = readFromFile(this.ndA + paramString);
    if (paramMap == null)
    {
      y.i("Msg.Plugin.HttpRequestCache", "readFromFile fail, cipherText is null, read error or cache not exist");
      return null;
    }
    paramString = decrypt(paramMap, Lf(paramString));
    if (paramString == null)
    {
      y.e("Msg.Plugin.HttpRequestCache", "decrypt fail, plaintText is null");
      return null;
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.k
 * JD-Core Version:    0.7.0.1
 */