package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.ag;
import com.tencent.mm.am.f;
import com.tencent.mm.am.q;
import com.tencent.mm.g.a.al;
import com.tencent.mm.g.a.fi;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bj.a;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.s;
import com.tencent.mm.storage.x;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.lang.ref.WeakReference;

public final class b
{
  private static boolean isDeleteCancel = false;
  
  public static void a(com.tencent.mm.api.c paramc, Activity paramActivity, am paramam, int paramInt)
  {
    AppMethodBeat.i(38982);
    a(paramc, paramActivity, paramam, false, null, paramInt);
    AppMethodBeat.o(38982);
  }
  
  public static void a(com.tencent.mm.api.c paramc, Activity paramActivity, am paramam, boolean paramBoolean, int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(38985);
    if ((paramc == null) || (paramActivity == null) || (paramam == null))
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
        if (paramam != null) {
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
    final String str = paramam.field_username;
    paramam.acI();
    ba.aBQ();
    com.tencent.mm.model.c.azo().c(new com.tencent.mm.bb.d(str, paramInt));
    if (w.zB(str))
    {
      ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().aTr(str);
      ba.aBQ();
      com.tencent.mm.model.c.azz().AT(str);
      if (com.tencent.mm.app.plugin.a.a.c(paramc))
      {
        paramc = new fi();
        paramc.dqv.doD = str;
        com.tencent.mm.sdk.b.a.IbL.l(paramc);
      }
      ag.aFY().DY(str);
      ag.aGf().apN(str);
      ag.aGg().apN(str);
      if (paramBoolean)
      {
        paramInt = paramActivity.getIntent().getIntExtra("Kdel_from", -1);
        if (paramInt != 0) {
          break label484;
        }
        paramc = new Intent(paramActivity, LauncherUI.class);
        paramc.addFlags(67108864);
        paramc = new com.tencent.mm.hellhoundlib.b.a().bc(paramc);
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramc.ahp(), "com/tencent/mm/ui/tools/BizContactDeleteUtil", "dealDelContactEvent", "(Lcom/tencent/mm/api/BizInfo;Landroid/app/Activity;Lcom/tencent/mm/storage/Contact;ZI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramActivity.startActivity((Intent)paramc.mq(0));
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
      bj.a local3 = new bj.a()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(38979);
          b.Jy();
          AppMethodBeat.o(38979);
        }
      }
      {
        public final boolean YK()
        {
          AppMethodBeat.i(38980);
          boolean bool = b.isDeleteCancel;
          AppMethodBeat.o(38980);
          return bool;
        }
        
        public final void YL()
        {
          AppMethodBeat.i(38981);
          if (this.KDT.Kl())
          {
            com.tencent.mm.kernel.g.ab(q.class);
            s.aSw(str);
            al localal = new al();
            localal.dkZ.userName = str;
            com.tencent.mm.sdk.b.a.IbL.l(localal);
          }
          ag.aFZ().delete(str);
          if (this.KDX.get() != null) {
            ((p)this.KDX.get()).dismiss();
          }
          AppMethodBeat.o(38981);
        }
      };
      ag.aGl();
      com.tencent.mm.am.a.Dv(str);
      ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().c(str, paramam);
      if (paramc.Kn()) {
        com.tencent.mm.am.g.DT(paramc.field_username);
      }
      for (;;)
      {
        if ((paramActivity == null) || (!paramBoolean)) {
          break label482;
        }
        paramActivity.setResult(-1, paramActivity.getIntent().putExtra("_delete_ok_", true));
        break;
        bj.a(str, local3);
        ba.aBQ();
        com.tencent.mm.model.c.azv().aTx(str);
      }
      label482:
      break;
      label484:
      if (paramInt == 2)
      {
        paramc = new Intent();
        paramc.addFlags(67108864);
        com.tencent.mm.bs.d.b(paramActivity, "brandservice", ".ui.BrandServiceIndexUI", paramc);
      }
    }
  }
  
  public static void a(com.tencent.mm.api.c paramc, final Activity paramActivity, final am paramam, final boolean paramBoolean, final Runnable paramRunnable, final int paramInt)
  {
    AppMethodBeat.i(38983);
    if ((paramc == null) || (paramActivity == null) || (paramam == null))
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
        if (paramam != null) {
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
    if (paramc.Ko()) {}
    for (String str = paramActivity.getString(2131756739);; str = paramActivity.getString(2131756740, new Object[] { paramam.adv() }))
    {
      h.a(paramActivity, str, "", paramActivity.getString(2131757797), paramActivity.getString(2131757796), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(38978);
          b.a(this.KDT, paramActivity, paramam, paramBoolean, paramInt);
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
  
  public static void c(com.tencent.mm.api.c paramc, Activity paramActivity, am paramam)
  {
    AppMethodBeat.i(38984);
    a(paramc, paramActivity, paramam, false, 0);
    AppMethodBeat.o(38984);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.b
 * JD-Core Version:    0.7.0.1
 */