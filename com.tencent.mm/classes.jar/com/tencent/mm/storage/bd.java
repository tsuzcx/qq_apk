package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storagebase.h;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.database.SQLiteDoneException;

public final class bd
  extends MStorage
  implements com.tencent.mm.plugin.messenger.foundation.a.a.c
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS DeletedConversationInfo ( userName TEXT  PRIMARY KEY , lastSeq LONG  , reserved1 INT  , reserved2 LONG  , reserved3 TEXT  ) ", "CREATE INDEX IF NOT EXISTS createTimeIndex  ON DeletedConversationInfo ( reserved2 )" };
  private final f<String, Long> jla;
  private h lvy;
  
  public bd(h paramh)
  {
    AppMethodBeat.i(117141);
    this.jla = new com.tencent.mm.memory.a.c(50);
    this.lvy = paramh;
    AppMethodBeat.o(117141);
  }
  
  private long o(String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(177112);
    try
    {
      long l = DatabaseUtils.longForQuery(this.lvy.hBZ(), paramString, paramArrayOfString);
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
      Log.printErrStackTrace("MicroMsg.DeletedConversationInfoStorage", paramString, "longForQuery failed", new Object[0]);
      AppMethodBeat.o(177112);
    }
    return 0L;
  }
  
  /* Error */
  public final boolean aI(String paramString, long paramLong)
  {
    // Byte code:
    //   0: ldc 79
    //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ifnonnull +10 -> 16
    //   9: ldc 79
    //   11: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   14: iconst_0
    //   15: ireturn
    //   16: aload_0
    //   17: getfield 43	com/tencent/mm/storage/bd:lvy	Lcom/tencent/mm/storagebase/h;
    //   20: invokevirtual 58	com/tencent/mm/storagebase/h:hBZ	()Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   23: astore 5
    //   25: aload 5
    //   27: invokevirtual 84	com/tencent/wcdb/database/SQLiteDatabase:beginTransaction	()V
    //   30: new 86	android/content/ContentValues
    //   33: dup
    //   34: invokespecial 87	android/content/ContentValues:<init>	()V
    //   37: astore 6
    //   39: aload 6
    //   41: ldc 89
    //   43: lload_2
    //   44: invokestatic 95	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   47: invokevirtual 99	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   50: aload 5
    //   52: ldc 101
    //   54: aload 6
    //   56: ldc 103
    //   58: iconst_1
    //   59: anewarray 17	java/lang/String
    //   62: dup
    //   63: iconst_0
    //   64: aload_1
    //   65: aastore
    //   66: invokevirtual 107	com/tencent/wcdb/database/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   69: ifle +83 -> 152
    //   72: iconst_1
    //   73: istore 4
    //   75: iload 4
    //   77: ifne +45 -> 122
    //   80: aload 6
    //   82: ldc 109
    //   84: aload_1
    //   85: invokevirtual 112	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: aload 6
    //   90: ldc 89
    //   92: lload_2
    //   93: invokestatic 95	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   96: invokevirtual 99	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   99: aload 6
    //   101: ldc 114
    //   103: iconst_0
    //   104: invokestatic 119	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   107: invokevirtual 122	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   110: aload 5
    //   112: ldc 101
    //   114: ldc 109
    //   116: aload 6
    //   118: invokevirtual 126	com/tencent/wcdb/database/SQLiteDatabase:replace	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   121: pop2
    //   122: aload 5
    //   124: invokevirtual 129	com/tencent/wcdb/database/SQLiteDatabase:setTransactionSuccessful	()V
    //   127: aload 5
    //   129: invokevirtual 133	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
    //   132: ifeq +8 -> 140
    //   135: aload 5
    //   137: invokevirtual 136	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
    //   140: aload_0
    //   141: aload_1
    //   142: invokevirtual 140	com/tencent/mm/storage/bd:doNotify	(Ljava/lang/String;)V
    //   145: ldc 79
    //   147: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: iconst_1
    //   151: ireturn
    //   152: iconst_0
    //   153: istore 4
    //   155: goto -80 -> 75
    //   158: astore_1
    //   159: ldc 66
    //   161: aload_1
    //   162: ldc 142
    //   164: iconst_0
    //   165: anewarray 70	java/lang/Object
    //   168: invokestatic 76	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   171: aload 5
    //   173: invokevirtual 133	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
    //   176: ifeq +8 -> 184
    //   179: aload 5
    //   181: invokevirtual 136	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
    //   184: ldc 79
    //   186: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   189: iconst_0
    //   190: ireturn
    //   191: astore_1
    //   192: aload 5
    //   194: invokevirtual 133	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
    //   197: ifeq +8 -> 205
    //   200: aload 5
    //   202: invokevirtual 136	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
    //   205: ldc 79
    //   207: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   210: aload_1
    //   211: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	212	0	this	bd
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
  public final boolean aJ(String paramString, long paramLong)
  {
    // Byte code:
    //   0: ldc 144
    //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 43	com/tencent/mm/storage/bd:lvy	Lcom/tencent/mm/storagebase/h;
    //   9: invokevirtual 58	com/tencent/mm/storagebase/h:hBZ	()Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   12: astore 5
    //   14: aload 5
    //   16: invokevirtual 84	com/tencent/wcdb/database/SQLiteDatabase:beginTransaction	()V
    //   19: new 86	android/content/ContentValues
    //   22: dup
    //   23: invokespecial 87	android/content/ContentValues:<init>	()V
    //   26: astore 6
    //   28: aload 6
    //   30: ldc 114
    //   32: lload_2
    //   33: invokestatic 95	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   36: invokevirtual 99	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   39: aload 5
    //   41: ldc 101
    //   43: aload 6
    //   45: ldc 103
    //   47: iconst_1
    //   48: anewarray 17	java/lang/String
    //   51: dup
    //   52: iconst_0
    //   53: aload_1
    //   54: aastore
    //   55: invokevirtual 107	com/tencent/wcdb/database/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   58: ifle +111 -> 169
    //   61: iconst_1
    //   62: istore 4
    //   64: iload 4
    //   66: ifne +45 -> 111
    //   69: aload 6
    //   71: ldc 109
    //   73: aload_1
    //   74: invokevirtual 112	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   77: aload 6
    //   79: ldc 89
    //   81: iconst_0
    //   82: invokestatic 119	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   85: invokevirtual 122	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   88: aload 6
    //   90: ldc 114
    //   92: lload_2
    //   93: invokestatic 95	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   96: invokevirtual 99	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   99: aload 5
    //   101: ldc 101
    //   103: ldc 109
    //   105: aload 6
    //   107: invokevirtual 126	com/tencent/wcdb/database/SQLiteDatabase:replace	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   110: pop2
    //   111: aload 5
    //   113: invokevirtual 129	com/tencent/wcdb/database/SQLiteDatabase:setTransactionSuccessful	()V
    //   116: aload_1
    //   117: ifnull +58 -> 175
    //   120: aload_1
    //   121: invokevirtual 147	java/lang/String:isEmpty	()Z
    //   124: ifeq +51 -> 175
    //   127: aload_0
    //   128: getfield 41	com/tencent/mm/storage/bd:jla	Lcom/tencent/mm/b/f;
    //   131: invokeinterface 152 1 0
    //   136: aload 5
    //   138: invokevirtual 155	com/tencent/wcdb/database/SQLiteDatabase:isOpen	()Z
    //   141: ifeq +16 -> 157
    //   144: aload 5
    //   146: invokevirtual 133	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
    //   149: ifeq +8 -> 157
    //   152: aload 5
    //   154: invokevirtual 136	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
    //   157: aload_0
    //   158: aload_1
    //   159: invokevirtual 140	com/tencent/mm/storage/bd:doNotify	(Ljava/lang/String;)V
    //   162: ldc 144
    //   164: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   167: iconst_1
    //   168: ireturn
    //   169: iconst_0
    //   170: istore 4
    //   172: goto -108 -> 64
    //   175: aload_0
    //   176: getfield 41	com/tencent/mm/storage/bd:jla	Lcom/tencent/mm/b/f;
    //   179: aload_1
    //   180: lload_2
    //   181: invokestatic 95	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   184: invokeinterface 158 3 0
    //   189: pop
    //   190: goto -54 -> 136
    //   193: astore_1
    //   194: ldc 66
    //   196: aload_1
    //   197: ldc 160
    //   199: iconst_0
    //   200: anewarray 70	java/lang/Object
    //   203: invokestatic 76	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   206: aload 5
    //   208: invokevirtual 155	com/tencent/wcdb/database/SQLiteDatabase:isOpen	()Z
    //   211: ifeq +16 -> 227
    //   214: aload 5
    //   216: invokevirtual 133	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
    //   219: ifeq +8 -> 227
    //   222: aload 5
    //   224: invokevirtual 136	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
    //   227: ldc 144
    //   229: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   232: iconst_0
    //   233: ireturn
    //   234: astore_1
    //   235: aload 5
    //   237: invokevirtual 155	com/tencent/wcdb/database/SQLiteDatabase:isOpen	()Z
    //   240: ifeq +16 -> 256
    //   243: aload 5
    //   245: invokevirtual 133	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
    //   248: ifeq +8 -> 256
    //   251: aload 5
    //   253: invokevirtual 136	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
    //   256: ldc 144
    //   258: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   261: aload_1
    //   262: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	this	bd
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
  
  public final long aOt(String paramString)
  {
    AppMethodBeat.i(117143);
    if (paramString == null)
    {
      AppMethodBeat.o(117143);
      return 0L;
    }
    long l = o("SELECT max(lastSeq) FROM DeletedConversationInfo WHERE userName=? OR userName=''", new String[] { paramString });
    AppMethodBeat.o(117143);
    return l;
  }
  
  public final long aOu(String paramString)
  {
    AppMethodBeat.i(117146);
    if (paramString == null)
    {
      AppMethodBeat.o(117146);
      return 0L;
    }
    Long localLong = (Long)this.jla.get(paramString);
    if (localLong != null)
    {
      l = localLong.longValue();
      AppMethodBeat.o(117146);
      return l;
    }
    long l = o("SELECT max(reserved2) FROM DeletedConversationInfo WHERE userName=? OR userName=''", new String[] { paramString });
    this.jla.put(paramString, Long.valueOf(l));
    AppMethodBeat.o(117146);
    return l;
  }
  
  /* Error */
  public final java.util.Map<String, Long> eSh()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: ldc 184
    //   5: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 186	java/util/HashMap
    //   11: dup
    //   12: invokespecial 187	java/util/HashMap:<init>	()V
    //   15: astore 7
    //   17: aload_0
    //   18: ldc 189
    //   20: aconst_null
    //   21: invokespecial 167	com/tencent/mm/storage/bd:o	(Ljava/lang/String;[Ljava/lang/String;)J
    //   24: lstore_1
    //   25: aload_0
    //   26: getfield 43	com/tencent/mm/storage/bd:lvy	Lcom/tencent/mm/storagebase/h;
    //   29: invokevirtual 58	com/tencent/mm/storagebase/h:hBZ	()Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   32: getstatic 195	com/tencent/wcdb/database/SQLiteDirectCursor:FACTORY	Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;
    //   35: ldc 197
    //   37: aconst_null
    //   38: ldc 101
    //   40: invokevirtual 201	com/tencent/wcdb/database/SQLiteDatabase:rawQueryWithFactory	(Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/String;)Lcom/tencent/wcdb/Cursor;
    //   43: astore 8
    //   45: aload 8
    //   47: invokeinterface 206 1 0
    //   52: ifeq +118 -> 170
    //   55: aload 8
    //   57: iconst_0
    //   58: invokeinterface 210 2 0
    //   63: astore 5
    //   65: aload 8
    //   67: iconst_1
    //   68: invokeinterface 214 2 0
    //   73: lstore_3
    //   74: aload_0
    //   75: getfield 41	com/tencent/mm/storage/bd:jla	Lcom/tencent/mm/b/f;
    //   78: aload 5
    //   80: lload_1
    //   81: lload_3
    //   82: invokestatic 220	java/lang/Math:max	(JJ)J
    //   85: invokestatic 95	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   88: invokeinterface 224 3 0
    //   93: aload 7
    //   95: aload 5
    //   97: lload_3
    //   98: invokestatic 95	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   101: invokeinterface 227 3 0
    //   106: pop
    //   107: goto -62 -> 45
    //   110: astore 6
    //   112: ldc 184
    //   114: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: aload 6
    //   119: athrow
    //   120: astore 5
    //   122: aload 8
    //   124: ifnull +15 -> 139
    //   127: aload 6
    //   129: ifnull +68 -> 197
    //   132: aload 8
    //   134: invokeinterface 230 1 0
    //   139: ldc 184
    //   141: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   144: aload 5
    //   146: athrow
    //   147: astore 5
    //   149: ldc 66
    //   151: aload 5
    //   153: ldc 232
    //   155: iconst_0
    //   156: anewarray 70	java/lang/Object
    //   159: invokestatic 76	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   162: ldc 184
    //   164: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   167: aload 7
    //   169: areturn
    //   170: aload 8
    //   172: ifnull -10 -> 162
    //   175: aload 8
    //   177: invokeinterface 230 1 0
    //   182: goto -20 -> 162
    //   185: astore 8
    //   187: aload 6
    //   189: aload 8
    //   191: invokevirtual 236	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   194: goto -55 -> 139
    //   197: aload 8
    //   199: invokeinterface 230 1 0
    //   204: goto -65 -> 139
    //   207: astore 5
    //   209: goto -87 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	212	0	this	bd
    //   24	57	1	l1	long
    //   73	25	3	l2	long
    //   63	33	5	str	String
    //   120	25	5	localObject1	Object
    //   147	5	5	localIllegalStateException	IllegalStateException
    //   207	1	5	localObject2	Object
    //   1	1	6	localObject3	Object
    //   110	78	6	localThrowable1	java.lang.Throwable
    //   15	153	7	localHashMap	java.util.HashMap
    //   43	133	8	localCursor	com.tencent.wcdb.Cursor
    //   185	13	8	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   45	107	110	java/lang/Throwable
    //   112	120	120	finally
    //   17	45	147	java/lang/IllegalStateException
    //   132	139	147	java/lang/IllegalStateException
    //   139	147	147	java/lang/IllegalStateException
    //   175	182	147	java/lang/IllegalStateException
    //   187	194	147	java/lang/IllegalStateException
    //   197	204	147	java/lang/IllegalStateException
    //   132	139	185	java/lang/Throwable
    //   45	107	207	finally
  }
  
  public final boolean eSi()
  {
    AppMethodBeat.i(177111);
    if (o("SELECT reserved2 FROM DeletedConversationInfo WHERE reserved2 > 0 LIMIT 1", null) > 0L)
    {
      AppMethodBeat.o(177111);
      return true;
    }
    AppMethodBeat.o(177111);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.bd
 * JD-Core Version:    0.7.0.1
 */