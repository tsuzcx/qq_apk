package com.tencent.mm.plugin.wear.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public final class g
{
  private static int uHr = 0;
  private HashMap<String, f> uHs;
  
  public g()
  {
    AppMethodBeat.i(26332);
    this.uHs = new HashMap();
    AppMethodBeat.o(26332);
  }
  
  public final void a(f paramf)
  {
    try
    {
      AppMethodBeat.i(26335);
      ab.i("MicroMsg.Wear.WearNotificationMap", "update notification=%s", new Object[] { paramf });
      this.uHs.put(paramf.talker, paramf);
      AppMethodBeat.o(26335);
      return;
    }
    finally
    {
      paramf = finally;
      throw paramf;
    }
  }
  
  /* Error */
  public final f agb(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 26333
    //   5: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 28	com/tencent/mm/plugin/wear/model/g:uHs	Ljava/util/HashMap;
    //   12: aload_1
    //   13: invokevirtual 58	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   16: ifeq +31 -> 47
    //   19: aload_0
    //   20: getfield 28	com/tencent/mm/plugin/wear/model/g:uHs	Ljava/util/HashMap;
    //   23: aload_1
    //   24: invokevirtual 62	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   27: checkcast 44	com/tencent/mm/plugin/wear/model/f
    //   30: invokevirtual 66	com/tencent/mm/plugin/wear/model/f:clone	()Ljava/lang/Object;
    //   33: checkcast 44	com/tencent/mm/plugin/wear/model/f
    //   36: astore_1
    //   37: sipush 26333
    //   40: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: areturn
    //   47: getstatic 13	com/tencent/mm/plugin/wear/model/g:uHr	I
    //   50: iconst_1
    //   51: iadd
    //   52: putstatic 13	com/tencent/mm/plugin/wear/model/g:uHr	I
    //   55: new 44	com/tencent/mm/plugin/wear/model/f
    //   58: dup
    //   59: invokespecial 67	com/tencent/mm/plugin/wear/model/f:<init>	()V
    //   62: astore_2
    //   63: aload_2
    //   64: aload_1
    //   65: putfield 48	com/tencent/mm/plugin/wear/model/f:talker	Ljava/lang/String;
    //   68: aload_2
    //   69: getstatic 13	com/tencent/mm/plugin/wear/model/g:uHr	I
    //   72: putfield 70	com/tencent/mm/plugin/wear/model/f:id	I
    //   75: aload_2
    //   76: getstatic 76	com/tencent/mm/plugin/wear/model/f$a:uHm	Lcom/tencent/mm/plugin/wear/model/f$a;
    //   79: putfield 79	com/tencent/mm/plugin/wear/model/f:uHl	Lcom/tencent/mm/plugin/wear/model/f$a;
    //   82: aload_0
    //   83: getfield 28	com/tencent/mm/plugin/wear/model/g:uHs	Ljava/util/HashMap;
    //   86: aload_1
    //   87: aload_2
    //   88: invokevirtual 52	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   91: pop
    //   92: aload_2
    //   93: invokevirtual 66	com/tencent/mm/plugin/wear/model/f:clone	()Ljava/lang/Object;
    //   96: checkcast 44	com/tencent/mm/plugin/wear/model/f
    //   99: astore_1
    //   100: sipush 26333
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
  
  public final void agc(String paramString)
  {
    try
    {
      AppMethodBeat.i(26334);
      ab.i("MicroMsg.Wear.WearNotificationMap", "reset notification talker=%s", new Object[] { paramString });
      if (this.uHs.containsKey(paramString))
      {
        ((f)this.uHs.get(paramString)).uHl = f.a.uHm;
        ((f)this.uHs.get(paramString)).uHk = 0;
      }
      AppMethodBeat.o(26334);
      return;
    }
    finally {}
  }
  
  public final void agd(String paramString)
  {
    try
    {
      AppMethodBeat.i(26336);
      if (this.uHs.containsKey(paramString))
      {
        paramString = (f)this.uHs.get(paramString);
        paramString.uHl = f.a.uHp;
        paramString.uHk = 0;
        ab.i("MicroMsg.Wear.WearNotificationMap", "Update reply success, notification=%s", new Object[] { paramString });
      }
      AppMethodBeat.o(26336);
      return;
    }
    finally {}
  }
  
  public final void age(String paramString)
  {
    try
    {
      AppMethodBeat.i(26338);
      if (this.uHs.containsKey(paramString))
      {
        paramString = (f)this.uHs.get(paramString);
        paramString.uHl = f.a.uHn;
        ab.i("MicroMsg.Wear.WearNotificationMap", "Update showing success, notification=%s", new Object[] { paramString });
      }
      AppMethodBeat.o(26338);
      return;
    }
    finally {}
  }
  
  public final void dH(String paramString, int paramInt)
  {
    try
    {
      AppMethodBeat.i(26337);
      if (this.uHs.containsKey(paramString))
      {
        paramString = (f)this.uHs.get(paramString);
        paramString.uHl = f.a.uHo;
        paramString.uHk = paramInt;
        ab.i("MicroMsg.Wear.WearNotificationMap", "Update ignore success, notification=%s", new Object[] { paramString });
      }
      AppMethodBeat.o(26337);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.g
 * JD-Core Version:    0.7.0.1
 */