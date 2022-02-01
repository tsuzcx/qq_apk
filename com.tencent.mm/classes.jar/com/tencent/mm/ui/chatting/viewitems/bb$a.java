package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.ca.c;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.e.a;

public final class bb$a
  extends c
{
  private a WBq;
  
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
      localView = paramLayoutInflater.inflate(R.i.edn, null);
      paramLayoutInflater = new bb.b();
      paramLayoutInflater.timeTV = ((TextView)localView.findViewById(R.h.dzs));
      paramLayoutInflater.userTV = ((TextView)localView.findViewById(R.h.chatting_user_tv));
      paramLayoutInflater.XfI = ((ImageView)localView.findViewById(R.h.dyC));
      paramLayoutInflater.Xkm = ((TextView)localView.findViewById(R.h.dzu));
      paramLayoutInflater.XjK = ((TextView)localView.findViewById(R.h.chatting_content_itv));
      paramLayoutInflater.clickArea = localView.findViewById(R.h.chatting_click_area);
      localView.setTag(paramLayoutInflater);
    }
    AppMethodBeat.o(37360);
    return localView;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(37361);
    this.WBq = parama1;
    parama = (bb.b)parama;
    bh.beI();
    paramString = com.tencent.mm.model.c.bbO().aOS(paramca.field_content);
    parama.Xkm.setText(paramString.title);
    parama.XjK.setText(paramString.content);
    a(parama, paramString.lZa);
    ImageView localImageView = parama.XfI;
    if (paramString.wSL) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      parama.clickArea.setTag(new by(paramca, parama1.hRi(), paramInt, null, '\000'));
      parama.clickArea.setOnClickListener(d(parama1));
      parama.clickArea.setOnLongClickListener(c(parama1));
      parama.clickArea.setOnTouchListener(((k)parama1.bC(k.class)).hNO());
      AppMethodBeat.o(37361);
      return;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean a(o paramo, View paramView, ca paramca)
  {
    AppMethodBeat.i(285064);
    int i = ((by)paramView.getTag()).position;
    if (!this.WBq.hRj()) {
      paramo.a(i, 100, paramView.getContext().getString(R.l.evO), R.k.icons_filled_delete);
    }
    AppMethodBeat.o(285064);
    return true;
  }
  
  public final boolean bZ(int paramInt, boolean paramBoolean)
  {
    return paramInt == 35;
  }
  
  public final boolean c(View paramView, a parama, ca paramca)
  {
    AppMethodBeat.i(37363);
    paramView = (by)paramView.getTag();
    bh.beI();
    paramca = com.tencent.mm.model.c.bbO().aOS(paramView.fNz.field_content);
    if (Util.nullAsNil(paramca.Hls).length() > 0) {
      com.tencent.mm.by.c.b(parama.WQv.getContext(), "qqmail", ".ui.ReadMailUI", new Intent().putExtra("msgid", paramView.fNz.field_msgId));
    }
    for (;;)
    {
      AppMethodBeat.o(37363);
      return true;
      if (Util.nullAsNil(paramca.VGS).length() > 0)
      {
        paramView = new Intent("android.intent.action.VIEW", Uri.parse(paramca.VGS));
        com.tencent.mm.by.c.b(parama.WQv.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
      }
    }
  }
  
  public final boolean hTD()
  {
    return false;
  }
  
  protected final boolean hTE()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bb.a
 * JD-Core Version:    0.7.0.1
 */