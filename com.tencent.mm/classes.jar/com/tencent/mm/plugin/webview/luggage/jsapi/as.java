package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.d;
import com.tencent.mm.g.a.st;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import org.json.JSONException;
import org.json.JSONObject;

public class as
  extends bo
{
  public final void a(final Context paramContext, final String paramString, final bn.a parama)
  {
    AppMethodBeat.i(78604);
    Object localObject2;
    try
    {
      localObject3 = new JSONObject(paramString);
      localObject2 = ((JSONObject)localObject3).optString("username");
      if ((localObject2 == null) || (((String)localObject2).length() == 0))
      {
        ac.e("MicroMsg.JsApiProfile", "doProfile fail, username is null");
        parama.f("fail", null);
        AppMethodBeat.o(78604);
        return;
      }
    }
    catch (JSONException paramContext)
    {
      ac.e("MicroMsg.JsApiProfile", "parase json fail");
      parama.f("fail", null);
      AppMethodBeat.o(78604);
      return;
    }
    if (bs.isNullOrNil((String)localObject2))
    {
      com.tencent.mm.ipcinvoker.p.z(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(78600);
          Toast.makeText(com.tencent.mm.sdk.platformtools.ai.getContext(), com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131759562, new Object[] { Integer.valueOf(3), Integer.valueOf(-1) }), 0).show();
          AppMethodBeat.o(78600);
        }
      });
      parama.f("fail", null);
      AppMethodBeat.o(78604);
      return;
    }
    g.agP();
    if (!com.tencent.mm.kernel.a.afX())
    {
      ac.e("MicroMsg.JsApiProfile", "doProfile, MMCore.hasCfgDefaultUin() is false");
      parama.f("fail", null);
      AppMethodBeat.o(78604);
      return;
    }
    Object localObject1 = ((k)g.ab(k.class)).awB().aNt((String)localObject2);
    if (localObject1 != null)
    {
      paramString = (String)localObject1;
      if ((int)((com.tencent.mm.n.b)localObject1).fLJ > 0) {}
    }
    else
    {
      paramString = ((k)g.ab(k.class)).awB().aNp((String)localObject2);
    }
    localObject1 = new Intent();
    Object localObject3 = ((JSONObject)localObject3).optString("profileReportInfo");
    if (!bs.isNullOrNil((String)localObject3)) {
      ((Intent)localObject1).putExtra("key_add_contact_report_info", (String)localObject3);
    }
    if ((paramString != null) && ((int)paramString.fLJ > 0))
    {
      ((Intent)localObject1).addFlags(268435456);
      ((Intent)localObject1).putExtra("Contact_User", paramString.field_username);
      if (paramString.fad()) {
        ((Intent)localObject1).putExtra("Contact_Scene", 42);
      }
      if (com.tencent.mm.n.b.ln(paramString.field_type))
      {
        localObject2 = new st();
        ((st)localObject2).dvI.intent = ((Intent)localObject1);
        ((st)localObject2).dvI.username = paramString.field_username;
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject2);
      }
      com.tencent.mm.plugin.webview.a.a.iyx.c((Intent)localObject1, paramContext);
      parama.f(null, null);
      AppMethodBeat.o(78604);
      return;
    }
    paramContext.getString(2131755906);
    paramString = com.tencent.mm.ui.base.h.b(paramContext, paramContext.getString(2131755936), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(78601);
        ar.a.hnw.yd(this.fur);
        parama.f("cancel", null);
        AppMethodBeat.o(78601);
      }
    });
    ar.a.hnw.a((String)localObject2, "", new ar.b.a()
    {
      public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(78603);
        if (paramContext == null)
        {
          ac.w("MicroMsg.JsApiProfile", "getNow callback, msghandler has already been detached!");
          parama.f("fail", null);
          AppMethodBeat.o(78603);
          return;
        }
        if (paramString != null) {
          paramString.dismiss();
        }
        com.tencent.mm.storage.ai localai2 = ((k)g.ab(k.class)).awB().aNt(paramAnonymousString);
        com.tencent.mm.storage.ai localai1;
        if (localai2 != null)
        {
          localai1 = localai2;
          if ((int)localai2.fLJ > 0) {}
        }
        else
        {
          localai1 = ((k)g.ab(k.class)).awB().aNp(paramAnonymousString);
        }
        if ((localai1 == null) || ((int)localai1.fLJ <= 0)) {
          paramAnonymousBoolean = false;
        }
        while (!paramAnonymousBoolean)
        {
          com.tencent.mm.ipcinvoker.p.z(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(78602);
              Toast.makeText(com.tencent.mm.sdk.platformtools.ai.getContext(), as.3.this.val$context.getString(2131759562, new Object[] { Integer.valueOf(3), Integer.valueOf(-1) }), 0).show();
              AppMethodBeat.o(78602);
            }
          });
          parama.f("fail", null);
          AppMethodBeat.o(78603);
          return;
          paramAnonymousString = localai1.field_username;
        }
        c.ag(paramAnonymousString, 3);
        com.tencent.mm.aj.p.aBy().zV(paramAnonymousString);
        this.val$intent.addFlags(268435456);
        this.val$intent.putExtra("Contact_User", paramAnonymousString);
        if (localai1.fad())
        {
          com.tencent.mm.plugin.report.service.h.wUl.kvStat(10298, localai1.field_username + ",42");
          this.val$intent.putExtra("Contact_Scene", 42);
        }
        com.tencent.mm.plugin.webview.a.a.iyx.c(this.val$intent, paramContext);
        parama.f(null, null);
        AppMethodBeat.o(78603);
      }
    });
    AppMethodBeat.o(78604);
  }
  
  public final void b(a.a parama) {}
  
  public final int bYk()
  {
    return 2;
  }
  
  public final String name()
  {
    return "profile";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.as
 * JD-Core Version:    0.7.0.1
 */