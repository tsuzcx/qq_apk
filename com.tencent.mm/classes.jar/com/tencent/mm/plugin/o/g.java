package com.tencent.mm.plugin.o;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.a.n;
import com.tencent.mm.sdk.platformtools.ac;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.List;

public final class g
{
  List<n> ixB;
  List<Pair> ixC;
  private RandomAccessFile uIc;
  n uId;
  int uIe;
  int uIf;
  
  public final int j(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(133909);
    if (this.uIe >= this.uIf)
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
        this.uIc.seek(this.uId.start);
        arrayOfByte = new byte[this.uId.size];
        i = this.uIc.read(arrayOfByte);
      }
      catch (Exception paramByteBuffer)
      {
        i = -1;
      }
      try
      {
        j = this.uId.size;
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
      ac.printErrStackTrace("MicroMsg.Mp4Extractor", paramByteBuffer, "read sample data error", new Object[0]);
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
    if (this.uIc != null) {}
    try
    {
      this.uIc.close();
      label19:
      this.ixB.clear();
      this.ixB = null;
      this.ixC.clear();
      this.ixC = null;
      this.uId = null;
      AppMethodBeat.o(133908);
      return;
    }
    catch (IOException localIOException)
    {
      break label19;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.o.g
 * JD-Core Version:    0.7.0.1
 */