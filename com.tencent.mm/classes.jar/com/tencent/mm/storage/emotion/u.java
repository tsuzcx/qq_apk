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
  private static final String[] Hbb;
  public static final String[] SQL_CREATE;
  public e db;
  
  static
  {
    AppMethodBeat.i(105152);
    SQL_CREATE = new String[] { j.getCreateSQLs(SmileyPanelConfigInfo.info, "SmileyPanelConfigInfo") };
    Hbb = new String[] { "position", "key" };
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
  public final java.util.ArrayList<SmileyPanelConfigInfo> cbS()
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
    //   20: getstatic 43	com/tencent/mm/storage/emotion/u:Hbb	[Ljava/lang/String;
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
    //   102: ldc 64
    //   104: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload 5
    //   109: areturn
    //   110: astore 4
    //   112: aconst_null
    //   113: astore_3
    //   114: aload_3
    //   115: astore_2
    //   116: ldc 96
    //   118: aload 4
    //   120: invokestatic 102	com/tencent/mm/sdk/platformtools/bs:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   123: invokestatic 108	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: aload_3
    //   127: ifnull -25 -> 102
    //   130: aload_3
    //   131: invokeinterface 94 1 0
    //   136: goto -34 -> 102
    //   139: astore_3
    //   140: aconst_null
    //   141: astore_2
    //   142: aload_2
    //   143: ifnull +9 -> 152
    //   146: aload_2
    //   147: invokeinterface 94 1 0
    //   152: ldc 64
    //   154: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   157: aload_3
    //   158: athrow
    //   159: astore_3
    //   160: goto -18 -> 142
    //   163: astore 4
    //   165: goto -51 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	this	u
    //   87	2	1	bool	boolean
    //   40	107	2	localCursor1	android.database.Cursor
    //   34	97	3	localCursor2	android.database.Cursor
    //   139	19	3	localObject1	java.lang.Object
    //   159	1	3	localObject2	java.lang.Object
    //   59	15	4	localSmileyPanelConfigInfo	SmileyPanelConfigInfo
    //   110	9	4	localException1	java.lang.Exception
    //   163	1	4	localException2	java.lang.Exception
    //   12	96	5	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   14	35	110	java/lang/Exception
    //   14	35	139	finally
    //   41	50	159	finally
    //   52	61	159	finally
    //   63	69	159	finally
    //   71	79	159	finally
    //   81	88	159	finally
    //   116	126	159	finally
    //   41	50	163	java/lang/Exception
    //   52	61	163	java/lang/Exception
    //   63	69	163	java/lang/Exception
    //   71	79	163	java/lang/Exception
    //   81	88	163	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.u
 * JD-Core Version:    0.7.0.1
 */