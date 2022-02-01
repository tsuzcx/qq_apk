package com.tencent.mm.ui.chatting.viewitems;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.e.a;

public final class bj$f
  extends c
{
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37528);
    View localView;
    if (paramView != null)
    {
      localView = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localView = paramLayoutInflater.inflate(2131493622, null);
      localView.setTag(new bj.i().hd(localView));
    }
    AppMethodBeat.o(37528);
    return localView;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(37529);
    parama.timeTV.setVisibility(0);
    parama.timeTV.setText(f.t(parama1.Pwc.getContext(), paramca.field_createTime));
    AppMethodBeat.o(37529);
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean a(m paramm, View paramView, ca paramca)
  {
    return false;
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return paramInt == 52;
  }
  
  public final boolean c(View paramView, a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean gTT()
  {
    return false;
  }
  
  protected final boolean gTU()
  {
    return false;
  }
  
  final boolean gTV()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bj.f
 * JD-Core Version:    0.7.0.1
 */