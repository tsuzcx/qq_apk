package com.tencent.mm.plugin.webview.modeltools;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashSet;
import java.util.Set;

public final class m
  extends j<i>
{
  public static final String[] SQL_CREATE;
  private final e db;
  
  static
  {
    AppMethodBeat.i(79224);
    SQL_CREATE = new String[] { j.getCreateSQLs(i.info, "WebViewHostsFilter") };
    AppMethodBeat.o(79224);
  }
  
  public m(e parame)
  {
    this(parame, i.info, "WebViewHostsFilter");
  }
  
  private m(e parame, c.a parama, String paramString)
  {
    super(parame, parama, paramString, null);
    this.db = parame;
  }
  
  public final Set<String> eRd()
  {
    AppMethodBeat.i(79223);
    long l = bt.aQJ();
    ad.d("MicroMsg.WebViewStorage", "webview hijack deleteExpiredItem now = ".concat(String.valueOf(l)));
    ad.i("MicroMsg.WebViewStorage", "delete expired items request  : [%b]", new Object[] { Boolean.valueOf(execSQL("WebViewHostsFilter", "delete from WebViewHostsFilter where expireTime < ".concat(String.valueOf(l)))) });
    Cursor localCursor = this.db.a(getTableName(), new String[] { "host" }, null, null, null, null, null, 2);
    HashSet localHashSet = new HashSet();
    if ((localCursor != null) && (localCursor.moveToFirst())) {
      do
      {
        String str = localCursor.getString(0);
        if (!bt.isNullOrNil(str))
        {
          localHashSet.add(str);
          ad.d("MicroMsg.WebViewStorage", "webview hijack gethost = ".concat(String.valueOf(str)));
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
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.m
 * JD-Core Version:    0.7.0.1
 */