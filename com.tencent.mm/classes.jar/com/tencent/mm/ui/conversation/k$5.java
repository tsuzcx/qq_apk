package com.tencent.mm.ui.conversation;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.d.a;
import com.tencent.mm.d.i.a;
import com.tencent.mm.model.az;
import com.tencent.mm.network.e;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.protocal.protobuf.dbz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;

final class k$5
  implements Runnable
{
  k$5(k paramk, dbz paramdbz) {}
  
  public final void run()
  {
    AppMethodBeat.i(38598);
    if ((this.HeK != null) && (this.HeK.syL.equalsIgnoreCase(com.tencent.mm.pluginsdk.g.i.hg(aj.getContext()))))
    {
      if ((com.tencent.mm.vfs.i.eK(this.HeK.EtF)) && (a.em(this.HeK.EtF)))
      {
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(38596);
            if ((k.i(k.5.this.HeJ) != null) && (k.i(k.5.this.HeJ).isShowing()))
            {
              ad.i("MicroMsg.InitHelper", "update dialog is showing.");
              AppMethodBeat.o(38596);
              return;
            }
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(614L, 60L, 1L, false);
            k.a(k.5.this.HeJ, com.tencent.mm.ui.base.h.a(k.a(k.5.this.HeJ), k.5.this.HeK.bLg, k.5.this.HeK.title, k.5.this.HeK.EtG, k.5.this.HeK.sne, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(38594);
                r.b(k.a(k.5.this.HeJ), k.5.this.HeK.EtF, null, false);
                com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(614L, 50L, 1L, false);
                paramAnonymous2DialogInterface.dismiss();
                AppMethodBeat.o(38594);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(38595);
                com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(614L, 57L, 1L, false);
                paramAnonymous2DialogInterface.dismiss();
                AppMethodBeat.o(38595);
              }
            }));
            com.tencent.mm.pluginsdk.g.i.ewk();
            AppMethodBeat.o(38596);
          }
        });
        AppMethodBeat.o(38598);
        return;
      }
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(38597);
          ad.i("MicroMsg.InitHelper", "path:%s,apkMd5:%s", new Object[] { k.5.this.HeK.EtF, k.5.this.HeK.syK });
          try
          {
            com.tencent.mm.network.c localc = az.aeS().gVH.avg();
            if (localc == null)
            {
              AppMethodBeat.o(38597);
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
            Object localObject3 = k.5.this.HeK.syH.substring(0, k.5.this.HeK.syH.lastIndexOf('/') + 1);
            Object localObject2 = k.5.this.HeK.syH.substring(k.5.this.HeK.syH.lastIndexOf('/') + 1);
            localObject3 = new com.tencent.mm.d.i((String)localObject3, k.5.this.HeK.versionCode);
            ((com.tencent.mm.d.i)localObject3).a(new i.a(k.5.this.HeK.syL, k.5.this.HeK.syK, k.5.this.HeK.patchMd5, (String)localObject2, k.5.this.HeK.lsc));
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("intent_short_ips", com.tencent.mm.pluginsdk.g.i.getShortIps());
            ((Intent)localObject2).putExtra("intent_client_version", com.tencent.mm.protocal.d.CpK);
            ((Intent)localObject2).putExtra("intent_extra_session", localObject1.mq(1));
            ((Intent)localObject2).putExtra("intent_extra_cookie", localObject1.auZ());
            ((Intent)localObject2).putExtra("intent_extra_ecdhkey", localObject1.avb());
            ((Intent)localObject2).putExtra("intent_extra_uin", localObject1.getUin());
            ((Intent)localObject2).putExtra("intent_update_type", 3);
            ((Intent)localObject2).putExtra("intent_extra_desc", k.5.this.HeK.bLg);
            ((Intent)localObject2).putExtra("intent_extra_md5", k.5.this.HeK.patchMd5);
            ((Intent)localObject2).putExtra("intent_extra_size", k.5.this.HeK.lsc);
            ((Intent)localObject2).putExtra("intent_extra_download_url", new String[] { k.5.this.HeK.syH });
            ((Intent)localObject2).putExtra("intent_extra_patchInfo", ((com.tencent.mm.d.i)localObject3).Kk());
            ((Intent)localObject2).putExtra("intent_extra_updateMode", com.tencent.mm.sdk.platformtools.i.cJT);
            ((Intent)localObject2).putExtra("intent_extra_marketUrl", com.tencent.mm.sdk.platformtools.i.ETv);
            ((Intent)localObject2).putExtra("intent_extra_extinfo", "<extinfo></extinfo>");
            ((Intent)localObject2).putExtra("intent_extra_tinker_patch", true);
            ((Intent)localObject2).putExtra("intent_extra_download_mode", 1);
            com.tencent.mm.plugin.q.d.cRq().J(k.a(k.5.this.HeJ), (Intent)localObject2);
            com.tencent.mm.pluginsdk.g.i.ewk();
            AppMethodBeat.o(38597);
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