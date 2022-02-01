package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.a.a;
import com.tencent.mm.g.c.du;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.storage.bl;

public final class ar$a
  extends av.a
{
  private com.tencent.mm.ui.chatting.d.a Gob;
  
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
      localObject = new af(paramLayoutInflater, 2131493473);
      ((View)localObject).setTag(new ar.c().ge((View)localObject));
    }
    AppMethodBeat.o(37367);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bl parambl, String paramString)
  {
    AppMethodBeat.i(37368);
    this.Gob = parama1;
    parama = (ar.c)parama;
    paramString = a.a.xB(parambl.field_content);
    if (paramString == null)
    {
      AppMethodBeat.o(37368);
      return;
    }
    String str = paramString.dpv;
    a(parama, parama1, parambl, str);
    a(parama, parama1, str, parambl);
    k.a(parama.GOh.getContext(), com.tencent.mm.an.a.a(paramString), (int)parama.GOh.getTextSize(), 1, null, "");
    parama.GOh.setTag(new bi(parambl, parama1.eZb(), paramInt, null, '\000'));
    parama.GOh.setOnLongClickListener(c(parama1));
    AppMethodBeat.o(37368);
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
  {
    AppMethodBeat.i(37369);
    if (parambl.eMf())
    {
      int i = ((bi)paramView.getTag()).position;
      if (parambl.field_status == 5) {
        paramContextMenu.add(i, 103, 0, paramView.getContext().getString(2131757286));
      }
      if (!this.Gob.eZc()) {
        paramContextMenu.add(i, 100, 0, paramView.getContext().getString(2131757221));
      }
    }
    AppMethodBeat.o(37369);
    return true;
  }
  
  public final boolean aX(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && ((paramInt == 55) || (paramInt == 57));
  }
  
  protected final boolean faD()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ar.a
 * JD-Core Version:    0.7.0.1
 */