package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.af;
import com.tencent.mm.al.e;
import com.tencent.mm.al.f;
import com.tencent.mm.g.a.al;
import com.tencent.mm.g.a.ff;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bi.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.h;
import java.lang.ref.WeakReference;

public final class b
{
  private static boolean isDeleteCancel = false;
  
  public static void a(com.tencent.mm.api.c paramc, Activity paramActivity, ai paramai, int paramInt)
  {
    AppMethodBeat.i(38982);
    a(paramc, paramActivity, paramai, false, null, paramInt);
    AppMethodBeat.o(38982);
  }
  
  public static void a(com.tencent.mm.api.c paramc, Activity paramActivity, ai paramai, boolean paramBoolean, int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(38985);
    if ((paramc == null) || (paramActivity == null) || (paramai == null))
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
        if (paramai != null) {
          break label88;
        }
      }
      for (;;)
      {
        ac.e("MicroMsg.BizContactDeleteUtil", "error args, %b, %b, %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
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
    final String str = paramai.field_username;
    paramai.aag();
    az.ayM();
    com.tencent.mm.model.c.awA().c(new com.tencent.mm.ba.d(str, paramInt));
    if (com.tencent.mm.model.w.wE(str))
    {
      ((k)g.ab(k.class)).awB().aNA(str);
      az.ayM();
      com.tencent.mm.model.c.awK().xT(str);
      if (com.tencent.mm.app.plugin.a.a.c(paramc))
      {
        paramc = new ff();
        paramc.deZ.ddh = str;
        com.tencent.mm.sdk.b.a.GpY.l(paramc);
      }
      af.aCV().AZ(str);
      af.aDc().alb(str);
      af.aDd().alb(str);
      if (paramBoolean)
      {
        paramInt = paramActivity.getIntent().getIntExtra("Kdel_from", -1);
        if (paramInt != 0) {
          break label484;
        }
        paramc = new Intent(paramActivity, LauncherUI.class);
        paramc.addFlags(67108864);
        paramc = new com.tencent.mm.hellhoundlib.b.a().ba(paramc);
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramc.aeD(), "com/tencent/mm/ui/tools/BizContactDeleteUtil", "dealDelContactEvent", "(Lcom/tencent/mm/api/BizInfo;Landroid/app/Activity;Lcom/tencent/mm/storage/Contact;ZI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramActivity.startActivity((Intent)paramc.lR(0));
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
          b.adZ();
          AppMethodBeat.o(38979);
        }
      }
      {
        public final boolean Wr()
        {
          AppMethodBeat.i(38980);
          boolean bool = b.isDeleteCancel;
          AppMethodBeat.o(38980);
          return bool;
        }
        
        public final void Ws()
        {
          AppMethodBeat.i(38981);
          if (this.IMM.IL())
          {
            g.ab(com.tencent.mm.al.p.class);
            q.aMK(str);
            al localal = new al();
            localal.cZH.userName = str;
            com.tencent.mm.sdk.b.a.GpY.l(localal);
          }
          af.aCW().delete(str);
          if (this.IMQ.get() != null) {
            ((com.tencent.mm.ui.base.p)this.IMQ.get()).dismiss();
          }
          AppMethodBeat.o(38981);
        }
      };
      af.aDi();
      com.tencent.mm.al.a.Aw(str);
      ((k)g.ab(k.class)).awB().c(str, paramai);
      if (paramc.IN()) {
        f.AU(paramc.field_username);
      }
      for (;;)
      {
        if ((paramActivity == null) || (!paramBoolean)) {
          break label482;
        }
        paramActivity.setResult(-1, paramActivity.getIntent().putExtra("_delete_ok_", true));
        break;
        bi.a(str, local3);
        az.ayM();
        com.tencent.mm.model.c.awG().aNG(str);
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
  
  public static void a(com.tencent.mm.api.c paramc, final Activity paramActivity, final ai paramai, final boolean paramBoolean, final Runnable paramRunnable, final int paramInt)
  {
    AppMethodBeat.i(38983);
    if ((paramc == null) || (paramActivity == null) || (paramai == null))
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
        if (paramai != null) {
          break label91;
        }
      }
      label85:
      label91:
      for (boolean bool2 = true;; bool2 = false)
      {
        ac.e("MicroMsg.BizContactDeleteUtil", "bizInfo null : %s, context null : %s, ct null : %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        AppMethodBeat.o(38983);
        return;
        paramBoolean = false;
        break;
        bool1 = false;
        break label31;
      }
    }
    if (paramc.IO()) {}
    for (String str = paramActivity.getString(2131756739);; str = paramActivity.getString(2131756740, new Object[] { paramai.aaS() }))
    {
      h.a(paramActivity, str, "", paramActivity.getString(2131757797), paramActivity.getString(2131757796), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(38978);
          b.a(this.IMM, paramActivity, paramai, paramBoolean, paramInt);
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
  
  public static void c(com.tencent.mm.api.c paramc, Activity paramActivity, ai paramai)
  {
    AppMethodBeat.i(38984);
    a(paramc, paramActivity, paramai, false, 0);
    AppMethodBeat.o(38984);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.b
 * JD-Core Version:    0.7.0.1
 */