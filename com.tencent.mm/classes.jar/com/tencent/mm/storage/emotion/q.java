package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.g;
import com.tencent.mm.cg.g.a;
import com.tencent.mm.cg.h;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;

public final class q
  extends j<SmileyInfo>
  implements g.a
{
  public static final String[] SQL_CREATE;
  private static final String[] yQc;
  private static final String[] yQd;
  private e db;
  
  static
  {
    AppMethodBeat.i(62886);
    SQL_CREATE = new String[] { j.getCreateSQLs(SmileyInfo.info, "SmileyInfo") };
    yQc = new String[] { "key", "cnValue", "qqValue", "enValue", "twValue", "thValue", "eggIndex", "fileName" };
    yQd = new String[] { "key" };
    AppMethodBeat.o(62886);
  }
  
  public q(e parame)
  {
    this(parame, SmileyInfo.info, "SmileyInfo");
  }
  
  private q(e parame, c.a parama, String paramString)
  {
    super(parame, parama, paramString, null);
    this.db = parame;
  }
  
  public final int a(g paramg)
  {
    this.db = paramg;
    return 0;
  }
  
  public final boolean ao(ArrayList<SmileyInfo> paramArrayList)
  {
    AppMethodBeat.i(62885);
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      ab.i("MicroMsg.emoji.NewSmileyInfoStorage", "insertSmileyInfoList failed. list is null.");
      AppMethodBeat.o(62885);
      return false;
    }
    h localh;
    long l;
    if ((this.db instanceof h))
    {
      localh = (h)this.db;
      l = localh.kr(Thread.currentThread().getId());
    }
    for (;;)
    {
      this.db.delete("SmileyInfo", null, null);
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        insert((SmileyInfo)paramArrayList.next());
      }
      int i = -1;
      if (localh != null) {
        i = localh.nY(l);
      }
      if (i >= 0)
      {
        AppMethodBeat.o(62885);
        return true;
      }
      AppMethodBeat.o(62885);
      return false;
      l = -1L;
      localh = null;
    }
  }
  
  /* Error */
  public final ArrayList<SmileyInfo> bkU()
  {
    // Byte code:
    //   0: ldc 145
    //   2: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 79	java/util/ArrayList
    //   8: dup
    //   9: invokespecial 147	java/util/ArrayList:<init>	()V
    //   12: astore 5
    //   14: aload_0
    //   15: getfield 72	com/tencent/mm/storage/emotion/q:db	Lcom/tencent/mm/sdk/e/e;
    //   18: ldc 32
    //   20: getstatic 56	com/tencent/mm/storage/emotion/q:yQc	[Ljava/lang/String;
    //   23: ldc 149
    //   25: iconst_1
    //   26: anewarray 24	java/lang/String
    //   29: dup
    //   30: iconst_0
    //   31: ldc 151
    //   33: aastore
    //   34: aconst_null
    //   35: aconst_null
    //   36: aconst_null
    //   37: iconst_2
    //   38: invokeinterface 154 9 0
    //   43: astore_3
    //   44: aload_3
    //   45: ifnull +64 -> 109
    //   48: aload_3
    //   49: astore_2
    //   50: aload_3
    //   51: invokeinterface 159 1 0
    //   56: ifeq +53 -> 109
    //   59: aload_3
    //   60: astore_2
    //   61: new 26	com/tencent/mm/storage/emotion/SmileyInfo
    //   64: dup
    //   65: invokespecial 160	com/tencent/mm/storage/emotion/SmileyInfo:<init>	()V
    //   68: astore 4
    //   70: aload_3
    //   71: astore_2
    //   72: aload 4
    //   74: aload_3
    //   75: invokevirtual 164	com/tencent/mm/storage/emotion/SmileyInfo:convertFrom	(Landroid/database/Cursor;)V
    //   78: aload_3
    //   79: astore_2
    //   80: aload 4
    //   82: iconst_m1
    //   83: putfield 168	com/tencent/mm/storage/emotion/SmileyInfo:field_position	I
    //   86: aload_3
    //   87: astore_2
    //   88: aload 5
    //   90: aload 4
    //   92: invokevirtual 172	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   95: pop
    //   96: aload_3
    //   97: astore_2
    //   98: aload_3
    //   99: invokeinterface 175 1 0
    //   104: istore_1
    //   105: iload_1
    //   106: ifne -47 -> 59
    //   109: aload_3
    //   110: ifnull +9 -> 119
    //   113: aload_3
    //   114: invokeinterface 178 1 0
    //   119: ldc 145
    //   121: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   124: aload 5
    //   126: areturn
    //   127: astore 4
    //   129: aconst_null
    //   130: astore_3
    //   131: aload_3
    //   132: astore_2
    //   133: ldc 85
    //   135: aload 4
    //   137: invokestatic 184	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   140: invokestatic 187	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   143: aload_3
    //   144: ifnull -25 -> 119
    //   147: aload_3
    //   148: invokeinterface 178 1 0
    //   153: goto -34 -> 119
    //   156: astore_3
    //   157: aconst_null
    //   158: astore_2
    //   159: aload_2
    //   160: ifnull +9 -> 169
    //   163: aload_2
    //   164: invokeinterface 178 1 0
    //   169: ldc 145
    //   171: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   174: aload_3
    //   175: athrow
    //   176: astore_3
    //   177: goto -18 -> 159
    //   180: astore 4
    //   182: goto -51 -> 131
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	q
    //   104	2	1	bool	boolean
    //   49	115	2	localCursor1	android.database.Cursor
    //   43	105	3	localCursor2	android.database.Cursor
    //   156	19	3	localObject1	java.lang.Object
    //   176	1	3	localObject2	java.lang.Object
    //   68	23	4	localSmileyInfo	SmileyInfo
    //   127	9	4	localException1	java.lang.Exception
    //   180	1	4	localException2	java.lang.Exception
    //   12	113	5	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   14	44	127	java/lang/Exception
    //   14	44	156	finally
    //   50	59	176	finally
    //   61	70	176	finally
    //   72	78	176	finally
    //   80	86	176	finally
    //   88	96	176	finally
    //   98	105	176	finally
    //   133	143	176	finally
    //   50	59	180	java/lang/Exception
    //   61	70	180	java/lang/Exception
    //   72	78	180	java/lang/Exception
    //   80	86	180	java/lang/Exception
    //   88	96	180	java/lang/Exception
    //   98	105	180	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.q
 * JD-Core Version:    0.7.0.1
 */