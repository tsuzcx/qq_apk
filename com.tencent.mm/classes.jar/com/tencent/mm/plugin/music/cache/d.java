package com.tencent.mm.plugin.music.cache;

import android.text.TextUtils;
import com.tencent.mm.plugin.music.f.c.b;
import com.tencent.mm.sdk.platformtools.y;
import java.util.BitSet;

public final class d
{
  public String bSB = "";
  public int count = 0;
  public long eUd = -1L;
  public String mUrl;
  public BitSet myc = new BitSet();
  
  public d(String paramString)
  {
    this.mUrl = paramString;
  }
  
  private void uC(int paramInt)
  {
    y.i("MicroMsg.Music.IndexBitMgr", "setFileCacheComplete %d", new Object[] { Integer.valueOf(paramInt) });
    if (!TextUtils.isEmpty(this.bSB))
    {
      String str = this.bSB;
      if (e.bmM()) {
        ((c)b.Q(c.class)).bZ(str, paramInt);
      }
    }
  }
  
  public final void bmL()
  {
    int k = 0;
    if (!TextUtils.isEmpty(this.bSB))
    {
      BitSet localBitSet = this.myc;
      byte[] arrayOfByte = new byte[localBitSet.size() / 8];
      i = 0;
      if (i < localBitSet.size())
      {
        int m = i / 8;
        int n = arrayOfByte[m];
        if (localBitSet.get(i)) {}
        for (int j = 1;; j = 0)
        {
          arrayOfByte[m] = ((byte)(j << 7 - i % 8 | n));
          i += 1;
          break;
        }
      }
      e.q(this.bSB, arrayOfByte);
    }
    y.d("MicroMsg.Music.IndexBitMgr", "saveBitCache bitSet:%s", new Object[] { this.myc.toString() });
    y.i("MicroMsg.Music.IndexBitMgr", "saveBitCache bitSet count %d, cardinality:" + this.count + "," + this.myc.cardinality());
    y.i("MicroMsg.Music.IndexBitMgr", "isCacheComplete, count:%d, cardinality:%d", new Object[] { Integer.valueOf(this.count), Integer.valueOf(this.myc.cardinality()) });
    int i = k;
    if (this.count > 0)
    {
      i = k;
      if (this.count == this.myc.cardinality()) {
        i = 1;
      }
    }
    if (i != 0) {
      uC(1);
    }
  }
  
  public final void clearCache()
  {
    y.i("MicroMsg.Music.IndexBitMgr", "clearCache");
    this.myc = new BitSet(this.count);
    uC(0);
    if (!TextUtils.isEmpty(this.bSB)) {
      e.q(this.bSB, null);
    }
  }
  
  public final boolean dn(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt1 > this.eUd) || (paramInt1 + paramInt2 > this.eUd))
    {
      y.e("MicroMsg.Music.IndexBitMgr", "canReadFromCache offset %d, size %d, fileLength %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(this.eUd) });
      y.e("MicroMsg.Music.IndexBitMgr", "canReadFromCache invalid parameter!");
      return false;
    }
    int i = getIndex(paramInt1);
    paramInt2 = getIndex(paramInt1 + paramInt2);
    paramInt1 = i;
    while (paramInt1 <= paramInt2)
    {
      if (!uD(i))
      {
        y.d("MicroMsg.Music.IndexBitMgr", "index %d, indexBit 0", new Object[] { Integer.valueOf(paramInt1) });
        return false;
      }
      paramInt1 += 1;
    }
    return true;
  }
  
  public final int getIndex(int paramInt)
  {
    if (paramInt > this.eUd)
    {
      y.e("MicroMsg.Music.IndexBitMgr", "getIndex, offset is invalid, offset:%d, fileLength:%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(this.eUd) });
      return 0;
    }
    return paramInt / 8192;
  }
  
  public final boolean uD(int paramInt)
  {
    return this.myc.get(paramInt);
  }
  
  public final void uE(int paramInt)
  {
    this.myc.set(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.cache.d
 * JD-Core Version:    0.7.0.1
 */