package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.e;
import com.tencent.mm.am.q;
import com.tencent.mm.f.a.vm;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.ipcinvoker.s;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.webview.a.a;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import org.json.JSONException;
import org.json.JSONObject;

public class au
  extends bs
{
  public final void a(final Context paramContext, final String paramString, final br.a parama)
  {
    AppMethodBeat.i(78604);
    Object localObject2;
    try
    {
      localObject3 = new JSONObject(paramString);
      localObject2 = ((JSONObject)localObject3).optString("username");
      if ((localObject2 == null) || (((String)localObject2).length() == 0))
      {
        Log.e("MicroMsg.JsApiProfile", "doProfile fail, username is null");
        parama.i("fail", null);
        AppMethodBeat.o(78604);
        return;
      }
    }
    catch (JSONException paramContext)
    {
      Log.e("MicroMsg.JsApiProfile", "parase json fail");
      parama.i("fail", null);
      AppMethodBeat.o(78604);
      return;
    }
    if (Util.isNullOrNil((String)localObject2))
    {
      s.y(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(78600);
          Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(c.i.fmt_self_qrcode_getting_err, new Object[] { Integer.valueOf(3), Integer.valueOf(-1) }), 0).show();
          AppMethodBeat.o(78600);
        }
      });
      parama.i("fail", null);
      AppMethodBeat.o(78604);
      return;
    }
    com.tencent.mm.kernel.h.aHE();
    if (!b.aGL())
    {
      Log.e("MicroMsg.JsApiProfile", "doProfile, MMCore.hasCfgDefaultUin() is false");
      parama.i("fail", null);
      AppMethodBeat.o(78604);
      return;
    }
    Object localObject1 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG((String)localObject2);
    if (localObject1 != null)
    {
      paramString = (String)localObject1;
      if ((int)((com.tencent.mm.contact.d)localObject1).jxt > 0) {}
    }
    else
    {
      paramString = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().bwe((String)localObject2);
    }
    localObject1 = new Intent();
    Object localObject3 = ((JSONObject)localObject3).optString("profileReportInfo");
    if (!Util.isNullOrNil((String)localObject3)) {
      ((Intent)localObject1).putExtra("key_add_contact_report_info", (String)localObject3);
    }
    if ((paramString != null) && ((int)paramString.jxt > 0))
    {
      ((Intent)localObject1).addFlags(268435456);
      ((Intent)localObject1).putExtra("Contact_User", paramString.field_username);
      if (paramString.hxX()) {
        ((Intent)localObject1).putExtra("Contact_Scene", 42);
      }
      if (com.tencent.mm.contact.d.rk(paramString.field_type))
      {
        localObject2 = new vm();
        ((vm)localObject2).fUF.intent = ((Intent)localObject1);
        ((vm)localObject2).fUF.username = paramString.field_username;
        EventCenter.instance.publish((IEvent)localObject2);
      }
      a.mIG.c((Intent)localObject1, paramContext);
      parama.i(null, null);
      AppMethodBeat.o(78604);
      return;
    }
    paramContext.getString(c.i.app_tip);
    paramString = com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(c.i.app_waiting), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(78601);
        az.a.ltq.Rr(this.iXG);
        parama.i("cancel", null);
        AppMethodBeat.o(78601);
      }
    });
    az.a.ltq.a((String)localObject2, "", new az.b.a()
    {
      public final void s(String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(78603);
        if (paramContext == null)
        {
          Log.w("MicroMsg.JsApiProfile", "getNow callback, msghandler has already been detached!");
          parama.i("fail", null);
          AppMethodBeat.o(78603);
          return;
        }
        if (paramString != null) {
          paramString.dismiss();
        }
        as localas2 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramAnonymousString);
        as localas1;
        if (localas2 != null)
        {
          localas1 = localas2;
          if ((int)localas2.jxt > 0) {}
        }
        else
        {
          localas1 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().bwe(paramAnonymousString);
        }
        if ((localas1 == null) || ((int)localas1.jxt <= 0)) {
          paramAnonymousBoolean = false;
        }
        while (!paramAnonymousBoolean)
        {
          s.y(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(78602);
              Toast.makeText(MMApplicationContext.getContext(), au.3.this.val$context.getString(c.i.fmt_self_qrcode_getting_err, new Object[] { Integer.valueOf(3), Integer.valueOf(-1) }), 0).show();
              AppMethodBeat.o(78602);
            }
          });
          parama.i("fail", null);
          AppMethodBeat.o(78603);
          return;
          paramAnonymousString = localas1.field_username;
        }
        com.tencent.mm.am.d.aH(paramAnonymousString, 3);
        q.bhR().TB(paramAnonymousString);
        this.val$intent.addFlags(268435456);
        this.val$intent.putExtra("Contact_User", paramAnonymousString);
        if (localas1.hxX())
        {
          com.tencent.mm.plugin.report.service.h.IzE.kvStat(10298, localas1.field_username + ",42");
          this.val$intent.putExtra("Contact_Scene", 42);
        }
        a.mIG.c(this.val$intent, paramContext);
        parama.i(null, null);
        AppMethodBeat.o(78603);
      }
    });
    AppMethodBeat.o(78604);
  }
  
  public final void b(b.a parama) {}
  
  public final int cDj()
  {
    return 2;
  }
  
  public final String name()
  {
    return "profile";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.au
 * JD-Core Version:    0.7.0.1
 */