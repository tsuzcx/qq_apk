package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.storage.bi;

public final class ai$a
  extends am.a
{
  private com.tencent.mm.ui.chatting.d.a zzP;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(33271);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new w(paramLayoutInflater, 2130969100);
      ((View)localObject).setTag(new ai.c().fl((View)localObject));
    }
    AppMethodBeat.o(33271);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bi parambi, String paramString)
  {
    AppMethodBeat.i(33272);
    this.zzP = parama1;
    parama = (ai.c)parama;
    paramString = a.a.sz(parambi.field_content);
    if (paramString == null)
    {
      AppMethodBeat.o(33272);
      return;
    }
    String str = paramString.czp;
    a(parama, parama1, parambi, str);
    a(parama, parama1, str, parambi);
    j.a(parama.zVQ.getContext(), com.tencent.mm.ak.a.a(paramString), (int)parama.zVQ.getTextSize(), 1, null, "");
    parama.zVQ.setTag(new az(parambi, parama1.dJG(), paramInt, null, '\000'));
    parama.zVQ.setOnLongClickListener(c(parama1));
    AppMethodBeat.o(33272);
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    AppMethodBeat.i(33273);
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
    AppMethodBeat.o(33273);
    return true;
  }
  
  public final boolean aK(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && ((paramInt == 55) || (paramInt == 57));
  }
  
  protected final boolean dLo()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ai.a
 * JD-Core Version:    0.7.0.1
 */