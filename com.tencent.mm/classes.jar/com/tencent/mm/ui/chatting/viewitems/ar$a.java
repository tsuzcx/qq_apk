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
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.bu.c;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.e.a;

public final class ar$a
  extends c
{
  private a JBI;
  
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
      paramLayoutInflater.fTP = ((TextView)localView.findViewById(2131298178));
      paramLayoutInflater.yEk = ((TextView)localView.findViewById(2131298185));
      paramLayoutInflater.KbA = ((ImageView)localView.findViewById(2131298146));
      paramLayoutInflater.Kfk = ((TextView)localView.findViewById(2131298180));
      paramLayoutInflater.KeJ = ((TextView)localView.findViewById(2131298073));
      paramLayoutInflater.ofK = localView.findViewById(2131298069);
      localView.setTag(paramLayoutInflater);
    }
    AppMethodBeat.o(37360);
    return localView;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bu parambu, String paramString)
  {
    AppMethodBeat.i(37361);
    this.JBI = parama1;
    parama = (ar.b)parama;
    ba.aBQ();
    paramString = com.tencent.mm.model.c.azs().aqi(parambu.field_content);
    parama.Kfk.setText(paramString.title);
    parama.KeJ.setText(paramString.content);
    a(parama, paramString.ild);
    ImageView localImageView = parama.KbA;
    if (paramString.rEq) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      parama.ofK.setTag(new bk(parambu, parama1.fFv(), paramInt, null, '\000'));
      parama.ofK.setOnClickListener(d(parama1));
      parama.ofK.setOnLongClickListener(c(parama1));
      parama.ofK.setOnTouchListener(((k)parama1.bh(k.class)).fCu());
      AppMethodBeat.o(37361);
      return;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bu parambu)
  {
    return false;
  }
  
  public final boolean a(l paraml, View paramView, bu parambu)
  {
    AppMethodBeat.i(194489);
    int i = ((bk)paramView.getTag()).position;
    if (!this.JBI.fFw()) {
      paraml.a(i, 100, paramView.getContext().getString(2131757221), 2131690384);
    }
    AppMethodBeat.o(194489);
    return true;
  }
  
  public final boolean b(View paramView, a parama, bu parambu)
  {
    AppMethodBeat.i(37363);
    paramView = (bk)paramView.getTag();
    ba.aBQ();
    parambu = com.tencent.mm.model.c.azs().aqi(paramView.dBd.field_content);
    if (bt.nullAsNil(parambu.xbf).length() > 0) {
      d.b(parama.JOR.getContext(), "qqmail", ".ui.ReadMailUI", new Intent().putExtra("msgid", paramView.dBd.field_msgId));
    }
    for (;;)
    {
      AppMethodBeat.o(37363);
      return true;
      if (bt.nullAsNil(parambu.IMy).length() > 0)
      {
        paramView = new Intent("android.intent.action.VIEW", Uri.parse(parambu.IMy));
        d.b(parama.JOR.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
      }
    }
  }
  
  public final boolean bi(int paramInt, boolean paramBoolean)
  {
    return paramInt == 35;
  }
  
  protected final boolean fHg()
  {
    return false;
  }
  
  public final boolean fHh()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ar.a
 * JD-Core Version:    0.7.0.1
 */