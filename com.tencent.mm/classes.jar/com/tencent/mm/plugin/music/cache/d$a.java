package com.tencent.mm.plugin.music.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.BitSet;

public final class d$a
{
  public static byte[] a(BitSet paramBitSet)
  {
    AppMethodBeat.i(137152);
    byte[] arrayOfByte = new byte[paramBitSet.size() / 8];
    int i = 0;
    if (i < paramBitSet.size())
    {
      int k = i / 8;
      int m = arrayOfByte[k];
      if (paramBitSet.get(i)) {}
      for (int j = 1;; j = 0)
      {
        arrayOfByte[k] = ((byte)(j << 7 - i % 8 | m));
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(137152);
    return arrayOfByte;
  }
  
  public static BitSet cl(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(137153);
    BitSet localBitSet = new BitSet(paramArrayOfByte.length * 8);
    int i = 0;
    int j = 0;
    while (i < paramArrayOfByte.length)
    {
      int k = 7;
      if (k >= 0)
      {
        if ((paramArrayOfByte[i] & 1 << k) >> k == 1) {}
        for (boolean bool = true;; bool = false)
        {
          localBitSet.set(j, bool);
          k -= 1;
          j += 1;
          break;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(137153);
    return localBitSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.music.cache.d.a
 * JD-Core Version:    0.7.0.1
 */