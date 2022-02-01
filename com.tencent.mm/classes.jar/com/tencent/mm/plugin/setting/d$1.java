package com.tencent.mm.plugin.setting;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bq;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;

final class d$1
  implements MStorageEx.IOnStorageChange
{
  d$1(d paramd) {}
  
  public final void onNotifyChange(int paramInt, final MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(73746);
    if (paramInt == 2)
    {
      paramMStorageEx = (String)paramObject;
      paramObject = ((n)h.ae(n.class)).bbL().bwc(paramMStorageEx);
      if ((paramObject != null) && (!com.tencent.mm.contact.d.rk(paramObject.field_type)) && (paramObject.aya()) && (!paramObject.ayb())) {
        h.aHJ().postToWorkerDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(73745);
            Object localObject = ((n)h.ae(n.class)).bbL().RG(paramMStorageEx);
            if ((localObject != null) && (!com.tencent.mm.contact.d.rk(((ax)localObject).field_type)) && (((as)localObject).aya()) && (!((as)localObject).ayb()))
            {
              localObject = new ca();
              ((ca)localObject).pJ(0);
              ((ca)localObject).Jm(paramMStorageEx);
              ((ca)localObject).setStatus(6);
              ((ca)localObject).setContent(MMApplicationContext.getContext().getString(b.i.settings_jump_to_verifypage_tips));
              ((ca)localObject).setCreateTime(bq.z(paramMStorageEx, System.currentTimeMillis() / 1000L));
              ((ca)localObject).setType(10000);
              ((n)h.ae(n.class)).eSe().aM((ca)localObject);
              Log.i("MicroMsg.SubCoreSetting", "insert chatcontact verify sysmsg. %s", new Object[] { paramMStorageEx });
            }
            AppMethodBeat.o(73745);
          }
        }, 5000L);
      }
    }
    AppMethodBeat.o(73746);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.d.1
 * JD-Core Version:    0.7.0.1
 */