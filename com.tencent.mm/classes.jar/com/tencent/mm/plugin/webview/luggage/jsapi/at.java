package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d;
import com.tencent.mm.g.a.tl;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.b;
import com.tencent.mm.model.au.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
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
        ae.e("MicroMsg.JsApiProfile", "doProfile fail, username is null");
        parama.f("fail", null);
        AppMethodBeat.o(78604);
        return;
      }
    }
    catch (JSONException paramContext)
    {
      ae.e("MicroMsg.JsApiProfile", "parase json fail");
      parama.f("fail", null);
      AppMethodBeat.o(78604);
      return;
    }
    if (bu.isNullOrNil((String)localObject2))
    {
      com.tencent.mm.ipcinvoker.p.x(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(78600);
          Toast.makeText(ak.getContext(), ak.getContext().getString(2131759562, new Object[] { Integer.valueOf(3), Integer.valueOf(-1) }), 0).show();
          AppMethodBeat.o(78600);
        }
      });
      parama.f("fail", null);
      AppMethodBeat.o(78604);
      return;
    }
    com.tencent.mm.kernel.g.ajP();
    if (!com.tencent.mm.kernel.a.aiY())
    {
      ae.e("MicroMsg.JsApiProfile", "doProfile, MMCore.hasCfgDefaultUin() is false");
      parama.f("fail", null);
      AppMethodBeat.o(78604);
      return;
    }
    Object localObject1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH((String)localObject2);
    if (localObject1 != null)
    {
      paramString = (String)localObject1;
      if ((int)((com.tencent.mm.contact.c)localObject1).ght > 0) {}
    }
    else
    {
      paramString = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().aUI((String)localObject2);
    }
    localObject1 = new Intent();
    Object localObject3 = ((JSONObject)localObject3).optString("profileReportInfo");
    if (!bu.isNullOrNil((String)localObject3)) {
      ((Intent)localObject1).putExtra("key_add_contact_report_info", (String)localObject3);
    }
    if ((paramString != null) && ((int)paramString.ght > 0))
    {
      ((Intent)localObject1).addFlags(268435456);
      ((Intent)localObject1).putExtra("Contact_User", paramString.field_username);
      if (paramString.fug()) {
        ((Intent)localObject1).putExtra("Contact_Scene", 42);
      }
      if (com.tencent.mm.contact.c.lO(paramString.field_type))
      {
        localObject2 = new tl();
        ((tl)localObject2).dIV.intent = ((Intent)localObject1);
        ((tl)localObject2).dIV.username = paramString.field_username;
        com.tencent.mm.sdk.b.a.IvT.l((b)localObject2);
      }
      com.tencent.mm.plugin.webview.a.a.iUz.c((Intent)localObject1, paramContext);
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
        au.a.hIG.Bt(this.fOj);
        parama.f("cancel", null);
        AppMethodBeat.o(78601);
      }
    });
    au.a.hIG.a((String)localObject2, "", new au.b.a()
    {
      public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(78603);
        if (paramContext == null)
        {
          ae.w("MicroMsg.JsApiProfile", "getNow callback, msghandler has already been detached!");
          parama.f("fail", null);
          AppMethodBeat.o(78603);
          return;
        }
        if (paramString != null) {
          paramString.dismiss();
        }
        an localan2 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(paramAnonymousString);
        an localan1;
        if (localan2 != null)
        {
          localan1 = localan2;
          if ((int)localan2.ght > 0) {}
        }
        else
        {
          localan1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().aUI(paramAnonymousString);
        }
        if ((localan1 == null) || ((int)localan1.ght <= 0)) {
          paramAnonymousBoolean = false;
        }
        while (!paramAnonymousBoolean)
        {
          com.tencent.mm.ipcinvoker.p.x(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(78602);
              Toast.makeText(ak.getContext(), at.3.this.val$context.getString(2131759562, new Object[] { Integer.valueOf(3), Integer.valueOf(-1) }), 0).show();
              AppMethodBeat.o(78602);
            }
          });
          parama.f("fail", null);
          AppMethodBeat.o(78603);
          return;
          paramAnonymousString = localan1.field_username;
        }
        com.tencent.mm.aj.c.al(paramAnonymousString, 3);
        com.tencent.mm.aj.p.aEP().Dw(paramAnonymousString);
        this.val$intent.addFlags(268435456);
        this.val$intent.putExtra("Contact_User", paramAnonymousString);
        if (localan1.fug())
        {
          com.tencent.mm.plugin.report.service.g.yxI.kvStat(10298, localan1.field_username + ",42");
          this.val$intent.putExtra("Contact_Scene", 42);
        }
        com.tencent.mm.plugin.webview.a.a.iUz.c(this.val$intent, paramContext);
        parama.f(null, null);
        AppMethodBeat.o(78603);
      }
    });
    AppMethodBeat.o(78604);
  }
  
  public final void b(b.a parama) {}
  
  public final int ced()
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