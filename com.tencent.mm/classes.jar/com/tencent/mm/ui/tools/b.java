package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.i;
import com.tencent.mm.ai.z;
import com.tencent.mm.h.a.ev;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.af;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.p;

public final class b
{
  private static boolean isDeleteCancel = false;
  private static p tipDialog = null;
  
  public static void a(com.tencent.mm.ai.d paramd, Activity paramActivity, ad paramad, int paramInt)
  {
    a(paramd, paramActivity, paramad, false, null, paramInt);
  }
  
  public static void a(com.tencent.mm.ai.d paramd, Activity paramActivity, ad paramad, boolean paramBoolean, int paramInt)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramd == null) || (paramActivity == null) || (paramad == null)) {
      if (paramd == null)
      {
        paramBoolean = true;
        if (paramActivity != null) {
          break label72;
        }
        bool1 = true;
        label28:
        if (paramad != null) {
          break label78;
        }
        label32:
        y.e("MicroMsg.BizContactDeleteUtil", "error args, %b, %b, %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      }
    }
    label72:
    label78:
    String str;
    do
    {
      return;
      paramBoolean = false;
      break;
      bool1 = false;
      break label28;
      bool2 = false;
      break label32;
      str = paramad.field_username;
      paramad.AI();
      au.Hx();
      c.Fv().b(new com.tencent.mm.ay.b(str, paramInt));
      if (!s.hi(str)) {
        break label316;
      }
      ((j)g.r(j.class)).Fw().abr(str);
      au.Hx();
      c.FF().it(str);
      if (com.tencent.mm.app.plugin.a.a.a(paramd))
      {
        paramd = new ev();
        paramd.bLo.bJw = str;
        com.tencent.mm.sdk.b.a.udP.m(paramd);
      }
      paramd = z.Mx();
      if (!bk.bl(str)) {
        y.i("MicroMsg.BizKFStorage", "deleteKFWorker by brand username(u:%s, r:%d).", new Object[] { str, Integer.valueOf(paramd.dXw.delete("BizKF", "brandUsername = ?", new String[] { str })) });
      }
      z.ME().Hr(str);
      z.MF().Hr(str);
    } while (!paramBoolean);
    paramInt = paramActivity.getIntent().getIntExtra("Kdel_from", -1);
    if (paramInt == 0)
    {
      paramd = new Intent(paramActivity, LauncherUI.class);
      paramd.addFlags(67108864);
      paramActivity.startActivity(paramd);
    }
    for (;;)
    {
      paramActivity.finish();
      return;
      label316:
      isDeleteCancel = false;
      paramActivity.getString(R.l.app_tip);
      tipDialog = com.tencent.mm.ui.base.h.b(paramActivity, paramActivity.getString(R.l.app_waiting), true, new b.2());
      b.3 local3 = new b.3(paramd, str);
      z.MK();
      com.tencent.mm.ai.a.kA(str);
      ((j)g.r(j.class)).Fw().a(str, paramad);
      if (paramd.Ly()) {
        f.lf(paramd.field_username);
      }
      for (;;)
      {
        if ((paramActivity == null) || (!paramBoolean)) {
          break label457;
        }
        paramActivity.setResult(-1, paramActivity.getIntent().putExtra("_delete_ok_", true));
        break;
        com.tencent.mm.model.bd.a(str, local3);
        au.Hx();
        c.FB().abu(str);
      }
      label457:
      break;
      if (paramInt == 2)
      {
        paramd = new Intent();
        paramd.addFlags(67108864);
        com.tencent.mm.br.d.b(paramActivity, "brandservice", ".ui.BrandServiceIndexUI", paramd);
      }
    }
  }
  
  public static void a(com.tencent.mm.ai.d paramd, Activity paramActivity, ad paramad, boolean paramBoolean, Runnable paramRunnable, int paramInt)
  {
    if ((paramd == null) || (paramActivity == null) || (paramad == null))
    {
      boolean bool1;
      if (paramd == null)
      {
        paramBoolean = true;
        if (paramActivity != null) {
          break label73;
        }
        bool1 = true;
        label25:
        if (paramad != null) {
          break label79;
        }
      }
      label73:
      label79:
      for (boolean bool2 = true;; bool2 = false)
      {
        y.e("MicroMsg.BizContactDeleteUtil", "bizInfo null : %s, context null : %s, ct null : %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        return;
        paramBoolean = false;
        break;
        bool1 = false;
        break label25;
      }
    }
    if (paramd.Lz()) {}
    for (String str = paramActivity.getString(R.l.brandservice_remove_enterprise_tips);; str = paramActivity.getString(R.l.brandservice_remove_subscribe_tips, new Object[] { paramad.Bq() }))
    {
      com.tencent.mm.ui.base.h.a(paramActivity, str, "", paramActivity.getString(R.l.contact_info_remove_biz_alert_sure), paramActivity.getString(R.l.contact_info_remove_biz_alert_cancel), new b.1(paramd, paramActivity, paramad, paramBoolean, paramInt, paramRunnable), null, R.e.red);
      return;
    }
  }
  
  public static void c(com.tencent.mm.ai.d paramd, Activity paramActivity, ad paramad)
  {
    a(paramd, paramActivity, paramad, false, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.tools.b
 * JD-Core Version:    0.7.0.1
 */