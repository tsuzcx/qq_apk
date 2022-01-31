package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.mm.a.o;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

final class i$1
  implements Runnable
{
  i$1(i.a parama) {}
  
  public final void run()
  {
    HttpURLConnection localHttpURLConnection;
    try
    {
      i.a locala = this.sna;
      y.i("MicroMsg.QQMailUnreadHelper", "dz[getUnreadCount]");
      localObject = (String)g.DP().Dz().get(-1535680990, "");
      long l = new o(bk.g((Integer)g.DP().Dz().get(9, null))).longValue();
      if ((bk.bl((String)localObject)) || (l == 0L))
      {
        g.DP().Dz().c(ac.a.uoK, Integer.valueOf(-1));
        y.w("MicroMsg.QQMailUnreadHelper", "dz[getUnreadEmailCountAndSet: authkey or uin is null]");
        ai.d(new i.2(locala));
        return;
      }
      localHttpURLConnection = (HttpURLConnection)new URL("https://qqmail.weixin.qq.com/cgi-bin/getunreadmailcount?f=xml&appname=qqmail_weixin&charset=utf-8&clientip=0").openConnection();
      localHttpURLConnection.setConnectTimeout(15000);
      localHttpURLConnection.setReadTimeout(20000);
      localHttpURLConnection.setRequestProperty("Cookie", String.format("skey=%s;uin=o%d;", new Object[] { localObject, Long.valueOf(l) }));
      if (localHttpURLConnection.getResponseCode() >= 300)
      {
        localHttpURLConnection.disconnect();
        y.w("MicroMsg.QQMailUnreadHelper", "dz[getUnreadCount http 300]");
        ai.d(new i.3(locala));
        return;
      }
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.QQMailUnreadHelper", localException, "", new Object[0]);
      y.e("MicroMsg.QQMailUnreadHelper", "getUnreadCountAsync exception");
      return;
    }
    Object localObject = bn.s(bk.convertStreamToString(localHttpURLConnection.getInputStream()), "Response");
    if ((localObject != null) && (bk.getInt((String)((Map)localObject).get(".Response.error.code"), -1) == 0)) {}
    for (int i = bk.getInt((String)((Map)localObject).get(".Response.result.UnreadCount"), -1);; i = -1)
    {
      if (i < 0)
      {
        ai.d(new i.4(localException));
        return;
      }
      g.DP().Dz().c(ac.a.uoK, Integer.valueOf(i));
      ai.d(new i.5(localException, i));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.i.1
 * JD-Core Version:    0.7.0.1
 */