package com.tencent.qqmusic.mediaplayer;

import com.tencent.qqmusic.mediaplayer.util.Logger;

class StateRunner<T>
{
  private static final String TAG = "StateRunner";
  private T mState;
  
  public StateRunner(T paramT)
  {
    this.mState = paramT;
  }
  
  public T get()
  {
    try
    {
      Object localObject1 = this.mState;
      return localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  /* Error */
  public boolean isEqual(T... paramVarArgs)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_1
    //   6: arraylength
    //   7: istore_3
    //   8: iconst_0
    //   9: istore_2
    //   10: iload 5
    //   12: istore 4
    //   14: iload_2
    //   15: iload_3
    //   16: if_icmpge +27 -> 43
    //   19: aload_1
    //   20: iload_2
    //   21: aaload
    //   22: astore 6
    //   24: aload_0
    //   25: getfield 19	com/tencent/qqmusic/mediaplayer/StateRunner:mState	Ljava/lang/Object;
    //   28: aload 6
    //   30: invokevirtual 31	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   33: istore 4
    //   35: iload 4
    //   37: ifeq +11 -> 48
    //   40: iconst_1
    //   41: istore 4
    //   43: aload_0
    //   44: monitorexit
    //   45: iload 4
    //   47: ireturn
    //   48: iload_2
    //   49: iconst_1
    //   50: iadd
    //   51: istore_2
    //   52: goto -42 -> 10
    //   55: astore_1
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_1
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	StateRunner
    //   0	60	1	paramVarArgs	T[]
    //   9	43	2	i	int
    //   7	10	3	j	int
    //   12	34	4	bool1	boolean
    //   1	10	5	bool2	boolean
    //   22	7	6	?	T
    // Exception table:
    //   from	to	target	type
    //   5	8	55	finally
    //   24	35	55	finally
  }
  
  public T transfer(T paramT)
  {
    try
    {
      Object localObject = this.mState;
      this.mState = paramT;
      Logger.i("StateRunner", localObject.toString() + " -> " + this.mState.toString());
      return localObject;
    }
    finally
    {
      paramT = finally;
      throw paramT;
    }
  }
  
  /* Error */
  public boolean transfer(T paramT, T... paramVarArgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_2
    //   4: invokevirtual 58	com/tencent/qqmusic/mediaplayer/StateRunner:isEqual	([Ljava/lang/Object;)Z
    //   7: ifeq +15 -> 22
    //   10: aload_0
    //   11: aload_1
    //   12: invokevirtual 60	com/tencent/qqmusic/mediaplayer/StateRunner:transfer	(Ljava/lang/Object;)Ljava/lang/Object;
    //   15: pop
    //   16: iconst_1
    //   17: istore_3
    //   18: aload_0
    //   19: monitorexit
    //   20: iload_3
    //   21: ireturn
    //   22: iconst_0
    //   23: istore_3
    //   24: goto -6 -> 18
    //   27: astore_1
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_1
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	StateRunner
    //   0	32	1	paramT	T
    //   0	32	2	paramVarArgs	T[]
    //   17	7	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	16	27	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.StateRunner
 * JD-Core Version:    0.7.0.1
 */