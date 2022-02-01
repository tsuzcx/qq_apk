package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.g.a.sk;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
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
        ad.e("MicroMsg.JsApiProfile", "doProfile fail, username is null");
        parama.f("fail", null);
        AppMethodBeat.o(78604);
        return;
      }
    }
    catch (JSONException paramContext)
    {
      ad.e("MicroMsg.JsApiProfile", "parase json fail");
      parama.f("fail", null);
      AppMethodBeat.o(78604);
      return;
    }
    if (bt.isNullOrNil((String)localObject2))
    {
      com.tencent.mm.ipcinvoker.p.y(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(78600);
          Toast.makeText(aj.getContext(), aj.getContext().getString(2131759562, new Object[] { Integer.valueOf(3), Integer.valueOf(-1) }), 0).show();
          AppMethodBeat.o(78600);
        }
      });
      parama.f("fail", null);
      AppMethodBeat.o(78604);
      return;
    }
    g.afz();
    if (!com.tencent.mm.kernel.a.aeH())
    {
      ad.e("MicroMsg.JsApiProfile", "doProfile, MMCore.hasCfgDefaultUin() is false");
      parama.f("fail", null);
      AppMethodBeat.o(78604);
      return;
    }
    Object localObject1 = ((k)g.ab(k.class)).apM().aHY((String)localObject2);
    if (localObject1 != null)
    {
      paramString = (String)localObject1;
      if ((int)((com.tencent.mm.n.b)localObject1).fId > 0) {}
    }
    else
    {
      paramString = ((k)g.ab(k.class)).apM().aHU((String)localObject2);
    }
    localObject1 = new Intent();
    Object localObject3 = ((JSONObject)localObject3).optString("profileReportInfo");
    if (!bt.isNullOrNil((String)localObject3)) {
      ((Intent)localObject1).putExtra("key_add_contact_report_info", (String)localObject3);
    }
    if ((paramString != null) && ((int)paramString.fId > 0))
    {
      ((Intent)localObject1).addFlags(268435456);
      ((Intent)localObject1).putExtra("Contact_User", paramString.field_username);
      if (paramString.eKB()) {
        ((Intent)localObject1).putExtra("Contact_Scene", 42);
      }
      if (com.tencent.mm.n.b.ls(paramString.field_type))
      {
        localObject2 = new sk();
        ((sk)localObject2).dxW.intent = ((Intent)localObject1);
        ((sk)localObject2).dxW.username = paramString.field_username;
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject2);
      }
      com.tencent.mm.plugin.webview.a.a.hYt.c((Intent)localObject1, paramContext);
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
        ar.a.gMW.tX(this.fqK);
        parama.f("cancel", null);
        AppMethodBeat.o(78601);
      }
    });
    ar.a.gMW.a((String)localObject2, "", new ar.b.a()
    {
      public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(78603);
        if (paramContext == null)
        {
          ad.w("MicroMsg.JsApiProfile", "getNow callback, msghandler has already been detached!");
          parama.f("fail", null);
          AppMethodBeat.o(78603);
          return;
        }
        if (paramString != null) {
          paramString.dismiss();
        }
        af localaf2 = ((k)g.ab(k.class)).apM().aHY(paramAnonymousString);
        af localaf1;
        if (localaf2 != null)
        {
          localaf1 = localaf2;
          if ((int)localaf2.fId > 0) {}
        }
        else
        {
          localaf1 = ((k)g.ab(k.class)).apM().aHU(paramAnonymousString);
        }
        if ((localaf1 == null) || ((int)localaf1.fId <= 0)) {
          paramAnonymousBoolean = false;
        }
        while (!paramAnonymousBoolean)
        {
          com.tencent.mm.ipcinvoker.p.y(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(78602);
              Toast.makeText(aj.getContext(), as.3.this.val$context.getString(2131759562, new Object[] { Integer.valueOf(3), Integer.valueOf(-1) }), 0).show();
              AppMethodBeat.o(78602);
            }
          });
          parama.f("fail", null);
          AppMethodBeat.o(78603);
          return;
          paramAnonymousString = localaf1.field_username;
        }
        c.ac(paramAnonymousString, 3);
        com.tencent.mm.ak.p.auH().vP(paramAnonymousString);
        this.val$intent.addFlags(268435456);
        this.val$intent.putExtra("Contact_User", paramAnonymousString);
        if (localaf1.eKB())
        {
          com.tencent.mm.plugin.report.service.h.vKh.kvStat(10298, localaf1.field_username + ",42");
          this.val$intent.putExtra("Contact_Scene", 42);
        }
        com.tencent.mm.plugin.webview.a.a.hYt.c(this.val$intent, paramContext);
        parama.f(null, null);
        AppMethodBeat.o(78603);
      }
    });
    AppMethodBeat.o(78604);
  }
  
  public final void b(a.a parama) {}
  
  public final int bQV()
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