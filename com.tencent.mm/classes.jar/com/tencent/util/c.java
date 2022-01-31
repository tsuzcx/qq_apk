package com.tencent.util;

import android.annotation.SuppressLint;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

@SuppressLint({"NewApi"})
public final class c
{
  public static final byte[] ENCRYPE_HEAD = { 69, 78, 67, 82 };
  
  private static void d(OutputStream paramOutputStream, int paramInt)
  {
    paramOutputStream.write(new byte[] { (byte)(paramInt >> 24 & 0xFF), (byte)(paramInt >> 16 & 0xFF), (byte)(paramInt >> 8 & 0xFF), (byte)(paramInt & 0xFF) });
  }
  
  public static byte[] decryptFile(InputStream paramInputStream)
  {
    for (;;)
    {
      int i;
      int k;
      try
      {
        Object localObject1 = new byte[4];
        paramInputStream.read((byte[])localObject1);
        Object localObject2;
        if ((localObject1[0] == ENCRYPE_HEAD[0]) && (localObject1[1] == ENCRYPE_HEAD[1]) && (localObject1[2] == ENCRYPE_HEAD[2]) && (localObject1[3] == ENCRYPE_HEAD[3]))
        {
          localObject1 = new ByteArrayOutputStream(readInt(paramInputStream));
          int j = readInt(paramInputStream);
          localObject2 = new byte[j];
          i = paramInputStream.read((byte[])localObject2, 0, j);
          if (i < j)
          {
            k = paramInputStream.read((byte[])localObject2, i, j - i);
            if (-1 == k) {
              throw new RuntimeException("decryptFile: inputStream end before all data read");
            }
          }
          else
          {
            Integer.toString(i);
            Object localObject3 = new DESedeKeySpec(Coffee.cRi().getBytes());
            localObject3 = SecretKeyFactory.getInstance("desede").generateSecret((KeySpec)localObject3);
            Cipher localCipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
            localCipher.init(2, (Key)localObject3, new IvParameterSpec("68881999".getBytes()));
            localObject2 = localCipher.doFinal((byte[])localObject2);
            ((ByteArrayOutputStream)localObject1).write((byte[])localObject2, 0, localObject2.length);
            e.copy(paramInputStream, (OutputStream)localObject1);
            return ((ByteArrayOutputStream)localObject1).toByteArray();
          }
        }
        else
        {
          localObject2 = new ByteArrayOutputStream();
          ((ByteArrayOutputStream)localObject2).write((byte[])localObject1);
          e.copy(paramInputStream, (OutputStream)localObject2);
          paramInputStream = ((ByteArrayOutputStream)localObject2).toByteArray();
          return paramInputStream;
        }
      }
      catch (Exception paramInputStream)
      {
        return null;
      }
      i += k;
    }
  }
  
  /* Error */
  public static void gP(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 129	java/io/FileInputStream
    //   3: dup
    //   4: new 131	java/io/File
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 132	java/io/File:<init>	(Ljava/lang/String;)V
    //   12: invokespecial 135	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   15: astore_2
    //   16: aload_2
    //   17: invokestatic 137	com/tencent/util/e:toByteArray	(Ljava/io/InputStream;)[B
    //   20: astore_0
    //   21: aload_2
    //   22: invokevirtual 140	java/io/FileInputStream:close	()V
    //   25: new 142	java/io/DataOutputStream
    //   28: dup
    //   29: new 144	java/io/FileOutputStream
    //   32: dup
    //   33: new 131	java/io/File
    //   36: dup
    //   37: aload_1
    //   38: invokespecial 132	java/io/File:<init>	(Ljava/lang/String;)V
    //   41: invokespecial 145	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   44: invokespecial 148	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   47: astore_1
    //   48: aload_1
    //   49: getstatic 17	com/tencent/util/c:ENCRYPE_HEAD	[B
    //   52: invokevirtual 149	java/io/DataOutputStream:write	([B)V
    //   55: aload_0
    //   56: arraylength
    //   57: sipush 1024
    //   60: if_icmple +51 -> 111
    //   63: aload_1
    //   64: aload_0
    //   65: arraylength
    //   66: invokestatic 151	com/tencent/util/c:d	(Ljava/io/OutputStream;I)V
    //   69: aload_0
    //   70: iconst_0
    //   71: sipush 1024
    //   74: invokestatic 157	java/util/Arrays:copyOfRange	([BII)[B
    //   77: invokestatic 162	com/tencent/util/b:encode	([B)[B
    //   80: astore_2
    //   81: aload_1
    //   82: aload_2
    //   83: arraylength
    //   84: invokestatic 151	com/tencent/util/c:d	(Ljava/io/OutputStream;I)V
    //   87: aload_1
    //   88: aload_2
    //   89: invokevirtual 149	java/io/DataOutputStream:write	([B)V
    //   92: aload_1
    //   93: aload_0
    //   94: sipush 1024
    //   97: aload_0
    //   98: arraylength
    //   99: sipush 1024
    //   102: isub
    //   103: invokevirtual 163	java/io/DataOutputStream:write	([BII)V
    //   106: aload_1
    //   107: invokevirtual 164	java/io/DataOutputStream:close	()V
    //   110: return
    //   111: aload_1
    //   112: aload_0
    //   113: arraylength
    //   114: invokestatic 151	com/tencent/util/c:d	(Ljava/io/OutputStream;I)V
    //   117: aload_0
    //   118: invokestatic 162	com/tencent/util/b:encode	([B)[B
    //   121: astore_0
    //   122: aload_1
    //   123: aload_0
    //   124: arraylength
    //   125: invokestatic 151	com/tencent/util/c:d	(Ljava/io/OutputStream;I)V
    //   128: aload_1
    //   129: aload_0
    //   130: invokevirtual 149	java/io/DataOutputStream:write	([B)V
    //   133: goto -27 -> 106
    //   136: astore_0
    //   137: return
    //   138: astore_0
    //   139: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	paramString1	String
    //   0	140	1	paramString2	String
    //   15	74	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   25	106	136	java/lang/Exception
    //   106	110	136	java/lang/Exception
    //   111	133	136	java/lang/Exception
    //   0	25	138	java/lang/Exception
  }
  
  private static int readInt(InputStream paramInputStream)
  {
    int i = paramInputStream.read();
    int j = paramInputStream.read();
    int k = paramInputStream.read();
    int m = paramInputStream.read();
    if ((i | j | k | m) < 0) {
      throw new EOFException();
    }
    return (i << 24) + (j << 16) + (k << 8) + (m << 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.util.c
 * JD-Core Version:    0.7.0.1
 */