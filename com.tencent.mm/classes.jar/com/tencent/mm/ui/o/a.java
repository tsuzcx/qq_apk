package com.tencent.mm.ui.o;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ba.i.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.h.a.f;
import java.util.ArrayList;
import java.util.List;
import org.b.a.a.c.a;
import org.b.d.c;
import org.b.d.k;
import org.b.g.d;

@SuppressLint({"HandlerLeak"})
public final class a
  implements b.a
{
  MMHandler Eok;
  org.b.e.b QAG;
  public org.b.d.i QAH;
  org.b.d.i QAI;
  private boolean QAJ;
  boolean QAK;
  public b QAL;
  public a QAM;
  Context context;
  
  public a()
  {
    AppMethodBeat.i(152862);
    this.QAG = null;
    this.QAH = null;
    this.QAI = null;
    this.QAJ = false;
    this.QAK = false;
    this.QAL = null;
    this.QAM = null;
    this.context = null;
    this.Eok = new MMHandler()
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
          f.Y(localContext, "Error", "Application requires permission to access the Internet");
        }
        for (;;)
        {
          if (paramAnonymousMessage.what == 1010)
          {
            paramAnonymousMessage = (a.c)paramAnonymousMessage.obj;
            localObject = a.this;
            ((a)localObject).QAK = false;
            if (paramAnonymousMessage == a.c.QAR)
            {
              ((a)localObject).QAI = null;
              a.a(null);
            }
            if (((a)localObject).QAM != null) {
              ((a)localObject).QAM.b(paramAnonymousMessage);
            }
          }
          AppMethodBeat.o(152852);
          return;
          label125:
          new b(localContext, (String)localObject, locala).show();
          continue;
          label142:
          a.this.c(a.c.QAR);
        }
      }
    };
    Object localObject = new org.b.a.a();
    ((org.b.a.a)localObject).Uie = org.b.a.a.bH(c.a.class);
    d.oM("XMr2y8FEVEqZBcZ1TU3gLA", "Invalid Api key");
    ((org.b.a.a)localObject).Uib = "XMr2y8FEVEqZBcZ1TU3gLA";
    d.oM("kyWwA5vbB6H1NDQFufR9hD5vWGStxhweIbatclCo", "Invalid Api secret");
    ((org.b.a.a)localObject).Uic = "kyWwA5vbB6H1NDQFufR9hD5vWGStxhweIbatclCo";
    d.j("wechatapp://sign-in-twitter.wechatapp.com/", "Callback can't be null");
    ((org.b.a.a)localObject).Uid = "wechatapp://sign-in-twitter.wechatapp.com/";
    d.j(((org.b.a.a)localObject).Uie, "You must specify a valid api through the provider() method");
    d.oM(((org.b.a.a)localObject).Uib, "You must provide an api key");
    d.oM(((org.b.a.a)localObject).Uic, "You must provide an api secret");
    this.QAG = ((org.b.a.a)localObject).Uie.a(new org.b.d.a(((org.b.a.a)localObject).Uib, ((org.b.a.a)localObject).Uic, ((org.b.a.a)localObject).Uid, ((org.b.a.a)localObject).Uif, ((org.b.a.a)localObject).scope, ((org.b.a.a)localObject).Uig));
    String str;
    if (com.tencent.mm.kernel.g.aAf().azp())
    {
      localObject = (String)com.tencent.mm.kernel.g.aAh().azQ().get(69377, null);
      str = (String)com.tencent.mm.kernel.g.aAh().azQ().get(69378, null);
      if ((Util.isNullOrNil((String)localObject)) || (Util.isNullOrNil(str))) {
        localObject = null;
      }
    }
    for (;;)
    {
      this.QAH = ((org.b.d.i)localObject);
      AppMethodBeat.o(152862);
      return;
      localObject = new org.b.d.i((String)localObject, str);
      continue;
      Log.e("Twitter", "acchas not ready for restoreTwitterAccessToken");
      localObject = null;
    }
  }
  
  static void CP(boolean paramBoolean)
  {
    AppMethodBeat.i(152870);
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean) {}
    for (String str = "1";; str = "2")
    {
      localArrayList.add(new i.a(10251, str));
      ((l)com.tencent.mm.kernel.g.af(l.class)).aSM().d(new com.tencent.mm.ba.i(localArrayList));
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
      com.tencent.mm.kernel.g.aAh().azQ().set(69377, "");
      com.tencent.mm.kernel.g.aAh().azQ().set(69378, "");
      AppMethodBeat.o(152865);
      return;
    }
    com.tencent.mm.kernel.g.aAh().azQ().set(69377, parami.token);
    com.tencent.mm.kernel.g.aAh().azQ().set(69378, parami.Mte);
    AppMethodBeat.o(152865);
  }
  
  public final void E(final Bundle paramBundle)
  {
    AppMethodBeat.i(152867);
    com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        Object localObject3 = null;
        AppMethodBeat.i(152857);
        if (a.this.QAI == null)
        {
          AppMethodBeat.o(152857);
          return;
        }
        a.CP(true);
        String str = paramBundle.getString("oauth_verifier");
        Object localObject1 = localObject3;
        if (str != null) {
          localObject1 = new k(str);
        }
        try
        {
          localObject1 = a.this.QAG.a(a.this.QAI, (k)localObject1);
          if (localObject1 != null)
          {
            a.this.QAH = ((org.b.d.i)localObject1);
            a.a(a.this.QAH);
            new MMHandler(Looper.getMainLooper()).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(152855);
                a.this.c(a.c.QAQ);
                h.CyF.idkeyStat(583L, 1L, 1L, false);
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
              a.this.c(a.c.QAR);
              h.CyF.idkeyStat(583L, 4L, 1L, false);
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
  
  public final void a(a parama)
  {
    AppMethodBeat.i(152864);
    if (this.QAK)
    {
      AppMethodBeat.o(152864);
      return;
    }
    this.QAM = parama;
    this.QAK = true;
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(152854);
        Object localObject = a.c.QAQ;
        if (a.this.QAH == null) {
          localObject = a.c.QAR;
        }
        for (;;)
        {
          localObject = a.this.Eok.obtainMessage(1010, localObject);
          a.this.Eok.sendMessage((Message)localObject);
          AppMethodBeat.o(152854);
          return;
          c localc1 = new c(org.b.d.j.Uix, "https://api.twitter.com/1.1/account/verify_credentials.json");
          a.this.QAG.a(a.this.QAH, localc1);
          try
          {
            if (localc1.hQf().code != 200) {
              localObject = a.c.QAR;
            }
          }
          catch (Exception localException)
          {
            Log.printErrStackTrace("MicroMsg.Twitter", localException, "request error.", new Object[0]);
            a.c localc = a.c.QAR;
          }
        }
      }
    }, "Twitter_validationAccessToken");
    AppMethodBeat.o(152864);
  }
  
  public final void a(b paramb, Context paramContext)
  {
    AppMethodBeat.i(152863);
    if (this.QAJ)
    {
      AppMethodBeat.o(152863);
      return;
    }
    h.CyF.idkeyStat(583L, 0L, 1L, false);
    this.QAL = paramb;
    this.context = paramContext;
    this.QAJ = true;
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        Object localObject = null;
        AppMethodBeat.i(152853);
        try
        {
          a.this.QAI = a.this.QAG.hQl();
          String str = a.this.QAG.b(a.this.QAI);
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
        localObject = a.this.Eok.obtainMessage(1000, localObject);
        a.this.Eok.sendMessage((Message)localObject);
        AppMethodBeat.o(152853);
      }
    }, "Twitter_doOAuth");
    AppMethodBeat.o(152863);
  }
  
  final void c(c paramc)
  {
    AppMethodBeat.i(152866);
    this.QAJ = false;
    this.QAI = null;
    if (this.QAL != null) {
      this.QAL.a(paramc);
    }
    AppMethodBeat.o(152866);
  }
  
  public final boolean gYx()
  {
    return this.QAH != null;
  }
  
  public final void gYy()
  {
    AppMethodBeat.i(152868);
    CP(false);
    c(c.QAR);
    h.CyF.idkeyStat(583L, 2L, 1L, false);
    AppMethodBeat.o(152868);
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(152869);
    CP(false);
    c(c.QAS);
    h.CyF.idkeyStat(583L, 3L, 1L, false);
    AppMethodBeat.o(152869);
  }
  
  public static abstract interface a
  {
    public abstract void b(a.c paramc);
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
      QAQ = new c("Finished", 0);
      QAR = new c("Failed", 1);
      QAS = new c("Canceled", 2);
      QAT = new c[] { QAQ, QAR, QAS };
      AppMethodBeat.o(152861);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.o.a
 * JD-Core Version:    0.7.0.1
 */