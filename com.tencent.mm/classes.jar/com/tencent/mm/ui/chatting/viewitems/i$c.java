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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
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
  private a Gob;
  
  private static String aLd(String paramString)
  {
    AppMethodBeat.i(36893);
    try
    {
      paramString = k.b.rx(paramString);
      if (paramString != null)
      {
        paramString = URLDecoder.decode(paramString.content, "UTF-8");
        AppMethodBeat.o(36893);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.ChattingItemTextTo", "getMsgContent error: %s", new Object[] { paramString.getMessage() });
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
      localObject = new af(paramLayoutInflater, 2131493502);
      ((View)localObject).setTag(new i.a().z((View)localObject, false));
    }
    AppMethodBeat.o(36892);
    return localObject;
  }
  
  public final void a(a parama, bl parambl)
  {
    AppMethodBeat.i(36896);
    if (parambl.cxB())
    {
      m.aB(parambl);
      com.tencent.mm.model.bi.lW(parambl.field_msgId);
      parama.wc(true);
      AppMethodBeat.o(36896);
      return;
    }
    AppMethodBeat.o(36896);
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bl parambl, String paramString)
  {
    AppMethodBeat.i(36894);
    this.Gob = parama1;
    parama = (i.a)parama;
    if (faG())
    {
      if (parama.uPp != null) {
        parama.uPp.setVisibility(8);
      }
      if ((parambl.field_status == 1) || (parambl.field_status == 5))
      {
        if (parama.GJi != null) {
          parama.GJi.setVisibility(8);
        }
        parama.GKR.setBackgroundResource(2131231726);
        parambl.FzQ = true;
      }
    }
    while (parama.uPp == null) {
      for (;;)
      {
        paramString = aLd(parambl.field_content);
        if (bt.isNullOrNil(paramString)) {
          ad.e("MicroMsg.ChattingItemTextTo", "[carl] text to, content is null! why?? localid : %s, svrid : %s", new Object[] { Long.valueOf(parambl.field_msgId), Long.valueOf(parambl.field_msgSvrId) });
        }
        parama.GKR.setMinWidth(0);
        parama.GKR.setText(paramString);
        paramString = parama.GKR;
        i = parambl.getType();
        String str = parama1.getTalkerUserName();
        if (i != 301989937) {
          k.a(paramString, str);
        }
        paramString.getText();
        paramString = bi.b(parambl, parama1.eZb(), paramInt);
        parama.GKR.setTag(paramString);
        parama.GKR.setOnLongClickListener(c(parama1));
        parama.GKR.setOnDoubleClickLitsener(((i)parama1.be(i.class)).eWo());
        a(paramInt, parama, parambl, parama1.eYX(), parama1.eZb(), parama1, this);
        AppMethodBeat.o(36894);
        return;
        parama.GKR.setBackground(ao.aC(parama1.GzJ.getContext(), 2130968741));
        if (parama.GJi != null) {
          if (a((i)parama1.be(i.class), parambl.field_msgId))
          {
            if (parambl.FzQ)
            {
              paramString = new AlphaAnimation(0.5F, 1.0F);
              paramString.setDuration(300L);
              parama.GKR.startAnimation(paramString);
              parambl.FzQ = false;
            }
            parama.GJi.setVisibility(0);
          }
          else
          {
            parama.GJi.setVisibility(8);
          }
        }
      }
    }
    paramString = parama.uPp;
    if (parambl.field_status >= 2) {}
    for (int i = 8;; i = 0)
    {
      paramString.setVisibility(i);
      break;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
  {
    AppMethodBeat.i(36895);
    paramContextMenu.add(((bi)paramView.getTag()).position, 100, 0, paramView.getContext().getString(2131757221));
    AppMethodBeat.o(36895);
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bl parambl)
  {
    return false;
  }
  
  public final boolean aX(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 503316529);
  }
  
  public final boolean b(View paramView, a parama, bl parambl)
  {
    return false;
  }
  
  public final boolean faE()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.i.c
 * JD-Core Version:    0.7.0.1
 */