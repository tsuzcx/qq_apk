package com.tencent.mm.plugin.s;

import android.util.Pair;
import com.tencent.mm.plugin.a.g;
import com.tencent.mm.sdk.platformtools.y;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.List;

public final class f
{
  List<g> eUA;
  List<Pair> eUB;
  RandomAccessFile meb;
  g mec;
  int med;
  int mee;
  
  public final int C(ByteBuffer paramByteBuffer)
  {
    if (this.med >= this.mee) {
      return -1;
    }
    for (;;)
    {
      byte[] arrayOfByte;
      int i;
      try
      {
        this.meb.seek(this.mec.start);
        arrayOfByte = new byte[this.mec.size];
        i = this.meb.read(arrayOfByte);
      }
      catch (Exception paramByteBuffer)
      {
        i = -1;
        continue;
        arrayOfByte[0] = 0;
        arrayOfByte[1] = 0;
        arrayOfByte[2] = 0;
        arrayOfByte[3] = 1;
        j = 0;
      }
      try
      {
        if (i >= this.mec.size) {
          continue;
        }
        return -1;
      }
      catch (Exception paramByteBuffer)
      {
        y.printErrStackTrace("MicroMsg.Mp4Extractor", paramByteBuffer, "read sample data error", new Object[0]);
        return i;
      }
      paramByteBuffer.clear();
      paramByteBuffer.put(arrayOfByte, 0, i).flip();
      return i;
      int j;
      while (j < i)
      {
        if ((arrayOfByte[j] == -128) && (j + 4 < i) && (arrayOfByte[(j + 1)] == 0) && (arrayOfByte[(j + 2)] == 0))
        {
          arrayOfByte[(j + 3)] = 0;
          arrayOfByte[(j + 4)] = 1;
        }
        j += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.s.f
 * JD-Core Version:    0.7.0.1
 */