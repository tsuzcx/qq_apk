package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.Iterator;

public final class v
  extends MAutoStorage<SmileyInfo>
{
  public static final String[] SQL_CREATE;
  private static final String[] admK;
  private static final String[] admL;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(105145);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(SmileyInfo.info, "SmileyInfo") };
    admK = new String[] { "key", "cnValue", "qqValue", "enValue", "twValue", "thValue", "eggIndex", "fileName" };
    admL = new String[] { "key" };
    AppMethodBeat.o(105145);
  }
  
  public v(ISQLiteDatabase paramISQLiteDatabase)
  {
    this(paramISQLiteDatabase, SmileyInfo.info, "SmileyInfo");
  }
  
  private v(ISQLiteDatabase paramISQLiteDatabase, IAutoDBItem.MAutoDBInfo paramMAutoDBInfo, String paramString)
  {
    super(paramISQLiteDatabase, paramMAutoDBInfo, paramString, null);
    this.db = paramISQLiteDatabase;
  }
  
  public final boolean cd(ArrayList<SmileyInfo> paramArrayList)
  {
    AppMethodBeat.i(105144);
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      Log.i("MicroMsg.emoji.NewSmileyInfoStorage", "insertSmileyInfoList failed. list is null.");
      AppMethodBeat.o(105144);
      return false;
    }
    h localh;
    long l;
    if ((this.db instanceof h))
    {
      localh = (h)this.db;
      l = localh.beginTransaction(Thread.currentThread().getId());
    }
    for (;;)
    {
      this.db.delete("SmileyInfo", null, null);
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        insert((SmileyInfo)paramArrayList.next());
      }
      int i = -1;
      if (localh != null) {
        i = localh.endTransaction(l);
      }
      if (i >= 0)
      {
        AppMethodBeat.o(105144);
        return true;
      }
      AppMethodBeat.o(105144);
      return false;
      l = -1L;
      localh = null;
    }
  }
  
  /* Error */
  public final ArrayList<SmileyInfo> dzv()
  {
    // Byte code:
    //   0: ldc 141
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 75	java/util/ArrayList
    //   8: dup
    //   9: invokespecial 143	java/util/ArrayList:<init>	()V
    //   12: astore 5
    //   14: aload_0
    //   15: getfield 70	com/tencent/mm/storage/emotion/v:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   18: ldc 30
    //   20: getstatic 54	com/tencent/mm/storage/emotion/v:admK	[Ljava/lang/String;
    //   23: ldc 145
    //   25: iconst_1
    //   26: anewarray 22	java/lang/String
    //   29: dup
    //   30: iconst_0
    //   31: ldc 147
    //   33: aastore
    //   34: aconst_null
    //   35: aconst_null
    //   36: aconst_null
    //   37: iconst_2
    //   38: invokeinterface 151 9 0
    //   43: astore_3
    //   44: aload_3
    //   45: ifnull +64 -> 109
    //   48: aload_3
    //   49: astore_2
    //   50: aload_3
    //   51: invokeinterface 156 1 0
    //   56: ifeq +53 -> 109
    //   59: aload_3
    //   60: astore_2
    //   61: new 24	com/tencent/mm/storage/emotion/SmileyInfo
    //   64: dup
    //   65: invokespecial 157	com/tencent/mm/storage/emotion/SmileyInfo:<init>	()V
    //   68: astore 4
    //   70: aload_3
    //   71: astore_2
    //   72: aload 4
    //   74: aload_3
    //   75: invokevirtual 161	com/tencent/mm/storage/emotion/SmileyInfo:convertFrom	(Landroid/database/Cursor;)V
    //   78: aload_3
    //   79: astore_2
    //   80: aload 4
    //   82: iconst_m1
    //   83: putfield 165	com/tencent/mm/storage/emotion/SmileyInfo:field_position	I
    //   86: aload_3
    //   87: astore_2
    //   88: aload 5
    //   90: aload 4
    //   92: invokevirtual 169	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   95: pop
    //   96: aload_3
    //   97: astore_2
    //   98: aload_3
    //   99: invokeinterface 172 1 0
    //   104: istore_1
    //   105: iload_1
    //   106: ifne -47 -> 59
    //   109: aload_3
    //   110: ifnull +9 -> 119
    //   113: aload_3
    //   114: invokeinterface 175 1 0
    //   119: ldc 141
    //   121: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   124: aload 5
    //   126: areturn
    //   127: astore 4
    //   129: aconst_null
    //   130: astore_3
    //   131: aload_3
    //   132: astore_2
    //   133: ldc 81
    //   135: aload 4
    //   137: invokestatic 181	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   140: invokestatic 184	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   143: aload_3
    //   144: ifnull -25 -> 119
    //   147: aload_3
    //   148: invokeinterface 175 1 0
    //   153: goto -34 -> 119
    //   156: astore_3
    //   157: aconst_null
    //   158: astore_2
    //   159: aload_2
    //   160: ifnull +9 -> 169
    //   163: aload_2
    //   164: invokeinterface 175 1 0
    //   169: ldc 141
    //   171: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   174: aload_3
    //   175: athrow
    //   176: astore_3
    //   177: goto -18 -> 159
    //   180: astore 4
    //   182: goto -51 -> 131
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	v
    //   104	2	1	bool	boolean
    //   49	115	2	localCursor1	android.database.Cursor
    //   43	105	3	localCursor2	android.database.Cursor
    //   156	19	3	localObject1	java.lang.Object
    //   176	1	3	localObject2	java.lang.Object
    //   68	23	4	localSmileyInfo	SmileyInfo
    //   127	9	4	localException1	java.lang.Exception
    //   180	1	4	localException2	java.lang.Exception
    //   12	113	5	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   14	44	127	java/lang/Exception
    //   14	44	156	finally
    //   50	59	176	finally
    //   61	70	176	finally
    //   72	78	176	finally
    //   80	86	176	finally
    //   88	96	176	finally
    //   98	105	176	finally
    //   133	143	176	finally
    //   50	59	180	java/lang/Exception
    //   61	70	180	java/lang/Exception
    //   72	78	180	java/lang/Exception
    //   80	86	180	java/lang/Exception
    //   88	96	180	java/lang/Exception
    //   98	105	180	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.v
 * JD-Core Version:    0.7.0.1
 */