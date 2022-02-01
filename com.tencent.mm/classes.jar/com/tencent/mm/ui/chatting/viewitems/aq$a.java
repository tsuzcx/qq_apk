package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bo.c;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.d.a;

public final class aq$a
  extends c
{
  private a HNS;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37360);
    View localView;
    if (paramView != null)
    {
      localView = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localView = paramLayoutInflater.inflate(2131493456, null);
      paramLayoutInflater = new aq.b();
      paramLayoutInflater.fAz = ((TextView)localView.findViewById(2131298178));
      paramLayoutInflater.xpH = ((TextView)localView.findViewById(2131298185));
      paramLayoutInflater.Ilc = ((ImageView)localView.findViewById(2131298146));
      paramLayoutInflater.IoK = ((TextView)localView.findViewById(2131298180));
      paramLayoutInflater.Ioj = ((TextView)localView.findViewById(2131298073));
      paramLayoutInflater.nDl = localView.findViewById(2131298069);
      localView.setTag(paramLayoutInflater);
    }
    AppMethodBeat.o(37360);
    return localView;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bo parambo, String paramString)
  {
    AppMethodBeat.i(37361);
    this.HNS = parama1;
    parama = (aq.b)parama;
    az.ayM();
    paramString = com.tencent.mm.model.c.awD().alu(parambo.field_content);
    parama.IoK.setText(paramString.title);
    parama.Ioj.setText(paramString.content);
    a(parama, paramString.hRP);
    ImageView localImageView = parama.Ilc;
    if (paramString.qUc) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      parama.nDl.setTag(new bj(parambo, parama1.foQ(), paramInt, null, '\000'));
      parama.nDl.setOnClickListener(d(parama1));
      parama.nDl.setOnLongClickListener(c(parama1));
      parama.nDl.setOnTouchListener(((i)parama1.bf(i.class)).fmb());
      AppMethodBeat.o(37361);
      return;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
  {
    AppMethodBeat.i(37362);
    int i = ((bj)paramView.getTag()).position;
    if (!this.HNS.foR()) {
      paramContextMenu.add(i, 100, 0, paramView.getContext().getString(2131757221));
    }
    AppMethodBeat.o(37362);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bo parambo)
  {
    return false;
  }
  
  public final boolean b(View paramView, a parama, bo parambo)
  {
    AppMethodBeat.i(37363);
    paramView = (bj)paramView.getTag();
    az.ayM();
    parambo = com.tencent.mm.model.c.awD().alu(paramView.dpq.field_content);
    if (bs.nullAsNil(parambo.vTT).length() > 0) {
      d.b(parama.HZF.getContext(), "qqmail", ".ui.ReadMailUI", new Intent().putExtra("msgid", paramView.dpq.field_msgId));
    }
    for (;;)
    {
      AppMethodBeat.o(37363);
      return true;
      if (bs.nullAsNil(parambo.GZj).length() > 0)
      {
        paramView = new Intent("android.intent.action.VIEW", Uri.parse(parambo.GZj));
        d.b(parama.HZF.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
      }
    }
  }
  
  public final boolean bb(int paramInt, boolean paramBoolean)
  {
    return paramInt == 35;
  }
  
  protected final boolean fqt()
  {
    return false;
  }
  
  public final boolean fqu()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aq.a
 * JD-Core Version:    0.7.0.1
 */