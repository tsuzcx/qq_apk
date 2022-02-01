package com.tencent.mm.ui.q;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bd.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ao;
import java.util.ArrayList;
import java.util.List;
import org.b.a.a.c.a;
import org.b.d.c;
import org.b.d.g;
import org.b.d.k;
import org.b.g.d;

@SuppressLint({"HandlerLeak"})
public final class a
  implements b.a
{
  MMHandler KBt;
  org.b.e.b XZf;
  public org.b.d.i XZg;
  org.b.d.i XZh;
  private boolean XZi;
  boolean XZj;
  public b XZk;
  public a.a XZl;
  Context context;
  
  public a()
  {
    AppMethodBeat.i(152862);
    this.XZf = null;
    this.XZg = null;
    this.XZh = null;
    this.XZi = false;
    this.XZj = false;
    this.XZk = null;
    this.XZl = null;
    this.context = null;
    this.KBt = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(152852);
        Object localObject;
        Context localContext;
        a locala;
        if (paramAnonymousMessage.what == 1000)
        {
          localObject = (String)paramAnonymousMessage.obj;
          if (localObject == null) {
            break label142;
          }
          localContext = a.this.context;
          locala = a.this;
          if (localContext.checkCallingOrSelfPermission("android.permission.INTERNET") == 0) {
            break label125;
          }
          com.tencent.mm.ui.i.a.f.ag(localContext, "Error", "Application requires permission to access the Internet");
        }
        for (;;)
        {
          if (paramAnonymousMessage.what == 1010)
          {
            paramAnonymousMessage = (a.c)paramAnonymousMessage.obj;
            localObject = a.this;
            ((a)localObject).XZj = false;
            if (paramAnonymousMessage == a.c.XZq)
            {
              ((a)localObject).XZh = null;
              a.a(null);
            }
            if (((a)localObject).XZl != null) {
              ((a)localObject).XZl.b(paramAnonymousMessage);
            }
          }
          AppMethodBeat.o(152852);
          return;
          label125:
          new b(localContext, (String)localObject, locala).show();
          continue;
          label142:
          a.this.c(a.c.XZq);
        }
      }
    };
    Object localObject = new org.b.a.a();
    ((org.b.a.a)localObject).abLz = org.b.a.a.cg(c.a.class);
    d.pJ("XMr2y8FEVEqZBcZ1TU3gLA", "Invalid Api key");
    ((org.b.a.a)localObject).abLw = "XMr2y8FEVEqZBcZ1TU3gLA";
    d.pJ("kyWwA5vbB6H1NDQFufR9hD5vWGStxhweIbatclCo", "Invalid Api secret");
    ((org.b.a.a)localObject).abLx = "kyWwA5vbB6H1NDQFufR9hD5vWGStxhweIbatclCo";
    d.n("wechatapp://sign-in-twitter.wechatapp.com/", "Callback can't be null");
    ((org.b.a.a)localObject).abLy = "wechatapp://sign-in-twitter.wechatapp.com/";
    d.n(((org.b.a.a)localObject).abLz, "You must specify a valid api through the provider() method");
    d.pJ(((org.b.a.a)localObject).abLw, "You must provide an api key");
    d.pJ(((org.b.a.a)localObject).abLx, "You must provide an api secret");
    this.XZf = ((org.b.a.a)localObject).abLz.a(new org.b.d.a(((org.b.a.a)localObject).abLw, ((org.b.a.a)localObject).abLx, ((org.b.a.a)localObject).abLy, ((org.b.a.a)localObject).abLA, ((org.b.a.a)localObject).scope, ((org.b.a.a)localObject).abLB));
    String str;
    if (com.tencent.mm.kernel.h.aHE().aGM())
    {
      localObject = (String)com.tencent.mm.kernel.h.aHG().aHp().b(69377, null);
      str = (String)com.tencent.mm.kernel.h.aHG().aHp().b(69378, null);
      if ((Util.isNullOrNil((String)localObject)) || (Util.isNullOrNil(str))) {
        localObject = null;
      }
    }
    for (;;)
    {
      this.XZg = ((org.b.d.i)localObject);
      AppMethodBeat.o(152862);
      return;
      localObject = new org.b.d.i((String)localObject, str);
      continue;
      Log.e("Twitter", "acchas not ready for restoreTwitterAccessToken");
      localObject = null;
    }
  }
  
  static void Hj(boolean paramBoolean)
  {
    AppMethodBeat.i(152870);
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean) {}
    for (String str = "1";; str = "2")
    {
      localArrayList.add(new i.a(10251, str));
      ((n)com.tencent.mm.kernel.h.ae(n.class)).bbK().d(new com.tencent.mm.bd.i(localArrayList));
      AppMethodBeat.o(152870);
      return;
    }
  }
  
  static void a(org.b.d.i parami)
  {
    AppMethodBeat.i(152865);
    MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
    if (parami == null)
    {
      com.tencent.mm.kernel.h.aHG().aHp().i(69377, "");
      com.tencent.mm.kernel.h.aHG().aHp().i(69378, "");
      AppMethodBeat.o(152865);
      return;
    }
    com.tencent.mm.kernel.h.aHG().aHp().i(69377, parami.token);
    com.tencent.mm.kernel.h.aHG().aHp().i(69378, parami.TEk);
    AppMethodBeat.o(152865);
  }
  
  public final void K(final Bundle paramBundle)
  {
    AppMethodBeat.i(152867);
    com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        Object localObject3 = null;
        AppMethodBeat.i(152857);
        if (a.this.XZh == null)
        {
          AppMethodBeat.o(152857);
          return;
        }
        a.Hj(true);
        String str = paramBundle.getString("oauth_verifier");
        Object localObject1 = localObject3;
        if (str != null) {
          localObject1 = new k(str);
        }
        try
        {
          localObject1 = a.this.XZf.a(a.this.XZh, (k)localObject1);
          if (localObject1 != null)
          {
            a.this.XZg = ((org.b.d.i)localObject1);
            a.a(a.this.XZg);
            new MMHandler(Looper.getMainLooper()).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(152855);
                a.this.c(a.c.XZp);
                com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(583L, 1L, 1L, false);
                AppMethodBeat.o(152855);
              }
            });
            AppMethodBeat.o(152857);
            return;
          }
          new MMHandler(Looper.getMainLooper()).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(152856);
              a.this.c(a.c.XZq);
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(583L, 4L, 1L, false);
              AppMethodBeat.o(152856);
            }
          });
          AppMethodBeat.o(152857);
          return;
        }
        catch (org.b.b.a locala)
        {
          for (;;)
          {
            Object localObject2 = localObject3;
          }
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(152858);
        String str = super.toString() + "|onComplete";
        AppMethodBeat.o(152858);
        return str;
      }
    });
    AppMethodBeat.o(152867);
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(152864);
    if (this.XZj)
    {
      AppMethodBeat.o(152864);
      return;
    }
    this.XZl = parama;
    this.XZj = true;
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(152854);
        Object localObject = a.c.XZp;
        if (a.this.XZg == null) {
          localObject = a.c.XZq;
        }
        for (;;)
        {
          localObject = a.this.KBt.obtainMessage(1010, localObject);
          a.this.KBt.sendMessage((Message)localObject);
          AppMethodBeat.o(152854);
          return;
          c localc1 = new c(org.b.d.j.abLS, "https://api.twitter.com/1.1/account/verify_credentials.json");
          a.this.XZf.a(a.this.XZg, localc1);
          try
          {
            if (localc1.iVo().code != 200) {
              localObject = a.c.XZq;
            }
          }
          catch (Exception localException)
          {
            Log.printErrStackTrace("MicroMsg.Twitter", localException, "request error.", new Object[0]);
            a.c localc = a.c.XZq;
          }
        }
      }
    }, "Twitter_validationAccessToken");
    AppMethodBeat.o(152864);
  }
  
  public final void a(b paramb, Context paramContext)
  {
    AppMethodBeat.i(152863);
    if (this.XZi)
    {
      AppMethodBeat.o(152863);
      return;
    }
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(583L, 0L, 1L, false);
    this.XZk = paramb;
    this.context = paramContext;
    this.XZi = true;
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        Object localObject = null;
        AppMethodBeat.i(152853);
        try
        {
          a.this.XZh = a.this.XZf.iVu();
          String str = a.this.XZf.b(a.this.XZh);
          localObject = str;
        }
        catch (org.b.b.b localb)
        {
          break label48;
        }
        catch (org.b.b.a locala)
        {
          label48:
          break label48;
        }
        localObject = a.this.KBt.obtainMessage(1000, localObject);
        a.this.KBt.sendMessage((Message)localObject);
        AppMethodBeat.o(152853);
      }
    }, "Twitter_doOAuth");
    AppMethodBeat.o(152863);
  }
  
  final void c(c paramc)
  {
    AppMethodBeat.i(152866);
    this.XZi = false;
    this.XZh = null;
    if (this.XZk != null) {
      this.XZk.a(paramc);
    }
    AppMethodBeat.o(152866);
  }
  
  public final boolean hZk()
  {
    return this.XZg != null;
  }
  
  public final void hZl()
  {
    AppMethodBeat.i(152868);
    Hj(false);
    c(c.XZq);
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(583L, 2L, 1L, false);
    AppMethodBeat.o(152868);
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(152869);
    Hj(false);
    c(c.XZr);
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(583L, 3L, 1L, false);
    AppMethodBeat.o(152869);
  }
  
  public static abstract interface b
  {
    public abstract void a(a.c paramc);
  }
  
  public static enum c
  {
    static
    {
      AppMethodBeat.i(152861);
      XZp = new c("Finished", 0);
      XZq = new c("Failed", 1);
      XZr = new c("Canceled", 2);
      XZs = new c[] { XZp, XZq, XZr };
      AppMethodBeat.o(152861);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.q.a
 * JD-Core Version:    0.7.0.1
 */