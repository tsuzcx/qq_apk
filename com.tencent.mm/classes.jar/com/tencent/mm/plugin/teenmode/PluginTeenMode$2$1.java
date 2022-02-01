package com.tencent.mm.plugin.teenmode;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.br;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.teenmode.a.a;
import com.tencent.mm.plugin.teenmode.a.d;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;

final class PluginTeenMode$2$1
  implements Runnable
{
  PluginTeenMode$2$1(PluginTeenMode.2 param2, String paramString1, String paramString2, int paramInt, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(278830);
    ((d)h.ax(d.class)).hEs();
    Object localObject2;
    if (z.bAM().equalsIgnoreCase(this.SUZ))
    {
      localObject2 = new cc();
      ((cc)localObject2).pI(0);
      ((cc)localObject2).setStatus(3);
      ((cc)localObject2).BS(this.SVa);
      ((cc)localObject2).setCreateTime(br.D(this.SVa, cn.bDu() / 1000L));
      localObject1 = ab.Jg(this.SVa);
      Resources localResources = MMApplicationContext.getResources();
      int i = a.g.SWR;
      if (localObject1 != null)
      {
        localObject1 = ((au)localObject1).aSV();
        ((cc)localObject2).setContent(localResources.getString(i, new Object[] { localObject1, ((d)h.ax(d.class)).aoi(this.SVb).gV(MMApplicationContext.getContext()), "<_wc_custom_link_ href='weixin://teenagerModeAgreenAuthorization/" + this.oHz + "'>", "</_wc_custom_link_>" }));
        ((cc)localObject2).setType(10000);
        ((cc)localObject2).setFlag(((fi)localObject2).field_flag | 0x8);
        br.B((cc)localObject2);
      }
    }
    for (Object localObject1 = ((n)h.ax(n.class)).gaZ().aU(this.SVa, this.oHz);; localObject1 = ((n)h.ax(n.class)).gaZ().aU(this.SUZ, this.oHz))
    {
      if ((localObject1 != null) && (!Util.isNullOrNil(((fi)localObject1).field_content)))
      {
        localObject2 = k.b.Hf(((fi)localObject1).field_content);
        if (localObject2 != null)
        {
          ((k.b)localObject2).title = (MMApplicationContext.getString(a.g.SWL) + ((k.b)localObject2).title);
          ((cc)localObject1).setContent(k.b.a((k.b)localObject2, null, null));
          br.C((cc)localObject1);
        }
      }
      AppMethodBeat.o(278830);
      return;
      localObject1 = "";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.PluginTeenMode.2.1
 * JD-Core Version:    0.7.0.1
 */