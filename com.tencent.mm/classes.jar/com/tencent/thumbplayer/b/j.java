package com.tencent.thumbplayer.b;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.a.c.g;

public final class j
{
  private static final SparseArray<String> LZh;
  public c.g LZi;
  private int LZj = 1;
  private int mCurState = 1;
  private int mXO = 1;
  
  static
  {
    AppMethodBeat.i(191857);
    SparseArray localSparseArray = new SparseArray();
    LZh = localSparseArray;
    localSparseArray.put(1, "IDLE");
    LZh.put(2, "INITIALIZED");
    LZh.put(3, "PREPARING");
    LZh.put(4, "PREPARED");
    LZh.put(5, "START");
    LZh.put(6, "PAUSE");
    LZh.put(7, "COMPLETE");
    LZh.put(8, "STOPPED");
    LZh.put(9, "ERROR");
    LZh.put(10, "RELEASED");
    AppMethodBeat.o(191857);
  }
  
  /* Error */
  public final boolean ahi(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 60	com/tencent/thumbplayer/b/j:mCurState	I
    //   6: istore_2
    //   7: iload_2
    //   8: iload_1
    //   9: if_icmpne +9 -> 18
    //   12: iconst_1
    //   13: istore_3
    //   14: aload_0
    //   15: monitorexit
    //   16: iload_3
    //   17: ireturn
    //   18: iconst_0
    //   19: istore_3
    //   20: goto -6 -> 14
    //   23: astore 4
    //   25: aload_0
    //   26: monitorexit
    //   27: aload 4
    //   29: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	30	0	this	j
    //   0	30	1	paramInt	int
    //   6	4	2	i	int
    //   13	7	3	bool	boolean
    //   23	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	23	finally
  }
  
  public final void changeState(int paramInt)
  {
    try
    {
      AppMethodBeat.i(191855);
      if (this.mCurState != paramInt)
      {
        this.LZj = this.mCurState;
        this.mCurState = paramInt;
        if (this.LZi != null) {
          this.LZi.fW(this.LZj, this.mCurState);
        }
      }
      AppMethodBeat.o(191855);
      return;
    }
    finally {}
  }
  
  public final int fWx()
  {
    try
    {
      int i = this.mCurState;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String toString()
  {
    try
    {
      AppMethodBeat.i(191856);
      String str1 = (String)LZh.get(this.mCurState);
      String str2 = (String)LZh.get(this.LZj);
      String str3 = (String)LZh.get(this.mXO);
      str1 = "state[ cur : " + str1 + " , pre : " + str2 + " , last : " + str3 + " ]";
      AppMethodBeat.o(191856);
      return str1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.b.j
 * JD-Core Version:    0.7.0.1
 */