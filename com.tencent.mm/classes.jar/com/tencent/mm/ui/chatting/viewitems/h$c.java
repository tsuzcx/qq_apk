package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.bf;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.s.n;
import com.tencent.mm.ui.widget.MMTextView;
import java.net.URLDecoder;

public final class h$c
  extends c
  implements s.n
{
  private a zzP;
  
  private static String aun(String paramString)
  {
    AppMethodBeat.i(32909);
    try
    {
      paramString = j.b.mY(paramString);
      if (paramString != null)
      {
        paramString = URLDecoder.decode(paramString.content, "UTF-8");
        AppMethodBeat.o(32909);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.ChattingItemTextTo", "getMsgContent error: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(32909);
    }
    return "";
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(32908);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new w(paramLayoutInflater, 2130969123);
      ((View)localObject).setTag(new h.a().A((View)localObject, false));
    }
    AppMethodBeat.o(32908);
    return localObject;
  }
  
  public final void a(a parama, bi parambi)
  {
    AppMethodBeat.i(32912);
    if (parambi.bCn())
    {
      l.al(parambi);
      bf.gw(parambi.field_msgId);
      parama.qT(true);
      AppMethodBeat.o(32912);
      return;
    }
    AppMethodBeat.o(32912);
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bi parambi, String paramString)
  {
    AppMethodBeat.i(32910);
    this.zzP = parama1;
    parama = (h.a)parama;
    if (dLr())
    {
      if (parama.pNd != null) {
        parama.pNd.setVisibility(8);
      }
      if ((parambi.field_status == 1) || (parambi.field_status == 5))
      {
        if (parama.zSm != null) {
          parama.zSm.setVisibility(8);
        }
        parama.zTF.setBackgroundResource(2130838368);
        parambi.yOd = true;
      }
    }
    while (parama.pNd == null) {
      for (;;)
      {
        paramString = aun(parambi.field_content);
        if (bo.isNullOrNil(paramString)) {
          ab.e("MicroMsg.ChattingItemTextTo", "[carl] text to, content is null! why?? localid : %s, svrid : %s", new Object[] { Long.valueOf(parambi.field_msgId), Long.valueOf(parambi.field_msgSvrId) });
        }
        parama.zTF.setMinWidth(0);
        parama.zTF.setText(paramString);
        paramString = parama.zTF;
        i = parambi.getType();
        String str = parama1.getTalkerUserName();
        if (i != 301989937) {
          j.a(paramString, str);
        }
        paramString.getText();
        paramString = az.b(parambi, parama1.dJG(), paramInt);
        parama.zTF.setTag(paramString);
        parama.zTF.setOnLongClickListener(c(parama1));
        parama.zTF.setOnDoubleClickLitsener(((h)parama1.ay(h.class)).dHh());
        a(paramInt, parama, parambi, parama1.dJD(), parama1.dJG(), parama1, this);
        AppMethodBeat.o(32910);
        return;
        parama.zTF.setBackgroundResource(2130838367);
        if (parama.zSm != null) {
          if (a((h)parama1.ay(h.class), parambi.field_msgId))
          {
            if (parambi.yOd)
            {
              paramString = new AlphaAnimation(0.5F, 1.0F);
              paramString.setDuration(300L);
              parama.zTF.startAnimation(paramString);
              parambi.yOd = false;
            }
            parama.zSm.setVisibility(0);
          }
          else
          {
            parama.zSm.setVisibility(8);
          }
        }
      }
    }
    paramString = parama.pNd;
    if (parambi.field_status >= 2) {}
    for (int i = 8;; i = 0)
    {
      paramString.setVisibility(i);
      break;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    AppMethodBeat.i(32911);
    paramContextMenu.add(((az)paramView.getTag()).position, 100, 0, paramView.getContext().getString(2131298232));
    AppMethodBeat.o(32911);
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bi parambi)
  {
    return false;
  }
  
  public final boolean aK(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 503316529);
  }
  
  public final boolean b(View paramView, a parama, bi parambi)
  {
    return false;
  }
  
  public final boolean dLp()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.h.c
 * JD-Core Version:    0.7.0.1
 */