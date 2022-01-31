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
import com.tencent.mm.bq.d;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.c;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.a;

public final class ag$a
  extends c
{
  private a zzP;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(33264);
    View localView;
    if (paramView != null)
    {
      localView = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localView = paramLayoutInflater.inflate(2130969083, null);
      paramLayoutInflater = new ag.b();
      paramLayoutInflater.ekh = ((TextView)localView.findViewById(2131820587));
      paramLayoutInflater.qFY = ((TextView)localView.findViewById(2131821122));
      paramLayoutInflater.zTT = ((ImageView)localView.findViewById(2131822680));
      paramLayoutInflater.zWr = ((TextView)localView.findViewById(2131822681));
      paramLayoutInflater.zVQ = ((TextView)localView.findViewById(2131821123));
      paramLayoutInflater.jYu = localView.findViewById(2131822580);
      localView.setTag(paramLayoutInflater);
    }
    AppMethodBeat.o(33264);
    return localView;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bi parambi, String paramString)
  {
    AppMethodBeat.i(33265);
    this.zzP = parama1;
    parama = (ag.b)parama;
    aw.aaz();
    paramString = com.tencent.mm.model.c.YC().Tw(parambi.field_content);
    parama.zWr.setText(paramString.title);
    parama.zVQ.setText(paramString.content);
    a(parama, paramString.fOJ);
    ImageView localImageView = parama.zTT;
    if (paramString.mDP) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      parama.jYu.setTag(new az(parambi, parama1.dJG(), paramInt, null, '\000'));
      parama.jYu.setOnClickListener(d(parama1));
      parama.jYu.setOnLongClickListener(c(parama1));
      parama.jYu.setOnTouchListener(((com.tencent.mm.ui.chatting.c.b.h)parama1.ay(com.tencent.mm.ui.chatting.c.b.h.class)).dHi());
      AppMethodBeat.o(33265);
      return;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    AppMethodBeat.i(33266);
    int i = ((az)paramView.getTag()).position;
    if (!this.zzP.dJH()) {
      paramContextMenu.add(i, 100, 0, paramView.getContext().getString(2131298232));
    }
    AppMethodBeat.o(33266);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bi parambi)
  {
    return false;
  }
  
  public final boolean aK(int paramInt, boolean paramBoolean)
  {
    return paramInt == 35;
  }
  
  public final boolean b(View paramView, a parama, bi parambi)
  {
    AppMethodBeat.i(33267);
    paramView = (az)paramView.getTag();
    aw.aaz();
    parambi = com.tencent.mm.model.c.YC().Tw(paramView.cEE.field_content);
    if (ah.nullAsNil(parambi.pIJ).length() > 0) {
      d.b(parama.zJz.getContext(), "qqmail", ".ui.ReadMailUI", new Intent().putExtra("msgid", paramView.cEE.field_msgId));
    }
    for (;;)
    {
      AppMethodBeat.o(33267);
      return true;
      if (ah.nullAsNil(parambi.yOu).length() > 0)
      {
        paramView = new Intent("android.intent.action.VIEW", Uri.parse(parambi.yOu));
        d.b(parama.zJz.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
      }
    }
  }
  
  protected final boolean dLo()
  {
    return false;
  }
  
  public final boolean dLp()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ag.a
 * JD-Core Version:    0.7.0.1
 */