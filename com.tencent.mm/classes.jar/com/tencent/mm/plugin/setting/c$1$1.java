package com.tencent.mm.plugin.setting;

import android.content.Context;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;

final class c$1$1
  implements Runnable
{
  c$1$1(c.1 param1, String paramString) {}
  
  public final void run()
  {
    Object localObject = ((j)com.tencent.mm.kernel.g.r(j.class)).Fw().abl(this.egy);
    if ((localObject != null) && (!a.gR(((ao)localObject).field_type)) && (((ad)localObject).Be()) && (!((ad)localObject).Bf()))
    {
      localObject = new bi();
      ((bi)localObject).fA(0);
      ((bi)localObject).ec(this.egy);
      ((bi)localObject).setStatus(6);
      ((bi)localObject).setContent(ae.getContext().getString(a.i.settings_jump_to_verifypage_tips));
      ((bi)localObject).bg(com.tencent.mm.model.bd.o(this.egy, System.currentTimeMillis() / 1000L));
      ((bi)localObject).setType(10000);
      ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().T((bi)localObject);
      y.i("MicroMsg.SubCoreSetting", "insert chatcontact verify sysmsg. %s", new Object[] { this.egy });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.c.1.1
 * JD-Core Version:    0.7.0.1
 */