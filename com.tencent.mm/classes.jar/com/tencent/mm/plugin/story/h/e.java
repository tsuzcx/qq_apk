package com.tencent.mm.plugin.story.h;

import a.l;
import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ev;
import com.tencent.mm.sdk.e.c.a;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/storage/StoryEditorDataStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/story/storage/StoryEditorData;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "cleanDirtyData", "", "cleanNullData", "timeStamp", "", "getAllDataIfNoMix", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getByLocalId", "localId", "getByTimeStamp", "getLastDataIfNoMix", "updateByLocal", "id", "editorData", "Companion", "plugin-story_release"})
public final class e
  extends com.tencent.mm.sdk.e.j<d>
{
  private static final String[] sGv;
  public static final e.a sGw;
  public final com.tencent.mm.sdk.e.e db;
  
  static
  {
    AppMethodBeat.i(109869);
    sGw = new e.a((byte)0);
    d.a locala = d.sGu;
    sGv = new String[] { com.tencent.mm.sdk.e.j.getCreateSQLs(d.cEM(), "StoryEditorInfo") };
    AppMethodBeat.o(109869);
  }
  
  public e(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, d.cEM(), "StoryEditorInfo", ev.INDEX_CREATE);
    AppMethodBeat.i(109868);
    this.db = parame;
    AppMethodBeat.o(109868);
  }
  
  public final long b(long paramLong, d paramd)
  {
    AppMethodBeat.i(109866);
    a.f.b.j.q(paramd, "editorData");
    paramd = paramd.convertTo();
    paramd.remove("rowid");
    paramLong = this.db.update("StoryEditorInfo", paramd, "rowid=?", new String[] { String.valueOf(paramLong) });
    AppMethodBeat.o(109866);
    return paramLong;
  }
  
  /* Error */
  public final d cEO()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: ldc 136
    //   5: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 142	com/tencent/mm/model/cb:abq	()J
    //   11: lstore_1
    //   12: getstatic 148	com/tencent/mm/plugin/story/model/i:suJ	Lcom/tencent/mm/plugin/story/model/i$a;
    //   15: astore 5
    //   17: invokestatic 152	com/tencent/mm/plugin/story/model/i:cAp	()I
    //   20: sipush 1000
    //   23: imul
    //   24: i2l
    //   25: lstore_3
    //   26: new 154	java/lang/StringBuilder
    //   29: dup
    //   30: ldc 156
    //   32: invokespecial 158	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   35: astore 5
    //   37: getstatic 164	com/tencent/mm/plugin/story/h/a$e:sGg	Lcom/tencent/mm/plugin/story/h/a$e;
    //   40: astore 7
    //   42: aload 5
    //   44: invokestatic 167	com/tencent/mm/plugin/story/h/a$e:cEB	()I
    //   47: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   50: ldc 173
    //   52: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: lload_1
    //   56: lload_3
    //   57: lsub
    //   58: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   61: ldc 181
    //   63: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: astore 5
    //   71: aload_0
    //   72: getfield 101	com/tencent/mm/plugin/story/h/e:db	Lcom/tencent/mm/sdk/e/e;
    //   75: aload 5
    //   77: aconst_null
    //   78: invokeinterface 189 3 0
    //   83: astore 5
    //   85: aload 5
    //   87: ifnull +61 -> 148
    //   90: aload 5
    //   92: checkcast 191	java/io/Closeable
    //   95: astore 7
    //   97: aload 5
    //   99: invokeinterface 197 1 0
    //   104: ifeq +33 -> 137
    //   107: new 60	com/tencent/mm/plugin/story/h/d
    //   110: dup
    //   111: invokespecial 199	com/tencent/mm/plugin/story/h/d:<init>	()V
    //   114: astore 8
    //   116: aload 8
    //   118: aload 5
    //   120: invokevirtual 203	com/tencent/mm/plugin/story/h/d:convertFrom	(Landroid/database/Cursor;)V
    //   123: aload 7
    //   125: aconst_null
    //   126: invokestatic 209	a/e/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   129: ldc 136
    //   131: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   134: aload 8
    //   136: areturn
    //   137: getstatic 215	a/y:BMg	La/y;
    //   140: astore 5
    //   142: aload 7
    //   144: aconst_null
    //   145: invokestatic 209	a/e/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   148: ldc 136
    //   150: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   153: aconst_null
    //   154: areturn
    //   155: astore 6
    //   157: ldc 136
    //   159: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   162: aload 6
    //   164: athrow
    //   165: astore 5
    //   167: aload 7
    //   169: aload 6
    //   171: invokestatic 209	a/e/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   174: ldc 136
    //   176: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   179: aload 5
    //   181: athrow
    //   182: astore 5
    //   184: goto -17 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	this	e
    //   11	45	1	l1	long
    //   25	32	3	l2	long
    //   15	126	5	localObject1	Object
    //   165	15	5	localObject2	Object
    //   182	1	5	localObject3	Object
    //   1	1	6	localObject4	Object
    //   155	15	6	localThrowable	java.lang.Throwable
    //   40	128	7	localObject5	Object
    //   114	21	8	locald	d
    // Exception table:
    //   from	to	target	type
    //   97	123	155	java/lang/Throwable
    //   137	142	155	java/lang/Throwable
    //   157	165	165	finally
    //   97	123	182	finally
    //   137	142	182	finally
  }
  
  public final d mQ(long paramLong)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(109865);
    Object localObject3 = this.db;
    d.a locala = d.sGu;
    localObject3 = ((com.tencent.mm.sdk.e.e)localObject3).query("StoryEditorInfo", d.cEM().columns, "rowid=".concat(String.valueOf(paramLong)), null, null, null, null);
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if (((Cursor)localObject3).moveToFirst())
      {
        localObject1 = new d();
        ((d)localObject1).convertFrom((Cursor)localObject3);
      }
      ((Cursor)localObject3).close();
    }
    AppMethodBeat.o(109865);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.e
 * JD-Core Version:    0.7.0.1
 */