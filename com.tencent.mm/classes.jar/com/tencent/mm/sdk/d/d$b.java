package com.tencent.mm.sdk.d;

import java.util.Vector;

final class d$b
{
  private int mCount = 0;
  private Vector<d.a> ujm = new Vector();
  private int ujn = 20;
  private int ujo = 0;
  private boolean ujp = false;
  
  /* Error */
  final void b(d paramd, android.os.Message paramMessage, java.lang.String paramString, a parama1, a parama2, a parama3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield 31	com/tencent/mm/sdk/d/d$b:mCount	I
    //   7: iconst_1
    //   8: iadd
    //   9: putfield 31	com/tencent/mm/sdk/d/d$b:mCount	I
    //   12: aload_0
    //   13: getfield 25	com/tencent/mm/sdk/d/d$b:ujm	Ljava/util/Vector;
    //   16: invokevirtual 41	java/util/Vector:size	()I
    //   19: aload_0
    //   20: getfield 27	com/tencent/mm/sdk/d/d$b:ujn	I
    //   23: if_icmpge +30 -> 53
    //   26: aload_0
    //   27: getfield 25	com/tencent/mm/sdk/d/d$b:ujm	Ljava/util/Vector;
    //   30: new 43	com/tencent/mm/sdk/d/d$a
    //   33: dup
    //   34: aload_1
    //   35: aload_2
    //   36: aload_3
    //   37: aload 4
    //   39: aload 5
    //   41: aload 6
    //   43: invokespecial 45	com/tencent/mm/sdk/d/d$a:<init>	(Lcom/tencent/mm/sdk/d/d;Landroid/os/Message;Ljava/lang/String;Lcom/tencent/mm/sdk/d/a;Lcom/tencent/mm/sdk/d/a;Lcom/tencent/mm/sdk/d/a;)V
    //   46: invokevirtual 49	java/util/Vector:add	(Ljava/lang/Object;)Z
    //   49: pop
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: aload_0
    //   54: getfield 25	com/tencent/mm/sdk/d/d$b:ujm	Ljava/util/Vector;
    //   57: aload_0
    //   58: getfield 29	com/tencent/mm/sdk/d/d$b:ujo	I
    //   61: invokevirtual 53	java/util/Vector:get	(I)Ljava/lang/Object;
    //   64: checkcast 43	com/tencent/mm/sdk/d/d$a
    //   67: astore 7
    //   69: aload_0
    //   70: aload_0
    //   71: getfield 29	com/tencent/mm/sdk/d/d$b:ujo	I
    //   74: iconst_1
    //   75: iadd
    //   76: putfield 29	com/tencent/mm/sdk/d/d$b:ujo	I
    //   79: aload_0
    //   80: getfield 29	com/tencent/mm/sdk/d/d$b:ujo	I
    //   83: aload_0
    //   84: getfield 27	com/tencent/mm/sdk/d/d$b:ujn	I
    //   87: if_icmplt +8 -> 95
    //   90: aload_0
    //   91: iconst_0
    //   92: putfield 29	com/tencent/mm/sdk/d/d$b:ujo	I
    //   95: aload 7
    //   97: aload_1
    //   98: aload_2
    //   99: aload_3
    //   100: aload 4
    //   102: aload 5
    //   104: aload 6
    //   106: invokevirtual 56	com/tencent/mm/sdk/d/d$a:a	(Lcom/tencent/mm/sdk/d/d;Landroid/os/Message;Ljava/lang/String;Lcom/tencent/mm/sdk/d/a;Lcom/tencent/mm/sdk/d/a;Lcom/tencent/mm/sdk/d/a;)V
    //   109: goto -59 -> 50
    //   112: astore_1
    //   113: aload_0
    //   114: monitorexit
    //   115: aload_1
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	b
    //   0	117	1	paramd	d
    //   0	117	2	paramMessage	android.os.Message
    //   0	117	3	paramString	java.lang.String
    //   0	117	4	parama1	a
    //   0	117	5	parama2	a
    //   0	117	6	parama3	a
    //   67	29	7	locala	d.a
    // Exception table:
    //   from	to	target	type
    //   2	50	112	finally
    //   53	95	112	finally
    //   95	109	112	finally
  }
  
  final void cleanup()
  {
    try
    {
      this.ujm.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final boolean csm()
  {
    try
    {
      boolean bool = this.ujp;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.sdk.d.d.b
 * JD-Core Version:    0.7.0.1
 */