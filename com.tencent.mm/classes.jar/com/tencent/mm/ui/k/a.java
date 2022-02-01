package com.tencent.mm.ui.k;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ba.i.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
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
  org.b.e.b IXV;
  public org.b.d.i IXW;
  org.b.d.i IXX;
  private boolean IXY;
  boolean IXZ;
  public a.b IYa;
  public a.a IYb;
  Context context;
  ao yxu;
  
  public a()
  {
    AppMethodBeat.i(152862);
    this.IXV = null;
    this.IXW = null;
    this.IXX = null;
    this.IXY = false;
    this.IXZ = false;
    this.IYa = null;
    this.IYb = null;
    this.context = null;
    this.yxu = new ao()
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
          f.R(localContext, "Error", "Application requires permission to access the Internet");
        }
        for (;;)
        {
          if (paramAnonymousMessage.what == 1010)
          {
            paramAnonymousMessage = (a.c)paramAnonymousMessage.obj;
            localObject = a.this;
            ((a)localObject).IXZ = false;
            if (paramAnonymousMessage == a.c.IYg)
            {
              ((a)localObject).IXX = null;
              a.a(null);
            }
            if (((a)localObject).IYb != null) {
              ((a)localObject).IYb.b(paramAnonymousMessage);
            }
          }
          AppMethodBeat.o(152852);
          return;
          label125:
          new b(localContext, (String)localObject, locala).show();
          continue;
          label142:
          a.this.c(a.c.IYg);
        }
      }
    };
    Object localObject = new org.b.a.a();
    ((org.b.a.a)localObject).Mba = org.b.a.a.bF(c.a.class);
    d.np("XMr2y8FEVEqZBcZ1TU3gLA", "Invalid Api key");
    ((org.b.a.a)localObject).MaX = "XMr2y8FEVEqZBcZ1TU3gLA";
    d.np("kyWwA5vbB6H1NDQFufR9hD5vWGStxhweIbatclCo", "Invalid Api secret");
    ((org.b.a.a)localObject).MaY = "kyWwA5vbB6H1NDQFufR9hD5vWGStxhweIbatclCo";
    d.j("wechatapp://sign-in-twitter.wechatapp.com/", "Callback can't be null");
    ((org.b.a.a)localObject).MaZ = "wechatapp://sign-in-twitter.wechatapp.com/";
    d.j(((org.b.a.a)localObject).Mba, "You must specify a valid api through the provider() method");
    d.np(((org.b.a.a)localObject).MaX, "You must provide an api key");
    d.np(((org.b.a.a)localObject).MaY, "You must provide an api secret");
    this.IXV = ((org.b.a.a)localObject).Mba.a(new org.b.d.a(((org.b.a.a)localObject).MaX, ((org.b.a.a)localObject).MaY, ((org.b.a.a)localObject).MaZ, ((org.b.a.a)localObject).Mbb, ((org.b.a.a)localObject).scope, ((org.b.a.a)localObject).Mbc));
    String str;
    if (com.tencent.mm.kernel.g.agP().afY())
    {
      localObject = (String)com.tencent.mm.kernel.g.agR().agA().get(69377, null);
      str = (String)com.tencent.mm.kernel.g.agR().agA().get(69378, null);
      if ((bs.isNullOrNil((String)localObject)) || (bs.isNullOrNil(str))) {
        localObject = null;
      }
    }
    for (;;)
    {
      this.IXW = ((org.b.d.i)localObject);
      AppMethodBeat.o(152862);
      return;
      localObject = new org.b.d.i((String)localObject, str);
      continue;
      ac.e("Twitter", "acchas not ready for restoreTwitterAccessToken");
      localObject = null;
    }
  }
  
  static void a(org.b.d.i parami)
  {
    AppMethodBeat.i(152865);
    ai.getContext().getSharedPreferences(ai.eUX(), 0);
    if (parami == null)
    {
      com.tencent.mm.kernel.g.agR().agA().set(69377, "");
      com.tencent.mm.kernel.g.agR().agA().set(69378, "");
      AppMethodBeat.o(152865);
      return;
    }
    com.tencent.mm.kernel.g.agR().agA().set(69377, parami.token);
    com.tencent.mm.kernel.g.agR().agA().set(69378, parami.FjO);
    AppMethodBeat.o(152865);
  }
  
  static void xS(boolean paramBoolean)
  {
    AppMethodBeat.i(152870);
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean) {}
    for (String str = "1";; str = "2")
    {
      localArrayList.add(new i.a(10251, str));
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awA().c(new com.tencent.mm.ba.i(localArrayList));
      AppMethodBeat.o(152870);
      return;
    }
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(152864);
    if (this.IXZ)
    {
      AppMethodBeat.o(152864);
      return;
    }
    this.IYb = parama;
    this.IXZ = true;
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(152854);
        Object localObject = a.c.IYf;
        if (a.this.IXW == null) {
          localObject = a.c.IYg;
        }
        for (;;)
        {
          localObject = a.this.yxu.obtainMessage(1010, localObject);
          a.this.yxu.sendMessage((Message)localObject);
          AppMethodBeat.o(152854);
          return;
          c localc1 = new c(j.Mbt, "https://api.twitter.com/1.1/account/verify_credentials.json");
          a.this.IXV.a(a.this.IXW, localc1);
          try
          {
            if (localc1.gfV().code != 200) {
              localObject = a.c.IYg;
            }
          }
          catch (Exception localException)
          {
            ac.printErrStackTrace("MicroMsg.Twitter", localException, "request error.", new Object[0]);
            a.c localc = a.c.IYg;
          }
        }
      }
    }, "Twitter_validationAccessToken");
    AppMethodBeat.o(152864);
  }
  
  public final void a(a.b paramb, Context paramContext)
  {
    AppMethodBeat.i(152863);
    if (this.IXY)
    {
      AppMethodBeat.o(152863);
      return;
    }
    h.wUl.idkeyStat(583L, 0L, 1L, false);
    this.IYa = paramb;
    this.context = paramContext;
    this.IXY = true;
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        Object localObject = null;
        AppMethodBeat.i(152853);
        try
        {
          a.this.IXX = a.this.IXV.ggb();
          String str = a.this.IXV.b(a.this.IXX);
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
        localObject = a.this.yxu.obtainMessage(1000, localObject);
        a.this.yxu.sendMessage((Message)localObject);
        AppMethodBeat.o(152853);
      }
    }, "Twitter_doOAuth");
    AppMethodBeat.o(152863);
  }
  
  final void c(c paramc)
  {
    AppMethodBeat.i(152866);
    this.IXY = false;
    this.IXX = null;
    if (this.IYa != null) {
      this.IYa.a(paramc);
    }
    AppMethodBeat.o(152866);
  }
  
  public final boolean fux()
  {
    return this.IXW != null;
  }
  
  public final void fuy()
  {
    AppMethodBeat.i(152868);
    xS(false);
    c(c.IYg);
    h.wUl.idkeyStat(583L, 2L, 1L, false);
    AppMethodBeat.o(152868);
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(152869);
    xS(false);
    c(c.IYh);
    h.wUl.idkeyStat(583L, 3L, 1L, false);
    AppMethodBeat.o(152869);
  }
  
  public final void w(final Bundle paramBundle)
  {
    AppMethodBeat.i(152867);
    com.tencent.mm.kernel.g.agU().az(new Runnable()
    {
      public final void run()
      {
        Object localObject3 = null;
        AppMethodBeat.i(152857);
        if (a.this.IXX == null)
        {
          AppMethodBeat.o(152857);
          return;
        }
        a.xS(true);
        String str = paramBundle.getString("oauth_verifier");
        Object localObject1 = localObject3;
        if (str != null) {
          localObject1 = new org.b.d.k(str);
        }
        try
        {
          localObject1 = a.this.IXV.a(a.this.IXX, (org.b.d.k)localObject1);
          if (localObject1 != null)
          {
            a.this.IXW = ((org.b.d.i)localObject1);
            a.a(a.this.IXW);
            new ao(Looper.getMainLooper()).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(152855);
                a.this.c(a.c.IYf);
                h.wUl.idkeyStat(583L, 1L, 1L, false);
                AppMethodBeat.o(152855);
              }
            });
            AppMethodBeat.o(152857);
            return;
          }
          new ao(Looper.getMainLooper()).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(152856);
              a.this.c(a.c.IYg);
              h.wUl.idkeyStat(583L, 4L, 1L, false);
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
      IYf = new c("Finished", 0);
      IYg = new c("Failed", 1);
      IYh = new c("Canceled", 2);
      IYi = new c[] { IYf, IYg, IYh };
      AppMethodBeat.o(152861);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.k.a
 * JD-Core Version:    0.7.0.1
 */