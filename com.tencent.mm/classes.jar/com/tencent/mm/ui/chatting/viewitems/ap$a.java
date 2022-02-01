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
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bl.c;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.d.a;

public final class ap$a
  extends c
{
  private a Gob;
  
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
      paramLayoutInflater = new ap.b();
      paramLayoutInflater.fwS = ((TextView)localView.findViewById(2131298178));
      paramLayoutInflater.wet = ((TextView)localView.findViewById(2131298185));
      paramLayoutInflater.GLf = ((ImageView)localView.findViewById(2131298146));
      paramLayoutInflater.GOI = ((TextView)localView.findViewById(2131298180));
      paramLayoutInflater.GOh = ((TextView)localView.findViewById(2131298073));
      paramLayoutInflater.naN = localView.findViewById(2131298069);
      localView.setTag(paramLayoutInflater);
    }
    AppMethodBeat.o(37360);
    return localView;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bl parambl, String paramString)
  {
    AppMethodBeat.i(37361);
    this.Gob = parama1;
    parama = (ap.b)parama;
    az.arV();
    paramString = com.tencent.mm.model.c.apO().agA(parambl.field_content);
    parama.GOI.setText(paramString.title);
    parama.GOh.setText(paramString.content);
    a(parama, paramString.hrn);
    ImageView localImageView = parama.GLf;
    if (paramString.qlA) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      parama.naN.setTag(new bi(parambl, parama1.eZb(), paramInt, null, '\000'));
      parama.naN.setOnClickListener(d(parama1));
      parama.naN.setOnLongClickListener(c(parama1));
      parama.naN.setOnTouchListener(((i)parama1.be(i.class)).eWp());
      AppMethodBeat.o(37361);
      return;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
  {
    AppMethodBeat.i(37362);
    int i = ((bi)paramView.getTag()).position;
    if (!this.Gob.eZc()) {
      paramContextMenu.add(i, 100, 0, paramView.getContext().getString(2131757221));
    }
    AppMethodBeat.o(37362);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bl parambl)
  {
    return false;
  }
  
  public final boolean aX(int paramInt, boolean paramBoolean)
  {
    return paramInt == 35;
  }
  
  public final boolean b(View paramView, a parama, bl parambl)
  {
    AppMethodBeat.i(37363);
    paramView = (bi)paramView.getTag();
    az.arV();
    parambl = com.tencent.mm.model.c.apO().agA(paramView.drF.field_content);
    if (bt.nullAsNil(parambl.uLc).length() > 0) {
      d.b(parama.GzJ.getContext(), "qqmail", ".ui.ReadMailUI", new Intent().putExtra("msgid", paramView.drF.field_msgId));
    }
    for (;;)
    {
      AppMethodBeat.o(37363);
      return true;
      if (bt.nullAsNil(parambl.FAh).length() > 0)
      {
        paramView = new Intent("android.intent.action.VIEW", Uri.parse(parambl.FAh));
        d.b(parama.GzJ.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
      }
    }
  }
  
  protected final boolean faD()
  {
    return false;
  }
  
  public final boolean faE()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ap.a
 * JD-Core Version:    0.7.0.1
 */