package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.ab;
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
  public static int pIQ = 100;
  private int eeH;
  public String pIR;
  
  public k(String paramString, int paramInt)
  {
    AppMethodBeat.i(67933);
    this.pIR = null;
    this.eeH = pIQ;
    ab.i("Msg.Plugin.HttpRequestCache", "HttpRequestCache constructor, path = " + paramString + ", maxCount = " + paramInt);
    this.pIR = paramString;
    paramString = new File(this.pIR);
    if (!paramString.exists()) {
      paramString.mkdir();
    }
    if (paramInt > 0) {}
    for (;;)
    {
      this.eeH = paramInt;
      AppMethodBeat.o(67933);
      return;
      paramInt = pIQ;
    }
  }
  
  private static byte[] Xo(String paramString)
  {
    AppMethodBeat.i(67937);
    paramString = g.w(paramString.toString().getBytes()).substring(8, 16).getBytes();
    AppMethodBeat.o(67937);
    return paramString;
  }
  
  private static int Xp(String paramString)
  {
    AppMethodBeat.i(67938);
    paramString = new File(paramString).list();
    if (paramString != null)
    {
      int i = paramString.length;
      AppMethodBeat.o(67938);
      return i;
    }
    AppMethodBeat.o(67938);
    return 0;
  }
  
  private static byte[] decrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(67941);
    try
    {
      paramArrayOfByte2 = new DESKeySpec(paramArrayOfByte2);
      paramArrayOfByte2 = SecretKeyFactory.getInstance("DES").generateSecret(paramArrayOfByte2);
      Cipher localCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
      localCipher.init(2, paramArrayOfByte2, new IvParameterSpec("12345678".getBytes()));
      paramArrayOfByte1 = localCipher.doFinal(paramArrayOfByte1);
      AppMethodBeat.o(67941);
      return paramArrayOfByte1;
    }
    catch (Exception paramArrayOfByte1)
    {
      for (;;)
      {
        ab.printErrStackTrace("Msg.Plugin.HttpRequestCache", paramArrayOfByte1, "", new Object[0]);
        paramArrayOfByte1 = null;
      }
    }
  }
  
  private static byte[] encrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(67940);
    try
    {
      paramArrayOfByte2 = new DESKeySpec(paramArrayOfByte2);
      paramArrayOfByte2 = SecretKeyFactory.getInstance("DES").generateSecret(paramArrayOfByte2);
      Cipher localCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
      localCipher.init(1, paramArrayOfByte2, new IvParameterSpec("12345678".getBytes()));
      paramArrayOfByte1 = localCipher.doFinal(paramArrayOfByte1);
      AppMethodBeat.o(67940);
      return paramArrayOfByte1;
    }
    catch (Exception paramArrayOfByte1)
    {
      for (;;)
      {
        ab.printErrStackTrace("Msg.Plugin.HttpRequestCache", paramArrayOfByte1, "", new Object[0]);
        paramArrayOfByte1 = null;
      }
    }
  }
  
  /* Error */
  public static byte[] readFromFile(String paramString)
  {
    // Byte code:
    //   0: ldc 150
    //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 58	java/io/File
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_0
    //   14: aload_0
    //   15: invokevirtual 63	java/io/File:exists	()Z
    //   18: istore_3
    //   19: iload_3
    //   20: ifne +10 -> 30
    //   23: ldc 150
    //   25: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: aconst_null
    //   29: areturn
    //   30: aload_0
    //   31: invokevirtual 154	java/io/File:length	()J
    //   34: l2i
    //   35: istore_1
    //   36: new 156	java/io/FileInputStream
    //   39: dup
    //   40: aload_0
    //   41: invokespecial 159	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   44: astore 4
    //   46: aload 4
    //   48: astore_0
    //   49: iload_1
    //   50: newarray byte
    //   52: astore 5
    //   54: aload 4
    //   56: astore_0
    //   57: aload 4
    //   59: aload 5
    //   61: invokevirtual 163	java/io/FileInputStream:read	([B)I
    //   64: istore_2
    //   65: iload_2
    //   66: iload_1
    //   67: if_icmpeq +31 -> 98
    //   70: aload 4
    //   72: invokevirtual 166	java/io/FileInputStream:close	()V
    //   75: ldc 150
    //   77: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: aconst_null
    //   81: areturn
    //   82: astore_0
    //   83: ldc 31
    //   85: aload_0
    //   86: ldc 140
    //   88: iconst_0
    //   89: anewarray 4	java/lang/Object
    //   92: invokestatic 144	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   95: goto -20 -> 75
    //   98: aload 4
    //   100: invokevirtual 166	java/io/FileInputStream:close	()V
    //   103: ldc 150
    //   105: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   108: aload 5
    //   110: areturn
    //   111: astore_0
    //   112: ldc 31
    //   114: aload_0
    //   115: ldc 140
    //   117: iconst_0
    //   118: anewarray 4	java/lang/Object
    //   121: invokestatic 144	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   124: goto -21 -> 103
    //   127: astore 5
    //   129: aconst_null
    //   130: astore 4
    //   132: aload 4
    //   134: astore_0
    //   135: ldc 31
    //   137: aload 5
    //   139: ldc 140
    //   141: iconst_0
    //   142: anewarray 4	java/lang/Object
    //   145: invokestatic 144	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   148: aload 4
    //   150: ifnull +8 -> 158
    //   153: aload 4
    //   155: invokevirtual 166	java/io/FileInputStream:close	()V
    //   158: ldc 150
    //   160: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   163: aconst_null
    //   164: areturn
    //   165: astore_0
    //   166: ldc 31
    //   168: aload_0
    //   169: ldc 140
    //   171: iconst_0
    //   172: anewarray 4	java/lang/Object
    //   175: invokestatic 144	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   178: goto -20 -> 158
    //   181: astore 4
    //   183: aconst_null
    //   184: astore_0
    //   185: aload_0
    //   186: ifnull +7 -> 193
    //   189: aload_0
    //   190: invokevirtual 166	java/io/FileInputStream:close	()V
    //   193: ldc 150
    //   195: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   198: aload 4
    //   200: athrow
    //   201: astore_0
    //   202: ldc 31
    //   204: aload_0
    //   205: ldc 140
    //   207: iconst_0
    //   208: anewarray 4	java/lang/Object
    //   211: invokestatic 144	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   214: goto -21 -> 193
    //   217: astore 4
    //   219: goto -34 -> 185
    //   222: astore 5
    //   224: goto -92 -> 132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	227	0	paramString	String
    //   35	33	1	i	int
    //   64	4	2	j	int
    //   18	2	3	bool	boolean
    //   44	110	4	localFileInputStream	java.io.FileInputStream
    //   181	18	4	localObject1	Object
    //   217	1	4	localObject2	Object
    //   52	57	5	arrayOfByte	byte[]
    //   127	11	5	localException1	Exception
    //   222	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   70	75	82	java/io/IOException
    //   98	103	111	java/io/IOException
    //   5	19	127	java/lang/Exception
    //   30	46	127	java/lang/Exception
    //   153	158	165	java/io/IOException
    //   5	19	181	finally
    //   30	46	181	finally
    //   189	193	201	java/io/IOException
    //   49	54	217	finally
    //   57	65	217	finally
    //   135	148	217	finally
    //   49	54	222	java/lang/Exception
    //   57	65	222	java/lang/Exception
  }
  
  private static String w(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(67936);
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
    paramString = g.w(localStringBuffer.toString().getBytes());
    AppMethodBeat.o(67936);
    return paramString;
  }
  
  /* Error */
  public static boolean z(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 209
    //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 211	java/io/FileOutputStream
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 212	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   13: astore_2
    //   14: aload_2
    //   15: astore_0
    //   16: aload_2
    //   17: aload_1
    //   18: invokevirtual 215	java/io/FileOutputStream:write	([B)V
    //   21: aload_2
    //   22: astore_0
    //   23: aload_2
    //   24: invokevirtual 218	java/io/FileOutputStream:flush	()V
    //   27: aload_2
    //   28: invokevirtual 219	java/io/FileOutputStream:close	()V
    //   31: ldc 209
    //   33: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: iconst_1
    //   37: ireturn
    //   38: astore_0
    //   39: ldc 31
    //   41: aload_0
    //   42: ldc 140
    //   44: iconst_0
    //   45: anewarray 4	java/lang/Object
    //   48: invokestatic 144	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   51: goto -20 -> 31
    //   54: astore_3
    //   55: aconst_null
    //   56: astore_1
    //   57: aload_1
    //   58: astore_0
    //   59: ldc 31
    //   61: aload_3
    //   62: ldc 140
    //   64: iconst_0
    //   65: anewarray 4	java/lang/Object
    //   68: invokestatic 144	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   71: aload_1
    //   72: ifnull +7 -> 79
    //   75: aload_1
    //   76: invokevirtual 219	java/io/FileOutputStream:close	()V
    //   79: ldc 209
    //   81: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: iconst_0
    //   85: ireturn
    //   86: astore_0
    //   87: ldc 31
    //   89: aload_0
    //   90: ldc 140
    //   92: iconst_0
    //   93: anewarray 4	java/lang/Object
    //   96: invokestatic 144	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   99: goto -20 -> 79
    //   102: astore_1
    //   103: aconst_null
    //   104: astore_0
    //   105: aload_0
    //   106: ifnull +7 -> 113
    //   109: aload_0
    //   110: invokevirtual 219	java/io/FileOutputStream:close	()V
    //   113: ldc 209
    //   115: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: aload_1
    //   119: athrow
    //   120: astore_0
    //   121: ldc 31
    //   123: aload_0
    //   124: ldc 140
    //   126: iconst_0
    //   127: anewarray 4	java/lang/Object
    //   130: invokestatic 144	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   133: goto -20 -> 113
    //   136: astore_1
    //   137: goto -32 -> 105
    //   140: astore_3
    //   141: aload_2
    //   142: astore_1
    //   143: goto -86 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	paramString	String
    //   0	146	1	paramArrayOfByte	byte[]
    //   13	129	2	localFileOutputStream	java.io.FileOutputStream
    //   54	8	3	localException1	Exception
    //   140	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   27	31	38	java/io/IOException
    //   5	14	54	java/lang/Exception
    //   75	79	86	java/io/IOException
    //   5	14	102	finally
    //   109	113	120	java/io/IOException
    //   16	21	136	finally
    //   23	27	136	finally
    //   59	71	136	finally
    //   16	21	140	java/lang/Exception
    //   23	27	140	java/lang/Exception
  }
  
  public final boolean b(String paramString, Map<String, String> paramMap, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(67935);
    if ((paramString == null) || (paramString.length() == 0) || (paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      ab.e("Msg.Plugin.HttpRequestCache", "setCache, invalid argument");
      AppMethodBeat.o(67935);
      return false;
    }
    cdC();
    paramString = w(paramString, paramMap);
    paramMap = encrypt(paramArrayOfByte, Xo(paramString));
    if (paramMap == null)
    {
      ab.e("Msg.Plugin.HttpRequestCache", "encrypt fail, cipherText is null");
      AppMethodBeat.o(67935);
      return false;
    }
    boolean bool = z(this.pIR + paramString, paramMap);
    AppMethodBeat.o(67935);
    return bool;
  }
  
  public final void cdC()
  {
    AppMethodBeat.i(67939);
    if (Xp(this.pIR) < this.eeH)
    {
      AppMethodBeat.o(67939);
      return;
    }
    String[] arrayOfString = new File(this.pIR).list();
    File localFile = null;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      localFile = new File(arrayOfString[i]);
      localFile.lastModified();
      i += 1;
    }
    if (localFile.exists()) {
      localFile.delete();
    }
    AppMethodBeat.o(67939);
  }
  
  public final byte[] v(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(67934);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ab.e("Msg.Plugin.HttpRequestCache", "getCache, invalid argument");
      AppMethodBeat.o(67934);
      return null;
    }
    paramString = w(paramString, paramMap);
    paramMap = readFromFile(this.pIR + paramString);
    if (paramMap == null)
    {
      ab.i("Msg.Plugin.HttpRequestCache", "readFromFile fail, cipherText is null, read error or cache not exist");
      AppMethodBeat.o(67934);
      return null;
    }
    paramString = decrypt(paramMap, Xo(paramString));
    if (paramString == null)
    {
      ab.e("Msg.Plugin.HttpRequestCache", "decrypt fail, plaintText is null");
      AppMethodBeat.o(67934);
      return null;
    }
    AppMethodBeat.o(67934);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.k
 * JD-Core Version:    0.7.0.1
 */