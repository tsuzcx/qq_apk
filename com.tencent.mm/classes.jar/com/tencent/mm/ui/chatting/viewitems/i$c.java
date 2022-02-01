package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bp;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.t.n;
import com.tencent.mm.ui.widget.MMTextView;
import java.net.URLDecoder;

public final class i$c
  extends c
  implements t.n
{
  private a PhN;
  
  private static String aGb(String paramString)
  {
    AppMethodBeat.i(36893);
    try
    {
      paramString = k.b.HD(paramString);
      if (paramString != null)
      {
        paramString = URLDecoder.decode(paramString.content, "UTF-8");
        AppMethodBeat.o(36893);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.ChattingItemTextTo", "getMsgContent error: %s", new Object[] { paramString.getMessage() });
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
      localObject = new an(paramLayoutInflater, 2131493611);
      ((View)localObject).setTag(new i.a().G((View)localObject, false));
    }
    AppMethodBeat.o(36892);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(36894);
    this.PhN = parama1;
    parama = (i.a)parama;
    if (gTW())
    {
      b(parama, false);
      if ((paramca.field_status == 1) || (paramca.field_status == 5))
      {
        if (parama.PIn != null) {
          parama.PIn.setVisibility(8);
        }
        parama.PJU.setBackgroundResource(2131231797);
        paramca.OqF = true;
      }
      for (;;)
      {
        paramString = aGb(paramca.field_content);
        if (Util.isNullOrNil(paramString)) {
          Log.e("MicroMsg.ChattingItemTextTo", "[carl] text to, content is null! why?? localid : %s, svrid : %s", new Object[] { Long.valueOf(paramca.field_msgId), Long.valueOf(paramca.field_msgSvrId) });
        }
        parama.PJU.setMinWidth(0);
        parama.PJU.setText(paramString);
        paramString = parama.PJU;
        int i = paramca.getType();
        String str = parama1.getTalkerUserName();
        if (i != 301989937) {
          l.a(paramString, str);
        }
        paramString.getText();
        paramString = bq.b(paramca, parama1.gRM(), paramInt);
        parama.PJU.setTag(paramString);
        parama.PJU.setOnLongClickListener(c(parama1));
        parama.PJU.setOnDoubleClickLitsener(((k)parama1.bh(k.class)).gOB());
        a(paramInt, parama, paramca, parama1.gRI(), parama1.gRM(), parama1, this);
        AppMethodBeat.o(36894);
        return;
        parama.PJU.setBackgroundResource(2131231796);
        if (parama.PIn != null) {
          if (b((k)parama1.bh(k.class), paramca.field_msgId))
          {
            if (paramca.OqF)
            {
              paramString = new AlphaAnimation(0.5F, 1.0F);
              paramString.setDuration(300L);
              parama.PJU.startAnimation(paramString);
              paramca.OqF = false;
            }
            parama.PIn.setVisibility(0);
          }
          else
          {
            parama.PIn.setVisibility(8);
          }
        }
      }
    }
    if (paramca.field_status < 2) {}
    for (boolean bool = true;; bool = false)
    {
      b(parama, bool);
      break;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean a(com.tencent.mm.ui.base.m paramm, View paramView, ca paramca)
  {
    AppMethodBeat.i(233623);
    paramm.a(((bq)paramView.getTag()).position, 100, paramView.getContext().getString(2131757433), 2131690529);
    AppMethodBeat.o(233623);
    return false;
  }
  
  public final void b(View paramView, a parama, ca paramca)
  {
    AppMethodBeat.i(233624);
    if (paramca.dOQ())
    {
      com.tencent.mm.pluginsdk.model.app.m.aS(paramca);
      bp.Ad(paramca.field_msgId);
      parama.BN(true);
      AppMethodBeat.o(233624);
      return;
    }
    AppMethodBeat.o(233624);
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 503316529);
  }
  
  public final boolean c(View paramView, a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean gTT()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.i.c
 * JD-Core Version:    0.7.0.1
 */