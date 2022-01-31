package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public final class g
{
  private static int qSk = 0;
  private HashMap<String, f> qSl = new HashMap();
  
  /* Error */
  public final f Re(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 22	com/tencent/mm/plugin/wear/model/g:qSl	Ljava/util/HashMap;
    //   6: aload_1
    //   7: invokevirtual 28	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   10: ifeq +25 -> 35
    //   13: aload_0
    //   14: getfield 22	com/tencent/mm/plugin/wear/model/g:qSl	Ljava/util/HashMap;
    //   17: aload_1
    //   18: invokevirtual 32	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   21: checkcast 34	com/tencent/mm/plugin/wear/model/f
    //   24: invokevirtual 38	com/tencent/mm/plugin/wear/model/f:clone	()Ljava/lang/Object;
    //   27: checkcast 34	com/tencent/mm/plugin/wear/model/f
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_1
    //   34: areturn
    //   35: getstatic 13	com/tencent/mm/plugin/wear/model/g:qSk	I
    //   38: iconst_1
    //   39: iadd
    //   40: putstatic 13	com/tencent/mm/plugin/wear/model/g:qSk	I
    //   43: new 34	com/tencent/mm/plugin/wear/model/f
    //   46: dup
    //   47: invokespecial 39	com/tencent/mm/plugin/wear/model/f:<init>	()V
    //   50: astore_2
    //   51: aload_2
    //   52: aload_1
    //   53: putfield 43	com/tencent/mm/plugin/wear/model/f:talker	Ljava/lang/String;
    //   56: aload_2
    //   57: getstatic 13	com/tencent/mm/plugin/wear/model/g:qSk	I
    //   60: putfield 46	com/tencent/mm/plugin/wear/model/f:id	I
    //   63: aload_2
    //   64: getstatic 52	com/tencent/mm/plugin/wear/model/f$a:qSf	Lcom/tencent/mm/plugin/wear/model/f$a;
    //   67: putfield 55	com/tencent/mm/plugin/wear/model/f:qSe	Lcom/tencent/mm/plugin/wear/model/f$a;
    //   70: aload_0
    //   71: getfield 22	com/tencent/mm/plugin/wear/model/g:qSl	Ljava/util/HashMap;
    //   74: aload_1
    //   75: aload_2
    //   76: invokevirtual 59	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   79: pop
    //   80: aload_2
    //   81: invokevirtual 38	com/tencent/mm/plugin/wear/model/f:clone	()Ljava/lang/Object;
    //   84: checkcast 34	com/tencent/mm/plugin/wear/model/f
    //   87: astore_1
    //   88: goto -57 -> 31
    //   91: astore_1
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_1
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	g
    //   0	96	1	paramString	String
    //   50	31	2	localf	f
    // Exception table:
    //   from	to	target	type
    //   2	31	91	finally
    //   35	88	91	finally
  }
  
  public final void Rf(String paramString)
  {
    try
    {
      y.i("MicroMsg.Wear.WearNotificationMap", "reset notification talker=%s", new Object[] { paramString });
      if (this.qSl.containsKey(paramString))
      {
        ((f)this.qSl.get(paramString)).qSe = f.a.qSf;
        ((f)this.qSl.get(paramString)).qSd = 0;
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void Rg(String paramString)
  {
    try
    {
      if (this.qSl.containsKey(paramString))
      {
        paramString = (f)this.qSl.get(paramString);
        paramString.qSe = f.a.qSi;
        paramString.qSd = 0;
        y.i("MicroMsg.Wear.WearNotificationMap", "Update reply success, notification=%s", new Object[] { paramString });
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void Rh(String paramString)
  {
    try
    {
      if (this.qSl.containsKey(paramString))
      {
        paramString = (f)this.qSl.get(paramString);
        paramString.qSe = f.a.qSg;
        y.i("MicroMsg.Wear.WearNotificationMap", "Update showing success, notification=%s", new Object[] { paramString });
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void a(f paramf)
  {
    try
    {
      y.i("MicroMsg.Wear.WearNotificationMap", "update notification=%s", new Object[] { paramf });
      this.qSl.put(paramf.talker, paramf);
      return;
    }
    finally
    {
      paramf = finally;
      throw paramf;
    }
  }
  
  public final void cI(String paramString, int paramInt)
  {
    try
    {
      if (this.qSl.containsKey(paramString))
      {
        paramString = (f)this.qSl.get(paramString);
        paramString.qSe = f.a.qSh;
        paramString.qSd = paramInt;
        y.i("MicroMsg.Wear.WearNotificationMap", "Update ignore success, notification=%s", new Object[] { paramString });
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.g
 * JD-Core Version:    0.7.0.1
 */