package com.tencent.mm.plugin.wear.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

public final class g
{
  private static int WiX = 0;
  private HashMap<String, f> AFz;
  
  public g()
  {
    AppMethodBeat.i(30014);
    this.AFz = new HashMap();
    AppMethodBeat.o(30014);
  }
  
  public final void a(f paramf)
  {
    try
    {
      AppMethodBeat.i(30017);
      Log.i("MicroMsg.Wear.WearNotificationMap", "update notification=%s", new Object[] { paramf });
      this.AFz.put(paramf.talker, paramf);
      AppMethodBeat.o(30017);
      return;
    }
    finally
    {
      paramf = finally;
      throw paramf;
    }
  }
  
  public final void bhA(String paramString)
  {
    try
    {
      AppMethodBeat.i(30016);
      Log.i("MicroMsg.Wear.WearNotificationMap", "reset notification talker=%s", new Object[] { paramString });
      if (this.AFz.containsKey(paramString))
      {
        ((f)this.AFz.get(paramString)).WiR = f.a.WiS;
        ((f)this.AFz.get(paramString)).WiQ = 0;
      }
      AppMethodBeat.o(30016);
      return;
    }
    finally {}
  }
  
  public final void bhB(String paramString)
  {
    try
    {
      AppMethodBeat.i(30018);
      if (this.AFz.containsKey(paramString))
      {
        paramString = (f)this.AFz.get(paramString);
        paramString.WiR = f.a.WiV;
        paramString.WiQ = 0;
        Log.i("MicroMsg.Wear.WearNotificationMap", "Update reply success, notification=%s", new Object[] { paramString });
      }
      AppMethodBeat.o(30018);
      return;
    }
    finally {}
  }
  
  public final void bhC(String paramString)
  {
    try
    {
      AppMethodBeat.i(30020);
      if (this.AFz.containsKey(paramString))
      {
        paramString = (f)this.AFz.get(paramString);
        paramString.WiR = f.a.WiT;
        Log.i("MicroMsg.Wear.WearNotificationMap", "Update showing success, notification=%s", new Object[] { paramString });
      }
      AppMethodBeat.o(30020);
      return;
    }
    finally {}
  }
  
  /* Error */
  public final f bhz(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 30015
    //   5: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 28	com/tencent/mm/plugin/wear/model/g:AFz	Ljava/util/HashMap;
    //   12: aload_1
    //   13: invokevirtual 60	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   16: ifeq +31 -> 47
    //   19: aload_0
    //   20: getfield 28	com/tencent/mm/plugin/wear/model/g:AFz	Ljava/util/HashMap;
    //   23: aload_1
    //   24: invokevirtual 64	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   27: checkcast 44	com/tencent/mm/plugin/wear/model/f
    //   30: invokevirtual 94	com/tencent/mm/plugin/wear/model/f:clone	()Ljava/lang/Object;
    //   33: checkcast 44	com/tencent/mm/plugin/wear/model/f
    //   36: astore_1
    //   37: sipush 30015
    //   40: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: areturn
    //   47: getstatic 13	com/tencent/mm/plugin/wear/model/g:WiX	I
    //   50: iconst_1
    //   51: iadd
    //   52: putstatic 13	com/tencent/mm/plugin/wear/model/g:WiX	I
    //   55: new 44	com/tencent/mm/plugin/wear/model/f
    //   58: dup
    //   59: invokespecial 95	com/tencent/mm/plugin/wear/model/f:<init>	()V
    //   62: astore_2
    //   63: aload_2
    //   64: aload_1
    //   65: putfield 48	com/tencent/mm/plugin/wear/model/f:talker	Ljava/lang/String;
    //   68: aload_2
    //   69: getstatic 13	com/tencent/mm/plugin/wear/model/g:WiX	I
    //   72: putfield 98	com/tencent/mm/plugin/wear/model/f:id	I
    //   75: aload_2
    //   76: getstatic 70	com/tencent/mm/plugin/wear/model/f$a:WiS	Lcom/tencent/mm/plugin/wear/model/f$a;
    //   79: putfield 73	com/tencent/mm/plugin/wear/model/f:WiR	Lcom/tencent/mm/plugin/wear/model/f$a;
    //   82: aload_0
    //   83: getfield 28	com/tencent/mm/plugin/wear/model/g:AFz	Ljava/util/HashMap;
    //   86: aload_1
    //   87: aload_2
    //   88: invokevirtual 52	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   91: pop
    //   92: aload_2
    //   93: invokevirtual 94	com/tencent/mm/plugin/wear/model/f:clone	()Ljava/lang/Object;
    //   96: checkcast 44	com/tencent/mm/plugin/wear/model/f
    //   99: astore_1
    //   100: sipush 30015
    //   103: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: goto -63 -> 43
    //   109: astore_1
    //   110: aload_0
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	this	g
    //   0	114	1	paramString	String
    //   62	31	2	localf	f
    // Exception table:
    //   from	to	target	type
    //   2	43	109	finally
    //   47	106	109	finally
  }
  
  public final void hI(String paramString, int paramInt)
  {
    try
    {
      AppMethodBeat.i(30019);
      if (this.AFz.containsKey(paramString))
      {
        paramString = (f)this.AFz.get(paramString);
        paramString.WiR = f.a.WiU;
        paramString.WiQ = paramInt;
        Log.i("MicroMsg.Wear.WearNotificationMap", "Update ignore success, notification=%s", new Object[] { paramString });
      }
      AppMethodBeat.o(30019);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.g
 * JD-Core Version:    0.7.0.1
 */