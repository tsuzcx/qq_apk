package com.tencent.mm.plugin.nearby.model;

import android.content.Context;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.np;
import com.tencent.mm.autogen.a.nq;
import com.tencent.mm.autogen.a.nq.a;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.br.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.nearby.b.g;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.bz;
import com.tencent.mm.storage.ca;

class SubCoreNearby$1
  extends IListener<nq>
{
  SubCoreNearby$1(f paramf, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(262797);
    this.__eventId = nq.class.getName().hashCode();
    AppMethodBeat.o(262797);
  }
  
  private static boolean a(nq paramnq)
  {
    int i = 3;
    AppMethodBeat.i(89776);
    Object localObject = paramnq.hQb.hQc;
    paramnq = paramnq.hQb.hzO;
    if ((((br.b)localObject).olW != null) && (((br.b)localObject).scene == 1))
    {
      h.baE().ban().B(73729, Integer.valueOf(1));
      bz localbz = new bz();
      localbz.field_content = paramnq.field_content;
      localbz.field_createtime = Util.nowSecond();
      localbz.field_imgpath = "";
      localbz.field_sayhicontent = MMApplicationContext.getContext().getString(b.g.Mov);
      localbz.field_sayhiuser = paramnq.field_talker;
      localbz.field_scene = 18;
      if (paramnq.field_status > 3) {
        i = paramnq.field_status;
      }
      localbz.field_status = i;
      localbz.field_svrid = paramnq.field_msgSvrId;
      localbz.field_talker = paramnq.field_talker;
      localbz.field_type = 34;
      localbz.field_isSend = 0;
      localbz.field_sayhiencryptuser = paramnq.field_talker;
      localbz.field_ticket = ((br.b)localObject).olW;
      h.baC().aZJ();
      ((ca)((n)h.ax(n.class)).gaW()).a(localbz);
      localObject = new np();
      ((np)localObject).hPZ.hQa = paramnq.field_talker;
      ((np)localObject).publish();
    }
    AppMethodBeat.o(89776);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.model.SubCoreNearby.1
 * JD-Core Version:    0.7.0.1
 */