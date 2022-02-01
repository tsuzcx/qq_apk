package com.tencent.mm.storage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/storage/file/FileMsgInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/storage/file/FileMsgInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "getFileMsgInfo", "msgSvrId", "", "getFileMsgInfoByOverwriteMsgId", "overwriteNewMsgId", "insert", "", "item", "Companion", "plugin-messenger-foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends MAutoStorage<a>
{
  private static final String[] INDEX_CREATE;
  private static final String[] SQL_CREATE;
  private static final String TAG;
  public static final a admP;
  private static final String admQ;
  private static final String admR;
  private static final String ptT;
  private final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(248866);
    admP = new a((byte)0);
    TAG = "MicroMsg.FileMsgInfoStorage";
    ptT = "FileMsgInfo";
    admQ = s.X("FileMsgInfo", "_");
    admR = "overwriteNewMsgIdIndex";
    a.a locala = a.admO;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(a.access$getInfo$cp(), ptT) };
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS " + admQ + admR + " ON " + ptT + " ( overwriteNewMsgId )" };
    AppMethodBeat.o(248866);
  }
  
  public b(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, a.access$getInfo$cp(), ptT, INDEX_CREATE);
    AppMethodBeat.i(248852);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(248852);
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(248893);
    if (parama == null)
    {
      AppMethodBeat.o(248893);
      return false;
    }
    boolean bool = super.insert((IAutoDBItem)parama);
    AppMethodBeat.o(248893);
    return bool;
  }
  
  /* Error */
  public final a zg(long paramLong)
  {
    // Byte code:
    //   0: ldc 154
    //   2: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: lload_1
    //   6: lconst_0
    //   7: lcmp
    //   8: ifne +10 -> 18
    //   11: ldc 154
    //   13: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: aconst_null
    //   17: areturn
    //   18: aload_0
    //   19: getfield 136	com/tencent/mm/storage/a/b:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   22: astore_3
    //   23: getstatic 68	com/tencent/mm/storage/a/b:ptT	Ljava/lang/String;
    //   26: astore 4
    //   28: getstatic 88	com/tencent/mm/storage/a/a:admO	Lcom/tencent/mm/storage/a/a$a;
    //   31: astore 5
    //   33: aload_3
    //   34: aload 4
    //   36: invokestatic 94	com/tencent/mm/storage/a/a:access$getInfo$cp	()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;
    //   39: getfield 159	com/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo:columns	[Ljava/lang/String;
    //   42: ldc 161
    //   44: iconst_1
    //   45: anewarray 90	java/lang/String
    //   48: dup
    //   49: iconst_0
    //   50: lload_1
    //   51: invokestatic 165	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   54: aastore
    //   55: aconst_null
    //   56: aconst_null
    //   57: aconst_null
    //   58: invokeinterface 171 8 0
    //   63: astore 4
    //   65: new 173	java/util/ArrayList
    //   68: dup
    //   69: invokespecial 175	java/util/ArrayList:<init>	()V
    //   72: checkcast 177	java/util/List
    //   75: astore_3
    //   76: aload 4
    //   78: invokeinterface 183 1 0
    //   83: ifeq +66 -> 149
    //   86: new 84	com/tencent/mm/storage/a/a
    //   89: dup
    //   90: invokespecial 184	com/tencent/mm/storage/a/a:<init>	()V
    //   93: astore 5
    //   95: aload 5
    //   97: aload 4
    //   99: invokevirtual 188	com/tencent/mm/storage/a/a:convertFrom	(Landroid/database/Cursor;)V
    //   102: aload_3
    //   103: aload 5
    //   105: invokeinterface 192 2 0
    //   110: pop
    //   111: goto -35 -> 76
    //   114: astore_3
    //   115: getstatic 64	com/tencent/mm/storage/a/b:TAG	Ljava/lang/String;
    //   118: ldc 194
    //   120: aload_3
    //   121: invokevirtual 197	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   124: invokestatic 76	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   127: invokestatic 203	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: aload 4
    //   132: ifnull +10 -> 142
    //   135: aload 4
    //   137: invokeinterface 206 1 0
    //   142: ldc 154
    //   144: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   147: aconst_null
    //   148: areturn
    //   149: aload_3
    //   150: invokeinterface 210 1 0
    //   155: ifle +33 -> 188
    //   158: aload_3
    //   159: iconst_0
    //   160: invokeinterface 214 2 0
    //   165: checkcast 84	com/tencent/mm/storage/a/a
    //   168: astore_3
    //   169: aload 4
    //   171: ifnull +10 -> 181
    //   174: aload 4
    //   176: invokeinterface 206 1 0
    //   181: ldc 154
    //   183: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   186: aload_3
    //   187: areturn
    //   188: aconst_null
    //   189: astore_3
    //   190: goto -21 -> 169
    //   193: astore_3
    //   194: aload 4
    //   196: ifnull +10 -> 206
    //   199: aload 4
    //   201: invokeinterface 206 1 0
    //   206: ldc 154
    //   208: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   211: aload_3
    //   212: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	this	b
    //   0	213	1	paramLong	long
    //   22	81	3	localObject1	Object
    //   114	45	3	localException	java.lang.Exception
    //   168	22	3	locala	a
    //   193	19	3	localObject2	Object
    //   26	174	4	localObject3	Object
    //   31	73	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   65	76	114	java/lang/Exception
    //   76	111	114	java/lang/Exception
    //   149	169	114	java/lang/Exception
    //   65	76	193	finally
    //   76	111	193	finally
    //   115	130	193	finally
    //   149	169	193	finally
  }
  
  /* Error */
  public final a zh(long paramLong)
  {
    // Byte code:
    //   0: ldc 216
    //   2: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: lload_1
    //   6: lconst_0
    //   7: lcmp
    //   8: ifne +10 -> 18
    //   11: ldc 216
    //   13: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: aconst_null
    //   17: areturn
    //   18: aload_0
    //   19: getfield 136	com/tencent/mm/storage/a/b:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   22: astore_3
    //   23: getstatic 68	com/tencent/mm/storage/a/b:ptT	Ljava/lang/String;
    //   26: astore 4
    //   28: getstatic 88	com/tencent/mm/storage/a/a:admO	Lcom/tencent/mm/storage/a/a$a;
    //   31: astore 5
    //   33: aload_3
    //   34: aload 4
    //   36: invokestatic 94	com/tencent/mm/storage/a/a:access$getInfo$cp	()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;
    //   39: getfield 159	com/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo:columns	[Ljava/lang/String;
    //   42: ldc 218
    //   44: iconst_1
    //   45: anewarray 90	java/lang/String
    //   48: dup
    //   49: iconst_0
    //   50: lload_1
    //   51: invokestatic 165	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   54: aastore
    //   55: aconst_null
    //   56: aconst_null
    //   57: aconst_null
    //   58: invokeinterface 171 8 0
    //   63: astore 4
    //   65: new 173	java/util/ArrayList
    //   68: dup
    //   69: invokespecial 175	java/util/ArrayList:<init>	()V
    //   72: checkcast 177	java/util/List
    //   75: astore_3
    //   76: aload 4
    //   78: invokeinterface 183 1 0
    //   83: ifeq +66 -> 149
    //   86: new 84	com/tencent/mm/storage/a/a
    //   89: dup
    //   90: invokespecial 184	com/tencent/mm/storage/a/a:<init>	()V
    //   93: astore 5
    //   95: aload 5
    //   97: aload 4
    //   99: invokevirtual 188	com/tencent/mm/storage/a/a:convertFrom	(Landroid/database/Cursor;)V
    //   102: aload_3
    //   103: aload 5
    //   105: invokeinterface 192 2 0
    //   110: pop
    //   111: goto -35 -> 76
    //   114: astore_3
    //   115: getstatic 64	com/tencent/mm/storage/a/b:TAG	Ljava/lang/String;
    //   118: ldc 220
    //   120: aload_3
    //   121: invokevirtual 197	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   124: invokestatic 76	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   127: invokestatic 203	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: aload 4
    //   132: ifnull +10 -> 142
    //   135: aload 4
    //   137: invokeinterface 206 1 0
    //   142: ldc 216
    //   144: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   147: aconst_null
    //   148: areturn
    //   149: aload_3
    //   150: invokeinterface 210 1 0
    //   155: ifle +33 -> 188
    //   158: aload_3
    //   159: iconst_0
    //   160: invokeinterface 214 2 0
    //   165: checkcast 84	com/tencent/mm/storage/a/a
    //   168: astore_3
    //   169: aload 4
    //   171: ifnull +10 -> 181
    //   174: aload 4
    //   176: invokeinterface 206 1 0
    //   181: ldc 216
    //   183: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   186: aload_3
    //   187: areturn
    //   188: aconst_null
    //   189: astore_3
    //   190: goto -21 -> 169
    //   193: astore_3
    //   194: aload 4
    //   196: ifnull +10 -> 206
    //   199: aload 4
    //   201: invokeinterface 206 1 0
    //   206: ldc 216
    //   208: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   211: aload_3
    //   212: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	this	b
    //   0	213	1	paramLong	long
    //   22	81	3	localObject1	Object
    //   114	45	3	localException	java.lang.Exception
    //   168	22	3	locala	a
    //   193	19	3	localObject2	Object
    //   26	174	4	localObject3	Object
    //   31	73	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   65	76	114	java/lang/Exception
    //   76	111	114	java/lang/Exception
    //   149	169	114	java/lang/Exception
    //   65	76	193	finally
    //   76	111	193	finally
    //   115	130	193	finally
    //   149	169	193	finally
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/storage/file/FileMsgInfoStorage$Companion;", "", "()V", "INDEX_CREATE", "", "", "getINDEX_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "SQL_CREATE", "kotlin.jvm.PlatformType", "getSQL_CREATE", "TABLE", "getTABLE", "()Ljava/lang/String;", "TABLE_INDEX_OVER_WRITE_NEW_MSGID", "getTABLE_INDEX_OVER_WRITE_NEW_MSGID", "TABLE_INDEX_PREFIX", "getTABLE_INDEX_PREFIX", "TAG", "getTAG", "plugin-messenger-foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.a.b
 * JD-Core Version:    0.7.0.1
 */