package com.tencent.mm.plugin.music.cache;

import com.tencent.mm.sdk.platformtools.y;

public final class a
{
  public int El = -1;
  private byte[] buffer = new byte[81920];
  public int mSize = 0;
  public com.tencent.mm.plugin.music.g.a.a mxU;
  public d mxV;
  public h mxW;
  public int mxX = -1;
  public int mxY = 0;
  
  public a(com.tencent.mm.plugin.music.g.a.a parama)
  {
    this.mxU = parama;
  }
  
  public final boolean bmG()
  {
    int j = 0;
    boolean bool = false;
    int m;
    int i;
    label198:
    int[] arrayOfInt;
    int n;
    int k;
    int i1;
    for (;;)
    {
      d locald;
      try
      {
        if ((this.El < 0) || (this.mSize <= 0))
        {
          y.e("MicroMsg.Music.FileBytesCacheMgr", "flushBufferAll(), mOffset:%d, mSize:%d", new Object[] { Integer.valueOf(this.El), Integer.valueOf(this.mSize) });
          return bool;
        }
        byte[] arrayOfByte = new byte[this.mSize];
        System.arraycopy(this.buffer, 0, arrayOfByte, 0, this.mSize);
        this.mxW.c(arrayOfByte, this.El, this.mSize);
        locald = this.mxV;
        m = this.El;
        i = this.mSize;
        if ((m < 0) || (i < 0) || (m > locald.eUd) || (m + i > locald.eUd))
        {
          y.i("MicroMsg.Music.IndexBitMgr", "getWriteBuffIndexRange offset %d, size %d, fileLength %d", new Object[] { Integer.valueOf(m), Integer.valueOf(i), Long.valueOf(locald.eUd) });
          y.e("MicroMsg.Music.IndexBitMgr", "getWriteBuffRange invalid parameter!");
          arrayOfByte = null;
          if (arrayOfByte != null) {
            break label576;
          }
          y.e("MicroMsg.Music.FileBytesCacheMgr", "flushBufferAll, range is null");
          continue;
        }
        arrayOfInt = new int[2];
      }
      finally {}
      arrayOfInt[1] = -1;
      arrayOfInt[0] = -1;
      n = m + i;
      k = locald.getIndex(m);
      i1 = locald.getIndex(n);
      i = k;
      break;
      label263:
      if ((arrayOfInt[0] != -1) || (arrayOfInt[1] != -1) || (n != locald.eUd)) {
        break label573;
      }
      y.i("MicroMsg.Music.IndexBitMgr", "write to file end!");
      arrayOfInt[0] = k;
      arrayOfInt[1] = i1;
      break label573;
      label312:
      y.d("MicroMsg.Music.FileBytesCacheMgr", "flushBufferAll range[0]:%d, range[1]:%d", new Object[] { Integer.valueOf(arrayOfInt[0]), Integer.valueOf(arrayOfInt[1]) });
    }
    for (;;)
    {
      if (i <= arrayOfInt[1])
      {
        this.mxV.uE(i);
        i += 1;
      }
      else
      {
        k = arrayOfInt[0];
        i = j;
        if (k > 0)
        {
          k -= 1;
          i = j;
          if (!this.mxV.uD(k))
          {
            i = j;
            if (this.mxX + this.mxY == this.El)
            {
              i = j;
              if (this.mSize > 0)
              {
                i = j;
                if (this.mxY >= 8192)
                {
                  y.i("MicroMsg.Music.FileBytesCacheMgr", "isCanSavePreviousIndex, save index :%d", new Object[] { Integer.valueOf(k) });
                  i = 1;
                }
              }
            }
          }
        }
        if (i != 0) {
          this.mxV.uE(arrayOfInt[0] - 1);
        }
        this.mxV.bmL();
        bool = true;
        break;
        while (i <= i1)
        {
          if ((i * 8192 >= m) && ((i + 1) * 8192 <= n))
          {
            if (arrayOfInt[0] == -1) {
              arrayOfInt[0] = i;
            }
            if (arrayOfInt[0] > i) {
              arrayOfInt[0] = i;
            }
            if (arrayOfInt[1] == -1) {
              arrayOfInt[1] = i;
            }
            if (arrayOfInt[1] < i) {
              arrayOfInt[1] = i;
            }
          }
          i += 1;
        }
        break label263;
        label573:
        break label198;
        label576:
        if ((arrayOfInt[0] == -1) || (arrayOfInt[1] == -1)) {
          break label312;
        }
        i = arrayOfInt[0];
      }
    }
  }
  
  public final void r(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      paramInt1 -= this.El;
      this.mSize = (paramInt1 + paramInt2);
      System.arraycopy(paramArrayOfByte, 0, this.buffer, paramInt1, paramInt2);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  /* Error */
  public final boolean uA(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 27	com/tencent/mm/plugin/music/cache/a:El	I
    //   6: iload_1
    //   7: if_icmpgt +28 -> 35
    //   10: aload_0
    //   11: getfield 27	com/tencent/mm/plugin/music/cache/a:El	I
    //   14: istore_2
    //   15: aload_0
    //   16: getfield 29	com/tencent/mm/plugin/music/cache/a:mSize	I
    //   19: istore_3
    //   20: iload_1
    //   21: iload_2
    //   22: iload_3
    //   23: iadd
    //   24: if_icmpgt +11 -> 35
    //   27: iconst_1
    //   28: istore 4
    //   30: aload_0
    //   31: monitorexit
    //   32: iload 4
    //   34: ireturn
    //   35: iconst_0
    //   36: istore 4
    //   38: goto -8 -> 30
    //   41: astore 5
    //   43: aload_0
    //   44: monitorexit
    //   45: aload 5
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	a
    //   0	48	1	paramInt	int
    //   14	10	2	i	int
    //   19	5	3	j	int
    //   28	9	4	bool	boolean
    //   41	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	41	finally
  }
  
  public final void uB(int paramInt)
  {
    try
    {
      this.mxX = this.El;
      this.mxY = this.mSize;
      this.El = paramInt;
      this.mSize = 0;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final boolean uz(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 27	com/tencent/mm/plugin/music/cache/a:El	I
    //   6: iload_1
    //   7: if_icmpgt +22 -> 29
    //   10: aload_0
    //   11: getfield 27	com/tencent/mm/plugin/music/cache/a:El	I
    //   14: istore_2
    //   15: iload_1
    //   16: iload_2
    //   17: ldc 23
    //   19: iadd
    //   20: if_icmpgt +9 -> 29
    //   23: iconst_1
    //   24: istore_3
    //   25: aload_0
    //   26: monitorexit
    //   27: iload_3
    //   28: ireturn
    //   29: iconst_0
    //   30: istore_3
    //   31: goto -6 -> 25
    //   34: astore 4
    //   36: aload_0
    //   37: monitorexit
    //   38: aload 4
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	a
    //   0	41	1	paramInt	int
    //   14	6	2	i	int
    //   24	7	3	bool	boolean
    //   34	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	15	34	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.cache.a
 * JD-Core Version:    0.7.0.1
 */