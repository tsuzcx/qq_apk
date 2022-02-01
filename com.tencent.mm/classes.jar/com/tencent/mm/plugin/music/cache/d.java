package com.tencent.mm.plugin.music.cache;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.BitSet;

public final class d
{
  public int count;
  public String dnX;
  public long ixc;
  public String mUrl;
  public BitSet vdZ;
  
  public d(String paramString)
  {
    AppMethodBeat.i(137154);
    this.vdZ = new BitSet();
    this.ixc = -1L;
    this.count = 0;
    this.dnX = "";
    this.mUrl = paramString;
    AppMethodBeat.o(137154);
  }
  
  private boolean dio()
  {
    AppMethodBeat.i(137163);
    ac.i("MicroMsg.Music.IndexBitMgr", "isCacheComplete, count:%d, cardinality:%d", new Object[] { Integer.valueOf(this.count), Integer.valueOf(this.vdZ.cardinality()) });
    if ((this.count > 0) && (this.count == this.vdZ.cardinality()))
    {
      AppMethodBeat.o(137163);
      return true;
    }
    AppMethodBeat.o(137163);
    return false;
  }
  
  public final void JA(int paramInt)
  {
    AppMethodBeat.i(137157);
    ac.i("MicroMsg.Music.IndexBitMgr", "setFileCacheComplete %d", new Object[] { Integer.valueOf(paramInt) });
    if (!TextUtils.isEmpty(this.dnX)) {
      e.ed(this.dnX, paramInt);
    }
    AppMethodBeat.o(137157);
  }
  
  public final boolean JB(int paramInt)
  {
    AppMethodBeat.i(137159);
    boolean bool = this.vdZ.get(paramInt);
    AppMethodBeat.o(137159);
    return bool;
  }
  
  public final void JC(int paramInt)
  {
    AppMethodBeat.i(137160);
    this.vdZ.set(paramInt);
    AppMethodBeat.o(137160);
  }
  
  public final void JD(int paramInt)
  {
    AppMethodBeat.i(137161);
    this.vdZ.set(paramInt, false);
    AppMethodBeat.o(137161);
  }
  
  public final void clearCache()
  {
    AppMethodBeat.i(137156);
    ac.i("MicroMsg.Music.IndexBitMgr", "clearCache");
    this.vdZ = new BitSet(this.count);
    JA(0);
    if (!TextUtils.isEmpty(this.dnX)) {
      e.s(this.dnX, null);
    }
    AppMethodBeat.o(137156);
  }
  
  public final void din()
  {
    AppMethodBeat.i(137155);
    if (!TextUtils.isEmpty(this.dnX))
    {
      byte[] arrayOfByte = a.a(this.vdZ);
      e.s(this.dnX, arrayOfByte);
    }
    ac.d("MicroMsg.Music.IndexBitMgr", "saveBitCache bitSet:%s", new Object[] { this.vdZ.toString() });
    ac.i("MicroMsg.Music.IndexBitMgr", "saveBitCache bitSet count %d, cardinality:" + this.count + "," + this.vdZ.cardinality());
    if (dio()) {
      JA(1);
    }
    AppMethodBeat.o(137155);
  }
  
  public final int getIndex(int paramInt)
  {
    AppMethodBeat.i(137158);
    if (paramInt > this.ixc)
    {
      ac.e("MicroMsg.Music.IndexBitMgr", "getIndex, offset is invalid, offset:%d, fileLength:%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(this.ixc) });
      AppMethodBeat.o(137158);
      return 0;
    }
    paramInt /= 8192;
    AppMethodBeat.o(137158);
    return paramInt;
  }
  
  public final boolean gq(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137162);
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt1 > this.ixc) || (paramInt1 + paramInt2 > this.ixc))
    {
      ac.e("MicroMsg.Music.IndexBitMgr", "canReadFromCache offset %d, size %d, fileLength %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(this.ixc) });
      ac.e("MicroMsg.Music.IndexBitMgr", "canReadFromCache invalid parameter!");
      AppMethodBeat.o(137162);
      return false;
    }
    int i = getIndex(paramInt1);
    paramInt2 = getIndex(paramInt1 + paramInt2);
    paramInt1 = i;
    while (paramInt1 <= paramInt2)
    {
      if (!JB(i))
      {
        ac.d("MicroMsg.Music.IndexBitMgr", "index %d, indexBit 0", new Object[] { Integer.valueOf(paramInt1) });
        AppMethodBeat.o(137162);
        return false;
      }
      paramInt1 += 1;
    }
    AppMethodBeat.o(137162);
    return true;
  }
  
  public static final class a
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
    
    public static BitSet br(byte[] paramArrayOfByte)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.cache.d
 * JD-Core Version:    0.7.0.1
 */