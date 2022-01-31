package com.tencent.mm.plugin.webview.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

final class b$1
  implements Runnable
{
  b$1(b paramb, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  public final void run()
  {
    AppMethodBeat.i(5624);
    c localc;
    Object localObject1;
    long l2;
    Object localObject2;
    label117:
    String str1;
    if (this.uOb > 0L)
    {
      localc = this.uOf.daw();
      localObject1 = this.val$appId;
      l2 = this.uOb;
      localObject1 = String.format("select * from %s where appId='%s' order by weight,timeStamp", new Object[] { "WebViewData", localObject1 });
      ab.d("MicroMsg.WebViewDataStorage", "deleteSize querySql: ".concat(String.valueOf(localObject1)));
      localObject2 = localc.rawQuery((String)localObject1, new String[0]);
      if (localObject2 == null)
      {
        l1 = 0L;
        b.a(this.uOf).put(this.val$appId, Long.valueOf(this.uOc - l1));
        localc = this.uOf.daw();
        localObject1 = this.val$appId;
        localObject2 = this.val$key;
        str1 = this.bBG;
        String str2 = bo.bf(this.uOd, "1");
        l1 = b.agK(this.uOe);
        a locala = new a();
        locala.field_appId = ((String)localObject1);
        locala.field_appIdKey = c.hn((String)localObject1, (String)localObject2);
        locala.field_value = str1;
        locala.field_weight = str2;
        locala.field_expireTime = (l1 + System.currentTimeMillis() / 1000L);
        locala.field_size = (((String)localObject2).getBytes().length + str1.getBytes().length);
        locala.field_timeStamp = (System.currentTimeMillis() / 1000L);
        ab.d("MicroMsg.WebViewDataStorage", "setData: ".concat(String.valueOf(localc.replace(locala))));
        localc = this.uOf.daw();
        localObject1 = this.val$appId;
        if (b.a(this.uOf).get(this.val$appId) != null) {
          break label683;
        }
      }
    }
    label683:
    for (long l1 = 0L;; l1 = ((Long)b.a(this.uOf).get(this.val$appId)).longValue())
    {
      localObject2 = new a();
      ((a)localObject2).field_appId = ((String)localObject1);
      ((a)localObject2).field_appIdKey = c.av((String)localObject1, "###@@@@TOTAL@@@###SIZE####", "_");
      ((a)localObject2).field_expireTime = 9223372036854775807L;
      ((a)localObject2).field_size = l1;
      ab.d("MicroMsg.WebViewDataStorage", "setAppIdSize: %b, size: %d", new Object[] { Boolean.valueOf(localc.replace((com.tencent.mm.sdk.e.c)localObject2)), Long.valueOf(l1) });
      b.b(this.uOf);
      AppMethodBeat.o(5624);
      return;
      localObject1 = new LinkedList();
      long l3;
      for (l1 = l2; (((Cursor)localObject2).moveToFirst()) && (l1 > 0L); l1 -= l3)
      {
        str1 = ((Cursor)localObject2).getString(1);
        l3 = ((Cursor)localObject2).getLong(6);
        ((List)localObject1).add(str1);
      }
      ((Cursor)localObject2).close();
      if (((List)localObject1).size() > 0)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("(");
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          str1 = (String)((Iterator)localObject1).next();
          ((StringBuilder)localObject2).append("\"" + str1 + "\",");
        }
        ((StringBuilder)localObject2).deleteCharAt(((StringBuilder)localObject2).length() - 1);
        ((StringBuilder)localObject2).append(")");
        localObject1 = String.format("delete from %s where %s in %s", new Object[] { "WebViewData", "appIdKey", ((StringBuilder)localObject2).toString() });
        ab.d("MicroMsg.WebViewDataStorage", "deleteSize deleteSql: ".concat(String.valueOf(localObject1)));
        ab.d("MicroMsg.WebViewDataStorage", "deleteSize: ".concat(String.valueOf(localc.execSQL("WebViewData", (String)localObject1))));
      }
      l1 = l2 - l1;
      break;
      b.a(this.uOf).put(this.val$appId, Long.valueOf(this.uOc));
      break label117;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.b.b.1
 * JD-Core Version:    0.7.0.1
 */