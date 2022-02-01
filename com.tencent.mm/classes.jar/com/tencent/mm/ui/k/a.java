package com.tencent.mm.ui.k;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.h.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.g.a.f;
import java.util.ArrayList;
import java.util.List;
import org.b.a.a.c.a;
import org.b.d.c;
import org.b.d.j;
import org.b.g.d;

@SuppressLint({"HandlerLeak"})
public final class a
  implements b.a
{
  org.b.d.i HxA;
  private boolean HxB;
  boolean HxC;
  public b HxD;
  public a HxE;
  org.b.e.b Hxy;
  public org.b.d.i Hxz;
  Context context;
  ap xkC;
  
  public a()
  {
    AppMethodBeat.i(152862);
    this.Hxy = null;
    this.Hxz = null;
    this.HxA = null;
    this.HxB = false;
    this.HxC = false;
    this.HxD = null;
    this.HxE = null;
    this.context = null;
    this.xkC = new ap()
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
          f.S(localContext, "Error", "Application requires permission to access the Internet");
        }
        for (;;)
        {
          if (paramAnonymousMessage.what == 1010)
          {
            paramAnonymousMessage = (a.c)paramAnonymousMessage.obj;
            localObject = a.this;
            ((a)localObject).HxC = false;
            if (paramAnonymousMessage == a.c.HxJ)
            {
              ((a)localObject).HxA = null;
              a.a(null);
            }
            if (((a)localObject).HxE != null) {
              ((a)localObject).HxE.b(paramAnonymousMessage);
            }
          }
          AppMethodBeat.o(152852);
          return;
          label125:
          new b(localContext, (String)localObject, locala).show();
          continue;
          label142:
          a.this.c(a.c.HxJ);
        }
      }
    };
    Object localObject = new org.b.a.a();
    ((org.b.a.a)localObject).Knr = org.b.a.a.bC(c.a.class);
    d.mP("XMr2y8FEVEqZBcZ1TU3gLA", "Invalid Api key");
    ((org.b.a.a)localObject).Kno = "XMr2y8FEVEqZBcZ1TU3gLA";
    d.mP("kyWwA5vbB6H1NDQFufR9hD5vWGStxhweIbatclCo", "Invalid Api secret");
    ((org.b.a.a)localObject).Knp = "kyWwA5vbB6H1NDQFufR9hD5vWGStxhweIbatclCo";
    d.j("wechatapp://sign-in-twitter.wechatapp.com/", "Callback can't be null");
    ((org.b.a.a)localObject).Knq = "wechatapp://sign-in-twitter.wechatapp.com/";
    d.j(((org.b.a.a)localObject).Knr, "You must specify a valid api through the provider() method");
    d.mP(((org.b.a.a)localObject).Kno, "You must provide an api key");
    d.mP(((org.b.a.a)localObject).Knp, "You must provide an api secret");
    this.Hxy = ((org.b.a.a)localObject).Knr.a(new org.b.d.a(((org.b.a.a)localObject).Kno, ((org.b.a.a)localObject).Knp, ((org.b.a.a)localObject).Knq, ((org.b.a.a)localObject).Kns, ((org.b.a.a)localObject).scope, ((org.b.a.a)localObject).Knt));
    String str;
    if (com.tencent.mm.kernel.g.afz().aeI())
    {
      localObject = (String)com.tencent.mm.kernel.g.afB().afk().get(69377, null);
      str = (String)com.tencent.mm.kernel.g.afB().afk().get(69378, null);
      if ((bt.isNullOrNil((String)localObject)) || (bt.isNullOrNil(str))) {
        localObject = null;
      }
    }
    for (;;)
    {
      this.Hxz = ((org.b.d.i)localObject);
      AppMethodBeat.o(152862);
      return;
      localObject = new org.b.d.i((String)localObject, str);
      continue;
      ad.e("Twitter", "acchas not ready for restoreTwitterAccessToken");
      localObject = null;
    }
  }
  
  static void a(org.b.d.i parami)
  {
    AppMethodBeat.i(152865);
    aj.getContext().getSharedPreferences(aj.eFD(), 0);
    if (parami == null)
    {
      com.tencent.mm.kernel.g.afB().afk().set(69377, "");
      com.tencent.mm.kernel.g.afB().afk().set(69378, "");
      AppMethodBeat.o(152865);
      return;
    }
    com.tencent.mm.kernel.g.afB().afk().set(69377, parami.token);
    com.tencent.mm.kernel.g.afB().afk().set(69378, parami.DNx);
    AppMethodBeat.o(152865);
  }
  
  static void wL(boolean paramBoolean)
  {
    AppMethodBeat.i(152870);
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean) {}
    for (String str = "1";; str = "2")
    {
      localArrayList.add(new h.a(10251, str));
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apL().c(new com.tencent.mm.bb.h(localArrayList));
      AppMethodBeat.o(152870);
      return;
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(152864);
    if (this.HxC)
    {
      AppMethodBeat.o(152864);
      return;
    }
    this.HxE = parama;
    this.HxC = true;
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(152854);
        Object localObject = a.c.HxI;
        if (a.this.Hxz == null) {
          localObject = a.c.HxJ;
        }
        for (;;)
        {
          localObject = a.this.xkC.obtainMessage(1010, localObject);
          a.this.xkC.sendMessage((Message)localObject);
          AppMethodBeat.o(152854);
          return;
          c localc1 = new c(j.KnK, "https://api.twitter.com/1.1/account/verify_credentials.json");
          a.this.Hxy.a(a.this.Hxz, localc1);
          try
          {
            if (localc1.fNf().code != 200) {
              localObject = a.c.HxJ;
            }
          }
          catch (Exception localException)
          {
            ad.printErrStackTrace("MicroMsg.Twitter", localException, "request error.", new Object[0]);
            a.c localc = a.c.HxJ;
          }
        }
      }
    }, "Twitter_validationAccessToken");
    AppMethodBeat.o(152864);
  }
  
  public final void a(b paramb, Context paramContext)
  {
    AppMethodBeat.i(152863);
    if (this.HxB)
    {
      AppMethodBeat.o(152863);
      return;
    }
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(583L, 0L, 1L, false);
    this.HxD = paramb;
    this.context = paramContext;
    this.HxB = true;
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        Object localObject = null;
        AppMethodBeat.i(152853);
        try
        {
          a.this.HxA = a.this.Hxy.fNl();
          String str = a.this.Hxy.b(a.this.HxA);
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
        localObject = a.this.xkC.obtainMessage(1000, localObject);
        a.this.xkC.sendMessage((Message)localObject);
        AppMethodBeat.o(152853);
      }
    }, "Twitter_doOAuth");
    AppMethodBeat.o(152863);
  }
  
  final void c(c paramc)
  {
    AppMethodBeat.i(152866);
    this.HxB = false;
    this.HxA = null;
    if (this.HxD != null) {
      this.HxD.a(paramc);
    }
    AppMethodBeat.o(152866);
  }
  
  public final boolean feC()
  {
    return this.Hxz != null;
  }
  
  public final void feD()
  {
    AppMethodBeat.i(152868);
    wL(false);
    c(c.HxJ);
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(583L, 2L, 1L, false);
    AppMethodBeat.o(152868);
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(152869);
    wL(false);
    c(c.HxK);
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(583L, 3L, 1L, false);
    AppMethodBeat.o(152869);
  }
  
  public final void w(final Bundle paramBundle)
  {
    AppMethodBeat.i(152867);
    com.tencent.mm.kernel.g.afE().ax(new Runnable()
    {
      public final void run()
      {
        Object localObject3 = null;
        AppMethodBeat.i(152857);
        if (a.this.HxA == null)
        {
          AppMethodBeat.o(152857);
          return;
        }
        a.wL(true);
        String str = paramBundle.getString("oauth_verifier");
        Object localObject1 = localObject3;
        if (str != null) {
          localObject1 = new org.b.d.k(str);
        }
        try
        {
          localObject1 = a.this.Hxy.a(a.this.HxA, (org.b.d.k)localObject1);
          if (localObject1 != null)
          {
            a.this.Hxz = ((org.b.d.i)localObject1);
            a.a(a.this.Hxz);
            new ap(Looper.getMainLooper()).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(152855);
                a.this.c(a.c.HxI);
                com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(583L, 1L, 1L, false);
                AppMethodBeat.o(152855);
              }
            });
            AppMethodBeat.o(152857);
            return;
          }
          new ap(Looper.getMainLooper()).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(152856);
              a.this.c(a.c.HxJ);
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(583L, 4L, 1L, false);
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
      HxI = new c("Finished", 0);
      HxJ = new c("Failed", 1);
      HxK = new c("Canceled", 2);
      HxL = new c[] { HxI, HxJ, HxK };
      AppMethodBeat.o(152861);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.k.a
 * JD-Core Version:    0.7.0.1
 */