package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.f;
import com.tencent.mm.am.k;
import com.tencent.mm.g.a.pa;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bi.a;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;

public final class c
{
  public static void a(final String paramString, final Context paramContext, final am paramam, final Runnable paramRunnable, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(38287);
    final PBool localPBool = new PBool();
    Object localObject1;
    if (w.pF(paramString))
    {
      paramam = null;
      az.arV();
      localObject1 = com.tencent.mm.model.c.apO().agp(paramString);
      az.arV();
      com.tencent.mm.model.c.apL().c(new com.tencent.mm.bb.d(paramString, ((du)localObject1).field_msgSvrId));
      localPBool.value = false;
      paramContext.getString(2131755906);
      localObject1 = com.tencent.mm.ui.base.h.b(paramContext, paramContext.getString(2131755936), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          this.HaH.value = true;
        }
      });
      if (!localPBool.value) {
        paramam = com.tencent.mm.pluginsdk.wallet.d.aCU(paramString);
      }
      if (!bt.isNullOrNil(paramam))
      {
        ((ProgressDialog)localObject1).dismiss();
        com.tencent.mm.ui.base.h.a(paramContext, false, paramContext.getString(2131765189, new Object[] { paramam }), null, paramContext.getString(2131760081), paramContext.getString(2131758021), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(38279);
            this.HaH.value = true;
            c.c(paramContext, paramBoolean2, paramString);
            if (paramBoolean1) {
              com.tencent.mm.plugin.report.service.h.vKh.f(14553, new Object[] { Integer.valueOf(1), Integer.valueOf(4), paramString });
            }
            AppMethodBeat.o(38279);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(38280);
            this.fqF.show();
            localPBool.value = false;
            c.a(paramString, localPBool, this.fqF);
            if (paramBoolean1) {
              com.tencent.mm.plugin.report.service.h.vKh.f(14553, new Object[] { Integer.valueOf(1), Integer.valueOf(3), paramString });
            }
            if (paramRunnable != null) {
              paramRunnable.run();
            }
            AppMethodBeat.o(38280);
          }
        }, -1, 2131099904);
      }
    }
    while (w.sL(paramString))
    {
      ad.i("MicroMsg.ConvDelLogic", "del all qmessage");
      bi.asj();
      az.arV();
      com.tencent.mm.model.c.apR().aIm("@qqim");
      AppMethodBeat.o(38287);
      return;
      ((ProgressDialog)localObject1).dismiss();
      com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131759507), "", paramContext.getString(2131755707), paramContext.getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(38281);
          c.a(this.fHA, localPBool, this.fqF);
          if (paramRunnable != null) {
            paramRunnable.run();
          }
          AppMethodBeat.o(38281);
        }
      }, null, 2131099904);
      continue;
      if (w.sU(paramString))
      {
        az.arV();
        com.tencent.mm.model.c.apR().aIm(paramString);
        paramContext = new pa();
        paramContext.duz.opType = 4;
        paramContext.duz.duE = 20;
        a.ESL.l(paramContext);
      }
      else if (w.sK(paramString))
      {
        az.arV();
        com.tencent.mm.model.c.apR().aIm(paramString);
      }
      else if (w.sN(paramString))
      {
        az.arV();
        com.tencent.mm.model.c.apR().aIl(paramString);
      }
      else
      {
        Object localObject2;
        int i;
        if (f.wL(paramString))
        {
          az.arV();
          localObject1 = com.tencent.mm.model.c.apO().agp(paramString);
          az.arV();
          com.tencent.mm.model.c.apL().c(new com.tencent.mm.bb.d(paramString, ((du)localObject1).field_msgSvrId));
          localPBool.value = false;
          paramContext.getString(2131755906);
          localObject1 = com.tencent.mm.ui.base.h.b(paramContext, paramContext.getString(2131755936), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              this.HaH.value = true;
            }
          });
          com.tencent.mm.am.af.awe();
          localObject2 = com.tencent.mm.am.e.wC(paramString);
          paramam = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(191711);
              c.a(paramString, paramam, localPBool, this.HaL);
              if (paramRunnable != null) {
                paramRunnable.run();
              }
              if (f.wG(paramString)) {
                com.tencent.mm.am.af.awp().wU(paramString);
              }
              AppMethodBeat.o(191711);
            }
          };
          ((ProgressDialog)localObject1).dismiss();
          if (bt.isNullOrNil((String)localObject2))
          {
            if (w.td(paramString)) {}
            for (i = 2131759506;; i = 2131759505)
            {
              com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(i), "", paramContext.getString(2131755707), paramContext.getString(2131755691), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(191712);
                  this.HaN.run();
                  AppMethodBeat.o(191712);
                }
              }, null, 2131099904);
              break;
            }
          }
          com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131759505), "", paramContext.getString(2131755707), paramContext.getString(2131755691), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(38285);
              this.HaN.run();
              bi.a(paramString, new bi.a()
              {
                public final boolean Vt()
                {
                  AppMethodBeat.i(191713);
                  if ((c.17.this.HaH.value) || (c.17.this.HaL == null) || (!c.17.this.HaL.isShowing()))
                  {
                    AppMethodBeat.o(191713);
                    return true;
                  }
                  AppMethodBeat.o(191713);
                  return false;
                }
                
                public final void Vu()
                {
                  AppMethodBeat.i(191714);
                  com.tencent.mm.am.a.e.M(c.17.this.FJl, false);
                  if (c.17.this.HaL != null) {
                    c.17.this.HaL.dismiss();
                  }
                  AppMethodBeat.o(191714);
                }
              });
              AppMethodBeat.o(38285);
            }
          }, null, 2131099904);
        }
        else if (f.pc(paramString))
        {
          localPBool.value = false;
          paramContext.getString(2131755906);
          paramam = com.tencent.mm.ui.base.h.b(paramContext, paramContext.getString(2131755936), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              this.HaH.value = true;
            }
          });
          paramam.dismiss();
          com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131759505), "", paramContext.getString(2131755707), paramContext.getString(2131755691), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(38273);
              bi.a(this.fHA, new bi.a()
              {
                public final boolean Vt()
                {
                  AppMethodBeat.i(191701);
                  if ((c.2.this.HaH.value) || (c.2.this.fqF == null) || (!c.2.this.fqF.isShowing()))
                  {
                    AppMethodBeat.o(191701);
                    return true;
                  }
                  AppMethodBeat.o(191701);
                  return false;
                }
                
                public final void Vu()
                {
                  AppMethodBeat.i(191702);
                  com.tencent.mm.am.a.e.M(c.2.this.FJl, false);
                  if (c.2.this.fqF != null) {
                    c.2.this.fqF.dismiss();
                  }
                  AppMethodBeat.o(191702);
                }
              });
              AppMethodBeat.o(38273);
            }
          }, null, 2131099904);
        }
        else
        {
          az.arV();
          localObject1 = com.tencent.mm.model.c.apO().agp(paramString);
          az.arV();
          com.tencent.mm.model.c.apL().c(new com.tencent.mm.bb.d(paramString, ((du)localObject1).field_msgSvrId));
          localPBool.value = false;
          paramContext.getString(2131755906);
          localObject2 = com.tencent.mm.ui.base.h.b(paramContext, paramContext.getString(2131755936), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              this.HaH.value = true;
            }
          });
          localObject1 = null;
          if (!localPBool.value) {
            localObject1 = com.tencent.mm.pluginsdk.wallet.d.aCU(paramString);
          }
          if (!bt.isNullOrNil((String)localObject1))
          {
            ((ProgressDialog)localObject2).dismiss();
            com.tencent.mm.ui.base.h.a(paramContext, false, paramContext.getString(2131765189, new Object[] { localObject1 }), null, paramContext.getString(2131760081), paramContext.getString(2131758021), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(191703);
                this.HaH.value = true;
                c.c(paramContext, paramBoolean2, paramString);
                if (paramBoolean1) {
                  com.tencent.mm.plugin.report.service.h.vKh.f(14553, new Object[] { Integer.valueOf(0), Integer.valueOf(4), paramString });
                }
                AppMethodBeat.o(191703);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(191704);
                this.HaL.show();
                localPBool.value = false;
                c.a(paramString, paramam, localPBool, this.HaL);
                if (paramRunnable != null) {
                  paramRunnable.run();
                }
                if (paramBoolean1) {
                  com.tencent.mm.plugin.report.service.h.vKh.f(14553, new Object[] { Integer.valueOf(0), Integer.valueOf(3), paramString });
                }
                AppMethodBeat.o(191704);
              }
            }, -1, 2131099904);
          }
          else
          {
            ((ProgressDialog)localObject2).dismiss();
            if (w.td(paramString)) {}
            for (i = 2131759506;; i = 2131759505)
            {
              com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(i), "", paramContext.getString(2131755707), paramContext.getString(2131755691), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(191705);
                  c.a(paramString, paramam, localPBool, this.HaL);
                  if (paramRunnable != null) {
                    paramRunnable.run();
                  }
                  if (f.wG(paramString)) {
                    com.tencent.mm.am.af.awp().wU(paramString);
                  }
                  AppMethodBeat.o(191705);
                }
              }, null, 2131099904);
              break;
            }
          }
        }
      }
    }
    if (w.sJ(paramString))
    {
      ad.i("MicroMsg.ConvDelLogic", "del all tmessage");
      bi.ask();
      az.arV();
      com.tencent.mm.model.c.apR().aIm("@t.qq.com");
    }
    AppMethodBeat.o(38287);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.c
 * JD-Core Version:    0.7.0.1
 */