package com.tencent.mm.storage.emotion;

import com.tencent.mm.cf.g;
import com.tencent.mm.cf.g.a;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class t
  extends i<s>
  implements g.a
{
  public static final String[] dXp = { i.a(s.buS, "SmileyPanelConfigInfo") };
  private static final String[] uDx = { "position", "key" };
  public e dXw;
  
  public t(e parame)
  {
    this(parame, s.buS, "SmileyPanelConfigInfo");
  }
  
  private t(e parame, c.a parama, String paramString)
  {
    super(parame, parama, paramString, null);
    this.dXw = parame;
  }
  
  public final int a(g paramg)
  {
    if (paramg != null) {
      this.dXw = paramg;
    }
    return 0;
  }
  
  /* Error */
  public final java.util.ArrayList<s> aHi()
  {
    // Byte code:
    //   0: new 54	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 56	java/util/ArrayList:<init>	()V
    //   7: astore 5
    //   9: aload_0
    //   10: getfield 47	com/tencent/mm/storage/emotion/t:dXw	Lcom/tencent/mm/sdk/e/e;
    //   13: ldc 24
    //   15: getstatic 36	com/tencent/mm/storage/emotion/t:uDx	[Ljava/lang/String;
    //   18: aconst_null
    //   19: aconst_null
    //   20: aconst_null
    //   21: aconst_null
    //   22: aconst_null
    //   23: iconst_2
    //   24: invokeinterface 61 9 0
    //   29: astore_3
    //   30: aload_3
    //   31: ifnull +56 -> 87
    //   34: aload_3
    //   35: astore_2
    //   36: aload_3
    //   37: invokeinterface 67 1 0
    //   42: ifeq +45 -> 87
    //   45: aload_3
    //   46: astore_2
    //   47: new 18	com/tencent/mm/storage/emotion/s
    //   50: dup
    //   51: invokespecial 68	com/tencent/mm/storage/emotion/s:<init>	()V
    //   54: astore 4
    //   56: aload_3
    //   57: astore_2
    //   58: aload 4
    //   60: aload_3
    //   61: invokevirtual 72	com/tencent/mm/storage/emotion/s:d	(Landroid/database/Cursor;)V
    //   64: aload_3
    //   65: astore_2
    //   66: aload 5
    //   68: aload 4
    //   70: invokevirtual 76	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   73: pop
    //   74: aload_3
    //   75: astore_2
    //   76: aload_3
    //   77: invokeinterface 79 1 0
    //   82: istore_1
    //   83: iload_1
    //   84: ifne -39 -> 45
    //   87: aload_3
    //   88: ifnull +9 -> 97
    //   91: aload_3
    //   92: invokeinterface 82 1 0
    //   97: aload 5
    //   99: areturn
    //   100: astore 4
    //   102: aconst_null
    //   103: astore_3
    //   104: aload_3
    //   105: astore_2
    //   106: ldc 84
    //   108: aload 4
    //   110: invokestatic 90	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   113: invokestatic 96	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   116: aload_3
    //   117: ifnull -20 -> 97
    //   120: aload_3
    //   121: invokeinterface 82 1 0
    //   126: aload 5
    //   128: areturn
    //   129: astore_3
    //   130: aconst_null
    //   131: astore_2
    //   132: aload_2
    //   133: ifnull +9 -> 142
    //   136: aload_2
    //   137: invokeinterface 82 1 0
    //   142: aload_3
    //   143: athrow
    //   144: astore_3
    //   145: goto -13 -> 132
    //   148: astore 4
    //   150: goto -46 -> 104
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	t
    //   82	2	1	bool	boolean
    //   35	102	2	localCursor1	android.database.Cursor
    //   29	92	3	localCursor2	android.database.Cursor
    //   129	14	3	localObject1	java.lang.Object
    //   144	1	3	localObject2	java.lang.Object
    //   54	15	4	locals	s
    //   100	9	4	localException1	java.lang.Exception
    //   148	1	4	localException2	java.lang.Exception
    //   7	120	5	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   9	30	100	java/lang/Exception
    //   9	30	129	finally
    //   36	45	144	finally
    //   47	56	144	finally
    //   58	64	144	finally
    //   66	74	144	finally
    //   76	83	144	finally
    //   106	116	144	finally
    //   36	45	148	java/lang/Exception
    //   47	56	148	java/lang/Exception
    //   58	64	148	java/lang/Exception
    //   66	74	148	java/lang/Exception
    //   76	83	148	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.t
 * JD-Core Version:    0.7.0.1
 */