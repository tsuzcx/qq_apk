package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class bg<T>
{
  public Object[] mPool;
  public int mPoolSize;
  
  public bg(int paramInt)
  {
    AppMethodBeat.i(52275);
    if (paramInt <= 0)
    {
      ab.e("MicroMsg.SimpleObjectPool", "The max pool size must be > 0");
      AppMethodBeat.o(52275);
      return;
    }
    this.mPool = new Object[paramInt];
    AppMethodBeat.o(52275);
  }
  
  public T acquire()
  {
    if (this.mPool == null) {}
    while (this.mPoolSize <= 0) {
      return null;
    }
    int i = this.mPoolSize - 1;
    Object localObject = this.mPool[i];
    this.mPool[i] = null;
    this.mPoolSize -= 1;
    return localObject;
  }
  
  public boolean release(T paramT)
  {
    AppMethodBeat.i(52276);
    if (this.mPool == null)
    {
      AppMethodBeat.o(52276);
      return false;
    }
    if (this.mPool != null)
    {
      i = 0;
      if (i < this.mPoolSize) {
        if (this.mPool[i] != paramT) {}
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label71;
      }
      AppMethodBeat.o(52276);
      return false;
      i += 1;
      break;
    }
    label71:
    if ((this.mPoolSize < this.mPool.length) && (this.mPoolSize >= 0))
    {
      this.mPool[this.mPoolSize] = paramT;
      this.mPoolSize += 1;
      AppMethodBeat.o(52276);
      return true;
    }
    ab.e("MicroMsg.SimpleObjectPool", "error index %d %d", new Object[] { Integer.valueOf(this.mPoolSize), Integer.valueOf(this.mPool.length) });
    AppMethodBeat.o(52276);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bg
 * JD-Core Version:    0.7.0.1
 */