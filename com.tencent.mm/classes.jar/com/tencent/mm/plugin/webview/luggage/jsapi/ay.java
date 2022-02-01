package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.xc;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.ipcinvoker.s;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.modelavatar.e;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.webview.a.a;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.k;
import org.json.JSONException;
import org.json.JSONObject;

public class ay
  extends bw
{
  public final void a(final Context paramContext, final String paramString, final bv.a parama)
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
        parama.j("fail", null);
        AppMethodBeat.o(78604);
        return;
      }
    }
    catch (JSONException paramContext)
    {
      Log.e("MicroMsg.JsApiProfile", "parase json fail");
      parama.j("fail", null);
      AppMethodBeat.o(78604);
      return;
    }
    if (Util.isNullOrNil((String)localObject2))
    {
      s.D(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(78600);
          Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(c.i.fmt_self_qrcode_getting_err, new Object[] { Integer.valueOf(3), Integer.valueOf(-1) }), 0).show();
          AppMethodBeat.o(78600);
        }
      });
      parama.j("fail", null);
      AppMethodBeat.o(78604);
      return;
    }
    com.tencent.mm.kernel.h.baC();
    if (!b.aZM())
    {
      Log.e("MicroMsg.JsApiProfile", "doProfile, MMCore.hasCfgDefaultUin() is false");
      parama.j("fail", null);
      AppMethodBeat.o(78604);
      return;
    }
    Object localObject1 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE((String)localObject2);
    if (localObject1 != null)
    {
      paramString = (String)localObject1;
      if ((int)((com.tencent.mm.contact.d)localObject1).maN > 0) {}
    }
    else
    {
      paramString = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxs((String)localObject2);
    }
    localObject1 = new Intent();
    Object localObject3 = ((JSONObject)localObject3).optString("profileReportInfo");
    if (!Util.isNullOrNil((String)localObject3)) {
      ((Intent)localObject1).putExtra("key_add_contact_report_info", (String)localObject3);
    }
    if ((paramString != null) && ((int)paramString.maN > 0))
    {
      ((Intent)localObject1).addFlags(268435456);
      ((Intent)localObject1).putExtra("Contact_User", paramString.field_username);
      if (paramString.iZC()) {
        ((Intent)localObject1).putExtra("Contact_Scene", 42);
      }
      if (com.tencent.mm.contact.d.rs(paramString.field_type))
      {
        localObject2 = new xc();
        ((xc)localObject2).iaC.intent = ((Intent)localObject1);
        ((xc)localObject2).iaC.username = paramString.field_username;
        ((xc)localObject2).publish();
      }
      a.pFn.c((Intent)localObject1, paramContext);
      parama.j(null, null);
      AppMethodBeat.o(78604);
      return;
    }
    paramContext.getString(c.i.app_tip);
    paramString = k.a(paramContext, paramContext.getString(c.i.app_waiting), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(78601);
        az.a.okP.Jq(this.lzC);
        parama.j("cancel", null);
        AppMethodBeat.o(78601);
      }
    });
    az.a.okP.a((String)localObject2, "", new az.b.a()
    {
      public final void getContactCallBack(String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(78603);
        if (paramContext == null)
        {
          Log.w("MicroMsg.JsApiProfile", "getNow callback, msghandler has already been detached!");
          parama.j("fail", null);
          AppMethodBeat.o(78603);
          return;
        }
        if (paramString != null) {
          paramString.dismiss();
        }
        au localau2 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramAnonymousString);
        au localau1;
        if (localau2 != null)
        {
          localau1 = localau2;
          if ((int)localau2.maN > 0) {}
        }
        else
        {
          localau1 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxs(paramAnonymousString);
        }
        if ((localau1 == null) || ((int)localau1.maN <= 0)) {
          paramAnonymousBoolean = false;
        }
        while (!paramAnonymousBoolean)
        {
          s.D(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(78602);
              Toast.makeText(MMApplicationContext.getContext(), ay.3.this.val$context.getString(c.i.fmt_self_qrcode_getting_err, new Object[] { Integer.valueOf(3), Integer.valueOf(-1) }), 0).show();
              AppMethodBeat.o(78602);
            }
          });
          parama.j("fail", null);
          AppMethodBeat.o(78603);
          return;
          paramAnonymousString = localau1.field_username;
        }
        com.tencent.mm.modelavatar.d.aS(paramAnonymousString, 3);
        q.bFG().LB(paramAnonymousString);
        this.val$intent.addFlags(268435456);
        this.val$intent.putExtra("Contact_User", paramAnonymousString);
        if (localau1.iZC())
        {
          com.tencent.mm.plugin.report.service.h.OAn.kvStat(10298, localau1.field_username + ",42");
          this.val$intent.putExtra("Contact_Scene", 42);
        }
        a.pFn.c(this.val$intent, paramContext);
        parama.j(null, null);
        AppMethodBeat.o(78603);
      }
    });
    AppMethodBeat.o(78604);
  }
  
  public final void b(b.a parama) {}
  
  public final int dgI()
  {
    return 2;
  }
  
  public final String name()
  {
    return "profile";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ay
 * JD-Core Version:    0.7.0.1
 */