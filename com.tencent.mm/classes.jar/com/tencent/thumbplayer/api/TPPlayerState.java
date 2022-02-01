package com.tencent.thumbplayer.api;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.a.c.h;

public class TPPlayerState
{
  public static final int COMPLETE = 7;
  public static final int ERROR = 10;
  public static final int IDLE = 1;
  public static final int INDEX = 0;
  public static final int INITIALIZED = 2;
  private static final SparseArray<String> NS_STATES;
  public static final int PAUSE = 6;
  public static final int PREPARED = 4;
  public static final int PREPARING = 3;
  public static final int RELEASED = 11;
  public static final int START = 5;
  public static final int STOPPED = 9;
  public static final int STOPPING = 8;
  private int mCurState = 1;
  private int mInnerPlayState = 1;
  private int mLastState = 1;
  private int mPreState = 1;
  private c.h mStateChangeListener;
  
  static
  {
    AppMethodBeat.i(228364);
    SparseArray localSparseArray = new SparseArray();
    NS_STATES = localSparseArray;
    localSparseArray.put(1, "IDLE");
    NS_STATES.put(2, "INITIALIZED");
    NS_STATES.put(3, "PREPARING");
    NS_STATES.put(4, "PREPARED");
    NS_STATES.put(5, "START");
    NS_STATES.put(6, "PAUSE");
    NS_STATES.put(7, "COMPLETE");
    NS_STATES.put(8, "STOPPING");
    NS_STATES.put(9, "STOPPED");
    NS_STATES.put(10, "ERROR");
    NS_STATES.put(11, "RELEASED");
    AppMethodBeat.o(228364);
  }
  
  public void changeState(int paramInt)
  {
    try
    {
      AppMethodBeat.i(228367);
      if (this.mCurState != paramInt)
      {
        this.mPreState = this.mCurState;
        this.mCurState = paramInt;
        if (this.mStateChangeListener != null) {
          this.mStateChangeListener.onStateChange(this.mPreState, this.mCurState);
        }
      }
      AppMethodBeat.o(228367);
      return;
    }
    finally {}
  }
  
  public int innerPlayState()
  {
    try
    {
      int i = this.mInnerPlayState;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public boolean is(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 78	com/tencent/thumbplayer/api/TPPlayerState:mCurState	I
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
    //   0	30	0	this	TPPlayerState
    //   0	30	1	paramInt	int
    //   6	4	2	i	int
    //   13	7	3	bool	boolean
    //   23	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	23	finally
  }
  
  public int lastState()
  {
    try
    {
      int i = this.mLastState;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int preState()
  {
    try
    {
      int i = this.mPreState;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setInnerPlayStateState(int paramInt)
  {
    try
    {
      if (this.mInnerPlayState != paramInt) {
        this.mInnerPlayState = paramInt;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setLastState(int paramInt)
  {
    try
    {
      if (this.mLastState != paramInt) {
        this.mLastState = paramInt;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setOnPlayerStateChangeListener(c.h paramh)
  {
    this.mStateChangeListener = paramh;
  }
  
  public int state()
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
  
  public String toString()
  {
    try
    {
      AppMethodBeat.i(228396);
      String str1 = (String)NS_STATES.get(this.mCurState);
      String str2 = (String)NS_STATES.get(this.mPreState);
      String str3 = (String)NS_STATES.get(this.mLastState);
      String str4 = (String)NS_STATES.get(this.mInnerPlayState);
      str1 = "state[ cur : " + str1 + " , pre : " + str2 + " , last : " + str3 + " , inner play : " + str4 + " ]";
      AppMethodBeat.o(228396);
      return str1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.api.TPPlayerState
 * JD-Core Version:    0.7.0.1
 */