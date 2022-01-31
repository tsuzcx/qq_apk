package com.tencent.mm.plugin.webview.modeltools;

import android.database.Cursor;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;
import java.util.Set;

public final class k
  extends com.tencent.mm.sdk.e.i<i>
{
  public static final String[] dXp = { com.tencent.mm.sdk.e.i.a(i.buS, "WebViewHostsFilter") };
  private final e dXw;
  
  public k(e parame)
  {
    this(parame, i.buS, "WebViewHostsFilter");
  }
  
  private k(e parame, c.a parama, String paramString)
  {
    super(parame, parama, paramString, null);
    this.dXw = parame;
  }
  
  public final Set<String> ccR()
  {
    long l = bk.UX();
    y.d("MicroMsg.WebViewStorage", "webview hijack deleteExpiredItem now = " + l);
    y.i("MicroMsg.WebViewStorage", "delete expired items request  : [%b]", new Object[] { Boolean.valueOf(gk("WebViewHostsFilter", "delete from WebViewHostsFilter where expireTime < " + l)) });
    Cursor localCursor = this.dXw.a(getTableName(), new String[] { "host" }, null, null, null, null, null, 2);
    HashSet localHashSet = new HashSet();
    if ((localCursor != null) && (localCursor.moveToFirst())) {
      do
      {
        String str = localCursor.getString(0);
        if (!bk.bl(str))
        {
          localHashSet.add(str);
          y.d("MicroMsg.WebViewStorage", "webview hijack gethost = " + str);
        }
      } while (localCursor.moveToNext());
    }
    if (localCursor != null) {
      localCursor.close();
    }
    return localHashSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.k
 * JD-Core Version:    0.7.0.1
 */