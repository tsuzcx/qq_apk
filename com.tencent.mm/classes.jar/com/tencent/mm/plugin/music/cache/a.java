package com.tencent.mm.plugin.music.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  public h FPA;
  public int FPB;
  public int FPC;
  public com.tencent.mm.plugin.music.g.a.a FPy;
  public d FPz;
  private byte[] buffer;
  public int mSize;
  public int zP;
  
  public a(com.tencent.mm.plugin.music.g.a.a parama)
  {
    AppMethodBeat.i(137148);
    this.buffer = new byte[81920];
    this.zP = -1;
    this.mSize = 0;
    this.FPB = -1;
    this.FPC = 0;
    this.FPy = parama;
    AppMethodBeat.o(137148);
  }
  
  public final void L(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      AppMethodBeat.i(137150);
      paramInt1 -= this.zP;
      this.mSize = (paramInt1 + paramInt2);
      System.arraycopy(paramArrayOfByte, 0, this.buffer, paramInt1, paramInt2);
      AppMethodBeat.o(137150);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  /* Error */
  public final boolean YY(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 34	com/tencent/mm/plugin/music/cache/a:zP	I
    //   6: iload_1
    //   7: if_icmpgt +22 -> 29
    //   10: aload_0
    //   11: getfield 34	com/tencent/mm/plugin/music/cache/a:zP	I
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
  public final boolean YZ(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 34	com/tencent/mm/plugin/music/cache/a:zP	I
    //   6: iload_1
    //   7: if_icmpgt +28 -> 35
    //   10: aload_0
    //   11: getfield 34	com/tencent/mm/plugin/music/cache/a:zP	I
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
  
  public final void Za(int paramInt)
  {
    try
    {
      this.FPB = this.zP;
      this.FPC = this.mSize;
      this.zP = paramInt;
      this.mSize = 0;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean fdO()
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
        AppMethodBeat.i(137149);
        if ((this.zP < 0) || (this.mSize <= 0))
        {
          Log.e("MicroMsg.Music.FileBytesCacheMgr", "flushBufferAll(), mOffset:%d, mSize:%d", new Object[] { Integer.valueOf(this.zP), Integer.valueOf(this.mSize) });
          AppMethodBeat.o(137149);
          return bool;
        }
        byte[] arrayOfByte = new byte[this.mSize];
        System.arraycopy(this.buffer, 0, arrayOfByte, 0, this.mSize);
        this.FPA.c(arrayOfByte, this.zP, this.mSize);
        locald = this.FPz;
        m = this.zP;
        i = this.mSize;
        if ((m < 0) || (i < 0) || (m > locald.mHi) || (m + i > locald.mHi))
        {
          Log.i("MicroMsg.Music.IndexBitMgr", "getWriteBuffIndexRange offset %d, size %d, fileLength %d", new Object[] { Integer.valueOf(m), Integer.valueOf(i), Long.valueOf(locald.mHi) });
          Log.e("MicroMsg.Music.IndexBitMgr", "getWriteBuffRange invalid parameter!");
          arrayOfByte = null;
          if (arrayOfByte != null) {
            break label617;
          }
          Log.e("MicroMsg.Music.FileBytesCacheMgr", "flushBufferAll, range is null");
          AppMethodBeat.o(137149);
          continue;
        }
        arrayOfInt = new int[2];
      }
      finally {}
      arrayOfInt[1] = -1;
      arrayOfInt[0] = -1;
      n = m + i;
      k = locald.Me(m);
      i1 = locald.Me(n);
      i = k;
      break;
      label278:
      if (n != locald.mHi) {
        break label614;
      }
      if ((i1 != 0) || (m != 0)) {
        break label595;
      }
      label303:
      Log.i("MicroMsg.Music.IndexBitMgr", "write to file end!");
      arrayOfInt[0] = k;
      arrayOfInt[1] = i1;
      break label614;
      label324:
      Log.d("MicroMsg.Music.FileBytesCacheMgr", "flushBufferAll range[0]:%d, range[1]:%d", new Object[] { Integer.valueOf(arrayOfInt[0]), Integer.valueOf(arrayOfInt[1]) });
      AppMethodBeat.o(137149);
    }
    for (;;)
    {
      if (i <= arrayOfInt[1])
      {
        this.FPz.Zd(i);
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
          if (!this.FPz.Zc(k))
          {
            i = j;
            if (this.FPB + this.FPC == this.zP)
            {
              i = j;
              if (this.mSize > 0)
              {
                i = j;
                if (this.FPC >= 8192)
                {
                  Log.i("MicroMsg.Music.FileBytesCacheMgr", "isCanSavePreviousIndex, save index :%d", new Object[] { Integer.valueOf(k) });
                  i = 1;
                }
              }
            }
          }
        }
        if (i != 0) {
          this.FPz.Zd(arrayOfInt[0] - 1);
        }
        this.FPz.fdT();
        AppMethodBeat.o(137149);
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
  
  public final void h(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      AppMethodBeat.i(137151);
      paramInt2 -= this.zP;
      this.mSize = (paramInt2 + paramInt3);
      System.arraycopy(paramArrayOfByte, paramInt1, this.buffer, paramInt2, paramInt3);
      AppMethodBeat.o(137151);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.cache.a
 * JD-Core Version:    0.7.0.1
 */