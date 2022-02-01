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
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bv.c;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.e.a;

public final class ar$a
  extends c
{
  private a JWz;
  
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
      paramLayoutInflater = new ar.b();
      paramLayoutInflater.fVV = ((TextView)localView.findViewById(2131298178));
      paramLayoutInflater.yUp = ((TextView)localView.findViewById(2131298185));
      paramLayoutInflater.KxS = ((ImageView)localView.findViewById(2131298146));
      paramLayoutInflater.KBD = ((TextView)localView.findViewById(2131298180));
      paramLayoutInflater.KBc = ((TextView)localView.findViewById(2131298073));
      paramLayoutInflater.olI = localView.findViewById(2131298069);
      localView.setTag(paramLayoutInflater);
    }
    AppMethodBeat.o(37360);
    return localView;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bv parambv, String paramString)
  {
    AppMethodBeat.i(37361);
    this.JWz = parama1;
    parama = (ar.b)parama;
    bc.aCg();
    paramString = com.tencent.mm.model.c.azI().arn(parambv.field_content);
    parama.KBD.setText(paramString.title);
    parama.KBc.setText(paramString.content);
    a(parama, paramString.inW);
    ImageView localImageView = parama.KxS;
    if (paramString.rMB) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      parama.olI.setTag(new bk(parambv, parama1.fJC(), paramInt, null, '\000'));
      parama.olI.setOnClickListener(d(parama1));
      parama.olI.setOnLongClickListener(c(parama1));
      parama.olI.setOnTouchListener(((k)parama1.bh(k.class)).fGw());
      AppMethodBeat.o(37361);
      return;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bv parambv)
  {
    return false;
  }
  
  public final boolean a(l paraml, View paramView, bv parambv)
  {
    AppMethodBeat.i(187884);
    int i = ((bk)paramView.getTag()).position;
    if (!this.JWz.fJD()) {
      paraml.a(i, 100, paramView.getContext().getString(2131757221), 2131690384);
    }
    AppMethodBeat.o(187884);
    return true;
  }
  
  public final boolean b(View paramView, a parama, bv parambv)
  {
    AppMethodBeat.i(37363);
    paramView = (bk)paramView.getTag();
    bc.aCg();
    parambv = com.tencent.mm.model.c.azI().arn(paramView.dCi.field_content);
    if (bu.nullAsNil(parambv.xqW).length() > 0) {
      d.b(parama.Kkd.getContext(), "qqmail", ".ui.ReadMailUI", new Intent().putExtra("msgid", paramView.dCi.field_msgId));
    }
    for (;;)
    {
      AppMethodBeat.o(37363);
      return true;
      if (bu.nullAsNil(parambv.Jhf).length() > 0)
      {
        paramView = new Intent("android.intent.action.VIEW", Uri.parse(parambv.Jhf));
        d.b(parama.Kkd.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
      }
    }
  }
  
  public final boolean br(int paramInt, boolean paramBoolean)
  {
    return paramInt == 35;
  }
  
  protected final boolean fLy()
  {
    return false;
  }
  
  public final boolean fLz()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ar.a
 * JD-Core Version:    0.7.0.1
 */