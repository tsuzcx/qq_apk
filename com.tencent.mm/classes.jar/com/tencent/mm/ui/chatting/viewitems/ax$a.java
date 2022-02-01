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
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.ca.c;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.e.a;

public final class ax$a
  extends c
{
  private a PhN;
  
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
      localView = paramLayoutInflater.inflate(2131493557, null);
      paramLayoutInflater = new ax.b();
      paramLayoutInflater.timeTV = ((TextView)localView.findViewById(2131298558));
      paramLayoutInflater.userTV = ((TextView)localView.findViewById(2131298566));
      paramLayoutInflater.PKi = ((ImageView)localView.findViewById(2131298507));
      paramLayoutInflater.POl = ((TextView)localView.findViewById(2131298560));
      paramLayoutInflater.PNK = ((TextView)localView.findViewById(2131298416));
      paramLayoutInflater.clickArea = localView.findViewById(2131298411);
      localView.setTag(paramLayoutInflater);
    }
    AppMethodBeat.o(37360);
    return localView;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(37361);
    this.PhN = parama1;
    parama = (ax.b)parama;
    bg.aVF();
    paramString = com.tencent.mm.model.c.aSQ().aEI(paramca.field_content);
    parama.POl.setText(paramString.title);
    parama.PNK.setText(paramString.content);
    a(parama, paramString.jje);
    ImageView localImageView = parama.PKi;
    if (paramString.tmn) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      parama.clickArea.setTag(new bq(paramca, parama1.gRM(), paramInt, null, '\000'));
      parama.clickArea.setOnClickListener(d(parama1));
      parama.clickArea.setOnLongClickListener(c(parama1));
      parama.clickArea.setOnTouchListener(((k)parama1.bh(k.class)).gOC());
      AppMethodBeat.o(37361);
      return;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean a(m paramm, View paramView, ca paramca)
  {
    AppMethodBeat.i(233919);
    int i = ((bq)paramView.getTag()).position;
    if (!this.PhN.gRN()) {
      paramm.a(i, 100, paramView.getContext().getString(2131757433), 2131690529);
    }
    AppMethodBeat.o(233919);
    return true;
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return paramInt == 35;
  }
  
  public final boolean c(View paramView, a parama, ca paramca)
  {
    AppMethodBeat.i(37363);
    paramView = (bq)paramView.getTag();
    bg.aVF();
    paramca = com.tencent.mm.model.c.aSQ().aEI(paramView.dTX.field_content);
    if (Util.nullAsNil(paramca.BqZ).length() > 0) {
      com.tencent.mm.br.c.b(parama.Pwc.getContext(), "qqmail", ".ui.ReadMailUI", new Intent().putExtra("msgid", paramView.dTX.field_msgId));
    }
    for (;;)
    {
      AppMethodBeat.o(37363);
      return true;
      if (Util.nullAsNil(paramca.OqW).length() > 0)
      {
        paramView = new Intent("android.intent.action.VIEW", Uri.parse(paramca.OqW));
        com.tencent.mm.br.c.b(parama.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
      }
    }
  }
  
  public final boolean gTT()
  {
    return false;
  }
  
  protected final boolean gTU()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ax.a
 * JD-Core Version:    0.7.0.1
 */