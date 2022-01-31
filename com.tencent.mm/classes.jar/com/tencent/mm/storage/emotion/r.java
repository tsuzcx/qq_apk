package com.tencent.mm.storage.emotion;

import com.tencent.mm.cf.g;
import com.tencent.mm.cf.g.a;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class r
  extends i<q>
  implements g.a
{
  public static final String[] dXp = { i.a(q.buS, "SmileyInfo") };
  private static final String[] uDv = { "key", "cnValue", "qqValue", "enValue", "twValue", "thValue", "eggIndex", "fileName" };
  private static final String[] uDw = { "key" };
  public e dXw;
  
  public r(e parame)
  {
    this(parame, q.buS, "SmileyInfo");
  }
  
  private r(e parame, c.a parama, String paramString)
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
  public final java.util.ArrayList<q> aHh()
  {
    // Byte code:
    //   0: new 69	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 71	java/util/ArrayList:<init>	()V
    //   7: astore 5
    //   9: aload_0
    //   10: getfield 62	com/tencent/mm/storage/emotion/r:dXw	Lcom/tencent/mm/sdk/e/e;
    //   13: ldc 25
    //   15: getstatic 49	com/tencent/mm/storage/emotion/r:uDv	[Ljava/lang/String;
    //   18: ldc 73
    //   20: iconst_1
    //   21: anewarray 17	java/lang/String
    //   24: dup
    //   25: iconst_0
    //   26: ldc 75
    //   28: aastore
    //   29: aconst_null
    //   30: aconst_null
    //   31: aconst_null
    //   32: iconst_2
    //   33: invokeinterface 80 9 0
    //   38: astore_3
    //   39: aload_3
    //   40: ifnull +64 -> 104
    //   43: aload_3
    //   44: astore_2
    //   45: aload_3
    //   46: invokeinterface 86 1 0
    //   51: ifeq +53 -> 104
    //   54: aload_3
    //   55: astore_2
    //   56: new 19	com/tencent/mm/storage/emotion/q
    //   59: dup
    //   60: invokespecial 87	com/tencent/mm/storage/emotion/q:<init>	()V
    //   63: astore 4
    //   65: aload_3
    //   66: astore_2
    //   67: aload 4
    //   69: aload_3
    //   70: invokevirtual 91	com/tencent/mm/storage/emotion/q:d	(Landroid/database/Cursor;)V
    //   73: aload_3
    //   74: astore_2
    //   75: aload 4
    //   77: iconst_m1
    //   78: putfield 95	com/tencent/mm/storage/emotion/q:field_position	I
    //   81: aload_3
    //   82: astore_2
    //   83: aload 5
    //   85: aload 4
    //   87: invokevirtual 99	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   90: pop
    //   91: aload_3
    //   92: astore_2
    //   93: aload_3
    //   94: invokeinterface 102 1 0
    //   99: istore_1
    //   100: iload_1
    //   101: ifne -47 -> 54
    //   104: aload_3
    //   105: ifnull +9 -> 114
    //   108: aload_3
    //   109: invokeinterface 105 1 0
    //   114: aload 5
    //   116: areturn
    //   117: astore 4
    //   119: aconst_null
    //   120: astore_3
    //   121: aload_3
    //   122: astore_2
    //   123: ldc 107
    //   125: aload 4
    //   127: invokestatic 113	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   130: invokestatic 119	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   133: aload_3
    //   134: ifnull -20 -> 114
    //   137: aload_3
    //   138: invokeinterface 105 1 0
    //   143: aload 5
    //   145: areturn
    //   146: astore_3
    //   147: aconst_null
    //   148: astore_2
    //   149: aload_2
    //   150: ifnull +9 -> 159
    //   153: aload_2
    //   154: invokeinterface 105 1 0
    //   159: aload_3
    //   160: athrow
    //   161: astore_3
    //   162: goto -13 -> 149
    //   165: astore 4
    //   167: goto -46 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	this	r
    //   99	2	1	bool	boolean
    //   44	110	2	localCursor1	android.database.Cursor
    //   38	100	3	localCursor2	android.database.Cursor
    //   146	14	3	localObject1	java.lang.Object
    //   161	1	3	localObject2	java.lang.Object
    //   63	23	4	localq	q
    //   117	9	4	localException1	java.lang.Exception
    //   165	1	4	localException2	java.lang.Exception
    //   7	137	5	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   9	39	117	java/lang/Exception
    //   9	39	146	finally
    //   45	54	161	finally
    //   56	65	161	finally
    //   67	73	161	finally
    //   75	81	161	finally
    //   83	91	161	finally
    //   93	100	161	finally
    //   123	133	161	finally
    //   45	54	165	java/lang/Exception
    //   56	65	165	java/lang/Exception
    //   67	73	165	java/lang/Exception
    //   75	81	165	java/lang/Exception
    //   83	91	165	java/lang/Exception
    //   93	100	165	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.r
 * JD-Core Version:    0.7.0.1
 */