package com.tencent.mm.ui.conversation;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.c.i.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.network.e;
import com.tencent.mm.protocal.protobuf.ckf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.g;

final class j$5$2
  implements Runnable
{
  j$5$2(j.5 param5) {}
  
  public final void run()
  {
    AppMethodBeat.i(34469);
    ab.i("MicroMsg.InitHelper", "path:%s,apkMd5:%s", new Object[] { this.Alh.Alg.xUk, this.Alh.Alg.nKS });
    try
    {
      com.tencent.mm.network.c localc = aw.Rc().ftA.adI();
      if (localc == null)
      {
        AppMethodBeat.o(34469);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      Object localObject1;
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.InitHelper", localThrowable, "", new Object[0]);
        localObject1 = null;
      }
      Object localObject3 = this.Alh.Alg.nKP.substring(0, this.Alh.Alg.nKP.lastIndexOf('/') + 1);
      Object localObject2 = this.Alh.Alg.nKP.substring(this.Alh.Alg.nKP.lastIndexOf('/') + 1);
      localObject3 = new com.tencent.mm.c.i((String)localObject3, this.Alh.Alg.versionCode);
      ((com.tencent.mm.c.i)localObject3).a(new i.a(this.Alh.Alg.nKT, this.Alh.Alg.nKS, this.Alh.Alg.bWN, (String)localObject2, this.Alh.Alg.iHT));
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("intent_short_ips", com.tencent.mm.pluginsdk.f.i.getShortIps());
      ((Intent)localObject2).putExtra("intent_client_version", com.tencent.mm.protocal.d.whH);
      ((Intent)localObject2).putExtra("intent_extra_session", localObject1.jN(1));
      ((Intent)localObject2).putExtra("intent_extra_cookie", localObject1.adB());
      ((Intent)localObject2).putExtra("intent_extra_ecdhkey", localObject1.adD());
      ((Intent)localObject2).putExtra("intent_extra_uin", localObject1.getUin());
      ((Intent)localObject2).putExtra("intent_update_type", 3);
      ((Intent)localObject2).putExtra("intent_extra_desc", this.Alh.Alg.bjm);
      ((Intent)localObject2).putExtra("intent_extra_md5", this.Alh.Alg.bWN);
      ((Intent)localObject2).putExtra("intent_extra_size", this.Alh.Alg.iHT);
      ((Intent)localObject2).putExtra("intent_extra_download_url", new String[] { this.Alh.Alg.nKP });
      ((Intent)localObject2).putExtra("intent_extra_patchInfo", ((com.tencent.mm.c.i)localObject3).AK());
      ((Intent)localObject2).putExtra("intent_extra_updateMode", g.bWw);
      ((Intent)localObject2).putExtra("intent_extra_marketUrl", g.ymK);
      ((Intent)localObject2).putExtra("intent_extra_extinfo", "<extinfo></extinfo>");
      ((Intent)localObject2).putExtra("intent_extra_tinker_patch", true);
      ((Intent)localObject2).putExtra("intent_extra_download_mode", 1);
      com.tencent.mm.plugin.p.d.bSu().w(j.a(this.Alh.Alf), (Intent)localObject2);
      com.tencent.mm.pluginsdk.f.i.dlY();
      AppMethodBeat.o(34469);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.j.5.2
 * JD-Core Version:    0.7.0.1
 */