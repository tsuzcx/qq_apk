package com.tencent.mm.ui.q;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.i.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.aq;
import java.util.ArrayList;
import java.util.List;
import org.b.a.a.c.a;
import org.b.d.c;
import org.b.d.g;
import org.b.d.k;
import org.b.g.d;

public final class a
  implements b.a
{
  MMHandler Rba;
  org.b.e.b afPV;
  public org.b.d.i afPW;
  org.b.d.i afPX;
  private boolean afPY;
  boolean afPZ;
  public a.b afQa;
  public a.a afQb;
  Context context;
  
  public a()
  {
    AppMethodBeat.i(152862);
    this.afPV = null;
    this.afPW = null;
    this.afPX = null;
    this.afPY = false;
    this.afPZ = false;
    this.afQa = null;
    this.afQb = null;
    this.context = null;
    this.Rba = new MMHandler()
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
          com.tencent.mm.ui.mmfb.sdk.i.al(localContext, "Error", "Application requires permission to access the Internet");
        }
        for (;;)
        {
          if (paramAnonymousMessage.what == 1010)
          {
            paramAnonymousMessage = (a.c)paramAnonymousMessage.obj;
            localObject = a.this;
            ((a)localObject).afPZ = false;
            if (paramAnonymousMessage == a.c.afQg)
            {
              ((a)localObject).afPX = null;
              a.a(null);
            }
            if (((a)localObject).afQb != null) {
              ((a)localObject).afQb.b(paramAnonymousMessage);
            }
          }
          AppMethodBeat.o(152852);
          return;
          label125:
          new b(localContext, (String)localObject, locala).show();
          continue;
          label142:
          a.this.c(a.c.afQg);
        }
      }
    };
    Object localObject = new org.b.a.a();
    ((org.b.a.a)localObject).ajYs = org.b.a.a.cS(c.a.class);
    d.rN("XMr2y8FEVEqZBcZ1TU3gLA", "Invalid Api key");
    ((org.b.a.a)localObject).ajYp = "XMr2y8FEVEqZBcZ1TU3gLA";
    d.rN("kyWwA5vbB6H1NDQFufR9hD5vWGStxhweIbatclCo", "Invalid Api secret");
    ((org.b.a.a)localObject).ajYq = "kyWwA5vbB6H1NDQFufR9hD5vWGStxhweIbatclCo";
    d.x("wechatapp://sign-in-twitter.wechatapp.com/", "Callback can't be null");
    ((org.b.a.a)localObject).ajYr = "wechatapp://sign-in-twitter.wechatapp.com/";
    d.x(((org.b.a.a)localObject).ajYs, "You must specify a valid api through the provider() method");
    d.rN(((org.b.a.a)localObject).ajYp, "You must provide an api key");
    d.rN(((org.b.a.a)localObject).ajYq, "You must provide an api secret");
    this.afPV = ((org.b.a.a)localObject).ajYs.a(new org.b.d.a(((org.b.a.a)localObject).ajYp, ((org.b.a.a)localObject).ajYq, ((org.b.a.a)localObject).ajYr, ((org.b.a.a)localObject).ajYt, ((org.b.a.a)localObject).scope, ((org.b.a.a)localObject).ajYu));
    String str;
    if (com.tencent.mm.kernel.h.baC().aZN())
    {
      localObject = (String)com.tencent.mm.kernel.h.baE().ban().d(69377, null);
      str = (String)com.tencent.mm.kernel.h.baE().ban().d(69378, null);
      if ((Util.isNullOrNil((String)localObject)) || (Util.isNullOrNil(str))) {
        localObject = null;
      }
    }
    for (;;)
    {
      this.afPW = ((org.b.d.i)localObject);
      AppMethodBeat.o(152862);
      return;
      localObject = new org.b.d.i((String)localObject, str);
      continue;
      Log.e("Twitter", "acchas not ready for restoreTwitterAccessToken");
      localObject = null;
    }
  }
  
  static void Ne(boolean paramBoolean)
  {
    AppMethodBeat.i(152870);
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean) {}
    for (String str = "1";; str = "2")
    {
      localArrayList.add(new i.a(10251, str));
      ((n)com.tencent.mm.kernel.h.ax(n.class)).bzz().d(new com.tencent.mm.ay.i(localArrayList));
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
      com.tencent.mm.kernel.h.baE().ban().B(69377, "");
      com.tencent.mm.kernel.h.baE().ban().B(69378, "");
      AppMethodBeat.o(152865);
      return;
    }
    com.tencent.mm.kernel.h.baE().ban().B(69377, parami.token);
    com.tencent.mm.kernel.h.baE().ban().B(69378, parami.aaTQ);
    AppMethodBeat.o(152865);
  }
  
  public final void T(final Bundle paramBundle)
  {
    AppMethodBeat.i(152867);
    com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        Object localObject3 = null;
        AppMethodBeat.i(152857);
        if (a.this.afPX == null)
        {
          AppMethodBeat.o(152857);
          return;
        }
        a.Ne(true);
        String str = paramBundle.getString("oauth_verifier");
        Object localObject1 = localObject3;
        if (str != null) {
          localObject1 = new k(str);
        }
        try
        {
          localObject1 = a.this.afPV.a(a.this.afPX, (k)localObject1);
          if (localObject1 != null)
          {
            a.this.afPW = ((org.b.d.i)localObject1);
            a.a(a.this.afPW);
            new MMHandler(Looper.getMainLooper()).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(152855);
                a.this.c(a.c.afQf);
                com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(583L, 1L, 1L, false);
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
              a.this.c(a.c.afQg);
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(583L, 4L, 1L, false);
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
    if (this.afPZ)
    {
      AppMethodBeat.o(152864);
      return;
    }
    this.afQb = parama;
    this.afPZ = true;
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(152854);
        Object localObject = a.c.afQf;
        if (a.this.afPW == null) {
          localObject = a.c.afQg;
        }
        for (;;)
        {
          localObject = a.this.Rba.obtainMessage(1010, localObject);
          a.this.Rba.sendMessage((Message)localObject);
          AppMethodBeat.o(152854);
          return;
          c localc1 = new c(org.b.d.j.ajYM, "https://api.twitter.com/1.1/account/verify_credentials.json");
          a.this.afPV.a(a.this.afPW, localc1);
          try
          {
            if (localc1.kJM().code != 200) {
              localObject = a.c.afQg;
            }
          }
          catch (Exception localException)
          {
            Log.printErrStackTrace("MicroMsg.Twitter", localException, "request error.", new Object[0]);
            a.c localc = a.c.afQg;
          }
        }
      }
    }, "Twitter_validationAccessToken");
    AppMethodBeat.o(152864);
  }
  
  public final void a(a.b paramb, Context paramContext)
  {
    AppMethodBeat.i(152863);
    if (this.afPY)
    {
      AppMethodBeat.o(152863);
      return;
    }
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(583L, 0L, 1L, false);
    this.afQa = paramb;
    this.context = paramContext;
    this.afPY = true;
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        Object localObject = null;
        AppMethodBeat.i(152853);
        try
        {
          a.this.afPX = a.this.afPV.kJS();
          String str = a.this.afPV.b(a.this.afPX);
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
        localObject = a.this.Rba.obtainMessage(1000, localObject);
        a.this.Rba.sendMessage((Message)localObject);
        AppMethodBeat.o(152853);
      }
    }, "Twitter_doOAuth");
    AppMethodBeat.o(152863);
  }
  
  final void c(c paramc)
  {
    AppMethodBeat.i(152866);
    this.afPY = false;
    this.afPX = null;
    if (this.afQa != null) {
      this.afQa.a(paramc);
    }
    AppMethodBeat.o(152866);
  }
  
  public final boolean jEf()
  {
    return this.afPW != null;
  }
  
  public final void jEg()
  {
    AppMethodBeat.i(249782);
    Ne(false);
    c(c.afQg);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(583L, 2L, 1L, false);
    AppMethodBeat.o(249782);
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(152869);
    Ne(false);
    c(c.afQh);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(583L, 3L, 1L, false);
    AppMethodBeat.o(152869);
  }
  
  public static enum c
  {
    static
    {
      AppMethodBeat.i(152861);
      afQf = new c("Finished", 0);
      afQg = new c("Failed", 1);
      afQh = new c("Canceled", 2);
      afQi = new c[] { afQf, afQg, afQh };
      AppMethodBeat.o(152861);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.q.a
 * JD-Core Version:    0.7.0.1
 */