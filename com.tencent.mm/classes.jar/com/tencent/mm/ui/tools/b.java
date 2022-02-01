package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.f;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.fj;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bl.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.s;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.lang.ref.WeakReference;

public final class b
{
  private static boolean isDeleteCancel = false;
  
  public static void a(com.tencent.mm.api.c paramc, Activity paramActivity, an paraman, int paramInt)
  {
    AppMethodBeat.i(38982);
    a(paramc, paramActivity, paraman, false, null, paramInt);
    AppMethodBeat.o(38982);
  }
  
  public static void a(com.tencent.mm.api.c paramc, Activity paramActivity, an paraman, boolean paramBoolean, int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(38985);
    if ((paramc == null) || (paramActivity == null) || (paraman == null))
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
        if (paraman != null) {
          break label88;
        }
      }
      for (;;)
      {
        ae.e("MicroMsg.BizContactDeleteUtil", "error args, %b, %b, %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
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
    final String str = paraman.field_username;
    paraman.acT();
    bc.aCg();
    com.tencent.mm.model.c.azE().d(new com.tencent.mm.ba.d(str, paramInt));
    if (com.tencent.mm.model.x.Al(str))
    {
      ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().aUS(str);
      bc.aCg();
      com.tencent.mm.model.c.azP().BD(str);
      if (com.tencent.mm.app.plugin.a.a.c(paramc))
      {
        paramc = new fj();
        paramc.drA.dpI = str;
        com.tencent.mm.sdk.b.a.IvT.l(paramc);
      }
      ag.aGo().EA(str);
      ag.aGv().aqS(str);
      ag.aGw().aqS(str);
      if (paramBoolean)
      {
        paramInt = paramActivity.getIntent().getIntExtra("Kdel_from", -1);
        if (paramInt != 0) {
          break label484;
        }
        paramc = new Intent(paramActivity, LauncherUI.class);
        paramc.addFlags(67108864);
        paramc = new com.tencent.mm.hellhoundlib.b.a().bc(paramc);
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramc.ahE(), "com/tencent/mm/ui/tools/BizContactDeleteUtil", "dealDelContactEvent", "(Lcom/tencent/mm/api/BizInfo;Landroid/app/Activity;Lcom/tencent/mm/storage/Contact;ZI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramActivity.startActivity((Intent)paramc.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/ui/tools/BizContactDeleteUtil", "dealDelContactEvent", "(Lcom/tencent/mm/api/BizInfo;Landroid/app/Activity;Lcom/tencent/mm/storage/Contact;ZI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    for (;;)
    {
      paramActivity.finish();
      AppMethodBeat.o(38985);
      return;
      isDeleteCancel = false;
      paramActivity.getString(2131755906);
      bl.a local3 = new bl.a()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(38979);
          b.JG();
          AppMethodBeat.o(38979);
        }
      }
      {
        public final boolean YT()
        {
          AppMethodBeat.i(38980);
          boolean bool = b.isDeleteCancel;
          AppMethodBeat.o(38980);
          return bool;
        }
        
        public final void YU()
        {
          AppMethodBeat.i(38981);
          if (this.Lan.Kt())
          {
            com.tencent.mm.kernel.g.ab(q.class);
            s.aTT(str);
            com.tencent.mm.g.a.al localal = new com.tencent.mm.g.a.al();
            localal.dmb.userName = str;
            com.tencent.mm.sdk.b.a.IvT.l(localal);
          }
          ag.aGp().delete(str);
          if (this.Lar.get() != null) {
            ((p)this.Lar.get()).dismiss();
          }
          AppMethodBeat.o(38981);
        }
      };
      ag.aGB();
      com.tencent.mm.al.a.DX(str);
      ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().c(str, paraman);
      if (paramc.Kv()) {
        com.tencent.mm.al.g.Ev(paramc.field_username);
      }
      for (;;)
      {
        if ((paramActivity == null) || (!paramBoolean)) {
          break label482;
        }
        paramActivity.setResult(-1, paramActivity.getIntent().putExtra("_delete_ok_", true));
        break;
        bl.a(str, local3);
        bc.aCg();
        com.tencent.mm.model.c.azL().aUY(str);
      }
      label482:
      break;
      label484:
      if (paramInt == 2)
      {
        paramc = new Intent();
        paramc.addFlags(67108864);
        com.tencent.mm.br.d.b(paramActivity, "brandservice", ".ui.BrandServiceIndexUI", paramc);
      }
    }
  }
  
  public static void a(com.tencent.mm.api.c paramc, final Activity paramActivity, final an paraman, final boolean paramBoolean, final Runnable paramRunnable, final int paramInt)
  {
    AppMethodBeat.i(38983);
    if ((paramc == null) || (paramActivity == null) || (paraman == null))
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
        if (paraman != null) {
          break label91;
        }
      }
      label85:
      label91:
      for (boolean bool2 = true;; bool2 = false)
      {
        ae.e("MicroMsg.BizContactDeleteUtil", "bizInfo null : %s, context null : %s, ct null : %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        AppMethodBeat.o(38983);
        return;
        paramBoolean = false;
        break;
        bool1 = false;
        break label31;
      }
    }
    if (paramc.Kw()) {}
    for (String str = paramActivity.getString(2131756739);; str = paramActivity.getString(2131756740, new Object[] { paraman.adG() }))
    {
      h.a(paramActivity, str, "", paramActivity.getString(2131757797), paramActivity.getString(2131757796), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(38978);
          b.a(this.Lan, paramActivity, paraman, paramBoolean, paramInt);
          if (paramRunnable != null) {
            paramRunnable.run();
          }
          AppMethodBeat.o(38978);
        }
      }, null, 2131100798);
      AppMethodBeat.o(38983);
      return;
    }
  }
  
  public static void c(com.tencent.mm.api.c paramc, Activity paramActivity, an paraman)
  {
    AppMethodBeat.i(38984);
    a(paramc, paramActivity, paraman, false, 0);
    AppMethodBeat.o(38984);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.b
 * JD-Core Version:    0.7.0.1
 */