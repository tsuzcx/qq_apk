package com.tencent.mm.plugin.music.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
{
  public int Fb;
  private byte[] buffer;
  public int mSize;
  public com.tencent.mm.plugin.music.g.a.a oYd;
  public d oYe;
  public h oYf;
  public int oYg;
  public int oYh;
  
  public a(com.tencent.mm.plugin.music.g.a.a parama)
  {
    AppMethodBeat.i(137398);
    this.buffer = new byte[81920];
    this.Fb = -1;
    this.mSize = 0;
    this.oYg = -1;
    this.oYh = 0;
    this.oYd = parama;
    AppMethodBeat.o(137398);
  }
  
  public final boolean bUZ()
  {
    int j = 0;
    boolean bool = false;
    int m;
    int i;
    label208:
    int[] arrayOfInt;
    int n;
    int k;
    int i1;
    for (;;)
    {
      d locald;
      try
      {
        AppMethodBeat.i(137399);
        if ((this.Fb < 0) || (this.mSize <= 0))
        {
          ab.e("MicroMsg.Music.FileBytesCacheMgr", "flushBufferAll(), mOffset:%d, mSize:%d", new Object[] { Integer.valueOf(this.Fb), Integer.valueOf(this.mSize) });
          AppMethodBeat.o(137399);
          return bool;
        }
        byte[] arrayOfByte = new byte[this.mSize];
        System.arraycopy(this.buffer, 0, arrayOfByte, 0, this.mSize);
        this.oYf.b(arrayOfByte, this.Fb, this.mSize);
        locald = this.oYe;
        m = this.Fb;
        i = this.mSize;
        if ((m < 0) || (i < 0) || (m > locald.gmb) || (m + i > locald.gmb))
        {
          ab.i("MicroMsg.Music.IndexBitMgr", "getWriteBuffIndexRange offset %d, size %d, fileLength %d", new Object[] { Integer.valueOf(m), Integer.valueOf(i), Long.valueOf(locald.gmb) });
          ab.e("MicroMsg.Music.IndexBitMgr", "getWriteBuffRange invalid parameter!");
          arrayOfByte = null;
          if (arrayOfByte != null) {
            break label617;
          }
          ab.e("MicroMsg.Music.FileBytesCacheMgr", "flushBufferAll, range is null");
          AppMethodBeat.o(137399);
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
      label278:
      if (n != locald.gmb) {
        break label614;
      }
      if ((i1 != 0) || (m != 0)) {
        break label595;
      }
      label303:
      ab.i("MicroMsg.Music.IndexBitMgr", "write to file end!");
      arrayOfInt[0] = k;
      arrayOfInt[1] = i1;
      break label614;
      label324:
      ab.d("MicroMsg.Music.FileBytesCacheMgr", "flushBufferAll range[0]:%d, range[1]:%d", new Object[] { Integer.valueOf(arrayOfInt[0]), Integer.valueOf(arrayOfInt[1]) });
      AppMethodBeat.o(137399);
    }
    for (;;)
    {
      if (i <= arrayOfInt[1])
      {
        this.oYe.zZ(i);
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
          if (!this.oYe.zY(k))
          {
            i = j;
            if (this.oYg + this.oYh == this.Fb)
            {
              i = j;
              if (this.mSize > 0)
              {
                i = j;
                if (this.oYh >= 8192)
                {
                  ab.i("MicroMsg.Music.FileBytesCacheMgr", "isCanSavePreviousIndex, save index :%d", new Object[] { Integer.valueOf(k) });
                  i = 1;
                }
              }
            }
          }
        }
        if (i != 0) {
          this.oYe.zZ(arrayOfInt[0] - 1);
        }
        this.oYe.bVg();
        AppMethodBeat.o(137399);
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
        break label278;
        label595:
        if ((i1 > 0) && (m <= i1 * 8192)) {
          break label303;
        }
        label614:
        break label208;
        label617:
        if ((arrayOfInt[0] == -1) || (arrayOfInt[1] == -1)) {
          break label324;
        }
        i = arrayOfInt[0];
      }
    }
  }
  
  public final void f(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      AppMethodBeat.i(137401);
      paramInt2 -= this.Fb;
      this.mSize = (paramInt2 + paramInt3);
      System.arraycopy(paramArrayOfByte, paramInt1, this.buffer, paramInt2, paramInt3);
      AppMethodBeat.o(137401);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public final void v(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      AppMethodBeat.i(137400);
      paramInt1 -= this.Fb;
      this.mSize = (paramInt1 + paramInt2);
      System.arraycopy(paramArrayOfByte, 0, this.buffer, paramInt1, paramInt2);
      AppMethodBeat.o(137400);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  /* Error */
  public final boolean zU(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 34	com/tencent/mm/plugin/music/cache/a:Fb	I
    //   6: iload_1
    //   7: if_icmpgt +22 -> 29
    //   10: aload_0
    //   11: getfield 34	com/tencent/mm/plugin/music/cache/a:Fb	I
    //   14: istore_2
    //   15: iload_1
    //   16: iload_2
    //   17: ldc 30
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
  
  /* Error */
  public final boolean zV(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 34	com/tencent/mm/plugin/music/cache/a:Fb	I
    //   6: iload_1
    //   7: if_icmpgt +28 -> 35
    //   10: aload_0
    //   11: getfield 34	com/tencent/mm/plugin/music/cache/a:Fb	I
    //   14: istore_2
    //   15: aload_0
    //   16: getfield 36	com/tencent/mm/plugin/music/cache/a:mSize	I
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
  
  public final void zW(int paramInt)
  {
    try
    {
      this.oYg = this.Fb;
      this.oYh = this.mSize;
      this.Fb = paramInt;
      this.mSize = 0;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.cache.a
 * JD-Core Version:    0.7.0.1
 */