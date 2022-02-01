package com.tencent.mm.ui.k;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ba.i.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
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
  aq AfN;
  org.b.d.i LlA;
  private boolean LlB;
  boolean LlC;
  public a.b LlD;
  public a.a LlE;
  org.b.e.b Lly;
  public org.b.d.i Llz;
  Context context;
  
  public a()
  {
    AppMethodBeat.i(152862);
    this.Lly = null;
    this.Llz = null;
    this.LlA = null;
    this.LlB = false;
    this.LlC = false;
    this.LlD = null;
    this.LlE = null;
    this.context = null;
    this.AfN = new aq()
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
            ((a)localObject).LlC = false;
            if (paramAnonymousMessage == a.c.LlJ)
            {
              ((a)localObject).LlA = null;
              a.a(null);
            }
            if (((a)localObject).LlE != null) {
              ((a)localObject).LlE.b(paramAnonymousMessage);
            }
          }
          AppMethodBeat.o(152852);
          return;
          label125:
          new b(localContext, (String)localObject, locala).show();
          continue;
          label142:
          a.this.c(a.c.LlJ);
        }
      }
    };
    Object localObject = new org.b.a.a();
    ((org.b.a.a)localObject).Oth = org.b.a.a.bH(c.a.class);
    d.nU("XMr2y8FEVEqZBcZ1TU3gLA", "Invalid Api key");
    ((org.b.a.a)localObject).Ote = "XMr2y8FEVEqZBcZ1TU3gLA";
    d.nU("kyWwA5vbB6H1NDQFufR9hD5vWGStxhweIbatclCo", "Invalid Api secret");
    ((org.b.a.a)localObject).Otf = "kyWwA5vbB6H1NDQFufR9hD5vWGStxhweIbatclCo";
    d.j("wechatapp://sign-in-twitter.wechatapp.com/", "Callback can't be null");
    ((org.b.a.a)localObject).Otg = "wechatapp://sign-in-twitter.wechatapp.com/";
    d.j(((org.b.a.a)localObject).Oth, "You must specify a valid api through the provider() method");
    d.nU(((org.b.a.a)localObject).Ote, "You must provide an api key");
    d.nU(((org.b.a.a)localObject).Otf, "You must provide an api secret");
    this.Lly = ((org.b.a.a)localObject).Oth.a(new org.b.d.a(((org.b.a.a)localObject).Ote, ((org.b.a.a)localObject).Otf, ((org.b.a.a)localObject).Otg, ((org.b.a.a)localObject).Oti, ((org.b.a.a)localObject).scope, ((org.b.a.a)localObject).Otj));
    String str;
    if (com.tencent.mm.kernel.g.ajP().aiZ())
    {
      localObject = (String)com.tencent.mm.kernel.g.ajR().ajA().get(69377, null);
      str = (String)com.tencent.mm.kernel.g.ajR().ajA().get(69378, null);
      if ((bu.isNullOrNil((String)localObject)) || (bu.isNullOrNil(str))) {
        localObject = null;
      }
    }
    for (;;)
    {
      this.Llz = ((org.b.d.i)localObject);
      AppMethodBeat.o(152862);
      return;
      localObject = new org.b.d.i((String)localObject, str);
      continue;
      ae.e("Twitter", "acchas not ready for restoreTwitterAccessToken");
      localObject = null;
    }
  }
  
  static void a(org.b.d.i parami)
  {
    AppMethodBeat.i(152865);
    ak.getContext().getSharedPreferences(ak.fow(), 0);
    if (parami == null)
    {
      com.tencent.mm.kernel.g.ajR().ajA().set(69377, "");
      com.tencent.mm.kernel.g.ajR().ajA().set(69378, "");
      AppMethodBeat.o(152865);
      return;
    }
    com.tencent.mm.kernel.g.ajR().ajA().set(69377, parami.token);
    com.tencent.mm.kernel.g.ajR().ajA().set(69378, parami.HmQ);
    AppMethodBeat.o(152865);
  }
  
  static void yU(boolean paramBoolean)
  {
    AppMethodBeat.i(152870);
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean) {}
    for (String str = "1";; str = "2")
    {
      localArrayList.add(new i.a(10251, str));
      ((l)com.tencent.mm.kernel.g.ab(l.class)).azE().d(new com.tencent.mm.ba.i(localArrayList));
      AppMethodBeat.o(152870);
      return;
    }
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(152864);
    if (this.LlC)
    {
      AppMethodBeat.o(152864);
      return;
    }
    this.LlE = parama;
    this.LlC = true;
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(152854);
        Object localObject = a.c.LlI;
        if (a.this.Llz == null) {
          localObject = a.c.LlJ;
        }
        for (;;)
        {
          localObject = a.this.AfN.obtainMessage(1010, localObject);
          a.this.AfN.sendMessage((Message)localObject);
          AppMethodBeat.o(152854);
          return;
          c localc1 = new c(org.b.d.j.OtA, "https://api.twitter.com/1.1/account/verify_credentials.json");
          a.this.Lly.a(a.this.Llz, localc1);
          try
          {
            if (localc1.gDb().code != 200) {
              localObject = a.c.LlJ;
            }
          }
          catch (Exception localException)
          {
            ae.printErrStackTrace("MicroMsg.Twitter", localException, "request error.", new Object[0]);
            a.c localc = a.c.LlJ;
          }
        }
      }
    }, "Twitter_validationAccessToken");
    AppMethodBeat.o(152864);
  }
  
  public final void a(a.b paramb, Context paramContext)
  {
    AppMethodBeat.i(152863);
    if (this.LlB)
    {
      AppMethodBeat.o(152863);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(583L, 0L, 1L, false);
    this.LlD = paramb;
    this.context = paramContext;
    this.LlB = true;
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        Object localObject = null;
        AppMethodBeat.i(152853);
        try
        {
          a.this.LlA = a.this.Lly.gDh();
          String str = a.this.Lly.b(a.this.LlA);
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
        localObject = a.this.AfN.obtainMessage(1000, localObject);
        a.this.AfN.sendMessage((Message)localObject);
        AppMethodBeat.o(152853);
      }
    }, "Twitter_doOAuth");
    AppMethodBeat.o(152863);
  }
  
  final void c(c paramc)
  {
    AppMethodBeat.i(152866);
    this.LlB = false;
    this.LlA = null;
    if (this.LlD != null) {
      this.LlD.a(paramc);
    }
    AppMethodBeat.o(152866);
  }
  
  public final boolean fPD()
  {
    return this.Llz != null;
  }
  
  public final void fPE()
  {
    AppMethodBeat.i(152868);
    yU(false);
    c(c.LlJ);
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(583L, 2L, 1L, false);
    AppMethodBeat.o(152868);
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(152869);
    yU(false);
    c(c.LlK);
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(583L, 3L, 1L, false);
    AppMethodBeat.o(152869);
  }
  
  public final void y(final Bundle paramBundle)
  {
    AppMethodBeat.i(152867);
    com.tencent.mm.kernel.g.ajU().aw(new Runnable()
    {
      public final void run()
      {
        Object localObject3 = null;
        AppMethodBeat.i(152857);
        if (a.this.LlA == null)
        {
          AppMethodBeat.o(152857);
          return;
        }
        a.yU(true);
        String str = paramBundle.getString("oauth_verifier");
        Object localObject1 = localObject3;
        if (str != null) {
          localObject1 = new k(str);
        }
        try
        {
          localObject1 = a.this.Lly.a(a.this.LlA, (k)localObject1);
          if (localObject1 != null)
          {
            a.this.Llz = ((org.b.d.i)localObject1);
            a.a(a.this.Llz);
            new aq(Looper.getMainLooper()).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(152855);
                a.this.c(a.c.LlI);
                com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(583L, 1L, 1L, false);
                AppMethodBeat.o(152855);
              }
            });
            AppMethodBeat.o(152857);
            return;
          }
          new aq(Looper.getMainLooper()).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(152856);
              a.this.c(a.c.LlJ);
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(583L, 4L, 1L, false);
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
      LlI = new c("Finished", 0);
      LlJ = new c("Failed", 1);
      LlK = new c("Canceled", 2);
      LlL = new c[] { LlI, LlJ, LlK };
      AppMethodBeat.o(152861);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.k.a
 * JD-Core Version:    0.7.0.1
 */