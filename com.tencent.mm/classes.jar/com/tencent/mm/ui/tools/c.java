package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.ao.af;
import com.tencent.mm.ao.f;
import com.tencent.mm.ao.g;
import com.tencent.mm.bd.d;
import com.tencent.mm.f.a.ao;
import com.tencent.mm.f.a.ft;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bq.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.s;
import java.lang.ref.WeakReference;

public final class c
{
  private static boolean isDeleteCancel = false;
  
  public static void a(com.tencent.mm.api.c paramc, Activity paramActivity, as paramas, int paramInt)
  {
    AppMethodBeat.i(38982);
    a(paramc, paramActivity, paramas, false, null, paramInt);
    AppMethodBeat.o(38982);
  }
  
  public static void a(com.tencent.mm.api.c paramc, Activity paramActivity, as paramas, boolean paramBoolean, int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(38985);
    if ((paramc == null) || (paramActivity == null) || (paramas == null))
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
        if (paramas != null) {
          break label88;
        }
      }
      for (;;)
      {
        Log.e("MicroMsg.BizContactDeleteUtil", "error args, %b, %b, %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        AppMethodBeat.o(38985);
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
    final String str = paramas.field_username;
    paramas.axl();
    bh.beI();
    com.tencent.mm.model.c.bbK().d(new d(str, paramInt));
    if (ab.Qj(str))
    {
      ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().bwp(str);
      bh.beI();
      com.tencent.mm.model.c.bbV().RC(str);
      if (com.tencent.mm.app.plugin.a.a.d(paramc))
      {
        paramc = new ft();
        paramc.fBD.fzM = str;
        EventCenter.instance.publish(paramc);
      }
      af.bju().UK(str);
      af.bjB().aOx(str);
      af.bjD().aOx(str);
      if (paramBoolean)
      {
        paramInt = paramActivity.getIntent().getIntExtra("Kdel_from", -1);
        if (paramInt != 0) {
          break label486;
        }
        paramc = new Intent(paramActivity, LauncherUI.class);
        paramc.addFlags(335544320);
        paramc = new com.tencent.mm.hellhoundlib.b.a().bm(paramc);
        com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramc.aFh(), "com/tencent/mm/ui/tools/BizContactDeleteUtil", "dealDelContactEvent", "(Lcom/tencent/mm/api/BizInfo;Landroid/app/Activity;Lcom/tencent/mm/storage/Contact;ZI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramActivity.startActivity((Intent)paramc.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/ui/tools/BizContactDeleteUtil", "dealDelContactEvent", "(Lcom/tencent/mm/api/BizInfo;Landroid/app/Activity;Lcom/tencent/mm/storage/Contact;ZI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    for (;;)
    {
      paramActivity.finish();
      AppMethodBeat.o(38985);
      return;
      isDeleteCancel = false;
      paramActivity.getString(R.l.app_tip);
      bq.a local3 = new bq.a()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(38979);
          c.Yy();
          AppMethodBeat.o(38979);
        }
      }
      {
        public final boolean asH()
        {
          AppMethodBeat.i(38980);
          boolean bool = c.isDeleteCancel;
          AppMethodBeat.o(38980);
          return bool;
        }
        
        public final void asI()
        {
          AppMethodBeat.i(38981);
          if (this.XNB.YV())
          {
            ((com.tencent.mm.ao.q)com.tencent.mm.kernel.h.ae(com.tencent.mm.ao.q.class)).bbQ();
            u.bvj(str);
            ao localao = new ao();
            localao.fvX.userName = str;
            EventCenter.instance.publish(localao);
          }
          af.bjv().Up(str);
          if (this.XNF.get() != null) {
            ((s)this.XNF.get()).dismiss();
          }
          AppMethodBeat.o(38981);
        }
      };
      af.bjI();
      com.tencent.mm.ao.a.Ug(str);
      ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().c(str, paramas);
      if (paramc.YX()) {
        g.UF(paramc.field_username);
      }
      for (;;)
      {
        if ((paramActivity == null) || (!paramBoolean)) {
          break label484;
        }
        paramActivity.setResult(-1, paramActivity.getIntent().putExtra("_delete_ok_", true));
        break;
        bq.a(str, local3);
        bh.beI();
        com.tencent.mm.model.c.bbR().bwv(str);
      }
      label484:
      break;
      label486:
      if (paramInt == 2)
      {
        paramc = new Intent();
        paramc.addFlags(67108864);
        com.tencent.mm.by.c.b(paramActivity, "brandservice", ".ui.BrandServiceIndexUI", paramc);
      }
    }
  }
  
  public static void a(com.tencent.mm.api.c paramc, final Activity paramActivity, final as paramas, final boolean paramBoolean, final Runnable paramRunnable, final int paramInt)
  {
    AppMethodBeat.i(38983);
    if ((paramc == null) || (paramActivity == null) || (paramas == null))
    {
      boolean bool1;
      if (paramc == null)
      {
        paramBoolean = true;
        if (paramActivity != null) {
          break label85;
        }
        bool1 = true;
        label31:
        if (paramas != null) {
          break label91;
        }
      }
      label85:
      label91:
      for (boolean bool2 = true;; bool2 = false)
      {
        Log.e("MicroMsg.BizContactDeleteUtil", "bizInfo null : %s, context null : %s, ct null : %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        AppMethodBeat.o(38983);
        return;
        paramBoolean = false;
        break;
        bool1 = false;
        break label31;
      }
    }
    if (paramc.YY()) {}
    for (String str = paramActivity.getString(R.l.etw);; str = paramActivity.getString(R.l.etx, new Object[] { paramas.ays() }))
    {
      com.tencent.mm.ui.base.h.a(paramActivity, str, "", paramActivity.getString(R.l.ezb), paramActivity.getString(R.l.eza), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(38978);
          c.a(this.XNB, paramActivity, paramas, paramBoolean, paramInt);
          ((com.tencent.mm.api.q)com.tencent.mm.kernel.h.ae(com.tencent.mm.api.q.class)).c(this.XNB);
          if (paramRunnable != null) {
            paramRunnable.run();
          }
          if (ar.hIH())
          {
            paramAnonymousDialogInterface = new Intent();
            com.tencent.mm.by.c.f(paramActivity, ".ui.EmptyActivity", paramAnonymousDialogInterface);
            Log.i("MicroMsg.BizContactDeleteUtil", "start empty activity");
          }
          AppMethodBeat.o(38978);
        }
      }, null, R.e.red);
      AppMethodBeat.o(38983);
      return;
    }
  }
  
  public static void c(com.tencent.mm.api.c paramc, Activity paramActivity, as paramas)
  {
    AppMethodBeat.i(38984);
    a(paramc, paramActivity, paramas, false, 0);
    AppMethodBeat.o(38984);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.c
 * JD-Core Version:    0.7.0.1
 */