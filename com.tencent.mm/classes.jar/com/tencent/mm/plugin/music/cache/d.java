package com.tencent.mm.plugin.music.cache;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.BitSet;

public final class d
{
  public String cAd;
  public int count;
  public long gmb;
  public String mUrl;
  public BitSet oYk;
  
  public d(String paramString)
  {
    AppMethodBeat.i(137404);
    this.oYk = new BitSet();
    this.gmb = -1L;
    this.count = 0;
    this.cAd = "";
    this.mUrl = paramString;
    AppMethodBeat.o(137404);
  }
  
  private boolean bVh()
  {
    AppMethodBeat.i(137413);
    ab.i("MicroMsg.Music.IndexBitMgr", "isCacheComplete, count:%d, cardinality:%d", new Object[] { Integer.valueOf(this.count), Integer.valueOf(this.oYk.cardinality()) });
    if ((this.count > 0) && (this.count == this.oYk.cardinality()))
    {
      AppMethodBeat.o(137413);
      return true;
    }
    AppMethodBeat.o(137413);
    return false;
  }
  
  public final void Aa(int paramInt)
  {
    AppMethodBeat.i(137411);
    this.oYk.set(paramInt, false);
    AppMethodBeat.o(137411);
  }
  
  public final void bVg()
  {
    AppMethodBeat.i(137405);
    if (!TextUtils.isEmpty(this.cAd))
    {
      byte[] arrayOfByte = d.a.a(this.oYk);
      e.y(this.cAd, arrayOfByte);
    }
    ab.d("MicroMsg.Music.IndexBitMgr", "saveBitCache bitSet:%s", new Object[] { this.oYk.toString() });
    ab.i("MicroMsg.Music.IndexBitMgr", "saveBitCache bitSet count %d, cardinality:" + this.count + "," + this.oYk.cardinality());
    if (bVh()) {
      zX(1);
    }
    AppMethodBeat.o(137405);
  }
  
  public final void clearCache()
  {
    AppMethodBeat.i(137406);
    ab.i("MicroMsg.Music.IndexBitMgr", "clearCache");
    this.oYk = new BitSet(this.count);
    zX(0);
    if (!TextUtils.isEmpty(this.cAd)) {
      e.y(this.cAd, null);
    }
    AppMethodBeat.o(137406);
  }
  
  public final boolean eN(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137412);
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt1 > this.gmb) || (paramInt1 + paramInt2 > this.gmb))
    {
      ab.e("MicroMsg.Music.IndexBitMgr", "canReadFromCache offset %d, size %d, fileLength %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(this.gmb) });
      ab.e("MicroMsg.Music.IndexBitMgr", "canReadFromCache invalid parameter!");
      AppMethodBeat.o(137412);
      return false;
    }
    int i = getIndex(paramInt1);
    paramInt2 = getIndex(paramInt1 + paramInt2);
    paramInt1 = i;
    while (paramInt1 <= paramInt2)
    {
      if (!zY(i))
      {
        ab.d("MicroMsg.Music.IndexBitMgr", "index %d, indexBit 0", new Object[] { Integer.valueOf(paramInt1) });
        AppMethodBeat.o(137412);
        return false;
      }
      paramInt1 += 1;
    }
    AppMethodBeat.o(137412);
    return true;
  }
  
  public final int getIndex(int paramInt)
  {
    AppMethodBeat.i(137408);
    if (paramInt > this.gmb)
    {
      ab.e("MicroMsg.Music.IndexBitMgr", "getIndex, offset is invalid, offset:%d, fileLength:%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(this.gmb) });
      AppMethodBeat.o(137408);
      return 0;
    }
    paramInt /= 8192;
    AppMethodBeat.o(137408);
    return paramInt;
  }
  
  public final void zX(int paramInt)
  {
    AppMethodBeat.i(137407);
    ab.i("MicroMsg.Music.IndexBitMgr", "setFileCacheComplete %d", new Object[] { Integer.valueOf(paramInt) });
    if (!TextUtils.isEmpty(this.cAd)) {
      e.cR(this.cAd, paramInt);
    }
    AppMethodBeat.o(137407);
  }
  
  public final boolean zY(int paramInt)
  {
    AppMethodBeat.i(137409);
    boolean bool = this.oYk.get(paramInt);
    AppMethodBeat.o(137409);
    return bool;
  }
  
  public final void zZ(int paramInt)
  {
    AppMethodBeat.i(137410);
    this.oYk.set(paramInt);
    AppMethodBeat.o(137410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.cache.d
 * JD-Core Version:    0.7.0.1
 */