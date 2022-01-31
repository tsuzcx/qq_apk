package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.g;
import com.tencent.mm.cg.g.a;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class n
  extends j<m>
  implements g.a
{
  public static final String[] SQL_CREATE;
  private e db;
  
  static
  {
    AppMethodBeat.i(62866);
    SQL_CREATE = new String[] { j.getCreateSQLs(m.info, "EmotionRewardTipInfo") };
    AppMethodBeat.o(62866);
  }
  
  public n(e parame)
  {
    this(parame, m.info, "EmotionRewardTipInfo");
  }
  
  private n(e parame, c.a parama, String paramString)
  {
    super(parame, parama, paramString, null);
    this.db = parame;
  }
  
  public final int a(g paramg)
  {
    this.db = paramg;
    return 0;
  }
  
  public final boolean a(m paramm)
  {
    AppMethodBeat.i(62865);
    if (paramm == null)
    {
      ab.w("MicroMsg.emoji.EmotionRewardTipStorage", "save failed info is null");
      AppMethodBeat.o(62865);
      return false;
    }
    long l = this.db.replace("EmotionRewardTipInfo", "prodcutID", paramm.convertTo());
    if (l > 0L) {
      ab.i("MicroMsg.emoji.EmotionRewardTipStorage", "save success");
    }
    while (l > 0L)
    {
      AppMethodBeat.o(62865);
      return true;
      ab.i("MicroMsg.emoji.EmotionRewardTipStorage", "save failed");
    }
    AppMethodBeat.o(62865);
    return false;
  }
  
  /* Error */
  public final m dzF()
  {
    // Byte code:
    //   0: ldc 87
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 50	com/tencent/mm/storage/emotion/n:db	Lcom/tencent/mm/sdk/e/e;
    //   9: ldc 89
    //   11: iconst_0
    //   12: anewarray 22	java/lang/String
    //   15: iconst_2
    //   16: invokeinterface 92 4 0
    //   21: astore_2
    //   22: aload_2
    //   23: ifnull +48 -> 71
    //   26: aload_2
    //   27: astore_1
    //   28: aload_2
    //   29: invokeinterface 98 1 0
    //   34: ifeq +37 -> 71
    //   37: aload_2
    //   38: astore_1
    //   39: new 24	com/tencent/mm/storage/emotion/m
    //   42: dup
    //   43: invokespecial 100	com/tencent/mm/storage/emotion/m:<init>	()V
    //   46: astore_3
    //   47: aload_2
    //   48: astore_1
    //   49: aload_3
    //   50: aload_2
    //   51: invokevirtual 104	com/tencent/mm/storage/emotion/m:convertFrom	(Landroid/database/Cursor;)V
    //   54: aload_2
    //   55: ifnull +9 -> 64
    //   58: aload_2
    //   59: invokeinterface 107 1 0
    //   64: ldc 87
    //   66: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: aload_3
    //   70: areturn
    //   71: aload_2
    //   72: ifnull +9 -> 81
    //   75: aload_2
    //   76: invokeinterface 107 1 0
    //   81: ldc 87
    //   83: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   86: aconst_null
    //   87: areturn
    //   88: astore_3
    //   89: aconst_null
    //   90: astore_2
    //   91: aload_2
    //   92: astore_1
    //   93: ldc 56
    //   95: ldc 109
    //   97: iconst_1
    //   98: anewarray 111	java/lang/Object
    //   101: dup
    //   102: iconst_0
    //   103: aload_3
    //   104: invokestatic 117	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   107: aastore
    //   108: invokestatic 121	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   111: aload_2
    //   112: ifnull -31 -> 81
    //   115: aload_2
    //   116: invokeinterface 107 1 0
    //   121: goto -40 -> 81
    //   124: astore_2
    //   125: aconst_null
    //   126: astore_1
    //   127: aload_1
    //   128: ifnull +9 -> 137
    //   131: aload_1
    //   132: invokeinterface 107 1 0
    //   137: ldc 87
    //   139: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   142: aload_2
    //   143: athrow
    //   144: astore_2
    //   145: goto -18 -> 127
    //   148: astore_3
    //   149: goto -58 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	this	n
    //   27	105	1	localCursor1	android.database.Cursor
    //   21	95	2	localCursor2	android.database.Cursor
    //   124	19	2	localObject1	Object
    //   144	1	2	localObject2	Object
    //   46	24	3	localm	m
    //   88	16	3	localException1	java.lang.Exception
    //   148	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   5	22	88	java/lang/Exception
    //   5	22	124	finally
    //   28	37	144	finally
    //   39	47	144	finally
    //   49	54	144	finally
    //   93	111	144	finally
    //   28	37	148	java/lang/Exception
    //   39	47	148	java/lang/Exception
    //   49	54	148	java/lang/Exception
  }
  
  public final boolean eI(String paramString, int paramInt)
  {
    AppMethodBeat.i(62864);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.emoji.EmotionRewardTipStorage", "product id is null.");
      AppMethodBeat.o(62864);
      return false;
    }
    paramString = "UPDATE EmotionRewardTipInfo SET flag=" + paramInt + ",setFlagTime=" + System.currentTimeMillis() + " WHERE prodcutID='" + paramString + "'";
    boolean bool = this.db.execSQL("EmotionRewardTipInfo", paramString);
    ab.i("MicroMsg.emoji.EmotionRewardTipStorage", "updateFlag result:%b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(62864);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.n
 * JD-Core Version:    0.7.0.1
 */