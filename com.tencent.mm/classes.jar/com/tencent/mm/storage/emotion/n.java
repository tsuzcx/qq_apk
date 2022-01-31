package com.tencent.mm.storage.emotion;

import com.tencent.mm.cf.g;
import com.tencent.mm.cf.g.a;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class n
  extends i<m>
  implements g.a
{
  public static final String[] dXp = { i.a(m.buS, "EmotionRewardTipInfo") };
  private e dXw;
  
  public n(e parame)
  {
    this(parame, m.buS, "EmotionRewardTipInfo");
  }
  
  private n(e parame, c.a parama, String paramString)
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
  
  public final boolean a(m paramm)
  {
    if (paramm == null) {
      y.w("MicroMsg.emoji.EmotionRewardTipStorage", "save failed info is null");
    }
    for (;;)
    {
      return false;
      long l = this.dXw.replace("EmotionRewardTipInfo", "prodcutID", paramm.vf());
      if (l > 0L) {
        y.i("MicroMsg.emoji.EmotionRewardTipStorage", "save success");
      }
      while (l > 0L)
      {
        return true;
        y.i("MicroMsg.emoji.EmotionRewardTipStorage", "save failed");
      }
    }
  }
  
  /* Error */
  public final m cwU()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 40	com/tencent/mm/storage/emotion/n:dXw	Lcom/tencent/mm/sdk/e/e;
    //   4: ldc 77
    //   6: iconst_0
    //   7: anewarray 15	java/lang/String
    //   10: iconst_2
    //   11: invokeinterface 80 4 0
    //   16: astore_2
    //   17: aload_2
    //   18: ifnull +43 -> 61
    //   21: aload_2
    //   22: astore_1
    //   23: aload_2
    //   24: invokeinterface 86 1 0
    //   29: ifeq +32 -> 61
    //   32: aload_2
    //   33: astore_1
    //   34: new 17	com/tencent/mm/storage/emotion/m
    //   37: dup
    //   38: invokespecial 88	com/tencent/mm/storage/emotion/m:<init>	()V
    //   41: astore_3
    //   42: aload_2
    //   43: astore_1
    //   44: aload_3
    //   45: aload_2
    //   46: invokevirtual 92	com/tencent/mm/storage/emotion/m:d	(Landroid/database/Cursor;)V
    //   49: aload_2
    //   50: ifnull +9 -> 59
    //   53: aload_2
    //   54: invokeinterface 95 1 0
    //   59: aload_3
    //   60: areturn
    //   61: aload_2
    //   62: ifnull +9 -> 71
    //   65: aload_2
    //   66: invokeinterface 95 1 0
    //   71: aconst_null
    //   72: areturn
    //   73: astore_3
    //   74: aconst_null
    //   75: astore_2
    //   76: aload_2
    //   77: astore_1
    //   78: ldc 44
    //   80: ldc 97
    //   82: iconst_1
    //   83: anewarray 99	java/lang/Object
    //   86: dup
    //   87: iconst_0
    //   88: aload_3
    //   89: invokestatic 105	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   92: aastore
    //   93: invokestatic 109	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   96: aload_2
    //   97: ifnull -26 -> 71
    //   100: aload_2
    //   101: invokeinterface 95 1 0
    //   106: goto -35 -> 71
    //   109: astore_2
    //   110: aconst_null
    //   111: astore_1
    //   112: aload_1
    //   113: ifnull +9 -> 122
    //   116: aload_1
    //   117: invokeinterface 95 1 0
    //   122: aload_2
    //   123: athrow
    //   124: astore_2
    //   125: goto -13 -> 112
    //   128: astore_3
    //   129: goto -53 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	this	n
    //   22	95	1	localCursor1	android.database.Cursor
    //   16	85	2	localCursor2	android.database.Cursor
    //   109	14	2	localObject1	Object
    //   124	1	2	localObject2	Object
    //   41	19	3	localm	m
    //   73	16	3	localException1	java.lang.Exception
    //   128	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	17	73	java/lang/Exception
    //   0	17	109	finally
    //   23	32	124	finally
    //   34	42	124	finally
    //   44	49	124	finally
    //   78	96	124	finally
    //   23	32	128	java/lang/Exception
    //   34	42	128	java/lang/Exception
    //   44	49	128	java/lang/Exception
  }
  
  public final boolean dz(String paramString, int paramInt)
  {
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.emoji.EmotionRewardTipStorage", "product id is null.");
      return false;
    }
    paramString = "UPDATE EmotionRewardTipInfo SET flag=" + paramInt + ",setFlagTime=" + System.currentTimeMillis() + " WHERE prodcutID='" + paramString + "'";
    boolean bool = this.dXw.gk("EmotionRewardTipInfo", paramString);
    y.i("MicroMsg.emoji.EmotionRewardTipStorage", "updateFlag result:%b", new Object[] { Boolean.valueOf(bool) });
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.n
 * JD-Core Version:    0.7.0.1
 */