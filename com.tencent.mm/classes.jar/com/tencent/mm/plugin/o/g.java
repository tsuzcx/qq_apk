package com.tencent.mm.plugin.o;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.a.m;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.List;

public final class g
{
  List<m> hXx;
  List<Pair> hXy;
  private RandomAccessFile tzF;
  m tzG;
  int tzH;
  int tzI;
  
  public final int j(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(133909);
    if (this.tzH >= this.tzI)
    {
      AppMethodBeat.o(133909);
      return -1;
    }
    for (;;)
    {
      byte[] arrayOfByte;
      int i;
      int j;
      try
      {
        this.tzF.seek(this.tzG.start);
        arrayOfByte = new byte[this.tzG.size];
        i = this.tzF.read(arrayOfByte);
      }
      catch (Exception paramByteBuffer)
      {
        i = -1;
      }
      try
      {
        j = this.tzG.size;
        if (i < j)
        {
          AppMethodBeat.o(133909);
          return -1;
        }
        arrayOfByte[0] = 0;
        arrayOfByte[1] = 0;
        arrayOfByte[2] = 0;
        arrayOfByte[3] = 1;
        j = 0;
      }
      catch (Exception paramByteBuffer)
      {
        break label130;
      }
      paramByteBuffer.clear();
      paramByteBuffer.put(arrayOfByte, 0, i).flip();
      AppMethodBeat.o(133909);
      return i;
      label130:
      ad.printErrStackTrace("MicroMsg.Mp4Extractor", paramByteBuffer, "read sample data error", new Object[0]);
      continue;
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
  
  public final void release()
  {
    AppMethodBeat.i(133908);
    if (this.tzF != null) {}
    try
    {
      this.tzF.close();
      label19:
      this.hXx.clear();
      this.hXx = null;
      this.hXy.clear();
      this.hXy = null;
      this.tzG = null;
      AppMethodBeat.o(133908);
      return;
    }
    catch (IOException localIOException)
    {
      break label19;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.o.g
 * JD-Core Version:    0.7.0.1
 */