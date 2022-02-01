package com.tencent.mm.plugin.webview.modeltools;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.HashSet;
import java.util.Set;

public final class n
  extends MAutoStorage<i>
{
  public static final String[] SQL_CREATE;
  private final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(79224);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(i.info, "WebViewHostsFilter") };
    AppMethodBeat.o(79224);
  }
  
  public n(ISQLiteDatabase paramISQLiteDatabase)
  {
    this(paramISQLiteDatabase, i.info, "WebViewHostsFilter");
  }
  
  private n(ISQLiteDatabase paramISQLiteDatabase, IAutoDBItem.MAutoDBInfo paramMAutoDBInfo, String paramString)
  {
    super(paramISQLiteDatabase, paramMAutoDBInfo, paramString, null);
    this.db = paramISQLiteDatabase;
  }
  
  public final Set<String> iwi()
  {
    AppMethodBeat.i(79223);
    long l = Util.nowSecond();
    Log.d("MicroMsg.WebViewStorage", "webview hijack deleteExpiredItem now = ".concat(String.valueOf(l)));
    Log.i("MicroMsg.WebViewStorage", "delete expired items request  : [%b]", new Object[] { Boolean.valueOf(execSQL("WebViewHostsFilter", "delete from WebViewHostsFilter where expireTime < ".concat(String.valueOf(l)))) });
    Cursor localCursor = this.db.query(getTableName(), new String[] { "host" }, null, null, null, null, null, 2);
    HashSet localHashSet = new HashSet();
    if ((localCursor != null) && (localCursor.moveToFirst())) {
      do
      {
        String str = localCursor.getString(0);
        if (!Util.isNullOrNil(str))
        {
          localHashSet.add(str);
          Log.d("MicroMsg.WebViewStorage", "webview hijack gethost = ".concat(String.valueOf(str)));
        }
      } while (localCursor.moveToNext());
    }
    if (localCursor != null) {
      localCursor.close();
    }
    AppMethodBeat.o(79223);
    return localHashSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.n
 * JD-Core Version:    0.7.0.1
 */