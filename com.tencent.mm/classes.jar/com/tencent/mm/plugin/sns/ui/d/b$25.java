package com.tencent.mm.plugin.sns.ui.d;

import android.app.Activity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.do;
import com.tencent.mm.h.a.do.b;
import com.tencent.mm.m.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

final class b$25
  extends c
{
  b$25(b paramb) {}
  
  public final void a(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    if ((paramView.getTag() instanceof aj))
    {
      paramView = (aj)paramView.getTag();
      if (!paramView.omL) {
        paramContextMenu.add(0, 19, 0, this.ppl.activity.getString(i.j.chatting_long_click_menu_mute_play));
      }
      if (bk.ZR(g.AA().getValue("SIGHTCannotTransmitForFav")) != 0) {
        break label301;
      }
      if (paramView.oTF.tNr.sPJ.size() <= 0) {
        break label294;
      }
      paramContextMenuInfo = (awd)paramView.oTF.tNr.sPJ.get(0);
      String str = paramContextMenuInfo.lsK;
      str = an.eJ(af.getAccSnsPath(), str) + i.e(paramContextMenuInfo);
      paramContextMenuInfo = aq.a(paramView.bJQ, paramContextMenuInfo);
      boolean bool1 = com.tencent.mm.vfs.e.bK(str);
      boolean bool2 = com.tencent.mm.vfs.e.bK(paramContextMenuInfo);
      y.i("MicroMsg.TimelineOnCreateContextMenuListener", "config can forward sight, thumb existed %B, video existed %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bool1) || (!bool2)) {
        break label301;
      }
    }
    label294:
    label301:
    for (int i = 1;; i = 0)
    {
      if (d.SP("favorite")) {
        paramContextMenu.add(0, 10, 0, this.ppl.activity.getString(i.j.plugin_favorite_opt));
      }
      if (i != 0)
      {
        paramContextMenuInfo = new do();
        paramContextMenuInfo.bJZ.bJQ = paramView.bJQ;
        com.tencent.mm.sdk.b.a.udP.m(paramContextMenuInfo);
        if (paramContextMenuInfo.bKa.bJy) {
          paramContextMenu.add(0, 18, 0, this.ppl.activity.getString(i.j.app_open));
        }
      }
      return;
      y.w("MicroMsg.TimelineOnCreateContextMenuListener", "sight item had not attch.");
    }
  }
  
  public final boolean dd(View paramView)
  {
    if ((paramView.getTag() instanceof aj))
    {
      String str = ((aj)paramView.getTag()).bJQ;
      n localn = af.bDF().OB(str);
      this.ppl.poz.a(paramView, str, localn.bGe());
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.25
 * JD-Core Version:    0.7.0.1
 */