package com.tencent.mm.storage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/storage/file/FileMsgInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/storage/file/FileMsgInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "getFileMsgInfo", "msgSvrId", "", "getFileMsgInfoByOverwriteMsgId", "overwriteNewMsgId", "insert", "", "item", "Companion", "plugin-messenger-foundation_release"})
public final class b
  extends MAutoStorage<a>
{
  private static final String Alf = "FileMsgInfo";
  private static final String[] INDEX_CREATE;
  private static final String[] SQL_CREATE;
  private static final String TAG = "MicroMsg.FileMsgInfoStorage";
  private static final String VIR = "FileMsgInfo_";
  private static final String VIS = "overwriteNewMsgIdIndex";
  public static final b.a VIT;
  private final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(189203);
    VIT = new b.a((byte)0);
    TAG = "MicroMsg.FileMsgInfoStorage";
    Alf = "FileMsgInfo";
    VIR = Alf + "_";
    VIS = "overwriteNewMsgIdIndex";
    a.a locala = a.VIQ;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(a.access$getInfo$cp(), Alf) };
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS " + VIR + VIS + " ON " + Alf + " ( overwriteNewMsgId )" };
    AppMethodBeat.o(189203);
  }
  
  public b(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, a.access$getInfo$cp(), Alf, INDEX_CREATE);
    AppMethodBeat.i(189199);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(189199);
  }
  
  /* Error */
  public final a UZ(long paramLong)
  {
    // Byte code:
    //   0: ldc 140
    //   2: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: lload_1
    //   6: lconst_0
    //   7: lcmp
    //   8: ifne +10 -> 18
    //   11: ldc 140
    //   13: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: aconst_null
    //   17: areturn
    //   18: aload_0
    //   19: getfield 132	com/tencent/mm/storage/a/b:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   22: astore_3
    //   23: getstatic 68	com/tencent/mm/storage/a/b:Alf	Ljava/lang/String;
    //   26: astore 4
    //   28: getstatic 92	com/tencent/mm/storage/a/a:VIQ	Lcom/tencent/mm/storage/a/a$a;
    //   31: astore 5
    //   33: aload_3
    //   34: aload 4
    //   36: invokestatic 98	com/tencent/mm/storage/a/a:access$getInfo$cp	()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;
    //   39: getfield 145	com/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo:columns	[Ljava/lang/String;
    //   42: ldc 147
    //   44: iconst_1
    //   45: anewarray 94	java/lang/String
    //   48: dup
    //   49: iconst_0
    //   50: lload_1
    //   51: invokestatic 151	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   54: aastore
    //   55: aconst_null
    //   56: aconst_null
    //   57: aconst_null
    //   58: invokeinterface 157 8 0
    //   63: astore 4
    //   65: new 159	java/util/ArrayList
    //   68: dup
    //   69: invokespecial 160	java/util/ArrayList:<init>	()V
    //   72: checkcast 162	java/util/List
    //   75: astore_3
    //   76: aload 4
    //   78: invokeinterface 168 1 0
    //   83: ifeq +76 -> 159
    //   86: new 88	com/tencent/mm/storage/a/a
    //   89: dup
    //   90: invokespecial 169	com/tencent/mm/storage/a/a:<init>	()V
    //   93: astore 5
    //   95: aload 5
    //   97: aload 4
    //   99: invokevirtual 173	com/tencent/mm/storage/a/a:convertFrom	(Landroid/database/Cursor;)V
    //   102: aload_3
    //   103: aload 5
    //   105: invokeinterface 177 2 0
    //   110: pop
    //   111: goto -35 -> 76
    //   114: astore_3
    //   115: getstatic 66	com/tencent/mm/storage/a/b:TAG	Ljava/lang/String;
    //   118: new 70	java/lang/StringBuilder
    //   121: dup
    //   122: ldc 179
    //   124: invokespecial 109	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   127: aload_3
    //   128: invokevirtual 182	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   131: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 188	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   140: aload 4
    //   142: ifnull +10 -> 152
    //   145: aload 4
    //   147: invokeinterface 191 1 0
    //   152: ldc 140
    //   154: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   157: aconst_null
    //   158: areturn
    //   159: aload_3
    //   160: invokeinterface 195 1 0
    //   165: ifle +33 -> 198
    //   168: aload_3
    //   169: iconst_0
    //   170: invokeinterface 199 2 0
    //   175: checkcast 88	com/tencent/mm/storage/a/a
    //   178: astore_3
    //   179: aload 4
    //   181: ifnull +10 -> 191
    //   184: aload 4
    //   186: invokeinterface 191 1 0
    //   191: ldc 140
    //   193: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   196: aload_3
    //   197: areturn
    //   198: aconst_null
    //   199: astore_3
    //   200: goto -21 -> 179
    //   203: astore_3
    //   204: aload 4
    //   206: ifnull +10 -> 216
    //   209: aload 4
    //   211: invokeinterface 191 1 0
    //   216: ldc 140
    //   218: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   221: aload_3
    //   222: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	this	b
    //   0	223	1	paramLong	long
    //   22	81	3	localObject1	java.lang.Object
    //   114	55	3	localException	java.lang.Exception
    //   178	22	3	locala	a
    //   203	19	3	localObject2	java.lang.Object
    //   26	184	4	localObject3	java.lang.Object
    //   31	73	5	localObject4	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   65	76	114	java/lang/Exception
    //   76	111	114	java/lang/Exception
    //   159	179	114	java/lang/Exception
    //   65	76	203	finally
    //   76	111	203	finally
    //   115	140	203	finally
    //   159	179	203	finally
  }
  
  /* Error */
  public final a Va(long paramLong)
  {
    // Byte code:
    //   0: ldc 201
    //   2: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: lload_1
    //   6: lconst_0
    //   7: lcmp
    //   8: ifne +10 -> 18
    //   11: ldc 201
    //   13: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: aconst_null
    //   17: areturn
    //   18: aload_0
    //   19: getfield 132	com/tencent/mm/storage/a/b:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   22: astore_3
    //   23: getstatic 68	com/tencent/mm/storage/a/b:Alf	Ljava/lang/String;
    //   26: astore 4
    //   28: getstatic 92	com/tencent/mm/storage/a/a:VIQ	Lcom/tencent/mm/storage/a/a$a;
    //   31: astore 5
    //   33: aload_3
    //   34: aload 4
    //   36: invokestatic 98	com/tencent/mm/storage/a/a:access$getInfo$cp	()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;
    //   39: getfield 145	com/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo:columns	[Ljava/lang/String;
    //   42: ldc 203
    //   44: iconst_1
    //   45: anewarray 94	java/lang/String
    //   48: dup
    //   49: iconst_0
    //   50: lload_1
    //   51: invokestatic 151	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   54: aastore
    //   55: aconst_null
    //   56: aconst_null
    //   57: aconst_null
    //   58: invokeinterface 157 8 0
    //   63: astore 4
    //   65: new 159	java/util/ArrayList
    //   68: dup
    //   69: invokespecial 160	java/util/ArrayList:<init>	()V
    //   72: checkcast 162	java/util/List
    //   75: astore_3
    //   76: aload 4
    //   78: invokeinterface 168 1 0
    //   83: ifeq +76 -> 159
    //   86: new 88	com/tencent/mm/storage/a/a
    //   89: dup
    //   90: invokespecial 169	com/tencent/mm/storage/a/a:<init>	()V
    //   93: astore 5
    //   95: aload 5
    //   97: aload 4
    //   99: invokevirtual 173	com/tencent/mm/storage/a/a:convertFrom	(Landroid/database/Cursor;)V
    //   102: aload_3
    //   103: aload 5
    //   105: invokeinterface 177 2 0
    //   110: pop
    //   111: goto -35 -> 76
    //   114: astore_3
    //   115: getstatic 66	com/tencent/mm/storage/a/b:TAG	Ljava/lang/String;
    //   118: new 70	java/lang/StringBuilder
    //   121: dup
    //   122: ldc 205
    //   124: invokespecial 109	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   127: aload_3
    //   128: invokevirtual 182	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   131: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 188	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   140: aload 4
    //   142: ifnull +10 -> 152
    //   145: aload 4
    //   147: invokeinterface 191 1 0
    //   152: ldc 201
    //   154: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   157: aconst_null
    //   158: areturn
    //   159: aload_3
    //   160: invokeinterface 195 1 0
    //   165: ifle +33 -> 198
    //   168: aload_3
    //   169: iconst_0
    //   170: invokeinterface 199 2 0
    //   175: checkcast 88	com/tencent/mm/storage/a/a
    //   178: astore_3
    //   179: aload 4
    //   181: ifnull +10 -> 191
    //   184: aload 4
    //   186: invokeinterface 191 1 0
    //   191: ldc 201
    //   193: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   196: aload_3
    //   197: areturn
    //   198: aconst_null
    //   199: astore_3
    //   200: goto -21 -> 179
    //   203: astore_3
    //   204: aload 4
    //   206: ifnull +10 -> 216
    //   209: aload 4
    //   211: invokeinterface 191 1 0
    //   216: ldc 201
    //   218: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   221: aload_3
    //   222: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	this	b
    //   0	223	1	paramLong	long
    //   22	81	3	localObject1	java.lang.Object
    //   114	55	3	localException	java.lang.Exception
    //   178	22	3	locala	a
    //   203	19	3	localObject2	java.lang.Object
    //   26	184	4	localObject3	java.lang.Object
    //   31	73	5	localObject4	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   65	76	114	java/lang/Exception
    //   76	111	114	java/lang/Exception
    //   159	179	114	java/lang/Exception
    //   65	76	203	finally
    //   76	111	203	finally
    //   115	140	203	finally
    //   159	179	203	finally
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(189195);
    if (parama == null)
    {
      AppMethodBeat.o(189195);
      return false;
    }
    boolean bool = super.insert((IAutoDBItem)parama);
    AppMethodBeat.o(189195);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.a.b
 * JD-Core Version:    0.7.0.1
 */