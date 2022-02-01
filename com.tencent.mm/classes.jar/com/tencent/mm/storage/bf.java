package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storagebase.h;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.database.SQLiteDoneException;

public final class bf
  extends MStorage
  implements com.tencent.mm.plugin.messenger.foundation.a.a.c
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS DeletedConversationInfo ( userName TEXT  PRIMARY KEY , lastSeq LONG  , reserved1 INT  , reserved2 LONG  , reserved3 TEXT  ) ", "CREATE INDEX IF NOT EXISTS createTimeIndex  ON DeletedConversationInfo ( reserved2 )" };
  private final f<String, Long> lNS;
  private h omV;
  
  public bf(h paramh)
  {
    AppMethodBeat.i(117141);
    this.lNS = new com.tencent.mm.memory.a.c(50);
    this.omV = paramh;
    AppMethodBeat.o(117141);
  }
  
  private long p(String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(177112);
    try
    {
      long l = DatabaseUtils.longForQuery(this.omV.jef(), paramString, paramArrayOfString);
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
  
  public final long aLs(String paramString)
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
  
  public final long aLt(String paramString)
  {
    AppMethodBeat.i(117146);
    if (paramString == null)
    {
      AppMethodBeat.o(117146);
      return 0L;
    }
    Long localLong = (Long)this.lNS.get(paramString);
    if (localLong != null)
    {
      l = localLong.longValue();
      AppMethodBeat.o(117146);
      return l;
    }
    long l = p("SELECT max(reserved2) FROM DeletedConversationInfo WHERE userName=? OR userName=''", new String[] { paramString });
    this.lNS.put(paramString, Long.valueOf(l));
    AppMethodBeat.o(117146);
    return l;
  }
  
  /* Error */
  public final boolean aR(String paramString, long paramLong)
  {
    // Byte code:
    //   0: ldc 111
    //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ifnonnull +10 -> 16
    //   9: ldc 111
    //   11: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   14: iconst_0
    //   15: ireturn
    //   16: aload_0
    //   17: getfield 43	com/tencent/mm/storage/bf:omV	Lcom/tencent/mm/storagebase/h;
    //   20: invokevirtual 59	com/tencent/mm/storagebase/h:jef	()Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   23: astore 5
    //   25: aload 5
    //   27: invokevirtual 116	com/tencent/wcdb/database/SQLiteDatabase:beginTransaction	()V
    //   30: new 118	android/content/ContentValues
    //   33: dup
    //   34: invokespecial 119	android/content/ContentValues:<init>	()V
    //   37: astore 6
    //   39: aload 6
    //   41: ldc 121
    //   43: lload_2
    //   44: invokestatic 104	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   47: invokevirtual 124	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   50: aload 5
    //   52: ldc 126
    //   54: aload 6
    //   56: ldc 128
    //   58: iconst_1
    //   59: anewarray 17	java/lang/String
    //   62: dup
    //   63: iconst_0
    //   64: aload_1
    //   65: aastore
    //   66: invokevirtual 132	com/tencent/wcdb/database/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   69: ifle +83 -> 152
    //   72: iconst_1
    //   73: istore 4
    //   75: iload 4
    //   77: ifne +45 -> 122
    //   80: aload 6
    //   82: ldc 134
    //   84: aload_1
    //   85: invokevirtual 137	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: aload 6
    //   90: ldc 121
    //   92: lload_2
    //   93: invokestatic 104	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   96: invokevirtual 124	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   99: aload 6
    //   101: ldc 139
    //   103: iconst_0
    //   104: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   107: invokevirtual 147	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   110: aload 5
    //   112: ldc 126
    //   114: ldc 134
    //   116: aload 6
    //   118: invokevirtual 151	com/tencent/wcdb/database/SQLiteDatabase:replace	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   121: pop2
    //   122: aload 5
    //   124: invokevirtual 154	com/tencent/wcdb/database/SQLiteDatabase:setTransactionSuccessful	()V
    //   127: aload 5
    //   129: invokevirtual 158	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
    //   132: ifeq +8 -> 140
    //   135: aload 5
    //   137: invokevirtual 161	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
    //   140: aload_0
    //   141: aload_1
    //   142: invokevirtual 165	com/tencent/mm/storage/bf:doNotify	(Ljava/lang/String;)V
    //   145: ldc 111
    //   147: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: iconst_1
    //   151: ireturn
    //   152: iconst_0
    //   153: istore 4
    //   155: goto -80 -> 75
    //   158: astore_1
    //   159: ldc 67
    //   161: aload_1
    //   162: ldc 167
    //   164: iconst_0
    //   165: anewarray 71	java/lang/Object
    //   168: invokestatic 77	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   171: aload 5
    //   173: invokevirtual 158	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
    //   176: ifeq +8 -> 184
    //   179: aload 5
    //   181: invokevirtual 161	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
    //   184: ldc 111
    //   186: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   189: iconst_0
    //   190: ireturn
    //   191: astore_1
    //   192: aload 5
    //   194: invokevirtual 158	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
    //   197: ifeq +8 -> 205
    //   200: aload 5
    //   202: invokevirtual 161	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
    //   205: ldc 111
    //   207: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   210: aload_1
    //   211: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	212	0	this	bf
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
  public final boolean aS(String paramString, long paramLong)
  {
    // Byte code:
    //   0: ldc 169
    //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 43	com/tencent/mm/storage/bf:omV	Lcom/tencent/mm/storagebase/h;
    //   9: invokevirtual 59	com/tencent/mm/storagebase/h:jef	()Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   12: astore 5
    //   14: aload 5
    //   16: invokevirtual 116	com/tencent/wcdb/database/SQLiteDatabase:beginTransaction	()V
    //   19: new 118	android/content/ContentValues
    //   22: dup
    //   23: invokespecial 119	android/content/ContentValues:<init>	()V
    //   26: astore 6
    //   28: aload 6
    //   30: ldc 139
    //   32: lload_2
    //   33: invokestatic 104	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   36: invokevirtual 124	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   39: aload 5
    //   41: ldc 126
    //   43: aload 6
    //   45: ldc 128
    //   47: iconst_1
    //   48: anewarray 17	java/lang/String
    //   51: dup
    //   52: iconst_0
    //   53: aload_1
    //   54: aastore
    //   55: invokevirtual 132	com/tencent/wcdb/database/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   58: ifle +111 -> 169
    //   61: iconst_1
    //   62: istore 4
    //   64: iload 4
    //   66: ifne +45 -> 111
    //   69: aload 6
    //   71: ldc 134
    //   73: aload_1
    //   74: invokevirtual 137	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   77: aload 6
    //   79: ldc 121
    //   81: iconst_0
    //   82: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   85: invokevirtual 147	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   88: aload 6
    //   90: ldc 139
    //   92: lload_2
    //   93: invokestatic 104	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   96: invokevirtual 124	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   99: aload 5
    //   101: ldc 126
    //   103: ldc 134
    //   105: aload 6
    //   107: invokevirtual 151	com/tencent/wcdb/database/SQLiteDatabase:replace	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   110: pop2
    //   111: aload 5
    //   113: invokevirtual 154	com/tencent/wcdb/database/SQLiteDatabase:setTransactionSuccessful	()V
    //   116: aload_1
    //   117: ifnull +58 -> 175
    //   120: aload_1
    //   121: invokevirtual 172	java/lang/String:isEmpty	()Z
    //   124: ifeq +51 -> 175
    //   127: aload_0
    //   128: getfield 41	com/tencent/mm/storage/bf:lNS	Lcom/tencent/mm/b/f;
    //   131: invokeinterface 175 1 0
    //   136: aload 5
    //   138: invokevirtual 178	com/tencent/wcdb/database/SQLiteDatabase:isOpen	()Z
    //   141: ifeq +16 -> 157
    //   144: aload 5
    //   146: invokevirtual 158	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
    //   149: ifeq +8 -> 157
    //   152: aload 5
    //   154: invokevirtual 161	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
    //   157: aload_0
    //   158: aload_1
    //   159: invokevirtual 165	com/tencent/mm/storage/bf:doNotify	(Ljava/lang/String;)V
    //   162: ldc 169
    //   164: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   167: iconst_1
    //   168: ireturn
    //   169: iconst_0
    //   170: istore 4
    //   172: goto -108 -> 64
    //   175: aload_0
    //   176: getfield 41	com/tencent/mm/storage/bf:lNS	Lcom/tencent/mm/b/f;
    //   179: aload_1
    //   180: lload_2
    //   181: invokestatic 104	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   184: invokeinterface 108 3 0
    //   189: pop
    //   190: goto -54 -> 136
    //   193: astore_1
    //   194: ldc 67
    //   196: aload_1
    //   197: ldc 180
    //   199: iconst_0
    //   200: anewarray 71	java/lang/Object
    //   203: invokestatic 77	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   206: aload 5
    //   208: invokevirtual 178	com/tencent/wcdb/database/SQLiteDatabase:isOpen	()Z
    //   211: ifeq +16 -> 227
    //   214: aload 5
    //   216: invokevirtual 158	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
    //   219: ifeq +8 -> 227
    //   222: aload 5
    //   224: invokevirtual 161	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
    //   227: ldc 169
    //   229: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   232: iconst_0
    //   233: ireturn
    //   234: astore_1
    //   235: aload 5
    //   237: invokevirtual 178	com/tencent/wcdb/database/SQLiteDatabase:isOpen	()Z
    //   240: ifeq +16 -> 256
    //   243: aload 5
    //   245: invokevirtual 158	com/tencent/wcdb/database/SQLiteDatabase:inTransaction	()Z
    //   248: ifeq +8 -> 256
    //   251: aload 5
    //   253: invokevirtual 161	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
    //   256: ldc 169
    //   258: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   261: aload_1
    //   262: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	this	bf
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
  
  /* Error */
  public final java.util.Map<String, Long> gbc()
  {
    // Byte code:
    //   0: ldc 183
    //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 185	java/util/HashMap
    //   8: dup
    //   9: invokespecial 186	java/util/HashMap:<init>	()V
    //   12: astore 5
    //   14: aload_0
    //   15: ldc 188
    //   17: aconst_null
    //   18: invokespecial 84	com/tencent/mm/storage/bf:p	(Ljava/lang/String;[Ljava/lang/String;)J
    //   21: lstore_1
    //   22: aload_0
    //   23: getfield 43	com/tencent/mm/storage/bf:omV	Lcom/tencent/mm/storagebase/h;
    //   26: invokevirtual 59	com/tencent/mm/storagebase/h:jef	()Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   29: getstatic 194	com/tencent/wcdb/database/SQLiteDirectCursor:FACTORY	Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;
    //   32: ldc 196
    //   34: aconst_null
    //   35: ldc 126
    //   37: invokevirtual 200	com/tencent/wcdb/database/SQLiteDatabase:rawQueryWithFactory	(Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/String;)Lcom/tencent/wcdb/Cursor;
    //   40: astore 6
    //   42: aload 6
    //   44: invokeinterface 205 1 0
    //   49: ifeq +103 -> 152
    //   52: aload 6
    //   54: iconst_0
    //   55: invokeinterface 209 2 0
    //   60: astore 7
    //   62: aload 6
    //   64: iconst_1
    //   65: invokeinterface 213 2 0
    //   70: lstore_3
    //   71: aload_0
    //   72: getfield 41	com/tencent/mm/storage/bf:lNS	Lcom/tencent/mm/b/f;
    //   75: aload 7
    //   77: lload_1
    //   78: lload_3
    //   79: invokestatic 219	java/lang/Math:max	(JJ)J
    //   82: invokestatic 104	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   85: invokeinterface 223 3 0
    //   90: aload 5
    //   92: aload 7
    //   94: lload_3
    //   95: invokestatic 104	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   98: invokeinterface 226 3 0
    //   103: pop
    //   104: goto -62 -> 42
    //   107: astore 7
    //   109: aload 6
    //   111: ifnull +10 -> 121
    //   114: aload 6
    //   116: invokeinterface 229 1 0
    //   121: ldc 183
    //   123: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: aload 7
    //   128: athrow
    //   129: astore 6
    //   131: ldc 67
    //   133: aload 6
    //   135: ldc 231
    //   137: iconst_0
    //   138: anewarray 71	java/lang/Object
    //   141: invokestatic 77	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   144: ldc 183
    //   146: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: aload 5
    //   151: areturn
    //   152: aload 6
    //   154: ifnull -10 -> 144
    //   157: aload 6
    //   159: invokeinterface 229 1 0
    //   164: goto -20 -> 144
    //   167: astore 6
    //   169: aload 7
    //   171: aload 6
    //   173: invokevirtual 237	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   176: goto -55 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	this	bf
    //   21	57	1	l1	long
    //   70	25	3	l2	long
    //   12	138	5	localHashMap	java.util.HashMap
    //   40	75	6	localCursor	com.tencent.wcdb.Cursor
    //   129	29	6	localIllegalStateException	IllegalStateException
    //   167	5	6	localThrowable	java.lang.Throwable
    //   60	33	7	str	String
    //   107	63	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   42	104	107	finally
    //   14	42	129	java/lang/IllegalStateException
    //   121	129	129	java/lang/IllegalStateException
    //   157	164	129	java/lang/IllegalStateException
    //   169	176	129	java/lang/IllegalStateException
    //   114	121	167	finally
  }
  
  public final boolean gbd()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.storage.bf
 * JD-Core Version:    0.7.0.1
 */