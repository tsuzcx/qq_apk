package com.tencent.recovery.wx.util;

import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public class EncryptUtil
{
  public static final String CIPHER_ALGORITHM = "RSA/ECB/PKCS1Padding";
  public static final int DECRYPTION = 1;
  public static final int ENCRYPTION = 0;
  public static final String KEY_ALGORITHM = "RSA";
  public static final String KEY_E = "010001";
  public static final String KEY_N = "DFE56EEE6506E5F9796B4F12C3A48121B84E548E9999D834E2C037E3CD276E9C4A2B1758C582A67F6D12895CE5525DDE51D0B92D32B8BE7B2C85827729C3571DCC14B581877BC634BCC7F9DA3825C97A25B341A64295098303C4B584EC579ECCA7C8B96782F65D650039EE7A0772C195DBEFC4488BDFB0B9A58C5C058E3AB04D";
  public static final int LATEST_RBCRYPT_PACK_VERSION = 1001;
  private static final int MAX_DECRYPT_BLOCK = 128;
  public static final int RBCPR_ERR_DECRYPT_WITH_DES_KEY = 12;
  public static final int RBCPR_ERR_DECRYPT_WITH_RSA_PRIVKEY = 10;
  public static final int RBCPR_ERR_ENCRYPT_WITH_DES_KEY = 11;
  public static final int RBCPR_ERR_ENCRYPT_WITH_RSA_PUBKEY = 8;
  public static final int RBCPR_ERR_GENERAL = 1;
  public static final int RBCPR_ERR_INVALID_ARG = 2;
  public static final int RBCPR_ERR_INVALID_RSA_KEY_E = 7;
  public static final int RBCPR_ERR_INVALID_RSA_KEY_N = 6;
  public static final int RBCPR_ERR_LOAD_RSA_PRIVATE_KEY = 9;
  public static final int RBCPR_ERR_NO_MEMORY = 14;
  public static final int RBCPR_ERR_NO_REFERENCE_INFO = 13;
  public static final int RBCPR_ERR_NO_SEQ = 15;
  public static final int RBCPR_ERR_PACK_CORRUPTED = 3;
  public static final int RBCPR_ERR_UNSUPPORTED_ALGORITHM = 5;
  public static final int RBCPR_ERR_UNSUPPORTED_VERSION = 4;
  public static final int RBCPR_OK = 0;
  public static final int RBCPTS_CryptedBuf = 302;
  public static final int RBCPTS_ReferenceInfo = 303;
  public static final int RBCPTS_Seq = 304;
  public static final int RBCPTS_Version = 301;
  public static final int RBCRYPT_PACK_VERSION_1 = 1001;
  public static final int RSA_PKCS_V15 = 0;
  public static final int RSA_PKCS_V21 = 1;
  public static final int RSA_PRIVATE = 1;
  public static final int RSA_PUBLIC = 0;
  private static final String TAG = "Recovery.EncryptUtil";
  
  public static int DESEncrypt(PByteArray paramPByteArray, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramPByteArray == null) || (paramArrayOfByte1 == null) || (paramArrayOfByte2 == null)) {
      return 2;
    }
    if ((paramArrayOfByte1.length < 0) || (paramArrayOfByte2.length <= 0)) {
      return 2;
    }
    int j = 8 - paramArrayOfByte1.length % 8;
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length + j];
    int i = 0;
    while (i < paramArrayOfByte1.length)
    {
      arrayOfByte[i] = paramArrayOfByte1[i];
      i += 1;
    }
    i = 0;
    while (i < j)
    {
      arrayOfByte[(paramArrayOfByte1.length + i)] = ((byte)j);
      i += 1;
    }
    paramPByteArray.value = new byte[paramArrayOfByte1.length + j + 32];
    if (MyDES.Using_DES(paramPByteArray.value, arrayOfByte, arrayOfByte.length, paramArrayOfByte2.length, paramArrayOfByte2, 0) == 0) {
      return 11;
    }
    paramArrayOfByte1 = new byte[paramArrayOfByte1.length + j + 8];
    i = 0;
    while (i < paramArrayOfByte1.length)
    {
      paramArrayOfByte1[i] = paramPByteArray.value[i];
      i += 1;
    }
    paramPByteArray.value = paramArrayOfByte1;
    return 0;
  }
  
  /* Error */
  public static byte[] compress(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 101	java/util/zip/Deflater
    //   3: dup
    //   4: invokespecial 102	java/util/zip/Deflater:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: invokevirtual 105	java/util/zip/Deflater:reset	()V
    //   14: aload 4
    //   16: aload_0
    //   17: invokevirtual 109	java/util/zip/Deflater:setInput	([B)V
    //   20: aload 4
    //   22: invokevirtual 112	java/util/zip/Deflater:finish	()V
    //   25: new 114	java/io/ByteArrayOutputStream
    //   28: dup
    //   29: aload_0
    //   30: arraylength
    //   31: invokespecial 117	java/io/ByteArrayOutputStream:<init>	(I)V
    //   34: astore_2
    //   35: aload_2
    //   36: astore_1
    //   37: sipush 1024
    //   40: newarray byte
    //   42: astore_3
    //   43: aload_2
    //   44: astore_1
    //   45: aload 4
    //   47: invokevirtual 121	java/util/zip/Deflater:finished	()Z
    //   50: ifne +54 -> 104
    //   53: aload_2
    //   54: astore_1
    //   55: aload_2
    //   56: aload_3
    //   57: iconst_0
    //   58: aload 4
    //   60: aload_3
    //   61: invokevirtual 125	java/util/zip/Deflater:deflate	([B)I
    //   64: invokevirtual 129	java/io/ByteArrayOutputStream:write	([BII)V
    //   67: goto -24 -> 43
    //   70: astore_3
    //   71: aload_2
    //   72: astore_1
    //   73: ldc 72
    //   75: aload_3
    //   76: ldc 131
    //   78: iconst_0
    //   79: anewarray 4	java/lang/Object
    //   82: invokestatic 137	com/tencent/recovery/log/RecoveryLog:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   85: aload_0
    //   86: astore_1
    //   87: aload_2
    //   88: ifnull +9 -> 97
    //   91: aload_2
    //   92: invokevirtual 140	java/io/ByteArrayOutputStream:close	()V
    //   95: aload_0
    //   96: astore_1
    //   97: aload 4
    //   99: invokevirtual 143	java/util/zip/Deflater:end	()V
    //   102: aload_1
    //   103: areturn
    //   104: aload_2
    //   105: astore_1
    //   106: aload_2
    //   107: invokevirtual 147	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   110: astore_3
    //   111: aload_3
    //   112: astore_1
    //   113: aload_2
    //   114: invokevirtual 140	java/io/ByteArrayOutputStream:close	()V
    //   117: goto -20 -> 97
    //   120: astore_0
    //   121: ldc 72
    //   123: aload_0
    //   124: ldc 131
    //   126: iconst_0
    //   127: anewarray 4	java/lang/Object
    //   130: invokestatic 137	com/tencent/recovery/log/RecoveryLog:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   133: goto -36 -> 97
    //   136: astore_1
    //   137: ldc 72
    //   139: aload_1
    //   140: ldc 131
    //   142: iconst_0
    //   143: anewarray 4	java/lang/Object
    //   146: invokestatic 137	com/tencent/recovery/log/RecoveryLog:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   149: aload_0
    //   150: astore_1
    //   151: goto -54 -> 97
    //   154: astore_1
    //   155: aconst_null
    //   156: astore_1
    //   157: new 97	java/lang/OutOfMemoryError
    //   160: dup
    //   161: new 149	java/lang/StringBuilder
    //   164: dup
    //   165: ldc 151
    //   167: invokespecial 154	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   170: aload_0
    //   171: arraylength
    //   172: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   175: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokespecial 163	java/lang/OutOfMemoryError:<init>	(Ljava/lang/String;)V
    //   181: athrow
    //   182: astore_0
    //   183: aload_1
    //   184: ifnull +7 -> 191
    //   187: aload_1
    //   188: invokevirtual 140	java/io/ByteArrayOutputStream:close	()V
    //   191: aload_0
    //   192: athrow
    //   193: astore_1
    //   194: ldc 72
    //   196: aload_1
    //   197: ldc 131
    //   199: iconst_0
    //   200: anewarray 4	java/lang/Object
    //   203: invokestatic 137	com/tencent/recovery/log/RecoveryLog:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   206: goto -15 -> 191
    //   209: astore_0
    //   210: aconst_null
    //   211: astore_1
    //   212: goto -29 -> 183
    //   215: astore_1
    //   216: aload_2
    //   217: astore_1
    //   218: goto -61 -> 157
    //   221: astore_3
    //   222: aconst_null
    //   223: astore_2
    //   224: goto -153 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	227	0	paramArrayOfByte	byte[]
    //   36	77	1	localObject1	Object
    //   136	4	1	localIOException1	java.io.IOException
    //   150	1	1	arrayOfByte1	byte[]
    //   154	1	1	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   156	32	1	localObject2	Object
    //   193	4	1	localIOException2	java.io.IOException
    //   211	1	1	localObject3	Object
    //   215	1	1	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   217	1	1	localByteArrayOutputStream1	ByteArrayOutputStream
    //   34	190	2	localByteArrayOutputStream2	ByteArrayOutputStream
    //   42	19	3	arrayOfByte2	byte[]
    //   70	6	3	localException1	Exception
    //   110	2	3	arrayOfByte3	byte[]
    //   221	1	3	localException2	Exception
    //   7	91	4	localDeflater	java.util.zip.Deflater
    // Exception table:
    //   from	to	target	type
    //   37	43	70	java/lang/Exception
    //   45	53	70	java/lang/Exception
    //   55	67	70	java/lang/Exception
    //   106	111	70	java/lang/Exception
    //   113	117	120	java/io/IOException
    //   91	95	136	java/io/IOException
    //   25	35	154	java/lang/OutOfMemoryError
    //   37	43	182	finally
    //   45	53	182	finally
    //   55	67	182	finally
    //   73	85	182	finally
    //   106	111	182	finally
    //   157	182	182	finally
    //   187	191	193	java/io/IOException
    //   25	35	209	finally
    //   37	43	215	java/lang/OutOfMemoryError
    //   45	53	215	java/lang/OutOfMemoryError
    //   55	67	215	java/lang/OutOfMemoryError
    //   106	111	215	java/lang/OutOfMemoryError
    //   25	35	221	java/lang/Exception
  }
  
  public static byte[] decryptByPublicKey(byte[] paramArrayOfByte, String paramString)
  {
    paramString = new X509EncodedKeySpec(Base64.decode(paramString, 0));
    paramString = KeyFactory.getInstance("RSA").generatePublic(paramString);
    Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
    localCipher.init(2, paramString);
    int k = paramArrayOfByte.length;
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    int i = 0;
    int j = 0;
    if (k - j > 0)
    {
      if (k - j > 128) {}
      for (paramString = localCipher.doFinal(paramArrayOfByte, j, 128);; paramString = localCipher.doFinal(paramArrayOfByte, j, k - j))
      {
        localByteArrayOutputStream.write(paramString, 0, paramString.length);
        i += 1;
        j = i * 128;
        break;
      }
    }
    paramArrayOfByte = localByteArrayOutputStream.toByteArray();
    localByteArrayOutputStream.close();
    return paramArrayOfByte;
  }
  
  public static final String getMessageDigest(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar = new char[16];
    char[] tmp8_6 = arrayOfChar;
    tmp8_6[0] = 48;
    char[] tmp13_8 = tmp8_6;
    tmp13_8[1] = 49;
    char[] tmp18_13 = tmp13_8;
    tmp18_13[2] = 50;
    char[] tmp23_18 = tmp18_13;
    tmp23_18[3] = 51;
    char[] tmp28_23 = tmp23_18;
    tmp28_23[4] = 52;
    char[] tmp33_28 = tmp28_23;
    tmp33_28[5] = 53;
    char[] tmp38_33 = tmp33_28;
    tmp38_33[6] = 54;
    char[] tmp44_38 = tmp38_33;
    tmp44_38[7] = 55;
    char[] tmp50_44 = tmp44_38;
    tmp50_44[8] = 56;
    char[] tmp56_50 = tmp50_44;
    tmp56_50[9] = 57;
    char[] tmp62_56 = tmp56_50;
    tmp62_56[10] = 97;
    char[] tmp68_62 = tmp62_56;
    tmp68_62[11] = 98;
    char[] tmp74_68 = tmp68_62;
    tmp74_68[12] = 99;
    char[] tmp80_74 = tmp74_68;
    tmp80_74[13] = 100;
    char[] tmp86_80 = tmp80_74;
    tmp86_80[14] = 101;
    char[] tmp92_86 = tmp86_80;
    tmp92_86[15] = 102;
    tmp92_86;
    for (;;)
    {
      Object localObject;
      int k;
      int i;
      int j;
      try
      {
        localObject = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject).update(paramArrayOfByte);
        paramArrayOfByte = ((MessageDigest)localObject).digest();
        k = paramArrayOfByte.length;
        localObject = new char[k * 2];
        i = 0;
        j = 0;
      }
      catch (Exception paramArrayOfByte)
      {
        return null;
      }
      paramArrayOfByte = new String((char[])localObject);
      return paramArrayOfByte;
      while (i < k)
      {
        int n = paramArrayOfByte[i];
        int m = j + 1;
        localObject[j] = arrayOfChar[(n >>> 4 & 0xF)];
        localObject[m] = arrayOfChar[(n & 0xF)];
        i += 1;
        j = m + 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.recovery.wx.util.EncryptUtil
 * JD-Core Version:    0.7.0.1
 */