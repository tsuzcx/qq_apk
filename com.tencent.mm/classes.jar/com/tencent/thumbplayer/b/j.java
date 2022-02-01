package com.tencent.thumbplayer.b;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.a.c.g;

public final class j
{
  private static final SparseArray<String> Mwc;
  public c.g Mwd;
  private int Mwe = 1;
  private int mCurState = 1;
  private int ncV = 1;
  
  static
  {
    AppMethodBeat.i(194535);
    SparseArray localSparseArray = new SparseArray();
    Mwc = localSparseArray;
    localSparseArray.put(1, "IDLE");
    Mwc.put(2, "INITIALIZED");
    Mwc.put(3, "PREPARING");
    Mwc.put(4, "PREPARED");
    Mwc.put(5, "START");
    Mwc.put(6, "PAUSE");
    Mwc.put(7, "COMPLETE");
    Mwc.put(8, "STOPPED");
    Mwc.put(9, "ERROR");
    Mwc.put(10, "RELEASED");
    AppMethodBeat.o(194535);
  }
  
  /* Error */
  public final boolean ahR(int paramInt)
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
      AppMethodBeat.i(194533);
      if (this.mCurState != paramInt)
      {
        this.Mwe = this.mCurState;
        this.mCurState = paramInt;
        if (this.Mwd != null) {
          this.Mwd.fW(this.Mwe, this.mCurState);
        }
      }
      AppMethodBeat.o(194533);
      return;
    }
    finally {}
  }
  
  public final int gaW()
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
      AppMethodBeat.i(194534);
      String str1 = (String)Mwc.get(this.mCurState);
      String str2 = (String)Mwc.get(this.Mwe);
      String str3 = (String)Mwc.get(this.ncV);
      str1 = "state[ cur : " + str1 + " , pre : " + str2 + " , last : " + str3 + " ]";
      AppMethodBeat.o(194534);
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