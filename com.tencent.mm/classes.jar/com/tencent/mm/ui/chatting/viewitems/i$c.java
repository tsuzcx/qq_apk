package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.bi;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.s.n;
import com.tencent.mm.ui.widget.MMTextView;
import java.net.URLDecoder;

public final class i$c
  extends c
  implements s.n
{
  private a HNS;
  
  private static String aQH(String paramString)
  {
    AppMethodBeat.i(36893);
    try
    {
      paramString = k.b.vA(paramString);
      if (paramString != null)
      {
        paramString = URLDecoder.decode(paramString.content, "UTF-8");
        AppMethodBeat.o(36893);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      ac.e("MicroMsg.ChattingItemTextTo", "getMsgContent error: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(36893);
    }
    return "";
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(36892);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ag(paramLayoutInflater, 2131493502);
      ((View)localObject).setTag(new i.a().z((View)localObject, false));
    }
    AppMethodBeat.o(36892);
    return localObject;
  }
  
  public final void a(a parama, bo parambo)
  {
    AppMethodBeat.i(36896);
    if (parambo.cKN())
    {
      m.aD(parambo);
      bi.pK(parambo.field_msgId);
      parama.xg(true);
      AppMethodBeat.o(36896);
      return;
    }
    AppMethodBeat.o(36896);
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bo parambo, String paramString)
  {
    AppMethodBeat.i(36894);
    this.HNS = parama1;
    parama = (i.a)parama;
    if (fqw())
    {
      b(parama, false);
      if ((parambo.field_status == 1) || (parambo.field_status == 5))
      {
        if (parama.Ijf != null) {
          parama.Ijf.setVisibility(8);
        }
        parama.IkO.setBackgroundResource(2131231726);
        parambo.GYS = true;
      }
      for (;;)
      {
        paramString = aQH(parambo.field_content);
        if (bs.isNullOrNil(paramString)) {
          ac.e("MicroMsg.ChattingItemTextTo", "[carl] text to, content is null! why?? localid : %s, svrid : %s", new Object[] { Long.valueOf(parambo.field_msgId), Long.valueOf(parambo.field_msgSvrId) });
        }
        parama.IkO.setMinWidth(0);
        parama.IkO.setText(paramString);
        paramString = parama.IkO;
        int i = parambo.getType();
        String str = parama1.getTalkerUserName();
        if (i != 301989937) {
          k.a(paramString, str);
        }
        paramString.getText();
        paramString = bj.b(parambo, parama1.foQ(), paramInt);
        parama.IkO.setTag(paramString);
        parama.IkO.setOnLongClickListener(c(parama1));
        parama.IkO.setOnDoubleClickLitsener(((i)parama1.bf(i.class)).fma());
        a(paramInt, parama, parambo, parama1.foM(), parama1.foQ(), parama1, this);
        AppMethodBeat.o(36894);
        return;
        parama.IkO.setBackground(ao.aI(parama1.HZF.getContext(), 2130968741));
        if (parama.Ijf != null) {
          if (a((i)parama1.bf(i.class), parambo.field_msgId))
          {
            if (parambo.GYS)
            {
              paramString = new AlphaAnimation(0.5F, 1.0F);
              paramString.setDuration(300L);
              parama.IkO.startAnimation(paramString);
              parambo.GYS = false;
            }
            parama.Ijf.setVisibility(0);
          }
          else
          {
            parama.Ijf.setVisibility(8);
          }
        }
      }
    }
    if (parambo.field_status < 2) {}
    for (boolean bool = true;; bool = false)
    {
      b(parama, bool);
      break;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
  {
    AppMethodBeat.i(36895);
    paramContextMenu.add(((bj)paramView.getTag()).position, 100, 0, paramView.getContext().getString(2131757221));
    AppMethodBeat.o(36895);
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bo parambo)
  {
    return false;
  }
  
  public final boolean b(View paramView, a parama, bo parambo)
  {
    return false;
  }
  
  public final boolean bb(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 503316529);
  }
  
  public final boolean fqu()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.i.c
 * JD-Core Version:    0.7.0.1
 */