package com.tencent.mm.plugin.sns.ui.d;

import android.app.Activity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.dr;
import com.tencent.mm.g.a.dr.b;
import com.tencent.mm.m.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

final class b$25
  extends c
{
  b$25(b paramb) {}
  
  public final void a(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(40280);
    if ((paramView.getTag() instanceof aj))
    {
      paramView = (aj)paramView.getTag();
      if (!paramView.raZ) {
        paramContextMenu.add(0, 19, 0, this.skd.activity.getString(2131298237));
      }
      if (bo.apV(g.Nq().getValue("SIGHTCannotTransmitForFav")) != 0) {
        break label308;
      }
      if (paramView.rLC.xTS.wOa.size() <= 0) {
        break label301;
      }
      paramContextMenuInfo = (bcs)paramView.rLC.xTS.wOa.get(0);
      String str = paramContextMenuInfo.Id;
      str = ao.gl(ag.getAccSnsPath(), str) + i.e(paramContextMenuInfo);
      paramContextMenuInfo = ar.a(paramView.crk, paramContextMenuInfo);
      boolean bool1 = com.tencent.mm.vfs.e.cN(str);
      boolean bool2 = com.tencent.mm.vfs.e.cN(paramContextMenuInfo);
      ab.i("MicroMsg.TimelineOnCreateContextMenuListener", "config can forward sight, thumb existed %B, video existed %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bool1) || (!bool2)) {
        break label308;
      }
    }
    label301:
    label308:
    for (int i = 1;; i = 0)
    {
      if (d.ahR("favorite")) {
        paramContextMenu.add(0, 10, 0, this.skd.activity.getString(2131302102));
      }
      if (i != 0)
      {
        paramContextMenuInfo = new dr();
        paramContextMenuInfo.crt.crk = paramView.crk;
        com.tencent.mm.sdk.b.a.ymk.l(paramContextMenuInfo);
        if (paramContextMenuInfo.cru.cqS) {
          paramContextMenu.add(0, 18, 0, this.skd.activity.getString(2131297019));
        }
      }
      AppMethodBeat.o(40280);
      return;
      ab.w("MicroMsg.TimelineOnCreateContextMenuListener", "sight item had not attch.");
    }
  }
  
  public final boolean dU(View paramView)
  {
    AppMethodBeat.i(40281);
    if ((paramView.getTag() instanceof aj))
    {
      String str = ((aj)paramView.getTag()).crk;
      n localn = ag.cpf().abv(str);
      this.skd.sjr.a(paramView, str, localn.csh());
      AppMethodBeat.o(40281);
      return true;
    }
    AppMethodBeat.o(40281);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.25
 * JD-Core Version:    0.7.0.1
 */