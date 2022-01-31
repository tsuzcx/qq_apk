package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.ContextMenu;
import android.view.View;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class ai$b
  extends am.b
{
  private com.tencent.mm.ui.chatting.d.a zzP;
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bi parambi, String paramString)
  {
    AppMethodBeat.i(33274);
    this.zzP = parama1;
    parama = (am.f)parama;
    paramString = a.a.sz(parambi.field_content);
    if (parambi.field_status >= 2) {
      parama.pNd.setVisibility(8);
    }
    for (;;)
    {
      j.a(parama.zXe.getContext(), com.tencent.mm.ak.a.a(paramString), (int)parama.zXe.getTextSize(), 1, null, "");
      parama.zXe.setTag(new az(parambi, parama1.dJG(), paramInt, null, '\000'));
      parama.zXe.setOnLongClickListener(c(parama1));
      a(paramInt, parama, parambi, parama1.dJD(), parama1.dJG(), parama1, this);
      AppMethodBeat.o(33274);
      return;
      parama.pNd.setVisibility(0);
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    AppMethodBeat.i(33275);
    if (parambi.dxZ())
    {
      int i = ((az)paramView.getTag()).position;
      if (parambi.field_status == 5) {
        paramContextMenu.add(i, 103, 0, paramView.getContext().getString(2131298295));
      }
      if (!this.zzP.dJH()) {
        paramContextMenu.add(i, 100, 0, paramView.getContext().getString(2131298232));
      }
    }
    AppMethodBeat.o(33275);
    return true;
  }
  
  public final boolean aK(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && ((paramInt == 55) || (paramInt == 57));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ai.b
 * JD-Core Version:    0.7.0.1
 */