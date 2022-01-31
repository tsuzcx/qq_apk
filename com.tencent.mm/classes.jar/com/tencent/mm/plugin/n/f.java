package com.tencent.mm.plugin.n;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.a.g;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.List;

public final class f
{
  List<g> gmy;
  List<Pair> gmz;
  g oEA;
  int oEB;
  int oEC;
  RandomAccessFile oEz;
  
  public final int F(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(117870);
    if (this.oEB >= this.oEC)
    {
      AppMethodBeat.o(117870);
      return -1;
    }
    for (;;)
    {
      byte[] arrayOfByte;
      int i;
      int j;
      try
      {
        this.oEz.seek(this.oEA.start);
        arrayOfByte = new byte[this.oEA.size];
        i = this.oEz.read(arrayOfByte);
      }
      catch (Exception paramByteBuffer)
      {
        i = -1;
      }
      try
      {
        j = this.oEA.size;
        if (i < j)
        {
          AppMethodBeat.o(117870);
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
      AppMethodBeat.o(117870);
      return i;
      label130:
      ab.printErrStackTrace("MicroMsg.Mp4Extractor", paramByteBuffer, "read sample data error", new Object[0]);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.n.f
 * JD-Core Version:    0.7.0.1
 */