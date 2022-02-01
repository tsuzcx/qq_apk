package com.tencent.mm.plugin.music.cache;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.BitSet;

public final class d
{
  public int count;
  public String dAQ;
  public long iTe;
  public String mUrl;
  public BitSet wza;
  
  public d(String paramString)
  {
    AppMethodBeat.i(137154);
    this.wza = new BitSet();
    this.iTe = -1L;
    this.count = 0;
    this.dAQ = "";
    this.mUrl = paramString;
    AppMethodBeat.o(137154);
  }
  
  private boolean dvP()
  {
    AppMethodBeat.i(137163);
    ae.i("MicroMsg.Music.IndexBitMgr", "isCacheComplete, count:%d, cardinality:%d", new Object[] { Integer.valueOf(this.count), Integer.valueOf(this.wza.cardinality()) });
    if ((this.count > 0) && (this.count == this.wza.cardinality()))
    {
      AppMethodBeat.o(137163);
      return true;
    }
    AppMethodBeat.o(137163);
    return false;
  }
  
  public final void LH(int paramInt)
  {
    AppMethodBeat.i(137157);
    ae.i("MicroMsg.Music.IndexBitMgr", "setFileCacheComplete %d", new Object[] { Integer.valueOf(paramInt) });
    if (!TextUtils.isEmpty(this.dAQ)) {
      e.eD(this.dAQ, paramInt);
    }
    AppMethodBeat.o(137157);
  }
  
  public final boolean LI(int paramInt)
  {
    AppMethodBeat.i(137159);
    boolean bool = this.wza.get(paramInt);
    AppMethodBeat.o(137159);
    return bool;
  }
  
  public final void LJ(int paramInt)
  {
    AppMethodBeat.i(137160);
    this.wza.set(paramInt);
    AppMethodBeat.o(137160);
  }
  
  public final void LK(int paramInt)
  {
    AppMethodBeat.i(137161);
    this.wza.set(paramInt, false);
    AppMethodBeat.o(137161);
  }
  
  public final void clearCache()
  {
    AppMethodBeat.i(137156);
    ae.i("MicroMsg.Music.IndexBitMgr", "clearCache");
    this.wza = new BitSet(this.count);
    LH(0);
    if (!TextUtils.isEmpty(this.dAQ)) {
      e.t(this.dAQ, null);
    }
    AppMethodBeat.o(137156);
  }
  
  public final void dvO()
  {
    AppMethodBeat.i(137155);
    if (!TextUtils.isEmpty(this.dAQ))
    {
      byte[] arrayOfByte = a.a(this.wza);
      e.t(this.dAQ, arrayOfByte);
    }
    ae.d("MicroMsg.Music.IndexBitMgr", "saveBitCache bitSet:%s", new Object[] { this.wza.toString() });
    ae.i("MicroMsg.Music.IndexBitMgr", "saveBitCache bitSet count %d, cardinality:" + this.count + "," + this.wza.cardinality());
    if (dvP()) {
      LH(1);
    }
    AppMethodBeat.o(137155);
  }
  
  public final boolean gJ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137162);
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt1 > this.iTe) || (paramInt1 + paramInt2 > this.iTe))
    {
      ae.e("MicroMsg.Music.IndexBitMgr", "canReadFromCache offset %d, size %d, fileLength %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(this.iTe) });
      ae.e("MicroMsg.Music.IndexBitMgr", "canReadFromCache invalid parameter!");
      AppMethodBeat.o(137162);
      return false;
    }
    int i = getIndex(paramInt1);
    paramInt2 = getIndex(paramInt1 + paramInt2);
    paramInt1 = i;
    while (paramInt1 <= paramInt2)
    {
      if (!LI(i))
      {
        ae.d("MicroMsg.Music.IndexBitMgr", "index %d, indexBit 0", new Object[] { Integer.valueOf(paramInt1) });
        AppMethodBeat.o(137162);
        return false;
      }
      paramInt1 += 1;
    }
    AppMethodBeat.o(137162);
    return true;
  }
  
  public final int getIndex(int paramInt)
  {
    AppMethodBeat.i(137158);
    if (paramInt > this.iTe)
    {
      ae.e("MicroMsg.Music.IndexBitMgr", "getIndex, offset is invalid, offset:%d, fileLength:%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(this.iTe) });
      AppMethodBeat.o(137158);
      return 0;
    }
    paramInt /= 8192;
    AppMethodBeat.o(137158);
    return paramInt;
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
    
    public static BitSet bC(byte[] paramArrayOfByte)
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