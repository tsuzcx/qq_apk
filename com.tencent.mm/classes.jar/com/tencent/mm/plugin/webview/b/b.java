package com.tencent.mm.plugin.webview.b;

import android.database.Cursor;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

public final class b
{
  private static long qYq = 2592000L;
  private static b qYr;
  private c qYs;
  private Map<String, Long> qYt = new HashMap();
  private long qYu = 0L;
  
  public static b cav()
  {
    if (qYr == null) {
      qYr = new b();
    }
    return qYr;
  }
  
  public final void RG(String paramString)
  {
    c localc = caw();
    paramString = String.format("delete from %s where %s=\"%s\"", new Object[] { "WebViewData", "appId", paramString });
    y.d("MicroMsg.WebViewDataStorage", "cleanAllData: " + paramString);
    boolean bool = localc.gk("WebViewData", paramString);
    y.d("MicroMsg.WebViewDataStorage", "cleanAllData: " + bool);
  }
  
  public final boolean a(String paramString1, final String paramString2, String paramString3, final String paramString4, final String paramString5, boolean paramBoolean)
  {
    Object localObject = caw().rawQuery(String.format("select %s from %s where %s=\"%s\"", new Object[] { "size", "WebViewData", "appIdKey", c.fs(paramString1, paramString2) }), new String[0]);
    long l2;
    long l4;
    long l5;
    label105:
    final long l3;
    if (localObject == null)
    {
      l2 = 0L;
      l4 = paramString2.getBytes().length + paramString3.getBytes().length;
      l5 = l4 - l2;
      if (!this.qYt.containsKey(paramString1)) {
        break label231;
      }
      l1 = ((Long)this.qYt.get(paramString1)).longValue();
      l3 = l1 + l5;
      if (!paramString1.equals("wx62d9035fd4fd2059")) {
        break label377;
      }
    }
    label231:
    label377:
    for (final long l1 = l3 - 52428800L;; l1 = l3 - 10485760L)
    {
      y.i("MicroMsg.WebViewDataCenter", "prevSize = %d, valueSize = %d, diffSize = %d, newAppSize = %d, expireSize = %d", new Object[] { Long.valueOf(l2), Long.valueOf(l4), Long.valueOf(l5), Long.valueOf(l3), Long.valueOf(l1) });
      if ((l1 <= 0L) || (paramBoolean)) {
        break label388;
      }
      return false;
      l1 = 0L;
      if (((Cursor)localObject).moveToFirst()) {
        l1 = ((Cursor)localObject).getLong(0);
      }
      ((Cursor)localObject).close();
      l2 = l1;
      break;
      localObject = caw();
      String str = String.format("select %s from %s where %s=\"%s\"", new Object[] { "size", "WebViewData", "appIdKey", c.ah(paramString1, "###@@@@TOTAL@@@###SIZE####", "_") });
      y.d("MicroMsg.WebViewDataStorage", "getAppIdSize: " + str);
      l3 = 0L;
      localObject = ((c)localObject).rawQuery(str, new String[0]);
      l1 = l3;
      if (localObject != null)
      {
        l1 = l3;
        if (((Cursor)localObject).moveToFirst()) {
          l1 = ((Cursor)localObject).getLong(0);
        }
        ((Cursor)localObject).close();
      }
      y.d("MicroMsg.WebViewDataStorage", "getAppIdSize: " + l1);
      break label105;
    }
    label388:
    au.DS().O(new Runnable()
    {
      public final void run()
      {
        c localc;
        Object localObject1;
        long l2;
        Object localObject2;
        label118:
        String str1;
        boolean bool;
        if (l1 > 0L)
        {
          localc = b.this.caw();
          localObject1 = l3;
          l2 = l1;
          localObject1 = String.format("select * from %s where appId='%s' order by weight,timeStamp", new Object[] { "WebViewData", localObject1 });
          y.d("MicroMsg.WebViewDataStorage", "deleteSize querySql: " + (String)localObject1);
          localObject2 = localc.rawQuery((String)localObject1, new String[0]);
          if (localObject2 == null)
          {
            l1 = 0L;
            b.a(b.this).put(l3, Long.valueOf(paramString2 - l1));
            localc = b.this.caw();
            localObject1 = l3;
            localObject2 = paramString4;
            str1 = paramString5;
            String str2 = bk.aM(this.qYx, "1");
            l1 = b.RH(this.qYy);
            a locala = new a();
            locala.field_appId = ((String)localObject1);
            locala.field_appIdKey = c.fs((String)localObject1, (String)localObject2);
            locala.field_value = str1;
            locala.field_weight = str2;
            locala.field_expireTime = (l1 + System.currentTimeMillis() / 1000L);
            locala.field_size = (((String)localObject2).getBytes().length + str1.getBytes().length);
            locala.field_timeStamp = (System.currentTimeMillis() / 1000L);
            bool = localc.a(locala);
            y.d("MicroMsg.WebViewDataStorage", "setData: " + bool);
            localc = b.this.caw();
            localObject1 = l3;
            if (b.a(b.this).get(l3) != null) {
              break label703;
            }
          }
        }
        label703:
        for (long l1 = 0L;; l1 = ((Long)b.a(b.this).get(l3)).longValue())
        {
          localObject2 = new a();
          ((a)localObject2).field_appId = ((String)localObject1);
          ((a)localObject2).field_appIdKey = c.ah((String)localObject1, "###@@@@TOTAL@@@###SIZE####", "_");
          ((a)localObject2).field_expireTime = 9223372036854775807L;
          ((a)localObject2).field_size = l1;
          y.d("MicroMsg.WebViewDataStorage", "setAppIdSize: %b, size: %d", new Object[] { Boolean.valueOf(localc.a((com.tencent.mm.sdk.e.c)localObject2)), Long.valueOf(l1) });
          b.b(b.this);
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
            y.d("MicroMsg.WebViewDataStorage", "deleteSize deleteSql: " + (String)localObject1);
            bool = localc.gk("WebViewData", (String)localObject1);
            y.d("MicroMsg.WebViewDataStorage", "deleteSize: " + bool);
          }
          l1 = l2 - l1;
          break;
          b.a(b.this).put(l3, Long.valueOf(paramString2));
          break label118;
        }
      }
    });
    return true;
  }
  
  public final void b(String paramString, JSONArray paramJSONArray)
  {
    c localc = caw();
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    int i = 0;
    for (;;)
    {
      if (i < paramJSONArray.length()) {
        try
        {
          String str = paramJSONArray.getString(i);
          localStringBuilder.append("\"" + c.fs(paramString, str) + "\",");
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            y.e("MicroMsg.WebViewDataStorage", "clearData: " + localException.getMessage());
          }
        }
      }
    }
    localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    localStringBuilder.append(")");
    paramString = String.format("delete from %s where %s in %s", new Object[] { "WebViewData", "appIdKey", localStringBuilder.toString() });
    y.d("MicroMsg.WebViewDataStorage", "deleteData: " + paramString);
    boolean bool = localc.gk("WebViewData", paramString);
    y.d("MicroMsg.WebViewDataStorage", "clearData: " + bool);
  }
  
  public final c caw()
  {
    if (this.qYs == null)
    {
      g.DQ();
      this.qYs = new c(g.DP().dKu);
    }
    return this.qYs;
  }
  
  public final a fr(String paramString1, String paramString2)
  {
    c localc = caw();
    paramString1 = String.format("select * from %s where %s=\"%s\"", new Object[] { "WebViewData", "appIdKey", c.fs(paramString1, paramString2) });
    y.d("MicroMsg.WebViewDataStorage", "getData: " + paramString1);
    paramString1 = localc.rawQuery(paramString1, new String[0]);
    paramString2 = new a();
    if (paramString1 != null)
    {
      if (paramString1.moveToFirst()) {
        paramString2.d(paramString1);
      }
      paramString1.close();
    }
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.b.b
 * JD-Core Version:    0.7.0.1
 */