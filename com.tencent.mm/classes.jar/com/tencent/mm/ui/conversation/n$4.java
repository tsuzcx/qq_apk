package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.am.s;
import com.tencent.mm.d.h.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.pluginsdk.model.app.v;
import com.tencent.mm.protocal.protobuf.fne;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.a.g.c;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i;

final class n$4
  implements Runnable
{
  n$4(n paramn, fne paramfne) {}
  
  public final void run()
  {
    AppMethodBeat.i(38598);
    if (((this.afqh != null) && (this.afqh.JEM.equalsIgnoreCase(com.tencent.mm.pluginsdk.platformtools.g.ju(MMApplicationContext.getContext())))) || ((this.afqh != null) && (this.afqh.hDq == 4)))
    {
      if ((this.afqh != null) && (this.afqh.hDq == 4)) {
        Log.i("MicroMsg.InitHelper", "checkTinkerBoostInstall, HdiffApk, oldApkMd5 is equal?: %s", new Object[] { Boolean.valueOf(this.afqh.JEM.equalsIgnoreCase(com.tencent.mm.pluginsdk.platformtools.g.ju(MMApplicationContext.getContext()))) });
      }
      if ((y.ZC(this.afqh.abNl)) && (com.tencent.mm.d.a.hZ(this.afqh.abNl)))
      {
        com.tencent.threadpool.h.ahAA.bk(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(38596);
            if ((n.i(n.4.this.afqg) != null) && (n.i(n.4.this.afqg).isShowing()))
            {
              Log.i("MicroMsg.InitHelper", "update dialog is showing.");
              AppMethodBeat.o(38596);
              return;
            }
            if (n.4.this.afqh.hDq == 4)
            {
              com.tencent.mm.plugin.hp.a.c.t(121, -100, 0L);
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(614L, 121L, 1L, false);
            }
            for (;;)
            {
              n.a(n.4.this.afqg, k.a(n.a(n.4.this.afqg), n.4.this.afqh.msg, n.4.this.afqh.title, n.4.this.afqh.abNm, n.4.this.afqh.IVk, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(38594);
                  v.b(n.a(n.4.this.afqg), n.4.this.afqh.abNl, null, false);
                  if (n.4.this.afqh.hDq != 4) {
                    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(614L, 50L, 1L, false);
                  }
                  for (;;)
                  {
                    paramAnonymous2DialogInterface.dismiss();
                    AppMethodBeat.o(38594);
                    return;
                    com.tencent.mm.plugin.hp.a.c.t(123, -100, 0L);
                    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(614L, 123L, 1L, false);
                  }
                }
              }, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(38595);
                  if (n.4.this.afqh.hDq != 4) {
                    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(614L, 57L, 1L, false);
                  }
                  for (;;)
                  {
                    paramAnonymous2DialogInterface.dismiss();
                    if (((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.updater.a.a.class)).openUpdater()) {
                      ((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.updater.a.a.class)).setFullCheckUpdateRedDot(n.4.this.afqh.abNn);
                    }
                    AppMethodBeat.o(38595);
                    return;
                    com.tencent.mm.plugin.hp.a.c.t(122, -100, 0L);
                    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(614L, 122L, 1L, false);
                  }
                }
              }));
              com.tencent.mm.pluginsdk.platformtools.g.fQs();
              AppMethodBeat.o(38596);
              return;
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(614L, 60L, 1L, false);
            }
          }
        });
        AppMethodBeat.o(38598);
        return;
      }
      if (((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.updater.a.a.class)).openUpdater())
      {
        com.tencent.threadpool.h.ahAA.bk(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(38597);
            if ((n.i(n.4.this.afqg) != null) && (n.i(n.4.this.afqg).isShowing()))
            {
              Log.i("MicroMsg.InitHelper", "update dialog is showing.");
              AppMethodBeat.o(38597);
              return;
            }
            Log.i("MicroMsg.InitHelper", "show update dialog");
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1429L, 27L, 1L, false);
            g.a locala = new g.a(MMApplicationContext.getContext());
            locala.bDE(MMApplicationContext.getContext().getString(R.l.updater_tip));
            locala.aEX(R.l.updater_confirm);
            locala.NF(true);
            locala.c(new g.c()
            {
              public final void onDialogClick(boolean paramAnonymous2Boolean, String paramAnonymous2String)
              {
                AppMethodBeat.i(256488);
                Log.i("MicroMsg.InitHelper", "onDialogClick %s", new Object[] { Boolean.valueOf(paramAnonymous2Boolean) });
                if (paramAnonymous2Boolean)
                {
                  n.aDF(n.4.this.afqh.abNn);
                  com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1429L, 28L, 1L, false);
                }
                AppMethodBeat.o(256488);
              }
            });
            locala.d(new DialogInterface.OnDismissListener()
            {
              public final void onDismiss(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(256486);
                ((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.updater.a.a.class)).setFullCheckUpdateRedDot(n.4.this.afqh.abNn);
                com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1429L, 29L, 1L, false);
                AppMethodBeat.o(256486);
              }
            });
            locala.show();
            n.a(n.4.this.afqg, locala.pRv);
            com.tencent.mm.pluginsdk.platformtools.g.fQs();
            AppMethodBeat.o(38597);
          }
        });
        AppMethodBeat.o(38598);
        return;
      }
      com.tencent.threadpool.h.ahAA.bk(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(256776);
          Log.i("MicroMsg.InitHelper", "path:%s,apkMd5:%s", new Object[] { n.4.this.afqh.abNl, n.4.this.afqh.JEL });
          try
          {
            com.tencent.mm.network.e locale = bh.aZW().oun.bGg();
            if (locale == null)
            {
              AppMethodBeat.o(256776);
              return;
            }
          }
          finally
          {
            Object localObject1;
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.InitHelper", localThrowable, "", new Object[0]);
              localObject1 = null;
            }
            Object localObject3 = n.4.this.afqh.mOI.substring(0, n.4.this.afqh.mOI.lastIndexOf('/') + 1);
            Object localObject2 = n.4.this.afqh.mOI.substring(n.4.this.afqh.mOI.lastIndexOf('/') + 1);
            localObject3 = new com.tencent.mm.d.h((String)localObject3, n.4.this.afqh.versionCode);
            ((com.tencent.mm.d.h)localObject3).a(new h.a(n.4.this.afqh.JEM, n.4.this.afqh.JEL, n.4.this.afqh.patchMd5, (String)localObject2, n.4.this.afqh.tQE));
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("intent_short_ips", com.tencent.mm.pluginsdk.platformtools.g.getShortIps());
            ((Intent)localObject2).putExtra("intent_client_version", com.tencent.mm.protocal.d.Yxh);
            ((Intent)localObject2).putExtra("intent_extra_session", localObject1.sA(1));
            ((Intent)localObject2).putExtra("intent_extra_cookie", localObject1.bFZ());
            ((Intent)localObject2).putExtra("intent_extra_ecdhkey", localObject1.bGb());
            ((Intent)localObject2).putExtra("intent_extra_uin", localObject1.getUin());
            ((Intent)localObject2).putExtra("intent_update_type", 3);
            ((Intent)localObject2).putExtra("intent_extra_desc", n.4.this.afqh.msg);
            ((Intent)localObject2).putExtra("intent_extra_md5", n.4.this.afqh.patchMd5);
            ((Intent)localObject2).putExtra("intent_extra_size", n.4.this.afqh.tQE);
            ((Intent)localObject2).putExtra("intent_extra_download_url", new String[] { n.4.this.afqh.mOI });
            ((Intent)localObject2).putExtra("intent_extra_patchInfo", ((com.tencent.mm.d.h)localObject3).aBN());
            ((Intent)localObject2).putExtra("intent_extra_updateMode", ChannelUtil.updateMode);
            ((Intent)localObject2).putExtra("intent_extra_marketUrl", ChannelUtil.marketURL);
            ((Intent)localObject2).putExtra("intent_extra_extinfo", "<extinfo></extinfo>");
            ((Intent)localObject2).putExtra("intent_extra_tinker_patch", true);
            ((Intent)localObject2).putExtra("intent_extra_download_mode", 1);
            com.tencent.mm.plugin.y.d.gdL().aC(n.a(n.4.this.afqg), (Intent)localObject2);
            com.tencent.mm.pluginsdk.platformtools.g.fQs();
            AppMethodBeat.o(256776);
          }
        }
      });
    }
    AppMethodBeat.o(38598);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.n.4
 * JD-Core Version:    0.7.0.1
 */