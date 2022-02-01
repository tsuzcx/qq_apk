package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.cc.d;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.d.a;

public final class bb$a
  extends c
{
  private a aeiK;
  
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
      localView = paramLayoutInflater.inflate(R.i.ggc, null);
      paramLayoutInflater = new bb.b();
      paramLayoutInflater.timeTV = ((TextView)localView.findViewById(R.h.fAm));
      paramLayoutInflater.userTV = ((TextView)localView.findViewById(R.h.fAr));
      paramLayoutInflater.aePK = ((ImageView)localView.findViewById(R.h.fzm));
      paramLayoutInflater.aeUX = ((TextView)localView.findViewById(R.h.fAo));
      paramLayoutInflater.aeUc = ((TextView)localView.findViewById(R.h.fxy));
      paramLayoutInflater.clickArea = localView.findViewById(R.h.chatting_click_area);
      localView.setTag(paramLayoutInflater);
    }
    AppMethodBeat.o(37360);
    return localView;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, cc paramcc, String paramString)
  {
    AppMethodBeat.i(37361);
    this.aeiK = parama1;
    parama = (bb.b)parama;
    bh.bCz();
    paramString = com.tencent.mm.model.c.bzD().aLS(paramcc.field_content);
    parama.aeUX.setText(paramString.title);
    parama.aeUc.setText(paramString.content);
    a(parama, paramString.oSj);
    ImageView localImageView = parama.aePK;
    if (paramString.Apo) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      parama.clickArea.setTag(new bz(paramcc, parama1.juG(), paramInt, null, '\000'));
      parama.clickArea.setOnClickListener(d(parama1));
      parama.clickArea.setOnLongClickListener(c(parama1));
      parama.clickArea.setOnTouchListener(((m)parama1.cm(m.class)).jqv());
      AppMethodBeat.o(37361);
      return;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, cc paramcc)
  {
    return false;
  }
  
  public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
  {
    AppMethodBeat.i(255125);
    int i = ((bz)paramView.getTag()).position;
    if (!this.aeiK.juH()) {
      params.a(i, 100, paramView.getContext().getString(R.l.gyo), R.k.icons_filled_delete);
    }
    AppMethodBeat.o(255125);
    return true;
  }
  
  public final boolean c(View paramView, a parama, cc paramcc)
  {
    AppMethodBeat.i(37363);
    paramView = (bz)paramView.getTag();
    bh.bCz();
    paramcc = com.tencent.mm.model.c.bzD().aLS(paramView.hTm.field_content);
    if (Util.nullAsNil(paramcc.Njg).length() > 0) {
      com.tencent.mm.br.c.b(parama.aezO.getContext(), "qqmail", ".ui.ReadMailUI", new Intent().putExtra("msgid", paramView.hTm.field_msgId));
    }
    for (;;)
    {
      AppMethodBeat.o(37363);
      return true;
      if (Util.nullAsNil(paramcc.adkM).length() > 0)
      {
        paramView = new Intent("android.intent.action.VIEW", Uri.parse(paramcc.adkM));
        com.tencent.mm.br.c.b(parama.aezO.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
      }
    }
  }
  
  public final boolean cM(int paramInt, boolean paramBoolean)
  {
    return paramInt == 35;
  }
  
  public final boolean fXn()
  {
    return false;
  }
  
  protected final boolean jxh()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bb.a
 * JD-Core Version:    0.7.0.1
 */