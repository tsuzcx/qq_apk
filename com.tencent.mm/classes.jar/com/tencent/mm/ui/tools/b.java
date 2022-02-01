package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.e;
import com.tencent.mm.am.f;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.ak;
import com.tencent.mm.g.a.fe;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bi.a;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.v;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.h;
import java.lang.ref.WeakReference;

public final class b
{
  private static boolean isDeleteCancel = false;
  
  public static void a(com.tencent.mm.api.c paramc, Activity paramActivity, com.tencent.mm.storage.af paramaf, int paramInt)
  {
    AppMethodBeat.i(38982);
    a(paramc, paramActivity, paramaf, false, null, paramInt);
    AppMethodBeat.o(38982);
  }
  
  public static void a(com.tencent.mm.api.c paramc, Activity paramActivity, com.tencent.mm.storage.af paramaf, boolean paramBoolean, int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(38985);
    if ((paramc == null) || (paramActivity == null) || (paramaf == null))
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
        if (paramaf != null) {
          break label88;
        }
      }
      for (;;)
      {
        ad.e("MicroMsg.BizContactDeleteUtil", "error args, %b, %b, %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
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
    final String str = paramaf.field_username;
    paramaf.Zl();
    az.arV();
    com.tencent.mm.model.c.apL().c(new com.tencent.mm.bb.c(str, paramInt));
    if (w.sB(str))
    {
      ((k)g.ab(k.class)).apM().aIf(str);
      az.arV();
      com.tencent.mm.model.c.apV().tN(str);
      if (com.tencent.mm.app.plugin.a.a.c(paramc))
      {
        paramc = new fe();
        paramc.dhE.dfM = str;
        com.tencent.mm.sdk.b.a.ESL.l(paramc);
      }
      com.tencent.mm.am.af.awd().wT(str);
      com.tencent.mm.am.af.awk().agh(str);
      com.tencent.mm.am.af.awl().agh(str);
      if (paramBoolean)
      {
        paramInt = paramActivity.getIntent().getIntExtra("Kdel_from", -1);
        if (paramInt != 0) {
          break label484;
        }
        paramc = new Intent(paramActivity, LauncherUI.class);
        paramc.addFlags(67108864);
        paramc = new com.tencent.mm.hellhoundlib.b.a().bd(paramc);
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramc.adn(), "com/tencent/mm/ui/tools/BizContactDeleteUtil", "dealDelContactEvent", "(Lcom/tencent/mm/api/BizInfo;Landroid/app/Activity;Lcom/tencent/mm/storage/Contact;ZI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramActivity.startActivity((Intent)paramc.lS(0));
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
      bi.a local3 = new bi.a()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(38979);
          b.acT();
          AppMethodBeat.o(38979);
        }
      }
      {
        public final boolean Vt()
        {
          AppMethodBeat.i(38980);
          boolean bool = b.isDeleteCancel;
          AppMethodBeat.o(38980);
          return bool;
        }
        
        public final void Vu()
        {
          AppMethodBeat.i(38981);
          if (this.Hmr.Jc())
          {
            g.ab(com.tencent.mm.am.p.class);
            q.aHq(str);
            ak localak = new ak();
            localak.dci.userName = str;
            com.tencent.mm.sdk.b.a.ESL.l(localak);
          }
          com.tencent.mm.am.af.awe().delete(str);
          if (this.Hmv.get() != null) {
            ((com.tencent.mm.ui.base.p)this.Hmv.get()).dismiss();
          }
          AppMethodBeat.o(38981);
        }
      };
      com.tencent.mm.am.af.awq();
      com.tencent.mm.am.a.wq(str);
      ((k)g.ab(k.class)).apM().c(str, paramaf);
      if (paramc.Je()) {
        f.wO(paramc.field_username);
      }
      for (;;)
      {
        if ((paramActivity == null) || (!paramBoolean)) {
          break label482;
        }
        paramActivity.setResult(-1, paramActivity.getIntent().putExtra("_delete_ok_", true));
        break;
        bi.a(str, local3);
        az.arV();
        com.tencent.mm.model.c.apR().aIl(str);
      }
      label482:
      break;
      label484:
      if (paramInt == 2)
      {
        paramc = new Intent();
        paramc.addFlags(67108864);
        d.b(paramActivity, "brandservice", ".ui.BrandServiceIndexUI", paramc);
      }
    }
  }
  
  public static void a(com.tencent.mm.api.c paramc, final Activity paramActivity, final com.tencent.mm.storage.af paramaf, final boolean paramBoolean, final Runnable paramRunnable, final int paramInt)
  {
    AppMethodBeat.i(38983);
    if ((paramc == null) || (paramActivity == null) || (paramaf == null))
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
        if (paramaf != null) {
          break label91;
        }
      }
      label85:
      label91:
      for (boolean bool2 = true;; bool2 = false)
      {
        ad.e("MicroMsg.BizContactDeleteUtil", "bizInfo null : %s, context null : %s, ct null : %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        AppMethodBeat.o(38983);
        return;
        paramBoolean = false;
        break;
        bool1 = false;
        break label31;
      }
    }
    if (paramc.Jf()) {}
    for (String str = paramActivity.getString(2131756739);; str = paramActivity.getString(2131756740, new Object[] { paramaf.ZX() }))
    {
      h.a(paramActivity, str, "", paramActivity.getString(2131757797), paramActivity.getString(2131757796), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(38978);
          b.a(this.Hmr, paramActivity, paramaf, paramBoolean, paramInt);
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
  
  public static void c(com.tencent.mm.api.c paramc, Activity paramActivity, com.tencent.mm.storage.af paramaf)
  {
    AppMethodBeat.i(38984);
    a(paramc, paramActivity, paramaf, false, 0);
    AppMethodBeat.o(38984);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.tools.b
 * JD-Core Version:    0.7.0.1
 */