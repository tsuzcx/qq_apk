package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.d;
import com.tencent.mm.g.a.nn;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bf.a;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.base.p;

public final class c
{
  public static void a(final String paramString, final Context paramContext, final ak paramak, final Runnable paramRunnable, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(34169);
    final PBool localPBool = new PBool();
    Object localObject;
    if (t.lA(paramString))
    {
      paramak = null;
      aw.aaz();
      localObject = com.tencent.mm.model.c.YC().Tl(paramString);
      aw.aaz();
      com.tencent.mm.model.c.Yz().c(new d(paramString, ((dd)localObject).field_msgSvrId));
      localPBool.value = false;
      paramContext.getString(2131297087);
      localObject = com.tencent.mm.ui.base.h.b(paramContext, paramContext.getString(2131297112), true, new c.1(localPBool));
      if (!localPBool.value) {
        paramak = com.tencent.mm.pluginsdk.wallet.f.amZ(paramString);
      }
      if (!ah.isNullOrNil(paramak))
      {
        ((ProgressDialog)localObject).dismiss();
        com.tencent.mm.ui.base.h.a(paramContext, false, paramContext.getString(2131304997, new Object[] { paramak }), null, paramContext.getString(2131300537), paramContext.getString(2131298936), new DialogInterface.OnClickListener()new c.8
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(34161);
            this.Ahi.value = true;
            c.c(paramContext, paramBoolean2, paramString);
            if (paramBoolean1) {
              com.tencent.mm.plugin.report.service.h.qsU.e(14553, new Object[] { Integer.valueOf(1), Integer.valueOf(4), paramString });
            }
            AppMethodBeat.o(34161);
          }
        }, new c.8((ProgressDialog)localObject, localPBool, paramString, paramBoolean1, paramRunnable), -1, 2131689667);
      }
    }
    while (t.ob(paramString))
    {
      ab.i("MicroMsg.ConvDelLogic", "del all qmessage");
      bf.aaN();
      aw.aaz();
      com.tencent.mm.model.c.YF().arG("@qqim");
      AppMethodBeat.o(34169);
      return;
      ((ProgressDialog)localObject).dismiss();
      com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131300040), "", paramContext.getString(2131296901), paramContext.getString(2131296888), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(34163);
          c.a(this.euc, localPBool, this.efE);
          if (paramRunnable != null) {
            paramRunnable.run();
          }
          AppMethodBeat.o(34163);
        }
      }, null, 2131689667);
      continue;
      if (t.ok(paramString))
      {
        aw.aaz();
        com.tencent.mm.model.c.YF().arG(paramString);
        paramContext = new nn();
        paramContext.cDX.opType = 4;
        paramContext.cDX.cEc = 20;
        a.ymk.l(paramContext);
      }
      else if (t.oa(paramString))
      {
        aw.aaz();
        com.tencent.mm.model.c.YF().arG(paramString);
      }
      else if (t.od(paramString))
      {
        aw.aaz();
        com.tencent.mm.model.c.YF().arF(paramString);
      }
      else if (com.tencent.mm.aj.f.lg(paramString))
      {
        localPBool.value = false;
        paramContext.getString(2131297087);
        paramak = com.tencent.mm.ui.base.h.b(paramContext, paramContext.getString(2131297112), true, new c.10(localPBool));
        paramak.dismiss();
        com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131300038), "", paramContext.getString(2131296901), paramContext.getString(2131296888), new c.11(paramString, localPBool, paramak, paramString), null, 2131689667);
      }
      else
      {
        aw.aaz();
        localObject = com.tencent.mm.model.c.YC().Tl(paramString);
        aw.aaz();
        com.tencent.mm.model.c.Yz().c(new d(paramString, ((dd)localObject).field_msgSvrId));
        localPBool.value = false;
        paramContext.getString(2131297087);
        p localp = com.tencent.mm.ui.base.h.b(paramContext, paramContext.getString(2131297112), true, new c.12(localPBool));
        localObject = null;
        if (!localPBool.value) {
          localObject = com.tencent.mm.pluginsdk.wallet.f.amZ(paramString);
        }
        if (!ah.isNullOrNil((String)localObject))
        {
          localp.dismiss();
          com.tencent.mm.ui.base.h.a(paramContext, false, paramContext.getString(2131304997, new Object[] { localObject }), null, paramContext.getString(2131300537), paramContext.getString(2131298936), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(34167);
              this.Ahi.value = true;
              c.c(paramContext, paramBoolean2, paramString);
              if (paramBoolean1) {
                com.tencent.mm.plugin.report.service.h.qsU.e(14553, new Object[] { Integer.valueOf(0), Integer.valueOf(4), paramString });
              }
              AppMethodBeat.o(34167);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(34168);
              this.Ahj.show();
              localPBool.value = false;
              c.a(paramString, paramak, localPBool, this.Ahj);
              if (paramRunnable != null) {
                paramRunnable.run();
              }
              if (paramBoolean1) {
                com.tencent.mm.plugin.report.service.h.qsU.e(14553, new Object[] { Integer.valueOf(0), Integer.valueOf(3), paramString });
              }
              AppMethodBeat.o(34168);
            }
          }, -1, 2131689667);
        }
        else
        {
          localp.dismiss();
          if (t.ot(paramString)) {}
          for (int i = 2131300039;; i = 2131300038)
          {
            com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(i), "", paramContext.getString(2131296901), paramContext.getString(2131296888), new c.2(paramContext, paramString, paramak, localPBool, localp, paramRunnable), null, 2131689667);
            break;
          }
        }
      }
    }
    if (t.nZ(paramString))
    {
      ab.i("MicroMsg.ConvDelLogic", "del all tmessage");
      bf.aaO();
      aw.aaz();
      com.tencent.mm.model.c.YF().arG("@t.qq.com");
    }
    AppMethodBeat.o(34169);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.c
 * JD-Core Version:    0.7.0.1
 */