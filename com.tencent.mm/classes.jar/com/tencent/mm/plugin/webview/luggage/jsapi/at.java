package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.g.a.tk;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
import com.tencent.mm.model.as.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.base.h;
import org.json.JSONException;
import org.json.JSONObject;

public class at
  extends br
{
  public final void a(final Context paramContext, final String paramString, final bq.a parama)
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
      com.tencent.mm.ipcinvoker.p.z(new Runnable()
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
    com.tencent.mm.kernel.g.ajA();
    if (!com.tencent.mm.kernel.a.aiJ())
    {
      ad.e("MicroMsg.JsApiProfile", "doProfile, MMCore.hasCfgDefaultUin() is false");
      parama.f("fail", null);
      AppMethodBeat.o(78604);
      return;
    }
    Object localObject1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf((String)localObject2);
    if (localObject1 != null)
    {
      paramString = (String)localObject1;
      if ((int)((com.tencent.mm.o.b)localObject1).gfj > 0) {}
    }
    else
    {
      paramString = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().aTh((String)localObject2);
    }
    localObject1 = new Intent();
    Object localObject3 = ((JSONObject)localObject3).optString("profileReportInfo");
    if (!bt.isNullOrNil((String)localObject3)) {
      ((Intent)localObject1).putExtra("key_add_contact_report_info", (String)localObject3);
    }
    if ((paramString != null) && ((int)paramString.gfj > 0))
    {
      ((Intent)localObject1).addFlags(268435456);
      ((Intent)localObject1).putExtra("Contact_User", paramString.field_username);
      if (paramString.fqg()) {
        ((Intent)localObject1).putExtra("Contact_Scene", 42);
      }
      if (com.tencent.mm.o.b.lM(paramString.field_type))
      {
        localObject2 = new tk();
        ((tk)localObject2).dHR.intent = ((Intent)localObject1);
        ((tk)localObject2).dHR.username = paramString.field_username;
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject2);
      }
      com.tencent.mm.plugin.webview.a.a.iRG.c((Intent)localObject1, paramContext);
      parama.f(null, null);
      AppMethodBeat.o(78604);
      return;
    }
    paramContext.getString(2131755906);
    paramString = h.b(paramContext, paramContext.getString(2131755936), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(78601);
        as.a.hFO.AJ(this.fNr);
        parama.f("cancel", null);
        AppMethodBeat.o(78601);
      }
    });
    as.a.hFO.a((String)localObject2, "", new as.b.a()
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
        am localam2 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(paramAnonymousString);
        am localam1;
        if (localam2 != null)
        {
          localam1 = localam2;
          if ((int)localam2.gfj > 0) {}
        }
        else
        {
          localam1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().aTh(paramAnonymousString);
        }
        if ((localam1 == null) || ((int)localam1.gfj <= 0)) {
          paramAnonymousBoolean = false;
        }
        while (!paramAnonymousBoolean)
        {
          com.tencent.mm.ipcinvoker.p.z(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(78602);
              Toast.makeText(aj.getContext(), at.3.this.val$context.getString(2131759562, new Object[] { Integer.valueOf(3), Integer.valueOf(-1) }), 0).show();
              AppMethodBeat.o(78602);
            }
          });
          parama.f("fail", null);
          AppMethodBeat.o(78603);
          return;
          paramAnonymousString = localam1.field_username;
        }
        c.ak(paramAnonymousString, 3);
        com.tencent.mm.ak.p.aEz().CU(paramAnonymousString);
        this.val$intent.addFlags(268435456);
        this.val$intent.putExtra("Contact_User", paramAnonymousString);
        if (localam1.fqg())
        {
          com.tencent.mm.plugin.report.service.g.yhR.kvStat(10298, localam1.field_username + ",42");
          this.val$intent.putExtra("Contact_Scene", 42);
        }
        com.tencent.mm.plugin.webview.a.a.iRG.c(this.val$intent, paramContext);
        parama.f(null, null);
        AppMethodBeat.o(78603);
      }
    });
    AppMethodBeat.o(78604);
  }
  
  public final void b(b.a parama) {}
  
  public final int ccO()
  {
    return 2;
  }
  
  public final String name()
  {
    return "profile";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.at
 * JD-Core Version:    0.7.0.1
 */