package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.f;
import com.tencent.mm.ba.d;
import com.tencent.mm.g.a.an;
import com.tencent.mm.g.a.fm;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.bp.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.h;
import java.lang.ref.WeakReference;

public final class b
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
    paramas.aqR();
    bg.aVF();
    com.tencent.mm.model.c.aSM().d(new d(str, paramInt));
    if (ab.IQ(str))
    {
      ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().aNa(str);
      bg.aVF();
      com.tencent.mm.model.c.aSX().Kj(str);
      if (com.tencent.mm.app.plugin.a.a.d(paramc))
      {
        paramc = new fm();
        paramc.dIM.brandName = str;
        EventCenter.instance.publish(paramc);
      }
      ag.bag().No(str);
      ag.ban().aEn(str);
      ag.bap().aEn(str);
      if (paramBoolean)
      {
        paramInt = paramActivity.getIntent().getIntExtra("Kdel_from", -1);
        if (paramInt != 0) {
          break label484;
        }
        paramc = new Intent(paramActivity, LauncherUI.class);
        paramc.addFlags(67108864);
        paramc = new com.tencent.mm.hellhoundlib.b.a().bl(paramc);
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramc.axQ(), "com/tencent/mm/ui/tools/BizContactDeleteUtil", "dealDelContactEvent", "(Lcom/tencent/mm/api/BizInfo;Landroid/app/Activity;Lcom/tencent/mm/storage/Contact;ZI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramActivity.startActivity((Intent)paramc.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/ui/tools/BizContactDeleteUtil", "dealDelContactEvent", "(Lcom/tencent/mm/api/BizInfo;Landroid/app/Activity;Lcom/tencent/mm/storage/Contact;ZI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    for (;;)
    {
      paramActivity.finish();
      AppMethodBeat.o(38985);
      return;
      isDeleteCancel = false;
      paramActivity.getString(2131755998);
      bp.a local3 = new bp.a()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(38979);
          b.TT();
          AppMethodBeat.o(38979);
        }
      }
      {
        public final boolean amG()
        {
          AppMethodBeat.i(38980);
          boolean bool = b.isDeleteCancel;
          AppMethodBeat.o(38980);
          return bool;
        }
        
        public final void amH()
        {
          AppMethodBeat.i(38981);
          if (this.Qpo.UD())
          {
            com.tencent.mm.kernel.g.af(com.tencent.mm.al.q.class);
            u.biP(str);
            an localan = new an();
            localan.dDr.userName = str;
            EventCenter.instance.publish(localan);
          }
          ag.bah().delete(str);
          if (this.Qps.get() != null) {
            ((com.tencent.mm.ui.base.q)this.Qps.get()).dismiss();
          }
          AppMethodBeat.o(38981);
        }
      };
      ag.bau();
      com.tencent.mm.al.a.ML(str);
      ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().c(str, paramas);
      if (paramc.UF()) {
        com.tencent.mm.al.g.Nj(paramc.field_username);
      }
      for (;;)
      {
        if ((paramActivity == null) || (!paramBoolean)) {
          break label482;
        }
        paramActivity.setResult(-1, paramActivity.getIntent().putExtra("_delete_ok_", true));
        break;
        bp.a(str, local3);
        bg.aVF();
        com.tencent.mm.model.c.aST().bjW(str);
      }
      label482:
      break;
      label484:
      if (paramInt == 2)
      {
        paramc = new Intent();
        paramc.addFlags(67108864);
        com.tencent.mm.br.c.b(paramActivity, "brandservice", ".ui.BrandServiceIndexUI", paramc);
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
    if (paramc.UG()) {}
    for (String str = paramActivity.getString(2131756901);; str = paramActivity.getString(2131756902, new Object[] { paramas.arJ() }))
    {
      h.a(paramActivity, str, "", paramActivity.getString(2131758037), paramActivity.getString(2131758036), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(38978);
          b.a(this.Qpo, paramActivity, paramas, paramBoolean, paramInt);
          ((com.tencent.mm.api.q)com.tencent.mm.kernel.g.af(com.tencent.mm.api.q.class)).c(this.Qpo);
          if (paramRunnable != null) {
            paramRunnable.run();
          }
          AppMethodBeat.o(38978);
        }
      }, null, 2131100994);
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
 * Qualified Name:     com.tencent.mm.ui.tools.b
 * JD-Core Version:    0.7.0.1
 */