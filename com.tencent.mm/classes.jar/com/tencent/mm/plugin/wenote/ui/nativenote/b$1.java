package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.a.q;
import com.tencent.mm.plugin.wenote.model.c;
import com.tencent.mm.plugin.wenote.model.d;
import com.tencent.mm.plugin.wenote.model.g;
import com.tencent.mm.plugin.wenote.model.j;
import com.tencent.mm.protocal.protobuf.acs;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;

final class b$1
  implements View.OnClickListener
{
  b$1(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(27112);
    ab.i("WNNoteBanner", "click WNNoteBanner");
    paramView = com.tencent.mm.plugin.wenote.model.nativenote.manager.h.diI().diJ();
    if (paramView == null)
    {
      ab.i("WNNoteBanner", "keepTopItem is null");
      this.vCM.setVisibility(8);
      AppMethodBeat.o(27112);
      return;
    }
    if (paramView.vxu)
    {
      if (paramView.muU) {
        com.tencent.mm.plugin.report.service.h.qsU.e(14789, new Object[] { Integer.valueOf(3) });
      }
      for (;;)
      {
        ab.i("WNNoteBanner", "isOpenFromSession: true");
        localObject = new j();
        c.dhH().vvQ = ((d)localObject);
        localacs = new acs();
        localacs.scene = 8;
        ((j)localObject).a(paramView.vxy, Long.valueOf(paramView.vxw), true, (Context)this.vCM.vUD.get(), paramView.vxz, paramView.vxA, localacs);
        AppMethodBeat.o(27112);
        return;
        com.tencent.mm.plugin.report.service.h.qsU.e(14789, new Object[] { Integer.valueOf(2) });
      }
    }
    com.tencent.mm.plugin.report.service.h.qsU.e(14789, new Object[] { Integer.valueOf(1) });
    ab.i("WNNoteBanner", "isOpenFromSession: false");
    Object localObject = new g();
    c.dhH().vvQ = ((d)localObject);
    acs localacs = new acs();
    localacs.scene = 8;
    ((g)localObject).a(paramView.vxv, (Context)this.vCM.vUD.get(), Boolean.TRUE, paramView.vxz, paramView.vxA, localacs, null);
    AppMethodBeat.o(27112);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.b.1
 * JD-Core Version:    0.7.0.1
 */