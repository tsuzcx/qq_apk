package com.tencent.tinker.b;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.zip.GZIPInputStream;

public final class a
{
  public static int a(InputStream paramInputStream1, InputStream paramInputStream2, File paramFile)
  {
    if (paramInputStream1 == null) {
      return 3;
    }
    if (paramFile == null) {
      return 4;
    }
    if (paramInputStream2 == null) {
      return 2;
    }
    paramInputStream1 = b.ad(paramInputStream1);
    Object localObject2 = b.ad(paramInputStream2);
    int m = paramInputStream1.length;
    int i = localObject2.length;
    paramInputStream2 = new DataInputStream(new ByteArrayInputStream((byte[])localObject2, 0, i));
    paramInputStream2.skip(8L);
    long l1 = paramInputStream2.readLong();
    long l2 = paramInputStream2.readLong();
    int n = (int)paramInputStream2.readLong();
    paramInputStream2.close();
    paramInputStream2 = new ByteArrayInputStream((byte[])localObject2, 0, i);
    paramInputStream2.skip(32L);
    paramInputStream2 = new DataInputStream(new GZIPInputStream(paramInputStream2));
    Object localObject1 = new ByteArrayInputStream((byte[])localObject2, 0, i);
    ((InputStream)localObject1).skip(32L + l1);
    localObject1 = new GZIPInputStream((InputStream)localObject1);
    localObject2 = new ByteArrayInputStream((byte[])localObject2, 0, i);
    ((InputStream)localObject2).skip(l2 + l1 + 32L);
    GZIPInputStream localGZIPInputStream = new GZIPInputStream((InputStream)localObject2);
    localObject2 = new byte[n];
    i = 0;
    int[] arrayOfInt = new int[3];
    int j = 0;
    while (j < n)
    {
      int k = 0;
      while (k <= 2)
      {
        arrayOfInt[k] = paramInputStream2.readInt();
        k += 1;
      }
      if (arrayOfInt[0] + j > n) {
        throw new IOException("Corrupt by wrong patch file.");
      }
      if (!b.a((InputStream)localObject1, (byte[])localObject2, j, arrayOfInt[0])) {
        throw new IOException("Corrupt by wrong patch file.");
      }
      k = 0;
      while (k < arrayOfInt[0])
      {
        if ((i + k >= 0) && (i + k < m))
        {
          i1 = j + k;
          localObject2[i1] = ((byte)(localObject2[i1] + paramInputStream1[(i + k)]));
        }
        k += 1;
      }
      j = arrayOfInt[0] + j;
      int i1 = arrayOfInt[0];
      if (arrayOfInt[1] + j > n) {
        throw new IOException("Corrupt by wrong patch file.");
      }
      if (!b.a(localGZIPInputStream, (byte[])localObject2, j, arrayOfInt[1])) {
        throw new IOException("Corrupt by wrong patch file.");
      }
      k = arrayOfInt[1];
      i = arrayOfInt[2] + (i1 + i);
      j += k;
    }
    paramInputStream2.close();
    ((InputStream)localObject1).close();
    localGZIPInputStream.close();
    paramInputStream1 = new FileOutputStream(paramFile);
    try
    {
      paramInputStream1.write((byte[])localObject2);
      return 1;
    }
    finally
    {
      paramInputStream1.close();
    }
  }
  
  private static int a(RandomAccessFile paramRandomAccessFile, int paramInt1, byte[] paramArrayOfByte, int paramInt2, File paramFile)
  {
    if ((paramRandomAccessFile == null) || (paramInt1 <= 0)) {
      return 3;
    }
    if (paramFile == null) {
      return 4;
    }
    if (paramInt2 <= 0) {
      return 2;
    }
    Object localObject1 = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte, 0, paramInt2));
    ((DataInputStream)localObject1).skip(8L);
    long l1 = ((DataInputStream)localObject1).readLong();
    long l2 = ((DataInputStream)localObject1).readLong();
    int k = (int)((DataInputStream)localObject1).readLong();
    ((DataInputStream)localObject1).close();
    localObject1 = new ByteArrayInputStream(paramArrayOfByte, 0, paramInt2);
    ((InputStream)localObject1).skip(32L);
    localObject1 = new DataInputStream(new GZIPInputStream((InputStream)localObject1));
    Object localObject2 = new ByteArrayInputStream(paramArrayOfByte, 0, paramInt2);
    ((InputStream)localObject2).skip(32L + l1);
    localObject2 = new GZIPInputStream((InputStream)localObject2);
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte, 0, paramInt2);
    paramArrayOfByte.skip(l1 + l2 + 32L);
    paramArrayOfByte = new GZIPInputStream(paramArrayOfByte);
    paramFile = new FileOutputStream(paramFile);
    paramInt2 = 0;
    int i;
    int j;
    for (;;)
    {
      try
      {
        arrayOfInt = new int[3];
        i = 0;
      }
      finally
      {
        int[] arrayOfInt;
        byte[] arrayOfByte1;
        byte[] arrayOfByte2;
        paramRandomAccessFile.close();
        paramFile.close();
      }
      if (j <= 2)
      {
        arrayOfInt[j] = ((DataInputStream)localObject1).readInt();
        j += 1;
      }
      else
      {
        if (arrayOfInt[0] + i > k)
        {
          paramFile.close();
          paramRandomAccessFile.close();
          paramFile.close();
          return 2;
        }
        arrayOfByte1 = new byte[arrayOfInt[0]];
        if (!b.a((InputStream)localObject2, arrayOfByte1, 0, arrayOfInt[0]))
        {
          paramFile.close();
          paramRandomAccessFile.close();
          paramFile.close();
          return 2;
        }
        arrayOfByte2 = new byte[arrayOfInt[0]];
        if (paramRandomAccessFile.read(arrayOfByte2, 0, arrayOfInt[0]) < arrayOfInt[0])
        {
          paramFile.close();
          paramRandomAccessFile.close();
          paramFile.close();
          return 2;
        }
        j = 0;
      }
    }
    for (;;)
    {
      if (j < arrayOfInt[0])
      {
        if ((paramInt2 + j >= 0) && (paramInt2 + j < paramInt1)) {
          arrayOfByte1[j] = ((byte)(arrayOfByte1[j] + arrayOfByte2[j]));
        }
      }
      else
      {
        paramFile.write(arrayOfByte1);
        i = arrayOfInt[0] + i;
        int m = arrayOfInt[0];
        if (arrayOfInt[1] + i > k)
        {
          paramFile.close();
          paramRandomAccessFile.close();
          paramFile.close();
          return 2;
        }
        arrayOfByte1 = new byte[arrayOfInt[1]];
        if (!b.a(paramArrayOfByte, arrayOfByte1, 0, arrayOfInt[1]))
        {
          paramFile.close();
          paramRandomAccessFile.close();
          paramFile.close();
          return 2;
        }
        paramFile.write(arrayOfByte1);
        paramFile.flush();
        j = arrayOfInt[1];
        paramInt2 = arrayOfInt[2] + (m + paramInt2);
        paramRandomAccessFile.seek(paramInt2);
        i += j;
        while (i >= k)
        {
          ((DataInputStream)localObject1).close();
          ((InputStream)localObject2).close();
          paramArrayOfByte.close();
          paramRandomAccessFile.close();
          paramFile.close();
          return 1;
        }
        j = 0;
        break;
      }
      j += 1;
    }
  }
  
  public static int a(RandomAccessFile paramRandomAccessFile, File paramFile1, File paramFile2)
  {
    if (paramRandomAccessFile.length() <= 0L) {
      return 3;
    }
    if (paramFile2.length() <= 0L) {
      return 2;
    }
    byte[] arrayOfByte = new byte[(int)paramFile2.length()];
    paramFile2 = new FileInputStream(paramFile2);
    try
    {
      b.a(paramFile2, arrayOfByte, 0, arrayOfByte.length);
      return a(paramRandomAccessFile, (int)paramRandomAccessFile.length(), arrayOfByte, arrayOfByte.length, paramFile1);
    }
    finally
    {
      paramFile2.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.b.a
 * JD-Core Version:    0.7.0.1
 */