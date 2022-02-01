package com.tencent.mm.ui.chatting.viewitems;

import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.neattextview.textview.view.NeatTextView;

public final class bg
  extends c
{
  private bh aeVw;
  private bc aeVx;
  private bi aeVy;
  private br aeVz;
  
  public bg()
  {
    AppMethodBeat.i(37376);
    this.aeVw = new bh();
    this.aeVx = new bc();
    this.aeVy = new bi();
    this.aeVz = new br();
    AppMethodBeat.o(37376);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37377);
    View localView;
    if (paramView != null)
    {
      localView = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localView = paramLayoutInflater.inflate(R.i.ggv, null);
      paramLayoutInflater = new b();
      paramLayoutInflater.convertView = localView;
      paramLayoutInflater.timeTV = ((TextView)localView.findViewById(R.h.fAm));
      paramLayoutInflater.noMoreMsgTip = localView.findViewById(R.h.fzC);
      paramLayoutInflater.aeVB = localView.findViewById(R.h.fAc);
      paramLayoutInflater.aeVC = ((TextView)localView.findViewById(R.h.fAb));
      paramLayoutInflater.aeVA = ((MMNeat7extView)localView.findViewById(R.h.fxy));
      paramLayoutInflater.aeVA.setOnTouchListener(new l(paramLayoutInflater.aeVA, new com.tencent.mm.pluginsdk.ui.span.s(paramLayoutInflater.aeVA.getContext())));
      paramLayoutInflater.uploadingPB = ((ProgressBar)localView.findViewById(R.h.gbm));
      localView.setTag(paramLayoutInflater);
    }
    AppMethodBeat.o(37377);
    return localView;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, cc paramcc, String paramString)
  {
    AppMethodBeat.i(37378);
    if ((paramcc.getType() == 10002) || (paramcc.getType() == 268445458)) {
      paramString = this.aeVx;
    }
    for (;;)
    {
      paramString.b(parama, paramInt, parama1, paramcc);
      paramString.b(parama, parama1, paramcc);
      AppMethodBeat.o(37378);
      return;
      if (paramcc.getType() == 570425393) {
        paramString = this.aeVy;
      } else if (paramcc.getType() == 603979825) {
        paramString = this.aeVz;
      } else {
        paramString = this.aeVw;
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, cc paramcc)
  {
    return false;
  }
  
  public final boolean a(com.tencent.mm.ui.base.s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
  {
    return false;
  }
  
  public final boolean c(View paramView, a parama, cc paramcc)
  {
    return false;
  }
  
  public final boolean cM(int paramInt, boolean paramBoolean)
  {
    return (paramInt == 10000) || (paramInt == 10002) || (paramInt == 570425393) || (paramInt == 64) || (paramInt == 603979825) || (paramInt == 268445456) || (paramInt == 268445458);
  }
  
  public final boolean fXn()
  {
    return false;
  }
  
  protected final boolean jxh()
  {
    return false;
  }
  
  public static abstract class a
  {
    public abstract void b(c.a parama, int paramInt, a parama1, cc paramcc);
    
    public void b(c.a parama, a parama1, cc paramcc)
    {
      parama = (bg.b)parama;
      if (parama.aeVB != null) {
        parama.aeVB.setVisibility(8);
      }
      if (parama.uploadingPB != null) {
        parama.uploadingPB.setVisibility(8);
      }
    }
  }
  
  final class b
    extends c.a
  {
    NeatTextView aeVA;
    public View aeVB;
    public TextView aeVC;
    View convertView;
    
    b() {}
    
    public final View getMainContainerView()
    {
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bg
 * JD-Core Version:    0.7.0.1
 */