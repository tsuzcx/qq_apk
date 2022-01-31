package com.tencent.util;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
public final class e
{
  public static final byte[] Bzc = { 69, 78, 67, 82 };
  
  public static byte[] L(InputStream paramInputStream)
  {
    AppMethodBeat.i(86580);
    try
    {
      localObject1 = new byte[4];
      paramInputStream.read((byte[])localObject1);
      if ((localObject1[0] == Bzc[0]) && (localObject1[1] == Bzc[1]) && (localObject1[2] == Bzc[2]) && (localObject1[3] == Bzc[3]))
      {
        localObject1 = new ByteArrayOutputStream(M(paramInputStream));
        int j = M(paramInputStream);
        localObject2 = new byte[j];
        i = paramInputStream.read((byte[])localObject2, 0, j);
        if (i < j)
        {
          k = paramInputStream.read((byte[])localObject2, i, j - i);
          if (-1 == k)
          {
            paramInputStream = new RuntimeException("decryptFile: inputStream end before all data read");
            AppMethodBeat.o(86580);
            throw paramInputStream;
          }
        }
      }
    }
    catch (Exception paramInputStream)
    {
      Object localObject1;
      int i;
      for (;;)
      {
        int k;
        AppMethodBeat.o(86580);
        return null;
        i += k;
      }
      Integer.toString(i);
      Object localObject3 = new DESedeKeySpec(Coffee.dWY().getBytes());
      localObject3 = SecretKeyFactory.getInstance("desede").generateSecret((KeySpec)localObject3);
      Cipher localCipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
      localCipher.init(2, (Key)localObject3, new IvParameterSpec("68881999".getBytes()));
      Object localObject2 = localCipher.doFinal((byte[])localObject2);
      ((ByteArrayOutputStream)localObject1).write((byte[])localObject2, 0, localObject2.length);
      g.copy(paramInputStream, (OutputStream)localObject1);
      paramInputStream = ((ByteArrayOutputStream)localObject1).toByteArray();
      AppMethodBeat.o(86580);
      return paramInputStream;
      localObject2 = new ByteArrayOutputStream();
      ((ByteArrayOutputStream)localObject2).write((byte[])localObject1);
      g.copy(paramInputStream, (OutputStream)localObject2);
      paramInputStream = ((ByteArrayOutputStream)localObject2).toByteArray();
      AppMethodBeat.o(86580);
      return paramInputStream;
    }
    catch (OutOfMemoryError paramInputStream)
    {
      label136:
      break label136;
    }
  }
  
  private static int M(InputStream paramInputStream)
  {
    AppMethodBeat.i(86581);
    int i = paramInputStream.read();
    int j = paramInputStream.read();
    int k = paramInputStream.read();
    int m = paramInputStream.read();
    if ((i | j | k | m) < 0)
    {
      paramInputStream = new EOFException();
      AppMethodBeat.o(86581);
      throw paramInputStream;
    }
    AppMethodBeat.o(86581);
    return (i << 24) + (j << 16) + (k << 8) + (m << 0);
  }
  
  private static void d(OutputStream paramOutputStream, int paramInt)
  {
    AppMethodBeat.i(86582);
    paramOutputStream.write(new byte[] { (byte)(paramInt >> 24 & 0xFF), (byte)(paramInt >> 16 & 0xFF), (byte)(paramInt >> 8 & 0xFF), (byte)(paramInt & 0xFF) });
    AppMethodBeat.o(86582);
  }
  
  /* Error */
  public static void iV(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 147
    //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 149	java/io/FileInputStream
    //   8: dup
    //   9: new 151	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 152	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: invokespecial 155	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   20: astore_2
    //   21: aload_2
    //   22: invokestatic 157	com/tencent/util/g:toByteArray	(Ljava/io/InputStream;)[B
    //   25: astore_0
    //   26: aload_2
    //   27: invokevirtual 160	java/io/FileInputStream:close	()V
    //   30: new 162	java/io/DataOutputStream
    //   33: dup
    //   34: new 164	java/io/FileOutputStream
    //   37: dup
    //   38: new 151	java/io/File
    //   41: dup
    //   42: aload_1
    //   43: invokespecial 152	java/io/File:<init>	(Ljava/lang/String;)V
    //   46: invokespecial 165	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   49: invokespecial 168	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   52: astore_1
    //   53: aload_1
    //   54: getstatic 17	com/tencent/util/e:Bzc	[B
    //   57: invokevirtual 169	java/io/DataOutputStream:write	([B)V
    //   60: aload_0
    //   61: arraylength
    //   62: sipush 1024
    //   65: if_icmple +56 -> 121
    //   68: aload_1
    //   69: aload_0
    //   70: arraylength
    //   71: invokestatic 171	com/tencent/util/e:d	(Ljava/io/OutputStream;I)V
    //   74: aload_0
    //   75: iconst_0
    //   76: sipush 1024
    //   79: invokestatic 177	java/util/Arrays:copyOfRange	([BII)[B
    //   82: invokestatic 182	com/tencent/util/c:encode	([B)[B
    //   85: astore_2
    //   86: aload_1
    //   87: aload_2
    //   88: arraylength
    //   89: invokestatic 171	com/tencent/util/e:d	(Ljava/io/OutputStream;I)V
    //   92: aload_1
    //   93: aload_2
    //   94: invokevirtual 169	java/io/DataOutputStream:write	([B)V
    //   97: aload_1
    //   98: aload_0
    //   99: sipush 1024
    //   102: aload_0
    //   103: arraylength
    //   104: sipush 1024
    //   107: isub
    //   108: invokevirtual 183	java/io/DataOutputStream:write	([BII)V
    //   111: aload_1
    //   112: invokevirtual 184	java/io/DataOutputStream:close	()V
    //   115: ldc 147
    //   117: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: return
    //   121: aload_1
    //   122: aload_0
    //   123: arraylength
    //   124: invokestatic 171	com/tencent/util/e:d	(Ljava/io/OutputStream;I)V
    //   127: aload_0
    //   128: invokestatic 182	com/tencent/util/c:encode	([B)[B
    //   131: astore_0
    //   132: aload_1
    //   133: aload_0
    //   134: arraylength
    //   135: invokestatic 171	com/tencent/util/e:d	(Ljava/io/OutputStream;I)V
    //   138: aload_1
    //   139: aload_0
    //   140: invokevirtual 169	java/io/DataOutputStream:write	([B)V
    //   143: goto -32 -> 111
    //   146: astore_0
    //   147: ldc 147
    //   149: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: return
    //   153: astore_0
    //   154: ldc 147
    //   156: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   159: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	paramString1	String
    //   0	160	1	paramString2	String
    //   20	74	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   30	111	146	java/lang/Exception
    //   111	115	146	java/lang/Exception
    //   121	143	146	java/lang/Exception
    //   5	30	153	java/lang/Exception
    //   115	120	153	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.util.e
 * JD-Core Version:    0.7.0.1
 */