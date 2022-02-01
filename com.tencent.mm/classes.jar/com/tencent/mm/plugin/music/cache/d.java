package com.tencent.mm.plugin.music.cache;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.BitSet;

public final class d
{
  public BitSet LKB;
  public int count;
  public long fileLength;
  public String mUrl;
  public String musicId;
  
  public d(String paramString)
  {
    AppMethodBeat.i(137154);
    this.LKB = new BitSet();
    this.fileLength = -1L;
    this.count = 0;
    this.musicId = "";
    this.mUrl = paramString;
    AppMethodBeat.o(137154);
  }
  
  private boolean gmW()
  {
    AppMethodBeat.i(137163);
    Log.i("MicroMsg.Music.IndexBitMgr", "isCacheComplete, count:%d, cardinality:%d", new Object[] { Integer.valueOf(this.count), Integer.valueOf(this.LKB.cardinality()) });
    if ((this.count > 0) && (this.count == this.LKB.cardinality()))
    {
      AppMethodBeat.o(137163);
      return true;
    }
    AppMethodBeat.o(137163);
    return false;
  }
  
  public final int Ni(int paramInt)
  {
    AppMethodBeat.i(137158);
    if (paramInt > this.fileLength)
    {
      Log.e("MicroMsg.Music.IndexBitMgr", "getIndex, offset is invalid, offset:%d, fileLength:%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(this.fileLength) });
      AppMethodBeat.o(137158);
      return 0;
    }
    paramInt /= 8192;
    AppMethodBeat.o(137158);
    return paramInt;
  }
  
  public final void adm(int paramInt)
  {
    AppMethodBeat.i(137157);
    Log.i("MicroMsg.Music.IndexBitMgr", "setFileCacheComplete %d", new Object[] { Integer.valueOf(paramInt) });
    if (!TextUtils.isEmpty(this.musicId)) {
      e.gm(this.musicId, paramInt);
    }
    AppMethodBeat.o(137157);
  }
  
  public final boolean adn(int paramInt)
  {
    AppMethodBeat.i(137159);
    boolean bool = this.LKB.get(paramInt);
    AppMethodBeat.o(137159);
    return bool;
  }
  
  public final void ado(int paramInt)
  {
    AppMethodBeat.i(137160);
    this.LKB.set(paramInt);
    AppMethodBeat.o(137160);
  }
  
  public final void adp(int paramInt)
  {
    AppMethodBeat.i(137161);
    this.LKB.set(paramInt, false);
    AppMethodBeat.o(137161);
  }
  
  public final void clearCache()
  {
    AppMethodBeat.i(137156);
    Log.i("MicroMsg.Music.IndexBitMgr", "clearCache");
    this.LKB = new BitSet(this.count);
    adm(0);
    if (!TextUtils.isEmpty(this.musicId)) {
      e.B(this.musicId, null);
    }
    AppMethodBeat.o(137156);
  }
  
  public final void gmV()
  {
    AppMethodBeat.i(137155);
    if (!TextUtils.isEmpty(this.musicId))
    {
      byte[] arrayOfByte = d.a.a(this.LKB);
      e.B(this.musicId, arrayOfByte);
    }
    Log.d("MicroMsg.Music.IndexBitMgr", "saveBitCache bitSet:%s", new Object[] { this.LKB.toString() });
    Log.i("MicroMsg.Music.IndexBitMgr", "saveBitCache bitSet count %d, cardinality:" + this.count + "," + this.LKB.cardinality());
    if (gmW()) {
      adm(1);
    }
    AppMethodBeat.o(137155);
  }
  
  public final boolean jY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137162);
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt1 > this.fileLength) || (paramInt1 + paramInt2 > this.fileLength))
    {
      Log.e("MicroMsg.Music.IndexBitMgr", "canReadFromCache offset %d, size %d, fileLength %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(this.fileLength) });
      Log.e("MicroMsg.Music.IndexBitMgr", "canReadFromCache invalid parameter!");
      AppMethodBeat.o(137162);
      return false;
    }
    int i = Ni(paramInt1);
    paramInt2 = Ni(paramInt1 + paramInt2);
    paramInt1 = i;
    while (paramInt1 <= paramInt2)
    {
      if (!adn(i))
      {
        Log.d("MicroMsg.Music.IndexBitMgr", "index %d, indexBit 0", new Object[] { Integer.valueOf(paramInt1) });
        AppMethodBeat.o(137162);
        return false;
      }
      paramInt1 += 1;
    }
    AppMethodBeat.o(137162);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.cache.d
 * JD-Core Version:    0.7.0.1
 */