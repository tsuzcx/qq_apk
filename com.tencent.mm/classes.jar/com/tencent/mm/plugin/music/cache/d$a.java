package com.tencent.mm.plugin.music.cache;

import java.util.BitSet;

public final class d$a
{
  public static BitSet aE(byte[] paramArrayOfByte)
  {
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
    return localBitSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.music.cache.d.a
 * JD-Core Version:    0.7.0.1
 */