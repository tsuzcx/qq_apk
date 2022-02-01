package com.tencent.mm.ui.conversation;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.d.a;
import com.tencent.mm.d.i.a;
import com.tencent.mm.model.az;
import com.tencent.mm.network.e;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.protocal.protobuf.dhl;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;

final class k$5
  implements Runnable
{
  k$5(k paramk, dhl paramdhl) {}
  
  public final void run()
  {
    AppMethodBeat.i(38598);
    if ((this.IEX != null) && (this.IEX.tGv.equalsIgnoreCase(com.tencent.mm.pluginsdk.g.i.hr(ai.getContext()))))
    {
      if ((com.tencent.mm.vfs.i.eA(this.IEX.FQH)) && (a.eb(this.IEX.FQH)))
      {
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(38596);
            if ((k.i(k.5.this.IEW) != null) && (k.i(k.5.this.IEW).isShowing()))
            {
              ac.i("MicroMsg.InitHelper", "update dialog is showing.");
              AppMethodBeat.o(38596);
              return;
            }
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(614L, 60L, 1L, false);
            k.a(k.5.this.IEW, com.tencent.mm.ui.base.h.a(k.a(k.5.this.IEW), k.5.this.IEX.bIO, k.5.this.IEX.title, k.5.this.IEX.FQI, k.5.this.IEX.tuX, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(38594);
                r.b(k.a(k.5.this.IEW), k.5.this.IEX.FQH, null, false);
                com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(614L, 50L, 1L, false);
                paramAnonymous2DialogInterface.dismiss();
                AppMethodBeat.o(38594);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(38595);
                com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(614L, 57L, 1L, false);
                paramAnonymous2DialogInterface.dismiss();
                AppMethodBeat.o(38595);
              }
            }));
            com.tencent.mm.pluginsdk.g.i.eLE();
            AppMethodBeat.o(38596);
          }
        });
        AppMethodBeat.o(38598);
        return;
      }
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(38597);
          ac.i("MicroMsg.InitHelper", "path:%s,apkMd5:%s", new Object[] { k.5.this.IEX.FQH, k.5.this.IEX.tGu });
          try
          {
            com.tencent.mm.network.c localc = az.agi().hwg.aBZ();
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
              ac.printErrStackTrace("MicroMsg.InitHelper", localThrowable, "", new Object[0]);
              localObject1 = null;
            }
            Object localObject3 = k.5.this.IEX.gnO.substring(0, k.5.this.IEX.gnO.lastIndexOf('/') + 1);
            Object localObject2 = k.5.this.IEX.gnO.substring(k.5.this.IEX.gnO.lastIndexOf('/') + 1);
            localObject3 = new com.tencent.mm.d.i((String)localObject3, k.5.this.IEX.versionCode);
            ((com.tencent.mm.d.i)localObject3).a(new i.a(k.5.this.IEX.tGv, k.5.this.IEX.tGu, k.5.this.IEX.patchMd5, (String)localObject2, k.5.this.IEX.lTX));
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("intent_short_ips", com.tencent.mm.pluginsdk.g.i.getShortIps());
            ((Intent)localObject2).putExtra("intent_client_version", com.tencent.mm.protocal.d.DIc);
            ((Intent)localObject2).putExtra("intent_extra_session", localObject1.mp(1));
            ((Intent)localObject2).putExtra("intent_extra_cookie", localObject1.aBS());
            ((Intent)localObject2).putExtra("intent_extra_ecdhkey", localObject1.aBU());
            ((Intent)localObject2).putExtra("intent_extra_uin", localObject1.getUin());
            ((Intent)localObject2).putExtra("intent_update_type", 3);
            ((Intent)localObject2).putExtra("intent_extra_desc", k.5.this.IEX.bIO);
            ((Intent)localObject2).putExtra("intent_extra_md5", k.5.this.IEX.patchMd5);
            ((Intent)localObject2).putExtra("intent_extra_size", k.5.this.IEX.lTX);
            ((Intent)localObject2).putExtra("intent_extra_download_url", new String[] { k.5.this.IEX.gnO });
            ((Intent)localObject2).putExtra("intent_extra_patchInfo", ((com.tencent.mm.d.i)localObject3).JU());
            ((Intent)localObject2).putExtra("intent_extra_updateMode", com.tencent.mm.sdk.platformtools.i.cHa);
            ((Intent)localObject2).putExtra("intent_extra_marketUrl", com.tencent.mm.sdk.platformtools.i.GqI);
            ((Intent)localObject2).putExtra("intent_extra_extinfo", "<extinfo></extinfo>");
            ((Intent)localObject2).putExtra("intent_extra_tinker_patch", true);
            ((Intent)localObject2).putExtra("intent_extra_download_mode", 1);
            com.tencent.mm.plugin.q.d.dfa().X(k.a(k.5.this.IEW), (Intent)localObject2);
            com.tencent.mm.pluginsdk.g.i.eLE();
            AppMethodBeat.o(38597);
          }
        }
      });
    }
    AppMethodBeat.o(38598);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.k.5
 * JD-Core Version:    0.7.0.1
 */