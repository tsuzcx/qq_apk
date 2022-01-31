package com.tencent.mm.ui.j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.h.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.List;
import org.b.a.a.c.a;
import org.b.d.c;
import org.b.e.b;

@SuppressLint({"HandlerLeak"})
public final class a
  implements b.a
{
  b ABa;
  public org.b.d.i ABb;
  org.b.d.i ABc;
  private boolean ABd;
  boolean ABe;
  public a.b ABf;
  public a.a ABg;
  Context context;
  ak rER;
  
  public a()
  {
    AppMethodBeat.i(80350);
    this.ABa = null;
    this.ABb = null;
    this.ABc = null;
    this.ABd = false;
    this.ABe = false;
    this.ABf = null;
    this.ABg = null;
    this.context = null;
    this.rER = new a.1(this);
    Object localObject = new org.b.a.a();
    ((org.b.a.a)localObject).CRC = org.b.a.a.bc(c.a.class);
    org.b.g.d.jJ("XMr2y8FEVEqZBcZ1TU3gLA", "Invalid Api key");
    ((org.b.a.a)localObject).CRz = "XMr2y8FEVEqZBcZ1TU3gLA";
    org.b.g.d.jJ("kyWwA5vbB6H1NDQFufR9hD5vWGStxhweIbatclCo", "Invalid Api secret");
    ((org.b.a.a)localObject).CRA = "kyWwA5vbB6H1NDQFufR9hD5vWGStxhweIbatclCo";
    org.b.g.d.s("wechatapp://sign-in-twitter.wechatapp.com/", "Callback can't be null");
    ((org.b.a.a)localObject).CRB = "wechatapp://sign-in-twitter.wechatapp.com/";
    org.b.g.d.s(((org.b.a.a)localObject).CRC, "You must specify a valid api through the provider() method");
    org.b.g.d.jJ(((org.b.a.a)localObject).CRz, "You must provide an api key");
    org.b.g.d.jJ(((org.b.a.a)localObject).CRA, "You must provide an api secret");
    this.ABa = ((org.b.a.a)localObject).CRC.a(new org.b.d.a(((org.b.a.a)localObject).CRz, ((org.b.a.a)localObject).CRA, ((org.b.a.a)localObject).CRB, ((org.b.a.a)localObject).CRD, ((org.b.a.a)localObject).scope, ((org.b.a.a)localObject).CRE));
    String str;
    if (com.tencent.mm.kernel.g.RJ().QU())
    {
      localObject = (String)com.tencent.mm.kernel.g.RL().Ru().get(69377, null);
      str = (String)com.tencent.mm.kernel.g.RL().Ru().get(69378, null);
      if ((bo.isNullOrNil((String)localObject)) || (bo.isNullOrNil(str))) {
        localObject = null;
      }
    }
    for (;;)
    {
      this.ABb = ((org.b.d.i)localObject);
      AppMethodBeat.o(80350);
      return;
      localObject = new org.b.d.i((String)localObject, str);
      continue;
      ab.e("Twitter", "acchas not ready for restoreTwitterAccessToken");
      localObject = null;
    }
  }
  
  static void a(org.b.d.i parami)
  {
    AppMethodBeat.i(80353);
    ah.getContext().getSharedPreferences(ah.dsP(), 0);
    if (parami == null)
    {
      com.tencent.mm.kernel.g.RL().Ru().set(69377, "");
      com.tencent.mm.kernel.g.RL().Ru().set(69378, "");
      AppMethodBeat.o(80353);
      return;
    }
    com.tencent.mm.kernel.g.RL().Ru().set(69377, parami.token);
    com.tencent.mm.kernel.g.RL().Ru().set(69378, parami.xsy);
    AppMethodBeat.o(80353);
  }
  
  static void rx(boolean paramBoolean)
  {
    AppMethodBeat.i(80358);
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean) {}
    for (String str = "1";; str = "2")
    {
      localArrayList.add(new h.a(10251, str));
      ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Yz().c(new com.tencent.mm.az.h(localArrayList));
      AppMethodBeat.o(80358);
      return;
    }
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(80352);
    if (this.ABe)
    {
      AppMethodBeat.o(80352);
      return;
    }
    this.ABg = parama;
    this.ABe = true;
    com.tencent.mm.sdk.g.d.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(80342);
        Object localObject = a.c.ABk;
        if (a.this.ABb == null) {
          localObject = a.c.ABl;
        }
        for (;;)
        {
          localObject = a.this.rER.obtainMessage(1010, localObject);
          a.this.rER.sendMessage((Message)localObject);
          AppMethodBeat.o(80342);
          return;
          c localc1 = new c(org.b.d.j.CRV, "https://api.twitter.com/1.1/account/verify_credentials.json");
          a.this.ABa.a(a.this.ABb, localc1);
          try
          {
            if (localc1.erD().code != 200) {
              localObject = a.c.ABl;
            }
          }
          catch (Exception localException)
          {
            ab.printErrStackTrace("MicroMsg.Twitter", localException, "request error.", new Object[0]);
            a.c localc = a.c.ABl;
          }
        }
      }
    }, "Twitter_validationAccessToken");
    AppMethodBeat.o(80352);
  }
  
  public final void a(a.b paramb, Context paramContext)
  {
    AppMethodBeat.i(80351);
    if (this.ABd)
    {
      AppMethodBeat.o(80351);
      return;
    }
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(583L, 0L, 1L, false);
    this.ABf = paramb;
    this.context = paramContext;
    this.ABd = true;
    com.tencent.mm.sdk.g.d.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(80341);
        try
        {
          a.this.ABc = a.this.ABa.erJ();
          Object localObject1 = a.this.ABa.b(a.this.ABc);
          localObject1 = a.this.rER.obtainMessage(1000, localObject1);
          a.this.rER.sendMessage((Message)localObject1);
          AppMethodBeat.o(80341);
          return;
        }
        catch (org.b.b.a locala)
        {
          for (;;)
          {
            Object localObject2 = null;
          }
        }
      }
    }, "Twitter_doOAuth");
    AppMethodBeat.o(80351);
  }
  
  final void c(a.c paramc)
  {
    AppMethodBeat.i(80354);
    this.ABd = false;
    this.ABc = null;
    if (this.ABf != null) {
      this.ABf.a(paramc);
    }
    AppMethodBeat.o(80354);
  }
  
  public final boolean dOy()
  {
    return this.ABb != null;
  }
  
  public final void dOz()
  {
    AppMethodBeat.i(80356);
    rx(false);
    c(a.c.ABl);
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(583L, 2L, 1L, false);
    AppMethodBeat.o(80356);
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(80357);
    rx(false);
    c(a.c.ABm);
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(583L, 3L, 1L, false);
    AppMethodBeat.o(80357);
  }
  
  public final void u(Bundle paramBundle)
  {
    AppMethodBeat.i(80355);
    com.tencent.mm.kernel.g.RO().ac(new a.4(this, paramBundle));
    AppMethodBeat.o(80355);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.j.a
 * JD-Core Version:    0.7.0.1
 */