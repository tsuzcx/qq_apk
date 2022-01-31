package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.d.a;

public final class ad
  extends c
{
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(33225);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new w(paramLayoutInflater, 2130969095);
      ((View)localObject).setTag(new ad.a(this).fo((View)localObject));
    }
    AppMethodBeat.o(33225);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bi parambi, String paramString)
  {
    AppMethodBeat.i(33226);
    ad.a locala = (ad.a)parama;
    j localj = al.dlL().nx(parambi.field_msgId);
    String str = parambi.field_content;
    if ((localj != null) && (str != null))
    {
      paramString = j.b.ab(str, parambi.field_reserved);
      parambi = new az(parambi, parama1.dJG(), paramInt, null, '\000');
      if ((paramString != null) && ((paramString.showType == 3) || (paramString.fhv == 3)))
      {
        locala.gxs.setImageResource(2130839074);
        locala.zWi.setText(paramString.fhA);
      }
      parama.jYu.setOnLongClickListener(c(parama1));
      parama.jYu.setOnTouchListener(((h)parama1.ay(h.class)).dHi());
      parama.jYu.setTag(parambi);
      AppMethodBeat.o(33226);
      return;
    }
    if (localj == null) {}
    for (boolean bool = true;; bool = false)
    {
      ab.e("MicroMsg.ChattingItemHardDeviceMsgPush", "amessage:%b, %s, %d, %s", new Object[] { Boolean.valueOf(bool), str, Long.valueOf(parambi.field_msgId), paramString });
      paramString = null;
      break;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    AppMethodBeat.i(33227);
    paramContextMenu.add(((az)paramView.getTag()).position, 100, 0, paramView.getContext().getString(2131298232));
    AppMethodBeat.o(33227);
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bi parambi)
  {
    AppMethodBeat.i(33228);
    paramMenuItem.getItemId();
    AppMethodBeat.o(33228);
    return false;
  }
  
  public final boolean aK(int paramInt, boolean paramBoolean)
  {
    return paramInt == -1879048176;
  }
  
  public final boolean b(View paramView, a parama, bi parambi)
  {
    return false;
  }
  
  public final boolean dLp()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ad
 * JD-Core Version:    0.7.0.1
 */