package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.ao.af;
import com.tencent.mm.ao.g;
import com.tencent.mm.ao.l;
import com.tencent.mm.f.a.rn;
import com.tencent.mm.f.b.a.gu;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bq.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.ar;

public final class c
{
  public static void a(final String paramString, final Context paramContext, final az paramaz, final Runnable paramRunnable, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(38287);
    final PBool localPBool = new PBool();
    Object localObject1;
    if (com.tencent.mm.model.ab.Lj(paramString))
    {
      paramaz = null;
      bh.beI();
      localObject1 = com.tencent.mm.model.c.bbO().aOG(paramString);
      bh.beI();
      com.tencent.mm.model.c.bbK().d(new com.tencent.mm.bd.e(paramString, ((et)localObject1).field_msgSvrId));
      localPBool.value = false;
      paramContext.getString(R.l.app_tip);
      localObject1 = com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          this.XzN.value = true;
        }
      });
      if (!localPBool.value) {
        paramaz = com.tencent.mm.pluginsdk.wallet.d.bsh(paramString);
      }
      if (!Util.isNullOrNil(paramaz))
      {
        ((ProgressDialog)localObject1).dismiss();
        com.tencent.mm.ui.base.h.a(paramContext, false, paramContext.getString(R.l.eVw, new Object[] { paramaz }), null, paramContext.getString(R.l.goto_conversation), paramContext.getString(R.l.eAX), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(38279);
            this.XzN.value = true;
            c.c(paramContext, paramBoolean2, paramString);
            if (paramBoolean1) {
              com.tencent.mm.plugin.report.service.h.IzE.a(14553, new Object[] { Integer.valueOf(1), Integer.valueOf(4), paramString });
            }
            AppMethodBeat.o(38279);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(38280);
            this.iYO.show();
            localPBool.value = false;
            c.a(paramContext, paramString, localPBool, this.iYO);
            if (paramBoolean1) {
              com.tencent.mm.plugin.report.service.h.IzE.a(14553, new Object[] { Integer.valueOf(1), Integer.valueOf(3), paramString });
            }
            if (paramRunnable != null) {
              paramRunnable.run();
            }
            AppMethodBeat.o(38280);
          }
        }, -1, R.e.alert_btn_color_warn);
      }
    }
    while (com.tencent.mm.model.ab.Qt(paramString))
    {
      Log.i("MicroMsg.ConvDelLogic", "del all qmessage");
      bq.beV();
      bh.beI();
      com.tencent.mm.model.c.bbR().bww("@qqim");
      AppMethodBeat.o(38287);
      return;
      ((ProgressDialog)localObject1).dismiss();
      com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(R.l.eFA), "", paramContext.getString(R.l.app_delete), paramContext.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(38281);
          c.a(this.val$context, paramString, localPBool, this.iYO);
          if (paramRunnable != null) {
            paramRunnable.run();
          }
          AppMethodBeat.o(38281);
        }
      }, null, R.e.alert_btn_color_warn);
      continue;
      if (com.tencent.mm.model.ab.QC(paramString))
      {
        bh.beI();
        com.tencent.mm.model.c.bbR().bww(paramString);
        paramContext = new rn();
        paramContext.fQH.opType = 4;
        paramContext.fQH.fQM = 20;
        EventCenter.instance.publish(paramContext);
      }
      else if (com.tencent.mm.model.ab.Qs(paramString))
      {
        bh.beI();
        com.tencent.mm.model.c.bbR().bww(paramString);
      }
      else if (com.tencent.mm.model.ab.Qv(paramString))
      {
        bh.beI();
        com.tencent.mm.model.c.bbR().bwv(paramString);
      }
      else
      {
        Object localObject2;
        int i;
        if (g.UC(paramString))
        {
          bh.beI();
          localObject1 = com.tencent.mm.model.c.bbO().aOG(paramString);
          bh.beI();
          com.tencent.mm.model.c.bbK().d(new com.tencent.mm.bd.e(paramString, ((et)localObject1).field_msgSvrId));
          localPBool.value = false;
          paramContext.getString(R.l.app_tip);
          localObject1 = com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              this.XzN.value = true;
            }
          });
          af.bjv();
          localObject2 = com.tencent.mm.ao.f.Ut(paramString);
          paramaz = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(287136);
              c.a(this.val$context, paramString, paramaz, localPBool, this.XzR);
              if (paramRunnable != null) {
                paramRunnable.run();
              }
              if (g.Ux(paramString)) {
                af.bjH().UL(paramString);
              }
              AppMethodBeat.o(287136);
            }
          };
          ((ProgressDialog)localObject1).dismiss();
          if (Util.isNullOrNil((String)localObject2))
          {
            if (com.tencent.mm.model.ab.QL(paramString)) {}
            for (i = R.l.eFz;; i = R.l.eFy)
            {
              com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(i), "", paramContext.getString(R.l.app_delete), paramContext.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(290824);
                  this.XzT.run();
                  AppMethodBeat.o(290824);
                }
              }, null, R.e.alert_btn_color_warn);
              break;
            }
          }
          com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(R.l.eFy), "", paramContext.getString(R.l.app_delete), paramContext.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(38285);
              this.XzT.run();
              bq.a(paramString, new bq.a()
              {
                public final boolean asH()
                {
                  AppMethodBeat.i(291153);
                  if ((c.17.this.XzN.value) || (c.17.this.XzR == null) || (!c.17.this.XzR.isShowing()))
                  {
                    AppMethodBeat.o(291153);
                    return true;
                  }
                  AppMethodBeat.o(291153);
                  return false;
                }
                
                public final void asI()
                {
                  AppMethodBeat.i(291155);
                  com.tencent.mm.ao.a.e.R(c.17.this.VTL, false);
                  if (c.17.this.XzR != null) {
                    c.17.this.XzR.dismiss();
                  }
                  AppMethodBeat.o(291155);
                }
              });
              AppMethodBeat.o(38285);
            }
          }, null, R.e.alert_btn_color_warn);
        }
        else if (g.KI(paramString))
        {
          localPBool.value = false;
          paramContext.getString(R.l.app_tip);
          paramaz = com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              this.XzN.value = true;
            }
          });
          paramaz.dismiss();
          com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(R.l.eFy), "", paramContext.getString(R.l.app_delete), paramContext.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(38273);
              bq.a(this.jwL, new bq.a()
              {
                public final boolean asH()
                {
                  AppMethodBeat.i(260256);
                  if ((c.2.this.XzN.value) || (c.2.this.iYO == null) || (!c.2.this.iYO.isShowing()))
                  {
                    AppMethodBeat.o(260256);
                    return true;
                  }
                  AppMethodBeat.o(260256);
                  return false;
                }
                
                public final void asI()
                {
                  AppMethodBeat.i(260258);
                  com.tencent.mm.ao.a.e.R(c.2.this.VTL, false);
                  if (c.2.this.iYO != null) {
                    c.2.this.iYO.dismiss();
                  }
                  AppMethodBeat.o(260258);
                }
              });
              AppMethodBeat.o(38273);
            }
          }, null, R.e.alert_btn_color_warn);
        }
        else
        {
          bh.beI();
          localObject1 = com.tencent.mm.model.c.bbO().aOG(paramString);
          bh.beI();
          com.tencent.mm.model.c.bbK().d(new com.tencent.mm.bd.e(paramString, ((et)localObject1).field_msgSvrId));
          localPBool.value = false;
          paramContext.getString(R.l.app_tip);
          localObject2 = com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              this.XzN.value = true;
            }
          });
          localObject1 = null;
          if (!localPBool.value) {
            localObject1 = com.tencent.mm.pluginsdk.wallet.d.bsh(paramString);
          }
          if (!Util.isNullOrNil((String)localObject1))
          {
            ((ProgressDialog)localObject2).dismiss();
            com.tencent.mm.ui.base.h.a(paramContext, false, paramContext.getString(R.l.eVw, new Object[] { localObject1 }), null, paramContext.getString(R.l.goto_conversation), paramContext.getString(R.l.eAX), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(279620);
                this.XzN.value = true;
                c.c(paramContext, paramBoolean2, paramString);
                if (paramBoolean1) {
                  com.tencent.mm.plugin.report.service.h.IzE.a(14553, new Object[] { Integer.valueOf(0), Integer.valueOf(4), paramString });
                }
                AppMethodBeat.o(279620);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(283836);
                this.XzR.show();
                localPBool.value = false;
                c.a(paramContext, paramString, paramaz, localPBool, this.XzR);
                if (paramRunnable != null) {
                  paramRunnable.run();
                }
                if (paramBoolean1) {
                  com.tencent.mm.plugin.report.service.h.IzE.a(14553, new Object[] { Integer.valueOf(0), Integer.valueOf(3), paramString });
                }
                AppMethodBeat.o(283836);
              }
            }, -1, R.e.alert_btn_color_warn);
          }
          else
          {
            ((ProgressDialog)localObject2).dismiss();
            if (com.tencent.mm.model.ab.QL(paramString)) {}
            for (i = R.l.eFz;; i = R.l.eFy)
            {
              com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(i), "", paramContext.getString(R.l.app_delete), paramContext.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(287194);
                  c.a(this.val$context, paramString, paramaz, localPBool, this.XzR);
                  if (paramRunnable != null) {
                    paramRunnable.run();
                  }
                  if (g.Ux(paramString)) {
                    af.bjH().UL(paramString);
                  }
                  if (com.tencent.mm.model.ab.QL(paramString)) {
                    com.tencent.mm.storage.ab.hxi();
                  }
                  AppMethodBeat.o(287194);
                }
              }, null, R.e.alert_btn_color_warn);
              break;
            }
          }
        }
      }
    }
    if (com.tencent.mm.model.ab.Qr(paramString))
    {
      Log.i("MicroMsg.ConvDelLogic", "del all tmessage");
      bq.beW();
      bh.beI();
      com.tencent.mm.model.c.bbR().bww("@t.qq.com");
      AppMethodBeat.o(38287);
      return;
    }
    if (com.tencent.mm.model.ab.QQ(paramString))
    {
      Log.i("MicroMsg.ConvDelLogic", "del all notify message");
      ((com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class)).getFinderLiveNotifyExposureInfoStorage().dDQ();
    }
    AppMethodBeat.o(38287);
  }
  
  private static void lo(Context paramContext)
  {
    AppMethodBeat.i(202782);
    if (ar.hIH())
    {
      com.tencent.mm.by.c.f(paramContext, ".ui.EmptyActivity", new Intent());
      Log.i("MicroMsg.ConvDelLogic", "start empty activity");
    }
    AppMethodBeat.o(202782);
  }
  
  private static void report(String paramString)
  {
    AppMethodBeat.i(202783);
    bh.beI();
    az localaz = com.tencent.mm.model.c.bbR().bwx(paramString);
    if (localaz != null)
    {
      gu localgu = new gu();
      localgu.giq = 15L;
      localgu.vL(paramString);
      localgu.gCI = ac.Rl(paramString);
      localgu.giH = localaz.field_unReadCount;
      localgu.bpa();
    }
    AppMethodBeat.o(202783);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.c
 * JD-Core Version:    0.7.0.1
 */