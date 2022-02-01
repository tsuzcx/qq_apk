package com.tencent.mm.plugin.selectrecord.d;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.zd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.cc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class b
  extends MAutoStorage<a>
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(266718);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(a.info, "SelectRecord") };
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS SelectRecord_historyIdIndex ON SelectRecord ( historyId )" };
    AppMethodBeat.o(266718);
  }
  
  public b(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, a.info, "SelectRecord", INDEX_CREATE);
    this.db = paramISQLiteDatabase;
  }
  
  /* Error */
  private a aVv(String paramString)
  {
    // Byte code:
    //   0: ldc 53
    //   2: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 50	com/tencent/mm/plugin/selectrecord/d/b:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   9: ldc 29
    //   11: getstatic 27	com/tencent/mm/plugin/selectrecord/d/a:info	Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;
    //   14: getfield 58	com/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo:columns	[Ljava/lang/String;
    //   17: ldc 60
    //   19: iconst_1
    //   20: anewarray 21	java/lang/String
    //   23: dup
    //   24: iconst_0
    //   25: aload_1
    //   26: aastore
    //   27: aconst_null
    //   28: aconst_null
    //   29: aconst_null
    //   30: iconst_2
    //   31: invokeinterface 66 9 0
    //   36: astore_1
    //   37: aload_1
    //   38: ifnonnull +10 -> 48
    //   41: ldc 53
    //   43: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: aconst_null
    //   47: areturn
    //   48: new 68	java/util/ArrayList
    //   51: dup
    //   52: invokespecial 70	java/util/ArrayList:<init>	()V
    //   55: astore_3
    //   56: aload_1
    //   57: invokeinterface 76 1 0
    //   62: ifeq +60 -> 122
    //   65: new 23	com/tencent/mm/plugin/selectrecord/d/a
    //   68: dup
    //   69: invokespecial 77	com/tencent/mm/plugin/selectrecord/d/a:<init>	()V
    //   72: astore 4
    //   74: aload 4
    //   76: aload_1
    //   77: invokevirtual 81	com/tencent/mm/plugin/selectrecord/d/a:convertFrom	(Landroid/database/Cursor;)V
    //   80: aload_3
    //   81: aload 4
    //   83: invokeinterface 87 2 0
    //   88: pop
    //   89: goto -33 -> 56
    //   92: astore_3
    //   93: ldc 89
    //   95: aload_3
    //   96: ldc 91
    //   98: iconst_0
    //   99: anewarray 93	java/lang/Object
    //   102: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   105: aload_1
    //   106: ifnull +9 -> 115
    //   109: aload_1
    //   110: invokeinterface 102 1 0
    //   115: ldc 53
    //   117: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: aconst_null
    //   121: areturn
    //   122: aload_3
    //   123: invokeinterface 106 1 0
    //   128: istore_2
    //   129: iload_2
    //   130: ifne +20 -> 150
    //   133: aload_1
    //   134: ifnull +9 -> 143
    //   137: aload_1
    //   138: invokeinterface 102 1 0
    //   143: ldc 53
    //   145: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   148: aconst_null
    //   149: areturn
    //   150: aload_3
    //   151: iconst_0
    //   152: invokeinterface 110 2 0
    //   157: checkcast 23	com/tencent/mm/plugin/selectrecord/d/a
    //   160: astore_3
    //   161: aload_1
    //   162: ifnull +9 -> 171
    //   165: aload_1
    //   166: invokeinterface 102 1 0
    //   171: ldc 53
    //   173: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   176: aload_3
    //   177: areturn
    //   178: astore_3
    //   179: aload_1
    //   180: ifnull +9 -> 189
    //   183: aload_1
    //   184: invokeinterface 102 1 0
    //   189: ldc 53
    //   191: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   194: aload_3
    //   195: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	this	b
    //   0	196	1	paramString	String
    //   128	2	2	i	int
    //   55	26	3	localArrayList	ArrayList
    //   92	59	3	localThrowable	java.lang.Throwable
    //   160	17	3	locala1	a
    //   178	17	3	localObject	Object
    //   72	10	4	locala2	a
    // Exception table:
    //   from	to	target	type
    //   48	56	92	finally
    //   56	89	92	finally
    //   122	129	92	finally
    //   150	161	92	finally
    //   93	105	178	finally
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(266722);
    if (parama == null)
    {
      AppMethodBeat.o(266722);
      return false;
    }
    boolean bool = super.insert(parama);
    AppMethodBeat.o(266722);
    return bool;
  }
  
  public final boolean a(String paramString, zd paramzd)
  {
    AppMethodBeat.i(266731);
    a locala = aVv(paramString);
    if (locala == null)
    {
      Log.e("MicroMsg.selectRecord.SelectRecordStorage", "updateChatHistoryItem() called with: historyId = [" + paramString + "], item = [" + paramzd + "] selectRecordItem == null");
      AppMethodBeat.o(266731);
      return false;
    }
    locala.field_chatHistoryItem = paramzd;
    boolean bool = super.update(locala.systemRowid, locala);
    int i = paramzd.ZhI.size();
    Log.i("MicroMsg.selectRecord.SelectRecordStorage", "updateChatHistoryItem() called with: historyId = [" + paramString + "], item = [" + paramzd + "] updateRes:%s itemsize:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
    AppMethodBeat.o(266731);
    return bool;
  }
  
  public final boolean aVu(String paramString)
  {
    AppMethodBeat.i(266738);
    a locala = aVv(paramString);
    if (locala == null)
    {
      Log.e("MicroMsg.selectRecord.SelectRecordStorage", "deleteRelatedMsgs() called with: historyId = [" + paramString + "] selectRecordItem == null");
      AppMethodBeat.o(266738);
      return false;
    }
    if ((!TextUtils.isEmpty(locala.field_talker)) && (locala.field_chatHistoryItem != null) && (locala.field_chatHistoryItem.ZhI != null) && (locala.field_chatHistoryItem.ZhI.size() > 0)) {
      try
      {
        paramString = locala.field_chatHistoryItem.ZhI.iterator();
        while (paramString.hasNext())
        {
          long l = ((Long)paramString.next()).longValue();
          br.E(locala.field_talker, l);
        }
        AppMethodBeat.o(266738);
      }
      finally
      {
        Log.printErrStackTrace("MicroMsg.selectRecord.SelectRecordStorage", paramString, "deleteRelatedMsgs err", new Object[0]);
      }
    }
    return true;
  }
  
  public final cc aVw(String paramString)
  {
    AppMethodBeat.i(266747);
    cc localcc1 = new cc();
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(266747);
      return localcc1;
    }
    paramString = this.db.query("SelectRecord", a.info.columns, "historyId=?", new String[] { paramString }, null, null, null, 2);
    if (paramString == null)
    {
      AppMethodBeat.o(266747);
      return localcc1;
    }
    ArrayList localArrayList;
    try
    {
      localArrayList = new ArrayList();
      while (paramString.moveToNext())
      {
        a locala = new a();
        locala.convertFrom(paramString);
        localArrayList.add(locala);
      }
      i = localArrayList.size();
    }
    finally
    {
      if (paramString != null) {
        paramString.close();
      }
      AppMethodBeat.o(266747);
    }
    int i;
    if (i == 0)
    {
      if (paramString != null) {
        paramString.close();
      }
      AppMethodBeat.o(266747);
      return localcc2;
    }
    Object localObject = (a)localArrayList.get(0);
    localObject = ((n)h.ax(n.class)).gaZ().sl(((a)localObject).field_msgId);
    if (paramString != null) {
      paramString.close();
    }
    AppMethodBeat.o(266747);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.selectrecord.d.b
 * JD-Core Version:    0.7.0.1
 */