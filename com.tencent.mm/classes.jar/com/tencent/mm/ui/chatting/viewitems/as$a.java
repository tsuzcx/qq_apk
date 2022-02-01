package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.a.a;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.storage.bo;

public final class as$a
  extends aw.a
{
  private com.tencent.mm.ui.chatting.d.a HNS;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37367);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ag(paramLayoutInflater, 2131493473);
      ((View)localObject).setTag(new as.c().gr((View)localObject));
    }
    AppMethodBeat.o(37367);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bo parambo, String paramString)
  {
    AppMethodBeat.i(37368);
    this.HNS = parama1;
    parama = (as.c)parama;
    paramString = a.a.BH(parambo.field_content);
    if (paramString == null)
    {
      AppMethodBeat.o(37368);
      return;
    }
    String str = paramString.dng;
    a(parama, parama1, parambo, str);
    a(parama, parama1, str, parambo);
    k.a(parama.Ioj.getContext(), com.tencent.mm.am.a.a(paramString), (int)parama.Ioj.getTextSize(), 1, null, "");
    parama.Ioj.setTag(new bj(parambo, parama1.foQ(), paramInt, null, '\000'));
    parama.Ioj.setOnLongClickListener(c(parama1));
    AppMethodBeat.o(37368);
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
  {
    AppMethodBeat.i(37369);
    if (parambo.fbK())
    {
      int i = ((bj)paramView.getTag()).position;
      if (parambo.field_status == 5) {
        paramContextMenu.add(i, 103, 0, paramView.getContext().getString(2131757286));
      }
      if (!this.HNS.foR()) {
        paramContextMenu.add(i, 100, 0, paramView.getContext().getString(2131757221));
      }
    }
    AppMethodBeat.o(37369);
    return true;
  }
  
  public final boolean bb(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && ((paramInt == 55) || (paramInt == 57));
  }
  
  protected final boolean fqt()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.as.a
 * JD-Core Version:    0.7.0.1
 */