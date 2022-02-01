package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public final class m
{
  public static void a(a parama)
  {
    AppMethodBeat.i(123216);
    b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(123211);
        try
        {
          m.b(this.DFL);
          AppMethodBeat.o(123211);
          return;
        }
        catch (Exception localException)
        {
          ac.printErrStackTrace("MicroMsg.QQMailUnreadHelper", localException, "", new Object[0]);
          ac.e("MicroMsg.QQMailUnreadHelper", "getUnreadCountAsync exception");
          AppMethodBeat.o(123211);
        }
      }
    }, "QQMailUnreadHelper");
    AppMethodBeat.o(123216);
  }
  
  public static void b(a parama)
  {
    AppMethodBeat.i(123217);
    ac.i("MicroMsg.QQMailUnreadHelper", "dz[getUnreadCount]");
    String str = (String)g.agR().agA().get(-1535680990, "");
    long l = new p(bs.m((Integer)g.agR().agA().get(9, null))).longValue();
    if ((bs.isNullOrNil(str)) || (l == 0L))
    {
      g.agR().agA().set(ah.a.GEP, Integer.valueOf(-1));
      ac.w("MicroMsg.QQMailUnreadHelper", "dz[getUnreadEmailCountAndSet: authkey or uin is null]");
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(123212);
          this.DFL.drR();
          AppMethodBeat.o(123212);
        }
      });
      AppMethodBeat.o(123217);
      return;
    }
    Object localObject = (HttpURLConnection)new URL("https://qqmail.weixin.qq.com/cgi-bin/getunreadmailcount?f=xml&appname=qqmail_weixin&charset=utf-8&clientip=0").openConnection();
    ((HttpURLConnection)localObject).setConnectTimeout(15000);
    ((HttpURLConnection)localObject).setReadTimeout(20000);
    ((HttpURLConnection)localObject).setRequestProperty("Cookie", String.format("skey=%s;uin=o%d;", new Object[] { str, Long.valueOf(l) }));
    if (((HttpURLConnection)localObject).getResponseCode() >= 300) {
      try
      {
        ((HttpURLConnection)localObject).getInputStream().close();
        ((HttpURLConnection)localObject).disconnect();
        ac.w("MicroMsg.QQMailUnreadHelper", "dz[getUnreadCount http 300]");
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(123213);
            this.DFL.drR();
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
          ac.e("MicroMsg.QQMailUnreadHelper", localException.getMessage());
        }
      }
    }
    localObject = bv.L(bs.convertStreamToString(((HttpURLConnection)localObject).getInputStream()), "Response");
    if ((localObject != null) && (bs.getInt((String)((Map)localObject).get(".Response.error.code"), -1) == 0)) {}
    for (final int i = bs.getInt((String)((Map)localObject).get(".Response.result.UnreadCount"), -1); i < 0; i = -1)
    {
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(123214);
          this.DFL.drR();
          AppMethodBeat.o(123214);
        }
      });
      AppMethodBeat.o(123217);
      return;
    }
    g.agR().agA().set(ah.a.GEP, Integer.valueOf(i));
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(123215);
        this.DFL.onSuccess(i);
        AppMethodBeat.o(123215);
      }
    });
    AppMethodBeat.o(123217);
  }
  
  public static abstract interface a
  {
    public abstract void drR();
    
    public abstract void onSuccess(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.m
 * JD-Core Version:    0.7.0.1
 */