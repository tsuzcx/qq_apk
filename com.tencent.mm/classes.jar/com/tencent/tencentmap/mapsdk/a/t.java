package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Stack;

public class t
{
  public static final long a(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(147076);
    if ((paramInputStream == null) || (paramOutputStream == null))
    {
      AppMethodBeat.o(147076);
      return -1L;
    }
    try
    {
      byte[] arrayOfByte = new byte[4096];
      int i;
      for (long l = 0L;; l += i)
      {
        i = paramInputStream.read(arrayOfByte);
        if (i <= 0) {
          break;
        }
        paramOutputStream.write(arrayOfByte, 0, i);
      }
      AppMethodBeat.o(147076);
      return l;
    }
    catch (IOException paramInputStream)
    {
      AppMethodBeat.o(147076);
    }
    return -1L;
  }
  
  public static void a(Bitmap paramBitmap)
  {
    AppMethodBeat.i(147080);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
      paramBitmap.recycle();
    }
    AppMethodBeat.o(147080);
  }
  
  public static final void a(Closeable paramCloseable)
  {
    AppMethodBeat.i(147074);
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        AppMethodBeat.o(147074);
        return;
      }
      catch (IOException paramCloseable) {}
    }
    AppMethodBeat.o(147074);
  }
  
  public static boolean a(String paramString)
  {
    AppMethodBeat.i(147077);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(147077);
      return false;
    }
    try
    {
      paramString = new File(paramString);
      if (paramString.exists())
      {
        bool = paramString.isDirectory();
        if (bool)
        {
          AppMethodBeat.o(147077);
          return true;
        }
      }
      if ((paramString.exists()) && (paramString.isFile())) {
        paramString.delete();
      }
      boolean bool = paramString.mkdirs();
      AppMethodBeat.o(147077);
      return bool;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(147077);
    }
    return false;
  }
  
  /* Error */
  public static final byte[] a(InputStream paramInputStream)
  {
    // Byte code:
    //   0: ldc 87
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnonnull +10 -> 16
    //   9: ldc 87
    //   11: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   14: aconst_null
    //   15: areturn
    //   16: new 89	java/io/ByteArrayOutputStream
    //   19: dup
    //   20: invokespecial 91	java/io/ByteArrayOutputStream:<init>	()V
    //   23: astore_2
    //   24: sipush 4096
    //   27: newarray byte
    //   29: astore_3
    //   30: aload_0
    //   31: aload_3
    //   32: iconst_0
    //   33: sipush 4096
    //   36: invokevirtual 94	java/io/InputStream:read	([BII)I
    //   39: istore_1
    //   40: iload_1
    //   41: iconst_m1
    //   42: if_icmpeq +25 -> 67
    //   45: aload_2
    //   46: aload_3
    //   47: iconst_0
    //   48: iload_1
    //   49: invokevirtual 95	java/io/ByteArrayOutputStream:write	([BII)V
    //   52: goto -22 -> 30
    //   55: astore_0
    //   56: aload_2
    //   57: invokestatic 97	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   60: ldc 87
    //   62: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: aconst_null
    //   66: areturn
    //   67: aload_2
    //   68: invokevirtual 100	java/io/ByteArrayOutputStream:flush	()V
    //   71: aload_2
    //   72: invokevirtual 104	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   75: astore_0
    //   76: aload_2
    //   77: invokestatic 97	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   80: ldc 87
    //   82: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: aload_0
    //   86: areturn
    //   87: astore_0
    //   88: aconst_null
    //   89: astore_2
    //   90: aload_2
    //   91: invokestatic 97	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   94: ldc 87
    //   96: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: aload_0
    //   100: athrow
    //   101: astore_0
    //   102: goto -12 -> 90
    //   105: astore_0
    //   106: aconst_null
    //   107: astore_2
    //   108: goto -52 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	paramInputStream	InputStream
    //   39	10	1	i	int
    //   23	85	2	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   29	18	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   24	30	55	java/lang/Throwable
    //   30	40	55	java/lang/Throwable
    //   45	52	55	java/lang/Throwable
    //   67	76	55	java/lang/Throwable
    //   16	24	87	finally
    //   24	30	101	finally
    //   30	40	101	finally
    //   45	52	101	finally
    //   67	76	101	finally
    //   16	24	105	java/lang/Throwable
  }
  
  public static final InputStream b(String paramString)
  {
    AppMethodBeat.i(147078);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(147078);
      return null;
    }
    try
    {
      paramString = new File(paramString);
      if ((paramString.exists()) && (paramString.isFile()) && (paramString.canRead()))
      {
        paramString = new FileInputStream(paramString);
        AppMethodBeat.o(147078);
        return paramString;
      }
    }
    catch (IOException paramString)
    {
      AppMethodBeat.o(147078);
    }
    return null;
  }
  
  public static boolean c(String paramString)
  {
    AppMethodBeat.i(147079);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(147079);
      return false;
    }
    Stack localStack = new Stack();
    localStack.push(paramString);
    while (!localStack.isEmpty())
    {
      File localFile = new File((String)localStack.peek());
      if (localFile.exists())
      {
        if (localFile.isDirectory())
        {
          paramString = localFile.listFiles();
          if ((paramString == null) || (paramString.length == 0))
          {
            localFile.delete();
            localStack.pop();
          }
          else
          {
            int j = paramString.length;
            int i = 0;
            label106:
            if (i < j)
            {
              localFile = paramString[i];
              if (!localFile.isDirectory()) {
                break label141;
              }
              localStack.push(localFile.getAbsolutePath());
            }
            for (;;)
            {
              i += 1;
              break label106;
              break;
              label141:
              localFile.delete();
            }
          }
        }
        else
        {
          localFile.delete();
          localStack.pop();
        }
      }
      else {
        localStack.pop();
      }
    }
    AppMethodBeat.o(147079);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.t
 * JD-Core Version:    0.7.0.1
 */