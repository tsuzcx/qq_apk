package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Stack;

public class v
{
  public static final long a(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    long l2;
    if ((paramInputStream == null) || (paramOutputStream == null)) {
      l2 = -1L;
    }
    for (;;)
    {
      return l2;
      try
      {
        byte[] arrayOfByte = new byte[4096];
        int i;
        for (long l1 = 0L;; l1 += i)
        {
          i = paramInputStream.read(arrayOfByte);
          l2 = l1;
          if (i <= 0) {
            break;
          }
          paramOutputStream.write(arrayOfByte, 0, i);
        }
        return -1L;
      }
      catch (IOException paramInputStream) {}
    }
  }
  
  public static void a(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
      paramBitmap.recycle();
    }
  }
  
  public static final void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      paramString = new File(paramString);
      if ((paramString.exists()) && (paramString.isDirectory())) {
        return true;
      }
      if ((paramString.exists()) && (paramString.isFile())) {
        paramString.delete();
      }
      boolean bool = paramString.mkdirs();
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  /* Error */
  public static final byte[] a(InputStream paramInputStream)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 75	java/io/ByteArrayOutputStream
    //   9: dup
    //   10: invokespecial 77	java/io/ByteArrayOutputStream:<init>	()V
    //   13: astore_2
    //   14: sipush 4096
    //   17: newarray byte
    //   19: astore_3
    //   20: aload_0
    //   21: aload_3
    //   22: iconst_0
    //   23: sipush 4096
    //   26: invokevirtual 80	java/io/InputStream:read	([BII)I
    //   29: istore_1
    //   30: iload_1
    //   31: iconst_m1
    //   32: if_icmpeq +20 -> 52
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: iload_1
    //   39: invokevirtual 81	java/io/ByteArrayOutputStream:write	([BII)V
    //   42: goto -22 -> 20
    //   45: astore_0
    //   46: aload_2
    //   47: invokestatic 83	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/Closeable;)V
    //   50: aconst_null
    //   51: areturn
    //   52: aload_2
    //   53: invokevirtual 86	java/io/ByteArrayOutputStream:flush	()V
    //   56: aload_2
    //   57: invokevirtual 90	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   60: astore_0
    //   61: aload_2
    //   62: invokestatic 83	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/Closeable;)V
    //   65: aload_0
    //   66: areturn
    //   67: astore_0
    //   68: aconst_null
    //   69: astore_2
    //   70: aload_2
    //   71: invokestatic 83	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/Closeable;)V
    //   74: aload_0
    //   75: athrow
    //   76: astore_0
    //   77: goto -7 -> 70
    //   80: astore_0
    //   81: aconst_null
    //   82: astore_2
    //   83: goto -37 -> 46
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	paramInputStream	InputStream
    //   29	10	1	i	int
    //   13	70	2	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   19	18	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   14	20	45	java/lang/Throwable
    //   20	30	45	java/lang/Throwable
    //   35	42	45	java/lang/Throwable
    //   52	61	45	java/lang/Throwable
    //   6	14	67	finally
    //   14	20	76	finally
    //   20	30	76	finally
    //   35	42	76	finally
    //   52	61	76	finally
    //   6	14	80	java/lang/Throwable
  }
  
  public static final InputStream b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        paramString = new File(paramString);
        if ((paramString.exists()) && (paramString.isFile()) && (paramString.canRead()))
        {
          paramString = new FileInputStream(paramString);
          return paramString;
        }
      }
      catch (IOException paramString) {}
    }
    return null;
  }
  
  public static boolean c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
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
            label96:
            if (i < j)
            {
              localFile = paramString[i];
              if (!localFile.isDirectory()) {
                break label131;
              }
              localStack.push(localFile.getAbsolutePath());
            }
            for (;;)
            {
              i += 1;
              break label96;
              break;
              label131:
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
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.v
 * JD-Core Version:    0.7.0.1
 */