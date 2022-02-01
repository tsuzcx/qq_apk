package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.an.af;
import com.tencent.mm.an.f;
import com.tencent.mm.an.g;
import com.tencent.mm.an.j;
import com.tencent.mm.an.q;
import com.tencent.mm.api.r;
import com.tencent.mm.app.plugin.exdevice.ChattingUIExDeviceLogic;
import com.tencent.mm.autogen.a.as;
import com.tencent.mm.autogen.a.ge;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.br.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.i.a.a;
import com.tencent.mm.protocal.protobuf.dzc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ag;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import java.lang.ref.WeakReference;

public final class c
{
  private static WeakReference<w> afDP;
  private static boolean isDeleteCancel = false;
  
  public static void a(com.tencent.mm.api.c paramc, Activity paramActivity, au paramau, int paramInt)
  {
    AppMethodBeat.i(38982);
    a(paramc, paramActivity, paramau, false, null, paramInt);
    AppMethodBeat.o(38982);
  }
  
  public static void a(final com.tencent.mm.api.c paramc, final Activity paramActivity, au paramau, final boolean paramBoolean)
  {
    boolean bool2 = true;
    AppMethodBeat.i(251047);
    if ((paramc == null) || (paramActivity == null) || (paramau == null))
    {
      boolean bool1;
      if (paramc == null)
      {
        paramBoolean = true;
        if (paramActivity != null) {
          break label82;
        }
        bool1 = true;
        label33:
        if (paramau != null) {
          break label88;
        }
      }
      for (;;)
      {
        Log.e("MicroMsg.BizContactDeleteUtil", "error args, %b, %b, %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        AppMethodBeat.o(251047);
        return;
        paramBoolean = false;
        break;
        label82:
        bool1 = false;
        break label33;
        label88:
        bool2 = false;
      }
    }
    isDeleteCancel = false;
    paramActivity.getString(R.l.app_tip);
    afDP = new WeakReference(k.a(paramActivity, paramActivity.getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(38979);
        c.aAs();
        AppMethodBeat.o(38979);
      }
    }));
    paramActivity = new WeakReference(paramActivity);
    String str = paramau.field_username;
    paramau.aRL();
    ((com.tencent.mm.pluginsdk.i.a)h.ax(com.tencent.mm.pluginsdk.i.a.class)).XN(str);
    ((com.tencent.mm.pluginsdk.i.a)h.ax(com.tencent.mm.pluginsdk.i.a.class)).a(new a.a()
    {
      public final void onDeleteContact(String paramAnonymousString, int paramAnonymousInt, dzc paramAnonymousdzc)
      {
        AppMethodBeat.i(251134);
        if (!paramAnonymousString.equals(c.this.field_username))
        {
          Log.w("MicroMsg.BizContactDeleteUtil", "not current contact %s,%s", new Object[] { c.this.field_username, paramAnonymousString });
          AppMethodBeat.o(251134);
          return;
        }
        Log.i("MicroMsg.BizContactDeleteUtil", "dealDelContactEvent callBack %s, ret=%d", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt) });
        ((com.tencent.mm.pluginsdk.i.a)h.ax(com.tencent.mm.pluginsdk.i.a.class)).b(this);
        c.access$100();
        if (paramAnonymousInt == 0)
        {
          c.b(paramc, (Activity)paramActivity.get(), c.this, paramBoolean);
          AppMethodBeat.o(251134);
          return;
        }
        if (!Util.isNullOrNil(paramAnonymousdzc.nUB))
        {
          k.c((Context)paramActivity.get(), paramAnonymousdzc.nUB, paramAnonymousdzc.hAP, true);
          AppMethodBeat.o(251134);
          return;
        }
        k.c((Context)paramActivity.get(), MMApplicationContext.getContext().getString(R.l.app_delete_failed), "", true);
        AppMethodBeat.o(251134);
      }
    });
    AppMethodBeat.o(251047);
  }
  
  public static void a(com.tencent.mm.api.c paramc, final Activity paramActivity, final au paramau, final boolean paramBoolean, final Runnable paramRunnable, final int paramInt)
  {
    AppMethodBeat.i(38983);
    if ((paramc == null) || (paramActivity == null) || (paramau == null))
    {
      boolean bool1;
      if (paramc == null)
      {
        paramBoolean = true;
        if (paramActivity != null) {
          break label82;
        }
        bool1 = true;
        label30:
        if (paramau != null) {
          break label88;
        }
      }
      label82:
      label88:
      for (boolean bool2 = true;; bool2 = false)
      {
        Log.e("MicroMsg.BizContactDeleteUtil", "bizInfo null : %s, context null : %s, ct null : %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        AppMethodBeat.o(38983);
        return;
        paramBoolean = false;
        break;
        bool1 = false;
        break label30;
      }
    }
    if (paramc.aAQ()) {}
    for (String str = paramActivity.getString(R.l.brandservice_remove_enterprise_tips);; str = paramActivity.getString(R.l.brandservice_remove_subscribe_tips, new Object[] { paramau.aSV() }))
    {
      k.a(paramActivity, str, "", paramActivity.getString(R.l.contact_info_remove_biz_alert_sure), paramActivity.getString(R.l.contact_info_remove_biz_alert_cancel), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(38978);
          c.a(c.this, paramActivity, paramau, paramBoolean);
          ((r)h.ax(r.class)).c(c.this);
          if (paramRunnable != null) {
            paramRunnable.run();
          }
          if (aw.jkS())
          {
            paramAnonymousDialogInterface = new Intent();
            com.tencent.mm.br.c.g(paramActivity, ".ui.EmptyActivity", paramAnonymousDialogInterface);
            Log.i("MicroMsg.BizContactDeleteUtil", "start empty activity");
          }
          AppMethodBeat.o(38978);
        }
      }, null, R.e.red);
      AppMethodBeat.o(38983);
      return;
    }
  }
  
  public static void b(com.tencent.mm.api.c paramc, Activity paramActivity, au paramau, boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(251051);
    if ((paramc == null) || (paramau == null))
    {
      if (paramc == null) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        if (paramau == null) {
          bool = true;
        }
        Log.e("MicroMsg.BizContactDeleteUtil", "error args, %b, %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
        AppMethodBeat.o(251051);
        return;
      }
    }
    final String str = paramau.field_username;
    int i;
    if (ab.IQ(str))
    {
      ((n)h.ax(n.class)).bzA().bxC(str);
      bh.bCz();
      com.tencent.mm.model.c.bzK().JA(str);
      if (ChattingUIExDeviceLogic.d(paramc))
      {
        paramc = new ge();
        paramc.hGs.hEy = str;
        paramc.publish();
      }
      af.bHe().MJ(str);
      af.bHl().aLw(str);
      af.bHo().aLw(str);
      if ((h.ax(r.class) != null) && (h.ax(com.tencent.mm.plugin.brandservice.api.c.class) != null) && (((r)h.ax(r.class)).aBu())) {
        ((com.tencent.mm.plugin.brandservice.api.c)h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).dby();
      }
      if ((paramBoolean) && (paramActivity != null))
      {
        i = paramActivity.getIntent().getIntExtra("Kdel_from", -1);
        if (i != 0) {
          break label465;
        }
        paramc = new Intent(paramActivity, LauncherUI.class);
        paramc.addFlags(335544320);
        paramc = new com.tencent.mm.hellhoundlib.b.a().cG(paramc);
        com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramc.aYi(), "com/tencent/mm/ui/tools/BizContactDeleteUtil", "dealDelContact", "(Lcom/tencent/mm/api/BizInfo;Landroid/app/Activity;Lcom/tencent/mm/storage/Contact;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramActivity.startActivity((Intent)paramc.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/ui/tools/BizContactDeleteUtil", "dealDelContact", "(Lcom/tencent/mm/api/BizInfo;Landroid/app/Activity;Lcom/tencent/mm/storage/Contact;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    for (;;)
    {
      paramActivity.finish();
      AppMethodBeat.o(251051);
      return;
      br.a local4 = new br.a()
      {
        public final boolean aMJ()
        {
          AppMethodBeat.i(251129);
          boolean bool = c.isDeleteCancel;
          AppMethodBeat.o(251129);
          return bool;
        }
        
        public final void aMK()
        {
          AppMethodBeat.i(251133);
          if (c.this.aAN())
          {
            ((q)h.ax(q.class)).bzF();
            u.bvr(str);
            as localas = new as();
            localas.hAu.userName = str;
            localas.publish();
          }
          af.bHf().Mo(str);
          ((n)h.ax(n.class)).bzA().bxC(str);
          AppMethodBeat.o(251133);
        }
      };
      af.bHt();
      com.tencent.mm.an.a.Mf(str);
      ((n)h.ax(n.class)).bzA().d(str, paramau);
      if (paramc.aAP()) {
        g.ME(paramc.field_username);
      }
      for (;;)
      {
        if ((paramActivity == null) || (!paramBoolean)) {
          break label463;
        }
        paramActivity.setResult(-1, paramActivity.getIntent().putExtra("_delete_ok_", true));
        break;
        br.a(str, local4);
        com.tencent.mm.modelsimple.ac.aY(str, 15);
        bh.bCz();
        com.tencent.mm.model.c.bzG().bxK(str);
      }
      label463:
      break;
      label465:
      if (i == 2)
      {
        paramc = new Intent();
        paramc.addFlags(67108864);
        com.tencent.mm.br.c.b(paramActivity, "brandservice", ".ui.BrandServiceIndexUI", paramc);
      }
    }
  }
  
  public static void c(com.tencent.mm.api.c paramc, Activity paramActivity, au paramau)
  {
    AppMethodBeat.i(38984);
    a(paramc, paramActivity, paramau, false);
    AppMethodBeat.o(38984);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.c
 * JD-Core Version:    0.7.0.1
 */