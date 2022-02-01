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
import com.tencent.mm.an.af;
import com.tencent.mm.an.f;
import com.tencent.mm.an.g;
import com.tencent.mm.an.l;
import com.tencent.mm.autogen.a.tc;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.autogen.mmdata.rpt.iq;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.br.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.k;
import java.util.Iterator;
import java.util.List;

public final class d
{
  public static void a(final String paramString, final Context paramContext, final bb parambb, final Runnable paramRunnable, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(38287);
    final PBool localPBool = new PBool();
    Object localObject1;
    if (au.bwE(paramString))
    {
      parambb = null;
      bh.bCz();
      localObject1 = com.tencent.mm.model.c.bzD().aLF(paramString);
      bh.bCz();
      com.tencent.mm.model.c.bzz().d(new com.tencent.mm.ay.e(paramString, ((fi)localObject1).field_msgSvrId));
      localPBool.value = false;
      paramContext.getString(R.l.app_tip);
      localObject1 = k.a(paramContext, paramContext.getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          d.this.value = true;
        }
      });
      if (!localPBool.value) {
        parambb = com.tencent.mm.pluginsdk.wallet.d.brY(paramString);
      }
      if (!Util.isNullOrNil(parambb))
      {
        ((ProgressDialog)localObject1).dismiss();
        k.a(paramContext, false, paramContext.getString(R.l.gYC, new Object[] { parambb }), null, paramContext.getString(R.l.goto_conversation), paramContext.getString(R.l.gDZ), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(38279);
            d.this.value = true;
            d.e(paramContext, paramBoolean2, paramString);
            if (paramBoolean1) {
              com.tencent.mm.plugin.report.service.h.OAn.b(14553, new Object[] { Integer.valueOf(1), Integer.valueOf(4), paramString });
            }
            AppMethodBeat.o(38279);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(38280);
            d.this.show();
            localPBool.value = false;
            d.a(paramContext, paramString, localPBool, d.this, true);
            if (paramBoolean1) {
              com.tencent.mm.plugin.report.service.h.OAn.b(14553, new Object[] { Integer.valueOf(1), Integer.valueOf(3), paramString });
            }
            if (paramRunnable != null) {
              paramRunnable.run();
            }
            AppMethodBeat.o(38280);
          }
        }, -1, R.e.alert_btn_color_warn);
      }
    }
    while (au.bvX(paramString))
    {
      Log.i("MicroMsg.ConvDelLogic", "del all qmessage");
      br.bCM();
      bh.bCz();
      com.tencent.mm.model.c.bzG().bxL("@qqim");
      AppMethodBeat.o(38287);
      return;
      ((ProgressDialog)localObject1).dismiss();
      k.a(paramContext, paramContext.getString(R.l.gIv), "", paramContext.getString(R.l.app_delete), paramContext.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(38281);
          d.a(d.this, paramString, localPBool, this.lAK, true);
          if (paramRunnable != null) {
            paramRunnable.run();
          }
          AppMethodBeat.o(38281);
        }
      }, null, R.e.alert_btn_color_warn);
      continue;
      if (au.bwg(paramString))
      {
        bh.bCz();
        com.tencent.mm.model.c.bzG().bxL(paramString);
        paramContext = new tc();
        paramContext.hWE.opType = 4;
        paramContext.hWE.hWJ = 20;
        paramContext.publish();
        com.tencent.mm.modelsimple.ac.aY(paramString, 15);
      }
      else if (au.bvW(paramString))
      {
        bh.bCz();
        com.tencent.mm.model.c.bzG().bxL(paramString);
        com.tencent.mm.modelsimple.ac.aY(paramString, 15);
      }
      else if (au.bvZ(paramString))
      {
        bh.bCz();
        com.tencent.mm.model.c.bzG().bxK(paramString);
        com.tencent.mm.modelsimple.ac.aY(paramString, 15);
      }
      else
      {
        Object localObject2;
        int i;
        if (g.MB(paramString))
        {
          bh.bCz();
          localObject1 = com.tencent.mm.model.c.bzD().aLF(paramString);
          bh.bCz();
          com.tencent.mm.model.c.bzz().d(new com.tencent.mm.ay.e(paramString, ((fi)localObject1).field_msgSvrId));
          localPBool.value = false;
          paramContext.getString(R.l.app_tip);
          localObject1 = k.a(paramContext, paramContext.getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              d.this.value = true;
            }
          });
          af.bHf();
          localObject2 = f.Ms(paramString);
          parambb = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(256800);
              d.a(d.this, paramString, parambb, localPBool, this.afmz);
              if (paramRunnable != null) {
                paramRunnable.run();
              }
              if (g.Mw(paramString)) {
                af.bHs().MK(paramString);
              }
              AppMethodBeat.o(256800);
            }
          };
          ((ProgressDialog)localObject1).dismiss();
          if (Util.isNullOrNil((String)localObject2))
          {
            if (au.bwp(paramString)) {}
            for (i = R.l.gIt;; i = R.l.gIs)
            {
              k.a(paramContext, paramContext.getString(i), "", paramContext.getString(R.l.app_delete), paramContext.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(256795);
                  d.this.run();
                  AppMethodBeat.o(256795);
                }
              }, null, R.e.alert_btn_color_warn);
              break;
            }
          }
          k.a(paramContext, paramContext.getString(R.l.gIs), "", paramContext.getString(R.l.app_delete), paramContext.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(38285);
              d.this.run();
              br.a(paramString, new br.a()
              {
                public final boolean aMJ()
                {
                  AppMethodBeat.i(256668);
                  if ((d.17.this.afmv.value) || (d.17.this.afmz == null) || (!d.17.this.afmz.isShowing()))
                  {
                    AppMethodBeat.o(256668);
                    return true;
                  }
                  AppMethodBeat.o(256668);
                  return false;
                }
                
                public final void aMK()
                {
                  AppMethodBeat.i(256671);
                  com.tencent.mm.an.a.e.V(d.17.this.adxW, false);
                  if (d.17.this.afmz != null) {
                    d.17.this.afmz.dismiss();
                  }
                  AppMethodBeat.o(256671);
                }
              });
              com.tencent.mm.modelsimple.ac.aY(paramString, 15);
              AppMethodBeat.o(38285);
            }
          }, null, R.e.alert_btn_color_warn);
        }
        else if (g.Dn(paramString))
        {
          localPBool.value = false;
          paramContext.getString(R.l.app_tip);
          parambb = k.a(paramContext, paramContext.getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              d.this.value = true;
            }
          });
          parambb.dismiss();
          k.a(paramContext, paramContext.getString(R.l.gIs), "", paramContext.getString(R.l.app_delete), paramContext.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(38273);
              br.a(d.this, new br.a()
              {
                public final boolean aMJ()
                {
                  AppMethodBeat.i(256655);
                  if ((d.2.this.afmv.value) || (d.2.this.lAK == null) || (!d.2.this.lAK.isShowing()))
                  {
                    AppMethodBeat.o(256655);
                    return true;
                  }
                  AppMethodBeat.o(256655);
                  return false;
                }
                
                public final void aMK()
                {
                  AppMethodBeat.i(256659);
                  com.tencent.mm.an.a.e.V(d.2.this.adxW, false);
                  if (d.2.this.lAK != null) {
                    d.2.this.lAK.dismiss();
                  }
                  AppMethodBeat.o(256659);
                }
              });
              com.tencent.mm.modelsimple.ac.aY(d.this, 15);
              AppMethodBeat.o(38273);
            }
          }, null, R.e.alert_btn_color_warn);
        }
        else
        {
          bh.bCz();
          localObject1 = com.tencent.mm.model.c.bzD().aLF(paramString);
          bh.bCz();
          com.tencent.mm.model.c.bzz().d(new com.tencent.mm.ay.e(paramString, ((fi)localObject1).field_msgSvrId));
          localPBool.value = false;
          paramContext.getString(R.l.app_tip);
          localObject2 = k.a(paramContext, paramContext.getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              d.this.value = true;
            }
          });
          localObject1 = null;
          if (!localPBool.value) {
            localObject1 = com.tencent.mm.pluginsdk.wallet.d.brY(paramString);
          }
          if (!Util.isNullOrNil((String)localObject1))
          {
            ((ProgressDialog)localObject2).dismiss();
            k.a(paramContext, false, paramContext.getString(R.l.gYC, new Object[] { localObject1 }), null, paramContext.getString(R.l.goto_conversation), paramContext.getString(R.l.gDZ), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(256551);
                d.this.value = true;
                d.e(paramContext, paramBoolean2, paramString);
                if (paramBoolean1) {
                  com.tencent.mm.plugin.report.service.h.OAn.b(14553, new Object[] { Integer.valueOf(0), Integer.valueOf(4), paramString });
                }
                AppMethodBeat.o(256551);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(256553);
                d.this.show();
                localPBool.value = false;
                d.a(paramContext, paramString, parambb, localPBool, d.this);
                if (paramRunnable != null) {
                  paramRunnable.run();
                }
                if (paramBoolean1) {
                  com.tencent.mm.plugin.report.service.h.OAn.b(14553, new Object[] { Integer.valueOf(0), Integer.valueOf(3), paramString });
                }
                AppMethodBeat.o(256553);
              }
            }, -1, R.e.alert_btn_color_warn);
          }
          else
          {
            ((ProgressDialog)localObject2).dismiss();
            i = R.l.gIs;
            if (au.bwp(paramString)) {
              i = R.l.gIt;
            }
            for (;;)
            {
              k.a(paramContext, paramContext.getString(i), "", paramContext.getString(R.l.app_delete), paramContext.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(256562);
                  d.a(d.this, paramString, parambb, localPBool, this.afmz);
                  if (paramRunnable != null) {
                    paramRunnable.run();
                  }
                  if (g.Mw(paramString)) {
                    af.bHs().MK(paramString);
                  }
                  if (au.bwp(paramString)) {
                    ad.iYN();
                  }
                  if (au.bwz(paramString))
                  {
                    bh.bCz();
                    paramAnonymousDialogInterface = com.tencent.mm.model.c.bzG().jaT().iterator();
                    while (paramAnonymousDialogInterface.hasNext())
                    {
                      bb localbb = (bb)paramAnonymousDialogInterface.next();
                      bh.bCz();
                      cc localcc = com.tencent.mm.model.c.bzD().aLF(localbb.field_username);
                      bh.bCz();
                      com.tencent.mm.model.c.bzz().d(new com.tencent.mm.ay.e(localbb.field_username, localcc.field_msgSvrId));
                      d.a(d.this, localbb.field_username, new PBool(), null, false);
                    }
                  }
                  AppMethodBeat.o(256562);
                }
              }, null, R.e.alert_btn_color_warn);
              break;
              if (au.bwz(paramString)) {
                i = R.l.gIu;
              }
            }
          }
        }
      }
    }
    if (au.bvV(paramString))
    {
      Log.i("MicroMsg.ConvDelLogic", "del all tmessage");
      br.bCN();
      bh.bCz();
      com.tencent.mm.model.c.bzG().bxL("@t.qq.com");
      AppMethodBeat.o(38287);
      return;
    }
    if (au.bwu(paramString))
    {
      Log.i("MicroMsg.ConvDelLogic", "del all notify message");
      ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).getFinderLiveNotifyExposureInfoStorage().eua();
    }
    AppMethodBeat.o(38287);
  }
  
  private static void nt(Context paramContext)
  {
    AppMethodBeat.i(256833);
    if (aw.jkS())
    {
      com.tencent.mm.br.c.g(paramContext, ".ui.EmptyActivity", new Intent());
      Log.i("MicroMsg.ConvDelLogic", "start empty activity");
    }
    AppMethodBeat.o(256833);
  }
  
  private static void report(String paramString)
  {
    AppMethodBeat.i(256838);
    bh.bCz();
    bb localbb = com.tencent.mm.model.c.bzG().bxM(paramString);
    if (localbb != null)
    {
      iq localiq = new iq();
      localiq.ioV = 15L;
      localiq.rT(paramString);
      localiq.iPK = com.tencent.mm.model.ac.Jj(paramString);
      localiq.ipl = localbb.field_unReadCount;
      localiq.bMH();
    }
    AppMethodBeat.o(256838);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.d
 * JD-Core Version:    0.7.0.1
 */