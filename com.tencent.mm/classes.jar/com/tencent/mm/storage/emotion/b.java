package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.bg;
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
  
  public final void a(bg parambg)
  {
    AppMethodBeat.i(183927);
    Object localObject = parambg.jHU;
    this.db.delete("EmojiDesignerProduct", "designerUin=? ", new String[] { localObject });
    parambg = parambg.ziJ.iterator();
    while (parambg.hasNext())
    {
      localObject = (a)parambg.next();
      this.db.insert("EmojiDesignerProduct", "", ((a)localObject).convertTo());
    }
    AppMethodBeat.o(183927);
  }
  
  /* Error */
  public final bg asK(int paramInt)
  {
    // Byte code:
    //   0: ldc 111
    //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 54	com/tencent/mm/storage/bg
    //   8: dup
    //   9: invokespecial 112	com/tencent/mm/storage/bg:<init>	()V
    //   12: astore 4
    //   14: aload 4
    //   16: iload_1
    //   17: putfield 58	com/tencent/mm/storage/bg:jHU	I
    //   20: aload_0
    //   21: getfield 45	com/tencent/mm/storage/emotion/b:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   24: ldc 28
    //   26: getstatic 26	com/tencent/mm/storage/emotion/a:info	Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;
    //   29: getfield 117	com/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo:columns	[Ljava/lang/String;
    //   32: ldc 68
    //   34: iconst_1
    //   35: anewarray 20	java/lang/String
    //   38: dup
    //   39: iconst_0
    //   40: iload_1
    //   41: invokestatic 121	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   44: aastore
    //   45: aconst_null
    //   46: aconst_null
    //   47: aconst_null
    //   48: invokeinterface 125 8 0
    //   53: astore 5
    //   55: aload 5
    //   57: ifnull +93 -> 150
    //   60: aload 5
    //   62: invokeinterface 130 1 0
    //   67: ifeq +83 -> 150
    //   70: new 22	com/tencent/mm/storage/emotion/a
    //   73: dup
    //   74: invokespecial 131	com/tencent/mm/storage/emotion/a:<init>	()V
    //   77: astore_2
    //   78: aload_2
    //   79: aload 5
    //   81: invokevirtual 135	com/tencent/mm/storage/emotion/a:convertFrom	(Landroid/database/Cursor;)V
    //   84: aload 4
    //   86: getfield 78	com/tencent/mm/storage/bg:ziJ	Ljava/util/LinkedList;
    //   89: aload_2
    //   90: invokevirtual 139	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   93: pop
    //   94: goto -34 -> 60
    //   97: astore_3
    //   98: ldc 111
    //   100: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: aload_3
    //   104: athrow
    //   105: astore_2
    //   106: aload 5
    //   108: ifnull +14 -> 122
    //   111: aload_3
    //   112: ifnull +64 -> 176
    //   115: aload 5
    //   117: invokeinterface 142 1 0
    //   122: ldc 111
    //   124: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: aload_2
    //   128: athrow
    //   129: astore_2
    //   130: ldc 144
    //   132: aload_2
    //   133: ldc 96
    //   135: iconst_0
    //   136: anewarray 146	java/lang/Object
    //   139: invokestatic 152	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   142: ldc 111
    //   144: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   147: aload 4
    //   149: areturn
    //   150: aload 5
    //   152: ifnull -10 -> 142
    //   155: aload 5
    //   157: invokeinterface 142 1 0
    //   162: goto -20 -> 142
    //   165: astore 5
    //   167: aload_3
    //   168: aload 5
    //   170: invokevirtual 156	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   173: goto -51 -> 122
    //   176: aload 5
    //   178: invokeinterface 142 1 0
    //   183: goto -61 -> 122
    //   186: astore_2
    //   187: aconst_null
    //   188: astore_3
    //   189: goto -83 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	this	b
    //   0	192	1	paramInt	int
    //   77	13	2	locala	a
    //   105	23	2	localObject1	Object
    //   129	4	2	localException	java.lang.Exception
    //   186	1	2	localObject2	Object
    //   97	71	3	localThrowable1	java.lang.Throwable
    //   188	1	3	localObject3	Object
    //   12	136	4	localbg	bg
    //   53	103	5	localCursor	android.database.Cursor
    //   165	12	5	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   60	94	97	java/lang/Throwable
    //   98	105	105	finally
    //   20	55	129	java/lang/Exception
    //   115	122	129	java/lang/Exception
    //   122	129	129	java/lang/Exception
    //   155	162	129	java/lang/Exception
    //   167	173	129	java/lang/Exception
    //   176	183	129	java/lang/Exception
    //   115	122	165	java/lang/Throwable
    //   60	94	186	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.b
 * JD-Core Version:    0.7.0.1
 */