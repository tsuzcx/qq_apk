package com.tencent.mm.ui.k;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.i.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.g.a.f;
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
  org.b.e.b KPa;
  public org.b.d.i KPb;
  org.b.d.i KPc;
  private boolean KPd;
  boolean KPe;
  public a.b KPf;
  public a.a KPg;
  Context context;
  ap zOG;
  
  public a()
  {
    AppMethodBeat.i(152862);
    this.KPa = null;
    this.KPb = null;
    this.KPc = null;
    this.KPd = false;
    this.KPe = false;
    this.KPf = null;
    this.KPg = null;
    this.context = null;
    this.zOG = new ap()
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
          f.U(localContext, "Error", "Application requires permission to access the Internet");
        }
        for (;;)
        {
          if (paramAnonymousMessage.what == 1010)
          {
            paramAnonymousMessage = (a.c)paramAnonymousMessage.obj;
            localObject = a.this;
            ((a)localObject).KPe = false;
            if (paramAnonymousMessage == a.c.KPl)
            {
              ((a)localObject).KPc = null;
              a.a(null);
            }
            if (((a)localObject).KPg != null) {
              ((a)localObject).KPg.b(paramAnonymousMessage);
            }
          }
          AppMethodBeat.o(152852);
          return;
          label125:
          new b(localContext, (String)localObject, locala).show();
          continue;
          label142:
          a.this.c(a.c.KPl);
        }
      }
    };
    Object localObject = new org.b.a.a();
    ((org.b.a.a)localObject).NWc = org.b.a.a.bH(c.a.class);
    d.nO("XMr2y8FEVEqZBcZ1TU3gLA", "Invalid Api key");
    ((org.b.a.a)localObject).NVZ = "XMr2y8FEVEqZBcZ1TU3gLA";
    d.nO("kyWwA5vbB6H1NDQFufR9hD5vWGStxhweIbatclCo", "Invalid Api secret");
    ((org.b.a.a)localObject).NWa = "kyWwA5vbB6H1NDQFufR9hD5vWGStxhweIbatclCo";
    d.j("wechatapp://sign-in-twitter.wechatapp.com/", "Callback can't be null");
    ((org.b.a.a)localObject).NWb = "wechatapp://sign-in-twitter.wechatapp.com/";
    d.j(((org.b.a.a)localObject).NWc, "You must specify a valid api through the provider() method");
    d.nO(((org.b.a.a)localObject).NVZ, "You must provide an api key");
    d.nO(((org.b.a.a)localObject).NWa, "You must provide an api secret");
    this.KPa = ((org.b.a.a)localObject).NWc.a(new org.b.d.a(((org.b.a.a)localObject).NVZ, ((org.b.a.a)localObject).NWa, ((org.b.a.a)localObject).NWb, ((org.b.a.a)localObject).NWd, ((org.b.a.a)localObject).scope, ((org.b.a.a)localObject).NWe));
    String str;
    if (com.tencent.mm.kernel.g.ajA().aiK())
    {
      localObject = (String)com.tencent.mm.kernel.g.ajC().ajl().get(69377, null);
      str = (String)com.tencent.mm.kernel.g.ajC().ajl().get(69378, null);
      if ((bt.isNullOrNil((String)localObject)) || (bt.isNullOrNil(str))) {
        localObject = null;
      }
    }
    for (;;)
    {
      this.KPb = ((org.b.d.i)localObject);
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
    aj.getContext().getSharedPreferences(aj.fkC(), 0);
    if (parami == null)
    {
      com.tencent.mm.kernel.g.ajC().ajl().set(69377, "");
      com.tencent.mm.kernel.g.ajC().ajl().set(69378, "");
      AppMethodBeat.o(152865);
      return;
    }
    com.tencent.mm.kernel.g.ajC().ajl().set(69377, parami.token);
    com.tencent.mm.kernel.g.ajC().ajl().set(69378, parami.GTp);
    AppMethodBeat.o(152865);
  }
  
  static void yG(boolean paramBoolean)
  {
    AppMethodBeat.i(152870);
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean) {}
    for (String str = "1";; str = "2")
    {
      localArrayList.add(new i.a(10251, str));
      ((l)com.tencent.mm.kernel.g.ab(l.class)).azo().c(new com.tencent.mm.bb.i(localArrayList));
      AppMethodBeat.o(152870);
      return;
    }
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(152864);
    if (this.KPe)
    {
      AppMethodBeat.o(152864);
      return;
    }
    this.KPg = parama;
    this.KPe = true;
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(152854);
        Object localObject = a.c.KPk;
        if (a.this.KPb == null) {
          localObject = a.c.KPl;
        }
        for (;;)
        {
          localObject = a.this.zOG.obtainMessage(1010, localObject);
          a.this.zOG.sendMessage((Message)localObject);
          AppMethodBeat.o(152854);
          return;
          c localc1 = new c(org.b.d.j.NWv, "https://api.twitter.com/1.1/account/verify_credentials.json");
          a.this.KPa.a(a.this.KPb, localc1);
          try
          {
            if (localc1.gyz().code != 200) {
              localObject = a.c.KPl;
            }
          }
          catch (Exception localException)
          {
            ad.printErrStackTrace("MicroMsg.Twitter", localException, "request error.", new Object[0]);
            a.c localc = a.c.KPl;
          }
        }
      }
    }, "Twitter_validationAccessToken");
    AppMethodBeat.o(152864);
  }
  
  public final void a(a.b paramb, Context paramContext)
  {
    AppMethodBeat.i(152863);
    if (this.KPd)
    {
      AppMethodBeat.o(152863);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(583L, 0L, 1L, false);
    this.KPf = paramb;
    this.context = paramContext;
    this.KPd = true;
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        Object localObject = null;
        AppMethodBeat.i(152853);
        try
        {
          a.this.KPc = a.this.KPa.gyF();
          String str = a.this.KPa.b(a.this.KPc);
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
        localObject = a.this.zOG.obtainMessage(1000, localObject);
        a.this.zOG.sendMessage((Message)localObject);
        AppMethodBeat.o(152853);
      }
    }, "Twitter_doOAuth");
    AppMethodBeat.o(152863);
  }
  
  final void c(c paramc)
  {
    AppMethodBeat.i(152866);
    this.KPd = false;
    this.KPc = null;
    if (this.KPf != null) {
      this.KPf.a(paramc);
    }
    AppMethodBeat.o(152866);
  }
  
  public final boolean fLk()
  {
    return this.KPb != null;
  }
  
  public final void fLl()
  {
    AppMethodBeat.i(152868);
    yG(false);
    c(c.KPl);
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(583L, 2L, 1L, false);
    AppMethodBeat.o(152868);
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(152869);
    yG(false);
    c(c.KPm);
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(583L, 3L, 1L, false);
    AppMethodBeat.o(152869);
  }
  
  public final void x(final Bundle paramBundle)
  {
    AppMethodBeat.i(152867);
    com.tencent.mm.kernel.g.ajF().ay(new Runnable()
    {
      public final void run()
      {
        Object localObject3 = null;
        AppMethodBeat.i(152857);
        if (a.this.KPc == null)
        {
          AppMethodBeat.o(152857);
          return;
        }
        a.yG(true);
        String str = paramBundle.getString("oauth_verifier");
        Object localObject1 = localObject3;
        if (str != null) {
          localObject1 = new k(str);
        }
        try
        {
          localObject1 = a.this.KPa.a(a.this.KPc, (k)localObject1);
          if (localObject1 != null)
          {
            a.this.KPb = ((org.b.d.i)localObject1);
            a.a(a.this.KPb);
            new ap(Looper.getMainLooper()).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(152855);
                a.this.c(a.c.KPk);
                com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(583L, 1L, 1L, false);
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
              a.this.c(a.c.KPl);
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(583L, 4L, 1L, false);
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
  
  public static enum c
  {
    static
    {
      AppMethodBeat.i(152861);
      KPk = new c("Finished", 0);
      KPl = new c("Failed", 1);
      KPm = new c("Canceled", 2);
      KPn = new c[] { KPk, KPl, KPm };
      AppMethodBeat.o(152861);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.k.a
 * JD-Core Version:    0.7.0.1
 */