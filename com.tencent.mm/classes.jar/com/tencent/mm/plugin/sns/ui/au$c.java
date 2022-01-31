package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.dk;
import com.tencent.mm.protocal.c.rp;
import java.util.LinkedList;

final class au$c
  implements View.OnCreateContextMenuListener
{
  private String bMB;
  private bxk oOz;
  private n oUH;
  private awd oqa;
  private View targetView;
  private String url;
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    paramContextMenuInfo = paramView.getTag();
    bxk localbxk;
    String str1;
    if ((paramContextMenuInfo instanceof q))
    {
      paramContextMenuInfo = (q)paramContextMenuInfo;
      localbxk = paramContextMenuInfo.oOz;
      paramView.getContext();
      str1 = localbxk.tNr.kSC;
      String str2 = localbxk.tNq.lsK;
      str1 = au.Pr(str1);
      if ((str1 != null) && (str1.length() != 0)) {
        break label69;
      }
    }
    label69:
    label118:
    do
    {
      return;
      this.url = str1;
      this.bMB = paramContextMenuInfo.bJQ;
      this.targetView = paramView;
      if (localbxk.tNr.sPJ.size() <= 0) {
        break;
      }
      paramContextMenuInfo = (awd)localbxk.tNr.sPJ.get(0);
      this.oqa = paramContextMenuInfo;
      this.oUH = af.bDF().OB(this.bMB);
      this.oOz = localbxk;
    } while ((localbxk.tNr.sPI == 10) || (localbxk.tNr.sPI == 13));
    if (d.SP("favorite")) {
      switch (localbxk.tNr.sPI)
      {
      default: 
        paramContextMenu.add(0, 3, 0, paramView.getContext().getString(i.j.plugin_favorite_opt));
      }
    }
    while ((this.oUH != null) && (!this.oUH.field_userName.equals(af.bDl())))
    {
      paramContextMenu.add(0, 8, 0, paramView.getContext().getString(i.j.contact_info_op_sns_permission));
      return;
      paramContextMenuInfo = null;
      break label118;
      paramContextMenu.add(0, 4, 0, paramView.getContext().getString(i.j.plugin_favorite_opt));
      continue;
      paramContextMenu.add(0, 5, 0, paramView.getContext().getString(i.j.plugin_favorite_opt));
      continue;
      paramContextMenu.add(0, 9, 0, paramView.getContext().getString(i.j.plugin_favorite_opt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.au.c
 * JD-Core Version:    0.7.0.1
 */