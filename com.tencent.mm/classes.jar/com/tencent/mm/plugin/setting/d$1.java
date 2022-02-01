package com.tencent.mm.plugin.setting;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
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
      paramObject = ((l)g.af(l.class)).aSN().bjF(paramMStorageEx);
      if ((paramObject != null) && (!c.oR(paramObject.field_type)) && (paramObject.arw()) && (!paramObject.arx())) {
        g.aAk().postToWorkerDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(73745);
            Object localObject = ((l)g.af(l.class)).aSN().Kn(paramMStorageEx);
            if ((localObject != null) && (!c.oR(((ax)localObject).field_type)) && (((as)localObject).arw()) && (!((as)localObject).arx()))
            {
              localObject = new ca();
              ((ca)localObject).nv(0);
              ((ca)localObject).Cy(paramMStorageEx);
              ((ca)localObject).setStatus(6);
              ((ca)localObject).setContent(MMApplicationContext.getContext().getString(2131765420));
              ((ca)localObject).setCreateTime(bp.C(paramMStorageEx, System.currentTimeMillis() / 1000L));
              ((ca)localObject).setType(10000);
              ((l)g.af(l.class)).eiy().aC((ca)localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.d.1
 * JD-Core Version:    0.7.0.1
 */