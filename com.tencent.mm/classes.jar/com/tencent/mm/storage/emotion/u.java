package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.storagebase.g;
import com.tencent.mm.storagebase.g.a;

public final class u
  extends j<SmileyPanelConfigInfo>
  implements g.a
{
  private static final String[] IOr;
  public static final String[] SQL_CREATE;
  public e db;
  
  static
  {
    AppMethodBeat.i(105152);
    SQL_CREATE = new String[] { j.getCreateSQLs(SmileyPanelConfigInfo.info, "SmileyPanelConfigInfo") };
    IOr = new String[] { "position", "key" };
    AppMethodBeat.o(105152);
  }
  
  public u(e parame)
  {
    this(parame, SmileyPanelConfigInfo.info, "SmileyPanelConfigInfo");
  }
  
  private u(e parame, c.a parama, String paramString)
  {
    super(parame, parama, paramString, null);
    this.db = parame;
  }
  
  public final int a(g paramg)
  {
    this.db = paramg;
    return 0;
  }
  
  /* Error */
  public final java.util.ArrayList<SmileyPanelConfigInfo> cgw()
  {
    // Byte code:
    //   0: ldc 64
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 66	java/util/ArrayList
    //   8: dup
    //   9: invokespecial 68	java/util/ArrayList:<init>	()V
    //   12: astore 5
    //   14: aload_0
    //   15: getfield 57	com/tencent/mm/storage/emotion/u:db	Lcom/tencent/mm/sdk/e/e;
    //   18: ldc 31
    //   20: getstatic 43	com/tencent/mm/storage/emotion/u:IOr	[Ljava/lang/String;
    //   23: aconst_null
    //   24: aconst_null
    //   25: aconst_null
    //   26: aconst_null
    //   27: aconst_null
    //   28: iconst_2
    //   29: invokeinterface 73 9 0
    //   34: astore_3
    //   35: aload_3
    //   36: ifnull +56 -> 92
    //   39: aload_3
    //   40: astore_2
    //   41: aload_3
    //   42: invokeinterface 79 1 0
    //   47: ifeq +45 -> 92
    //   50: aload_3
    //   51: astore_2
    //   52: new 25	com/tencent/mm/storage/emotion/SmileyPanelConfigInfo
    //   55: dup
    //   56: invokespecial 80	com/tencent/mm/storage/emotion/SmileyPanelConfigInfo:<init>	()V
    //   59: astore 4
    //   61: aload_3
    //   62: astore_2
    //   63: aload 4
    //   65: aload_3
    //   66: invokevirtual 84	com/tencent/mm/storage/emotion/SmileyPanelConfigInfo:convertFrom	(Landroid/database/Cursor;)V
    //   69: aload_3
    //   70: astore_2
    //   71: aload 5
    //   73: aload 4
    //   75: invokevirtual 88	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   78: pop
    //   79: aload_3
    //   80: astore_2
    //   81: aload_3
    //   82: invokeinterface 91 1 0
    //   87: istore_1
    //   88: iload_1
    //   89: ifne -39 -> 50
    //   92: aload_3
    //   93: ifnull +9 -> 102
    //   96: aload_3
    //   97: invokeinterface 94 1 0
    //   102: ldc 96
    //   104: ldc 98
    //   106: iconst_1
    //   107: anewarray 100	java/lang/Object
    //   110: dup
    //   111: iconst_0
    //   112: aload 5
    //   114: invokevirtual 104	java/util/ArrayList:size	()I
    //   117: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   120: aastore
    //   121: invokestatic 115	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   124: ldc 64
    //   126: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   129: aload 5
    //   131: areturn
    //   132: astore 4
    //   134: aconst_null
    //   135: astore_3
    //   136: aload_3
    //   137: astore_2
    //   138: ldc 96
    //   140: aload 4
    //   142: invokestatic 121	com/tencent/mm/sdk/platformtools/bt:n	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   145: invokestatic 125	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: aload_3
    //   149: ifnull -47 -> 102
    //   152: aload_3
    //   153: invokeinterface 94 1 0
    //   158: goto -56 -> 102
    //   161: astore_3
    //   162: aconst_null
    //   163: astore_2
    //   164: aload_2
    //   165: ifnull +9 -> 174
    //   168: aload_2
    //   169: invokeinterface 94 1 0
    //   174: ldc 64
    //   176: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   179: aload_3
    //   180: athrow
    //   181: astore_3
    //   182: goto -18 -> 164
    //   185: astore 4
    //   187: goto -51 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	this	u
    //   87	2	1	bool	boolean
    //   40	129	2	localCursor1	android.database.Cursor
    //   34	119	3	localCursor2	android.database.Cursor
    //   161	19	3	localObject1	java.lang.Object
    //   181	1	3	localObject2	java.lang.Object
    //   59	15	4	localSmileyPanelConfigInfo	SmileyPanelConfigInfo
    //   132	9	4	localException1	java.lang.Exception
    //   185	1	4	localException2	java.lang.Exception
    //   12	118	5	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   14	35	132	java/lang/Exception
    //   14	35	161	finally
    //   41	50	181	finally
    //   52	61	181	finally
    //   63	69	181	finally
    //   71	79	181	finally
    //   81	88	181	finally
    //   138	148	181	finally
    //   41	50	185	java/lang/Exception
    //   52	61	185	java/lang/Exception
    //   63	69	185	java/lang/Exception
    //   71	79	185	java/lang/Exception
    //   81	88	185	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.u
 * JD-Core Version:    0.7.0.1
 */