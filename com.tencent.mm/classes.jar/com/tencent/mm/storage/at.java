package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storagebase.h;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.database.SQLiteDoneException;

public final class at
  extends k
  implements com.tencent.mm.plugin.messenger.foundation.a.a.c
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS DeletedConversationInfo ( userName TEXT  PRIMARY KEY , lastSeq LONG  , reserved1 INT  , reserved2 LONG  , reserved3 TEXT  ) ", "CREATE INDEX IF NOT EXISTS createTimeIndex  ON DeletedConversationInfo ( reserved2 )" };
  private final f<String, Long> fAs;
  private h hpA;
  
  public at(h paramh)
  {
    AppMethodBeat.i(117141);
    this.fAs = new com.tencent.mm.memory.a.c(50);
    this.hpA = paramh;
    AppMethodBeat.o(117141);
  }
  
  private long p(String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(177112);
    try
    {
      long l = DatabaseUtils.longForQuery(this.hpA.fdL(), paramString, paramArrayOfString);
      AppMethodBeat.o(177112);
      return l;
    }
    catch (SQLiteDoneException paramString)
    {
      AppMethodBeat.o(177112);
      return 0L;
    }
    catch (IllegalStateException paramString)
    {
      ac.printErrStackTrace("MicroMsg.DeletedConversationInfoStorage", paramString, "longForQuery failed", new Object[0]);
      AppMethodBeat.o(177112);
    }
    return 0L;
  }
  
  /* Error */
  public final boolean aC(String paramString, long paramLong)
  {
    // Byte code:
    //   0: ldc 80
    //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ifnonnull +10 -> 16
    //   9: ldc 80
    //   11: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   14: iconst_0
    //   15: ireturn
    //   16: aload_0
    //   17: getfield 43	com/tencent/mm/storage/at:hpA	Lcom/tencent/mm/storagebase/h;
    //   20: invokevirtual 59	com/tencent/mm/storagebase/h:fdL	()Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   23: astore 5
    //   25: aload 5
    //   27: invokevirtual 85	com/tencent/wcdb/database/SQLiteDatabase:beginTransaction	()V
    //   30: new 87	android/content/ContentValues
    //   33: dup
    //   34: invokespecial 88	android/content/ContentValues:<init>	()V
    //   37: astore 6
    //   39: aload 6
    //   41: ldc 90
    //   43: lload_2
    //   44: invokestatic 96	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   47: invokevirtual 100	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   50: aload 5
    //   52: ldc 102
    //   54: aload 6
    //   56: ldc 104
    //   58: iconst_1
    //   59: anewarray 17	java/lang/String
    //   62: dup
    //   63: iconst_0
    //   64: aload_1
    //   65: aastore
    //   66: invokevirtual 108	com/tencent/wcdb/database/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   69: ifle +83 -> 152
    //   72: iconst_1
    //   73: istore 4
    //   75: iload 4
    //   77: ifne +45 -> 122
    //   80: aload 6
    //   82: ldc 110
    //   84: aload_1
    //   85: invokevirtual 113	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: aload 6
    //   90: ldc 90
    //   92: lload_2
    //   93: invokestatic 96	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   96: invokevirtual 100	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   99: aload 6
    //   101: ldc 115
    //   103: iconst_0
    //   104: invokestatic 120	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   107: invokevirtual 123	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   110: aload 5
    //   112: ldc 102
    //   114: ldc 110
    //   116: aload 6
    //   118: invokevirtual 127	com/tencent/wcdb/database/SQLiteDatabase:replace	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   121: pop2
    //   122: aload 5
    //   124: invokevirtual 130	com/tencent/wcdb/database/SQLiteDatabase:setTransactionSuccessful	()V
    //   127: aload 5
    //   129: invokevirtual 134	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
    //   132: ifeq +8 -> 140
    //   135: aload 5
    //   137: invokevirtual 137	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
    //   140: aload_0
    //   141: aload_1
    //   142: invokevirtual 141	com/tencent/mm/storage/at:doNotify	(Ljava/lang/String;)V
    //   145: ldc 80
    //   147: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: iconst_1
    //   151: ireturn
    //   152: iconst_0
    //   153: istore 4
    //   155: goto -80 -> 75
    //   158: astore_1
    //   159: ldc 67
    //   161: aload_1
    //   162: ldc 143
    //   164: iconst_0
    //   165: anewarray 71	java/lang/Object
    //   168: invokestatic 77	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   171: aload 5
    //   173: invokevirtual 134	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
    //   176: ifeq +8 -> 184
    //   179: aload 5
    //   181: invokevirtual 137	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
    //   184: ldc 80
    //   186: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   189: iconst_0
    //   190: ireturn
    //   191: astore_1
    //   192: aload 5
    //   194: invokevirtual 134	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
    //   197: ifeq +8 -> 205
    //   200: aload 5
    //   202: invokevirtual 137	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
    //   205: ldc 80
    //   207: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   210: aload_1
    //   211: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	212	0	this	at
    //   0	212	1	paramString	String
    //   0	212	2	paramLong	long
    //   73	81	4	i	int
    //   23	178	5	localSQLiteDatabase	com.tencent.wcdb.database.SQLiteDatabase
    //   37	80	6	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   25	72	158	java/lang/IllegalStateException
    //   80	122	158	java/lang/IllegalStateException
    //   122	127	158	java/lang/IllegalStateException
    //   25	72	191	finally
    //   80	122	191	finally
    //   122	127	191	finally
    //   159	171	191	finally
  }
  
  /* Error */
  public final boolean aD(String paramString, long paramLong)
  {
    // Byte code:
    //   0: ldc 145
    //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 43	com/tencent/mm/storage/at:hpA	Lcom/tencent/mm/storagebase/h;
    //   9: invokevirtual 59	com/tencent/mm/storagebase/h:fdL	()Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   12: astore 5
    //   14: aload 5
    //   16: invokevirtual 85	com/tencent/wcdb/database/SQLiteDatabase:beginTransaction	()V
    //   19: new 87	android/content/ContentValues
    //   22: dup
    //   23: invokespecial 88	android/content/ContentValues:<init>	()V
    //   26: astore 6
    //   28: aload 6
    //   30: ldc 115
    //   32: lload_2
    //   33: invokestatic 96	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   36: invokevirtual 100	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   39: aload 5
    //   41: ldc 102
    //   43: aload 6
    //   45: ldc 104
    //   47: iconst_1
    //   48: anewarray 17	java/lang/String
    //   51: dup
    //   52: iconst_0
    //   53: aload_1
    //   54: aastore
    //   55: invokevirtual 108	com/tencent/wcdb/database/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   58: ifle +111 -> 169
    //   61: iconst_1
    //   62: istore 4
    //   64: iload 4
    //   66: ifne +45 -> 111
    //   69: aload 6
    //   71: ldc 110
    //   73: aload_1
    //   74: invokevirtual 113	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   77: aload 6
    //   79: ldc 90
    //   81: iconst_0
    //   82: invokestatic 120	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   85: invokevirtual 123	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   88: aload 6
    //   90: ldc 115
    //   92: lload_2
    //   93: invokestatic 96	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   96: invokevirtual 100	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   99: aload 5
    //   101: ldc 102
    //   103: ldc 110
    //   105: aload 6
    //   107: invokevirtual 127	com/tencent/wcdb/database/SQLiteDatabase:replace	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   110: pop2
    //   111: aload 5
    //   113: invokevirtual 130	com/tencent/wcdb/database/SQLiteDatabase:setTransactionSuccessful	()V
    //   116: aload_1
    //   117: ifnull +58 -> 175
    //   120: aload_1
    //   121: invokevirtual 148	java/lang/String:isEmpty	()Z
    //   124: ifeq +51 -> 175
    //   127: aload_0
    //   128: getfield 41	com/tencent/mm/storage/at:fAs	Lcom/tencent/mm/b/f;
    //   131: invokeinterface 153 1 0
    //   136: aload 5
    //   138: invokevirtual 156	com/tencent/wcdb/database/SQLiteDatabase:isOpen	()Z
    //   141: ifeq +16 -> 157
    //   144: aload 5
    //   146: invokevirtual 134	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
    //   149: ifeq +8 -> 157
    //   152: aload 5
    //   154: invokevirtual 137	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
    //   157: aload_0
    //   158: aload_1
    //   159: invokevirtual 141	com/tencent/mm/storage/at:doNotify	(Ljava/lang/String;)V
    //   162: ldc 145
    //   164: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   167: iconst_1
    //   168: ireturn
    //   169: iconst_0
    //   170: istore 4
    //   172: goto -108 -> 64
    //   175: aload_0
    //   176: getfield 41	com/tencent/mm/storage/at:fAs	Lcom/tencent/mm/b/f;
    //   179: aload_1
    //   180: lload_2
    //   181: invokestatic 96	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   184: invokeinterface 159 3 0
    //   189: pop
    //   190: goto -54 -> 136
    //   193: astore_1
    //   194: ldc 67
    //   196: aload_1
    //   197: ldc 161
    //   199: iconst_0
    //   200: anewarray 71	java/lang/Object
    //   203: invokestatic 77	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   206: aload 5
    //   208: invokevirtual 156	com/tencent/wcdb/database/SQLiteDatabase:isOpen	()Z
    //   211: ifeq +16 -> 227
    //   214: aload 5
    //   216: invokevirtual 134	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
    //   219: ifeq +8 -> 227
    //   222: aload 5
    //   224: invokevirtual 137	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
    //   227: ldc 145
    //   229: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   232: iconst_0
    //   233: ireturn
    //   234: astore_1
    //   235: aload 5
    //   237: invokevirtual 156	com/tencent/wcdb/database/SQLiteDatabase:isOpen	()Z
    //   240: ifeq +16 -> 256
    //   243: aload 5
    //   245: invokevirtual 134	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
    //   248: ifeq +8 -> 256
    //   251: aload 5
    //   253: invokevirtual 137	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
    //   256: ldc 145
    //   258: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   261: aload_1
    //   262: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	this	at
    //   0	263	1	paramString	String
    //   0	263	2	paramLong	long
    //   62	109	4	i	int
    //   12	240	5	localSQLiteDatabase	com.tencent.wcdb.database.SQLiteDatabase
    //   26	80	6	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   14	61	193	java/lang/IllegalStateException
    //   69	111	193	java/lang/IllegalStateException
    //   111	116	193	java/lang/IllegalStateException
    //   120	136	193	java/lang/IllegalStateException
    //   175	190	193	java/lang/IllegalStateException
    //   14	61	234	finally
    //   69	111	234	finally
    //   111	116	234	finally
    //   120	136	234	finally
    //   175	190	234	finally
    //   194	206	234	finally
  }
  
  public final long akX(String paramString)
  {
    AppMethodBeat.i(117143);
    if (paramString == null)
    {
      AppMethodBeat.o(117143);
      return 0L;
    }
    long l = p("SELECT max(lastSeq) FROM DeletedConversationInfo WHERE userName=? OR userName=''", new String[] { paramString });
    AppMethodBeat.o(117143);
    return l;
  }
  
  public final long akY(String paramString)
  {
    AppMethodBeat.i(117146);
    if (paramString == null)
    {
      AppMethodBeat.o(117146);
      return 0L;
    }
    Long localLong = (Long)this.fAs.get(paramString);
    if (localLong != null)
    {
      l = localLong.longValue();
      AppMethodBeat.o(117146);
      return l;
    }
    long l = p("SELECT max(reserved2) FROM DeletedConversationInfo WHERE userName=? OR userName=''", new String[] { paramString });
    this.fAs.put(paramString, Long.valueOf(l));
    AppMethodBeat.o(117146);
    return l;
  }
  
  /* Error */
  public final java.util.Map<String, Long> dcv()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: ldc 185
    //   5: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 187	java/util/HashMap
    //   11: dup
    //   12: invokespecial 188	java/util/HashMap:<init>	()V
    //   15: astore 5
    //   17: aload_0
    //   18: ldc 190
    //   20: aconst_null
    //   21: invokespecial 168	com/tencent/mm/storage/at:p	(Ljava/lang/String;[Ljava/lang/String;)J
    //   24: lstore_1
    //   25: aload_0
    //   26: getfield 43	com/tencent/mm/storage/at:hpA	Lcom/tencent/mm/storagebase/h;
    //   29: invokevirtual 59	com/tencent/mm/storagebase/h:fdL	()Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   32: getstatic 196	com/tencent/wcdb/database/SQLiteDirectCursor:FACTORY	Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;
    //   35: ldc 198
    //   37: aconst_null
    //   38: ldc 102
    //   40: invokevirtual 202	com/tencent/wcdb/database/SQLiteDatabase:rawQueryWithFactory	(Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/String;)Lcom/tencent/wcdb/Cursor;
    //   43: astore 7
    //   45: aload 7
    //   47: invokeinterface 207 1 0
    //   52: ifeq +95 -> 147
    //   55: aload 7
    //   57: iconst_0
    //   58: invokeinterface 211 2 0
    //   63: astore 8
    //   65: aload 7
    //   67: iconst_1
    //   68: invokeinterface 215 2 0
    //   73: lstore_3
    //   74: aload_0
    //   75: getfield 41	com/tencent/mm/storage/at:fAs	Lcom/tencent/mm/b/f;
    //   78: aload 8
    //   80: lload_1
    //   81: lload_3
    //   82: invokestatic 221	java/lang/Math:max	(JJ)J
    //   85: invokestatic 96	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   88: invokeinterface 224 3 0
    //   93: aload 5
    //   95: aload 8
    //   97: lload_3
    //   98: invokestatic 96	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   101: invokeinterface 227 3 0
    //   106: pop
    //   107: goto -62 -> 45
    //   110: astore 6
    //   112: ldc 185
    //   114: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: aload 6
    //   119: athrow
    //   120: astore 5
    //   122: aload 7
    //   124: ifnull +15 -> 139
    //   127: aload 6
    //   129: ifnull +50 -> 179
    //   132: aload 7
    //   134: invokeinterface 230 1 0
    //   139: ldc 185
    //   141: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   144: aload 5
    //   146: athrow
    //   147: aload 7
    //   149: ifnull +10 -> 159
    //   152: aload 7
    //   154: invokeinterface 230 1 0
    //   159: ldc 185
    //   161: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   164: aload 5
    //   166: areturn
    //   167: astore 7
    //   169: aload 6
    //   171: aload 7
    //   173: invokevirtual 234	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   176: goto -37 -> 139
    //   179: aload 7
    //   181: invokeinterface 230 1 0
    //   186: goto -47 -> 139
    //   189: astore 5
    //   191: goto -69 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	this	at
    //   24	57	1	l1	long
    //   73	25	3	l2	long
    //   15	79	5	localHashMap	java.util.HashMap
    //   120	45	5	localMap	java.util.Map<String, Long>
    //   189	1	5	localObject1	Object
    //   1	1	6	localObject2	Object
    //   110	60	6	localThrowable1	java.lang.Throwable
    //   43	110	7	localCursor	com.tencent.wcdb.Cursor
    //   167	13	7	localThrowable2	java.lang.Throwable
    //   63	33	8	str	String
    // Exception table:
    //   from	to	target	type
    //   45	107	110	java/lang/Throwable
    //   112	120	120	finally
    //   132	139	167	java/lang/Throwable
    //   45	107	189	finally
  }
  
  public final boolean dcw()
  {
    AppMethodBeat.i(177111);
    if (p("SELECT reserved2 FROM DeletedConversationInfo WHERE reserved2 > 0 LIMIT 1", null) > 0L)
    {
      AppMethodBeat.o(177111);
      return true;
    }
    AppMethodBeat.o(177111);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storage.at
 * JD-Core Version:    0.7.0.1
 */