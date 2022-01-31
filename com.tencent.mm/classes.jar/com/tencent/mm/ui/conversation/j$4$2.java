package com.tencent.mm.ui.conversation;

import android.content.Intent;
import com.tencent.mm.ah.p;
import com.tencent.mm.c.i.a;
import com.tencent.mm.model.au;
import com.tencent.mm.protocal.c.bxs;
import com.tencent.mm.sdk.platformtools.y;

final class j$4$2
  implements Runnable
{
  j$4$2(j.4 param4) {}
  
  public final void run()
  {
    y.i("MicroMsg.InitHelper", "path:%s,apkMd5:%s", new Object[] { this.vTp.vTo.tNK, this.vTp.vTo.lnz });
    try
    {
      com.tencent.mm.network.c localc = au.Dk().edx.KR();
      if (localc == null) {
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      Object localObject1;
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.InitHelper", localThrowable, "", new Object[0]);
        localObject1 = null;
      }
      Object localObject3 = this.vTp.vTo.lnw.substring(0, this.vTp.vTo.lnw.lastIndexOf('/') + 1);
      Object localObject2 = this.vTp.vTo.lnw.substring(this.vTp.vTo.lnw.lastIndexOf('/') + 1);
      localObject3 = new com.tencent.mm.c.i((String)localObject3, this.vTp.vTo.versionCode);
      ((com.tencent.mm.c.i)localObject3).a(new i.a(this.vTp.vTo.lnA, this.vTp.vTo.lnz, this.vTp.vTo.bvC, (String)localObject2, this.vTp.vTo.gZD));
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("intent_short_ips", com.tencent.mm.pluginsdk.f.i.getShortIps());
      ((Intent)localObject2).putExtra("intent_client_version", com.tencent.mm.protocal.d.spa);
      ((Intent)localObject2).putExtra("intent_extra_session", localObject1.Dj());
      ((Intent)localObject2).putExtra("intent_extra_cookie", localObject1.KM());
      ((Intent)localObject2).putExtra("intent_extra_ecdhkey", localObject1.KO());
      ((Intent)localObject2).putExtra("intent_extra_uin", localObject1.CK());
      ((Intent)localObject2).putExtra("intent_update_type", 3);
      ((Intent)localObject2).putExtra("intent_extra_desc", this.vTp.vTo.bHk);
      ((Intent)localObject2).putExtra("intent_extra_md5", this.vTp.vTo.bvC);
      ((Intent)localObject2).putExtra("intent_extra_size", this.vTp.vTo.gZD);
      ((Intent)localObject2).putExtra("intent_extra_download_url", new String[] { this.vTp.vTo.lnw });
      ((Intent)localObject2).putExtra("intent_extra_patchInfo", ((com.tencent.mm.c.i)localObject3).st());
      ((Intent)localObject2).putExtra("intent_extra_updateMode", com.tencent.mm.sdk.platformtools.e.bvl);
      ((Intent)localObject2).putExtra("intent_extra_marketUrl", com.tencent.mm.sdk.platformtools.e.uej);
      ((Intent)localObject2).putExtra("intent_extra_extinfo", "<extinfo></extinfo>");
      ((Intent)localObject2).putExtra("intent_extra_tinker_patch", true);
      ((Intent)localObject2).putExtra("intent_extra_download_mode", 1);
      com.tencent.mm.plugin.w.d.bkt().t(j.a(this.vTp.vTn), (Intent)localObject2);
      com.tencent.mm.pluginsdk.f.i.clo();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.j.4.2
 * JD-Core Version:    0.7.0.1
 */