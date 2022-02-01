package com.tencent.mm.sdk.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Vector;

final class d$b
{
  private Vector<d.a> Ihd;
  private int Ihe;
  private boolean Ihf;
  private int mCount;
  private int zbE;
  
  private d$b()
  {
    AppMethodBeat.i(158014);
    this.Ihd = new Vector();
    this.zbE = 20;
    this.Ihe = 0;
    this.mCount = 0;
    this.Ihf = false;
    AppMethodBeat.o(158014);
  }
  
  /* Error */
  final void b(d paramd, android.os.Message paramMessage, java.lang.String paramString, a parama1, a parama2, a parama3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 48
    //   4: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: aload_0
    //   9: getfield 38	com/tencent/mm/sdk/d/d$b:mCount	I
    //   12: iconst_1
    //   13: iadd
    //   14: putfield 38	com/tencent/mm/sdk/d/d$b:mCount	I
    //   17: aload_0
    //   18: getfield 32	com/tencent/mm/sdk/d/d$b:Ihd	Ljava/util/Vector;
    //   21: invokevirtual 52	java/util/Vector:size	()I
    //   24: aload_0
    //   25: getfield 34	com/tencent/mm/sdk/d/d$b:zbE	I
    //   28: if_icmpge +35 -> 63
    //   31: aload_0
    //   32: getfield 32	com/tencent/mm/sdk/d/d$b:Ihd	Ljava/util/Vector;
    //   35: new 54	com/tencent/mm/sdk/d/d$a
    //   38: dup
    //   39: aload_1
    //   40: aload_2
    //   41: aload_3
    //   42: aload 4
    //   44: aload 5
    //   46: aload 6
    //   48: invokespecial 56	com/tencent/mm/sdk/d/d$a:<init>	(Lcom/tencent/mm/sdk/d/d;Landroid/os/Message;Ljava/lang/String;Lcom/tencent/mm/sdk/d/a;Lcom/tencent/mm/sdk/d/a;Lcom/tencent/mm/sdk/d/a;)V
    //   51: invokevirtual 60	java/util/Vector:add	(Ljava/lang/Object;)Z
    //   54: pop
    //   55: ldc 48
    //   57: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: aload_0
    //   61: monitorexit
    //   62: return
    //   63: aload_0
    //   64: getfield 32	com/tencent/mm/sdk/d/d$b:Ihd	Ljava/util/Vector;
    //   67: aload_0
    //   68: getfield 36	com/tencent/mm/sdk/d/d$b:Ihe	I
    //   71: invokevirtual 64	java/util/Vector:get	(I)Ljava/lang/Object;
    //   74: checkcast 54	com/tencent/mm/sdk/d/d$a
    //   77: astore 7
    //   79: aload_0
    //   80: aload_0
    //   81: getfield 36	com/tencent/mm/sdk/d/d$b:Ihe	I
    //   84: iconst_1
    //   85: iadd
    //   86: putfield 36	com/tencent/mm/sdk/d/d$b:Ihe	I
    //   89: aload_0
    //   90: getfield 36	com/tencent/mm/sdk/d/d$b:Ihe	I
    //   93: aload_0
    //   94: getfield 34	com/tencent/mm/sdk/d/d$b:zbE	I
    //   97: if_icmplt +8 -> 105
    //   100: aload_0
    //   101: iconst_0
    //   102: putfield 36	com/tencent/mm/sdk/d/d$b:Ihe	I
    //   105: aload 7
    //   107: aload_1
    //   108: aload_2
    //   109: aload_3
    //   110: aload 4
    //   112: aload 5
    //   114: aload 6
    //   116: invokevirtual 67	com/tencent/mm/sdk/d/d$a:a	(Lcom/tencent/mm/sdk/d/d;Landroid/os/Message;Ljava/lang/String;Lcom/tencent/mm/sdk/d/a;Lcom/tencent/mm/sdk/d/a;Lcom/tencent/mm/sdk/d/a;)V
    //   119: ldc 48
    //   121: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   124: goto -64 -> 60
    //   127: astore_1
    //   128: aload_0
    //   129: monitorexit
    //   130: aload_1
    //   131: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	this	b
    //   0	132	1	paramd	d
    //   0	132	2	paramMessage	android.os.Message
    //   0	132	3	paramString	java.lang.String
    //   0	132	4	parama1	a
    //   0	132	5	parama2	a
    //   0	132	6	parama3	a
    //   77	29	7	locala	d.a
    // Exception table:
    //   from	to	target	type
    //   2	60	127	finally
    //   63	105	127	finally
    //   105	124	127	finally
  }
  
  final void cleanup()
  {
    try
    {
      AppMethodBeat.i(158015);
      this.Ihd.clear();
      AppMethodBeat.o(158015);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final boolean fmg()
  {
    try
    {
      boolean bool = this.Ihf;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.d.d.b
 * JD-Core Version:    0.7.0.1
 */