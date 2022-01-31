package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.f;
import com.tencent.mm.aj.z;
import com.tencent.mm.g.a.ey;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.r;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public final class b
{
  private static boolean isDeleteCancel = false;
  private static p tipDialog = null;
  
  public static void a(com.tencent.mm.aj.d paramd, Activity paramActivity, ad paramad, int paramInt)
  {
    AppMethodBeat.i(34789);
    a(paramd, paramActivity, paramad, false, null, paramInt);
    AppMethodBeat.o(34789);
  }
  
  public static void a(com.tencent.mm.aj.d paramd, Activity paramActivity, ad paramad, boolean paramBoolean, int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(34792);
    if ((paramd == null) || (paramActivity == null) || (paramad == null))
    {
      boolean bool1;
      if (paramd == null)
      {
        paramBoolean = true;
        if (paramActivity != null) {
          break label82;
        }
        bool1 = true;
        label33:
        if (paramad != null) {
          break label88;
        }
      }
      for (;;)
      {
        ab.e("MicroMsg.BizContactDeleteUtil", "error args, %b, %b, %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        AppMethodBeat.o(34792);
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
    String str = paramad.field_username;
    paramad.Ny();
    aw.aaz();
    com.tencent.mm.model.c.Yz().c(new com.tencent.mm.az.c(str, paramInt));
    if (com.tencent.mm.model.t.nR(str))
    {
      ((j)g.E(j.class)).YA().arC(str);
      aw.aaz();
      com.tencent.mm.model.c.YJ().pa(str);
      if (com.tencent.mm.app.plugin.a.a.a(paramd))
      {
        paramd = new ey();
        paramd.csI.cqQ = str;
        com.tencent.mm.sdk.b.a.ymk.l(paramd);
      }
      z.afh().sd(str);
      z.afo().Td(str);
      z.afp().Td(str);
      if (paramBoolean)
      {
        paramInt = paramActivity.getIntent().getIntExtra("Kdel_from", -1);
        if (paramInt != 0) {
          break label424;
        }
        paramd = new Intent(paramActivity, LauncherUI.class);
        paramd.addFlags(67108864);
        paramActivity.startActivity(paramd);
      }
    }
    for (;;)
    {
      paramActivity.finish();
      AppMethodBeat.o(34792);
      return;
      isDeleteCancel = false;
      paramActivity.getString(2131297087);
      tipDialog = h.b(paramActivity, paramActivity.getString(2131297112), true, new b.2());
      b.3 local3 = new b.3(paramd, str);
      z.afu();
      com.tencent.mm.aj.a.ru(str);
      ((j)g.E(j.class)).YA().b(str, paramad);
      if (paramd.aeg()) {
        f.sa(paramd.field_username);
      }
      for (;;)
      {
        if ((paramActivity == null) || (!paramBoolean)) {
          break label422;
        }
        paramActivity.setResult(-1, paramActivity.getIntent().putExtra("_delete_ok_", true));
        break;
        bf.a(str, local3);
        aw.aaz();
        com.tencent.mm.model.c.YF().arF(str);
      }
      label422:
      break;
      label424:
      if (paramInt == 2)
      {
        paramd = new Intent();
        paramd.addFlags(67108864);
        com.tencent.mm.bq.d.b(paramActivity, "brandservice", ".ui.BrandServiceIndexUI", paramd);
      }
    }
  }
  
  public static void a(com.tencent.mm.aj.d paramd, Activity paramActivity, ad paramad, boolean paramBoolean, Runnable paramRunnable, int paramInt)
  {
    AppMethodBeat.i(34790);
    if ((paramd == null) || (paramActivity == null) || (paramad == null))
    {
      boolean bool1;
      if (paramd == null)
      {
        paramBoolean = true;
        if (paramActivity != null) {
          break label85;
        }
        bool1 = true;
        label31:
        if (paramad != null) {
          break label91;
        }
      }
      label85:
      label91:
      for (boolean bool2 = true;; bool2 = false)
      {
        ab.e("MicroMsg.BizContactDeleteUtil", "bizInfo null : %s, context null : %s, ct null : %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        AppMethodBeat.o(34790);
        return;
        paramBoolean = false;
        break;
        bool1 = false;
        break label31;
      }
    }
    if (paramd.aeh()) {}
    for (String str = paramActivity.getString(2131297813);; str = paramActivity.getString(2131297814, new Object[] { paramad.Of() }))
    {
      h.a(paramActivity, str, "", paramActivity.getString(2131298734), paramActivity.getString(2131298733), new b.1(paramd, paramActivity, paramad, paramBoolean, paramInt, paramRunnable), null, 2131690391);
      AppMethodBeat.o(34790);
      return;
    }
  }
  
  public static void c(com.tencent.mm.aj.d paramd, Activity paramActivity, ad paramad)
  {
    AppMethodBeat.i(34791);
    a(paramd, paramActivity, paramad, false, 0);
    AppMethodBeat.o(34791);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.tools.b
 * JD-Core Version:    0.7.0.1
 */