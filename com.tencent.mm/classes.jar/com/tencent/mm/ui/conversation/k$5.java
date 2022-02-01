package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.d.i.a;
import com.tencent.mm.model.ba;
import com.tencent.mm.network.e;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.protocal.protobuf.dna;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;

final class k$5
  implements Runnable
{
  k$5(k paramk, dna paramdna) {}
  
  public final void run()
  {
    AppMethodBeat.i(38598);
    if ((this.Kwa != null) && (this.Kwa.uJi.equalsIgnoreCase(com.tencent.mm.pluginsdk.i.j.hw(aj.getContext()))))
    {
      if ((com.tencent.mm.vfs.i.fv(this.Kwa.HBm)) && (com.tencent.mm.d.a.eW(this.Kwa.HBm)))
      {
        com.tencent.e.h.LTJ.aP(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(38596);
            if ((k.i(k.5.this.KvZ) != null) && (k.i(k.5.this.KvZ).isShowing()))
            {
              ad.i("MicroMsg.InitHelper", "update dialog is showing.");
              AppMethodBeat.o(38596);
              return;
            }
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(614L, 60L, 1L, false);
            k.a(k.5.this.KvZ, com.tencent.mm.ui.base.h.a(k.a(k.5.this.KvZ), k.5.this.Kwa.msg, k.5.this.Kwa.title, k.5.this.Kwa.HBn, k.5.this.Kwa.utw, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(38594);
                r.b(k.a(k.5.this.KvZ), k.5.this.Kwa.HBm, null, false);
                com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(614L, 50L, 1L, false);
                paramAnonymous2DialogInterface.dismiss();
                AppMethodBeat.o(38594);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(38595);
                com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(614L, 57L, 1L, false);
                paramAnonymous2DialogInterface.dismiss();
                ((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.updater.a.a.class)).setFullCheckUpdateRedDot(k.5.this.Kwa.HBo);
                AppMethodBeat.o(38595);
              }
            }));
            com.tencent.mm.pluginsdk.i.j.faB();
            AppMethodBeat.o(38596);
          }
        });
        AppMethodBeat.o(38598);
        return;
      }
      if (((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.updater.a.a.class)).openUpdater())
      {
        com.tencent.e.h.LTJ.aP(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(38597);
            if ((k.i(k.5.this.KvZ) != null) && (k.i(k.5.this.KvZ).isShowing()))
            {
              ad.i("MicroMsg.InitHelper", "update dialog is showing.");
              AppMethodBeat.o(38597);
              return;
            }
            ad.i("MicroMsg.InitHelper", "show update dialog");
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(614L, 60L, 1L, false);
            f.a locala = new f.a(aj.getContext());
            locala.aXO(aj.getContext().getString(2131767001));
            locala.afp(2131766990);
            locala.yU(true);
            locala.c(new f.c()
            {
              public final void d(boolean paramAnonymous2Boolean, String paramAnonymous2String)
              {
                AppMethodBeat.i(194681);
                ad.i("MicroMsg.InitHelper", "onDialogClick %s", new Object[] { Boolean.valueOf(paramAnonymous2Boolean) });
                if (paramAnonymous2Boolean)
                {
                  k.aey(k.5.this.Kwa.HBo);
                  com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(614L, 50L, 1L, false);
                }
                AppMethodBeat.o(194681);
              }
            });
            locala.b(new DialogInterface.OnDismissListener()
            {
              public final void onDismiss(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(194682);
                com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(614L, 57L, 1L, false);
                ((com.tencent.mm.plugin.updater.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.updater.a.a.class)).setFullCheckUpdateRedDot(k.5.this.Kwa.HBo);
                AppMethodBeat.o(194682);
              }
            });
            k.a(k.5.this.KvZ, locala.jcs);
            k.i(k.5.this.KvZ).show();
            AppMethodBeat.o(38597);
          }
        });
        AppMethodBeat.o(38598);
        return;
      }
      com.tencent.e.h.LTJ.aP(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(194683);
          ad.i("MicroMsg.InitHelper", "path:%s,apkMd5:%s", new Object[] { k.5.this.Kwa.HBm, k.5.this.Kwa.uJh });
          try
          {
            com.tencent.mm.network.c localc = ba.aiU().hOv.aFc();
            if (localc == null)
            {
              AppMethodBeat.o(194683);
              return;
            }
          }
          catch (Throwable localThrowable)
          {
            Object localObject1;
            for (;;)
            {
              ad.printErrStackTrace("MicroMsg.InitHelper", localThrowable, "", new Object[0]);
              localObject1 = null;
            }
            Object localObject3 = k.5.this.Kwa.gHx.substring(0, k.5.this.Kwa.gHx.lastIndexOf('/') + 1);
            Object localObject2 = k.5.this.Kwa.gHx.substring(k.5.this.Kwa.gHx.lastIndexOf('/') + 1);
            localObject3 = new com.tencent.mm.d.i((String)localObject3, k.5.this.Kwa.versionCode);
            ((com.tencent.mm.d.i)localObject3).a(new i.a(k.5.this.Kwa.uJi, k.5.this.Kwa.uJh, k.5.this.Kwa.patchMd5, (String)localObject2, k.5.this.Kwa.mtM));
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("intent_short_ips", com.tencent.mm.pluginsdk.i.j.getShortIps());
            ((Intent)localObject2).putExtra("intent_client_version", com.tencent.mm.protocal.d.Fnj);
            ((Intent)localObject2).putExtra("intent_extra_session", localObject1.mO(1));
            ((Intent)localObject2).putExtra("intent_extra_cookie", localObject1.aEV());
            ((Intent)localObject2).putExtra("intent_extra_ecdhkey", localObject1.aEX());
            ((Intent)localObject2).putExtra("intent_extra_uin", localObject1.getUin());
            ((Intent)localObject2).putExtra("intent_update_type", 3);
            ((Intent)localObject2).putExtra("intent_extra_desc", k.5.this.Kwa.msg);
            ((Intent)localObject2).putExtra("intent_extra_md5", k.5.this.Kwa.patchMd5);
            ((Intent)localObject2).putExtra("intent_extra_size", k.5.this.Kwa.mtM);
            ((Intent)localObject2).putExtra("intent_extra_download_url", new String[] { k.5.this.Kwa.gHx });
            ((Intent)localObject2).putExtra("intent_extra_patchInfo", ((com.tencent.mm.d.i)localObject3).Lt());
            ((Intent)localObject2).putExtra("intent_extra_updateMode", com.tencent.mm.sdk.platformtools.j.cSe);
            ((Intent)localObject2).putExtra("intent_extra_marketUrl", com.tencent.mm.sdk.platformtools.j.Icw);
            ((Intent)localObject2).putExtra("intent_extra_extinfo", "<extinfo></extinfo>");
            ((Intent)localObject2).putExtra("intent_extra_tinker_patch", true);
            ((Intent)localObject2).putExtra("intent_extra_download_mode", 1);
            com.tencent.mm.plugin.q.d.doy().Z(k.a(k.5.this.KvZ), (Intent)localObject2);
            com.tencent.mm.pluginsdk.i.j.faB();
            AppMethodBeat.o(194683);
          }
        }
      });
    }
    AppMethodBeat.o(38598);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.k.5
 * JD-Core Version:    0.7.0.1
 */