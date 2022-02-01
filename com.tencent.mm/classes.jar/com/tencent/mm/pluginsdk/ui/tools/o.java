package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public final class o
{
  private static final String Kwq;
  
  static
  {
    AppMethodBeat.i(198777);
    Kwq = "https://" + WeChatHosts.domainString(2131761733) + "/cgi-bin/getunreadmailcount?f=xml&appname=qqmail_weixin&charset=utf-8&clientip=0";
    AppMethodBeat.o(198777);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(123216);
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(123211);
        try
        {
          o.b(this.Kwr);
          AppMethodBeat.o(123211);
          return;
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("MicroMsg.QQMailUnreadHelper", localException, "", new Object[0]);
          Log.e("MicroMsg.QQMailUnreadHelper", "getUnreadCountAsync exception");
          AppMethodBeat.o(123211);
        }
      }
    }, "QQMailUnreadHelper");
    AppMethodBeat.o(123216);
  }
  
  public static void b(a parama)
  {
    AppMethodBeat.i(123217);
    Log.i("MicroMsg.QQMailUnreadHelper", "dz[getUnreadCount]");
    String str = (String)g.aAh().azQ().get(-1535680990, "");
    long l = new p(Util.nullAsNil((Integer)g.aAh().azQ().get(9, null))).longValue();
    if ((Util.isNullOrNil(str)) || (l == 0L))
    {
      g.aAh().azQ().set(ar.a.NTG, Integer.valueOf(-1));
      Log.w("MicroMsg.QQMailUnreadHelper", "dz[getUnreadEmailCountAndSet: authkey or uin is null]");
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(123212);
          this.Kwr.eGv();
          AppMethodBeat.o(123212);
        }
      });
      AppMethodBeat.o(123217);
      return;
    }
    Object localObject = (HttpURLConnection)new URL(Kwq).openConnection();
    ((HttpURLConnection)localObject).setConnectTimeout(15000);
    ((HttpURLConnection)localObject).setReadTimeout(20000);
    ((HttpURLConnection)localObject).setRequestProperty("Cookie", String.format("skey=%s;uin=o%d;", new Object[] { str, Long.valueOf(l) }));
    if (((HttpURLConnection)localObject).getResponseCode() >= 300) {
      try
      {
        ((HttpURLConnection)localObject).getInputStream().close();
        ((HttpURLConnection)localObject).disconnect();
        Log.w("MicroMsg.QQMailUnreadHelper", "dz[getUnreadCount http 300]");
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(123213);
            this.Kwr.eGv();
            AppMethodBeat.o(123213);
          }
        });
        AppMethodBeat.o(123217);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.QQMailUnreadHelper", localException.getMessage());
        }
      }
    }
    localObject = XmlParser.parseXml(Util.convertStreamToString(((HttpURLConnection)localObject).getInputStream()), "Response", null);
    if ((localObject != null) && (Util.getInt((String)((Map)localObject).get(".Response.error.code"), -1) == 0)) {}
    for (final int i = Util.getInt((String)((Map)localObject).get(".Response.result.UnreadCount"), -1); i < 0; i = -1)
    {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(123214);
          this.Kwr.eGv();
          AppMethodBeat.o(123214);
        }
      });
      AppMethodBeat.o(123217);
      return;
    }
    g.aAh().azQ().set(ar.a.NTG, Integer.valueOf(i));
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(123215);
        this.Kwr.onSuccess(i);
        AppMethodBeat.o(123215);
      }
    });
    AppMethodBeat.o(123217);
  }
  
  public static abstract interface a
  {
    public abstract void eGv();
    
    public abstract void onSuccess(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.o
 * JD-Core Version:    0.7.0.1
 */