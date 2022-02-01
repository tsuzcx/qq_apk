package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.bi;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
  extends MAutoStorage<a>
{
  public static final String[] SQL_CREATE;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(183928);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(a.info, "EmojiDesignerProduct") };
    AppMethodBeat.o(183928);
  }
  
  public b(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, a.info, "EmojiDesignerProduct", null);
    this.db = paramISQLiteDatabase;
  }
  
  public final void a(bi parambi)
  {
    AppMethodBeat.i(183927);
    Object localObject = parambi.mhB;
    this.db.delete("EmojiDesignerProduct", "designerUin=? ", new String[] { localObject });
    parambi = parambi.Eib.iterator();
    while (parambi.hasNext())
    {
      localObject = (a)parambi.next();
      this.db.insert("EmojiDesignerProduct", "", ((a)localObject).convertTo());
    }
    AppMethodBeat.o(183927);
  }
  
  /* Error */
  public final bi aza(int paramInt)
  {
    // Byte code:
    //   0: ldc 109
    //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 54	com/tencent/mm/storage/bi
    //   8: dup
    //   9: invokespecial 110	com/tencent/mm/storage/bi:<init>	()V
    //   12: astore_2
    //   13: aload_2
    //   14: iload_1
    //   15: putfield 58	com/tencent/mm/storage/bi:mhB	I
    //   18: aload_0
    //   19: getfield 45	com/tencent/mm/storage/emotion/b:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   22: ldc 28
    //   24: getstatic 26	com/tencent/mm/storage/emotion/a:info	Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;
    //   27: getfield 115	com/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo:columns	[Ljava/lang/String;
    //   30: ldc 68
    //   32: iconst_1
    //   33: anewarray 20	java/lang/String
    //   36: dup
    //   37: iconst_0
    //   38: iload_1
    //   39: invokestatic 119	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   42: aastore
    //   43: aconst_null
    //   44: aconst_null
    //   45: aconst_null
    //   46: invokeinterface 123 8 0
    //   51: astore_3
    //   52: aload_3
    //   53: ifnull +80 -> 133
    //   56: aload_3
    //   57: invokeinterface 128 1 0
    //   62: ifeq +71 -> 133
    //   65: new 22	com/tencent/mm/storage/emotion/a
    //   68: dup
    //   69: invokespecial 129	com/tencent/mm/storage/emotion/a:<init>	()V
    //   72: astore 4
    //   74: aload 4
    //   76: aload_3
    //   77: invokevirtual 133	com/tencent/mm/storage/emotion/a:convertFrom	(Landroid/database/Cursor;)V
    //   80: aload_2
    //   81: getfield 78	com/tencent/mm/storage/bi:Eib	Ljava/util/LinkedList;
    //   84: aload 4
    //   86: invokevirtual 137	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   89: pop
    //   90: goto -34 -> 56
    //   93: astore 4
    //   95: aload_3
    //   96: ifnull +9 -> 105
    //   99: aload_3
    //   100: invokeinterface 140 1 0
    //   105: ldc 109
    //   107: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: aload 4
    //   112: athrow
    //   113: astore_3
    //   114: ldc 142
    //   116: aload_3
    //   117: ldc 96
    //   119: iconst_0
    //   120: anewarray 144	java/lang/Object
    //   123: invokestatic 150	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   126: ldc 109
    //   128: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   131: aload_2
    //   132: areturn
    //   133: aload_3
    //   134: ifnull -8 -> 126
    //   137: aload_3
    //   138: invokeinterface 140 1 0
    //   143: goto -17 -> 126
    //   146: astore_3
    //   147: aload 4
    //   149: aload_3
    //   150: invokevirtual 156	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   153: goto -48 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	this	b
    //   0	156	1	paramInt	int
    //   12	120	2	localbi	bi
    //   51	49	3	localCursor	android.database.Cursor
    //   113	25	3	localException	java.lang.Exception
    //   146	4	3	localThrowable	java.lang.Throwable
    //   72	13	4	locala	a
    //   93	55	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   56	90	93	finally
    //   18	52	113	java/lang/Exception
    //   105	113	113	java/lang/Exception
    //   137	143	113	java/lang/Exception
    //   147	153	113	java/lang/Exception
    //   99	105	146	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.b
 * JD-Core Version:    0.7.0.1
 */