package com.tencent.mm.plugin.subapp.jdbiz;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.z;

final class a$2
  implements Runnable
{
  a$2(a parama, c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(25189);
    Object localObject = this.sWy;
    c localc = this.sWz;
    aw.aaz();
    int i = ((Integer)com.tencent.mm.model.c.Ru().get(15, Integer.valueOf(0))).intValue();
    if ((aw.Rc().foreground) && (1 == i))
    {
      localObject = d.dz(localc.jumpUrl, 5);
      JDRemindDialog.a(ah.getContext(), localc.sWL, localc.sWM, localc.sWN, (String)localObject, localc.sWB);
      h.qsU.e(11178, new Object[] { localObject, d.cGE().cGJ().sWB, Integer.valueOf(5) });
      AppMethodBeat.o(25189);
      return;
    }
    String str = d.dz(localc.jumpUrl, 4);
    Bundle localBundle = new Bundle();
    localBundle.putString("activity_id", localc.sWB);
    localBundle.putString("jump_url", str);
    ((aq)aw.getNotification()).a(37, ah.getContext().getString(2131297049), localc.sWK, str, "bizjd", localBundle);
    com.tencent.mm.sdk.b.a.ymk.c(((a)localObject).sWx);
    h.qsU.e(11178, new Object[] { str, d.cGE().cGJ().sWB, Integer.valueOf(4) });
    AppMethodBeat.o(25189);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.jdbiz.a.2
 * JD-Core Version:    0.7.0.1
 */